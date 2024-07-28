package com.bumptech.glide.load.d.a;

import android.util.Log;
import com.bumptech.glide.g.j;
import com.bumptech.glide.load.ImageHeaderParser;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public final class m implements ImageHeaderParser {

    /* renamed from: a  reason: collision with root package name */
    static final byte[] f7145a = "Exif\u0000\u0000".getBytes(Charset.forName(AppConstants.UTF_8));

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f7146b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    public final ImageHeaderParser.ImageType a(InputStream inputStream) throws IOException {
        return a((c) new d((InputStream) j.a(inputStream, "Argument must not be null")));
    }

    public final ImageHeaderParser.ImageType a(ByteBuffer byteBuffer) throws IOException {
        return a((c) new a((ByteBuffer) j.a(byteBuffer, "Argument must not be null")));
    }

    public final int a(InputStream inputStream, com.bumptech.glide.load.b.a.b bVar) throws IOException {
        return a((c) new d((InputStream) j.a(inputStream, "Argument must not be null")), (com.bumptech.glide.load.b.a.b) j.a(bVar, "Argument must not be null"));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003b, code lost:
        return com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0039 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.bumptech.glide.load.ImageHeaderParser.ImageType a(com.bumptech.glide.load.d.a.m.c r5) throws java.io.IOException {
        /*
            int r0 = r5.b()     // Catch:{ a -> 0x00a0 }
            r1 = 65496(0xffd8, float:9.178E-41)
            if (r0 != r1) goto L_0x000c
            com.bumptech.glide.load.ImageHeaderParser$ImageType r5 = com.bumptech.glide.load.ImageHeaderParser.ImageType.JPEG     // Catch:{ a -> 0x00a0 }
            return r5
        L_0x000c:
            int r0 = r0 << 8
            short r1 = r5.a()     // Catch:{ a -> 0x00a0 }
            r0 = r0 | r1
            r1 = 4671814(0x474946, float:6.546606E-39)
            if (r0 != r1) goto L_0x001b
            com.bumptech.glide.load.ImageHeaderParser$ImageType r5 = com.bumptech.glide.load.ImageHeaderParser.ImageType.GIF     // Catch:{ a -> 0x00a0 }
            return r5
        L_0x001b:
            int r0 = r0 << 8
            short r1 = r5.a()     // Catch:{ a -> 0x00a0 }
            r0 = r0 | r1
            r1 = -1991225785(0xffffffff89504e47, float:-2.5073895E-33)
            if (r0 != r1) goto L_0x003c
            r0 = 21
            r5.a(r0)     // Catch:{ a -> 0x00a0 }
            short r5 = r5.a()     // Catch:{ a -> 0x0039 }
            r0 = 3
            if (r5 < r0) goto L_0x0036
            com.bumptech.glide.load.ImageHeaderParser$ImageType r5 = com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG_A     // Catch:{ a -> 0x0039 }
            return r5
        L_0x0036:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r5 = com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG     // Catch:{ a -> 0x0039 }
            return r5
        L_0x0039:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r5 = com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG     // Catch:{ a -> 0x00a0 }
            return r5
        L_0x003c:
            r1 = 1380533830(0x52494646, float:2.16116855E11)
            if (r0 == r1) goto L_0x0044
            com.bumptech.glide.load.ImageHeaderParser$ImageType r5 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN     // Catch:{ a -> 0x00a0 }
            return r5
        L_0x0044:
            r0 = 4
            r5.a(r0)     // Catch:{ a -> 0x00a0 }
            int r2 = r5.b()     // Catch:{ a -> 0x00a0 }
            int r2 = r2 << 16
            int r3 = r5.b()     // Catch:{ a -> 0x00a0 }
            r2 = r2 | r3
            r3 = 1464156752(0x57454250, float:2.16888601E14)
            if (r2 == r3) goto L_0x005c
            com.bumptech.glide.load.ImageHeaderParser$ImageType r5 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN     // Catch:{ a -> 0x00a0 }
            return r5
        L_0x005c:
            int r2 = r5.b()     // Catch:{ a -> 0x00a0 }
            int r2 = r2 << 16
            int r3 = r5.b()     // Catch:{ a -> 0x00a0 }
            r2 = r2 | r3
            r3 = r2 & -256(0xffffffffffffff00, float:NaN)
            r4 = 1448097792(0x56503800, float:5.7234734E13)
            if (r3 == r4) goto L_0x0071
            com.bumptech.glide.load.ImageHeaderParser$ImageType r5 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN     // Catch:{ a -> 0x00a0 }
            return r5
        L_0x0071:
            r2 = r2 & 255(0xff, float:3.57E-43)
            r3 = 88
            if (r2 != r3) goto L_0x0088
            r5.a(r0)     // Catch:{ a -> 0x00a0 }
            short r5 = r5.a()     // Catch:{ a -> 0x00a0 }
            r5 = r5 & 16
            if (r5 == 0) goto L_0x0085
            com.bumptech.glide.load.ImageHeaderParser$ImageType r5 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP_A     // Catch:{ a -> 0x00a0 }
            return r5
        L_0x0085:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r5 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP     // Catch:{ a -> 0x00a0 }
            return r5
        L_0x0088:
            r3 = 76
            if (r2 != r3) goto L_0x009d
            r5.a(r0)     // Catch:{ a -> 0x00a0 }
            short r5 = r5.a()     // Catch:{ a -> 0x00a0 }
            r5 = r5 & 8
            if (r5 == 0) goto L_0x009a
            com.bumptech.glide.load.ImageHeaderParser$ImageType r5 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP_A     // Catch:{ a -> 0x00a0 }
            return r5
        L_0x009a:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r5 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP     // Catch:{ a -> 0x00a0 }
            return r5
        L_0x009d:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r5 = com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP     // Catch:{ a -> 0x00a0 }
            return r5
        L_0x00a0:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r5 = com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.d.a.m.a(com.bumptech.glide.load.d.a.m$c):com.bumptech.glide.load.ImageHeaderParser$ImageType");
    }

    private static int a(c cVar, com.bumptech.glide.load.b.a.b bVar) throws IOException {
        int i2;
        byte[] bArr;
        int i3;
        try {
            int b2 = cVar.b();
            if (!((b2 & 65496) == 65496 || b2 == 19789 || b2 == 18761)) {
                Log.isLoggable("DfltImageHeaderParser", 3);
                return -1;
            }
            while (true) {
                if (cVar.a() == 255) {
                    short a2 = cVar.a();
                    if (a2 != 218) {
                        if (a2 != 217) {
                            i2 = cVar.b() - 2;
                            if (a2 == 225) {
                                break;
                            }
                            long j = (long) i2;
                            long a3 = cVar.a(j);
                            if (a3 != j) {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    StringBuilder sb = new StringBuilder("Unable to skip enough data, type: ");
                                    sb.append(a2);
                                    sb.append(", wanted to skip: ");
                                    sb.append(i2);
                                    sb.append(", but actually skipped: ");
                                    sb.append(a3);
                                }
                            }
                        } else {
                            Log.isLoggable("DfltImageHeaderParser", 3);
                            break;
                        }
                    } else {
                        break;
                    }
                } else {
                    Log.isLoggable("DfltImageHeaderParser", 3);
                    break;
                }
            }
            i2 = -1;
            if (i2 == -1) {
                Log.isLoggable("DfltImageHeaderParser", 3);
                return -1;
            }
            bArr = (byte[]) bVar.a(i2, byte[].class);
            int a4 = cVar.a(bArr, i2);
            if (a4 != i2) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    StringBuilder sb2 = new StringBuilder("Unable to read exif segment data, length: ");
                    sb2.append(i2);
                    sb2.append(", actually read: ");
                    sb2.append(a4);
                }
            } else if (a(bArr, i2)) {
                i3 = a(new b(bArr, i2));
                bVar.a(bArr);
                return i3;
            } else {
                Log.isLoggable("DfltImageHeaderParser", 3);
            }
            i3 = -1;
            bVar.a(bArr);
            return i3;
        } catch (c.a unused) {
            return -1;
        } catch (Throwable th) {
            bVar.a(bArr);
            throw th;
        }
    }

    private static boolean a(byte[] bArr, int i2) {
        boolean z = bArr != null && i2 > f7145a.length;
        if (!z) {
            return z;
        }
        int i3 = 0;
        while (true) {
            byte[] bArr2 = f7145a;
            if (i3 >= bArr2.length) {
                return z;
            }
            if (bArr[i3] != bArr2[i3]) {
                return false;
            }
            i3++;
        }
    }

    private static int a(b bVar) {
        ByteOrder byteOrder;
        short b2 = bVar.b(6);
        if (b2 == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else if (b2 != 19789) {
            Log.isLoggable("DfltImageHeaderParser", 3);
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        bVar.f7148a.order(byteOrder);
        int a2 = bVar.a(10) + 6;
        short b3 = bVar.b(a2);
        for (int i2 = 0; i2 < b3; i2++) {
            int i3 = a2 + 2 + (i2 * 12);
            short b4 = bVar.b(i3);
            if (b4 == 274) {
                short b5 = bVar.b(i3 + 2);
                if (b5 <= 0 || b5 > 12) {
                    boolean isLoggable = Log.isLoggable("DfltImageHeaderParser", 3);
                } else {
                    int a3 = bVar.a(i3 + 4);
                    if (a3 < 0) {
                        boolean isLoggable2 = Log.isLoggable("DfltImageHeaderParser", 3);
                    } else {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            StringBuilder sb = new StringBuilder("Got tagIndex=");
                            sb.append(i2);
                            sb.append(" tagType=");
                            sb.append(b4);
                            sb.append(" formatCode=");
                            sb.append(b5);
                            sb.append(" componentCount=");
                            sb.append(a3);
                        }
                        int i4 = a3 + f7146b[b5];
                        if (i4 > 4) {
                            boolean isLoggable3 = Log.isLoggable("DfltImageHeaderParser", 3);
                        } else {
                            int i5 = i3 + 8;
                            if (i5 < 0 || i5 > bVar.f7148a.remaining()) {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    StringBuilder sb2 = new StringBuilder("Illegal tagValueOffset=");
                                    sb2.append(i5);
                                    sb2.append(" tagType=");
                                    sb2.append(b4);
                                }
                            } else if (i4 >= 0 && i4 + i5 <= bVar.f7148a.remaining()) {
                                return bVar.b(i5);
                            } else {
                                boolean isLoggable4 = Log.isLoggable("DfltImageHeaderParser", 3);
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        final ByteBuffer f7148a;

        b(byte[] bArr, int i2) {
            this.f7148a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i2);
        }

        /* access modifiers changed from: package-private */
        public final int a(int i2) {
            if (a(i2, 4)) {
                return this.f7148a.getInt(i2);
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public final short b(int i2) {
            if (a(i2, 2)) {
                return this.f7148a.getShort(i2);
            }
            return -1;
        }

        private boolean a(int i2, int i3) {
            return this.f7148a.remaining() - i2 >= i3;
        }
    }

    interface c {
        int a(byte[] bArr, int i2) throws IOException;

        long a(long j) throws IOException;

        short a() throws IOException;

        int b() throws IOException;

        public static final class a extends IOException {
            private static final long serialVersionUID = 1;

            a() {
                super("Unexpectedly reached end of a file");
            }
        }
    }

    static final class a implements c {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f7147a;

        a(ByteBuffer byteBuffer) {
            this.f7147a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        public final short a() throws c.a {
            if (this.f7147a.remaining() > 0) {
                return (short) (this.f7147a.get() & 255);
            }
            throw new c.a();
        }

        public final int b() throws c.a {
            return (a() << 8) | a();
        }

        public final int a(byte[] bArr, int i2) {
            int min = Math.min(i2, this.f7147a.remaining());
            if (min == 0) {
                return -1;
            }
            this.f7147a.get(bArr, 0, min);
            return min;
        }

        public final long a(long j) {
            int min = (int) Math.min((long) this.f7147a.remaining(), j);
            ByteBuffer byteBuffer = this.f7147a;
            byteBuffer.position(byteBuffer.position() + min);
            return (long) min;
        }
    }

    static final class d implements c {

        /* renamed from: a  reason: collision with root package name */
        private final InputStream f7149a;

        d(InputStream inputStream) {
            this.f7149a = inputStream;
        }

        public final short a() throws IOException {
            int read = this.f7149a.read();
            if (read != -1) {
                return (short) read;
            }
            throw new c.a();
        }

        public final int b() throws IOException {
            return (a() << 8) | a();
        }

        public final int a(byte[] bArr, int i2) throws IOException {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2 && (i4 = this.f7149a.read(bArr, i3, i2 - i3)) != -1) {
                i3 += i4;
            }
            if (i3 != 0 || i4 != -1) {
                return i3;
            }
            throw new c.a();
        }

        public final long a(long j) throws IOException {
            if (j < 0) {
                return 0;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.f7149a.skip(j2);
                if (skip <= 0) {
                    if (this.f7149a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j2 -= skip;
            }
            return j - j2;
        }
    }
}
