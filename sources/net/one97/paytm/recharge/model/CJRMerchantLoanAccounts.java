package net.one97.paytm.recharge.model;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRMerchantLoanAccounts extends IJRPaytmDataModel implements IJRDataModel {
    private List<CJRMerchantLoanAccountItem> accounts;

    public final List<CJRMerchantLoanAccountItem> getAccounts() {
        return this.accounts;
    }
}
