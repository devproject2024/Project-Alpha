package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.a.a.a;
import androidx.core.h.t;
import androidx.core.widget.i;

public class AppCompatAutoCompleteTextView extends AutoCompleteTextView implements t {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f1467a = {16843126};

    /* renamed from: b  reason: collision with root package name */
    private final d f1468b;

    /* renamed from: c  reason: collision with root package name */
    private final l f1469c;

    public AppCompatAutoCompleteTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
    }

    public AppCompatAutoCompleteTextView(Context context, AttributeSet attributeSet, int i2) {
        super(z.a(context), attributeSet, i2);
        y.a((View) this, getContext());
        ac a2 = ac.a(getContext(), attributeSet, f1467a, i2, 0);
        if (a2.g(0)) {
            setDropDownBackgroundDrawable(a2.a(0));
        }
        a2.f1669a.recycle();
        this.f1468b = new d(this);
        this.f1468b.a(attributeSet, i2);
        this.f1469c = new l(this);
        this.f1469c.a(attributeSet, i2);
        this.f1469c.a();
    }

    public void setDropDownBackgroundResource(int i2) {
        setDropDownBackgroundDrawable(a.b(getContext(), i2));
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        d dVar = this.f1468b;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f1468b;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f1468b;
        if (dVar != null) {
            dVar.a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f1468b;
        if (dVar != null) {
            return dVar.b();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f1468b;
        if (dVar != null) {
            dVar.a(mode);
        }
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f1468b;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f1468b;
        if (dVar != null) {
            dVar.d();
        }
        l lVar = this.f1469c;
        if (lVar != null) {
            lVar.a();
        }
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        l lVar = this.f1469c;
        if (lVar != null) {
            lVar.a(context, i2);
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return g.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(i.a((TextView) this, callback));
    }
}
