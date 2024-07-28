package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.clearcut.a;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.clearcut.ga;
import com.google.android.gms.internal.clearcut.zzr;
import com.google.android.gms.phenotype.ExperimentTokens;
import java.util.Arrays;

public final class zze extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zze> CREATOR = new e();

    /* renamed from: a  reason: collision with root package name */
    public zzr f8319a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f8320b;

    /* renamed from: c  reason: collision with root package name */
    public final ga f8321c;

    /* renamed from: d  reason: collision with root package name */
    public final a.c f8322d;

    /* renamed from: e  reason: collision with root package name */
    public final a.c f8323e;

    /* renamed from: f  reason: collision with root package name */
    private int[] f8324f;

    /* renamed from: g  reason: collision with root package name */
    private String[] f8325g;

    /* renamed from: h  reason: collision with root package name */
    private int[] f8326h;

    /* renamed from: i  reason: collision with root package name */
    private byte[][] f8327i;
    private ExperimentTokens[] j;
    private boolean k;

    public zze(zzr zzr, ga gaVar, int[] iArr, int[] iArr2, boolean z) {
        this.f8319a = zzr;
        this.f8321c = gaVar;
        this.f8322d = null;
        this.f8323e = null;
        this.f8324f = iArr;
        this.f8325g = null;
        this.f8326h = iArr2;
        this.f8327i = null;
        this.j = null;
        this.k = z;
    }

    zze(zzr zzr, byte[] bArr, int[] iArr, String[] strArr, int[] iArr2, byte[][] bArr2, boolean z, ExperimentTokens[] experimentTokensArr) {
        this.f8319a = zzr;
        this.f8320b = bArr;
        this.f8324f = iArr;
        this.f8325g = strArr;
        this.f8321c = null;
        this.f8322d = null;
        this.f8323e = null;
        this.f8326h = iArr2;
        this.f8327i = bArr2;
        this.j = experimentTokensArr;
        this.k = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zze) {
            zze zze = (zze) obj;
            return q.a(this.f8319a, zze.f8319a) && Arrays.equals(this.f8320b, zze.f8320b) && Arrays.equals(this.f8324f, zze.f8324f) && Arrays.equals(this.f8325g, zze.f8325g) && q.a(this.f8321c, zze.f8321c) && q.a(this.f8322d, zze.f8322d) && q.a(this.f8323e, zze.f8323e) && Arrays.equals(this.f8326h, zze.f8326h) && Arrays.deepEquals(this.f8327i, zze.f8327i) && Arrays.equals(this.j, zze.j) && this.k == zze.k;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LogEventParcelable[");
        sb.append(this.f8319a);
        sb.append(", LogEventBytes: ");
        byte[] bArr = this.f8320b;
        sb.append(bArr == null ? null : new String(bArr));
        sb.append(", TestCodes: ");
        sb.append(Arrays.toString(this.f8324f));
        sb.append(", MendelPackages: ");
        sb.append(Arrays.toString(this.f8325g));
        sb.append(", LogEvent: ");
        sb.append(this.f8321c);
        sb.append(", ExtensionProducer: ");
        sb.append(this.f8322d);
        sb.append(", VeProducer: ");
        sb.append(this.f8323e);
        sb.append(", ExperimentIDs: ");
        sb.append(Arrays.toString(this.f8326h));
        sb.append(", ExperimentTokens: ");
        sb.append(Arrays.toString(this.f8327i));
        sb.append(", ExperimentTokensParcelables: ");
        sb.append(Arrays.toString(this.j));
        sb.append(", AddPhenotypeExperimentTokens: ");
        sb.append(this.k);
        sb.append("]");
        return sb.toString();
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8319a, this.f8320b, this.f8324f, this.f8325g, this.f8321c, this.f8322d, this.f8323e, this.f8326h, this.f8327i, this.j, Boolean.valueOf(this.k)});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 2, this.f8319a, i2, false);
        b.a(parcel, 3, this.f8320b, false);
        b.a(parcel, 4, this.f8324f);
        b.a(parcel, 5, this.f8325g);
        b.a(parcel, 6, this.f8326h);
        b.a(parcel, 7, this.f8327i);
        b.a(parcel, 8, this.k);
        b.a(parcel, 9, (T[]) this.j, i2);
        b.b(parcel, a2);
    }
}
