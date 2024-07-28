package com.google.android.exoplayer2.video;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.exoplayer2.g.ae;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    final WindowManager f33698a;

    /* renamed from: b  reason: collision with root package name */
    final b f33699b;

    /* renamed from: c  reason: collision with root package name */
    final a f33700c;

    /* renamed from: d  reason: collision with root package name */
    long f33701d;

    /* renamed from: e  reason: collision with root package name */
    long f33702e;

    /* renamed from: f  reason: collision with root package name */
    long f33703f;

    /* renamed from: g  reason: collision with root package name */
    long f33704g;

    /* renamed from: h  reason: collision with root package name */
    long f33705h;

    /* renamed from: i  reason: collision with root package name */
    boolean f33706i;
    long j;
    long k;
    long l;

    public f() {
        this((Context) null);
    }

    public f(Context context) {
        DisplayManager displayManager;
        a aVar = null;
        if (context != null) {
            context = context.getApplicationContext();
            this.f33698a = (WindowManager) context.getSystemService("window");
        } else {
            this.f33698a = null;
        }
        if (this.f33698a != null) {
            if (ae.f32499a >= 17 && (displayManager = (DisplayManager) context.getSystemService("display")) != null) {
                aVar = new a(displayManager);
            }
            this.f33700c = aVar;
            this.f33699b = b.a();
        } else {
            this.f33700c = null;
            this.f33699b = null;
        }
        this.f33701d = -9223372036854775807L;
        this.f33702e = -9223372036854775807L;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        Display defaultDisplay = this.f33698a.getDefaultDisplay();
        if (defaultDisplay != null) {
            this.f33701d = (long) (1.0E9d / ((double) defaultDisplay.getRefreshRate()));
            this.f33702e = (this.f33701d * 80) / 100;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a(long j2, long j3) {
        return Math.abs((j3 - this.j) - (j2 - this.k)) > 20000000;
    }

    final class a implements DisplayManager.DisplayListener {

        /* renamed from: a  reason: collision with root package name */
        final DisplayManager f33707a;

        public final void onDisplayAdded(int i2) {
        }

        public final void onDisplayRemoved(int i2) {
        }

        public a(DisplayManager displayManager) {
            this.f33707a = displayManager;
        }

        public final void onDisplayChanged(int i2) {
            if (i2 == 0) {
                f.this.a();
            }
        }
    }

    static final class b implements Handler.Callback, Choreographer.FrameCallback {

        /* renamed from: c  reason: collision with root package name */
        private static final b f33709c = new b();

        /* renamed from: a  reason: collision with root package name */
        public volatile long f33710a = -9223372036854775807L;

        /* renamed from: b  reason: collision with root package name */
        final Handler f33711b;

        /* renamed from: d  reason: collision with root package name */
        private final HandlerThread f33712d = new HandlerThread("ChoreographerOwner:Handler");

        /* renamed from: e  reason: collision with root package name */
        private Choreographer f33713e;

        /* renamed from: f  reason: collision with root package name */
        private int f33714f;

        public static b a() {
            return f33709c;
        }

        private b() {
            this.f33712d.start();
            this.f33711b = ae.a(this.f33712d.getLooper(), (Handler.Callback) this);
            this.f33711b.sendEmptyMessage(0);
        }

        public final void doFrame(long j) {
            this.f33710a = j;
            this.f33713e.postFrameCallbackDelayed(this, 500);
        }

        public final boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                this.f33713e = Choreographer.getInstance();
                return true;
            } else if (i2 == 1) {
                this.f33714f++;
                if (this.f33714f == 1) {
                    this.f33713e.postFrameCallback(this);
                }
                return true;
            } else if (i2 != 2) {
                return false;
            } else {
                this.f33714f--;
                if (this.f33714f == 0) {
                    this.f33713e.removeFrameCallback(this);
                    this.f33710a = -9223372036854775807L;
                }
                return true;
            }
        }
    }
}
