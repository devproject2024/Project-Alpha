package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.cashback.posttxn.CashBackBaseModal;

public class CashBackNewOffersDetailModal extends CashBackBaseModal {
    private static final long serialVersionUID = 1;
    @b(a = "campaign")
    private CashBackNewOfferModal campaign;
    @b(a = "supercash_list")
    private ArrayList<VIPCashBackOffer> supercashList;

    public static long getSerialVersionUID() {
        return 1;
    }

    public CashBackNewOfferModal getCampaign() {
        return this.campaign;
    }

    public ArrayList<VIPCashBackOffer> getSupercashList() {
        return this.supercashList;
    }
}
