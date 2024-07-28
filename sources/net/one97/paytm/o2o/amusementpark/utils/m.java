package net.one97.paytm.o2o.amusementpark.utils;

public final class m {
    public static void a() {
        Class[] clsArr = new Class[0];
        try {
            Class<?> cls = Class.forName("net.one97.paytm.dynamic.module.amusement.AmParkInitActivity");
            cls.getDeclaredMethod("reInitialized", clsArr).invoke(cls.newInstance(), (Object[]) null);
        } catch (Exception unused) {
        }
    }
}
