package com.alipay.imobile.network.quake.d.a;

import com.alipay.imobile.network.quake.e;
import com.alipay.imobile.network.quake.h.a.f;
import com.alipay.imobile.network.quake.h.c;
import com.alipay.imobile.network.quake.h.d;
import com.alipay.imobile.network.quake.m;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public final class a extends com.alipay.imobile.network.quake.h.a.a {

    /* renamed from: c  reason: collision with root package name */
    private static Class<?> f14754c;

    /* renamed from: d  reason: collision with root package name */
    private static Class<?> f14755d;

    /* renamed from: e  reason: collision with root package name */
    private static Class<?> f14756e;

    /* renamed from: f  reason: collision with root package name */
    private static Class<?> f14757f;

    /* renamed from: g  reason: collision with root package name */
    private c f14758g;

    static {
        try {
            f14754c = com.alipay.imobile.network.quake.i.c.a("okhttp3.internal.huc.HttpURLConnectionImpl");
            f14755d = com.alipay.imobile.network.quake.i.c.a("okhttp3.OkHttpClient");
            f14756e = com.alipay.imobile.network.quake.i.c.a("i.v");
            f14757f = com.alipay.imobile.network.quake.i.c.a("com.alipay.imobile.network.quake.ext.okhttp.OkhttpBridge");
        } catch (Exception unused) {
            String str = com.alipay.imobile.network.quake.c.f14737a;
            com.alipay.iap.android.common.b.c.j();
        }
    }

    private a(com.alipay.imobile.network.quake.h.a.c cVar) throws ClassNotFoundException {
        if (f14754c == null) {
            throw new ClassNotFoundException("could not find dependence of okhttp urlconnection v3.2.0+");
        } else if (f14755d == null) {
            throw new ClassNotFoundException("could not find dependence of okhttp v3.2.0+");
        } else if (f14756e != null) {
            Class<?> cls = f14757f;
            if (cls != null) {
                try {
                    this.f14758g = (com.alipay.imobile.network.quake.h.a.a) cls.getConstructor(new Class[]{com.alipay.imobile.network.quake.h.a.c.class, Boolean.TYPE}).newInstance(new Object[]{cVar, Boolean.TRUE});
                } catch (NoSuchMethodException unused) {
                    String str = com.alipay.imobile.network.quake.c.f14737a;
                    com.alipay.iap.android.common.b.c.j();
                    throw new ClassNotFoundException("could not find dependence of quake-okhttp");
                } catch (IllegalAccessException unused2) {
                    String str2 = com.alipay.imobile.network.quake.c.f14737a;
                    com.alipay.iap.android.common.b.c.j();
                    throw new ClassNotFoundException("could not find dependence of quake-okhttp");
                } catch (InstantiationException unused3) {
                    String str3 = com.alipay.imobile.network.quake.c.f14737a;
                    com.alipay.iap.android.common.b.c.j();
                    throw new ClassNotFoundException("could not find dependence of quake-okhttp");
                } catch (InvocationTargetException unused4) {
                    String str4 = com.alipay.imobile.network.quake.c.f14737a;
                    com.alipay.iap.android.common.b.c.j();
                    throw new ClassNotFoundException("could not find dependence of quake-okhttp");
                }
            } else {
                throw new ClassNotFoundException("could not find dependence of quake-okhttp");
            }
        } else {
            throw new ClassNotFoundException("could not find dependence of okio v1.6.0+");
        }
    }

    public final f a(e eVar, Map<String, String> map) throws IOException, com.alipay.mobile.b.b.a {
        return null;
    }

    public final void a(e eVar, d dVar) {
        c cVar = this.f14758g;
        if (cVar != null) {
            cVar.a(eVar, dVar);
        }
    }

    public a() throws ClassNotFoundException {
        this(m.a().m.f14752i);
    }
}
