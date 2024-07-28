package com.google.firebase.crashlytics.a.h;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;

final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final a f38599b = new a(new byte[0]);

    /* renamed from: a  reason: collision with root package name */
    final byte[] f38600a;

    /* renamed from: c  reason: collision with root package name */
    private volatile int f38601c = 0;

    private a(byte[] bArr) {
        this.f38600a = bArr;
    }

    public static a a(byte[] bArr) {
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return new a(bArr2);
    }

    public static a a(String str) {
        try {
            return new a(str.getBytes(AppConstants.UTF_8));
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("UTF-8 not supported.", e2);
        }
    }

    public final void a(byte[] bArr, int i2, int i3, int i4) {
        System.arraycopy(this.f38600a, i2, bArr, i3, i4);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        byte[] bArr = this.f38600a;
        int length = bArr.length;
        byte[] bArr2 = ((a) obj).f38600a;
        if (length != bArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i2 = this.f38601c;
        if (i2 == 0) {
            int i3 = r1;
            for (byte b2 : this.f38600a) {
                i3 = (i3 * 31) + b2;
            }
            i2 = i3 == 0 ? 1 : i3;
            this.f38601c = i2;
        }
        return i2;
    }
}
