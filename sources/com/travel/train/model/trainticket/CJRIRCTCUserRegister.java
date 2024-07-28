package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRIRCTCUserRegister extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "status")
    private a mStatus;

    public class a {
        @b(a = "result")

        /* renamed from: a  reason: collision with root package name */
        public String f27704a;
    }

    public a getStatus() {
        return this.mStatus;
    }
}
