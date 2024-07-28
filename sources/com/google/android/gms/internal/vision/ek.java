package com.google.android.gms.internal.vision;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class ek {

    /* renamed from: a  reason: collision with root package name */
    static final Charset f11111a = Charset.forName(AppConstants.UTF_8);

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f11112b;

    /* renamed from: c  reason: collision with root package name */
    private static final Charset f11113c = Charset.forName("ISO-8859-1");

    /* renamed from: d  reason: collision with root package name */
    private static final ByteBuffer f11114d;

    /* renamed from: e  reason: collision with root package name */
    private static final dl f11115e;

    public static int a(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int a(boolean z) {
        return z ? 1231 : 1237;
    }

    static boolean a() {
        return false;
    }

    static <T> T a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean a(byte[] bArr) {
        return hj.a(bArr);
    }

    public static String b(byte[] bArr) {
        return new String(bArr, f11111a);
    }

    public static int c(byte[] bArr) {
        int length = bArr.length;
        int a2 = a(length, bArr, 0, length);
        if (a2 == 0) {
            return 1;
        }
        return a2;
    }

    static int a(int i2, byte[] bArr, int i3, int i4) {
        int i5 = i2;
        for (int i6 = i3; i6 < i3 + i4; i6++) {
            i5 = (i5 * 31) + bArr[i6];
        }
        return i5;
    }

    static Object a(Object obj, Object obj2) {
        return ((ft) obj).i().a((ft) obj2).c();
    }

    static {
        byte[] bArr = new byte[0];
        f11112b = bArr;
        f11114d = ByteBuffer.wrap(bArr);
        byte[] bArr2 = f11112b;
        f11115e = dl.a(bArr2, bArr2.length);
    }
}
