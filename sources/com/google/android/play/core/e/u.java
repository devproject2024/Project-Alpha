package com.google.android.play.core.e;

import java.util.concurrent.CountDownLatch;

public final class u implements b, c {

    /* renamed from: a  reason: collision with root package name */
    public final CountDownLatch f37483a = new CountDownLatch(1);

    private u() {
    }

    public /* synthetic */ u(byte b2) {
    }

    public final void onFailure(Exception exc) {
        this.f37483a.countDown();
    }

    public final void onSuccess(Object obj) {
        this.f37483a.countDown();
    }
}
