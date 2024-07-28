package com.alipay.mobile.c;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.mobile.framework.b.b;
import java.lang.reflect.Method;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static long f14948a;

    /* renamed from: b  reason: collision with root package name */
    public static Context f14949b;

    /* renamed from: c  reason: collision with root package name */
    public static Application f14950c;

    public static void a(b bVar) {
        if (!TextUtils.isEmpty(bVar.f14958a) && !TextUtils.isEmpty(bVar.f14959b)) {
            try {
                Class<?> cls = Class.forName(bVar.f14958a);
                if (cls != null) {
                    Object newInstance = cls.newInstance();
                    Method declaredMethod = cls.getDeclaredMethod("onCreate", new Class[]{Bundle.class});
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(newInstance, new Object[]{new Bundle()});
                    com.alipay.mobile.framework.b.a.a().a(bVar.f14959b, newInstance);
                }
            } catch (Exception e2) {
                new StringBuilder().append(e2);
            }
        }
    }
}
