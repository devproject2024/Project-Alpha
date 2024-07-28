package com.google.android.exoplayer2.video;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.g.ae;
import java.util.Arrays;

public final class ColorInfo implements Parcelable {
    public static final Parcelable.Creator<ColorInfo> CREATOR = new Parcelable.Creator<ColorInfo>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new ColorInfo[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ColorInfo(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final int f33647a;

    /* renamed from: b  reason: collision with root package name */
    public final int f33648b;

    /* renamed from: c  reason: collision with root package name */
    public final int f33649c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f33650d;

    /* renamed from: e  reason: collision with root package name */
    private int f33651e;

    public final int describeContents() {
        return 0;
    }

    public ColorInfo(int i2, int i3, int i4, byte[] bArr) {
        this.f33647a = i2;
        this.f33648b = i3;
        this.f33649c = i4;
        this.f33650d = bArr;
    }

    ColorInfo(Parcel parcel) {
        this.f33647a = parcel.readInt();
        this.f33648b = parcel.readInt();
        this.f33649c = parcel.readInt();
        this.f33650d = ae.a(parcel) ? parcel.createByteArray() : null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ColorInfo colorInfo = (ColorInfo) obj;
            return this.f33647a == colorInfo.f33647a && this.f33648b == colorInfo.f33648b && this.f33649c == colorInfo.f33649c && Arrays.equals(this.f33650d, colorInfo.f33650d);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ColorInfo(");
        sb.append(this.f33647a);
        sb.append(", ");
        sb.append(this.f33648b);
        sb.append(", ");
        sb.append(this.f33649c);
        sb.append(", ");
        sb.append(this.f33650d != null);
        sb.append(")");
        return sb.toString();
    }

    public final int hashCode() {
        if (this.f33651e == 0) {
            this.f33651e = ((((((this.f33647a + 527) * 31) + this.f33648b) * 31) + this.f33649c) * 31) + Arrays.hashCode(this.f33650d);
        }
        return this.f33651e;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f33647a);
        parcel.writeInt(this.f33648b);
        parcel.writeInt(this.f33649c);
        ae.a(parcel, this.f33650d != null);
        byte[] bArr = this.f33650d;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }
}
