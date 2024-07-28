package net.one97.paytm.wallet.rateMerchant.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class QnARequestBody extends IJRPaytmDataModel {
    @b(a = "categories")
    private final List<String> categoryArray;
    @b(a = "contractId")
    private final String contractId;
    @b(a = "questionAnswer")
    private final List<QnAModel> qnaList;
    @b(a = "rating")
    private final String rating;

    public static /* synthetic */ QnARequestBody copy$default(QnARequestBody qnARequestBody, List<QnAModel> list, String str, List<String> list2, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = qnARequestBody.qnaList;
        }
        if ((i2 & 2) != 0) {
            str = qnARequestBody.contractId;
        }
        if ((i2 & 4) != 0) {
            list2 = qnARequestBody.categoryArray;
        }
        if ((i2 & 8) != 0) {
            str2 = qnARequestBody.rating;
        }
        return qnARequestBody.copy(list, str, list2, str2);
    }

    public final List<QnAModel> component1() {
        return this.qnaList;
    }

    public final String component2() {
        return this.contractId;
    }

    public final List<String> component3() {
        return this.categoryArray;
    }

    public final String component4() {
        return this.rating;
    }

    public final QnARequestBody copy(List<QnAModel> list, String str, List<String> list2, String str2) {
        return new QnARequestBody(list, str, list2, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QnARequestBody)) {
            return false;
        }
        QnARequestBody qnARequestBody = (QnARequestBody) obj;
        return k.a((Object) this.qnaList, (Object) qnARequestBody.qnaList) && k.a((Object) this.contractId, (Object) qnARequestBody.contractId) && k.a((Object) this.categoryArray, (Object) qnARequestBody.categoryArray) && k.a((Object) this.rating, (Object) qnARequestBody.rating);
    }

    public final int hashCode() {
        List<QnAModel> list = this.qnaList;
        int i2 = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.contractId;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        List<String> list2 = this.categoryArray;
        int hashCode3 = (hashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        String str2 = this.rating;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "QnARequestBody(qnaList=" + this.qnaList + ", contractId=" + this.contractId + ", categoryArray=" + this.categoryArray + ", rating=" + this.rating + ")";
    }

    public final List<QnAModel> getQnaList() {
        return this.qnaList;
    }

    public final String getContractId() {
        return this.contractId;
    }

    public final List<String> getCategoryArray() {
        return this.categoryArray;
    }

    public QnARequestBody(List<QnAModel> list, String str, List<String> list2, String str2) {
        this.qnaList = list;
        this.contractId = str;
        this.categoryArray = list2;
        this.rating = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QnARequestBody(List list, String str, List list2, String str2, int i2, g gVar) {
        this(list, str, list2, (i2 & 8) != 0 ? null : str2);
    }

    public final String getRating() {
        return this.rating;
    }
}
