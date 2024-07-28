package com.google.android.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.a;
import java.util.Arrays;

public final class TrackGroup implements Parcelable {
    public static final Parcelable.Creator<TrackGroup> CREATOR = new Parcelable.Creator<TrackGroup>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new TrackGroup[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new TrackGroup(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final int f32780a;

    /* renamed from: b  reason: collision with root package name */
    public final Format[] f32781b;

    /* renamed from: c  reason: collision with root package name */
    private int f32782c;

    public final int describeContents() {
        return 0;
    }

    public TrackGroup(Format... formatArr) {
        a.b(formatArr.length > 0);
        this.f32781b = formatArr;
        this.f32780a = formatArr.length;
    }

    TrackGroup(Parcel parcel) {
        this.f32780a = parcel.readInt();
        this.f32781b = new Format[this.f32780a];
        for (int i2 = 0; i2 < this.f32780a; i2++) {
            this.f32781b[i2] = (Format) parcel.readParcelable(Format.class.getClassLoader());
        }
    }

    public final int a(Format format) {
        int i2 = 0;
        while (true) {
            Format[] formatArr = this.f32781b;
            if (i2 >= formatArr.length) {
                return -1;
            }
            if (format == formatArr[i2]) {
                return i2;
            }
            i2++;
        }
    }

    public final int hashCode() {
        if (this.f32782c == 0) {
            this.f32782c = Arrays.hashCode(this.f32781b) + 527;
        }
        return this.f32782c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            TrackGroup trackGroup = (TrackGroup) obj;
            return this.f32780a == trackGroup.f32780a && Arrays.equals(this.f32781b, trackGroup.f32781b);
        }
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f32780a);
        for (int i3 = 0; i3 < this.f32780a; i3++) {
            parcel.writeParcelable(this.f32781b[i3], 0);
        }
    }
}
