package com.airbnb.lottie.b;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.airbnb.lottie.c.i;
import com.airbnb.lottie.f.d;
import java.util.HashMap;
import java.util.Map;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final i<String> f5790a = new i<>();

    /* renamed from: b  reason: collision with root package name */
    public final Map<i<String>, Typeface> f5791b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, Typeface> f5792c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final AssetManager f5793d;

    /* renamed from: e  reason: collision with root package name */
    public com.airbnb.lottie.a f5794e;

    /* renamed from: f  reason: collision with root package name */
    public String f5795f = ".ttf";

    public a(Drawable.Callback callback, com.airbnb.lottie.a aVar) {
        this.f5794e = aVar;
        if (!(callback instanceof View)) {
            d.a("LottieDrawable must be inside of a view for images to work.");
            this.f5793d = null;
            return;
        }
        this.f5793d = ((View) callback).getContext().getAssets();
    }
}
