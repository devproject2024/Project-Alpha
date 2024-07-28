package net.one97.paytm.oauth.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.URLUtil;
import com.alipay.mobile.h5container.api.H5Param;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.gsonhtcfix.f;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.security.PublicKey;
import java.util.HashMap;
import net.one97.paytm.common.entity.shopping.CJRHomePageV2;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.activity.AJRChangePassword;
import net.one97.paytm.oauth.activity.MergeAccountActivity;
import net.one97.paytm.oauth.activity.OAuthMainActivity;
import net.one97.paytm.oauth.fragment.AccountBlockEnterNumberFragment;
import net.one97.paytm.oauth.fragment.AccountBlockReasonFragment;
import net.one97.paytm.oauth.fragment.EnterNewNumberFragment;
import net.one97.paytm.oauth.fragment.ForgotEnterNumberFragment;
import net.one97.paytm.oauth.fragment.ForgotEnterOtpFragment;
import net.one97.paytm.oauth.fragment.NewNumberOtpFragment;
import net.one97.paytm.oauth.fragment.SavedCardListFragment;
import net.one97.paytm.oauth.fragment.SetNewPasswordFragment;
import net.one97.paytm.oauth.fragment.UpdatePhoneConfirmBottomFragment;
import net.one97.paytm.oauth.fragment.VerifyEmailOtpFragment;
import net.one97.paytm.oauth.fragment.VerifyPhoneOtpFragment;
import net.one97.paytm.oauth.fragment.ah;
import net.one97.paytm.oauth.fragment.ai;
import net.one97.paytm.oauth.fragment.aq;
import net.one97.paytm.oauth.fragment.as;
import net.one97.paytm.oauth.models.AccountBlockStatusResModel;
import net.one97.paytm.oauth.models.AuthEncryptedSSOToken;
import net.one97.paytm.oauth.models.AuthorizationInitResModel;
import net.one97.paytm.oauth.models.AuthorizationResModel;
import net.one97.paytm.oauth.models.CJRAccessToken;
import net.one97.paytm.oauth.models.CJRChangePwdStatus;
import net.one97.paytm.oauth.models.DeviceBindingInitResModel;
import net.one97.paytm.oauth.models.DeviceBindingStausResModel;
import net.one97.paytm.oauth.models.DoVerify;
import net.one97.paytm.oauth.models.DoViewResModel;
import net.one97.paytm.oauth.models.EmptyResModel;
import net.one97.paytm.oauth.models.FetchAccessTokenReqModel;
import net.one97.paytm.oauth.models.MergeChallenge;
import net.one97.paytm.oauth.models.Meta;
import net.one97.paytm.oauth.models.SavedCardsResModel;
import net.one97.paytm.oauth.models.SimplifiedLoginInit;
import net.one97.paytm.oauth.models.TokenV3ResModel;
import net.one97.paytm.oauth.models.UpdatePhoneResModel;
import net.one97.paytm.oauth.models.UpgradeDeviceReqModel;
import net.one97.paytm.oauth.models.VerificationInitResModel;
import net.one97.paytm.oauth.models.VerificationResModel;
import net.one97.paytm.oauth.models.VerifyCardDetailsReqModel;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.utils.l;
import net.one97.paytm.oauth.utils.n;
import net.one97.paytm.oauth.utils.o;
import net.one97.paytm.oauth.utils.s;
import net.one97.paytm.oauth.utils.t;
import net.one97.paytm.upi.util.UpiConstantServiceApi;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    public static com.paytm.network.b a(String str) {
        com.paytm.network.b bVar = new com.paytm.network.b();
        bVar.f42877a = OauthModule.b().getApplicationContext();
        bVar.o = str;
        bVar.f42878b = a.c.AUTH;
        bVar.k = false;
        bVar.u = false;
        return bVar;
    }

    public static void a(Context context, com.paytm.network.listener.b bVar, String str, String str2) {
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("forgetpasswordSv1");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(context, a2);
            s sVar = s.f56801a;
            HashMap<String, String> a3 = s.a();
            a3.put("loginId", str);
            a3.put("verificationType", str2);
            a3.put("autoReadHash", OauthModule.a().c());
            try {
                o oVar = o.f56791a;
                o.a(a3);
            } catch (NullPointerException e3) {
                q.b(e3.getMessage());
                NetworkCustomError networkCustomError = new NetworkCustomError();
                networkCustomError.setStatusCode(n.f56790i.intValue());
                bVar.handleErrorCode(n.f56790i.intValue(), (IJRPaytmDataModel) null, networkCustomError);
            }
            o oVar2 = o.f56791a;
            o.a(e2, l.a(a.C0715a.PUT), a3, "");
            com.paytm.network.b a4 = a(ForgotEnterNumberFragment.class.getName());
            a4.n = a.b.USER_FACING;
            a4.f42879c = a.C0715a.PUT;
            a4.f42880d = e2;
            a4.f42882f = a3;
            a4.j = bVar;
            a4.f42885i = new SimplifiedLoginInit();
            a l = a4.l();
            l.f42860d = true;
            if (!com.paytm.network.b.b.a(context)) {
                bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            } else {
                l.a();
            }
        }
    }

    public static void a(String str, Context context, com.paytm.network.listener.b bVar) {
        String str2 = "code=" + str + "&scope=paytm&grant_type=authorization_code";
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/x-www-form-urlencoded");
        hashMap.put("Authorization", OauthModule.a().f52576c);
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a(UpiConstantServiceApi.KEY_TOKEN);
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(context, a2);
            com.paytm.network.b a3 = a(OAuthMainActivity.class.getName());
            a3.n = a.b.SILENT;
            a3.f42879c = a.C0715a.POST;
            a3.f42880d = e2;
            a3.f42882f = hashMap;
            a3.f42884h = str2;
            a3.j = bVar;
            a3.f42885i = new CJRAccessToken();
            a l = a3.l();
            if (!com.paytm.network.b.b.a(context)) {
                bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            } else {
                l.a();
            }
        }
    }

    public static void b(Context context, com.paytm.network.listener.b bVar, String str, String str2) {
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("oauthValidateOtpSv1");
        o oVar = o.f56791a;
        if (!o.a()) {
            net.one97.paytm.oauth.a.a();
            a2 = net.one97.paytm.oauth.a.a("simple_auth_validate_otp_url");
        }
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(context, a2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("otp", str);
                jSONObject.put("stateToken", str2);
            } catch (JSONException e3) {
                q.b(e3.getMessage());
            }
            s sVar = s.f56801a;
            HashMap<String, String> a3 = s.a();
            o oVar2 = o.f56791a;
            o.a(e2, l.a(a.C0715a.POST), a3, jSONObject.toString());
            com.paytm.network.b a4 = a(ai.class.getName());
            a4.n = a.b.SILENT;
            a4.f42879c = a.C0715a.POST;
            a4.f42880d = e2;
            a4.f42882f = a3;
            a4.f42884h = jSONObject.toString();
            a4.j = bVar;
            a4.f42885i = new SimplifiedLoginInit();
            a4.x = 0;
            a l = a4.l();
            l.f42860d = true;
            if (!com.paytm.network.b.b.a(context)) {
                bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            } else {
                l.a();
            }
        }
    }

    public static void a(com.paytm.network.listener.b bVar, String str, String str2, String str3) {
        Context applicationContext = OauthModule.b().getApplicationContext();
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("oauthdevicebindingConfirmSv1");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(applicationContext, a2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(H5Param.SESSION_ID, str2);
                jSONObject.put("method", "otp");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(ContactColumn.PHONE_NUMBER, str3);
                jSONObject2.put("otpValue", str);
                jSONObject.put("meta", jSONObject2);
            } catch (JSONException e3) {
                q.b(e3.getMessage());
            }
            s sVar = s.f56801a;
            HashMap<String, String> a3 = s.a();
            com.paytm.network.b a4 = a(ai.class.getName());
            a4.n = a.b.SILENT;
            a4.f42879c = a.C0715a.POST;
            a4.f42880d = e2;
            a4.f42882f = a3;
            a4.f42884h = jSONObject.toString();
            a4.j = bVar;
            a4.f42885i = new SimplifiedLoginInit();
            a4.x = 0;
            a l = a4.l();
            l.f42860d = true;
            if (!com.paytm.network.b.b.a(applicationContext)) {
                bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            } else {
                l.a();
            }
        }
    }

    public static void a(Context context, com.paytm.network.listener.b bVar, String str, boolean z) {
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("oauthSimpleResendOtpSv1");
        o oVar = o.f56791a;
        if (!o.a()) {
            net.one97.paytm.oauth.a.a();
            a2 = net.one97.paytm.oauth.a.a("simple_auth_otp_url");
        }
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(context, a2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("stateToken", str);
                String str2 = "SMS";
                if (z) {
                    str2 = "OBD";
                }
                jSONObject.put("otpDeliveryMethod", str2);
            } catch (JSONException e3) {
                q.b(e3.getMessage());
            }
            s sVar = s.f56801a;
            HashMap<String, String> a3 = s.a();
            a3.put("autoReadHash", OauthModule.a().c());
            o oVar2 = o.f56791a;
            o.a(e2, l.a(a.C0715a.POST), a3, jSONObject.toString());
            com.paytm.network.b a4 = a(ai.class.getName());
            a4.n = a.b.SILENT;
            a4.f42879c = a.C0715a.POST;
            a4.f42880d = e2;
            a4.f42882f = a3;
            a4.f42884h = jSONObject.toString();
            a4.j = bVar;
            a4.f42885i = new SimplifiedLoginInit();
            a4.x = 0;
            a l = a4.l();
            l.f42860d = true;
            if (!com.paytm.network.b.b.a(context)) {
                bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            } else {
                l.a();
            }
        }
    }

    private static void a(boolean z, String str, String str2, com.paytm.network.listener.b bVar, a.c cVar) {
        Context applicationContext = OauthModule.b().getApplicationContext();
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("oauthTokenV3");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(applicationContext, a2);
            s sVar = s.f56801a;
            HashMap<String, String> a3 = s.a();
            FetchAccessTokenReqModel fetchAccessTokenReqModel = new FetchAccessTokenReqModel(z ? "refresh_token" : "authorization_code", l.a());
            if (z) {
                fetchAccessTokenReqModel.setRefreshToken(str2);
            } else {
                fetchAccessTokenReqModel.setCode(str);
            }
            com.paytm.network.b a4 = a(OauthModule.class.getName());
            a4.n = a.b.SILENT;
            a4.f42879c = a.C0715a.POST;
            a4.f42880d = e2;
            a4.f42882f = a3;
            a4.f42884h = new f().a((Object) fetchAccessTokenReqModel);
            a4.j = bVar;
            a4.f42885i = new TokenV3ResModel();
            a4.x = 1;
            if (cVar != null) {
                a4.f42878b = cVar;
            }
            a l = a4.l();
            if (!com.paytm.network.b.b.a(applicationContext)) {
                bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            } else {
                l.a();
            }
        }
    }

    public static void a(String str, com.paytm.network.listener.b bVar) {
        a(false, str, (String) null, bVar, (a.c) null);
    }

    public static void a(String str, com.paytm.network.listener.b bVar, a.c cVar) {
        a(true, (String) null, str, bVar, cVar);
    }

    public static void b(String str, com.paytm.network.listener.b bVar) {
        a(true, (String) null, str, bVar, (a.c) null);
    }

    public static void a(Context context, com.paytm.network.listener.b bVar, String str) {
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("oauthSimpleClaimSv1");
        o oVar = o.f56791a;
        if (!o.a()) {
            net.one97.paytm.oauth.a.a();
            a2 = net.one97.paytm.oauth.a.a("claim_acc_url");
        }
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(context, a2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("stateToken", str);
            } catch (JSONException e3) {
                q.b(e3.getMessage());
            }
            s sVar = s.f56801a;
            HashMap<String, String> a3 = s.a();
            o oVar2 = o.f56791a;
            o.a(e2, l.a(a.C0715a.POST), a3, jSONObject.toString());
            com.paytm.network.b a4 = a(ah.class.getName());
            a4.n = a.b.SILENT;
            a4.f42879c = a.C0715a.POST;
            a4.f42880d = e2;
            a4.f42882f = a3;
            a4.f42884h = jSONObject.toString();
            a4.j = bVar;
            a4.f42885i = new SimplifiedLoginInit();
            a4.x = 0;
            a l = a4.l();
            l.f42860d = true;
            if (!com.paytm.network.b.b.a(context)) {
                bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            } else {
                l.a();
            }
        }
    }

    public static void c(String str, com.paytm.network.listener.b bVar) {
        Context applicationContext = OauthModule.b().getApplicationContext();
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("oauthDeviceUpgradeSv1");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(applicationContext, a2);
            o oVar = o.f56791a;
            PublicKey b2 = o.b();
            String a3 = new f().a((Object) new UpgradeDeviceReqModel(b2 != null ? Base64.encodeToString(b2.getEncoded(), 2) : "", l.a()));
            s sVar = s.f56801a;
            HashMap<String, String> a4 = s.a();
            a4.put("session_token", str);
            o oVar2 = o.f56791a;
            o.a(e2, l.a(a.C0715a.POST), a4, a3);
            com.paytm.network.b a5 = a(OAuthMainActivity.class.getName());
            a5.n = a.b.SILENT;
            a5.f42879c = a.C0715a.POST;
            a5.f42880d = e2;
            a5.f42882f = a4;
            a5.f42884h = a3;
            a5.j = bVar;
            a5.f42885i = new UpdatePhoneResModel();
            a5.x = 1;
            a l = a5.l();
            if (!com.paytm.network.b.b.a(applicationContext)) {
                bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            } else {
                l.a();
            }
        }
    }

    public static void d(String str, com.paytm.network.listener.b bVar) {
        Context applicationContext = OauthModule.b().getApplicationContext();
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("oauthTokenUpgradeSv1");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(applicationContext, a2);
            FetchAccessTokenReqModel fetchAccessTokenReqModel = new FetchAccessTokenReqModel("upgrade_token", l.a());
            fetchAccessTokenReqModel.setAccessToken(str);
            String a3 = new f().a((Object) fetchAccessTokenReqModel);
            s sVar = s.f56801a;
            HashMap<String, String> a4 = s.a();
            com.paytm.network.b a5 = a(OAuthMainActivity.class.getName());
            a5.n = a.b.SILENT;
            a5.f42879c = a.C0715a.POST;
            a5.f42880d = e2;
            a5.f42882f = a4;
            a5.f42884h = a3;
            a5.j = bVar;
            a5.f42885i = new TokenV3ResModel();
            a5.x = 1;
            a l = a5.l();
            if (!com.paytm.network.b.b.a(applicationContext)) {
                bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            } else {
                l.a();
            }
        }
    }

    public static void a(Context context, t tVar) {
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("logout_all_devices_sso");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(context, a2);
            HashMap hashMap = new HashMap();
            hashMap.put("Authorization", com.paytm.utility.b.m());
            hashMap.put("Content-Type", "application/json");
            hashMap.put("session_token", OauthModule.b().getSSOToken());
            com.paytm.network.b a3 = a(as.class.getName());
            a3.n = a.b.SILENT;
            a3.f42879c = a.C0715a.DELETE;
            a3.f42880d = e2;
            a3.f42882f = hashMap;
            a3.j = tVar;
            a3.f42885i = new EmptyResModel();
            OAuthUtils.a(context, (OAuthUtils.a) new OAuthUtils.a(a3.l()) {
                private final /* synthetic */ a f$1;

                {
                    this.f$1 = r2;
                }

                public final void onNetWorkAvailable() {
                    b.c(t.this, this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void c(t tVar, a aVar) {
        tVar.a();
        aVar.a();
    }

    public static void a(Context context, String str, boolean z, String str2, String str3, t tVar) {
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("mergeChallenge");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(context, a2);
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("Authorization", com.paytm.utility.b.m());
                hashMap.put("Content-Type", "application/json");
                hashMap.put("session_token", OauthModule.b().getSSOToken());
                String e3 = com.paytm.utility.b.e(context, e2);
                JSONObject jSONObject = new JSONObject();
                String str4 = "0";
                if (z) {
                    str4 = "1";
                }
                jSONObject.put("confirmation", str4);
                if (str2 != null) {
                    jSONObject.put("data", str2);
                }
                if (str3 != null) {
                    jSONObject.put("option", str3);
                }
                jSONObject.put("state", str);
                jSONObject.put("doNotRedirect", true);
                com.paytm.network.b a3 = a(MergeAccountActivity.class.getName());
                a3.n = a.b.SILENT;
                a3.f42879c = a.C0715a.POST;
                a3.f42880d = e3;
                a3.f42882f = hashMap;
                a3.j = tVar;
                a3.f42885i = new MergeChallenge();
                OAuthUtils.a(context, (OAuthUtils.a) new OAuthUtils.a(a3.l()) {
                    private final /* synthetic */ a f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onNetWorkAvailable() {
                        b.b(t.this, this.f$1);
                    }
                });
            } catch (Exception e4) {
                if (com.paytm.utility.b.v) {
                    q.b(e4.getMessage());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(t tVar, a aVar) {
        tVar.a();
        aVar.a();
    }

    public static void a(Context context, String str, String str2, Boolean bool, Boolean bool2, t tVar) {
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("changePasswordV2Sv1");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(context, a2);
            s sVar = s.f56801a;
            HashMap<String, String> a3 = s.a();
            a3.put("session_token", OauthModule.b().getSSOToken());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("oldPassword", str);
                jSONObject.put("newPassword", str2);
                jSONObject.put("confirmPassword", str2);
                jSONObject.put("passwordUpgrade", bool2);
                if (bool.booleanValue()) {
                    jSONObject.put("userLogoutConsent", "LOGOUT_FROM_ALL_DEVICES");
                } else {
                    jSONObject.put("userLogoutConsent", "LOGOUT_FROM_NONE");
                }
                String e3 = com.paytm.utility.b.e(context, e2);
                o oVar = o.f56791a;
                o.a(e3, l.a(a.C0715a.POST), a3, jSONObject.toString());
                com.paytm.network.b a4 = a(AJRChangePassword.class.getName());
                a4.n = a.b.SILENT;
                a4.f42879c = a.C0715a.POST;
                a4.f42880d = e3;
                a4.f42882f = a3;
                a4.f42884h = jSONObject.toString();
                a4.j = tVar;
                a4.f42885i = new CJRChangePwdStatus();
                OAuthUtils.a(context, (OAuthUtils.a) new OAuthUtils.a(a4.l()) {
                    private final /* synthetic */ a f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onNetWorkAvailable() {
                        b.a(t.this, this.f$1);
                    }
                });
            } catch (Exception e4) {
                q.b(e4.getMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(t tVar, a aVar) {
        tVar.a();
        aVar.a();
    }

    public static void a(com.paytm.network.listener.b bVar) {
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("encryptedTokenUrl");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(OauthModule.b().getApplicationContext(), a2);
            com.paytm.network.b a3 = a("Encrypted Token");
            a3.n = a.b.USER_FACING;
            a3.f42879c = a.C0715a.GET;
            a3.f42880d = e2;
            a3.f42882f = com.paytm.utility.b.ah(OauthModule.b().getApplicationContext());
            a3.j = bVar;
            a3.f42885i = new AuthEncryptedSSOToken();
            a3.l().a();
        }
    }

    public static void b(com.paytm.network.listener.b bVar, String str, String str2, String str3) {
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("validateOtpV4");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(OauthModule.b().getApplicationContext(), a2);
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("Authorization", OauthModule.a().f52576c);
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("session_token", str3);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("otp", str);
                jSONObject.put("state_token", str2);
            } catch (JSONException e3) {
                q.b(e3.getMessage());
            }
            com.paytm.network.b a3 = a(ForgotEnterOtpFragment.class.getName());
            a3.n = a.b.SILENT;
            a3.f42879c = a.C0715a.POST;
            a3.f42880d = e2;
            a3.f42882f = hashMap;
            a3.f42884h = jSONObject.toString();
            a3.j = bVar;
            a3.f42885i = new UpdatePhoneResModel();
            a l = a3.l();
            l.f42860d = true;
            if (com.paytm.network.b.b.a(OauthModule.b().getApplicationContext())) {
                l.a();
            } else {
                bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            }
        }
    }

    public static void a(com.paytm.network.listener.b bVar, String str, String str2, Boolean bool) {
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("forgetpasswordSv1");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(OauthModule.b().getApplicationContext(), a2);
            s sVar = s.f56801a;
            HashMap<String, String> a3 = s.a();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("stateToken", str);
                jSONObject.put("newPassword", str2);
                jSONObject.put("confirmNewPassword", str2);
                if (bool.booleanValue()) {
                    jSONObject.put("userLogoutConsent", "LOGOUT_FROM_ALL_DEVICES");
                } else {
                    jSONObject.put("userLogoutConsent", "LOGOUT_FROM_NONE");
                }
            } catch (JSONException e3) {
                q.b(e3.getMessage());
            }
            o oVar = o.f56791a;
            o.a(e2, l.a(a.C0715a.POST), a3, jSONObject.toString());
            com.paytm.network.b a4 = a(SetNewPasswordFragment.class.getName());
            a4.n = a.b.USER_FACING;
            a4.f42879c = a.C0715a.POST;
            a4.f42880d = e2;
            a4.f42882f = a3;
            a4.f42884h = jSONObject.toString();
            a4.j = bVar;
            a4.f42885i = new SimplifiedLoginInit();
            a l = a4.l();
            l.f42860d = true;
            if (com.paytm.network.b.b.a(OauthModule.b().getApplicationContext())) {
                l.a();
            } else {
                bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            }
        }
    }

    public static void c(com.paytm.network.listener.b bVar, String str, String str2, String str3) {
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("sendOtpV4");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(OauthModule.b().getApplicationContext(), a2);
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("Authorization", OauthModule.a().f52576c);
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("session_token", str3);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("state_token", str);
                jSONObject.put("mode", str2);
            } catch (JSONException e3) {
                q.b(e3.getMessage());
            }
            com.paytm.network.b a3 = a(UpdatePhoneConfirmBottomFragment.class.getName());
            a3.n = a.b.USER_FACING;
            a3.f42879c = a.C0715a.POST;
            a3.f42880d = e2;
            a3.f42882f = hashMap;
            a3.f42884h = jSONObject.toString();
            a3.j = bVar;
            a3.f42885i = new UpdatePhoneResModel();
            a l = a3.l();
            l.f42860d = true;
            if (com.paytm.network.b.b.a(OauthModule.b().getApplicationContext())) {
                l.a();
            } else {
                bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            }
        }
    }

    public static void a(com.paytm.network.listener.b bVar, String str, String str2) {
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("OauthsendOTPUserEmailV4SV1");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(OauthModule.b().getApplicationContext(), a2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("stateToken", str);
                jSONObject.put(AppConstants.KEY_EMAIL, str2);
            } catch (JSONException e3) {
                q.b(e3.getMessage());
            }
            s sVar = s.f56801a;
            HashMap<String, String> a3 = s.a();
            a3.put("autoReadHash", OauthModule.a().c());
            o oVar = o.f56791a;
            o.a(e2, l.a(a.C0715a.PUT), a3, jSONObject.toString());
            com.paytm.network.b a4 = a(VerifyEmailOtpFragment.class.getName());
            a4.n = a.b.USER_FACING;
            a4.f42879c = a.C0715a.PUT;
            a4.f42880d = e2;
            a4.f42882f = a3;
            a4.f42884h = jSONObject.toString();
            a4.j = bVar;
            a4.f42885i = new UpdatePhoneResModel();
            a4.x = 0;
            a l = a4.l();
            l.f42860d = true;
            if (com.paytm.network.b.b.a(OauthModule.b().getApplicationContext())) {
                l.a();
            } else {
                bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            }
        }
    }

    public static void b(com.paytm.network.listener.b bVar, String str, String str2) {
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("userPhoneV4");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(OauthModule.b().getApplicationContext(), a2);
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("Authorization", OauthModule.a().f52576c);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("state_token", str);
                jSONObject.put(UpiConstants.EXTRA_PHONE_NUMBER_FROM_P2P, str2);
            } catch (JSONException e3) {
                q.b(e3.getMessage());
            }
            com.paytm.network.b a3 = a(EnterNewNumberFragment.class.getName());
            a3.n = a.b.USER_FACING;
            a3.f42879c = a.C0715a.PUT;
            a3.f42880d = e2;
            a3.f42882f = hashMap;
            a3.f42884h = jSONObject.toString();
            a3.j = bVar;
            a3.f42885i = new UpdatePhoneResModel();
            a l = a3.l();
            l.f42860d = true;
            if (com.paytm.network.b.b.a(OauthModule.b().getApplicationContext())) {
                l.a();
            } else {
                bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            }
        }
    }

    public static void c(com.paytm.network.listener.b bVar, String str, String str2) {
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("userValidateOtpV4");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(OauthModule.b().getApplicationContext(), a2);
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("Authorization", OauthModule.a().f52576c);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("state_token", str);
                jSONObject.put("otp", str2);
            } catch (JSONException e3) {
                q.b(e3.getMessage());
            }
            com.paytm.network.b a3 = a(NewNumberOtpFragment.class.getName());
            a3.n = a.b.USER_FACING;
            a3.f42879c = a.C0715a.POST;
            a3.f42880d = e2;
            a3.f42882f = hashMap;
            a3.f42884h = jSONObject.toString();
            a3.j = bVar;
            a3.f42885i = new UpdatePhoneResModel();
            a l = a3.l();
            l.f42860d = true;
            if (com.paytm.network.b.b.a(OauthModule.b().getApplicationContext())) {
                l.a();
            } else {
                bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            }
        }
    }

    public static void a(com.paytm.network.listener.b bVar, String str) {
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("oauthResendOtp");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(OauthModule.b().getApplicationContext(), a2);
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            hashMap.put("Authorization", OauthModule.a().f52576c);
            hashMap.put("autoReadHash", OauthModule.a().c());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("state_token", str);
            } catch (JSONException e3) {
                q.b(e3.getMessage());
            }
            com.paytm.network.b a3 = a(NewNumberOtpFragment.class.getName());
            a3.n = a.b.USER_FACING;
            a3.f42879c = a.C0715a.POST;
            a3.f42880d = e2;
            a3.f42882f = hashMap;
            a3.f42884h = jSONObject.toString();
            a3.j = bVar;
            a3.f42885i = new UpdatePhoneResModel();
            a l = a3.l();
            l.f42860d = true;
            if (com.paytm.network.b.b.a(OauthModule.b().getApplicationContext())) {
                l.a();
            } else {
                bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            }
        }
    }

    public static void d(com.paytm.network.listener.b bVar, String str, String str2) {
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("OauthResendOTPSV1");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(OauthModule.b().getApplicationContext(), a2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("state_token", str);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("otp_delivery_method", str2);
                }
            } catch (JSONException e3) {
                q.b(e3.getMessage());
            }
            s sVar = s.f56801a;
            HashMap<String, String> a3 = s.a();
            a3.put("autoReadHash", OauthModule.a().c());
            o oVar = o.f56791a;
            o.a(e2, l.a(a.C0715a.POST), a3, jSONObject.toString());
            com.paytm.network.b a4 = a(NewNumberOtpFragment.class.getName());
            a4.n = a.b.USER_FACING;
            a4.f42879c = a.C0715a.POST;
            a4.f42880d = e2;
            a4.f42882f = a3;
            a4.f42884h = jSONObject.toString();
            a4.j = bVar;
            a4.f42885i = new UpdatePhoneResModel();
            a4.x = 0;
            a l = a4.l();
            l.f42860d = true;
            if (com.paytm.network.b.b.a(OauthModule.b().getApplicationContext())) {
                l.a();
            } else {
                bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            }
        }
    }

    public static void e(com.paytm.network.listener.b bVar, String str, String str2) {
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("OauthUserValidateOTPSV1");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(OauthModule.b().getApplicationContext(), a2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("state_token", str);
                jSONObject.put("otp", str2);
            } catch (JSONException e3) {
                q.b(e3.getMessage());
            }
            s sVar = s.f56801a;
            HashMap<String, String> a3 = s.a();
            o oVar = o.f56791a;
            o.a(e2, l.a(a.C0715a.POST), a3, jSONObject.toString());
            com.paytm.network.b a4 = a(NewNumberOtpFragment.class.getName());
            a4.n = a.b.USER_FACING;
            a4.f42879c = a.C0715a.POST;
            a4.f42880d = e2;
            a4.f42882f = a3;
            a4.f42884h = jSONObject.toString();
            a4.j = bVar;
            a4.f42885i = new UpdatePhoneResModel();
            a4.x = 0;
            a l = a4.l();
            l.f42860d = true;
            if (com.paytm.network.b.b.a(OauthModule.b().getApplicationContext())) {
                l.a();
            } else {
                bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            }
        }
    }

    public static void f(com.paytm.network.listener.b bVar, String str, String str2) {
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("oauthSendOtpV3");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(OauthModule.b().getApplicationContext(), a2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("loginId", str);
                jSONObject.put("actionType", str2);
            } catch (JSONException e3) {
                q.b(e3.getMessage());
            }
            s sVar = s.f56801a;
            HashMap<String, String> a3 = s.a();
            a3.put("autoReadHash", OauthModule.a().c());
            com.paytm.network.b a4 = a(UpdatePhoneConfirmBottomFragment.class.getName());
            a4.n = a.b.USER_FACING;
            a4.f42879c = a.C0715a.POST;
            a4.f42880d = e2;
            a4.f42882f = a3;
            a4.f42884h = jSONObject.toString();
            a4.j = bVar;
            a4.f42885i = new UpdatePhoneResModel();
            a4.x = 0;
            a l = a4.l();
            l.f42860d = true;
            if (com.paytm.network.b.b.a(OauthModule.b().getApplicationContext())) {
                l.a();
            } else {
                bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            }
        }
    }

    public static void d(com.paytm.network.listener.b bVar, String str, String str2, String str3) {
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("profileResendOTPV3");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(OauthModule.b().getApplicationContext(), a2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("state", str);
                jSONObject.put("type", str2);
            } catch (JSONException e3) {
                q.b(e3.getMessage());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("Authorization", com.paytm.utility.b.m());
            hashMap.put("Content-Type", "application/json");
            hashMap.put("Accept", "application/json");
            hashMap.put("autoReadHash", OauthModule.a().c());
            com.paytm.network.b a3 = a(str3);
            a3.n = a.b.USER_FACING;
            a3.f42879c = a.C0715a.POST;
            a3.f42880d = e2;
            a3.f42882f = hashMap;
            a3.f42884h = jSONObject.toString();
            a3.f42885i = new UpdatePhoneResModel();
            a3.j = bVar;
            a l = a3.l();
            if (com.paytm.network.b.b.a(OauthModule.b().getApplicationContext())) {
                l.a();
            } else {
                bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            }
        }
    }

    public static void a(com.paytm.network.listener.b bVar, String str, String str2, String str3, String str4) {
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("profileValidateOTPV3");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(OauthModule.b().getApplicationContext(), a2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("state", str);
                jSONObject.put("currentPhoneOtp", str2);
                if (!TextUtils.isEmpty(str3)) {
                    jSONObject.put("updatedPhoneOtp", str3);
                }
            } catch (JSONException e3) {
                q.b(e3.getMessage());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("Authorization", com.paytm.utility.b.m());
            hashMap.put("Content-Type", "application/json");
            hashMap.put("Accept", "application/json");
            com.paytm.network.b a3 = a(str4);
            a3.n = a.b.USER_FACING;
            a3.f42879c = a.C0715a.POST;
            a3.f42880d = e2;
            a3.f42882f = hashMap;
            a3.f42884h = jSONObject.toString();
            a3.f42885i = new UpdatePhoneResModel();
            a3.j = bVar;
            a l = a3.l();
            if (com.paytm.network.b.b.a(OauthModule.b().getApplicationContext())) {
                l.a();
            } else {
                bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            }
        }
    }

    public static void g(com.paytm.network.listener.b bVar, String str, String str2) {
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("oauthVerificationInit");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(OauthModule.b().getApplicationContext(), a2);
            boolean r = com.paytm.utility.b.r(OauthModule.b().getApplicationContext());
            JSONObject jSONObject = new JSONObject();
            if (!r) {
                try {
                    jSONObject.put("stateCode", str);
                } catch (JSONException e3) {
                    q.b(e3.getMessage());
                }
            }
            jSONObject.put("bizFlow", str2);
            HashMap hashMap = new HashMap();
            hashMap.put("Authorization", com.paytm.utility.b.m());
            hashMap.put("Content-Type", "application/json");
            if (r) {
                hashMap.put("session_token", OauthModule.b().getSSOToken());
            }
            com.paytm.network.b a3 = a("Init");
            a3.n = a.b.USER_FACING;
            a3.f42879c = a.C0715a.POST;
            a3.f42880d = e2;
            a3.f42882f = hashMap;
            a3.f42884h = jSONObject.toString();
            a3.f42885i = new VerificationResModel();
            a3.j = bVar;
            a l = a3.l();
            if (com.paytm.network.b.b.a(OauthModule.b().getApplicationContext())) {
                l.a();
            } else {
                bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            }
        }
    }

    public static void b(com.paytm.network.listener.b bVar, String str) {
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("oauthVerificationFulfill");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(OauthModule.b().getApplicationContext(), a2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("stateCode", str);
            } catch (JSONException e3) {
                q.b(e3.getMessage());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("Authorization", com.paytm.utility.b.m());
            hashMap.put("Content-Type", "application/json");
            com.paytm.network.b a3 = a("Fulfill");
            a3.n = a.b.USER_FACING;
            a3.f42879c = a.C0715a.POST;
            a3.f42880d = e2;
            a3.f42882f = hashMap;
            a3.f42884h = jSONObject.toString();
            a3.f42885i = new VerificationResModel();
            a3.j = bVar;
            a l = a3.l();
            if (com.paytm.network.b.b.a(OauthModule.b().getApplicationContext())) {
                l.a();
            } else {
                bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            }
        }
    }

    public static void b(com.paytm.network.listener.b bVar, String str, String str2, String str3, String str4) {
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("oauthVerifyCard");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(OauthModule.b().getApplicationContext(), a2);
            VerifyCardDetailsReqModel verifyCardDetailsReqModel = new VerifyCardDetailsReqModel(str, str2, str3, new Meta(str4));
            HashMap hashMap = new HashMap();
            hashMap.put("Authorization", com.paytm.utility.b.m());
            hashMap.put("Content-Type", "application/json");
            com.paytm.network.b a3 = a("Fulfill");
            a3.n = a.b.USER_FACING;
            a3.f42879c = a.C0715a.POST;
            a3.f42880d = e2;
            a3.f42882f = hashMap;
            a3.f42884h = new f().a((Object) verifyCardDetailsReqModel);
            a3.f42885i = new VerificationResModel();
            a3.j = bVar;
            a l = a3.l();
            if (com.paytm.network.b.b.a(OauthModule.b().getApplicationContext())) {
                l.a();
            } else {
                bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            }
        }
    }

    public static void h(com.paytm.network.listener.b bVar, String str, String str2) {
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("restDoViewLogin");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(OauthModule.b().getApplicationContext(), a2);
            HashMap hashMap = new HashMap();
            hashMap.put("Authorization", com.paytm.utility.b.m());
            hashMap.put("Content-Type", "application/json");
            hashMap.put("session_token", str2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("verifyId", str);
                jSONObject.put("method", "SAVED_CARD");
            } catch (JSONException e3) {
                q.b(e3.getMessage());
            }
            com.paytm.network.b a3 = a(SavedCardListFragment.class.getName());
            a3.n = a.b.USER_FACING;
            a3.f42879c = a.C0715a.POST;
            a3.f42880d = e2;
            a3.f42882f = hashMap;
            a3.f42884h = jSONObject.toString();
            a3.f42885i = new SavedCardsResModel();
            a3.j = bVar;
            a l = a3.l();
            if (com.paytm.network.b.b.a(OauthModule.b().getApplicationContext())) {
                l.a();
            } else {
                bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            }
        }
    }

    public static void c(com.paytm.network.listener.b bVar, String str) {
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("restDoViewLogout");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(OauthModule.b().getApplicationContext(), a2);
            HashMap hashMap = new HashMap();
            hashMap.put("Authorization", com.paytm.utility.b.m());
            hashMap.put("Content-Type", "application/json");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("verifyId", str);
                jSONObject.put("method", "SAVED_CARD");
            } catch (JSONException e3) {
                q.b(e3.getMessage());
            }
            com.paytm.network.b a3 = a(SavedCardListFragment.class.getName());
            a3.n = a.b.USER_FACING;
            a3.f42879c = a.C0715a.POST;
            a3.f42880d = e2;
            a3.f42882f = hashMap;
            a3.f42884h = jSONObject.toString();
            a3.f42885i = new SavedCardsResModel();
            a3.j = bVar;
            a l = a3.l();
            if (com.paytm.network.b.b.a(OauthModule.b().getApplicationContext())) {
                l.a();
            } else {
                bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            }
        }
    }

    public static void e(com.paytm.network.listener.b bVar, String str, String str2, String str3) {
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("OauthValidateOTPV4SV1");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(OauthModule.b().getApplicationContext(), a2);
            s sVar = s.f56801a;
            HashMap<String, String> a3 = s.a();
            if (!TextUtils.isEmpty(str3)) {
                a3.put("session_token", str3);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("otp", str);
                jSONObject.put("state_token", str2);
            } catch (JSONException e3) {
                q.b(e3.getMessage());
            }
            o oVar = o.f56791a;
            o.a(e2, l.a(a.C0715a.POST), a3, jSONObject.toString());
            com.paytm.network.b a4 = a(VerifyPhoneOtpFragment.class.getName());
            a4.n = a.b.SILENT;
            a4.f42879c = a.C0715a.POST;
            a4.f42880d = e2;
            a4.f42882f = a3;
            a4.f42884h = jSONObject.toString();
            a4.j = bVar;
            a4.f42885i = new UpdatePhoneResModel();
            a4.x = 0;
            a l = a4.l();
            l.f42860d = true;
            if (com.paytm.network.b.b.a(OauthModule.b().getApplicationContext())) {
                l.a();
            } else {
                bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            }
        }
    }

    public static void d(com.paytm.network.listener.b bVar, String str) {
        Context applicationContext = OauthModule.b().getApplicationContext();
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("oauthdevicebindingstatusSv1");
        if (URLUtil.isValidUrl(a2)) {
            String str2 = com.paytm.utility.b.e(applicationContext, a2) + "&sessionId=" + str;
            s sVar = s.f56801a;
            HashMap<String, String> a3 = s.a();
            o oVar = o.f56791a;
            o.a(str2, l.a(a.C0715a.GET), a3, "");
            com.paytm.network.b a4 = a(aq.class.getName());
            a4.n = a.b.SILENT;
            a4.f42879c = a.C0715a.GET;
            a4.f42880d = str2;
            a4.f42882f = a3;
            a4.j = bVar;
            a4.f42885i = new DeviceBindingStausResModel();
            a4.x = 0;
            a l = a4.l();
            l.f42860d = true;
            if (!com.paytm.network.b.b.a(applicationContext)) {
                bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            } else {
                l.a();
            }
        }
    }

    public static void c(com.paytm.network.listener.b bVar, String str, String str2, String str3, String str4) {
        Context applicationContext = OauthModule.b().getApplicationContext();
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("oauthdevicebindinginitSv1");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(applicationContext, a2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("flow", str2);
                jSONObject.put("phoneNumber", str);
                jSONObject.put("method", str3);
                jSONObject.put("deviceId", l.a());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("iccid", str4);
                jSONObject.put("meta", jSONObject2);
            } catch (JSONException e3) {
                q.b(e3.getMessage());
            }
            s sVar = s.f56801a;
            HashMap<String, String> a3 = s.a();
            a3.put("autoReadHash", OauthModule.a().c());
            try {
                o oVar = o.f56791a;
                o.a(a3);
            } catch (NullPointerException e4) {
                q.b(e4.getMessage());
            }
            o oVar2 = o.f56791a;
            o.a(e2, l.a(a.C0715a.POST), a3, jSONObject.toString());
            if (!a3.containsKey("x-public-key") || !a3.containsKey("x-client-signature")) {
                NetworkCustomError networkCustomError = new NetworkCustomError();
                networkCustomError.setStatusCode(n.f56790i.intValue());
                bVar.handleErrorCode(n.f56790i.intValue(), (IJRPaytmDataModel) null, networkCustomError);
                return;
            }
            com.paytm.network.b a4 = a(aq.class.getName());
            a4.n = a.b.SILENT;
            a4.f42879c = a.C0715a.POST;
            a4.f42880d = e2;
            a4.f42882f = a3;
            a4.f42884h = jSONObject.toString();
            a4.j = bVar;
            a4.f42885i = new DeviceBindingInitResModel();
            a4.x = 0;
            a l = a4.l();
            l.f42860d = true;
            if (!com.paytm.network.b.b.a(applicationContext)) {
                bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            } else {
                l.a();
            }
        }
    }

    public static void i(com.paytm.network.listener.b bVar, String str, String str2) {
        Context applicationContext = OauthModule.b().getApplicationContext();
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("oauthdevicebindingclaimSv1");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(applicationContext, a2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("claimFlow", str);
                jSONObject.put(H5Param.SESSION_ID, str2);
            } catch (JSONException e3) {
                q.b(e3.getMessage());
            }
            s sVar = s.f56801a;
            HashMap<String, String> a3 = s.a();
            a3.put("autoReadHash", OauthModule.a().c());
            o oVar = o.f56791a;
            o.a(e2, l.a(a.C0715a.POST), a3, jSONObject.toString());
            com.paytm.network.b a4 = a(aq.class.getName());
            a4.n = a.b.SILENT;
            a4.f42879c = a.C0715a.POST;
            a4.f42880d = e2;
            a4.f42882f = a3;
            a4.f42884h = jSONObject.toString();
            a4.j = bVar;
            a4.f42885i = new DeviceBindingInitResModel();
            a4.x = 0;
            a l = a4.l();
            l.f42860d = true;
            if (!com.paytm.network.b.b.a(applicationContext)) {
                bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            } else {
                l.a();
            }
        }
    }

    public static void j(com.paytm.network.listener.b bVar, String str, String str2) {
        Context applicationContext = OauthModule.b().getApplicationContext();
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("oauthauthorizeinitSv1");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(applicationContext, a2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("authenticationId", str);
                jSONObject.put("stateToken", str2);
                jSONObject.put("deviceId", l.a());
            } catch (JSONException e3) {
                q.b(e3.getMessage());
            }
            s sVar = s.f56801a;
            HashMap<String, String> a3 = s.a();
            o oVar = o.f56791a;
            o.a(e2, l.a(a.C0715a.POST), a3, jSONObject.toString());
            com.paytm.network.b a4 = a(aq.class.getName());
            a4.n = a.b.SILENT;
            a4.f42879c = a.C0715a.POST;
            a4.f42880d = e2;
            a4.f42882f = a3;
            a4.f42884h = jSONObject.toString();
            a4.j = bVar;
            a4.f42885i = new AuthorizationInitResModel();
            a4.x = 0;
            a l = a4.l();
            l.f42860d = true;
            if (!com.paytm.network.b.b.a(applicationContext)) {
                bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            } else {
                l.a();
            }
        }
    }

    public static void k(com.paytm.network.listener.b bVar, String str, String str2) {
        Context applicationContext = OauthModule.b().getApplicationContext();
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("oauthV2authorizeSv1");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(applicationContext, a2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("authenticationValueType", str);
                jSONObject.put("stateToken", str2);
                jSONObject.put("deviceId", l.a());
            } catch (JSONException e3) {
                q.b(e3.getMessage());
            }
            s sVar = s.f56801a;
            HashMap<String, String> a3 = s.a();
            o oVar = o.f56791a;
            o.a(e2, l.a(a.C0715a.POST), a3, jSONObject.toString());
            com.paytm.network.b a4 = a(aq.class.getName());
            a4.n = a.b.SILENT;
            a4.f42879c = a.C0715a.POST;
            a4.f42880d = e2;
            a4.f42882f = a3;
            a4.f42884h = jSONObject.toString();
            a4.j = bVar;
            a4.f42885i = new AuthorizationResModel();
            a4.x = 0;
            a l = a4.l();
            l.f42860d = true;
            if (!com.paytm.network.b.b.a(applicationContext)) {
                bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            } else {
                l.a();
            }
        }
    }

    public static void d(com.paytm.network.listener.b bVar, String str, String str2, String str3, String str4) {
        Context applicationContext = OauthModule.b().getApplicationContext();
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("oauthAccountStatus");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(applicationContext, a2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("verificationType", str3);
                jSONObject.put(CJRQRScanResultModel.KEY_COMMENT_SMALL, str);
                jSONObject.put("status", str4);
                jSONObject.put("channelName", "DIY");
                jSONObject.put("verificationData", str2);
                jSONObject.put("userConsent", "1");
            } catch (JSONException e3) {
                q.b(e3.getMessage());
            }
            s sVar = s.f56801a;
            HashMap<String, String> a3 = s.a();
            com.paytm.network.b a4 = a(AccountBlockReasonFragment.class.getName());
            a4.n = a.b.SILENT;
            a4.f42879c = a.C0715a.POST;
            a4.f42880d = e2;
            a4.f42882f = a3;
            a4.f42884h = jSONObject.toString();
            a4.j = bVar;
            a4.f42885i = new AccountBlockStatusResModel();
            a4.x = 0;
            a l = a4.l();
            l.f42860d = true;
            if (!com.paytm.network.b.b.a(applicationContext)) {
                bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            } else {
                l.a();
            }
        }
    }

    public static void l(com.paytm.network.listener.b bVar, String str, String str2) {
        Context applicationContext = OauthModule.b().getApplicationContext();
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("oauthDoView");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(applicationContext, a2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("verifyId", str);
                jSONObject.put("method", str2);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            s sVar = s.f56801a;
            HashMap<String, String> a3 = s.a();
            if (str2.equals("OTP_SMS")) {
                a3.put("autoReadHash", OauthModule.a().c());
            }
            com.paytm.network.b a4 = a(AccountBlockEnterNumberFragment.class.getName());
            a4.n = a.b.SILENT;
            a4.f42879c = a.C0715a.POST;
            a4.f42880d = e2;
            a4.f42882f = a3;
            a4.f42884h = jSONObject.toString();
            a4.j = bVar;
            a4.f42885i = new DoViewResModel();
            a4.x = 0;
            a l = a4.l();
            l.f42860d = true;
            if (!com.paytm.network.b.b.a(applicationContext)) {
                bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            } else {
                l.a();
            }
        }
    }

    public static void f(com.paytm.network.listener.b bVar, String str, String str2, String str3) {
        Context applicationContext = OauthModule.b().getApplicationContext();
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("oauthDoVerify");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(applicationContext, a2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("verifyId", str);
                jSONObject.put("method", str3);
                jSONObject.put("validateData", str2);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            s sVar = s.f56801a;
            HashMap<String, String> a3 = s.a();
            com.paytm.network.b a4 = a(AccountBlockReasonFragment.class.getName());
            a4.n = a.b.SILENT;
            a4.f42879c = a.C0715a.POST;
            a4.f42880d = e2;
            a4.f42882f = a3;
            a4.f42884h = jSONObject.toString();
            a4.j = bVar;
            a4.f42885i = new DoVerify();
            a4.x = 0;
            a l = a4.l();
            l.f42860d = true;
            if (!com.paytm.network.b.b.a(applicationContext)) {
                bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            } else {
                l.a();
            }
        }
    }

    public static void m(com.paytm.network.listener.b bVar, String str, String str2) {
        Context applicationContext = OauthModule.b().getApplicationContext();
        net.one97.paytm.oauth.a.a();
        String a2 = net.one97.paytm.oauth.a.a("oauthUserVerificationInit");
        if (URLUtil.isValidUrl(a2)) {
            String e2 = com.paytm.utility.b.e(applicationContext, a2);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("bizFlow", str2);
                jSONObject.put("anchor", str);
                jSONObject.put("anchorType", CJRQRScanResultModel.KEY_MOBILE_NO);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
            s sVar = s.f56801a;
            HashMap<String, String> a3 = s.a();
            com.paytm.network.b a4 = a(AccountBlockEnterNumberFragment.class.getName());
            a4.n = a.b.SILENT;
            a4.f42879c = a.C0715a.POST;
            a4.f42880d = e2;
            a4.f42882f = a3;
            a4.f42884h = jSONObject.toString();
            a4.j = bVar;
            a4.f42885i = new VerificationInitResModel();
            a4.x = 0;
            a l = a4.l();
            l.f42860d = true;
            if (!com.paytm.network.b.b.a(applicationContext)) {
                bVar.handleErrorCode(-1, (IJRPaytmDataModel) null, new NetworkCustomError());
            } else {
                l.a();
            }
        }
    }

    public static a e(com.paytm.network.listener.b bVar, String str) {
        Context applicationContext = OauthModule.b().getApplicationContext();
        String a2 = a(applicationContext);
        HashMap hashMap = new HashMap();
        String n = com.paytm.utility.b.n(applicationContext);
        String sSOToken = OauthModule.b().getSSOToken();
        if (!TextUtils.isEmpty(n) && com.paytm.utility.b.r(applicationContext)) {
            hashMap.put("user_id", n);
        }
        if (!TextUtils.isEmpty(sSOToken)) {
            hashMap.put(com.paytm.business.merchantprofile.common.utility.AppConstants.SSO_TOKEN, sSOToken);
        }
        net.one97.paytm.oauth.a.a();
        String e2 = com.paytm.utility.b.e(applicationContext, net.one97.paytm.oauth.a.a("signUpStoreFrontUrl"));
        com.paytm.network.b a3 = a(str);
        a3.n = a.b.SILENT;
        a3.f42879c = a.C0715a.POST;
        a3.f42880d = e2;
        a3.f42882f = hashMap;
        a3.f42885i = new CJRHomePageV2();
        a3.f42884h = a2;
        a3.j = bVar;
        a3.u = true;
        return a3.l();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00aa A[Catch:{ Exception -> 0x015e }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b8 A[Catch:{ Exception -> 0x015e }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00bf A[Catch:{ Exception -> 0x015e }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c6 A[Catch:{ Exception -> 0x015e }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ce A[Catch:{ Exception -> 0x015e }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00da A[Catch:{ Exception -> 0x015e }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e1 A[Catch:{ Exception -> 0x015e }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e8 A[Catch:{ Exception -> 0x015e }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ef A[Catch:{ Exception -> 0x015e }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f6 A[Catch:{ Exception -> 0x015e }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ff A[Catch:{ Exception -> 0x015e }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0108 A[Catch:{ Exception -> 0x015e }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x010f A[Catch:{ Exception -> 0x015e }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x012e A[Catch:{ Exception -> 0x015e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(android.content.Context r24) {
        /*
            java.lang.String r1 = ""
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            org.json.JSONObject r6 = new org.json.JSONObject
            r6.<init>()
            org.json.JSONObject r7 = new org.json.JSONObject
            r7.<init>()
            java.lang.String r8 = com.paytm.utility.b.s((android.content.Context) r24)
            java.lang.String r9 = com.paytm.utility.b.t((android.content.Context) r24)
            java.lang.String r10 = android.os.Build.MANUFACTURER
            java.lang.String r11 = android.os.Build.MODEL
            java.lang.String r12 = android.os.Build.VERSION.RELEASE
            java.lang.String r13 = com.paytm.utility.b.b((android.content.Context) r24)
            java.lang.String r14 = android.os.Build.DEVICE
            java.lang.String r0 = "http.agent"
            java.lang.String r15 = java.lang.System.getProperty(r0)
            r16 = r6
            java.lang.String r6 = com.paytm.utility.b.u((android.content.Context) r24)
            r17 = r7
            java.lang.String r7 = com.paytm.utility.b.V((android.content.Context) r24)
            android.content.ContentResolver r0 = r24.getContentResolver()
            r18 = r3
            java.lang.String r3 = "android_id"
            java.lang.String r3 = android.provider.Settings.Secure.getString(r0, r3)
            r19 = r3
            java.lang.String r3 = com.paytm.utility.b.o()
            android.content.pm.PackageManager r0 = r24.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0070 }
            r20 = r6
            java.lang.String r6 = r24.getPackageName()     // Catch:{ NameNotFoundException -> 0x006e }
            r21 = r13
            r13 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r6, r13)     // Catch:{ NameNotFoundException -> 0x006c }
            java.lang.String r0 = r0.versionName     // Catch:{ NameNotFoundException -> 0x006c }
            goto L_0x0081
        L_0x006c:
            r0 = move-exception
            goto L_0x0075
        L_0x006e:
            r0 = move-exception
            goto L_0x0073
        L_0x0070:
            r0 = move-exception
            r20 = r6
        L_0x0073:
            r21 = r13
        L_0x0075:
            boolean r6 = com.paytm.utility.b.v
            if (r6 == 0) goto L_0x0080
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x0080:
            r0 = r1
        L_0x0081:
            r22 = 0
            boolean r6 = com.paytm.utility.b.r((android.content.Context) r24)
            if (r6 == 0) goto L_0x009d
            java.lang.String r6 = com.paytm.utility.b.n((android.content.Context) r24)
            boolean r13 = android.text.TextUtils.isEmpty(r6)
            if (r13 != 0) goto L_0x009d
            boolean r13 = android.text.TextUtils.isDigitsOnly(r6)
            if (r13 == 0) goto L_0x009d
            long r22 = java.lang.Long.parseLong(r6)     // Catch:{ NumberFormatException -> 0x009d }
        L_0x009d:
            r6 = r14
            r13 = r22
            r22 = r0
            java.lang.String r0 = "user_id"
            r2.put(r0, r13)     // Catch:{ Exception -> 0x015e }
            if (r7 == 0) goto L_0x00af
            java.lang.String r0 = "ga_id"
            r2.put(r0, r7)     // Catch:{ Exception -> 0x015e }
        L_0x00af:
            java.lang.String r0 = "experiment_id"
            java.lang.String r13 = com.paytm.utility.e.s     // Catch:{ Exception -> 0x015e }
            r2.put(r0, r13)     // Catch:{ Exception -> 0x015e }
            if (r8 == 0) goto L_0x00bd
            java.lang.String r0 = "lat"
            r4.put(r0, r8)     // Catch:{ Exception -> 0x015e }
        L_0x00bd:
            if (r9 == 0) goto L_0x00c4
            java.lang.String r0 = "long"
            r4.put(r0, r9)     // Catch:{ Exception -> 0x015e }
        L_0x00c4:
            if (r15 == 0) goto L_0x00cc
            java.lang.String r0 = "ua"
            r5.put(r0, r15)     // Catch:{ Exception -> 0x015e }
        L_0x00cc:
            if (r3 == 0) goto L_0x00d3
            java.lang.String r0 = "ip"
            r5.put(r0, r3)     // Catch:{ Exception -> 0x015e }
        L_0x00d3:
            java.lang.String r0 = "ip_v6"
            r5.put(r0, r1)     // Catch:{ Exception -> 0x015e }
            if (r10 == 0) goto L_0x00df
            java.lang.String r0 = "make"
            r5.put(r0, r10)     // Catch:{ Exception -> 0x015e }
        L_0x00df:
            if (r11 == 0) goto L_0x00e6
            java.lang.String r0 = "model_1"
            r5.put(r0, r11)     // Catch:{ Exception -> 0x015e }
        L_0x00e6:
            if (r12 == 0) goto L_0x00ed
            java.lang.String r0 = "osv"
            r5.put(r0, r12)     // Catch:{ Exception -> 0x015e }
        L_0x00ed:
            if (r6 == 0) goto L_0x00f4
            java.lang.String r0 = "hwv"
            r5.put(r0, r6)     // Catch:{ Exception -> 0x015e }
        L_0x00f4:
            if (r21 == 0) goto L_0x00fd
            java.lang.String r0 = "connection_type"
            r3 = r21
            r5.put(r0, r3)     // Catch:{ Exception -> 0x015e }
        L_0x00fd:
            if (r20 == 0) goto L_0x0106
            java.lang.String r0 = "carrier"
            r3 = r20
            r5.put(r0, r3)     // Catch:{ Exception -> 0x015e }
        L_0x0106:
            if (r7 == 0) goto L_0x010d
            java.lang.String r0 = "aaid"
            r5.put(r0, r7)     // Catch:{ Exception -> 0x015e }
        L_0x010d:
            if (r19 == 0) goto L_0x0116
            java.lang.String r0 = "browser_uuid"
            r3 = r19
            r5.put(r0, r3)     // Catch:{ Exception -> 0x015e }
        L_0x0116:
            java.lang.String r0 = "device_type"
            java.lang.String r3 = "PHONE"
            r5.put(r0, r3)     // Catch:{ Exception -> 0x015e }
            java.lang.String r0 = "os"
            java.lang.String r3 = "Android"
            r5.put(r0, r3)     // Catch:{ Exception -> 0x015e }
            java.lang.String r0 = "user"
            r3 = r18
            r3.put(r0, r2)     // Catch:{ Exception -> 0x015e }
            if (r22 == 0) goto L_0x0136
            java.lang.String r0 = "version"
            r2 = r22
            r3.put(r0, r2)     // Catch:{ Exception -> 0x015e }
        L_0x0136:
            java.lang.String r0 = "geo"
            r3.put(r0, r4)     // Catch:{ Exception -> 0x015e }
            java.lang.String r0 = "device"
            r3.put(r0, r5)     // Catch:{ Exception -> 0x015e }
            java.lang.String r0 = "channel"
            java.lang.String r2 = "APP"
            r3.put(r0, r2)     // Catch:{ Exception -> 0x015e }
            java.lang.String r0 = "referer_ui_element"
            r2 = r17
            r2.put(r0, r1)     // Catch:{ Exception -> 0x015e }
            java.lang.String r0 = "context"
            r1 = r16
            r1.put(r0, r3)     // Catch:{ Exception -> 0x015c }
            java.lang.String r0 = "tracking"
            r1.put(r0, r2)     // Catch:{ Exception -> 0x015c }
            goto L_0x0168
        L_0x015c:
            r0 = move-exception
            goto L_0x0161
        L_0x015e:
            r0 = move-exception
            r1 = r16
        L_0x0161:
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.b(r0)
        L_0x0168:
            java.lang.String r0 = r1.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.oauth.b.b.a(android.content.Context):java.lang.String");
    }
}
