package net.one97.paytm.o2o.movies.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJRRatingDataItem implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @b(a = "baseValue")
    private String baseValue;
    @b(a = "value")
    private String value;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new CJRRatingDataItem(parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new CJRRatingDataItem[i2];
        }
    }

    public CJRRatingDataItem() {
        this((String) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ CJRRatingDataItem copy$default(CJRRatingDataItem cJRRatingDataItem, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRRatingDataItem.value;
        }
        if ((i2 & 2) != 0) {
            str2 = cJRRatingDataItem.baseValue;
        }
        return cJRRatingDataItem.copy(str, str2);
    }

    public final String component1() {
        return this.value;
    }

    public final String component2() {
        return this.baseValue;
    }

    public final CJRRatingDataItem copy(String str, String str2) {
        return new CJRRatingDataItem(str, str2);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRRatingDataItem)) {
            return false;
        }
        CJRRatingDataItem cJRRatingDataItem = (CJRRatingDataItem) obj;
        return k.a((Object) this.value, (Object) cJRRatingDataItem.value) && k.a((Object) this.baseValue, (Object) cJRRatingDataItem.baseValue);
    }

    public final int hashCode() {
        String str = this.value;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.baseValue;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "CJRRatingDataItem(value=" + this.value + ", baseValue=" + this.baseValue + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.value);
        parcel.writeString(this.baseValue);
    }

    public CJRRatingDataItem(String str, String str2) {
        this.value = str;
        this.baseValue = str2;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setValue(String str) {
        this.value = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRRatingDataItem(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }

    public final String getBaseValue() {
        return this.baseValue;
    }

    public final void setBaseValue(String str) {
        this.baseValue = str;
    }
}
