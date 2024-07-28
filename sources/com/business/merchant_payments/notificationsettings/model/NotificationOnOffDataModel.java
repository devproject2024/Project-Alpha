package com.business.merchant_payments.notificationsettings.model;

import com.business.merchant_payments.model.BaseModel;
import kotlin.g.b.k;

public final class NotificationOnOffDataModel extends BaseModel {
    public final SmsEmailOnOffDataModel refund;
    public final SmsEmailOnOffDataModel transaction;

    public static /* synthetic */ NotificationOnOffDataModel copy$default(NotificationOnOffDataModel notificationOnOffDataModel, SmsEmailOnOffDataModel smsEmailOnOffDataModel, SmsEmailOnOffDataModel smsEmailOnOffDataModel2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            smsEmailOnOffDataModel = notificationOnOffDataModel.transaction;
        }
        if ((i2 & 2) != 0) {
            smsEmailOnOffDataModel2 = notificationOnOffDataModel.refund;
        }
        return notificationOnOffDataModel.copy(smsEmailOnOffDataModel, smsEmailOnOffDataModel2);
    }

    public final SmsEmailOnOffDataModel component1() {
        return this.transaction;
    }

    public final SmsEmailOnOffDataModel component2() {
        return this.refund;
    }

    public final NotificationOnOffDataModel copy(SmsEmailOnOffDataModel smsEmailOnOffDataModel, SmsEmailOnOffDataModel smsEmailOnOffDataModel2) {
        k.d(smsEmailOnOffDataModel, "transaction");
        k.d(smsEmailOnOffDataModel2, "refund");
        return new NotificationOnOffDataModel(smsEmailOnOffDataModel, smsEmailOnOffDataModel2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NotificationOnOffDataModel)) {
            return false;
        }
        NotificationOnOffDataModel notificationOnOffDataModel = (NotificationOnOffDataModel) obj;
        return k.a((Object) this.transaction, (Object) notificationOnOffDataModel.transaction) && k.a((Object) this.refund, (Object) notificationOnOffDataModel.refund);
    }

    public final int hashCode() {
        SmsEmailOnOffDataModel smsEmailOnOffDataModel = this.transaction;
        int i2 = 0;
        int hashCode = (smsEmailOnOffDataModel != null ? smsEmailOnOffDataModel.hashCode() : 0) * 31;
        SmsEmailOnOffDataModel smsEmailOnOffDataModel2 = this.refund;
        if (smsEmailOnOffDataModel2 != null) {
            i2 = smsEmailOnOffDataModel2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "NotificationOnOffDataModel(transaction=" + this.transaction + ", refund=" + this.refund + ")";
    }

    public final SmsEmailOnOffDataModel getTransaction() {
        return this.transaction;
    }

    public NotificationOnOffDataModel(SmsEmailOnOffDataModel smsEmailOnOffDataModel, SmsEmailOnOffDataModel smsEmailOnOffDataModel2) {
        k.d(smsEmailOnOffDataModel, "transaction");
        k.d(smsEmailOnOffDataModel2, "refund");
        this.transaction = smsEmailOnOffDataModel;
        this.refund = smsEmailOnOffDataModel2;
    }

    public final SmsEmailOnOffDataModel getRefund() {
        return this.refund;
    }
}
