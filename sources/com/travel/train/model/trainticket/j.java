package com.travel.train.model.trainticket;

import java.io.Serializable;

public interface j extends Serializable {
    public static final int TYPE_EDIT_TAG = 3;
    public static final int TYPE_FIXED_CONTACT_TAG = 1;
    public static final int TYPE_FIXED_EMAIL_TAG = 2;
    public static final int TYPE_GENERIC_FIXED_TAG = 4;

    int getType();
}
