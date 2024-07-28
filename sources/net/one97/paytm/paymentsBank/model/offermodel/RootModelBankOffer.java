package net.one97.paytm.paymentsBank.model.offermodel;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class RootModelBankOffer extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "page")
    private ModelBankOffers pageModel;

    public ModelBankOffers getPageModel() {
        return this.pageModel;
    }

    public void setPageModel(ModelBankOffers modelBankOffers) {
        this.pageModel = modelBankOffers;
    }
}
