package com.example.languagehelper;

public class Words {
    private String miwokTranslation, defaultTranslation;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int imgResourceId = NO_IMAGE_PROVIDED;
    private int audioResourceId;

    public Words(String miwokTranslation, String defaultTranslation, int audioResourceId) {
        this.miwokTranslation = miwokTranslation;
        this.defaultTranslation = defaultTranslation;
        this.audioResourceId = audioResourceId;
    }

    public String getMiwokTranslation() {
        return miwokTranslation;
    }


    public String getDefaultTranslation() {
        return defaultTranslation;
    }

    public int getImgResourceId() {
        return imgResourceId;
    }

    public int getAudioResourceId() {
        return audioResourceId;
    }

    public Words(String miwokTranslation, String defaultTranslation, int imgResourceId, int audioResourceId) {
        this.miwokTranslation = miwokTranslation;
        this.defaultTranslation = defaultTranslation;
        this.imgResourceId = imgResourceId;
        this.audioResourceId  = audioResourceId;
    }
    public boolean hasImage(){
        return imgResourceId != NO_IMAGE_PROVIDED;
    }
}
