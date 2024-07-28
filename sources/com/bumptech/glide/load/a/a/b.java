package com.bumptech.glide.load.a.a;

import android.net.Uri;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;

public final class b {
    public static boolean a(int i2, int i3) {
        return i2 != Integer.MIN_VALUE && i3 != Integer.MIN_VALUE && i2 <= 512 && i3 <= 384;
    }

    public static boolean a(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public static boolean b(Uri uri) {
        return uri.getPathSegments().contains(H5ResourceHandlerUtil.VIDEO);
    }
}
