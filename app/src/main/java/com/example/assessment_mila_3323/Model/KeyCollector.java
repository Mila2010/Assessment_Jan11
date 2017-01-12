package com.example.assessment_mila_3323.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Millochka on 1/11/17.
 */

public class KeyCollector {
    boolean success;

    @SerializedName("available keys")
    ArrayList<Keys> available_keys;

    public boolean isSuccess() {
        return success;
    }

    public ArrayList<Keys> getAvailable_keys() {
        return available_keys;
    }
}
