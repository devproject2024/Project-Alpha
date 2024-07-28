package net.one97.paytm.o2o.movies.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJRMetricInfoDataItem implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @b(a = "metricData")
    private LikeDisLikeInfoItem metricData;
    @b(a = "ratingsData")
    private HashMap<String, CJRRatingDataItem> ratingsData;
    @b(a = "reviewData")
    private CRJReviewData reviewData;
    @b(a = "sessionData")
    private CJRSessionData sessionData;

    public static class Creator implements Parcelable.Creator {
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: net.one97.paytm.o2o.movies.entity.CRJReviewData} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object createFromParcel(android.os.Parcel r8) {
            /*
                r7 = this;
                java.lang.String r0 = "in"
                kotlin.g.b.k.c(r8, r0)
                net.one97.paytm.o2o.movies.entity.CJRMetricInfoDataItem r0 = new net.one97.paytm.o2o.movies.entity.CJRMetricInfoDataItem
                int r1 = r8.readInt()
                r2 = 0
                if (r1 == 0) goto L_0x0017
                android.os.Parcelable$Creator r1 = net.one97.paytm.o2o.movies.entity.LikeDisLikeInfoItem.CREATOR
                java.lang.Object r1 = r1.createFromParcel(r8)
                net.one97.paytm.o2o.movies.entity.LikeDisLikeInfoItem r1 = (net.one97.paytm.o2o.movies.entity.LikeDisLikeInfoItem) r1
                goto L_0x0018
            L_0x0017:
                r1 = r2
            L_0x0018:
                int r3 = r8.readInt()
                if (r3 == 0) goto L_0x003b
                int r3 = r8.readInt()
                java.util.HashMap r4 = new java.util.HashMap
                r4.<init>(r3)
            L_0x0027:
                if (r3 == 0) goto L_0x003c
                java.lang.String r5 = r8.readString()
                android.os.Parcelable$Creator r6 = net.one97.paytm.o2o.movies.entity.CJRRatingDataItem.CREATOR
                java.lang.Object r6 = r6.createFromParcel(r8)
                net.one97.paytm.o2o.movies.entity.CJRRatingDataItem r6 = (net.one97.paytm.o2o.movies.entity.CJRRatingDataItem) r6
                r4.put(r5, r6)
                int r3 = r3 + -1
                goto L_0x0027
            L_0x003b:
                r4 = r2
            L_0x003c:
                int r3 = r8.readInt()
                if (r3 == 0) goto L_0x004b
                android.os.Parcelable$Creator r3 = net.one97.paytm.o2o.movies.entity.CJRSessionData.CREATOR
                java.lang.Object r3 = r3.createFromParcel(r8)
                net.one97.paytm.o2o.movies.entity.CJRSessionData r3 = (net.one97.paytm.o2o.movies.entity.CJRSessionData) r3
                goto L_0x004c
            L_0x004b:
                r3 = r2
            L_0x004c:
                int r5 = r8.readInt()
                if (r5 == 0) goto L_0x005b
                android.os.Parcelable$Creator r2 = net.one97.paytm.o2o.movies.entity.CRJReviewData.CREATOR
                java.lang.Object r8 = r2.createFromParcel(r8)
                r2 = r8
                net.one97.paytm.o2o.movies.entity.CRJReviewData r2 = (net.one97.paytm.o2o.movies.entity.CRJReviewData) r2
            L_0x005b:
                r0.<init>(r1, r4, r3, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.entity.CJRMetricInfoDataItem.Creator.createFromParcel(android.os.Parcel):java.lang.Object");
        }

        public final Object[] newArray(int i2) {
            return new CJRMetricInfoDataItem[i2];
        }
    }

    public CJRMetricInfoDataItem() {
        this((LikeDisLikeInfoItem) null, (HashMap) null, (CJRSessionData) null, (CRJReviewData) null, 15, (g) null);
    }

    public static /* synthetic */ CJRMetricInfoDataItem copy$default(CJRMetricInfoDataItem cJRMetricInfoDataItem, LikeDisLikeInfoItem likeDisLikeInfoItem, HashMap<String, CJRRatingDataItem> hashMap, CJRSessionData cJRSessionData, CRJReviewData cRJReviewData, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            likeDisLikeInfoItem = cJRMetricInfoDataItem.metricData;
        }
        if ((i2 & 2) != 0) {
            hashMap = cJRMetricInfoDataItem.ratingsData;
        }
        if ((i2 & 4) != 0) {
            cJRSessionData = cJRMetricInfoDataItem.sessionData;
        }
        if ((i2 & 8) != 0) {
            cRJReviewData = cJRMetricInfoDataItem.reviewData;
        }
        return cJRMetricInfoDataItem.copy(likeDisLikeInfoItem, hashMap, cJRSessionData, cRJReviewData);
    }

    public final LikeDisLikeInfoItem component1() {
        return this.metricData;
    }

    public final HashMap<String, CJRRatingDataItem> component2() {
        return this.ratingsData;
    }

    public final CJRSessionData component3() {
        return this.sessionData;
    }

    public final CRJReviewData component4() {
        return this.reviewData;
    }

    public final CJRMetricInfoDataItem copy(LikeDisLikeInfoItem likeDisLikeInfoItem, HashMap<String, CJRRatingDataItem> hashMap, CJRSessionData cJRSessionData, CRJReviewData cRJReviewData) {
        return new CJRMetricInfoDataItem(likeDisLikeInfoItem, hashMap, cJRSessionData, cRJReviewData);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRMetricInfoDataItem)) {
            return false;
        }
        CJRMetricInfoDataItem cJRMetricInfoDataItem = (CJRMetricInfoDataItem) obj;
        return k.a((Object) this.metricData, (Object) cJRMetricInfoDataItem.metricData) && k.a((Object) this.ratingsData, (Object) cJRMetricInfoDataItem.ratingsData) && k.a((Object) this.sessionData, (Object) cJRMetricInfoDataItem.sessionData) && k.a((Object) this.reviewData, (Object) cJRMetricInfoDataItem.reviewData);
    }

    public final int hashCode() {
        LikeDisLikeInfoItem likeDisLikeInfoItem = this.metricData;
        int i2 = 0;
        int hashCode = (likeDisLikeInfoItem != null ? likeDisLikeInfoItem.hashCode() : 0) * 31;
        HashMap<String, CJRRatingDataItem> hashMap = this.ratingsData;
        int hashCode2 = (hashCode + (hashMap != null ? hashMap.hashCode() : 0)) * 31;
        CJRSessionData cJRSessionData = this.sessionData;
        int hashCode3 = (hashCode2 + (cJRSessionData != null ? cJRSessionData.hashCode() : 0)) * 31;
        CRJReviewData cRJReviewData = this.reviewData;
        if (cRJReviewData != null) {
            i2 = cRJReviewData.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "CJRMetricInfoDataItem(metricData=" + this.metricData + ", ratingsData=" + this.ratingsData + ", sessionData=" + this.sessionData + ", reviewData=" + this.reviewData + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        LikeDisLikeInfoItem likeDisLikeInfoItem = this.metricData;
        if (likeDisLikeInfoItem != null) {
            parcel.writeInt(1);
            likeDisLikeInfoItem.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        HashMap<String, CJRRatingDataItem> hashMap = this.ratingsData;
        if (hashMap != null) {
            parcel.writeInt(1);
            parcel.writeInt(hashMap.size());
            for (Map.Entry<String, CJRRatingDataItem> next : hashMap.entrySet()) {
                parcel.writeString(next.getKey());
                next.getValue().writeToParcel(parcel, 0);
            }
        } else {
            parcel.writeInt(0);
        }
        CJRSessionData cJRSessionData = this.sessionData;
        if (cJRSessionData != null) {
            parcel.writeInt(1);
            cJRSessionData.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        CRJReviewData cRJReviewData = this.reviewData;
        if (cRJReviewData != null) {
            parcel.writeInt(1);
            cRJReviewData.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    public CJRMetricInfoDataItem(LikeDisLikeInfoItem likeDisLikeInfoItem, HashMap<String, CJRRatingDataItem> hashMap, CJRSessionData cJRSessionData, CRJReviewData cRJReviewData) {
        this.metricData = likeDisLikeInfoItem;
        this.ratingsData = hashMap;
        this.sessionData = cJRSessionData;
        this.reviewData = cRJReviewData;
    }

    public final LikeDisLikeInfoItem getMetricData() {
        return this.metricData;
    }

    public final void setMetricData(LikeDisLikeInfoItem likeDisLikeInfoItem) {
        this.metricData = likeDisLikeInfoItem;
    }

    public final HashMap<String, CJRRatingDataItem> getRatingsData() {
        return this.ratingsData;
    }

    public final void setRatingsData(HashMap<String, CJRRatingDataItem> hashMap) {
        this.ratingsData = hashMap;
    }

    public final CJRSessionData getSessionData() {
        return this.sessionData;
    }

    public final void setSessionData(CJRSessionData cJRSessionData) {
        this.sessionData = cJRSessionData;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRMetricInfoDataItem(LikeDisLikeInfoItem likeDisLikeInfoItem, HashMap hashMap, CJRSessionData cJRSessionData, CRJReviewData cRJReviewData, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : likeDisLikeInfoItem, (i2 & 2) != 0 ? null : hashMap, (i2 & 4) != 0 ? null : cJRSessionData, (i2 & 8) != 0 ? null : cRJReviewData);
    }

    public final CRJReviewData getReviewData() {
        return this.reviewData;
    }

    public final void setReviewData(CRJReviewData cRJReviewData) {
        this.reviewData = cRJReviewData;
    }
}
