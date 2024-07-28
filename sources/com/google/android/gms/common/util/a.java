package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.common.c.c;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile int f8959a = -1;

    public static byte[] a(Context context, String str) throws PackageManager.NameNotFoundException {
        MessageDigest a2;
        PackageInfo b2 = c.a(context).b(str, 64);
        if (b2.signatures == null || b2.signatures.length != 1 || (a2 = a("SHA1")) == null) {
            return null;
        }
        return a2.digest(b2.signatures[0].toByteArray());
    }

    public static MessageDigest a(String str) {
        int i2 = 0;
        while (i2 < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    return instance;
                }
                i2++;
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }
}
