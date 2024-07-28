package net.one97.paytm.upi.common.models;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public class UpiExpireSmsTokenModel implements UpiBaseDataModel {
    @b(a = "respCode")
    private String mResponseCode;
    @b(a = "respMessage")
    private String mResponseMessage;
    @b(a = "seqNo")
    private String mSeqNo;
    @b(a = "status")
    private String mStatus;

    public String getStatus() {
        return this.mStatus;
    }

    public void setStatus(String str) {
        this.mStatus = str;
    }

    public String getResponseCode() {
        return this.mResponseCode;
    }

    public void setResponseCode(String str) {
        this.mResponseCode = str;
    }

    public String getResponseMessage() {
        return this.mResponseMessage;
    }

    public void setResponseMessage(String str) {
        this.mResponseMessage = str;
    }

    public String getSeqNo() {
        return this.mSeqNo;
    }

    public void setSeqNo(String str) {
        this.mSeqNo = str;
    }
}
