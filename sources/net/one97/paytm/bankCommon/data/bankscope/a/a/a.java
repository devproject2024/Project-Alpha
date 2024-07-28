package net.one97.paytm.bankCommon.data.bankscope.a.a;

import android.app.Application;
import android.content.Context;
import kotlin.d.d;
import kotlin.g.b.k;
import kotlin.n;
import kotlin.x;
import net.one97.paytm.bankCommon.b.c;
import net.one97.paytm.bankCommon.utils.e;
import net.one97.paytm.bankOpen.d.c;

public final class a implements net.one97.paytm.bankCommon.data.bankscope.a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0222a f16246a = new C0222a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f16247c;

    /* renamed from: b  reason: collision with root package name */
    private Application f16248b;

    private a(Application application) {
        this.f16248b = application;
    }

    public /* synthetic */ a(Application application, byte b2) {
        this(application);
    }

    public final Object a(String str, String str2, d<? super c<? extends Object>> dVar) {
        c.a aVar = c.f16215d;
        byte[] bytes = "SUCCESS".getBytes(kotlin.m.d.f47971a);
        k.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
        return c.a.a(new String(bytes, kotlin.m.d.f47971a));
    }

    public final Object b(String str, String str2, d<? super c<? extends Object>> dVar) {
        throw new n("An operation is not implemented: ".concat("Not yet implemented"));
    }

    public final Object a(String str, d<? super c<? extends Object>> dVar) {
        c.a aVar = c.f16215d;
        byte[] bytes = "SUCCESS".getBytes(kotlin.m.d.f47971a);
        k.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
        return c.a.a(new String(bytes, kotlin.m.d.f47971a));
    }

    public final Object a(d<? super c<? extends Object>> dVar) {
        c.a aVar = c.f16215d;
        byte[] bytes = "SUCCESS".getBytes(kotlin.m.d.f47971a);
        k.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
        return c.a.a(new String(bytes, kotlin.m.d.f47971a));
    }

    public final void a(String str, String str2) {
        k.c(str, "bankScopeToken");
        k.c(str2, "refreshToken");
        e.a aVar = e.f16328a;
        Context context = this.f16248b;
        k.c(str, "bankUserToken");
        k.c(context, "context");
        c.a aVar2 = net.one97.paytm.bankOpen.d.c.f16425a;
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        com.paytm.b.a.a a2 = c.a.a(applicationContext);
        if (a2 != null) {
            a2.a("bank_user_token", str, false);
        }
        e.a aVar3 = e.f16328a;
        Context context2 = this.f16248b;
        k.c(str2, "refreshToken");
        k.c(context2, "context");
        c.a aVar4 = net.one97.paytm.bankOpen.d.c.f16425a;
        Context applicationContext2 = context2.getApplicationContext();
        k.a((Object) applicationContext2, "context.applicationContext");
        com.paytm.b.a.a a3 = c.a.a(applicationContext2);
        if (a3 != null) {
            a3.a("bank_refresh_token", str2, false);
        }
    }

    /* renamed from: net.one97.paytm.bankCommon.data.bankscope.a.a.a$a  reason: collision with other inner class name */
    public static final class C0222a {
        private C0222a() {
        }

        public /* synthetic */ C0222a(byte b2) {
            this();
        }

        public static a a(Application application) {
            k.c(application, "application");
            if (a.f16247c == null) {
                synchronized (net.one97.paytm.bankCommon.data.bankscope.a.b.a.class) {
                    if (a.f16247c == null) {
                        a.f16247c = new a(application, (byte) 0);
                    }
                    x xVar = x.f47997a;
                }
            }
            a a2 = a.f16247c;
            if (a2 == null) {
                k.a();
            }
            return a2;
        }
    }
}
