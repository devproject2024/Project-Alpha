package net.one97.paytm.fastag.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRRefundConsultView extends IJRPaytmDataModel {
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

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String str) {
        this.destination = str;
    }

    public String getEnableStatus() {
        return this.enableStatus;
    }

    public void setEnableStatus(String str) {
        this.enableStatus = str;
    }

    public String getDisableReason() {
        return this.disableReason;
    }

    public void setDisableReason(String str) {
        this.disableReason = str;
    }

    public String getDisableReasonText() {
        return this.disableReasonText;
    }

    public void setDisableReasonText(String str) {
        this.disableReasonText = str;
    }

    public String getDestinationSubText() {
        return this.destinationSubText;
    }

    public void setDestinationSubText(String str) {
        this.destinationSubText = str;
    }

    public String getDestinationText() {
        return this.destinationText;
    }

    public void setDestinationText(String str) {
        this.destinationText = str;
    }
}
