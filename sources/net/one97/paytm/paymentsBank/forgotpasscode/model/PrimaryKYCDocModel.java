package net.one97.paytm.paymentsBank.forgotpasscode.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class PrimaryKYCDocModel extends IJRPaytmDataModel implements IJRDataModel {
    @com.google.gsonhtcfix.a.a
    @b(a = "error")
    private a error;
    @com.google.gsonhtcfix.a.a
    @b(a = "primaryDocument")
    private String primaryDocument;

    public class a {
        @com.google.gsonhtcfix.a.a
        @b(a = "errorMsg")

        /* renamed from: a  reason: collision with root package name */
        public String f18391a;
    }

    public a getError() {
        return this.error;
    }

    public void setError(a aVar) {
        this.error = aVar;
    }

    public String getPrimaryDocument() {
        return this.primaryDocument;
    }

    public void setPrimaryDocument(String str) {
        this.primaryDocument = str;
    }
}
