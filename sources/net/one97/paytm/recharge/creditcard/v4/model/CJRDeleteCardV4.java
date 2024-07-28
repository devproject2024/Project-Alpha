package net.one97.paytm.recharge.creditcard.v4.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRDeleteCardV4 extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "info")
    private a info;
    @b(a = "message")
    private String message;
    @b(a = "code")
    private String status;

    public final class a {
        @b(a = "message")

        /* renamed from: a  reason: collision with root package name */
        public String f62624a;
        @b(a = "deletionStatus")

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<Object> f62625b;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final a getInfo() {
        return this.info;
    }

    public final void setInfo(a aVar) {
        this.info = aVar;
    }
}
