package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import androidx.appcompat.R;
import androidx.appcompat.a.a.a;
import androidx.core.h.t;

public class AppCompatMultiAutoCompleteTextView extends MultiAutoCompleteTextView implements t {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f1479a = {16843126};

    /* renamed from: b  reason: collision with root package name */
    private final d f1480b;

    /* renamed from: c  reason: collision with root package name */
    private final l f1481c;

    public AppCompatMultiAutoCompleteTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
    }

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet, int i2) {
        super(z.a(context), attributeSet, i2);
        y.a((View) this, getContext());
        ac a2 = ac.a(getContext(), attributeSet, f1479a, i2, 0);
        if (a2.g(0)) {
            setDropDownBackgroundDrawable(a2.a(0));
        }
        a2.f1669a.recycle();
        this.f1480b = new d(this);
        this.f1480b.a(attributeSet, i2);
        this.f1481c = new l(this);
        this.f1481c.a(attributeSet, i2);
        this.f1481c.a();
    }

    public void setDropDownBackgroundResource(int i2) {
        setDropDownBackgroundDrawable(a.b(getContext(), i2));
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        d dVar = this.f1480b;
        if (dVar != null) {
            dVar.a(i2);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f1480b;
        if (dVar != null) {
            dVar.a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f1480b;
        if (dVar != null) {
            dVar.a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f1480b;
        if (dVar != null) {
            return dVar.b();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f1480b;
        if (dVar != null) {
            dVar.a(mode);
        }
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f1480b;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f1480b;
        if (dVar != null) {
            dVar.d();
        }
        l lVar = this.f1481c;
        if (lVar != null) {
            lVar.a();
        }
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        l lVar = this.f1481c;
        if (lVar != null) {
            lVar.a(context, i2);
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return g.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }
}
