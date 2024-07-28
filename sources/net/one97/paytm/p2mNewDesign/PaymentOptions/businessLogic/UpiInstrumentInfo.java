package net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic;

import net.one97.paytm.p2mNewDesign.entity.InstrumentInfo;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public class UpiInstrumentInfo extends InstrumentInfo {
    private UpiBaseDataModel upiDataModel;

    public UpiBaseDataModel getUpiDataModel() {
        return this.upiDataModel;
    }

    public void setUpiDataModel(UpiBaseDataModel upiBaseDataModel) {
        this.upiDataModel = upiBaseDataModel;
    }
}
