package com.paytmmall.clpartifact.modal.clpCommon;

import com.google.gson.a.c;
import java.io.Serializable;

public class ViewDataSource implements Serializable {
    @c(a = "container_id")
    private String containerId;
    @c(a = "container_instance_id")
    private String containerInstanceId;
    @c(a = "list_id")
    private String listId;
    @c(a = "type")
    private String type;

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getListId() {
        return this.listId;
    }

    public void setListId(String str) {
        this.listId = str;
    }

    public String getContainerId() {
        return this.containerId;
    }

    public void setContainerId(String str) {
        this.containerId = str;
    }

    public String getContainerInstanceId() {
        return this.containerInstanceId;
    }

    public void setContainerInstanceId(String str) {
        this.containerInstanceId = str;
    }
}
