package com.google.android.material.chip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.h.a.c;
import androidx.core.h.u;
import com.google.android.material.R;
import com.google.android.material.chip.a;
import com.google.android.material.h.c;
import com.google.android.material.h.d;
import com.google.android.material.h.f;
import com.google.android.material.i.b;
import com.google.android.material.internal.k;
import com.google.android.material.internal.q;
import com.google.android.material.k.h;
import com.google.android.material.k.i;
import com.google.android.material.k.m;
import com.google.android.material.k.p;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import net.one97.paytm.nativesdk.otp.view.PinEntryEditText;

public class Chip extends AppCompatCheckBox implements a.C0603a, p {

    /* renamed from: a  reason: collision with root package name */
    private static final int f36081a = R.style.Widget_MaterialComponents_Chip_Action;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Rect f36082b = new Rect();

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f36083c = {16842913};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f36084d = {16842911};
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public a f36085e;

    /* renamed from: f  reason: collision with root package name */
    private InsetDrawable f36086f;

    /* renamed from: g  reason: collision with root package name */
    private RippleDrawable f36087g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f36088h;

    /* renamed from: i  reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f36089i;
    private boolean j;
    private boolean k;
    private boolean l;
    /* access modifiers changed from: private */
    public boolean m;
    private boolean n;
    private int o;
    private int p;
    private final a q;
    private final Rect r;
    private final RectF s;
    private final f t;

    public void setBackgroundColor(int i2) {
    }

    public void setBackgroundResource(int i2) {
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
    }

    public Chip(Context context) {
        this(context, (AttributeSet) null);
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.chipStyle);
    }

    public Chip(Context context, AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.a(context, attributeSet, i2, f36081a), attributeSet, i2);
        this.r = new Rect();
        this.s = new RectF();
        this.t = new f() {
            public final void a(int i2) {
            }

            public final void a(Typeface typeface, boolean z) {
                CharSequence charSequence;
                Chip chip = Chip.this;
                if (chip.f36085e.E) {
                    charSequence = Chip.this.f36085e.f36110f;
                } else {
                    charSequence = Chip.this.getText();
                }
                chip.setText(charSequence);
                Chip.this.requestLayout();
                Chip.this.invalidate();
            }
        };
        Context context2 = getContext();
        if (attributeSet != null) {
            attributeSet.getAttributeValue(PinEntryEditText.XML_NAMESPACE_ANDROID, "background");
            if (attributeSet.getAttributeValue(PinEntryEditText.XML_NAMESPACE_ANDROID, "drawableLeft") != null) {
                throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
            } else if (attributeSet.getAttributeValue(PinEntryEditText.XML_NAMESPACE_ANDROID, "drawableStart") != null) {
                throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
            } else if (attributeSet.getAttributeValue(PinEntryEditText.XML_NAMESPACE_ANDROID, "drawableEnd") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            } else if (attributeSet.getAttributeValue(PinEntryEditText.XML_NAMESPACE_ANDROID, "drawableRight") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            } else if (attributeSet.getAttributeBooleanValue(PinEntryEditText.XML_NAMESPACE_ANDROID, "singleLine", true) && attributeSet.getAttributeIntValue(PinEntryEditText.XML_NAMESPACE_ANDROID, "lines", 1) == 1 && attributeSet.getAttributeIntValue(PinEntryEditText.XML_NAMESPACE_ANDROID, "minLines", 1) == 1 && attributeSet.getAttributeIntValue(PinEntryEditText.XML_NAMESPACE_ANDROID, "maxLines", 1) == 1) {
                attributeSet.getAttributeIntValue(PinEntryEditText.XML_NAMESPACE_ANDROID, "gravity", 8388627);
            } else {
                throw new UnsupportedOperationException("Chip does not support multi-line text");
            }
        }
        a a2 = a.a(context2, attributeSet, i2, f36081a);
        int i3 = i2;
        TypedArray a3 = k.a(context2, attributeSet, R.styleable.Chip, i3, f36081a, new int[0]);
        this.n = a3.getBoolean(R.styleable.Chip_ensureMinTouchTargetSize, false);
        this.p = (int) Math.ceil((double) a3.getDimension(R.styleable.Chip_chipMinTouchTargetSize, (float) Math.ceil((double) q.a(getContext(), 48))));
        a3.recycle();
        setChipDrawable(a2);
        a2.r(u.v(this));
        TypedArray a4 = k.a(context2, attributeSet, R.styleable.Chip, i3, f36081a, new int[0]);
        if (Build.VERSION.SDK_INT < 23) {
            setTextColor(c.a(context2, a4, R.styleable.Chip_android_textColor));
        }
        boolean hasValue = a4.hasValue(R.styleable.Chip_shapeAppearance);
        a4.recycle();
        this.q = new a(this);
        f();
        if (!hasValue && Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new ViewOutlineProvider() {
                public final void getOutline(View view, Outline outline) {
                    if (Chip.this.f36085e != null) {
                        Chip.this.f36085e.getOutline(outline);
                    } else {
                        outline.setAlpha(0.0f);
                    }
                }
            });
        }
        setChecked(this.j);
        setText(a2.f36110f);
        setEllipsize(a2.D);
        k();
        if (!this.f36085e.E) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        g();
        if (this.n) {
            setMinHeight(this.p);
        }
        this.o = u.j(this);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.a((View) this, (h) this.f36085e);
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.r(f2);
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i2;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (d() || isClickable()) {
            accessibilityNodeInfo.setClassName(d() ? "android.widget.CompoundButton" : "android.widget.Button");
        } else {
            accessibilityNodeInfo.setClassName("android.view.View");
        }
        accessibilityNodeInfo.setCheckable(d());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            androidx.core.h.a.c a2 = androidx.core.h.a.c.a(accessibilityNodeInfo);
            if (chipGroup.a()) {
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    if (i3 >= chipGroup.getChildCount()) {
                        break;
                    }
                    if (chipGroup.getChildAt(i3) instanceof Chip) {
                        if (((Chip) chipGroup.getChildAt(i3)) == this) {
                            i2 = i4;
                            break;
                        }
                        i4++;
                    }
                    i3++;
                }
            }
            i2 = -1;
            a2.b((Object) c.C0046c.a(ChipGroup.a(this), 1, i2, 1, false, isChecked()));
        }
    }

    private void f() {
        if (!j() || !c() || this.f36088h == null) {
            u.a((View) this, (androidx.core.h.a) null);
        } else {
            u.a((View) this, (androidx.core.h.a) this.q);
        }
    }

    private void g() {
        a aVar;
        if (!TextUtils.isEmpty(getText()) && (aVar = this.f36085e) != null) {
            int c2 = (int) (aVar.z + this.f36085e.w + this.f36085e.c());
            int b2 = (int) (this.f36085e.s + this.f36085e.v + this.f36085e.b());
            if (this.f36086f != null) {
                Rect rect = new Rect();
                this.f36086f.getPadding(rect);
                b2 += rect.left;
                c2 += rect.right;
            }
            u.b(this, b2, getPaddingTop(), c2, getPaddingBottom());
        }
    }

    public void onRtlPropertiesChanged(int i2) {
        super.onRtlPropertiesChanged(i2);
        if (this.o != i2) {
            this.o = i2;
            g();
        }
    }

    public Drawable getChipDrawable() {
        return this.f36085e;
    }

    public void setChipDrawable(a aVar) {
        a aVar2 = this.f36085e;
        if (aVar2 != aVar) {
            if (aVar2 != null) {
                aVar2.a((a.C0603a) null);
            }
            this.f36085e = aVar;
            a aVar3 = this.f36085e;
            aVar3.E = false;
            aVar3.a((a.C0603a) this);
            a(this.p);
        }
    }

    private void h() {
        if (b.f36380a) {
            i();
            return;
        }
        this.f36085e.a(true);
        u.a((View) this, getBackgroundDrawable());
        g();
        if (getBackgroundDrawable() == this.f36086f && this.f36085e.getCallback() == null) {
            this.f36085e.setCallback(this.f36086f);
        }
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f36086f;
        return insetDrawable == null ? this.f36085e : insetDrawable;
    }

    private void i() {
        this.f36087g = new RippleDrawable(b.b(this.f36085e.f36109e), getBackgroundDrawable(), (Drawable) null);
        this.f36085e.a(false);
        u.a((View) this, (Drawable) this.f36087g);
        g();
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f36083c);
        }
        if (d()) {
            mergeDrawableStates(onCreateDrawableState, f36084d);
        }
        return onCreateDrawableState;
    }

    public void setGravity(int i2) {
        if (i2 == 8388627) {
            super.setGravity(i2);
        }
    }

    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f36087g) {
            super.setBackground(drawable);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f36087g) {
            super.setBackgroundDrawable(drawable);
        }
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i4 == 0) {
            super.setCompoundDrawablesWithIntrinsicBounds(i2, i3, i4, i5);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i4 == 0) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(i2, i3, i4, i5);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public TextUtils.TruncateAt getEllipsize() {
        a aVar = this.f36085e;
        if (aVar != null) {
            return aVar.D;
        }
        return null;
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f36085e != null) {
            if (truncateAt != TextUtils.TruncateAt.MARQUEE) {
                super.setEllipsize(truncateAt);
                a aVar = this.f36085e;
                if (aVar != null) {
                    aVar.D = truncateAt;
                    return;
                }
                return;
            }
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
    }

    public void setSingleLine(boolean z) {
        if (z) {
            super.setSingleLine(z);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setLines(int i2) {
        if (i2 <= 1) {
            super.setLines(i2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMinLines(int i2) {
        if (i2 <= 1) {
            super.setMinLines(i2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMaxLines(int i2) {
        if (i2 <= 1) {
            super.setMaxLines(i2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMaxWidth(int i2) {
        super.setMaxWidth(i2);
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.F = i2;
        }
    }

    public final void a() {
        a(this.p);
        requestLayout();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setChecked(boolean z) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        a aVar = this.f36085e;
        if (aVar == null) {
            this.j = z;
        } else if (aVar.n) {
            boolean isChecked = isChecked();
            super.setChecked(z);
            if (isChecked != z && (onCheckedChangeListener = this.f36089i) != null) {
                onCheckedChangeListener.onCheckedChanged(this, z);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f36089i = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f36088h = onClickListener;
        f();
    }

    public final boolean b() {
        boolean z = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f36088h;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z = true;
        }
        this.q.a(1, 1);
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        if (r0 != 3) goto L_0x0040;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0039
            if (r0 == r3) goto L_0x002b
            r4 = 2
            if (r0 == r4) goto L_0x0021
            r1 = 3
            if (r0 == r1) goto L_0x0034
            goto L_0x0040
        L_0x0021:
            boolean r0 = r5.k
            if (r0 == 0) goto L_0x0040
            if (r1 != 0) goto L_0x003e
            r5.setCloseIconPressed(r2)
            goto L_0x003e
        L_0x002b:
            boolean r0 = r5.k
            if (r0 == 0) goto L_0x0034
            r5.b()
            r0 = 1
            goto L_0x0035
        L_0x0034:
            r0 = 0
        L_0x0035:
            r5.setCloseIconPressed(r2)
            goto L_0x0041
        L_0x0039:
            if (r1 == 0) goto L_0x0040
            r5.setCloseIconPressed(r3)
        L_0x003e:
            r0 = 1
            goto L_0x0041
        L_0x0040:
            r0 = 0
        L_0x0041:
            if (r0 != 0) goto L_0x004b
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L_0x004a
            goto L_0x004b
        L_0x004a:
            return r2
        L_0x004b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    private boolean a(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 10) {
            try {
                Field declaredField = androidx.customview.a.a.class.getDeclaredField("c");
                declaredField.setAccessible(true);
                if (((Integer) declaredField.get(this.q)).intValue() != Integer.MIN_VALUE) {
                    Method declaredMethod = androidx.customview.a.a.class.getDeclaredMethod("b", new Class[]{Integer.TYPE});
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.q, new Object[]{Integer.MIN_VALUE});
                    return true;
                }
            } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return a(motionEvent) || this.q.a(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.q.a(keyEvent) || this.q.f3222b == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        this.q.a(z, i2, rect);
    }

    public void getFocusedRect(Rect rect) {
        if (this.q.f3222b == 1 || this.q.f3221a == 1) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    private void setCloseIconPressed(boolean z) {
        if (this.k != z) {
            this.k = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconHovered(boolean z) {
        if (this.l != z) {
            this.l = z;
            refreshDrawableState();
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        a aVar = this.f36085e;
        int i2 = 0;
        if (aVar != null && a.a(aVar.j)) {
            a aVar2 = this.f36085e;
            int i3 = isEnabled() ? 1 : 0;
            if (this.m) {
                i3++;
            }
            if (this.l) {
                i3++;
            }
            if (this.k) {
                i3++;
            }
            if (isChecked()) {
                i3++;
            }
            int[] iArr = new int[i3];
            if (isEnabled()) {
                iArr[0] = 16842910;
                i2 = 1;
            }
            if (this.m) {
                iArr[i2] = 16842908;
                i2++;
            }
            if (this.l) {
                iArr[i2] = 16843623;
                i2++;
            }
            if (this.k) {
                iArr[i2] = 16842919;
                i2++;
            }
            if (isChecked()) {
                iArr[i2] = 16842913;
            }
            i2 = aVar2.a(iArr);
        }
        if (i2 != 0) {
            invalidate();
        }
    }

    /* access modifiers changed from: private */
    public boolean j() {
        a aVar = this.f36085e;
        return (aVar == null || aVar.f() == null) ? false : true;
    }

    /* access modifiers changed from: private */
    public RectF getCloseIconTouchBounds() {
        this.s.setEmpty();
        if (j()) {
            a aVar = this.f36085e;
            aVar.a(aVar.getBounds(), this.s);
        }
        return this.s;
    }

    /* access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.r.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.r;
    }

    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i2) {
        if (!getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) || !isEnabled()) {
            return null;
        }
        return PointerIcon.getSystemIcon(getContext(), 1002);
    }

    class a extends androidx.customview.a.a {
        a(Chip chip) {
            super(chip);
        }

        public final int a(float f2, float f3) {
            return (!Chip.this.j() || !Chip.this.getCloseIconTouchBounds().contains(f2, f3)) ? 0 : 1;
        }

        public final void a(List<Integer> list) {
            list.add(0);
            if (Chip.this.j() && Chip.this.c() && Chip.this.f36088h != null) {
                list.add(1);
            }
        }

        public final void a(int i2, boolean z) {
            if (i2 == 1) {
                boolean unused = Chip.this.m = z;
                Chip.this.refreshDrawableState();
            }
        }

        public final void a(int i2, androidx.core.h.a.c cVar) {
            if (i2 == 1) {
                CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
                if (closeIconContentDescription != null) {
                    cVar.e(closeIconContentDescription);
                } else {
                    CharSequence text = Chip.this.getText();
                    Context context = Chip.this.getContext();
                    int i3 = R.string.mtrl_chip_close_icon_content_description;
                    Object[] objArr = new Object[1];
                    if (TextUtils.isEmpty(text)) {
                        text = "";
                    }
                    objArr[0] = text;
                    cVar.e((CharSequence) context.getString(i3, objArr).trim());
                }
                cVar.b(Chip.this.getCloseIconTouchBoundsInt());
                cVar.a(c.a.f3048e);
                cVar.i(Chip.this.isEnabled());
                return;
            }
            cVar.e((CharSequence) "");
            cVar.b(Chip.f36082b);
        }

        public final void a(androidx.core.h.a.c cVar) {
            cVar.a(Chip.this.d());
            cVar.g(Chip.this.isClickable());
            if (Chip.this.d() || Chip.this.isClickable()) {
                cVar.b((CharSequence) Chip.this.d() ? "android.widget.CompoundButton" : "android.widget.Button");
            } else {
                cVar.b((CharSequence) "android.view.View");
            }
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                cVar.c(text);
            } else {
                cVar.e(text);
            }
        }

        public final boolean b(int i2, int i3, Bundle bundle) {
            if (i3 != 16) {
                return false;
            }
            if (i2 == 0) {
                return Chip.this.performClick();
            }
            if (i2 == 1) {
                return Chip.this.b();
            }
            return false;
        }
    }

    public ColorStateList getChipBackgroundColor() {
        a aVar = this.f36085e;
        if (aVar != null) {
            return aVar.f36105a;
        }
        return null;
    }

    public void setChipBackgroundColorResource(int i2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.a(androidx.appcompat.a.a.a.a(aVar.A, i2));
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.a(colorStateList);
        }
    }

    public float getChipMinHeight() {
        a aVar = this.f36085e;
        if (aVar != null) {
            return aVar.f36106b;
        }
        return 0.0f;
    }

    public void setChipMinHeightResource(int i2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.a(aVar.A.getResources().getDimension(i2));
        }
    }

    public void setChipMinHeight(float f2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.a(f2);
        }
    }

    public float getChipCornerRadius() {
        a aVar = this.f36085e;
        if (aVar != null) {
            return Math.max(0.0f, aVar.d());
        }
        return 0.0f;
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.b(aVar.A.getResources().getDimension(i2));
        }
    }

    public void setShapeAppearanceModel(m mVar) {
        this.f36085e.setShapeAppearanceModel(mVar);
    }

    public m getShapeAppearanceModel() {
        return this.f36085e.G.f36536a;
    }

    @Deprecated
    public void setChipCornerRadius(float f2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.b(f2);
        }
    }

    public ColorStateList getChipStrokeColor() {
        a aVar = this.f36085e;
        if (aVar != null) {
            return aVar.f36107c;
        }
        return null;
    }

    public void setChipStrokeColorResource(int i2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.b(androidx.appcompat.a.a.a.a(aVar.A, i2));
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.b(colorStateList);
        }
    }

    public float getChipStrokeWidth() {
        a aVar = this.f36085e;
        if (aVar != null) {
            return aVar.f36108d;
        }
        return 0.0f;
    }

    public void setChipStrokeWidthResource(int i2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.c(aVar.A.getResources().getDimension(i2));
        }
    }

    public void setChipStrokeWidth(float f2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.c(f2);
        }
    }

    public ColorStateList getRippleColor() {
        a aVar = this.f36085e;
        if (aVar != null) {
            return aVar.f36109e;
        }
        return null;
    }

    public void setRippleColorResource(int i2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.c(androidx.appcompat.a.a.a.a(aVar.A, i2));
            if (!this.f36085e.C) {
                i();
            }
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.c(colorStateList);
        }
        if (!this.f36085e.C) {
            i();
        }
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public void setLayoutDirection(int i2) {
        if (this.f36085e != null && Build.VERSION.SDK_INT >= 17) {
            super.setLayoutDirection(i2);
        }
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (this.f36085e != null) {
            if (charSequence == null) {
                charSequence = "";
            }
            super.setText(this.f36085e.E ? null : charSequence, bufferType);
            a aVar = this.f36085e;
            if (aVar != null) {
                aVar.a(charSequence);
            }
        }
    }

    @Deprecated
    public void setChipTextResource(int i2) {
        setText(getResources().getString(i2));
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    public void setTextAppearanceResource(int i2) {
        setTextAppearance(getContext(), i2);
    }

    public void setTextAppearance(d dVar) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.a(dVar);
        }
        k();
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.a(i2);
        }
        k();
    }

    public void setTextAppearance(int i2) {
        super.setTextAppearance(i2);
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.a(i2);
        }
        k();
    }

    private void k() {
        TextPaint paint = getPaint();
        a aVar = this.f36085e;
        if (aVar != null) {
            paint.drawableState = aVar.getState();
        }
        d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.a(getContext(), paint, this.t);
        }
    }

    private d getTextAppearance() {
        a aVar = this.f36085e;
        if (aVar != null) {
            return aVar.B.f36483d;
        }
        return null;
    }

    public void setChipIconVisible(int i2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.b(aVar.A.getResources().getBoolean(i2));
        }
    }

    public void setChipIconVisible(boolean z) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.b(z);
        }
    }

    @Deprecated
    public void setChipIconEnabledResource(int i2) {
        setChipIconVisible(i2);
    }

    @Deprecated
    public void setChipIconEnabled(boolean z) {
        setChipIconVisible(z);
    }

    public Drawable getChipIcon() {
        a aVar = this.f36085e;
        if (aVar != null) {
            return aVar.e();
        }
        return null;
    }

    public void setChipIconResource(int i2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.b(androidx.appcompat.a.a.a.b(aVar.A, i2));
        }
    }

    public void setChipIcon(Drawable drawable) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.b(drawable);
        }
    }

    public ColorStateList getChipIconTint() {
        a aVar = this.f36085e;
        if (aVar != null) {
            return aVar.f36111g;
        }
        return null;
    }

    public void setChipIconTintResource(int i2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.d(androidx.appcompat.a.a.a.a(aVar.A, i2));
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.d(colorStateList);
        }
    }

    public float getChipIconSize() {
        a aVar = this.f36085e;
        if (aVar != null) {
            return aVar.f36112h;
        }
        return 0.0f;
    }

    public void setChipIconSizeResource(int i2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.d(aVar.A.getResources().getDimension(i2));
        }
    }

    public void setChipIconSize(float f2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.d(f2);
        }
    }

    public final boolean c() {
        a aVar = this.f36085e;
        return aVar != null && aVar.f36113i;
    }

    public void setCloseIconVisible(int i2) {
        setCloseIconVisible(getResources().getBoolean(i2));
    }

    public void setCloseIconVisible(boolean z) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.c(z);
        }
        f();
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i2) {
        setCloseIconVisible(i2);
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        setCloseIconVisible(z);
    }

    public Drawable getCloseIcon() {
        a aVar = this.f36085e;
        if (aVar != null) {
            return aVar.f();
        }
        return null;
    }

    public void setCloseIconResource(int i2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.c(androidx.appcompat.a.a.a.b(aVar.A, i2));
        }
        f();
    }

    public void setCloseIcon(Drawable drawable) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.c(drawable);
        }
        f();
    }

    public ColorStateList getCloseIconTint() {
        a aVar = this.f36085e;
        if (aVar != null) {
            return aVar.k;
        }
        return null;
    }

    public void setCloseIconTintResource(int i2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.e(androidx.appcompat.a.a.a.a(aVar.A, i2));
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.e(colorStateList);
        }
    }

    public float getCloseIconSize() {
        a aVar = this.f36085e;
        if (aVar != null) {
            return aVar.l;
        }
        return 0.0f;
    }

    public void setCloseIconSizeResource(int i2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.e(aVar.A.getResources().getDimension(i2));
        }
    }

    public void setCloseIconSize(float f2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.e(f2);
        }
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        a aVar = this.f36085e;
        if (aVar != null && aVar.m != charSequence) {
            aVar.m = androidx.core.f.a.a().a(charSequence);
            aVar.invalidateSelf();
        }
    }

    public CharSequence getCloseIconContentDescription() {
        a aVar = this.f36085e;
        if (aVar != null) {
            return aVar.m;
        }
        return null;
    }

    public final boolean d() {
        a aVar = this.f36085e;
        return aVar != null && aVar.n;
    }

    public void setCheckableResource(int i2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.d(aVar.A.getResources().getBoolean(i2));
        }
    }

    public void setCheckable(boolean z) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.d(z);
        }
    }

    public void setCheckedIconVisible(int i2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.e(aVar.A.getResources().getBoolean(i2));
        }
    }

    public void setCheckedIconVisible(boolean z) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.e(z);
        }
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i2) {
        setCheckedIconVisible(i2);
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        setCheckedIconVisible(z);
    }

    public Drawable getCheckedIcon() {
        a aVar = this.f36085e;
        if (aVar != null) {
            return aVar.o;
        }
        return null;
    }

    public void setCheckedIconResource(int i2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.d(androidx.appcompat.a.a.a.b(aVar.A, i2));
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.d(drawable);
        }
    }

    public ColorStateList getCheckedIconTint() {
        a aVar = this.f36085e;
        if (aVar != null) {
            return aVar.p;
        }
        return null;
    }

    public void setCheckedIconTintResource(int i2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.f(androidx.appcompat.a.a.a.a(aVar.A, i2));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.f(colorStateList);
        }
    }

    public com.google.android.material.a.h getShowMotionSpec() {
        a aVar = this.f36085e;
        if (aVar != null) {
            return aVar.q;
        }
        return null;
    }

    public void setShowMotionSpecResource(int i2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.q = com.google.android.material.a.h.a(aVar.A, i2);
        }
    }

    public void setShowMotionSpec(com.google.android.material.a.h hVar) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.q = hVar;
        }
    }

    public com.google.android.material.a.h getHideMotionSpec() {
        a aVar = this.f36085e;
        if (aVar != null) {
            return aVar.r;
        }
        return null;
    }

    public void setHideMotionSpecResource(int i2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.r = com.google.android.material.a.h.a(aVar.A, i2);
        }
    }

    public void setHideMotionSpec(com.google.android.material.a.h hVar) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.r = hVar;
        }
    }

    public float getChipStartPadding() {
        a aVar = this.f36085e;
        if (aVar != null) {
            return aVar.s;
        }
        return 0.0f;
    }

    public void setChipStartPaddingResource(int i2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.f(aVar.A.getResources().getDimension(i2));
        }
    }

    public void setChipStartPadding(float f2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.f(f2);
        }
    }

    public float getIconStartPadding() {
        a aVar = this.f36085e;
        if (aVar != null) {
            return aVar.t;
        }
        return 0.0f;
    }

    public void setIconStartPaddingResource(int i2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.g(aVar.A.getResources().getDimension(i2));
        }
    }

    public void setIconStartPadding(float f2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.g(f2);
        }
    }

    public float getIconEndPadding() {
        a aVar = this.f36085e;
        if (aVar != null) {
            return aVar.u;
        }
        return 0.0f;
    }

    public void setIconEndPaddingResource(int i2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.h(aVar.A.getResources().getDimension(i2));
        }
    }

    public void setIconEndPadding(float f2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.h(f2);
        }
    }

    public float getTextStartPadding() {
        a aVar = this.f36085e;
        if (aVar != null) {
            return aVar.v;
        }
        return 0.0f;
    }

    public void setTextStartPaddingResource(int i2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.i(aVar.A.getResources().getDimension(i2));
        }
    }

    public void setTextStartPadding(float f2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.i(f2);
        }
    }

    public float getTextEndPadding() {
        a aVar = this.f36085e;
        if (aVar != null) {
            return aVar.w;
        }
        return 0.0f;
    }

    public void setTextEndPaddingResource(int i2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.j(aVar.A.getResources().getDimension(i2));
        }
    }

    public void setTextEndPadding(float f2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.j(f2);
        }
    }

    public float getCloseIconStartPadding() {
        a aVar = this.f36085e;
        if (aVar != null) {
            return aVar.x;
        }
        return 0.0f;
    }

    public void setCloseIconStartPaddingResource(int i2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.k(aVar.A.getResources().getDimension(i2));
        }
    }

    public void setCloseIconStartPadding(float f2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.k(f2);
        }
    }

    public float getCloseIconEndPadding() {
        a aVar = this.f36085e;
        if (aVar != null) {
            return aVar.y;
        }
        return 0.0f;
    }

    public void setCloseIconEndPaddingResource(int i2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.l(aVar.A.getResources().getDimension(i2));
        }
    }

    public void setCloseIconEndPadding(float f2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.l(f2);
        }
    }

    public float getChipEndPadding() {
        a aVar = this.f36085e;
        if (aVar != null) {
            return aVar.z;
        }
        return 0.0f;
    }

    public void setChipEndPaddingResource(int i2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.m(aVar.A.getResources().getDimension(i2));
        }
    }

    public void setChipEndPadding(float f2) {
        a aVar = this.f36085e;
        if (aVar != null) {
            aVar.m(f2);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        this.n = z;
        a(this.p);
    }

    private boolean a(int i2) {
        this.p = i2;
        int i3 = 0;
        if (!this.n) {
            if (this.f36086f != null) {
                l();
            } else {
                h();
            }
            return false;
        }
        int max = Math.max(0, i2 - this.f36085e.getIntrinsicHeight());
        int max2 = Math.max(0, i2 - this.f36085e.getIntrinsicWidth());
        if (max2 > 0 || max > 0) {
            int i4 = max2 > 0 ? max2 / 2 : 0;
            if (max > 0) {
                i3 = max / 2;
            }
            if (this.f36086f != null) {
                Rect rect = new Rect();
                this.f36086f.getPadding(rect);
                if (rect.top == i3 && rect.bottom == i3 && rect.left == i4 && rect.right == i4) {
                    h();
                    return true;
                }
            }
            if (Build.VERSION.SDK_INT >= 16) {
                if (getMinHeight() != i2) {
                    setMinHeight(i2);
                }
                if (getMinWidth() != i2) {
                    setMinWidth(i2);
                }
            } else {
                setMinHeight(i2);
                setMinWidth(i2);
            }
            a(i4, i3, i4, i3);
            h();
            return true;
        }
        if (this.f36086f != null) {
            l();
        } else {
            h();
        }
        return false;
    }

    private void l() {
        if (this.f36086f != null) {
            this.f36086f = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            h();
        }
    }

    private void a(int i2, int i3, int i4, int i5) {
        this.f36086f = new InsetDrawable(this.f36085e, i2, i3, i4, i5);
    }
}
