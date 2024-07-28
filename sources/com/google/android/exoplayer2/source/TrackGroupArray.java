package com.google.android.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public final class TrackGroupArray implements Parcelable {
    public static final Parcelable.Creator<TrackGroupArray> CREATOR = new Parcelable.Creator<TrackGroupArray>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new TrackGroupArray[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new TrackGroupArray(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public static final TrackGroupArray f32783a = new TrackGroupArray(new TrackGroup[0]);

    /* renamed from: b  reason: collision with root package name */
    public final int f32784b;

    /* renamed from: c  reason: collision with root package name */
    public final TrackGroup[] f32785c;

    /* renamed from: d  reason: collision with root package name */
    private int f32786d;

    public final int describeContents() {
        return 0;
    }

    public TrackGroupArray(TrackGroup... trackGroupArr) {
        this.f32785c = trackGroupArr;
        this.f32784b = trackGroupArr.length;
    }

    TrackGroupArray(Parcel parcel) {
        this.f32784b = parcel.readInt();
        this.f32785c = new TrackGroup[this.f32784b];
        for (int i2 = 0; i2 < this.f32784b; i2++) {
            this.f32785c[i2] = (TrackGroup) parcel.readParcelable(TrackGroup.class.getClassLoader());
        }
    }

    public final int a(TrackGroup trackGroup) {
        for (int i2 = 0; i2 < this.f32784b; i2++) {
            if (this.f32785c[i2] == trackGroup) {
                return i2;
            }
        }
        return -1;
    }

    public final boolean a() {
        return this.f32784b == 0;
    }

    public final int hashCode() {
        if (this.f32786d == 0) {
            this.f32786d = Arrays.hashCode(this.f32785c);
        }
        return this.f32786d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            TrackGroupArray trackGroupArray = (TrackGroupArray) obj;
            return this.f32784b == trackGroupArray.f32784b && Arrays.equals(this.f32785c, trackGroupArray.f32785c);
        }
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f32784b);
        for (int i3 = 0; i3 < this.f32784b; i3++) {
            parcel.writeParcelable(this.f32785c[i3], 0);
        }
    }
}
