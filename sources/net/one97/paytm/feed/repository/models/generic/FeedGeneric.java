package net.one97.paytm.feed.repository.models.generic;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.a.c;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.feed.repository.models.FeedItem;

public final class FeedGeneric extends FeedItem {
    public static final CREATOR CREATOR = new CREATOR((g) null);
    @c(a = "cardData")
    private FeedGenericData feedGenericData;
    private Parcel parcel;

    public static /* synthetic */ FeedGeneric copy$default(FeedGeneric feedGeneric, FeedGenericData feedGenericData2, Parcel parcel2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            feedGenericData2 = feedGeneric.feedGenericData;
        }
        if ((i2 & 2) != 0) {
            parcel2 = feedGeneric.parcel;
        }
        return feedGeneric.copy(feedGenericData2, parcel2);
    }

    public final FeedGenericData component1() {
        return this.feedGenericData;
    }

    public final Parcel component2() {
        return this.parcel;
    }

    public final FeedGeneric copy(FeedGenericData feedGenericData2, Parcel parcel2) {
        k.c(feedGenericData2, "feedGenericData");
        return new FeedGeneric(feedGenericData2, parcel2);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedGeneric)) {
            return false;
        }
        FeedGeneric feedGeneric = (FeedGeneric) obj;
        return k.a((Object) this.feedGenericData, (Object) feedGeneric.feedGenericData) && k.a((Object) this.parcel, (Object) feedGeneric.parcel);
    }

    public final int hashCode() {
        FeedGenericData feedGenericData2 = this.feedGenericData;
        int i2 = 0;
        int hashCode = (feedGenericData2 != null ? feedGenericData2.hashCode() : 0) * 31;
        Parcel parcel2 = this.parcel;
        if (parcel2 != null) {
            i2 = parcel2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "FeedGeneric(feedGenericData=" + this.feedGenericData + ", parcel=" + this.parcel + ")";
    }

    public final FeedGenericData getFeedGenericData() {
        return this.feedGenericData;
    }

    public final void setFeedGenericData(FeedGenericData feedGenericData2) {
        k.c(feedGenericData2, "<set-?>");
        this.feedGenericData = feedGenericData2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedGeneric(FeedGenericData feedGenericData2, Parcel parcel2) {
        super(parcel2);
        k.c(feedGenericData2, "feedGenericData");
        this.feedGenericData = feedGenericData2;
        this.parcel = parcel2;
        Parcel parcel3 = this.parcel;
        if (parcel3 != null) {
            Parcelable readParcelable = parcel3.readParcelable(FeedGenericData.class.getClassLoader());
            if (readParcelable == null) {
                k.a();
            }
            this.feedGenericData = (FeedGenericData) readParcelable;
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
    public FeedGeneric(android.os.Parcel r38) {
        /*
            r37 = this;
            r0 = r38
            java.lang.String r1 = "parcel"
            kotlin.g.b.k.c(r0, r1)
            net.one97.paytm.feed.repository.models.generic.FeedGenericData r1 = new net.one97.paytm.feed.repository.models.generic.FeedGenericData
            r2 = r1
            r3 = 0
            java.lang.Integer r31 = java.lang.Integer.valueOf(r3)
            r13 = r31
            r14 = r31
            r15 = r31
            java.lang.Boolean r16 = java.lang.Boolean.FALSE
            java.lang.Boolean r21 = java.lang.Boolean.FALSE
            r20 = r21
            java.lang.Boolean r22 = java.lang.Boolean.FALSE
            r19 = r22
            java.lang.Boolean r25 = java.lang.Boolean.FALSE
            java.lang.String r9 = ""
            java.lang.String r10 = ""
            java.lang.String r3 = ""
            java.lang.String r11 = ""
            java.lang.String r7 = ""
            java.lang.String r17 = ""
            java.lang.String r18 = ""
            java.lang.String r12 = ""
            java.lang.String r8 = ""
            java.lang.String r6 = ""
            java.lang.String r26 = ""
            java.lang.String r27 = ""
            java.lang.String r28 = ""
            java.lang.String r29 = ""
            java.lang.String r33 = ""
            java.lang.String r30 = ""
            java.lang.String r32 = ""
            java.lang.String r35 = ""
            java.lang.String r36 = ""
            r4 = 0
            r5 = 0
            r23 = 0
            r24 = 0
            r34 = 1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)
            r2 = r37
            r2.<init>(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.feed.repository.models.generic.FeedGeneric.<init>(android.os.Parcel):void");
    }

    public final void writeToParcel(Parcel parcel2, int i2) {
        k.c(parcel2, "parcel");
        super.writeToParcel(parcel2, i2);
        parcel2.writeParcelable(this.feedGenericData, i2);
    }

    public static final class CREATOR implements Parcelable.Creator<FeedGeneric> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(g gVar) {
            this();
        }

        public final FeedGeneric createFromParcel(Parcel parcel) {
            k.c(parcel, "parcel");
            return new FeedGeneric(parcel);
        }

        public final FeedGeneric[] newArray(int i2) {
            return new FeedGeneric[i2];
        }
    }
}
