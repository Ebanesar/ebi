package com.palmtree.content.analysis.image;
import com.google.cloud.vision.v1.*;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.common.collect.Iterators;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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
            WebDetection wb3 = annotateImageResponse.getWebDetection();
            List<WebDetection.WebEntity> wb4 = wb3.getWebEntitiesList();
            List<EntityAnnotation> labelAnnotations =  annotateImageResponse.getLabelAnnotationsList();
            for (EntityAnnotation entityAnnotation:labelAnnotations)
            {
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
        int a=0;
        ArrayList<String> list = new ArrayList<String>(); // Creating the array list
        list.add("head");
        list.add("Man");
        Iterator<String> iterators = list.iterator();

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
                List<EntityAnnotation> labelAnnotations =  annotateImageResponse.getLabelAnnotationsList();
                WebDetection wb = annotateImageResponse.getWebDetection();
                List<WebDetection.WebEntity> wb1 = wb.getWebEntitiesList();
               // List<FaceAnnotation> fa = annotateImageResponse.getFaceAnnotationsList();
               //System.out.println(annotateImageResponse.getLogoAnnotationsCount());
               //System.out.println(annotateImageResponse.getTextAnnotationsCount());
               //System.out.println(annotateImageResponse.());
               //System.out.println(annotateImageResponse.getLogoAnnotationsCount());
                boolean hasError = annotateImageResponse.hasError();
                System.out.println(annotateImageResponse.getError().getMessage());


            for(EntityAnnotation entityAnnotation:labelAnnotations)   //Face Focus
            {
                if (entityAnnotation.getDescription().contains("chin")
                        || entityAnnotation.getDescription().contains("Nose")
                        || entityAnnotation.getDescription().contains("Forehead")
                        || entityAnnotation.getDescription().contains("Mouth")
                        || entityAnnotation.getDescription().contains("Neck")
                        || entityAnnotation.getDescription().contains("cheek")
                        || entityAnnotation.getDescription().contains("jaw")
                        || entityAnnotation.getDescription().contains("ear")
                        || entityAnnotation.getDescription().contains("smile")
                        || entityAnnotation.getDescription().contains("Eyebrow")
                        || entityAnnotation.getDescription().contains("head"))
                {
                    a=1;
                }

                else if (entityAnnotation.getDescription().contains("jeans")
                        || entityAnnotation.getDescription().contains("Standing")
                        || entityAnnotation.getDescription().contains("Trouser")
                        || entityAnnotation.getDescription().contains("Shoe")
                        || entityAnnotation.getDescription().contains("Gentleman")
                        || entityAnnotation.getDescription().contains("Suit")
                        || entityAnnotation.getDescription().contains("Formal Wear")
                        || entityAnnotation.getDescription().contains("T Shirt"))   //Full image
                {
                     a=2;
                }



         switch (a)
         {
             case 1:
             {
                 for (WebDetection.WebEntity wb2 : wb.getWebEntitiesList())
                 {
              if (entityAnnotation.getDescription().equalsIgnoreCase("sunglasses")
                        || entityAnnotation.getDescription().equalsIgnoreCase("Headgear")
                        || entityAnnotation.getDescription().equalsIgnoreCase("Mask")
                        || entityAnnotation.getDescription().equalsIgnoreCase("Helmet")
                        || entityAnnotation.getDescription().equalsIgnoreCase("Turban")
                        || entityAnnotation.getDescription().equalsIgnoreCase("Fedora")
                        || entityAnnotation.getDescription().equalsIgnoreCase("Mammal")
                        || entityAnnotation.getDescription().equalsIgnoreCase("Animal")
                        || entityAnnotation.getDescription().equalsIgnoreCase("Hand")
                        || entityAnnotation.getDescription().equalsIgnoreCase("Tattoo")
                        || wb2.getDescription().equalsIgnoreCase("Silhouette")
                        || wb2.getDescription().equalsIgnoreCase("Tattoo")
                        || wb2.getDescription().equalsIgnoreCase("Mask")
                        || wb2.getDescription().equalsIgnoreCase("Headwear")
                        || wb2.getDescription().equalsIgnoreCase("Headscarf")
                        || wb2.getDescription().equalsIgnoreCase("sunglasses")
                        || wb2.getDescription().equalsIgnoreCase("Animal")
                        || wb2.getDescription().equalsIgnoreCase("Mammal"))
                           {
                                isValid = false;
                           }
                                    break;

                 }
             }
             case 2:
             {
                 for (WebDetection.WebEntity wb2 : wb.getWebEntitiesList())
                 {
                if (entityAnnotation.getDescription().equalsIgnoreCase("sunglasses")
                             || entityAnnotation.getDescription().equalsIgnoreCase("Headgear")
                             || entityAnnotation.getDescription().equalsIgnoreCase("Mask")
                             || entityAnnotation.getDescription().equalsIgnoreCase("Helmet")
                             || entityAnnotation.getDescription().equalsIgnoreCase("Turban")
                             || entityAnnotation.getDescription().equalsIgnoreCase("Fedora")
                             || entityAnnotation.getDescription().equalsIgnoreCase("Mammal")
                             || entityAnnotation.getDescription().equalsIgnoreCase("Animal")
                             || entityAnnotation.getDescription().equalsIgnoreCase("Tattoo")
                             || wb2.getDescription().equalsIgnoreCase("Silhouette")
                             || wb2.getDescription().equalsIgnoreCase("Tattoo")
                             || wb2.getDescription().equalsIgnoreCase("Mask")
                             || wb2.getDescription().equalsIgnoreCase("Headwear")
                             || wb2.getDescription().equalsIgnoreCase("Headscarf")
                             || wb2.getDescription().equalsIgnoreCase("sunglasses")
                             || wb2.getDescription().equalsIgnoreCase("Animal")
                             || wb2.getDescription().equalsIgnoreCase("Mammal"))
                     {
                         isValid = false;
                     }
                     break;

             }

         }

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
       if (analyser.isValidImage("http://st3.cricketcountry.com/wp-content/uploads/cricket/20160617015246.jpeg")==false)
        {
            System.out.println("Invalid Image");
        }
      else
        {
           System.out.println("Valid Image");
        }

   /*    if (analyser.isImageSafe("https://image.shutterstock.com/z/stock-photo-bald-man-face-closed-hands-279396935.jpg")==false)
        {
            System.out.println("Unsafe Image");
        }
        else
        {
            System.out.println("Safe Image");
        }       */

    }
}