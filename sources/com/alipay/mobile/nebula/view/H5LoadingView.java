package com.alipay.mobile.nebula.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alipay.mobile.h5container.api.H5ViewCache;
import com.alipay.mobile.nebula.R;

public class H5LoadingView extends RelativeLayout {
    private TextView textView;

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public H5LoadingView(Context context) {
        this(context, (AttributeSet) null);
    }

    public H5LoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public H5LoadingView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init(context);
    }

    private void init(Context context) {
        View cachedViewById = H5ViewCache.getCachedViewById(R.layout.h5_loading_view);
        if (cachedViewById != null) {
            addView(cachedViewById, new RelativeLayout.LayoutParams(-1, -1));
        } else {
            LayoutInflater.from(context).inflate(R.layout.h5_loading_view, this);
        }
        this.textView = (TextView) findViewById(R.id.h5_loading_message);
    }

    public void setText(String str) {
        this.textView.setText(str);
    }
}
