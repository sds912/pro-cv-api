package com.blog.example.CreatePDF.dto;

public class Avatar {

    private String localUrl;
    private String remoteUrl;

    public String getLocalUrl() {
        return localUrl;
    }

    public void setLocalUrl(String localUrl) {
        this.localUrl = localUrl;
    }

    public String getRemoteUrl() {
        return remoteUrl;
    }

    public void setRemoteUrl(String remoteUrl) {
        this.remoteUrl = remoteUrl;
    }

    @Override
    public String toString() {
        return "Avatar{" +
                "localUrl='" + localUrl + '\'' +
                ", remoteUrl='" + remoteUrl + '\'' +
                '}';
    }
}
