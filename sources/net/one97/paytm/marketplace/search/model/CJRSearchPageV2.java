package net.one97.paytm.marketplace.search.model;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRSearchPage;

public class CJRSearchPageV2 extends CJRSearchPage {
    @b(a = "services")
    private ArrayList<CJRHomePageItem> mRelatedServicesList;

    public ArrayList<CJRHomePageItem> getmRelatedServicesList() {
        return this.mRelatedServicesList;
    }

    public void setmRelatedServicesList(ArrayList<CJRHomePageItem> arrayList) {
        this.mRelatedServicesList = arrayList;
    }
}
