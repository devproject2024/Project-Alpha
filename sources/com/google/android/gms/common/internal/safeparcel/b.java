package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public final class b {
    public static void a(Parcel parcel, int i2, int i3) {
        if (i3 >= 65535) {
            parcel.writeInt(i2 | -65536);
            parcel.writeInt(i3);
            return;
        }
        parcel.writeInt(i2 | (i3 << 16));
    }

    public static int a(Parcel parcel, int i2) {
        parcel.writeInt(i2 | -65536);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void b(Parcel parcel, int i2) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i2 - 4);
        parcel.writeInt(dataPosition - i2);
        parcel.setDataPosition(dataPosition);
    }

    public static void a(Parcel parcel, int i2, boolean z) {
        a(parcel, i2, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void a(Parcel parcel, int i2, byte b2) {
        a(parcel, i2, 4);
        parcel.writeInt(b2);
    }

    public static void b(Parcel parcel, int i2, int i3) {
        a(parcel, i2, 4);
        parcel.writeInt(i3);
    }

    public static void a(Parcel parcel, int i2, Integer num) {
        if (num != null) {
            a(parcel, i2, 4);
            parcel.writeInt(num.intValue());
        }
    }

    public static void a(Parcel parcel, int i2, long j) {
        a(parcel, i2, 8);
        parcel.writeLong(j);
    }

    public static void a(Parcel parcel, int i2, Long l) {
        if (l != null) {
            a(parcel, i2, 8);
            parcel.writeLong(l.longValue());
        }
    }

    public static void a(Parcel parcel, int i2, float f2) {
        a(parcel, i2, 4);
        parcel.writeFloat(f2);
    }

    public static void a(Parcel parcel, int i2, Float f2) {
        if (f2 != null) {
            a(parcel, i2, 4);
            parcel.writeFloat(f2.floatValue());
        }
    }

    public static void a(Parcel parcel, int i2, double d2) {
        a(parcel, i2, 8);
        parcel.writeDouble(d2);
    }

    public static void a(Parcel parcel, int i2, String str, boolean z) {
        if (str != null) {
            int a2 = a(parcel, i2);
            parcel.writeString(str);
            b(parcel, a2);
        } else if (z) {
            a(parcel, i2, 0);
        }
    }

    public static void a(Parcel parcel, int i2, IBinder iBinder) {
        if (iBinder != null) {
            int a2 = a(parcel, i2);
            parcel.writeStrongBinder(iBinder);
            b(parcel, a2);
        }
    }

    public static void a(Parcel parcel, int i2, Parcelable parcelable, int i3, boolean z) {
        if (parcelable != null) {
            int a2 = a(parcel, i2);
            parcelable.writeToParcel(parcel, i3);
            b(parcel, a2);
        } else if (z) {
            a(parcel, i2, 0);
        }
    }

    public static void a(Parcel parcel, int i2, Bundle bundle) {
        if (bundle != null) {
            int a2 = a(parcel, i2);
            parcel.writeBundle(bundle);
            b(parcel, a2);
        }
    }

    public static void a(Parcel parcel, int i2, byte[] bArr, boolean z) {
        if (bArr != null) {
            int a2 = a(parcel, i2);
            parcel.writeByteArray(bArr);
            b(parcel, a2);
        } else if (z) {
            a(parcel, i2, 0);
        }
    }

    public static void a(Parcel parcel, int i2, byte[][] bArr) {
        if (bArr != null) {
            int a2 = a(parcel, i2);
            parcel.writeInt(r0);
            for (byte[] writeByteArray : bArr) {
                parcel.writeByteArray(writeByteArray);
            }
            b(parcel, a2);
        }
    }

    public static void a(Parcel parcel, int i2, int[] iArr) {
        if (iArr != null) {
            int a2 = a(parcel, i2);
            parcel.writeIntArray(iArr);
            b(parcel, a2);
        }
    }

    public static void a(Parcel parcel, int i2, String[] strArr) {
        if (strArr != null) {
            int a2 = a(parcel, i2);
            parcel.writeStringArray(strArr);
            b(parcel, a2);
        }
    }

    public static void a(Parcel parcel, int i2, List<Integer> list) {
        if (list != null) {
            int a2 = a(parcel, i2);
            int size = list.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeInt(list.get(i3).intValue());
            }
            b(parcel, a2);
        }
    }

    public static void b(Parcel parcel, int i2, List<String> list) {
        if (list != null) {
            int a2 = a(parcel, i2);
            parcel.writeStringList(list);
            b(parcel, a2);
        }
    }

    public static <T extends Parcelable> void a(Parcel parcel, int i2, T[] tArr, int i3) {
        if (tArr != null) {
            int a2 = a(parcel, i2);
            parcel.writeInt(r0);
            for (T t : tArr) {
                if (t == null) {
                    parcel.writeInt(0);
                } else {
                    a(parcel, t, i3);
                }
            }
            b(parcel, a2);
        }
    }

    public static <T extends Parcelable> void a(Parcel parcel, int i2, List<T> list, boolean z) {
        if (list != null) {
            int a2 = a(parcel, i2);
            int size = list.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                Parcelable parcelable = (Parcelable) list.get(i3);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    a(parcel, parcelable, 0);
                }
            }
            b(parcel, a2);
        } else if (z) {
            a(parcel, i2, 0);
        }
    }

    private static <T extends Parcelable> void a(Parcel parcel, T t, int i2) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i2);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }
}
