package com.paytmmall.clpartifact.modal.grid;

import com.google.gson.a.c;
import java.io.Serializable;

public class CJRDataSource implements Serializable {
    @c(a = "container_id")
    private String mContainerID;
    @c(a = "container_instance_id")
    private String mContainerInstanceID;
    @c(a = "list_id")
    private String mListId;
    @c(a = "type")
    private String mType;

    public String getmType() {
        return this.mType;
    }

    public void setmType(String str) {
        this.mType = str;
    }

    public String getmListId() {
        return this.mListId;
    }

    public void setmListId(String str) {
        this.mListId = str;
    }

    public String getmContainerID() {
        return this.mContainerID;
    }

    public void setmContainerID(String str) {
        this.mContainerID = str;
    }

    public String getmContainerInstanceID() {
        return this.mContainerInstanceID;
    }

    public void setmContainerInstanceID(String str) {
        this.mContainerInstanceID = str;
    }
}
