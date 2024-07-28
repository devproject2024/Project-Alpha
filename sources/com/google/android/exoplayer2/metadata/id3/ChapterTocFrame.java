package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.g.ae;
import java.util.Arrays;

public final class ChapterTocFrame extends Id3Frame {
    public static final Parcelable.Creator<ChapterTocFrame> CREATOR = new Parcelable.Creator<ChapterTocFrame>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new ChapterTocFrame[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ChapterTocFrame(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f32690a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f32691b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f32692c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f32693d;

    /* renamed from: e  reason: collision with root package name */
    private final Id3Frame[] f32694e;

    public ChapterTocFrame(String str, boolean z, boolean z2, String[] strArr, Id3Frame[] id3FrameArr) {
        super("CTOC");
        this.f32690a = str;
        this.f32691b = z;
        this.f32692c = z2;
        this.f32693d = strArr;
        this.f32694e = id3FrameArr;
    }

    ChapterTocFrame(Parcel parcel) {
        super("CTOC");
        this.f32690a = (String) ae.a(parcel.readString());
        boolean z = true;
        this.f32691b = parcel.readByte() != 0;
        this.f32692c = parcel.readByte() == 0 ? false : z;
        this.f32693d = (String[]) ae.a(parcel.createStringArray());
        int readInt = parcel.readInt();
        this.f32694e = new Id3Frame[readInt];
        for (int i2 = 0; i2 < readInt; i2++) {
            this.f32694e[i2] = (Id3Frame) parcel.readParcelable(Id3Frame.class.getClassLoader());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ChapterTocFrame chapterTocFrame = (ChapterTocFrame) obj;
            return this.f32691b == chapterTocFrame.f32691b && this.f32692c == chapterTocFrame.f32692c && ae.a((Object) this.f32690a, (Object) chapterTocFrame.f32690a) && Arrays.equals(this.f32693d, chapterTocFrame.f32693d) && Arrays.equals(this.f32694e, chapterTocFrame.f32694e);
        }
    }

    public final int hashCode() {
        int i2 = ((((this.f32691b ? 1 : 0) + true) * 31) + (this.f32692c ? 1 : 0)) * 31;
        String str = this.f32690a;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f32690a);
        parcel.writeByte(this.f32691b ? (byte) 1 : 0);
        parcel.writeByte(this.f32692c ? (byte) 1 : 0);
        parcel.writeStringArray(this.f32693d);
        parcel.writeInt(this.f32694e.length);
        for (Id3Frame writeParcelable : this.f32694e) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }
}
