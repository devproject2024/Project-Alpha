package com.google.android.play.core.b;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

final class bc implements ab {

    /* renamed from: a  reason: collision with root package name */
    private final FileChannel f37282a;

    /* renamed from: b  reason: collision with root package name */
    private final long f37283b;

    /* renamed from: c  reason: collision with root package name */
    private final long f37284c;

    public bc(FileChannel fileChannel, long j, long j2) {
        this.f37282a = fileChannel;
        this.f37283b = j;
        this.f37284c = j2;
    }

    public final long a() {
        return this.f37284c;
    }

    public final void a(MessageDigest[] messageDigestArr, long j, int i2) throws IOException {
        MappedByteBuffer map = this.f37282a.map(FileChannel.MapMode.READ_ONLY, this.f37283b + j, (long) i2);
        map.load();
        for (MessageDigest update : messageDigestArr) {
            map.position(0);
            update.update(map);
        }
    }
}
