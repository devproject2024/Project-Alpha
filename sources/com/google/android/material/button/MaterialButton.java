package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.h.u;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.k.i;
import com.google.android.material.k.m;
import com.google.android.material.k.p;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class MaterialButton extends AppCompatButton implements Checkable, p {

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f36022b = {16842911};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f36023c = {16842912};

    /* renamed from: e  reason: collision with root package name */
    private static final int f36024e = R.style.Widget_MaterialComponents_Button;

    /* renamed from: a  reason: collision with root package name */
    final LinkedHashSet<a> f36025a;

    /* renamed from: f  reason: collision with root package name */
    private final a f36026f;

    /* renamed from: g  reason: collision with root package name */
    private b f36027g;

    /* renamed from: h  reason: collision with root package name */
    private PorterDuff.Mode f36028h;

    /* renamed from: i  reason: collision with root package name */
    private ColorStateList f36029i;
    private Drawable j;
    private int k;
    private int l;
    private int m;
    private boolean n;
    private boolean o;
    private int p;

    public interface a {
        void a(MaterialButton materialButton, boolean z);
    }

    interface b {
        void a();
    }

    public MaterialButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialButtonStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialButton(android.content.Context r17, android.util.AttributeSet r18, int r19) {
        /*
            r16 = this;
            r0 = r16
            r7 = r18
            r8 = r19
            int r1 = f36024e
            r2 = r17
            android.content.Context r1 = com.google.android.material.theme.a.a.a(r2, r7, r8, r1)
            r0.<init>(r1, r7, r8)
            java.util.LinkedHashSet r1 = new java.util.LinkedHashSet
            r1.<init>()
            r0.f36025a = r1
            r9 = 0
            r0.n = r9
            r0.o = r9
            android.content.Context r10 = r16.getContext()
            int[] r3 = com.google.android.material.R.styleable.MaterialButton
            int r5 = f36024e
            int[] r6 = new int[r9]
            r1 = r10
            r2 = r18
            r4 = r19
            android.content.res.TypedArray r1 = com.google.android.material.internal.k.a(r1, r2, r3, r4, r5, r6)
            int r2 = com.google.android.material.R.styleable.MaterialButton_iconPadding
            int r2 = r1.getDimensionPixelSize(r2, r9)
            r0.m = r2
            int r2 = com.google.android.material.R.styleable.MaterialButton_iconTintMode
            r3 = -1
            int r2 = r1.getInt(r2, r3)
            android.graphics.PorterDuff$Mode r4 = android.graphics.PorterDuff.Mode.SRC_IN
            android.graphics.PorterDuff$Mode r2 = com.google.android.material.internal.q.a((int) r2, (android.graphics.PorterDuff.Mode) r4)
            r0.f36028h = r2
            android.content.Context r2 = r16.getContext()
            int r4 = com.google.android.material.R.styleable.MaterialButton_iconTint
            android.content.res.ColorStateList r2 = com.google.android.material.h.c.a((android.content.Context) r2, (android.content.res.TypedArray) r1, (int) r4)
            r0.f36029i = r2
            android.content.Context r2 = r16.getContext()
            int r4 = com.google.android.material.R.styleable.MaterialButton_icon
            android.graphics.drawable.Drawable r2 = com.google.android.material.h.c.b(r2, r1, r4)
            r0.j = r2
            int r2 = com.google.android.material.R.styleable.MaterialButton_iconGravity
            r4 = 1
            int r2 = r1.getInteger(r2, r4)
            r0.p = r2
            int r2 = com.google.android.material.R.styleable.MaterialButton_iconSize
            int r2 = r1.getDimensionPixelSize(r2, r9)
            r0.k = r2
            int r2 = f36024e
            com.google.android.material.k.m$a r2 = com.google.android.material.k.m.a((android.content.Context) r10, (android.util.AttributeSet) r7, (int) r8, (int) r2)
            com.google.android.material.k.m r2 = r2.a()
            com.google.android.material.button.a r5 = new com.google.android.material.button.a
            r5.<init>(r0, r2)
            r0.f36026f = r5
            com.google.android.material.button.a r2 = r0.f36026f
            int r5 = com.google.android.material.R.styleable.MaterialButton_android_insetLeft
            int r5 = r1.getDimensionPixelOffset(r5, r9)
            r2.f36052d = r5
            int r5 = com.google.android.material.R.styleable.MaterialButton_android_insetRight
            int r5 = r1.getDimensionPixelOffset(r5, r9)
            r2.f36053e = r5
            int r5 = com.google.android.material.R.styleable.MaterialButton_android_insetTop
            int r5 = r1.getDimensionPixelOffset(r5, r9)
            r2.f36054f = r5
            int r5 = com.google.android.material.R.styleable.MaterialButton_android_insetBottom
            int r5 = r1.getDimensionPixelOffset(r5, r9)
            r2.f36055g = r5
            int r5 = com.google.android.material.R.styleable.MaterialButton_cornerRadius
            boolean r5 = r1.hasValue(r5)
            if (r5 == 0) goto L_0x00c1
            int r5 = com.google.android.material.R.styleable.MaterialButton_cornerRadius
            int r5 = r1.getDimensionPixelSize(r5, r3)
            r2.f36056h = r5
            com.google.android.material.k.m r5 = r2.f36051c
            int r6 = r2.f36056h
            float r6 = (float) r6
            com.google.android.material.k.m r5 = r5.a((float) r6)
            r2.a((com.google.android.material.k.m) r5)
            r2.q = r4
        L_0x00c1:
            int r5 = com.google.android.material.R.styleable.MaterialButton_strokeWidth
            int r5 = r1.getDimensionPixelSize(r5, r9)
            r2.f36057i = r5
            int r5 = com.google.android.material.R.styleable.MaterialButton_backgroundTintMode
            int r5 = r1.getInt(r5, r3)
            android.graphics.PorterDuff$Mode r6 = android.graphics.PorterDuff.Mode.SRC_IN
            android.graphics.PorterDuff$Mode r5 = com.google.android.material.internal.q.a((int) r5, (android.graphics.PorterDuff.Mode) r6)
            r2.j = r5
            com.google.android.material.button.MaterialButton r5 = r2.f36050b
            android.content.Context r5 = r5.getContext()
            int r6 = com.google.android.material.R.styleable.MaterialButton_backgroundTint
            android.content.res.ColorStateList r5 = com.google.android.material.h.c.a((android.content.Context) r5, (android.content.res.TypedArray) r1, (int) r6)
            r2.k = r5
            com.google.android.material.button.MaterialButton r5 = r2.f36050b
            android.content.Context r5 = r5.getContext()
            int r6 = com.google.android.material.R.styleable.MaterialButton_strokeColor
            android.content.res.ColorStateList r5 = com.google.android.material.h.c.a((android.content.Context) r5, (android.content.res.TypedArray) r1, (int) r6)
            r2.l = r5
            com.google.android.material.button.MaterialButton r5 = r2.f36050b
            android.content.Context r5 = r5.getContext()
            int r6 = com.google.android.material.R.styleable.MaterialButton_rippleColor
            android.content.res.ColorStateList r5 = com.google.android.material.h.c.a((android.content.Context) r5, (android.content.res.TypedArray) r1, (int) r6)
            r2.m = r5
            int r5 = com.google.android.material.R.styleable.MaterialButton_android_checkable
            boolean r5 = r1.getBoolean(r5, r9)
            r2.r = r5
            int r5 = com.google.android.material.R.styleable.MaterialButton_elevation
            int r5 = r1.getDimensionPixelSize(r5, r9)
            com.google.android.material.button.MaterialButton r6 = r2.f36050b
            int r6 = androidx.core.h.u.m(r6)
            com.google.android.material.button.MaterialButton r7 = r2.f36050b
            int r7 = r7.getPaddingTop()
            com.google.android.material.button.MaterialButton r8 = r2.f36050b
            int r8 = androidx.core.h.u.n(r8)
            com.google.android.material.button.MaterialButton r10 = r2.f36050b
            int r10 = r10.getPaddingBottom()
            int r11 = com.google.android.material.R.styleable.MaterialButton_android_background
            boolean r11 = r1.hasValue(r11)
            if (r11 == 0) goto L_0x0135
            r2.a()
            r13 = 1
            goto L_0x01eb
        L_0x0135:
            com.google.android.material.button.MaterialButton r11 = r2.f36050b
            com.google.android.material.k.h r12 = new com.google.android.material.k.h
            com.google.android.material.k.m r13 = r2.f36051c
            r12.<init>((com.google.android.material.k.m) r13)
            com.google.android.material.button.MaterialButton r13 = r2.f36050b
            android.content.Context r13 = r13.getContext()
            r12.a((android.content.Context) r13)
            android.content.res.ColorStateList r13 = r2.k
            androidx.core.graphics.drawable.a.a((android.graphics.drawable.Drawable) r12, (android.content.res.ColorStateList) r13)
            android.graphics.PorterDuff$Mode r13 = r2.j
            if (r13 == 0) goto L_0x0155
            android.graphics.PorterDuff$Mode r13 = r2.j
            androidx.core.graphics.drawable.a.a((android.graphics.drawable.Drawable) r12, (android.graphics.PorterDuff.Mode) r13)
        L_0x0155:
            int r13 = r2.f36057i
            float r13 = (float) r13
            android.content.res.ColorStateList r14 = r2.l
            r12.a((float) r13, (android.content.res.ColorStateList) r14)
            com.google.android.material.k.h r13 = new com.google.android.material.k.h
            com.google.android.material.k.m r14 = r2.f36051c
            r13.<init>((com.google.android.material.k.m) r14)
            r13.setTint(r9)
            int r14 = r2.f36057i
            float r14 = (float) r14
            boolean r15 = r2.o
            if (r15 == 0) goto L_0x0177
            com.google.android.material.button.MaterialButton r15 = r2.f36050b
            int r4 = com.google.android.material.R.attr.colorSurface
            int r4 = com.google.android.material.h.b.a((android.view.View) r15, (int) r4)
            goto L_0x0178
        L_0x0177:
            r4 = 0
        L_0x0178:
            r13.a((float) r14, (int) r4)
            boolean r4 = com.google.android.material.button.a.f36049a
            r14 = 2
            if (r4 == 0) goto L_0x01b1
            com.google.android.material.k.h r4 = new com.google.android.material.k.h
            com.google.android.material.k.m r15 = r2.f36051c
            r4.<init>((com.google.android.material.k.m) r15)
            r2.n = r4
            android.graphics.drawable.Drawable r4 = r2.n
            androidx.core.graphics.drawable.a.a((android.graphics.drawable.Drawable) r4, (int) r3)
            android.graphics.drawable.RippleDrawable r3 = new android.graphics.drawable.RippleDrawable
            android.content.res.ColorStateList r4 = r2.m
            android.content.res.ColorStateList r4 = com.google.android.material.i.b.b(r4)
            android.graphics.drawable.LayerDrawable r15 = new android.graphics.drawable.LayerDrawable
            android.graphics.drawable.Drawable[] r14 = new android.graphics.drawable.Drawable[r14]
            r14[r9] = r13
            r13 = 1
            r14[r13] = r12
            r15.<init>(r14)
            android.graphics.drawable.InsetDrawable r12 = r2.a((android.graphics.drawable.Drawable) r15)
            android.graphics.drawable.Drawable r13 = r2.n
            r3.<init>(r4, r12, r13)
            r2.s = r3
            android.graphics.drawable.LayerDrawable r3 = r2.s
            r13 = 1
            goto L_0x01de
        L_0x01b1:
            com.google.android.material.i.a r3 = new com.google.android.material.i.a
            com.google.android.material.k.m r4 = r2.f36051c
            r3.<init>((com.google.android.material.k.m) r4)
            r2.n = r3
            android.graphics.drawable.Drawable r3 = r2.n
            android.content.res.ColorStateList r4 = r2.m
            android.content.res.ColorStateList r4 = com.google.android.material.i.b.b(r4)
            androidx.core.graphics.drawable.a.a((android.graphics.drawable.Drawable) r3, (android.content.res.ColorStateList) r4)
            android.graphics.drawable.LayerDrawable r3 = new android.graphics.drawable.LayerDrawable
            r4 = 3
            android.graphics.drawable.Drawable[] r4 = new android.graphics.drawable.Drawable[r4]
            r4[r9] = r13
            r13 = 1
            r4[r13] = r12
            android.graphics.drawable.Drawable r12 = r2.n
            r4[r14] = r12
            r3.<init>(r4)
            r2.s = r3
            android.graphics.drawable.LayerDrawable r3 = r2.s
            android.graphics.drawable.InsetDrawable r3 = r2.a((android.graphics.drawable.Drawable) r3)
        L_0x01de:
            r11.setInternalBackground(r3)
            com.google.android.material.k.h r3 = r2.a((boolean) r9)
            if (r3 == 0) goto L_0x01eb
            float r4 = (float) r5
            r3.r(r4)
        L_0x01eb:
            com.google.android.material.button.MaterialButton r3 = r2.f36050b
            int r4 = r2.f36052d
            int r6 = r6 + r4
            int r4 = r2.f36054f
            int r7 = r7 + r4
            int r4 = r2.f36053e
            int r8 = r8 + r4
            int r2 = r2.f36055g
            int r10 = r10 + r2
            androidx.core.h.u.b(r3, r6, r7, r8, r10)
            r1.recycle()
            int r1 = r0.m
            r0.setCompoundDrawablePadding(r1)
            android.graphics.drawable.Drawable r1 = r0.j
            if (r1 == 0) goto L_0x0209
            goto L_0x020a
        L_0x0209:
            r13 = 0
        L_0x020a:
            r0.a(r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private String getA11yClassName() {
        return (c() ? CompoundButton.class : Button.class).getName();
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(c());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f36030a = this.n;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f3245d);
        setChecked(savedState.f36030a);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (d()) {
            a aVar = this.f36026f;
            if (aVar.k != colorStateList) {
                aVar.k = colorStateList;
                if (aVar.a(false) != null) {
                    androidx.core.graphics.drawable.a.a((Drawable) aVar.a(false), aVar.k);
                    return;
                }
                return;
            }
            return;
        }
        super.setSupportBackgroundTintList(colorStateList);
    }

    public ColorStateList getSupportBackgroundTintList() {
        if (d()) {
            return this.f36026f.k;
        }
        return super.getSupportBackgroundTintList();
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (d()) {
            a aVar = this.f36026f;
            if (aVar.j != mode) {
                aVar.j = mode;
                if (aVar.a(false) != null && aVar.j != null) {
                    androidx.core.graphics.drawable.a.a((Drawable) aVar.a(false), aVar.j);
                    return;
                }
                return;
            }
            return;
        }
        super.setSupportBackgroundTintMode(mode);
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (d()) {
            return this.f36026f.j;
        }
        return super.getSupportBackgroundTintMode();
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public void setBackgroundColor(int i2) {
        if (d()) {
            a aVar = this.f36026f;
            if (aVar.a(false) != null) {
                aVar.a(false).setTint(i2);
                return;
            }
            return;
        }
        super.setBackgroundColor(i2);
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundResource(int i2) {
        setBackgroundDrawable(i2 != 0 ? androidx.appcompat.a.a.a.b(getContext(), i2) : null);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (d()) {
            if (drawable != getBackground()) {
                this.f36026f.a();
            } else {
                getBackground().setState(drawable.getState());
                return;
            }
        }
        super.setBackgroundDrawable(drawable);
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        a aVar;
        super.onLayout(z, i2, i3, i4, i5);
        if (Build.VERSION.SDK_INT == 21 && (aVar = this.f36026f) != null) {
            int i6 = i5 - i3;
            int i7 = i4 - i2;
            if (aVar.n != null) {
                aVar.n.setBounds(aVar.f36052d, aVar.f36054f, i7 - aVar.f36053e, i6 - aVar.f36055g);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        a();
    }

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        a();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (d()) {
            i.a((View) this, this.f36026f.a(false));
        }
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        if (d()) {
            this.f36026f.a(false).r(f2);
        }
    }

    private void a() {
        if (this.j != null && getLayout() != null) {
            int i2 = this.p;
            boolean z = true;
            if (i2 == 1 || i2 == 3) {
                this.l = 0;
                a(false);
                return;
            }
            TextPaint paint = getPaint();
            String charSequence = getText().toString();
            if (getTransformationMethod() != null) {
                charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
            }
            int min = Math.min((int) paint.measureText(charSequence), getLayout().getEllipsizedWidth());
            int i3 = this.k;
            if (i3 == 0) {
                i3 = this.j.getIntrinsicWidth();
            }
            int measuredWidth = (((((getMeasuredWidth() - min) - u.n(this)) - i3) - this.m) - u.m(this)) / 2;
            boolean b2 = b();
            if (this.p != 4) {
                z = false;
            }
            if (b2 != z) {
                measuredWidth = -measuredWidth;
            }
            if (this.l != measuredWidth) {
                this.l = measuredWidth;
                a(false);
            }
        }
    }

    private boolean b() {
        return u.j(this) == 1;
    }

    /* access modifiers changed from: package-private */
    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setIconPadding(int i2) {
        if (this.m != i2) {
            this.m = i2;
            setCompoundDrawablePadding(i2);
        }
    }

    public int getIconPadding() {
        return this.m;
    }

    public void setIconSize(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        } else if (this.k != i2) {
            this.k = i2;
            a(true);
        }
    }

    public int getIconSize() {
        return this.k;
    }

    public void setIcon(Drawable drawable) {
        if (this.j != drawable) {
            this.j = drawable;
            a(true);
        }
    }

    public void setIconResource(int i2) {
        setIcon(i2 != 0 ? androidx.appcompat.a.a.a.b(getContext(), i2) : null);
    }

    public Drawable getIcon() {
        return this.j;
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f36029i != colorStateList) {
            this.f36029i = colorStateList;
            a(false);
        }
    }

    public void setIconTintResource(int i2) {
        setIconTint(androidx.appcompat.a.a.a.a(getContext(), i2));
    }

    public ColorStateList getIconTint() {
        return this.f36029i;
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f36028h != mode) {
            this.f36028h = mode;
            a(false);
        }
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f36028h;
    }

    private void a(boolean z) {
        Drawable drawable = this.j;
        boolean z2 = false;
        if (drawable != null) {
            this.j = androidx.core.graphics.drawable.a.f(drawable).mutate();
            androidx.core.graphics.drawable.a.a(this.j, this.f36029i);
            PorterDuff.Mode mode = this.f36028h;
            if (mode != null) {
                androidx.core.graphics.drawable.a.a(this.j, mode);
            }
            int i2 = this.k;
            if (i2 == 0) {
                i2 = this.j.getIntrinsicWidth();
            }
            int i3 = this.k;
            if (i3 == 0) {
                i3 = this.j.getIntrinsicHeight();
            }
            Drawable drawable2 = this.j;
            int i4 = this.l;
            drawable2.setBounds(i4, 0, i2 + i4, i3);
        }
        int i5 = this.p;
        boolean z3 = i5 == 1 || i5 == 2;
        if (z) {
            b(z3);
            return;
        }
        Drawable[] b2 = androidx.core.widget.i.b(this);
        Drawable drawable3 = b2[0];
        Drawable drawable4 = b2[2];
        if ((z3 && drawable3 != this.j) || (!z3 && drawable4 != this.j)) {
            z2 = true;
        }
        if (z2) {
            b(z3);
        }
    }

    private void b(boolean z) {
        if (z) {
            androidx.core.widget.i.a(this, this.j, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            androidx.core.widget.i.a(this, (Drawable) null, (Drawable) null, this.j, (Drawable) null);
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (d()) {
            a aVar = this.f36026f;
            if (aVar.m != colorStateList) {
                aVar.m = colorStateList;
                if (a.f36049a && (aVar.f36050b.getBackground() instanceof RippleDrawable)) {
                    ((RippleDrawable) aVar.f36050b.getBackground()).setColor(com.google.android.material.i.b.b(colorStateList));
                } else if (!a.f36049a && (aVar.f36050b.getBackground() instanceof com.google.android.material.i.a)) {
                    ((com.google.android.material.i.a) aVar.f36050b.getBackground()).setTintList(com.google.android.material.i.b.b(colorStateList));
                }
            }
        }
    }

    public void setRippleColorResource(int i2) {
        if (d()) {
            setRippleColor(androidx.appcompat.a.a.a.a(getContext(), i2));
        }
    }

    public ColorStateList getRippleColor() {
        if (d()) {
            return this.f36026f.m;
        }
        return null;
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (d()) {
            a aVar = this.f36026f;
            if (aVar.l != colorStateList) {
                aVar.l = colorStateList;
                aVar.b();
            }
        }
    }

    public void setStrokeColorResource(int i2) {
        if (d()) {
            setStrokeColor(androidx.appcompat.a.a.a.a(getContext(), i2));
        }
    }

    public ColorStateList getStrokeColor() {
        if (d()) {
            return this.f36026f.l;
        }
        return null;
    }

    public void setStrokeWidth(int i2) {
        if (d()) {
            a aVar = this.f36026f;
            if (aVar.f36057i != i2) {
                aVar.f36057i = i2;
                aVar.b();
            }
        }
    }

    public void setStrokeWidthResource(int i2) {
        if (d()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i2));
        }
    }

    public int getStrokeWidth() {
        if (d()) {
            return this.f36026f.f36057i;
        }
        return 0;
    }

    public void setCornerRadius(int i2) {
        if (d()) {
            a aVar = this.f36026f;
            if (!aVar.q || aVar.f36056h != i2) {
                aVar.f36056h = i2;
                aVar.q = true;
                aVar.a(aVar.f36051c.a((float) i2));
            }
        }
    }

    public void setCornerRadiusResource(int i2) {
        if (d()) {
            setCornerRadius(getResources().getDimensionPixelSize(i2));
        }
    }

    public int getCornerRadius() {
        if (d()) {
            return this.f36026f.f36056h;
        }
        return 0;
    }

    public int getIconGravity() {
        return this.p;
    }

    public void setIconGravity(int i2) {
        if (this.p != i2) {
            this.p = i2;
            a();
        }
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (c()) {
            mergeDrawableStates(onCreateDrawableState, f36022b);
        }
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f36023c);
        }
        return onCreateDrawableState;
    }

    public void setChecked(boolean z) {
        if (c() && isEnabled() && this.n != z) {
            this.n = z;
            refreshDrawableState();
            if (!this.o) {
                this.o = true;
                Iterator it2 = this.f36025a.iterator();
                while (it2.hasNext()) {
                    ((a) it2.next()).a(this, this.n);
                }
                this.o = false;
            }
        }
    }

    public boolean isChecked() {
        return this.n;
    }

    public void toggle() {
        setChecked(!this.n);
    }

    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    private boolean c() {
        a aVar = this.f36026f;
        return aVar != null && aVar.r;
    }

    public void setCheckable(boolean z) {
        if (d()) {
            this.f36026f.r = z;
        }
    }

    public void setShapeAppearanceModel(m mVar) {
        if (d()) {
            this.f36026f.a(mVar);
            return;
        }
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    public m getShapeAppearanceModel() {
        if (d()) {
            return this.f36026f.f36051c;
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    /* access modifiers changed from: package-private */
    public void setOnPressedChangeListenerInternal(b bVar) {
        this.f36027g = bVar;
    }

    public void setPressed(boolean z) {
        b bVar = this.f36027g;
        if (bVar != null) {
            bVar.a();
        }
        super.setPressed(z);
    }

    private boolean d() {
        a aVar = this.f36026f;
        return aVar != null && !aVar.p;
    }

    /* access modifiers changed from: package-private */
    public void setShouldDrawSurfaceColorStroke(boolean z) {
        if (d()) {
            a aVar = this.f36026f;
            aVar.o = z;
            aVar.b();
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        boolean f36030a;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            this.f36030a = parcel.readInt() != 1 ? false : true;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f36030a ? 1 : 0);
        }
    }
}
