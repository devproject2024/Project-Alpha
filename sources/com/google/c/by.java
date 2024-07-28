package com.google.c;

import com.alipay.mobile.nebula.util.tar.TarHeader;
import java.nio.ByteBuffer;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

final class by {

    /* renamed from: a  reason: collision with root package name */
    private static final b f37826a = ((!(bx.a() && bx.b()) || d.a()) ? new c() : new e());

    /* access modifiers changed from: private */
    public static int b(int i2) {
        if (i2 > -12) {
            return -1;
        }
        return i2;
    }

    /* access modifiers changed from: private */
    public static int b(int i2, int i3) {
        if (i2 > -12 || i3 > -65) {
            return -1;
        }
        return i2 ^ (i3 << 8);
    }

    /* access modifiers changed from: private */
    public static int b(int i2, int i3, int i4) {
        if (i2 > -12 || i3 > -65 || i4 > -65) {
            return -1;
        }
        return (i2 ^ (i3 << 8)) ^ (i4 << 16);
    }

    public static boolean a(byte[] bArr) {
        return f37826a.a(bArr, 0, bArr.length);
    }

    public static boolean a(byte[] bArr, int i2, int i3) {
        return f37826a.a(bArr, i2, i3);
    }

    public static int a(int i2, byte[] bArr, int i3, int i4) {
        return f37826a.a(i2, bArr, i3, i4);
    }

    static class d extends IllegalArgumentException {
        d(int i2, int i3) {
            super("Unpaired surrogate at index " + i2 + " of " + i3);
        }
    }

    static int a(CharSequence charSequence) {
        int length = charSequence.length();
        int i2 = 0;
        int i3 = 0;
        while (i3 < length && charSequence.charAt(i3) < 128) {
            i3++;
        }
        int i4 = length;
        while (true) {
            if (i3 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i3);
            if (charAt < 2048) {
                i4 += (127 - charAt) >>> 31;
                i3++;
            } else {
                int length2 = charSequence.length();
                while (i3 < length2) {
                    char charAt2 = charSequence.charAt(i3);
                    if (charAt2 < 2048) {
                        i2 += (127 - charAt2) >>> 31;
                    } else {
                        i2 += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i3) >= 65536) {
                                i3++;
                            } else {
                                throw new d(i3, length2);
                            }
                        }
                    }
                    i3++;
                }
                i4 += i2;
            }
        }
        if (i4 >= length) {
            return i4;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i4) + 4294967296L));
    }

    static int a(CharSequence charSequence, byte[] bArr, int i2, int i3) {
        return f37826a.a(charSequence, bArr, i2, i3);
    }

    static boolean a(ByteBuffer byteBuffer) {
        return f37826a.a(0, byteBuffer, byteBuffer.position(), byteBuffer.remaining()) == 0;
    }

    static int a(int i2, ByteBuffer byteBuffer, int i3, int i4) {
        return f37826a.a(i2, byteBuffer, i3, i4);
    }

    static String a(ByteBuffer byteBuffer, int i2, int i3) throws ad {
        b bVar = f37826a;
        if (byteBuffer.hasArray()) {
            return bVar.b(byteBuffer.array(), byteBuffer.arrayOffset() + i2, i3);
        } else if (byteBuffer.isDirect()) {
            return bVar.a(byteBuffer, i2, i3);
        } else {
            return b.b(byteBuffer, i2, i3);
        }
    }

    static String b(byte[] bArr, int i2, int i3) throws ad {
        return f37826a.b(bArr, i2, i3);
    }

    static abstract class b {
        /* access modifiers changed from: package-private */
        public abstract int a(int i2, byte[] bArr, int i3, int i4);

        /* access modifiers changed from: package-private */
        public abstract int a(CharSequence charSequence, byte[] bArr, int i2, int i3);

        /* access modifiers changed from: package-private */
        public abstract String a(ByteBuffer byteBuffer, int i2, int i3) throws ad;

        /* access modifiers changed from: package-private */
        public abstract int b(int i2, ByteBuffer byteBuffer, int i3, int i4);

        /* access modifiers changed from: package-private */
        public abstract String b(byte[] bArr, int i2, int i3) throws ad;

        b() {
        }

        /* access modifiers changed from: package-private */
        public final boolean a(byte[] bArr, int i2, int i3) {
            return a(0, bArr, i2, i3) == 0;
        }

        /* access modifiers changed from: package-private */
        public final int a(int i2, ByteBuffer byteBuffer, int i3, int i4) {
            if (byteBuffer.hasArray()) {
                int arrayOffset = byteBuffer.arrayOffset();
                return a(i2, byteBuffer.array(), i3 + arrayOffset, arrayOffset + i4);
            } else if (byteBuffer.isDirect()) {
                return b(i2, byteBuffer, i3, i4);
            } else {
                return c(i2, byteBuffer, i3, i4);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0048, code lost:
            if (r7.get(r8) > -65) goto L_0x004a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0086, code lost:
            if (r7.get(r6) > -65) goto L_0x0088;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
            if (r7.get(r8) > -65) goto L_0x0019;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static int c(int r6, java.nio.ByteBuffer r7, int r8, int r9) {
            /*
                if (r6 == 0) goto L_0x0089
                if (r8 < r9) goto L_0x0005
                return r6
            L_0x0005:
                byte r0 = (byte) r6
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L_0x001a
                r6 = -62
                if (r0 < r6) goto L_0x0019
                int r6 = r8 + 1
                byte r8 = r7.get(r8)
                if (r8 <= r3) goto L_0x008a
            L_0x0019:
                return r2
            L_0x001a:
                r4 = -16
                if (r0 >= r4) goto L_0x004b
                int r6 = r6 >> 8
                int r6 = ~r6
                byte r6 = (byte) r6
                if (r6 != 0) goto L_0x0034
                int r6 = r8 + 1
                byte r8 = r7.get(r8)
                if (r6 < r9) goto L_0x0031
                int r6 = com.google.c.by.b(r0, r8)
                return r6
            L_0x0031:
                r5 = r8
                r8 = r6
                r6 = r5
            L_0x0034:
                if (r6 > r3) goto L_0x004a
                r4 = -96
                if (r0 != r1) goto L_0x003c
                if (r6 < r4) goto L_0x004a
            L_0x003c:
                r1 = -19
                if (r0 != r1) goto L_0x0042
                if (r6 >= r4) goto L_0x004a
            L_0x0042:
                int r6 = r8 + 1
                byte r8 = r7.get(r8)
                if (r8 <= r3) goto L_0x008a
            L_0x004a:
                return r2
            L_0x004b:
                int r1 = r6 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                r4 = 0
                if (r1 != 0) goto L_0x005f
                int r6 = r8 + 1
                byte r1 = r7.get(r8)
                if (r6 < r9) goto L_0x0063
                int r6 = com.google.c.by.b(r0, r1)
                return r6
            L_0x005f:
                int r6 = r6 >> 16
                byte r4 = (byte) r6
                r6 = r8
            L_0x0063:
                if (r4 != 0) goto L_0x0073
                int r8 = r6 + 1
                byte r4 = r7.get(r6)
                if (r8 < r9) goto L_0x0072
                int r6 = com.google.c.by.b((int) r0, (int) r1, (int) r4)
                return r6
            L_0x0072:
                r6 = r8
            L_0x0073:
                if (r1 > r3) goto L_0x0088
                int r8 = r0 << 28
                int r1 = r1 + 112
                int r8 = r8 + r1
                int r8 = r8 >> 30
                if (r8 != 0) goto L_0x0088
                if (r4 > r3) goto L_0x0088
                int r8 = r6 + 1
                byte r6 = r7.get(r6)
                if (r6 <= r3) goto L_0x0089
            L_0x0088:
                return r2
            L_0x0089:
                r6 = r8
            L_0x008a:
                int r6 = c(r7, r6, r9)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.c.by.b.c(int, java.nio.ByteBuffer, int, int):int");
        }

        private static int c(ByteBuffer byteBuffer, int i2, int i3) {
            int b2 = i2 + by.b(byteBuffer, i2, i3);
            while (b2 < i3) {
                int i4 = b2 + 1;
                byte b3 = byteBuffer.get(b2);
                if (b3 < 0) {
                    if (b3 < -32) {
                        if (i4 >= i3) {
                            return b3;
                        }
                        if (b3 < -62 || byteBuffer.get(i4) > -65) {
                            return -1;
                        }
                        b2 = i4 + 1;
                    } else if (b3 < -16) {
                        if (i4 >= i3 - 1) {
                            return by.a(byteBuffer, (int) b3, i4, i3 - i4);
                        }
                        int i5 = i4 + 1;
                        byte b4 = byteBuffer.get(i4);
                        if (b4 > -65 || ((b3 == -32 && b4 < -96) || ((b3 == -19 && b4 >= -96) || byteBuffer.get(i5) > -65))) {
                            return -1;
                        }
                        b2 = i5 + 1;
                    } else if (i4 >= i3 - 2) {
                        return by.a(byteBuffer, (int) b3, i4, i3 - i4);
                    } else {
                        int i6 = i4 + 1;
                        byte b5 = byteBuffer.get(i4);
                        if (b5 <= -65 && (((b3 << 28) + (b5 + 112)) >> 30) == 0) {
                            int i7 = i6 + 1;
                            if (byteBuffer.get(i6) <= -65) {
                                i4 = i7 + 1;
                                if (byteBuffer.get(i7) > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                }
                b2 = i4;
            }
            return 0;
        }

        static String b(ByteBuffer byteBuffer, int i2, int i3) throws ad {
            if ((i2 | i3 | ((byteBuffer.limit() - i2) - i3)) >= 0) {
                int i4 = i2 + i3;
                char[] cArr = new char[i3];
                int i5 = 0;
                while (r12 < i4) {
                    byte b2 = byteBuffer.get(r12);
                    if (!(b2 >= 0)) {
                        break;
                    }
                    i2 = r12 + 1;
                    cArr[i5] = (char) b2;
                    i5++;
                }
                int i6 = i5;
                while (r12 < i4) {
                    int i7 = r12 + 1;
                    byte b3 = byteBuffer.get(r12);
                    if (b3 >= 0) {
                        int i8 = i6 + 1;
                        cArr[i6] = (char) b3;
                        while (i7 < i4) {
                            byte b4 = byteBuffer.get(i7);
                            if (!(b4 >= 0)) {
                                break;
                            }
                            i7++;
                            cArr[i8] = (char) b4;
                            i8++;
                        }
                        r12 = i7;
                        i6 = i8;
                    } else if (a.a(b3)) {
                        if (i7 < i4) {
                            a.a(b3, byteBuffer.get(i7), cArr, i6);
                            r12 = i7 + 1;
                            i6++;
                        } else {
                            throw ad.invalidUtf8();
                        }
                    } else if (a.b(b3)) {
                        if (i7 < i4 - 1) {
                            int i9 = i7 + 1;
                            a.a(b3, byteBuffer.get(i7), byteBuffer.get(i9), cArr, i6);
                            r12 = i9 + 1;
                            i6++;
                        } else {
                            throw ad.invalidUtf8();
                        }
                    } else if (i7 < i4 - 2) {
                        int i10 = i7 + 1;
                        byte b5 = byteBuffer.get(i7);
                        int i11 = i10 + 1;
                        a.a(b3, b5, byteBuffer.get(i10), byteBuffer.get(i11), cArr, i6);
                        r12 = i11 + 1;
                        i6 = i6 + 1 + 1;
                    } else {
                        throw ad.invalidUtf8();
                    }
                }
                return new String(cArr, 0, i6);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i2), Integer.valueOf(i3)}));
        }
    }

    static final class c extends b {
        c() {
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0043, code lost:
            if (r13[r14] > -65) goto L_0x0045;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x007e, code lost:
            if (r13[r14] > -65) goto L_0x0080;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
            if (r13[r14] > -65) goto L_0x001e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int a(int r12, byte[] r13, int r14, int r15) {
            /*
                r11 = this;
                r0 = -19
                r1 = -62
                r2 = -16
                r3 = 0
                r4 = -96
                r5 = -32
                r6 = -1
                r7 = -65
                if (r12 == 0) goto L_0x0081
                if (r14 < r15) goto L_0x0013
                return r12
            L_0x0013:
                byte r8 = (byte) r12
                if (r8 >= r5) goto L_0x001f
                if (r8 < r1) goto L_0x001e
                int r12 = r14 + 1
                byte r14 = r13[r14]
                if (r14 <= r7) goto L_0x0082
            L_0x001e:
                return r6
            L_0x001f:
                if (r8 >= r2) goto L_0x0046
                int r12 = r12 >> 8
                int r12 = ~r12
                byte r12 = (byte) r12
                if (r12 != 0) goto L_0x0035
                int r12 = r14 + 1
                byte r14 = r13[r14]
                if (r12 < r15) goto L_0x0032
                int r12 = com.google.c.by.b(r8, r14)
                return r12
            L_0x0032:
                r10 = r14
                r14 = r12
                r12 = r10
            L_0x0035:
                if (r12 > r7) goto L_0x0045
                if (r8 != r5) goto L_0x003b
                if (r12 < r4) goto L_0x0045
            L_0x003b:
                if (r8 != r0) goto L_0x003f
                if (r12 >= r4) goto L_0x0045
            L_0x003f:
                int r12 = r14 + 1
                byte r14 = r13[r14]
                if (r14 <= r7) goto L_0x0082
            L_0x0045:
                return r6
            L_0x0046:
                int r9 = r12 >> 8
                int r9 = ~r9
                byte r9 = (byte) r9
                if (r9 != 0) goto L_0x005a
                int r12 = r14 + 1
                byte r9 = r13[r14]
                if (r12 < r15) goto L_0x0057
                int r12 = com.google.c.by.b(r8, r9)
                return r12
            L_0x0057:
                r14 = r12
                r12 = 0
                goto L_0x005d
            L_0x005a:
                int r12 = r12 >> 16
                byte r12 = (byte) r12
            L_0x005d:
                if (r12 != 0) goto L_0x006d
                int r12 = r14 + 1
                byte r14 = r13[r14]
                if (r12 < r15) goto L_0x006a
                int r12 = com.google.c.by.b((int) r8, (int) r9, (int) r14)
                return r12
            L_0x006a:
                r10 = r14
                r14 = r12
                r12 = r10
            L_0x006d:
                if (r9 > r7) goto L_0x0080
                int r8 = r8 << 28
                int r9 = r9 + 112
                int r8 = r8 + r9
                int r8 = r8 >> 30
                if (r8 != 0) goto L_0x0080
                if (r12 > r7) goto L_0x0080
                int r12 = r14 + 1
                byte r14 = r13[r14]
                if (r14 <= r7) goto L_0x0082
            L_0x0080:
                return r6
            L_0x0081:
                r12 = r14
            L_0x0082:
                if (r12 >= r15) goto L_0x008b
                byte r14 = r13[r12]
                if (r14 < 0) goto L_0x008b
                int r12 = r12 + 1
                goto L_0x0082
            L_0x008b:
                if (r12 < r15) goto L_0x008e
                return r3
            L_0x008e:
                if (r12 < r15) goto L_0x0091
                return r3
            L_0x0091:
                int r14 = r12 + 1
                byte r12 = r13[r12]
                if (r12 >= 0) goto L_0x00ea
                if (r12 >= r5) goto L_0x00a5
                if (r14 < r15) goto L_0x009c
                return r12
            L_0x009c:
                if (r12 < r1) goto L_0x00a4
                int r12 = r14 + 1
                byte r14 = r13[r14]
                if (r14 <= r7) goto L_0x008e
            L_0x00a4:
                return r6
            L_0x00a5:
                if (r12 >= r2) goto L_0x00c5
                int r8 = r15 + -1
                if (r14 < r8) goto L_0x00b0
                int r12 = com.google.c.by.c(r13, r14, r15)
                return r12
            L_0x00b0:
                int r8 = r14 + 1
                byte r14 = r13[r14]
                if (r14 > r7) goto L_0x00c4
                if (r12 != r5) goto L_0x00ba
                if (r14 < r4) goto L_0x00c4
            L_0x00ba:
                if (r12 != r0) goto L_0x00be
                if (r14 >= r4) goto L_0x00c4
            L_0x00be:
                int r12 = r8 + 1
                byte r14 = r13[r8]
                if (r14 <= r7) goto L_0x008e
            L_0x00c4:
                return r6
            L_0x00c5:
                int r8 = r15 + -2
                if (r14 < r8) goto L_0x00ce
                int r12 = com.google.c.by.c(r13, r14, r15)
                return r12
            L_0x00ce:
                int r8 = r14 + 1
                byte r14 = r13[r14]
                if (r14 > r7) goto L_0x00e9
                int r12 = r12 << 28
                int r14 = r14 + 112
                int r12 = r12 + r14
                int r12 = r12 >> 30
                if (r12 != 0) goto L_0x00e9
                int r12 = r8 + 1
                byte r14 = r13[r8]
                if (r14 > r7) goto L_0x00e9
                int r14 = r12 + 1
                byte r12 = r13[r12]
                if (r12 <= r7) goto L_0x00ea
            L_0x00e9:
                return r6
            L_0x00ea:
                r12 = r14
                goto L_0x008e
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.c.by.c.a(int, byte[], int, int):int");
        }

        /* access modifiers changed from: package-private */
        public final int b(int i2, ByteBuffer byteBuffer, int i3, int i4) {
            return c(i2, byteBuffer, i3, i4);
        }

        /* access modifiers changed from: package-private */
        public final String b(byte[] bArr, int i2, int i3) throws ad {
            if ((i2 | i3 | ((bArr.length - i2) - i3)) >= 0) {
                int i4 = i2 + i3;
                char[] cArr = new char[i3];
                int i5 = 0;
                while (r13 < i4) {
                    byte b2 = bArr[r13];
                    if (!(b2 >= 0)) {
                        break;
                    }
                    i2 = r13 + 1;
                    cArr[i5] = (char) b2;
                    i5++;
                }
                int i6 = i5;
                while (r13 < i4) {
                    int i7 = r13 + 1;
                    byte b3 = bArr[r13];
                    if (b3 >= 0) {
                        int i8 = i6 + 1;
                        cArr[i6] = (char) b3;
                        while (i7 < i4) {
                            byte b4 = bArr[i7];
                            if (!(b4 >= 0)) {
                                break;
                            }
                            i7++;
                            cArr[i8] = (char) b4;
                            i8++;
                        }
                        r13 = i7;
                        i6 = i8;
                    } else if (a.a(b3)) {
                        if (i7 < i4) {
                            a.a(b3, bArr[i7], cArr, i6);
                            r13 = i7 + 1;
                            i6++;
                        } else {
                            throw ad.invalidUtf8();
                        }
                    } else if (a.b(b3)) {
                        if (i7 < i4 - 1) {
                            int i9 = i7 + 1;
                            a.a(b3, bArr[i7], bArr[i9], cArr, i6);
                            r13 = i9 + 1;
                            i6++;
                        } else {
                            throw ad.invalidUtf8();
                        }
                    } else if (i7 < i4 - 2) {
                        int i10 = i7 + 1;
                        byte b5 = bArr[i7];
                        int i11 = i10 + 1;
                        a.a(b3, b5, bArr[i10], bArr[i11], cArr, i6);
                        r13 = i11 + 1;
                        i6 = i6 + 1 + 1;
                    } else {
                        throw ad.invalidUtf8();
                    }
                }
                return new String(cArr, 0, i6);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)}));
        }

        /* access modifiers changed from: package-private */
        public final String a(ByteBuffer byteBuffer, int i2, int i3) throws ad {
            return b(byteBuffer, i2, i3);
        }

        /* access modifiers changed from: package-private */
        public final int a(CharSequence charSequence, byte[] bArr, int i2, int i3) {
            int i4;
            int i5;
            int i6;
            char charAt;
            int length = charSequence.length();
            int i7 = i3 + i2;
            int i8 = 0;
            while (i8 < length && (i6 = i8 + i2) < i7 && (charAt = charSequence.charAt(i8)) < 128) {
                bArr[i6] = (byte) charAt;
                i8++;
            }
            if (i8 == length) {
                return i2 + length;
            }
            int i9 = i2 + i8;
            while (i8 < length) {
                char charAt2 = charSequence.charAt(i8);
                if (charAt2 < 128 && i9 < i7) {
                    i5 = i9 + 1;
                    bArr[i9] = (byte) charAt2;
                } else if (charAt2 < 2048 && i9 <= i7 - 2) {
                    int i10 = i9 + 1;
                    bArr[i9] = (byte) ((charAt2 >>> 6) | 960);
                    i9 = i10 + 1;
                    bArr[i10] = (byte) ((charAt2 & '?') | 128);
                    i8++;
                } else if ((charAt2 < 55296 || 57343 < charAt2) && i9 <= i7 - 3) {
                    int i11 = i9 + 1;
                    bArr[i9] = (byte) ((charAt2 >>> 12) | SDKConstants.ERROR_CODE_480);
                    int i12 = i11 + 1;
                    bArr[i11] = (byte) (((charAt2 >>> 6) & 63) | 128);
                    i5 = i12 + 1;
                    bArr[i12] = (byte) ((charAt2 & '?') | 128);
                } else if (i9 <= i7 - 4) {
                    int i13 = i8 + 1;
                    if (i13 != charSequence.length()) {
                        char charAt3 = charSequence.charAt(i13);
                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                            int i14 = i9 + 1;
                            bArr[i9] = (byte) ((codePoint >>> 18) | 240);
                            int i15 = i14 + 1;
                            bArr[i14] = (byte) (((codePoint >>> 12) & 63) | 128);
                            int i16 = i15 + 1;
                            bArr[i15] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i9 = i16 + 1;
                            bArr[i16] = (byte) ((codePoint & 63) | 128);
                            i8 = i13;
                            i8++;
                        } else {
                            i8 = i13;
                        }
                    }
                    throw new d(i8 - 1, length);
                } else if (55296 > charAt2 || charAt2 > 57343 || ((i4 = i8 + 1) != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i4)))) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i9);
                } else {
                    throw new d(i8, length);
                }
                i9 = i5;
                i8++;
            }
            return i9;
        }
    }

    static final class e extends b {
        e() {
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
            if (com.google.c.bx.a(r13, r2) > -65) goto L_0x0027;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0056, code lost:
            if (com.google.c.bx.a(r13, r2) > -65) goto L_0x0058;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0098, code lost:
            if (com.google.c.bx.a(r13, r2) > -65) goto L_0x009a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int a(int r12, byte[] r13, int r14, int r15) {
            /*
                r11 = this;
                r0 = r14 | r15
                int r1 = r13.length
                int r1 = r1 - r15
                r0 = r0 | r1
                r1 = 0
                if (r0 < 0) goto L_0x00a3
                long r2 = (long) r14
                long r14 = (long) r15
                if (r12 == 0) goto L_0x009b
                int r0 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
                if (r0 < 0) goto L_0x0011
                return r12
            L_0x0011:
                byte r0 = (byte) r12
                r4 = -32
                r5 = -1
                r6 = -65
                r7 = 1
                if (r0 >= r4) goto L_0x0028
                r12 = -62
                if (r0 < r12) goto L_0x0027
                long r0 = r2 + r7
                byte r12 = com.google.c.bx.a((byte[]) r13, (long) r2)
                if (r12 <= r6) goto L_0x009c
            L_0x0027:
                return r5
            L_0x0028:
                r9 = -16
                if (r0 >= r9) goto L_0x0059
                int r12 = r12 >> 8
                int r12 = ~r12
                byte r12 = (byte) r12
                if (r12 != 0) goto L_0x0042
                long r9 = r2 + r7
                byte r12 = com.google.c.bx.a((byte[]) r13, (long) r2)
                int r1 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
                if (r1 < 0) goto L_0x0041
                int r12 = com.google.c.by.b(r0, r12)
                return r12
            L_0x0041:
                r2 = r9
            L_0x0042:
                if (r12 > r6) goto L_0x0058
                r1 = -96
                if (r0 != r4) goto L_0x004a
                if (r12 < r1) goto L_0x0058
            L_0x004a:
                r4 = -19
                if (r0 != r4) goto L_0x0050
                if (r12 >= r1) goto L_0x0058
            L_0x0050:
                long r0 = r2 + r7
                byte r12 = com.google.c.bx.a((byte[]) r13, (long) r2)
                if (r12 <= r6) goto L_0x009c
            L_0x0058:
                return r5
            L_0x0059:
                int r4 = r12 >> 8
                int r4 = ~r4
                byte r4 = (byte) r4
                if (r4 != 0) goto L_0x0070
                long r9 = r2 + r7
                byte r4 = com.google.c.bx.a((byte[]) r13, (long) r2)
                int r12 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
                if (r12 < 0) goto L_0x006e
                int r12 = com.google.c.by.b(r0, r4)
                return r12
            L_0x006e:
                r2 = r9
                goto L_0x0073
            L_0x0070:
                int r12 = r12 >> 16
                byte r1 = (byte) r12
            L_0x0073:
                if (r1 != 0) goto L_0x0085
                long r9 = r2 + r7
                byte r1 = com.google.c.bx.a((byte[]) r13, (long) r2)
                int r12 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
                if (r12 < 0) goto L_0x0084
                int r12 = com.google.c.by.b((int) r0, (int) r4, (int) r1)
                return r12
            L_0x0084:
                r2 = r9
            L_0x0085:
                if (r4 > r6) goto L_0x009a
                int r12 = r0 << 28
                int r4 = r4 + 112
                int r12 = r12 + r4
                int r12 = r12 >> 30
                if (r12 != 0) goto L_0x009a
                if (r1 > r6) goto L_0x009a
                long r0 = r2 + r7
                byte r12 = com.google.c.bx.a((byte[]) r13, (long) r2)
                if (r12 <= r6) goto L_0x009c
            L_0x009a:
                return r5
            L_0x009b:
                r0 = r2
            L_0x009c:
                long r14 = r14 - r0
                int r12 = (int) r14
                int r12 = a((byte[]) r13, (long) r0, (int) r12)
                return r12
            L_0x00a3:
                java.lang.ArrayIndexOutOfBoundsException r12 = new java.lang.ArrayIndexOutOfBoundsException
                r0 = 3
                java.lang.Object[] r0 = new java.lang.Object[r0]
                int r13 = r13.length
                java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
                r0[r1] = r13
                r13 = 1
                java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
                r0[r13] = r14
                r13 = 2
                java.lang.Integer r14 = java.lang.Integer.valueOf(r15)
                r0[r13] = r14
                java.lang.String r13 = "Array length=%d, index=%d, limit=%d"
                java.lang.String r13 = java.lang.String.format(r13, r0)
                r12.<init>(r13)
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.c.by.e.a(int, byte[], int, int):int");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x002f, code lost:
            if (com.google.c.bx.a(r2) > -65) goto L_0x0031;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0060, code lost:
            if (com.google.c.bx.a(r2) > -65) goto L_0x0062;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x00a2, code lost:
            if (com.google.c.bx.a(r2) > -65) goto L_0x00a4;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int b(int r11, java.nio.ByteBuffer r12, int r13, int r14) {
            /*
                r10 = this;
                r0 = r13 | r14
                int r1 = r12.limit()
                int r1 = r1 - r14
                r0 = r0 | r1
                r1 = 0
                if (r0 < 0) goto L_0x00ad
                long r2 = com.google.c.bx.a((java.nio.ByteBuffer) r12)
                long r4 = (long) r13
                long r2 = r2 + r4
                int r14 = r14 - r13
                long r12 = (long) r14
                long r12 = r12 + r2
                if (r11 == 0) goto L_0x00a5
                int r14 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
                if (r14 < 0) goto L_0x001b
                return r11
            L_0x001b:
                byte r14 = (byte) r11
                r0 = -32
                r4 = -1
                r5 = -65
                r6 = 1
                if (r14 >= r0) goto L_0x0032
                r11 = -62
                if (r14 < r11) goto L_0x0031
                long r0 = r2 + r6
                byte r11 = com.google.c.bx.a((long) r2)
                if (r11 <= r5) goto L_0x00a6
            L_0x0031:
                return r4
            L_0x0032:
                r8 = -16
                if (r14 >= r8) goto L_0x0063
                int r11 = r11 >> 8
                int r11 = ~r11
                byte r11 = (byte) r11
                if (r11 != 0) goto L_0x004c
                long r8 = r2 + r6
                byte r11 = com.google.c.bx.a((long) r2)
                int r1 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
                if (r1 < 0) goto L_0x004b
                int r11 = com.google.c.by.b(r14, r11)
                return r11
            L_0x004b:
                r2 = r8
            L_0x004c:
                if (r11 > r5) goto L_0x0062
                r1 = -96
                if (r14 != r0) goto L_0x0054
                if (r11 < r1) goto L_0x0062
            L_0x0054:
                r0 = -19
                if (r14 != r0) goto L_0x005a
                if (r11 >= r1) goto L_0x0062
            L_0x005a:
                long r0 = r2 + r6
                byte r11 = com.google.c.bx.a((long) r2)
                if (r11 <= r5) goto L_0x00a6
            L_0x0062:
                return r4
            L_0x0063:
                int r0 = r11 >> 8
                int r0 = ~r0
                byte r0 = (byte) r0
                if (r0 != 0) goto L_0x007a
                long r8 = r2 + r6
                byte r0 = com.google.c.bx.a((long) r2)
                int r11 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
                if (r11 < 0) goto L_0x0078
                int r11 = com.google.c.by.b(r14, r0)
                return r11
            L_0x0078:
                r2 = r8
                goto L_0x007d
            L_0x007a:
                int r11 = r11 >> 16
                byte r1 = (byte) r11
            L_0x007d:
                if (r1 != 0) goto L_0x008f
                long r8 = r2 + r6
                byte r1 = com.google.c.bx.a((long) r2)
                int r11 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
                if (r11 < 0) goto L_0x008e
                int r11 = com.google.c.by.b((int) r14, (int) r0, (int) r1)
                return r11
            L_0x008e:
                r2 = r8
            L_0x008f:
                if (r0 > r5) goto L_0x00a4
                int r11 = r14 << 28
                int r0 = r0 + 112
                int r11 = r11 + r0
                int r11 = r11 >> 30
                if (r11 != 0) goto L_0x00a4
                if (r1 > r5) goto L_0x00a4
                long r0 = r2 + r6
                byte r11 = com.google.c.bx.a((long) r2)
                if (r11 <= r5) goto L_0x00a6
            L_0x00a4:
                return r4
            L_0x00a5:
                r0 = r2
            L_0x00a6:
                long r12 = r12 - r0
                int r11 = (int) r12
                int r11 = a(r0, r11)
                return r11
            L_0x00ad:
                java.lang.ArrayIndexOutOfBoundsException r11 = new java.lang.ArrayIndexOutOfBoundsException
                r0 = 3
                java.lang.Object[] r0 = new java.lang.Object[r0]
                int r12 = r12.limit()
                java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
                r0[r1] = r12
                r12 = 1
                java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
                r0[r12] = r13
                r12 = 2
                java.lang.Integer r13 = java.lang.Integer.valueOf(r14)
                r0[r12] = r13
                java.lang.String r12 = "buffer limit=%d, index=%d, limit=%d"
                java.lang.String r12 = java.lang.String.format(r12, r0)
                r11.<init>(r12)
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.c.by.e.b(int, java.nio.ByteBuffer, int, int):int");
        }

        /* access modifiers changed from: package-private */
        public final String b(byte[] bArr, int i2, int i3) throws ad {
            if ((i2 | i3 | ((bArr.length - i2) - i3)) >= 0) {
                int i4 = i2 + i3;
                char[] cArr = new char[i3];
                int i5 = 0;
                while (r13 < i4) {
                    byte a2 = bx.a(bArr, (long) r13);
                    if (!(a2 >= 0)) {
                        break;
                    }
                    i2 = r13 + 1;
                    cArr[i5] = (char) a2;
                    i5++;
                }
                int i6 = i5;
                while (r13 < i4) {
                    int i7 = r13 + 1;
                    byte a3 = bx.a(bArr, (long) r13);
                    if (a3 >= 0) {
                        int i8 = i6 + 1;
                        cArr[i6] = (char) a3;
                        while (i7 < i4) {
                            byte a4 = bx.a(bArr, (long) i7);
                            if (!(a4 >= 0)) {
                                break;
                            }
                            i7++;
                            cArr[i8] = (char) a4;
                            i8++;
                        }
                        r13 = i7;
                        i6 = i8;
                    } else if (a.a(a3)) {
                        if (i7 < i4) {
                            a.a(a3, bx.a(bArr, (long) i7), cArr, i6);
                            r13 = i7 + 1;
                            i6++;
                        } else {
                            throw ad.invalidUtf8();
                        }
                    } else if (a.b(a3)) {
                        if (i7 < i4 - 1) {
                            int i9 = i7 + 1;
                            a.a(a3, bx.a(bArr, (long) i7), bx.a(bArr, (long) i9), cArr, i6);
                            r13 = i9 + 1;
                            i6++;
                        } else {
                            throw ad.invalidUtf8();
                        }
                    } else if (i7 < i4 - 2) {
                        int i10 = i7 + 1;
                        byte a5 = bx.a(bArr, (long) i7);
                        int i11 = i10 + 1;
                        a.a(a3, a5, bx.a(bArr, (long) i10), bx.a(bArr, (long) i11), cArr, i6);
                        r13 = i11 + 1;
                        i6 = i6 + 1 + 1;
                    } else {
                        throw ad.invalidUtf8();
                    }
                }
                return new String(cArr, 0, i6);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)}));
        }

        /* access modifiers changed from: package-private */
        public final String a(ByteBuffer byteBuffer, int i2, int i3) throws ad {
            long j;
            int i4 = i2;
            int i5 = i3;
            if ((i4 | i5 | ((byteBuffer.limit() - i4) - i5)) >= 0) {
                long a2 = bx.a(byteBuffer) + ((long) i4);
                long j2 = ((long) i5) + a2;
                char[] cArr = new char[i5];
                int i6 = 0;
                while (a2 < j2) {
                    byte a3 = bx.a(a2);
                    if (!(a3 >= 0)) {
                        break;
                    }
                    a2++;
                    cArr[i6] = (char) a3;
                    i6++;
                }
                while (true) {
                    int i7 = i6;
                    while (j < j2) {
                        long j3 = j + 1;
                        byte a4 = bx.a(j);
                        if (a4 >= 0) {
                            int i8 = i7 + 1;
                            cArr[i7] = (char) a4;
                            while (j3 < j2) {
                                byte a5 = bx.a(j3);
                                if (!(a5 >= 0)) {
                                    break;
                                }
                                j3++;
                                cArr[i8] = (char) a5;
                                i8++;
                            }
                            i7 = i8;
                            j = j3;
                        } else if (a.a(a4)) {
                            if (j3 < j2) {
                                j = j3 + 1;
                                a.a(a4, bx.a(j3), cArr, i7);
                                i7++;
                            } else {
                                throw ad.invalidUtf8();
                            }
                        } else if (a.b(a4)) {
                            if (j3 < j2 - 1) {
                                long j4 = j3 + 1;
                                a.a(a4, bx.a(j3), bx.a(j4), cArr, i7);
                                i7++;
                                j = j4 + 1;
                            } else {
                                throw ad.invalidUtf8();
                            }
                        } else if (j3 < j2 - 2) {
                            long j5 = j3 + 1;
                            byte a6 = bx.a(j3);
                            long j6 = j5 + 1;
                            byte a7 = bx.a(j5);
                            a2 = j6 + 1;
                            a.a(a4, a6, a7, bx.a(j6), cArr, i7);
                            i6 = i7 + 1 + 1;
                        } else {
                            throw ad.invalidUtf8();
                        }
                    }
                    return new String(cArr, 0, i7);
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i2), Integer.valueOf(i3)}));
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0033 A[LOOP:1: B:13:0x0033->B:38:0x00fb, LOOP_START, PHI: r2 r3 r4 r11 
          PHI: (r2v3 int) = (r2v2 int), (r2v5 int) binds: [B:10:0x002f, B:38:0x00fb] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r3v2 char) = (r3v1 char), (r3v3 char) binds: [B:10:0x002f, B:38:0x00fb] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r4v3 long) = (r4v2 long), (r4v5 long) binds: [B:10:0x002f, B:38:0x00fb] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r11v3 long) = (r11v2 long), (r11v4 long) binds: [B:10:0x002f, B:38:0x00fb] A[DONT_GENERATE, DONT_INLINE]] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final int a(java.lang.CharSequence r23, byte[] r24, int r25, int r26) {
            /*
                r22 = this;
                r0 = r23
                r1 = r24
                r2 = r25
                r3 = r26
                long r4 = (long) r2
                long r6 = (long) r3
                long r6 = r6 + r4
                int r8 = r23.length()
                java.lang.String r9 = " at index "
                java.lang.String r10 = "Failed writing "
                if (r8 > r3) goto L_0x0141
                int r11 = r1.length
                int r11 = r11 - r3
                if (r11 < r2) goto L_0x0141
                r2 = 0
            L_0x001a:
                r3 = 128(0x80, float:1.794E-43)
                r11 = 1
                if (r2 >= r8) goto L_0x002f
                char r13 = r0.charAt(r2)
                if (r13 >= r3) goto L_0x002f
                long r11 = r11 + r4
                byte r3 = (byte) r13
                com.google.c.bx.a((byte[]) r1, (long) r4, (byte) r3)
                int r2 = r2 + 1
                r4 = r11
                goto L_0x001a
            L_0x002f:
                if (r2 != r8) goto L_0x0033
                int r0 = (int) r4
                return r0
            L_0x0033:
                if (r2 >= r8) goto L_0x013f
                char r13 = r0.charAt(r2)
                if (r13 >= r3) goto L_0x004b
                int r14 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r14 >= 0) goto L_0x004b
                long r14 = r4 + r11
                byte r13 = (byte) r13
                com.google.c.bx.a((byte[]) r1, (long) r4, (byte) r13)
                r4 = r11
                r12 = r14
            L_0x0047:
                r11 = 128(0x80, float:1.794E-43)
                goto L_0x00fb
            L_0x004b:
                r14 = 2048(0x800, float:2.87E-42)
                if (r13 >= r14) goto L_0x0075
                r14 = 2
                long r14 = r6 - r14
                int r16 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
                if (r16 > 0) goto L_0x0075
                long r14 = r4 + r11
                int r3 = r13 >>> 6
                r3 = r3 | 960(0x3c0, float:1.345E-42)
                byte r3 = (byte) r3
                com.google.c.bx.a((byte[]) r1, (long) r4, (byte) r3)
                long r3 = r14 + r11
                r5 = r13 & 63
                r13 = 128(0x80, float:1.794E-43)
                r5 = r5 | r13
                byte r5 = (byte) r5
                com.google.c.bx.a((byte[]) r1, (long) r14, (byte) r5)
                r20 = r11
                r11 = 128(0x80, float:1.794E-43)
                r12 = r3
                r4 = r20
                goto L_0x00fb
            L_0x0075:
                r3 = 57343(0xdfff, float:8.0355E-41)
                r14 = 55296(0xd800, float:7.7486E-41)
                if (r13 < r14) goto L_0x007f
                if (r3 >= r13) goto L_0x00ae
            L_0x007f:
                r15 = 3
                long r15 = r6 - r15
                int r17 = (r4 > r15 ? 1 : (r4 == r15 ? 0 : -1))
                if (r17 > 0) goto L_0x00ae
                long r14 = r4 + r11
                int r3 = r13 >>> 12
                r3 = r3 | 480(0x1e0, float:6.73E-43)
                byte r3 = (byte) r3
                com.google.c.bx.a((byte[]) r1, (long) r4, (byte) r3)
                long r3 = r14 + r11
                int r5 = r13 >>> 6
                r5 = r5 & 63
                r11 = 128(0x80, float:1.794E-43)
                r5 = r5 | r11
                byte r5 = (byte) r5
                com.google.c.bx.a((byte[]) r1, (long) r14, (byte) r5)
                r14 = 1
                long r18 = r3 + r14
                r5 = r13 & 63
                r5 = r5 | r11
                byte r5 = (byte) r5
                com.google.c.bx.a((byte[]) r1, (long) r3, (byte) r5)
                r12 = r18
                r4 = 1
                goto L_0x0047
            L_0x00ae:
                r11 = 4
                long r11 = r6 - r11
                int r15 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
                if (r15 > 0) goto L_0x010f
                int r3 = r2 + 1
                if (r3 == r8) goto L_0x0107
                char r2 = r0.charAt(r3)
                boolean r11 = java.lang.Character.isSurrogatePair(r13, r2)
                if (r11 == 0) goto L_0x0106
                int r2 = java.lang.Character.toCodePoint(r13, r2)
                r11 = 1
                long r13 = r4 + r11
                int r15 = r2 >>> 18
                r15 = r15 | 240(0xf0, float:3.36E-43)
                byte r15 = (byte) r15
                com.google.c.bx.a((byte[]) r1, (long) r4, (byte) r15)
                long r4 = r13 + r11
                int r15 = r2 >>> 12
                r15 = r15 & 63
                r11 = 128(0x80, float:1.794E-43)
                r12 = r15 | 128(0x80, float:1.794E-43)
                byte r12 = (byte) r12
                com.google.c.bx.a((byte[]) r1, (long) r13, (byte) r12)
                r12 = 1
                long r14 = r4 + r12
                int r16 = r2 >>> 6
                r12 = r16 & 63
                r12 = r12 | r11
                byte r12 = (byte) r12
                com.google.c.bx.a((byte[]) r1, (long) r4, (byte) r12)
                r4 = 1
                long r12 = r14 + r4
                r2 = r2 & 63
                r2 = r2 | r11
                byte r2 = (byte) r2
                com.google.c.bx.a((byte[]) r1, (long) r14, (byte) r2)
                r2 = r3
            L_0x00fb:
                int r2 = r2 + 1
                r3 = 128(0x80, float:1.794E-43)
                r20 = r4
                r4 = r12
                r11 = r20
                goto L_0x0033
            L_0x0106:
                r2 = r3
            L_0x0107:
                com.google.c.by$d r0 = new com.google.c.by$d
                int r2 = r2 + -1
                r0.<init>(r2, r8)
                throw r0
            L_0x010f:
                if (r14 > r13) goto L_0x0127
                if (r13 > r3) goto L_0x0127
                int r1 = r2 + 1
                if (r1 == r8) goto L_0x0121
                char r0 = r0.charAt(r1)
                boolean r0 = java.lang.Character.isSurrogatePair(r13, r0)
                if (r0 != 0) goto L_0x0127
            L_0x0121:
                com.google.c.by$d r0 = new com.google.c.by$d
                r0.<init>(r2, r8)
                throw r0
            L_0x0127:
                java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>(r10)
                r1.append(r13)
                r1.append(r9)
                r1.append(r4)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x013f:
                int r0 = (int) r4
                return r0
            L_0x0141:
                java.lang.ArrayIndexOutOfBoundsException r1 = new java.lang.ArrayIndexOutOfBoundsException
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>(r10)
                int r8 = r8 + -1
                char r0 = r0.charAt(r8)
                r4.append(r0)
                r4.append(r9)
                int r0 = r2 + r3
                r4.append(r0)
                java.lang.String r0 = r4.toString()
                r1.<init>(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.c.by.e.a(java.lang.CharSequence, byte[], int, int):int");
        }

        private static int a(byte[] bArr, int i2, long j, int i3) {
            if (i3 == 0) {
                return by.b(i2);
            }
            if (i3 == 1) {
                return by.b(i2, bx.a(bArr, j));
            }
            if (i3 == 2) {
                return by.b(i2, (int) bx.a(bArr, j), (int) bx.a(bArr, j + 1));
            }
            throw new AssertionError();
        }

        private static int a(long j, int i2, int i3) {
            if (i3 == 0) {
                return by.b(i2);
            }
            if (i3 == 1) {
                return by.b(i2, bx.a(j));
            }
            if (i3 == 2) {
                return by.b(i2, (int) bx.a(j), (int) bx.a(j + 1));
            }
            throw new AssertionError();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:26:0x004f, code lost:
            return -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x00aa, code lost:
            return -1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static int a(byte[] r11, long r12, int r14) {
            /*
                r0 = 0
                r1 = 1
                r3 = 16
                if (r14 >= r3) goto L_0x0009
                r3 = 0
                goto L_0x001b
            L_0x0009:
                r4 = r12
                r3 = 0
            L_0x000b:
                if (r3 >= r14) goto L_0x001a
                long r6 = r4 + r1
                byte r4 = com.google.c.bx.a((byte[]) r11, (long) r4)
                if (r4 >= 0) goto L_0x0016
                goto L_0x001b
            L_0x0016:
                int r3 = r3 + 1
                r4 = r6
                goto L_0x000b
            L_0x001a:
                r3 = r14
            L_0x001b:
                int r14 = r14 - r3
                long r3 = (long) r3
                long r12 = r12 + r3
            L_0x001e:
                r3 = 0
            L_0x001f:
                if (r14 <= 0) goto L_0x002f
                long r3 = r12 + r1
                byte r12 = com.google.c.bx.a((byte[]) r11, (long) r12)
                if (r12 < 0) goto L_0x0032
                int r14 = r14 + -1
                r9 = r3
                r3 = r12
                r12 = r9
                goto L_0x001f
            L_0x002f:
                r9 = r12
                r12 = r3
                r3 = r9
            L_0x0032:
                if (r14 != 0) goto L_0x0035
                return r0
            L_0x0035:
                int r14 = r14 + -1
                r13 = -32
                r5 = -65
                r6 = -1
                if (r12 >= r13) goto L_0x0050
                if (r14 != 0) goto L_0x0041
                return r12
            L_0x0041:
                int r14 = r14 + -1
                r13 = -62
                if (r12 < r13) goto L_0x004f
                long r12 = r3 + r1
                byte r3 = com.google.c.bx.a((byte[]) r11, (long) r3)
                if (r3 <= r5) goto L_0x001e
            L_0x004f:
                return r6
            L_0x0050:
                r7 = -16
                if (r12 >= r7) goto L_0x007b
                r7 = 2
                if (r14 >= r7) goto L_0x005c
                int r11 = a((byte[]) r11, (int) r12, (long) r3, (int) r14)
                return r11
            L_0x005c:
                int r14 = r14 + -2
                long r7 = r3 + r1
                byte r3 = com.google.c.bx.a((byte[]) r11, (long) r3)
                if (r3 > r5) goto L_0x007a
                r4 = -96
                if (r12 != r13) goto L_0x006c
                if (r3 < r4) goto L_0x007a
            L_0x006c:
                r13 = -19
                if (r12 != r13) goto L_0x0072
                if (r3 >= r4) goto L_0x007a
            L_0x0072:
                long r12 = r7 + r1
                byte r3 = com.google.c.bx.a((byte[]) r11, (long) r7)
                if (r3 <= r5) goto L_0x001e
            L_0x007a:
                return r6
            L_0x007b:
                r13 = 3
                if (r14 >= r13) goto L_0x0083
                int r11 = a((byte[]) r11, (int) r12, (long) r3, (int) r14)
                return r11
            L_0x0083:
                int r14 = r14 + -3
                long r7 = r3 + r1
                byte r13 = com.google.c.bx.a((byte[]) r11, (long) r3)
                if (r13 > r5) goto L_0x00aa
                int r12 = r12 << 28
                int r13 = r13 + 112
                int r12 = r12 + r13
                int r12 = r12 >> 30
                if (r12 != 0) goto L_0x00aa
                long r12 = r7 + r1
                byte r3 = com.google.c.bx.a((byte[]) r11, (long) r7)
                if (r3 > r5) goto L_0x00aa
                long r3 = r12 + r1
                byte r12 = com.google.c.bx.a((byte[]) r11, (long) r12)
                if (r12 <= r5) goto L_0x00a7
                goto L_0x00aa
            L_0x00a7:
                r12 = r3
                goto L_0x001e
            L_0x00aa:
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.c.by.e.a(byte[], long, int):int");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0076, code lost:
            return -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x00a1, code lost:
            return -1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static int a(long r17, int r19) {
            /*
                r0 = r17
                r2 = r19
                r3 = 0
                r4 = 1
                r6 = 16
                if (r2 >= r6) goto L_0x000d
                r6 = 0
                goto L_0x0042
            L_0x000d:
                int r6 = (int) r0
                r6 = r6 & 7
                r7 = 8
                int r6 = 8 - r6
                r9 = r0
                r8 = r6
            L_0x0016:
                if (r8 <= 0) goto L_0x0026
                long r11 = r9 + r4
                byte r9 = com.google.c.bx.a((long) r9)
                if (r9 >= 0) goto L_0x0022
                int r6 = r6 - r8
                goto L_0x0042
            L_0x0022:
                int r8 = r8 + -1
                r9 = r11
                goto L_0x0016
            L_0x0026:
                int r6 = r2 - r6
            L_0x0028:
                if (r6 < r7) goto L_0x0040
                long r11 = com.google.c.bx.b((long) r9)
                r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
                long r11 = r11 & r13
                r13 = 0
                int r8 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
                if (r8 != 0) goto L_0x0040
                r11 = 8
                long r9 = r9 + r11
                int r6 = r6 + -8
                goto L_0x0028
            L_0x0040:
                int r6 = r2 - r6
            L_0x0042:
                long r7 = (long) r6
                long r0 = r0 + r7
                int r2 = r2 - r6
            L_0x0045:
                r6 = 0
            L_0x0046:
                if (r2 <= 0) goto L_0x0056
                long r6 = r0 + r4
                byte r0 = com.google.c.bx.a((long) r0)
                if (r0 < 0) goto L_0x0059
                int r2 = r2 + -1
                r15 = r6
                r6 = r0
                r0 = r15
                goto L_0x0046
            L_0x0056:
                r15 = r0
                r0 = r6
                r6 = r15
            L_0x0059:
                if (r2 != 0) goto L_0x005c
                return r3
            L_0x005c:
                int r2 = r2 + -1
                r1 = -32
                r8 = -65
                r9 = -1
                if (r0 >= r1) goto L_0x0077
                if (r2 != 0) goto L_0x0068
                return r0
            L_0x0068:
                int r2 = r2 + -1
                r1 = -62
                if (r0 < r1) goto L_0x0076
                long r0 = r6 + r4
                byte r6 = com.google.c.bx.a((long) r6)
                if (r6 <= r8) goto L_0x0045
            L_0x0076:
                return r9
            L_0x0077:
                r10 = -16
                if (r0 >= r10) goto L_0x00a2
                r10 = 2
                if (r2 >= r10) goto L_0x0083
                int r0 = a((long) r6, (int) r0, (int) r2)
                return r0
            L_0x0083:
                int r2 = r2 + -2
                long r10 = r6 + r4
                byte r6 = com.google.c.bx.a((long) r6)
                if (r6 > r8) goto L_0x00a1
                r7 = -96
                if (r0 != r1) goto L_0x0093
                if (r6 < r7) goto L_0x00a1
            L_0x0093:
                r1 = -19
                if (r0 != r1) goto L_0x0099
                if (r6 >= r7) goto L_0x00a1
            L_0x0099:
                long r0 = r10 + r4
                byte r6 = com.google.c.bx.a((long) r10)
                if (r6 <= r8) goto L_0x0045
            L_0x00a1:
                return r9
            L_0x00a2:
                r1 = 3
                if (r2 >= r1) goto L_0x00aa
                int r0 = a((long) r6, (int) r0, (int) r2)
                return r0
            L_0x00aa:
                int r2 = r2 + -3
                long r10 = r6 + r4
                byte r1 = com.google.c.bx.a((long) r6)
                if (r1 > r8) goto L_0x00d1
                int r0 = r0 << 28
                int r1 = r1 + 112
                int r0 = r0 + r1
                int r0 = r0 >> 30
                if (r0 != 0) goto L_0x00d1
                long r0 = r10 + r4
                byte r6 = com.google.c.bx.a((long) r10)
                if (r6 > r8) goto L_0x00d1
                long r6 = r0 + r4
                byte r0 = com.google.c.bx.a((long) r0)
                if (r0 <= r8) goto L_0x00ce
                goto L_0x00d1
            L_0x00ce:
                r0 = r6
                goto L_0x0045
            L_0x00d1:
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.c.by.e.a(long, int):int");
        }
    }

    static /* synthetic */ int b(ByteBuffer byteBuffer, int i2, int i3) {
        int i4 = i3 - 7;
        int i5 = i2;
        while (i5 < i4 && (byteBuffer.getLong(i5) & -9187201950435737472L) == 0) {
            i5 += 8;
        }
        return i5 - i2;
    }

    static class a {
        static /* synthetic */ boolean a(byte b2) {
            return b2 < -32;
        }

        static /* synthetic */ boolean b(byte b2) {
            return b2 < -16;
        }

        private static boolean c(byte b2) {
            return b2 > -65;
        }

        static /* synthetic */ void a(byte b2, byte b3, char[] cArr, int i2) throws ad {
            if (b2 < -62 || c(b3)) {
                throw ad.invalidUtf8();
            }
            cArr[i2] = (char) (((b2 & 31) << 6) | (b3 & 63));
        }

        static /* synthetic */ void a(byte b2, byte b3, byte b4, char[] cArr, int i2) throws ad {
            if (c(b3) || ((b2 == -32 && b3 < -96) || ((b2 == -19 && b3 >= -96) || c(b4)))) {
                throw ad.invalidUtf8();
            }
            cArr[i2] = (char) (((b2 & 15) << 12) | ((b3 & 63) << 6) | (b4 & 63));
        }

        static /* synthetic */ void a(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i2) throws ad {
            if (c(b3) || (((b2 << 28) + (b3 + 112)) >> 30) != 0 || c(b4) || c(b5)) {
                throw ad.invalidUtf8();
            }
            byte b6 = ((b2 & 7) << 18) | ((b3 & 63) << 12) | ((b4 & 63) << 6) | (b5 & 63);
            cArr[i2] = (char) ((b6 >>> 10) + 55232);
            cArr[i2 + 1] = (char) ((b6 & 1023) + TarHeader.LF_OLDNORM);
        }
    }

    static /* synthetic */ int a(ByteBuffer byteBuffer, int i2, int i3, int i4) {
        if (i4 == 0) {
            return b(i2);
        }
        if (i4 == 1) {
            return b(i2, byteBuffer.get(i3));
        }
        if (i4 == 2) {
            return b(i2, (int) byteBuffer.get(i3), (int) byteBuffer.get(i3 + 1));
        }
        throw new AssertionError();
    }

    static /* synthetic */ int c(byte[] bArr, int i2, int i3) {
        byte b2 = bArr[i2 - 1];
        int i4 = i3 - i2;
        if (i4 == 0) {
            return b(b2);
        }
        if (i4 == 1) {
            return b(b2, bArr[i2]);
        }
        if (i4 == 2) {
            return b((int) b2, (int) bArr[i2], (int) bArr[i2 + 1]);
        }
        throw new AssertionError();
    }
}
