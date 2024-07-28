package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.g.ae;
import java.util.Arrays;

public final class ChapterFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterFrame> CREATOR = new Parcelable.Creator<ChapterFrame>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new ChapterFrame[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ChapterFrame(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f32684a;

    /* renamed from: b  reason: collision with root package name */
    public final int f32685b;

    /* renamed from: c  reason: collision with root package name */
    public final int f32686c;

    /* renamed from: d  reason: collision with root package name */
    public final long f32687d;

    /* renamed from: e  reason: collision with root package name */
    public final long f32688e;

    /* renamed from: g  reason: collision with root package name */
    private final Id3Frame[] f32689g;

    public final int describeContents() {
        return 0;
    }

    public ChapterFrame(String str, int i2, int i3, long j, long j2, Id3Frame[] id3FrameArr) {
        super("CHAP");
        this.f32684a = str;
        this.f32685b = i2;
        this.f32686c = i3;
        this.f32687d = j;
        this.f32688e = j2;
        this.f32689g = id3FrameArr;
    }

    ChapterFrame(Parcel parcel) {
        super("CHAP");
        this.f32684a = (String) ae.a(parcel.readString());
        this.f32685b = parcel.readInt();
        this.f32686c = parcel.readInt();
        this.f32687d = parcel.readLong();
        this.f32688e = parcel.readLong();
        int readInt = parcel.readInt();
        this.f32689g = new Id3Frame[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f32689g[i2] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ChapterFrame chapterFrame = (ChapterFrame) obj;
            return this.f32685b == chapterFrame.f32685b && this.f32686c == chapterFrame.f32686c && this.f32687d == chapterFrame.f32687d && this.f32688e == chapterFrame.f32688e && ae.a((Object) this.f32684a, (Object) chapterFrame.f32684a) && Arrays.equals(this.f32689g, chapterFrame.f32689g);
        }
    }

    public final int hashCode() {
        int i2 = (((((((this.f32685b + 527) * 31) + this.f32686c) * 31) + ((int) this.f32687d)) * 31) + ((int) this.f32688e)) * 31;
        String str = this.f32684a;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f32684a);
        parcel.writeInt(this.f32685b);
        parcel.writeInt(this.f32686c);
        parcel.writeLong(this.f32687d);
        parcel.writeLong(this.f32688e);
        parcel.writeInt(this.f32689g.length);
        for (Id3Frame writeParcelable : this.f32689g) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }
}
