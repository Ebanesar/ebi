package com.palmtree.content.analysis.image;

import com.palmtree.content.analysis.image.model.*;
import com.palmtree.content.analysis.image.model.ImageDetectLandmarkResponse;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(value = "/imageValidity", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<ImageValidityResponse> isImageValid(@RequestParam String imageURI) {
        boolean isValid = contentAnalyser.isValidImage(imageURI);
        ImageValidityResponse response = new ImageValidityResponse();
        response.setValid(isValid);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/safeImage", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<ImageSafetyResponse> isImageSafe(@RequestParam String imageURI) {
        boolean isSafe = contentAnalyser.isImageSafe(imageURI);
        ImageSafetyResponse response = new ImageSafetyResponse();
        response.setSafe(isSafe);
        return ResponseEntity.ok(response);
    }

  /*  @RequestMapping(value = "/detectLogos", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<ImageLogoResponse> isLogoValid(@RequestParam String imageURI) {
        List<String> detectedLogos = contentAnalyser.detectLogos(imageURI);
        ImageLogoResponse response = new ImageLogoResponse();

        response.setDetectedLogos(detectedLogos);

        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/detectLandmarks", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<ImageLandmarkResponse> isLandmarkValid(@RequestParam String imageURI) {
        List<String> landMarksDetected = contentAnalyser.detectLandmarks(imageURI);
        ImageLandmarkResponse response = new ImageLandmarkResponse();

        response.setDetectedLandmarks(landMarksDetected);

        return ResponseEntity.ok(response);
    }     */


    @CrossOrigin
    @RequestMapping(value = "/generateTemplate", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<Boolean> generateTemplateResponseResponseEntity(@RequestParam("file") MultipartFile imageContent, HashMap<String, String> stringMap, String docType) {
        System.out.println("The request is received");
       boolean response = true;
        try {
            response = contentAnalyser.generateTemplate(imageContent.getBytes(),stringMap,docType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(response);
    }







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





}































