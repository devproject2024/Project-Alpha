package com.arthurivanets.arvi.model;

import android.os.Parcel;
import android.os.Parcelable;

public final class VolumeInfo implements Parcelable {
    public static final Parcelable.Creator<VolumeInfo> CREATOR = new Parcelable.ClassLoaderCreator<VolumeInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new VolumeInfo(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new VolumeInfo[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new VolumeInfo(parcel, (byte) 0);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public float f31027a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f31028b;

    public final int describeContents() {
        return 0;
    }

    /* synthetic */ VolumeInfo(Parcel parcel, byte b2) {
        this(parcel);
    }

    public VolumeInfo() {
        this((byte) 0);
    }

    private VolumeInfo(byte b2) {
        this.f31027a = 1.0f;
        this.f31028b = false;
    }

    private VolumeInfo(Parcel parcel) {
        this.f31027a = parcel.readFloat();
        this.f31028b = parcel.readByte() != 0;
    }

    public final int hashCode() {
        return ((Float.floatToIntBits(this.f31027a) + 527) * 31) + (this.f31028b ? 1 : 0);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof VolumeInfo) && obj.hashCode() == hashCode();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeFloat(this.f31027a);
        parcel.writeByte(this.f31028b ? (byte) 1 : 0);
    }
}
