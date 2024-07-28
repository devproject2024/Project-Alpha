package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R;
import androidx.core.h.u;

final class d {

    /* renamed from: a  reason: collision with root package name */
    private final View f1723a;

    /* renamed from: b  reason: collision with root package name */
    private final f f1724b;

    /* renamed from: c  reason: collision with root package name */
    private int f1725c = -1;

    /* renamed from: d  reason: collision with root package name */
    private aa f1726d;

    /* renamed from: e  reason: collision with root package name */
    private aa f1727e;

    /* renamed from: f  reason: collision with root package name */
    private aa f1728f;

    d(View view) {
        this.f1723a = view;
        this.f1724b = f.b();
    }

    /* access modifiers changed from: package-private */
    public final void a(AttributeSet attributeSet, int i2) {
        ac a2 = ac.a(this.f1723a.getContext(), attributeSet, R.styleable.ViewBackgroundHelper, i2, 0);
        View view = this.f1723a;
        u.a(view, view.getContext(), R.styleable.ViewBackgroundHelper, attributeSet, a2.f1669a, i2);
        try {
            if (a2.g(R.styleable.ViewBackgroundHelper_android_background)) {
                this.f1725c = a2.g(R.styleable.ViewBackgroundHelper_android_background, -1);
                ColorStateList c2 = this.f1724b.c(this.f1723a.getContext(), this.f1725c);
                if (c2 != null) {
                    b(c2);
                }
            }
            if (a2.g(R.styleable.ViewBackgroundHelper_backgroundTint)) {
                u.a(this.f1723a, a2.e(R.styleable.ViewBackgroundHelper_backgroundTint));
            }
            if (a2.g(R.styleable.ViewBackgroundHelper_backgroundTintMode)) {
                u.a(this.f1723a, p.a(a2.a(R.styleable.ViewBackgroundHelper_backgroundTintMode, -1), (PorterDuff.Mode) null));
            }
        } finally {
            a2.f1669a.recycle();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        this.f1725c = i2;
        f fVar = this.f1724b;
        b(fVar != null ? fVar.c(this.f1723a.getContext(), i2) : null);
        d();
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f1725c = -1;
        b((ColorStateList) null);
        d();
    }

    /* access modifiers changed from: package-private */
    public final void a(ColorStateList colorStateList) {
        if (this.f1727e == null) {
            this.f1727e = new aa();
        }
        aa aaVar = this.f1727e;
        aaVar.f1664a = colorStateList;
        aaVar.f1667d = true;
        d();
    }

    /* access modifiers changed from: package-private */
    public final ColorStateList b() {
        aa aaVar = this.f1727e;
        if (aaVar != null) {
            return aaVar.f1664a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void a(PorterDuff.Mode mode) {
        if (this.f1727e == null) {
            this.f1727e = new aa();
        }
        aa aaVar = this.f1727e;
        aaVar.f1665b = mode;
        aaVar.f1666c = true;
        d();
    }

    /* access modifiers changed from: package-private */
    public final PorterDuff.Mode c() {
        aa aaVar = this.f1727e;
        if (aaVar != null) {
            return aaVar.f1665b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        Drawable background = this.f1723a.getBackground();
        if (background == null) {
            return;
        }
        if (!e() || !a(background)) {
            aa aaVar = this.f1727e;
            if (aaVar != null) {
                f.a(background, aaVar, this.f1723a.getDrawableState());
                return;
            }
            aa aaVar2 = this.f1726d;
            if (aaVar2 != null) {
                f.a(background, aaVar2, this.f1723a.getDrawableState());
            }
        }
    }

    private void b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1726d == null) {
                this.f1726d = new aa();
            }
            aa aaVar = this.f1726d;
            aaVar.f1664a = colorStateList;
            aaVar.f1667d = true;
        } else {
            this.f1726d = null;
        }
        d();
    }

    private boolean e() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 > 21 ? this.f1726d != null : i2 == 21;
    }

    private boolean a(Drawable drawable) {
        if (this.f1728f == null) {
            this.f1728f = new aa();
        }
        aa aaVar = this.f1728f;
        aaVar.a();
        ColorStateList E = u.E(this.f1723a);
        if (E != null) {
            aaVar.f1667d = true;
            aaVar.f1664a = E;
        }
        PorterDuff.Mode F = u.F(this.f1723a);
        if (F != null) {
            aaVar.f1666c = true;
            aaVar.f1665b = F;
        }
        if (!aaVar.f1667d && !aaVar.f1666c) {
            return false;
        }
        f.a(drawable, aaVar, this.f1723a.getDrawableState());
        return true;
    }
}
