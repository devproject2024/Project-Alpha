package net.one97.paytm.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class IJRLoanLeadData extends IJRPaytmDataModel {
    @b(a = "meta")
    private a meta;

    public class a {
        @b(a = "status")

        /* renamed from: a  reason: collision with root package name */
        public String f53514a;
    }

    public a getMeta() {
        return this.meta;
    }

    public void setMeta(a aVar) {
        this.meta = aVar;
    }
}
