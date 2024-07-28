package com.google.android.material.card;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.cardview.widget.CardView;
import androidx.core.h.u;
import com.google.android.material.R;
import com.google.android.material.h.b;
import com.google.android.material.h.c;
import com.google.android.material.internal.k;
import com.google.android.material.k.i;
import com.google.android.material.k.m;
import com.google.android.material.k.p;

public class MaterialCardView extends CardView implements Checkable, p {

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f36062e = {16842911};

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f36063f = {16842912};

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f36064g = {R.attr.state_dragged};

    /* renamed from: h  reason: collision with root package name */
    private static final int f36065h = R.style.Widget_MaterialComponents_CardView;

    /* renamed from: i  reason: collision with root package name */
    private final a f36066i;
    private boolean j;
    private boolean k;
    private boolean l;
    private a m;

    public interface a {
    }

    public MaterialCardView(Context context) {
        this(context, (AttributeSet) null);
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialCardViewStyle);
    }

    public MaterialCardView(Context context, AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.a(context, attributeSet, i2, f36065h), attributeSet, i2);
        this.k = false;
        this.l = false;
        this.j = true;
        TypedArray a2 = k.a(getContext(), attributeSet, R.styleable.MaterialCardView, i2, f36065h, new int[0]);
        this.f36066i = new a(this, attributeSet, i2, f36065h);
        this.f36066i.b(super.getCardBackgroundColor());
        this.f36066i.a(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        a aVar = this.f36066i;
        aVar.m = c.a(aVar.f36067a.getContext(), a2, R.styleable.MaterialCardView_strokeColor);
        if (aVar.m == null) {
            aVar.m = ColorStateList.valueOf(-1);
        }
        aVar.f36073g = a2.getDimensionPixelSize(R.styleable.MaterialCardView_strokeWidth, 0);
        aVar.q = a2.getBoolean(R.styleable.MaterialCardView_android_checkable, false);
        aVar.f36067a.setLongClickable(aVar.q);
        aVar.k = c.a(aVar.f36067a.getContext(), a2, R.styleable.MaterialCardView_checkedIconTint);
        aVar.a(c.b(aVar.f36067a.getContext(), a2, R.styleable.MaterialCardView_checkedIcon));
        aVar.j = c.a(aVar.f36067a.getContext(), a2, R.styleable.MaterialCardView_rippleColor);
        if (aVar.j == null) {
            aVar.j = ColorStateList.valueOf(b.a((View) aVar.f36067a, R.attr.colorControlHighlight));
        }
        aVar.c(c.a(aVar.f36067a.getContext(), a2, R.styleable.MaterialCardView_cardForegroundColor));
        aVar.k();
        aVar.a();
        aVar.c();
        aVar.f36067a.setBackgroundInternal(aVar.b((Drawable) aVar.f36069c));
        aVar.f36074h = aVar.f36067a.isClickable() ? aVar.j() : aVar.f36070d;
        aVar.f36067a.setForeground(aVar.b(aVar.f36074h));
        a2.recycle();
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        accessibilityNodeInfo.setCheckable(a());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(isChecked());
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        super.onMeasure(i2, i3);
        a aVar = this.f36066i;
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (aVar.n != null) {
            int i6 = (measuredWidth - aVar.f36071e) - aVar.f36072f;
            int i7 = (measuredHeight - aVar.f36071e) - aVar.f36072f;
            if ((Build.VERSION.SDK_INT < 21) || aVar.f36067a.getUseCompatPadding()) {
                i7 -= (int) Math.ceil((double) (aVar.f() * 2.0f));
                i6 -= (int) Math.ceil((double) (aVar.g() * 2.0f));
            }
            int i8 = i7;
            int i9 = aVar.f36071e;
            if (u.j(aVar.f36067a) == 1) {
                i4 = i6;
                i5 = i9;
            } else {
                i5 = i6;
                i4 = i9;
            }
            aVar.n.setLayerInset(2, i5, aVar.f36071e, i4, i8);
        }
    }

    public void setStrokeColor(int i2) {
        this.f36066i.a(ColorStateList.valueOf(i2));
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.f36066i.a(colorStateList);
    }

    @Deprecated
    public int getStrokeColor() {
        a aVar = this.f36066i;
        if (aVar.m == null) {
            return -1;
        }
        return aVar.m.getDefaultColor();
    }

    public ColorStateList getStrokeColorStateList() {
        return this.f36066i.m;
    }

    public void setStrokeWidth(int i2) {
        a aVar = this.f36066i;
        if (i2 != aVar.f36073g) {
            aVar.f36073g = i2;
            aVar.c();
        }
    }

    public int getStrokeWidth() {
        return this.f36066i.f36073g;
    }

    public void setRadius(float f2) {
        super.setRadius(f2);
        a aVar = this.f36066i;
        aVar.a(aVar.l.a(f2));
        aVar.f36074h.invalidateSelf();
        if (aVar.i() || aVar.h()) {
            aVar.d();
        }
        if (aVar.i()) {
            aVar.b();
        }
    }

    public float getRadius() {
        return this.f36066i.f36069c.m();
    }

    public void setProgress(float f2) {
        a aVar = this.f36066i;
        aVar.f36069c.p(f2);
        if (aVar.f36070d != null) {
            aVar.f36070d.p(f2);
        }
        if (aVar.o != null) {
            aVar.o.p(f2);
        }
    }

    public float getProgress() {
        return this.f36066i.f36069c.G.k;
    }

    public void setContentPadding(int i2, int i3, int i4, int i5) {
        this.f36066i.a(i2, i3, i4, i5);
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, int i3, int i4, int i5) {
        super.setContentPadding(i2, i3, i4, i5);
    }

    public int getContentPaddingLeft() {
        return this.f36066i.f36068b.left;
    }

    public int getContentPaddingTop() {
        return this.f36066i.f36068b.top;
    }

    public int getContentPaddingRight() {
        return this.f36066i.f36068b.right;
    }

    public int getContentPaddingBottom() {
        return this.f36066i.f36068b.bottom;
    }

    public void setCardBackgroundColor(int i2) {
        this.f36066i.b(ColorStateList.valueOf(i2));
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.f36066i.b(colorStateList);
    }

    public ColorStateList getCardBackgroundColor() {
        return this.f36066i.f36069c.G.f36539d;
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        this.f36066i.c(colorStateList);
    }

    public ColorStateList getCardForegroundColor() {
        return this.f36066i.f36070d.G.f36539d;
    }

    public void setClickable(boolean z) {
        super.setClickable(z);
        a aVar = this.f36066i;
        Drawable drawable = aVar.f36074h;
        aVar.f36074h = aVar.f36067a.isClickable() ? aVar.j() : aVar.f36070d;
        if (drawable != aVar.f36074h) {
            Drawable drawable2 = aVar.f36074h;
            if (Build.VERSION.SDK_INT < 23 || !(aVar.f36067a.getForeground() instanceof InsetDrawable)) {
                aVar.f36067a.setForeground(aVar.b(drawable2));
            } else {
                ((InsetDrawable) aVar.f36067a.getForeground()).setDrawable(drawable2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.a((View) this, this.f36066i.f36069c);
    }

    public void setCardElevation(float f2) {
        super.setCardElevation(f2);
        this.f36066i.a();
    }

    public void setMaxCardElevation(float f2) {
        super.setMaxCardElevation(f2);
        this.f36066i.b();
    }

    public void setUseCompatPadding(boolean z) {
        super.setUseCompatPadding(z);
        this.f36066i.b();
        this.f36066i.d();
    }

    public void setPreventCornerOverlap(boolean z) {
        super.setPreventCornerOverlap(z);
        this.f36066i.b();
        this.f36066i.d();
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (this.j) {
            if (!this.f36066i.p) {
                this.f36066i.p = true;
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    /* access modifiers changed from: package-private */
    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public boolean isChecked() {
        return this.k;
    }

    public void setChecked(boolean z) {
        if (this.k != z) {
            toggle();
        }
    }

    public void setDragged(boolean z) {
        if (this.l != z) {
            this.l = z;
            refreshDrawableState();
            b();
            invalidate();
        }
    }

    private boolean a() {
        a aVar = this.f36066i;
        return aVar != null && aVar.q;
    }

    public void setCheckable(boolean z) {
        this.f36066i.q = z;
    }

    public void toggle() {
        if (a() && isEnabled()) {
            this.k = !this.k;
            refreshDrawableState();
            b();
        }
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 3);
        if (a()) {
            mergeDrawableStates(onCreateDrawableState, f36062e);
        }
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f36063f);
        }
        if (this.l) {
            mergeDrawableStates(onCreateDrawableState, f36064g);
        }
        return onCreateDrawableState;
    }

    public void setOnCheckedChangeListener(a aVar) {
        this.m = aVar;
    }

    public void setRippleColor(ColorStateList colorStateList) {
        this.f36066i.d(colorStateList);
    }

    public void setRippleColorResource(int i2) {
        this.f36066i.d(androidx.appcompat.a.a.a.a(getContext(), i2));
    }

    public ColorStateList getRippleColor() {
        return this.f36066i.j;
    }

    public Drawable getCheckedIcon() {
        return this.f36066i.f36075i;
    }

    public void setCheckedIconResource(int i2) {
        this.f36066i.a(androidx.appcompat.a.a.a.b(getContext(), i2));
    }

    public void setCheckedIcon(Drawable drawable) {
        this.f36066i.a(drawable);
    }

    public ColorStateList getCheckedIconTint() {
        return this.f36066i.k;
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        a aVar = this.f36066i;
        aVar.k = colorStateList;
        if (aVar.f36075i != null) {
            androidx.core.graphics.drawable.a.a(aVar.f36075i, colorStateList);
        }
    }

    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.f36066i.f36069c.getBounds());
        return rectF;
    }

    public void setShapeAppearanceModel(m mVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(mVar.a(getBoundsAsRectF()));
        }
        this.f36066i.a(mVar);
    }

    public m getShapeAppearanceModel() {
        return this.f36066i.l;
    }

    private void b() {
        if (Build.VERSION.SDK_INT > 26) {
            this.f36066i.e();
        }
    }

    /* access modifiers changed from: package-private */
    public float getCardViewRadius() {
        return super.getRadius();
    }
}
