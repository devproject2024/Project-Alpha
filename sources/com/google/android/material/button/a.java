package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.View;
import com.google.android.material.R;
import com.google.android.material.h.b;
import com.google.android.material.k.h;
import com.google.android.material.k.m;
import com.google.android.material.k.p;

final class a {

    /* renamed from: a  reason: collision with root package name */
    static final boolean f36049a = (Build.VERSION.SDK_INT >= 21);

    /* renamed from: b  reason: collision with root package name */
    final MaterialButton f36050b;

    /* renamed from: c  reason: collision with root package name */
    m f36051c;

    /* renamed from: d  reason: collision with root package name */
    int f36052d;

    /* renamed from: e  reason: collision with root package name */
    int f36053e;

    /* renamed from: f  reason: collision with root package name */
    int f36054f;

    /* renamed from: g  reason: collision with root package name */
    int f36055g;

    /* renamed from: h  reason: collision with root package name */
    int f36056h;

    /* renamed from: i  reason: collision with root package name */
    int f36057i;
    PorterDuff.Mode j;
    ColorStateList k;
    ColorStateList l;
    ColorStateList m;
    Drawable n;
    boolean o = false;
    boolean p = false;
    boolean q = false;
    boolean r;
    LayerDrawable s;

    a(MaterialButton materialButton, m mVar) {
        this.f36050b = materialButton;
        this.f36051c = mVar;
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.p = true;
        this.f36050b.setSupportBackgroundTintList(this.k);
        this.f36050b.setSupportBackgroundTintMode(this.j);
    }

    /* access modifiers changed from: package-private */
    public final InsetDrawable a(Drawable drawable) {
        return new InsetDrawable(drawable, this.f36052d, this.f36054f, this.f36053e, this.f36055g);
    }

    /* access modifiers changed from: package-private */
    public final h a(boolean z) {
        LayerDrawable layerDrawable = this.s;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        if (f36049a) {
            return (h) ((LayerDrawable) ((InsetDrawable) this.s.getDrawable(0)).getDrawable()).getDrawable(z ^ true ? 1 : 0);
        }
        return (h) this.s.getDrawable(z ^ true ? 1 : 0);
    }

    private p c() {
        LayerDrawable layerDrawable = this.s;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        if (this.s.getNumberOfLayers() > 2) {
            return (p) this.s.getDrawable(2);
        }
        return (p) this.s.getDrawable(1);
    }

    /* access modifiers changed from: package-private */
    public final void a(m mVar) {
        this.f36051c = mVar;
        b(mVar);
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        int i2 = 0;
        h a2 = a(false);
        h a3 = a(true);
        if (a2 != null) {
            a2.a((float) this.f36057i, this.l);
            if (a3 != null) {
                float f2 = (float) this.f36057i;
                if (this.o) {
                    i2 = b.a((View) this.f36050b, R.attr.colorSurface);
                }
                a3.a(f2, i2);
            }
        }
    }

    private void b(m mVar) {
        if (a(false) != null) {
            a(false).setShapeAppearanceModel(mVar);
        }
        if (a(true) != null) {
            a(true).setShapeAppearanceModel(mVar);
        }
        if (c() != null) {
            c().setShapeAppearanceModel(mVar);
        }
    }
}
