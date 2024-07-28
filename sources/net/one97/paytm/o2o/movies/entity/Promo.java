package net.one97.paytm.o2o.movies.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import kotlin.g.b.k;

public final class Promo implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @b(a = "category")
    private String category;
    @b(a = "header")
    private String header;
    @b(a = "text")
    private String text;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new Promo(parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new Promo[i2];
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.category);
        parcel.writeString(this.header);
        parcel.writeString(this.text);
    }

    public Promo(String str, String str2, String str3) {
        this.category = str;
        this.header = str2;
        this.text = str3;
    }

    public final String getCategory() {
        return this.category;
    }

    public final void setCategory(String str) {
        this.category = str;
    }

    public final String getHeader() {
        return this.header;
    }

    public final void setHeader(String str) {
        this.header = str;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        this.text = str;
    }
}
