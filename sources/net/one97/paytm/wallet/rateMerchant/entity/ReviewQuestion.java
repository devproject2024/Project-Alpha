package net.one97.paytm.wallet.rateMerchant.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.k;

public final class ReviewQuestion extends IJRPaytmDataModel {
    @b(a = "multiSelect")
    private final boolean isMultichoice;
    @b(a = "options")
    private final List<AnswerOption> optionList;
    @b(a = "questionId")
    private final int questionId;
    @b(a = "questionText")
    private final String questionTitle;

    public static /* synthetic */ ReviewQuestion copy$default(ReviewQuestion reviewQuestion, int i2, String str, List<AnswerOption> list, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = reviewQuestion.questionId;
        }
        if ((i3 & 2) != 0) {
            str = reviewQuestion.questionTitle;
        }
        if ((i3 & 4) != 0) {
            list = reviewQuestion.optionList;
        }
        if ((i3 & 8) != 0) {
            z = reviewQuestion.isMultichoice;
        }
        return reviewQuestion.copy(i2, str, list, z);
    }

    public final int component1() {
        return this.questionId;
    }

    public final String component2() {
        return this.questionTitle;
    }

    public final List<AnswerOption> component3() {
        return this.optionList;
    }

    public final boolean component4() {
        return this.isMultichoice;
    }

    public final ReviewQuestion copy(int i2, String str, List<AnswerOption> list, boolean z) {
        k.c(str, "questionTitle");
        k.c(list, "optionList");
        return new ReviewQuestion(i2, str, list, z);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof ReviewQuestion) {
                ReviewQuestion reviewQuestion = (ReviewQuestion) obj;
                if ((this.questionId == reviewQuestion.questionId) && k.a((Object) this.questionTitle, (Object) reviewQuestion.questionTitle) && k.a((Object) this.optionList, (Object) reviewQuestion.optionList)) {
                    if (this.isMultichoice == reviewQuestion.isMultichoice) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i2 = this.questionId * 31;
        String str = this.questionTitle;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        List<AnswerOption> list = this.optionList;
        if (list != null) {
            i3 = list.hashCode();
        }
        int i4 = (hashCode + i3) * 31;
        boolean z = this.isMultichoice;
        if (z) {
            z = true;
        }
        return i4 + (z ? 1 : 0);
    }

    public final String toString() {
        return "ReviewQuestion(questionId=" + this.questionId + ", questionTitle=" + this.questionTitle + ", optionList=" + this.optionList + ", isMultichoice=" + this.isMultichoice + ")";
    }

    public final int getQuestionId() {
        return this.questionId;
    }

    public final String getQuestionTitle() {
        return this.questionTitle;
    }

    public final List<AnswerOption> getOptionList() {
        return this.optionList;
    }

    public ReviewQuestion(int i2, String str, List<AnswerOption> list, boolean z) {
        k.c(str, "questionTitle");
        k.c(list, "optionList");
        this.questionId = i2;
        this.questionTitle = str;
        this.optionList = list;
        this.isMultichoice = z;
    }

    public final boolean isMultichoice() {
        return this.isMultichoice;
    }
}
