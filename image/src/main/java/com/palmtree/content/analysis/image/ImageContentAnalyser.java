package com.palmtree.content.analysis.image;

import com.google.cloud.vision.v1.*;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.gson.Gson;
import com.google.protobuf.ByteString;
import org.apache.log4j.Logger;
import sun.misc.BASE64Decoder;

import java.io.*;
import java.util.*;


/**
 * Created by kaarthikraaj on 10/8/17.
 **/

public class ImageContentAnalyser {

    private static Logger logger = Logger.getLogger(ImageContentAnalyser.class.getName());

    public static void main(String args[]) throws IOException {
        ImageContentAnalyser analyser = new ImageContentAnalyser();
        System.out.println(System.getenv("GOOGLE_APPLICATION_CREDENTIALS"));

        //     with urlimage  "---ImageSafe---"
        //     System.out.println(analyser.isImageSafe("https://www.dailydot.com/wp-content/uploads/6c855233625ee8c7985a841c4bd068dd5e1.jpg/91/"));


        //     with localimage  "---ImageSafe---"
 /*     BufferedImage safeimage = ImageIO.read(new File("/home/palm_tree/Pictures/safety/13758862-Masked-gunman-taking-aim-with-a-gun-Stock-Photo-leather.jpg"));
        ByteArrayOutputStream safebaos = new ByteArrayOutputStream();
        ImageIO.write(safeimage,"jpg",safebaos);
        byte [] safe = safebaos.toByteArray();
        System.out.println(analyser.isImageSafe(safe));                 */

        //     with urlimage  "---ImageValid---"
        //     System.out.println(analyser.isValidImage("https://ichef.bbci.co.uk/images/ic/480x270/p049tgdb.jpg"));

        //     with localimage  "---ImageValid---"
 /*     BufferedImage validimage = ImageIO.read(new File("/home/palm_tree/Music/ebi.jpg"));
        ByteArrayOutputStream validbaos = new ByteArrayOutputStream();
        ImageIO.write(validimage,"jpg",validbaos);
        byte [] valid = validbaos.toByteArray();
        System.out.println(analyser.isValidImage(valid));                */

        //     with urlimage  "---LandmarkDetection---"
        //     System.out.println(analyser.detectLandmarks("https://upload.wikimedia.org/wikipedia/commons/c/c8/Taj_Mahal_in_March_2004.jpg"));

        //     with localimage  "---LandmarkDetection---"
 /*     BufferedImage landmarkimage = ImageIO.read(new File("/home/palm_tree/Pictures/stonehenge-landmark-2.jpg"));
        ByteArrayOutputStream landmarkbaos = new ByteArrayOutputStream();
        ImageIO.write(landmarkimage,"jpg",landmarkbaos);
        byte [] landmark = landmarkbaos.toByteArray();
        System.out.println(analyser.detectLandmarks(landmark));           */

        //     with urlimage  "---LogoDetection---"
        //     System.out.println(analyser.detectLogos("http://www.carlogos.org/logo/Audi-logo-1999-1920x1080.png"));


        //     with localimage  "---LogoDetection---"
 /*     BufferedImage logoimage = ImageIO.read(new File("/home/palm_tree/Pictures/m-bk7098white-adidas-originals-original-imaewgv6nwxkfek7.jpeg"));
        ByteArrayOutputStream logobaos = new ByteArrayOutputStream();
        ImageIO.write(logoimage,"jpg",logobaos);
        byte [] logo = logobaos.toByteArray();
        System.out.println(analyser.detectLogos(logo));   */



        //--------------------------------111111----------------------------

        //--------------- with localimage  "---OCR---"  -------------------------------------------------


        File file1 = new File("/home/palm_tree/Downloads/OCR/Pass_template.jpg");
        FileInputStream imageInFile = new FileInputStream(file1);
        byte imageData[] = new byte[(int) file1.length()];
        imageInFile.read(imageData);
        // Converting Image byte array into Base64 String
        String templateImage = com.sun.org.apache.xerces.internal.impl.dv.util.Base64.encode(imageData);

        // Giving input hashmap for generating template
        HashMap<String,String> Passport_input_hashmap = new HashMap<String, String>();
        HashMap<String,String> Fb_id_input_hashmap = new HashMap<String, String>();
        //  Pass_port_input_hashmap.put("Type","P");
        //Pass_port_input_hashmap.put("Code","IND");

        //Passport_input_hashmap.put("Nationality","INDIAN");
        //Pass_port_input_hashmap.put("Name","GUWAHATI");



        // Passport_input_hashmap.put("Sex","F");
     /*  Fb_id_input_hashmap.put("Name","Sangeetha Bregit");
        Fb_id_input_hashmap.put("Gender","Female");
        Fb_id_input_hashmap.put("Born","12 Mar");
        Fb_id_input_hashmap.put("Location","Dindigul,");
        Fb_id_input_hashmap.put("id","779405708897475");*/
        Passport_input_hashmap.put("Nationality","INDIAN");
        Passport_input_hashmap.put("Name","BRAHMACHARIMAYUM");
        Passport_input_hashmap.put("Issue_Place","GUWAHATI");
        Passport_input_hashmap.put("Issue_Date","16/12/2015");
        Passport_input_hashmap.put("Expiry_Date","15/12/2025");
        Passport_input_hashmap.put("Birth_Date","25/04/1994");

        String docType = null;
        // creating template image
        analyser.generateTemplate(templateImage,Passport_input_hashmap, docType);

        File file2 = new File("/home/palm_tree/Downloads/OCR/ttt.jpg");
        FileInputStream imageInFile2 = new FileInputStream(file2);
        byte imageData2[] = new byte[(int) file2.length()];
        imageInFile2.read(imageData2);
        // Converting Image byte array into Base64 String
        String image = com.sun.org.apache.xerces.internal.impl.dv.util.Base64.encode(imageData2);


        analyser.ImageEnhancement(image);
    }
    // analyser.Resize(templateImage, image, input_hashmap);

 /*       File file2 = new File("/home/palm_tree/Pictures/OCR/hamsa.jpg");
        FileInputStream imageInFile2 = new FileInputStream(file2);
        byte imageData2[] = new byte[(int) file2.length()];
        imageInFile2.read(imageData2);                              zzzz
                 // Converting Image byte array into Base64 String
        String extractValue = com.sun.org.apache.xerces.internal.impl.dv.util.Base64.encode(imageData2);


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


     /*   File file2 = new File("/home/palm_tree/Pictures/OCR/qqq.jpg");
        FileInputStream imageInFile2 = new FileInputStream(file2);
        byte imageData2[] = new byte[(int) file2.length()];
        imageInFile2.read(imageData2);
        // Converting Image byte array into Base64 String
        String image = com.sun.org.apache.xerces.internal.impl.dv.util.Base64.encode(imageData2);

        analyser.ImageRotation(image);

       */










    public  boolean ImageEnhancement(String img) throws IOException
    {   float x1=0;             float x2=0;
        float y1=0;             float y2=0;
        float X;                float Y;

        String image_path = "/home/palm_tree/Downloads/OCR/ttt.jpg"; //we gaved manuall path
        String convert_path = "/usr/bin/convert-im6";
        String textcleaner_path = "/usr/local/bin/textcleaner";
        HashMap TextAndLocationHM = rotation_extractTextsAndLocation(img);
        Set<String> key = TextAndLocationHM.keySet();
        TextFieldArea yy = null;
        for(String label:key)
        {
            //System.out.println("label value------------------" + label);
            yy = (TextFieldArea) TextAndLocationHM.get(label);

            break;

        }
        x1 = yy.left_Bottom_X_Pos;
        y1 = yy.left_Bottom_Y_Pos;
        x2 = yy.right_Bottom_X_Pos;
        y2 = yy.right_Bottom_Y_Pos;
        //calculating distance  of two points
        X = x2-x1;
        Y = y2-y1;
        // System.out.println(Y + "------------------"+ X);
        double Angle_Tilt = (Math.atan2(Y, X) * 180) / 3.14;
        double angleNeedToRotate = 360 - Angle_Tilt;
        if(Angle_Tilt==0)
        {
            System.out.println("Image no need rotation");
            ProcessBuilder pb2 = new ProcessBuilder(convert_path,image_path, "-flatten","-fuzz", "2%", "-trim",image_path);
            pb2.redirectErrorStream(true);
            try {  // Text Cleaning command to Trim the image
                Process p3 = pb2.start();
                BufferedReader br3 = new BufferedReader( new InputStreamReader(p3.getInputStream() ));
                String line2 = null;
                while((line2=br3.readLine())!=null){
                    System.out.println(line2);
                }
            }catch(Exception e) {
                return false;
            }
            File file5 = new File("/home/palm_tree/Downloads/OCR/ttt.jpg");
            FileInputStream imageInFile5 = new FileInputStream(file5);
            byte imageData5[] = new byte[(int) file5.length()];
            imageInFile5.read(imageData5);
            // Converting Image byte array into Base64 String
            String image = com.sun.org.apache.xerces.internal.impl.dv.util.Base64.encode(imageData5);
            System.out.println(extractFieldValueUsingTemplate(image,"fb_id"));
        }
        else   // Image need Rotation
        {
            System.out.println(Angle_Tilt + "text angle"  +"-------" + "angle need to be rotated " + angleNeedToRotate); //for your reference


            ProcessBuilder pb = new ProcessBuilder(convert_path, "-rotate" , String.valueOf(angleNeedToRotate), image_path , image_path);
            ProcessBuilder pb1 = new ProcessBuilder(textcleaner_path, "-T" , image_path , image_path);
            ProcessBuilder pb2 = new ProcessBuilder(convert_path, "-fuzz", "2%", image_path,image_path);
            pb.redirectErrorStream(true);
            try {  //image rotation command
                Process p = pb.start();
                BufferedReader br = new BufferedReader( new InputStreamReader(p.getInputStream() ));
                String line = null;
                while((line=br.readLine())!=null){
                    System.out.println(line);
                }
            }catch(Exception e) {
                return false;
            }

            try {  // Text Cleaning command to Trim the image
                Process p1 = pb1.start();
                BufferedReader br1 = new BufferedReader( new InputStreamReader(p1.getInputStream() ));
                String line1 = null;
                while((line1=br1.readLine())!=null){
                    System.out.println(line1);
                }
            }catch(Exception e) {
                return false;
            }
          /*  try {  // Text Cleaning command to Trim the image
                Process p2 = pb1.start();
                BufferedReader br2 = new BufferedReader( new InputStreamReader(p2.getInputStream() ));
                String line2 = null;
                while((line2=br2.readLine())!=null){
                    System.out.println(line2);
                }
            }catch(Exception e) {
                return false;
            }  */
            try {  // Text Cleaning command to Trim the image
                Process p3 = pb2.start();
                BufferedReader br3 = new BufferedReader( new InputStreamReader(p3.getInputStream() ));
                String line2 = null;
                while((line2=br3.readLine())!=null){
                    System.out.println(line2);
                }
            }catch(Exception e) {
                return false;
            }


            File file5 = new File("/home/palm_tree/Downloads/OCR/ttt.jpg");
            FileInputStream imageInFile5 = new FileInputStream(file5);
            byte imageData5[] = new byte[(int) file5.length()];
            imageInFile5.read(imageData5);
            // Converting Image byte array into Base64 String
            String image = com.sun.org.apache.xerces.internal.impl.dv.util.Base64.encode(imageData5);

            System.out.println(extractFieldValueUsingTemplate(image,"doctype"));
        }

        return true;   }







//---------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------







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
        System.out.println(first + "--------------" + last);
        Set<String> label = TextAndPosition.keySet();
        for (String labels:label)
        {
            if (labels.contains(first))
            {   left_Top_X_Pos = TextAndPosition.get(first).left_Top_X_Pos -30;
                left_Top_Y_Pos = TextAndPosition.get(first).left_Top_Y_Pos -10;}
            if (labels.contains(last))
            {   right_Bottom_X_Pos = TextAndPosition.get(last).right_Bottom_X_Pos +40;
                right_Bottom_Y_Pos = TextAndPosition.get(last).right_Bottom_Y_Pos +10;}
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
                            //.addFeatures(Feature.newBuilder().setType(Type.DOCUMENT_TEXT_DETECTION).build())
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

    private HashMap rotation_extractTextsAndLocation(String image) {
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
                    .addFeatures(Feature.newBuilder().setType(Type.DOCUMENT_TEXT_DETECTION).build())
                            //  .addFeatures(Feature.newBuilder().setType(Type.TEXT_DETECTION).build())
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
}


class TextFieldArea
{
    float left_Top_X_Pos,right_Top_X_Pos,left_Bottom_X_Pos, right_Bottom_X_Pos,
            left_Top_Y_Pos,right_Top_Y_Pos,left_Bottom_Y_Pos, right_Bottom_Y_Pos;
    public TextFieldArea(float left_Top_X_Pos, float left_Top_Y_Pos, float right_Top_X_Pos,
                         float right_Top_Y_Pos, float right_Bottom_X_Pos, float right_Bottom_Y_Pos,
                         float left_Bottom_X_Pos, float left_Bottom_Y_Pos)
    {
        this.left_Top_X_Pos = left_Top_X_Pos;
        this.left_Top_Y_Pos = left_Top_Y_Pos;
        this.right_Top_X_Pos = right_Top_X_Pos;
        this.right_Top_Y_Pos = right_Top_Y_Pos;
        this.right_Bottom_X_Pos = right_Bottom_X_Pos;
        this.right_Bottom_Y_Pos = right_Bottom_Y_Pos;
        this.left_Bottom_X_Pos = left_Bottom_X_Pos;
        this.left_Bottom_Y_Pos = left_Bottom_Y_Pos;
    }
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



//     with localimage  "---ImageExpire---"
 /*     BufferedImage expireimage = ImageIO.read(new File("/home/palm_tree/Downloads/sharpeningcommon/quality100/v22.jpg"));
        ByteArrayOutputStream expirebaos = new ByteArrayOutputStream();
        ImageIO.write(expireimage,"jpg",expirebaos);
        byte [] expire = expirebaos.toByteArray();
        analyser.isImageExpire(expire);                     */


   /*
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

              */


/*   public static boolean resizeImage(String input_img_path, String quality, String size, String output_img_path)
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
        return true;   } */

   /* private void Resize(String template_image, String image, HashMap<String, String> inputHashMap)  throws IOException {
        //To change body of created methods use File | Settings | File Templates.
        float x1=0;             float x2=0;
        float y1=0;             float y2=0;
        float X;                float Y;

        String image_path = "/home/palm_tree/Downloads/OCR/ttt.jpg"; //we gaved manuall path
        String convert_path = "/usr/bin/convert-im6";
        String textcleaner_path = "/usr/local/bin/textcleaner";
        HashMap<String,TextFieldArea> TemplateHM = extractTextsAndLocation(template_image);
        HashMap<String, TextFieldArea> inputImageHM = extractTextsAndLocation(image);
        TextFieldArea template_textfieldArea= null;
        TextFieldArea inputimage_textfieldArea = null;
        Set<String> key_template = inputHashMap.keySet();
        Set<String> Key_Resize = inputImageHM.keySet();
        Set<String> template_key_from_image = TemplateHM.keySet();
        String label = "  " ;
        Iterator it = inputHashMap.entrySet().iterator();
        float template_Top_x1 = 0;
        float template_Top_y1 =0;
        float template_Bottom_x1=0;
        float template_Bottom_y1 =0;
        float input_image_Top_x1 =0;
        float input_image_Top_y1 =0;
        float input_image_Bottom_x1=0;
        float input_image_Bottom_y1=0;
        float Difference_Top_X1= 0;
        float Difference_Top_Y1 =0;
        float Difference_Bottom_X2= 0;
        float Difference_Bottom_Y2 =0;
        while ((it.hasNext()))   // iterating the inputhashmap
        {
            Map.Entry entry = (Map.Entry) it.next();
            String key = (String) entry.getKey();

            for(String template_lable:template_key_from_image)    // getting template image label and points
            {

                if(key.equals(template_lable))
                {
                    template_textfieldArea = (TextFieldArea) TemplateHM.get(template_lable);

                    template_Top_x1 = template_textfieldArea.left_Top_X_Pos;
                    template_Top_y1 = template_textfieldArea.left_Top_Y_Pos;
                    template_Bottom_x1 = template_textfieldArea.right_Bottom_X_Pos;
                    template_Bottom_y1 = template_textfieldArea.right_Bottom_Y_Pos;

                    System.out.println("Template_label points------------" + template_lable + "------" + template_Top_x1+ "------------" + template_Top_y1);

                }
            }
            for(String input_image_label :Key_Resize)
            {
                if(key.equals(input_image_label))
                {
                    inputimage_textfieldArea =  inputImageHM.get(input_image_label);

                    input_image_Top_x1 = inputimage_textfieldArea.left_Top_X_Pos;
                    input_image_Top_y1 = inputimage_textfieldArea.left_Top_Y_Pos;
                    input_image_Bottom_x1 = inputimage_textfieldArea.right_Bottom_X_Pos;
                    input_image_Bottom_y1 = inputimage_textfieldArea.right_Bottom_Y_Pos;
                    System.out.println("Input_image_label points-------------" + input_image_label + "--------------" + input_image_Top_x1 + "------------" + input_image_Top_y1);


                }
            }
            Difference_Top_X1 = input_image_Top_x1-template_Top_x1;
            Difference_Top_Y1 = input_image_Top_y1 - template_Top_y1;
            Difference_Bottom_X2 = input_image_Bottom_x1-template_Bottom_x1;
            Difference_Bottom_Y2 = input_image_Bottom_y1-template_Bottom_y1;
            System.out.println("Difference_Top_x_and_y_values" + Difference_Top_X1 + "-------" + Difference_Top_Y1);
            System.out.println("Difference_Bottom_x_and_y_values" +Difference_Bottom_X2 + "--------" + Difference_Bottom_Y2);

            //   System.out.println(extractFieldValueUsingTemplate(image,"wuywe"));

        }
    }  */


