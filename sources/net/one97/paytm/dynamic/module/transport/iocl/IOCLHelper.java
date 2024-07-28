package net.one97.paytm.dynamic.module.transport.iocl;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.paytm.network.model.NetworkCustomError;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.common.entity.CJRPGToken;
import net.one97.paytm.common.entity.CJRPGTokenListTransport;
import net.one97.paytm.deeplink.d;
import net.one97.paytm.deeplink.s;
import net.one97.paytm.locale.b.e;
import net.one97.paytm.m;
import net.one97.paytm.oauth.activity.OAuthMainActivity;
import net.one97.paytm.transport.iocl.b;
import net.one97.paytm.utils.l;
import net.one97.paytm.utils.r;
import net.one97.paytm.utils.t;

public class IOCLHelper implements b {
    private static IOCLHelper mInstance;

    private IOCLHelper() {
    }

    public static IOCLHelper getInstance() {
        if (mInstance == null) {
            mInstance = new IOCLHelper();
        }
        return mInstance;
    }

    public Application getApplicationContext() {
        return (Application) CJRJarvisApplication.getAppContext();
    }

    public String getSSOToken(Context context) {
        return t.b(context);
    }

    public String getWalletSSOToken(Context context) {
        return t.c(context);
    }

    public void launchDeeplink(String str, Context context, String str2) {
        l.a(str, context, str2);
    }

    public Class getCSTOrderIssuesActivity() {
        s sVar = s.f50367a;
        return s.a();
    }

    public void openH5CST(Activity activity, Bundle bundle) {
        d.a((Context) activity, bundle, (m) null);
    }

    public Class getAJRMainActivity() {
        s sVar = s.f50367a;
        return s.c();
    }

    public Class getPaySendActivity() {
        s sVar = s.f50367a;
        return s.b();
    }

    public Class getAJRAuthActivity() {
        return OAuthMainActivity.class;
    }

    public Context attachBaseContext(Context context) {
        return e.a(context);
    }

    public void showSessionTimeoutAlert(Activity activity, String str, Bundle bundle, NetworkCustomError networkCustomError, int i2) {
        r.a(activity, (String) null, new Bundle(), (Exception) networkCustomError, false, true, i2);
    }

    public void addBottomBarTab(Context context, LinearLayout linearLayout, View.OnClickListener onClickListener) {
        s sVar = s.f50367a;
        s.a(context, linearLayout, onClickListener);
    }

    public String getWalletSSOToken(CJRPGTokenListTransport cJRPGTokenListTransport) {
        boolean z;
        ArrayList<CJRPGToken> pGTokenList = cJRPGTokenListTransport.getPGTokenList();
        String str = null;
        if (pGTokenList == null) {
            return null;
        }
        int size = pGTokenList.size();
        long j = 0;
        String str2 = null;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            CJRPGToken cJRPGToken = pGTokenList.get(i2);
            String[] split = cJRPGToken.getScopes().split(AppConstants.COMMA);
            int length = split.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    if (!TextUtils.isEmpty(split[i3]) && split[i3].equalsIgnoreCase("wallet")) {
                        z = true;
                        break;
                    }
                    i3++;
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                str = cJRPGToken.getToken();
                j = cJRPGToken.getExpires();
                break;
            }
            if (str2 == null) {
                str2 = cJRPGToken.getResourceOwnerId();
            }
            i2++;
        }
        t.a(j);
        t.b(str);
        t.c(str2);
        return str;
    }
}
