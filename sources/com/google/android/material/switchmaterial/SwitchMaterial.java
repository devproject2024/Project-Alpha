package com.google.android.material.switchmaterial;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.R;
import com.google.android.material.e.a;
import com.google.android.material.h.b;
import com.google.android.material.internal.k;
import com.google.android.material.internal.q;

public class SwitchMaterial extends SwitchCompat {

    /* renamed from: c  reason: collision with root package name */
    private static final int f36714c = R.style.Widget_MaterialComponents_CompoundButton_Switch;

    /* renamed from: d  reason: collision with root package name */
    private static final int[][] f36715d = {new int[]{16842910, 16842912}, new int[]{16842910, -16842912}, new int[]{-16842910, 16842912}, new int[]{-16842910, -16842912}};

    /* renamed from: e  reason: collision with root package name */
    private final a f36716e;

    /* renamed from: f  reason: collision with root package name */
    private ColorStateList f36717f;

    /* renamed from: g  reason: collision with root package name */
    private ColorStateList f36718g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f36719h;

    public SwitchMaterial(Context context) {
        this(context, (AttributeSet) null);
    }

    public SwitchMaterial(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.switchStyle);
    }

    public SwitchMaterial(Context context, AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.a(context, attributeSet, i2, f36714c), attributeSet, i2);
        Context context2 = getContext();
        this.f36716e = new a(context2);
        TypedArray a2 = k.a(context2, attributeSet, R.styleable.SwitchMaterial, i2, f36714c, new int[0]);
        this.f36719h = a2.getBoolean(R.styleable.SwitchMaterial_useMaterialThemeColors, false);
        a2.recycle();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f36719h && getThumbTintList() == null) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
        }
        if (this.f36719h && getTrackTintList() == null) {
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        }
    }

    public void setUseMaterialThemeColors(boolean z) {
        this.f36719h = z;
        if (z) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
            setTrackTintList(getMaterialThemeColorsTrackTintList());
            return;
        }
        setThumbTintList((ColorStateList) null);
        setTrackTintList((ColorStateList) null);
    }

    private ColorStateList getMaterialThemeColorsThumbTintList() {
        if (this.f36717f == null) {
            int a2 = b.a((View) this, R.attr.colorSurface);
            int a3 = b.a((View) this, R.attr.colorControlActivated);
            float dimension = getResources().getDimension(R.dimen.mtrl_switch_thumb_elevation);
            if (this.f36716e.f36266a) {
                dimension += q.c(this);
            }
            int a4 = this.f36716e.a(a2, dimension);
            int[] iArr = new int[f36715d.length];
            iArr[0] = com.google.android.material.b.a.a(a2, a3, 1.0f);
            iArr[1] = a4;
            iArr[2] = com.google.android.material.b.a.a(a2, a3, 0.38f);
            iArr[3] = a4;
            this.f36717f = new ColorStateList(f36715d, iArr);
        }
        return this.f36717f;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        if (this.f36718g == null) {
            int[] iArr = new int[f36715d.length];
            int a2 = b.a((View) this, R.attr.colorSurface);
            int a3 = b.a((View) this, R.attr.colorControlActivated);
            int a4 = b.a((View) this, R.attr.colorOnSurface);
            iArr[0] = com.google.android.material.b.a.a(a2, a3, 0.54f);
            iArr[1] = com.google.android.material.b.a.a(a2, a4, 0.32f);
            iArr[2] = com.google.android.material.b.a.a(a2, a3, 0.12f);
            iArr[3] = com.google.android.material.b.a.a(a2, a4, 0.12f);
            this.f36718g = new ColorStateList(f36715d, iArr);
        }
        return this.f36718g;
    }
}
