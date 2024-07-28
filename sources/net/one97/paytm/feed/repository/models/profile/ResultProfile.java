package net.one97.paytm.feed.repository.models.profile;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;

public final class ResultProfile implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final List<FeedGeneric> feed;
    private final List<Following> following;
    private final long maxId;
    private final UserData userData;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((Following) Following.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            long readLong = parcel.readLong();
            UserData userData = (UserData) UserData.CREATOR.createFromParcel(parcel);
            int readInt2 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList2.add((FeedGeneric) parcel.readParcelable(ResultProfile.class.getClassLoader()));
                readInt2--;
            }
            return new ResultProfile(arrayList, readLong, userData, arrayList2);
        }

        public final Object[] newArray(int i2) {
            return new ResultProfile[i2];
        }
    }

    public static /* synthetic */ ResultProfile copy$default(ResultProfile resultProfile, List<Following> list, long j, UserData userData2, List<FeedGeneric> list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = resultProfile.following;
        }
        if ((i2 & 2) != 0) {
            j = resultProfile.maxId;
        }
        long j2 = j;
        if ((i2 & 4) != 0) {
            userData2 = resultProfile.userData;
        }
        UserData userData3 = userData2;
        if ((i2 & 8) != 0) {
            list2 = resultProfile.feed;
        }
        return resultProfile.copy(list, j2, userData3, list2);
    }

    public final List<Following> component1() {
        return this.following;
    }

    public final long component2() {
        return this.maxId;
    }

    public final UserData component3() {
        return this.userData;
    }

    public final List<FeedGeneric> component4() {
        return this.feed;
    }

    public final ResultProfile copy(List<Following> list, long j, UserData userData2, List<FeedGeneric> list2) {
        k.c(list, "following");
        k.c(userData2, "userData");
        k.c(list2, "feed");
        return new ResultProfile(list, j, userData2, list2);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ResultProfile) {
                ResultProfile resultProfile = (ResultProfile) obj;
                if (k.a((Object) this.following, (Object) resultProfile.following)) {
                    if (!(this.maxId == resultProfile.maxId) || !k.a((Object) this.userData, (Object) resultProfile.userData) || !k.a((Object) this.feed, (Object) resultProfile.feed)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        List<Following> list = this.following;
        int i2 = 0;
        int hashCode = (((list != null ? list.hashCode() : 0) * 31) + Long.valueOf(this.maxId).hashCode()) * 31;
        UserData userData2 = this.userData;
        int hashCode2 = (hashCode + (userData2 != null ? userData2.hashCode() : 0)) * 31;
        List<FeedGeneric> list2 = this.feed;
        if (list2 != null) {
            i2 = list2.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "ResultProfile(following=" + this.following + ", maxId=" + this.maxId + ", userData=" + this.userData + ", feed=" + this.feed + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        List<Following> list = this.following;
        parcel.writeInt(list.size());
        for (Following writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, 0);
        }
        parcel.writeLong(this.maxId);
        this.userData.writeToParcel(parcel, 0);
        List<FeedGeneric> list2 = this.feed;
        parcel.writeInt(list2.size());
        for (FeedGeneric writeParcelable : list2) {
            parcel.writeParcelable(writeParcelable, i2);
        }
    }

    public ResultProfile(List<Following> list, long j, UserData userData2, List<FeedGeneric> list2) {
        k.c(list, "following");
        k.c(userData2, "userData");
        k.c(list2, "feed");
        this.following = list;
        this.maxId = j;
        this.userData = userData2;
        this.feed = list2;
    }

    public final List<Following> getFollowing() {
        return this.following;
    }

    public final long getMaxId() {
        return this.maxId;
    }

    public final UserData getUserData() {
        return this.userData;
    }

    public final List<FeedGeneric> getFeed() {
        return this.feed;
    }
}
