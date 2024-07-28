package easypay.entity;

import com.google.gson.a.c;
import java.io.Serializable;

public class Operation implements Serializable {
    @c(a = "actionMetadata")
    private String actionMetadata;
    @c(a = "actionType")
    private String actionType;
    @c(a = "jsTemplate")
    private String jsTemplate;

    public String getJsTemplate() {
        return this.jsTemplate;
    }

    public void setJsTemplate(String str) {
        this.jsTemplate = str;
    }

    public String getActionType() {
        return this.actionType;
    }

    public void setActionType(String str) {
        this.actionType = str;
    }

    public String getActionMetadata() {
        return this.actionMetadata;
    }

    public void setActionMetadata(String str) {
        this.actionMetadata = str;
    }
}
