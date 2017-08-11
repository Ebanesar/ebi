package com.palmtree.content.analysis.image;

import com.palmtree.content.analysis.image.model.ImageValidityResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by kaarthikraaj on 9/8/17.
 */
@RestController
public class ImageContentAnalysisResourceController {
    ImageContentAnalyser contentAnalyser = new ImageContentAnalyser();

    @RequestMapping(value = "/imageValidity", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<ImageValidityResponse> isImageValid(@RequestParam String imageURI) {
        boolean isValid = contentAnalyser.isValidImage(imageURI);
        ImageValidityResponse response = new ImageValidityResponse();
        response.setValid(isValid);
        return ResponseEntity.ok(response);
    }
}
