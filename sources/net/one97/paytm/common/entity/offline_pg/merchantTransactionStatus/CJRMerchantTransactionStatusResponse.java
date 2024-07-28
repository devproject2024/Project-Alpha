package net.one97.paytm.common.entity.offline_pg.merchantTransactionStatus;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.offline_pg.paymethodresponse.Head;
import net.one97.paytm.network.CJRWalletDataModel;

public class CJRMerchantTransactionStatusResponse extends CJRWalletDataModel implements IJRDataModel {
    Head head;
    @b(a = "body")
    CJRMerchantTransactionStatusResponseBody mResponse;

    public CJRMerchantTransactionStatusResponseBody getResponse() {
        return this.mResponse;
    }
}
