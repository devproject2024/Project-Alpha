package net.one97.paytm.o2o.movies.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
import net.one97.paytm.o2o.movies.d.l;

public class ObservableHorizontalScrollView extends HorizontalScrollView {

    /* renamed from: a  reason: collision with root package name */
    private final String f76162a = "ObservableHorizontalScrollView";

    /* renamed from: b  reason: collision with root package name */
    private l f76163b = null;

    /* renamed from: c  reason: collision with root package name */
    private boolean f76164c = false;

    public ObservableHorizontalScrollView(Context context) {
        super(context);
    }

    public ObservableHorizontalScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public ObservableHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setScrollViewListener(l lVar) {
        this.f76163b = lVar;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        l lVar = this.f76163b;
        if (lVar != null) {
            lVar.onScrollChanged(this, i2, i3, i4, i5, this.f76164c);
        }
    }

    public void scrollTo(int i2, int i3) {
        this.f76164c = false;
        super.scrollTo(i2, i3);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f76164c = true;
        } else if (action == 2) {
            this.f76164c = true;
        }
        return super.onTouchEvent(motionEvent);
    }
}
