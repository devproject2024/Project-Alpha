package net.one97.paytm.paymentslimit.bean;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.network.CJRWalletDataModel;

public class CJRTransitionLimitResponse extends CJRWalletDataModel {
    @b(a = "metadata")
    public String metadata;
    @b(a = "orderId")
    public String orderId;
    @b(a = "requestGuid")
    public String requestGuid;
    @b(a = "response")
    public String response;
    @b(a = "status")
    public String status;
    @b(a = "statusCode")
    public String statusCode;
    @b(a = "statusMessage")
    public String statusMessage;
    @b(a = "type")
    public String type;
}
