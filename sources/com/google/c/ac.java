package com.google.c;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.RandomAccess;

public final class ac {

    /* renamed from: a  reason: collision with root package name */
    static final Charset f37697a = Charset.forName(AppConstants.UTF_8);

    /* renamed from: b  reason: collision with root package name */
    static final Charset f37698b = Charset.forName("ISO-8859-1");

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f37699c;

    /* renamed from: d  reason: collision with root package name */
    public static final ByteBuffer f37700d;

    /* renamed from: e  reason: collision with root package name */
    public static final k f37701e;

    public interface a extends i {
    }

    public interface b extends i {
    }

    public interface c {
        int a();
    }

    public interface d<T extends c> {
        T a();
    }

    public interface e {
        boolean a();
    }

    public interface f extends i {
    }

    public interface g extends i {
    }

    public interface h extends i {
    }

    public interface i<E> extends List<E>, RandomAccess {
        i<E> a(int i2);

        boolean a();

        void b();
    }

    public static int a(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int a(boolean z) {
        return z ? 1231 : 1237;
    }

    static {
        byte[] bArr = new byte[0];
        f37699c = bArr;
        f37700d = ByteBuffer.wrap(bArr);
        byte[] bArr2 = f37699c;
        f37701e = k.a(bArr2, 0, bArr2.length, false);
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
        return by.a(bArr);
    }

    public static String b(byte[] bArr) {
        return new String(bArr, f37697a);
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
        return ((at) obj).m().a((at) obj2).b();
    }
}
