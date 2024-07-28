package com.google.android.gms.internal.firebase_ml;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.YuvImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ek {

    /* renamed from: a  reason: collision with root package name */
    private static final ek f9865a = new ek();

    private ek() {
    }

    public static ek a() {
        return f9865a;
    }

    public static byte[] a(ByteBuffer byteBuffer) {
        byteBuffer.rewind();
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr, 0, bArr.length);
        return bArr;
    }

    public static byte[] a(byte[] bArr, int i2, int i3) {
        ByteArrayOutputStream byteArrayOutputStream;
        YuvImage yuvImage = new YuvImage(bArr, 17, i2, i3, (int[]) null);
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            yuvImage.compressToJpeg(new Rect(0, 0, i2, i3), 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                return byteArray;
            } catch (IOException unused) {
                return byteArray;
            }
        } catch (IOException unused2) {
            return null;
        } catch (Throwable th) {
            az.a(th, th);
        }
        throw th;
    }

    public static byte[] a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
                return byteArray;
            } catch (IOException unused) {
                return byteArray;
            }
        } catch (IOException unused2) {
            return null;
        } catch (Throwable th) {
            az.a(th, th);
        }
        throw th;
    }

    public static byte[] a(byte[] bArr) {
        int length = bArr.length;
        int i2 = length / 6;
        byte[] bArr2 = new byte[length];
        int i3 = i2 << 2;
        System.arraycopy(bArr, 0, bArr2, 0, i3);
        for (int i4 = 0; i4 < (i2 << 1); i4++) {
            bArr2[i3 + i4] = bArr[((i4 % 2) * i2) + i3 + (i4 / 2)];
        }
        return bArr2;
    }
}
