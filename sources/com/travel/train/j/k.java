package com.travel.train.j;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.util.HashMap;

public final class k implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: e  reason: collision with root package name */
    private static HashMap<a, k> f27570e = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    private a f27571a;

    /* renamed from: b  reason: collision with root package name */
    private View f27572b;

    /* renamed from: c  reason: collision with root package name */
    private Boolean f27573c = null;

    /* renamed from: d  reason: collision with root package name */
    private float f27574d;

    public interface a {
        void onToggleSoftKeyboard(boolean z);
    }

    public final void onGlobalLayout() {
        Rect rect = new Rect();
        this.f27572b.getWindowVisibleDisplayFrame(rect);
        boolean z = ((float) (this.f27572b.getRootView().getHeight() - (rect.bottom - rect.top))) / this.f27574d > 200.0f;
        if (this.f27571a != null) {
            Boolean bool = this.f27573c;
            if (bool == null || z != bool.booleanValue()) {
                this.f27573c = Boolean.valueOf(z);
                this.f27571a.onToggleSoftKeyboard(z);
            }
        }
    }

    public static void a(Activity activity, a aVar) {
        a(aVar);
        f27570e.put(aVar, new k(activity, aVar));
    }

    public static void a(a aVar) {
        if (f27570e.containsKey(aVar)) {
            f27570e.get(aVar).a();
            f27570e.remove(aVar);
        }
    }

    private void a() {
        this.f27571a = null;
        this.f27572b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    private k(Activity activity, a aVar) {
        this.f27571a = aVar;
        this.f27572b = ((ViewGroup) activity.findViewById(16908290)).getChildAt(0);
        this.f27572b.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.f27574d = activity.getResources().getDisplayMetrics().density;
    }
}
