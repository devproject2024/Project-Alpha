package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class eq {

    /* renamed from: a  reason: collision with root package name */
    final ByteBuffer f9341a;

    /* renamed from: b  reason: collision with root package name */
    private am f9342b;

    /* renamed from: c  reason: collision with root package name */
    private int f9343c;

    private eq(ByteBuffer byteBuffer) {
        this.f9341a = byteBuffer;
        this.f9341a.order(ByteOrder.LITTLE_ENDIAN);
    }

    private eq(byte[] bArr, int i2) {
        this(ByteBuffer.wrap(bArr, 0, i2));
    }

    public static int a(int i2) {
        if (i2 >= 0) {
            return b(i2);
        }
        return 10;
    }

    private static int a(CharSequence charSequence) {
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
                                StringBuilder sb = new StringBuilder(39);
                                sb.append("Unpaired surrogate at index ");
                                sb.append(i3);
                                throw new IllegalArgumentException(sb.toString());
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
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("UTF-8 length does not fit in int: ");
        sb2.append(((long) i4) + 4294967296L);
        throw new IllegalArgumentException(sb2.toString());
    }

    public static int a(String str) {
        int a2 = a((CharSequence) str);
        return b(a2) + a2;
    }

    public static int a(byte[] bArr) {
        return b(bArr.length) + bArr.length;
    }

    public static eq a(byte[] bArr, int i2) {
        return new eq(bArr, i2);
    }

    private static void a(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i2;
        int i3;
        int i4;
        char charAt;
        if (!byteBuffer.isReadOnly()) {
            int i5 = 0;
            if (byteBuffer.hasArray()) {
                try {
                    byte[] array = byteBuffer.array();
                    int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
                    int remaining = byteBuffer.remaining();
                    int length = charSequence.length();
                    int i6 = remaining + arrayOffset;
                    while (i5 < length) {
                        int i7 = i5 + arrayOffset;
                        if (i7 >= i6 || (charAt = charSequence.charAt(i5)) >= 128) {
                            break;
                        }
                        array[i7] = (byte) charAt;
                        i5++;
                    }
                    if (i5 == length) {
                        i3 = arrayOffset + length;
                    } else {
                        i3 = arrayOffset + i5;
                        while (i5 < length) {
                            char charAt2 = charSequence.charAt(i5);
                            if (charAt2 < 128 && i3 < i6) {
                                i4 = i3 + 1;
                                array[i3] = (byte) charAt2;
                            } else if (charAt2 < 2048 && i3 <= i6 - 2) {
                                int i8 = i3 + 1;
                                array[i3] = (byte) ((charAt2 >>> 6) | 960);
                                i3 = i8 + 1;
                                array[i8] = (byte) ((charAt2 & '?') | 128);
                                i5++;
                            } else if ((charAt2 < 55296 || 57343 < charAt2) && i3 <= i6 - 3) {
                                int i9 = i3 + 1;
                                array[i3] = (byte) ((charAt2 >>> 12) | SDKConstants.ERROR_CODE_480);
                                int i10 = i9 + 1;
                                array[i9] = (byte) (((charAt2 >>> 6) & 63) | 128);
                                i4 = i10 + 1;
                                array[i10] = (byte) ((charAt2 & '?') | 128);
                            } else if (i3 <= i6 - 4) {
                                int i11 = i5 + 1;
                                if (i11 != charSequence.length()) {
                                    char charAt3 = charSequence.charAt(i11);
                                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                                        int i12 = i3 + 1;
                                        array[i3] = (byte) ((codePoint >>> 18) | 240);
                                        int i13 = i12 + 1;
                                        array[i12] = (byte) (((codePoint >>> 12) & 63) | 128);
                                        int i14 = i13 + 1;
                                        array[i13] = (byte) (((codePoint >>> 6) & 63) | 128);
                                        i3 = i14 + 1;
                                        array[i14] = (byte) ((codePoint & 63) | 128);
                                        i5 = i11;
                                        i5++;
                                    } else {
                                        i5 = i11;
                                    }
                                }
                                StringBuilder sb = new StringBuilder(39);
                                sb.append("Unpaired surrogate at index ");
                                sb.append(i5 - 1);
                                throw new IllegalArgumentException(sb.toString());
                            } else {
                                StringBuilder sb2 = new StringBuilder(37);
                                sb2.append("Failed writing ");
                                sb2.append(charAt2);
                                sb2.append(" at index ");
                                sb2.append(i3);
                                throw new ArrayIndexOutOfBoundsException(sb2.toString());
                            }
                            i3 = i4;
                            i5++;
                        }
                    }
                    byteBuffer.position(i3 - byteBuffer.arrayOffset());
                } catch (ArrayIndexOutOfBoundsException e2) {
                    BufferOverflowException bufferOverflowException = new BufferOverflowException();
                    bufferOverflowException.initCause(e2);
                    throw bufferOverflowException;
                }
            } else {
                int length2 = charSequence.length();
                while (i5 < length2) {
                    char charAt4 = charSequence.charAt(i5);
                    if (charAt4 >= 128) {
                        if (charAt4 < 2048) {
                            i2 = (charAt4 >>> 6) | 960;
                        } else if (charAt4 < 55296 || 57343 < charAt4) {
                            byteBuffer.put((byte) ((charAt4 >>> 12) | SDKConstants.ERROR_CODE_480));
                            i2 = ((charAt4 >>> 6) & 63) | 128;
                        } else {
                            int i15 = i5 + 1;
                            if (i15 != charSequence.length()) {
                                char charAt5 = charSequence.charAt(i15);
                                if (Character.isSurrogatePair(charAt4, charAt5)) {
                                    int codePoint2 = Character.toCodePoint(charAt4, charAt5);
                                    byteBuffer.put((byte) ((codePoint2 >>> 18) | 240));
                                    byteBuffer.put((byte) (((codePoint2 >>> 12) & 63) | 128));
                                    byteBuffer.put((byte) (((codePoint2 >>> 6) & 63) | 128));
                                    byteBuffer.put((byte) ((codePoint2 & 63) | 128));
                                    i5 = i15;
                                    i5++;
                                } else {
                                    i5 = i15;
                                }
                            }
                            StringBuilder sb3 = new StringBuilder(39);
                            sb3.append("Unpaired surrogate at index ");
                            sb3.append(i5 - 1);
                            throw new IllegalArgumentException(sb3.toString());
                        }
                        byteBuffer.put((byte) i2);
                        charAt4 = (charAt4 & '?') | 128;
                    }
                    byteBuffer.put((byte) charAt4);
                    i5++;
                }
            }
        } else {
            throw new ReadOnlyBufferException();
        }
    }

    static int b(int i2) {
        if ((i2 & -128) == 0) {
            return 1;
        }
        if ((i2 & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i2) == 0) {
            return 3;
        }
        return (i2 & -268435456) == 0 ? 4 : 5;
    }

    public static int b(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static long c(long j) {
        return (j >> 63) ^ (j << 1);
    }

    private final void c(int i2) throws IOException {
        byte b2 = (byte) i2;
        if (this.f9341a.hasRemaining()) {
            this.f9341a.put(b2);
            return;
        }
        throw new er(this.f9341a.position(), this.f9341a.limit());
    }

    private final void d(int i2) throws IOException {
        while ((i2 & -128) != 0) {
            c((i2 & 127) | 128);
            i2 >>>= 7;
        }
        c(i2);
    }

    public final void a(int i2, int i3) throws IOException {
        b(i2, 0);
        if (i3 >= 0) {
            d(i3);
        } else {
            a((long) i3);
        }
    }

    public final void a(int i2, long j) throws IOException {
        b(i2, 0);
        a(j);
    }

    public final void a(int i2, cm cmVar) throws IOException {
        if (this.f9342b == null) {
            this.f9342b = am.a(this.f9341a);
        } else {
            if (this.f9343c != this.f9341a.position()) {
                this.f9342b.b(this.f9341a.array(), this.f9343c, this.f9341a.position() - this.f9343c);
            }
            am amVar = this.f9342b;
            amVar.a(i2, cmVar);
            amVar.h();
            this.f9343c = this.f9341a.position();
        }
        this.f9343c = this.f9341a.position();
        am amVar2 = this.f9342b;
        amVar2.a(i2, cmVar);
        amVar2.h();
        this.f9343c = this.f9341a.position();
    }

    public final void a(int i2, ex exVar) throws IOException {
        b(i2, 2);
        if (exVar.f9357b < 0) {
            exVar.d();
        }
        d(exVar.f9357b);
        exVar.a(this);
    }

    public final void a(int i2, String str) throws IOException {
        b(i2, 2);
        try {
            int b2 = b(str.length());
            if (b2 == b(str.length() * 3)) {
                int position = this.f9341a.position();
                if (this.f9341a.remaining() >= b2) {
                    this.f9341a.position(position + b2);
                    a((CharSequence) str, this.f9341a);
                    int position2 = this.f9341a.position();
                    this.f9341a.position(position);
                    d((position2 - position) - b2);
                    this.f9341a.position(position2);
                    return;
                }
                throw new er(position + b2, this.f9341a.limit());
            }
            d(a((CharSequence) str));
            a((CharSequence) str, this.f9341a);
        } catch (BufferOverflowException e2) {
            er erVar = new er(this.f9341a.position(), this.f9341a.limit());
            erVar.initCause(e2);
            throw erVar;
        }
    }

    public final void a(int i2, byte[] bArr) throws IOException {
        b(i2, 2);
        d(bArr.length);
        int length = bArr.length;
        if (this.f9341a.remaining() >= length) {
            this.f9341a.put(bArr, 0, length);
            return;
        }
        throw new er(this.f9341a.position(), this.f9341a.limit());
    }

    public final void a(long j) throws IOException {
        while ((-128 & j) != 0) {
            c((((int) j) & 127) | 128);
            j >>>= 7;
        }
        c((int) j);
    }

    public final void b(int i2, int i3) throws IOException {
        d((i2 << 3) | i3);
    }

    public static int b(int i2, long j) {
        return b(i2 << 3) + b(j);
    }

    public static int b(int i2, String str) {
        return b(i2 << 3) + a(str);
    }

    public static int b(int i2, ex exVar) {
        int b2 = b(i2 << 3);
        int d2 = exVar.d();
        return b2 + b(d2) + d2;
    }

    public static int b(int i2, byte[] bArr) {
        return b(i2 << 3) + a(bArr);
    }
}
