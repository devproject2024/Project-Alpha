package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.f.v;
import com.google.android.exoplayer2.f.x;
import java.io.FileNotFoundException;
import java.io.IOException;

public final class s implements w {

    /* renamed from: a  reason: collision with root package name */
    private final int f32454a;

    public s() {
        this((byte) 0);
    }

    private s(byte b2) {
        this.f32454a = -1;
    }

    public final long a(IOException iOException) {
        if (!(iOException instanceof v.e)) {
            return -9223372036854775807L;
        }
        int i2 = ((v.e) iOException).responseCode;
        if (i2 == 404 || i2 == 410) {
            return 60000;
        }
        return -9223372036854775807L;
    }

    public final long a(IOException iOException, int i2) {
        if ((iOException instanceof com.google.android.exoplayer2.v) || (iOException instanceof FileNotFoundException) || (iOException instanceof x.g)) {
            return -9223372036854775807L;
        }
        return (long) Math.min((i2 - 1) * 1000, 5000);
    }

    public final int a(int i2) {
        int i3 = this.f32454a;
        if (i3 == -1) {
            return i2 == 7 ? 6 : 3;
        }
        return i3;
    }
}
