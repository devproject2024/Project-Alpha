package net.one97.paytm.feed.repository.models.cricket;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.a.c;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.FeedItem;

public final class FeedCricket extends FeedItem {
    public static final CREATOR CREATOR = new CREATOR((g) null);
    @c(a = "feedItemData")
    private FeedCricketData feedCricketData;
    private Parcel parcel;

    public static /* synthetic */ FeedCricket copy$default(FeedCricket feedCricket, FeedCricketData feedCricketData2, Parcel parcel2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            feedCricketData2 = feedCricket.feedCricketData;
        }
        if ((i2 & 2) != 0) {
            parcel2 = feedCricket.parcel;
        }
        return feedCricket.copy(feedCricketData2, parcel2);
    }

    public final FeedCricketData component1() {
        return this.feedCricketData;
    }

    public final Parcel component2() {
        return this.parcel;
    }

    public final FeedCricket copy(FeedCricketData feedCricketData2, Parcel parcel2) {
        k.c(feedCricketData2, "feedCricketData");
        return new FeedCricket(feedCricketData2, parcel2);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedCricket)) {
            return false;
        }
        FeedCricket feedCricket = (FeedCricket) obj;
        return k.a((Object) this.feedCricketData, (Object) feedCricket.feedCricketData) && k.a((Object) this.parcel, (Object) feedCricket.parcel);
    }

    public final int hashCode() {
        FeedCricketData feedCricketData2 = this.feedCricketData;
        int i2 = 0;
        int hashCode = (feedCricketData2 != null ? feedCricketData2.hashCode() : 0) * 31;
        Parcel parcel2 = this.parcel;
        if (parcel2 != null) {
            i2 = parcel2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "FeedCricket(feedCricketData=" + this.feedCricketData + ", parcel=" + this.parcel + ")";
    }

    public final FeedCricketData getFeedCricketData() {
        return this.feedCricketData;
    }

    public final void setFeedCricketData(FeedCricketData feedCricketData2) {
        k.c(feedCricketData2, "<set-?>");
        this.feedCricketData = feedCricketData2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedCricket(FeedCricketData feedCricketData2, Parcel parcel2) {
        super(parcel2);
        k.c(feedCricketData2, "feedCricketData");
        this.feedCricketData = feedCricketData2;
        this.parcel = parcel2;
        Parcel parcel3 = this.parcel;
        if (parcel3 != null) {
            Parcelable readParcelable = parcel3.readParcelable(FeedCricketData.class.getClassLoader());
            if (readParcelable == null) {
                k.a();
            }
            this.feedCricketData = (FeedCricketData) readParcelable;
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
    public FeedCricket(android.os.Parcel r17) {
        /*
            r16 = this;
            r0 = r17
            java.lang.String r1 = "parcel"
            kotlin.g.b.k.c(r0, r1)
            net.one97.paytm.feed.repository.models.cricket.FeedCricketData r1 = new net.one97.paytm.feed.repository.models.cricket.FeedCricketData
            java.lang.String r3 = ""
            java.lang.String r5 = ""
            java.lang.String r4 = ""
            java.lang.String r7 = ""
            java.lang.String r6 = ""
            java.lang.String r12 = ""
            java.lang.String r10 = ""
            java.lang.String r8 = ""
            java.lang.String r9 = ""
            java.lang.String r11 = ""
            java.lang.String r13 = ""
            java.lang.String r14 = ""
            java.lang.String r15 = ""
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r2 = r16
            r2.<init>(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.models.cricket.FeedCricket.<init>(android.os.Parcel):void");
    }

    public final void writeToParcel(Parcel parcel2, int i2) {
        k.c(parcel2, "parcel");
        super.writeToParcel(parcel2, i2);
        parcel2.writeParcelable(this.feedCricketData, i2);
    }

    public static final class CREATOR implements Parcelable.Creator<FeedCricket> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(g gVar) {
            this();
        }

        public final FeedCricket createFromParcel(Parcel parcel) {
            k.c(parcel, "parcel");
            return new FeedCricket(parcel);
        }

        public final FeedCricket[] newArray(int i2) {
            return new FeedCricket[i2];
        }
    }
}
