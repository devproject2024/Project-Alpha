package net.one97.paytm.recharge.model.imps;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public final class CJRRefundConsultViewV8 extends IJRPaytmDataModel {
    @b(a = "iconImageUrl")
    private String bankImageUrl;
    @b(a = "destination")
    private String destination;
    @b(a = "destinationSubText")
    private String destinationSubText;
    @b(a = "destinationText")
    private String destinationText;
    @b(a = "disableReason")
    private String disableReason;
    @b(a = "disableReasonText")
    private String disableReasonText;
    @b(a = "enableStatus")
    private String enableStatus;
    @b(a = "refundAllocatedInfos")
    private List<CJRRefundAllocatedInfoV8> refundAllocatedInfos;

    public final String getDestination() {
        return this.destination;
    }

    public final void setDestination(String str) {
        this.destination = str;
    }

    public final String getDestinationText() {
        return this.destinationText;
    }

    public final void setDestinationText(String str) {
        this.destinationText = str;
    }

    public final String getDestinationSubText() {
        return this.destinationSubText;
    }

    public final void setDestinationSubText(String str) {
        this.destinationSubText = str;
    }

    public final String getEnableStatus() {
        return this.enableStatus;
    }

    public final void setEnableStatus(String str) {
        this.enableStatus = str;
    }

    public final String getDisableReason() {
        return this.disableReason;
    }

    public final void setDisableReason(String str) {
        this.disableReason = str;
    }

    public final String getDisableReasonText() {
        return this.disableReasonText;
    }

    public final void setDisableReasonText(String str) {
        this.disableReasonText = str;
    }

    public final List<CJRRefundAllocatedInfoV8> getRefundAllocatedInfos() {
        return this.refundAllocatedInfos;
    }

    public final void setRefundAllocatedInfos(List<CJRRefundAllocatedInfoV8> list) {
        this.refundAllocatedInfos = list;
    }

    public final String getBankImageUrl() {
        return this.bankImageUrl;
    }

    public final void setBankImageUrl(String str) {
        this.bankImageUrl = str;
    }
}
