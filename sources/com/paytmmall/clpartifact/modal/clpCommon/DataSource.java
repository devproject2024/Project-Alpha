package com.paytmmall.clpartifact.modal.clpCommon;

import com.google.gson.a.c;
import java.io.Serializable;

public class DataSource implements Serializable {
    @c(a = "container_id")
    private Long mContainerId;
    @c(a = "container_instance_id")
    private String mContainerInstanceId;
    @c(a = "list_id")
    private Long mListId;
    @c(a = "type")
    private String mType;

    public Long getContainerId() {
        return this.mContainerId;
    }

    public void setContainerId(Long l) {
        this.mContainerId = l;
    }

    public String getContainerInstanceId() {
        return this.mContainerInstanceId;
    }

    public void setContainerInstanceId(String str) {
        this.mContainerInstanceId = str;
    }

    public Long getListId() {
        return this.mListId;
    }

    public void setListId(Long l) {
        this.mListId = l;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }
}
