package com.palmtree.content.analysis.video;

import com.google.api.gax.rpc.OperationFuture;
import com.google.cloud.videointelligence.v1beta1.*;
import com.google.longrunning.Operation;
/*import org.apache.commons.code.binary.Base64; */
import org.apache.log4j.Logger;

/*import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;  */

/**
 * Created by kaarthikraaj on 10/8/17.
 */
public class VideoContentAnalyser {
    private static Logger logger = Logger.getLogger(VideoContentAnalyser.class.getName());

    public static void main(String args[]) {
        String gcsUri = "gs://staging.palmtree-videocontentanalysis.appspot.com/video/bike.mp4";

        VideoContentAnalyser analyser = new VideoContentAnalyser();
        System.out.println(System.getenv("GOOGLE_APPLICATION_CREDENTIALS"));
        System.out.println(analyser.isVideoSafe(gcsUri));
    }

    public boolean isVideoSafe(String videoCloudStorageURI) {
        boolean isSafe = true;

        try {
            VideoIntelligenceServiceSettings settings =
                    VideoIntelligenceServiceSettings.defaultBuilder().build();
            VideoIntelligenceServiceClient client = VideoIntelligenceServiceClient.create(settings);
        /*    Path path = Paths.get(filePath);
            byte[] data = Files.readAllBytes(path);
            byte[] encodedBytes = Base64.encodeBase64(data); */


            // Create an operation that will contain the response when the operation completes.
            AnnotateVideoRequest request = AnnotateVideoRequest.newBuilder()
                    .setInputUri(videoCloudStorageURI)
                    .addFeatures(Feature.LABEL_DETECTION)
                    .addFeatures(Feature.SAFE_SEARCH_DETECTION)
                    .addFeatures(Feature.SHOT_CHANGE_DETECTION)
                    .build();

            OperationFuture<AnnotateVideoResponse, AnnotateVideoProgress, Operation> operation =
                    client.annotateVideoAsync(request);
            System.out.println("Waiting for operation to complete...");
           // boolean foundLabel = true;
            boolean foundUnsafe = true;

           for (VideoAnnotationResults result : operation.get().getAnnotationResultsList()) {
               if (result.getLabelAnnotationsCount() > 0)
                if (result.getSafeSearchAnnotationsCount() > 0) {
                    System.out.println("Labels:");
                    System.out.println("Safe search annotations:");
                    for (LabelAnnotation annotation : result.getLabelAnnotationsList())
                    for (SafeSearchAnnotation note : result.getSafeSearchAnnotationsList()) {
                        System.out.println("\tDescription: " + annotation.getDescription());

                        System.out.printf("Location: %fs\n", note.getTimeOffset() / 1000000.0);
                        System.out.println("\tAdult: " + note.getAdult().name());
                        System.out.println("\tMedical: " + note.getMedical().name());
                        System.out.println("\tRacy: " + note.getRacy().name());
                        System.out.println("\tSpoof: " + note.getSpoof().name());
                        System.out.println("\tViolent: " + note.getViolent().name());
                        System.out.println();


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
                    }
                    for (SafeSearchAnnotation safeSearchResponse : result.getSafeSearchAnnotationsList())
                        if (safeSearchResponse.getAdult().compareTo(Likelihood.LIKELY) > 1
                                || safeSearchResponse.getViolent().compareTo(Likelihood.LIKELY) > 1
                                || safeSearchResponse.getRacy().compareTo(Likelihood.LIKELY) > 1) {
                            return false;
                        }

                }


                else {
                    logger.info("No labels detected in " + videoCloudStorageURI);
                    logger.info("No safe search annotations detected in " + videoCloudStorageURI);

                }
            }

            if (foundUnsafe) {
                logger.info("Found potentially unsafe content.");
            } else {
                logger.info("Did not detect unsafe content.");
            }
        }
        catch (Exception exc) {
            logger.error("Exception while processing video " + videoCloudStorageURI + ":" + exc.getMessage());
        }

        return isSafe;
    }
}



/*
hai */