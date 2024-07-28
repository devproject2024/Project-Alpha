package net.one97.paytm.feed.repository.models.stories;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.a.c;
import com.sendbird.android.constant.StringSet;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.FeedItemData;
import net.one97.paytm.feed.repository.models.FeedOfFeed;

public final class Stories implements FeedItemData {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final boolean completelySeen;
    private final FeedOfFeed data;
    private final List<String> postIds;
    private String sid;
    @c(a = "id")
    private final String storyId;
    @c(a = "updatedAt")
    private final String storyUpdatedAt;
    @c(a = "position")
    private final int storyposition;
    private final User user;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            return new Stories(parcel.readString(), parcel.readString(), (User) User.CREATOR.createFromParcel(parcel), parcel.readInt() != 0, parcel.readString(), parcel.readInt(), parcel.createStringArrayList(), (FeedOfFeed) FeedOfFeed.CREATOR.createFromParcel(parcel));
        }

        public final Object[] newArray(int i2) {
            return new Stories[i2];
        }
    }

    public static /* synthetic */ Stories copy$default(Stories stories, String str, String str2, User user2, boolean z, String str3, int i2, List list, FeedOfFeed feedOfFeed, int i3, Object obj) {
        Stories stories2 = stories;
        int i4 = i3;
        return stories.copy((i4 & 1) != 0 ? stories2.storyId : str, (i4 & 2) != 0 ? stories2.sid : str2, (i4 & 4) != 0 ? stories2.user : user2, (i4 & 8) != 0 ? stories2.completelySeen : z, (i4 & 16) != 0 ? stories2.storyUpdatedAt : str3, (i4 & 32) != 0 ? stories2.storyposition : i2, (i4 & 64) != 0 ? stories2.postIds : list, (i4 & 128) != 0 ? stories2.data : feedOfFeed);
    }

    public final String component1() {
        return this.storyId;
    }

    public final String component2() {
        return this.sid;
    }

    public final User component3() {
        return this.user;
    }

    public final boolean component4() {
        return this.completelySeen;
    }

    public final String component5() {
        return this.storyUpdatedAt;
    }

    public final int component6() {
        return this.storyposition;
    }

    public final List<String> component7() {
        return this.postIds;
    }

    public final FeedOfFeed component8() {
        return this.data;
    }

    public final Stories copy(String str, String str2, User user2, boolean z, String str3, int i2, List<String> list, FeedOfFeed feedOfFeed) {
        k.c(str, "storyId");
        k.c(str2, "sid");
        k.c(user2, StringSet.user);
        k.c(str3, "storyUpdatedAt");
        List<String> list2 = list;
        k.c(list2, "postIds");
        FeedOfFeed feedOfFeed2 = feedOfFeed;
        k.c(feedOfFeed2, "data");
        return new Stories(str, str2, user2, z, str3, i2, list2, feedOfFeed2);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Stories) {
                Stories stories = (Stories) obj;
                if (k.a((Object) this.storyId, (Object) stories.storyId) && k.a((Object) this.sid, (Object) stories.sid) && k.a((Object) this.user, (Object) stories.user)) {
                    if ((this.completelySeen == stories.completelySeen) && k.a((Object) this.storyUpdatedAt, (Object) stories.storyUpdatedAt)) {
                        if (!(this.storyposition == stories.storyposition) || !k.a((Object) this.postIds, (Object) stories.postIds) || !k.a((Object) this.data, (Object) stories.data)) {
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
        String str = this.storyId;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.sid;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        User user2 = this.user;
        int hashCode3 = (hashCode2 + (user2 != null ? user2.hashCode() : 0)) * 31;
        boolean z = this.completelySeen;
        if (z) {
            z = true;
        }
        int i3 = (hashCode3 + (z ? 1 : 0)) * 31;
        String str3 = this.storyUpdatedAt;
        int hashCode4 = (((i3 + (str3 != null ? str3.hashCode() : 0)) * 31) + Integer.valueOf(this.storyposition).hashCode()) * 31;
        List<String> list = this.postIds;
        int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        FeedOfFeed feedOfFeed = this.data;
        if (feedOfFeed != null) {
            i2 = feedOfFeed.hashCode();
        }
        return hashCode5 + i2;
    }

    public final String toString() {
        return "Stories(storyId=" + this.storyId + ", sid=" + this.sid + ", user=" + this.user + ", completelySeen=" + this.completelySeen + ", storyUpdatedAt=" + this.storyUpdatedAt + ", storyposition=" + this.storyposition + ", postIds=" + this.postIds + ", data=" + this.data + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.storyId);
        parcel.writeString(this.sid);
        this.user.writeToParcel(parcel, 0);
        parcel.writeInt(this.completelySeen ? 1 : 0);
        parcel.writeString(this.storyUpdatedAt);
        parcel.writeInt(this.storyposition);
        parcel.writeStringList(this.postIds);
        this.data.writeToParcel(parcel, 0);
    }

    public Stories(String str, String str2, User user2, boolean z, String str3, int i2, List<String> list, FeedOfFeed feedOfFeed) {
        k.c(str, "storyId");
        k.c(str2, "sid");
        k.c(user2, StringSet.user);
        k.c(str3, "storyUpdatedAt");
        k.c(list, "postIds");
        k.c(feedOfFeed, "data");
        this.storyId = str;
        this.sid = str2;
        this.user = user2;
        this.completelySeen = z;
        this.storyUpdatedAt = str3;
        this.storyposition = i2;
        this.postIds = list;
        this.data = feedOfFeed;
    }

    public final String getStoryId() {
        return this.storyId;
    }

    public final String getSid() {
        return this.sid;
    }

    public final void setSid(String str) {
        k.c(str, "<set-?>");
        this.sid = str;
    }

    public final User getUser() {
        return this.user;
    }

    public final boolean getCompletelySeen() {
        return this.completelySeen;
    }

    public final String getStoryUpdatedAt() {
        return this.storyUpdatedAt;
    }

    public final int getStoryposition() {
        return this.storyposition;
    }

    public final List<String> getPostIds() {
        return this.postIds;
    }

    public final FeedOfFeed getData() {
        return this.data;
    }
}
