package com.squareup.picasso;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

final class h implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a  reason: collision with root package name */
    final WeakReference<ImageView> f45411a;

    /* renamed from: b  reason: collision with root package name */
    e f45412b;

    /* renamed from: c  reason: collision with root package name */
    private final aa f45413c;

    h(aa aaVar, ImageView imageView, e eVar) {
        this.f45413c = aaVar;
        this.f45411a = new WeakReference<>(imageView);
        this.f45412b = eVar;
        imageView.addOnAttachStateChangeListener(this);
        if (imageView.getWindowToken() != null) {
            onViewAttachedToWindow(imageView);
        }
    }

    public final void onViewAttachedToWindow(View view) {
        view.getViewTreeObserver().addOnPreDrawListener(this);
    }

    public final void onViewDetachedFromWindow(View view) {
        view.getViewTreeObserver().removeOnPreDrawListener(this);
    }

    public final boolean onPreDraw() {
        ImageView imageView = (ImageView) this.f45411a.get();
        if (imageView == null) {
            return true;
        }
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        int width = imageView.getWidth();
        int height = imageView.getHeight();
        if (width > 0 && height > 0) {
            imageView.removeOnAttachStateChangeListener(this);
            viewTreeObserver.removeOnPreDrawListener(this);
            this.f45411a.clear();
            aa aaVar = this.f45413c;
            aaVar.f45353b = false;
            aaVar.a(width, height).a(imageView, this.f45412b);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f45413c.f45354c = null;
        this.f45412b = null;
        ImageView imageView = (ImageView) this.f45411a.get();
        if (imageView != null) {
            this.f45411a.clear();
            imageView.removeOnAttachStateChangeListener(this);
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
        }
    }
}
