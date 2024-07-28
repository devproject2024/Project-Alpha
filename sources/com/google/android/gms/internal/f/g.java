package com.google.android.gms.internal.f;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Queue;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static final OutputStream f9469a = new f();

    private static byte[] a(Queue<byte[]> queue, int i2) {
        byte[] bArr = new byte[i2];
        int i3 = i2;
        while (i3 > 0) {
            byte[] remove = queue.remove();
            int min = Math.min(i3, remove.length);
            System.arraycopy(remove, 0, bArr, i2 - i3, min);
            i3 -= min;
        }
        return bArr;
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        int i2;
        d.a(inputStream);
        ArrayDeque arrayDeque = new ArrayDeque(20);
        int i3 = FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE;
        for (int i4 = 0; i4 < 2147483639; i4 = i2) {
            byte[] bArr = new byte[Math.min(i3, 2147483639 - i4)];
            arrayDeque.add(bArr);
            i2 = i4;
            int i5 = 0;
            while (i5 < bArr.length) {
                int read = inputStream.read(bArr, i5, bArr.length - i5);
                if (read == -1) {
                    return a(arrayDeque, i2);
                }
                i5 += read;
                i2 += read;
            }
            i3 = k.a(i3);
        }
        if (inputStream.read() == -1) {
            return a(arrayDeque, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    public static InputStream b(InputStream inputStream) {
        return new i(inputStream);
    }
}
