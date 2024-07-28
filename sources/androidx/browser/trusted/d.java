package androidx.browser.trusted;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f1938a;

    /* renamed from: b  reason: collision with root package name */
    String f1939b;

    /* renamed from: c  reason: collision with root package name */
    List<byte[]> f1940c;

    public d(byte[] bArr) {
        this.f1938a = bArr;
    }

    static d a(String str, List<byte[]> list) throws IOException {
        return new d(b(str, list), str, list);
    }

    private d(byte[] bArr, String str, List<byte[]> list) {
        this.f1938a = bArr;
        this.f1939b = str;
        this.f1940c = new ArrayList(list.size());
        for (byte[] next : list) {
            this.f1940c.add(Arrays.copyOf(next, next.length));
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f1938a, ((d) obj).f1938a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f1938a);
    }

    private static byte[] b(String str, List<byte[]> list) throws IOException {
        Collections.sort(list, $$Lambda$d$ujAZjZm6MzyqooKDYckrB96rdAE.INSTANCE);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeUTF(str);
        dataOutputStream.writeInt(list.size());
        for (byte[] next : list) {
            dataOutputStream.writeInt(next.length);
            dataOutputStream.write(next);
        }
        dataOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r5v0, types: [byte[]] */
    /* JADX WARNING: type inference failed for: r2v3, types: [byte] */
    /* JADX WARNING: type inference failed for: r3v1, types: [byte] */
    /* JADX WARNING: type inference failed for: r4v4, types: [byte] */
    /* JADX WARNING: type inference failed for: r5v3, types: [byte] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r4v4, types: [byte] */
    /* JADX WARNING: Incorrect type for immutable var: ssa=byte, code=int, for r5v3, types: [byte] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(byte[] r4, byte[] r5) {
        /*
            r0 = 0
            if (r4 != r5) goto L_0x0004
            return r0
        L_0x0004:
            if (r4 != 0) goto L_0x0008
            r4 = -1
            return r4
        L_0x0008:
            if (r5 != 0) goto L_0x000c
            r4 = 1
            return r4
        L_0x000c:
            r1 = 0
        L_0x000d:
            int r2 = r4.length
            int r3 = r5.length
            int r2 = java.lang.Math.min(r2, r3)
            if (r1 >= r2) goto L_0x0024
            byte r2 = r4[r1]
            byte r3 = r5[r1]
            if (r2 == r3) goto L_0x0021
            byte r4 = r4[r1]
            byte r5 = r5[r1]
        L_0x001f:
            int r4 = r4 - r5
            return r4
        L_0x0021:
            int r1 = r1 + 1
            goto L_0x000d
        L_0x0024:
            int r1 = r4.length
            int r2 = r5.length
            if (r1 == r2) goto L_0x002b
            int r4 = r4.length
            int r5 = r5.length
            goto L_0x001f
        L_0x002b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.browser.trusted.d.a(byte[], byte[]):int");
    }

    /* access modifiers changed from: package-private */
    public final void a() throws IOException {
        if (this.f1939b == null) {
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(this.f1938a));
            this.f1939b = dataInputStream.readUTF();
            int readInt = dataInputStream.readInt();
            this.f1940c = new ArrayList(readInt);
            int i2 = 0;
            while (i2 < readInt) {
                int readInt2 = dataInputStream.readInt();
                byte[] bArr = new byte[readInt2];
                if (dataInputStream.read(bArr) == readInt2) {
                    this.f1940c.add(bArr);
                    i2++;
                } else {
                    throw new IllegalStateException("Could not read fingerprint");
                }
            }
        }
    }
}
