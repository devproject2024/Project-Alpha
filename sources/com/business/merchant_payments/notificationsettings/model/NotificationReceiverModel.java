package com.business.merchant_payments.notificationsettings.model;

import androidx.databinding.a;
import java.io.Serializable;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class NotificationReceiverModel extends a implements Serializable {
    public static final int ADDITIONAL_CONTACT = 5;
    public static final Companion Companion = new Companion((g) null);
    public static final int PRIMARY_EMAIL = 1;
    public static final int PRIMARY_NUMBER = 2;
    public static final int SECONDARY_EMAIL = 4;
    public static final int SECONDARY_NUMBER = 3;
    public final String receiverString;
    public final int receiverType;

    public static /* synthetic */ NotificationReceiverModel copy$default(NotificationReceiverModel notificationReceiverModel, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = notificationReceiverModel.receiverString;
        }
        if ((i3 & 2) != 0) {
            i2 = notificationReceiverModel.receiverType;
        }
        return notificationReceiverModel.copy(str, i2);
    }

    public final String component1() {
        return this.receiverString;
    }

    public final int component2() {
        return this.receiverType;
    }

    public final NotificationReceiverModel copy(String str, int i2) {
        return new NotificationReceiverModel(str, i2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NotificationReceiverModel)) {
            return false;
        }
        NotificationReceiverModel notificationReceiverModel = (NotificationReceiverModel) obj;
        return k.a((Object) this.receiverString, (Object) notificationReceiverModel.receiverString) && this.receiverType == notificationReceiverModel.receiverType;
    }

    public final int hashCode() {
        String str = this.receiverString;
        return ((str != null ? str.hashCode() : 0) * 31) + this.receiverType;
    }

    public final String toString() {
        return "NotificationReceiverModel(receiverString=" + this.receiverString + ", receiverType=" + this.receiverType + ")";
    }

    public NotificationReceiverModel(String str, int i2) {
        this.receiverString = str;
        this.receiverType = i2;
    }

    public final String getReceiverString() {
        return this.receiverString;
    }

    public final int getReceiverType() {
        return this.receiverType;
    }

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public final String getReceiver() {
        return this.receiverString;
    }

    public final int getType() {
        return this.receiverType;
    }

    public final boolean getRemoveButtonVisibility() {
        int i2 = this.receiverType;
        return (i2 == 1 || i2 == 2) ? false : true;
    }

    public final boolean getPrimaryViewVisibility() {
        int i2 = this.receiverType;
        return i2 == 2 || i2 == 1;
    }
}
