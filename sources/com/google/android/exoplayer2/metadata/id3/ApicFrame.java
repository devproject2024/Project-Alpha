package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.g.ae;
import java.util.Arrays;

public final class ApicFrame extends Id3Frame {
    public static final Parcelable.Creator<ApicFrame> CREATOR = new Parcelable.Creator<ApicFrame>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new ApicFrame[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ApicFrame(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f32679a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32680b;

    /* renamed from: c  reason: collision with root package name */
    public final int f32681c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f32682d;

    public ApicFrame(String str, String str2, int i2, byte[] bArr) {
        super("APIC");
        this.f32679a = str;
        this.f32680b = str2;
        this.f32681c = i2;
        this.f32682d = bArr;
    }

    ApicFrame(Parcel parcel) {
        super("APIC");
        this.f32679a = (String) ae.a(parcel.readString());
        this.f32680b = (String) ae.a(parcel.readString());
        this.f32681c = parcel.readInt();
        this.f32682d = (byte[]) ae.a(parcel.createByteArray());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ApicFrame apicFrame = (ApicFrame) obj;
            return this.f32681c == apicFrame.f32681c && ae.a((Object) this.f32679a, (Object) apicFrame.f32679a) && ae.a((Object) this.f32680b, (Object) apicFrame.f32680b) && Arrays.equals(this.f32682d, apicFrame.f32682d);
        }
    }

    public final int hashCode() {
        int i2 = (this.f32681c + 527) * 31;
        String str = this.f32679a;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f32680b;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return ((hashCode + i3) * 31) + Arrays.hashCode(this.f32682d);
    }

    public final String toString() {
        return this.f32702f + ": mimeType=" + this.f32679a + ", description=" + this.f32680b;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f32679a);
        parcel.writeString(this.f32680b);
        parcel.writeInt(this.f32681c);
        parcel.writeByteArray(this.f32682d);
    }
}
