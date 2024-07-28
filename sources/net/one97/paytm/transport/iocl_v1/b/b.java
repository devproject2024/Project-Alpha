package net.one97.paytm.transport.iocl_v1.b;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.alipay.mobile.h5container.api.H5Param;
import com.google.gsonhtcfix.f;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.a;
import com.paytm.utility.c;
import com.paytm.utility.h;
import easypay.manager.Constants;
import java.util.HashMap;
import net.one97.paytm.transport.iocl.a;
import net.one97.paytm.transport.iocl_v1.data.IOCLBaseModel;
import net.one97.paytm.transport.iocl_v1.data.IOCLCommonResponse;
import net.one97.paytm.transport.iocl_v1.data.IOCLRedeemHistoryModel;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f14410a = "https://transportation.paytm.com/iocl/v1";

    /* renamed from: b  reason: collision with root package name */
    public static String f14411b = "https://staging-transportation.paytmdgt.io/iocl/v1";

    /* renamed from: c  reason: collision with root package name */
    public static String f14412c = f14410a;

    /* renamed from: d  reason: collision with root package name */
    public static int f14413d = 10;

    public static void a(Context context, com.paytm.network.listener.b bVar, String str) {
        String str2;
        String iOCLBaseUrl = a.c().getIOCLBaseUrl();
        if (TextUtils.isEmpty(iOCLBaseUrl)) {
            iOCLBaseUrl = f14412c;
        }
        if (TextUtils.isEmpty(a.c().getIOCLHomeUrl())) {
            str2 = iOCLBaseUrl + "/home";
        } else {
            str2 = iOCLBaseUrl + a.c().getIOCLHomeUrl();
        }
        String uri = Uri.parse(str2 + c.a(context, false)).buildUpon().appendQueryParameter(ContactColumn.PHONE_NUMBER, com.paytm.utility.b.l(context)).build().toString();
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put(AppConstants.SSO_TOKEN, a.b().getSSOToken(context));
        hashMap.put("wallet_token", a.b().getWalletSSOToken(context));
        com.paytm.network.b bVar2 = new com.paytm.network.b();
        bVar2.f42877a = context;
        bVar2.f42878b = a.c.TRANSPORTAION;
        bVar2.n = a.b.SILENT;
        bVar2.o = str;
        bVar2.f42879c = a.C0715a.GET;
        bVar2.f42880d = uri;
        bVar2.f42882f = hashMap;
        bVar2.f42885i = new IOCLBaseModel();
        bVar2.j = bVar;
        com.paytm.network.a l = bVar2.l();
        l.f42859c = false;
        l.a();
    }

    public static void a(Context context, com.paytm.network.listener.b bVar, int i2) {
        String str;
        String iOCLBaseUrl = net.one97.paytm.transport.iocl.a.c().getIOCLBaseUrl();
        if (TextUtils.isEmpty(iOCLBaseUrl)) {
            iOCLBaseUrl = f14412c;
        }
        if (TextUtils.isEmpty(net.one97.paytm.transport.iocl.a.c().getIOCLRedeemHistoryUrl())) {
            str = iOCLBaseUrl + "/redeemHistory";
        } else {
            str = iOCLBaseUrl + net.one97.paytm.transport.iocl.a.c().getIOCLRedeemHistoryUrl();
        }
        String uri = Uri.parse(str + c.a(context, false)).buildUpon().appendQueryParameter(ContactColumn.PHONE_NUMBER, com.paytm.utility.b.l(context)).appendQueryParameter(H5Param.PAGE, String.valueOf(i2)).appendQueryParameter("limit", String.valueOf(f14413d)).build().toString();
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put(AppConstants.SSO_TOKEN, net.one97.paytm.transport.iocl.a.b().getSSOToken(context));
        hashMap.put("wallet_token", net.one97.paytm.transport.iocl.a.b().getWalletSSOToken(context));
        com.paytm.network.b bVar2 = new com.paytm.network.b();
        bVar2.f42877a = context;
        bVar2.f42878b = a.c.TRANSPORTAION;
        bVar2.n = a.b.SILENT;
        bVar2.o = "ioclVideoFragment";
        bVar2.f42879c = a.C0715a.GET;
        bVar2.f42880d = uri;
        bVar2.f42882f = hashMap;
        bVar2.f42885i = new IOCLRedeemHistoryModel();
        bVar2.j = bVar;
        com.paytm.network.a l = bVar2.l();
        l.f42859c = false;
        l.a();
    }

    public static void a(Context context, com.paytm.network.listener.b bVar, Long l) {
        String str;
        String iOCLBaseUrl = net.one97.paytm.transport.iocl.a.c().getIOCLBaseUrl();
        if (TextUtils.isEmpty(iOCLBaseUrl)) {
            iOCLBaseUrl = f14412c;
        }
        if (TextUtils.isEmpty(net.one97.paytm.transport.iocl.a.c().getIOCLOTPUrl())) {
            str = iOCLBaseUrl + "/generateotp";
        } else {
            str = iOCLBaseUrl + net.one97.paytm.transport.iocl.a.c().getIOCLOTPUrl();
        }
        Uri build = Uri.parse(str + c.a(context, false)).buildUpon().appendQueryParameter(ContactColumn.PHONE_NUMBER, com.paytm.utility.b.l(context)).build();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("points", l);
            jSONObject.put("transaction", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        String uri = build.toString();
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put(AppConstants.SSO_TOKEN, net.one97.paytm.transport.iocl.a.b().getSSOToken(context));
        hashMap.put("wallet_token", net.one97.paytm.transport.iocl.a.b().getWalletSSOToken(context));
        com.paytm.network.b bVar2 = new com.paytm.network.b();
        bVar2.f42877a = context;
        bVar2.f42878b = a.c.TRANSPORTAION;
        bVar2.n = a.b.SILENT;
        bVar2.o = "ioclVideoFragment";
        bVar2.f42879c = a.C0715a.POST;
        bVar2.f42880d = uri;
        bVar2.f42882f = hashMap;
        bVar2.f42885i = new IOCLBaseModel();
        bVar2.j = bVar;
        bVar2.f42884h = jSONObject.toString();
        com.paytm.network.a l2 = bVar2.l();
        l2.f42859c = false;
        l2.a();
    }

    public static void a(Context context, com.paytm.network.listener.b bVar, IOCLCommonResponse iOCLCommonResponse) {
        String str;
        String iOCLBaseUrl = net.one97.paytm.transport.iocl.a.c().getIOCLBaseUrl();
        if (TextUtils.isEmpty(iOCLBaseUrl)) {
            iOCLBaseUrl = f14412c;
        }
        if (TextUtils.isEmpty(net.one97.paytm.transport.iocl.a.c().getRedeemIOCLOTPUrl())) {
            str = iOCLBaseUrl + "/redeem";
        } else {
            str = iOCLBaseUrl + net.one97.paytm.transport.iocl.a.c().getRedeemIOCLOTPUrl();
        }
        Uri build = Uri.parse(str + c.a(context, false)).buildUpon().appendQueryParameter(ContactColumn.PHONE_NUMBER, com.paytm.utility.b.l(context)).build();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (!(iOCLCommonResponse == null || iOCLCommonResponse.getRewards() == null)) {
            try {
                jSONObject2.put("points", iOCLCommonResponse.getRewards().getPoints());
                jSONObject2.put("otp", iOCLCommonResponse.getRewards().getOtp());
                jSONObject2.put(Constants.RISK_TRANSACTION_ID, iOCLCommonResponse.getTransactionId());
                jSONObject.put("transaction", jSONObject2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        String uri = build.toString();
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put(AppConstants.SSO_TOKEN, net.one97.paytm.transport.iocl.a.b().getSSOToken(context));
        hashMap.put("wallet_token", net.one97.paytm.transport.iocl.a.b().getWalletSSOToken(context));
        com.paytm.network.b bVar2 = new com.paytm.network.b();
        bVar2.f42877a = context;
        bVar2.f42878b = a.c.TRANSPORTAION;
        bVar2.n = a.b.SILENT;
        bVar2.o = "ioclVideoFragment";
        bVar2.f42879c = a.C0715a.POST;
        bVar2.f42880d = uri;
        bVar2.f42882f = hashMap;
        bVar2.f42885i = new IOCLBaseModel();
        bVar2.j = bVar;
        bVar2.f42884h = jSONObject.toString();
        com.paytm.network.a l = bVar2.l();
        l.f42859c = false;
        l.a();
    }

    public static void a(Context context, com.paytm.network.listener.b bVar) {
        String str;
        String iOCLBaseUrl = net.one97.paytm.transport.iocl.a.c().getIOCLBaseUrl();
        if (TextUtils.isEmpty(iOCLBaseUrl)) {
            iOCLBaseUrl = f14412c;
        }
        if (TextUtils.isEmpty(net.one97.paytm.transport.iocl.a.c().getIOCLUserInfoUrl())) {
            str = iOCLBaseUrl + "/userInfo";
        } else {
            str = iOCLBaseUrl + net.one97.paytm.transport.iocl.a.c().getIOCLUserInfoUrl();
        }
        String uri = Uri.parse(str + c.a(context, false)).buildUpon().appendQueryParameter(ContactColumn.PHONE_NUMBER, com.paytm.utility.b.l(context)).build().toString();
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put(AppConstants.SSO_TOKEN, net.one97.paytm.transport.iocl.a.b().getSSOToken(context));
        hashMap.put("wallet_token", net.one97.paytm.transport.iocl.a.b().getWalletSSOToken(context));
        com.paytm.network.b bVar2 = new com.paytm.network.b();
        bVar2.f42877a = context;
        bVar2.f42878b = a.c.TRANSPORTAION;
        bVar2.n = a.b.SILENT;
        bVar2.o = "ioclVideoFragment";
        bVar2.f42879c = a.C0715a.GET;
        bVar2.f42880d = uri;
        bVar2.f42882f = hashMap;
        bVar2.f42885i = new IOCLBaseModel();
        bVar2.j = bVar;
        com.paytm.network.a l = bVar2.l();
        l.f42859c = false;
        l.a();
    }

    public static void a(Context context, net.one97.paytm.transport.iocl_v1.data.b bVar, com.paytm.network.listener.b bVar2) {
        String str;
        String iOCLBaseUrl = net.one97.paytm.transport.iocl.a.c().getIOCLBaseUrl();
        if (TextUtils.isEmpty(iOCLBaseUrl)) {
            iOCLBaseUrl = f14412c;
        }
        if (TextUtils.isEmpty(net.one97.paytm.transport.iocl.a.c().getIOCLRegisterUserUrl())) {
            str = iOCLBaseUrl + "/registerUser";
        } else {
            str = iOCLBaseUrl + net.one97.paytm.transport.iocl.a.c().getIOCLRegisterUserUrl();
        }
        String s = com.paytm.utility.b.s(context, Uri.parse(str).buildUpon().appendQueryParameter(ContactColumn.PHONE_NUMBER, com.paytm.utility.b.l(context)).build().toString());
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put(AppConstants.SSO_TOKEN, net.one97.paytm.transport.iocl.a.b().getSSOToken(context));
        hashMap.put("wallet_token", net.one97.paytm.transport.iocl.a.b().getWalletSSOToken(context));
        new HashMap();
        hashMap.put(ContactColumn.PHONE_NUMBER, com.paytm.utility.b.l(context));
        String a2 = new f().a((Object) bVar);
        com.paytm.network.b bVar3 = new com.paytm.network.b();
        bVar3.f42877a = context;
        bVar3.f42878b = a.c.TRANSPORTAION;
        bVar3.n = a.b.SILENT;
        bVar3.o = "ioclVideoFragment";
        bVar3.f42879c = a.C0715a.POST;
        bVar3.f42880d = s;
        bVar3.f42882f = hashMap;
        bVar3.f42885i = new IOCLBaseModel();
        bVar3.j = bVar2;
        bVar3.f42884h = a2.toString();
        com.paytm.network.a l = bVar3.l();
        l.f42859c = false;
        l.a();
    }

    public static void a(Activity activity) {
        try {
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus != null) {
                ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    public static void a(final Activity activity, String str) {
        if ((activity instanceof Activity) && !activity.isFinishing()) {
            final h hVar = new h(activity);
            hVar.a(str);
            hVar.setCancelable(false);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(hVar.getWindow().getAttributes());
            layoutParams.width = -1;
            layoutParams.height = -2;
            hVar.a(-3, "Ok", new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.cancel();
                    activity.finish();
                }
            });
            hVar.show();
            if (hVar.getWindow() != null) {
                hVar.getWindow().setAttributes(layoutParams);
            }
        }
    }
}
