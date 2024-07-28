package net.one97.paytm.recharge.di;

import android.content.Context;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.a.a;
import com.paytm.utility.q;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.recharge.automatic.c.d;
import net.one97.paytm.recharge.common.utils.CJRRechargeAuthReceiver;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final f f62644a = new f();

    /* renamed from: b  reason: collision with root package name */
    private static b f62645b;

    /* renamed from: c  reason: collision with root package name */
    private static d f62646c;

    /* renamed from: d  reason: collision with root package name */
    private static a f62647d;

    /* renamed from: e  reason: collision with root package name */
    private static e f62648e;

    /* renamed from: f  reason: collision with root package name */
    private static c f62649f;

    private f() {
    }

    public final void a(b bVar) {
        k.c(bVar, "mIJRDependencyHelper");
        f62645b = bVar;
        Context e2 = e();
        if (e2 != null) {
            a.a(e2).a(new CJRRechargeAuthReceiver(), new IntentFilter("action_update_login_status"));
        }
        d dVar = d.f60262c;
        if (e2 == null) {
            k.a();
        }
        d.a(new net.one97.paytm.recharge.automatic.a(e2));
    }

    public final d a() {
        b bVar = f62645b;
        if (!(bVar instanceof d)) {
            bVar = null;
        }
        d dVar = bVar;
        f62646c = dVar;
        if (dVar == null) {
            f();
            b bVar2 = f62645b;
            if (!(bVar2 instanceof d)) {
                bVar2 = null;
            }
            d dVar2 = bVar2;
            f62646c = dVar2;
            if (dVar2 == null) {
                k.a();
            }
            return dVar2;
        }
        d dVar3 = f62646c;
        if (dVar3 == null) {
            k.a();
        }
        return dVar3;
    }

    public final a b() {
        b bVar = f62645b;
        if (!(bVar instanceof a)) {
            bVar = null;
        }
        f62647d = bVar;
        if (f62645b == null) {
            f();
            b bVar2 = f62645b;
            if (bVar2 != null) {
                a aVar = bVar2;
                f62647d = aVar;
                if (aVar == null) {
                    k.a();
                }
                return aVar;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.di.IJRActivityNavigationHelper");
        }
        a aVar2 = f62647d;
        if (aVar2 == null) {
            k.a();
        }
        return aVar2;
    }

    public final e c() {
        b bVar = f62645b;
        if (!(bVar instanceof e)) {
            bVar = null;
        }
        e eVar = bVar;
        f62648e = eVar;
        if (eVar == null) {
            f();
            b bVar2 = f62645b;
            if (!(bVar2 instanceof e)) {
                bVar2 = null;
            }
            e eVar2 = bVar2;
            f62648e = eVar2;
            if (eVar2 == null) {
                k.a();
            }
            return eVar2;
        }
        e eVar3 = f62648e;
        if (eVar3 == null) {
            k.a();
        }
        return eVar3;
    }

    public final c d() {
        b bVar = f62645b;
        if (!(bVar instanceof c)) {
            bVar = null;
        }
        c cVar = bVar;
        f62649f = cVar;
        if (cVar == null) {
            f();
            b bVar2 = f62645b;
            if (bVar2 != null) {
                c cVar2 = bVar2;
                f62649f = cVar2;
                if (cVar2 == null) {
                    k.a();
                }
                return cVar2;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.di.IJRRechargeEvents");
        }
        c cVar3 = f62649f;
        if (cVar3 == null) {
            k.a();
        }
        return cVar3;
    }

    public final Context e() {
        e c2 = c();
        if (c2 != null) {
            return c2.getApplicationContext();
        }
        return null;
    }

    private final void f() {
        try {
            Class<?> cls = Class.forName("net.one97.paytm.app.CJRJarvisApplication");
            k.a((Object) cls, "Class.forName(\"net.one97…pp.CJRJarvisApplication\")");
            Method declaredMethod = cls.getDeclaredMethod("getAppContext", new Class[0]);
            k.a((Object) declaredMethod, "jarvisApplicationCls.get…edMethod(\"getAppContext\")");
            Object invoke = declaredMethod.invoke((Object) null, new Object[0]);
            if (!(invoke instanceof Context)) {
                invoke = null;
            }
            Class<?> cls2 = Class.forName("net.one97.paytm.recharge.CJRJarvisCommonComponentImpl");
            k.a((Object) cls2, "Class.forName(\"net.one97…rvisCommonComponentImpl\")");
            Constructor<?> constructor = cls2.getConstructor(new Class[]{Context.class});
            k.a((Object) constructor, "cls.getConstructor(Context::class.java)");
            Object newInstance = constructor.newInstance(new Object[]{(Context) invoke});
            if (newInstance != null) {
                a((b) newInstance);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.di.IJRRechargeComponent");
        } catch (Exception e2) {
            q.d(e2.getMessage());
        }
    }
}
