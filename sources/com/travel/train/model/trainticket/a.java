package com.travel.train.model.trainticket;

import android.text.TextUtils;

public final class a implements j {
    private int color;
    private String contactName;
    private String contactNumber;
    private final String displayChar;
    private String photoUri;

    public final int getType() {
        return 1;
    }

    public a(String str, String str2) {
        this.contactName = str;
        this.contactNumber = str2;
        if (!TextUtils.isEmpty(str)) {
            this.displayChar = String.valueOf(str.charAt(0)).toUpperCase();
        } else {
            this.displayChar = String.valueOf(str2.charAt(0)).toUpperCase();
        }
    }

    public final String getContactName() {
        return this.contactName;
    }

    public final String getDisplayChar() {
        return this.displayChar;
    }

    public final String getContactNumber() {
        return this.contactNumber;
    }

    public final String getPhotoUri() {
        return this.photoUri;
    }

    public final void setPhotoUri(String str) {
        this.photoUri = str;
    }

    public final int getColor() {
        return this.color;
    }

    public final void setColor(int i2) {
        this.color = i2;
    }
}
