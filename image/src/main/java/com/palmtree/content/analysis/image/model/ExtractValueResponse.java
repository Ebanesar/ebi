package com.palmtree.content.analysis.image.model;

import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: palm_tree
 * Date: 12/10/17
 * Time: 4:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class ExtractValueResponse {

    String sample;

    public String isSample()
    {
        return sample;
    }

    public void setSample (String samples)
    {
        sample = samples;
    }
}
