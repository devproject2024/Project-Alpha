package net.one97.paytm.o2o.movies.common.movies.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import kotlin.g.b.k;

public final class CJRArea implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    @b(a = "code")

    /* renamed from: a  reason: collision with root package name */
    public String f75157a;
    @b(a = "label")

    /* renamed from: b  reason: collision with root package name */
    public String f75158b;
    @b(a = "typeCode")

    /* renamed from: c  reason: collision with root package name */
    public String f75159c;
    @b(a = "price")

    /* renamed from: d  reason: collision with root package name */
    public Double f75160d;

    public static class a implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new CJRArea(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? Double.valueOf(parcel.readDouble()) : null);
        }

        public final Object[] newArray(int i2) {
            return new CJRArea[i2];
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRArea)) {
            return false;
        }
        CJRArea cJRArea = (CJRArea) obj;
        return k.a((Object) this.f75157a, (Object) cJRArea.f75157a) && k.a((Object) this.f75158b, (Object) cJRArea.f75158b) && k.a((Object) this.f75159c, (Object) cJRArea.f75159c) && k.a((Object) this.f75160d, (Object) cJRArea.f75160d);
    }

    public final int hashCode() {
        String str = this.f75157a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f75158b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f75159c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Double d2 = this.f75160d;
        if (d2 != null) {
            i2 = d2.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "CJRArea(code=" + this.f75157a + ", label=" + this.f75158b + ", typeCode=" + this.f75159c + ", price=" + this.f75160d + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.f75157a);
        parcel.writeString(this.f75158b);
        parcel.writeString(this.f75159c);
        Double d2 = this.f75160d;
        if (d2 != null) {
            parcel.writeInt(1);
            parcel.writeDouble(d2.doubleValue());
            return;
        }
        parcel.writeInt(0);
    }

    public CJRArea(String str, String str2, String str3, Double d2) {
        this.f75157a = str;
        this.f75158b = str2;
        this.f75159c = str3;
        this.f75160d = d2;
    }
}
