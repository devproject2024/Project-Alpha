package net.one97.paytm.paymentsBank.model.offermodel;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class ModelBankOffers extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "views")
    private List<ViewsItem> views;

    public void setViews(List<ViewsItem> list) {
        this.views = list;
    }

    public List<ViewsItem> getViews() {
        return this.views;
    }
}
