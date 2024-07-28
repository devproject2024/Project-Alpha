package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.h.t;
import androidx.core.widget.b;
import androidx.core.widget.i;
import androidx.core.widget.k;

public class AppCompatButton extends Button implements t, b, k {

    /* renamed from: a  reason: collision with root package name */
    private final d f1470a;

    /* renamed from: b  reason: collision with root package name */
    private final l f1471b;

    public AppCompatButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyle);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet, int i2) {
        super(z.a(context), attributeSet, i2);
        y.a((View) this, getContext());
        this.f1470a = new d(this);
        this.f1470a.a(attributeSet, i2);
        this.f1471b = new l(this);
        this.f1471b.a(attributeSet, i2);
        this.f1471b.a();
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        d dVar = this.f1470a;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f1470a;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f1470a;
        if (dVar != null) {
            dVar.a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f1470a;
        if (dVar != null) {
            return dVar.b();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f1470a;
        if (dVar != null) {
            dVar.a(mode);
        }
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f1470a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f1470a;
        if (dVar != null) {
            dVar.d();
        }
        l lVar = this.f1471b;
        if (lVar != null) {
            lVar.a();
        }
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        l lVar = this.f1471b;
        if (lVar != null) {
            lVar.a(context, i2);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        l lVar = this.f1471b;
        if (lVar != null) {
            lVar.b();
        }
    }

    public void setTextSize(int i2, float f2) {
        if (f3188d) {
            super.setTextSize(i2, f2);
            return;
        }
        l lVar = this.f1471b;
        if (lVar != null) {
            lVar.a(i2, f2);
        }
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        if (this.f1471b != null && !f3188d && this.f1471b.f1759a.b()) {
            this.f1471b.f1759a.a();
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i2) {
        if (f3188d) {
            super.setAutoSizeTextTypeWithDefaults(i2);
            return;
        }
        l lVar = this.f1471b;
        if (lVar != null) {
            lVar.a(i2);
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        if (f3188d) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
            return;
        }
        l lVar = this.f1471b;
        if (lVar != null) {
            lVar.a(i2, i3, i4, i5);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i2) throws IllegalArgumentException {
        if (f3188d) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
            return;
        }
        l lVar = this.f1471b;
        if (lVar != null) {
            lVar.a(iArr, i2);
        }
    }

    public int getAutoSizeTextType() {
        if (!f3188d) {
            l lVar = this.f1471b;
            if (lVar != null) {
                return lVar.f1759a.f1775a;
            }
            return 0;
        } else if (super.getAutoSizeTextType() == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public int getAutoSizeStepGranularity() {
        if (f3188d) {
            return super.getAutoSizeStepGranularity();
        }
        l lVar = this.f1471b;
        if (lVar != null) {
            return Math.round(lVar.f1759a.f1776b);
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (f3188d) {
            return super.getAutoSizeMinTextSize();
        }
        l lVar = this.f1471b;
        if (lVar != null) {
            return Math.round(lVar.f1759a.f1777c);
        }
        return -1;
    }

    public int getAutoSizeMaxTextSize() {
        if (f3188d) {
            return super.getAutoSizeMaxTextSize();
        }
        l lVar = this.f1471b;
        if (lVar != null) {
            return Math.round(lVar.f1759a.f1778d);
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (f3188d) {
            return super.getAutoSizeTextAvailableSizes();
        }
        l lVar = this.f1471b;
        return lVar != null ? lVar.f1759a.f1779e : new int[0];
    }

    public void setSupportAllCaps(boolean z) {
        l lVar = this.f1471b;
        if (lVar != null) {
            lVar.a(z);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(i.a((TextView) this, callback));
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1471b.a(colorStateList);
        this.f1471b.a();
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1471b.c();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1471b.a(mode);
        this.f1471b.a();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1471b.d();
    }
}
