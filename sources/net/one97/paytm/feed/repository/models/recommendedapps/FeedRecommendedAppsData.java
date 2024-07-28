package net.one97.paytm.feed.repository.models.recommendedapps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.a.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.FeedItemData;

public final class FeedRecommendedAppsData implements FeedItemData {
    public static final Parcelable.Creator CREATOR = new Creator();
    @c(a = "cards")
    private final List<RecommendedApps> appsList;
    private final String title;
    private final String viewAllUrl;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((RecommendedApps) RecommendedApps.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new FeedRecommendedAppsData(readString, readString2, arrayList);
        }

        public final Object[] newArray(int i2) {
            return new FeedRecommendedAppsData[i2];
        }
    }

    public static /* synthetic */ FeedRecommendedAppsData copy$default(FeedRecommendedAppsData feedRecommendedAppsData, String str, String str2, List<RecommendedApps> list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = feedRecommendedAppsData.title;
        }
        if ((i2 & 2) != 0) {
            str2 = feedRecommendedAppsData.viewAllUrl;
        }
        if ((i2 & 4) != 0) {
            list = feedRecommendedAppsData.appsList;
        }
        return feedRecommendedAppsData.copy(str, str2, list);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.viewAllUrl;
    }

    public final List<RecommendedApps> component3() {
        return this.appsList;
    }

    public final FeedRecommendedAppsData copy(String str, String str2, List<RecommendedApps> list) {
        k.c(str, "title");
        k.c(list, "appsList");
        return new FeedRecommendedAppsData(str, str2, list);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedRecommendedAppsData)) {
            return false;
        }
        FeedRecommendedAppsData feedRecommendedAppsData = (FeedRecommendedAppsData) obj;
        return k.a((Object) this.title, (Object) feedRecommendedAppsData.title) && k.a((Object) this.viewAllUrl, (Object) feedRecommendedAppsData.viewAllUrl) && k.a((Object) this.appsList, (Object) feedRecommendedAppsData.appsList);
    }

    public final int hashCode() {
        String str = this.title;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.viewAllUrl;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<RecommendedApps> list = this.appsList;
        if (list != null) {
            i2 = list.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "FeedRecommendedAppsData(title=" + this.title + ", viewAllUrl=" + this.viewAllUrl + ", appsList=" + this.appsList + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.viewAllUrl);
        List<RecommendedApps> list = this.appsList;
        parcel.writeInt(list.size());
        for (RecommendedApps writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, 0);
        }
    }

    public FeedRecommendedAppsData(String str, String str2, List<RecommendedApps> list) {
        k.c(str, "title");
        k.c(list, "appsList");
        this.title = str;
        this.viewAllUrl = str2;
        this.appsList = list;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getViewAllUrl() {
        return this.viewAllUrl;
    }

    public final List<RecommendedApps> getAppsList() {
        return this.appsList;
    }
}
