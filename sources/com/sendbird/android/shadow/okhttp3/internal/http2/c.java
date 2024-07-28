package com.sendbird.android.shadow.okhttp3.internal.http2;

import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import com.sendbird.android.shadow.okhttp3.internal.Util;
import com.sendbird.android.shadow.okhttp3.internal.http2.a;
import com.sendbird.android.shadow.okio.Buffer;
import com.sendbird.android.shadow.okio.BufferedSink;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

final class c implements Closeable {

    /* renamed from: c  reason: collision with root package name */
    private static final Logger f45175c = Logger.getLogger(Http2.class.getName());

    /* renamed from: a  reason: collision with root package name */
    int f45176a = 16384;

    /* renamed from: b  reason: collision with root package name */
    final a.b f45177b = new a.b(this.f45180f);

    /* renamed from: d  reason: collision with root package name */
    private final BufferedSink f45178d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f45179e;

    /* renamed from: f  reason: collision with root package name */
    private final Buffer f45180f = new Buffer();

    /* renamed from: g  reason: collision with root package name */
    private boolean f45181g;

    c(BufferedSink bufferedSink, boolean z) {
        this.f45178d = bufferedSink;
        this.f45179e = z;
    }

    public final synchronized void a() throws IOException {
        if (this.f45181g) {
            throw new IOException("closed");
        } else if (this.f45179e) {
            if (f45175c.isLoggable(Level.FINE)) {
                f45175c.fine(Util.format(">> CONNECTION %s", Http2.CONNECTION_PREFACE.hex()));
            }
            this.f45178d.write(Http2.CONNECTION_PREFACE.toByteArray());
            this.f45178d.flush();
        }
    }

    public final synchronized void a(Settings settings) throws IOException {
        if (!this.f45181g) {
            this.f45176a = settings.getMaxFrameSize(this.f45176a);
            if (settings.getHeaderTableSize() != -1) {
                this.f45177b.a(settings.getHeaderTableSize());
            }
            a(0, 0, (byte) 4, (byte) 1);
            this.f45178d.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void a(int i2, int i3, List<Header> list) throws IOException {
        if (!this.f45181g) {
            this.f45177b.a(list);
            long size = this.f45180f.size();
            int min = (int) Math.min((long) (this.f45176a - 4), size);
            long j = (long) min;
            int i4 = (size > j ? 1 : (size == j ? 0 : -1));
            a(i2, min + 4, (byte) 5, i4 == 0 ? (byte) 4 : 0);
            this.f45178d.writeInt(i3 & Integer.MAX_VALUE);
            this.f45178d.write(this.f45180f, j);
            if (i4 > 0) {
                b(i2, size - j);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void b() throws IOException {
        if (!this.f45181g) {
            this.f45178d.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void a(boolean z, int i2, List<Header> list) throws IOException {
        if (!this.f45181g) {
            c(z, i2, list);
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void b(boolean z, int i2, List<Header> list) throws IOException {
        if (!this.f45181g) {
            c(z, i2, list);
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void a(int i2, ErrorCode errorCode) throws IOException {
        if (this.f45181g) {
            throw new IOException("closed");
        } else if (errorCode.httpCode != -1) {
            a(i2, 4, (byte) 3, (byte) 0);
            this.f45178d.writeInt(errorCode.httpCode);
            this.f45178d.flush();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public final synchronized void a(boolean z, int i2, Buffer buffer, int i3) throws IOException {
        if (!this.f45181g) {
            a(i2, i3, (byte) 0, z ? (byte) 1 : 0);
            if (i3 > 0) {
                this.f45178d.write(buffer, (long) i3);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void b(Settings settings) throws IOException {
        if (!this.f45181g) {
            int i2 = 0;
            a(0, settings.size() * 6, (byte) 4, (byte) 0);
            while (i2 < 10) {
                if (settings.isSet(i2)) {
                    this.f45178d.writeShort(i2 == 4 ? 3 : i2 == 7 ? 4 : i2);
                    this.f45178d.writeInt(settings.get(i2));
                }
                i2++;
            }
            this.f45178d.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void a(boolean z, int i2, int i3) throws IOException {
        if (!this.f45181g) {
            a(0, 8, (byte) 6, z ? (byte) 1 : 0);
            this.f45178d.writeInt(i2);
            this.f45178d.writeInt(i3);
            this.f45178d.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void a(int i2, ErrorCode errorCode, byte[] bArr) throws IOException {
        if (this.f45181g) {
            throw new IOException("closed");
        } else if (errorCode.httpCode != -1) {
            a(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.f45178d.writeInt(i2);
            this.f45178d.writeInt(errorCode.httpCode);
            if (bArr.length > 0) {
                this.f45178d.write(bArr);
            }
            this.f45178d.flush();
        } else {
            throw Http2.illegalArgument("errorCode.httpCode == -1", new Object[0]);
        }
    }

    public final synchronized void a(int i2, long j) throws IOException {
        if (this.f45181g) {
            throw new IOException("closed");
        } else if (j == 0 || j > 2147483647L) {
            throw Http2.illegalArgument("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
        } else {
            a(i2, 4, (byte) 8, (byte) 0);
            this.f45178d.writeInt((int) j);
            this.f45178d.flush();
        }
    }

    private void a(int i2, int i3, byte b2, byte b3) throws IOException {
        if (f45175c.isLoggable(Level.FINE)) {
            f45175c.fine(Http2.frameLog(false, i2, i3, b2, b3));
        }
        int i4 = this.f45176a;
        if (i3 > i4) {
            throw Http2.illegalArgument("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i4), Integer.valueOf(i3));
        } else if ((Integer.MIN_VALUE & i2) == 0) {
            a(this.f45178d, i3);
            this.f45178d.writeByte(b2 & 255);
            this.f45178d.writeByte(b3 & 255);
            this.f45178d.writeInt(i2 & Integer.MAX_VALUE);
        } else {
            throw Http2.illegalArgument("reserved bit set: %s", Integer.valueOf(i2));
        }
    }

    public final synchronized void close() throws IOException {
        this.f45181g = true;
        this.f45178d.close();
    }

    private static void a(BufferedSink bufferedSink, int i2) throws IOException {
        bufferedSink.writeByte((i2 >>> 16) & PriceRangeSeekBar.INVALID_POINTER_ID);
        bufferedSink.writeByte((i2 >>> 8) & PriceRangeSeekBar.INVALID_POINTER_ID);
        bufferedSink.writeByte(i2 & PriceRangeSeekBar.INVALID_POINTER_ID);
    }

    private void b(int i2, long j) throws IOException {
        while (j > 0) {
            int min = (int) Math.min((long) this.f45176a, j);
            long j2 = (long) min;
            j -= j2;
            a(i2, min, (byte) 9, j == 0 ? (byte) 4 : 0);
            this.f45178d.write(this.f45180f, j2);
        }
    }

    private void c(boolean z, int i2, List<Header> list) throws IOException {
        if (!this.f45181g) {
            this.f45177b.a(list);
            long size = this.f45180f.size();
            int min = (int) Math.min((long) this.f45176a, size);
            long j = (long) min;
            int i3 = (size > j ? 1 : (size == j ? 0 : -1));
            byte b2 = i3 == 0 ? (byte) 4 : 0;
            if (z) {
                b2 = (byte) (b2 | 1);
            }
            a(i2, min, (byte) 1, b2);
            this.f45178d.write(this.f45180f, j);
            if (i3 > 0) {
                b(i2, size - j);
                return;
            }
            return;
        }
        throw new IOException("closed");
    }
}
