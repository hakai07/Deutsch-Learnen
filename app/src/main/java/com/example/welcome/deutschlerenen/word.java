package com.example.welcome.deutschlerenen;

public class word {
    private String germanTranslate;
    private String EngTranslate;
    private int audioResourceId;

    public word(String engTranslate, String germanTranslate,int aResourceId) {
        EngTranslate = engTranslate;
        this.germanTranslate = germanTranslate;
        audioResourceId = aResourceId;
    }

    public String getgermanTranslate() {
        return germanTranslate;
    }

    public String getEngTranslate() {
        return EngTranslate;
    }

    public int getAudioResourceId(){
        return audioResourceId;
    }
}

