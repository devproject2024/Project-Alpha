package net.one97.paytm.p2mNewDesign.entity;

import android.view.View;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public class CardDetailsV2 extends CJRWalletDataModel implements IJRDataModel {
    InstrumentInfo instrumentInfo;
    View view;

    public CardDetailsV2(InstrumentInfo instrumentInfo2, View view2) {
        this.instrumentInfo = instrumentInfo2;
        this.view = view2;
    }

    public InstrumentInfo getInstrumentInfo() {
        return this.instrumentInfo;
    }

    public View getView() {
        return this.view;
    }
}
