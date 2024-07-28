package net.one97.paytm.oauth.models;

import kotlin.g.b.k;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final String f56740a;

    /* renamed from: b  reason: collision with root package name */
    public final String f56741b;

    /* renamed from: c  reason: collision with root package name */
    public final String f56742c;

    /* renamed from: d  reason: collision with root package name */
    public final String f56743d;

    /* renamed from: e  reason: collision with root package name */
    public final String f56744e;

    /* renamed from: f  reason: collision with root package name */
    public final int f56745f;

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (k.a((Object) this.f56740a, (Object) aVar.f56740a) && k.a((Object) this.f56741b, (Object) aVar.f56741b) && k.a((Object) this.f56742c, (Object) aVar.f56742c) && k.a((Object) this.f56743d, (Object) aVar.f56743d) && k.a((Object) this.f56744e, (Object) aVar.f56744e)) {
                    if (this.f56745f == aVar.f56745f) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String str = this.f56740a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f56741b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f56742c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f56743d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f56744e;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return ((hashCode4 + i2) * 31) + this.f56745f;
    }

    public final String toString() {
        return "HawkEyeModel(flowName=" + this.f56740a + ", screenName=" + this.f56741b + ", customMessage=" + this.f56742c + ", errorMsg=" + this.f56743d + ", uri=" + this.f56744e + ", responseCode=" + this.f56745f + ")";
    }

    public a(String str, String str2, String str3, String str4, String str5, int i2) {
        k.c(str, "flowName");
        k.c(str2, SDKConstants.EVENT_KEY_SCREEN_NAME);
        k.c(str3, "customMessage");
        k.c(str4, "errorMsg");
        k.c(str5, "uri");
        this.f56740a = str;
        this.f56741b = str2;
        this.f56742c = str3;
        this.f56743d = str4;
        this.f56744e = str5;
        this.f56745f = i2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(String str, String str2, String str3, String str4, String str5, int i2, int i3) {
        this(str, str2, str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? "" : str5, (i3 & 32) != 0 ? 200 : i2);
    }
}
