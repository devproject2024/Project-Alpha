package com.sendbird.android.shadow.okhttp3.internal.http2;

import com.sendbird.android.shadow.okhttp3.internal.http2.a;
import com.sendbird.android.shadow.okio.Buffer;
import com.sendbird.android.shadow.okio.BufferedSource;
import com.sendbird.android.shadow.okio.ByteString;
import com.sendbird.android.shadow.okio.Source;
import com.sendbird.android.shadow.okio.Timeout;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

final class b implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    static final Logger f45164a = Logger.getLogger(Http2.class.getName());

    /* renamed from: b  reason: collision with root package name */
    final BufferedSource f45165b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f45166c;

    /* renamed from: d  reason: collision with root package name */
    final a.C0758a f45167d = new a.C0758a(this.f45168e);

    /* renamed from: e  reason: collision with root package name */
    private final a f45168e = new a(this.f45165b);

    /* renamed from: com.sendbird.android.shadow.okhttp3.internal.http2.b$b  reason: collision with other inner class name */
    interface C0759b {
        void a(int i2, long j);

        void a(int i2, ErrorCode errorCode);

        void a(int i2, ByteString byteString);

        void a(int i2, List<Header> list) throws IOException;

        void a(Settings settings);

        void a(boolean z, int i2, int i3);

        void a(boolean z, int i2, BufferedSource bufferedSource, int i3) throws IOException;

        void a(boolean z, int i2, List<Header> list);
    }

    b(BufferedSource bufferedSource, boolean z) {
        this.f45165b = bufferedSource;
        this.f45166c = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: short} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: short} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: short} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v24, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v25, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(boolean r11, com.sendbird.android.shadow.okhttp3.internal.http2.b.C0759b r12) throws java.io.IOException {
        /*
            r10 = this;
            r0 = 0
            com.sendbird.android.shadow.okio.BufferedSource r1 = r10.f45165b     // Catch:{ IOException -> 0x02bf }
            r2 = 9
            r1.require(r2)     // Catch:{ IOException -> 0x02bf }
            com.sendbird.android.shadow.okio.BufferedSource r1 = r10.f45165b
            int r1 = a(r1)
            r2 = 1
            if (r1 < 0) goto L_0x02b0
            r3 = 16384(0x4000, float:2.2959E-41)
            if (r1 > r3) goto L_0x02b0
            com.sendbird.android.shadow.okio.BufferedSource r4 = r10.f45165b
            byte r4 = r4.readByte()
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r4
            r5 = 4
            if (r11 == 0) goto L_0x0033
            if (r4 != r5) goto L_0x0024
            goto L_0x0033
        L_0x0024:
            java.lang.Object[] r11 = new java.lang.Object[r2]
            java.lang.Byte r12 = java.lang.Byte.valueOf(r4)
            r11[r0] = r12
            java.lang.String r12 = "Expected a SETTINGS frame but was %s"
            java.io.IOException r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.ioException(r12, r11)
            throw r11
        L_0x0033:
            com.sendbird.android.shadow.okio.BufferedSource r11 = r10.f45165b
            byte r11 = r11.readByte()
            r11 = r11 & 255(0xff, float:3.57E-43)
            byte r11 = (byte) r11
            com.sendbird.android.shadow.okio.BufferedSource r6 = r10.f45165b
            int r6 = r6.readInt()
            r7 = 2147483647(0x7fffffff, float:NaN)
            r6 = r6 & r7
            java.util.logging.Logger r8 = f45164a
            java.util.logging.Level r9 = java.util.logging.Level.FINE
            boolean r8 = r8.isLoggable(r9)
            if (r8 == 0) goto L_0x0059
            java.util.logging.Logger r8 = f45164a
            java.lang.String r9 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.frameLog(r2, r6, r1, r4, r11)
            r8.fine(r9)
        L_0x0059:
            r8 = 5
            r9 = 8
            switch(r4) {
                case 0: goto L_0x026e;
                case 1: goto L_0x023a;
                case 2: goto L_0x0219;
                case 3: goto L_0x01dd;
                case 4: goto L_0x014b;
                case 5: goto L_0x011d;
                case 6: goto L_0x00ec;
                case 7: goto L_0x009e;
                case 8: goto L_0x0067;
                default: goto L_0x005f;
            }
        L_0x005f:
            com.sendbird.android.shadow.okio.BufferedSource r11 = r10.f45165b
            long r0 = (long) r1
            r11.skip(r0)
            goto L_0x02af
        L_0x0067:
            if (r1 != r5) goto L_0x008f
            com.sendbird.android.shadow.okio.BufferedSource r11 = r10.f45165b
            int r11 = r11.readInt()
            long r3 = (long) r11
            r7 = 2147483647(0x7fffffff, double:1.060997895E-314)
            long r3 = r3 & r7
            r7 = 0
            int r11 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r11 == 0) goto L_0x007f
            r12.a((int) r6, (long) r3)
            goto L_0x02af
        L_0x007f:
            java.lang.Object[] r11 = new java.lang.Object[r2]
            java.lang.Long r12 = java.lang.Long.valueOf(r3)
            r11[r0] = r12
            java.lang.String r12 = "windowSizeIncrement was 0"
            java.io.IOException r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.ioException(r12, r11)
            throw r11
        L_0x008f:
            java.lang.Object[] r11 = new java.lang.Object[r2]
            java.lang.Integer r12 = java.lang.Integer.valueOf(r1)
            r11[r0] = r12
            java.lang.String r12 = "TYPE_WINDOW_UPDATE length !=4: %s"
            java.io.IOException r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.ioException(r12, r11)
            throw r11
        L_0x009e:
            if (r1 < r9) goto L_0x00dd
            if (r6 != 0) goto L_0x00d4
            com.sendbird.android.shadow.okio.BufferedSource r11 = r10.f45165b
            int r11 = r11.readInt()
            com.sendbird.android.shadow.okio.BufferedSource r3 = r10.f45165b
            int r3 = r3.readInt()
            int r1 = r1 - r9
            com.sendbird.android.shadow.okhttp3.internal.http2.ErrorCode r4 = com.sendbird.android.shadow.okhttp3.internal.http2.ErrorCode.fromHttp2(r3)
            if (r4 == 0) goto L_0x00c5
            com.sendbird.android.shadow.okio.ByteString r0 = com.sendbird.android.shadow.okio.ByteString.EMPTY
            if (r1 <= 0) goto L_0x00c0
            com.sendbird.android.shadow.okio.BufferedSource r0 = r10.f45165b
            long r3 = (long) r1
            com.sendbird.android.shadow.okio.ByteString r0 = r0.readByteString(r3)
        L_0x00c0:
            r12.a((int) r11, (com.sendbird.android.shadow.okio.ByteString) r0)
            goto L_0x02af
        L_0x00c5:
            java.lang.Object[] r11 = new java.lang.Object[r2]
            java.lang.Integer r12 = java.lang.Integer.valueOf(r3)
            r11[r0] = r12
            java.lang.String r12 = "TYPE_GOAWAY unexpected error code: %d"
            java.io.IOException r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.ioException(r12, r11)
            throw r11
        L_0x00d4:
            java.lang.Object[] r11 = new java.lang.Object[r0]
            java.lang.String r12 = "TYPE_GOAWAY streamId != 0"
            java.io.IOException r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.ioException(r12, r11)
            throw r11
        L_0x00dd:
            java.lang.Object[] r11 = new java.lang.Object[r2]
            java.lang.Integer r12 = java.lang.Integer.valueOf(r1)
            r11[r0] = r12
            java.lang.String r12 = "TYPE_GOAWAY length < 8: %s"
            java.io.IOException r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.ioException(r12, r11)
            throw r11
        L_0x00ec:
            if (r1 != r9) goto L_0x010e
            if (r6 != 0) goto L_0x0105
            com.sendbird.android.shadow.okio.BufferedSource r1 = r10.f45165b
            int r1 = r1.readInt()
            com.sendbird.android.shadow.okio.BufferedSource r3 = r10.f45165b
            int r3 = r3.readInt()
            r11 = r11 & r2
            if (r11 == 0) goto L_0x0100
            r0 = 1
        L_0x0100:
            r12.a((boolean) r0, (int) r1, (int) r3)
            goto L_0x02af
        L_0x0105:
            java.lang.Object[] r11 = new java.lang.Object[r0]
            java.lang.String r12 = "TYPE_PING streamId != 0"
            java.io.IOException r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.ioException(r12, r11)
            throw r11
        L_0x010e:
            java.lang.Object[] r11 = new java.lang.Object[r2]
            java.lang.Integer r12 = java.lang.Integer.valueOf(r1)
            r11[r0] = r12
            java.lang.String r12 = "TYPE_PING length != 8: %s"
            java.io.IOException r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.ioException(r12, r11)
            throw r11
        L_0x011d:
            if (r6 == 0) goto L_0x0142
            r3 = r11 & 8
            if (r3 == 0) goto L_0x012c
            com.sendbird.android.shadow.okio.BufferedSource r0 = r10.f45165b
            byte r0 = r0.readByte()
            r0 = r0 & 255(0xff, float:3.57E-43)
            short r0 = (short) r0
        L_0x012c:
            com.sendbird.android.shadow.okio.BufferedSource r3 = r10.f45165b
            int r3 = r3.readInt()
            r3 = r3 & r7
            int r1 = r1 + -4
            int r1 = a(r1, r11, r0)
            java.util.List r11 = r10.a(r1, r0, r11, r6)
            r12.a((int) r3, (java.util.List<com.sendbird.android.shadow.okhttp3.internal.http2.Header>) r11)
            goto L_0x02af
        L_0x0142:
            java.lang.Object[] r11 = new java.lang.Object[r0]
            java.lang.String r12 = "PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0"
            java.io.IOException r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.ioException(r12, r11)
            throw r11
        L_0x014b:
            if (r6 != 0) goto L_0x01d4
            r11 = r11 & r2
            if (r11 == 0) goto L_0x015d
            if (r1 != 0) goto L_0x0154
            goto L_0x02af
        L_0x0154:
            java.lang.Object[] r11 = new java.lang.Object[r0]
            java.lang.String r12 = "FRAME_SIZE_ERROR ack frame should be empty!"
            java.io.IOException r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.ioException(r12, r11)
            throw r11
        L_0x015d:
            int r11 = r1 % 6
            if (r11 != 0) goto L_0x01c5
            com.sendbird.android.shadow.okhttp3.internal.http2.Settings r11 = new com.sendbird.android.shadow.okhttp3.internal.http2.Settings
            r11.<init>()
            r4 = 0
        L_0x0167:
            if (r4 >= r1) goto L_0x01c0
            com.sendbird.android.shadow.okio.BufferedSource r6 = r10.f45165b
            short r6 = r6.readShort()
            r7 = 65535(0xffff, float:9.1834E-41)
            r6 = r6 & r7
            com.sendbird.android.shadow.okio.BufferedSource r7 = r10.f45165b
            int r7 = r7.readInt()
            if (r6 == r2) goto L_0x01ba
            r9 = 2
            if (r6 == r9) goto L_0x01ac
            r9 = 3
            if (r6 == r9) goto L_0x01aa
            if (r6 == r5) goto L_0x019d
            if (r6 == r8) goto L_0x0186
            goto L_0x01ba
        L_0x0186:
            if (r7 < r3) goto L_0x018e
            r9 = 16777215(0xffffff, float:2.3509886E-38)
            if (r7 > r9) goto L_0x018e
            goto L_0x01ba
        L_0x018e:
            java.lang.Object[] r11 = new java.lang.Object[r2]
            java.lang.Integer r12 = java.lang.Integer.valueOf(r7)
            r11[r0] = r12
            java.lang.String r12 = "PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s"
            java.io.IOException r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.ioException(r12, r11)
            throw r11
        L_0x019d:
            r6 = 7
            if (r7 < 0) goto L_0x01a1
            goto L_0x01ba
        L_0x01a1:
            java.lang.Object[] r11 = new java.lang.Object[r0]
            java.lang.String r12 = "PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1"
            java.io.IOException r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.ioException(r12, r11)
            throw r11
        L_0x01aa:
            r6 = 4
            goto L_0x01ba
        L_0x01ac:
            if (r7 == 0) goto L_0x01ba
            if (r7 != r2) goto L_0x01b1
            goto L_0x01ba
        L_0x01b1:
            java.lang.Object[] r11 = new java.lang.Object[r0]
            java.lang.String r12 = "PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1"
            java.io.IOException r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.ioException(r12, r11)
            throw r11
        L_0x01ba:
            r11.set(r6, r7)
            int r4 = r4 + 6
            goto L_0x0167
        L_0x01c0:
            r12.a(r11)
            goto L_0x02af
        L_0x01c5:
            java.lang.Object[] r11 = new java.lang.Object[r2]
            java.lang.Integer r12 = java.lang.Integer.valueOf(r1)
            r11[r0] = r12
            java.lang.String r12 = "TYPE_SETTINGS length %% 6 != 0: %s"
            java.io.IOException r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.ioException(r12, r11)
            throw r11
        L_0x01d4:
            java.lang.Object[] r11 = new java.lang.Object[r0]
            java.lang.String r12 = "TYPE_SETTINGS streamId != 0"
            java.io.IOException r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.ioException(r12, r11)
            throw r11
        L_0x01dd:
            if (r1 != r5) goto L_0x020a
            if (r6 == 0) goto L_0x0201
            com.sendbird.android.shadow.okio.BufferedSource r11 = r10.f45165b
            int r11 = r11.readInt()
            com.sendbird.android.shadow.okhttp3.internal.http2.ErrorCode r1 = com.sendbird.android.shadow.okhttp3.internal.http2.ErrorCode.fromHttp2(r11)
            if (r1 == 0) goto L_0x01f2
            r12.a((int) r6, (com.sendbird.android.shadow.okhttp3.internal.http2.ErrorCode) r1)
            goto L_0x02af
        L_0x01f2:
            java.lang.Object[] r12 = new java.lang.Object[r2]
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r12[r0] = r11
            java.lang.String r11 = "TYPE_RST_STREAM unexpected error code: %d"
            java.io.IOException r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.ioException(r11, r12)
            throw r11
        L_0x0201:
            java.lang.Object[] r11 = new java.lang.Object[r0]
            java.lang.String r12 = "TYPE_RST_STREAM streamId == 0"
            java.io.IOException r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.ioException(r12, r11)
            throw r11
        L_0x020a:
            java.lang.Object[] r11 = new java.lang.Object[r2]
            java.lang.Integer r12 = java.lang.Integer.valueOf(r1)
            r11[r0] = r12
            java.lang.String r12 = "TYPE_RST_STREAM length: %d != 4"
            java.io.IOException r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.ioException(r12, r11)
            throw r11
        L_0x0219:
            if (r1 != r8) goto L_0x022b
            if (r6 == 0) goto L_0x0222
            r10.a()
            goto L_0x02af
        L_0x0222:
            java.lang.Object[] r11 = new java.lang.Object[r0]
            java.lang.String r12 = "TYPE_PRIORITY streamId == 0"
            java.io.IOException r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.ioException(r12, r11)
            throw r11
        L_0x022b:
            java.lang.Object[] r11 = new java.lang.Object[r2]
            java.lang.Integer r12 = java.lang.Integer.valueOf(r1)
            r11[r0] = r12
            java.lang.String r12 = "TYPE_PRIORITY length: %d != 5"
            java.io.IOException r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.ioException(r12, r11)
            throw r11
        L_0x023a:
            if (r6 == 0) goto L_0x0265
            r3 = r11 & 1
            if (r3 == 0) goto L_0x0242
            r3 = 1
            goto L_0x0243
        L_0x0242:
            r3 = 0
        L_0x0243:
            r4 = r11 & 8
            if (r4 == 0) goto L_0x0250
            com.sendbird.android.shadow.okio.BufferedSource r0 = r10.f45165b
            byte r0 = r0.readByte()
            r0 = r0 & 255(0xff, float:3.57E-43)
            short r0 = (short) r0
        L_0x0250:
            r4 = r11 & 32
            if (r4 == 0) goto L_0x0259
            r10.a()
            int r1 = r1 + -5
        L_0x0259:
            int r1 = a(r1, r11, r0)
            java.util.List r11 = r10.a(r1, r0, r11, r6)
            r12.a((boolean) r3, (int) r6, (java.util.List<com.sendbird.android.shadow.okhttp3.internal.http2.Header>) r11)
            goto L_0x02af
        L_0x0265:
            java.lang.Object[] r11 = new java.lang.Object[r0]
            java.lang.String r12 = "PROTOCOL_ERROR: TYPE_HEADERS streamId == 0"
            java.io.IOException r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.ioException(r12, r11)
            throw r11
        L_0x026e:
            if (r6 == 0) goto L_0x02a6
            r3 = r11 & 1
            if (r3 == 0) goto L_0x0276
            r3 = 1
            goto L_0x0277
        L_0x0276:
            r3 = 0
        L_0x0277:
            r4 = r11 & 32
            if (r4 == 0) goto L_0x027d
            r4 = 1
            goto L_0x027e
        L_0x027d:
            r4 = 0
        L_0x027e:
            if (r4 != 0) goto L_0x029d
            r4 = r11 & 8
            if (r4 == 0) goto L_0x028d
            com.sendbird.android.shadow.okio.BufferedSource r0 = r10.f45165b
            byte r0 = r0.readByte()
            r0 = r0 & 255(0xff, float:3.57E-43)
            short r0 = (short) r0
        L_0x028d:
            int r11 = a(r1, r11, r0)
            com.sendbird.android.shadow.okio.BufferedSource r1 = r10.f45165b
            r12.a(r3, r6, r1, r11)
            com.sendbird.android.shadow.okio.BufferedSource r11 = r10.f45165b
            long r0 = (long) r0
            r11.skip(r0)
            goto L_0x02af
        L_0x029d:
            java.lang.Object[] r11 = new java.lang.Object[r0]
            java.lang.String r12 = "PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA"
            java.io.IOException r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.ioException(r12, r11)
            throw r11
        L_0x02a6:
            java.lang.Object[] r11 = new java.lang.Object[r0]
            java.lang.String r12 = "PROTOCOL_ERROR: TYPE_DATA streamId == 0"
            java.io.IOException r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.ioException(r12, r11)
            throw r11
        L_0x02af:
            return r2
        L_0x02b0:
            java.lang.Object[] r11 = new java.lang.Object[r2]
            java.lang.Integer r12 = java.lang.Integer.valueOf(r1)
            r11[r0] = r12
            java.lang.String r12 = "FRAME_SIZE_ERROR: %s"
            java.io.IOException r11 = com.sendbird.android.shadow.okhttp3.internal.http2.Http2.ioException(r12, r11)
            throw r11
        L_0x02bf:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.okhttp3.internal.http2.b.a(boolean, com.sendbird.android.shadow.okhttp3.internal.http2.b$b):boolean");
    }

    private List<Header> a(int i2, short s, byte b2, int i3) throws IOException {
        a aVar = this.f45168e;
        aVar.f45172d = i2;
        aVar.f45169a = i2;
        aVar.f45173e = s;
        aVar.f45170b = b2;
        aVar.f45171c = i3;
        this.f45167d.a();
        return this.f45167d.b();
    }

    private void a() throws IOException {
        this.f45165b.readInt();
        this.f45165b.readByte();
    }

    public final void close() throws IOException {
        this.f45165b.close();
    }

    static final class a implements Source {

        /* renamed from: a  reason: collision with root package name */
        int f45169a;

        /* renamed from: b  reason: collision with root package name */
        byte f45170b;

        /* renamed from: c  reason: collision with root package name */
        int f45171c;

        /* renamed from: d  reason: collision with root package name */
        int f45172d;

        /* renamed from: e  reason: collision with root package name */
        short f45173e;

        /* renamed from: f  reason: collision with root package name */
        private final BufferedSource f45174f;

        public final void close() throws IOException {
        }

        a(BufferedSource bufferedSource) {
            this.f45174f = bufferedSource;
        }

        public final long read(Buffer buffer, long j) throws IOException {
            int i2;
            do {
                int i3 = this.f45172d;
                if (i3 == 0) {
                    this.f45174f.skip((long) this.f45173e);
                    this.f45173e = 0;
                    if ((this.f45170b & 4) != 0) {
                        return -1;
                    }
                    i2 = this.f45171c;
                    int a2 = b.a(this.f45174f);
                    this.f45172d = a2;
                    this.f45169a = a2;
                    byte readByte = (byte) (this.f45174f.readByte() & 255);
                    this.f45170b = (byte) (this.f45174f.readByte() & 255);
                    if (b.f45164a.isLoggable(Level.FINE)) {
                        b.f45164a.fine(Http2.frameLog(true, this.f45171c, this.f45169a, readByte, this.f45170b));
                    }
                    this.f45171c = this.f45174f.readInt() & Integer.MAX_VALUE;
                    if (readByte != 9) {
                        throw Http2.ioException("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
                    }
                } else {
                    long read = this.f45174f.read(buffer, Math.min(j, (long) i3));
                    if (read == -1) {
                        return -1;
                    }
                    this.f45172d = (int) (((long) this.f45172d) - read);
                    return read;
                }
            } while (this.f45171c == i2);
            throw Http2.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
        }

        public final Timeout timeout() {
            return this.f45174f.timeout();
        }
    }

    static int a(BufferedSource bufferedSource) throws IOException {
        return (bufferedSource.readByte() & 255) | ((bufferedSource.readByte() & 255) << 16) | ((bufferedSource.readByte() & 255) << 8);
    }

    private static int a(int i2, byte b2, short s) throws IOException {
        if ((b2 & 8) != 0) {
            i2--;
        }
        if (s <= i2) {
            return (short) (i2 - s);
        }
        throw Http2.ioException("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i2));
    }
}
