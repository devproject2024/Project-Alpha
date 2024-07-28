package com.google.android.play.core.assetpacks;

import java.util.concurrent.ThreadFactory;

final /* synthetic */ class cy implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    static final ThreadFactory f37184a = new cy();

    private cy() {
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, "AssetPackBackgroundExecutor");
    }
}
