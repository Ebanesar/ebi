package com.palmtree.content.analysis.image.model;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: palm_tree
 * Date: 12/10/17
 * Time: 3:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class ImageDetectLandmarkResponse {
    List<String> detectLandmarks;

    public List<String> getDetectLandmarks()
    {
        return detectLandmarks;
    }
   public void setDetectLandmarks(List<String> landmark)
   {
       detectLandmarks = landmark;
   }

}
