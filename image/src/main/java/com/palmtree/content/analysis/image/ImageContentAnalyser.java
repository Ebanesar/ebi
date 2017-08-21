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
                    .addFeatures(Feature.newBuilder().setType(Type.SAFE_SEARCH_DETECTION).build())
                    .addFeatures(Feature.newBuilder().setType(Type.WEB_DETECTION).build()).build();
            imageReqsList.add(imageReq);

            BatchAnnotateImagesResponse response = visionClient.batchAnnotateImages(imageReqsList);
           // System.out.println(response.getResponsesCount());
            List<AnnotateImageResponse> annotateImageResponses = response.getResponsesList();
            for(AnnotateImageResponse annotateImageResponse : annotateImageResponses)
            {
           /*     System.out.println(annotateImageResponse.getLogoAnnotationsCount());
                System.out.println(annotateImageResponse.getTextAnnotationsCount());
             //   System.out.println(annotateImageResponse.());
                System.out.println(annotateImageResponse.getLogoAnnotationsCount());

                boolean hasError = annotateImageResponse.hasError();
                int labelAnnCount = annotateImageResponse.getLabelAnnotationsCount();
              System.out.println(annotateImageResponse.getError().getMessage());
           boolean hasWebDetection = annotateImageResponse.hasWebDetection();
           boolean hasSafeSearchAnnotation = annotateImageResponse.hasSafeSearchAnnotation();
          System.out.println(hasWebDetection+""+hasSafeSearchAnnotation+""+hasError+"label Annotation count"+labelAnnCount);
         */

            SafeSearchAnnotation safeAnnotation =  annotateImageResponse.getSafeSearchAnnotation();
            System.out.println("Violence value is "+safeAnnotation.getViolence().getNumber());
            System.out.println("Adult Content value is "+safeAnnotation.getAdultValue());

            List<EntityAnnotation> labelAnnotations =  annotateImageResponse.getLabelAnnotationsList();
            for (EntityAnnotation entityAnnotation:labelAnnotations)
            {
                  WebDetection wb3 = annotateImageResponse.getWebDetection();
                  List<WebDetection.WebEntity> wb4 = wb3.getWebEntitiesList();
                  for (WebDetection.WebEntity wb5 : wb3.getWebEntitiesList())
                  {
                     if (safeAnnotation.getViolence().getNumber()>1
                      || safeAnnotation.getAdult().getNumber()>3
                      || wb5.getDescription().equalsIgnoreCase("Weapon")
                      || wb5.getDescription().equalsIgnoreCase("cigarette")
                      || wb5.getDescription().equalsIgnoreCase("Alcohol")
                      || wb5.getDescription().equalsIgnoreCase("Alcoholic drink")
                      || wb5.getDescription().equalsIgnoreCase("Tobacco")
                      || wb5.getDescription().equalsIgnoreCase("Knife")
                      || wb5.getDescription().equalsIgnoreCase("Ground fighting")
                      || wb5.getDescription().equalsIgnoreCase("Shooting")
                      || wb5.getDescription().equalsIgnoreCase("Blood")
                      || wb5.getDescription().equalsIgnoreCase("Daemon's Souls")
                      || wb5.getDescription().equalsIgnoreCase("Stabbing"))

                  isSafe = false;
                 //  System.out.println(entityAnnotation.getDescription());
                  }
            }
         }
        }
        catch (IOException e)
        {
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
            AnnotateImageRequest imageReq = AnnotateImageRequest.newBuilder().setImage(image)
                    .addFeatures(Feature.newBuilder().setType(Type.LABEL_DETECTION).build())
                    .addFeatures(Feature.newBuilder().setType(Type.SAFE_SEARCH_DETECTION).build())
                    .addFeatures(Feature.newBuilder().setType(Type.FACE_DETECTION).build())
                    .addFeatures(Feature.newBuilder().setType(Type.WEB_DETECTION).build())
                    .build();
            imageReqsList.add(imageReq);

            BatchAnnotateImagesResponse response = visionClient.batchAnnotateImages(imageReqsList);
               //System.out.println(response.getResponsesCount());
            List<AnnotateImageResponse> annotateImageResponses = response.getResponsesList();
            for(AnnotateImageResponse annotateImageResponse : annotateImageResponses)
            {
               //System.out.println(annotateImageResponse.getLogoAnnotationsCount());
               //System.out.println(annotateImageResponse.getTextAnnotationsCount());
               //System.out.println(annotateImageResponse.());
               //System.out.println(annotateImageResponse.getLogoAnnotationsCount());
                boolean hasError = annotateImageResponse.hasError();
                System.out.println(annotateImageResponse.getError().getMessage());

            List<EntityAnnotation> labelAnnotations =  annotateImageResponse.getLabelAnnotationsList();
            for (EntityAnnotation entityAnnotation:labelAnnotations)
            {
                 WebDetection wb = annotateImageResponse.getWebDetection();
                 List<WebDetection.WebEntity> wb1 = wb.getWebEntitiesList();
                 for (WebDetection.WebEntity wb2 : wb.getWebEntitiesList())
                 {    //if (wb2.getDescription().equalsIgnoreCase("Tattoo"))
                     //System.out.println( faceAnnotation.getHeadwearLikelihoodValue());
                     //EntityAnnotation entityAnnotation = annotateImageResponse.getLabelAnnotations(0);
                    if(entityAnnotation.getDescription().equalsIgnoreCase("sunglasses")
                      || entityAnnotation.getDescription().equalsIgnoreCase("Headgear")
                      || entityAnnotation.getDescription().equalsIgnoreCase("Mask")
                      || entityAnnotation.getDescription().equalsIgnoreCase("Helmet")
                      || entityAnnotation.getDescription().equalsIgnoreCase("Turban")
                      || entityAnnotation.getDescription().equalsIgnoreCase("Fedora")
                      || wb2.getDescription().equalsIgnoreCase("Tattoo")
                      || wb2.getDescription().equalsIgnoreCase("Mask")
                      || wb2.getDescription().equalsIgnoreCase("Headwear")
                      || wb2.getDescription().equalsIgnoreCase("Headscarf"))

                    return false;
                 }
            }
            }
                // p.getName()
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        //Invoke Cloud Vision API and based on the response return if its valid or not.
        return isValid;
    }

    public static  void main(String args[])
    {
        ImageContentAnalyser analyser = new ImageContentAnalyser();
        System.out.println(System.getenv("GOOGLE_APPLICATION_CREDENTIALS"));
        //System.out.println(analyser.isImageSafe("https://cdn.pornpics.com/pics1/2016-07-15/361749_12big.jpg"));
        if (analyser.isValidImage("https://ae01.alicdn.com/kf/HTB1zy1TLpXXXXb9XVXXq6xXFXXXp/Fashion-Bufanda-Tubular-Hijab-Camo-Bandana-font-b-Scarf-b-font-Seamless-Neck-Tube-Bandana-Standard.jpg")==false)
         {
            System.out.println("InValid Image");
         }
         else
         {
            System.out.println("Valid Image");
         }
      /* if (analyser.isImageSafe("https://cdn.munplanet.com/storage/uploads/52209627db7c13603b000001/topic/background_image/54302218db7c1366d600b544/o-TERRORISM-facebook.jpg")==false)
        {
            System.out.println("Unsafe Image");
        }
        else
        {
            System.out.println("Safe Image");
        } */
    }
 }
