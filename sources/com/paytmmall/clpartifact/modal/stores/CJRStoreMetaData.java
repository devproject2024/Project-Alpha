package com.paytmmall.clpartifact.modal.stores;

import java.io.Serializable;

public class CJRStoreMetaData implements Serializable {
    private String status;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String toString() {
        return "ClassPojo [status = " + this.status + "]";
    }
}
