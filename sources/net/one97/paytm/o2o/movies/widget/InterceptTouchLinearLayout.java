package net.one97.paytm.o2o.movies.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import net.one97.paytm.o2o.movies.d.k;

public class InterceptTouchLinearLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private k f76158a;

    public InterceptTouchLinearLayout(Context context) {
        super(context);
    }

    public InterceptTouchLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InterceptTouchLinearLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setInterceptTouchListener(k kVar) {
        this.f76158a = kVar;
    }
}
