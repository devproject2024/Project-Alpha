package net.one97.paytm.wallet.rateMerchant.c;

import android.app.Application;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import kotlin.g.b.k;
import net.one97.paytm.wallet.rateMerchant.b.a;
import net.one97.paytm.wallet.rateMerchant.b.b;
import net.one97.paytm.wallet.rateMerchant.b.d;

public final class c extends al.d {

    /* renamed from: a  reason: collision with root package name */
    public static final a f71702a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static volatile c f71703d;

    /* renamed from: b  reason: collision with root package name */
    private final Application f71704b;

    /* renamed from: c  reason: collision with root package name */
    private final net.one97.paytm.wallet.rateMerchant.b.c f71705c;

    public /* synthetic */ c(Application application, net.one97.paytm.wallet.rateMerchant.b.c cVar, byte b2) {
        this(application, cVar);
    }

    private c(Application application, net.one97.paytm.wallet.rateMerchant.b.c cVar) {
        this.f71704b = application;
        this.f71705c = cVar;
    }

    public final <T extends ai> T create(Class<T> cls) {
        k.c(cls, "modelClass");
        if (cls.isAssignableFrom(a.class)) {
            return (ai) new a(this.f71705c);
        }
        throw new IllegalArgumentException("Unknown viewmodel class " + cls.getName());
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
            c a3 = c.f71703d;
            if (a3 != null) {
                return a3;
            }
            synchronized (c.class) {
                a2 = c.f71703d;
                if (a2 == null) {
                    d.a aVar = d.f71644a;
                    b.a aVar2 = b.f71634b;
                    b a4 = b.a.a(application);
                    a.C1456a aVar3 = net.one97.paytm.wallet.rateMerchant.b.a.f71628c;
                    a2 = new c(application, d.a.a(application, a4, a.C1456a.a(application)), (byte) 0);
                    c.f71703d = a2;
                }
            }
            return a2;
        }
    }
}
