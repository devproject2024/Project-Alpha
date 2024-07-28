package net.one97.paytm.P2B;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRNotifyBankResponse extends IJRPaytmDataModel {
    @b(a = "respCode")
    private String respCode;
    @b(a = "respMessage")
    private String respMessage;
    @b(a = "seqNo")
    private String seqNo;
    @b(a = "status")
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
}
