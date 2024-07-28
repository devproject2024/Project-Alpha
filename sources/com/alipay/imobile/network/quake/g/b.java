package com.alipay.imobile.network.quake.g;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.imobile.network.quake.a;
import com.alipay.imobile.network.quake.c;
import java.lang.annotation.Annotation;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public final class b implements a {

    /* renamed from: c  reason: collision with root package name */
    private static a f14791c;

    /* renamed from: a  reason: collision with root package name */
    private Map<String, c> f14792a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private a f14793b;

    private b(Context context) {
        this.f14793b = c.a(context);
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (b.class) {
            if (f14791c == null) {
                f14791c = new b(context);
            }
            aVar = f14791c;
        }
        return aVar;
    }

    public static synchronized a b() throws com.alipay.mobile.b.b.a {
        a aVar;
        synchronized (b.class) {
            if (f14791c != null) {
                aVar = f14791c;
            } else {
                throw new com.alipay.mobile.b.b.a((Integer) 9, "IQuakeRpc has not been initialized by createInstance(Context).");
            }
        }
        return aVar;
    }

    public final synchronized a a() {
        return this.f14793b;
    }

    public final synchronized c a(Class<? extends Annotation> cls) {
        if (cls == null) {
            return null;
        }
        String name = cls.getName();
        if (TextUtils.isEmpty(name)) {
            return null;
        }
        return this.f14792a.get(name);
    }

    public final synchronized <T> T b(Class<T> cls) throws IllegalArgumentException {
        if (cls != null) {
        } else {
            throw new IllegalArgumentException("the input parameter can not be null");
        }
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new d(b(), cls));
    }
}
