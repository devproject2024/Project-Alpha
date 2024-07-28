package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import android.widget.TextView;
import androidx.appcompat.a.a.a;
import androidx.core.widget.i;

public class AppCompatCheckedTextView extends CheckedTextView {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f1475a = {16843016};

    /* renamed from: b  reason: collision with root package name */
    private final l f1476b;

    public AppCompatCheckedTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet, int i2) {
        super(z.a(context), attributeSet, i2);
        y.a((View) this, getContext());
        this.f1476b = new l(this);
        this.f1476b.a(attributeSet, i2);
        this.f1476b.a();
        ac a2 = ac.a(getContext(), attributeSet, f1475a, i2, 0);
        setCheckMarkDrawable(a2.a(0));
        a2.f1669a.recycle();
    }

    public void setCheckMarkDrawable(int i2) {
        setCheckMarkDrawable(a.b(getContext(), i2));
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        l lVar = this.f1476b;
        if (lVar != null) {
            lVar.a(context, i2);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        l lVar = this.f1476b;
        if (lVar != null) {
            lVar.a();
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return g.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(i.a((TextView) this, callback));
    }
}
