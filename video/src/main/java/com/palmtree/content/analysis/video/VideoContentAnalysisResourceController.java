package com.palmtree.content.analysis.video;

import com.palmtree.content.analysis.video.model.VideoSafetyResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by kaarthikraaj on 9/8/17.
 */
@RestController
public class VideoContentAnalysisResourceController {
    VideoContentAnalyser contentAnalyser = new VideoContentAnalyser();

    @RequestMapping(value = "/safeVideo", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<VideoSafetyResponse> isVideoSafe(@RequestParam String videoURI) {
        boolean isSafe = contentAnalyser.isVideoSafe(videoURI);
        VideoSafetyResponse response = new VideoSafetyResponse();
        response.setSafe(isSafe);
        return ResponseEntity.ok(response);
    }
}
