package com.business.merchant_payments.notificationsettings.model;

import android.text.TextUtils;
import com.business.common_module.f.a;
import com.google.gson.a.c;

public class MerchantProfileResponse extends a {
    public static final long serialVersionUID = 1;
    @c(a = "STATUS")
    public String STATUS;
    @c(a = "DATA")
    public Data data;
    @c(a = "pennyDropStatus")
    public String pennyDropStatus;
    @c(a = "status")
    public String status;
    public String statusMessage;

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public String getStatus() {
        if (!TextUtils.isEmpty(this.STATUS)) {
            return this.STATUS;
        }
        return this.status;
    }

    public Data getData() {
        return this.data;
    }

    public String getPennyDropStatus() {
        return this.pennyDropStatus;
    }

    public class Data {
        @c(a = "MSG")
        public String msg;

        public Data(MerchantProfileResponse merchantProfileResponse) {
        }

        public String getMsg() {
            return this.msg;
        }
    }
}
