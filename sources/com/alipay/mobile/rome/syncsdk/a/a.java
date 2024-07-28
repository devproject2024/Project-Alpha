package com.alipay.mobile.rome.syncsdk.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.alipay.mobile.rome.longlinkservice.c;
import com.alipay.mobile.rome.syncsdk.e.h;
import com.alipay.mobile.rome.syncsdk.e.i;

public class a {

    /* renamed from: d  reason: collision with root package name */
    private static final String f14986d = a.class.getSimpleName();

    /* renamed from: e  reason: collision with root package name */
    private static a f14987e;

    /* renamed from: a  reason: collision with root package name */
    public String f14988a;

    /* renamed from: b  reason: collision with root package name */
    public String f14989b;

    /* renamed from: c  reason: collision with root package name */
    public c f14990c;

    /* renamed from: f  reason: collision with root package name */
    private String f14991f = com.ta.utdid2.c.c.a(com.alipay.mobile.rome.syncservice.a.a.f15156a);

    /* renamed from: g  reason: collision with root package name */
    private boolean f14992g;

    /* renamed from: h  reason: collision with root package name */
    private String f14993h;

    private a() {
        h.b(f14986d, "longLinkAppConfig is null, will retrieve from manifest or mpaas.properties");
        Context context = com.alipay.mobile.rome.syncservice.a.a.f15156a;
        c cVar = new c();
        cVar.f14973c = i.b(context);
        cVar.f14974d = i.a(context);
        cVar.f14976f = i.c(context);
        cVar.f14971a = i.g(context);
        cVar.f14975e = i.f(context);
        cVar.f14977g = i.d(com.alipay.mobile.rome.syncservice.a.a.f15156a);
        cVar.f14978h = i.e(com.alipay.mobile.rome.syncservice.a.a.f15156a);
        if (TextUtils.isEmpty(cVar.f14971a)) {
            cVar.f14971a = String.format("%s-%s", new Object[]{cVar.f14974d, cVar.f14976f});
        }
        if (TextUtils.isEmpty(cVar.f14972b)) {
            cVar.f14972b = l();
        }
        this.f14990c = cVar;
        String str = f14986d;
        h.b(str, "longLinkAppConfig = " + this.f14990c.toString());
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f14987e == null) {
                f14987e = new a();
            }
            aVar = f14987e;
        }
        return aVar;
    }

    public final synchronized String b() {
        return this.f14990c.f14972b;
    }

    public final synchronized String c() {
        return this.f14990c.f14971a;
    }

    public final synchronized String d() {
        return this.f14990c.f14973c;
    }

    public final synchronized String e() {
        return this.f14991f;
    }

    public final synchronized String f() {
        return this.f14989b;
    }

    public final synchronized String g() {
        return this.f14990c.f14974d;
    }

    public final synchronized String a(Context context) {
        return com.alipay.mobile.rome.syncsdk.b.a.a().a(context, "key_cdid");
    }

    public final synchronized void a(Context context, String str) {
        com.alipay.mobile.rome.syncsdk.b.a.a().a(context, "key_cdid", str);
    }

    public final synchronized String h() {
        return this.f14990c.f14977g;
    }

    public final synchronized String i() {
        return this.f14990c.f14978h;
    }

    public final synchronized boolean j() {
        this.f14992g = false;
        if (TextUtils.equals(this.f14990c.f14978h, "443")) {
            this.f14992g = true;
        }
        return this.f14992g;
    }

    public final synchronized String k() {
        this.f14993h = null;
        if (TextUtils.equals(this.f14990c.f14978h, "443")) {
            String str = this.f14990c.f14977g;
            boolean z = false;
            if (!TextUtils.isEmpty(str)) {
                while (str.startsWith(" ")) {
                    str = str.substring(1, str.length()).trim();
                }
                while (str.endsWith(" ")) {
                    str = str.substring(0, str.length() - 1).trim();
                }
                if (str.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}")) {
                    String[] split = str.split("\\.");
                    if (Integer.parseInt(split[0]) < 255 && Integer.parseInt(split[1]) < 255 && Integer.parseInt(split[2]) < 255 && Integer.parseInt(split[3]) < 255) {
                        z = true;
                    }
                }
            }
            if (z) {
                this.f14993h = "*.cloud.alipay.com";
            } else {
                this.f14993h = this.f14990c.f14977g;
            }
        }
        return this.f14993h;
    }

    private static String l() {
        Context context = com.alipay.mobile.rome.syncservice.a.a.f15156a;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return null;
        } catch (Throwable th) {
            h.a(f14986d, "LongLinkAppInfo exception:".concat(String.valueOf(th)));
            return null;
        }
    }
}
