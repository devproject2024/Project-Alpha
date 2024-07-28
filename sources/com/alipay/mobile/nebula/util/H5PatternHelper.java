package com.alipay.mobile.nebula.util;

import android.util.LruCache;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class H5PatternHelper {
    private static final boolean DEBUG = H5Utils.isDebuggable(H5Utils.getContext());
    private static final String TAG = "H5PatternHelper";
    private static LruCache<String, Pattern> sPatternCache = new LruCache<>(20);

    public static boolean matchRegex(String str, String str2) {
        Pattern compile;
        if (str == null || str2 == null || (compile = compile(str)) == null) {
            return false;
        }
        return compile.matcher(str2).matches();
    }

    public static Pattern compile(String str) {
        if (str == null) {
            return null;
        }
        Pattern pattern = sPatternCache.get(str);
        if (pattern != null) {
            if (DEBUG) {
                H5Log.d(TAG, "pattern cache hit: ".concat(String.valueOf(str)));
            }
            return pattern;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Pattern compile = Pattern.compile(str);
            sPatternCache.put(str, compile);
            if (DEBUG) {
                H5Log.d(TAG, "pattern cache miss, use time: " + (System.currentTimeMillis() - currentTimeMillis) + " " + str);
            }
            return compile;
        } catch (PatternSyntaxException e2) {
            H5Log.e(TAG, "pattern " + str + " compile error!", e2);
            return null;
        }
    }
}
