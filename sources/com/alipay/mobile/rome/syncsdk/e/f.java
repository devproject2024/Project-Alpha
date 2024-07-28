package com.alipay.mobile.rome.syncsdk.e;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.a.a.a.a;
import java.util.Locale;

public final class f {
    public static a a(Context context, String str) {
        a aVar = new a();
        aVar.f14667c = "2.0.0";
        aVar.f14672h = str;
        if (TextUtils.equals(str, "unbind")) {
            return aVar;
        }
        String str2 = com.alipay.mobile.rome.syncsdk.a.a.a().f14988a;
        String f2 = com.alipay.mobile.rome.syncsdk.a.a.a().f();
        aVar.f14666b = "";
        aVar.n = "";
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(f2)) {
            aVar.f14666b = str2;
            aVar.n = f2;
        }
        if (TextUtils.equals(str, "bind")) {
            return aVar;
        }
        aVar.f14671g = "android";
        aVar.f14668d = j.a(context);
        aVar.f14669e = com.alipay.mobile.rome.syncsdk.a.a.a().b();
        aVar.f14673i = com.alipay.mobile.rome.syncsdk.a.a.a().c();
        aVar.o = Locale.getDefault().getLanguage();
        aVar.j = com.alipay.mobile.rome.syncsdk.a.a.a().d();
        aVar.p = com.alipay.mobile.rome.syncsdk.a.a.a().g();
        aVar.r = Long.valueOf(System.currentTimeMillis());
        com.alipay.mobile.rome.syncsdk.a.a.a();
        String str3 = aVar.p;
        aVar.s = l.a(context, str3, aVar.p + aVar.r);
        aVar.q = com.alipay.mobile.rome.syncsdk.a.a.a().f14990c.f14976f;
        String e2 = com.alipay.mobile.rome.syncsdk.a.a.a().e();
        aVar.f14670f = "";
        if (!TextUtils.isEmpty(e2)) {
            aVar.f14670f = e2;
        }
        aVar.f14668d = j.a(context);
        if (!TextUtils.isEmpty(com.alipay.mobile.rome.syncsdk.a.a.a().a(context))) {
            aVar.t = com.alipay.mobile.rome.syncsdk.a.a.a().a(context);
        } else {
            g a2 = g.a(context);
            String str4 = a2.f15092a;
            String str5 = a2.f15093b;
            String str6 = a2.f15094c;
            aVar.m = str4;
            aVar.l = str5;
            aVar.k = str6;
        }
        return aVar;
    }
}
