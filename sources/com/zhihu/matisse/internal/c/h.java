package com.zhihu.matisse.internal.c;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    Activity f45750a;

    /* renamed from: b  reason: collision with root package name */
    View f45751b;

    /* renamed from: c  reason: collision with root package name */
    int f45752c;

    /* renamed from: d  reason: collision with root package name */
    FrameLayout.LayoutParams f45753d;

    /* renamed from: e  reason: collision with root package name */
    int f45754e;

    /* renamed from: f  reason: collision with root package name */
    boolean f45755f = true;

    /* renamed from: g  reason: collision with root package name */
    int f45756g;

    public h(Activity activity) {
        this.f45750a = activity;
        this.f45751b = ((FrameLayout) activity.findViewById(16908290)).getChildAt(0);
        this.f45751b.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                int i2;
                if (h.this.f45755f) {
                    h hVar = h.this;
                    hVar.f45754e = hVar.f45751b.getHeight();
                    h.this.f45755f = false;
                }
                h hVar2 = h.this;
                Activity activity = hVar2.f45750a;
                Rect rect = new Rect();
                activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int i3 = rect.top;
                Rect rect2 = new Rect();
                hVar2.f45751b.getWindowVisibleDisplayFrame(rect2);
                if (Build.VERSION.SDK_INT >= 19) {
                    i2 = (rect2.bottom - rect2.top) + i3;
                } else {
                    i2 = rect2.bottom - rect2.top;
                }
                if (i2 != hVar2.f45752c) {
                    int height = hVar2.f45751b.getRootView().getHeight();
                    int i4 = height - i2;
                    if (i4 <= height / 4) {
                        hVar2.f45753d.height = hVar2.f45754e;
                    } else if (Build.VERSION.SDK_INT >= 19) {
                        hVar2.f45753d.height = (height - i4) + hVar2.f45756g;
                    } else {
                        hVar2.f45753d.height = height - i4;
                    }
                    hVar2.f45751b.requestLayout();
                    hVar2.f45752c = i2;
                }
            }
        });
        this.f45753d = (FrameLayout.LayoutParams) this.f45751b.getLayoutParams();
    }
}
