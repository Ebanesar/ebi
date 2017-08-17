package com.palmtree.content.analysis.image;
import com.google.cloud.vision.v1.*;
import com.google.cloud.vision.v1.Feature.Type;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaarthikraaj on 10/8/17.
 */
public class ImageContentAnalyser {
    public boolean isImageSafe(String imageURI){
        boolean isSafe = true;
        try {
            ImageAnnotatorClient visionClient =  ImageAnnotatorClient.create();
            ArrayList<AnnotateImageRequest> imageReqsList = new ArrayList<AnnotateImageRequest>();
            Image image = Image.newBuilder().setSource(ImageSource.newBuilder().setImageUri(imageURI)).build();
            AnnotateImageRequest imageReq = AnnotateImageRequest.newBuilder().setImage(image)
                    .addFeatures(Feature.newBuilder().setType(Type.LABEL_DETECTION).build())
                    .addFeatures(Feature.newBuilder().setType(Type.SAFE_SEARCH_DETECTION).build()).build();
            imageReqsList.add(imageReq);

            BatchAnnotateImagesResponse response = visionClient.batchAnnotateImages(imageReqsList);
            System.out.println(response.getResponsesCount());
            List<AnnotateImageResponse> annotateImageResponses = response.getResponsesList();

            for(AnnotateImageResponse annotateImageResponse : annotateImageResponses){
               // System.out.println(annotateImageResponse.getLogoAnnotationsCount());
                System.out.println(annotateImageResponse.getTextAnnotationsCount());
               // System.out.println(annotateImageResponse.());
               // System.out.println(annotateImageResponse.getLogoAnnotationsCount());

                boolean hasError = annotateImageResponse.hasError();
                int labelAnnCount = annotateImageResponse.getLabelAnnotationsCount();
                System.out.println(annotateImageResponse.getError().getMessage());
            boolean hasWebDetection = annotateImageResponse.hasWebDetection();
            boolean hasSafeSearchAnnotation = annotateImageResponse.hasSafeSearchAnnotation();
System.out.println(hasWebDetection+""+hasSafeSearchAnnotation+""+hasError+"label Annotation count"+labelAnnCount);



                List<EntityAnnotation> labelAnnotations =  annotateImageResponse.getLabelAnnotationsList();
                for (EntityAnnotation entityAnnotation:labelAnnotations){

System.out.println(entityAnnotation.getDescription());
                }

               SafeSearchAnnotation safeAnnotation =  annotateImageResponse.getSafeSearchAnnotation();
                System.out.println("Violence value is "+safeAnnotation.getViolence().getNumber());
                if(safeAnnotation.getViolence().getNumber()>1)
                    isSafe = false;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Invoke Cloud Vision API and based on the response return if its valid or not.
        return isSafe;
    }

    public boolean isValidImage(String imageURI){
        boolean isValid = true;
        try {
            ImageAnnotatorClient visionClient =  ImageAnnotatorClient.create();
            ArrayList<AnnotateImageRequest> imageReqsList = new ArrayList<AnnotateImageRequest>();
            Image image = Image.newBuilder().setSource(ImageSource.newBuilder().setImageUri(imageURI)).build();
            AnnotateImageRequest imageReq = AnnotateImageRequest.newBuilder().setImage(image).addFeatures(Feature.newBuilder().setType(Type.LABEL_DETECTION).build()).build();
            imageReqsList.add(imageReq);

            BatchAnnotateImagesResponse response = visionClient.batchAnnotateImages(imageReqsList);
            System.out.println(response.getResponsesCount());
            List<AnnotateImageResponse> annotateImageResponses = response.getResponsesList();

            for(AnnotateImageResponse annotateImageResponse : annotateImageResponses){
                // System.out.println(annotateImageResponse.getLogoAnnotationsCount());
                System.out.println(annotateImageResponse.getTextAnnotationsCount());
                // System.out.println(annotateImageResponse.());
                // System.out.println(annotateImageResponse.getLogoAnnotationsCount());

                boolean hasError = annotateImageResponse.hasError();
                System.out.println(annotateImageResponse.getError().getMessage());




                List<EntityAnnotation> labelAnnotations =  annotateImageResponse.getLabelAnnotationsList();
                System.out.println(labelAnnotations.size());
                for (EntityAnnotation entityAnnotation:labelAnnotations){
                    //System.out.println( faceAnnotation.getHeadwearLikelihoodValue());
                     if(entityAnnotation.getDescription().equalsIgnoreCase("sunglasses"))
                         return false;
                    // p.getName()

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Invoke Cloud Vision API and based on the response return if its valid or not.
        return isValid;
    }

    public static  void main(String args[]){
        ImageContentAnalyser analyser = new ImageContentAnalyser();
        System.out.println(System.getenv("GOOGLE_APPLICATION_CREDENTIALS"));
      //  System.out.println(analyser.isImageSafe("https://previews.123rf.com/images/ximagination/ximagination1511/ximagination151100842/48741803-Scary-terrorist-with-cold-gaze-wearing-mask-and-holding-machine-gun-shot-outdoors-Stock-Photo.jpg"));
        System.out.println(analyser.isValidImage("https://thumb1.shutterstock.com/display_pic_with_logo/948721/288704459/stock-photo-stylish-teenage-boy-wearing-sun-glasses-cap-and-trendy-shirt-outdoors-looking-at-camera-posing-288704459.jpg"));

    }
}
