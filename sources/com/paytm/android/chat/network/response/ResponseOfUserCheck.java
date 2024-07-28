package com.paytm.android.chat.network.response;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;

public class ResponseOfUserCheck extends ResponseBase implements Serializable {
    private a data;

    public a getData() {
        return this.data;
    }

    public void setData(a aVar) {
        this.data = aVar;
    }

    public boolean isPaytmFirstUser() {
        if (getData() != null) {
            return getData().f42301a;
        }
        return false;
    }

    public String toString() {
        return super.toString() + "->ResponseOfRegister{data=" + this.data + '}';
    }

    static class a {
        @b(a = "pfuser")

        /* renamed from: a  reason: collision with root package name */
        boolean f42301a;
        @b(a = "id")

        /* renamed from: b  reason: collision with root package name */
        private long f42302b;

        /* renamed from: c  reason: collision with root package name */
        private String f42303c;

        public final String toString() {
            return "DataOfRegister{id=" + this.f42302b + ", isPaytmFirstUser=" + this.f42301a + ", name='" + this.f42303c + '\'' + '}';
        }
    }
}
