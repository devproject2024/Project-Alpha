package com.google.android.material.circularreveal.coordinatorlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.circularreveal.b;
import com.google.android.material.circularreveal.c;

public class CircularRevealCoordinatorLayout extends CoordinatorLayout implements c {

    /* renamed from: h  reason: collision with root package name */
    private final b f36136h;

    public CircularRevealCoordinatorLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public CircularRevealCoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36136h = new b(this);
    }

    public final void a() {
        this.f36136h.a();
    }

    public final void b() {
        this.f36136h.b();
    }

    public void setRevealInfo(c.d dVar) {
        this.f36136h.a(dVar);
    }

    public c.d getRevealInfo() {
        return this.f36136h.c();
    }

    public void setCircularRevealScrimColor(int i2) {
        this.f36136h.a(i2);
    }

    public int getCircularRevealScrimColor() {
        return this.f36136h.f36120b.getColor();
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.f36136h.f36121c;
    }

    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f36136h.a(drawable);
    }

    public void draw(Canvas canvas) {
        b bVar = this.f36136h;
        if (bVar != null) {
            bVar.a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    public final void a(Canvas canvas) {
        super.draw(canvas);
    }

    public boolean isOpaque() {
        b bVar = this.f36136h;
        if (bVar != null) {
            return bVar.d();
        }
        return super.isOpaque();
    }

    public final boolean c() {
        return super.isOpaque();
    }
}
