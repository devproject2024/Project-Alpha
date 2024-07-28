package net.one97.paytm.o2o.movies.common.movies.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import kotlin.g.b.k;
import kotlin.m.p;

public final class GroupFormatObject implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();
    @b(a = "scrnFmt")

    /* renamed from: a  reason: collision with root package name */
    public String f75200a;
    @b(a = "movieCode")

    /* renamed from: b  reason: collision with root package name */
    private String f75201b;

    public static class a implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new GroupFormatObject(parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new GroupFormatObject[i2];
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final int hashCode() {
        String str = this.f75201b;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f75200a;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "GroupFormatObject(movieCode=" + this.f75201b + ", scrnFmt=" + this.f75200a + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.f75201b);
        parcel.writeString(this.f75200a);
    }

    public GroupFormatObject(String str, String str2) {
        this.f75201b = str;
        this.f75200a = str2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof GroupFormatObject) {
            return p.a(this.f75200a, ((GroupFormatObject) obj).f75200a, true);
        }
        return super.equals(obj);
    }
}
