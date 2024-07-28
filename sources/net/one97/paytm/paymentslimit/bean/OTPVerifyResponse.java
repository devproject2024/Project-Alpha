package net.one97.paytm.paymentslimit.bean;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.network.CJRWalletDataModel;

public class OTPVerifyResponse extends CJRWalletDataModel {
    @b(a = "message")
    public String message;
    public String otp;
    @b(a = "responseCode")
    public String responseCode;
    @b(a = "state")
    public String state;
    @b(a = "status")
    public String status;
}
