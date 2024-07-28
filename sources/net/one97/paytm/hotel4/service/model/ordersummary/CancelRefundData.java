package net.one97.paytm.hotel4.service.model.ordersummary;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.hotels2.utils.CJRHotelsUtilsLib;

public final class CancelRefundData extends IJRPaytmDataModel {
    private String cancellationCharges;
    private String convenienceFee;
    private String refundAmount;
    private String totalAmount;

    public final String getCancellationCharges() {
        return this.cancellationCharges;
    }

    public final String getConvenienceFee() {
        return this.convenienceFee;
    }

    public final String getRefundAmount() {
        return this.refundAmount;
    }

    public final String getTotalAmount() {
        return this.totalAmount;
    }

    public final void setCancellationCharges(String str) {
        k.c(str, "<set-?>");
        this.cancellationCharges = str;
    }

    public final void setConvenienceFee(String str) {
        k.c(str, "<set-?>");
        this.convenienceFee = str;
    }

    public final void setRefundAmount(String str) {
        k.c(str, "<set-?>");
        this.refundAmount = str;
    }

    public final void setTotalAmount(String str) {
        k.c(str, "<set-?>");
        this.totalAmount = str;
    }

    public CancelRefundData(String str, String str2, String str3, String str4) {
        k.c(str, CJRQRScanResultModel.KEY_TOTAL_AMOUNT);
        k.c(str2, "refundAmount");
        k.c(str3, "cancellationCharges");
        k.c(str4, "convenienceFee");
        this.totalAmount = str;
        this.refundAmount = str2;
        this.cancellationCharges = str3;
        this.convenienceFee = str4;
    }

    public final String getFormatedPrice(String str, boolean z) {
        k.c(str, "price");
        if (z) {
            return "- ₹" + CJRHotelsUtilsLib.a(str);
        }
        return FilterPriceSliderFragment.RUPEE_SYMBOL + CJRHotelsUtilsLib.a(str);
    }
}
