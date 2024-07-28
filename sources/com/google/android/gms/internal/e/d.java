package com.google.android.gms.internal.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class d extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private static f f9460a;

    public d() {
    }

    public d(Looper looper) {
        super(looper);
    }

    public d(Looper looper, Handler.Callback callback) {
        super(looper, callback);
    }

    public boolean sendMessageAtTime(Message message, long j) {
        return super.sendMessageAtTime(message, j);
    }

    public final void dispatchMessage(Message message) {
        if (f9460a == null) {
            super.dispatchMessage(message);
        } else {
            super.dispatchMessage(message);
        }
    }
}
