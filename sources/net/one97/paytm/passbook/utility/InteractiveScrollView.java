package net.one97.paytm.passbook.utility;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.widget.NestedScrollView;

public class InteractiveScrollView extends NestedScrollView {

    /* renamed from: a  reason: collision with root package name */
    a f59223a;

    public interface a {
        void onBottomReached();
    }

    public InteractiveScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public InteractiveScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InteractiveScrollView(Context context) {
        super(context);
    }

    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        a aVar;
        if (getChildAt(getChildCount() - 1).getBottom() - (getHeight() + getScrollY()) == 0 && (aVar = this.f59223a) != null) {
            aVar.onBottomReached();
        }
        super.onScrollChanged(i2, i3, i4, i5);
    }

    public a getOnBottomReachedListener() {
        return this.f59223a;
    }

    public void setOnBottomReachedListener(a aVar) {
        this.f59223a = aVar;
    }
}
