package net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.tooltip;

import android.os.Build;
import android.view.ViewTreeObserver;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    static final b f55165a;

    static class b {
        b() {
        }

        public void a(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
        }
    }

    static class a extends b {
        a() {
        }

        public final void a(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 16) {
            f55165a = new a();
        } else {
            f55165a = new b();
        }
    }

    public static void a(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        f55165a.a(viewTreeObserver, onGlobalLayoutListener);
    }
}
