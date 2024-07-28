package com.google.android.exoplayer2.extractor.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.Arrays;

public final class MdtaMetadataEntry implements Metadata.Entry {
    public static final Parcelable.Creator<MdtaMetadataEntry> CREATOR = new Parcelable.Creator<MdtaMetadataEntry>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new MdtaMetadataEntry[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new MdtaMetadataEntry(parcel, (byte) 0);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f32155a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f32156b;

    /* renamed from: c  reason: collision with root package name */
    public final int f32157c;

    /* renamed from: d  reason: collision with root package name */
    public final int f32158d;

    public /* synthetic */ Format a() {
        return Metadata.Entry.CC.$default$a(this);
    }

    public /* synthetic */ byte[] b() {
        return Metadata.Entry.CC.$default$b(this);
    }

    public final int describeContents() {
        return 0;
    }

    /* synthetic */ MdtaMetadataEntry(Parcel parcel, byte b2) {
        this(parcel);
    }

    public MdtaMetadataEntry(String str, byte[] bArr, int i2, int i3) {
        this.f32155a = str;
        this.f32156b = bArr;
        this.f32157c = i2;
        this.f32158d = i3;
    }

    private MdtaMetadataEntry(Parcel parcel) {
        this.f32155a = (String) ae.a(parcel.readString());
        this.f32156b = new byte[parcel.readInt()];
        parcel.readByteArray(this.f32156b);
        this.f32157c = parcel.readInt();
        this.f32158d = parcel.readInt();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            MdtaMetadataEntry mdtaMetadataEntry = (MdtaMetadataEntry) obj;
            return this.f32155a.equals(mdtaMetadataEntry.f32155a) && Arrays.equals(this.f32156b, mdtaMetadataEntry.f32156b) && this.f32157c == mdtaMetadataEntry.f32157c && this.f32158d == mdtaMetadataEntry.f32158d;
        }
    }

    public final int hashCode() {
        return ((((((this.f32155a.hashCode() + 527) * 31) + Arrays.hashCode(this.f32156b)) * 31) + this.f32157c) * 31) + this.f32158d;
    }

    public final String toString() {
        return "mdta: key=" + this.f32155a;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f32155a);
        parcel.writeInt(this.f32156b.length);
        parcel.writeByteArray(this.f32156b);
        parcel.writeInt(this.f32157c);
        parcel.writeInt(this.f32158d);
    }
}
