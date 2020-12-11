package com.example.wastesortingapp;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties

public class FirebasePost {

    public String id;
    public String pwd;

    public FirebasePost(){

    }

    public FirebasePost(String id, String pwd){
        this.id = id;
        this.pwd = pwd;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("id", id);
        result.put("pw", pwd);
        return result;
    }
}
