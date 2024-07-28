package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import androidx.core.graphics.drawable.a;
import androidx.core.widget.c;

final class e {

    /* renamed from: a  reason: collision with root package name */
    ColorStateList f1729a = null;

    /* renamed from: b  reason: collision with root package name */
    PorterDuff.Mode f1730b = null;

    /* renamed from: c  reason: collision with root package name */
    private final CompoundButton f1731c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1732d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1733e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1734f;

    e(CompoundButton compoundButton) {
        this.f1731c = compoundButton;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0040 A[SYNTHETIC, Splitter:B:12:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0067 A[Catch:{ all -> 0x0091 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007a A[Catch:{ all -> 0x0091 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.util.AttributeSet r10, int r11) {
        /*
            r9 = this;
            android.widget.CompoundButton r0 = r9.f1731c
            android.content.Context r0 = r0.getContext()
            int[] r1 = androidx.appcompat.R.styleable.CompoundButton
            r2 = 0
            androidx.appcompat.widget.ac r0 = androidx.appcompat.widget.ac.a(r0, r10, r1, r11, r2)
            android.widget.CompoundButton r3 = r9.f1731c
            android.content.Context r4 = r3.getContext()
            int[] r5 = androidx.appcompat.R.styleable.CompoundButton
            android.content.res.TypedArray r7 = r0.f1669a
            r6 = r10
            r8 = r11
            androidx.core.h.u.a(r3, r4, r5, r6, r7, r8)
            int r10 = androidx.appcompat.R.styleable.CompoundButton_buttonCompat     // Catch:{ all -> 0x0091 }
            boolean r10 = r0.g(r10)     // Catch:{ all -> 0x0091 }
            if (r10 == 0) goto L_0x003d
            int r10 = androidx.appcompat.R.styleable.CompoundButton_buttonCompat     // Catch:{ all -> 0x0091 }
            int r10 = r0.g(r10, r2)     // Catch:{ all -> 0x0091 }
            if (r10 == 0) goto L_0x003d
            android.widget.CompoundButton r11 = r9.f1731c     // Catch:{ NotFoundException -> 0x003d }
            android.widget.CompoundButton r1 = r9.f1731c     // Catch:{ NotFoundException -> 0x003d }
            android.content.Context r1 = r1.getContext()     // Catch:{ NotFoundException -> 0x003d }
            android.graphics.drawable.Drawable r10 = androidx.appcompat.a.a.a.b(r1, r10)     // Catch:{ NotFoundException -> 0x003d }
            r11.setButtonDrawable(r10)     // Catch:{ NotFoundException -> 0x003d }
            r10 = 1
            goto L_0x003e
        L_0x003d:
            r10 = 0
        L_0x003e:
            if (r10 != 0) goto L_0x005f
            int r10 = androidx.appcompat.R.styleable.CompoundButton_android_button     // Catch:{ all -> 0x0091 }
            boolean r10 = r0.g(r10)     // Catch:{ all -> 0x0091 }
            if (r10 == 0) goto L_0x005f
            int r10 = androidx.appcompat.R.styleable.CompoundButton_android_button     // Catch:{ all -> 0x0091 }
            int r10 = r0.g(r10, r2)     // Catch:{ all -> 0x0091 }
            if (r10 == 0) goto L_0x005f
            android.widget.CompoundButton r11 = r9.f1731c     // Catch:{ all -> 0x0091 }
            android.widget.CompoundButton r1 = r9.f1731c     // Catch:{ all -> 0x0091 }
            android.content.Context r1 = r1.getContext()     // Catch:{ all -> 0x0091 }
            android.graphics.drawable.Drawable r10 = androidx.appcompat.a.a.a.b(r1, r10)     // Catch:{ all -> 0x0091 }
            r11.setButtonDrawable(r10)     // Catch:{ all -> 0x0091 }
        L_0x005f:
            int r10 = androidx.appcompat.R.styleable.CompoundButton_buttonTint     // Catch:{ all -> 0x0091 }
            boolean r10 = r0.g(r10)     // Catch:{ all -> 0x0091 }
            if (r10 == 0) goto L_0x0072
            android.widget.CompoundButton r10 = r9.f1731c     // Catch:{ all -> 0x0091 }
            int r11 = androidx.appcompat.R.styleable.CompoundButton_buttonTint     // Catch:{ all -> 0x0091 }
            android.content.res.ColorStateList r11 = r0.e(r11)     // Catch:{ all -> 0x0091 }
            androidx.core.widget.c.a((android.widget.CompoundButton) r10, (android.content.res.ColorStateList) r11)     // Catch:{ all -> 0x0091 }
        L_0x0072:
            int r10 = androidx.appcompat.R.styleable.CompoundButton_buttonTintMode     // Catch:{ all -> 0x0091 }
            boolean r10 = r0.g(r10)     // Catch:{ all -> 0x0091 }
            if (r10 == 0) goto L_0x008b
            android.widget.CompoundButton r10 = r9.f1731c     // Catch:{ all -> 0x0091 }
            int r11 = androidx.appcompat.R.styleable.CompoundButton_buttonTintMode     // Catch:{ all -> 0x0091 }
            r1 = -1
            int r11 = r0.a((int) r11, (int) r1)     // Catch:{ all -> 0x0091 }
            r1 = 0
            android.graphics.PorterDuff$Mode r11 = androidx.appcompat.widget.p.a(r11, r1)     // Catch:{ all -> 0x0091 }
            androidx.core.widget.c.a((android.widget.CompoundButton) r10, (android.graphics.PorterDuff.Mode) r11)     // Catch:{ all -> 0x0091 }
        L_0x008b:
            android.content.res.TypedArray r10 = r0.f1669a
            r10.recycle()
            return
        L_0x0091:
            r10 = move-exception
            android.content.res.TypedArray r11 = r0.f1669a
            r11.recycle()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.e.a(android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: package-private */
    public final void a(ColorStateList colorStateList) {
        this.f1729a = colorStateList;
        this.f1732d = true;
        b();
    }

    /* access modifiers changed from: package-private */
    public final void a(PorterDuff.Mode mode) {
        this.f1730b = mode;
        this.f1733e = true;
        b();
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        if (this.f1734f) {
            this.f1734f = false;
            return;
        }
        this.f1734f = true;
        b();
    }

    private void b() {
        Drawable b2 = c.b(this.f1731c);
        if (b2 == null) {
            return;
        }
        if (this.f1732d || this.f1733e) {
            Drawable mutate = a.f(b2).mutate();
            if (this.f1732d) {
                a.a(mutate, this.f1729a);
            }
            if (this.f1733e) {
                a.a(mutate, this.f1730b);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.f1731c.getDrawableState());
            }
            this.f1731c.setButtonDrawable(mutate);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = androidx.core.widget.c.b(r2.f1731c);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(int r3) {
        /*
            r2 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 17
            if (r0 >= r1) goto L_0x0013
            android.widget.CompoundButton r0 = r2.f1731c
            android.graphics.drawable.Drawable r0 = androidx.core.widget.c.b(r0)
            if (r0 == 0) goto L_0x0013
            int r0 = r0.getIntrinsicWidth()
            int r3 = r3 + r0
        L_0x0013:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.e.a(int):int");
    }
}
