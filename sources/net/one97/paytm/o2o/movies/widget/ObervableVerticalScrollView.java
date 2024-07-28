package net.one97.paytm.o2o.movies.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import net.one97.paytm.o2o.movies.d.k;
import net.one97.paytm.o2o.movies.d.m;

public class ObervableVerticalScrollView extends ScrollView {

    /* renamed from: a  reason: collision with root package name */
    private final String f76159a = "ObervableVerticalScrollView";

    /* renamed from: b  reason: collision with root package name */
    private m f76160b;

    /* renamed from: c  reason: collision with root package name */
    private k f76161c;

    public ObervableVerticalScrollView(Context context) {
        super(context);
    }

    public ObervableVerticalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ObervableVerticalScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setVerticalScrollListener(m mVar) {
        this.f76160b = mVar;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        this.f76160b.a(i3);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        k kVar = this.f76161c;
        if (kVar != null) {
            kVar.a(motionEvent);
        }
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    public void setInterceptTouchListener(k kVar) {
        this.f76161c = kVar;
    }
}
