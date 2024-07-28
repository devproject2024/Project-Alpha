package com.google.android.exoplayer2.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class z implements k {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f32594a;

    public z(Handler handler) {
        this.f32594a = handler;
    }

    public final Looper a() {
        return this.f32594a.getLooper();
    }

    public final Message a(int i2, Object obj) {
        return this.f32594a.obtainMessage(i2, obj);
    }

    public final Message a(int i2, int i3) {
        return this.f32594a.obtainMessage(i2, i3, 0);
    }

    public final Message a(int i2, int i3, Object obj) {
        return this.f32594a.obtainMessage(0, i2, i3, obj);
    }

    public final boolean a(int i2) {
        return this.f32594a.sendEmptyMessage(i2);
    }

    public final boolean a(long j) {
        return this.f32594a.sendEmptyMessageAtTime(2, j);
    }

    public final void b() {
        this.f32594a.removeMessages(2);
    }
}
