package com.paytm.android.chat.network.requests;

import c.a.a.p;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.paytm.android.chat.utils.SharedPreferencesUtil;
import com.paytm.business.merchantprofile.common.utility.AppConstants;

public class BaseRequest {
    p baseData = new p();

    public BaseRequest() {
        String token = SharedPreferencesUtil.getToken();
        if (token != null && !token.isEmpty()) {
            this.baseData.b(AppManagerUtil.EXTEND_PREFIX_DEFAULT, "paytm");
            this.baseData.b(AppConstants.SSO_TOKEN, token);
            this.baseData.b("Content-Type", "application/json");
        }
    }
}
