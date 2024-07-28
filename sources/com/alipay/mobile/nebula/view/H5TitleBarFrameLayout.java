package com.alipay.mobile.nebula.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.alipay.mobile.nebula.R;

public class H5TitleBarFrameLayout extends FrameLayout {
    private ColorDrawable contentBgView = null;

    public H5TitleBarFrameLayout(Context context) {
        super(context);
        initBgView();
    }

    public H5TitleBarFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initBgView();
    }

    public H5TitleBarFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        initBgView();
    }

    private void initBgView() {
        this.contentBgView = new ColorDrawable(getResources().getColor(R.color.h5_nav_bar));
        setBackgroundDrawable(this.contentBgView);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
    }

    public ColorDrawable getContentBgView() {
        return this.contentBgView;
    }
}
