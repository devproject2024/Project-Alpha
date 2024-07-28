package net.one97.paytm.common.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import net.one97.paytm.common.widgets.a.c;

public class EndlessScrollView extends ScrollView {

    /* renamed from: a  reason: collision with root package name */
    private c f49834a = null;

    public EndlessScrollView(Context context) {
        super(context);
    }

    public EndlessScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public EndlessScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setScrollViewListener(c cVar) {
        this.f49834a = cVar;
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        c cVar = this.f49834a;
        if (cVar != null) {
            cVar.a(this);
        }
    }
}
