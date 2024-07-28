package com.google.android.play.core.assetpacks;

import java.util.concurrent.ThreadFactory;

final /* synthetic */ class cz implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    static final ThreadFactory f37185a = new cz();

    private cz() {
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "UpdateListenerExecutor");
    }
}
