package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.g.ae;

public final class CommentFrame extends Id3Frame {
    public static final Parcelable.Creator<CommentFrame> CREATOR = new Parcelable.Creator<CommentFrame>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new CommentFrame[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CommentFrame(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f32695a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32696b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32697c;

    public CommentFrame(String str, String str2, String str3) {
        super("COMM");
        this.f32695a = str;
        this.f32696b = str2;
        this.f32697c = str3;
    }

    CommentFrame(Parcel parcel) {
        super("COMM");
        this.f32695a = (String) ae.a(parcel.readString());
        this.f32696b = (String) ae.a(parcel.readString());
        this.f32697c = (String) ae.a(parcel.readString());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            CommentFrame commentFrame = (CommentFrame) obj;
            return ae.a((Object) this.f32696b, (Object) commentFrame.f32696b) && ae.a((Object) this.f32695a, (Object) commentFrame.f32695a) && ae.a((Object) this.f32697c, (Object) commentFrame.f32697c);
        }
    }

    public final int hashCode() {
        String str = this.f32695a;
        int i2 = 0;
        int hashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.f32696b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f32697c;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return this.f32702f + ": language=" + this.f32695a + ", description=" + this.f32696b;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f32702f);
        parcel.writeString(this.f32695a);
        parcel.writeString(this.f32697c);
    }
}
