package com.google.android.play.core.b;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

final class a implements ab {

    /* renamed from: a  reason: collision with root package name */
    private final ByteBuffer f37269a;

    public a(ByteBuffer byteBuffer) {
        this.f37269a = byteBuffer.slice();
    }

    public final long a() {
        return (long) this.f37269a.capacity();
    }

    public final void a(MessageDigest[] messageDigestArr, long j, int i2) throws IOException {
        ByteBuffer slice;
        synchronized (this.f37269a) {
            int i3 = (int) j;
            this.f37269a.position(i3);
            this.f37269a.limit(i3 + i2);
            slice = this.f37269a.slice();
        }
        for (MessageDigest update : messageDigestArr) {
            slice.position(0);
            update.update(slice);
        }
    }
}
