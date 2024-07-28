package com.google.firebase.components;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class f<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f38098a;

    /* renamed from: b  reason: collision with root package name */
    public final b<T> f38099b;

    public interface b<T> {
        List<String> a(T t);
    }

    public f(T t, b<T> bVar) {
        this.f38098a = t;
        this.f38099b = bVar;
    }

    public static List<h> a(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            try {
                Class<?> cls = Class.forName(next);
                if (!h.class.isAssignableFrom(cls)) {
                    String.format("Class %s is not an instance of %s", new Object[]{next, "com.google.firebase.components.ComponentRegistrar"});
                } else {
                    arrayList.add((h) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                }
            } catch (ClassNotFoundException unused) {
                String.format("Class %s is not an found.", new Object[]{next});
            } catch (IllegalAccessException unused2) {
                String.format("Could not instantiate %s.", new Object[]{next});
            } catch (InstantiationException unused3) {
                String.format("Could not instantiate %s.", new Object[]{next});
            } catch (NoSuchMethodException unused4) {
                String.format("Could not instantiate %s", new Object[]{next});
            } catch (InvocationTargetException unused5) {
                String.format("Could not instantiate %s", new Object[]{next});
            }
        }
        return arrayList;
    }

    public static class a implements b<Context> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<? extends Service> f38100a;

        public /* synthetic */ a(Class cls, byte b2) {
            this(cls);
        }

        public final /* synthetic */ List a(Object obj) {
            Bundle a2 = a((Context) obj);
            if (a2 == null) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (String str : a2.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(a2.get(str)) && str.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str.substring(31));
                }
            }
            return arrayList;
        }

        private a(Class<? extends Service> cls) {
            this.f38100a = cls;
        }

        private Bundle a(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, this.f38100a), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(this.f38100a);
                sb.append(" has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }
    }
}
