package com.travel.flight.views;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import com.paytm.utility.RoboTextView;
import java.util.HashSet;
import java.util.Set;

public class EllipsisTextView extends RoboTextView {

    /* renamed from: a  reason: collision with root package name */
    private boolean f25604a = false;

    /* renamed from: b  reason: collision with root package name */
    private final Set<a> f25605b = new HashSet();

    public interface a {
        void ellipsisStateChanged(boolean z);
    }

    public EllipsisTextView(Context context) {
        super(context);
    }

    public EllipsisTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EllipsisTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setEllipsesListener(a aVar) {
        this.f25605b.clear();
        if (aVar != null) {
            this.f25605b.add(aVar);
        }
    }

    public void layout(int i2, int i3, int i4, int i5) {
        int lineCount;
        super.layout(i2, i3, i4, i5);
        this.f25604a = false;
        Layout layout = getLayout();
        if (layout != null && (lineCount = layout.getLineCount()) > 0 && layout.getEllipsisCount(lineCount - 1) > 0) {
            this.f25604a = true;
        }
        for (a ellipsisStateChanged : this.f25605b) {
            ellipsisStateChanged.ellipsisStateChanged(this.f25604a);
        }
    }
}
