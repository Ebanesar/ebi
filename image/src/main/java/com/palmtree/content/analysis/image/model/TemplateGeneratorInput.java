package com.palmtree.content.analysis.image.model;

import com.google.api.client.json.Json;
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
     HashMap labelVal;
     String docType;

    public void setImage(String image) {
        this.image = image;
    }

    public HashMap getLabelVal() {
        return labelVal;
    }

    public void setLabelVal(HashMap labelVal) {
        this.labelVal = labelVal;
    }

    public String getImage() {
        return image;
    }
    // HashMap<String,String> json_String;


    public String getDocType()
    {
        return docType;
    }
    public void setDocType(String doctype_Value)
    {
        docType = doctype_Value;
    }

    public static void main(String args[]){
        TemplateGeneratorInput input = new TemplateGeneratorInput() ;
        input.setDocType("USPassport");
        HashMap<String ,String> inputCoordinates = new HashMap<>();
        inputCoordinates.put("testlabel1","testval1");
        inputCoordinates.put("testlabel12","testval2");


        input.setLabelVal(inputCoordinates);
        input.setImage("Image");
        Gson gson = new Gson();
        System.out.println(gson.toJson(input));

    }
}


