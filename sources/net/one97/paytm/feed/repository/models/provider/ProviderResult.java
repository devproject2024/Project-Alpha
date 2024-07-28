package net.one97.paytm.feed.repository.models.provider;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.FeedItem;

public final class ProviderResult implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final List<FeedItem> feed;
    private final long maxId;
    private ProviderData providerData;
    private final UserData userData;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            long readLong = parcel.readLong();
            ProviderData providerData = (ProviderData) ProviderData.CREATOR.createFromParcel(parcel);
            UserData userData = (UserData) UserData.CREATOR.createFromParcel(parcel);
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((FeedItem) parcel.readParcelable(ProviderResult.class.getClassLoader()));
                readInt--;
            }
            return new ProviderResult(readLong, providerData, userData, arrayList);
        }

        public final Object[] newArray(int i2) {
            return new ProviderResult[i2];
        }
    }

    public static /* synthetic */ ProviderResult copy$default(ProviderResult providerResult, long j, ProviderData providerData2, UserData userData2, List<FeedItem> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = providerResult.maxId;
        }
        long j2 = j;
        if ((i2 & 2) != 0) {
            providerData2 = providerResult.providerData;
        }
        ProviderData providerData3 = providerData2;
        if ((i2 & 4) != 0) {
            userData2 = providerResult.userData;
        }
        UserData userData3 = userData2;
        if ((i2 & 8) != 0) {
            list = providerResult.feed;
        }
        return providerResult.copy(j2, providerData3, userData3, list);
    }

    public final long component1() {
        return this.maxId;
    }

    public final ProviderData component2() {
        return this.providerData;
    }

    public final UserData component3() {
        return this.userData;
    }

    public final List<FeedItem> component4() {
        return this.feed;
    }

    public final ProviderResult copy(long j, ProviderData providerData2, UserData userData2, List<? extends FeedItem> list) {
        k.c(providerData2, "providerData");
        k.c(userData2, "userData");
        k.c(list, "feed");
        return new ProviderResult(j, providerData2, userData2, list);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ProviderResult) {
                ProviderResult providerResult = (ProviderResult) obj;
                if (!(this.maxId == providerResult.maxId) || !k.a((Object) this.providerData, (Object) providerResult.providerData) || !k.a((Object) this.userData, (Object) providerResult.userData) || !k.a((Object) this.feed, (Object) providerResult.feed)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int hashCode = Long.valueOf(this.maxId).hashCode() * 31;
        ProviderData providerData2 = this.providerData;
        int i2 = 0;
        int hashCode2 = (hashCode + (providerData2 != null ? providerData2.hashCode() : 0)) * 31;
        UserData userData2 = this.userData;
        int hashCode3 = (hashCode2 + (userData2 != null ? userData2.hashCode() : 0)) * 31;
        List<FeedItem> list = this.feed;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "ProviderResult(maxId=" + this.maxId + ", providerData=" + this.providerData + ", userData=" + this.userData + ", feed=" + this.feed + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeLong(this.maxId);
        this.providerData.writeToParcel(parcel, 0);
        this.userData.writeToParcel(parcel, 0);
        List<FeedItem> list = this.feed;
        parcel.writeInt(list.size());
        for (FeedItem writeParcelable : list) {
            parcel.writeParcelable(writeParcelable, i2);
        }
    }

    public ProviderResult(long j, ProviderData providerData2, UserData userData2, List<? extends FeedItem> list) {
        k.c(providerData2, "providerData");
        k.c(userData2, "userData");
        k.c(list, "feed");
        this.maxId = j;
        this.providerData = providerData2;
        this.userData = userData2;
        this.feed = list;
    }

    public final long getMaxId() {
        return this.maxId;
    }

    public final ProviderData getProviderData() {
        return this.providerData;
    }

    public final void setProviderData(ProviderData providerData2) {
        k.c(providerData2, "<set-?>");
        this.providerData = providerData2;
    }

    public final UserData getUserData() {
        return this.userData;
    }

    public final List<FeedItem> getFeed() {
        return this.feed;
    }
}
