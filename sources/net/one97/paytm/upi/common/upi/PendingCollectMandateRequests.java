package net.one97.paytm.upi.common.upi;

import com.google.gson.a.c;
import java.util.ArrayList;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public class PendingCollectMandateRequests implements UpiBaseDataModel {
    @c(a = "pendingTxnList")
    private ArrayList<UpiPendingRequestModel> mPendingRequests;
    @c(a = "respCode")
    private String respCode;
    @c(a = "respMessage")
    private String respMessage;
    @c(a = "status")
    private String status;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getRespCode() {
        return this.respCode;
    }

    public void setRespCode(String str) {
        this.respCode = str;
    }

    public String getRespMessage() {
        return this.respMessage;
    }

    public void setRespMessage(String str) {
        this.respMessage = str;
    }

    public ArrayList<UpiPendingRequestModel> getmPendingRequests() {
        return this.mPendingRequests;
    }

    public void setmPendingRequests(ArrayList<UpiPendingRequestModel> arrayList) {
        this.mPendingRequests = arrayList;
    }
}
