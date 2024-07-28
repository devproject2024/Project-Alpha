package net.one97.paytm.common.entity.shopping;

import com.paytm.network.model.IJRPaytmDataModel;

public class TemplateData extends IJRPaytmDataModel {
    private String ord_bookingMsg;
    private String ord_confirmMsg;
    private String ord_enableQR_Code;
    private String ord_enableRedemption;
    private String ord_enableShortCode;
    private String ord_redemptionText;

    public String getOrd_confirmMsg() {
        return this.ord_confirmMsg;
    }

    public String getOrd_bookingMsg() {
        return this.ord_bookingMsg;
    }

    public String getOrd_redemptionText() {
        return this.ord_redemptionText;
    }

    public String getOrd_enableRedemption() {
        return this.ord_enableRedemption;
    }

    public String getOrd_enableShortCode() {
        return this.ord_enableShortCode;
    }

    public String getOrd_enableQR_Code() {
        return this.ord_enableQR_Code;
    }
}
