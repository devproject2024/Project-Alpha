package net.one97.paytm.passbook.beans;

public class SubwalletTxnInfo {
    private String amount;
    private String comment;
    private String gvType;
    private String senderName;
    private String senderPhoneNumber;
    private String state;

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public String getSenderPhoneNumber() {
        return this.senderPhoneNumber;
    }

    public void setSenderPhoneNumber(String str) {
        this.senderPhoneNumber = str;
    }

    public String getSenderName() {
        return this.senderName;
    }

    public void setSenderName(String str) {
        this.senderName = str;
    }

    public String getGvType() {
        return this.gvType;
    }

    public void setGvType(String str) {
        this.gvType = str;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String str) {
        this.state = str;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String str) {
        this.comment = str;
    }

    public String toString() {
        return "ClassPojo [amount = " + this.amount + ", senderPhoneNumber = " + this.senderPhoneNumber + ", senderName = " + this.senderName + ", gvType = " + this.gvType + ", state = " + this.state + ", comment = " + this.comment + "]";
    }
}
