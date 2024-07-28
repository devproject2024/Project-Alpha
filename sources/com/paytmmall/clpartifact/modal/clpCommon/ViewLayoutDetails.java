package com.paytmmall.clpartifact.modal.clpCommon;

import com.google.gson.a.c;
import java.io.Serializable;

public class ViewLayoutDetails implements Serializable {
    @c(a = "open_states")
    private int state;

    public int getState() {
        return this.state;
    }

    public void setState(int i2) {
        this.state = i2;
    }
}
