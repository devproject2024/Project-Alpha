package net.one97.paytm.common.entity.wallet;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public class CJRWalletConvenienceFee extends CJRWalletDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "orderId")
    private String mOrderId;
    @b(a = "requestGuid")
    private String mRequestGuid;
    @b(a = "status")
    private String mStatus;
    @b(a = "statusCode")
    private String mStatusCode;
    @b(a = "statusMessage")
    private String mStatusMessage;
    @b(a = "response")
    public ConvenienceFeeResponse response;
    @b(a = "type")
    private String type;

    public static class ConvenienceFeeResponse {
        @b(a = "convenienceFee")
        private Double mConvenienceFee;
        @b(a = "serviceTax")
        private Double mServiceTax;
        @b(a = "txnAmount")
        private Double mTxnAmount;

        public Double getTxnAmount() {
            return this.mTxnAmount;
        }

        public Double getConvenienceFee() {
            return this.mConvenienceFee;
        }

        public Double getServiceTax() {
            return this.mServiceTax;
        }
    }
}
