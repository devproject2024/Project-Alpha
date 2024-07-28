package com.business.merchant_payments.notificationsettings.model;

import com.business.merchant_payments.common.utility.AppConstants;
import com.business.merchant_payments.model.BaseModel;
import kotlin.g.b.k;

public final class SmsEmailOnOffDataModel extends BaseModel {
    public final boolean emailAllowed;
    public final String event;
    public final boolean smsAllowed;

    public static /* synthetic */ SmsEmailOnOffDataModel copy$default(SmsEmailOnOffDataModel smsEmailOnOffDataModel, String str, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = smsEmailOnOffDataModel.event;
        }
        if ((i2 & 2) != 0) {
            z = smsEmailOnOffDataModel.smsAllowed;
        }
        if ((i2 & 4) != 0) {
            z2 = smsEmailOnOffDataModel.emailAllowed;
        }
        return smsEmailOnOffDataModel.copy(str, z, z2);
    }

    public final String component1() {
        return this.event;
    }

    public final boolean component2() {
        return this.smsAllowed;
    }

    public final boolean component3() {
        return this.emailAllowed;
    }

    public final SmsEmailOnOffDataModel copy(String str, boolean z, boolean z2) {
        k.d(str, AppConstants.NOTIFICATION_DETAILS.EVENT);
        return new SmsEmailOnOffDataModel(str, z, z2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SmsEmailOnOffDataModel)) {
            return false;
        }
        SmsEmailOnOffDataModel smsEmailOnOffDataModel = (SmsEmailOnOffDataModel) obj;
        return k.a((Object) this.event, (Object) smsEmailOnOffDataModel.event) && this.smsAllowed == smsEmailOnOffDataModel.smsAllowed && this.emailAllowed == smsEmailOnOffDataModel.emailAllowed;
    }

    public final int hashCode() {
        String str = this.event;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.smsAllowed;
        if (z) {
            z = true;
        }
        int i2 = (hashCode + (z ? 1 : 0)) * 31;
        boolean z2 = this.emailAllowed;
        if (z2) {
            z2 = true;
        }
        return i2 + (z2 ? 1 : 0);
    }

    public final String toString() {
        return "SmsEmailOnOffDataModel(event=" + this.event + ", smsAllowed=" + this.smsAllowed + ", emailAllowed=" + this.emailAllowed + ")";
    }

    public final String getEvent() {
        return this.event;
    }

    public final boolean getSmsAllowed() {
        return this.smsAllowed;
    }

    public SmsEmailOnOffDataModel(String str, boolean z, boolean z2) {
        k.d(str, AppConstants.NOTIFICATION_DETAILS.EVENT);
        this.event = str;
        this.smsAllowed = z;
        this.emailAllowed = z2;
    }

    public final boolean getEmailAllowed() {
        return this.emailAllowed;
    }
}
