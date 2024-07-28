package com.google.android.material.circularreveal.cardview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.circularreveal.b;
import com.google.android.material.circularreveal.c;

public class CircularRevealCardView extends MaterialCardView implements c {

    /* renamed from: e  reason: collision with root package name */
    private final b f36135e;

    public CircularRevealCardView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CircularRevealCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36135e = new b(this);
    }

    public final void a() {
        this.f36135e.a();
    }

    public final void b() {
        this.f36135e.b();
    }

    public void setRevealInfo(c.d dVar) {
        this.f36135e.a(dVar);
    }

    public c.d getRevealInfo() {
        return this.f36135e.c();
    }

    public void setCircularRevealScrimColor(int i2) {
        this.f36135e.a(i2);
    }

    public int getCircularRevealScrimColor() {
        return this.f36135e.f36120b.getColor();
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.f36135e.f36121c;
    }

    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f36135e.a(drawable);
    }

    public void draw(Canvas canvas) {
        b bVar = this.f36135e;
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
        b bVar = this.f36135e;
        if (bVar != null) {
            return bVar.d();
        }
        return super.isOpaque();
    }

    public final boolean c() {
        return super.isOpaque();
    }
}
