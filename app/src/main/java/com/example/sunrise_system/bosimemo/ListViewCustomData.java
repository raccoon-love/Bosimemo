package com.example.sunrise_system.bosimemo;

import android.graphics.Bitmap;

/**
 * Created by sunrise-system on 2016/10/14.
 */

public class ListViewCustomData {

    private Bitmap imageData_;
    private String textData_;
    private String textData2_;

    public void setImagaData(Bitmap image) {
        imageData_ = image;
    }

    public Bitmap getImageData() {
        return imageData_;
    }

    public void setTextData(String text) {
        textData_ = text;
    }

    public String getTextData() {
        return textData_;
    }

    public void setTextData2(String text2) {
        textData2_ = text2;
    }

    public String getTextData2() {
        return textData2_;
    }
}


