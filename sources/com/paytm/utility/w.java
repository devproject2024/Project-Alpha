package com.paytm.utility;

import android.content.Context;
import android.graphics.Typeface;
import java.util.Hashtable;

public final class w {

    /* renamed from: a  reason: collision with root package name */
    private static final Hashtable<String, Typeface> f43865a = new Hashtable<>();

    public static Typeface a(Context context, String str) {
        Typeface typeface;
        synchronized (f43865a) {
            if (!f43865a.containsKey(str)) {
                try {
                    f43865a.put(str, Typeface.createFromAsset(context.getAssets(), str));
                } catch (Exception unused) {
                    return null;
                }
            }
            typeface = f43865a.get(str);
        }
        return typeface;
    }
}
