package com.google.firebase.appindexing.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzc> CREATOR = new x();

    /* renamed from: a  reason: collision with root package name */
    int f38050a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f38051b;

    /* renamed from: c  reason: collision with root package name */
    private final String f38052c;

    /* renamed from: d  reason: collision with root package name */
    private final String f38053d;

    /* renamed from: e  reason: collision with root package name */
    private final byte[] f38054e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f38055f;

    zzc(int i2, boolean z, String str, String str2, byte[] bArr, boolean z2) {
        this.f38050a = i2;
        this.f38051b = z;
        this.f38052c = str;
        this.f38053d = str2;
        this.f38054e = bArr;
        this.f38055f = z2;
    }

    public zzc(boolean z) {
        this.f38051b = z;
        this.f38052c = null;
        this.f38053d = null;
        this.f38054e = null;
        this.f38055f = false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MetadataImpl { ");
        sb.append("{ eventStatus: '");
        sb.append(this.f38050a);
        sb.append("' } ");
        sb.append("{ uploadable: '");
        sb.append(this.f38051b);
        sb.append("' } ");
        if (this.f38052c != null) {
            sb.append("{ completionToken: '");
            sb.append(this.f38052c);
            sb.append("' } ");
        }
        if (this.f38053d != null) {
            sb.append("{ accountName: '");
            sb.append(this.f38053d);
            sb.append("' } ");
        }
        if (this.f38054e != null) {
            sb.append("{ ssbContext: [ ");
            for (byte hexString : this.f38054e) {
                sb.append("0x");
                sb.append(Integer.toHexString(hexString));
                sb.append(" ");
            }
            sb.append("] } ");
        }
        sb.append("{ contextOnly: '");
        sb.append(this.f38055f);
        sb.append("' } ");
        sb.append("}");
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 1, this.f38050a);
        b.a(parcel, 2, this.f38051b);
        b.a(parcel, 3, this.f38052c, false);
        b.a(parcel, 4, this.f38053d, false);
        b.a(parcel, 5, this.f38054e, false);
        b.a(parcel, 6, this.f38055f);
        b.b(parcel, a2);
    }
}
