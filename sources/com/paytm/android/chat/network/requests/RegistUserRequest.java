package com.paytm.android.chat.network.requests;

import c.a.a.a;
import c.a.a.p;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.google.gsonhtcfix.f;
import com.paytm.android.chat.bean.jsonbean.UserRegistJsonBean;
import com.paytm.android.chat.network.UrlManager;
import com.paytm.android.chat.network.UrlProfileList;
import com.paytm.android.chat.network.response.ResponseOfRegister;
import com.paytm.android.chat.utils.SharedPreferencesUtil;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.utility.q;

public class RegistUserRequest {

    public interface PFRegistCallBack {
        void onFailure(int i2, String str);

        void onSuccess(ResponseOfRegister responseOfRegister);
    }

    public RegistUserRequest(UserRegistJsonBean userRegistJsonBean, final PFRegistCallBack pFRegistCallBack) {
        String url = UrlManager.getUrl(UrlProfileList.REGIST_USER);
        q.d("url:".concat(String.valueOf(url)));
        SharedPreferencesUtil.saveString(SharedPreferencesUtil.Key.PF_ID, userRegistJsonBean.getUserId());
        p pVar = new p();
        String token = userRegistJsonBean.getToken();
        if (token != null && !token.isEmpty()) {
            pVar.b(AppManagerUtil.EXTEND_PREFIX_DEFAULT, "paytm");
            pVar.b(AppConstants.SSO_TOKEN, token);
            SharedPreferencesUtil.saveString(SharedPreferencesUtil.Key.SELF_TOKEN, token);
            pVar.b("Content-Type", "application/json");
        }
        String a2 = new f().a((Object) userRegistJsonBean);
        q.b("RegistUserRequest, request param:".concat(String.valueOf(a2)));
        pVar.c("application/json", a2);
        c.a.a.f.b(url, pVar, new a<String>() {
            public final /* synthetic */ void a(Object obj) {
                String str = (String) obj;
                q.b("RegistUserRequest, response:".concat(String.valueOf(str)));
                ResponseOfRegister responseOfRegister = (ResponseOfRegister) new f().a(str, ResponseOfRegister.class);
                if (responseOfRegister == null) {
                    PFRegistCallBack pFRegistCallBack = pFRegistCallBack;
                    if (pFRegistCallBack != null) {
                        pFRegistCallBack.onFailure(-1, "Data Parse Error");
                    }
                } else if (!responseOfRegister.getResultCode().equals("0")) {
                    q.b("RegistUserRequest parse resultCode == " + responseOfRegister.getResultCode());
                    PFRegistCallBack pFRegistCallBack2 = pFRegistCallBack;
                    if (pFRegistCallBack2 != null) {
                        pFRegistCallBack2.onFailure(-2, "RegistUserRequest parse resultCode == " + responseOfRegister.getResultCode());
                    }
                } else if (responseOfRegister.getUserId() == null) {
                    PFRegistCallBack pFRegistCallBack3 = pFRegistCallBack;
                    if (pFRegistCallBack3 != null) {
                        pFRegistCallBack3.onFailure(-3, "RegistUserRequest response userId is null");
                    }
                } else {
                    SharedPreferencesUtil.saveUserId(responseOfRegister.getUserId());
                    if (responseOfRegister.getAccessToken() != null && !responseOfRegister.getAccessToken().isEmpty()) {
                        SharedPreferencesUtil.saveString(SharedPreferencesUtil.Key.SB_TOKEN, responseOfRegister.getAccessToken());
                    }
                    PFRegistCallBack pFRegistCallBack4 = pFRegistCallBack;
                    if (pFRegistCallBack4 != null) {
                        pFRegistCallBack4.onSuccess(responseOfRegister);
                    }
                }
            }

            public final void a(int i2, String str) {
                PFRegistCallBack pFRegistCallBack = pFRegistCallBack;
                if (pFRegistCallBack != null) {
                    pFRegistCallBack.onFailure(i2, str);
                }
            }
        });
    }
}
