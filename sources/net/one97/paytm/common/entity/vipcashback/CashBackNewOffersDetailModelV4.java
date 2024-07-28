package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.cashback.posttxn.Campaign;
import net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4;

public class CashBackNewOffersDetailModelV4 extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "campaign")
    public Campaign campaign;
    @b(a = "supercash_game")
    public VIPCashBackOfferV4 supercashGame;

    public static long getSerialVersionUID() {
        return 1;
    }
}
