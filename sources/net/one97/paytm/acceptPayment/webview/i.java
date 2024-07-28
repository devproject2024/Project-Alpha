package net.one97.paytm.acceptPayment.webview;

import com.alipay.mobile.h5container.api.H5Param;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.acceptPayment.webviewutils.b.a;
import net.one97.paytm.acceptPayment.webviewutils.b.c;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    final String f52228a;

    /* renamed from: b  reason: collision with root package name */
    final String f52229b;

    /* renamed from: c  reason: collision with root package name */
    final Map<String, String> f52230c;

    /* renamed from: d  reason: collision with root package name */
    final String f52231d;

    /* renamed from: e  reason: collision with root package name */
    final Class<? extends c> f52232e;

    /* renamed from: f  reason: collision with root package name */
    final Class<? extends a> f52233f;

    /* renamed from: g  reason: collision with root package name */
    private final Map<String, String> f52234g;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return k.a((Object) this.f52228a, (Object) iVar.f52228a) && k.a((Object) this.f52229b, (Object) iVar.f52229b) && k.a((Object) this.f52234g, (Object) iVar.f52234g) && k.a((Object) this.f52230c, (Object) iVar.f52230c) && k.a((Object) this.f52231d, (Object) iVar.f52231d) && k.a((Object) this.f52232e, (Object) iVar.f52232e) && k.a((Object) this.f52233f, (Object) iVar.f52233f);
    }

    public final int hashCode() {
        String str = this.f52228a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f52229b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Map<String, String> map = this.f52234g;
        int hashCode3 = (hashCode2 + (map != null ? map.hashCode() : 0)) * 31;
        Map<String, String> map2 = this.f52230c;
        int hashCode4 = (hashCode3 + (map2 != null ? map2.hashCode() : 0)) * 31;
        String str3 = this.f52231d;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Class<? extends c> cls = this.f52232e;
        int hashCode6 = (hashCode5 + (cls != null ? cls.hashCode() : 0)) * 31;
        Class<? extends a> cls2 = this.f52233f;
        if (cls2 != null) {
            i2 = cls2.hashCode();
        }
        return hashCode6 + i2;
    }

    public final String toString() {
        return "WebviewConfig(id=" + this.f52228a + ", url=" + this.f52229b + ", param=" + this.f52234g + ", headers=" + this.f52230c + ", moduleName=" + this.f52231d + ", reactHandlerClass=" + this.f52232e + ", webViewClientClass=" + this.f52233f + ")";
    }

    public i(String str, String str2, Map<String, String> map, Map<String, String> map2, String str3, Class<? extends c> cls, Class<? extends a> cls2) {
        k.d(str, "id");
        k.d(str2, "url");
        k.d(map, H5Param.PARAM);
        k.d(map2, "headers");
        k.d(str3, "moduleName");
        k.d(cls, "reactHandlerClass");
        k.d(cls2, "webViewClientClass");
        this.f52228a = str;
        this.f52229b = str2;
        this.f52234g = map;
        this.f52230c = map2;
        this.f52231d = str3;
        this.f52232e = cls;
        this.f52233f = cls2;
    }
}
