package com.travel.citybus.brts.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.a.c;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJRBusStopModel implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR((g) null);
    @c(a = "merchantStopId")
    private String merchantStopId;
    @c(a = "name")
    private String name;

    public static /* synthetic */ CJRBusStopModel copy$default(CJRBusStopModel cJRBusStopModel, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRBusStopModel.name;
        }
        if ((i2 & 2) != 0) {
            str2 = cJRBusStopModel.merchantStopId;
        }
        return cJRBusStopModel.copy(str, str2);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.merchantStopId;
    }

    public final CJRBusStopModel copy(String str, String str2) {
        k.c(str, "name");
        k.c(str2, "merchantStopId");
        return new CJRBusStopModel(str, str2);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRBusStopModel)) {
            return false;
        }
        CJRBusStopModel cJRBusStopModel = (CJRBusStopModel) obj;
        return k.a((Object) this.name, (Object) cJRBusStopModel.name) && k.a((Object) this.merchantStopId, (Object) cJRBusStopModel.merchantStopId);
    }

    public final int hashCode() {
        String str = this.name;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.merchantStopId;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "CJRBusStopModel(name=" + this.name + ", merchantStopId=" + this.merchantStopId + ")";
    }

    public CJRBusStopModel(String str, String str2) {
        k.c(str, "name");
        k.c(str2, "merchantStopId");
        this.name = str;
        this.merchantStopId = str2;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        k.c(str, "<set-?>");
        this.name = str;
    }

    public final String getMerchantStopId() {
        return this.merchantStopId;
    }

    public final void setMerchantStopId(String str) {
        k.c(str, "<set-?>");
        this.merchantStopId = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CJRBusStopModel(android.os.Parcel r3) {
        /*
            r2 = this;
            java.lang.String r0 = "parcel"
            kotlin.g.b.k.c(r3, r0)
            java.lang.String r0 = r3.readString()
            if (r0 != 0) goto L_0x000e
            kotlin.g.b.k.a()
        L_0x000e:
            java.lang.String r1 = "parcel.readString()!!"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r3 = r3.readString()
            if (r3 != 0) goto L_0x001c
            kotlin.g.b.k.a()
        L_0x001c:
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r1)
            r2.<init>(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.citybus.brts.model.pojo.CJRBusStopModel.<init>(android.os.Parcel):void");
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.name);
        parcel.writeString(this.merchantStopId);
    }

    public static final class CREATOR implements Parcelable.Creator<CJRBusStopModel> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(g gVar) {
            this();
        }

        public final CJRBusStopModel createFromParcel(Parcel parcel) {
            k.c(parcel, "parcel");
            return new CJRBusStopModel(parcel);
        }

        public final CJRBusStopModel[] newArray(int i2) {
            return new CJRBusStopModel[i2];
        }
    }
}
