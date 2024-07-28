package in.org.npci.commonlibrary;

import java.io.UnsupportedEncodingException;

public class a {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f46330a = (!a.class.desiredAssertionStatus());

    private a() {
    }

    public static byte[] a(String str, int i2) {
        return a(str.getBytes(), i2);
    }

    public static byte[] a(byte[] bArr, int i2) {
        return a(bArr, 0, bArr.length, i2);
    }

    public static byte[] a(byte[] bArr, int i2, int i3, int i4) {
        c cVar = new c(i4, new byte[((i3 * 3) / 4)]);
        if (!cVar.a(bArr, i2, i3, true)) {
            throw new IllegalArgumentException("bad base-64");
        } else if (cVar.f46333b == cVar.f46332a.length) {
            return cVar.f46332a;
        } else {
            byte[] bArr2 = new byte[cVar.f46333b];
            System.arraycopy(cVar.f46332a, 0, bArr2, 0, cVar.f46333b);
            return bArr2;
        }
    }

    public static String b(byte[] bArr, int i2) {
        try {
            return new String(c(bArr, i2), "US-ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public static byte[] b(byte[] bArr, int i2, int i3, int i4) {
        d dVar = new d(i4, (byte[]) null);
        int i5 = (i3 / 3) * 4;
        int i6 = 2;
        if (!dVar.f46343d) {
            int i7 = i3 % 3;
            if (i7 != 0) {
                if (i7 == 1) {
                    i5 += 2;
                } else if (i7 == 2) {
                    i5 += 3;
                }
            }
        } else if (i3 % 3 > 0) {
            i5 += 4;
        }
        if (dVar.f46344e && i3 > 0) {
            int i8 = ((i3 - 1) / 57) + 1;
            if (!dVar.f46345f) {
                i6 = 1;
            }
            i5 += i8 * i6;
        }
        dVar.f46332a = new byte[i5];
        dVar.a(bArr, i2, i3, true);
        if (f46330a || dVar.f46333b == i5) {
            return dVar.f46332a;
        }
        throw new AssertionError();
    }

    public static byte[] c(byte[] bArr, int i2) {
        return b(bArr, 0, bArr.length, i2);
    }
}
