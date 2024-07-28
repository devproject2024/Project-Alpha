package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.l;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

public final class zzo extends AbstractSafeParcelable implements l {
    public static final Parcelable.Creator<zzo> CREATOR = new fo();

    /* renamed from: a  reason: collision with root package name */
    private Status f10312a;

    /* renamed from: b  reason: collision with root package name */
    private List<zzw> f10313b;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    private String[] f10314c;

    public zzo() {
    }

    public final Status a() {
        return this.f10312a;
    }

    zzo(Status status, List<zzw> list, String[] strArr) {
        this.f10312a = status;
        this.f10313b = list;
        this.f10314c = strArr;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f10312a, i2, false);
        b.a(parcel, 2, this.f10313b, false);
        b.a(parcel, 3, this.f10314c);
        b.b(parcel, a2);
    }
}
