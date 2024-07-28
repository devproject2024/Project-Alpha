package net.one97.paytm.recharge.model.v4;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJRDeviceType extends IJRPaytmDataModel {
    @b(a = "android")

    /* renamed from: android  reason: collision with root package name */
    private final String f63967android;
    @b(a = "defaultValue")

    /* renamed from: default  reason: not valid java name */
    private final String f668default;

    public CJRDeviceType() {
        this((String) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ CJRDeviceType copy$default(CJRDeviceType cJRDeviceType, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRDeviceType.f63967android;
        }
        if ((i2 & 2) != 0) {
            str2 = cJRDeviceType.f668default;
        }
        return cJRDeviceType.copy(str, str2);
    }

    public final String component1() {
        return this.f63967android;
    }

    public final String component2() {
        return this.f668default;
    }

    public final CJRDeviceType copy(String str, String str2) {
        return new CJRDeviceType(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRDeviceType)) {
            return false;
        }
        CJRDeviceType cJRDeviceType = (CJRDeviceType) obj;
        return k.a((Object) this.f63967android, (Object) cJRDeviceType.f63967android) && k.a((Object) this.f668default, (Object) cJRDeviceType.f668default);
    }

    public final int hashCode() {
        String str = this.f63967android;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f668default;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "CJRDeviceType(android=" + this.f63967android + ", default=" + this.f668default + ")";
    }

    public final String getAndroid() {
        return this.f63967android;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRDeviceType(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final String getDefault() {
        return this.f668default;
    }

    public CJRDeviceType(String str, String str2) {
        this.f63967android = str;
        this.f668default = str2;
    }

    public final String getAndroidType() {
        String str = this.f63967android;
        if (str != null) {
            return str;
        }
        return this.f668default;
    }
}
