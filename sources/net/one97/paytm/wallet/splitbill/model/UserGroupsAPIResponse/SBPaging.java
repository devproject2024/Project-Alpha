package net.one97.paytm.wallet.splitbill.model.UserGroupsAPIResponse;

import com.google.gson.a.a;
import com.google.gson.a.c;
import net.one97.paytm.network.CJRWalletDataModel;

public class SBPaging extends CJRWalletDataModel {
    @c(a = "limit")
    @a
    private Integer limit;
    @c(a = "nextPage")
    @a
    private Boolean nextPage;
    @c(a = "offset")
    @a
    private Integer offset;

    public Integer getOffset() {
        return this.offset;
    }

    public void setOffset(Integer num) {
        this.offset = num;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public void setLimit(Integer num) {
        this.limit = num;
    }

    public Boolean getNextPage() {
        return this.nextPage;
    }

    public void setNextPage(Boolean bool) {
        this.nextPage = bool;
    }
}
