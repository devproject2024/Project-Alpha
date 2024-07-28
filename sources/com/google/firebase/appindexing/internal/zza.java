package com.google.firebase.appindexing.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.firebase.appindexing.a;

public final class zza extends AbstractSafeParcelable implements a {
    public static final Parcelable.Creator<zza> CREATOR = new f();

    /* renamed from: a  reason: collision with root package name */
    final zzc f38043a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38044b;

    /* renamed from: c  reason: collision with root package name */
    private final String f38045c;

    /* renamed from: d  reason: collision with root package name */
    private final String f38046d;

    /* renamed from: e  reason: collision with root package name */
    private final String f38047e;

    /* renamed from: f  reason: collision with root package name */
    private final String f38048f;

    /* renamed from: g  reason: collision with root package name */
    private final Bundle f38049g;

    public zza(String str, String str2, String str3, String str4, zzc zzc, String str5, Bundle bundle) {
        this.f38044b = str;
        this.f38045c = str2;
        this.f38046d = str3;
        this.f38047e = str4;
        this.f38043a = zzc;
        this.f38048f = str5;
        if (bundle != null) {
            this.f38049g = bundle;
        } else {
            this.f38049g = Bundle.EMPTY;
        }
        this.f38049g.setClassLoader(getClass().getClassLoader());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ActionImpl { ");
        sb.append("{ actionType: '");
        sb.append(this.f38044b);
        sb.append("' } ");
        sb.append("{ objectName: '");
        sb.append(this.f38045c);
        sb.append("' } ");
        sb.append("{ objectUrl: '");
        sb.append(this.f38046d);
        sb.append("' } ");
        if (this.f38047e != null) {
            sb.append("{ objectSameAs: '");
            sb.append(this.f38047e);
            sb.append("' } ");
        }
        if (this.f38043a != null) {
            sb.append("{ metadata: '");
            sb.append(this.f38043a.toString());
            sb.append("' } ");
        }
        if (this.f38048f != null) {
            sb.append("{ actionStatus: '");
            sb.append(this.f38048f);
            sb.append("' } ");
        }
        if (!this.f38049g.isEmpty()) {
            sb.append("{ ");
            sb.append(this.f38049g);
            sb.append(" } ");
        }
        sb.append("}");
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.a(parcel, 1, this.f38044b, false);
        b.a(parcel, 2, this.f38045c, false);
        b.a(parcel, 3, this.f38046d, false);
        b.a(parcel, 4, this.f38047e, false);
        b.a(parcel, 5, this.f38043a, i2, false);
        b.a(parcel, 6, this.f38048f, false);
        b.a(parcel, 7, this.f38049g);
        b.b(parcel, a2);
    }
}
