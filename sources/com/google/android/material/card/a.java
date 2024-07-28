package com.google.android.material.card;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import com.google.android.material.R;
import com.google.android.material.i.b;
import com.google.android.material.k.d;
import com.google.android.material.k.e;
import com.google.android.material.k.h;
import com.google.android.material.k.l;
import com.google.android.material.k.m;

final class a {
    private static final int[] r = {16842912};
    private static final double s = Math.cos(Math.toRadians(45.0d));

    /* renamed from: a  reason: collision with root package name */
    final MaterialCardView f36067a;

    /* renamed from: b  reason: collision with root package name */
    final Rect f36068b = new Rect();

    /* renamed from: c  reason: collision with root package name */
    final h f36069c;

    /* renamed from: d  reason: collision with root package name */
    final h f36070d;

    /* renamed from: e  reason: collision with root package name */
    final int f36071e;

    /* renamed from: f  reason: collision with root package name */
    final int f36072f;

    /* renamed from: g  reason: collision with root package name */
    int f36073g;

    /* renamed from: h  reason: collision with root package name */
    Drawable f36074h;

    /* renamed from: i  reason: collision with root package name */
    Drawable f36075i;
    ColorStateList j;
    ColorStateList k;
    m l;
    ColorStateList m;
    LayerDrawable n;
    h o;
    boolean p = false;
    boolean q;
    private Drawable t;
    private h u;

    public a(MaterialCardView materialCardView, AttributeSet attributeSet, int i2, int i3) {
        this.f36067a = materialCardView;
        this.f36069c = new h(materialCardView.getContext(), attributeSet, i2, i3);
        this.f36069c.a(materialCardView.getContext());
        this.f36069c.k();
        m.a b2 = this.f36069c.G.f36536a.b();
        TypedArray obtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, R.styleable.CardView, i2, R.style.CardView);
        if (obtainStyledAttributes.hasValue(R.styleable.CardView_cardCornerRadius)) {
            b2.a(obtainStyledAttributes.getDimension(R.styleable.CardView_cardCornerRadius, 0.0f));
        }
        this.f36070d = new h();
        a(b2.a());
        Resources resources = materialCardView.getResources();
        this.f36071e = resources.getDimensionPixelSize(R.dimen.mtrl_card_checked_icon_margin);
        this.f36072f = resources.getDimensionPixelSize(R.dimen.mtrl_card_checked_icon_size);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: package-private */
    public final void a(ColorStateList colorStateList) {
        if (this.m != colorStateList) {
            this.m = colorStateList;
            c();
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(ColorStateList colorStateList) {
        this.f36069c.g(colorStateList);
    }

    /* access modifiers changed from: package-private */
    public final void c(ColorStateList colorStateList) {
        h hVar = this.f36070d;
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        hVar.g(colorStateList);
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, int i3, int i4, int i5) {
        this.f36068b.set(i2, i3, i4, i5);
        d();
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f36069c.r(this.f36067a.getCardElevation());
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        this.f36070d.a((float) this.f36073g, this.m);
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        int n2 = (int) ((h() || i() ? n() : 0.0f) - m());
        this.f36067a.a(this.f36068b.left + n2, this.f36068b.top + n2, this.f36068b.right + n2, this.f36068b.bottom + n2);
    }

    /* access modifiers changed from: package-private */
    public final void d(ColorStateList colorStateList) {
        this.j = colorStateList;
        k();
    }

    /* access modifiers changed from: package-private */
    public final void a(Drawable drawable) {
        this.f36075i = drawable;
        if (drawable != null) {
            this.f36075i = androidx.core.graphics.drawable.a.f(drawable.mutate());
            androidx.core.graphics.drawable.a.a(this.f36075i, this.k);
        }
        if (this.n != null) {
            this.n.setDrawableByLayerId(R.id.mtrl_card_checked_layer_id, q());
        }
    }

    /* access modifiers changed from: package-private */
    public final void e() {
        Drawable drawable = this.t;
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            int i2 = bounds.bottom;
            this.t.setBounds(bounds.left, bounds.top, bounds.right, i2 - 1);
            this.t.setBounds(bounds.left, bounds.top, bounds.right, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(m mVar) {
        this.l = mVar;
        this.f36069c.setShapeAppearanceModel(mVar);
        h hVar = this.f36069c;
        hVar.H = !hVar.q();
        h hVar2 = this.f36070d;
        if (hVar2 != null) {
            hVar2.setShapeAppearanceModel(mVar);
        }
        h hVar3 = this.o;
        if (hVar3 != null) {
            hVar3.setShapeAppearanceModel(mVar);
        }
        h hVar4 = this.u;
        if (hVar4 != null) {
            hVar4.setShapeAppearanceModel(mVar);
        }
    }

    /* access modifiers changed from: package-private */
    public final Drawable b(Drawable drawable) {
        int i2;
        int i3;
        if ((Build.VERSION.SDK_INT < 21) || this.f36067a.getUseCompatPadding()) {
            int ceil = (int) Math.ceil((double) f());
            i3 = (int) Math.ceil((double) g());
            i2 = ceil;
        } else {
            i3 = 0;
            i2 = 0;
        }
        return new InsetDrawable(drawable, i3, i2, i3, i2) {
            public final int getMinimumHeight() {
                return -1;
            }

            public final int getMinimumWidth() {
                return -1;
            }

            public final boolean getPadding(Rect rect) {
                return false;
            }
        };
    }

    /* access modifiers changed from: package-private */
    public final float f() {
        return (this.f36067a.getMaxCardElevation() * 1.5f) + (i() ? n() : 0.0f);
    }

    /* access modifiers changed from: package-private */
    public final float g() {
        return this.f36067a.getMaxCardElevation() + (i() ? n() : 0.0f);
    }

    private boolean l() {
        return Build.VERSION.SDK_INT >= 21 && this.f36069c.q();
    }

    private float m() {
        if (!this.f36067a.getPreventCornerOverlap()) {
            return 0.0f;
        }
        if (Build.VERSION.SDK_INT < 21 || this.f36067a.getUseCompatPadding()) {
            return (float) ((1.0d - s) * ((double) this.f36067a.getCardViewRadius()));
        }
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public final boolean h() {
        return this.f36067a.getPreventCornerOverlap() && !l();
    }

    /* access modifiers changed from: package-private */
    public final boolean i() {
        return this.f36067a.getPreventCornerOverlap() && l() && this.f36067a.getUseCompatPadding();
    }

    private float n() {
        return Math.max(Math.max(a(this.l.f36550b, this.f36069c.m()), a(this.l.f36551c, this.f36069c.n())), Math.max(a(this.l.f36552d, this.f36069c.p()), a(this.l.f36553e, this.f36069c.o())));
    }

    private static float a(d dVar, float f2) {
        if (dVar instanceof l) {
            return (float) ((1.0d - s) * ((double) f2));
        }
        if (dVar instanceof e) {
            return f2 / 2.0f;
        }
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public final Drawable j() {
        if (this.t == null) {
            this.t = o();
        }
        if (this.n == null) {
            this.n = new LayerDrawable(new Drawable[]{this.t, this.f36070d, q()});
            this.n.setId(2, R.id.mtrl_card_checked_layer_id);
        }
        return this.n;
    }

    private Drawable o() {
        if (!b.f36380a) {
            return p();
        }
        this.o = r();
        return new RippleDrawable(this.j, (Drawable) null, this.o);
    }

    private Drawable p() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.u = r();
        this.u.g(this.j);
        stateListDrawable.addState(new int[]{16842919}, this.u);
        return stateListDrawable;
    }

    /* access modifiers changed from: package-private */
    public final void k() {
        Drawable drawable;
        if (!b.f36380a || (drawable = this.t) == null) {
            h hVar = this.u;
            if (hVar != null) {
                hVar.g(this.j);
                return;
            }
            return;
        }
        ((RippleDrawable) drawable).setColor(this.j);
    }

    private Drawable q() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable = this.f36075i;
        if (drawable != null) {
            stateListDrawable.addState(r, drawable);
        }
        return stateListDrawable;
    }

    private h r() {
        return new h(this.l);
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        if (!this.p) {
            this.f36067a.setBackgroundInternal(b((Drawable) this.f36069c));
        }
        this.f36067a.setForeground(b(this.f36074h));
    }
}
