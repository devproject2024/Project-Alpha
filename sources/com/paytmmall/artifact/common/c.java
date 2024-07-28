package com.paytmmall.artifact.common;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.paytmmall.artifact.d.l;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    Context f15663a;

    public c(Context context) {
        this.f15663a = context;
    }

    @JavascriptInterface
    public final String getSsoToken() {
        return l.a(this.f15663a);
    }
}
