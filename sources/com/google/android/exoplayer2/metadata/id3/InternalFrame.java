package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.g.ae;

public final class InternalFrame extends Id3Frame {
    public static final Parcelable.Creator<InternalFrame> CREATOR = new Parcelable.Creator<InternalFrame>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new InternalFrame[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new InternalFrame(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f32703a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32704b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32705c;

    public InternalFrame(String str, String str2, String str3) {
        super("----");
        this.f32703a = str;
        this.f32704b = str2;
        this.f32705c = str3;
    }

    InternalFrame(Parcel parcel) {
        super("----");
        this.f32703a = (String) ae.a(parcel.readString());
        this.f32704b = (String) ae.a(parcel.readString());
        this.f32705c = (String) ae.a(parcel.readString());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            InternalFrame internalFrame = (InternalFrame) obj;
            return ae.a((Object) this.f32704b, (Object) internalFrame.f32704b) && ae.a((Object) this.f32703a, (Object) internalFrame.f32703a) && ae.a((Object) this.f32705c, (Object) internalFrame.f32705c);
        }
    }

    public final int hashCode() {
        String str = this.f32703a;
        int i2 = 0;
        int hashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.f32704b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f32705c;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return this.f32702f + ": domain=" + this.f32703a + ", description=" + this.f32704b;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f32702f);
        parcel.writeString(this.f32703a);
        parcel.writeString(this.f32705c);
    }
}
