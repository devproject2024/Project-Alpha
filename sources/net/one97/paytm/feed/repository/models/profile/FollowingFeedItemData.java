package net.one97.paytm.feed.repository.models.profile;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.g.b.k;

public final class FollowingFeedItemData implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final int followerCount;
    private final String followerCountDisplay;
    private final String imageUrl;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new FollowingFeedItemData(parcel.readInt(), parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new FollowingFeedItemData[i2];
        }
    }

    public static /* synthetic */ FollowingFeedItemData copy$default(FollowingFeedItemData followingFeedItemData, int i2, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = followingFeedItemData.followerCount;
        }
        if ((i3 & 2) != 0) {
            str = followingFeedItemData.followerCountDisplay;
        }
        if ((i3 & 4) != 0) {
            str2 = followingFeedItemData.imageUrl;
        }
        return followingFeedItemData.copy(i2, str, str2);
    }

    public final int component1() {
        return this.followerCount;
    }

    public final String component2() {
        return this.followerCountDisplay;
    }

    public final String component3() {
        return this.imageUrl;
    }

    public final FollowingFeedItemData copy(int i2, String str, String str2) {
        k.c(str, "followerCountDisplay");
        k.c(str2, "imageUrl");
        return new FollowingFeedItemData(i2, str, str2);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof FollowingFeedItemData) {
                FollowingFeedItemData followingFeedItemData = (FollowingFeedItemData) obj;
                if (!(this.followerCount == followingFeedItemData.followerCount) || !k.a((Object) this.followerCountDisplay, (Object) followingFeedItemData.followerCountDisplay) || !k.a((Object) this.imageUrl, (Object) followingFeedItemData.imageUrl)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int hashCode = Integer.valueOf(this.followerCount).hashCode() * 31;
        String str = this.followerCountDisplay;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.imageUrl;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "FollowingFeedItemData(followerCount=" + this.followerCount + ", followerCountDisplay=" + this.followerCountDisplay + ", imageUrl=" + this.imageUrl + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeInt(this.followerCount);
        parcel.writeString(this.followerCountDisplay);
        parcel.writeString(this.imageUrl);
    }

    public FollowingFeedItemData(int i2, String str, String str2) {
        k.c(str, "followerCountDisplay");
        k.c(str2, "imageUrl");
        this.followerCount = i2;
        this.followerCountDisplay = str;
        this.imageUrl = str2;
    }

    public final int getFollowerCount() {
        return this.followerCount;
    }

    public final String getFollowerCountDisplay() {
        return this.followerCountDisplay;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }
}
