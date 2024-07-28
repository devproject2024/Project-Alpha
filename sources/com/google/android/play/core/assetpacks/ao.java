package com.google.android.play.core.assetpacks;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

final class ao extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    long f36986a;

    /* renamed from: b  reason: collision with root package name */
    boolean f36987b = false;

    /* renamed from: c  reason: collision with root package name */
    boolean f36988c = false;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f36989d = new byte[4096];

    ao(InputStream inputStream) {
        super(inputStream);
    }

    private final int a(byte[] bArr, int i2, int i3) throws IOException {
        return Math.max(0, super.read(bArr, i2, i3));
    }

    private final cs a(int i2, String str, long j, int i3, boolean z) {
        return cs.a(str, j, i3, z, Arrays.copyOf(this.f36989d, i2));
    }

    private final void a(long j) {
        int length = this.f36989d.length;
        if (j > ((long) length)) {
            do {
                length += length;
            } while (((long) length) < j);
            this.f36989d = Arrays.copyOf(this.f36989d, length);
        }
    }

    private final boolean a(int i2, int i3) throws IOException {
        return a(this.f36989d, i2, i3) == i3;
    }

    /* access modifiers changed from: package-private */
    public final cs a() throws IOException {
        byte[] bArr;
        if (this.f36986a > 0) {
            do {
                bArr = this.f36989d;
            } while (read(bArr, 0, bArr.length) != -1);
        }
        if (this.f36987b || this.f36988c) {
            return cs.a((String) null, -1, -1, false, (byte[]) null);
        }
        int a2 = a(this.f36989d, 0, 30);
        if (a2 != 30 && !a(a2, 30 - a2)) {
            this.f36987b = true;
            return a(a2, (String) null, -1, -1, true);
        } else if (by.a(this.f36989d, 0) != 67324752) {
            this.f36988c = true;
            return a(a2, (String) null, -1, -1, false);
        } else {
            long a3 = by.a(this.f36989d, 18);
            if (a3 != 4294967295L) {
                int b2 = by.b(this.f36989d, 8);
                int b3 = by.b(this.f36989d, 26);
                int i2 = b3 + 30;
                a((long) i2);
                int a4 = a(this.f36989d, 30, b3);
                int i3 = a4 + 30;
                if (a4 == b3 || a(i3, b3 - a4)) {
                    String str = new String(this.f36989d, 30, b3);
                    int b4 = by.b(this.f36989d, 28);
                    int i4 = i2 + b4;
                    a((long) i4);
                    int a5 = a(this.f36989d, i2, b4);
                    int i5 = i2 + a5;
                    if (a5 == b4 || a(i5, b4 - a5)) {
                        this.f36986a = by.a(this.f36989d, 18);
                        return a(i4, str, a3, b2, false);
                    }
                    this.f36987b = true;
                    return a(i5, str, a3, b2, true);
                }
                this.f36987b = true;
                return a(i3, (String) null, a3, b2, true);
            }
            throw new ax("Files bigger than 4GiB are not supported.");
        }
    }

    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        long j = this.f36986a;
        if (j <= 0 || this.f36987b) {
            return -1;
        }
        int a2 = a(bArr, i2, (int) Math.min(j, (long) i3));
        this.f36986a -= (long) a2;
        if (a2 != 0) {
            return a2;
        }
        this.f36987b = true;
        return 0;
    }
}
