package net.one97.paytm.o2o.movies.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class LikeDisLikeInfoItem implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @b(a = "interested")
    private SentimentInterestedItem interested;
    @b(a = "sentiment")
    private SentimentInterestedItem sentiment;

    public static class Creator implements Parcelable.Creator {
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: net.one97.paytm.o2o.movies.entity.SentimentInterestedItem} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object createFromParcel(android.os.Parcel r5) {
            /*
                r4 = this;
                java.lang.String r0 = "in"
                kotlin.g.b.k.c(r5, r0)
                net.one97.paytm.o2o.movies.entity.LikeDisLikeInfoItem r0 = new net.one97.paytm.o2o.movies.entity.LikeDisLikeInfoItem
                int r1 = r5.readInt()
                r2 = 0
                if (r1 == 0) goto L_0x0017
                android.os.Parcelable$Creator r1 = net.one97.paytm.o2o.movies.entity.SentimentInterestedItem.CREATOR
                java.lang.Object r1 = r1.createFromParcel(r5)
                net.one97.paytm.o2o.movies.entity.SentimentInterestedItem r1 = (net.one97.paytm.o2o.movies.entity.SentimentInterestedItem) r1
                goto L_0x0018
            L_0x0017:
                r1 = r2
            L_0x0018:
                int r3 = r5.readInt()
                if (r3 == 0) goto L_0x0027
                android.os.Parcelable$Creator r2 = net.one97.paytm.o2o.movies.entity.SentimentInterestedItem.CREATOR
                java.lang.Object r5 = r2.createFromParcel(r5)
                r2 = r5
                net.one97.paytm.o2o.movies.entity.SentimentInterestedItem r2 = (net.one97.paytm.o2o.movies.entity.SentimentInterestedItem) r2
            L_0x0027:
                r0.<init>(r1, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.entity.LikeDisLikeInfoItem.Creator.createFromParcel(android.os.Parcel):java.lang.Object");
        }

        public final Object[] newArray(int i2) {
            return new LikeDisLikeInfoItem[i2];
        }
    }

    public LikeDisLikeInfoItem() {
        this((SentimentInterestedItem) null, (SentimentInterestedItem) null, 3, (g) null);
    }

    public static /* synthetic */ LikeDisLikeInfoItem copy$default(LikeDisLikeInfoItem likeDisLikeInfoItem, SentimentInterestedItem sentimentInterestedItem, SentimentInterestedItem sentimentInterestedItem2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            sentimentInterestedItem = likeDisLikeInfoItem.sentiment;
        }
        if ((i2 & 2) != 0) {
            sentimentInterestedItem2 = likeDisLikeInfoItem.interested;
        }
        return likeDisLikeInfoItem.copy(sentimentInterestedItem, sentimentInterestedItem2);
    }

    public final SentimentInterestedItem component1() {
        return this.sentiment;
    }

    public final SentimentInterestedItem component2() {
        return this.interested;
    }

    public final LikeDisLikeInfoItem copy(SentimentInterestedItem sentimentInterestedItem, SentimentInterestedItem sentimentInterestedItem2) {
        return new LikeDisLikeInfoItem(sentimentInterestedItem, sentimentInterestedItem2);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LikeDisLikeInfoItem)) {
            return false;
        }
        LikeDisLikeInfoItem likeDisLikeInfoItem = (LikeDisLikeInfoItem) obj;
        return k.a((Object) this.sentiment, (Object) likeDisLikeInfoItem.sentiment) && k.a((Object) this.interested, (Object) likeDisLikeInfoItem.interested);
    }

    public final int hashCode() {
        SentimentInterestedItem sentimentInterestedItem = this.sentiment;
        int i2 = 0;
        int hashCode = (sentimentInterestedItem != null ? sentimentInterestedItem.hashCode() : 0) * 31;
        SentimentInterestedItem sentimentInterestedItem2 = this.interested;
        if (sentimentInterestedItem2 != null) {
            i2 = sentimentInterestedItem2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "LikeDisLikeInfoItem(sentiment=" + this.sentiment + ", interested=" + this.interested + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        SentimentInterestedItem sentimentInterestedItem = this.sentiment;
        if (sentimentInterestedItem != null) {
            parcel.writeInt(1);
            sentimentInterestedItem.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        SentimentInterestedItem sentimentInterestedItem2 = this.interested;
        if (sentimentInterestedItem2 != null) {
            parcel.writeInt(1);
            sentimentInterestedItem2.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    public LikeDisLikeInfoItem(SentimentInterestedItem sentimentInterestedItem, SentimentInterestedItem sentimentInterestedItem2) {
        this.sentiment = sentimentInterestedItem;
        this.interested = sentimentInterestedItem2;
    }

    public final SentimentInterestedItem getSentiment() {
        return this.sentiment;
    }

    public final void setSentiment(SentimentInterestedItem sentimentInterestedItem) {
        this.sentiment = sentimentInterestedItem;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LikeDisLikeInfoItem(SentimentInterestedItem sentimentInterestedItem, SentimentInterestedItem sentimentInterestedItem2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : sentimentInterestedItem, (i2 & 2) != 0 ? null : sentimentInterestedItem2);
    }

    public final SentimentInterestedItem getInterested() {
        return this.interested;
    }

    public final void setInterested(SentimentInterestedItem sentimentInterestedItem) {
        this.interested = sentimentInterestedItem;
    }
}
