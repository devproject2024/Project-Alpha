package net.one97.paytm.oauth.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5Param;
import com.android.volley.toolbox.HttpClientStack;
import com.paytm.network.a;
import com.paytm.network.model.NetworkCustomError;
import com.sendbird.android.constant.StringSet;
import java.util.Iterator;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRPGToken;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.b;
import net.one97.paytm.oauth.models.ErrorModel;
import net.one97.paytm.oauth.models.TokenV3Data;
import net.one97.paytm.oauth.models.TokenV3ResModel;

public final class l {
    public static final String a() {
        b b2 = OauthModule.b();
        k.a((Object) b2, "OauthModule.getOathDataProvider()");
        String e2 = com.paytm.utility.b.e(b2.getApplicationContext());
        k.a((Object) e2, "CJRAppCommonUtility.getD…applicationContext, null)");
        return e2;
    }

    public static final String a(a.C0715a aVar) {
        k.c(aVar, "method");
        int i2 = m.f56781a[aVar.ordinal()];
        if (i2 == 1) {
            return H5Param.DEFAULT_LONG_WEBVIEW_OPENURL_METHOD;
        }
        if (i2 == 2) {
            return "POST";
        }
        if (i2 == 3) {
            return "PUT";
        }
        if (i2 != 4) {
            return i2 != 5 ? "" : "DELETE";
        }
        return HttpClientStack.HttpPatch.METHOD_NAME;
    }

    public static final String a(TokenV3ResModel tokenV3ResModel) {
        k.c(tokenV3ResModel, "tokenV3ResModel");
        Iterator<TokenV3Data> it2 = tokenV3ResModel.getTokens().iterator();
        String str = "";
        while (it2.hasNext()) {
            TokenV3Data next = it2.next();
            String scope = next.getScope();
            if (scope != null) {
                int hashCode = scope.hashCode();
                long j = 0;
                if (hashCode != -795192327) {
                    if (hashCode == 106444065 && scope.equals("paytm")) {
                        str = next.getAccessToken();
                        if (str == null) {
                            str = "";
                        }
                        OauthModule.b().saveSSOToken(str);
                        q qVar = q.f56798a;
                        q.f(str);
                        if (!TextUtils.isEmpty(next.getRefreshToken())) {
                            q qVar2 = q.f56798a;
                            q.d(next.getRefreshToken());
                        }
                        q qVar3 = q.f56798a;
                        Long expiresIn = next.getExpiresIn();
                        if (expiresIn != null) {
                            j = expiresIn.longValue();
                        }
                        q.d(j);
                    }
                } else if (scope.equals("wallet")) {
                    b b2 = OauthModule.b();
                    String scope2 = next.getScope();
                    String accessToken = next.getAccessToken();
                    Long expiresIn2 = next.getExpiresIn();
                    if (expiresIn2 != null) {
                        j = expiresIn2.longValue();
                    }
                    b2.saveWalletScopeToken(scope2, accessToken, j);
                    if (!TextUtils.isEmpty(next.getRefreshToken())) {
                        q qVar4 = q.f56798a;
                        q.e(next.getRefreshToken());
                    }
                }
            }
        }
        return str;
    }

    public static final void a(CJRPGTokenList cJRPGTokenList) {
        k.c(cJRPGTokenList, "resModel");
        Iterator<CJRPGToken> it2 = cJRPGTokenList.getPGTokenList().iterator();
        while (it2.hasNext()) {
            CJRPGToken next = it2.next();
            k.a((Object) next, StringSet.token);
            if (k.a((Object) "wallet", (Object) next.getScope())) {
                new StringBuilder("Wallet Token:").append(next.getAccess_token());
                OauthModule.b().saveWalletScopeToken(next.getScope(), next.getAccess_token(), next.getExpires());
                return;
            }
        }
    }

    public static final boolean a(ErrorModel errorModel) {
        if (errorModel != null) {
            int status = errorModel.getStatus();
            if (status == -1) {
                NetworkCustomError customError = errorModel.getCustomError();
                k.a((Object) customError, "customError");
                if (customError.getErrorType() != NetworkCustomError.ErrorType.NoConnectionError) {
                    NetworkCustomError customError2 = errorModel.getCustomError();
                    k.a((Object) customError2, "customError");
                    return customError2.getUrl() != null;
                }
            }
            Integer num = n.f56790i;
            if (num != null && status == num.intValue()) {
                return true;
            }
        }
        return false;
    }

    public static final boolean a(ErrorModel errorModel, Context context, DialogInterface.OnClickListener onClickListener) {
        k.c(onClickListener, "clickListener");
        if (errorModel == null || errorModel.getStatus() != -1 || context == null) {
            return false;
        }
        OAuthUtils.a(context, context.getString(R.string.no_connection), context.getString(R.string.no_internet), onClickListener);
        return true;
    }
}
