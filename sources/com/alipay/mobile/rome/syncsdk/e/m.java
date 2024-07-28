package com.alipay.mobile.rome.syncsdk.e;

import java.util.concurrent.ThreadFactory;

final class m implements ThreadFactory {
    private m() {
    }

    /* synthetic */ m(byte b2) {
        this();
    }

    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("sync_dispatch:" + thread.getId());
        thread.setPriority(5);
        return thread;
    }
}
