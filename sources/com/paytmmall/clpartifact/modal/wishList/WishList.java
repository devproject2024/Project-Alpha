package com.paytmmall.clpartifact.modal.wishList;

import com.google.gson.a.c;
import java.io.Serializable;
import java.util.ArrayList;

public class WishList implements Serializable {
    @c(a = "message")
    private String mMessage;
    @c(a = "items")
    private ArrayList<WishListProduct> mProduct;

    public String getmMessage() {
        return this.mMessage;
    }

    public ArrayList<WishListProduct> getmProduct() {
        return this.mProduct;
    }
}
