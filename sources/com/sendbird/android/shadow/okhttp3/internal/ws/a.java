package com.sendbird.android.shadow.okhttp3.internal.ws;

import com.sendbird.android.shadow.okio.Buffer;
import com.sendbird.android.shadow.okio.BufferedSink;
import com.sendbird.android.shadow.okio.ByteString;
import com.sendbird.android.shadow.okio.Sink;
import com.sendbird.android.shadow.okio.Timeout;
import java.io.IOException;
import java.util.Random;

final class a {

    /* renamed from: a  reason: collision with root package name */
    final boolean f45234a;

    /* renamed from: b  reason: collision with root package name */
    final Random f45235b;

    /* renamed from: c  reason: collision with root package name */
    final BufferedSink f45236c;

    /* renamed from: d  reason: collision with root package name */
    final Buffer f45237d;

    /* renamed from: e  reason: collision with root package name */
    boolean f45238e;

    /* renamed from: f  reason: collision with root package name */
    final Buffer f45239f = new Buffer();

    /* renamed from: g  reason: collision with root package name */
    final C0761a f45240g = new C0761a();

    /* renamed from: h  reason: collision with root package name */
    boolean f45241h;

    /* renamed from: i  reason: collision with root package name */
    private final byte[] f45242i;
    private final Buffer.UnsafeCursor j;

    a(boolean z, BufferedSink bufferedSink, Random random) {
        if (bufferedSink == null) {
            throw new NullPointerException("sink == null");
        } else if (random != null) {
            this.f45234a = z;
            this.f45236c = bufferedSink;
            this.f45237d = bufferedSink.buffer();
            this.f45235b = random;
            Buffer.UnsafeCursor unsafeCursor = null;
            this.f45242i = z ? new byte[4] : null;
            this.j = z ? new Buffer.UnsafeCursor() : unsafeCursor;
        } else {
            throw new NullPointerException("random == null");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, ByteString byteString) throws IOException {
        if (!this.f45238e) {
            int size = byteString.size();
            if (((long) size) <= 125) {
                this.f45237d.writeByte(i2 | 128);
                if (this.f45234a) {
                    this.f45237d.writeByte(size | 128);
                    this.f45235b.nextBytes(this.f45242i);
                    this.f45237d.write(this.f45242i);
                    if (size > 0) {
                        long size2 = this.f45237d.size();
                        this.f45237d.write(byteString);
                        this.f45237d.readAndWriteUnsafe(this.j);
                        this.j.seek(size2);
                        WebSocketProtocol.toggleMask(this.j, this.f45242i);
                        this.j.close();
                    }
                } else {
                    this.f45237d.writeByte(size);
                    this.f45237d.write(byteString);
                }
                this.f45236c.flush();
                return;
            }
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        throw new IOException("closed");
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, long j2, boolean z, boolean z2) throws IOException {
        if (!this.f45238e) {
            int i3 = 0;
            if (!z) {
                i2 = 0;
            }
            if (z2) {
                i2 |= 128;
            }
            this.f45237d.writeByte(i2);
            if (this.f45234a) {
                i3 = 128;
            }
            if (j2 <= 125) {
                this.f45237d.writeByte(((int) j2) | i3);
            } else if (j2 <= 65535) {
                this.f45237d.writeByte(i3 | 126);
                this.f45237d.writeShort((int) j2);
            } else {
                this.f45237d.writeByte(i3 | 127);
                this.f45237d.writeLong(j2);
            }
            if (this.f45234a) {
                this.f45235b.nextBytes(this.f45242i);
                this.f45237d.write(this.f45242i);
                if (j2 > 0) {
                    long size = this.f45237d.size();
                    this.f45237d.write(this.f45239f, j2);
                    this.f45237d.readAndWriteUnsafe(this.j);
                    this.j.seek(size);
                    WebSocketProtocol.toggleMask(this.j, this.f45242i);
                    this.j.close();
                }
            } else {
                this.f45237d.write(this.f45239f, j2);
            }
            this.f45236c.emit();
            return;
        }
        throw new IOException("closed");
    }

    /* renamed from: com.sendbird.android.shadow.okhttp3.internal.ws.a$a  reason: collision with other inner class name */
    final class C0761a implements Sink {

        /* renamed from: a  reason: collision with root package name */
        int f45243a;

        /* renamed from: b  reason: collision with root package name */
        long f45244b;

        /* renamed from: c  reason: collision with root package name */
        boolean f45245c;

        /* renamed from: d  reason: collision with root package name */
        boolean f45246d;

        C0761a() {
        }

        public final void write(Buffer buffer, long j) throws IOException {
            if (!this.f45246d) {
                a.this.f45239f.write(buffer, j);
                boolean z = this.f45245c && this.f45244b != -1 && a.this.f45239f.size() > this.f45244b - 8192;
                long completeSegmentByteCount = a.this.f45239f.completeSegmentByteCount();
                if (completeSegmentByteCount > 0 && !z) {
                    a.this.a(this.f45243a, completeSegmentByteCount, this.f45245c, false);
                    this.f45245c = false;
                    return;
                }
                return;
            }
            throw new IOException("closed");
        }

        public final void flush() throws IOException {
            if (!this.f45246d) {
                a aVar = a.this;
                aVar.a(this.f45243a, aVar.f45239f.size(), this.f45245c, false);
                this.f45245c = false;
                return;
            }
            throw new IOException("closed");
        }

        public final Timeout timeout() {
            return a.this.f45236c.timeout();
        }

        public final void close() throws IOException {
            if (!this.f45246d) {
                a aVar = a.this;
                aVar.a(this.f45243a, aVar.f45239f.size(), this.f45245c, true);
                this.f45246d = true;
                a.this.f45241h = false;
                return;
            }
            throw new IOException("closed");
        }
    }
}
