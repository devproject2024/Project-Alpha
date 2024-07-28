package net.one97.paytm.common.entity.busticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;

public final class CJRBusRefundModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "refund_initiated")
    private boolean refundInitiated;
    @b(a = "status")
    private String status;
    @b(a = "status_text")
    private String statusText;
    @b(a = "total")
    private String total;
    @b(a = "transaction_details")
    private List<CJRBusTransactionModel> transactionDetails;
    @b(a = "userCreditInitiateTimestamp")
    private String userCreditInitiateTimeStamp;

    public final String getStatusText() {
        return this.statusText;
    }

    public final void setStatusText(String str) {
        k.c(str, "<set-?>");
        this.statusText = str;
    }

    public final List<CJRBusTransactionModel> getTransactionDetails() {
        return this.transactionDetails;
    }

    public final void setTransactionDetails(List<CJRBusTransactionModel> list) {
        k.c(list, "<set-?>");
        this.transactionDetails = list;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        k.c(str, "<set-?>");
        this.status = str;
    }

    public final boolean getRefundInitiated() {
        return this.refundInitiated;
    }

    public final void setRefundInitiated(boolean z) {
        this.refundInitiated = z;
    }

    public final String getTotal() {
        return this.total;
    }

    public final void setTotal(String str) {
        k.c(str, "<set-?>");
        this.total = str;
    }

    public CJRBusRefundModel(String str, List<CJRBusTransactionModel> list, String str2, boolean z, String str3, String str4) {
        k.c(str, ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_TEXT);
        k.c(list, "transactionDetails");
        k.c(str2, "status");
        k.c(str3, "total");
        k.c(str4, "userCreditInitiateTimeStamp");
        this.statusText = str;
        this.transactionDetails = list;
        this.status = str2;
        this.refundInitiated = z;
        this.total = str3;
        this.userCreditInitiateTimeStamp = str4;
    }

    public final String getUserCreditInitiateTimeStamp() {
        return this.userCreditInitiateTimeStamp;
    }

    public final void setUserCreditInitiateTimeStamp(String str) {
        k.c(str, "<set-?>");
        this.userCreditInitiateTimeStamp = str;
    }
}
