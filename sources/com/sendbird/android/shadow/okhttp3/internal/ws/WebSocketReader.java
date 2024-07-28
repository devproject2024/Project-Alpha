package com.sendbird.android.shadow.okhttp3.internal.ws;

import com.sendbird.android.shadow.okio.Buffer;
import com.sendbird.android.shadow.okio.BufferedSource;
import com.sendbird.android.shadow.okio.ByteString;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

final class WebSocketReader {

    /* renamed from: a  reason: collision with root package name */
    final boolean f45225a;

    /* renamed from: b  reason: collision with root package name */
    final BufferedSource f45226b;

    /* renamed from: c  reason: collision with root package name */
    final FrameCallback f45227c;

    /* renamed from: d  reason: collision with root package name */
    boolean f45228d;

    /* renamed from: e  reason: collision with root package name */
    int f45229e;

    /* renamed from: f  reason: collision with root package name */
    long f45230f;

    /* renamed from: g  reason: collision with root package name */
    boolean f45231g;

    /* renamed from: h  reason: collision with root package name */
    boolean f45232h;

    /* renamed from: i  reason: collision with root package name */
    private final Buffer f45233i = new Buffer();
    private final Buffer j = new Buffer();
    private final byte[] k;
    private final Buffer.UnsafeCursor l;

    public interface FrameCallback {
        void onReadClose(int i2, String str);

        void onReadMessage(ByteString byteString) throws IOException;

        void onReadMessage(String str) throws IOException;

        void onReadPing(ByteString byteString);

        void onReadPong(ByteString byteString);
    }

    WebSocketReader(boolean z, BufferedSource bufferedSource, FrameCallback frameCallback) {
        if (bufferedSource != null) {
            this.f45225a = z;
            this.f45226b = bufferedSource;
            this.f45227c = frameCallback;
            Buffer.UnsafeCursor unsafeCursor = null;
            this.k = z ? null : new byte[4];
            this.l = !z ? new Buffer.UnsafeCursor() : unsafeCursor;
            return;
        }
        throw new NullPointerException("source == null");
    }

    /* access modifiers changed from: package-private */
    public final void a() throws IOException {
        b();
        if (this.f45232h) {
            c();
        } else {
            d();
        }
    }

    /* JADX INFO: finally extract failed */
    private void b() throws IOException {
        if (!this.f45228d) {
            long timeoutNanos = this.f45226b.timeout().timeoutNanos();
            this.f45226b.timeout().clearTimeout();
            try {
                byte readByte = this.f45226b.readByte() & 255;
                this.f45226b.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                this.f45229e = readByte & 15;
                boolean z = true;
                this.f45231g = (readByte & 128) != 0;
                this.f45232h = (readByte & 8) != 0;
                if (!this.f45232h || this.f45231g) {
                    boolean z2 = (readByte & 64) != 0;
                    boolean z3 = (readByte & 32) != 0;
                    boolean z4 = (readByte & 16) != 0;
                    if (z2 || z3 || z4) {
                        throw new ProtocolException("Reserved flags are unsupported.");
                    }
                    byte readByte2 = this.f45226b.readByte() & 255;
                    if ((readByte2 & 128) == 0) {
                        z = false;
                    }
                    boolean z5 = this.f45225a;
                    if (z == z5) {
                        throw new ProtocolException(z5 ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
                    }
                    this.f45230f = (long) (readByte2 & Byte.MAX_VALUE);
                    long j2 = this.f45230f;
                    if (j2 == 126) {
                        this.f45230f = ((long) this.f45226b.readShort()) & 65535;
                    } else if (j2 == 127) {
                        this.f45230f = this.f45226b.readLong();
                        if (this.f45230f < 0) {
                            throw new ProtocolException("Frame length 0x" + Long.toHexString(this.f45230f) + " > 0x7FFFFFFFFFFFFFFF");
                        }
                    }
                    if (this.f45232h && this.f45230f > 125) {
                        throw new ProtocolException("Control frame must be less than 125B.");
                    } else if (z) {
                        this.f45226b.readFully(this.k);
                    }
                } else {
                    throw new ProtocolException("Control frames must be final.");
                }
            } catch (Throwable th) {
                this.f45226b.timeout().timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                throw th;
            }
        } else {
            throw new IOException("closed");
        }
    }

    private void c() throws IOException {
        String str;
        long j2 = this.f45230f;
        if (j2 > 0) {
            this.f45226b.readFully(this.f45233i, j2);
            if (!this.f45225a) {
                this.f45233i.readAndWriteUnsafe(this.l);
                this.l.seek(0);
                WebSocketProtocol.toggleMask(this.l, this.k);
                this.l.close();
            }
        }
        switch (this.f45229e) {
            case 8:
                short s = 1005;
                long size = this.f45233i.size();
                if (size != 1) {
                    if (size != 0) {
                        s = this.f45233i.readShort();
                        str = this.f45233i.readUtf8();
                        String closeCodeExceptionMessage = WebSocketProtocol.closeCodeExceptionMessage(s);
                        if (closeCodeExceptionMessage != null) {
                            throw new ProtocolException(closeCodeExceptionMessage);
                        }
                    } else {
                        str = "";
                    }
                    this.f45227c.onReadClose(s, str);
                    this.f45228d = true;
                    return;
                }
                throw new ProtocolException("Malformed close payload length of 1.");
            case 9:
                this.f45227c.onReadPing(this.f45233i.readByteString());
                return;
            case 10:
                this.f45227c.onReadPong(this.f45233i.readByteString());
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.f45229e));
        }
    }

    private void d() throws IOException {
        int i2 = this.f45229e;
        if (i2 == 1 || i2 == 2) {
            f();
            if (i2 == 1) {
                this.f45227c.onReadMessage(this.j.readUtf8());
            } else {
                this.f45227c.onReadMessage(this.j.readByteString());
            }
        } else {
            throw new ProtocolException("Unknown opcode: " + Integer.toHexString(i2));
        }
    }

    private void e() throws IOException {
        while (!this.f45228d) {
            b();
            if (this.f45232h) {
                c();
            } else {
                return;
            }
        }
    }

    private void f() throws IOException {
        while (!this.f45228d) {
            long j2 = this.f45230f;
            if (j2 > 0) {
                this.f45226b.readFully(this.j, j2);
                if (!this.f45225a) {
                    this.j.readAndWriteUnsafe(this.l);
                    this.l.seek(this.j.size() - this.f45230f);
                    WebSocketProtocol.toggleMask(this.l, this.k);
                    this.l.close();
                }
            }
            if (!this.f45231g) {
                e();
                if (this.f45229e != 0) {
                    throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.f45229e));
                }
            } else {
                return;
            }
        }
        throw new IOException("closed");
    }
}
