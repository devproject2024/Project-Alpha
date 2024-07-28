package net.one97.paytm.wifi.c;

public final class a {
    public static void a() {
        Class[] clsArr = new Class[0];
        try {
            Class<?> cls = Class.forName("net.one97.paytm.dynamic.module.wifi.WifiInitActivity");
            cls.getDeclaredMethod("reInitialized", clsArr).invoke(cls.newInstance(), (Object[]) null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
