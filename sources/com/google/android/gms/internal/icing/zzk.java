package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zzk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzk> CREATOR = new fl();

    /* renamed from: b  reason: collision with root package name */
    private static final int f10304b = Integer.parseInt(H5BridgeContext.INVALID_ID);

    /* renamed from: c  reason: collision with root package name */
    private static final zzt f10305c;

    /* renamed from: a  reason: collision with root package name */
    public final int f10306a;

    /* renamed from: d  reason: collision with root package name */
    private final String f10307d;

    /* renamed from: e  reason: collision with root package name */
    private final zzt f10308e;

    /* renamed from: f  reason: collision with root package name */
    private final byte[] f10309f;

    zzk(String str, zzt zzt, int i2, byte[] bArr) {
        String str2;
        boolean z = i2 == f10304b || fn.a(i2) != null;
        StringBuilder sb = new StringBuilder(32);
        sb.append("Invalid section type ");
        sb.append(i2);
        s.b(z, sb.toString());
        this.f10307d = str;
        this.f10308e = zzt;
        this.f10306a = i2;
        this.f10309f = bArr;
        int i3 = this.f10306a;
        if (i3 == f10304b || fn.a(i3) != null) {
            str2 = (this.f10307d == null || this.f10309f == null) ? null : "Both content and blobContent set";
        } else {
            int i4 = this.f10306a;
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append("Invalid section type ");
            sb2.append(i4);
            str2 = sb2.toString();
        }
        if (str2 != null) {
            throw new IllegalArgumentException(str2);
        }
    }

    static {
        fp fpVar = new fp("SsbContext");
        fpVar.f10244c = true;
        fpVar.f10243b = "blob";
        f10305c = new zzt(fpVar.f10242a, fpVar.f10243b, fpVar.f10244c, fpVar.f10245d, fpVar.f10246e, (String) null, (zzm[]) fpVar.f10247f.toArray(new zzm[fpVar.f10247f.size()]), fpVar.f10248g, (zzu) null);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f10307d, false);
        b.a(parcel, 3, this.f10308e, i2, false);
        b.b(parcel, 4, this.f10306a);
        b.a(parcel, 5, this.f10309f, false);
        b.b(parcel, a2);
    }
}
