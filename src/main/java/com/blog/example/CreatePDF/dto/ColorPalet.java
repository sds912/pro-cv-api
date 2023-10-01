package com.blog.example.CreatePDF.dto;

public class ColorPalet {
    private String primary;
    private String secondary;
    private String muted;

    public String getPrimary() {
        return primary;
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }

    public String getSecondary() {
        return secondary;
    }

    public void setSecondary(String secondary) {
        this.secondary = secondary;
    }

    public String getMuted() {
        return muted;
    }

    public void setMuted(String muted) {
        this.muted = muted;
    }

    @Override
    public String toString() {
        return "ColorPalet{" +
                "primary='" + primary + '\'' +
                ", secondary='" + secondary + '\'' +
                ", muted='" + muted + '\'' +
                '}';
    }
}
