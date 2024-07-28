package com.travel.train.model.trainticket;

import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainForgotUserId extends IJRPaytmDataModel implements IJRDataModel {
    @com.google.gsonhtcfix.a.b(a = "body")
    private a mForgotUserIdBody;
    @com.google.gsonhtcfix.a.b(a = "status")
    private b mForgotUserIsStatus;

    public class a {
        @com.google.gsonhtcfix.a.b(a = "status")

        /* renamed from: a  reason: collision with root package name */
        public String f27715a;
    }

    public class b {
        @com.google.gsonhtcfix.a.b(a = "result")

        /* renamed from: a  reason: collision with root package name */
        public String f27716a;
    }

    public b getForgotUserIsStatus() {
        return this.mForgotUserIsStatus;
    }

    public a getForgotUserIdBody() {
        return this.mForgotUserIdBody;
    }
}
