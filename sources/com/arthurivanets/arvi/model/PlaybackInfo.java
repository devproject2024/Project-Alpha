package com.arthurivanets.arvi.model;

import android.os.Parcel;
import android.os.Parcelable;

public final class PlaybackInfo implements Parcelable {
    public static final Parcelable.Creator<PlaybackInfo> CREATOR = new Parcelable.ClassLoaderCreator<PlaybackInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new PlaybackInfo(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new PlaybackInfo[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PlaybackInfo(parcel, (byte) 0);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public long f31023a;

    /* renamed from: b  reason: collision with root package name */
    public VolumeInfo f31024b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f31025c;

    /* renamed from: d  reason: collision with root package name */
    private long f31026d;

    public final int describeContents() {
        return 0;
    }

    /* synthetic */ PlaybackInfo(Parcel parcel, byte b2) {
        this(parcel);
    }

    public PlaybackInfo() {
        this.f31023a = 0;
        this.f31026d = 0;
        this.f31024b = new VolumeInfo();
        this.f31025c = false;
    }

    private PlaybackInfo(Parcel parcel) {
        this.f31023a = parcel.readLong();
        this.f31026d = parcel.readLong();
        this.f31024b = (VolumeInfo) parcel.readParcelable(VolumeInfo.class.getClassLoader());
        this.f31025c = parcel.readByte() != 0;
    }

    public final int hashCode() {
        return ((((((Long.valueOf(this.f31023a).hashCode() + 527) * 31) + Long.valueOf(this.f31026d).hashCode()) * 31) + this.f31024b.hashCode()) * 31) + (this.f31025c ? 1 : 0);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof PlaybackInfo) && obj.hashCode() == hashCode();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f31023a);
        parcel.writeLong(this.f31026d);
        parcel.writeParcelable(this.f31024b, i2);
        parcel.writeByte(this.f31025c ? (byte) 1 : 0);
    }
}
