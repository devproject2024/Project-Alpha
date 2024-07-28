package net.one97.paytm.wallet.rateMerchant.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;

public final class AnswerOption extends IJRPaytmDataModel {
    @b(a = "optionId")
    private final int optionId;
    @b(a = "optionText")
    private final String optionTitle;

    public static /* synthetic */ AnswerOption copy$default(AnswerOption answerOption, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = answerOption.optionId;
        }
        if ((i3 & 2) != 0) {
            str = answerOption.optionTitle;
        }
        return answerOption.copy(i2, str);
    }

    public final int component1() {
        return this.optionId;
    }

    public final String component2() {
        return this.optionTitle;
    }

    public final AnswerOption copy(int i2, String str) {
        k.c(str, "optionTitle");
        return new AnswerOption(i2, str);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof AnswerOption) {
                AnswerOption answerOption = (AnswerOption) obj;
                if (!(this.optionId == answerOption.optionId) || !k.a((Object) this.optionTitle, (Object) answerOption.optionTitle)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i2 = this.optionId * 31;
        String str = this.optionTitle;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "AnswerOption(optionId=" + this.optionId + ", optionTitle=" + this.optionTitle + ")";
    }

    public AnswerOption(int i2, String str) {
        k.c(str, "optionTitle");
        this.optionId = i2;
        this.optionTitle = str;
    }

    public final int getOptionId() {
        return this.optionId;
    }

    public final String getOptionTitle() {
        return this.optionTitle;
    }
}
