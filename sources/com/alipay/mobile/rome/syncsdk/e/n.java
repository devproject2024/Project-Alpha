package com.alipay.mobile.rome.syncsdk.e;

import java.util.concurrent.ThreadFactory;

final class n implements ThreadFactory {
    private n() {
    }

    /* synthetic */ n(byte b2) {
        this();
    }

    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("sync_receive:" + thread.getId());
        thread.setPriority(5);
        return thread;
    }
}
