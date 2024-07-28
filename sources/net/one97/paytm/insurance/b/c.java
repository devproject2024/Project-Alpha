package net.one97.paytm.insurance.b;

import java.lang.reflect.InvocationTargetException;
import net.one97.paytm.insurance.a.a;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f13989a;

    /* renamed from: b  reason: collision with root package name */
    private a f13990b;

    private c() {
    }

    public static void a(a aVar) {
        if (f13989a == null) {
            c cVar = new c();
            f13989a = cVar;
            cVar.f13990b = aVar;
        }
    }

    private static c b() {
        if (f13989a == null) {
            synchronized (c.class) {
                try {
                    Class.forName("net.one97.paytm.dynamic.module.insurance.InsuranceImplProvider").getMethod("init", new Class[0]).invoke((Object) null, new Object[0]);
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
        c cVar = f13989a;
        if (cVar != null) {
            return cVar;
        }
        throw new RuntimeException("getInstance() called before InsuranceImplProvider's init()");
    }

    public static a a() {
        return b().f13990b;
    }
}
