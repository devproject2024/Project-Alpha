package net.one97.paytm.recharge.common.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    final View f61759a;

    /* renamed from: b  reason: collision with root package name */
    View f61760b;

    /* renamed from: c  reason: collision with root package name */
    final Activity f61761c;

    /* renamed from: d  reason: collision with root package name */
    private final ViewTreeObserver.OnGlobalLayoutListener f61762d = new ViewTreeObserver.OnGlobalLayoutListener(this) {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f61763a;

        {
            this.f61763a = r1;
        }

        public final void onGlobalLayout() {
            View view = this.f61763a.f61760b;
            if (view != null) {
                Rect rect = new Rect();
                this.f61763a.f61759a.getWindowVisibleDisplayFrame(rect);
                View rootView = this.f61763a.f61759a.getRootView();
                k.a((Object) rootView, "decorView.rootView");
                int height = rootView.getHeight() - rect.bottom;
                if (height != 0) {
                    if (view.getPaddingBottom() != height) {
                        View currentFocus = this.f61763a.f61761c.getCurrentFocus();
                        k.c(view, "firstView");
                        Rect rect2 = new Rect();
                        if (currentFocus != null) {
                            currentFocus.getWindowVisibleDisplayFrame(rect2);
                        }
                        Rect rect3 = new Rect();
                        view.getWindowVisibleDisplayFrame(rect3);
                        rect3.bottom += height;
                        view.setPadding(0, 0, 0, height);
                    }
                } else if (view.getPaddingBottom() != 0) {
                    view.setPadding(0, 0, 0, 0);
                }
            }
        }
    };

    public t(Activity activity) {
        k.c(activity, "act");
        this.f61761c = activity;
        Window window = this.f61761c.getWindow();
        k.a((Object) window, "act.window");
        View decorView = window.getDecorView();
        k.a((Object) decorView, "act.window.decorView");
        this.f61759a = decorView;
    }

    public final void a() {
        if (this.f61761c.getCurrentFocus() != null) {
            try {
                Object systemService = this.f61761c.getSystemService("input_method");
                if (systemService != null) {
                    InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                    View currentFocus = this.f61761c.getCurrentFocus();
                    inputMethodManager.hideSoftInputFromWindow(currentFocus != null ? currentFocus.getWindowToken() : null, 0);
                    return;
                }
                throw new u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            } catch (Throwable th) {
                CJRRechargeUtilities.INSTANCE.debugLogExceptions(th);
            }
        }
    }

    public static void a(View view) {
        k.c(view, "view");
        Context context = view.getContext();
        Object systemService = context != null ? context.getSystemService("input_method") : null;
        if (!(systemService instanceof InputMethodManager)) {
            systemService = null;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        if (view.getWindowToken() != null && inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
        }
    }

    public final void b() {
        Object systemService = this.f61761c.getSystemService("input_method");
        if (systemService != null) {
            ((InputMethodManager) systemService).toggleSoftInput(2, 0);
            return;
        }
        throw new u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    public static void b(View view) {
        k.c(view, "view");
        if (view.requestFocus()) {
            Context context = view.getContext();
            Object systemService = context != null ? context.getSystemService("input_method") : null;
            if (!(systemService instanceof InputMethodManager)) {
                systemService = null;
            }
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(view, 1);
            }
        }
    }
}
