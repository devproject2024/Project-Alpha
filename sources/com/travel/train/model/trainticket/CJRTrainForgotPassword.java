package com.travel.train.model.trainticket;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainForgotPassword extends IJRPaytmDataModel implements IJRDataModel {
    @com.google.gsonhtcfix.a.b(a = "status")
    private b mForgotPasswordStatus;
    @com.google.gsonhtcfix.a.b(a = "body")
    private a mPasswordBody;

    public class a {
        @com.google.gsonhtcfix.a.b(a = "status")

        /* renamed from: a  reason: collision with root package name */
        public String f27713a;
    }

    public class b {
        @com.google.gsonhtcfix.a.b(a = "result")

        /* renamed from: a  reason: collision with root package name */
        public String f27714a;
    }

    public b getForgotPasswordStatus() {
        return this.mForgotPasswordStatus;
    }

    public a getPasswordBody() {
        return this.mPasswordBody;
    }
}
