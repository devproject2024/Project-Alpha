package net.one97.paytm.o2o.movies.adapter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CriticReviewAndRating extends IJRPaytmDataModel implements Parcelable {
    public static final a CREATOR = new a((byte) 0);
    @b(a = "ratings")
    private final ArrayList<CriticRatingReviewItem> ratings;
    @b(a = "reviews")
    private final ArrayList<CriticRatingReviewItem> reviews;
    @b(a = "selectedSourceId")
    private int selectedSourceId;

    public CriticReviewAndRating() {
        this((ArrayList) null, (ArrayList) null, 0, 7, (g) null);
    }

    public static /* synthetic */ CriticReviewAndRating copy$default(CriticReviewAndRating criticReviewAndRating, ArrayList<CriticRatingReviewItem> arrayList, ArrayList<CriticRatingReviewItem> arrayList2, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            arrayList = criticReviewAndRating.ratings;
        }
        if ((i3 & 2) != 0) {
            arrayList2 = criticReviewAndRating.reviews;
        }
        if ((i3 & 4) != 0) {
            i2 = criticReviewAndRating.selectedSourceId;
        }
        return criticReviewAndRating.copy(arrayList, arrayList2, i2);
    }

    public final ArrayList<CriticRatingReviewItem> component1() {
        return this.ratings;
    }

    public final ArrayList<CriticRatingReviewItem> component2() {
        return this.reviews;
    }

    public final int component3() {
        return this.selectedSourceId;
    }

    public final CriticReviewAndRating copy(ArrayList<CriticRatingReviewItem> arrayList, ArrayList<CriticRatingReviewItem> arrayList2, int i2) {
        return new CriticReviewAndRating(arrayList, arrayList2, i2);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CriticReviewAndRating)) {
            return false;
        }
        CriticReviewAndRating criticReviewAndRating = (CriticReviewAndRating) obj;
        return k.a((Object) this.ratings, (Object) criticReviewAndRating.ratings) && k.a((Object) this.reviews, (Object) criticReviewAndRating.reviews) && this.selectedSourceId == criticReviewAndRating.selectedSourceId;
    }

    public final int hashCode() {
        ArrayList<CriticRatingReviewItem> arrayList = this.ratings;
        int i2 = 0;
        int hashCode = (arrayList != null ? arrayList.hashCode() : 0) * 31;
        ArrayList<CriticRatingReviewItem> arrayList2 = this.reviews;
        if (arrayList2 != null) {
            i2 = arrayList2.hashCode();
        }
        return ((hashCode + i2) * 31) + Integer.valueOf(this.selectedSourceId).hashCode();
    }

    public final String toString() {
        return "CriticReviewAndRating(ratings=" + this.ratings + ", reviews=" + this.reviews + ", selectedSourceId=" + this.selectedSourceId + ")";
    }

    public final ArrayList<CriticRatingReviewItem> getRatings() {
        return this.ratings;
    }

    public final ArrayList<CriticRatingReviewItem> getReviews() {
        return this.reviews;
    }

    public CriticReviewAndRating(ArrayList<CriticRatingReviewItem> arrayList, ArrayList<CriticRatingReviewItem> arrayList2, int i2) {
        this.ratings = arrayList;
        this.reviews = arrayList2;
        this.selectedSourceId = i2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CriticReviewAndRating(ArrayList arrayList, ArrayList arrayList2, int i2, int i3, g gVar) {
        this((i3 & 1) != 0 ? null : arrayList, (i3 & 2) != 0 ? null : arrayList2, (i3 & 4) != 0 ? -1 : i2);
    }

    public final int getSelectedSourceId() {
        return this.selectedSourceId;
    }

    public final void setSelectedSourceId(int i2) {
        this.selectedSourceId = i2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CriticReviewAndRating(android.os.Parcel r5) {
        /*
            r4 = this;
            java.lang.String r0 = "parcel"
            kotlin.g.b.k.c(r5, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = r0
            java.util.List r1 = (java.util.List) r1
            java.lang.Class<net.one97.paytm.o2o.movies.adapter.CriticRatingReviewItem> r2 = net.one97.paytm.o2o.movies.adapter.CriticRatingReviewItem.class
            java.lang.ClassLoader r2 = r2.getClassLoader()
            r5.readList(r1, r2)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = r1
            java.util.List r2 = (java.util.List) r2
            java.lang.Class<net.one97.paytm.o2o.movies.adapter.CriticRatingReviewItem> r3 = net.one97.paytm.o2o.movies.adapter.CriticRatingReviewItem.class
            java.lang.ClassLoader r3 = r3.getClassLoader()
            r5.readList(r2, r3)
            int r5 = r5.readInt()
            r4.<init>(r0, r1, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.adapter.CriticReviewAndRating.<init>(android.os.Parcel):void");
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeList(this.ratings);
        parcel.writeList(this.reviews);
        parcel.writeInt(this.selectedSourceId);
    }

    public static final class a implements Parcelable.Creator<CriticReviewAndRating> {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            k.c(parcel, "parcel");
            return new CriticReviewAndRating(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new CriticReviewAndRating[i2];
        }
    }
}
