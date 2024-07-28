package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R;
import androidx.core.graphics.drawable.a;
import androidx.core.h.u;

final class j extends i {

    /* renamed from: b  reason: collision with root package name */
    final SeekBar f1751b;

    /* renamed from: c  reason: collision with root package name */
    Drawable f1752c;

    /* renamed from: d  reason: collision with root package name */
    private ColorStateList f1753d = null;

    /* renamed from: e  reason: collision with root package name */
    private PorterDuff.Mode f1754e = null;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1755f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1756g = false;

    j(SeekBar seekBar) {
        super(seekBar);
        this.f1751b = seekBar;
    }

    /* access modifiers changed from: package-private */
    public final void a(AttributeSet attributeSet, int i2) {
        super.a(attributeSet, i2);
        ac a2 = ac.a(this.f1751b.getContext(), attributeSet, R.styleable.AppCompatSeekBar, i2, 0);
        SeekBar seekBar = this.f1751b;
        u.a(seekBar, seekBar.getContext(), R.styleable.AppCompatSeekBar, attributeSet, a2.f1669a, i2);
        Drawable b2 = a2.b(R.styleable.AppCompatSeekBar_android_thumb);
        if (b2 != null) {
            this.f1751b.setThumb(b2);
        }
        Drawable a3 = a2.a(R.styleable.AppCompatSeekBar_tickMark);
        Drawable drawable = this.f1752c;
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback) null);
        }
        this.f1752c = a3;
        if (a3 != null) {
            a3.setCallback(this.f1751b);
            a.b(a3, u.j(this.f1751b));
            if (a3.isStateful()) {
                a3.setState(this.f1751b.getDrawableState());
            }
            a();
        }
        this.f1751b.invalidate();
        if (a2.g(R.styleable.AppCompatSeekBar_tickMarkTintMode)) {
            this.f1754e = p.a(a2.a(R.styleable.AppCompatSeekBar_tickMarkTintMode, -1), this.f1754e);
            this.f1756g = true;
        }
        if (a2.g(R.styleable.AppCompatSeekBar_tickMarkTint)) {
            this.f1753d = a2.e(R.styleable.AppCompatSeekBar_tickMarkTint);
            this.f1755f = true;
        }
        a2.f1669a.recycle();
        a();
    }

    private void a() {
        if (this.f1752c == null) {
            return;
        }
        if (this.f1755f || this.f1756g) {
            this.f1752c = a.f(this.f1752c.mutate());
            if (this.f1755f) {
                a.a(this.f1752c, this.f1753d);
            }
            if (this.f1756g) {
                a.a(this.f1752c, this.f1754e);
            }
            if (this.f1752c.isStateful()) {
                this.f1752c.setState(this.f1751b.getDrawableState());
            }
        }
    }
}
