package com.google.android.gms.internal.icing;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class bx {

    /* renamed from: a  reason: collision with root package name */
    static final Charset f10119a = Charset.forName(AppConstants.UTF_8);

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f10120b;

    /* renamed from: c  reason: collision with root package name */
    private static final Charset f10121c = Charset.forName("ISO-8859-1");

    /* renamed from: d  reason: collision with root package name */
    private static final ByteBuffer f10122d;

    /* renamed from: e  reason: collision with root package name */
    private static final be f10123e;

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
        return er.a(bArr);
    }

    public static String b(byte[] bArr) {
        return new String(bArr, f10119a);
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
        return ((dd) obj).e().a((dd) obj2).b();
    }

    static {
        byte[] bArr = new byte[0];
        f10120b = bArr;
        f10122d = ByteBuffer.wrap(bArr);
        byte[] bArr2 = f10120b;
        f10123e = be.a(bArr2, bArr2.length);
    }
}
