package com.palmtree.content.analysis.image;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.vision.v1.*;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.gson.Gson;
import com.google.protobuf.ByteString;
import org.apache.log4j.Logger;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import javax.validation.constraints.Max;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.*;



import  java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * Created by kaarthikraaj on 10/8/17.
 **/

public class ImageContentAnalyser {

    private static Logger logger = Logger.getLogger(ImageContentAnalyser.class.getName());

    public static void main(String args[]) throws IOException {
        ImageContentAnalyser analyser = new ImageContentAnalyser();
        System.out.println(System.getenv("GOOGLE_APPLICATION_CREDENTIALS"));



 /*   // with localimage  "---ImageExpire---"
       BufferedImage expireimage = ImageIO.read(new File("/home/palm_tree/Downloads/sharpeningcommon/quality100/v22.jpg"));
        ByteArrayOutputStream expirebaos = new ByteArrayOutputStream();
        ImageIO.write(expireimage,"jpg",expirebaos);
        byte [] expire = expirebaos.toByteArray();
        analyser.isImageExpire(expire);             */


       // with urlimage "---ImageSafe---"
       // System.out.println(analyser.isImageSafe("https://www.dailydot.com/wp-content/uploads/6c855233625ee8c7985a841c4bd068dd5e1.jpg/91/"));

       // with localimage  "---ImageSafe---"
    /*    BufferedImage safeimage = ImageIO.read(new File("/home/palm_tree/Pictures/safety/13758862-Masked-gunman-taking-aim-with-a-gun-Stock-Photo-leather.jpg"));
        ByteArrayOutputStream safebaos = new ByteArrayOutputStream();
        ImageIO.write(safeimage,"jpg",safebaos);
        byte [] safe = safebaos.toByteArray();
        System.out.println(analyser.isImageSafe(safe));     */

        // with urlimage "---ImageValid---"
        //System.out.println(analyser.isValidImage("https://ichef.bbci.co.uk/images/ic/480x270/p049tgdb.jpg"));

        // with localimage "---ImageValid---"
      /*   BufferedImage validimage = ImageIO.read(new File("/home/palm_tree/Music/ebi.jpg"));
        ByteArrayOutputStream validbaos = new ByteArrayOutputStream();
        ImageIO.write(validimage,"jpg",validbaos);
        byte [] valid = validbaos.toByteArray();
        System.out.println(analyser.isValidImage(valid));  */

        // with urlimage "---LandmarkDetection---"
       // System.out.println(analyser.detectLandmarks("https://upload.wikimedia.org/wikipedia/commons/c/c8/Taj_Mahal_in_March_2004.jpg"));

      // with localimage "---LandmarkDetection---"
      /*BufferedImage landmarkimage = ImageIO.read(new File("/home/palm_tree/Pictures/stonehenge-landmark-2.jpg"));
        ByteArrayOutputStream landmarkbaos = new ByteArrayOutputStream();
        ImageIO.write(landmarkimage,"jpg",landmarkbaos);
        byte [] landmark = landmarkbaos.toByteArray();
        System.out.println(analyser.detectLandmarks(landmark));   */

       // with urlimage "---LogoDetection---"
       // System.out.println(analyser.detectLogos("http://www.carlogos.org/logo/Audi-logo-1999-1920x1080.png"));

      // with localimage "---LogoDetection---"
      /* BufferedImage logoimage = ImageIO.read(new File("/home/palm_tree/Pictures/m-bk7098white-adidas-originals-original-imaewgv6nwxkfek7.jpeg"));
        ByteArrayOutputStream logobaos = new ByteArrayOutputStream();
        ImageIO.write(logoimage,"jpg",logobaos);
        byte [] logo = logobaos.toByteArray();
        System.out.println(analyser.detectLogos(logo));   */


 /*
      // with localimage "---OCR---"
        File file = new File("/home/palm_tree/Pictures/OCR/sangeetha.jpg");
        FileInputStream imageInFile = new FileInputStream(file);
        byte imageData[] = new byte[(int) file.length()];
        imageInFile.read(imageData);
                 // Converting Image byte array into Base64 String
        String generateTemplate = com.sun.org.apache.xerces.internal.impl.dv.util.Base64.encode(imageData);

        File file2 = new File("/home/palm_tree/Pictures/OCR/hamsa.jpg");
        FileInputStream imageInFile2 = new FileInputStream(file2);
        byte imageData2[] = new byte[(int) file2.length()];
        imageInFile2.read(imageData2);
                 // Converting Image byte array into Base64 String
        String extractValue = com.sun.org.apache.xerces.internal.impl.dv.util.Base64.encode(imageData2);

                // Giving input hashmap for generating template
        HashMap<String,String> input_hashmap = new HashMap<String, String>();
        input_hashmap.put("NAME","Sangeetha Bregit");
        input_hashmap.put("GENDER","Female");
        String docType = null;
        // creating template image
        analyser.generateTemplate(generateTemplate, input_hashmap, docType);
        System.out.println(analyser.extractFieldValueUsingTemplate(extractValue , docType));

        */

 //resizing image
    /*    String old_img_path = "/home/palm_tree/Downloads/sharpeningcommon/v1.jpg";
        String new_img_path = "/home/palm_tree/Downloads/sharpeningcommon/v1_new.jpg";
        analyser.resizeImage(old_img_path, "90%","100x100", new_img_path);   */


        

   /*        // with localimage  "---picking Gender---"
       BufferedImage correctimage = ImageIO.read(new File("/home/palm_tree/Pictures/OCR/ebi.jpg"));
        ByteArrayOutputStream correctbaos = new ByteArrayOutputStream();
        ImageIO.write(correctimage,"jpg",correctbaos);
        byte [] correct = correctbaos.toByteArray();
       System.out.println( analyser.isImageCorrect(correct));  */

//------------------------------------------------------------------------------------------------//
        //----------------------------------------------------------------------------------//
        //rotating function//


        File file2 = new File("/home/palm_tree/Pictures/OCR/qqq.jpg");
        FileInputStream imageInFile2 = new FileInputStream(file2);
        byte imageData2[] = new byte[(int) file2.length()];
        imageInFile2.read(imageData2);
        // Converting Image byte array into Base64 String
        String image = com.sun.org.apache.xerces.internal.impl.dv.util.Base64.encode(imageData2);

        analyser.ImageRotation(image);

}

    public  boolean ImageRotation(String img)
    {   float x1=0;             float x2=0;
        float y1=0;             float y2=0;
        float X;                float Y;

        String image_path = "/home/palm_tree/Pictures/OCR/qqq.jpg"; //we gaved manuall path
        String convert_path = "/usr/bin/convert-im6";
        HashMap characterAndLocationHM = extractCharacterAndLocation(img);

        Iterator it = characterAndLocationHM.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry entry = (Map.Entry) it.next();
            String key = (String) entry.getKey();
            TextFieldArea value = (TextFieldArea) entry.getValue();
            x1 = value.left_Top_X_Pos;
            y1 = value.left_Top_Y_Pos;
            x2 = value.right_Top_X_Pos;
            y2 = value.right_Top_Y_Pos;
        }
        //calculating distance  of two points
        X = x2-x1;
        Y = y2-y1;
        double characterAngle = (Math.atan2(Y, X) * 180) / 3.14;
        double angleNeedToRotate = 360 - characterAngle;

        System.out.println(characterAngle + "character angle"); //for your reference

        ProcessBuilder pb = new ProcessBuilder(convert_path, "-rotate" , String.valueOf(angleNeedToRotate), image_path , image_path);
        pb.redirectErrorStream(true);
        try {
            Process p = pb.start();
            BufferedReader br = new BufferedReader( new InputStreamReader(p.getInputStream() ));
            String line = null;
            while((line=br.readLine())!=null){
                System.out.println(line);
            }
        }catch(Exception e) {
            return false;
        }
        return true;   }


    //character and location hashmap
    private HashMap extractCharacterAndLocation(String image) {
        HashMap<String,TextFieldArea> characterPositionHM = new HashMap<String, TextFieldArea>();
        String  character = "";

        try {
            ImageAnnotatorClient visionClient = ImageAnnotatorClient.create();
            ArrayList<AnnotateImageRequest> imageReqsList = new ArrayList<AnnotateImageRequest>();

            BASE64Decoder decoder = new BASE64Decoder();
            byte[] imgBytes = decoder.decodeBuffer(image);


            Image img = Image.newBuilder().setContent(ByteString.copyFrom(imgBytes)).build();
            //   Image img = Image.newBuilder().setSource(ImageSource.newBuilder().setImageUri(image)).build();
            AnnotateImageRequest imageReq = AnnotateImageRequest.newBuilder().setImage(img)
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
                // for (EntityAnnotation poly : annotateImageResponse.getTextAnnotationsList()) {

                TextAnnotation annotation = annotateImageResponse.getFullTextAnnotation();
                Page page= annotation.getPages(0);
                Block block = page.getBlocks(0);
                Paragraph paraText = block.getParagraphs(0);
                Word wordText = paraText.getWords(0);
                Symbol symbol = wordText.getSymbols(0);
                Description.add(character);
                vertex.add(symbol.getBoundingBox().getVerticesList());
            }

            for (int i = 0; i < Description.size(); i++) {
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

                characterPositionHM.put(text,textFieldArea);

            }  } catch (IOException exc) {
            logger.error("Exception while reading image from the url" + exc.getMessage());
        }
        return characterPositionHM;
    }



//---------------------------------------------------------------------------------------------
 //-----------------------------------------------------------------------------------











  /*


    HashMap<String,TextFieldArea> template = new HashMap<String, TextFieldArea>();
    public boolean generateTemplate(String image, HashMap<String, String> input_hashmap,String docType)
    {
        HashMap<String, HashMap> templateRegistry = new HashMap<String, HashMap>();
        Set<String> label = input_hashmap.keySet();
        TextFieldArea textFieldArea = null;
        HashMap<String,TextFieldArea> text_positionhashmap = new HashMap<String,TextFieldArea>();
        for (String labels:label)
        {
            String valueForLabel = input_hashmap.get(labels);
            text_positionhashmap = extractTextsAndLocation(image);
            textFieldArea= getPostionOfValueForLabel(valueForLabel, text_positionhashmap);
            template.put(labels,textFieldArea);
        }
        return true;
    }


    public HashMap extractFieldValueUsingTemplate(String image, String docType)
    {
        Set<String> labelValue = template.keySet();
        HashMap <String,TextFieldArea> text_positionhashmap = new HashMap<String,TextFieldArea>();
        HashMap <String,String> outputHashmap = new HashMap<String, String>();
        text_positionhashmap = extractTextsAndLocation(image);
        for (String value:labelValue)
        {
            TextFieldArea textFieldArea_bigRect =  template.get(value);
            String value_text = extractTextValueForLabel(textFieldArea_bigRect,text_positionhashmap);
            outputHashmap.put(value,value_text);
        }
        Gson gson = new Gson();
        //    String  json_String = gson.toJson(outputHashmap);
        String image_string = gson.toJson(image);

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



    private HashMap extractTextsAndLocation(String image) {
        HashMap<String,TextFieldArea> textPositionHM = new HashMap<String, TextFieldArea>();
        try {
            ImageAnnotatorClient visionClient = ImageAnnotatorClient.create();
            ArrayList<AnnotateImageRequest> imageReqsList = new ArrayList<AnnotateImageRequest>();

            BASE64Decoder decoder = new BASE64Decoder();
            byte[] imgBytes = decoder.decodeBuffer(image);


            Image img = Image.newBuilder().setContent(ByteString.copyFrom(imgBytes)).build();
            //   Image img = Image.newBuilder().setSource(ImageSource.newBuilder().setImageUri(image)).build();
            AnnotateImageRequest imageReq = AnnotateImageRequest.newBuilder().setImage(img)
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




















    public HashMap duplicateLocation(String image)
    {

        HashMap<String,TextFieldArea> duplicateHM = new HashMap<String, TextFieldArea>();
        try {
            ImageAnnotatorClient visionClient = ImageAnnotatorClient.create();
            ArrayList<AnnotateImageRequest> imageReqsList = new ArrayList<AnnotateImageRequest>();

            BASE64Decoder decoder = new BASE64Decoder();
            byte[] imgBytes = decoder.decodeBuffer(image);


            Image img = Image.newBuilder().setContent(ByteString.copyFrom(imgBytes)).build();
            //   Image img = Image.newBuilder().setSource(ImageSource.newBuilder().setImageUri(image)).build();
            AnnotateImageRequest imageReq = AnnotateImageRequest.newBuilder().setImage(img)
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


                duplicateHM.put(text,textFieldArea);
            }
        } catch (IOException exc) {
            logger.error("Exception while reading image from the url" + exc.getMessage());
        }
        return duplicateHM;
    }




      public HashMap originalLocation(String image)
      {

          HashMap<String,TextFieldArea> originalHM = new HashMap<String, TextFieldArea>();
          try {
              ImageAnnotatorClient visionClient = ImageAnnotatorClient.create();
              ArrayList<AnnotateImageRequest> imageReqsList = new ArrayList<AnnotateImageRequest>();

              BASE64Decoder decoder = new BASE64Decoder();
              byte[] imgBytes = decoder.decodeBuffer(image);


              Image img = Image.newBuilder().setContent(ByteString.copyFrom(imgBytes)).build();
              //   Image img = Image.newBuilder().setSource(ImageSource.newBuilder().setImageUri(image)).build();
              AnnotateImageRequest imageReq = AnnotateImageRequest.newBuilder().setImage(img)
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

                  originalHM.put(text,textFieldArea);
              }
          } catch (IOException exc) {
              logger.error("Exception while reading image from the url" + exc.getMessage());
          }
          return originalHM;

      }

       public float Comparation(HashMap orignal, HashMap duplicate)
       {
           String orignal_name = "NAME";
           String duplicate_name = "NAME";

         //  Set<String> labelValue = orignal.keySet();
          // Set<String> labelValue_duplicate = duplicate.keySet();

           Iterator it = orignal.entrySet().iterator();
           Iterator it1 = duplicate.entrySet().iterator();
           Map.Entry entry = null;
           Map.Entry entry1 = null;
           TextFieldArea value = null;
           TextFieldArea value1 = null;
           float sub = 0;
           float degree = (float) 360.0;
           while (it.hasNext())
           {
               entry = (Map.Entry) it.next();
               String key = (String) entry.getKey();
                value = (TextFieldArea)  entry.getValue();
               if (key.equals(orignal_name))
               {
                   System.out.println(key + "---------" + value.left_Top_X_Pos +" " + value.left_Top_Y_Pos + " " + value.right_Top_X_Pos + "  " + value.right_Top_Y_Pos + " " + value.right_Bottom_X_Pos + " "+ value.right_Bottom_Y_Pos + " " + value.left_Bottom_X_Pos + " " + value.left_Bottom_Y_Pos);

               }

           while ((it1.hasNext()))
           {
               entry1 = (Map.Entry)it1.next();
               String key1 = (String) entry1.getKey();
                value1 = (TextFieldArea) entry1.getValue();
               if(key1.equals(duplicate_name))
               {
                   System.out.println( "duplicate"+ key1 + value1.left_Top_X_Pos +" " + value1.left_Top_Y_Pos + " " + value1.right_Top_X_Pos + "  " + value1.right_Top_Y_Pos + " " + value1.right_Bottom_X_Pos + " "+ value1.right_Bottom_Y_Pos + " " + value1.left_Bottom_X_Pos + " " + value1.left_Bottom_Y_Pos);
               }


           if (value.left_Top_X_Pos < value1.left_Top_X_Pos)
           {
                    float sub1 = value.left_Top_X_Pos;
                    float sub2 = value1.left_Top_X_Pos;
                    sub = sub1-sub2;



           }
           }
           }
           System.out.println(sub);
           degree = degree-sub;
           System.out.println(sub);



           return degree;
       }



    public static boolean resizeImage(String input_img_path, String quality, String size, String output_img_path)
    {
        // absolute path to ImageMagick: Command-line Tools: Convert
        String convert_path = "/usr/bin/convert-im6";

        // Build process to execute convert
        ProcessBuilder pb = new ProcessBuilder(convert_path, input_img_path,  "-quality", quality ,"-resize", size,  output_img_path);
        pb.redirectErrorStream(true);
        try {
            Process p = pb.start();
            BufferedReader br = new BufferedReader( new InputStreamReader(p.getInputStream() ));
            String line = null;
            while((line=br.readLine())!=null){
                System.out.println(line);
            }
        }catch(Exception e) {
            return false;
        }
        return true;   }




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




    public boolean isImageSafe(byte[] imageURI) {
        boolean isSafe = true;
        try {
            ImageAnnotatorClient visionClient = ImageAnnotatorClient.create();
            ArrayList<AnnotateImageRequest> imageReqsList = new ArrayList<AnnotateImageRequest>();
            //   Image image = Image.newBuilder().setSource(ImageSource.newBuilder().setImageUri(imageURI)).build();
            Image image = Image.newBuilder().setContent(ByteString.copyFrom(imageURI)).build();
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



    public List<String> detectLandmarks(byte[] imageURI) {
        List<String> detectedLandMarks = new ArrayList<String>();

        try {
            ImageAnnotatorClient visionClient = ImageAnnotatorClient.create();
            ArrayList<AnnotateImageRequest> imageReqsList = new ArrayList<AnnotateImageRequest>();
            //    Image image = Image.newBuilder().setSource(ImageSource.newBuilder().setImageUri(imageURI)).build();
            Image image = Image.newBuilder().setContent(ByteString.copyFrom(imageURI)).build();
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



    public List<String> detectLogos(byte[] imageURI) {
        List<String> logosDetected = new ArrayList<String>();

        try {
            ImageAnnotatorClient visionClient = ImageAnnotatorClient.create();
            ArrayList<AnnotateImageRequest> imageReqsList = new ArrayList<AnnotateImageRequest>();
            //       Image image = Image.newBuilder().setSource(ImageSource.newBuilder().setImageUri(imageURI)).build();
            Image image = Image.newBuilder().setContent(ByteString.copyFrom(imageURI)).build();
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


  */


    public List<String> detectLogosDuplicate(String imageURI) {
        List<String> logosDetected = new ArrayList<String>();

        try {
            ImageAnnotatorClient visionClient = ImageAnnotatorClient.create();
            ArrayList<AnnotateImageRequest> imageReqsList = new ArrayList<AnnotateImageRequest>();
            Image image = Image.newBuilder().setSource(ImageSource.newBuilder().setImageUri(imageURI)).build();
            //    Image image = Image.newBuilder().setContent(ByteString.copyFrom(imageURI)).build();
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
    public boolean isImageExpire(byte[] imageURI) {
        boolean isExpire = false;
        try {
            ImageAnnotatorClient visionClient = ImageAnnotatorClient.create();
            ArrayList<AnnotateImageRequest> imageReqsList = new ArrayList<AnnotateImageRequest>();
            //   Image image = Image.newBuilder().setSource(ImageSource.newBuilder().setImageUri(imageURI)).build();
            Image image = Image.newBuilder().setContent(ByteString.copyFrom(imageURI)).build();
            AnnotateImageRequest imageReq = AnnotateImageRequest.newBuilder().setImage(image)
                    .addFeatures(Feature.newBuilder().setType(Type.LABEL_DETECTION).build())
                    .addFeatures(Feature.newBuilder().setType(Type.TEXT_DETECTION).build())
                    .build();
            imageReqsList.add(imageReq);

            BatchAnnotateImagesResponse response = visionClient.batchAnnotateImages(imageReqsList);
            List<AnnotateImageResponse> annotateImageResponses = response.getResponsesList();
            List<String> Description = new ArrayList<String>();

            for (AnnotateImageResponse annotateImageResponse : annotateImageResponses) {
                for (EntityAnnotation poly : annotateImageResponse.getTextAnnotationsList())
                {
                    System.out.println(poly.getDescription());
                Description.add(poly.getDescription());
                }
            }

             // System.out.println(Description);


            {
             System.out.println("t6tttttttttttt");

            }

        //Getting Current Date
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date dateobj = new Date();
            System.out.println("Current date:" + df.format(dateobj));





        } catch (IOException exc) {
            logger.error("Exception while reading image from the url" + exc.getMessage());
        }

        return isExpire;
    }

       */

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

