package com.airbnb.lottie.b;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.airbnb.lottie.f.d;
import com.airbnb.lottie.f.h;
import com.airbnb.lottie.g;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class b {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f5796c = new Object();

    /* renamed from: a  reason: collision with root package name */
    public com.airbnb.lottie.b f5797a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, g> f5798b;

    /* renamed from: d  reason: collision with root package name */
    private final Context f5799d;

    /* renamed from: e  reason: collision with root package name */
    private String f5800e;

    public b(Drawable.Callback callback, String str, com.airbnb.lottie.b bVar, Map<String, g> map) {
        this.f5800e = str;
        if (!TextUtils.isEmpty(str)) {
            String str2 = this.f5800e;
            if (str2.charAt(str2.length() - 1) != '/') {
                this.f5800e += '/';
            }
        }
        if (!(callback instanceof View)) {
            d.a("LottieDrawable must be inside of a view for images to work.");
            this.f5798b = new HashMap();
            this.f5799d = null;
            return;
        }
        this.f5799d = ((View) callback).getContext();
        this.f5798b = map;
        this.f5797a = bVar;
    }

    public final Bitmap a(String str) {
        g gVar = this.f5798b.get(str);
        if (gVar == null) {
            return null;
        }
        Bitmap bitmap = gVar.f6132e;
        if (bitmap != null) {
            return bitmap;
        }
        com.airbnb.lottie.b bVar = this.f5797a;
        if (bVar != null) {
            Bitmap a2 = bVar.a();
            if (a2 != null) {
                a(str, a2);
            }
            return a2;
        }
        String str2 = gVar.f6131d;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (!str2.startsWith("data:") || str2.indexOf("base64,") <= 0) {
            try {
                if (!TextUtils.isEmpty(this.f5800e)) {
                    AssetManager assets = this.f5799d.getAssets();
                    return a(str, h.a(BitmapFactory.decodeStream(assets.open(this.f5800e + str2), (Rect) null, options), gVar.f6128a, gVar.f6129b));
                }
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            } catch (IOException unused) {
                d.b("Unable to open asset.");
                return null;
            }
        } else {
            try {
                byte[] decode = Base64.decode(str2.substring(str2.indexOf(44) + 1), 0);
                return a(str, BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
            } catch (IllegalArgumentException unused2) {
                d.b("data URL did not have correct base64 format.");
                return null;
            }
        }
    }

    public final boolean a(Context context) {
        return (context == null && this.f5799d == null) || this.f5799d.equals(context);
    }

    public final Bitmap a(String str, Bitmap bitmap) {
        synchronized (f5796c) {
            this.f5798b.get(str).f6132e = bitmap;
        }
        return bitmap;
    }
}
