package com.paytmmall.artifact.widget;

import android.content.Context;
import android.graphics.Typeface;
import java.util.Hashtable;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Hashtable<String, Typeface> f16032a = new Hashtable<>();

    public static Typeface a(Context context, String str) {
        Typeface typeface;
        synchronized (f16032a) {
            if (!f16032a.containsKey(str)) {
                try {
                    f16032a.put(str, Typeface.createFromAsset(context.getAssets(), str));
                } catch (Exception unused) {
                    return null;
                }
            }
            typeface = f16032a.get(str);
        }
        return typeface;
    }
}
