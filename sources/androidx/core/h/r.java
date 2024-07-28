package androidx.core.h;

import android.view.View;
import android.view.ViewTreeObserver;

public final class r implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a  reason: collision with root package name */
    private final View f3116a;

    /* renamed from: b  reason: collision with root package name */
    private ViewTreeObserver f3117b;

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f3118c;

    private r(View view, Runnable runnable) {
        this.f3116a = view;
        this.f3117b = view.getViewTreeObserver();
        this.f3118c = runnable;
    }

    public static r a(View view, Runnable runnable) {
        if (view != null) {
            r rVar = new r(view, runnable);
            view.getViewTreeObserver().addOnPreDrawListener(rVar);
            view.addOnAttachStateChangeListener(rVar);
            return rVar;
        }
        throw new NullPointerException("view == null");
    }

    public final boolean onPreDraw() {
        a();
        this.f3118c.run();
        return true;
    }

    private void a() {
        if (this.f3117b.isAlive()) {
            this.f3117b.removeOnPreDrawListener(this);
        } else {
            this.f3116a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f3116a.removeOnAttachStateChangeListener(this);
    }

    public final void onViewAttachedToWindow(View view) {
        this.f3117b = view.getViewTreeObserver();
    }

    public final void onViewDetachedFromWindow(View view) {
        a();
    }
}
