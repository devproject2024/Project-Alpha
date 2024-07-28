package net.one97.paytm.wallet.rateMerchant.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class ReviewQuestionResponse extends IJRPaytmDataModel {
    @b(a = "meta")
    private final b meta;
    @b(a = "data")
    private final ReviewQuestionData reviewQuestionData;

    public ReviewQuestionResponse() {
        this((b) null, (ReviewQuestionData) null, 3, (g) null);
    }

    public static /* synthetic */ ReviewQuestionResponse copy$default(ReviewQuestionResponse reviewQuestionResponse, b bVar, ReviewQuestionData reviewQuestionData2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bVar = reviewQuestionResponse.meta;
        }
        if ((i2 & 2) != 0) {
            reviewQuestionData2 = reviewQuestionResponse.reviewQuestionData;
        }
        return reviewQuestionResponse.copy(bVar, reviewQuestionData2);
    }

    public final b component1() {
        return this.meta;
    }

    public final ReviewQuestionData component2() {
        return this.reviewQuestionData;
    }

    public final ReviewQuestionResponse copy(b bVar, ReviewQuestionData reviewQuestionData2) {
        return new ReviewQuestionResponse(bVar, reviewQuestionData2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReviewQuestionResponse)) {
            return false;
        }
        ReviewQuestionResponse reviewQuestionResponse = (ReviewQuestionResponse) obj;
        return k.a((Object) this.meta, (Object) reviewQuestionResponse.meta) && k.a((Object) this.reviewQuestionData, (Object) reviewQuestionResponse.reviewQuestionData);
    }

    public final int hashCode() {
        b bVar = this.meta;
        int i2 = 0;
        int hashCode = (bVar != null ? bVar.hashCode() : 0) * 31;
        ReviewQuestionData reviewQuestionData2 = this.reviewQuestionData;
        if (reviewQuestionData2 != null) {
            i2 = reviewQuestionData2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "ReviewQuestionResponse(meta=" + this.meta + ", reviewQuestionData=" + this.reviewQuestionData + ")";
    }

    public ReviewQuestionResponse(b bVar, ReviewQuestionData reviewQuestionData2) {
        this.meta = bVar;
        this.reviewQuestionData = reviewQuestionData2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReviewQuestionResponse(b bVar, ReviewQuestionData reviewQuestionData2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : bVar, (i2 & 2) != 0 ? null : reviewQuestionData2);
    }

    public final b getMeta() {
        return this.meta;
    }

    public final ReviewQuestionData getReviewQuestionData() {
        return this.reviewQuestionData;
    }
}
