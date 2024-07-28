package com.jackpocket.scratchoff;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

public final class b<T extends View> {

    /* renamed from: a  reason: collision with root package name */
    WeakReference<T> f40795a;

    /* renamed from: b  reason: collision with root package name */
    public Canvas f40796b;

    /* renamed from: c  reason: collision with root package name */
    public Bitmap f40797c;

    /* renamed from: d  reason: collision with root package name */
    a f40798d;

    /* renamed from: e  reason: collision with root package name */
    public Paint f40799e;

    /* renamed from: f  reason: collision with root package name */
    boolean f40800f;

    public b() {
        this.f40800f = false;
        this.f40800f = false;
        this.f40797c = null;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        View view = (View) this.f40795a.get();
        if (view != null && (view instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                viewGroup.getChildAt(i2).setVisibility(8);
            }
        }
    }
}
