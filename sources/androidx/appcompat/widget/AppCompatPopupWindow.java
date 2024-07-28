package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.core.widget.g;

class AppCompatPopupWindow extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f1482a = (Build.VERSION.SDK_INT < 21);

    /* renamed from: b  reason: collision with root package name */
    private boolean f1483b;

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet, i2, 0);
    }

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(context, attributeSet, i2, i3);
    }

    private void a(Context context, AttributeSet attributeSet, int i2, int i3) {
        ac a2 = ac.a(context, attributeSet, R.styleable.PopupWindow, i2, i3);
        if (a2.g(R.styleable.PopupWindow_overlapAnchor)) {
            a(a2.a(R.styleable.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(a2.a(R.styleable.PopupWindow_android_popupBackground));
        a2.f1669a.recycle();
    }

    public void showAsDropDown(View view, int i2, int i3) {
        if (f1482a && this.f1483b) {
            i3 -= view.getHeight();
        }
        super.showAsDropDown(view, i2, i3);
    }

    public void showAsDropDown(View view, int i2, int i3, int i4) {
        if (f1482a && this.f1483b) {
            i3 -= view.getHeight();
        }
        super.showAsDropDown(view, i2, i3, i4);
    }

    public void update(View view, int i2, int i3, int i4, int i5) {
        if (f1482a && this.f1483b) {
            i3 -= view.getHeight();
        }
        super.update(view, i2, i3, i4, i5);
    }

    private void a(boolean z) {
        if (f1482a) {
            this.f1483b = z;
        } else {
            g.a((PopupWindow) this, z);
        }
    }
}
