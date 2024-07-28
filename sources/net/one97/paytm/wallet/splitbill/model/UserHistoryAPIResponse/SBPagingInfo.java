package net.one97.paytm.wallet.splitbill.model.UserHistoryAPIResponse;

import com.google.gson.a.a;
import com.google.gson.a.c;
import net.one97.paytm.network.CJRWalletDataModel;

public class SBPagingInfo extends CJRWalletDataModel {
    @c(a = "limit")
    @a
    private Integer limit;
    @c(a = "offset")
    @a
    private Integer offset;
    @c(a = "total")
    @a
    private Integer total;

    public Integer getLimit() {
        return this.limit;
    }

    public void setLimit(Integer num) {
        this.limit = num;
    }

    public Integer getTotal() {
        return this.total;
    }

    public void setTotal(Integer num) {
        this.total = num;
    }

    public Integer getOffset() {
        return this.offset;
    }

    public void setOffset(Integer num) {
        this.offset = num;
    }
}
