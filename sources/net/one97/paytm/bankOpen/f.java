package net.one97.paytm.bankOpen;

import java.lang.reflect.InvocationTargetException;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static f f16431a;

    /* renamed from: b  reason: collision with root package name */
    private c f16432b;

    /* renamed from: c  reason: collision with root package name */
    private d f16433c;

    /* renamed from: d  reason: collision with root package name */
    private e f16434d;

    public static void a(c cVar) {
        if (f16431a == null) {
            f fVar = new f();
            f16431a = fVar;
            fVar.f16432b = cVar;
            if (cVar instanceof d) {
                f16431a.f16433c = (d) cVar;
            } else {
                f16431a.f16433c = new b();
            }
            if (cVar instanceof e) {
                f16431a.f16434d = (e) cVar;
            } else {
                f16431a.f16434d = new a();
            }
            BankCommonProvider.init();
        }
    }

    private static f e() {
        if (f16431a == null) {
            synchronized (f.class) {
                try {
                    Class.forName("net.one97.paytm.paymentsBank.AccOpenHelperProvider").getMethod("init", new Class[0]).invoke((Object) null, new Object[0]);
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
        }
        f fVar = f16431a;
        if (fVar != null) {
            return fVar;
        }
        throw new RuntimeException("getInstance() called before PaymentsBankImplProvider's init()");
    }

    public static c a() {
        return e().f16432b;
    }

    public static d b() {
        return e().f16433c;
    }

    public static e c() {
        return e().f16434d;
    }

    public static boolean d() {
        return f16431a == null;
    }
}
