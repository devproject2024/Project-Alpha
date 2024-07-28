package com.alibaba.wireless.security.b;

import android.content.Context;
import com.alibaba.wireless.security.b.e.a;
import java.util.Map;
import org.json.JSONObject;

public class c {

    /* renamed from: b  reason: collision with root package name */
    private static volatile c f14644b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile a f14645c;

    /* renamed from: d  reason: collision with root package name */
    private static final Object f14646d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private static JSONObject f14647e = null;

    /* renamed from: g  reason: collision with root package name */
    private static Object f14648g = new Object();

    /* renamed from: a  reason: collision with root package name */
    private com.alibaba.wireless.security.a.c f14649a;

    /* renamed from: f  reason: collision with root package name */
    private final Map<Integer, Class> f14650f = new e(this);

    private c(com.alibaba.wireless.security.a.c cVar) {
        this.f14649a = cVar;
    }

    public static c a(Context context) throws b {
        return b(context);
    }

    private static a b() {
        if (f14645c == null) {
            synchronized (f14646d) {
                if (f14645c == null) {
                    f14645c = new com.alibaba.wireless.security.b.e.c((byte) 0);
                }
            }
        }
        return f14645c;
    }

    private static c b(Context context) throws b {
        if (f14644b == null) {
            synchronized (c.class) {
                if (context == null) {
                    return null;
                }
                if (f14644b == null && b().a(context) == 0) {
                    f14644b = new c(((com.alibaba.wireless.security.b.e.c) b()).f14655a.f14656a);
                }
            }
        }
        return f14644b;
    }

    public final a a() {
        try {
            return (a) this.f14649a.a(this.f14650f.get(1));
        } catch (b e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
