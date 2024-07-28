package com.google.android.gms.internal.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class k extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private static volatile j f9113a;

    public k() {
    }

    public k(Looper looper) {
        super(looper);
    }

    public k(Looper looper, Handler.Callback callback) {
        super(looper, callback);
    }

    public final void dispatchMessage(Message message) {
        super.dispatchMessage(message);
    }
}
