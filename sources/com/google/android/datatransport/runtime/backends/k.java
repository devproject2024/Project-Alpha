package com.google.android.datatransport.runtime.backends;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class k implements e {

    /* renamed from: a  reason: collision with root package name */
    private final a f7759a;

    /* renamed from: b  reason: collision with root package name */
    private final i f7760b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, m> f7761c;

    k(Context context, i iVar) {
        this(new a(context), iVar);
    }

    private k(a aVar, i iVar) {
        this.f7761c = new HashMap();
        this.f7759a = aVar;
        this.f7760b = iVar;
    }

    public final synchronized m a(String str) {
        if (this.f7761c.containsKey(str)) {
            return this.f7761c.get(str);
        }
        d a2 = this.f7759a.a(str);
        if (a2 == null) {
            return null;
        }
        i iVar = this.f7760b;
        m create = a2.create(new c(iVar.f7753a, iVar.f7754b, iVar.f7755c, str));
        this.f7761c.put(str, create);
        return create;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private final Context f7762a;

        /* renamed from: b  reason: collision with root package name */
        private Map<String, String> f7763b = null;

        a(Context context) {
            this.f7762a = context;
        }

        private static Bundle a(Context context) {
            ServiceInfo serviceInfo;
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null || (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, TransportBackendDiscovery.class), 128)) == null) {
                    return null;
                }
                return serviceInfo.metaData;
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        /* access modifiers changed from: package-private */
        public final d a(String str) {
            Map<String, String> map;
            if (this.f7763b == null) {
                Bundle a2 = a(this.f7762a);
                if (a2 == null) {
                    map = Collections.emptyMap();
                } else {
                    HashMap hashMap = new HashMap();
                    for (String str2 : a2.keySet()) {
                        Object obj = a2.get(str2);
                        if ((obj instanceof String) && str2.startsWith("backend:")) {
                            for (String trim : ((String) obj).split(AppConstants.COMMA, -1)) {
                                String trim2 = trim.trim();
                                if (!trim2.isEmpty()) {
                                    hashMap.put(trim2, str2.substring(8));
                                }
                            }
                        }
                    }
                    map = hashMap;
                }
                this.f7763b = map;
            }
            String str3 = this.f7763b.get(str);
            if (str3 == null) {
                return null;
            }
            try {
                return (d) Class.forName(str3).asSubclass(d.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException unused) {
                String.format("Class %s is not found.", new Object[]{str3});
                return null;
            } catch (IllegalAccessException unused2) {
                String.format("Could not instantiate %s.", new Object[]{str3});
                return null;
            } catch (InstantiationException unused3) {
                String.format("Could not instantiate %s.", new Object[]{str3});
                return null;
            } catch (NoSuchMethodException unused4) {
                String.format("Could not instantiate %s", new Object[]{str3});
                return null;
            } catch (InvocationTargetException unused5) {
                String.format("Could not instantiate %s", new Object[]{str3});
                return null;
            }
        }
    }
}
