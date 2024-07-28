package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Group extends ConstraintHelper {
    public Group(Context context) {
        super(context);
    }

    public Group(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Group(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public final void a(AttributeSet attributeSet) {
        super.a(attributeSet);
        this.n = false;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c();
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        c();
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        c();
    }

    public final void a() {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.an.g(0);
        layoutParams.an.h(0);
    }
}
