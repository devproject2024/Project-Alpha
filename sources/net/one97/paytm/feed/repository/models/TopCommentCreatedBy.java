package net.one97.paytm.feed.repository.models;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.g.b.k;

public final class TopCommentCreatedBy implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final int id;
    private final String imageUrl;
    private final String name;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new TopCommentCreatedBy(parcel.readInt(), parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new TopCommentCreatedBy[i2];
        }
    }

    public static /* synthetic */ TopCommentCreatedBy copy$default(TopCommentCreatedBy topCommentCreatedBy, int i2, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = topCommentCreatedBy.id;
        }
        if ((i3 & 2) != 0) {
            str = topCommentCreatedBy.name;
        }
        if ((i3 & 4) != 0) {
            str2 = topCommentCreatedBy.imageUrl;
        }
        return topCommentCreatedBy.copy(i2, str, str2);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.imageUrl;
    }

    public final TopCommentCreatedBy copy(int i2, String str, String str2) {
        k.c(str, "name");
        k.c(str2, "imageUrl");
        return new TopCommentCreatedBy(i2, str, str2);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof TopCommentCreatedBy) {
                TopCommentCreatedBy topCommentCreatedBy = (TopCommentCreatedBy) obj;
                if (!(this.id == topCommentCreatedBy.id) || !k.a((Object) this.name, (Object) topCommentCreatedBy.name) || !k.a((Object) this.imageUrl, (Object) topCommentCreatedBy.imageUrl)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int hashCode = Integer.valueOf(this.id).hashCode() * 31;
        String str = this.name;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.imageUrl;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "TopCommentCreatedBy(id=" + this.id + ", name=" + this.name + ", imageUrl=" + this.imageUrl + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.imageUrl);
    }

    public TopCommentCreatedBy(int i2, String str, String str2) {
        k.c(str, "name");
        k.c(str2, "imageUrl");
        this.id = i2;
        this.name = str;
        this.imageUrl = str2;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }
}
