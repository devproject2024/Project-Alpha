package net.one97.paytm.paymentsBank.utils;

import android.app.Application;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import kotlin.x;
import net.one97.paytm.bankCommon.data.bankscope.a.a.a;
import net.one97.paytm.bankCommon.data.bankscope.a.b.a;
import net.one97.paytm.bankCommon.data.bankscope.b;

public final class k extends al.d {

    /* renamed from: a  reason: collision with root package name */
    public static final a f19520a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static volatile k f19521c;

    /* renamed from: b  reason: collision with root package name */
    private Application f19522b;

    public static final k a(Application application) {
        return a.a(application);
    }

    public k(Application application) {
        kotlin.g.b.k.c(application, "application");
        this.f19522b = application;
    }

    public final <T extends ai> T create(Class<T> cls) {
        kotlin.g.b.k.c(cls, "modelClass");
        if (kotlin.g.b.k.a((Object) cls, (Object) net.one97.paytm.paymentsBank.i.a.class)) {
            b.a aVar = b.f16256a;
            a.C0222a aVar2 = net.one97.paytm.bankCommon.data.bankscope.a.a.a.f16246a;
            a.C0223a aVar3 = net.one97.paytm.bankCommon.data.bankscope.a.b.a.f16249a;
            return (ai) new net.one97.paytm.paymentsBank.i.a(b.a.a(a.C0222a.a(this.f19522b), a.C0223a.a(this.f19522b)));
        } else if (!kotlin.g.b.k.a((Object) cls, (Object) net.one97.paytm.paymentsBank.passcode.a.class)) {
            return null;
        } else {
            b.a aVar4 = b.f16256a;
            a.C0222a aVar5 = net.one97.paytm.bankCommon.data.bankscope.a.a.a.f16246a;
            a.C0223a aVar6 = net.one97.paytm.bankCommon.data.bankscope.a.b.a.f16249a;
            return (ai) new net.one97.paytm.paymentsBank.passcode.a(b.a.a(a.C0222a.a(this.f19522b), a.C0223a.a(this.f19522b)));
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static k a(Application application) {
            kotlin.g.b.k.c(application, "application");
            if (k.f19521c == null) {
                synchronized (k.class) {
                    a aVar = k.f19520a;
                    if (k.f19521c == null) {
                        a aVar2 = k.f19520a;
                        k.f19521c = new k(application);
                    }
                    x xVar = x.f47997a;
                }
            }
            k a2 = k.f19521c;
            if (a2 == null) {
                kotlin.g.b.k.a();
            }
            return a2;
        }
    }
}
