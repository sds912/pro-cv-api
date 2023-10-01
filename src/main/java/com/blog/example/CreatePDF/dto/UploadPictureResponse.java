package com.blog.example.CreatePDF.dto;

public class UploadPictureResponse {

   public UploadPictureResponse(String fileName){
        this.url = "../static/images/" + fileName;
    }

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
