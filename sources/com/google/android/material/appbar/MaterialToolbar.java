package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.core.h.u;
import com.google.android.material.R;
import com.google.android.material.k.h;
import com.google.android.material.k.i;
import com.google.android.material.theme.a.a;

public class MaterialToolbar extends Toolbar {

    /* renamed from: a  reason: collision with root package name */
    private static final int f35872a = R.style.Widget_MaterialComponents_Toolbar;

    public MaterialToolbar(Context context) {
        this(context, (AttributeSet) null);
    }

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    public MaterialToolbar(Context context, AttributeSet attributeSet, int i2) {
        super(a.a(context, attributeSet, i2, f35872a), attributeSet, i2);
        Context context2 = getContext();
        Drawable background = getBackground();
        if (background == null || (background instanceof ColorDrawable)) {
            h hVar = new h();
            hVar.g(ColorStateList.valueOf(background != null ? ((ColorDrawable) background).getColor() : 0));
            hVar.a(context2);
            hVar.r(u.v(this));
            u.a((View) this, (Drawable) hVar);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.a((View) this);
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        i.a((View) this, f2);
    }
}
