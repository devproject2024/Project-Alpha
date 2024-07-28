package com.google.android.gms.internal.p000authapi;

import android.util.Base64;
import java.util.Random;

/* renamed from: com.google.android.gms.internal.auth-api.a  reason: invalid package */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Random f9065a = new Random();

    public static String a() {
        byte[] bArr = new byte[16];
        f9065a.nextBytes(bArr);
        return Base64.encodeToString(bArr, 11);
    }
}
