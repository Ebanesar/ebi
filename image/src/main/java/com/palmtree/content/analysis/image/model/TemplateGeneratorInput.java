package com.palmtree.content.analysis.image.model;

import com.google.gson.Gson;

import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: palm_tree
 * Date: 24/10/17
 * Time: 3:18 PM
 * To change this template use File | Settings | File Templates.
 **/

public class TemplateGeneratorInput {

     String image;
     HashMap outputHashmap;
     String docType;
    String  json_String;
    // HashMap<String,String> json_String;

    public String getHashmap()
    {

        return json_String;
    }
    public void setHashmap(HashMap<String,String> incomingHashmap)
    {     Gson gson = new Gson();
        json_String = gson.toJson(incomingHashmap);
      //    outputHashmap = json_String;
   }
    public String getImage()
    {
        return image;
    }
    public void SetImage(String image_value)
    {
        image = image_value;
    }
    public String getDocType()
    {
        return docType;
    }
    public void setDocType(String doctype_Value)
    {
        docType = doctype_Value;
    }
}


