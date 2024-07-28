package net.one97.paytm.hotel4.utils;

import android.os.SystemClock;
import android.view.View;
import kotlin.g.b.k;

public final class g implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f28644a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private long f28645b;

    /* renamed from: c  reason: collision with root package name */
    private int f28646c = 1000;

    /* renamed from: d  reason: collision with root package name */
    private final Runnable f28647d;

    public g(Runnable runnable) {
        k.c(runnable, "onClickAction");
        this.f28647d = runnable;
    }

    public final void onClick(View view) {
        k.c(view, "v");
        if (SystemClock.elapsedRealtime() - this.f28645b >= ((long) this.f28646c)) {
            this.f28645b = SystemClock.elapsedRealtime();
            view.post(this.f28647d);
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final void a(View view, Runnable runnable) {
        k.c(runnable, "action");
        if (view != null) {
            view.setOnClickListener(new g(runnable));
        }
    }
}
