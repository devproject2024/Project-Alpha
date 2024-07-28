package net.one97.paytm.feed.repository.models.profile;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.g.b.k;

public final class UserData implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final int bookmarkCount;
    private final String bookmarkCountDisplay;
    private final int followingCount;
    private final String followingCountDisplay;
    private final int id;
    private final String imageUrl;
    private final String name;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new UserData(parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new UserData[i2];
        }
    }

    public static /* synthetic */ UserData copy$default(UserData userData, int i2, String str, int i3, String str2, int i4, String str3, String str4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i2 = userData.bookmarkCount;
        }
        if ((i5 & 2) != 0) {
            str = userData.bookmarkCountDisplay;
        }
        String str5 = str;
        if ((i5 & 4) != 0) {
            i3 = userData.followingCount;
        }
        int i6 = i3;
        if ((i5 & 8) != 0) {
            str2 = userData.followingCountDisplay;
        }
        String str6 = str2;
        if ((i5 & 16) != 0) {
            i4 = userData.id;
        }
        int i7 = i4;
        if ((i5 & 32) != 0) {
            str3 = userData.imageUrl;
        }
        String str7 = str3;
        if ((i5 & 64) != 0) {
            str4 = userData.name;
        }
        return userData.copy(i2, str5, i6, str6, i7, str7, str4);
    }

    public final int component1() {
        return this.bookmarkCount;
    }

    public final String component2() {
        return this.bookmarkCountDisplay;
    }

    public final int component3() {
        return this.followingCount;
    }

    public final String component4() {
        return this.followingCountDisplay;
    }

    public final int component5() {
        return this.id;
    }

    public final String component6() {
        return this.imageUrl;
    }

    public final String component7() {
        return this.name;
    }

    public final UserData copy(int i2, String str, int i3, String str2, int i4, String str3, String str4) {
        k.c(str, "bookmarkCountDisplay");
        k.c(str2, "followingCountDisplay");
        k.c(str3, "imageUrl");
        String str5 = str4;
        k.c(str5, "name");
        return new UserData(i2, str, i3, str2, i4, str3, str5);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof UserData) {
                UserData userData = (UserData) obj;
                if ((this.bookmarkCount == userData.bookmarkCount) && k.a((Object) this.bookmarkCountDisplay, (Object) userData.bookmarkCountDisplay)) {
                    if ((this.followingCount == userData.followingCount) && k.a((Object) this.followingCountDisplay, (Object) userData.followingCountDisplay)) {
                        if (!(this.id == userData.id) || !k.a((Object) this.imageUrl, (Object) userData.imageUrl) || !k.a((Object) this.name, (Object) userData.name)) {
                            return false;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int hashCode = Integer.valueOf(this.bookmarkCount).hashCode() * 31;
        String str = this.bookmarkCountDisplay;
        int i2 = 0;
        int hashCode2 = (((hashCode + (str != null ? str.hashCode() : 0)) * 31) + Integer.valueOf(this.followingCount).hashCode()) * 31;
        String str2 = this.followingCountDisplay;
        int hashCode3 = (((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + Integer.valueOf(this.id).hashCode()) * 31;
        String str3 = this.imageUrl;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.name;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "UserData(bookmarkCount=" + this.bookmarkCount + ", bookmarkCountDisplay=" + this.bookmarkCountDisplay + ", followingCount=" + this.followingCount + ", followingCountDisplay=" + this.followingCountDisplay + ", id=" + this.id + ", imageUrl=" + this.imageUrl + ", name=" + this.name + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeInt(this.bookmarkCount);
        parcel.writeString(this.bookmarkCountDisplay);
        parcel.writeInt(this.followingCount);
        parcel.writeString(this.followingCountDisplay);
        parcel.writeInt(this.id);
        parcel.writeString(this.imageUrl);
        parcel.writeString(this.name);
    }

    public UserData(int i2, String str, int i3, String str2, int i4, String str3, String str4) {
        k.c(str, "bookmarkCountDisplay");
        k.c(str2, "followingCountDisplay");
        k.c(str3, "imageUrl");
        k.c(str4, "name");
        this.bookmarkCount = i2;
        this.bookmarkCountDisplay = str;
        this.followingCount = i3;
        this.followingCountDisplay = str2;
        this.id = i4;
        this.imageUrl = str3;
        this.name = str4;
    }

    public final int getBookmarkCount() {
        return this.bookmarkCount;
    }

    public final String getBookmarkCountDisplay() {
        return this.bookmarkCountDisplay;
    }

    public final int getFollowingCount() {
        return this.followingCount;
    }

    public final String getFollowingCountDisplay() {
        return this.followingCountDisplay;
    }

    public final int getId() {
        return this.id;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getName() {
        return this.name;
    }
}
