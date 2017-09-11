package com.palmtree.content.analysis.video;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.junit.Assert;

/**
 * Created by kaarthikraaj on 5/9/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)

@WebAppConfiguration
public class VideoContentAnalysisTest {
    VideoContentAnalyser videoContentAnalyser = new VideoContentAnalyser();

    @Test
 /*  public void testMurderVideoForSafety(){
        boolean safe = videoContentAnalyser.isVideoSafe("gs://staging.palmtree-videocontentanalysis.appspot.com/video/kiss.mp4");
        Assert.assertTrue(safe);

    }
    public void testViolent1VideoForSafety(){
        boolean safe = videoContentAnalyser.isVideoSafe("gs://staging.palmtree-videocontentanalysis.appspot.com/video/violent1.mp4");
        Assert.assertTrue(safe);
    }
    public void testCartoonVideoForSafety(){
        boolean safe = videoContentAnalyser.isVideoSafe("gs://staging.palmtree-videocontentanalysis.appspot.com/video/cartoonv.mp4");
        Assert.assertTrue(safe);
    }
    public void testKillerVideoForSafety() {
        boolean safe = videoContentAnalyser.isVideoSafe("gs://staging.palmtree-videocontentanalysis.appspot.com/video/killer.mp4");
        Assert.assertFalse(safe);
    } */
   public void testBikeVideoForSafety(){
        boolean safe = videoContentAnalyser.isVideoSafe("gs://staging.palmtree-videocontentanalysis.appspot.com/video/bike.mp4");
        Assert.assertTrue(safe);
    }
}
