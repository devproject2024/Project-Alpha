package com.business.merchant_payments.model.requestpayment;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class MessageBundle implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR((g) null);
    public String body;
    public String id;
    public String linkName;
    public String type;

    public static /* synthetic */ MessageBundle copy$default(MessageBundle messageBundle, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = messageBundle.type;
        }
        if ((i2 & 2) != 0) {
            str2 = messageBundle.body;
        }
        if ((i2 & 4) != 0) {
            str3 = messageBundle.id;
        }
        if ((i2 & 8) != 0) {
            str4 = messageBundle.linkName;
        }
        return messageBundle.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.body;
    }

    public final String component3() {
        return this.id;
    }

    public final String component4() {
        return this.linkName;
    }

    public final MessageBundle copy(String str, String str2, String str3, String str4) {
        return new MessageBundle(str, str2, str3, str4);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageBundle)) {
            return false;
        }
        MessageBundle messageBundle = (MessageBundle) obj;
        return k.a((Object) this.type, (Object) messageBundle.type) && k.a((Object) this.body, (Object) messageBundle.body) && k.a((Object) this.id, (Object) messageBundle.id) && k.a((Object) this.linkName, (Object) messageBundle.linkName);
    }

    public final int hashCode() {
        String str = this.type;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.body;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.id;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.linkName;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "MessageBundle(type=" + this.type + ", body=" + this.body + ", id=" + this.id + ", linkName=" + this.linkName + ")";
    }

    public MessageBundle(String str, String str2, String str3, String str4) {
        this.type = str;
        this.body = str2;
        this.id = str3;
        this.linkName = str4;
    }

    public final String getBody() {
        return this.body;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLinkName() {
        return this.linkName;
    }

    public final String getType() {
        return this.type;
    }

    public final void setBody(String str) {
        this.body = str;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final void setLinkName(String str) {
        this.linkName = str;
    }

    public final void setType(String str) {
        this.type = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MessageBundle(Parcel parcel) {
        this(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        k.d(parcel, "parcel");
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.d(parcel, "parcel");
        parcel.writeString(this.type);
        parcel.writeString(this.body);
        parcel.writeString(this.id);
        parcel.writeString(this.linkName);
    }

    public static final class CREATOR implements Parcelable.Creator<MessageBundle> {
        public CREATOR() {
        }

        public /* synthetic */ CREATOR(g gVar) {
            this();
        }

        public final MessageBundle createFromParcel(Parcel parcel) {
            k.d(parcel, "parcel");
            return new MessageBundle(parcel);
        }

        public final MessageBundle[] newArray(int i2) {
            return new MessageBundle[i2];
        }
    }
}
