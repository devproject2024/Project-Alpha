package net.one97.paytm.bankOpen.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.alipay.iap.android.webapp.sdk.plugin.H5RpcPlugin;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import net.one97.paytm.bankCommon.g.b;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.BankAccOpen;
import net.one97.paytm.bankCommon.model.CJRP2BStatus;
import net.one97.paytm.bankCommon.model.CustProductList;
import net.one97.paytm.bankCommon.model.CustProductStatus;
import net.one97.paytm.bankCommon.model.NomineeAdd;
import net.one97.paytm.bankCommon.model.NomineeModel;
import net.one97.paytm.bankCommon.model.bankstatus.BankStatusModel;
import net.one97.paytm.bankCommon.model.nominee.NomineeUpdateResponse;
import net.one97.paytm.bankCommon.utils.d;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.common.entity.upgradeKyc.NearbyRequestCreator;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.UpiConstantServiceApi;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static f a(Context context, String str, g.b<IJRPaytmDataModel> bVar, g.a aVar, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        Context context2 = context;
        try {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("User-Token", net.one97.paytm.bankOpen.f.a().getUserToken(context));
            hashMap2.put("Content-Type", "application/json");
            hashMap2.put("channel", net.one97.paytm.bankOpen.f.a().getAppChannel());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("channel", net.one97.paytm.bankOpen.f.a().getAppChannel());
            String str2 = str;
            jSONObject.put("productRequested", str);
            String jSONObject2 = jSONObject.toString();
            net.one97.paytm.bankCommon.mapping.g.a();
            return new b(com.paytm.utility.b.e(context, d.a("ppb_custprod_prereq")), (g.b) bVar, aVar, (IJRPaytmDataModel) new CustProductStatus(), (Map<String, String>) null, (Map<String, String>) hashMap2, jSONObject2, cVar, bVar2, hashMap, a.C0715a.POST);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static void a(Activity activity, String str, String str2, String str3, g.b<IJRPaytmDataModel> bVar, g.a aVar, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        if (activity != null) {
            activity.getApplicationContext();
            net.one97.paytm.bankCommon.mapping.g.a();
            String a2 = d.a("p2bStatus");
            if (URLUtil.isValidUrl(a2)) {
                String e2 = com.paytm.utility.b.e((Context) activity, a2);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("ssotoken", net.one97.paytm.bankOpen.f.a().getUserToken(activity));
                hashMap2.put("Content-Type", "application/json");
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put(SDKConstants.TXN_TYPE, "PAYER_TO_BANK_TRANSFER");
                    jSONObject3.put("ssoId", net.one97.paytm.bankOpen.f.a().getUserId(activity));
                    jSONObject.put("request", jSONObject3);
                    jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.ipAddress, "127.0.0.1");
                    jSONObject.put(NearbyRequestCreator.NearbyRequestConstants.platformName, "PayTM");
                    jSONObject.put(H5RpcPlugin.RpcRequest.RpcParam.OPERATION_TYPE, "P2B_TRANSFER");
                    jSONObject.put("channel", UpiConstants.MP_ANDROID);
                    String appVersion = net.one97.paytm.bankOpen.f.a().getAppVersion(activity);
                    if (appVersion != null) {
                        jSONObject.put("version", appVersion);
                    }
                    jSONObject2.put("ifscCode", str2);
                    jSONObject2.put(CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER, str);
                    jSONObject2.put("txnAmount", str3);
                    jSONObject.put("additionalParams", jSONObject2);
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
                activity.getApplicationContext();
                new c();
                c.a(new b(e2, bVar, aVar, (IJRPaytmDataModel) new CJRP2BStatus(), (Map<String, String>) null, (Map<String, String>) hashMap2, jSONObject.toString(), a.C0715a.POST, cVar, bVar2, hashMap));
            }
        }
    }

    public static f a(Context context, boolean z, NomineeModel nomineeModel, boolean z2, g.b<IJRPaytmDataModel> bVar, g.a aVar, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        HashMap hashMap2;
        Context context2 = context;
        HashMap hashMap3 = new HashMap();
        hashMap3.put("Content-Type", "application/json");
        hashMap3.put("User-Token", net.one97.paytm.bankOpen.f.a().getUserToken(context2));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("channel", net.one97.paytm.bankOpen.f.a().getAppChannel());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("isaCustomization", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (z2) {
                jSONObject2.put("consentCode", "aadhaarseedingtnc");
                jSONObject2.put("consentVersion", 1);
            }
            if (z) {
                JSONArray jSONArray2 = new JSONArray();
                jSONObject2.put("nominee", jSONArray2);
                JSONObject jSONObject4 = new JSONObject();
                jSONArray2.put(jSONObject4);
                if (!TextUtils.isEmpty(nomineeModel.getCity())) {
                    jSONObject4.put("city", nomineeModel.getCity());
                }
                try {
                    if (!TextUtils.isEmpty(nomineeModel.getDob())) {
                        jSONObject4.put("dob", nomineeModel.getDob());
                    }
                    if (!TextUtils.isEmpty(nomineeModel.getEmail())) {
                        jSONObject4.put(AppConstants.KEY_EMAIL, nomineeModel.getEmail());
                    }
                    if (!TextUtils.isEmpty(nomineeModel.getState())) {
                        jSONObject4.put("state", nomineeModel.getState());
                    }
                    if (!TextUtils.isEmpty(nomineeModel.getRelationship())) {
                        jSONObject4.put("relationship", nomineeModel.getRelationship().toUpperCase(Locale.ENGLISH));
                    }
                    if (!TextUtils.isEmpty(nomineeModel.getHouseNo())) {
                        jSONObject4.put("houseNo", nomineeModel.getHouseNo());
                    }
                    if (!TextUtils.isEmpty(nomineeModel.getStreetName())) {
                        jSONObject4.put("streetName", nomineeModel.getStreetName());
                    }
                    if (!TextUtils.isEmpty(nomineeModel.getAreaName())) {
                        jSONObject4.put("areaName", nomineeModel.getAreaName());
                    }
                    if (!TextUtils.isEmpty(nomineeModel.getPinCode())) {
                        jSONObject4.put("pinCode", nomineeModel.getPinCode());
                    }
                    hashMap2 = hashMap3;
                    if (!TextUtils.isEmpty(nomineeModel.getName())) {
                        try {
                            jSONObject4.put("name", nomineeModel.getName());
                        } catch (JSONException e2) {
                            e = e2;
                            e.printStackTrace();
                            String jSONObject5 = jSONObject.toString();
                            net.one97.paytm.bankCommon.mapping.g.a();
                            return new b(com.paytm.utility.b.e(context2, d.a(UpiConstantServiceApi.GTM_KEY_PPB_GET_FIN_PRODUCT)), (g.b) bVar, aVar, (IJRPaytmDataModel) new BankAccOpen(), (Map<String, String>) null, (Map<String, String>) hashMap2, jSONObject5, cVar, bVar2, hashMap, a.C0715a.POST);
                        }
                    }
                } catch (JSONException e3) {
                    e = e3;
                    hashMap2 = hashMap3;
                    context2 = context;
                    e.printStackTrace();
                    String jSONObject52 = jSONObject.toString();
                    net.one97.paytm.bankCommon.mapping.g.a();
                    return new b(com.paytm.utility.b.e(context2, d.a(UpiConstantServiceApi.GTM_KEY_PPB_GET_FIN_PRODUCT)), (g.b) bVar, aVar, (IJRPaytmDataModel) new BankAccOpen(), (Map<String, String>) null, (Map<String, String>) hashMap2, jSONObject52, cVar, bVar2, hashMap, a.C0715a.POST);
                }
                try {
                    jSONObject4.put("percentage", 100);
                    if (!(nomineeModel.getGuardians() == null || nomineeModel.getGuardians().get(0) == null)) {
                        NomineeModel nomineeModel2 = nomineeModel.getGuardians().get(0);
                        if (!TextUtils.isEmpty(nomineeModel2.getAreaName())) {
                            jSONObject3.put("areaName", nomineeModel2.getAreaName());
                        }
                        if (!TextUtils.isEmpty(nomineeModel2.getCity())) {
                            jSONObject3.put("city", nomineeModel2.getCity());
                        }
                        if (!TextUtils.isEmpty(nomineeModel2.getDob())) {
                            jSONObject3.put("dob", nomineeModel2.getDob());
                        }
                        if (!TextUtils.isEmpty(nomineeModel2.getEmail())) {
                            jSONObject3.put(AppConstants.KEY_EMAIL, nomineeModel2.getEmail());
                        }
                        if (!TextUtils.isEmpty(nomineeModel2.getHouseNo())) {
                            jSONObject3.put("houseNo", nomineeModel2.getHouseNo());
                        }
                        if (!TextUtils.isEmpty(nomineeModel2.getName())) {
                            jSONObject3.put("name", nomineeModel2.getName());
                        }
                        if (!TextUtils.isEmpty(nomineeModel2.getPinCode())) {
                            jSONObject3.put("pinCode", nomineeModel2.getPinCode());
                        }
                        if (!TextUtils.isEmpty(nomineeModel2.getRelationship())) {
                            jSONObject3.put("relationship", nomineeModel2.getRelationship().toUpperCase(Locale.ENGLISH));
                        }
                        if (!TextUtils.isEmpty(nomineeModel2.getState())) {
                            jSONObject3.put("state", nomineeModel2.getState());
                        }
                        if (!TextUtils.isEmpty(nomineeModel2.getStreetName())) {
                            jSONObject3.put("streetName", nomineeModel2.getStreetName());
                        }
                        jSONArray.put(jSONObject3);
                        jSONObject4.put("guardians", jSONArray);
                    }
                } catch (JSONException e4) {
                    e = e4;
                    context2 = context;
                    e.printStackTrace();
                    String jSONObject522 = jSONObject.toString();
                    net.one97.paytm.bankCommon.mapping.g.a();
                    return new b(com.paytm.utility.b.e(context2, d.a(UpiConstantServiceApi.GTM_KEY_PPB_GET_FIN_PRODUCT)), (g.b) bVar, aVar, (IJRPaytmDataModel) new BankAccOpen(), (Map<String, String>) null, (Map<String, String>) hashMap2, jSONObject522, cVar, bVar2, hashMap, a.C0715a.POST);
                }
            } else {
                hashMap2 = hashMap3;
            }
            JSONArray jSONArray3 = new JSONArray();
            jSONArray3.put("ISA");
            jSONArray3.put("VDC");
            jSONObject.put("products", jSONArray3);
            context2 = context;
            if (!net.one97.paytm.bankOpen.f.a().showPasscodeScreen(context2)) {
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("custId", net.one97.paytm.bankOpen.f.a().getUserId(context2));
                jSONObject6.put("serviceRequest", false);
                jSONObject6.put("passcodeCheckRequired", false);
                jSONObject.put("customerInfo", jSONObject6);
            }
            String s = com.paytm.utility.b.s(context);
            String t = com.paytm.utility.b.t(context);
            jSONObject.put("lat", s);
            jSONObject.put("long", t);
        } catch (JSONException e5) {
            e = e5;
            hashMap2 = hashMap3;
            e.printStackTrace();
            String jSONObject5222 = jSONObject.toString();
            net.one97.paytm.bankCommon.mapping.g.a();
            return new b(com.paytm.utility.b.e(context2, d.a(UpiConstantServiceApi.GTM_KEY_PPB_GET_FIN_PRODUCT)), (g.b) bVar, aVar, (IJRPaytmDataModel) new BankAccOpen(), (Map<String, String>) null, (Map<String, String>) hashMap2, jSONObject5222, cVar, bVar2, hashMap, a.C0715a.POST);
        }
        String jSONObject52222 = jSONObject.toString();
        net.one97.paytm.bankCommon.mapping.g.a();
        return new b(com.paytm.utility.b.e(context2, d.a(UpiConstantServiceApi.GTM_KEY_PPB_GET_FIN_PRODUCT)), (g.b) bVar, aVar, (IJRPaytmDataModel) new BankAccOpen(), (Map<String, String>) null, (Map<String, String>) hashMap2, jSONObject52222, cVar, bVar2, hashMap, a.C0715a.POST);
    }

    public static f a(Context context, g.b<IJRPaytmDataModel> bVar, g.a aVar, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        HashMap hashMap2 = new HashMap();
        hashMap2.put("User-Token", com.paytm.utility.a.q(context));
        hashMap2.put("Client-Id", "ANDROID");
        d.b();
        String a2 = d.a("fetchBankStatus");
        if (!URLUtil.isValidUrl(a2)) {
            a2 = net.one97.paytm.bankOpen.f.a().getBuildConfigBuildType().equalsIgnoreCase(SDKConstants.KEY_STAGING_API) ? "https://veneer-ite.paytmbank.com/middleware-veneer/ext/v1/login/prerequisite" : "https://veneer.paytmbank.com/middleware-veneer/ext/v1/login/prerequisite";
        }
        String e2 = com.paytm.utility.b.e(context, a2);
        String a3 = net.one97.paytm.bankCommon.utils.f.a();
        if (!TextUtils.isEmpty(e2)) {
            if (e2.contains("?")) {
                e2 = e2 + "&accountType=" + a3;
            } else {
                e2 = e2 + "?accountType=" + a3;
            }
        }
        return new net.one97.paytm.bankCommon.g.a(e2, (g.b) bVar, aVar, (IJRPaytmDataModel) new BankStatusModel(), (Map<String, String>) null, (Map<String, String>) hashMap2, cVar, bVar2, hashMap);
    }

    public static f b(Context context, g.b<IJRPaytmDataModel> bVar, g.a aVar, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        HashMap hashMap2 = new HashMap();
        hashMap2.put("User-Token", net.one97.paytm.bankOpen.f.a().getUserToken(context));
        hashMap2.put("Content-Type", "application/json");
        hashMap2.put("channel", net.one97.paytm.bankOpen.f.a().getAppChannel());
        net.one97.paytm.bankCommon.mapping.g.a();
        return new net.one97.paytm.bankCommon.g.a(com.paytm.utility.b.e(context, d.a(UpiConstantServiceApi.GTM_KEY_PPB_GET_FIN_PRODUCT)), (g.b) bVar, aVar, (IJRPaytmDataModel) new CustProductList(), (Map<String, String>) null, (Map<String, String>) hashMap2, cVar, bVar2, hashMap);
    }

    public static f a(Context context, NomineeModel nomineeModel, g.b<IJRPaytmDataModel> bVar, g.a aVar, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        JSONArray jSONArray;
        JSONObject jSONObject;
        String str;
        HashMap hashMap2;
        try {
            net.one97.paytm.bankCommon.mapping.g.a();
            String a2 = d.a("editNomineeBankUrl");
            if (!URLUtil.isValidUrl(a2)) {
                return null;
            }
            HashMap hashMap3 = new HashMap();
            hashMap3.put("User-Token", net.one97.paytm.bankOpen.f.a().getUserToken(context));
            hashMap3.put("Content-Type", "application/json");
            hashMap3.put("Client-Id", net.one97.paytm.bankOpen.f.a().getAppChannel());
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray2 = new JSONArray();
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = new JSONObject();
            JSONArray jSONArray3 = new JSONArray();
            if (nomineeModel != null) {
                if (!TextUtils.isEmpty(nomineeModel.getAreaName())) {
                    jSONObject3.put("areaName", nomineeModel.getAreaName());
                }
                if (!TextUtils.isEmpty(nomineeModel.getCity())) {
                    jSONObject3.put("city", nomineeModel.getCity());
                }
                if (!TextUtils.isEmpty(nomineeModel.getDob())) {
                    jSONObject3.put("dob", nomineeModel.getDob());
                }
                if (!TextUtils.isEmpty(nomineeModel.getEmail())) {
                    jSONObject3.put(AppConstants.KEY_EMAIL, nomineeModel.getEmail());
                }
                if (!TextUtils.isEmpty(nomineeModel.getHouseNo())) {
                    jSONObject3.put("houseNo", nomineeModel.getHouseNo());
                }
                if (!TextUtils.isEmpty(nomineeModel.getLatitude())) {
                    jSONObject3.put("latitude", nomineeModel.getLatitude());
                }
                if (!TextUtils.isEmpty(nomineeModel.getLongitude())) {
                    jSONObject3.put("longitude", nomineeModel.getLongitude());
                }
                if (!TextUtils.isEmpty(nomineeModel.getName())) {
                    jSONObject3.put("name", nomineeModel.getName());
                }
                if (!TextUtils.isEmpty(nomineeModel.getNomineeId())) {
                    jSONObject3.put("nomineeId", nomineeModel.getNomineeId());
                }
                jSONObject3.put("percentage", 100);
                if (!TextUtils.isEmpty(nomineeModel.getPinCode())) {
                    jSONObject3.put("pinCode", nomineeModel.getPinCode());
                }
                hashMap2 = hashMap3;
                if (!TextUtils.isEmpty(nomineeModel.getRelationship())) {
                    str = a2;
                    jSONObject3.put("relationship", nomineeModel.getRelationship().toUpperCase(Locale.ENGLISH));
                } else {
                    str = a2;
                }
                if (!TextUtils.isEmpty(nomineeModel.getState())) {
                    jSONObject3.put("state", nomineeModel.getState());
                }
                jSONArray = jSONArray2;
                if (!TextUtils.isEmpty(nomineeModel.getStreetName())) {
                    jSONObject3.put("streetName", nomineeModel.getStreetName());
                }
                if (nomineeModel.getGuardians() != null) {
                    jSONObject = jSONObject2;
                    if (nomineeModel.getGuardians().get(0) != null) {
                        NomineeModel nomineeModel2 = nomineeModel.getGuardians().get(0);
                        if (!TextUtils.isEmpty(nomineeModel2.getAreaName())) {
                            jSONObject4.put("areaName", nomineeModel2.getAreaName());
                        }
                        if (!TextUtils.isEmpty(nomineeModel2.getCity())) {
                            jSONObject4.put("city", nomineeModel2.getCity());
                        }
                        if (!TextUtils.isEmpty(nomineeModel2.getDob())) {
                            jSONObject4.put("dob", nomineeModel2.getDob());
                        }
                        if (!TextUtils.isEmpty(nomineeModel2.getEmail())) {
                            jSONObject4.put(AppConstants.KEY_EMAIL, nomineeModel2.getEmail());
                        }
                        if (!TextUtils.isEmpty(nomineeModel2.getHouseNo())) {
                            jSONObject4.put("houseNo", nomineeModel2.getHouseNo());
                        }
                        if (!TextUtils.isEmpty(nomineeModel2.getName())) {
                            jSONObject4.put("name", nomineeModel2.getName());
                        }
                        if (!TextUtils.isEmpty(nomineeModel2.getPinCode())) {
                            jSONObject4.put("pinCode", nomineeModel2.getPinCode());
                        }
                        if (!TextUtils.isEmpty(nomineeModel2.getRelationship())) {
                            jSONObject4.put("relationship", nomineeModel2.getRelationship().toUpperCase(Locale.ENGLISH));
                        }
                        if (!TextUtils.isEmpty(nomineeModel2.getState())) {
                            jSONObject4.put("state", nomineeModel2.getState());
                        }
                        if (!TextUtils.isEmpty(nomineeModel2.getStreetName())) {
                            jSONObject4.put("streetName", nomineeModel2.getStreetName());
                        }
                        jSONArray3.put(jSONObject4);
                        jSONObject3.put("guardians", jSONArray3);
                    }
                } else {
                    jSONObject = jSONObject2;
                }
            } else {
                jSONObject = jSONObject2;
                jSONArray = jSONArray2;
                str = a2;
                hashMap2 = hashMap3;
            }
            JSONObject jSONObject5 = jSONObject;
            jSONObject5.put("nomineeId", nomineeModel.getNomineeId());
            jSONObject5.put("nomineePojo", jSONObject3);
            JSONArray jSONArray4 = jSONArray;
            jSONArray4.put("ISA");
            jSONObject5.put("products", jSONArray4);
            return new b(str, bVar, aVar, (IJRPaytmDataModel) new NomineeUpdateResponse(), (Map<String, String>) null, (Map<String, String>) hashMap2, jSONObject5.toString(), a.C0715a.PUT, cVar, bVar2, hashMap);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static f a(Context context, NomineeModel nomineeModel, String str, g.b<IJRPaytmDataModel> bVar, g.a aVar, a.c cVar, a.b bVar2, HashMap<String, String> hashMap) {
        HashMap hashMap2;
        Context context2 = context;
        try {
            HashMap hashMap3 = new HashMap();
            hashMap3.put("User-Token", net.one97.paytm.bankOpen.f.a().getUserToken(context2));
            hashMap3.put("Content-Type", "application/json");
            hashMap3.put("channel", net.one97.paytm.bankOpen.f.a().getAppChannel());
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            if (nomineeModel != null) {
                if (!TextUtils.isEmpty(nomineeModel.getState())) {
                    jSONObject.put("state", nomineeModel.getState());
                }
                if (!TextUtils.isEmpty(nomineeModel.getPinCode())) {
                    jSONObject.put("pinCode", nomineeModel.getPinCode());
                }
                if (!TextUtils.isEmpty(nomineeModel.getName())) {
                    jSONObject.put("name", nomineeModel.getName());
                }
                if (!TextUtils.isEmpty(nomineeModel.getHouseNo())) {
                    jSONObject.put("houseNo", nomineeModel.getHouseNo());
                }
                if (!TextUtils.isEmpty(nomineeModel.getStreetName())) {
                    jSONObject.put("streetName", nomineeModel.getStreetName());
                }
                if (!TextUtils.isEmpty(nomineeModel.getAreaName())) {
                    jSONObject.put("areaName", nomineeModel.getAreaName());
                }
                if (!TextUtils.isEmpty(nomineeModel.getDob())) {
                    jSONObject.put("dob", nomineeModel.getDob());
                }
                if (!TextUtils.isEmpty(nomineeModel.getRelationship())) {
                    jSONObject.put("relationship", nomineeModel.getRelationship().toUpperCase(Locale.ENGLISH));
                }
                if (!TextUtils.isEmpty(nomineeModel.getCity())) {
                    jSONObject.put("city", nomineeModel.getCity());
                }
                if (!TextUtils.isEmpty(nomineeModel.getEmail())) {
                    jSONObject.put(AppConstants.KEY_EMAIL, nomineeModel.getEmail());
                }
                hashMap2 = hashMap3;
                jSONObject.put("percentage", 100);
                if (!(nomineeModel.getGuardians() == null || nomineeModel.getGuardians().get(0) == null)) {
                    NomineeModel nomineeModel2 = nomineeModel.getGuardians().get(0);
                    if (!TextUtils.isEmpty(nomineeModel2.getAreaName())) {
                        jSONObject2.put("areaName", nomineeModel2.getAreaName());
                    }
                    if (!TextUtils.isEmpty(nomineeModel2.getCity())) {
                        jSONObject2.put("city", nomineeModel2.getCity());
                    }
                    if (!TextUtils.isEmpty(nomineeModel2.getDob())) {
                        jSONObject2.put("dob", nomineeModel2.getDob());
                    }
                    if (!TextUtils.isEmpty(nomineeModel2.getEmail())) {
                        jSONObject2.put(AppConstants.KEY_EMAIL, nomineeModel2.getEmail());
                    }
                    if (!TextUtils.isEmpty(nomineeModel2.getHouseNo())) {
                        jSONObject2.put("houseNo", nomineeModel2.getHouseNo());
                    }
                    if (!TextUtils.isEmpty(nomineeModel2.getName())) {
                        jSONObject2.put("name", nomineeModel2.getName());
                    }
                    if (!TextUtils.isEmpty(nomineeModel2.getPinCode())) {
                        jSONObject2.put("pinCode", nomineeModel2.getPinCode());
                    }
                    if (!TextUtils.isEmpty(nomineeModel2.getRelationship())) {
                        jSONObject2.put("relationship", nomineeModel2.getRelationship().toUpperCase(Locale.ENGLISH));
                    }
                    if (!TextUtils.isEmpty(nomineeModel2.getState())) {
                        jSONObject2.put("state", nomineeModel2.getState());
                    }
                    if (!TextUtils.isEmpty(nomineeModel2.getStreetName())) {
                        jSONObject2.put("streetName", nomineeModel2.getStreetName());
                    }
                    jSONArray.put(jSONObject2);
                    jSONObject.put("guardians", jSONArray);
                }
            } else {
                hashMap2 = hashMap3;
            }
            String jSONObject3 = jSONObject.toString();
            HashMap hashMap4 = new HashMap();
            hashMap4.put("accountNo", str);
            net.one97.paytm.bankCommon.mapping.g.a();
            return new b(com.paytm.utility.b.e(context2, d.a("ppb_add_is_nominee")), (g.b) bVar, aVar, (IJRPaytmDataModel) new NomineeAdd(), (Map<String, String>) hashMap4, (Map<String, String>) hashMap2, jSONObject3, cVar, bVar2, hashMap, a.C0715a.POST);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
