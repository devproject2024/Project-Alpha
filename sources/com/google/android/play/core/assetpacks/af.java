package com.google.android.play.core.assetpacks;

import java.io.IOException;
import java.io.InputStream;

final class af extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f36958a;

    /* renamed from: b  reason: collision with root package name */
    private long f36959b;

    af(InputStream inputStream, long j) {
        this.f36958a = inputStream;
        this.f36959b = j;
    }

    public final int read() throws IOException {
        long j = this.f36959b;
        if (j <= 0) {
            return -1;
        }
        this.f36959b = j - 1;
        return this.f36958a.read();
    }

    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        long j = this.f36959b;
        if (j <= 0) {
            return -1;
        }
        int read = this.f36958a.read(bArr, i2, (int) Math.min((long) i3, j));
        if (read != -1) {
            this.f36959b -= (long) read;
        }
        return read;
    }
}
