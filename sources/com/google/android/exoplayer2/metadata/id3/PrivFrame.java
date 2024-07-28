package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.g.ae;
import java.util.Arrays;

public final class PrivFrame extends Id3Frame {
    public static final Parcelable.Creator<PrivFrame> CREATOR = new Parcelable.Creator<PrivFrame>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new PrivFrame[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PrivFrame(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f32711a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f32712b;

    public PrivFrame(String str, byte[] bArr) {
        super("PRIV");
        this.f32711a = str;
        this.f32712b = bArr;
    }

    PrivFrame(Parcel parcel) {
        super("PRIV");
        this.f32711a = (String) ae.a(parcel.readString());
        this.f32712b = (byte[]) ae.a(parcel.createByteArray());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PrivFrame privFrame = (PrivFrame) obj;
            return ae.a((Object) this.f32711a, (Object) privFrame.f32711a) && Arrays.equals(this.f32712b, privFrame.f32712b);
        }
    }

    public final int hashCode() {
        String str = this.f32711a;
        return (((str != null ? str.hashCode() : 0) + 527) * 31) + Arrays.hashCode(this.f32712b);
    }

    public final String toString() {
        return this.f32702f + ": owner=" + this.f32711a;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f32711a);
        parcel.writeByteArray(this.f32712b);
    }
}
