package net.one97.paytm.o2o.movies.adapter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import kotlin.g.b.k;

public final class DwhSource implements Parcelable {
    public static final a CREATOR = new a((byte) 0);
    @b(a = "name")

    /* renamed from: a  reason: collision with root package name */
    public final String f74236a;
    @b(a = "image")

    /* renamed from: b  reason: collision with root package name */
    final String f74237b;

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DwhSource)) {
            return false;
        }
        DwhSource dwhSource = (DwhSource) obj;
        return k.a((Object) this.f74236a, (Object) dwhSource.f74236a) && k.a((Object) this.f74237b, (Object) dwhSource.f74237b);
    }

    public final int hashCode() {
        String str = this.f74236a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f74237b;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "DwhSource(sourceName=" + this.f74236a + ", sourceImage=" + this.f74237b + ")";
    }

    private DwhSource(String str, String str2) {
        this.f74236a = str;
        this.f74237b = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DwhSource(Parcel parcel) {
        this(parcel.readString(), parcel.readString());
        k.c(parcel, "parcel");
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.f74236a);
        parcel.writeString(this.f74237b);
    }

    public static final class a implements Parcelable.Creator<DwhSource> {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            k.c(parcel, "parcel");
            return new DwhSource(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new DwhSource[i2];
        }
    }
}
