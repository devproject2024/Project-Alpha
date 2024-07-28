package net.one97.paytm.feed.repository.models.merchantstorefront;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.FeedItemData;

public final class FeedMerchantStoreFrontData implements FeedItemData {
    public static final Parcelable.Creator CREATOR = new Creator();
    private final List<Brand> brands;
    private final String title;
    private final String viewAllUrl;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            k.c(parcel, "in");
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((Brand) Brand.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            return new FeedMerchantStoreFrontData(arrayList, parcel.readString(), parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new FeedMerchantStoreFrontData[i2];
        }
    }

    public static /* synthetic */ FeedMerchantStoreFrontData copy$default(FeedMerchantStoreFrontData feedMerchantStoreFrontData, List<Brand> list, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = feedMerchantStoreFrontData.brands;
        }
        if ((i2 & 2) != 0) {
            str = feedMerchantStoreFrontData.title;
        }
        if ((i2 & 4) != 0) {
            str2 = feedMerchantStoreFrontData.viewAllUrl;
        }
        return feedMerchantStoreFrontData.copy(list, str, str2);
    }

    public final List<Brand> component1() {
        return this.brands;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.viewAllUrl;
    }

    public final FeedMerchantStoreFrontData copy(List<Brand> list, String str, String str2) {
        k.c(list, "brands");
        k.c(str, "title");
        k.c(str2, "viewAllUrl");
        return new FeedMerchantStoreFrontData(list, str, str2);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedMerchantStoreFrontData)) {
            return false;
        }
        FeedMerchantStoreFrontData feedMerchantStoreFrontData = (FeedMerchantStoreFrontData) obj;
        return k.a((Object) this.brands, (Object) feedMerchantStoreFrontData.brands) && k.a((Object) this.title, (Object) feedMerchantStoreFrontData.title) && k.a((Object) this.viewAllUrl, (Object) feedMerchantStoreFrontData.viewAllUrl);
    }

    public final int hashCode() {
        List<Brand> list = this.brands;
        int i2 = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.title;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.viewAllUrl;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "FeedMerchantStoreFrontData(brands=" + this.brands + ", title=" + this.title + ", viewAllUrl=" + this.viewAllUrl + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        List<Brand> list = this.brands;
        parcel.writeInt(list.size());
        for (Brand writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, 0);
        }
        parcel.writeString(this.title);
        parcel.writeString(this.viewAllUrl);
    }

    public FeedMerchantStoreFrontData(List<Brand> list, String str, String str2) {
        k.c(list, "brands");
        k.c(str, "title");
        k.c(str2, "viewAllUrl");
        this.brands = list;
        this.title = str;
        this.viewAllUrl = str2;
    }

    public final List<Brand> getBrands() {
        return this.brands;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getViewAllUrl() {
        return this.viewAllUrl;
    }
}
