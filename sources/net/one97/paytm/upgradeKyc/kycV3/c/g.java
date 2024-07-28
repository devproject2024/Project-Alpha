package net.one97.paytm.upgradeKyc.kycV3.c;

import android.app.Application;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import kotlin.g.b.k;
import net.one97.paytm.upgradeKyc.data.a.a.a.a;
import net.one97.paytm.upgradeKyc.data.a.a.b;
import net.one97.paytm.upgradeKyc.data.a.a.b.a;
import net.one97.paytm.upgradeKyc.data.a.b;
import net.one97.paytm.upgradeKyc.data.a.b.a;
import net.one97.paytm.upgradeKyc.data.a.c.a;
import net.one97.paytm.upgradeKyc.kycV3.b.c;
import net.one97.paytm.upgradeKyc.videokyc.b.b;
import net.one97.paytm.upgradeKyc.videokyc.b.d;

public final class g extends al.d {

    /* renamed from: a  reason: collision with root package name */
    public static final a f66236a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static volatile g f66237d;

    /* renamed from: b  reason: collision with root package name */
    private final Application f66238b;

    /* renamed from: c  reason: collision with root package name */
    private final c f66239c;

    public /* synthetic */ g(Application application, c cVar, byte b2) {
        this(application, cVar);
    }

    private g(Application application, c cVar) {
        this.f66238b = application;
        this.f66239c = cVar;
    }

    public final <T extends ai> T create(Class<T> cls) {
        k.c(cls, "modelClass");
        if (cls.isAssignableFrom(net.one97.paytm.upgradeKyc.videokyc.b.c.class)) {
            return (ai) new net.one97.paytm.upgradeKyc.videokyc.b.c(this.f66238b, this.f66239c);
        }
        if (cls.isAssignableFrom(d.class)) {
            return (ai) new d(this.f66238b, this.f66239c);
        }
        if (cls.isAssignableFrom(net.one97.paytm.upgradeKyc.videokyc.b.a.class)) {
            return (ai) new net.one97.paytm.upgradeKyc.videokyc.b.a(this.f66238b, this.f66239c);
        }
        if (cls.isAssignableFrom(b.class)) {
            return (ai) new b(this.f66238b, this.f66239c);
        }
        if (cls.isAssignableFrom(e.class)) {
            return (ai) new e(this.f66238b, this.f66239c);
        }
        if (cls.isAssignableFrom(j.class)) {
            return (ai) new j(this.f66238b, this.f66239c);
        }
        if (cls.isAssignableFrom(c.class)) {
            return (ai) new c(this.f66238b, this.f66239c);
        }
        if (cls.isAssignableFrom(a.class)) {
            return (ai) new a(this.f66238b, this.f66239c);
        }
        if (cls.isAssignableFrom(net.one97.paytm.upgradeKyc.aotp.b.a.class)) {
            return (ai) new net.one97.paytm.upgradeKyc.aotp.b.a(this.f66238b, this.f66239c);
        }
        if (cls.isAssignableFrom(net.one97.paytm.upgradeKyc.aotp.b.b.class)) {
            return (ai) new net.one97.paytm.upgradeKyc.aotp.b.b(this.f66238b, this.f66239c);
        }
        if (cls.isAssignableFrom(h.class)) {
            return (ai) new h(this.f66238b, this.f66239c);
        }
        if (cls.isAssignableFrom(l.class)) {
            return (ai) new l(this.f66238b, this.f66239c);
        }
        if (cls.isAssignableFrom(net.one97.paytm.upgradeKyc.minkycotp.a.class)) {
            b.a aVar = net.one97.paytm.upgradeKyc.data.a.b.f65789a;
            a.C1303a aVar2 = net.one97.paytm.upgradeKyc.data.a.b.a.f65793a;
            a.C1304a aVar3 = net.one97.paytm.upgradeKyc.data.a.c.a.f65795a;
            return (ai) new net.one97.paytm.upgradeKyc.minkycotp.a(b.a.a(a.C1303a.a(), a.C1304a.a(this.f66238b)));
        } else if (cls.isAssignableFrom(net.one97.paytm.upgradeKyc.aotp.b.c.class)) {
            b.a aVar4 = net.one97.paytm.upgradeKyc.data.a.a.b.f65778a;
            a.C1300a aVar5 = net.one97.paytm.upgradeKyc.data.a.a.a.a.f65775a;
            a.C1301a aVar6 = net.one97.paytm.upgradeKyc.data.a.a.b.a.f65782a;
            return (ai) new net.one97.paytm.upgradeKyc.aotp.b.c(b.a.a(a.C1300a.a(this.f66238b), a.C1301a.a(this.f66238b)));
        } else {
            throw new IllegalArgumentException("Unknown viewmodel class " + cls.getName());
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static g a(Application application) {
            g a2;
            k.c(application, "application");
            g a3 = g.f66237d;
            if (a3 != null) {
                return a3;
            }
            synchronized (g.class) {
                a2 = g.f66237d;
                if (a2 == null) {
                    net.one97.paytm.upgradeKyc.kycV3.a aVar = net.one97.paytm.upgradeKyc.kycV3.a.f66033a;
                    a2 = new g(application, net.one97.paytm.upgradeKyc.kycV3.a.a(application), (byte) 0);
                    g.f66237d = a2;
                }
            }
            return a2;
        }
    }
}
