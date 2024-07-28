package net.one97.paytm.paymentsBank.model.slfd;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public final class SlfdListModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "fd_list")
    private ArrayList<SlfdModel> fdList;
    @b(a = "message")
    private String message;
    @b(a = "response_code")
    private int responseCode;
    @b(a = "status")
    private String status;
    @b(a = "txn_id")
    private String txnId;

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final int getResponseCode() {
        return this.responseCode;
    }

    public final void setResponseCode(int i2) {
        this.responseCode = i2;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getTxnId() {
        return this.txnId;
    }

    public final void setTxnId(String str) {
        this.txnId = str;
    }

    public final ArrayList<SlfdModel> getFdList() {
        return this.fdList;
    }

    public final void setFdList(ArrayList<SlfdModel> arrayList) {
        this.fdList = arrayList;
    }
}
