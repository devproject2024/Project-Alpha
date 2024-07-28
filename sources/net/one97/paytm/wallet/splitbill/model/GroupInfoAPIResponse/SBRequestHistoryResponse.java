package net.one97.paytm.wallet.splitbill.model.GroupInfoAPIResponse;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.ArrayList;
import net.one97.paytm.network.CJRWalletDataModel;
import net.one97.paytm.wallet.splitbill.model.NonGroupExpensesAPIResponse.SBRequestHistory;

public class SBRequestHistoryResponse extends CJRWalletDataModel {
    @c(a = "nextPage")
    @a
    private Boolean nextPage;
    @c(a = "offset")
    @a
    private String offset;
    @c(a = "requestHistoryList")
    @a
    private ArrayList<SBRequestHistory> requestHistoryList = null;

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

    public ArrayList<SBRequestHistory> getRequestHistoryList() {
        return this.requestHistoryList;
    }

    public void setRequestHistoryList(ArrayList<SBRequestHistory> arrayList) {
        this.requestHistoryList = arrayList;
    }
}
