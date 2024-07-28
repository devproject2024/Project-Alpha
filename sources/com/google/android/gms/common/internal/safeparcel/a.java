package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public final class a {

    /* renamed from: com.google.android.gms.common.internal.safeparcel.a$a  reason: collision with other inner class name */
    public static class C0133a extends RuntimeException {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public C0133a(java.lang.String r4, android.os.Parcel r5) {
            /*
                r3 = this;
                int r0 = r5.dataPosition()
                int r5 = r5.dataSize()
                java.lang.String r1 = java.lang.String.valueOf(r4)
                int r1 = r1.length()
                int r1 = r1 + 41
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>(r1)
                r2.append(r4)
                java.lang.String r4 = " Parcel: pos="
                r2.append(r4)
                r2.append(r0)
                java.lang.String r4 = " size="
                r2.append(r4)
                r2.append(r5)
                java.lang.String r4 = r2.toString()
                r3.<init>(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.safeparcel.a.C0133a.<init>(java.lang.String, android.os.Parcel):void");
        }
    }

    public static int a(Parcel parcel, int i2) {
        return (i2 & -65536) != -65536 ? (i2 >> 16) & 65535 : parcel.readInt();
    }

    public static void b(Parcel parcel, int i2) {
        parcel.setDataPosition(parcel.dataPosition() + a(parcel, i2));
    }

    public static void a(Parcel parcel, int i2, int i3) {
        int a2 = a(parcel, i2);
        if (a2 != i3) {
            String hexString = Integer.toHexString(a2);
            StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
            sb.append("Expected size ");
            sb.append(i3);
            sb.append(" got ");
            sb.append(a2);
            sb.append(" (0x");
            sb.append(hexString);
            sb.append(")");
            throw new C0133a(sb.toString(), parcel);
        }
    }

    public static void b(Parcel parcel, int i2, int i3) {
        if (i2 != i3) {
            String hexString = Integer.toHexString(i2);
            StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
            sb.append("Expected size ");
            sb.append(i3);
            sb.append(" got ");
            sb.append(i2);
            sb.append(" (0x");
            sb.append(hexString);
            sb.append(")");
            throw new C0133a(sb.toString(), parcel);
        }
    }

    public static boolean c(Parcel parcel, int i2) {
        a(parcel, i2, 4);
        return parcel.readInt() != 0;
    }

    public static byte d(Parcel parcel, int i2) {
        a(parcel, i2, 4);
        return (byte) parcel.readInt();
    }

    public static int e(Parcel parcel, int i2) {
        a(parcel, i2, 4);
        return parcel.readInt();
    }

    public static Integer f(Parcel parcel, int i2) {
        int a2 = a(parcel, i2);
        if (a2 == 0) {
            return null;
        }
        b(parcel, a2, 4);
        return Integer.valueOf(parcel.readInt());
    }

    public static long g(Parcel parcel, int i2) {
        a(parcel, i2, 8);
        return parcel.readLong();
    }

    public static Long h(Parcel parcel, int i2) {
        int a2 = a(parcel, i2);
        if (a2 == 0) {
            return null;
        }
        b(parcel, a2, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static BigInteger i(Parcel parcel, int i2) {
        int a2 = a(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + a2);
        return new BigInteger(createByteArray);
    }

    public static float j(Parcel parcel, int i2) {
        a(parcel, i2, 4);
        return parcel.readFloat();
    }

    public static Float k(Parcel parcel, int i2) {
        int a2 = a(parcel, i2);
        if (a2 == 0) {
            return null;
        }
        b(parcel, a2, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static double l(Parcel parcel, int i2) {
        a(parcel, i2, 8);
        return parcel.readDouble();
    }

    public static BigDecimal m(Parcel parcel, int i2) {
        int a2 = a(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        int readInt = parcel.readInt();
        parcel.setDataPosition(dataPosition + a2);
        return new BigDecimal(new BigInteger(createByteArray), readInt);
    }

    public static String n(Parcel parcel, int i2) {
        int a2 = a(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + a2);
        return readString;
    }

    public static IBinder o(Parcel parcel, int i2) {
        int a2 = a(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + a2);
        return readStrongBinder;
    }

    public static <T extends Parcelable> T a(Parcel parcel, int i2, Parcelable.Creator<T> creator) {
        int a2 = a(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        T t = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + a2);
        return t;
    }

    public static Bundle p(Parcel parcel, int i2) {
        int a2 = a(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + a2);
        return readBundle;
    }

    public static byte[] q(Parcel parcel, int i2) {
        int a2 = a(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + a2);
        return createByteArray;
    }

    public static byte[][] r(Parcel parcel, int i2) {
        int a2 = a(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        byte[][] bArr = new byte[readInt][];
        for (int i3 = 0; i3 < readInt; i3++) {
            bArr[i3] = parcel.createByteArray();
        }
        parcel.setDataPosition(dataPosition + a2);
        return bArr;
    }

    public static int[] s(Parcel parcel, int i2) {
        int a2 = a(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(dataPosition + a2);
        return createIntArray;
    }

    public static BigInteger[] t(Parcel parcel, int i2) {
        int a2 = a(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            bigIntegerArr[i3] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + a2);
        return bigIntegerArr;
    }

    public static BigDecimal[] u(Parcel parcel, int i2) {
        int a2 = a(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            byte[] createByteArray = parcel.createByteArray();
            bigDecimalArr[i3] = new BigDecimal(new BigInteger(createByteArray), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + a2);
        return bigDecimalArr;
    }

    public static String[] v(Parcel parcel, int i2) {
        int a2 = a(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(dataPosition + a2);
        return createStringArray;
    }

    public static ArrayList<Integer> w(Parcel parcel, int i2) {
        int a2 = a(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        int readInt = parcel.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            arrayList.add(Integer.valueOf(parcel.readInt()));
        }
        parcel.setDataPosition(dataPosition + a2);
        return arrayList;
    }

    public static ArrayList<String> x(Parcel parcel, int i2) {
        int a2 = a(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(dataPosition + a2);
        return createStringArrayList;
    }

    public static <T> T[] b(Parcel parcel, int i2, Parcelable.Creator<T> creator) {
        int a2 = a(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        T[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + a2);
        return createTypedArray;
    }

    public static <T> ArrayList<T> c(Parcel parcel, int i2, Parcelable.Creator<T> creator) {
        int a2 = a(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + a2);
        return createTypedArrayList;
    }

    public static Parcel y(Parcel parcel, int i2) {
        int a2 = a(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, a2);
        parcel.setDataPosition(dataPosition + a2);
        return obtain;
    }

    public static Parcel[] z(Parcel parcel, int i2) {
        int a2 = a(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (a2 == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        Parcel[] parcelArr = new Parcel[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            int readInt2 = parcel.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                parcelArr[i3] = obtain;
                parcel.setDataPosition(dataPosition2 + readInt2);
            } else {
                parcelArr[i3] = null;
            }
        }
        parcel.setDataPosition(dataPosition + a2);
        return parcelArr;
    }

    public static void A(Parcel parcel, int i2) {
        if (parcel.dataPosition() != i2) {
            StringBuilder sb = new StringBuilder(37);
            sb.append("Overread allowed size end=");
            sb.append(i2);
            throw new C0133a(sb.toString(), parcel);
        }
    }

    public static int a(Parcel parcel) {
        int readInt = parcel.readInt();
        int a2 = a(parcel, readInt);
        int dataPosition = parcel.dataPosition();
        if ((65535 & readInt) != 20293) {
            String valueOf = String.valueOf(Integer.toHexString(readInt));
            throw new C0133a(valueOf.length() != 0 ? "Expected object header. Got 0x".concat(valueOf) : new String("Expected object header. Got 0x"), parcel);
        }
        int i2 = a2 + dataPosition;
        if (i2 >= dataPosition && i2 <= parcel.dataSize()) {
            return i2;
        }
        StringBuilder sb = new StringBuilder(54);
        sb.append("Size read is invalid start=");
        sb.append(dataPosition);
        sb.append(" end=");
        sb.append(i2);
        throw new C0133a(sb.toString(), parcel);
    }
}
