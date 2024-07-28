package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.cashback.posttxn.CashBackBaseModal;

public class MerchantCashbackOffer extends CashBackBaseModal {
    private static final long serialVersionUID = 1;
    @b(a = "data")
    private Data data;

    public Data getData() {
        return this.data;
    }

    public class Data extends IJRPaytmDataModel {
        private static final long serialVersionUID = 1;
        @b(a = "has_expired_offers")
        private boolean hasExpiredOffers;
        @b(a = "is_next")
        private boolean isNext;
        @b(a = "supercash_list")
        private ArrayList<MerchantGameItem> supercashList;

        public Data() {
        }

        public boolean hasExpiredOffers() {
            return this.hasExpiredOffers;
        }

        public boolean isNext() {
            return this.isNext;
        }

        public ArrayList<MerchantGameItem> getSupercashList() {
            return this.supercashList;
        }
    }
}
