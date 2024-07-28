package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.cashback.posttxn.Campaign;
import net.one97.paytm.cashback.posttxn.CashBackBaseModal;

public final class CampaignData extends CashBackBaseModal {
    @b(a = "data")
    private Data data;

    public final Data getData() {
        return this.data;
    }

    public final void setData(Data data2) {
        this.data = data2;
    }

    public final class Data {
        @b(a = "campaigns")
        private ArrayList<Campaign> campaignsList;
        @b(a = "is_next")
        private boolean isNext;

        public Data() {
        }

        public final ArrayList<Campaign> getCampaignsList() {
            return this.campaignsList;
        }

        public final void setCampaignsList(ArrayList<Campaign> arrayList) {
            this.campaignsList = arrayList;
        }

        public final boolean isNext() {
            return this.isNext;
        }

        public final void setNext(boolean z) {
            this.isNext = z;
        }
    }
}
