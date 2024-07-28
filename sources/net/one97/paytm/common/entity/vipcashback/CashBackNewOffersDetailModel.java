package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.cashback.posttxn.CashBackBaseModal;

public class CashBackNewOffersDetailModel extends CashBackBaseModal {
    private static final long serialVersionUID = 1;
    @b(a = "campaign")
    public CashBackNewOfferModal campaign;
    @b(a = "supercash_game")
    public VIPCashBackOffer supercashGame;

    public static long getSerialVersionUID() {
        return 1;
    }
}
