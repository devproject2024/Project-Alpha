package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMultipleOffers implements IJRDataModel {
    @b(a = "bank_offers")
    private CJRBankOffers bankOffers;
    @b(a = "emi")
    private CJREmiOffers emi;
    @b(a = "freebie")
    private ArrayList<CJRPaytmOffers> freebieOffers;

    public CJRBankOffers getBankOffers() {
        return this.bankOffers;
    }

    public ArrayList<CJRPaytmOffers> getFreebieOffers() {
        return this.freebieOffers;
    }

    public CJREmiOffers getEmi() {
        return this.emi;
    }

    public void setEmi(CJREmiOffers cJREmiOffers) {
        this.emi = cJREmiOffers;
    }
}
