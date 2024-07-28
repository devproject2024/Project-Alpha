package com.google.android.material.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.widget.c;
import com.google.android.material.R;
import com.google.android.material.h.b;
import com.google.android.material.internal.k;
import com.google.android.material.theme.a.a;

public class MaterialCheckBox extends AppCompatCheckBox {

    /* renamed from: a  reason: collision with root package name */
    private static final int f36077a = R.style.Widget_MaterialComponents_CompoundButton_CheckBox;

    /* renamed from: b  reason: collision with root package name */
    private static final int[][] f36078b = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};

    /* renamed from: c  reason: collision with root package name */
    private ColorStateList f36079c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f36080d;

    public MaterialCheckBox(Context context) {
        this(context, (AttributeSet) null);
    }

    public MaterialCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkboxStyle);
    }

    public MaterialCheckBox(Context context, AttributeSet attributeSet, int i2) {
        super(a.a(context, attributeSet, i2, f36077a), attributeSet, i2);
        Context context2 = getContext();
        TypedArray a2 = k.a(context2, attributeSet, R.styleable.MaterialCheckBox, i2, f36077a, new int[0]);
        if (a2.hasValue(R.styleable.MaterialCheckBox_buttonTint)) {
            c.a((CompoundButton) this, com.google.android.material.h.c.a(context2, a2, R.styleable.MaterialCheckBox_buttonTint));
        }
        this.f36080d = a2.getBoolean(R.styleable.MaterialCheckBox_useMaterialThemeColors, false);
        a2.recycle();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f36080d && c.a(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.f36080d = z;
        if (z) {
            c.a((CompoundButton) this, getMaterialThemeColorsTintList());
        } else {
            c.a((CompoundButton) this, (ColorStateList) null);
        }
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.f36079c == null) {
            int[] iArr = new int[f36078b.length];
            int a2 = b.a((View) this, R.attr.colorControlActivated);
            int a3 = b.a((View) this, R.attr.colorSurface);
            int a4 = b.a((View) this, R.attr.colorOnSurface);
            iArr[0] = com.google.android.material.b.a.a(a3, a2, 1.0f);
            iArr[1] = com.google.android.material.b.a.a(a3, a4, 0.54f);
            iArr[2] = com.google.android.material.b.a.a(a3, a4, 0.38f);
            iArr[3] = com.google.android.material.b.a.a(a3, a4, 0.38f);
            this.f36079c = new ColorStateList(f36078b, iArr);
        }
        return this.f36079c;
    }
}
