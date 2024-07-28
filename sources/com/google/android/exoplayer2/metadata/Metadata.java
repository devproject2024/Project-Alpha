package com.google.android.exoplayer2.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.ae;
import java.util.Arrays;
import java.util.List;

public final class Metadata implements Parcelable {
    public static final Parcelable.Creator<Metadata> CREATOR = new Parcelable.Creator<Metadata>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new Metadata[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Metadata(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final Entry[] f32644a;

    public interface Entry extends Parcelable {

        /* renamed from: com.google.android.exoplayer2.metadata.Metadata$Entry$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static Format $default$a(Entry entry) {
                return null;
            }

            public static byte[] $default$b(Entry entry) {
                return null;
            }
        }

        Format a();

        byte[] b();
    }

    public final int describeContents() {
        return 0;
    }

    public Metadata(Entry... entryArr) {
        this.f32644a = entryArr == null ? new Entry[0] : entryArr;
    }

    public Metadata(List<? extends Entry> list) {
        this.f32644a = new Entry[list.size()];
        list.toArray(this.f32644a);
    }

    Metadata(Parcel parcel) {
        this.f32644a = new Entry[parcel.readInt()];
        int i2 = 0;
        while (true) {
            Entry[] entryArr = this.f32644a;
            if (i2 < entryArr.length) {
                entryArr[i2] = (Entry) parcel.readParcelable(Entry.class.getClassLoader());
                i2++;
            } else {
                return;
            }
        }
    }

    public final Metadata a(Metadata metadata) {
        return metadata == null ? this : a(metadata.f32644a);
    }

    public final Metadata a(Entry... entryArr) {
        Entry[] entryArr2 = this.f32644a;
        Entry[] entryArr3 = (Entry[]) Arrays.copyOf(entryArr2, entryArr2.length + entryArr.length);
        System.arraycopy(entryArr, 0, entryArr3, this.f32644a.length, entryArr.length);
        return new Metadata((Entry[]) ae.a((T[]) entryArr3));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f32644a, ((Metadata) obj).f32644a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f32644a);
    }

    public final String toString() {
        return "entries=" + Arrays.toString(this.f32644a);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f32644a.length);
        for (Entry writeParcelable : this.f32644a) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }
}
