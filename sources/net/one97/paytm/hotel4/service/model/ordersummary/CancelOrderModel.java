package net.one97.paytm.hotel4.service.model.ordersummary;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;

public final class CancelOrderModel extends IJRPaytmDataModel {
    private String code;
    private CancelRefundData data;
    private String message;

    public CancelOrderModel() {
        this((String) null, (String) null, (CancelRefundData) null, 7, (g) null);
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final String getCode() {
        return this.code;
    }

    public final void setCode(String str) {
        this.code = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CancelOrderModel(String str, String str2, CancelRefundData cancelRefundData, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : cancelRefundData);
    }

    public final CancelRefundData getData() {
        return this.data;
    }

    public final void setData(CancelRefundData cancelRefundData) {
        this.data = cancelRefundData;
    }

    public CancelOrderModel(String str, String str2, CancelRefundData cancelRefundData) {
        this.message = str;
        this.code = str2;
        this.data = cancelRefundData;
    }
}
