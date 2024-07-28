package net.one97.paytm.transport.iocl.b;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.webkit.URLUtil;
import com.google.gsonhtcfix.f;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.a;
import com.paytm.utility.c;
import com.paytm.utility.h;
import java.util.HashMap;
import net.one97.paytm.common.entity.CJRAadharPanGet;
import net.one97.paytm.common.entity.CJRPGTokenListTransport;
import net.one97.paytm.iocl.R;
import net.one97.paytm.transport.iocl.a;
import net.one97.paytm.transport.iocl.data.IOCLBaseModel;
import net.one97.paytm.transport.iocl.data.IOCLCommonResponse;
import net.one97.paytm.transport.iocl.data.IOCLRedeemHistoryModel;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f14269a = "https://transportation.paytm.com/iocl/v2";

    /* renamed from: b  reason: collision with root package name */
    public static String f14270b = "https://staging-transportation.paytmdgt.io/iocl/v2";

    /* renamed from: c  reason: collision with root package name */
    public static int f14271c = 102;

    /* renamed from: d  reason: collision with root package name */
    public static int f14272d = 101;

    /* renamed from: e  reason: collision with root package name */
    public static int f14273e = 103;

    /* renamed from: f  reason: collision with root package name */
    public static int f14274f = 104;

    /* renamed from: g  reason: collision with root package name */
    public static int f14275g = 105;

    /* renamed from: h  reason: collision with root package name */
    public static String f14276h = f14269a;

    /* renamed from: i  reason: collision with root package name */
    public static int f14277i = 10;

    public static void a(Context context, com.paytm.network.listener.b bVar, String str) {
        String str2;
        String iOCLBaseUrlV2 = a.c().getIOCLBaseUrlV2();
        if (TextUtils.isEmpty(iOCLBaseUrlV2)) {
            iOCLBaseUrlV2 = f14276h;
        }
        if (TextUtils.isEmpty(a.c().getIOCLHomeUrl())) {
            str2 = iOCLBaseUrlV2 + "/home";
        } else {
            str2 = iOCLBaseUrlV2 + a.c().getIOCLHomeUrl();
        }
        String uri = Uri.parse(str2 + c.a(context, false)).buildUpon().appendQueryParameter(ContactColumn.PHONE_NUMBER, com.paytm.utility.b.ab(context)).build().toString();
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

    public static void a(Context context, com.paytm.network.listener.b bVar, int i2, String str, String str2, boolean z, boolean z2) {
        String str3;
        String iOCLBaseUrlV2 = net.one97.paytm.transport.iocl.a.c().getIOCLBaseUrlV2();
        if (TextUtils.isEmpty(iOCLBaseUrlV2)) {
            iOCLBaseUrlV2 = f14276h;
        }
        if (TextUtils.isEmpty(net.one97.paytm.transport.iocl.a.c().getIOCLRedeemHistoryUrl())) {
            str3 = iOCLBaseUrlV2 + "/redeemHistory";
        } else {
            str3 = iOCLBaseUrlV2 + net.one97.paytm.transport.iocl.a.c().getIOCLRedeemHistoryUrl();
        }
        String uri = Uri.parse(str3 + c.a(context, false)).buildUpon().appendQueryParameter(ContactColumn.PHONE_NUMBER, com.paytm.utility.b.ab(context)).appendQueryParameter("startRowNum", String.valueOf(i2)).appendQueryParameter("limit", String.valueOf(f14277i)).build().toString();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            uri = uri.concat("&startDate=".concat(str)).concat("&endDate=".concat(str2));
        }
        if (!z || !z2) {
            if (z) {
                uri = uri.concat("&transactionType=Accrual");
            } else if (z2) {
                uri = uri.concat("&transactionType=Redemption");
            }
        }
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

    public static void a(Context context, com.paytm.network.listener.b bVar, IOCLCommonResponse iOCLCommonResponse) {
        String str;
        String iOCLBaseUrlV2 = net.one97.paytm.transport.iocl.a.c().getIOCLBaseUrlV2();
        if (TextUtils.isEmpty(iOCLBaseUrlV2)) {
            iOCLBaseUrlV2 = f14276h;
        }
        if (TextUtils.isEmpty(net.one97.paytm.transport.iocl.a.c().getRedeemIOCLOTPUrl())) {
            str = iOCLBaseUrlV2 + "/redeem";
        } else {
            str = iOCLBaseUrlV2 + net.one97.paytm.transport.iocl.a.c().getRedeemIOCLOTPUrl();
        }
        Uri build = Uri.parse(str + c.a(context, false)).buildUpon().appendQueryParameter(ContactColumn.PHONE_NUMBER, com.paytm.utility.b.l(context)).build();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (!(iOCLCommonResponse == null || iOCLCommonResponse.getRewards() == null)) {
            try {
                jSONObject2.put("points", iOCLCommonResponse.getRewards().getPoints());
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

    public static void a(Context context, com.paytm.network.listener.b bVar) {
        String str;
        String iOCLBaseUrlV2 = net.one97.paytm.transport.iocl.a.c().getIOCLBaseUrlV2();
        if (TextUtils.isEmpty(iOCLBaseUrlV2)) {
            iOCLBaseUrlV2 = f14276h;
        }
        if (TextUtils.isEmpty(net.one97.paytm.transport.iocl.a.c().getIOCLUserInfoUrl())) {
            str = iOCLBaseUrlV2 + "/userInfo";
        } else {
            str = iOCLBaseUrlV2 + net.one97.paytm.transport.iocl.a.c().getIOCLUserInfoUrl();
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

    public static void b(Context context, com.paytm.network.listener.b bVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("session_token", net.one97.paytm.transport.iocl.a.b().getSSOToken(context));
        hashMap.put("Accept-Encoding", "gzip");
        com.paytm.network.b bVar2 = new com.paytm.network.b();
        bVar2.f42877a = context;
        bVar2.f42878b = a.c.TRANSPORTAION;
        bVar2.n = a.b.SILENT;
        bVar2.o = "ioclVideoFragment";
        bVar2.f42879c = a.C0715a.GET;
        bVar2.f42880d = net.one97.paytm.transport.iocl.a.c().getIOCLKycInfoUrl() + c.a(context, false);
        bVar2.f42882f = hashMap;
        bVar2.f42885i = new CJRAadharPanGet();
        bVar2.j = bVar;
        com.paytm.network.a l = bVar2.l();
        l.f42859c = false;
        l.a();
    }

    public static void a(Context context, net.one97.paytm.transport.iocl.data.b bVar, com.paytm.network.listener.b bVar2, String str, String str2) {
        String str3;
        String iOCLBaseUrlV2 = net.one97.paytm.transport.iocl.a.c().getIOCLBaseUrlV2();
        if (TextUtils.isEmpty(iOCLBaseUrlV2)) {
            iOCLBaseUrlV2 = f14276h;
        }
        if (TextUtils.isEmpty(net.one97.paytm.transport.iocl.a.c().getIOCLRegisterUserUrl())) {
            str3 = iOCLBaseUrlV2 + "/registerUser";
        } else {
            str3 = iOCLBaseUrlV2 + net.one97.paytm.transport.iocl.a.c().getIOCLRegisterUserUrl();
        }
        Uri build = Uri.parse(str3).buildUpon().appendQueryParameter(ContactColumn.PHONE_NUMBER, com.paytm.utility.b.l(context)).appendQueryParameter("userAction", str).build();
        if (!TextUtils.isEmpty(str2)) {
            build = Uri.parse(str3).buildUpon().appendQueryParameter(ContactColumn.PHONE_NUMBER, com.paytm.utility.b.l(context)).appendQueryParameter("userAction", str).appendQueryParameter("isEditable", str2).build();
        }
        String s = com.paytm.utility.b.s(context, build.toString());
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put(AppConstants.SSO_TOKEN, net.one97.paytm.transport.iocl.a.b().getSSOToken(context));
        hashMap.put("wallet_token", net.one97.paytm.transport.iocl.a.b().getWalletSSOToken(context));
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

    public static void b(Context context, com.paytm.network.listener.b bVar, String str) {
        a.c cVar = a.c.OAUTH;
        HashMap hashMap = new HashMap();
        hashMap.put("Authorization", com.paytm.utility.b.m());
        hashMap.put("access_token", str);
        if (!URLUtil.isValidUrl("https://accounts.paytm.com/oauth2/usertokens")) {
            com.paytm.utility.b.b(context, context.getResources().getString(R.string.error), context.getResources().getString(R.string.msg_invalid_url));
            return;
        }
        String e2 = com.paytm.utility.b.e(context, "https://accounts.paytm.com/oauth2/usertokens");
        if (com.paytm.utility.b.c(context)) {
            com.paytm.network.b bVar2 = new com.paytm.network.b();
            bVar2.f42877a = context;
            bVar2.f42879c = a.C0715a.GET;
            bVar2.f42878b = cVar;
            bVar2.f42880d = e2;
            bVar2.f42884h = null;
            bVar2.f42882f = hashMap;
            bVar2.f42885i = new CJRPGTokenListTransport();
            bVar2.o = "InsuranceOrderSummary";
            bVar2.j = bVar;
            bVar2.n = a.b.SILENT;
            bVar2.l().a();
            return;
        }
        com.paytm.utility.b.b(context, context.getResources().getString(R.string.no_connection), context.getResources().getString(R.string.no_internet));
    }
}
