package net.one97.paytm.o2o.movies.common.movies.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import kotlin.g.b.k;

public final class Rating implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    @b(a = "src")

    /* renamed from: a  reason: collision with root package name */
    public String f75205a;
    @b(a = "base")

    /* renamed from: b  reason: collision with root package name */
    public String f75206b;
    @b(a = "val1")

    /* renamed from: c  reason: collision with root package name */
    public String f75207c;
    @b(a = "type")

    /* renamed from: d  reason: collision with root package name */
    private String f75208d;

    public static class a implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new Rating(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new Rating[i2];
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Rating)) {
            return false;
        }
        Rating rating = (Rating) obj;
        return k.a((Object) this.f75205a, (Object) rating.f75205a) && k.a((Object) this.f75208d, (Object) rating.f75208d) && k.a((Object) this.f75206b, (Object) rating.f75206b) && k.a((Object) this.f75207c, (Object) rating.f75207c);
    }

    public final int hashCode() {
        String str = this.f75205a;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f75208d;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f75206b;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f75207c;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "Rating(src=" + this.f75205a + ", type=" + this.f75208d + ", base=" + this.f75206b + ", val1=" + this.f75207c + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.f75205a);
        parcel.writeString(this.f75208d);
        parcel.writeString(this.f75206b);
        parcel.writeString(this.f75207c);
    }

    public Rating(String str, String str2, String str3, String str4) {
        this.f75205a = str;
        this.f75208d = str2;
        this.f75206b = str3;
        this.f75207c = str4;
    }

    private /* synthetic */ Rating() {
        this((String) null, (String) null, (String) null, (String) null);
    }
}
