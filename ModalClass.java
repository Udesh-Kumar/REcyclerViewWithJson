package com.example.cc.recyclerviewwithjson;

import com.google.gson.annotations.SerializedName;

import javax.xml.transform.Source;

public class ModalClass {
    @SerializedName("title")
    private String title;

    @SerializedName("image")
    private String imageUrl;

//    public ModalClass(String title, String imageUrl) {
//        this.title = title;
//        this.imageUrl = imageUrl;
//    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
