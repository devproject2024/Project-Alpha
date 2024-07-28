package net.one97.paytm.model;

import com.google.gsonhtcfix.a.b;

public class LoanEnabledData extends IJRLoanLeadData {
    @b(a = "data")
    private a data;

    public class a {
        @b(a = "isEnabled")

        /* renamed from: a  reason: collision with root package name */
        public boolean f53515a;
    }

    public a getData() {
        return this.data;
    }

    public void setData(a aVar) {
        this.data = aVar;
    }
}
