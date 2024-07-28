package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRExchangeDetail implements IJRDataModel {
    @b(a = "category_type")
    private String category_type;
    @b(a = "eligible")
    private boolean eligible;
    @b(a = "exchange_partners")
    private ArrayList<CJRExchangePartner> exchange_partners;

    public boolean isEligible() {
        return this.eligible;
    }

    public String getCategoryType() {
        return this.category_type;
    }

    public ArrayList<CJRExchangePartner> getExchangePartners() {
        return this.exchange_partners;
    }
}
