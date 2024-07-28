package com.google.android.exoplayer2.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.metadata.Metadata;

public final class IcyInfo implements Metadata.Entry {
    public static final Parcelable.Creator<IcyInfo> CREATOR = new Parcelable.Creator<IcyInfo>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new IcyInfo[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new IcyInfo(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f32676a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32677b;

    public /* synthetic */ Format a() {
        return Metadata.Entry.CC.$default$a(this);
    }

    public /* synthetic */ byte[] b() {
        return Metadata.Entry.CC.$default$b(this);
    }

    public final int describeContents() {
        return 0;
    }

    public IcyInfo(String str, String str2) {
        this.f32676a = str;
        this.f32677b = str2;
    }

    IcyInfo(Parcel parcel) {
        this.f32676a = parcel.readString();
        this.f32677b = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            IcyInfo icyInfo = (IcyInfo) obj;
            return ae.a((Object) this.f32676a, (Object) icyInfo.f32676a) && ae.a((Object) this.f32677b, (Object) icyInfo.f32677b);
        }
    }

    public final int hashCode() {
        String str = this.f32676a;
        int i2 = 0;
        int hashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.f32677b;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "ICY: title=\"" + this.f32676a + "\", url=\"" + this.f32677b + "\"";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f32676a);
        parcel.writeString(this.f32677b);
    }
}
