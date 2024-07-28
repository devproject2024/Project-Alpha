package com.zhihu.matisse.internal.ui.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class RelativeLayoutEx extends RelativeLayout {
    public RelativeLayoutEx(Context context) {
        super(context);
    }

    public RelativeLayoutEx(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RelativeLayoutEx(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        rect.top = 0;
        return super.fitSystemWindows(rect);
    }
}
