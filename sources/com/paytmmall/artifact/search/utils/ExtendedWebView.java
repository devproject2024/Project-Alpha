package com.paytmmall.artifact.search.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

public class ExtendedWebView extends WebView {
    public ExtendedWebView(Context context) {
        super(context);
    }

    public ExtendedWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final boolean a(int i2) {
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        int computeVerticalScrollRange = computeVerticalScrollRange() - computeVerticalScrollExtent();
        if (computeVerticalScrollRange == 0) {
            return false;
        }
        return i2 < 0 ? computeVerticalScrollOffset > 0 : computeVerticalScrollOffset < computeVerticalScrollRange - 1;
    }
}
