package net.one97.paytm.paymentsBank.model.chequebook;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;

public class CbListPaging {
    @a
    @b(a = "limit")
    private Integer limit;
    @a
    @b(a = "nextPage")
    private Boolean nextPage;
    @a
    @b(a = "offset")
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
