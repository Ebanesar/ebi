package com.palmtree.content.analysis.image;

import com.google.cloud.vision.v1.*;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.protobuf.ByteString;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

/**
 * Created by kaarthikraaj on 10/8/17.
 */
public class ImageContentAnalyser {

    private static Logger logger = Logger.getLogger(ImageContentAnalyser.class.getName());

    public static void main(String args[]) {
        ImageContentAnalyser analyser = new ImageContentAnalyser();
        System.out.println(System.getenv("GOOGLE_APPLICATION_CREDENTIALS"));
       // System.out.println(analyser.isImageSafe("https://www.dailydot.com/wp-content/uploads/6c855233625ee8c7985a841c4bd068dd5e1.jpg/91/"));
       // System.out.println(analyser.isValidImage("https://i.pinimg.com/736x/a1/7c/69/a17c694d0f8f25774847f9224529cb8f.jpg"));
       // System.out.println(analyser.detectLogos("http://www.carlogos.org/logo/Audi-logo-1999-1920x1080.png"));
       // System.out.println(analyser.detectLandmarks("https://upload.wikimedia.org/wikipedia/commons/c/c8/Taj_Mahal_in_March_2004.jpg"));
       // System.out.println(analyser.detectTexts("http://www.gsproducts.co.uk/wordpress/wp-content/uploads/2015/04/Boat-name-Mariah.jpg"));
        System.out.println(analyser.DocumentExtractionTemplate("https://00e9e64bacb462cf36ffc2ddb79a1c88b387c029959caf4d1a-apidata.googleusercontent.com/download/storage/v1/b/palmtree-image-02.appspot.com/o/ProffesionalBlue.png?qk=AD5uMEt8yaYfBy4wGFw9da7XDiK2ScjSGVLx9491-TR3DW5ZPKCeh_6nptbPTDs4va1L8GRIhidOpGBZUJ_une6ONRMG4AMaXX5NCn3iJR_E_3fNVq8BZk3yn8tlgADlEScuwbwEDudKLZucY54gWsvitEra2u3hK_Ik0Q7GBykWbdC86T8NTlkEBrmQxvcyoByyo-y5DEBqwuM8r2TxdzyurDMPafewICb1MNkURQ676RlaiZfHf9wpTBerRQ1c37gLsX--2n0KRrMOWO5KXhYvFkPULRMh9ij8lLMlLyfqL1rNMQPISqHkZHcP_DylJNct_kUKB26dS7pLlsgntwEef7HOn9KBneb_L3469KZMS1qdMe6Mxbyk4Oi99ufkCUQikWFxYS9-W1_n1dh6hafZR7o2Gcle_YLyMhVsPAmh60GjZlPG7tdoum6J5fZ9X6fFNON3-cRnzUQWhaF2NTHMXzgMkyXoTTuFv3H2tpDVNI-VcoEwamjcDrUVo_wMpgQRapVfnc8kQ-VQTGg8YWbDkk1d0f3m5P6fIagdThdQvZyiITx7nw6xocM7ulJm1DueZ6FlwBj7zPliPLrRUOCryRSeAz8SWBhOrxkEC4_TyqwSQ9-heZy8MY3N8Ydie7vdS3UaxIzZEz0KGPAuH0lv1mtCfxmAm0K55ELtjirWg8EkFjNJ4BZFlwx5OsBTwqIXjYboUNf53BBO1PaXoKDr_CnwYlSljjldt-4eKniJ4BwLiirGHQ3XNZ09QFVw6b9dSA_vyic8F6vGa0fn54Gsqrczr-Cqew"));
        // analyser.extractTextValueForLabel()
    }


    public boolean isImageSafe(String imageURI) {
        boolean isSafe = true;

        try {
            ImageAnnotatorClient visionClient = ImageAnnotatorClient.create();
            ArrayList<AnnotateImageRequest> imageReqsList = new ArrayList<AnnotateImageRequest>();
            Image image = Image.newBuilder().setSource(ImageSource.newBuilder().setImageUri(imageURI)).build();
            AnnotateImageRequest imageReq = AnnotateImageRequest.newBuilder().setImage(image)
                    .addFeatures(Feature.newBuilder().setType(Type.SAFE_SEARCH_DETECTION).build())
                    .addFeatures(Feature.newBuilder().setType(Type.WEB_DETECTION).build()).build();
            imageReqsList.add(imageReq);

            BatchAnnotateImagesResponse response = visionClient.batchAnnotateImages(imageReqsList);
            List<AnnotateImageResponse> annotateImageResponses = response.getResponsesList();
            for (AnnotateImageResponse annotateImageResponse : annotateImageResponses) {


                SafeSearchAnnotation safeAnnotation = annotateImageResponse.getSafeSearchAnnotation();
                if (safeAnnotation.getViolence().getNumber() > 1
                        || safeAnnotation.getAdult().getNumber() > 3) {
                    return false;
                }

                WebDetection webDetection = annotateImageResponse.getWebDetection();
                for (WebDetection.WebEntity webEntity : webDetection.getWebEntitiesList()) {
                    if (webEntity.getDescription().equalsIgnoreCase("Weapon")
                            || webEntity.getDescription().equalsIgnoreCase("cigarette")
                            || webEntity.getDescription().equalsIgnoreCase("Alcohol")
                            || webEntity.getDescription().equalsIgnoreCase("Alcoholic drink")
                            || webEntity.getDescription().equalsIgnoreCase("Tobacco")
                            || webEntity.getDescription().equalsIgnoreCase("Knife")
                            || webEntity.getDescription().equalsIgnoreCase("Ground fighting")
                            || webEntity.getDescription().equalsIgnoreCase("Shooting")
                            || webEntity.getDescription().equalsIgnoreCase("Blood")
                            || webEntity.getDescription().equalsIgnoreCase("Daemon's Souls")
                            || webEntity.getDescription().equalsIgnoreCase("Stabbing"))

                        return false;
                }
            }
        } catch (IOException exc) {
            logger.error("Exception while reading image from the url" + exc.getMessage());
        }

        return isSafe;
    }

    public boolean isValidImage(String imageURI) {
        boolean isValid = true;

        try {
            ImageAnnotatorClient visionClient = ImageAnnotatorClient.create();
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
            List<AnnotateImageResponse> annotateImageResponses = response.getResponsesList();
            for (AnnotateImageResponse annotateImageResponse : annotateImageResponses) {

               List<EntityAnnotation> labelAnnotations = annotateImageResponse.getLabelAnnotationsList();
                WebDetection wb = annotateImageResponse.getWebDetection();
                List<WebDetection.WebEntity> wb1 = wb.getWebEntitiesList();
                boolean hasError = annotateImageResponse.hasError();
                System.out.println(annotateImageResponse.getError().getMessage());


                for (EntityAnnotation entityAnnotation : labelAnnotations) {
                    if (entityAnnotation.getDescription().equalsIgnoreCase("Headgear")
                            ||entityAnnotation.getDescription().equalsIgnoreCase("Sunglasses")
                            || entityAnnotation.getDescription().equalsIgnoreCase("Mask")
                            || entityAnnotation.getDescription().equalsIgnoreCase("Helmet")
                            || entityAnnotation.getDescription().equalsIgnoreCase("Turban")
                            || entityAnnotation.getDescription().equalsIgnoreCase("Fedora")
                            || entityAnnotation.getDescription().equalsIgnoreCase("Mammal")
                            || entityAnnotation.getDescription().equalsIgnoreCase("Animal")
                            || entityAnnotation.getDescription().equalsIgnoreCase("Cartoon")
                            || entityAnnotation.getDescription().equalsIgnoreCase("Tattoo")
                            || entityAnnotation.getDescription().equalsIgnoreCase("Actor")
                            || entityAnnotation.getDescription().equalsIgnoreCase("Actress")) {

                        return false;
                    }
                }

               for (WebDetection.WebEntity webEntity : wb.getWebEntitiesList()) {
                   if (webEntity.getDescription().equalsIgnoreCase("Optics")
                        || webEntity.getDescription().equalsIgnoreCase("Visual perception"))
                {

                    return true;
                }
                 else if (webEntity.getDescription().equalsIgnoreCase("Silhouette")
                        || webEntity.getDescription().equalsIgnoreCase("Tattoo")
                        || webEntity.getDescription().equalsIgnoreCase("Cartoon")
                        || webEntity.getDescription().equalsIgnoreCase("Mask")
                        || webEntity.getDescription().equalsIgnoreCase("Headwear")
                        || webEntity.getDescription().equalsIgnoreCase("Headscarf")
                        || webEntity.getDescription().equalsIgnoreCase("Animal")
                        || webEntity.getDescription().equalsIgnoreCase("Mammal")
                        || webEntity.getDescription().equalsIgnoreCase("Actress")
                        || webEntity.getDescription().equalsIgnoreCase("Actor")) {

                    return false;
                }
                }
            }
           } catch (IOException exc) {
            logger.error("Exception while reading image from the url" + exc.getMessage());
        }

        return isValid;
    }

    public List<String> detectLandmarks(String imageURI) {
        List<String> detectedLandMarks = new ArrayList<String>();

        try {
            ImageAnnotatorClient visionClient = ImageAnnotatorClient.create();
            ArrayList<AnnotateImageRequest> imageReqsList = new ArrayList<AnnotateImageRequest>();
            Image image = Image.newBuilder().setSource(ImageSource.newBuilder().setImageUri(imageURI)).build();
            System.out.println(image.getSource().getImageUri());

            AnnotateImageRequest imageReq = AnnotateImageRequest.newBuilder().setImage(image)
                    .addFeatures(Feature.newBuilder().setType(Type.LABEL_DETECTION).build())
                    .addFeatures(Feature.newBuilder().setType(Type.LOGO_DETECTION).build())
                    .addFeatures(Feature.newBuilder().setType(Type.LANDMARK_DETECTION).build())
                    .build();
            imageReqsList.add(imageReq);

            BatchAnnotateImagesResponse response = visionClient.batchAnnotateImages(imageReqsList);
            List<AnnotateImageResponse> annotateImageResponses = response.getResponsesList();
            for (AnnotateImageResponse annotateImageResponse : annotateImageResponses) {
                for (EntityAnnotation landmark : annotateImageResponse.getLandmarkAnnotationsList()) {
                    detectedLandMarks.add(landmark.getDescription());
                }
            }

        } catch (IOException exc) {
            logger.error("Exception while reading image from the url" + exc.getMessage());
        }

        return detectedLandMarks;
    }

    public List<String> detectLandmark(byte[] imageContent) {
        List<String> detectedLandMarks = new ArrayList<String>();

        try {
            ImageAnnotatorClient visionClient = ImageAnnotatorClient.create();
            ArrayList<AnnotateImageRequest> imageReqsList = new ArrayList<AnnotateImageRequest>();
            Image image = Image.newBuilder().setContent(ByteString.copyFrom(imageContent)).build();

            AnnotateImageRequest imageReq = AnnotateImageRequest.newBuilder().setImage(image)
                    .addFeatures(Feature.newBuilder().setType(Type.LABEL_DETECTION).build())
                    .addFeatures(Feature.newBuilder().setType(Type.LOGO_DETECTION).build())
                    .addFeatures(Feature.newBuilder().setType(Type.LANDMARK_DETECTION).build())
                    .build();
            imageReqsList.add(imageReq);

            BatchAnnotateImagesResponse response = visionClient.batchAnnotateImages(imageReqsList);
            List<AnnotateImageResponse> annotateImageResponses = response.getResponsesList();
            for (AnnotateImageResponse annotateImageResponse : annotateImageResponses) {
                for (EntityAnnotation landmark : annotateImageResponse.getLandmarkAnnotationsList()) {
                    detectedLandMarks.add(landmark.getDescription());
                }
            }
        } catch (IOException exc) {
            logger.error("Exception while reading image from the url" + exc.getMessage());

        }

        return detectedLandMarks;
    }

    public List<String> detectLogos(String imageURI) {
        List<String> logosDetected = new ArrayList<String>();

        try {
            ImageAnnotatorClient visionClient = ImageAnnotatorClient.create();
            ArrayList<AnnotateImageRequest> imageReqsList = new ArrayList<AnnotateImageRequest>();
            Image image = Image.newBuilder().setSource(ImageSource.newBuilder().setImageUri(imageURI)).build();
            AnnotateImageRequest imageReq = AnnotateImageRequest.newBuilder().setImage(image)
                    .addFeatures(Feature.newBuilder().setType(Type.LOGO_DETECTION).build())
                    .build();
            imageReqsList.add(imageReq);

            BatchAnnotateImagesResponse response = visionClient.batchAnnotateImages(imageReqsList);
            List<AnnotateImageResponse> annotateImageResponses = response.getResponsesList();
            for (AnnotateImageResponse annotateImageResponse : annotateImageResponses) {
                for (EntityAnnotation logo : annotateImageResponse.getLogoAnnotationsList()) {
                    logosDetected.add(logo.getDescription());
                }
            }
        } catch (Exception exc) {
            logger.error("Exception while reading image from the url" + exc.getMessage());
        }
       return logosDetected;
    }


   /*
private String extractValue(String imageURI)
{     {
    try {
        ImageAnnotatorClient visionClient = ImageAnnotatorClient.create();
        ArrayList<AnnotateImageRequest> imageReqsList = new ArrayList<AnnotateImageRequest>();
        Image image = Image.newBuilder().setSource(ImageSource.newBuilder().setImageUri(imageURI)).build();
        AnnotateImageRequest imageReq = AnnotateImageRequest.newBuilder().setImage(image)
                .addFeatures(Feature.newBuilder().setType(Type.LABEL_DETECTION).build())
                .addFeatures(Feature.newBuilder().setType(Type.TEXT_DETECTION).build())
                .build();
        imageReqsList.add(imageReq);

        BatchAnnotateImagesResponse response = visionClient.batchAnnotateImages(imageReqsList);
        List<AnnotateImageResponse> annotateImageResponses = response.getResponsesList();
        List<List<Vertex>> vertexobj = new ArrayList<List<Vertex>>();
        ArrayList<Vertex> vertexArrayList = new ArrayList<Vertex>();
        List<Vertex> position = new ArrayList<Vertex>();
        for (AnnotateImageResponse annotateImageResponse : annotateImageResponses){
          for (EntityAnnotation text : annotateImageResponse.getTextAnnotationsList())
            {   vertexobj.add(text.getBoundingPoly().getVerticesList());
//System.out.println(text.getDescription() + text.getBoundingPoly().getVerticesList());
            }for (int i=0;i < vertexobj.size();i++)
            {
            System.out.print("Value of element " + i + vertexobj.get(i));            }
            position = vertexobj.get(0);
        }
            System.out.println(position);
        }



    catch (IOException exc) {
        logger.error("Exception while reading image from the url" + exc.getMessage());
    }  return true; }} */


 /* Document Generating API */

    public boolean DocumentExtractionTemplate(String imageURI)

    {

        //  Map<LabelFieldArea,ValueFieldArea> map = new HashMap<LabelFieldArea, ValueFieldArea>();

        try {

            ImageAnnotatorClient visionClient = ImageAnnotatorClient.create();

            ArrayList<AnnotateImageRequest> imageReqsList = new ArrayList<AnnotateImageRequest>();

            Image image = Image.newBuilder().setSource(ImageSource.newBuilder().setImageUri(imageURI)).build();

            AnnotateImageRequest imageReq = AnnotateImageRequest.newBuilder().setImage(image)

                    .addFeatures(Feature.newBuilder().setType(Type.LABEL_DETECTION).build())

                    .addFeatures(Feature.newBuilder().setType(Type.TEXT_DETECTION).build())

                    .build();

            imageReqsList.add(imageReq);

            BatchAnnotateImagesResponse response = visionClient.batchAnnotateImages(imageReqsList);

            List<AnnotateImageResponse> annotateImageResponses = response.getResponsesList();

            List<String> Description = new ArrayList<String>();

            List<List<Vertex>> vertex = new ArrayList<List<Vertex>>();

            List<Vertex> polygon = new ArrayList<Vertex>();

            String text = "";

            float left_Top_X_Pos = 0;

            float  right_Top_X_Pos =0 ;

            float left_Bottom_X_Pos=0;

            float right_Bottom_X_Pos=0;

            float left_Top_Y_Pos=0 ;

            float  right_Top_Y_Pos =0;

            float left_Bottom_Y_Pos =0;

            float right_Bottom_Y_Pos=0;

            HashMap<String,TextFieldArea> hashMap = new HashMap<String,TextFieldArea>();

            for (AnnotateImageResponse annotateImageResponse : annotateImageResponses){

                for (EntityAnnotation poly : annotateImageResponse.getTextAnnotationsList())

                {

                    // System.out.println(poly.getDescription() + poly.getBoundingPoly().getVerticesList());

                    Description.add(poly.getDescription());

                    vertex.add(poly.getBoundingPoly().getVerticesList());

                }}

           /*System.out.print(Description.get(0));

            polygon = vertex.get(0);

           System.out.print(polygon.get(0));*/

            for (int i=0;i < vertex.size();i++)

            {

                text =  Description.get(i);

                polygon = vertex.get(i);

           /* System.out.print(polygon.get(0));

            System.out.print(polygon.get(1));

            System.out.print(polygon.get(2));

            System.out.print(polygon.get(3));  */

                Vertex First_co_ordinate = polygon.get(0);

                Vertex Second_co_ordinate = polygon.get(0);

                Vertex Third_co_ordinate = polygon.get(0);

                Vertex Forth_co_ordinate = polygon.get(0);

                left_Top_X_Pos = First_co_ordinate.getX();

                right_Top_X_Pos = First_co_ordinate.getX();

                left_Bottom_X_Pos = Second_co_ordinate.getX();

                right_Bottom_X_Pos = Second_co_ordinate.getX();

                left_Top_Y_Pos = Third_co_ordinate.getY();

                right_Top_Y_Pos = Third_co_ordinate.getY();

                left_Bottom_Y_Pos = Forth_co_ordinate.getY();

                right_Bottom_Y_Pos = Forth_co_ordinate.getY();

        /* System.out.println(text);

          System.out.println(" Left_top_x_pos :" + left_Top_X_Pos);

            System.out.println(" Right_top_x_pos:" + left_Bottom_X_Pos);

            System.out.println(" left_bootom_x_pos :" + left_Bottom_X_Pos);

            System.out.println(" Right_bottom_x_pos:" + right_Bottom_X_Pos );

            System.out.println(" Left_top_Y_pos :"+ left_Top_Y_Pos);

             System.out.println(" Right_Top_Y_pos :" +  right_Top_Y_Pos);

            System.out.println(" Left_Top_Y_pos :"+ left_Bottom_Y_Pos);

            System.out.println(" Right_Bottom_Y_pos :" + right_Bottom_Y_Pos);    */

                TextFieldArea textFieldArea=new TextFieldArea(text,left_Top_X_Pos,right_Top_X_Pos,left_Bottom_X_Pos,right_Bottom_X_Pos,left_Top_Y_Pos,right_Top_Y_Pos,left_Bottom_Y_Pos,right_Bottom_Y_Pos);

                hashMap.put(text,textFieldArea);

                // System.out.println(text);

            }

            //  Set<Map.Entry<String,TextFieldArea>> entrySet = hashMap.entrySet();

            for (Map.Entry<String,TextFieldArea> entry :hashMap.entrySet())

            {       //  System.out.println("key: " + entry.getKey());

                //  System.out.println("Value: " + entry.getValue());

                String key = (String) entry.getKey();

                TextFieldArea value = (TextFieldArea) entry.getValue();

                //  System.out.print(key);

                //System.out.print(value.text);

                System.out.println(key +"------------------" + value.left_Top_X_Pos + "  "+value.right_Top_X_Pos +"  "+

                        "    " + value.left_Bottom_X_Pos + "   " + value.right_Bottom_X_Pos + "   " + value.left_Top_Y_Pos +

                        "    "  + value.right_Top_Y_Pos + "   " + value.left_Bottom_Y_Pos + " " + value.right_Bottom_Y_Pos);

            }

        }

        catch (IOException exc) {

            logger.error("Exception while reading image from the url" + exc.getMessage());

        }

        return true;

    }



 private StringBuilder extractTextValueForLabel(TextFieldArea valueRectCoordinates,
                                                   HashMap<String, TextFieldArea> docTextsCoordinates)
    {
       StringBuilder text = new StringBuilder();
        Iterator it = docTextsCoordinates.entrySet().iterator();

         while (it.hasNext())
         {
          Map.Entry entry = (Map.Entry)it.next();
             String key = (String) entry.getKey();
             TextFieldArea value = (TextFieldArea) entry.getValue();

             float leftbottomxsmall = value.left_Bottom_X_Pos;
             float rightbottomxsmall = value.right_Bottom_X_Pos;
             float lefttopxsmall = value.left_Top_X_Pos;
             float righttopxsmall = value.right_Top_X_Pos;

             float leftbottomxbig = valueRectCoordinates.left_Bottom_X_Pos;
             float rightbottomxbig = valueRectCoordinates.right_Bottom_X_Pos;
             float lefttopxbig = valueRectCoordinates.left_Top_X_Pos;
             float righttopxbig = valueRectCoordinates.right_Top_X_Pos;


             float max_vertices1 = Math.max(leftbottomxsmall,rightbottomxsmall);
             float max_vertices2 = Math.max(lefttopxsmall,righttopxsmall);
             float max_verticessmall = Math.max(max_vertices1,max_vertices2);

             float max_vertices3 = Math.max(leftbottomxsmall,rightbottomxsmall);
             float max_vertices4 = Math.max(lefttopxsmall,righttopxsmall);
             float max_verticesbig = Math.max(max_vertices3,max_vertices4);

              if(max_verticessmall<max_verticesbig)
             {
                 text.append(" ");
                 text.append(docTextsCoordinates.values());
             }

         }
         return text;
    }
}


class TextFieldArea{

    float left_Top_X_Pos,right_Top_X_Pos,left_Bottom_X_Pos, right_Bottom_X_Pos,

    left_Top_Y_Pos,right_Top_Y_Pos,left_Bottom_Y_Pos, right_Bottom_Y_Pos;

    String text;

    public TextFieldArea(String text, float left_Top_X_Pos,float right_Top_X_Pos,float left_Bottom_X_Pos,float right_Bottom_X_Pos,

                         float left_Top_Y_Pos,float right_Top_Y_Pos,float left_Bottom_Y_Pos, float right_Bottom_Y_Pos)

    {

        this.text = text;

        this.left_Top_X_Pos = left_Top_X_Pos;

        this.right_Top_X_Pos = right_Top_X_Pos;

        this.left_Bottom_X_Pos = left_Bottom_X_Pos;

        this.right_Bottom_X_Pos = right_Bottom_X_Pos;

        this.left_Top_Y_Pos = left_Top_Y_Pos;

        this.right_Top_Y_Pos = right_Top_Y_Pos;

        this.left_Bottom_Y_Pos = left_Bottom_Y_Pos;

        this.right_Bottom_Y_Pos = right_Bottom_Y_Pos;

    }

}