package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ToggleButton;

public class AppCompatToggleButton extends ToggleButton {

    /* renamed from: a  reason: collision with root package name */
    private final l f1517a;

    public AppCompatToggleButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatToggleButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842827);
    }

    public AppCompatToggleButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        y.a((View) this, getContext());
        this.f1517a = new l(this);
        this.f1517a.a(attributeSet, i2);
    }
}
