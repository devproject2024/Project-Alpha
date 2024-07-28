package net.one97.paytm.paymentsBank.chequebook.utils;

import android.app.Application;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import kotlin.g.b.k;
import net.one97.paytm.paymentsBank.chequebook.depositedCheque.b;
import net.one97.paytm.paymentsBank.chequebook.leaflist.d;

public final class c extends al.d {

    /* renamed from: a  reason: collision with root package name */
    public static final a f17946a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static volatile c f17947d;

    /* renamed from: b  reason: collision with root package name */
    private final Application f17948b;

    /* renamed from: c  reason: collision with root package name */
    private final g f17949c;

    public /* synthetic */ c(Application application, g gVar, byte b2) {
        this(application, gVar);
    }

    private c(Application application, g gVar) {
        this.f17948b = application;
        this.f17949c = gVar;
    }

    public final <T extends ai> T create(Class<T> cls) {
        T t;
        k.c(cls, "modelClass");
        if (cls.isAssignableFrom(d.class)) {
            t = (net.one97.paytm.paymentsBank.chequebook.a) new d(this.f17948b, this.f17949c);
        } else if (cls.isAssignableFrom(b.class)) {
            t = (net.one97.paytm.paymentsBank.chequebook.a) new b(this.f17948b, this.f17949c);
        } else if (cls.isAssignableFrom(net.one97.paytm.paymentsBank.chequebook.leaflist.b.class)) {
            t = (net.one97.paytm.paymentsBank.chequebook.a) new net.one97.paytm.paymentsBank.chequebook.leaflist.b(this.f17948b, this.f17949c);
        } else if (cls.isAssignableFrom(net.one97.paytm.paymentsBank.chequebook.returnedCheque.b.class)) {
            t = (net.one97.paytm.paymentsBank.chequebook.a) new net.one97.paytm.paymentsBank.chequebook.returnedCheque.b(this.f17948b, this.f17949c);
        } else {
            throw new IllegalArgumentException("Unknown viewmodel class " + cls.getName());
        }
        return (ai) t;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static c a(Application application) {
            c a2;
            k.c(application, "application");
            c a3 = c.f17947d;
            if (a3 != null) {
                return a3;
            }
            synchronized (c.class) {
                a2 = c.f17947d;
                if (a2 == null) {
                    a aVar = c.f17946a;
                    k.c(application, "application");
                    d dVar = d.f17950a;
                    g a4 = d.a(application);
                    if (a4 != null) {
                        c cVar = new c(application, a4, (byte) 0);
                        c.f17947d = cVar;
                        a2 = cVar;
                    } else {
                        a2 = null;
                    }
                }
            }
            return a2;
        }
    }
}
