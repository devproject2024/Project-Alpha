package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.cashback.posttxn.CashBackBaseModal;

public class MerchantCampaignGameResponse extends CashBackBaseModal {
    private static final long serialVersionUID = 1;
    @b(a = "data")
    private MerchantCampaignGameItem data;

    public MerchantCampaignGameItem getData() {
        return this.data;
    }
}
