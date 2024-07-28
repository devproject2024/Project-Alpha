package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.r;
import java.nio.ByteBuffer;
import java.util.UUID;

public final class h {
    public static byte[] a(UUID uuid, byte[] bArr) {
        return a(uuid, (UUID[]) null, bArr);
    }

    public static byte[] a(UUID uuid, UUID[] uuidArr, byte[] bArr) {
        int length = (bArr != null ? bArr.length : 0) + 32;
        if (uuidArr != null) {
            length += (uuidArr.length * 16) + 4;
        }
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length);
        allocate.putInt(a.ah);
        allocate.putInt(uuidArr != null ? 16777216 : 0);
        allocate.putLong(uuid.getMostSignificantBits());
        allocate.putLong(uuid.getLeastSignificantBits());
        if (uuidArr != null) {
            allocate.putInt(uuidArr.length);
            for (UUID uuid2 : uuidArr) {
                allocate.putLong(uuid2.getMostSignificantBits());
                allocate.putLong(uuid2.getLeastSignificantBits());
            }
        }
        if (!(bArr == null || bArr.length == 0)) {
            allocate.putInt(bArr.length);
            allocate.put(bArr);
        }
        return allocate.array();
    }

    public static UUID a(byte[] bArr) {
        a b2 = b(bArr);
        if (b2 == null) {
            return null;
        }
        return b2.f32253a;
    }

    private static a b(byte[] bArr) {
        r rVar = new r(bArr);
        if (rVar.f32568c < 32) {
            return null;
        }
        rVar.c(0);
        if (rVar.i() != rVar.b() + 4 || rVar.i() != a.ah) {
            return null;
        }
        int a2 = a.a(rVar.i());
        if (a2 > 1) {
            "Unsupported pssh version: ".concat(String.valueOf(a2));
            l.c();
            return null;
        }
        UUID uuid = new UUID(rVar.k(), rVar.k());
        if (a2 == 1) {
            rVar.d(rVar.n() * 16);
        }
        int n = rVar.n();
        if (n != rVar.b()) {
            return null;
        }
        byte[] bArr2 = new byte[n];
        rVar.a(bArr2, 0, n);
        return new a(uuid, a2, bArr2);
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final UUID f32253a;

        /* renamed from: b  reason: collision with root package name */
        private final int f32254b;

        /* renamed from: c  reason: collision with root package name */
        private final byte[] f32255c;

        public a(UUID uuid, int i2, byte[] bArr) {
            this.f32253a = uuid;
            this.f32254b = i2;
            this.f32255c = bArr;
        }
    }
}
