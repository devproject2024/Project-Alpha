package net.one97.paytm.wallet.rateMerchant.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.k;

public final class QnAModel extends IJRPaytmDataModel {
    @b(a = "optionId")
    private final List<Integer> optionsList;
    @b(a = "questionId")
    private final int questionId;

    public static /* synthetic */ QnAModel copy$default(QnAModel qnAModel, int i2, List<Integer> list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = qnAModel.questionId;
        }
        if ((i3 & 2) != 0) {
            list = qnAModel.optionsList;
        }
        return qnAModel.copy(i2, list);
    }

    public final int component1() {
        return this.questionId;
    }

    public final List<Integer> component2() {
        return this.optionsList;
    }

    public final QnAModel copy(int i2, List<Integer> list) {
        k.c(list, "optionsList");
        return new QnAModel(i2, list);
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof QnAModel) {
                QnAModel qnAModel = (QnAModel) obj;
                if (!(this.questionId == qnAModel.questionId) || !k.a((Object) this.optionsList, (Object) qnAModel.optionsList)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i2 = this.questionId * 31;
        List<Integer> list = this.optionsList;
        return i2 + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        return "QnAModel(questionId=" + this.questionId + ", optionsList=" + this.optionsList + ")";
    }

    public QnAModel(int i2, List<Integer> list) {
        k.c(list, "optionsList");
        this.questionId = i2;
        this.optionsList = list;
    }

    public final List<Integer> getOptionsList() {
        return this.optionsList;
    }

    public final int getQuestionId() {
        return this.questionId;
    }
}
