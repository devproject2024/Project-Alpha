package com.bumptech.glide.load.d.a;

import com.bumptech.glide.load.b.a.b;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class y extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private volatile byte[] f7189a;

    /* renamed from: b  reason: collision with root package name */
    private int f7190b;

    /* renamed from: c  reason: collision with root package name */
    private int f7191c;

    /* renamed from: d  reason: collision with root package name */
    private int f7192d;

    /* renamed from: e  reason: collision with root package name */
    private int f7193e;

    /* renamed from: f  reason: collision with root package name */
    private final b f7194f;

    public final boolean markSupported() {
        return true;
    }

    public y(InputStream inputStream, b bVar) {
        this(inputStream, bVar, (byte) 0);
    }

    private y(InputStream inputStream, b bVar, byte b2) {
        super(inputStream);
        this.f7192d = -1;
        this.f7194f = bVar;
        this.f7189a = (byte[]) bVar.a(65536, byte[].class);
    }

    public final synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = this.in;
        if (this.f7189a == null || inputStream == null) {
            throw c();
        }
        return (this.f7190b - this.f7193e) + inputStream.available();
    }

    private static IOException c() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    public final synchronized void a() {
        this.f7191c = this.f7189a.length;
    }

    public final synchronized void b() {
        if (this.f7189a != null) {
            this.f7194f.a(this.f7189a);
            this.f7189a = null;
        }
    }

    public final void close() throws IOException {
        if (this.f7189a != null) {
            this.f7194f.a(this.f7189a);
            this.f7189a = null;
        }
        InputStream inputStream = this.in;
        this.in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    private int a(InputStream inputStream, byte[] bArr) throws IOException {
        int i2;
        int i3 = this.f7192d;
        if (i3 == -1 || this.f7193e - i3 >= (i2 = this.f7191c)) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                this.f7192d = -1;
                this.f7193e = 0;
                this.f7190b = read;
            }
            return read;
        }
        if (i3 == 0 && i2 > bArr.length && this.f7190b == bArr.length) {
            int length = bArr.length * 2;
            if (length > i2) {
                length = i2;
            }
            byte[] bArr2 = (byte[]) this.f7194f.a(length, byte[].class);
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.f7189a = bArr2;
            this.f7194f.a(bArr);
            bArr = bArr2;
        } else {
            int i4 = this.f7192d;
            if (i4 > 0) {
                System.arraycopy(bArr, i4, bArr, 0, bArr.length - i4);
            }
        }
        this.f7193e -= this.f7192d;
        this.f7192d = 0;
        this.f7190b = 0;
        int i5 = this.f7193e;
        int read2 = inputStream.read(bArr, i5, bArr.length - i5);
        int i6 = this.f7193e;
        if (read2 > 0) {
            i6 += read2;
        }
        this.f7190b = i6;
        return read2;
    }

    public final synchronized void mark(int i2) {
        this.f7191c = Math.max(this.f7191c, i2);
        this.f7192d = this.f7193e;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:11:0x0018=Splitter:B:11:0x0018, B:27:0x003b=Splitter:B:27:0x003b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int read() throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            byte[] r0 = r5.f7189a     // Catch:{ all -> 0x0040 }
            java.io.InputStream r1 = r5.in     // Catch:{ all -> 0x0040 }
            if (r0 == 0) goto L_0x003b
            if (r1 == 0) goto L_0x003b
            int r2 = r5.f7193e     // Catch:{ all -> 0x0040 }
            int r3 = r5.f7190b     // Catch:{ all -> 0x0040 }
            r4 = -1
            if (r2 < r3) goto L_0x0018
            int r1 = r5.a(r1, r0)     // Catch:{ all -> 0x0040 }
            if (r1 != r4) goto L_0x0018
            monitor-exit(r5)
            return r4
        L_0x0018:
            byte[] r1 = r5.f7189a     // Catch:{ all -> 0x0040 }
            if (r0 == r1) goto L_0x0026
            byte[] r0 = r5.f7189a     // Catch:{ all -> 0x0040 }
            if (r0 == 0) goto L_0x0021
            goto L_0x0026
        L_0x0021:
            java.io.IOException r0 = c()     // Catch:{ all -> 0x0040 }
            throw r0     // Catch:{ all -> 0x0040 }
        L_0x0026:
            int r1 = r5.f7190b     // Catch:{ all -> 0x0040 }
            int r2 = r5.f7193e     // Catch:{ all -> 0x0040 }
            int r1 = r1 - r2
            if (r1 <= 0) goto L_0x0039
            int r1 = r5.f7193e     // Catch:{ all -> 0x0040 }
            int r2 = r1 + 1
            r5.f7193e = r2     // Catch:{ all -> 0x0040 }
            byte r0 = r0[r1]     // Catch:{ all -> 0x0040 }
            r0 = r0 & 255(0xff, float:3.57E-43)
            monitor-exit(r5)
            return r0
        L_0x0039:
            monitor-exit(r5)
            return r4
        L_0x003b:
            java.io.IOException r0 = c()     // Catch:{ all -> 0x0040 }
            throw r0     // Catch:{ all -> 0x0040 }
        L_0x0040:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.d.a.y.read():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int read(byte[] r6, int r7, int r8) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            byte[] r0 = r5.f7189a     // Catch:{ all -> 0x009e }
            if (r0 == 0) goto L_0x0099
            if (r8 != 0) goto L_0x000a
            r6 = 0
            monitor-exit(r5)
            return r6
        L_0x000a:
            java.io.InputStream r1 = r5.in     // Catch:{ all -> 0x009e }
            if (r1 == 0) goto L_0x0094
            int r2 = r5.f7193e     // Catch:{ all -> 0x009e }
            int r3 = r5.f7190b     // Catch:{ all -> 0x009e }
            if (r2 >= r3) goto L_0x003b
            int r2 = r5.f7190b     // Catch:{ all -> 0x009e }
            int r3 = r5.f7193e     // Catch:{ all -> 0x009e }
            int r2 = r2 - r3
            if (r2 < r8) goto L_0x001d
            r2 = r8
            goto L_0x0022
        L_0x001d:
            int r2 = r5.f7190b     // Catch:{ all -> 0x009e }
            int r3 = r5.f7193e     // Catch:{ all -> 0x009e }
            int r2 = r2 - r3
        L_0x0022:
            int r3 = r5.f7193e     // Catch:{ all -> 0x009e }
            java.lang.System.arraycopy(r0, r3, r6, r7, r2)     // Catch:{ all -> 0x009e }
            int r3 = r5.f7193e     // Catch:{ all -> 0x009e }
            int r3 = r3 + r2
            r5.f7193e = r3     // Catch:{ all -> 0x009e }
            if (r2 == r8) goto L_0x0039
            int r3 = r1.available()     // Catch:{ all -> 0x009e }
            if (r3 != 0) goto L_0x0035
            goto L_0x0039
        L_0x0035:
            int r7 = r7 + r2
            int r2 = r8 - r2
            goto L_0x003c
        L_0x0039:
            monitor-exit(r5)
            return r2
        L_0x003b:
            r2 = r8
        L_0x003c:
            int r3 = r5.f7192d     // Catch:{ all -> 0x009e }
            r4 = -1
            if (r3 != r4) goto L_0x0051
            int r3 = r0.length     // Catch:{ all -> 0x009e }
            if (r2 < r3) goto L_0x0051
            int r3 = r1.read(r6, r7, r2)     // Catch:{ all -> 0x009e }
            if (r3 != r4) goto L_0x0084
            if (r2 != r8) goto L_0x004e
            monitor-exit(r5)
            return r4
        L_0x004e:
            int r8 = r8 - r2
            monitor-exit(r5)
            return r8
        L_0x0051:
            int r3 = r5.a(r1, r0)     // Catch:{ all -> 0x009e }
            if (r3 != r4) goto L_0x005e
            if (r2 != r8) goto L_0x005b
            monitor-exit(r5)
            return r4
        L_0x005b:
            int r8 = r8 - r2
            monitor-exit(r5)
            return r8
        L_0x005e:
            byte[] r3 = r5.f7189a     // Catch:{ all -> 0x009e }
            if (r0 == r3) goto L_0x006c
            byte[] r0 = r5.f7189a     // Catch:{ all -> 0x009e }
            if (r0 == 0) goto L_0x0067
            goto L_0x006c
        L_0x0067:
            java.io.IOException r6 = c()     // Catch:{ all -> 0x009e }
            throw r6     // Catch:{ all -> 0x009e }
        L_0x006c:
            int r3 = r5.f7190b     // Catch:{ all -> 0x009e }
            int r4 = r5.f7193e     // Catch:{ all -> 0x009e }
            int r3 = r3 - r4
            if (r3 < r2) goto L_0x0075
            r3 = r2
            goto L_0x007a
        L_0x0075:
            int r3 = r5.f7190b     // Catch:{ all -> 0x009e }
            int r4 = r5.f7193e     // Catch:{ all -> 0x009e }
            int r3 = r3 - r4
        L_0x007a:
            int r4 = r5.f7193e     // Catch:{ all -> 0x009e }
            java.lang.System.arraycopy(r0, r4, r6, r7, r3)     // Catch:{ all -> 0x009e }
            int r4 = r5.f7193e     // Catch:{ all -> 0x009e }
            int r4 = r4 + r3
            r5.f7193e = r4     // Catch:{ all -> 0x009e }
        L_0x0084:
            int r2 = r2 - r3
            if (r2 != 0) goto L_0x0089
            monitor-exit(r5)
            return r8
        L_0x0089:
            int r4 = r1.available()     // Catch:{ all -> 0x009e }
            if (r4 != 0) goto L_0x0092
            int r8 = r8 - r2
            monitor-exit(r5)
            return r8
        L_0x0092:
            int r7 = r7 + r3
            goto L_0x003c
        L_0x0094:
            java.io.IOException r6 = c()     // Catch:{ all -> 0x009e }
            throw r6     // Catch:{ all -> 0x009e }
        L_0x0099:
            java.io.IOException r6 = c()     // Catch:{ all -> 0x009e }
            throw r6     // Catch:{ all -> 0x009e }
        L_0x009e:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.d.a.y.read(byte[], int, int):int");
    }

    public final synchronized void reset() throws IOException {
        if (this.f7189a == null) {
            throw new IOException("Stream is closed");
        } else if (-1 != this.f7192d) {
            this.f7193e = this.f7192d;
        } else {
            throw new a("Mark has been invalidated, pos: " + this.f7193e + " markLimit: " + this.f7191c);
        }
    }

    public final synchronized long skip(long j) throws IOException {
        if (j < 1) {
            return 0;
        }
        byte[] bArr = this.f7189a;
        if (bArr != null) {
            InputStream inputStream = this.in;
            if (inputStream == null) {
                throw c();
            } else if (((long) (this.f7190b - this.f7193e)) >= j) {
                this.f7193e = (int) (((long) this.f7193e) + j);
                return j;
            } else {
                long j2 = ((long) this.f7190b) - ((long) this.f7193e);
                this.f7193e = this.f7190b;
                if (this.f7192d == -1 || j > ((long) this.f7191c)) {
                    return j2 + inputStream.skip(j - j2);
                } else if (a(inputStream, bArr) == -1) {
                    return j2;
                } else {
                    if (((long) (this.f7190b - this.f7193e)) >= j - j2) {
                        this.f7193e = (int) ((((long) this.f7193e) + j) - j2);
                        return j;
                    }
                    long j3 = (j2 + ((long) this.f7190b)) - ((long) this.f7193e);
                    this.f7193e = this.f7190b;
                    return j3;
                }
            }
        } else {
            throw c();
        }
    }

    static class a extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        a(String str) {
            super(str);
        }
    }
}
