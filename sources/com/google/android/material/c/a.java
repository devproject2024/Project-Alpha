package com.google.android.material.c;

import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

public final class a implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private final Dialog f36058a;

    /* renamed from: b  reason: collision with root package name */
    private final int f36059b;

    /* renamed from: c  reason: collision with root package name */
    private final int f36060c;

    /* renamed from: d  reason: collision with root package name */
    private final int f36061d;

    public a(Dialog dialog, Rect rect) {
        this.f36058a = dialog;
        this.f36059b = rect.left;
        this.f36060c = rect.top;
        this.f36061d = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        View findViewById = view.findViewById(16908290);
        int left = this.f36059b + findViewById.getLeft();
        int width = findViewById.getWidth() + left;
        int top = this.f36060c + findViewById.getTop();
        if (new RectF((float) left, (float) top, (float) width, (float) (findViewById.getHeight() + top)).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            obtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            obtain.setAction(0);
            int i2 = this.f36061d;
            obtain.setLocation((float) ((-i2) - 1), (float) ((-i2) - 1));
        }
        view.performClick();
        return this.f36058a.onTouchEvent(obtain);
    }
}
