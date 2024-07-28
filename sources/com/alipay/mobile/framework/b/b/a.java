package com.alipay.mobile.framework.b.b;

public class a {
    public static boolean a(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setPriority(10);
        thread.setName("h5_init_uc_thread");
        thread.start();
        return true;
    }
}
