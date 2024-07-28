package net.one97.paytm.upi.common.upi;

import com.google.gson.a.c;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public class UpiProfileBaseResponseModel implements UpiBaseDataModel {
    @c(a = "respCode")
    private String respCode;
    @c(a = "respMessage")
    private String respMessage;
    @c(a = "seqNo")
    private String seqNo;
    @c(a = "status")
    private String status;

    public String getStatus() {
        return this.status;
    }

    public String getRespCode() {
        return this.respCode;
    }

    public String getRespMessage() {
        return this.respMessage;
    }

    public String getSeqNo() {
        return this.seqNo;
    }
}
