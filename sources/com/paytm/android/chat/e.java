package com.paytm.android.chat;

import com.paytm.android.chat.e.b;
import com.paytm.utility.q;
import java.lang.reflect.InvocationTargetException;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static e f42019a;

    /* renamed from: b  reason: collision with root package name */
    private b f42020b;

    private e() {
    }

    public static void a(b bVar) {
        if (f42019a == null) {
            e eVar = new e();
            f42019a = eVar;
            eVar.f42020b = bVar;
        }
    }

    private static e b() {
        if (f42019a == null) {
            synchronized (e.class) {
                try {
                    Class.forName("net.one97.paytm.dynamic.module.chat.ChatHelperImpl").getMethod("init", new Class[0]).invoke((Object) null, new Object[0]);
                } catch (ClassNotFoundException unused) {
                    q.c("initInstance");
                } catch (NoSuchMethodException unused2) {
                    q.c("initInstance");
                } catch (IllegalAccessException unused3) {
                    q.c("initInstance");
                } catch (InvocationTargetException unused4) {
                    q.c("initInstance");
                }
            }
        }
        e eVar = f42019a;
        if (eVar != null) {
            return eVar;
        }
        throw new RuntimeException("getInstance() called before ChatHelperImpl's init()");
    }

    public static b a() {
        return b().f42020b;
    }
}
