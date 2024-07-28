package com.travel.flight.tooltipwidget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

public class ToolTipRelativeLayout extends RelativeLayout {
    public ToolTipRelativeLayout(Context context) {
        super(context);
    }

    public ToolTipRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ToolTipRelativeLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public final ToolTipView a(a aVar, View view) {
        ToolTipView toolTipView = new ToolTipView(getContext());
        toolTipView.setToolTip(aVar, view);
        addView(toolTipView);
        return toolTipView;
    }
}
