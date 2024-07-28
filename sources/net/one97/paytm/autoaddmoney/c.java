package net.one97.paytm.autoaddmoney;

import android.app.Application;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import kotlin.g.b.k;
import net.one97.paytm.autoaddmoney.c.a;
import net.one97.paytm.autoaddmoney.data.source.b;

public final class c extends al.d {

    /* renamed from: a  reason: collision with root package name */
    public static final a f49170a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f49171c;

    /* renamed from: b  reason: collision with root package name */
    private final b f49172b;

    public /* synthetic */ c(b bVar, byte b2) {
        this(bVar);
    }

    private c(b bVar) {
        this.f49172b = bVar;
    }

    public final <T extends ai> T create(Class<T> cls) {
        k.c(cls, "modelClass");
        if (cls.isAssignableFrom(net.one97.paytm.autoaddmoney.c.c.class)) {
            return (ai) new net.one97.paytm.autoaddmoney.c.c(this.f49172b);
        }
        if (cls.isAssignableFrom(a.class)) {
            return (ai) new a(this.f49172b);
        }
        if (cls.isAssignableFrom(net.one97.paytm.autoaddmoney.c.b.class)) {
            return (ai) new net.one97.paytm.autoaddmoney.c.b(this.f49172b);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + cls.getName());
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static c a(Application application) {
            c a2;
            c a3 = c.f49171c;
            if (a3 != null) {
                return a3;
            }
            synchronized (c.class) {
                a2 = c.f49171c;
                if (a2 == null) {
                    b bVar = b.f49147a;
                    a2 = new c(b.a(application != null ? application.getApplicationContext() : null), (byte) 0);
                    c.f49171c = a2;
                }
            }
            return a2;
        }
    }
}
