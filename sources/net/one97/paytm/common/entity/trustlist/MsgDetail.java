package net.one97.paytm.common.entity.trustlist;

public class MsgDetail {
    private String SMSGenerationDatetime;
    private String SMSMask;
    private String maskedMobileNo;
    private String message;
    private String occurTime;
    private String scenario;
    private String sender;

    public String toString() {
        return " message " + this.message + " sender " + this.sender + " occurTime " + this.occurTime + " SMSGenerationDatetime " + this.SMSGenerationDatetime + " scenario " + this.scenario + " SMSMask " + this.SMSMask;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getSender() {
        return this.sender;
    }

    public void setSender(String str) {
        this.sender = str;
    }

    public String getOccurTime() {
        return this.occurTime;
    }

    public void setOccurTime(String str) {
        this.occurTime = str;
    }

    public String getSMSGenerationDatetime() {
        return this.SMSGenerationDatetime;
    }

    public void setSMSGenerationDatetime(String str) {
        this.SMSGenerationDatetime = str;
    }

    public String getScenario() {
        return this.scenario;
    }

    public void setScenario(String str) {
        this.scenario = str;
    }

    public String getSMSMask() {
        return this.SMSMask;
    }

    public void setSMSMask(String str) {
        this.SMSMask = str;
    }

    public String getMaskedMobileNo() {
        return this.maskedMobileNo;
    }

    public void setMaskedMobileNo(String str) {
        this.maskedMobileNo = str;
    }
}
