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
    public boolean isValidImage(String imageURI){
        boolean isValid = false;
        try {
            ImageAnnotatorClient visionClient =  ImageAnnotatorClient.create();
            ArrayList<AnnotateImageRequest> imageReqsList = new ArrayList<AnnotateImageRequest>();
            Image image = Image.newBuilder().setSource(ImageSource.newBuilder().setImageUri(imageURI)).build();
            AnnotateImageRequest imageReq = AnnotateImageRequest.newBuilder().setImage(image).addFeatures(Feature.newBuilder().setType(Type.DOCUMENT_TEXT_DETECTION).build()).addFeatures(Feature.newBuilder().setType(Type.FACE_DETECTION).build()).build();
            imageReqsList.add(imageReq);

            BatchAnnotateImagesResponse response = visionClient.batchAnnotateImages(imageReqsList);
            System.out.println(response.getResponsesCount());
            List<AnnotateImageResponse> annotateImageResponses = response.getResponsesList();

            for(AnnotateImageResponse annotateImageResponse : annotateImageResponses){
               // System.out.println(annotateImageResponse.getLogoAnnotationsCount());
                System.out.println(annotateImageResponse.getTextAnnotationsCount());
               // System.out.println(annotateImageResponse.());
               // System.out.println(annotateImageResponse.getLogoAnnotationsCount());

                boolean hasFullTextAnnotation = annotateImageResponse.hasFullTextAnnotation();
                boolean hasError = annotateImageResponse.hasError();
                System.out.println(annotateImageResponse.getError().getMessage());
            boolean hasWebDetection = annotateImageResponse.hasWebDetection();
            boolean hasCropHintsAnnotation = annotateImageResponse.hasCropHintsAnnotation();
            boolean hasImagePropertiesAnnotation = annotateImageResponse.hasImagePropertiesAnnotation();
            boolean hasSafeSearchAnnotation = annotateImageResponse.hasSafeSearchAnnotation();
System.out.println(hasWebDetection+""+hasCropHintsAnnotation+""+ hasImagePropertiesAnnotation+""+hasSafeSearchAnnotation+""+hasFullTextAnnotation+""+hasError);
                List<FaceAnnotation> faceAnnotations =  annotateImageResponse.getFaceAnnotationsList();
                for (FaceAnnotation faceAnnotation:faceAnnotations){
                    //System.out.println( faceAnnotation.getHeadwearLikelihoodValue());
                    //faceAnnotation.getBlurredLikelihood().
                    int angerlikelihod = faceAnnotation.getAngerLikelihood().getNumber();
                    float likelihoodValue = faceAnnotation.getHeadwearLikelihoodValue();
                    float joyLikelihood=faceAnnotation.getJoyLikelihoodValue();
                    System.out.println(likelihoodValue+" joy"+joyLikelihood+"underExposed"+ faceAnnotation.getUnderExposedLikelihoodValue()+"AngerLikelihood"+angerlikelihod
                    );
                    if(likelihoodValue>50) return false;

                }


                List<EntityAnnotation> labelAnnotations =  annotateImageResponse.getLabelAnnotationsList();
                for (EntityAnnotation entityAnnotation:labelAnnotations){
                    //System.out.println( faceAnnotation.getHeadwearLikelihoodValue());
                    Property p   = entityAnnotation.getProperties(0);
                   // p.getName()
                    System.out.println( p.getName());
                    System.out.println( p.getValue());
                     return false;

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
        //System.out.println(System.getenv("GOOGLE_APPLICATION_CREDENTIALS"));
        System.out.println(analyser.isValidImage("http://media.gettyimages.com/photos/germany-bavaria-munich-senior-flight-captain-wearing-aviation-glasses-picture-id138311449"));
    }
}
