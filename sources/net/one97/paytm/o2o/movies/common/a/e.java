package net.one97.paytm.o2o.movies.common.a;

import android.view.View;
import kotlin.g.b.k;

public final class e {
    public static final boolean a(View view) {
        k.c(view, "$this$isVisible");
        return view.getVisibility() == 0;
    }

    public static final void a(View view, boolean z) {
        k.c(view, "$this$isVisible");
        view.setVisibility(z ? 0 : 8);
    }

    public static final void b(View view, boolean z) {
        k.c(view, "$this$isInvisible");
        view.setVisibility(z ? 4 : 0);
    }

    public static final void b(View view) {
        if (view != null) {
            view.setClickable(false);
            view.postDelayed(new a(view), 3000);
        }
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f75000a;

        a(View view) {
            this.f75000a = view;
        }

        public final void run() {
            try {
                this.f75000a.setClickable(true);
            } catch (Exception unused) {
            }
        }
    }
}
