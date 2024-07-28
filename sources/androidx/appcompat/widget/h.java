package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.R;
import androidx.appcompat.a.a.a;
import androidx.core.h.u;
import androidx.core.widget.e;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f1744a;

    /* renamed from: b  reason: collision with root package name */
    private aa f1745b;

    /* renamed from: c  reason: collision with root package name */
    private aa f1746c;

    /* renamed from: d  reason: collision with root package name */
    private aa f1747d;

    public h(ImageView imageView) {
        this.f1744a = imageView;
    }

    public final void a(AttributeSet attributeSet, int i2) {
        int g2;
        ac a2 = ac.a(this.f1744a.getContext(), attributeSet, R.styleable.AppCompatImageView, i2, 0);
        ImageView imageView = this.f1744a;
        u.a(imageView, imageView.getContext(), R.styleable.AppCompatImageView, attributeSet, a2.f1669a, i2);
        try {
            Drawable drawable = this.f1744a.getDrawable();
            if (!(drawable != null || (g2 = a2.g(R.styleable.AppCompatImageView_srcCompat, -1)) == -1 || (drawable = a.b(this.f1744a.getContext(), g2)) == null)) {
                this.f1744a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                p.b(drawable);
            }
            if (a2.g(R.styleable.AppCompatImageView_tint)) {
                e.a(this.f1744a, a2.e(R.styleable.AppCompatImageView_tint));
            }
            if (a2.g(R.styleable.AppCompatImageView_tintMode)) {
                e.a(this.f1744a, p.a(a2.a(R.styleable.AppCompatImageView_tintMode, -1), (PorterDuff.Mode) null));
            }
        } finally {
            a2.f1669a.recycle();
        }
    }

    public final void a(int i2) {
        if (i2 != 0) {
            Drawable b2 = a.b(this.f1744a.getContext(), i2);
            if (b2 != null) {
                p.b(b2);
            }
            this.f1744a.setImageDrawable(b2);
        } else {
            this.f1744a.setImageDrawable((Drawable) null);
        }
        d();
    }

    /* access modifiers changed from: package-private */
    public final boolean a() {
        return Build.VERSION.SDK_INT < 21 || !(this.f1744a.getBackground() instanceof RippleDrawable);
    }

    /* access modifiers changed from: package-private */
    public final void a(ColorStateList colorStateList) {
        if (this.f1746c == null) {
            this.f1746c = new aa();
        }
        aa aaVar = this.f1746c;
        aaVar.f1664a = colorStateList;
        aaVar.f1667d = true;
        d();
    }

    /* access modifiers changed from: package-private */
    public final ColorStateList b() {
        aa aaVar = this.f1746c;
        if (aaVar != null) {
            return aaVar.f1664a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void a(PorterDuff.Mode mode) {
        if (this.f1746c == null) {
            this.f1746c = new aa();
        }
        aa aaVar = this.f1746c;
        aaVar.f1665b = mode;
        aaVar.f1666c = true;
        d();
    }

    /* access modifiers changed from: package-private */
    public final PorterDuff.Mode c() {
        aa aaVar = this.f1746c;
        if (aaVar != null) {
            return aaVar.f1665b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        Drawable drawable = this.f1744a.getDrawable();
        if (drawable != null) {
            p.b(drawable);
        }
        if (drawable == null) {
            return;
        }
        if (!e() || !a(drawable)) {
            aa aaVar = this.f1746c;
            if (aaVar != null) {
                f.a(drawable, aaVar, this.f1744a.getDrawableState());
                return;
            }
            aa aaVar2 = this.f1745b;
            if (aaVar2 != null) {
                f.a(drawable, aaVar2, this.f1744a.getDrawableState());
            }
        }
    }

    private boolean e() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 > 21 ? this.f1745b != null : i2 == 21;
    }

    private boolean a(Drawable drawable) {
        if (this.f1747d == null) {
            this.f1747d = new aa();
        }
        aa aaVar = this.f1747d;
        aaVar.a();
        ColorStateList a2 = e.a(this.f1744a);
        if (a2 != null) {
            aaVar.f1667d = true;
            aaVar.f1664a = a2;
        }
        PorterDuff.Mode b2 = e.b(this.f1744a);
        if (b2 != null) {
            aaVar.f1666c = true;
            aaVar.f1665b = b2;
        }
        if (!aaVar.f1667d && !aaVar.f1666c) {
            return false;
        }
        f.a(drawable, aaVar, this.f1744a.getDrawableState());
        return true;
    }
}
