package net.one97.paytm.common.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ExpandableHeightListView extends ListView {

    /* renamed from: a  reason: collision with root package name */
    private boolean f49835a = false;

    /* renamed from: b  reason: collision with root package name */
    private AdapterView.OnItemClickListener f49836b;

    public ExpandableHeightListView(Context context) {
        super(context);
    }

    public ExpandableHeightListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ExpandableHeightListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setExpanded(boolean z) {
        this.f49835a = z;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        super.setOnItemClickListener(onItemClickListener);
        this.f49836b = onItemClickListener;
    }

    public AdapterView.OnItemClickListener getCustomOnItemClickListener() {
        return this.f49836b;
    }

    public void onMeasure(int i2, int i3) {
        if (this.f49835a) {
            super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
            getLayoutParams().height = getMeasuredHeight();
            return;
        }
        super.onMeasure(i2, i3);
    }
}
