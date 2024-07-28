package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.g.ae;
import java.util.Arrays;

public final class GeobFrame extends Id3Frame {
    public static final Parcelable.Creator<GeobFrame> CREATOR = new Parcelable.Creator<GeobFrame>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new GeobFrame[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new GeobFrame(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f32698a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32699b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32700c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f32701d;

    public GeobFrame(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.f32698a = str;
        this.f32699b = str2;
        this.f32700c = str3;
        this.f32701d = bArr;
    }

    GeobFrame(Parcel parcel) {
        super("GEOB");
        this.f32698a = (String) ae.a(parcel.readString());
        this.f32699b = (String) ae.a(parcel.readString());
        this.f32700c = (String) ae.a(parcel.readString());
        this.f32701d = (byte[]) ae.a(parcel.createByteArray());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            GeobFrame geobFrame = (GeobFrame) obj;
            return ae.a((Object) this.f32698a, (Object) geobFrame.f32698a) && ae.a((Object) this.f32699b, (Object) geobFrame.f32699b) && ae.a((Object) this.f32700c, (Object) geobFrame.f32700c) && Arrays.equals(this.f32701d, geobFrame.f32701d);
        }
    }

    public final int hashCode() {
        String str = this.f32698a;
        int i2 = 0;
        int hashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.f32699b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f32700c;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return ((hashCode2 + i2) * 31) + Arrays.hashCode(this.f32701d);
    }

    public final String toString() {
        return this.f32702f + ": mimeType=" + this.f32698a + ", filename=" + this.f32699b + ", description=" + this.f32700c;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f32698a);
        parcel.writeString(this.f32699b);
        parcel.writeString(this.f32700c);
        parcel.writeByteArray(this.f32701d);
    }
}
