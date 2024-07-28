package net.one97.paytm.feed.repository.models.comment;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.g.b.k;

public final class CreatedBy implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final String id;
    private final String imageUrl;
    private final String name;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new CreatedBy(parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new CreatedBy[i2];
        }
    }

    public static /* synthetic */ CreatedBy copy$default(CreatedBy createdBy, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = createdBy.id;
        }
        if ((i2 & 2) != 0) {
            str2 = createdBy.imageUrl;
        }
        if ((i2 & 4) != 0) {
            str3 = createdBy.name;
        }
        return createdBy.copy(str, str2, str3);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.imageUrl;
    }

    public final String component3() {
        return this.name;
    }

    public final CreatedBy copy(String str, String str2, String str3) {
        k.c(str, "id");
        return new CreatedBy(str, str2, str3);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CreatedBy)) {
            return false;
        }
        CreatedBy createdBy = (CreatedBy) obj;
        return k.a((Object) this.id, (Object) createdBy.id) && k.a((Object) this.imageUrl, (Object) createdBy.imageUrl) && k.a((Object) this.name, (Object) createdBy.name);
    }

    public final int hashCode() {
        String str = this.id;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.imageUrl;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.name;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "CreatedBy(id=" + this.id + ", imageUrl=" + this.imageUrl + ", name=" + this.name + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.imageUrl);
        parcel.writeString(this.name);
    }

    public CreatedBy(String str, String str2, String str3) {
        k.c(str, "id");
        this.id = str;
        this.imageUrl = str2;
        this.name = str3;
    }

    public final String getId() {
        return this.id;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getName() {
        return this.name;
    }
}
