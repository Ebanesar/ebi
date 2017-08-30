package com.palmtree.content.analysis.video;

import com.google.api.gax.rpc.OperationFuture;
import com.google.cloud.videointelligence.v1beta1.*;
import com.google.longrunning.Operation;
import com.sun.xml.internal.ws.binding.FeatureListUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaarthikraaj on 10/8/17.
 */
public class VideoContentAnalyser {
    public boolean isVideoSafe(){
        boolean isSafe = true;

            try {
                VideoIntelligenceServiceSettings settings =
                        VideoIntelligenceServiceSettings.defaultBuilder().build();
                VideoIntelligenceServiceClient client = VideoIntelligenceServiceClient.create(settings);

                // The Google Cloud Storage path to the video to annotate.
                String gcsUri = "gs://staging.palmtree-videocontentanalysis.appspot.com/video/swm.mp4";

                // Create an operation that will contain the response when the operation completes.
                AnnotateVideoRequest request = AnnotateVideoRequest.newBuilder()
                        .setInputUri(gcsUri)
                        .addFeatures(Feature.LABEL_DETECTION)
                        .build();

                OperationFuture<AnnotateVideoResponse, AnnotateVideoProgress, Operation> operation =
                        client.annotateVideoAsync(request);

                System.out.println("Waiting for operation to complete...");
                for (VideoAnnotationResults result : operation.get().getAnnotationResultsList()) {
                    if (result.getLabelAnnotationsCount() > 0) {
                        System.out.println("Labels:");
                        for (LabelAnnotation annotation : result.getLabelAnnotationsList()) {
                            System.out.println("\tDescription: " + annotation.getDescription());
                            for (LabelLocation loc : annotation.getLocationsList()) {
                                if (loc.getSegment().getStartTimeOffset() == -1
                                        && loc.getSegment().getEndTimeOffset() == -1) {
                                    System.out.println("\tLocation: Entire video");
                                } else {
                                    System.out.printf(
                                            "\tLocation: %fs - %fs\n",
                                            loc.getSegment().getStartTimeOffset() / 1000000.0,
                                            loc.getSegment().getEndTimeOffset() / 1000000.0);
                                }
                            }
                            System.out.println();
                        }
                    } else {
                        System.out.println("No labels detected in " + gcsUri);
                    }
                }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        //Invoke Cloud Vision API and based on the response return if its valid or not.
        return isSafe;
    }





    public static  void main(String args[])
    {
        VideoContentAnalyser analyser = new VideoContentAnalyser();
        System.out.println(System.getenv("GOOGLE_APPLICATION_CREDENTIALS"));
        analyser.isVideoSafe();


    }
}
