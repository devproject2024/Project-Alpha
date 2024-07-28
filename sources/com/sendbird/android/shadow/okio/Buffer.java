package com.sendbird.android.shadow.okio;

import com.alipay.mobile.nebula.util.tar.TarHeader;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import easypay.manager.Constants;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;

public final class Buffer implements BufferedSink, BufferedSource, Cloneable, ByteChannel {
    private static final byte[] DIGITS = {TarHeader.LF_NORMAL, TarHeader.LF_LINK, TarHeader.LF_SYMLINK, TarHeader.LF_CHR, TarHeader.LF_BLK, TarHeader.LF_DIR, TarHeader.LF_FIFO, TarHeader.LF_CONTIG, 56, 57, 97, 98, 99, 100, 101, 102};
    static final int REPLACEMENT_CHARACTER = 65533;
    d head;
    long size;

    public final Buffer buffer() {
        return this;
    }

    public final void close() {
    }

    public final BufferedSink emit() {
        return this;
    }

    public final Buffer emitCompleteSegments() {
        return this;
    }

    public final void flush() {
    }

    public final boolean isOpen() {
        return true;
    }

    public final long size() {
        return this.size;
    }

    public final OutputStream outputStream() {
        return new OutputStream() {
            public final void close() {
            }

            public final void flush() {
            }

            public final void write(int i2) {
                Buffer.this.writeByte((int) (byte) i2);
            }

            public final void write(byte[] bArr, int i2, int i3) {
                Buffer.this.write(bArr, i2, i3);
            }

            public final String toString() {
                return Buffer.this + ".outputStream()";
            }
        };
    }

    public final boolean exhausted() {
        return this.size == 0;
    }

    public final void require(long j) throws EOFException {
        if (this.size < j) {
            throw new EOFException();
        }
    }

    public final boolean request(long j) {
        return this.size >= j;
    }

    public final InputStream inputStream() {
        return new InputStream() {
            public final void close() {
            }

            public final int read() {
                if (Buffer.this.size > 0) {
                    return Buffer.this.readByte() & 255;
                }
                return -1;
            }

            public final int read(byte[] bArr, int i2, int i3) {
                return Buffer.this.read(bArr, i2, i3);
            }

            public final int available() {
                return (int) Math.min(Buffer.this.size, 2147483647L);
            }

            public final String toString() {
                return Buffer.this + ".inputStream()";
            }
        };
    }

    public final Buffer copyTo(OutputStream outputStream) throws IOException {
        return copyTo(outputStream, 0, this.size);
    }

    public final Buffer copyTo(OutputStream outputStream, long j, long j2) throws IOException {
        if (outputStream != null) {
            g.a(this.size, j, j2);
            if (j2 == 0) {
                return this;
            }
            d dVar = this.head;
            while (j >= ((long) (dVar.f45275c - dVar.f45274b))) {
                j -= (long) (dVar.f45275c - dVar.f45274b);
                dVar = dVar.f45278f;
            }
            while (j2 > 0) {
                int i2 = (int) (((long) dVar.f45274b) + j);
                int min = (int) Math.min((long) (dVar.f45275c - i2), j2);
                outputStream.write(dVar.f45273a, i2, min);
                j2 -= (long) min;
                dVar = dVar.f45278f;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public final Buffer copyTo(Buffer buffer, long j, long j2) {
        if (buffer != null) {
            g.a(this.size, j, j2);
            if (j2 == 0) {
                return this;
            }
            buffer.size += j2;
            d dVar = this.head;
            while (j >= ((long) (dVar.f45275c - dVar.f45274b))) {
                j -= (long) (dVar.f45275c - dVar.f45274b);
                dVar = dVar.f45278f;
            }
            while (j2 > 0) {
                d a2 = dVar.a();
                a2.f45274b = (int) (((long) a2.f45274b) + j);
                a2.f45275c = Math.min(a2.f45274b + ((int) j2), a2.f45275c);
                d dVar2 = buffer.head;
                if (dVar2 == null) {
                    a2.f45279g = a2;
                    a2.f45278f = a2;
                    buffer.head = a2;
                } else {
                    dVar2.f45279g.a(a2);
                }
                j2 -= (long) (a2.f45275c - a2.f45274b);
                dVar = dVar.f45278f;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public final Buffer writeTo(OutputStream outputStream) throws IOException {
        return writeTo(outputStream, this.size);
    }

    public final Buffer writeTo(OutputStream outputStream, long j) throws IOException {
        if (outputStream != null) {
            g.a(this.size, 0, j);
            d dVar = this.head;
            while (j > 0) {
                int min = (int) Math.min(j, (long) (dVar.f45275c - dVar.f45274b));
                outputStream.write(dVar.f45273a, dVar.f45274b, min);
                dVar.f45274b += min;
                long j2 = (long) min;
                this.size -= j2;
                j -= j2;
                if (dVar.f45274b == dVar.f45275c) {
                    d c2 = dVar.c();
                    this.head = c2;
                    e.a(dVar);
                    dVar = c2;
                }
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public final Buffer readFrom(InputStream inputStream) throws IOException {
        readFrom(inputStream, Long.MAX_VALUE, true);
        return this;
    }

    public final Buffer readFrom(InputStream inputStream, long j) throws IOException {
        if (j >= 0) {
            readFrom(inputStream, j, false);
            return this;
        }
        throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
    }

    private void readFrom(InputStream inputStream, long j, boolean z) throws IOException {
        if (inputStream != null) {
            while (true) {
                if (j > 0 || z) {
                    d writableSegment = writableSegment(1);
                    int read = inputStream.read(writableSegment.f45273a, writableSegment.f45275c, (int) Math.min(j, (long) (8192 - writableSegment.f45275c)));
                    if (read != -1) {
                        writableSegment.f45275c += read;
                        long j2 = (long) read;
                        this.size += j2;
                        j -= j2;
                    } else if (!z) {
                        throw new EOFException();
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("in == null");
        }
    }

    public final long completeSegmentByteCount() {
        long j = this.size;
        if (j == 0) {
            return 0;
        }
        d dVar = this.head.f45279g;
        return (dVar.f45275c >= 8192 || !dVar.f45277e) ? j : j - ((long) (dVar.f45275c - dVar.f45274b));
    }

    public final byte readByte() {
        if (this.size != 0) {
            d dVar = this.head;
            int i2 = dVar.f45274b;
            int i3 = dVar.f45275c;
            int i4 = i2 + 1;
            byte b2 = dVar.f45273a[i2];
            this.size--;
            if (i4 == i3) {
                this.head = dVar.c();
                e.a(dVar);
            } else {
                dVar.f45274b = i4;
            }
            return b2;
        }
        throw new IllegalStateException("size == 0");
    }

    public final byte getByte(long j) {
        g.a(this.size, j, 1);
        long j2 = this.size;
        if (j2 - j > j) {
            d dVar = this.head;
            while (true) {
                long j3 = (long) (dVar.f45275c - dVar.f45274b);
                if (j < j3) {
                    return dVar.f45273a[dVar.f45274b + ((int) j)];
                }
                j -= j3;
                dVar = dVar.f45278f;
            }
        } else {
            long j4 = j - j2;
            d dVar2 = this.head;
            do {
                dVar2 = dVar2.f45279g;
                j4 += (long) (dVar2.f45275c - dVar2.f45274b);
            } while (j4 < 0);
            return dVar2.f45273a[dVar2.f45274b + ((int) j4)];
        }
    }

    public final short readShort() {
        if (this.size >= 2) {
            d dVar = this.head;
            int i2 = dVar.f45274b;
            int i3 = dVar.f45275c;
            if (i3 - i2 < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = dVar.f45273a;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            byte b2 = ((bArr[i2] & 255) << 8) | (bArr[i4] & 255);
            this.size -= 2;
            if (i5 == i3) {
                this.head = dVar.c();
                e.a(dVar);
            } else {
                dVar.f45274b = i5;
            }
            return (short) b2;
        }
        throw new IllegalStateException("size < 2: " + this.size);
    }

    public final int readInt() {
        if (this.size >= 4) {
            d dVar = this.head;
            int i2 = dVar.f45274b;
            int i3 = dVar.f45275c;
            if (i3 - i2 < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = dVar.f45273a;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            byte b2 = ((bArr[i2] & 255) << 24) | ((bArr[i4] & 255) << 16);
            int i6 = i5 + 1;
            byte b3 = b2 | ((bArr[i5] & 255) << 8);
            int i7 = i6 + 1;
            byte b4 = b3 | (bArr[i6] & 255);
            this.size -= 4;
            if (i7 == i3) {
                this.head = dVar.c();
                e.a(dVar);
            } else {
                dVar.f45274b = i7;
            }
            return b4;
        }
        throw new IllegalStateException("size < 4: " + this.size);
    }

    public final long readLong() {
        if (this.size >= 8) {
            d dVar = this.head;
            int i2 = dVar.f45274b;
            int i3 = dVar.f45275c;
            if (i3 - i2 < 8) {
                return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
            }
            byte[] bArr = dVar.f45273a;
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            int i6 = i5 + 1;
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            int i9 = i8 + 1;
            int i10 = i9 + 1;
            int i11 = i10 + 1;
            long j = (((long) bArr[i10]) & 255) | ((((long) bArr[i2]) & 255) << 56) | ((((long) bArr[i4]) & 255) << 48) | ((((long) bArr[i5]) & 255) << 40) | ((((long) bArr[i6]) & 255) << 32) | ((((long) bArr[i7]) & 255) << 24) | ((((long) bArr[i8]) & 255) << 16) | ((((long) bArr[i9]) & 255) << 8);
            this.size -= 8;
            if (i11 == i3) {
                this.head = dVar.c();
                e.a(dVar);
            } else {
                dVar.f45274b = i11;
            }
            return j;
        }
        throw new IllegalStateException("size < 8: " + this.size);
    }

    public final short readShortLe() {
        return g.a(readShort());
    }

    public final int readIntLe() {
        return g.a(readInt());
    }

    public final long readLongLe() {
        return g.a(readLong());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
        r1 = new com.sendbird.android.shadow.okio.Buffer().writeDecimalLong(r6).writeByte((int) r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004e, code lost:
        if (r3 != false) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
        r1.readByte();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006a, code lost:
        throw new java.lang.NumberFormatException("Number too large: " + r1.readUtf8());
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x009c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x001b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long readDecimalLong() {
        /*
            r17 = this;
            r0 = r17
            long r1 = r0.size
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00bd
            r1 = -7
            r5 = 0
            r6 = r3
            r3 = 0
            r4 = 0
        L_0x0010:
            com.sendbird.android.shadow.okio.d r8 = r0.head
            byte[] r9 = r8.f45273a
            int r10 = r8.f45274b
            int r11 = r8.f45275c
        L_0x0018:
            r12 = 1
            if (r10 >= r11) goto L_0x009c
            byte r13 = r9[r10]
            r14 = 48
            if (r13 < r14) goto L_0x006b
            r15 = 57
            if (r13 > r15) goto L_0x006b
            int r14 = r14 - r13
            r15 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r12 = (r6 > r15 ? 1 : (r6 == r15 ? 0 : -1))
            if (r12 < 0) goto L_0x0041
            r15 = r8
            r16 = r9
            if (r12 != 0) goto L_0x003a
            long r8 = (long) r14
            int r12 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r12 >= 0) goto L_0x003a
            goto L_0x0041
        L_0x003a:
            r8 = 10
            long r6 = r6 * r8
            long r8 = (long) r14
            long r6 = r6 + r8
            goto L_0x0078
        L_0x0041:
            com.sendbird.android.shadow.okio.Buffer r1 = new com.sendbird.android.shadow.okio.Buffer
            r1.<init>()
            com.sendbird.android.shadow.okio.Buffer r1 = r1.writeDecimalLong((long) r6)
            com.sendbird.android.shadow.okio.Buffer r1 = r1.writeByte((int) r13)
            if (r3 != 0) goto L_0x0053
            r1.readByte()
        L_0x0053:
            java.lang.NumberFormatException r2 = new java.lang.NumberFormatException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Number too large: "
            r3.<init>(r4)
            java.lang.String r1 = r1.readUtf8()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x006b:
            r15 = r8
            r16 = r9
            r8 = 45
            if (r13 != r8) goto L_0x0080
            if (r5 != 0) goto L_0x0080
            r8 = 1
            long r1 = r1 - r8
            r3 = 1
        L_0x0078:
            int r10 = r10 + 1
            int r5 = r5 + 1
            r8 = r15
            r9 = r16
            goto L_0x0018
        L_0x0080:
            if (r5 == 0) goto L_0x0084
            r4 = 1
            goto L_0x009d
        L_0x0084:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Expected leading [0-9] or '-' character but was 0x"
            r2.<init>(r3)
            java.lang.String r3 = java.lang.Integer.toHexString(r13)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x009c:
            r15 = r8
        L_0x009d:
            if (r10 != r11) goto L_0x00a9
            com.sendbird.android.shadow.okio.d r8 = r15.c()
            r0.head = r8
            com.sendbird.android.shadow.okio.e.a(r15)
            goto L_0x00ac
        L_0x00a9:
            r8 = r15
            r8.f45274b = r10
        L_0x00ac:
            if (r4 != 0) goto L_0x00b2
            com.sendbird.android.shadow.okio.d r8 = r0.head
            if (r8 != 0) goto L_0x0010
        L_0x00b2:
            long r1 = r0.size
            long r4 = (long) r5
            long r1 = r1 - r4
            r0.size = r1
            if (r3 == 0) goto L_0x00bb
            return r6
        L_0x00bb:
            long r1 = -r6
            return r1
        L_0x00bd:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "size == 0"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okio.Buffer.readDecimalLong():long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x008c, code lost:
        if (r8 != r9) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008e, code lost:
        r15.head = r6.c();
        com.sendbird.android.shadow.okio.e.a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0098, code lost:
        r6.f45274b = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009a, code lost:
        if (r5 != false) goto L_0x00a0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0074 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long readHexadecimalUnsignedLong() {
        /*
            r15 = this;
            long r0 = r15.size
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00a7
            r0 = 0
            r0 = r2
            r4 = 0
            r5 = 0
        L_0x000c:
            com.sendbird.android.shadow.okio.d r6 = r15.head
            byte[] r7 = r6.f45273a
            int r8 = r6.f45274b
            int r9 = r6.f45275c
        L_0x0014:
            if (r8 >= r9) goto L_0x008c
            byte r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L_0x0023
            r11 = 57
            if (r10 > r11) goto L_0x0023
            int r11 = r10 + -48
            goto L_0x003b
        L_0x0023:
            r11 = 97
            if (r10 < r11) goto L_0x0030
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L_0x0030
            int r11 = r10 + -97
        L_0x002d:
            int r11 = r11 + 10
            goto L_0x003b
        L_0x0030:
            r11 = 65
            if (r10 < r11) goto L_0x0070
            r11 = 70
            if (r10 > r11) goto L_0x0070
            int r11 = r10 + -65
            goto L_0x002d
        L_0x003b:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r0
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L_0x004b
            r10 = 4
            long r0 = r0 << r10
            long r10 = (long) r11
            long r0 = r0 | r10
            int r8 = r8 + 1
            int r4 = r4 + 1
            goto L_0x0014
        L_0x004b:
            com.sendbird.android.shadow.okio.Buffer r2 = new com.sendbird.android.shadow.okio.Buffer
            r2.<init>()
            com.sendbird.android.shadow.okio.Buffer r0 = r2.writeHexadecimalUnsignedLong((long) r0)
            com.sendbird.android.shadow.okio.Buffer r0 = r0.writeByte((int) r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Number too large: "
            r2.<init>(r3)
            java.lang.String r0 = r0.readUtf8()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0070:
            if (r4 == 0) goto L_0x0074
            r5 = 1
            goto L_0x008c
        L_0x0074:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.<init>(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x008c:
            if (r8 != r9) goto L_0x0098
            com.sendbird.android.shadow.okio.d r7 = r6.c()
            r15.head = r7
            com.sendbird.android.shadow.okio.e.a(r6)
            goto L_0x009a
        L_0x0098:
            r6.f45274b = r8
        L_0x009a:
            if (r5 != 0) goto L_0x00a0
            com.sendbird.android.shadow.okio.d r6 = r15.head
            if (r6 != 0) goto L_0x000c
        L_0x00a0:
            long r2 = r15.size
            long r4 = (long) r4
            long r2 = r2 - r4
            r15.size = r2
            return r0
        L_0x00a7:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okio.Buffer.readHexadecimalUnsignedLong():long");
    }

    public final ByteString readByteString() {
        return new ByteString(readByteArray());
    }

    public final ByteString readByteString(long j) throws EOFException {
        return new ByteString(readByteArray(j));
    }

    public final int select(Options options) {
        int selectPrefix = selectPrefix(options, false);
        if (selectPrefix == -1) {
            return -1;
        }
        try {
            skip((long) options.byteStrings[selectPrefix].size());
            return selectPrefix;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    public final int selectPrefix(Options options, boolean z) {
        int i2;
        int i3;
        d dVar;
        Options options2 = options;
        d dVar2 = this.head;
        if (dVar2 != null) {
            byte[] bArr = dVar2.f45273a;
            int i4 = dVar2.f45274b;
            int i5 = dVar2.f45275c;
            int[] iArr = options2.trie;
            int i6 = i4;
            int i7 = i5;
            int i8 = -1;
            d dVar3 = dVar2;
            byte[] bArr2 = bArr;
            int i9 = 0;
            loop0:
            while (true) {
                int i10 = i9 + 1;
                int i11 = iArr[i9];
                int i12 = i10 + 1;
                int i13 = iArr[i10];
                if (i13 != -1) {
                    i8 = i13;
                }
                if (dVar3 == null) {
                    break;
                }
                if (i11 < 0) {
                    int i14 = i12 + (i11 * -1);
                    while (true) {
                        int i15 = i6 + 1;
                        int i16 = i12 + 1;
                        if ((bArr2[i6] & 255) != iArr[i12]) {
                            return i8;
                        }
                        boolean z2 = i16 == i14;
                        if (i15 == i7) {
                            dVar = dVar3.f45278f;
                            i3 = dVar.f45274b;
                            bArr2 = dVar.f45273a;
                            i7 = dVar.f45275c;
                            if (dVar == dVar2) {
                                if (!z2) {
                                    break loop0;
                                }
                                dVar = null;
                            }
                        } else {
                            d dVar4 = dVar3;
                            i3 = i15;
                            dVar = dVar4;
                        }
                        if (z2) {
                            i2 = iArr[i16];
                            break;
                        }
                        i6 = i3;
                        i12 = i16;
                        dVar3 = dVar;
                    }
                } else {
                    int i17 = i6 + 1;
                    byte b2 = bArr2[i6] & 255;
                    int i18 = i12 + i11;
                    while (i12 != i18) {
                        if (b2 == iArr[i12]) {
                            i2 = iArr[i12 + i11];
                            if (i17 == i7) {
                                dVar = dVar3.f45278f;
                                i3 = dVar.f45274b;
                                bArr2 = dVar.f45273a;
                                i7 = dVar.f45275c;
                                if (dVar == dVar2) {
                                    dVar = null;
                                }
                            } else {
                                dVar = dVar3;
                                i3 = i17;
                            }
                        } else {
                            i12++;
                        }
                    }
                    return i8;
                }
                if (i2 >= 0) {
                    return i2;
                }
                int i19 = -i2;
                i6 = i3;
                dVar3 = dVar;
                i9 = i19;
            }
            if (z) {
                return -2;
            }
            return i8;
        } else if (z) {
            return -2;
        } else {
            return options2.indexOf(ByteString.EMPTY);
        }
    }

    public final void readFully(Buffer buffer, long j) throws EOFException {
        long j2 = this.size;
        if (j2 >= j) {
            buffer.write(this, j);
        } else {
            buffer.write(this, j2);
            throw new EOFException();
        }
    }

    public final long readAll(Sink sink) throws IOException {
        long j = this.size;
        if (j > 0) {
            sink.write(this, j);
        }
        return j;
    }

    public final String readUtf8() {
        try {
            return readString(this.size, g.f45282a);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public final String readUtf8(long j) throws EOFException {
        return readString(j, g.f45282a);
    }

    public final String readString(Charset charset) {
        try {
            return readString(this.size, charset);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public final String readString(long j, Charset charset) throws EOFException {
        g.a(this.size, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        } else if (j == 0) {
            return "";
        } else {
            d dVar = this.head;
            if (((long) dVar.f45274b) + j > ((long) dVar.f45275c)) {
                return new String(readByteArray(j), charset);
            }
            String str = new String(dVar.f45273a, dVar.f45274b, (int) j, charset);
            dVar.f45274b = (int) (((long) dVar.f45274b) + j);
            this.size -= j;
            if (dVar.f45274b == dVar.f45275c) {
                this.head = dVar.c();
                e.a(dVar);
            }
            return str;
        }
    }

    public final String readUtf8Line() throws EOFException {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return readUtf8Line(indexOf);
        }
        long j = this.size;
        if (j != 0) {
            return readUtf8(j);
        }
        return null;
    }

    public final String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(Long.MAX_VALUE);
    }

    public final String readUtf8LineStrict(long j) throws EOFException {
        if (j >= 0) {
            long j2 = Long.MAX_VALUE;
            if (j != Long.MAX_VALUE) {
                j2 = j + 1;
            }
            long indexOf = indexOf((byte) 10, 0, j2);
            if (indexOf != -1) {
                return readUtf8Line(indexOf);
            }
            if (j2 < size() && getByte(j2 - 1) == 13 && getByte(j2) == 10) {
                return readUtf8Line(j2);
            }
            Buffer buffer = new Buffer();
            copyTo(buffer, 0, Math.min(32, size()));
            throw new EOFException("\\n not found: limit=" + Math.min(size(), j) + " content=" + buffer.readByteString().hex() + 8230);
        }
        throw new IllegalArgumentException("limit < 0: ".concat(String.valueOf(j)));
    }

    /* access modifiers changed from: package-private */
    public final String readUtf8Line(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (getByte(j2) == 13) {
                String readUtf8 = readUtf8(j2);
                skip(2);
                return readUtf8;
            }
        }
        String readUtf82 = readUtf8(j);
        skip(1);
        return readUtf82;
    }

    public final int readUtf8CodePoint() throws EOFException {
        byte b2;
        int i2;
        byte b3;
        if (this.size != 0) {
            byte b4 = getByte(0);
            int i3 = 1;
            if ((b4 & 128) == 0) {
                b3 = b4 & Byte.MAX_VALUE;
                i2 = 1;
                b2 = 0;
            } else if ((b4 & 224) == 192) {
                b3 = b4 & 31;
                i2 = 2;
                b2 = 128;
            } else if ((b4 & 240) == 224) {
                b3 = b4 & 15;
                i2 = 3;
                b2 = TarHeader.LF_OLDNORM;
            } else if ((b4 & 248) == 240) {
                b3 = b4 & 7;
                i2 = 4;
                b2 = TarHeader.LF_OLDNORM;
            } else {
                skip(1);
                return REPLACEMENT_CHARACTER;
            }
            long j = (long) i2;
            if (this.size >= j) {
                while (i3 < i2) {
                    long j2 = (long) i3;
                    byte b5 = getByte(j2);
                    if ((b5 & 192) == 128) {
                        b3 = (b3 << 6) | (b5 & 63);
                        i3++;
                    } else {
                        skip(j2);
                        return REPLACEMENT_CHARACTER;
                    }
                }
                skip(j);
                if (b3 > 1114111) {
                    return REPLACEMENT_CHARACTER;
                }
                if ((b3 < 55296 || b3 > 57343) && b3 >= b2) {
                    return b3;
                }
                return REPLACEMENT_CHARACTER;
            }
            throw new EOFException("size < " + i2 + ": " + this.size + " (to read code point prefixed 0x" + Integer.toHexString(b4) + ")");
        }
        throw new EOFException();
    }

    public final byte[] readByteArray() {
        try {
            return readByteArray(this.size);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public final byte[] readByteArray(long j) throws EOFException {
        g.a(this.size, 0, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[((int) j)];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
    }

    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public final void readFully(byte[] bArr) throws EOFException {
        int i2 = 0;
        while (i2 < bArr.length) {
            int read = read(bArr, i2, bArr.length - i2);
            if (read != -1) {
                i2 += read;
            } else {
                throw new EOFException();
            }
        }
    }

    public final int read(byte[] bArr, int i2, int i3) {
        g.a((long) bArr.length, (long) i2, (long) i3);
        d dVar = this.head;
        if (dVar == null) {
            return -1;
        }
        int min = Math.min(i3, dVar.f45275c - dVar.f45274b);
        System.arraycopy(dVar.f45273a, dVar.f45274b, bArr, i2, min);
        dVar.f45274b += min;
        this.size -= (long) min;
        if (dVar.f45274b == dVar.f45275c) {
            this.head = dVar.c();
            e.a(dVar);
        }
        return min;
    }

    public final int read(ByteBuffer byteBuffer) throws IOException {
        d dVar = this.head;
        if (dVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), dVar.f45275c - dVar.f45274b);
        byteBuffer.put(dVar.f45273a, dVar.f45274b, min);
        dVar.f45274b += min;
        this.size -= (long) min;
        if (dVar.f45274b == dVar.f45275c) {
            this.head = dVar.c();
            e.a(dVar);
        }
        return min;
    }

    public final void clear() {
        try {
            skip(this.size);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public final void skip(long j) throws EOFException {
        while (j > 0) {
            d dVar = this.head;
            if (dVar != null) {
                int min = (int) Math.min(j, (long) (dVar.f45275c - this.head.f45274b));
                long j2 = (long) min;
                this.size -= j2;
                j -= j2;
                this.head.f45274b += min;
                if (this.head.f45274b == this.head.f45275c) {
                    d dVar2 = this.head;
                    this.head = dVar2.c();
                    e.a(dVar2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public final Buffer write(ByteString byteString) {
        if (byteString != null) {
            byteString.write(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    public final Buffer writeUtf8(String str) {
        return writeUtf8(str, 0, str.length());
    }

    public final Buffer writeUtf8(String str, int i2, int i3) {
        char c2;
        char charAt;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i2 < 0) {
            throw new IllegalArgumentException("beginIndex < 0: ".concat(String.valueOf(i2)));
        } else if (i3 < i2) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i3 + " < " + i2);
        } else if (i3 <= str.length()) {
            while (i2 < i3) {
                char charAt2 = str.charAt(i2);
                if (charAt2 < 128) {
                    d writableSegment = writableSegment(1);
                    byte[] bArr = writableSegment.f45273a;
                    int i4 = writableSegment.f45275c - i2;
                    int min = Math.min(i3, 8192 - i4);
                    int i5 = i2 + 1;
                    bArr[i2 + i4] = (byte) charAt2;
                    while (true) {
                        i2 = i5;
                        if (i2 >= min || (charAt = str.charAt(i2)) >= 128) {
                            int i6 = (i4 + i2) - writableSegment.f45275c;
                            writableSegment.f45275c += i6;
                            this.size += (long) i6;
                        } else {
                            i5 = i2 + 1;
                            bArr[i2 + i4] = (byte) charAt;
                        }
                    }
                    int i62 = (i4 + i2) - writableSegment.f45275c;
                    writableSegment.f45275c += i62;
                    this.size += (long) i62;
                } else {
                    if (charAt2 < 2048) {
                        writeByte((charAt2 >> 6) | 192);
                        writeByte((int) (charAt2 & '?') | 128);
                    } else if (charAt2 < 55296 || charAt2 > 57343) {
                        writeByte((charAt2 >> 12) | Constants.EASY_PAY_INVISIBLE_ASSIST);
                        writeByte(((charAt2 >> 6) & 63) | 128);
                        writeByte((int) (charAt2 & '?') | 128);
                    } else {
                        int i7 = i2 + 1;
                        if (i7 < i3) {
                            c2 = str.charAt(i7);
                        } else {
                            c2 = 0;
                        }
                        if (charAt2 > 56319 || c2 < 56320 || c2 > 57343) {
                            writeByte(63);
                            i2 = i7;
                        } else {
                            int i8 = (((charAt2 & 10239) << 10) | (9215 & c2)) + 0;
                            writeByte((i8 >> 18) | 240);
                            writeByte(((i8 >> 12) & 63) | 128);
                            writeByte(((i8 >> 6) & 63) | 128);
                            writeByte((i8 & 63) | 128);
                            i2 += 2;
                        }
                    }
                    i2++;
                }
            }
            return this;
        } else {
            throw new IllegalArgumentException("endIndex > string.length: " + i3 + " > " + str.length());
        }
    }

    public final Buffer writeUtf8CodePoint(int i2) {
        if (i2 < 128) {
            writeByte(i2);
        } else if (i2 < 2048) {
            writeByte((i2 >> 6) | 192);
            writeByte((i2 & 63) | 128);
        } else if (i2 < 65536) {
            if (i2 < 55296 || i2 > 57343) {
                writeByte((i2 >> 12) | Constants.EASY_PAY_INVISIBLE_ASSIST);
                writeByte(((i2 >> 6) & 63) | 128);
                writeByte((i2 & 63) | 128);
            } else {
                writeByte(63);
            }
        } else if (i2 <= 1114111) {
            writeByte((i2 >> 18) | 240);
            writeByte(((i2 >> 12) & 63) | 128);
            writeByte(((i2 >> 6) & 63) | 128);
            writeByte((i2 & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i2));
        }
        return this;
    }

    public final Buffer writeString(String str, Charset charset) {
        return writeString(str, 0, str.length(), charset);
    }

    public final Buffer writeString(String str, int i2, int i3, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i2 < 0) {
            throw new IllegalAccessError("beginIndex < 0: ".concat(String.valueOf(i2)));
        } else if (i3 < i2) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i3 + " < " + i2);
        } else if (i3 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i3 + " > " + str.length());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(g.f45282a)) {
            return writeUtf8(str, i2, i3);
        } else {
            byte[] bytes = str.substring(i2, i3).getBytes(charset);
            return write(bytes, 0, bytes.length);
        }
    }

    public final Buffer write(byte[] bArr) {
        if (bArr != null) {
            return write(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    public final Buffer write(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            long j = (long) i3;
            g.a((long) bArr.length, (long) i2, j);
            int i4 = i3 + i2;
            while (i2 < i4) {
                d writableSegment = writableSegment(1);
                int min = Math.min(i4 - i2, 8192 - writableSegment.f45275c);
                System.arraycopy(bArr, i2, writableSegment.f45273a, writableSegment.f45275c, min);
                i2 += min;
                writableSegment.f45275c += min;
            }
            this.size += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    public final int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i2 = remaining;
            while (i2 > 0) {
                d writableSegment = writableSegment(1);
                int min = Math.min(i2, 8192 - writableSegment.f45275c);
                byteBuffer.get(writableSegment.f45273a, writableSegment.f45275c, min);
                i2 -= min;
                writableSegment.f45275c += min;
            }
            this.size += (long) remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    public final long writeAll(Source source) throws IOException {
        if (source != null) {
            long j = 0;
            while (true) {
                long read = source.read(this, 8192);
                if (read == -1) {
                    return j;
                }
                j += read;
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public final BufferedSink write(Source source, long j) throws IOException {
        while (j > 0) {
            long read = source.read(this, j);
            if (read != -1) {
                j -= read;
            } else {
                throw new EOFException();
            }
        }
        return this;
    }

    public final Buffer writeByte(int i2) {
        d writableSegment = writableSegment(1);
        byte[] bArr = writableSegment.f45273a;
        int i3 = writableSegment.f45275c;
        writableSegment.f45275c = i3 + 1;
        bArr[i3] = (byte) i2;
        this.size++;
        return this;
    }

    public final Buffer writeShort(int i2) {
        d writableSegment = writableSegment(2);
        byte[] bArr = writableSegment.f45273a;
        int i3 = writableSegment.f45275c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 8) & PriceRangeSeekBar.INVALID_POINTER_ID);
        bArr[i4] = (byte) (i2 & PriceRangeSeekBar.INVALID_POINTER_ID);
        writableSegment.f45275c = i4 + 1;
        this.size += 2;
        return this;
    }

    public final Buffer writeShortLe(int i2) {
        return writeShort((int) g.a((short) i2));
    }

    public final Buffer writeInt(int i2) {
        d writableSegment = writableSegment(4);
        byte[] bArr = writableSegment.f45273a;
        int i3 = writableSegment.f45275c;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 24) & PriceRangeSeekBar.INVALID_POINTER_ID);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 16) & PriceRangeSeekBar.INVALID_POINTER_ID);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i2 >>> 8) & PriceRangeSeekBar.INVALID_POINTER_ID);
        bArr[i6] = (byte) (i2 & PriceRangeSeekBar.INVALID_POINTER_ID);
        writableSegment.f45275c = i6 + 1;
        this.size += 4;
        return this;
    }

    public final Buffer writeIntLe(int i2) {
        return writeInt(g.a(i2));
    }

    public final Buffer writeLong(long j) {
        d writableSegment = writableSegment(8);
        byte[] bArr = writableSegment.f45273a;
        int i2 = writableSegment.f45275c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 56) & 255));
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((int) ((j >>> 48) & 255));
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((int) ((j >>> 40) & 255));
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((int) ((j >>> 32) & 255));
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((int) ((j >>> 24) & 255));
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((int) ((j >>> 16) & 255));
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((int) ((j >>> 8) & 255));
        bArr[i9] = (byte) ((int) (j & 255));
        writableSegment.f45275c = i9 + 1;
        this.size += 8;
        return this;
    }

    public final Buffer writeLongLe(long j) {
        return writeLong(g.a(j));
    }

    public final Buffer writeDecimalLong(long j) {
        int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i2 == 0) {
            return writeByte(48);
        }
        boolean z = false;
        int i3 = 1;
        if (i2 < 0) {
            j = -j;
            if (j < 0) {
                return writeUtf8("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i3 = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i3 = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i3 = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i3 = 2;
        }
        if (z) {
            i3++;
        }
        d writableSegment = writableSegment(i3);
        byte[] bArr = writableSegment.f45273a;
        int i4 = writableSegment.f45275c + i3;
        while (j != 0) {
            i4--;
            bArr[i4] = DIGITS[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i4 - 1] = 45;
        }
        writableSegment.f45275c += i3;
        this.size += (long) i3;
        return this;
    }

    public final Buffer writeHexadecimalUnsignedLong(long j) {
        if (j == 0) {
            return writeByte(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        d writableSegment = writableSegment(numberOfTrailingZeros);
        byte[] bArr = writableSegment.f45273a;
        int i2 = writableSegment.f45275c;
        for (int i3 = (writableSegment.f45275c + numberOfTrailingZeros) - 1; i3 >= i2; i3--) {
            bArr[i3] = DIGITS[(int) (15 & j)];
            j >>>= 4;
        }
        writableSegment.f45275c += numberOfTrailingZeros;
        this.size += (long) numberOfTrailingZeros;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final d writableSegment(int i2) {
        if (i2 <= 0 || i2 > 8192) {
            throw new IllegalArgumentException();
        }
        d dVar = this.head;
        if (dVar == null) {
            this.head = e.a();
            d dVar2 = this.head;
            dVar2.f45279g = dVar2;
            dVar2.f45278f = dVar2;
            return dVar2;
        }
        d dVar3 = dVar.f45279g;
        return (dVar3.f45275c + i2 > 8192 || !dVar3.f45277e) ? dVar3.a(e.a()) : dVar3;
    }

    public final void write(Buffer buffer, long j) {
        d dVar;
        int i2;
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        } else if (buffer != this) {
            g.a(buffer.size, 0, j);
            while (j > 0) {
                int i3 = 0;
                if (j < ((long) (buffer.head.f45275c - buffer.head.f45274b))) {
                    d dVar2 = this.head;
                    d dVar3 = dVar2 != null ? dVar2.f45279g : null;
                    if (dVar3 != null && dVar3.f45277e) {
                        long j2 = ((long) dVar3.f45275c) + j;
                        if (dVar3.f45276d) {
                            i2 = 0;
                        } else {
                            i2 = dVar3.f45274b;
                        }
                        if (j2 - ((long) i2) <= 8192) {
                            buffer.head.a(dVar3, (int) j);
                            buffer.size -= j;
                            this.size += j;
                            return;
                        }
                    }
                    d dVar4 = buffer.head;
                    int i4 = (int) j;
                    if (i4 <= 0 || i4 > dVar4.f45275c - dVar4.f45274b) {
                        throw new IllegalArgumentException();
                    }
                    if (i4 >= 1024) {
                        dVar = dVar4.a();
                    } else {
                        dVar = e.a();
                        System.arraycopy(dVar4.f45273a, dVar4.f45274b, dVar.f45273a, 0, i4);
                    }
                    dVar.f45275c = dVar.f45274b + i4;
                    dVar4.f45274b += i4;
                    dVar4.f45279g.a(dVar);
                    buffer.head = dVar;
                }
                d dVar5 = buffer.head;
                long j3 = (long) (dVar5.f45275c - dVar5.f45274b);
                buffer.head = dVar5.c();
                d dVar6 = this.head;
                if (dVar6 == null) {
                    this.head = dVar5;
                    d dVar7 = this.head;
                    dVar7.f45279g = dVar7;
                    dVar7.f45278f = dVar7;
                } else {
                    d a2 = dVar6.f45279g.a(dVar5);
                    if (a2.f45279g == a2) {
                        throw new IllegalStateException();
                    } else if (a2.f45279g.f45277e) {
                        int i5 = a2.f45275c - a2.f45274b;
                        int i6 = 8192 - a2.f45279g.f45275c;
                        if (!a2.f45279g.f45276d) {
                            i3 = a2.f45279g.f45274b;
                        }
                        if (i5 <= i6 + i3) {
                            a2.a(a2.f45279g, i5);
                            a2.c();
                            e.a(a2);
                        }
                    }
                }
                buffer.size -= j3;
                this.size += j3;
                j -= j3;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }

    public final long read(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j >= 0) {
            long j2 = this.size;
            if (j2 == 0) {
                return -1;
            }
            if (j > j2) {
                j = j2;
            }
            buffer.write(this, j);
            return j;
        } else {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
    }

    public final long indexOf(byte b2) {
        return indexOf(b2, 0, Long.MAX_VALUE);
    }

    public final long indexOf(byte b2, long j) {
        return indexOf(b2, j, Long.MAX_VALUE);
    }

    public final long indexOf(byte b2, long j, long j2) {
        d dVar;
        long j3 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(this.size), Long.valueOf(j), Long.valueOf(j2)}));
        }
        long j4 = this.size;
        if (j2 <= j4) {
            j4 = j2;
        }
        if (j == j4 || (dVar = this.head) == null) {
            return -1;
        }
        long j5 = this.size;
        if (j5 - j >= j) {
            while (true) {
                j5 = j3;
                j3 = ((long) (dVar.f45275c - dVar.f45274b)) + j5;
                if (j3 >= j) {
                    break;
                }
                dVar = dVar.f45278f;
            }
        } else {
            while (j5 > j) {
                dVar = dVar.f45279g;
                j5 -= (long) (dVar.f45275c - dVar.f45274b);
            }
        }
        long j6 = j;
        while (j5 < j4) {
            byte[] bArr = dVar.f45273a;
            int min = (int) Math.min((long) dVar.f45275c, (((long) dVar.f45274b) + j4) - j5);
            for (int i2 = (int) ((((long) dVar.f45274b) + j6) - j5); i2 < min; i2++) {
                if (bArr[i2] == b2) {
                    return ((long) (i2 - dVar.f45274b)) + j5;
                }
            }
            byte b3 = b2;
            j6 = ((long) (dVar.f45275c - dVar.f45274b)) + j5;
            dVar = dVar.f45278f;
            j5 = j6;
        }
        return -1;
    }

    public final long indexOf(ByteString byteString) throws IOException {
        return indexOf(byteString, 0);
    }

    public final long indexOf(ByteString byteString, long j) throws IOException {
        byte[] bArr;
        d dVar;
        if (byteString.size() != 0) {
            long j2 = 0;
            if (j >= 0) {
                d dVar2 = this.head;
                long j3 = -1;
                if (dVar2 == null) {
                    return -1;
                }
                long j4 = this.size;
                if (j4 - j >= j) {
                    while (true) {
                        j4 = j2;
                        j2 = ((long) (dVar2.f45275c - dVar2.f45274b)) + j4;
                        if (j2 >= j) {
                            break;
                        }
                        dVar2 = dVar2.f45278f;
                    }
                } else {
                    while (j4 > j) {
                        dVar2 = dVar2.f45279g;
                        j4 -= (long) (dVar2.f45275c - dVar2.f45274b);
                    }
                }
                byte b2 = byteString.getByte(0);
                int size2 = byteString.size();
                long j5 = 1 + (this.size - ((long) size2));
                long j6 = j;
                d dVar3 = dVar2;
                long j7 = j4;
                while (j7 < j5) {
                    byte[] bArr2 = dVar3.f45273a;
                    int min = (int) Math.min((long) dVar3.f45275c, (((long) dVar3.f45274b) + j5) - j7);
                    int i2 = (int) ((((long) dVar3.f45274b) + j6) - j7);
                    while (i2 < min) {
                        if (bArr2[i2] == b2) {
                            bArr = bArr2;
                            dVar = dVar3;
                            if (rangeEquals(dVar3, i2 + 1, byteString, 1, size2)) {
                                return ((long) (i2 - dVar.f45274b)) + j7;
                            }
                        } else {
                            bArr = bArr2;
                            dVar = dVar3;
                        }
                        i2++;
                        dVar3 = dVar;
                        bArr2 = bArr;
                    }
                    d dVar4 = dVar3;
                    j6 = ((long) (dVar4.f45275c - dVar4.f45274b)) + j7;
                    dVar3 = dVar4.f45278f;
                    j3 = -1;
                    j7 = j6;
                }
                return j3;
            }
            throw new IllegalArgumentException("fromIndex < 0");
        }
        throw new IllegalArgumentException("bytes is empty");
    }

    public final long indexOfElement(ByteString byteString) {
        return indexOfElement(byteString, 0);
    }

    public final long indexOfElement(ByteString byteString, long j) {
        int i2;
        int i3;
        long j2 = 0;
        if (j >= 0) {
            d dVar = this.head;
            if (dVar == null) {
                return -1;
            }
            long j3 = this.size;
            if (j3 - j >= j) {
                while (true) {
                    j3 = j2;
                    j2 = ((long) (dVar.f45275c - dVar.f45274b)) + j3;
                    if (j2 >= j) {
                        break;
                    }
                    dVar = dVar.f45278f;
                }
            } else {
                while (j3 > j) {
                    dVar = dVar.f45279g;
                    j3 -= (long) (dVar.f45275c - dVar.f45274b);
                }
            }
            if (byteString.size() == 2) {
                byte b2 = byteString.getByte(0);
                byte b3 = byteString.getByte(1);
                while (j3 < this.size) {
                    byte[] bArr = dVar.f45273a;
                    i2 = (int) ((((long) dVar.f45274b) + j) - j3);
                    int i4 = dVar.f45275c;
                    while (i2 < i4) {
                        byte b4 = bArr[i2];
                        if (b4 == b2 || b4 == b3) {
                            i3 = dVar.f45274b;
                        } else {
                            i2++;
                        }
                    }
                    j = ((long) (dVar.f45275c - dVar.f45274b)) + j3;
                    dVar = dVar.f45278f;
                    j3 = j;
                }
                return -1;
            }
            byte[] internalArray = byteString.internalArray();
            while (j3 < this.size) {
                byte[] bArr2 = dVar.f45273a;
                int i5 = (int) ((((long) dVar.f45274b) + j) - j3);
                int i6 = dVar.f45275c;
                while (i2 < i6) {
                    byte b5 = bArr2[i2];
                    int length = internalArray.length;
                    int i7 = 0;
                    while (i7 < length) {
                        if (b5 == internalArray[i7]) {
                            i3 = dVar.f45274b;
                        } else {
                            i7++;
                        }
                    }
                    i5 = i2 + 1;
                }
                j = ((long) (dVar.f45275c - dVar.f45274b)) + j3;
                dVar = dVar.f45278f;
                j3 = j;
            }
            return -1;
            return ((long) (i2 - i3)) + j3;
        }
        throw new IllegalArgumentException("fromIndex < 0");
    }

    public final boolean rangeEquals(long j, ByteString byteString) {
        return rangeEquals(j, byteString, 0, byteString.size());
    }

    public final boolean rangeEquals(long j, ByteString byteString, int i2, int i3) {
        if (j < 0 || i2 < 0 || i3 < 0 || this.size - j < ((long) i3) || byteString.size() - i2 < i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (getByte(((long) i4) + j) != byteString.getByte(i2 + i4)) {
                return false;
            }
        }
        return true;
    }

    private boolean rangeEquals(d dVar, int i2, ByteString byteString, int i3, int i4) {
        int i5 = dVar.f45275c;
        byte[] bArr = dVar.f45273a;
        while (i3 < i4) {
            if (i2 == i5) {
                dVar = dVar.f45278f;
                byte[] bArr2 = dVar.f45273a;
                int i6 = dVar.f45274b;
                bArr = bArr2;
                i2 = i6;
                i5 = dVar.f45275c;
            }
            if (bArr[i2] != byteString.getByte(i3)) {
                return false;
            }
            i2++;
            i3++;
        }
        return true;
    }

    public final Timeout timeout() {
        return Timeout.NONE;
    }

    /* access modifiers changed from: package-private */
    public final List<Integer> segmentSizes() {
        if (this.head == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(this.head.f45275c - this.head.f45274b));
        d dVar = this.head;
        while (true) {
            dVar = dVar.f45278f;
            if (dVar == this.head) {
                return arrayList;
            }
            arrayList.add(Integer.valueOf(dVar.f45275c - dVar.f45274b));
        }
    }

    public final ByteString md5() {
        return digest("MD5");
    }

    public final ByteString sha1() {
        return digest("SHA-1");
    }

    public final ByteString sha256() {
        return digest("SHA-256");
    }

    public final ByteString sha512() {
        return digest("SHA-512");
    }

    private ByteString digest(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            if (this.head != null) {
                instance.update(this.head.f45273a, this.head.f45274b, this.head.f45275c - this.head.f45274b);
                d dVar = this.head;
                while (true) {
                    dVar = dVar.f45278f;
                    if (dVar == this.head) {
                        break;
                    }
                    instance.update(dVar.f45273a, dVar.f45274b, dVar.f45275c - dVar.f45274b);
                }
            }
            return ByteString.of(instance.digest());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    public final ByteString hmacSha1(ByteString byteString) {
        return hmac("HmacSHA1", byteString);
    }

    public final ByteString hmacSha256(ByteString byteString) {
        return hmac("HmacSHA256", byteString);
    }

    public final ByteString hmacSha512(ByteString byteString) {
        return hmac("HmacSHA512", byteString);
    }

    private ByteString hmac(String str, ByteString byteString) {
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(byteString.toByteArray(), str));
            if (this.head != null) {
                instance.update(this.head.f45273a, this.head.f45274b, this.head.f45275c - this.head.f45274b);
                d dVar = this.head;
                while (true) {
                    dVar = dVar.f45278f;
                    if (dVar == this.head) {
                        break;
                    }
                    instance.update(dVar.f45273a, dVar.f45274b, dVar.f45275c - dVar.f45274b);
                }
            }
            return ByteString.of(instance.doFinal());
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer = (Buffer) obj;
        long j = this.size;
        if (j != buffer.size) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        d dVar = this.head;
        d dVar2 = buffer.head;
        int i2 = dVar.f45274b;
        int i3 = dVar2.f45274b;
        while (j2 < this.size) {
            long min = (long) Math.min(dVar.f45275c - i2, dVar2.f45275c - i3);
            int i4 = i3;
            int i5 = i2;
            int i6 = 0;
            while (((long) i6) < min) {
                int i7 = i5 + 1;
                int i8 = i4 + 1;
                if (dVar.f45273a[i5] != dVar2.f45273a[i4]) {
                    return false;
                }
                i6++;
                i5 = i7;
                i4 = i8;
            }
            if (i5 == dVar.f45275c) {
                dVar = dVar.f45278f;
                i2 = dVar.f45274b;
            } else {
                i2 = i5;
            }
            if (i4 == dVar2.f45275c) {
                dVar2 = dVar2.f45278f;
                i3 = dVar2.f45274b;
            } else {
                i3 = i4;
            }
            j2 += min;
        }
        return true;
    }

    public final int hashCode() {
        d dVar = this.head;
        if (dVar == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i3 = dVar.f45275c;
            for (int i4 = dVar.f45274b; i4 < i3; i4++) {
                i2 = (i2 * 31) + dVar.f45273a[i4];
            }
            dVar = dVar.f45278f;
        } while (dVar != this.head);
        return i2;
    }

    public final String toString() {
        return snapshot().toString();
    }

    public final Buffer clone() {
        Buffer buffer = new Buffer();
        if (this.size == 0) {
            return buffer;
        }
        buffer.head = this.head.a();
        d dVar = buffer.head;
        dVar.f45279g = dVar;
        dVar.f45278f = dVar;
        d dVar2 = this.head;
        while (true) {
            dVar2 = dVar2.f45278f;
            if (dVar2 != this.head) {
                buffer.head.f45279g.a(dVar2.a());
            } else {
                buffer.size = this.size;
                return buffer;
            }
        }
    }

    public final ByteString snapshot() {
        long j = this.size;
        if (j <= 2147483647L) {
            return snapshot((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.size);
    }

    public final ByteString snapshot(int i2) {
        if (i2 == 0) {
            return ByteString.EMPTY;
        }
        return new f(this, i2);
    }

    public final UnsafeCursor readUnsafe() {
        return readUnsafe(new UnsafeCursor());
    }

    public final UnsafeCursor readUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer == null) {
            unsafeCursor.buffer = this;
            unsafeCursor.readWrite = false;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer");
    }

    public final UnsafeCursor readAndWriteUnsafe() {
        return readAndWriteUnsafe(new UnsafeCursor());
    }

    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer == null) {
            unsafeCursor.buffer = this;
            unsafeCursor.readWrite = true;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer");
    }

    public static final class UnsafeCursor implements Closeable {
        public Buffer buffer;
        public byte[] data;
        public int end = -1;
        public long offset = -1;
        public boolean readWrite;
        private d segment;
        public int start = -1;

        public final int next() {
            if (this.offset != this.buffer.size) {
                long j = this.offset;
                if (j == -1) {
                    return seek(0);
                }
                return seek(j + ((long) (this.end - this.start)));
            }
            throw new IllegalStateException();
        }

        public final int seek(long j) {
            d dVar;
            long j2;
            int i2 = (j > -1 ? 1 : (j == -1 ? 0 : -1));
            if (i2 < 0 || j > this.buffer.size) {
                throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", new Object[]{Long.valueOf(j), Long.valueOf(this.buffer.size)}));
            } else if (i2 == 0 || j == this.buffer.size) {
                this.segment = null;
                this.offset = j;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return -1;
            } else {
                long j3 = 0;
                long j4 = this.buffer.size;
                d dVar2 = this.buffer.head;
                d dVar3 = this.buffer.head;
                d dVar4 = this.segment;
                if (dVar4 != null) {
                    long j5 = this.offset - ((long) (this.start - dVar4.f45274b));
                    if (j5 > j) {
                        dVar3 = this.segment;
                        j4 = j5;
                    } else {
                        dVar2 = this.segment;
                        j3 = j5;
                    }
                }
                if (j4 - j > j - j3) {
                    while (j >= ((long) (dVar.f45275c - dVar.f45274b)) + j2) {
                        j3 = j2 + ((long) (dVar.f45275c - dVar.f45274b));
                        dVar2 = dVar.f45278f;
                    }
                } else {
                    j2 = j4;
                    dVar = dVar3;
                    while (j2 > j) {
                        dVar = dVar.f45279g;
                        j2 -= (long) (dVar.f45275c - dVar.f45274b);
                    }
                }
                if (this.readWrite && dVar.f45276d) {
                    d b2 = dVar.b();
                    if (this.buffer.head == dVar) {
                        this.buffer.head = b2;
                    }
                    dVar = dVar.a(b2);
                    dVar.f45279g.c();
                }
                this.segment = dVar;
                this.offset = j;
                this.data = dVar.f45273a;
                this.start = dVar.f45274b + ((int) (j - j2));
                this.end = dVar.f45275c;
                return this.end - this.start;
            }
        }

        public final long resizeBuffer(long j) {
            Buffer buffer2 = this.buffer;
            if (buffer2 == null) {
                throw new IllegalStateException("not attached to a buffer");
            } else if (this.readWrite) {
                long j2 = buffer2.size;
                int i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                if (i2 <= 0) {
                    if (j >= 0) {
                        long j3 = j2 - j;
                        while (true) {
                            if (j3 <= 0) {
                                break;
                            }
                            d dVar = this.buffer.head.f45279g;
                            long j4 = (long) (dVar.f45275c - dVar.f45274b);
                            if (j4 > j3) {
                                dVar.f45275c = (int) (((long) dVar.f45275c) - j3);
                                break;
                            }
                            this.buffer.head = dVar.c();
                            e.a(dVar);
                            j3 -= j4;
                        }
                        this.segment = null;
                        this.offset = j;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                    } else {
                        throw new IllegalArgumentException("newSize < 0: ".concat(String.valueOf(j)));
                    }
                } else if (i2 > 0) {
                    long j5 = j - j2;
                    boolean z = true;
                    while (j5 > 0) {
                        d writableSegment = this.buffer.writableSegment(1);
                        int min = (int) Math.min(j5, (long) (8192 - writableSegment.f45275c));
                        writableSegment.f45275c += min;
                        j5 -= (long) min;
                        if (z) {
                            this.segment = writableSegment;
                            this.offset = j2;
                            this.data = writableSegment.f45273a;
                            this.start = writableSegment.f45275c - min;
                            this.end = writableSegment.f45275c;
                            z = false;
                        }
                    }
                }
                this.buffer.size = j;
                return j2;
            } else {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers");
            }
        }

        public final long expandBuffer(int i2) {
            if (i2 <= 0) {
                throw new IllegalArgumentException("minByteCount <= 0: ".concat(String.valueOf(i2)));
            } else if (i2 <= 8192) {
                Buffer buffer2 = this.buffer;
                if (buffer2 == null) {
                    throw new IllegalStateException("not attached to a buffer");
                } else if (this.readWrite) {
                    long j = buffer2.size;
                    d writableSegment = this.buffer.writableSegment(i2);
                    int i3 = 8192 - writableSegment.f45275c;
                    writableSegment.f45275c = FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE;
                    long j2 = (long) i3;
                    this.buffer.size = j + j2;
                    this.segment = writableSegment;
                    this.offset = j;
                    this.data = writableSegment.f45273a;
                    this.start = 8192 - i3;
                    this.end = FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE;
                    return j2;
                } else {
                    throw new IllegalStateException("expandBuffer() only permitted for read/write buffers");
                }
            } else {
                throw new IllegalArgumentException("minByteCount > Segment.SIZE: ".concat(String.valueOf(i2)));
            }
        }

        public final void close() {
            if (this.buffer != null) {
                this.buffer = null;
                this.segment = null;
                this.offset = -1;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer");
        }
    }
}
