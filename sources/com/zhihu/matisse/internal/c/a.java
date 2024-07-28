package com.zhihu.matisse.internal.c;

import android.media.ExifInterface;
import java.io.IOException;

final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f45736a = a.class.getSimpleName();

    private a() {
    }

    public static ExifInterface a(String str) throws IOException {
        if (str != null) {
            return new ExifInterface(str);
        }
        throw new NullPointerException("filename should not be null");
    }
}
