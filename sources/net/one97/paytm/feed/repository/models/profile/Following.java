package net.one97.paytm.feed.repository.models.profile;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.g.b.k;

public final class Following implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final long createdAt;
    private boolean following;
    private final FollowingFeedItemData followingFeedItemData;
    private final String name;
    private final int userId;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new Following(parcel.readLong(), (FollowingFeedItemData) FollowingFeedItemData.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt(), parcel.readInt() != 0);
        }

        public final Object[] newArray(int i2) {
            return new Following[i2];
        }
    }

    public static /* synthetic */ Following copy$default(Following following2, long j, FollowingFeedItemData followingFeedItemData2, String str, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j = following2.createdAt;
        }
        long j2 = j;
        if ((i3 & 2) != 0) {
            followingFeedItemData2 = following2.followingFeedItemData;
        }
        FollowingFeedItemData followingFeedItemData3 = followingFeedItemData2;
        if ((i3 & 4) != 0) {
            str = following2.name;
        }
        String str2 = str;
        if ((i3 & 8) != 0) {
            i2 = following2.userId;
        }
        int i4 = i2;
        if ((i3 & 16) != 0) {
            z = following2.following;
        }
        return following2.copy(j2, followingFeedItemData3, str2, i4, z);
    }

    public final long component1() {
        return this.createdAt;
    }

    public final FollowingFeedItemData component2() {
        return this.followingFeedItemData;
    }

    public final String component3() {
        return this.name;
    }

    public final int component4() {
        return this.userId;
    }

    public final boolean component5() {
        return this.following;
    }

    public final Following copy(long j, FollowingFeedItemData followingFeedItemData2, String str, int i2, boolean z) {
        k.c(followingFeedItemData2, "followingFeedItemData");
        k.c(str, "name");
        return new Following(j, followingFeedItemData2, str, i2, z);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Following) {
                Following following2 = (Following) obj;
                if ((this.createdAt == following2.createdAt) && k.a((Object) this.followingFeedItemData, (Object) following2.followingFeedItemData) && k.a((Object) this.name, (Object) following2.name)) {
                    if (this.userId == following2.userId) {
                        if (this.following == following2.following) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int hashCode = Long.valueOf(this.createdAt).hashCode() * 31;
        FollowingFeedItemData followingFeedItemData2 = this.followingFeedItemData;
        int i2 = 0;
        int hashCode2 = (hashCode + (followingFeedItemData2 != null ? followingFeedItemData2.hashCode() : 0)) * 31;
        String str = this.name;
        if (str != null) {
            i2 = str.hashCode();
        }
        int hashCode3 = (((hashCode2 + i2) * 31) + Integer.valueOf(this.userId).hashCode()) * 31;
        boolean z = this.following;
        if (z) {
            z = true;
        }
        return hashCode3 + (z ? 1 : 0);
    }

    public final String toString() {
        return "Following(createdAt=" + this.createdAt + ", followingFeedItemData=" + this.followingFeedItemData + ", name=" + this.name + ", userId=" + this.userId + ", following=" + this.following + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeLong(this.createdAt);
        this.followingFeedItemData.writeToParcel(parcel, 0);
        parcel.writeString(this.name);
        parcel.writeInt(this.userId);
        parcel.writeInt(this.following ? 1 : 0);
    }

    public Following(long j, FollowingFeedItemData followingFeedItemData2, String str, int i2, boolean z) {
        k.c(followingFeedItemData2, "followingFeedItemData");
        k.c(str, "name");
        this.createdAt = j;
        this.followingFeedItemData = followingFeedItemData2;
        this.name = str;
        this.userId = i2;
        this.following = z;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final FollowingFeedItemData getFollowingFeedItemData() {
        return this.followingFeedItemData;
    }

    public final String getName() {
        return this.name;
    }

    public final int getUserId() {
        return this.userId;
    }

    public final boolean getFollowing() {
        return this.following;
    }

    public final void setFollowing(boolean z) {
        this.following = z;
    }
}
