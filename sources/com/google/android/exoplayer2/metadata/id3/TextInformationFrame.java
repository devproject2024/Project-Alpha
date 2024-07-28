package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.g.ae;

public final class TextInformationFrame extends Id3Frame {
    public static final Parcelable.Creator<TextInformationFrame> CREATOR = new Parcelable.Creator<TextInformationFrame>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new TextInformationFrame[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new TextInformationFrame(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f32713a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32714b;

    public TextInformationFrame(String str, String str2, String str3) {
        super(str);
        this.f32713a = str2;
        this.f32714b = str3;
    }

    TextInformationFrame(Parcel parcel) {
        super((String) ae.a(parcel.readString()));
        this.f32713a = parcel.readString();
        this.f32714b = (String) ae.a(parcel.readString());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            TextInformationFrame textInformationFrame = (TextInformationFrame) obj;
            return this.f32702f.equals(textInformationFrame.f32702f) && ae.a((Object) this.f32713a, (Object) textInformationFrame.f32713a) && ae.a((Object) this.f32714b, (Object) textInformationFrame.f32714b);
        }
    }

    public final int hashCode() {
        int hashCode = (this.f32702f.hashCode() + 527) * 31;
        String str = this.f32713a;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f32714b;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return this.f32702f + ": description=" + this.f32713a + ": value=" + this.f32714b;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f32702f);
        parcel.writeString(this.f32713a);
        parcel.writeString(this.f32714b);
    }
}
