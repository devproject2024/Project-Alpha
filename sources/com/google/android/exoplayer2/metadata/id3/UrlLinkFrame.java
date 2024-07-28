package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.g.ae;

public final class UrlLinkFrame extends Id3Frame {
    public static final Parcelable.Creator<UrlLinkFrame> CREATOR = new Parcelable.Creator<UrlLinkFrame>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new UrlLinkFrame[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new UrlLinkFrame(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f32715a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32716b;

    public UrlLinkFrame(String str, String str2, String str3) {
        super(str);
        this.f32715a = str2;
        this.f32716b = str3;
    }

    UrlLinkFrame(Parcel parcel) {
        super((String) ae.a(parcel.readString()));
        this.f32715a = parcel.readString();
        this.f32716b = (String) ae.a(parcel.readString());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            UrlLinkFrame urlLinkFrame = (UrlLinkFrame) obj;
            return this.f32702f.equals(urlLinkFrame.f32702f) && ae.a((Object) this.f32715a, (Object) urlLinkFrame.f32715a) && ae.a((Object) this.f32716b, (Object) urlLinkFrame.f32716b);
        }
    }

    public final int hashCode() {
        int hashCode = (this.f32702f.hashCode() + 527) * 31;
        String str = this.f32715a;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f32716b;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return this.f32702f + ": url=" + this.f32716b;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f32702f);
        parcel.writeString(this.f32715a);
        parcel.writeString(this.f32716b);
    }
}
