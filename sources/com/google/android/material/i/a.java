package com.google.android.material.i;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.e;
import com.google.android.material.k.h;
import com.google.android.material.k.m;
import com.google.android.material.k.p;

public final class a extends Drawable implements e, p {

    /* renamed from: a  reason: collision with root package name */
    private C0607a f36377a;

    public final boolean isStateful() {
        return true;
    }

    /* synthetic */ a(C0607a aVar, byte b2) {
        this(aVar);
    }

    public a(m mVar) {
        this(new C0607a(new h(mVar)));
    }

    private a(C0607a aVar) {
        this.f36377a = aVar;
    }

    public final void setTint(int i2) {
        this.f36377a.f36378a.setTint(i2);
    }

    public final void setTintMode(PorterDuff.Mode mode) {
        this.f36377a.f36378a.setTintMode(mode);
    }

    public final void setTintList(ColorStateList colorStateList) {
        this.f36377a.f36378a.setTintList(colorStateList);
    }

    public final void setShapeAppearanceModel(m mVar) {
        this.f36377a.f36378a.setShapeAppearanceModel(mVar);
    }

    /* access modifiers changed from: protected */
    public final boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        if (this.f36377a.f36378a.setState(iArr)) {
            onStateChange = true;
        }
        boolean a2 = b.a(iArr);
        if (this.f36377a.f36379b == a2) {
            return onStateChange;
        }
        this.f36377a.f36379b = a2;
        return true;
    }

    public final void draw(Canvas canvas) {
        if (this.f36377a.f36379b) {
            this.f36377a.f36378a.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f36377a.f36378a.setBounds(rect);
    }

    public final Drawable.ConstantState getConstantState() {
        return this.f36377a;
    }

    public final void setAlpha(int i2) {
        this.f36377a.f36378a.setAlpha(i2);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.f36377a.f36378a.setColorFilter(colorFilter);
    }

    public final int getOpacity() {
        return this.f36377a.f36378a.getOpacity();
    }

    /* renamed from: com.google.android.material.i.a$a  reason: collision with other inner class name */
    static final class C0607a extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        h f36378a;

        /* renamed from: b  reason: collision with root package name */
        boolean f36379b;

        public final int getChangingConfigurations() {
            return 0;
        }

        public C0607a(h hVar) {
            this.f36378a = hVar;
            this.f36379b = false;
        }

        public C0607a(C0607a aVar) {
            this.f36378a = (h) aVar.f36378a.getConstantState().newDrawable();
            this.f36379b = aVar.f36379b;
        }

        public final /* synthetic */ Drawable newDrawable() {
            return new a(new C0607a(this), (byte) 0);
        }
    }

    public final /* synthetic */ Drawable mutate() {
        this.f36377a = new C0607a(this.f36377a);
        return this;
    }
}
