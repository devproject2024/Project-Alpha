package com.paytmmall.clpartifact.modal.wishList;

import com.google.gson.a.c;
import java.io.Serializable;

public class WishListTag implements Serializable {
    @c(a = "display_name")
    private String mDisplayName;
    @c(a = "name")
    private String name;

    public String getmDisplayName() {
        return this.mDisplayName;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setmDisplayName(String str) {
        this.mDisplayName = str;
    }
}
