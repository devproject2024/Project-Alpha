package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ExperimentTokens extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ExperimentTokens> CREATOR = new g();

    /* renamed from: a  reason: collision with root package name */
    private static final byte[][] f12404a = new byte[0][];

    /* renamed from: b  reason: collision with root package name */
    private static final ExperimentTokens f12405b;
    private static final a k = new c();
    private static final a l = new d();
    private static final a m = new e();
    private static final a n = new f();

    /* renamed from: c  reason: collision with root package name */
    private final String f12406c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f12407d;

    /* renamed from: e  reason: collision with root package name */
    private final byte[][] f12408e;

    /* renamed from: f  reason: collision with root package name */
    private final byte[][] f12409f;

    /* renamed from: g  reason: collision with root package name */
    private final byte[][] f12410g;

    /* renamed from: h  reason: collision with root package name */
    private final byte[][] f12411h;

    /* renamed from: i  reason: collision with root package name */
    private final int[] f12412i;
    private final byte[][] j;

    interface a {
    }

    static {
        byte[][] bArr = f12404a;
        f12405b = new ExperimentTokens("", (byte[]) null, bArr, bArr, bArr, bArr, (int[]) null, (byte[][]) null);
    }

    public ExperimentTokens(String str, byte[] bArr, byte[][] bArr2, byte[][] bArr3, byte[][] bArr4, byte[][] bArr5, int[] iArr, byte[][] bArr6) {
        this.f12406c = str;
        this.f12407d = bArr;
        this.f12408e = bArr2;
        this.f12409f = bArr3;
        this.f12410g = bArr4;
        this.f12411h = bArr5;
        this.f12412i = iArr;
        this.j = bArr6;
    }

    private static List<Integer> a(int[] iArr) {
        if (iArr == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int valueOf : iArr) {
            arrayList.add(Integer.valueOf(valueOf));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static List<String> a(byte[][] bArr) {
        if (bArr == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte[] encodeToString : bArr) {
            arrayList.add(Base64.encodeToString(encodeToString, 3));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static void a(StringBuilder sb, String str, byte[][] bArr) {
        String str2;
        sb.append(str);
        sb.append("=");
        if (bArr == null) {
            str2 = "null";
        } else {
            sb.append("(");
            int length = bArr.length;
            int i2 = 0;
            boolean z = true;
            while (i2 < length) {
                byte[] bArr2 = bArr[i2];
                if (!z) {
                    sb.append(", ");
                }
                sb.append("'");
                sb.append(Base64.encodeToString(bArr2, 3));
                sb.append("'");
                i2++;
                z = false;
            }
            str2 = ")";
        }
        sb.append(str2);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ExperimentTokens) {
            ExperimentTokens experimentTokens = (ExperimentTokens) obj;
            return l.a(this.f12406c, experimentTokens.f12406c) && Arrays.equals(this.f12407d, experimentTokens.f12407d) && l.a(a(this.f12408e), a(experimentTokens.f12408e)) && l.a(a(this.f12409f), a(experimentTokens.f12409f)) && l.a(a(this.f12410g), a(experimentTokens.f12410g)) && l.a(a(this.f12411h), a(experimentTokens.f12411h)) && l.a(a(this.f12412i), a(experimentTokens.f12412i)) && l.a(a(this.j), a(experimentTokens.j));
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder("ExperimentTokens");
        sb.append("(");
        String str2 = this.f12406c;
        if (str2 == null) {
            str = "null";
        } else {
            StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 2);
            sb2.append("'");
            sb2.append(str2);
            sb2.append("'");
            str = sb2.toString();
        }
        sb.append(str);
        sb.append(", ");
        byte[] bArr = this.f12407d;
        sb.append("direct");
        sb.append("=");
        if (bArr == null) {
            sb.append("null");
        } else {
            sb.append("'");
            sb.append(Base64.encodeToString(bArr, 3));
            sb.append("'");
        }
        sb.append(", ");
        a(sb, "GAIA", this.f12408e);
        sb.append(", ");
        a(sb, "PSEUDO", this.f12409f);
        sb.append(", ");
        a(sb, "ALWAYS", this.f12410g);
        sb.append(", ");
        a(sb, "OTHER", this.f12411h);
        sb.append(", ");
        int[] iArr = this.f12412i;
        sb.append("weak");
        sb.append("=");
        if (iArr == null) {
            sb.append("null");
        } else {
            sb.append("(");
            int length = iArr.length;
            int i2 = 0;
            boolean z = true;
            while (i2 < length) {
                int i3 = iArr[i2];
                if (!z) {
                    sb.append(", ");
                }
                sb.append(i3);
                i2++;
                z = false;
            }
            sb.append(")");
        }
        sb.append(", ");
        a(sb, "directs", this.j);
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 2, this.f12406c, false);
        b.a(parcel, 3, this.f12407d, false);
        b.a(parcel, 4, this.f12408e);
        b.a(parcel, 5, this.f12409f);
        b.a(parcel, 6, this.f12410g);
        b.a(parcel, 7, this.f12411h);
        b.a(parcel, 8, this.f12412i);
        b.a(parcel, 9, this.j);
        b.b(parcel, a2);
    }
}
