package net.one97.paytm.paymentsBank.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.h.c;
import net.one97.paytm.bankCommon.model.CJRBankDetails;
import net.one97.paytm.bankCommon.model.CJRIMPSInitiateDataModel;
import net.one97.paytm.bankCommon.model.CustProductList;
import net.one97.paytm.bankCommon.model.CustProductStatus;
import net.one97.paytm.bankCommon.model.IDCResponse;
import net.one97.paytm.bankCommon.model.IsaDetailsModel;
import net.one97.paytm.bankCommon.model.PBBlockUnblockCardResponse;
import net.one97.paytm.bankCommon.model.PBCJRAccountSummary;
import net.one97.paytm.bankCommon.model.PDCAtmPinSetResponse;
import net.one97.paytm.bankCommon.model.PermBlockDCResponse;
import net.one97.paytm.bankCommon.utils.d;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.common.entity.upgradeKyc.NearbyRequestCreator;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.paymentsBank.model.bankstatus.BankStatusModel;
import net.one97.paytm.paymentsBank.model.nach.NachMandateResponse;
import net.one97.paytm.paymentsBank.model.nach.NachTransactionDetailResponse;
import net.one97.paytm.paymentsBank.slfd.model.FDStatusResponse;
import net.one97.paytm.paymentsBank.updateInfo.model.EmailOtpResponse;
import net.one97.paytm.paymentsBank.updateInfo.model.ValidateEmailOtpResponse;
import net.one97.paytm.paymentsBank.utils.j;
import net.one97.paytm.paymentsBank.utils.o;
import net.one97.paytm.upi.util.UpiConstantServiceApi;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiRequestBuilder;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static f a(Context context, g.b<IJRPaytmDataModel> bVar, g.a aVar, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        HashMap hashMap2 = new HashMap();
        hashMap2.put("User-Token", com.paytm.utility.a.q(context));
        hashMap2.put("Content-Type", "application/json");
        hashMap2.put("channel", UpiConstants.B2C_ANDROID);
        net.one97.paytm.bankCommon.mapping.g.a();
        return new net.one97.paytm.bankCommon.g.a(j.a(b.e(context, d.a(UpiConstantServiceApi.GTM_KEY_PPB_GET_FIN_PRODUCT)), j.a().equals("ICA")), (g.b) bVar, aVar, (IJRPaytmDataModel) new CustProductList(), (Map<String, String>) null, (Map<String, String>) hashMap2, cVar, bVar2, hashMap);
    }

    public static f b(Context context, g.b<IJRPaytmDataModel> bVar, g.a aVar, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        HashMap hashMap2 = new HashMap();
        hashMap2.put("User-Token", com.paytm.utility.a.q(context));
        hashMap2.put("Client-Id", "ANDROID");
        String stringFromGTM = o.a().getStringFromGTM("fetchBankStatus");
        if (!URLUtil.isValidUrl(stringFromGTM)) {
            stringFromGTM = o.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://veneer-ite.paytmbank.com/middleware-veneer/ext/v1/login/prerequisite" : "https://veneer.paytmbank.com/middleware-veneer/ext/v1/login/prerequisite";
        }
        String e2 = b.e(context, stringFromGTM);
        String a2 = j.a();
        if (!TextUtils.isEmpty(e2)) {
            if (e2.contains("?")) {
                e2 = e2 + "&accountType=" + a2;
            } else {
                e2 = e2 + "?accountType=" + a2;
            }
        }
        return new net.one97.paytm.bankCommon.g.a(e2, (g.b) bVar, aVar, (IJRPaytmDataModel) new BankStatusModel(), (Map<String, String>) null, (Map<String, String>) hashMap2, cVar, bVar2, hashMap);
    }

    public static f a(Context context, String str, g.b<IJRPaytmDataModel> bVar, g.a aVar, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        HashMap hashMap2 = new HashMap();
        hashMap2.put("user-token", com.paytm.utility.a.q(context));
        hashMap2.put("client-id", UpiConstants.B2C_ANDROID);
        hashMap2.put("Content-Type", "application/json");
        String stringFromGTM = o.a().getStringFromGTM("fetchUserFDStatus");
        if (!URLUtil.isValidUrl(stringFromGTM)) {
            stringFromGTM = o.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://veneer-ite.paytmbank.com/middleware-veneer/ext/v1/fixed-deposit/status" : "https://veneer.paytmbank.com/middleware-veneer/ext/v1/fixed-deposit/status";
        }
        HashMap hashMap3 = new HashMap();
        String str2 = str;
        hashMap3.put("accountType", str);
        return new net.one97.paytm.bankCommon.g.a(stringFromGTM, (g.b) bVar, aVar, (IJRPaytmDataModel) new FDStatusResponse(), (Map<String, String>) hashMap3, (Map<String, String>) hashMap2, cVar, bVar2, hashMap);
    }

    public static f a(Context context, g.b<IJRPaytmDataModel> bVar, g.a aVar, a.c cVar, a.b bVar2, HashMap<String, String> hashMap, String str) {
        HashMap hashMap2 = new HashMap();
        hashMap2.put("User-Token", com.paytm.utility.a.q(context));
        hashMap2.put("Content-Type", "application/json");
        hashMap2.put("channel", UpiConstants.B2C_ANDROID);
        net.one97.paytm.bankCommon.mapping.g.a();
        Context context2 = context;
        String e2 = b.e(context, d.a(UpiConstantServiceApi.GTM_KEY_PPB_GET_FIN_PRODUCT));
        if (str.equals("ICA")) {
            e2 = j.a(e2, true);
        }
        return new net.one97.paytm.bankCommon.g.a(e2, (g.b) bVar, aVar, (IJRPaytmDataModel) new CustProductList(), (Map<String, String>) null, (Map<String, String>) hashMap2, cVar, bVar2, hashMap);
    }

    public static f b(Context context, String str, g.b<IJRPaytmDataModel> bVar, g.a aVar, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        try {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("User-Token", com.paytm.utility.a.q(context));
            hashMap2.put("Content-Type", "application/json");
            hashMap2.put("channel", UpiConstants.B2C_ANDROID);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("channel", UpiConstants.B2C_ANDROID);
            String str2 = str;
            jSONObject.put("productRequested", str);
            String jSONObject2 = jSONObject.toString();
            String stringFromGTM = o.a().getStringFromGTM("ppb_custprod_prereqv2");
            if (!URLUtil.isValidUrl(stringFromGTM)) {
                stringFromGTM = o.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://product-ite.paytmbank.com/product/ext/v2/product-prerequisites" : "https://product.paytmbank.com/product/ext/v2/product-prerequisites";
            }
            String str3 = stringFromGTM;
            Context context2 = context;
            return new net.one97.paytm.bankCommon.g.b(b.e(context, str3), (g.b) bVar, aVar, (IJRPaytmDataModel) new CustProductStatus(), (Map<String, String>) null, (Map<String, String>) hashMap2, jSONObject2, cVar, bVar2, hashMap, a.C0715a.POST);
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return null;
        }
    }

    public static f a(Context context, String str, String str2, g.b<IJRPaytmDataModel> bVar, g.a aVar, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        HashMap hashMap2 = new HashMap();
        String str3 = str;
        hashMap2.put("User-Token", str);
        hashMap2.put("Content-Type", "application/json");
        hashMap2.put("channel", UpiConstants.B2C_ANDROID);
        HashMap hashMap3 = new HashMap();
        String str4 = str2;
        hashMap3.put(CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER, str2);
        net.one97.paytm.bankCommon.mapping.g.a();
        Context context2 = context;
        return new net.one97.paytm.bankCommon.g.a(j.a(b.e(context, d.a("ppb_isa_detail")), new boolean[0]), (g.b) bVar, aVar, (IJRPaytmDataModel) new IsaDetailsModel(), (Map<String, String>) hashMap3, (Map<String, String>) hashMap2, cVar, bVar2, hashMap);
    }

    public static f b(Context context, String str, String str2, g.b<IJRPaytmDataModel> bVar, g.a aVar, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        HashMap hashMap2 = new HashMap();
        String str3 = str;
        hashMap2.put("User-Token", str);
        hashMap2.put("Content-Type", "application/json");
        hashMap2.put("channel", UpiConstants.B2C_ANDROID);
        net.one97.paytm.bankCommon.mapping.g.a();
        String str4 = str2;
        Context context2 = context;
        return new net.one97.paytm.bankCommon.g.b(j.a(b.e(context, d.a("ppb_block_card").replace("{cardNumberAlias}", str2)), new boolean[0]), (g.b) bVar, aVar, (IJRPaytmDataModel) new PBBlockUnblockCardResponse(), (Map<String, String>) null, (Map<String, String>) hashMap2, (String) null, cVar, bVar2, hashMap, a.C0715a.PUT);
    }

    public static f c(Context context, String str, String str2, g.b<IJRPaytmDataModel> bVar, g.a aVar, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        HashMap hashMap2 = new HashMap();
        String str3 = str;
        hashMap2.put("User-Token", str);
        hashMap2.put("Content-Type", "application/json");
        hashMap2.put("channel", UpiConstants.B2C_ANDROID);
        net.one97.paytm.bankCommon.mapping.g.a();
        String str4 = str2;
        Context context2 = context;
        return new net.one97.paytm.bankCommon.g.b(j.a(b.e(context, d.a("ppb_unblock_card").replace("{cardNumberAlias}", str2)), new boolean[0]), (g.b) bVar, aVar, (IJRPaytmDataModel) new PBBlockUnblockCardResponse(), (Map<String, String>) null, (Map<String, String>) hashMap2, (String) null, cVar, bVar2, hashMap, a.C0715a.PUT);
    }

    public static f c(Context context, String str, g.b<IJRPaytmDataModel> bVar, g.a aVar, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        return a(context, str, bVar, aVar, cVar, bVar2, hashMap, j.a(), c.d(o.a().getApplicationContext()));
    }

    public static f a(Context context, String str, g.b<IJRPaytmDataModel> bVar, g.a aVar, a.c cVar, a.b bVar2, HashMap<String, String> hashMap, String str2, String str3) {
        HashMap hashMap2 = new HashMap();
        hashMap2.put("Authorization".toLowerCase(), com.paytm.utility.a.q(context));
        hashMap2.put("Content-Type", "application/json");
        hashMap2.put("channel", UpiConstants.B2C_ANDROID);
        net.one97.paytm.bankCommon.mapping.g.a();
        Context context2 = context;
        String e2 = b.e(context, d.a(UpiConstantServiceApi.KEY_FETCH_PAYMENT_BANK_BALANCE_NEW));
        if (!TextUtils.isEmpty(str2) && str2.equals("ICA")) {
            String replace = e2.replace("account_type=isa", "account_type=ica");
            StringBuilder sb = new StringBuilder();
            sb.append(replace);
            sb.append("&account_ref_id=");
            sb.append(str3);
            sb.append("&account_number=");
            String str4 = str;
            sb.append(str);
            e2 = sb.toString();
        }
        return new net.one97.paytm.bankCommon.g.a(e2, bVar, aVar, new PBCJRAccountSummary(), hashMap2, cVar, bVar2, hashMap);
    }

    public static f a(Object obj, String str, String str2, a.c cVar, a.b bVar, HashMap<String, String> hashMap) {
        Context context = (Context) obj;
        g.b bVar2 = (g.b) obj;
        g.a aVar = (g.a) obj;
        HashMap hashMap2 = new HashMap();
        hashMap2.put("User-Token", com.paytm.utility.a.q(context));
        hashMap2.put("Content-Type", "application/json");
        hashMap2.put("channel", UpiConstants.B2C_ANDROID);
        JSONObject jSONObject = new JSONObject();
        try {
            d.b();
            String str3 = str;
            jSONObject.put("existingPin", com.paytm.e.a.b.a(d.a("pb_atm_rsa_key"), str));
            jSONObject.put("cardAliasNumber", str2);
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        net.one97.paytm.bankCommon.mapping.g.a();
        return new net.one97.paytm.bankCommon.g.b(b.e(context, d.a("ppb_check_pdc_pin")), bVar2, aVar, (IJRPaytmDataModel) new PDCAtmPinSetResponse(), (Map<String, String>) null, (Map<String, String>) hashMap2, jSONObject.toString(), cVar, bVar, hashMap, a.C0715a.POST);
    }

    public static f a(Object obj, String str, String str2, String str3, a.c cVar, a.b bVar, HashMap<String, String> hashMap) {
        Context context = (Context) obj;
        g.b bVar2 = (g.b) obj;
        g.a aVar = (g.a) obj;
        HashMap hashMap2 = new HashMap();
        String str4 = str;
        hashMap2.put("User-Token", str);
        hashMap2.put("Content-Type", "application/json");
        hashMap2.put("channel", UpiConstants.B2C_ANDROID);
        JSONObject jSONObject = new JSONObject();
        try {
            d.b();
            jSONObject.put("newPin", com.paytm.e.a.b.a(d.a("pb_atm_rsa_key"), str2));
            jSONObject.put("cardNumberAlias", str3);
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        net.one97.paytm.bankCommon.mapping.g.a();
        return new net.one97.paytm.bankCommon.g.b(b.e(context, d.a("ppb_reset_pdc_pin")), (g.b<IJRPaytmDataModel>) bVar2, aVar, (IJRPaytmDataModel) new PDCAtmPinSetResponse(), (Map<String, String>) null, (Map<String, String>) hashMap2, jSONObject.toString(), a.C0715a.POST, cVar, bVar, hashMap);
    }

    public static f b(Object obj, String str, String str2, String str3, a.c cVar, a.b bVar, HashMap<String, String> hashMap) {
        Context context = (Context) obj;
        g.b bVar2 = (g.b) obj;
        g.a aVar = (g.a) obj;
        HashMap hashMap2 = new HashMap();
        hashMap2.put("User-Token", com.paytm.utility.a.q(context));
        hashMap2.put("Content-Type", "application/json");
        hashMap2.put("channel", UpiConstants.B2C_ANDROID);
        JSONObject jSONObject = new JSONObject();
        try {
            d.b();
            String str4 = str;
            jSONObject.put("existingPin", com.paytm.e.a.b.a(d.a("pb_atm_rsa_key"), str));
            d.b();
            jSONObject.put("newPin", com.paytm.e.a.b.a(d.a("pb_atm_rsa_key"), str2));
            jSONObject.put("cardNumberAlias", str3);
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        net.one97.paytm.bankCommon.mapping.g.a();
        return new net.one97.paytm.bankCommon.g.b(b.e(context, d.a("ppb_reset_pdc_pin")), (g.b<IJRPaytmDataModel>) bVar2, aVar, (IJRPaytmDataModel) new PDCAtmPinSetResponse(), (Map<String, String>) null, (Map<String, String>) hashMap2, jSONObject.toString(), a.C0715a.POST, cVar, bVar, hashMap);
    }

    public static f c(Object obj, String str, String str2, String str3, a.c cVar, a.b bVar, HashMap<String, String> hashMap) {
        Context context = (Context) obj;
        g.b bVar2 = (g.b) obj;
        g.a aVar = (g.a) obj;
        HashMap hashMap2 = new HashMap();
        String str4 = str;
        hashMap2.put("User-Token", str);
        hashMap2.put("Content-Type", "application/json");
        hashMap2.put("channel", UpiConstants.B2C_ANDROID);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("qrcodeId", str2);
            d.b();
            jSONObject.put("pin", com.paytm.e.a.b.a(d.a("pb_atm_rsa_key"), str3));
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        net.one97.paytm.bankCommon.mapping.g.a();
        return new net.one97.paytm.bankCommon.g.b(b.e(context, d.a("ppb_set_pdc_pin")), (g.b<IJRPaytmDataModel>) bVar2, aVar, (IJRPaytmDataModel) new PDCAtmPinSetResponse(), (Map<String, String>) null, (Map<String, String>) hashMap2, jSONObject.toString(), a.C0715a.POST, cVar, bVar, hashMap);
    }

    public static f d(Context context, String str, g.b<IJRPaytmDataModel> bVar, g.a aVar, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        net.one97.paytm.bankCommon.mapping.g.a();
        String a2 = d.a("ppb_get_customer_cards");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("User-Token", com.paytm.utility.a.q(context));
        String str2 = str;
        hashMap2.put("CardAlias", str);
        return new net.one97.paytm.bankCommon.g.a(a2, (g.b) bVar, aVar, (IJRPaytmDataModel) new IDCResponse(), (Map<String, String>) hashMap2, cVar, bVar2, hashMap, 0);
    }

    public static f c(Context context, g.b<IJRPaytmDataModel> bVar, g.a aVar, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        HashMap hashMap2 = new HashMap();
        hashMap2.put("User-Token", com.paytm.utility.a.q(context));
        hashMap2.put("Content-Type", "application/json");
        net.one97.paytm.bankCommon.mapping.g.a();
        String a2 = d.a("nachGetMandatesURL");
        if (!URLUtil.isValidUrl(a2)) {
            return null;
        }
        return new net.one97.paytm.bankCommon.g.a(com.paytm.utility.c.b(a2, context), bVar, aVar, new NachMandateResponse(), hashMap2, cVar, bVar2, hashMap);
    }

    public static f a(Context context, g.b<IJRPaytmDataModel> bVar, g.a aVar, String str, String str2, String str3, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        HashMap hashMap2 = new HashMap();
        hashMap2.put("User-Token", com.paytm.utility.a.q(context));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cardAlias", str);
            jSONObject.put(CJRQRScanResultModel.KEY_COMMENT_SMALL, str3);
            jSONObject.put("channel", str2);
            jSONObject.put("reasonCode", "HL9");
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
        net.one97.paytm.bankCommon.mapping.g.a();
        String a2 = d.a("cardHotlistUrl");
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        return new net.one97.paytm.bankCommon.g.b(a2, bVar, aVar, (IJRPaytmDataModel) new PermBlockDCResponse(), (Map<String, String>) null, (Map<String, String>) hashMap2, jSONObject.toString(), a.C0715a.POST, cVar, bVar2, hashMap);
    }

    public static f a(Context context, g.b<IJRPaytmDataModel> bVar, g.a aVar, String str, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        HashMap hashMap2 = new HashMap();
        hashMap2.put(UpiRequestBuilder.SESSION_TOKEN, com.paytm.utility.a.q(context));
        g.b<IJRPaytmDataModel> bVar3 = bVar;
        g.a aVar2 = aVar;
        HashMap hashMap3 = hashMap2;
        a.c cVar2 = cVar;
        a.b bVar4 = bVar2;
        HashMap<String, String> hashMap4 = hashMap;
        new net.one97.paytm.bankCommon.b.b().a((String) null, bVar3, aVar2, new NachTransactionDetailResponse(), hashMap3, cVar2, bVar4, hashMap4);
        net.one97.paytm.bankCommon.mapping.g.a();
        String a2 = d.a("nachGetTransactionsURL");
        StringBuilder sb = new StringBuilder();
        sb.append(a2);
        sb.append("?umrn=");
        String str2 = str;
        sb.append(str);
        return new net.one97.paytm.bankCommon.g.a(sb.toString(), bVar3, aVar2, new NachTransactionDetailResponse(), hashMap3, cVar2, bVar4, hashMap4);
    }

    public static void a(Activity activity, String str, g.b<IJRPaytmDataModel> bVar, g.a aVar, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        if (activity != null) {
            activity.getApplicationContext();
            net.one97.paytm.bankCommon.mapping.g.a();
            String a2 = d.a(UpiConstantServiceApi.KEY_GET_BANK);
            if (URLUtil.isValidUrl(a2)) {
                String e2 = b.e((Context) activity, a2);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("ssotoken", com.paytm.utility.a.q(activity));
                hashMap2.put("Content-Type", "application/json");
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("ifscCode", str);
                    jSONObject.put("request", jSONObject2);
                    jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, "127.0.0.1");
                    jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
                    jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, "P2B_TRANSFER");
                    jSONObject.put("channel", UpiConstants.MP_ANDROID);
                    String Q = b.Q((Context) activity);
                    if (Q != null) {
                        jSONObject.put("version", Q);
                    }
                } catch (Exception e3) {
                    if (b.v) {
                        e3.printStackTrace();
                    }
                }
                activity.getApplicationContext();
                new net.one97.paytm.bankCommon.g.c();
                net.one97.paytm.bankCommon.g.c.a(new net.one97.paytm.bankCommon.g.b(e2, bVar, aVar, (IJRPaytmDataModel) new CJRBankDetails(), (Map<String, String>) null, (Map<String, String>) hashMap2, jSONObject.toString(), a.C0715a.POST, cVar, bVar2, hashMap));
            }
        }
    }

    public static f a(Context context, String str, int i2, String str2, g.b<IJRPaytmDataModel> bVar, g.a aVar, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        HashMap hashMap2 = new HashMap();
        String str3 = str;
        hashMap2.put("Authorization", str);
        hashMap2.put("Content-Type", "application/json");
        hashMap2.put("channel", "MOB");
        hashMap2.put("channel_id", UpiConstants.B2C_ANDROID);
        o.a().checkRiskInformationAvaiable(hashMap2);
        JSONObject jSONObject = new JSONObject();
        int i3 = i2;
        try {
            jSONObject.put("resume_id", i2);
            String str4 = str2;
            jSONObject.put("txn_id", str2);
        } catch (JSONException unused) {
        }
        String jSONObject2 = jSONObject.toString();
        net.one97.paytm.bankCommon.mapping.g.a();
        Context context2 = context;
        return new net.one97.paytm.bankCommon.g.b(b.e(context, d.a("ppb_continue_imps")), bVar, aVar, new CJRIMPSInitiateDataModel(), hashMap2, jSONObject2, cVar, bVar2, hashMap);
    }

    public static f a(Context context, g.b<IJRPaytmDataModel> bVar, g.a aVar, a.c cVar, a.b bVar2, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        HashMap hashMap3 = new HashMap();
        hashMap3.put("session_token", com.paytm.utility.a.q(context));
        hashMap3.put("Content-Type", "application/json");
        hashMap3.put("channel", UpiConstants.B2C_ANDROID);
        Map<String, String> e2 = net.one97.paytm.bankCommon.mapping.d.e(context);
        e2.put("session_token", com.paytm.utility.a.q(context));
        net.one97.paytm.bankCommon.mapping.g.b();
        return new net.one97.paytm.bankCommon.g.b(b.e(context, d.a("updateEmailV3")), bVar, aVar, (IJRPaytmDataModel) new EmailOtpResponse(), (Map<String, String>) null, e2, new com.google.gsonhtcfix.f().a((Object) hashMap), a.C0715a.PUT, cVar, bVar2, hashMap2);
    }

    public static f b(Context context, g.b<IJRPaytmDataModel> bVar, g.a aVar, a.c cVar, a.b bVar2, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        HashMap hashMap3 = new HashMap();
        hashMap3.put("session_token", com.paytm.utility.a.q(context));
        hashMap3.put("Content-Type", "application/json");
        hashMap3.put("channel", UpiConstants.B2C_ANDROID);
        Map<String, String> e2 = net.one97.paytm.bankCommon.mapping.d.e(context);
        e2.put("session_token", com.paytm.utility.a.q(context));
        net.one97.paytm.bankCommon.mapping.g.a();
        return new net.one97.paytm.bankCommon.g.b(b.e(context, d.a("profileValidateOTPV3")), bVar, aVar, (IJRPaytmDataModel) new ValidateEmailOtpResponse(), (Map<String, String>) null, e2, new com.google.gsonhtcfix.f().a((Object) hashMap), a.C0715a.POST, cVar, bVar2, hashMap2);
    }
}
