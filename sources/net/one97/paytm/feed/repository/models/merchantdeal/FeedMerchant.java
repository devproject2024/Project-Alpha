package net.one97.paytm.feed.repository.models.merchantdeal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.a.c;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.FeedItem;

public final class FeedMerchant extends FeedItem {
    public static final CREATOR CREATOR = new CREATOR((g) null);
    @c(a = "feedItemData")
    private FeedMerchantData feedMerchantData;
    private Parcel parcel;

    public static /* synthetic */ FeedMerchant copy$default(FeedMerchant feedMerchant, FeedMerchantData feedMerchantData2, Parcel parcel2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            feedMerchantData2 = feedMerchant.feedMerchantData;
        }
        if ((i2 & 2) != 0) {
            parcel2 = feedMerchant.parcel;
        }
        return feedMerchant.copy(feedMerchantData2, parcel2);
    }

    public final FeedMerchantData component1() {
        return this.feedMerchantData;
    }

    public final Parcel component2() {
        return this.parcel;
    }

    public final FeedMerchant copy(FeedMerchantData feedMerchantData2, Parcel parcel2) {
        k.c(feedMerchantData2, "feedMerchantData");
        return new FeedMerchant(feedMerchantData2, parcel2);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedMerchant)) {
            return false;
        }
        FeedMerchant feedMerchant = (FeedMerchant) obj;
        return k.a((Object) this.feedMerchantData, (Object) feedMerchant.feedMerchantData) && k.a((Object) this.parcel, (Object) feedMerchant.parcel);
    }

    public final int hashCode() {
        FeedMerchantData feedMerchantData2 = this.feedMerchantData;
        int i2 = 0;
        int hashCode = (feedMerchantData2 != null ? feedMerchantData2.hashCode() : 0) * 31;
        Parcel parcel2 = this.parcel;
        if (parcel2 != null) {
            i2 = parcel2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "FeedMerchant(feedMerchantData=" + this.feedMerchantData + ", parcel=" + this.parcel + ")";
    }

    public final FeedMerchantData getFeedMerchantData() {
        return this.feedMerchantData;
    }

    public final void setFeedMerchantData(FeedMerchantData feedMerchantData2) {
        k.c(feedMerchantData2, "<set-?>");
        this.feedMerchantData = feedMerchantData2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedMerchant(FeedMerchantData feedMerchantData2, Parcel parcel2) {
        super(parcel2);
        k.c(feedMerchantData2, "feedMerchantData");
        this.feedMerchantData = feedMerchantData2;
        this.parcel = parcel2;
        Parcel parcel3 = this.parcel;
        if (parcel3 != null) {
            Parcelable readParcelable = parcel3.readParcelable(FeedMerchantData.class.getClassLoader());
            if (readParcelable == null) {
                k.a();
            }
            this.feedMerchantData = (FeedMerchantData) readParcelable;
        }
    }

    public final Parcel getParcel() {
        return this.parcel;
    }

    public final void setParcel(Parcel parcel2) {
        this.parcel = parcel2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FeedMerchant(android.os.Parcel r25) {
        /*
            r24 = this;
            r0 = r25
            java.lang.String r1 = "parcel"
            kotlin.g.b.k.c(r0, r1)
            net.one97.paytm.feed.repository.models.merchantdeal.FeedMerchantData r1 = new net.one97.paytm.feed.repository.models.merchantdeal.FeedMerchantData
            r2 = r1
            java.lang.String r19 = ""
            java.lang.String r8 = ""
            java.lang.String r7 = ""
            java.lang.String r13 = ""
            java.lang.String r12 = ""
            java.lang.String r11 = ""
            java.lang.String r10 = ""
            java.lang.String r9 = ""
            java.lang.String r3 = ""
            java.lang.String r22 = ""
            java.lang.String r23 = ""
            r4 = 0
            r5 = 0
            r6 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r20 = 0
            r21 = 0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r2 = r24
            r2.<init>(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.models.merchantdeal.FeedMerchant.<init>(android.os.Parcel):void");
    }

    public final void writeToParcel(Parcel parcel2, int i2) {
        k.c(parcel2, "parcel");
        super.writeToParcel(parcel2, i2);
        parcel2.writeParcelable(this.feedMerchantData, i2);
    }

    public static final class CREATOR implements Parcelable.Creator<FeedMerchant> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(g gVar) {
            this();
        }

        public final FeedMerchant createFromParcel(Parcel parcel) {
            k.c(parcel, "parcel");
            return new FeedMerchant(parcel);
        }

        public final FeedMerchant[] newArray(int i2) {
            return new FeedMerchant[i2];
        }
    }
}
