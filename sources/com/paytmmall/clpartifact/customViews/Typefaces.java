package com.paytmmall.clpartifact.customViews;

import android.content.Context;
import android.graphics.Typeface;
import java.util.Hashtable;

public class Typefaces {
    private static final Hashtable<String, Typeface> cache = new Hashtable<>();

    public static Typeface get(Context context, String str) {
        Typeface typeface;
        synchronized (cache) {
            if (!cache.containsKey(str)) {
                try {
                    cache.put(str, Typeface.createFromAsset(context.getAssets(), str));
                } catch (Exception unused) {
                    return null;
                }
            }
            typeface = cache.get(str);
        }
        return typeface;
    }
}
