package net.one97.paytm.common.entity;

public class CJRAadharPanDocList implements IJRDataModel {
    private String docCode;
    private String docValue;
    private String editableAction;
    private String editableActionMsg;
    private String submittedAs;

    public String getEditableAction() {
        return this.editableAction;
    }

    public void setEditableAction(String str) {
        this.editableAction = str;
    }

    public String getEditableActionMsg() {
        return this.editableActionMsg;
    }

    public void setEditableActionMsg(String str) {
        this.editableActionMsg = str;
    }

    public String getDocCode() {
        return this.docCode;
    }

    public void setDocCode(String str) {
        this.docCode = str;
    }

    public String getSubmittedAs() {
        return this.submittedAs;
    }

    public void setSubmittedAs(String str) {
        this.submittedAs = str;
    }

    public String getDocValue() {
        return this.docValue;
    }

    public void setDocValue(String str) {
        this.docValue = str;
    }
}
