package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.g.ae;
import java.util.Arrays;

public final class BinaryFrame extends Id3Frame {
    public static final Parcelable.Creator<BinaryFrame> CREATOR = new Parcelable.Creator<BinaryFrame>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new BinaryFrame[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BinaryFrame(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f32683a;

    public BinaryFrame(String str, byte[] bArr) {
        super(str);
        this.f32683a = bArr;
    }

    BinaryFrame(Parcel parcel) {
        super((String) ae.a(parcel.readString()));
        this.f32683a = (byte[]) ae.a(parcel.createByteArray());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            BinaryFrame binaryFrame = (BinaryFrame) obj;
            return this.f32702f.equals(binaryFrame.f32702f) && Arrays.equals(this.f32683a, binaryFrame.f32683a);
        }
    }

    public final int hashCode() {
        return ((this.f32702f.hashCode() + 527) * 31) + Arrays.hashCode(this.f32683a);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f32702f);
        parcel.writeByteArray(this.f32683a);
    }
}
