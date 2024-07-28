package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.Arrays;
import java.util.Comparator;

public final class zzi extends AbstractSafeParcelable implements Comparable<zzi> {
    public static final Parcelable.Creator<zzi> CREATOR = new i();

    /* renamed from: i  reason: collision with root package name */
    private static final Comparator<zzi> f12417i = new h();

    /* renamed from: a  reason: collision with root package name */
    public final String f12418a;

    /* renamed from: b  reason: collision with root package name */
    public final int f12419b;

    /* renamed from: c  reason: collision with root package name */
    private final long f12420c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f12421d;

    /* renamed from: e  reason: collision with root package name */
    private final double f12422e;

    /* renamed from: f  reason: collision with root package name */
    private final String f12423f;

    /* renamed from: g  reason: collision with root package name */
    private final byte[] f12424g;

    /* renamed from: h  reason: collision with root package name */
    private final int f12425h;

    public zzi(String str, long j, boolean z, double d2, String str2, byte[] bArr, int i2, int i3) {
        this.f12418a = str;
        this.f12420c = j;
        this.f12421d = z;
        this.f12422e = d2;
        this.f12423f = str2;
        this.f12424g = bArr;
        this.f12425h = i2;
        this.f12419b = i3;
    }

    private static int a(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 == i3 ? 0 : 1;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        zzi zzi = (zzi) obj;
        int compareTo = this.f12418a.compareTo(zzi.f12418a);
        if (compareTo != 0) {
            return compareTo;
        }
        int a2 = a(this.f12425h, zzi.f12425h);
        if (a2 != 0) {
            return a2;
        }
        int i2 = this.f12425h;
        if (i2 == 1) {
            int i3 = (this.f12420c > zzi.f12420c ? 1 : (this.f12420c == zzi.f12420c ? 0 : -1));
            if (i3 < 0) {
                return -1;
            }
            return i3 == 0 ? 0 : 1;
        } else if (i2 == 2) {
            boolean z = this.f12421d;
            if (z == zzi.f12421d) {
                return 0;
            }
            return z ? 1 : -1;
        } else if (i2 == 3) {
            return Double.compare(this.f12422e, zzi.f12422e);
        } else {
            if (i2 == 4) {
                String str = this.f12423f;
                String str2 = zzi.f12423f;
                if (str == str2) {
                    return 0;
                }
                if (str == null) {
                    return -1;
                }
                if (str2 == null) {
                    return 1;
                }
                return str.compareTo(str2);
            } else if (i2 == 5) {
                byte[] bArr = this.f12424g;
                byte[] bArr2 = zzi.f12424g;
                if (bArr == bArr2) {
                    return 0;
                }
                if (bArr == null) {
                    return -1;
                }
                if (bArr2 == null) {
                    return 1;
                }
                for (int i4 = 0; i4 < Math.min(this.f12424g.length, zzi.f12424g.length); i4++) {
                    int i5 = this.f12424g[i4] - zzi.f12424g[i4];
                    if (i5 != 0) {
                        return i5;
                    }
                }
                return a(this.f12424g.length, zzi.f12424g.length);
            } else {
                StringBuilder sb = new StringBuilder(31);
                sb.append("Invalid enum value: ");
                sb.append(i2);
                throw new AssertionError(sb.toString());
            }
        }
    }

    public final boolean equals(Object obj) {
        int i2;
        if (obj instanceof zzi) {
            zzi zzi = (zzi) obj;
            if (l.a(this.f12418a, zzi.f12418a) && (i2 = this.f12425h) == zzi.f12425h && this.f12419b == zzi.f12419b) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        return this.f12421d == zzi.f12421d;
                    }
                    if (i2 == 3) {
                        return this.f12422e == zzi.f12422e;
                    }
                    if (i2 == 4) {
                        return l.a(this.f12423f, zzi.f12423f);
                    }
                    if (i2 == 5) {
                        return Arrays.equals(this.f12424g, zzi.f12424g);
                    }
                    StringBuilder sb = new StringBuilder(31);
                    sb.append("Invalid enum value: ");
                    sb.append(i2);
                    throw new AssertionError(sb.toString());
                } else if (this.f12420c == zzi.f12420c) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Flag(");
        sb.append(this.f12418a);
        sb.append(", ");
        int i2 = this.f12425h;
        if (i2 == 1) {
            sb.append(this.f12420c);
        } else if (i2 == 2) {
            sb.append(this.f12421d);
        } else if (i2 != 3) {
            if (i2 == 4) {
                sb.append("'");
                str = this.f12423f;
            } else if (i2 != 5) {
                String str2 = this.f12418a;
                StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 27);
                sb2.append("Invalid type: ");
                sb2.append(str2);
                sb2.append(", ");
                sb2.append(i2);
                throw new AssertionError(sb2.toString());
            } else if (this.f12424g == null) {
                sb.append("null");
            } else {
                sb.append("'");
                str = Base64.encodeToString(this.f12424g, 3);
            }
            sb.append(str);
            sb.append("'");
        } else {
            sb.append(this.f12422e);
        }
        sb.append(", ");
        sb.append(this.f12425h);
        sb.append(", ");
        sb.append(this.f12419b);
        sb.append(")");
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 2, this.f12418a, false);
        b.a(parcel, 3, this.f12420c);
        b.a(parcel, 4, this.f12421d);
        b.a(parcel, 5, this.f12422e);
        b.a(parcel, 6, this.f12423f, false);
        b.a(parcel, 7, this.f12424g, false);
        b.b(parcel, 8, this.f12425h);
        b.b(parcel, 9, this.f12419b);
        b.b(parcel, a2);
    }
}
