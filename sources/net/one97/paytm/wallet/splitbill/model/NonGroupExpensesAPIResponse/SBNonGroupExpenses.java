package net.one97.paytm.wallet.splitbill.model.NonGroupExpensesAPIResponse;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.List;
import net.one97.paytm.network.CJRWalletDataModel;

public class SBNonGroupExpenses extends CJRWalletDataModel {
    @c(a = "nextPage")
    @a
    private Boolean nextPage;
    @c(a = "offset")
    @a
    private String offset;
    @c(a = "requestHistoryList")
    @a
    private List<SBRequestHistory> requestHistoryList = null;

    public Boolean getNextPage() {
        return this.nextPage;
    }

    public void setNextPage(Boolean bool) {
        this.nextPage = bool;
    }

    public String getOffset() {
        return this.offset;
    }

    public void setOffset(String str) {
        this.offset = str;
    }

    public List<SBRequestHistory> getRequestHistoryList() {
        return this.requestHistoryList;
    }

    public void setRequestHistoryList(List<SBRequestHistory> list) {
        this.requestHistoryList = list;
    }
}
