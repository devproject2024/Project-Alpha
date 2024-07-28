package net.one97.paytm.upi.common.upi;

import com.google.gson.a.c;
import java.util.ArrayList;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public class PendingRequestsV2 implements UpiBaseDataModel {
    @c(a = "pendingList")
    private ArrayList<UpiPendingRequestModel> mPendingRequests;
    @c(a = "respCode")
    private String respCode;
    @c(a = "respMessage")
    private String respMessage;
    @c(a = "seqNo")
    private String seqNo;
    @c(a = "status")
    private String status;

    public ArrayList<UpiPendingRequestModel> getPendingRequests() {
        return this.mPendingRequests;
    }

    public String getStatus() {
        return this.status;
    }

    public String getRespCode() {
        return this.respCode;
    }

    public String getRespMessage() {
        return this.respMessage;
    }
}
