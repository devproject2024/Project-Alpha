package com.google.android.material.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.google.android.material.circularreveal.c;

public class CircularRevealRelativeLayout extends RelativeLayout implements c {

    /* renamed from: a  reason: collision with root package name */
    private final b f36117a;

    public CircularRevealRelativeLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public CircularRevealRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36117a = new b(this);
    }

    public final void a() {
        this.f36117a.a();
    }

    public final void b() {
        this.f36117a.b();
    }

    public c.d getRevealInfo() {
        return this.f36117a.c();
    }

    public void setRevealInfo(c.d dVar) {
        this.f36117a.a(dVar);
    }

    public int getCircularRevealScrimColor() {
        return this.f36117a.f36120b.getColor();
    }

    public void setCircularRevealScrimColor(int i2) {
        this.f36117a.a(i2);
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.f36117a.f36121c;
    }

    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f36117a.a(drawable);
    }

    public void draw(Canvas canvas) {
        b bVar = this.f36117a;
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
        b bVar = this.f36117a;
        if (bVar != null) {
            return bVar.d();
        }
        return super.isOpaque();
    }

    public final boolean c() {
        return super.isOpaque();
    }
}
