package net.one97.paytm.fastag.model;

public class SolutionDocuments {
    private String docProvided;
    private String docType;
    private String docUUID;

    public String getDocType() {
        return this.docType;
    }

    public void setDocType(String str) {
        this.docType = str;
    }

    public String getDocUUID() {
        return this.docUUID;
    }

    public void setDocUUID(String str) {
        this.docUUID = str;
    }

    public String getDocProvided() {
        return this.docProvided;
    }

    public void setDocProvided(String str) {
        this.docProvided = str;
    }

    public String toString() {
        return "ClassPojo [docType = " + this.docType + ", docUUID = " + this.docUUID + ", docProvided = " + this.docProvided + "]";
    }
}
