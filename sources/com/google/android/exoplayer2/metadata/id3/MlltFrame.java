package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.g.ae;
import java.util.Arrays;

public final class MlltFrame extends Id3Frame {
    public static final Parcelable.Creator<MlltFrame> CREATOR = new Parcelable.Creator<MlltFrame>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new MlltFrame[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new MlltFrame(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final int f32706a;

    /* renamed from: b  reason: collision with root package name */
    public final int f32707b;

    /* renamed from: c  reason: collision with root package name */
    public final int f32708c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f32709d;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f32710e;

    public final int describeContents() {
        return 0;
    }

    public MlltFrame(int i2, int i3, int i4, int[] iArr, int[] iArr2) {
        super("MLLT");
        this.f32706a = i2;
        this.f32707b = i3;
        this.f32708c = i4;
        this.f32709d = iArr;
        this.f32710e = iArr2;
    }

    MlltFrame(Parcel parcel) {
        super("MLLT");
        this.f32706a = parcel.readInt();
        this.f32707b = parcel.readInt();
        this.f32708c = parcel.readInt();
        this.f32709d = (int[]) ae.a(parcel.createIntArray());
        this.f32710e = (int[]) ae.a(parcel.createIntArray());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            MlltFrame mlltFrame = (MlltFrame) obj;
            return this.f32706a == mlltFrame.f32706a && this.f32707b == mlltFrame.f32707b && this.f32708c == mlltFrame.f32708c && Arrays.equals(this.f32709d, mlltFrame.f32709d) && Arrays.equals(this.f32710e, mlltFrame.f32710e);
        }
    }

    public final int hashCode() {
        return ((((((((this.f32706a + 527) * 31) + this.f32707b) * 31) + this.f32708c) * 31) + Arrays.hashCode(this.f32709d)) * 31) + Arrays.hashCode(this.f32710e);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f32706a);
        parcel.writeInt(this.f32707b);
        parcel.writeInt(this.f32708c);
        parcel.writeIntArray(this.f32709d);
        parcel.writeIntArray(this.f32710e);
    }
}
