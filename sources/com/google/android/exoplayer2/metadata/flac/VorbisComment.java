package com.google.android.exoplayer2.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.metadata.Metadata;

public final class VorbisComment implements Metadata.Entry {
    public static final Parcelable.Creator<VorbisComment> CREATOR = new Parcelable.Creator<VorbisComment>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new VorbisComment[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new VorbisComment(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f32668a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32669b;

    public /* synthetic */ Format a() {
        return Metadata.Entry.CC.$default$a(this);
    }

    public /* synthetic */ byte[] b() {
        return Metadata.Entry.CC.$default$b(this);
    }

    public final int describeContents() {
        return 0;
    }

    VorbisComment(Parcel parcel) {
        this.f32668a = (String) ae.a(parcel.readString());
        this.f32669b = (String) ae.a(parcel.readString());
    }

    public final String toString() {
        return "VC: " + this.f32668a + "=" + this.f32669b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            VorbisComment vorbisComment = (VorbisComment) obj;
            return this.f32668a.equals(vorbisComment.f32668a) && this.f32669b.equals(vorbisComment.f32669b);
        }
    }

    public final int hashCode() {
        return ((this.f32668a.hashCode() + 527) * 31) + this.f32669b.hashCode();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f32668a);
        parcel.writeString(this.f32669b);
    }
}
