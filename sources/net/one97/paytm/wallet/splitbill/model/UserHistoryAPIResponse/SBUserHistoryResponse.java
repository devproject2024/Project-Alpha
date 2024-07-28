package net.one97.paytm.wallet.splitbill.model.UserHistoryAPIResponse;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.util.List;
import net.one97.paytm.network.CJRWalletDataModel;

public class SBUserHistoryResponse extends CJRWalletDataModel {
    @c(a = "pagingInfo")
    @a
    private SBPagingInfo pagingInfo;
    @c(a = "response")
    @a
    private List<SBUserHistoryItem> response = null;

    public SBPagingInfo getPagingInfo() {
        return this.pagingInfo;
    }

    public void setPagingInfo(SBPagingInfo sBPagingInfo) {
        this.pagingInfo = sBPagingInfo;
    }

    public List<SBUserHistoryItem> getResponse() {
        return this.response;
    }

    public void setResponse(List<SBUserHistoryItem> list) {
        this.response = list;
    }
}
