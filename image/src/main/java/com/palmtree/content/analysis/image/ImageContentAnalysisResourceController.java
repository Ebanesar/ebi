package com.palmtree.content.analysis.image;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.palmtree.content.analysis.image.model.*;
import com.palmtree.content.analysis.image.model.ImageDetectLandmarkResponse;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kaarthikraaj on 9/8/17.
 */
@RestController
public class ImageContentAnalysisResourceController {
    ImageContentAnalyser contentAnalyser = new ImageContentAnalyser();
  /*
   @RequestMapping(value = "/imageValidity", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<ImageValidityResponse> isImageValid(@RequestParam String imageURI) {
        boolean isValid = contentAnalyser.isValidImage(imageURI);
        ImageValidityResponse response = new ImageValidityResponse();
        response.setValid(isValid);
        return ResponseEntity.ok(response);
    }
 */
  /*  @RequestMapping(value = "/safeImage", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<ImageSafetyResponse> isImageSafe(@RequestParam String imageURI) {
        boolean isSafe = contentAnalyser.isImageSafe(imageURI);
        ImageSafetyResponse response = new ImageSafetyResponse();
        response.setSafe(isSafe);
        return ResponseEntity.ok(response);
    }          */
 /*
  @CrossOrigin
    @RequestMapping(value = "/imageValidity", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<ImageValidityResponse> imageValidityResponseResponseEntity(@RequestParam("file") MultipartFile imageContent) throws IOException {
        System.out.println("The request is received");
ImageValidityResponse response = new ImageValidityResponse();
      try {
            boolean isValid =contentAnalyser.isValidImage(imageContent.getBytes());
          response.setValid(isValid);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(response);
    }

    @CrossOrigin
    @RequestMapping(value = "/safeImage", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<ImageSafetyResponse> imageSafetyResponseResponseEntity(@RequestParam("file") MultipartFile imageContent) throws IOException {
        System.out.println("The request is received");
        ImageSafetyResponse response = new ImageSafetyResponse();
        try {
            boolean isSafe =contentAnalyser.isImageSafe(imageContent.getBytes());
            response.setSafe(isSafe);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(response);
    }


    @CrossOrigin
    @RequestMapping(value = "/detectLandmarks", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<ImageDetectLandmarkResponse> imageDetectLandmarkResponseResponseEntity(@RequestParam("file") MultipartFile imageContent) throws IOException
    {   System.out.println("The request is received");
        ImageDetectLandmarkResponse response = new ImageDetectLandmarkResponse();
        try {
        List<String> landMarksDetected = contentAnalyser.detectLandmarks(imageContent.getBytes());
        response.setDetectLandmarks(landMarksDetected);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(response);
    }

    @CrossOrigin
    @RequestMapping(value = "/detectLogos", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<ImageDetectLogoResponse> imageDetectLogoResponseResponseEntity(@RequestParam("file") MultipartFile imageContent) throws IOException
    {   System.out.println("The request is received");
        ImageDetectLogoResponse response = new ImageDetectLogoResponse();
        try {
            List<String> logosDetected = contentAnalyser.detectLogos(imageContent.getBytes());
            response.setDetectLogos(logosDetected);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(response);
    }
            */
  /*     @CrossOrigin
    @RequestMapping(value = "/extractValue" , method = RequestMethod.POST)
    public  @ResponseBody
    ResponseEntity<ExtractValueResponse> extractValueResponseResponseEntity (@RequestParam("file") MultipartFile imageContent, String docType)
       {
      System.out.println("The request is received");
     ExtractValueResponse response = new ExtractValueResponse();
     try {
    String outputDetected = contentAnalyser.extractFieldValueUsingTemplate(imageContent.getBytes(), docType);
      response.setSample(outputDetected);
     } catch (IOException e)
     {
         e.printStackTrace();
     }
    return ResponseEntity.ok(response);

       }   */
  /*
    @CrossOrigin
    @RequestMapping(value = "/extractValue", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<HashMap> extractValueResponseResponseEntity(@RequestParam("file") MultipartFile imageContent, String docType) {
        System.out.println("The request is received");
      HashMap response = null;
        try {
            response =contentAnalyser.extractFieldValueUsingTemplate(imageContent.getBytes() , docType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(response);
    }
       */

   /*
   @CrossOrigin
    @RequestMapping(value = "/generateTemplate", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<GenerateTemplateResponse> generateTemplateResponseResponseEntity(@RequestParam("file") MultipartFile imageContent, HashMap<String, String> stringMap, String docType) {
        System.out.println("The request is received");
     GenerateTemplateResponse response = new GenerateTemplateResponse();
        try {
            boolean ww=contentAnalyser.generateTemplate(imageContent.getBytes(),stringMap,docType);
            response.setSample(ww);
      } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(response);
    }
    */


    @CrossOrigin
    @RequestMapping (value = "/extractvalueusingtemplate" , method =  RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<TemplateGeneratorInput> jsonObjectResponseEntity1(@RequestParam String image, String doctype) throws HttpMessageNotWritableException {

        TemplateGeneratorInput response = new TemplateGeneratorInput();
        {
            System.out.print("The Request is received");


            HashMap hashMap = contentAnalyser.extractFieldValueUsingTemplate(image, doctype);

            response.setHashmap(hashMap);


            return ResponseEntity.ok(response);
        }




}
}











