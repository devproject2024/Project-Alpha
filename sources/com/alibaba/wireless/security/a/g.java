package com.alibaba.wireless.security.a;

import android.content.pm.PackageInfo;
import com.alibaba.wireless.security.b.e.b;
import dalvik.system.DexClassLoader;

public final class g implements b {

    /* renamed from: a  reason: collision with root package name */
    String f14618a;

    /* renamed from: b  reason: collision with root package name */
    PackageInfo f14619b;

    /* renamed from: c  reason: collision with root package name */
    private String f14620c;

    /* renamed from: d  reason: collision with root package name */
    private DexClassLoader f14621d;

    /* renamed from: e  reason: collision with root package name */
    private b f14622e;

    /* renamed from: f  reason: collision with root package name */
    private c f14623f;

    public g(String str, c cVar, String str2, DexClassLoader dexClassLoader, PackageInfo packageInfo, b bVar) {
        this.f14618a = str;
        this.f14623f = cVar;
        this.f14620c = str2;
        this.f14621d = dexClassLoader;
        this.f14619b = packageInfo;
        this.f14622e = bVar;
    }

    public final String a() {
        return this.f14619b.versionName;
    }

    public final String a(String str) {
        return this.f14619b.applicationInfo.metaData.getString(str);
    }

    public final String b() {
        return this.f14618a;
    }

    public final b c() {
        return this.f14622e;
    }
}
