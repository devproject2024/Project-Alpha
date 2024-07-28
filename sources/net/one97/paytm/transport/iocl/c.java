package net.one97.paytm.transport.iocl;

import android.content.Context;
import java.util.Map;

public interface c {
    String getIOCLBaseUrl();

    String getIOCLBaseUrlV2();

    String getIOCLHomeUrl();

    String getIOCLKycInfoUrl();

    String getIOCLOTPUrl();

    String getIOCLRedeemHistoryUrl();

    String getIOCLRegisterUserUrl();

    String getIOCLUserInfoUrl();

    String getRedeemIOCLOTPUrl();

    void sendCustomRechargeEvent(Map<String, Object> map, Context context);

    void sendOpenScreenEvent(Context context, String str);
}
