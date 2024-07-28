package net.one97.paytm.feed.utility;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;
import kotlin.g.b.k;
import kotlin.u;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f35396a = new g();

    private g() {
    }

    public static void a(Activity activity) {
        k.c(activity, "activity");
        Object systemService = activity.getSystemService("input_method");
        if (systemService != null) {
            ((InputMethodManager) systemService).toggleSoftInput(1, 0);
            return;
        }
        throw new u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }
}
