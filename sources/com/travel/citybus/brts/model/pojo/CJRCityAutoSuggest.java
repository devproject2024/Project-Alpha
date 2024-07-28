package com.travel.citybus.brts.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJRCityAutoSuggest implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR((g) null);
    @b(a = "enabled")
    private boolean enabled;
    @b(a = "id")
    private String id;
    @b(a = "name")
    private String name;
    @b(a = "stationId")
    private String stationId;
    @b(a = "weight")
    private int weight;

    public static /* synthetic */ CJRCityAutoSuggest copy$default(CJRCityAutoSuggest cJRCityAutoSuggest, String str, String str2, String str3, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = cJRCityAutoSuggest.id;
        }
        if ((i3 & 2) != 0) {
            str2 = cJRCityAutoSuggest.name;
        }
        String str4 = str2;
        if ((i3 & 4) != 0) {
            str3 = cJRCityAutoSuggest.stationId;
        }
        String str5 = str3;
        if ((i3 & 8) != 0) {
            i2 = cJRCityAutoSuggest.weight;
        }
        int i4 = i2;
        if ((i3 & 16) != 0) {
            z = cJRCityAutoSuggest.enabled;
        }
        return cJRCityAutoSuggest.copy(str, str4, str5, i4, z);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.stationId;
    }

    public final int component4() {
        return this.weight;
    }

    public final boolean component5() {
        return this.enabled;
    }

    public final CJRCityAutoSuggest copy(String str, String str2, String str3, int i2, boolean z) {
        k.c(str, "id");
        k.c(str2, "name");
        k.c(str3, "stationId");
        return new CJRCityAutoSuggest(str, str2, str3, i2, z);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRCityAutoSuggest)) {
            return false;
        }
        CJRCityAutoSuggest cJRCityAutoSuggest = (CJRCityAutoSuggest) obj;
        return k.a((Object) this.id, (Object) cJRCityAutoSuggest.id) && k.a((Object) this.name, (Object) cJRCityAutoSuggest.name) && k.a((Object) this.stationId, (Object) cJRCityAutoSuggest.stationId) && this.weight == cJRCityAutoSuggest.weight && this.enabled == cJRCityAutoSuggest.enabled;
    }

    public final int hashCode() {
        String str = this.id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.stationId;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = (((hashCode2 + i2) * 31) + this.weight) * 31;
        boolean z = this.enabled;
        if (z) {
            z = true;
        }
        return i3 + (z ? 1 : 0);
    }

    public final String toString() {
        return "CJRCityAutoSuggest(id=" + this.id + ", name=" + this.name + ", stationId=" + this.stationId + ", weight=" + this.weight + ", enabled=" + this.enabled + ")";
    }

    public CJRCityAutoSuggest(String str, String str2, String str3, int i2, boolean z) {
        k.c(str, "id");
        k.c(str2, "name");
        k.c(str3, "stationId");
        this.id = str;
        this.name = str2;
        this.stationId = str3;
        this.weight = i2;
        this.enabled = z;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        k.c(str, "<set-?>");
        this.id = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        k.c(str, "<set-?>");
        this.name = str;
    }

    public final String getStationId() {
        return this.stationId;
    }

    public final void setStationId(String str) {
        k.c(str, "<set-?>");
        this.stationId = str;
    }

    public final int getWeight() {
        return this.weight;
    }

    public final void setWeight(int i2) {
        this.weight = i2;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CJRCityAutoSuggest(android.os.Parcel r8) {
        /*
            r7 = this;
            java.lang.String r0 = "parcel"
            kotlin.g.b.k.c(r8, r0)
            java.lang.String r2 = r8.readString()
            if (r2 != 0) goto L_0x000e
            kotlin.g.b.k.a()
        L_0x000e:
            java.lang.String r0 = "parcel.readString()!!"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r0)
            java.lang.String r3 = r8.readString()
            if (r3 != 0) goto L_0x001c
            kotlin.g.b.k.a()
        L_0x001c:
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r0)
            java.lang.String r4 = r8.readString()
            if (r4 != 0) goto L_0x0028
            kotlin.g.b.k.a()
        L_0x0028:
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
            int r5 = r8.readInt()
            byte r8 = r8.readByte()
            if (r8 == 0) goto L_0x0038
            r8 = 1
            r6 = 1
            goto L_0x003a
        L_0x0038:
            r8 = 0
            r6 = 0
        L_0x003a:
            r1 = r7
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.citybus.brts.model.pojo.CJRCityAutoSuggest.<init>(android.os.Parcel):void");
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.stationId);
        parcel.writeInt(this.weight);
        parcel.writeByte(this.enabled ? (byte) 1 : 0);
    }

    public static final class CREATOR implements Parcelable.Creator<CJRCityAutoSuggest> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(g gVar) {
            this();
        }

        public final CJRCityAutoSuggest createFromParcel(Parcel parcel) {
            k.c(parcel, "parcel");
            return new CJRCityAutoSuggest(parcel);
        }

        public final CJRCityAutoSuggest[] newArray(int i2) {
            return new CJRCityAutoSuggest[i2];
        }
    }
}
