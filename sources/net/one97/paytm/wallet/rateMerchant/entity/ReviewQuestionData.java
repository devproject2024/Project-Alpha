package net.one97.paytm.wallet.rateMerchant.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class ReviewQuestionData extends IJRPaytmDataModel {
    @b(a = "remainingQuestionCount")
    private final int remainingQuestionCount;
    @b(a = "question")
    private final ReviewQuestion reviewQuestion;
    @b(a = "totalQuestionCount")
    private final int totalQuestionCount;

    public static /* synthetic */ ReviewQuestionData copy$default(ReviewQuestionData reviewQuestionData, int i2, int i3, ReviewQuestion reviewQuestion2, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = reviewQuestionData.totalQuestionCount;
        }
        if ((i4 & 2) != 0) {
            i3 = reviewQuestionData.remainingQuestionCount;
        }
        if ((i4 & 4) != 0) {
            reviewQuestion2 = reviewQuestionData.reviewQuestion;
        }
        return reviewQuestionData.copy(i2, i3, reviewQuestion2);
    }

    public final int component1() {
        return this.totalQuestionCount;
    }

    public final int component2() {
        return this.remainingQuestionCount;
    }

    public final ReviewQuestion component3() {
        return this.reviewQuestion;
    }

    public final ReviewQuestionData copy(int i2, int i3, ReviewQuestion reviewQuestion2) {
        k.c(reviewQuestion2, "reviewQuestion");
        return new ReviewQuestionData(i2, i3, reviewQuestion2);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ReviewQuestionData) {
                ReviewQuestionData reviewQuestionData = (ReviewQuestionData) obj;
                if (this.totalQuestionCount == reviewQuestionData.totalQuestionCount) {
                    if (!(this.remainingQuestionCount == reviewQuestionData.remainingQuestionCount) || !k.a((Object) this.reviewQuestion, (Object) reviewQuestionData.reviewQuestion)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i2 = ((this.totalQuestionCount * 31) + this.remainingQuestionCount) * 31;
        ReviewQuestion reviewQuestion2 = this.reviewQuestion;
        return i2 + (reviewQuestion2 != null ? reviewQuestion2.hashCode() : 0);
    }

    public final String toString() {
        return "ReviewQuestionData(totalQuestionCount=" + this.totalQuestionCount + ", remainingQuestionCount=" + this.remainingQuestionCount + ", reviewQuestion=" + this.reviewQuestion + ")";
    }

    public final int getTotalQuestionCount() {
        return this.totalQuestionCount;
    }

    public ReviewQuestionData(int i2, int i3, ReviewQuestion reviewQuestion2) {
        k.c(reviewQuestion2, "reviewQuestion");
        this.totalQuestionCount = i2;
        this.remainingQuestionCount = i3;
        this.reviewQuestion = reviewQuestion2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReviewQuestionData(int i2, int i3, ReviewQuestion reviewQuestion2, int i4, g gVar) {
        this((i4 & 1) != 0 ? 0 : i2, (i4 & 2) != 0 ? 0 : i3, reviewQuestion2);
    }

    public final int getRemainingQuestionCount() {
        return this.remainingQuestionCount;
    }

    public final ReviewQuestion getReviewQuestion() {
        return this.reviewQuestion;
    }
}
