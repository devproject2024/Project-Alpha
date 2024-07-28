package net.one97.paytm.hotel4.utils;

import android.view.View;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.x;

public final class h {

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f28648a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f28649b;

        a(View view, b bVar) {
            this.f28648a = view;
            this.f28649b = bVar;
        }

        public final void run() {
            this.f28649b.invoke(this.f28648a);
        }
    }

    public static final void a(View view, b<? super View, x> bVar) {
        k.c(view, "$this$setOnClickListenerThrottled");
        k.c(bVar, "onClick");
        view.setOnClickListener(new g(new a(view, bVar)));
    }
}
