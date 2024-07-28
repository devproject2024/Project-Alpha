package com.bumptech.glide.load.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class y {

    /* renamed from: a  reason: collision with root package name */
    private boolean f6967a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f6968b = new Handler(Looper.getMainLooper(), new a());

    y() {
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(v<?> vVar, boolean z) {
        if (!this.f6967a) {
            if (!z) {
                this.f6967a = true;
                vVar.d();
                this.f6967a = false;
                return;
            }
        }
        this.f6968b.obtainMessage(1, vVar).sendToTarget();
    }

    static final class a implements Handler.Callback {
        a() {
        }

        public final boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((v) message.obj).d();
            return true;
        }
    }
}
