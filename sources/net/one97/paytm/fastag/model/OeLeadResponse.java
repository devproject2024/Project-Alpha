package net.one97.paytm.fastag.model;

import com.paytm.network.model.IJRPaytmDataModel;

public class OeLeadResponse extends IJRPaytmDataModel {
    private String displayMessage;
    private String leadId;
    private String refId;
    private String statusCode;

    public String getDisplayMessage() {
        return this.displayMessage;
    }

    public void setDisplayMessage(String str) {
        this.displayMessage = str;
    }

    public String getRefId() {
        return this.refId;
    }

    public void setRefId(String str) {
        this.refId = str;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(String str) {
        this.statusCode = str;
    }

    public String getLeadId() {
        return this.leadId;
    }

    public void setLeadId(String str) {
        this.leadId = str;
    }

    public String toString() {
        return "ClassPojo [displayMessage = " + this.displayMessage + ", refId = " + this.refId + ", statusCode = " + this.statusCode + ", leadId = " + this.leadId + "]";
    }
}
