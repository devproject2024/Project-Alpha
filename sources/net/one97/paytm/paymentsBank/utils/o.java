package net.one97.paytm.paymentsBank.utils;

import java.lang.reflect.InvocationTargetException;
import net.one97.paytm.paymentsBank.AccOpenHelperProvider;
import net.one97.paytm.paymentsBank.h.a;

public class o {

    /* renamed from: a  reason: collision with root package name */
    private static o f19530a;

    /* renamed from: b  reason: collision with root package name */
    private a f19531b;

    private o() {
    }

    public static void a(a aVar) {
        if (f19530a == null) {
            o oVar = new o();
            f19530a = oVar;
            oVar.f19531b = aVar;
            AccOpenHelperProvider.init();
        }
    }

    private static o c() {
        if (f19530a == null) {
            synchronized (o.class) {
                d();
            }
        }
        o oVar = f19530a;
        if (oVar != null) {
            return oVar;
        }
        throw new RuntimeException("getInstance() called before PaymentsBankImplProvider's init()");
    }

    private static void d() {
        try {
            Class.forName("net.one97.paytm.dynamic.module.bank.PaymentsBankImplProvider").getMethod("init", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
        } catch (IllegalAccessException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
    }

    public static a a() {
        return c().f19531b;
    }

    public static boolean b() {
        if (f19530a == null) {
            d();
        }
        return f19530a == null;
    }
}
