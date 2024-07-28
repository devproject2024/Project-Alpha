package com.google.android.exoplayer2.offline;

import android.os.Parcel;
import android.os.Parcelable;
import com.business.merchant_payments.common.utility.AppUtility;

public final class StreamKey implements Parcelable, Comparable<StreamKey> {
    public static final Parcelable.Creator<StreamKey> CREATOR = new Parcelable.Creator<StreamKey>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new StreamKey[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new StreamKey(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final int f32765a;

    /* renamed from: b  reason: collision with root package name */
    public final int f32766b;

    /* renamed from: c  reason: collision with root package name */
    public final int f32767c;

    public final int describeContents() {
        return 0;
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        StreamKey streamKey = (StreamKey) obj;
        int i2 = this.f32765a - streamKey.f32765a;
        if (i2 != 0) {
            return i2;
        }
        int i3 = this.f32766b - streamKey.f32766b;
        return i3 == 0 ? this.f32767c - streamKey.f32767c : i3;
    }

    public StreamKey() {
        this.f32765a = -1;
        this.f32766b = -1;
        this.f32767c = -1;
    }

    StreamKey(Parcel parcel) {
        this.f32765a = parcel.readInt();
        this.f32766b = parcel.readInt();
        this.f32767c = parcel.readInt();
    }

    public final String toString() {
        return this.f32765a + AppUtility.CENTER_DOT + this.f32766b + AppUtility.CENTER_DOT + this.f32767c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            StreamKey streamKey = (StreamKey) obj;
            return this.f32765a == streamKey.f32765a && this.f32766b == streamKey.f32766b && this.f32767c == streamKey.f32767c;
        }
    }

    public final int hashCode() {
        return (((this.f32765a * 31) + this.f32766b) * 31) + this.f32767c;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f32765a);
        parcel.writeInt(this.f32766b);
        parcel.writeInt(this.f32767c);
    }
}
