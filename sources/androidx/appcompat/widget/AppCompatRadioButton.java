package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioButton;
import androidx.appcompat.R;
import androidx.appcompat.a.a.a;
import androidx.core.h.t;
import androidx.core.widget.j;

public class AppCompatRadioButton extends RadioButton implements t, j {

    /* renamed from: a  reason: collision with root package name */
    private final e f1484a;

    /* renamed from: b  reason: collision with root package name */
    private final d f1485b;

    /* renamed from: c  reason: collision with root package name */
    private final l f1486c;

    public AppCompatRadioButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.radioButtonStyle);
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet, int i2) {
        super(z.a(context), attributeSet, i2);
        y.a((View) this, getContext());
        this.f1484a = new e(this);
        this.f1484a.a(attributeSet, i2);
        this.f1485b = new d(this);
        this.f1485b.a(attributeSet, i2);
        this.f1486c = new l(this);
        this.f1486c.a(attributeSet, i2);
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        e eVar = this.f1484a;
        if (eVar != null) {
            eVar.a();
        }
    }

    public void setButtonDrawable(int i2) {
        setButtonDrawable(a.b(getContext(), i2));
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        e eVar = this.f1484a;
        return eVar != null ? eVar.a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        e eVar = this.f1484a;
        if (eVar != null) {
            eVar.a(colorStateList);
        }
    }

    public ColorStateList getSupportButtonTintList() {
        e eVar = this.f1484a;
        if (eVar != null) {
            return eVar.f1729a;
        }
        return null;
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        e eVar = this.f1484a;
        if (eVar != null) {
            eVar.a(mode);
        }
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        e eVar = this.f1484a;
        if (eVar != null) {
            return eVar.f1730b;
        }
        return null;
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f1485b;
        if (dVar != null) {
            dVar.a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f1485b;
        if (dVar != null) {
            return dVar.b();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f1485b;
        if (dVar != null) {
            dVar.a(mode);
        }
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f1485b;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f1485b;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        d dVar = this.f1485b;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f1485b;
        if (dVar != null) {
            dVar.d();
        }
        l lVar = this.f1486c;
        if (lVar != null) {
            lVar.a();
        }
    }
}
