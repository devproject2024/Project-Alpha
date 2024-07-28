package com.google.android.exoplayer2.source.hls;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class HlsTrackMetadataEntry implements Metadata.Entry {
    public static final Parcelable.Creator<HlsTrackMetadataEntry> CREATOR = new Parcelable.Creator<HlsTrackMetadataEntry>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new HlsTrackMetadataEntry[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new HlsTrackMetadataEntry(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final String f33062a;

    /* renamed from: b  reason: collision with root package name */
    public final String f33063b;

    /* renamed from: c  reason: collision with root package name */
    public final List<VariantInfo> f33064c;

    public /* synthetic */ Format a() {
        return Metadata.Entry.CC.$default$a(this);
    }

    public /* synthetic */ byte[] b() {
        return Metadata.Entry.CC.$default$b(this);
    }

    public final int describeContents() {
        return 0;
    }

    public static final class VariantInfo implements Parcelable {
        public static final Parcelable.Creator<VariantInfo> CREATOR = new Parcelable.Creator<VariantInfo>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new VariantInfo[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new VariantInfo(parcel);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        public final long f33065a;

        /* renamed from: b  reason: collision with root package name */
        public final String f33066b;

        /* renamed from: c  reason: collision with root package name */
        public final String f33067c;

        /* renamed from: d  reason: collision with root package name */
        public final String f33068d;

        /* renamed from: e  reason: collision with root package name */
        public final String f33069e;

        public final int describeContents() {
            return 0;
        }

        public VariantInfo(long j, String str, String str2, String str3, String str4) {
            this.f33065a = j;
            this.f33066b = str;
            this.f33067c = str2;
            this.f33068d = str3;
            this.f33069e = str4;
        }

        VariantInfo(Parcel parcel) {
            this.f33065a = parcel.readLong();
            this.f33066b = parcel.readString();
            this.f33067c = parcel.readString();
            this.f33068d = parcel.readString();
            this.f33069e = parcel.readString();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                VariantInfo variantInfo = (VariantInfo) obj;
                return this.f33065a == variantInfo.f33065a && TextUtils.equals(this.f33066b, variantInfo.f33066b) && TextUtils.equals(this.f33067c, variantInfo.f33067c) && TextUtils.equals(this.f33068d, variantInfo.f33068d) && TextUtils.equals(this.f33069e, variantInfo.f33069e);
            }
        }

        public final int hashCode() {
            long j = this.f33065a;
            int i2 = ((int) (j ^ (j >>> 32))) * 31;
            String str = this.f33066b;
            int i3 = 0;
            int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f33067c;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f33068d;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.f33069e;
            if (str4 != null) {
                i3 = str4.hashCode();
            }
            return hashCode3 + i3;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            parcel.writeLong(this.f33065a);
            parcel.writeString(this.f33066b);
            parcel.writeString(this.f33067c);
            parcel.writeString(this.f33068d);
            parcel.writeString(this.f33069e);
        }
    }

    public HlsTrackMetadataEntry(String str, String str2, List<VariantInfo> list) {
        this.f33062a = str;
        this.f33063b = str2;
        this.f33064c = Collections.unmodifiableList(new ArrayList(list));
    }

    HlsTrackMetadataEntry(Parcel parcel) {
        this.f33062a = parcel.readString();
        this.f33063b = parcel.readString();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(parcel.readParcelable(VariantInfo.class.getClassLoader()));
        }
        this.f33064c = Collections.unmodifiableList(arrayList);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            HlsTrackMetadataEntry hlsTrackMetadataEntry = (HlsTrackMetadataEntry) obj;
            return TextUtils.equals(this.f33062a, hlsTrackMetadataEntry.f33062a) && TextUtils.equals(this.f33063b, hlsTrackMetadataEntry.f33063b) && this.f33064c.equals(hlsTrackMetadataEntry.f33064c);
        }
    }

    public final int hashCode() {
        String str = this.f33062a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f33063b;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return ((hashCode + i2) * 31) + this.f33064c.hashCode();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f33062a);
        parcel.writeString(this.f33063b);
        int size = this.f33064c.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeParcelable(this.f33064c.get(i3), 0);
        }
    }
}
