package net.one97.paytm.games.model.pfg;

import com.google.gson.a.c;
import java.util.ArrayList;
import net.one97.paytm.games.model.GpCommonBaseResponse;

public final class PFGUserTransactionResponse extends GpCommonBaseResponse {
    private UserTransactionData data;

    public final UserTransactionData getData() {
        return this.data;
    }

    public final void setData(UserTransactionData userTransactionData) {
        this.data = userTransactionData;
    }

    public static final class UserTransactionData {
        @c(a = "data")
        private ArrayList<GameUserTransaction> data;
        @c(a = "pageNum")
        private Integer pageNum;
        @c(a = "pageSize")
        private Integer pageSize;
        @c(a = "total")
        private Integer total;

        public final Integer getTotal() {
            return this.total;
        }

        public final void setTotal(Integer num) {
            this.total = num;
        }

        public final Integer getPageNum() {
            return this.pageNum;
        }

        public final void setPageNum(Integer num) {
            this.pageNum = num;
        }

        public final Integer getPageSize() {
            return this.pageSize;
        }

        public final void setPageSize(Integer num) {
            this.pageSize = num;
        }

        public final ArrayList<GameUserTransaction> getData() {
            return this.data;
        }

        public final void setData(ArrayList<GameUserTransaction> arrayList) {
            this.data = arrayList;
        }
    }
}
