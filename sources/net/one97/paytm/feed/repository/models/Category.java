package net.one97.paytm.feed.repository.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.a.c;
import kotlin.g.b.k;

public final class Category implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final String color;
    @c(a = "name")
    private final String displayName;
    @c(a = "icon_url")
    private final String iconUrl;
    private final String id;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new Category(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new Category[i2];
        }
    }

    public static /* synthetic */ Category copy$default(Category category, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = category.id;
        }
        if ((i2 & 2) != 0) {
            str2 = category.displayName;
        }
        if ((i2 & 4) != 0) {
            str3 = category.color;
        }
        if ((i2 & 8) != 0) {
            str4 = category.iconUrl;
        }
        return category.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.displayName;
    }

    public final String component3() {
        return this.color;
    }

    public final String component4() {
        return this.iconUrl;
    }

    public final Category copy(String str, String str2, String str3, String str4) {
        return new Category(str, str2, str3, str4);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Category)) {
            return false;
        }
        Category category = (Category) obj;
        return k.a((Object) this.id, (Object) category.id) && k.a((Object) this.displayName, (Object) category.displayName) && k.a((Object) this.color, (Object) category.color) && k.a((Object) this.iconUrl, (Object) category.iconUrl);
    }

    public final int hashCode() {
        String str = this.id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.displayName;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.color;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.iconUrl;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "Category(id=" + this.id + ", displayName=" + this.displayName + ", color=" + this.color + ", iconUrl=" + this.iconUrl + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.displayName);
        parcel.writeString(this.color);
        parcel.writeString(this.iconUrl);
    }

    public Category(String str, String str2, String str3, String str4) {
        this.id = str;
        this.displayName = str2;
        this.color = str3;
        this.iconUrl = str4;
    }

    public final String getId() {
        return this.id;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getColor() {
        return this.color;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }
}
