package com.palmtree.content.analysis.image.model;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: palm_tree
 * Date: 21/10/17
 * Time: 10:06 AM
 * To change this template use File | Settings | File Templates.
 */
public class ImageDetectLogoResponse {
    List<String> detectLogos;

    public List<String> getDetectLogos()
    {
        return detectLogos;
    }
    public void setDetectLogos(List<String> logo)
    {
        detectLogos = logo;
    }

}

