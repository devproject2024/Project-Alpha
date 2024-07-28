package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import com.google.android.material.k.h;
import com.google.android.material.k.m;

final class c extends h {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f36811a;

    /* renamed from: b  reason: collision with root package name */
    private final RectF f36812b;

    /* renamed from: c  reason: collision with root package name */
    private int f36813c;

    c() {
        this((m) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    c(m mVar) {
        super(mVar == null ? new m() : mVar);
        this.f36811a = new Paint(1);
        this.f36811a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f36811a.setColor(-1);
        this.f36811a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.f36812b = new RectF();
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        return !this.f36812b.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public final void a(float f2, float f3, float f4, float f5) {
        if (f2 != this.f36812b.left || f3 != this.f36812b.top || f4 != this.f36812b.right || f5 != this.f36812b.bottom) {
            this.f36812b.set(f2, f3, f4, f5);
            invalidateSelf();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(RectF rectF) {
        a(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    public final void draw(Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (callback instanceof View) {
            View view = (View) callback;
            if (view.getLayerType() != 2) {
                view.setLayerType(2, (Paint) null);
            }
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.f36813c = canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), (Paint) null);
        } else {
            this.f36813c = canvas.saveLayer(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), (Paint) null, 31);
        }
        super.draw(canvas);
        canvas.drawRect(this.f36812b, this.f36811a);
        if (!(getCallback() instanceof View)) {
            canvas.restoreToCount(this.f36813c);
        }
    }
}
