package net.one97.paytm.nativesdk.common.model;

public class UpiConsentResponse implements BaseDataModel {
    private String respCode;
    private String respMessage;
    private String seqNo;
    private String status;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getSeqNo() {
        return this.seqNo;
    }

    public void setSeqNo(String str) {
        this.seqNo = str;
    }

    public String getRespMessage() {
        return this.respMessage;
    }

    public void setRespMessage(String str) {
        this.respMessage = str;
    }

    public String getRespCode() {
        return this.respCode;
    }

    public void setRespCode(String str) {
        this.respCode = str;
    }

    public String toString() {
        return "status:" + this.status + ",respCode:" + this.respCode;
    }
}
