package com.palmtree.content.analysis.image.model;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: palm_tree
 * Date: 12/10/17
 * Time: 4:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class ExtractValueResponse {

    HashMap<String,String> stringHashMap;

    public HashMap<String,String>  getStringHashMap()
    {
        return stringHashMap;
    }
    public void setStringHashMap(HashMap<String,String> output)
    {
        stringHashMap=output;
    }
}
