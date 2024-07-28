package com.alipay.iap.android.common.c;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.iap.android.common.b.c;
import com.alipay.imobile.network.quake.c.b;
import com.alipay.imobile.network.quake.d;
import java.util.HashMap;
import java.util.Map;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, Object> f14689a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static C0200a f14690b = null;

    /* renamed from: com.alipay.iap.android.common.c.a$a  reason: collision with other inner class name */
    public interface C0200a {
        <T> T a(Class<T> cls);
    }

    public static <T> T a(Class<T> cls) {
        if (f14689a.containsKey(cls.getName())) {
            return f14689a.get(cls.getName());
        }
        C0200a aVar = f14690b;
        if (aVar == null) {
            return null;
        }
        T a2 = aVar.a(cls);
        f14689a.put(cls.getName(), a2);
        return a2;
    }

    private static boolean a() throws ClassNotFoundException {
        try {
            return Class.forName("com.alipay.imobile.network.quake.g.a") != null;
        } catch (ClassNotFoundException unused) {
            c.g();
            if (f14690b != null) {
                return false;
            }
            throw new ClassNotFoundException("Neither IAPNetworkKit in this package nor another RPC implementation is set to RPCHost, network will not be available");
        }
    }

    public static void a(Context context, String str, String str2, String str3) throws b, IllegalArgumentException, ClassNotFoundException {
        if (a()) {
            com.alipay.imobile.network.quake.a a2 = com.alipay.imobile.network.quake.g.b.a(context).a();
            if (TextUtils.isEmpty(str2)) {
                c.c();
            }
            if (!TextUtils.isEmpty(str3)) {
                StringBuilder sb = new StringBuilder("[Use user-passed configuration] configuration:appkey=");
                sb.append(str2);
                sb.append(", gwurl=");
                sb.append(str3);
                c.c();
                a2.a(new d(str, str2, str3));
                f14690b = new C0200a() {
                    public final <T> T a(Class<T> cls) {
                        return com.alipay.imobile.network.quake.g.b.b().b(cls);
                    }
                };
                return;
            }
            throw new IllegalArgumentException("the url of gate way is empty");
        }
    }
}
