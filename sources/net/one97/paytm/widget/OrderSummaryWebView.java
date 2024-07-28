package net.one97.paytm.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;
import com.paytm.utility.q;

public class OrderSummaryWebView extends WebView {
    public OrderSummaryWebView(Context context) {
        super(context);
    }

    public OrderSummaryWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        try {
            requestDisallowInterceptTouchEvent(true);
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        return super.onTouchEvent(motionEvent);
    }
}
