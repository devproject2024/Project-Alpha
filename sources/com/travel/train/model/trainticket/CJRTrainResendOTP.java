package com.travel.train.model.trainticket;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainResendOTP extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @com.google.gsonhtcfix.a.b(a = "status")
    private b ResendStatus;
    @com.google.gsonhtcfix.a.b(a = "body")
    private a mOTPDetails;

    public class a {
        @com.google.gsonhtcfix.a.b(a = "status")

        /* renamed from: a  reason: collision with root package name */
        public String f27721a;
    }

    public class b {
        @com.google.gsonhtcfix.a.b(a = "result")

        /* renamed from: a  reason: collision with root package name */
        public String f27722a;
    }

    public b getResendStatus() {
        return this.ResendStatus;
    }

    public a getOTPDetails() {
        return this.mOTPDetails;
    }
}
