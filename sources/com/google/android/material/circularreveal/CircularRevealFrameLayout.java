package com.google.android.material.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.google.android.material.circularreveal.c;

public class CircularRevealFrameLayout extends FrameLayout implements c {

    /* renamed from: a  reason: collision with root package name */
    private final b f36114a;

    public CircularRevealFrameLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public CircularRevealFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36114a = new b(this);
    }

    public final void a() {
        this.f36114a.a();
    }

    public final void b() {
        this.f36114a.b();
    }

    public c.d getRevealInfo() {
        return this.f36114a.c();
    }

    public void setRevealInfo(c.d dVar) {
        this.f36114a.a(dVar);
    }

    public int getCircularRevealScrimColor() {
        return this.f36114a.f36120b.getColor();
    }

    public void setCircularRevealScrimColor(int i2) {
        this.f36114a.a(i2);
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.f36114a.f36121c;
    }

    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f36114a.a(drawable);
    }

    public void draw(Canvas canvas) {
        b bVar = this.f36114a;
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
        b bVar = this.f36114a;
        if (bVar != null) {
            return bVar.d();
        }
        return super.isOpaque();
    }

    public final boolean c() {
        return super.isOpaque();
    }
}
