package com.palmtree.content.analysis.image;

import com.google.cloud.vision.v1.*;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.protobuf.ByteString;
import org.apache.log4j.Logger;
import javax.validation.constraints.Max;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

/**
 * Created by kaarthikraaj on 10/8/17.
 **/

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

        HashMap<String,String> input = new HashMap<String, String>();
        input.put("NAME","Sangeetha Bregit");
        input.put("GENDER","Female");
        String docType = null;
       analyser.generateTemplate("https://00e9e64bac5f3661c72877f9dca51e583dd787844949b054b3-apidata.googleusercontent.com/download/storage/v1/b/staging.palmtree-image-01.appspot.com/o/id-779405708897475.jpg?qk=AD5uMEu7mWsjNHUjiRFgf1UEDiu3BJtppaM5Pmw1T0SvfJuaiMaNQaLcg_pkVo-bQyvm9iR6Sas3FPA9CVk1Ru4-uVwRzLKiFcETkGrjFYCrmTEUj8GoZeXwSjn-4-NuP-UbTuAFfk30JBY1qmkEgPvlbHaYNF77EG9HeA_nQfw6jH7-Pu4Pd_lQF40zPR2BOu4EnWMFU9J34Wr2vj6JXJUKNKnGnt1FU--NTHamZyUKPknF8RdrbmE0GokFwWQ1QMmpHZRsZ8JcStqArb-IEJKiBVE7A0Chyb3hgQbXS_OwpgjnLJ21Jcklod_YVm5HqU9yGO_l4GkRdYigTR0WbcU9unqlJcc_ZHYBbzk34eU4FvxYpUEcH7pltPcXk4Nyh8MHOCPAjLaji7O0TDf_qPCslkXR05syU2zQ88HQ0FqnHz4gnlIeJCXtiv_1kL2mYtt7JonWxdcVHK223_j6uBHBEV49wo3JOtSCrSyQFvd2VtxWzw3shl1MRZkUBsJhtZf1AhMjjUBaxGl_AuyREwJpmDJ016vICaylPSJtPcq0JgsyJXsVLmy1Tr1yVQUYu-4zkaCv_5e8uGeRB3tt6goy2XLLK32nkH9UPjqSkcVCqIl4JhbbonTdqeIIaFd127xO6gLAEoMmzVjueCTj5vSP0UOKZXYX1JG0TeYBkcInYwevxMC-f2zsLCt0vHrrWcELGmCkscRz-lMIItLfDHUe4CVlMNND-FtNy2o1oHkHwlt6EKbRZlGSIaxMwykk2zdKwDDkBQtinwDReKbXn2jlvlATDbZ4Ig", input, docType);
     System.out.println(analyser.extractFieldValueUsingTemplate("https://00e9e64bac2fb2188cba72841a16635d014f7f477bb97d6b77-apidata.googleusercontent.com/download/storage/v1/b/staging.palmtree-image-01.appspot.com/o/id-1919331104995787.jpg?qk=AD5uMEsPxonbha6VveSun-2RK7qHezi5XImff_BB1Sxj3EeCEVNzSHLTxOLyotlMdldU75r_Nne84tguwEZnnmDxSrwGmojAQNUXAZDWFuOC-ams6I5-JqSF_UQOduRdIjlY1tNeRl0yPySxFmAmnzb9jl0Jq97XOG-kICuL-J2PBAjYH-BcHOH7eR8BRRkj45cEL76WezLFm7OHMUvG2rNqNNfYVyMe2kspVR-aL5O363624DcoU6QJijuHfbFBiulXBjiy4bDKjeLsLCXaBbTj7-DwS3EXElqBAX9z9ZCXDAwZ17OhkuF66L4ATO7aDKo3GTa03lkLp9LX5F5yFYuv3lNhg5GW9udp4ozeWol9Cgx-ae_8UZU3mXwWhOQH6mLVUq3zsvhdtqZjoCEoiX4LR7MpYTa_RqMLK99lyeBbIVJI_L7wJU2POV_AYbBV3KNePf1qbHz_o9rxEDnMiK_d6QJGE0YltkN90oQBc3JqUvjzARgU4BxDdaDDw16X6jGS7DsK3QwJ3NI_eFCncENsBr1vve6wY5GU7AHoQ63eNscVmGoCtYX__92ACgtYN2ygVR3_vAiwIOzmXtNZn2yPlAkCBaZIkQZUr9NbBMa3G7zMvMsi6Z19p4wYDsDATXeycM_qf84U5mg4ahZ7EDIowAVoSY3pkAAwLtN1cxS56Wq0w-J3Z5VEDPHW559iJRZ-Zrvqd9Ijlu8iUpKoWwHSFqJeRjasEfpw-3h9LHQZXlJEurP3C1AiAIl189ctKM5DNInNqPILwfYxBEgUESgxdfVvi7_FKQ" , docType));
   }

    HashMap<String,TextFieldArea> template = new HashMap<String, TextFieldArea>();

    public boolean generateTemplate(String imageURI, HashMap<String, String> input_hashmap,String docType) {
        HashMap<String, HashMap> templateRegistry = new HashMap<String, HashMap>();
        Set<String> label = input_hashmap.keySet();
        TextFieldArea textFieldArea = null;
        HashMap <String,TextFieldArea> text_positionhashmap = new HashMap<String, TextFieldArea>();
        HashMap<String,String> outputHashMap = new HashMap<String, String>();
        for (String labels:label)
        {
           String valueForLabel = input_hashmap.get(labels);
            text_positionhashmap = extractTextsAndLocation(imageURI);
            textFieldArea= getPostionOfValueForLabel(valueForLabel, text_positionhashmap);
            template.put(labels,textFieldArea);
          //  outputHashMap = extractFieldValueUsingTemplate(imageURI,docType);
        }
       // System.out.println(outputHashMap);
       // templateRegistry.put(docType,template);
        return true;
        }


    public HashMap extractFieldValueUsingTemplate(String imageURI, String docType)
    {

        Set<String> labelValue = template.keySet();
        HashMap <String,TextFieldArea> text_positionhashmap = new HashMap<String,TextFieldArea>();
        HashMap <String,String> outputHashmap = new HashMap<String, String>();
        text_positionhashmap = extractTextsAndLocation(imageURI);

        for (String value:labelValue)
        {
            TextFieldArea textFieldArea_bigRect =  template.get(value);
           String value_text = extractTextValueForLabel(textFieldArea_bigRect,text_positionhashmap);
           outputHashmap.put(value,value_text);
        }

        return outputHashmap;
    }




    public TextFieldArea getPostionOfValueForLabel(String valueForLabel, HashMap<String,TextFieldArea> TextAndPosition)
    {      float left_Top_X_Pos=0, left_Top_Y_Pos=0,
            right_Top_X_Pos=0,right_Top_Y_Pos=0,
            right_Bottom_X_Pos=0,right_Bottom_Y_Pos=0,
            left_Bottom_X_Pos=0,left_Bottom_Y_Pos=0;

        String first = "";
        String last = "";
        String[] splitValue = valueForLabel.split(" ");
        int j = splitValue.length;
        first = splitValue[0];
        last = splitValue[j-1];
        Set<String> label = TextAndPosition.keySet();

        for (String labels:label)
        {
            if (labels.contains(first))
            {   left_Top_X_Pos = TextAndPosition.get(first).left_Top_X_Pos - 5;
                left_Top_Y_Pos = TextAndPosition.get(first).left_Top_Y_Pos -2;}
            if (labels.contains(last))
            {   right_Bottom_X_Pos = TextAndPosition.get(last).right_Bottom_X_Pos +5;
                right_Bottom_Y_Pos = TextAndPosition.get(last).right_Bottom_Y_Pos +2;}
        }
        right_Top_X_Pos = right_Bottom_X_Pos;
        right_Top_Y_Pos = left_Top_Y_Pos;
        left_Bottom_X_Pos = left_Top_X_Pos;
        left_Bottom_Y_Pos = right_Bottom_Y_Pos;

   //     System.out.println("\n left_Top_X_Pos:" +left_Top_X_Pos + "\n left_Top_Y_Pos: " +left_Top_Y_Pos +
     //           "\n right_Top_X_Pos " + right_Top_X_Pos + "\n right_Top_Y_Pos " + right_Top_Y_Pos +
       //         "\n right_Bottom_X_Pos " + right_Bottom_X_Pos + "\n right_Bottom_Y_Pos " + right_Bottom_Y_Pos +
         //       "\n left_Bottom_X_Pos" + left_Bottom_X_Pos + "\n left_Bottom_Y_Pos " + left_Bottom_Y_Pos);
        TextFieldArea textFieldArea_bigRect = new TextFieldArea(left_Top_X_Pos,left_Top_Y_Pos,right_Top_X_Pos,
                right_Top_Y_Pos,right_Bottom_X_Pos,right_Bottom_Y_Pos,
                left_Bottom_X_Pos,left_Bottom_Y_Pos);
           return textFieldArea_bigRect;
    }



    private HashMap extractTextsAndLocation(String imageURI) {
        HashMap<String,TextFieldArea> textPositionHM = new HashMap<String, TextFieldArea>();
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
            float left_Top_X_Pos = 0;                   float right_Top_X_Pos = 0;
            float left_Bottom_X_Pos = 0;                float right_Bottom_X_Pos = 0;
            float left_Top_Y_Pos = 0;                   float right_Top_Y_Pos = 0;
            float left_Bottom_Y_Pos = 0;                float right_Bottom_Y_Pos = 0;


            for (AnnotateImageResponse annotateImageResponse : annotateImageResponses) {
                for (EntityAnnotation poly : annotateImageResponse.getTextAnnotationsList()) {
                    Description.add(poly.getDescription());
                    vertex.add(poly.getBoundingPoly().getVerticesList());   }  }

            for (int i = 1; i < vertex.size(); i++) {
                text = Description.get(i);
                polygon = vertex.get(i);

                Vertex First_co_ordinate = polygon.get(0);
                Vertex Second_co_ordinate = polygon.get(1);
                Vertex Third_co_ordinate = polygon.get(2);
                Vertex Forth_co_ordinate = polygon.get(3);

                left_Top_X_Pos = First_co_ordinate.getX();
                left_Top_Y_Pos = First_co_ordinate.getY();
                right_Top_X_Pos = Second_co_ordinate.getX();
                right_Top_Y_Pos = Second_co_ordinate.getY();
                right_Bottom_X_Pos = Third_co_ordinate.getX();
                right_Bottom_Y_Pos = Third_co_ordinate.getY();
                left_Bottom_X_Pos = Forth_co_ordinate.getX();
                left_Bottom_Y_Pos = Forth_co_ordinate.getY();
                TextFieldArea textFieldArea = new TextFieldArea(left_Top_X_Pos, left_Top_Y_Pos,
                        right_Top_X_Pos, right_Top_Y_Pos, right_Bottom_X_Pos, right_Bottom_Y_Pos,
                        left_Bottom_X_Pos, left_Bottom_Y_Pos);

                textPositionHM.put(text,textFieldArea);
            }
        } catch (IOException exc) {
            logger.error("Exception while reading image from the url" + exc.getMessage());
        }
        return textPositionHM;
    }



    // Method For Comparing Rectangle
    private String extractTextValueForLabel(TextFieldArea bigRect , HashMap<String, TextFieldArea> smallRect)
    {
        Iterator it = smallRect.entrySet().iterator();
        StringBuilder builder = new StringBuilder();
        String text = "";

        while (it.hasNext())
        {

            Map.Entry entry = (Map.Entry) it.next();
            String key = (String) entry.getKey();
            TextFieldArea value = (TextFieldArea) entry.getValue();

            if ((value.left_Top_X_Pos >=  bigRect.left_Top_X_Pos
                    && value.left_Top_Y_Pos >= bigRect.left_Top_Y_Pos)

                    && (value.right_Bottom_X_Pos <= bigRect.right_Bottom_X_Pos
                    && value.right_Bottom_Y_Pos <= bigRect.right_Bottom_Y_Pos))
            {
                builder.append(key);
                builder.append(" ");
            }
        }
        text = builder.toString();
        return text;
    }









    public boolean tryingRearrange (String imageURI) {
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
            float left_Top_X_Pos = 0;                   float right_Top_X_Pos = 0;
            float left_Bottom_X_Pos = 0;                float right_Bottom_X_Pos = 0;
            float left_Top_Y_Pos = 0;                   float right_Top_Y_Pos = 0;
            float left_Bottom_Y_Pos = 0;                float right_Bottom_Y_Pos = 0;


            for (AnnotateImageResponse annotateImageResponse : annotateImageResponses) {
                for (EntityAnnotation poly : annotateImageResponse.getTextAnnotationsList()) {
                    Description.add(poly.getDescription());
                    vertex.add(poly.getBoundingPoly().getVerticesList());   }  }

            for (int i = 1; i < vertex.size(); i++) {
                text = Description.get(i);
                polygon = vertex.get(i);

                Vertex First_co_ordinate = polygon.get(0);
                Vertex Second_co_ordinate = polygon.get(1);
                Vertex Third_co_ordinate = polygon.get(2);
                Vertex Forth_co_ordinate = polygon.get(3);

                left_Top_X_Pos = First_co_ordinate.getX();
                left_Top_Y_Pos = First_co_ordinate.getY();
                right_Top_X_Pos = Second_co_ordinate.getX();
                right_Top_Y_Pos = Second_co_ordinate.getY();
                right_Bottom_X_Pos = Third_co_ordinate.getX();
                right_Bottom_Y_Pos = Third_co_ordinate.getY();
                left_Bottom_X_Pos = Forth_co_ordinate.getX();
                left_Bottom_Y_Pos = Forth_co_ordinate.getY();
                TextFieldArea textFieldArea = new TextFieldArea(left_Bottom_X_Pos, left_Bottom_Y_Pos,
                        right_Bottom_X_Pos, right_Bottom_Y_Pos, right_Top_X_Pos, right_Top_Y_Pos, left_Top_X_Pos, left_Top_Y_Pos);

            }
        } catch (IOException exc) {
            logger.error("Exception while reading image from the url" + exc.getMessage());
        }
        return true;
    }


    ///////////////////////////////////////////////////////////




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
}


class TextFieldArea{
    float left_Top_X_Pos,right_Top_X_Pos,left_Bottom_X_Pos, right_Bottom_X_Pos,
            left_Top_Y_Pos,right_Top_Y_Pos,left_Bottom_Y_Pos, right_Bottom_Y_Pos;
    public TextFieldArea(float left_Top_X_Pos,float left_Top_Y_Pos,float  right_Top_X_Pos,
                         float right_Top_Y_Pos,float right_Bottom_X_Pos,float right_Bottom_Y_Pos,
                         float left_Bottom_X_Pos, float left_Bottom_Y_Pos)
    {
        this.left_Top_X_Pos = left_Top_X_Pos;
        this.left_Top_Y_Pos = left_Top_Y_Pos;
        this.right_Top_X_Pos = right_Top_X_Pos;
        this.right_Top_Y_Pos = right_Top_Y_Pos;
        this.right_Bottom_X_Pos = right_Bottom_X_Pos;
        this.right_Bottom_Y_Pos = right_Bottom_Y_Pos;
        this.left_Bottom_X_Pos = left_Bottom_X_Pos;
        this.left_Bottom_Y_Pos = left_Bottom_Y_Pos;  }}

 /*        //finding template
        for (String value:labelValue)
        {      if(value=="Religion")
            {        docType = "Indian PAssPort";
          System.out.println(docType);  }}      */


/*           for(Map.Entry<String,TextFieldArea> entry:TextAndPosition.entrySet())
        {   String key = entry.getKey();
            TextFieldArea value = entry.getValue();

            if (key.contains(first))
            {   left_Top_X_Pos = value.left_Top_X_Pos;
                left_Top_Y_Pos = value.left_Top_Y_Pos;}
            if (key.contains(last))
            {   right_Bottom_X_Pos = value.right_Bottom_X_Pos;
                right_Bottom_Y_Pos = value.right_Bottom_Y_Pos;}
       }                 */