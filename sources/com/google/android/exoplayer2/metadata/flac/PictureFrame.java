package com.google.android.exoplayer2.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.Arrays;

public final class PictureFrame implements Metadata.Entry {
    public static final Parcelable.Creator<PictureFrame> CREATOR = new Parcelable.Creator<PictureFrame>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new PictureFrame[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PictureFrame(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final int f32660a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32661b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32662c;

    /* renamed from: d  reason: collision with root package name */
    public final int f32663d;

    /* renamed from: e  reason: collision with root package name */
    public final int f32664e;

    /* renamed from: f  reason: collision with root package name */
    public final int f32665f;

    /* renamed from: g  reason: collision with root package name */
    public final int f32666g;

    /* renamed from: h  reason: collision with root package name */
    public final byte[] f32667h;

    public /* synthetic */ Format a() {
        return Metadata.Entry.CC.$default$a(this);
    }

    public /* synthetic */ byte[] b() {
        return Metadata.Entry.CC.$default$b(this);
    }

    public final int describeContents() {
        return 0;
    }

    PictureFrame(Parcel parcel) {
        this.f32660a = parcel.readInt();
        this.f32661b = (String) ae.a(parcel.readString());
        this.f32662c = (String) ae.a(parcel.readString());
        this.f32663d = parcel.readInt();
        this.f32664e = parcel.readInt();
        this.f32665f = parcel.readInt();
        this.f32666g = parcel.readInt();
        this.f32667h = (byte[]) ae.a(parcel.createByteArray());
    }

    public final String toString() {
        return "Picture: mimeType=" + this.f32661b + ", description=" + this.f32662c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PictureFrame pictureFrame = (PictureFrame) obj;
            return this.f32660a == pictureFrame.f32660a && this.f32661b.equals(pictureFrame.f32661b) && this.f32662c.equals(pictureFrame.f32662c) && this.f32663d == pictureFrame.f32663d && this.f32664e == pictureFrame.f32664e && this.f32665f == pictureFrame.f32665f && this.f32666g == pictureFrame.f32666g && Arrays.equals(this.f32667h, pictureFrame.f32667h);
        }
    }

    public final int hashCode() {
        return ((((((((((((((this.f32660a + 527) * 31) + this.f32661b.hashCode()) * 31) + this.f32662c.hashCode()) * 31) + this.f32663d) * 31) + this.f32664e) * 31) + this.f32665f) * 31) + this.f32666g) * 31) + Arrays.hashCode(this.f32667h);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f32660a);
        parcel.writeString(this.f32661b);
        parcel.writeString(this.f32662c);
        parcel.writeInt(this.f32663d);
        parcel.writeInt(this.f32664e);
        parcel.writeInt(this.f32665f);
        parcel.writeInt(this.f32666g);
        parcel.writeByteArray(this.f32667h);
    }
}
