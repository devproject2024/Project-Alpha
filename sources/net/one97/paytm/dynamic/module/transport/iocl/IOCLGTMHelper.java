package net.one97.paytm.dynamic.module.transport.iocl;

import android.content.Context;
import java.util.Map;
import net.one97.paytm.j.a;
import net.one97.paytm.transport.iocl.c;

public class IOCLGTMHelper implements c {
    private static IOCLGTMHelper mInstance;
    private net.one97.paytm.j.c gtmLoader = net.one97.paytm.j.c.a();

    private IOCLGTMHelper() {
    }

    public static IOCLGTMHelper getInstance() {
        if (mInstance == null) {
            mInstance = new IOCLGTMHelper();
        }
        return mInstance;
    }

    public void sendOpenScreenEvent(Context context, String str) {
        a.b(context, str);
    }

    public void sendCustomRechargeEvent(Map<String, Object> map, Context context) {
        a.b(map, context);
    }

    public String getIOCLBaseUrl() {
        return net.one97.paytm.j.c.a("ioclBaseUrl", (String) null);
    }

    public String getIOCLBaseUrlV2() {
        return net.one97.paytm.j.c.a("ioclBaseUrlV2", "");
    }

    public String getIOCLHomeUrl() {
        return net.one97.paytm.j.c.a("ioclHomeUrl", (String) null);
    }

    public String getIOCLRedeemHistoryUrl() {
        return net.one97.paytm.j.c.a("ioclRedeemHistoryUrl", (String) null);
    }

    public String getIOCLOTPUrl() {
        return net.one97.paytm.j.c.a("ioclOTPUrl", (String) null);
    }

    public String getIOCLRegisterUserUrl() {
        return net.one97.paytm.j.c.a("ioclRegisterUrl", (String) null);
    }

    public String getIOCLUserInfoUrl() {
        return net.one97.paytm.j.c.a("ioclUserInfoUrl", (String) null);
    }

    public String getIOCLKycInfoUrl() {
        return net.one97.paytm.j.c.a("kycFetchProfileInfoV2", (String) null);
    }

    public String getHelpVideoDetailsUrl() {
        return net.one97.paytm.j.c.a("helpVideoDetailsUrl", (String) null);
    }

    public String getRedeemIOCLOTPUrl() {
        return net.one97.paytm.j.c.a("ioclRedeemOTPUrl", (String) null);
    }
}
