package net.one97.paytm.dynamic.flight;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.android.volley.VolleyError;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.network.a;
import com.paytm.network.model.CJRError;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.travel.common.a.a;
import com.travel.flight.flightSRPV2.a.n;
import com.travel.g.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.g.b.k;
import net.one97.paytm.AJROrderSummaryActivity;
import net.one97.paytm.AJRRechargePaymentActivity;
import net.one97.paytm.AJRYoutubeVideoPlay;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.cashback.posttxn.f;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.CJRPGToken;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJRCart;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRLifafa;
import net.one97.paytm.common.entity.shopping.CJROrderItems;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.common.entity.shopping.CJRUrlUtmData;
import net.one97.paytm.deeplink.d;
import net.one97.paytm.deeplink.h;
import net.one97.paytm.hotels2.utils.a;
import net.one97.paytm.i;
import net.one97.paytm.i.e;
import net.one97.paytm.j.c;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.landingpage.hometabs.HomeTabItem;
import net.one97.paytm.locale.b.e;
import net.one97.paytm.m;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.NativeSdkPromoHelper;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.Utils.FetchPayOptionsListener;
import net.one97.paytm.nativesdk.Utils.Server;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.app.VerifyPromoCallbackListener;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.VpaFetch;
import net.one97.paytm.nativesdk.orflow.interfaces.OnPromoActivityDestroyListener;
import net.one97.paytm.nativesdk.orflow.promo.PromoHelper;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.travel.AJRBusPaymentActivity;
import net.one97.paytm.travel.AJRFlightPaymentActivity;
import net.one97.paytm.travel.AJRTrainPaymentActivity;
import net.one97.paytm.utils.ac;
import net.one97.paytm.utils.au;
import net.one97.paytm.utils.ba;
import net.one97.paytm.utils.j;
import net.one97.paytm.utils.l;
import net.one97.paytm.utils.r;
import net.one97.paytm.utils.t;

public class TravelDependencyProvider implements a {
    private static final String IS_DEFERRED_CHECKOUT_BUS = "is_deferred_checkout_bus";
    private static final String IS_DEFERRED_CHECKOUT_FLIGHT = "is_deferred_checkout_flight";
    private static final String IS_DEFERRED_CHECKOUT_TRAIN = "is_deferred_checkout_train";
    private static final String TAG = TravelDependencyProvider.class.getName();
    private static TravelDependencyProvider _instance;
    private final String AppsFlyerChannel = "whatsapp";

    public String getAliasClientIdKeyMap() {
        return "0YlmrDXUI6c6jWMTk1JinueaGq-gCvSd2KMsygoITb177xpcT2dKdGom1l3S2cFxBVO1j0_GCU7z3HDx0vOlbw==";
    }

    public String getAliasClientSecretKeyMap() {
        return "0PSHDRHyqKGMdl97qJDbYxZ1pJLPyZzLBFhCCYC-rL2w8nPLrxDXt5AYN1M01emC3qyjLcP_rbVaCWFLQbU4eTr6YWlf4RTb";
    }

    public String getBuildAppId() {
        return "net.one97.paytm";
    }

    public String getBuildTypeString() {
        return "release";
    }

    public Fragment getHotelLifafaInstance(String str, String str2) {
        return null;
    }

    public String getMapSDKKey() {
        return "eu8bmgnsub2mvrhpsni4zfkdeixgj44w";
    }

    public String getRestApiKeyMap() {
        return "ndojlf9d73cxgkpiup7gcdlg1zylppuo";
    }

    public BaseAdapter getYourOrdersItemAdapter(Context context, ArrayList<CJROrderItems> arrayList, String str, int i2, boolean z) {
        return null;
    }

    public boolean isBuildTypeDebug() {
        return false;
    }

    public void launchLifafa(Context context, CJRLifafa cJRLifafa) {
    }

    public void sendRechargeCheckOutEvent(Context context, CJRCart cJRCart) {
    }

    public static TravelDependencyProvider getInstance() {
        if (_instance == null) {
            synchronized (TravelDependencyProvider.class) {
                if (_instance == null) {
                    _instance = new TravelDependencyProvider();
                }
            }
        }
        return _instance;
    }

    public String getAppManagerStringValue(String str, String str2) {
        c.a();
        return c.a(str, str2);
    }

    public int getAppManagerIntegerValue(String str, int i2) {
        c.a();
        return c.a(str, i2);
    }

    public boolean getAppManagerBooleanValue(String str, boolean z) {
        c.a();
        return c.a(str, z);
    }

    public void sendCustomGTMEvents(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        net.one97.paytm.j.a.a(context, str, str2, str3, str4, str5, str6);
    }

    public void sendOpenScreenWithDeviceInfo(String str, String str2, Context context) {
        net.one97.paytm.j.a.b(str, str2, context);
    }

    public void sendCustomEventWithMap(String str, HashMap<String, Object> hashMap, Context context) {
        net.one97.paytm.j.a.b(str, (Map<String, Object>) hashMap, context);
    }

    public void sendCustomEvents(String str, Context context) {
        net.one97.paytm.j.a.a(str, context);
    }

    public Map<String, Map<String, String>> getUnknownUrlMessageMap() {
        return c.a().l();
    }

    public void startLoginActivityForResult(Context context, Intent intent, int i2) {
        intent.setClass(context, AJRAuthActivity.class);
        ((Activity) context).startActivityForResult(intent, i2);
    }

    public void startReachargePaymentActivity(Context context, Intent intent) {
        if (intent != null && intent.getBooleanExtra(IS_DEFERRED_CHECKOUT_FLIGHT, false)) {
            intent.setClass(context, AJRFlightPaymentActivity.class);
        } else if (intent != null && intent.getBooleanExtra(IS_DEFERRED_CHECKOUT_BUS, false)) {
            intent.setClass(context, AJRBusPaymentActivity.class);
        } else if (intent == null || !intent.getBooleanExtra(IS_DEFERRED_CHECKOUT_TRAIN, false)) {
            intent.setClass(context, AJRRechargePaymentActivity.class);
        } else {
            intent.setClass(context, AJRTrainPaymentActivity.class);
        }
        context.startActivity(intent);
    }

    public Context attachBaseContext(Context context) {
        return Build.VERSION.SDK_INT < 29 ? e.a(context) : context;
    }

    public void handleCustomError(Activity activity, NetworkCustomError networkCustomError) {
        l.a(activity, networkCustomError);
    }

    public void startCSTOrderIssuesActivity(Context context, Bundle bundle, m mVar) {
        d.a(context, bundle, mVar);
    }

    public boolean handleDeeplink(Context context, String str, Bundle bundle) {
        h.a aVar = h.f50349a;
        return h.a.a(context, str, bundle);
    }

    public Fragment getTravelOfferFragment(b bVar, WeakReference<View> weakReference) {
        return new net.one97.paytm.i.e(weakReference);
    }

    public void updateNestedScroll(Fragment fragment) {
        if (fragment != null && (fragment instanceof net.one97.paytm.i.e)) {
            net.one97.paytm.i.e eVar = (net.one97.paytm.i.e) fragment;
            if (eVar.f50576b != null && eVar.f50579e == e.b.IDLE) {
                eVar.f50580f.sendEmptyMessageDelayed(1, 100);
            }
        }
    }

    public void loadMoreTravelOffer(Fragment fragment) {
        int parseInt;
        if (fragment instanceof net.one97.paytm.i.e) {
            net.one97.paytm.i.e eVar = (net.one97.paytm.i.e) fragment;
            eVar.c();
            if (eVar.f50575a != null && eVar.f50575a.hasMore() && eVar.f50578d < (parseInt = Integer.parseInt(eVar.f50575a.getTotalViewCount()))) {
                eVar.f50578d += 5;
                if (eVar.f50578d > parseInt) {
                    eVar.f50578d = parseInt;
                }
                if (!TextUtils.isEmpty(eVar.f50577c)) {
                    eVar.b();
                } else {
                    eVar.a();
                }
            }
        }
    }

    public void startHomeScreen(Context context, Intent intent) {
        if (context != null && intent != null) {
            intent.setClass(context, AJRMainActivity.class);
            context.startActivity(intent);
        }
    }

    public String getMainActivityClassName() {
        return AJRMainActivity.class.getName();
    }

    public Intent getCommonOrderSummaryIntent(Context context) {
        return new Intent(context, AJROrderSummaryActivity.class);
    }

    public void startOldOrderSummary(Context context, Intent intent) {
        if (context != null && intent != null) {
            intent.setClass(context, AJROrderSummaryActivity.class);
            context.startActivity(intent);
        }
    }

    public void sendCustomEventScreenWithMap(String str, String str2, String str3, String str4, Context context) {
        net.one97.paytm.j.a.a(str, str2, str3, str4, context);
    }

    public void startReachargePaymentActivityForResult(Context context, Intent intent, int i2) {
        if (intent != null && intent.getBooleanExtra(IS_DEFERRED_CHECKOUT_FLIGHT, false)) {
            intent.setClass(context, AJRFlightPaymentActivity.class);
        } else if (intent == null || !intent.getBooleanExtra(IS_DEFERRED_CHECKOUT_BUS, false)) {
            intent.setClass(context, AJRRechargePaymentActivity.class);
        } else {
            intent.setClass(context, AJRBusPaymentActivity.class);
        }
        ((Activity) context).startActivityForResult(intent, i2);
    }

    public void sendCustomEventsWithScreenName(String str, String str2, Context context) {
        net.one97.paytm.j.a.a(str, str2, context);
    }

    public void sendCustomEventWithKeyValuePair(String str, String str2, String str3, Context context) {
        net.one97.paytm.j.a.a(str, str2, str3, context);
    }

    public boolean isVerticalVIPOfferEnabled(Context context, com.travel.common.a.c cVar) {
        net.one97.paytm.cashback.posttxn.e a2 = net.one97.paytm.deeplink.e.a() ? net.one97.paytm.cashback.posttxn.c.a() : null;
        if (a2 == null) {
            return false;
        }
        int id = net.one97.paytm.utils.b.a.BUS_TICKETS.getId();
        int i2 = AnonymousClass3.$SwitchMap$com$travel$common$listener$VerticalType[cVar.ordinal()];
        if (i2 == 1) {
            id = net.one97.paytm.utils.b.a.BUS_TICKETS.getId();
        } else if (i2 == 2) {
            id = net.one97.paytm.utils.b.a.TRAIN_TICKETS.getId();
        } else if (i2 == 3) {
            id = net.one97.paytm.utils.b.a.FLIGHT_TICKETS.getId();
        } else if (i2 == 4) {
            id = net.one97.paytm.utils.b.a.HOTEL_BOOKING.getId();
        }
        return a2.a(id, 0);
    }

    /* renamed from: net.one97.paytm.dynamic.flight.TravelDependencyProvider$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$travel$common$listener$VerticalType = new int[com.travel.common.a.c.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.travel.common.a.c[] r0 = com.travel.common.a.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$travel$common$listener$VerticalType = r0
                int[] r0 = $SwitchMap$com$travel$common$listener$VerticalType     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.travel.common.a.c r1 = com.travel.common.a.c.BUS     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$travel$common$listener$VerticalType     // Catch:{ NoSuchFieldError -> 0x001f }
                com.travel.common.a.c r1 = com.travel.common.a.c.TRAIN     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$travel$common$listener$VerticalType     // Catch:{ NoSuchFieldError -> 0x002a }
                com.travel.common.a.c r1 = com.travel.common.a.c.FLIGHT     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = $SwitchMap$com$travel$common$listener$VerticalType     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.travel.common.a.c r1 = com.travel.common.a.c.HOTEL     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.dynamic.flight.TravelDependencyProvider.AnonymousClass3.<clinit>():void");
        }
    }

    public net.one97.paytm.cashback.posttxn.e getIPostTxnCashbackHelper(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        if (net.one97.paytm.deeplink.e.a()) {
            return net.one97.paytm.cashback.posttxn.c.a();
        }
        return null;
    }

    public void sendDeepLinkOpen(String str, CJRHomePageItem cJRHomePageItem, Context context) {
        net.one97.paytm.j.a.a(str, cJRHomePageItem, context);
    }

    public void sendTravelPromotionClickImpression(CJRItem cJRItem, Context context, int i2, String str) {
        net.one97.paytm.j.a.a(cJRItem, context, i2, str);
    }

    public void setUtmData(CJRUrlUtmData cJRUrlUtmData) {
        CJRJarvisApplication.a(cJRUrlUtmData);
    }

    public String getCategoryId(CJRItem cJRItem) {
        return l.a(cJRItem);
    }

    public Intent getSplashScreenIntent(Context context) {
        return new Intent(context, AJRMainActivity.class);
    }

    public void launchDeeplink(String str, Context context, String str2) {
        l.a(str, context, str2);
    }

    public void sendTravelPromotionImpression(CJRItem cJRItem, Context context, int i2, String str) {
        net.one97.paytm.j.a.b(cJRItem, context, i2, str);
    }

    public void openPassbookMainActivity(Context context, Intent intent) {
        net.one97.paytm.payments.d.a.a(context, "paytmmp://cash_wallet?featuretype=cash_ledger");
    }

    public void openItemLevelOrder(Context context, Intent intent) {
        c.a();
        net.one97.paytm.payments.d.a.a(context, c.ar());
    }

    public String getAppStamp() {
        return l.a();
    }

    public void logCrashlyticsException(String str, String str2, Exception exc) {
        l.a(str, str2, (Throwable) exc);
    }

    public View getOnTransactionCompleteView(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        net.one97.paytm.cashback.posttxn.e a2 = net.one97.paytm.deeplink.e.a() ? net.one97.paytm.cashback.posttxn.c.a() : null;
        if (a2 != null) {
            a2.a((AppCompatActivity) context);
            f.a aVar = new f.a();
            aVar.f49545a = str;
            a2.a(aVar.a(), (net.one97.paytm.cashback.posttxn.a) null);
        }
        return new View(context);
    }

    public void loaddpdpBrand(Context context, String str, IJRDataModel iJRDataModel, String str2, int i2, ArrayList<? extends CJRItem> arrayList, boolean z, String str3, String str4, String str5, String str6, String str7, String str8) {
        j.a(context, str, iJRDataModel, str2, i2, arrayList, z, str3, str4, str5, str6, str7, str8);
    }

    public void loadPage(Context context, String str, IJRDataModel iJRDataModel, String str2, int i2, ArrayList<? extends CJRItem> arrayList, boolean z, String str3) {
        j.a(context, str, iJRDataModel, str2, i2, arrayList, z, str3, (net.one97.paytm.c) null);
    }

    public Context getApplicationContext() {
        return CJRJarvisApplication.getAppContext();
    }

    public void initPostVerifyNativePGFlow(CJRRechargePayment cJRRechargePayment, Intent intent) {
        net.one97.paytm.travel.c.a();
        ab.a(cJRRechargePayment, intent);
    }

    public void openPassbook(Context context, String str) {
        net.one97.paytm.travel.c.a();
        net.one97.paytm.payments.d.a.a(context, "paytmmp://cash_wallet?featuretype=cash_ledger&tab=prepaid_wallet");
    }

    public boolean reportError(Context context, Exception exc, String str) {
        net.one97.paytm.travel.c.a();
        return r.a(context, exc, str);
    }

    public void showNetworkDialog(com.paytm.network.a aVar, Context context, DialogInterface.OnCancelListener onCancelListener) {
        net.one97.paytm.travel.c.a();
        r.a(aVar, context, onCancelListener);
    }

    public CJRHomePageItem getDeepLinkDataItem(Context context, String str) {
        net.one97.paytm.travel.c.a();
        return ac.a(context, str);
    }

    public Date hotelUtilDateValue(Activity activity, String str) {
        net.one97.paytm.travel.c.a();
        return net.one97.paytm.k.a.a.a(activity, str);
    }

    public void sendUAEventWithValue(String str, String str2) {
        net.one97.paytm.travel.c.a();
        StringBuilder sb = new StringBuilder();
        sb.append(i.f52406a);
        sb.append(str);
        i.a();
    }

    public void sendFbAppsFlyerThankYouPageEvent(Context context, CJROrderedCart cJROrderedCart, String str, String str2) {
        net.one97.paytm.travel.c.a();
    }

    public Intent getIntent(String str, Context context, CJRHomePageItem cJRHomePageItem) {
        net.one97.paytm.travel.c.a();
        if (str.equalsIgnoreCase("travelmybookings")) {
            return ba.l(context);
        }
        if (str.equalsIgnoreCase("travelpreferences")) {
            return ba.m(context);
        }
        if (str.equalsIgnoreCase("travelhelp")) {
            return ba.n(context);
        }
        return null;
    }

    public void sendFlightEvent(String str, String str2, String str3, String str4, Context context) {
        net.one97.paytm.travel.c.a();
        net.one97.paytm.j.a.a(str, str2, str3, str4);
    }

    public void startOrderListActivity(Activity activity, Bundle bundle, m mVar) {
        net.one97.paytm.travel.c.a();
        d.a((Context) activity, bundle, mVar);
    }

    public void startViewAllIssuesActivity(Activity activity, Bundle bundle, m mVar) {
        net.one97.paytm.travel.c.a();
        d.a((Context) activity, bundle, mVar);
    }

    public CJRError getErrorFromAppUtils(Context context, VolleyError volleyError) {
        net.one97.paytm.travel.c.a();
        return l.b(context, volleyError);
    }

    public CJRError getErrorFromAppUtils(Context context, NetworkCustomError networkCustomError) {
        net.one97.paytm.travel.c.a();
        return l.a(context, networkCustomError);
    }

    public void showSessionTimeoutAlert(Activity activity, String str, Bundle bundle, VolleyError volleyError) {
        net.one97.paytm.travel.c.a();
        r.a(activity, str, bundle);
    }

    public boolean checkForUtilities(String str, Context context) {
        net.one97.paytm.travel.c.a();
        return l.b(str);
    }

    public String initPreVerifyNativePGFlow(String str) {
        net.one97.paytm.travel.c.a();
        return ab.b(str);
    }

    public boolean isInstanceOfTravelOfferFragment(Fragment fragment) {
        net.one97.paytm.travel.c.a();
        return fragment instanceof net.one97.paytm.i.e;
    }

    public void clearRecentSearchedData(Context context) {
        net.one97.paytm.travel.c.a();
        l.a(context);
    }

    public Intent getExternalIntent(String str) {
        net.one97.paytm.travel.c.a();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        return intent;
    }

    public String getBankQRCodeConstant() {
        net.one97.paytm.travel.c.a();
        return "pdc_qrcode_id";
    }

    public void startLanguageActivityForResult(Context context, Intent intent, int i2) {
        net.one97.paytm.travel.c.a();
        net.one97.paytm.payments.d.a.a(context, "paytmmp://mini-app?aId=109200364bd9adad098ce67c643bade349cd01d5&data=eyJwYXJhbXMiOiIvaDUtc2V0dGluZ3MvcHJlZmVycmVkLWxhbmd1YWdlIiwic3BhcmFtcyI6eyJjYW5QdWxsRG93biI6ZmFsc2UsInB1bGxSZWZyZXNoIjpmYWxzZSwic2hvd1RpdGxlQmFyIjpmYWxzZX19&url=https://paytm.com");
    }

    public Intent getAJREmbedViewIntent(Context context, String str, String str2, String str3, String str4) {
        net.one97.paytm.travel.c.a();
        return l.a(context, str, str2, str3, str4);
    }

    public void openPromoScreen(String str, Context context, double d2, String str2, VerifyPromoCallbackListener verifyPromoCallbackListener, OnPromoActivityDestroyListener onPromoActivityDestroyListener, String str3) {
        net.one97.paytm.travel.c.a();
        if ((verifyPromoCallbackListener instanceof VerifyPromoCallbackListener) && (onPromoActivityDestroyListener instanceof OnPromoActivityDestroyListener)) {
            try {
                Server server = Server.PRODUCTION;
                PromoHelper.Configuration.class.newInstance().setServer(Server.STAGING);
                NativeSdkPromoHelper nativeSdkPromoHelper = new NativeSdkPromoHelper(str, com.paytm.utility.a.q(context), str3, PromoHelper.Configuration.class.newInstance().setServer(server));
                nativeSdkPromoHelper.startPromoSearchActivity(context, Double.valueOf(d2), str2, verifyPromoCallbackListener);
                nativeSdkPromoHelper.setOnPromoActivityDestroyListener(onPromoActivityDestroyListener);
            } catch (InstantiationException e2) {
                q.b(e2.getMessage());
            } catch (IllegalAccessException e3) {
                q.b(e3.getMessage());
            }
        }
    }

    public void openPromoPayOptionsBottomSheet(String str, Context context, androidx.fragment.app.j jVar, double d2, CJPayMethodResponse cJPayMethodResponse, VerifyPromoCallbackListener verifyPromoCallbackListener, OnPromoActivityDestroyListener onPromoActivityDestroyListener, PaytmSDKRequestClient.VerifyResponseData verifyResponseData) {
        net.one97.paytm.travel.c.a();
        String str2 = str;
        NativeSdkPromoHelper nativeSdkPromoHelper = new NativeSdkPromoHelper(str, t.b(context), "flights");
        nativeSdkPromoHelper.openPromoPayOptionsBottomSheet(jVar, d2, cJPayMethodResponse, verifyResponseData, verifyPromoCallbackListener);
        nativeSdkPromoHelper.setOnPromoActivityDestroyListener(onPromoActivityDestroyListener);
    }

    public Class getYoutubeClass() {
        net.one97.paytm.travel.c.a();
        return AJRYoutubeVideoPlay.class;
    }

    public ContextWrapper getBaseContext(Context context) {
        return net.one97.paytm.locale.b.e.a(context);
    }

    public void sendCustomGTMEventsForhotels(Context context, String str, String str2, String str3, String str4, String str5) {
        net.one97.paytm.j.a.a(context, str, str2, str3, str4, str5);
    }

    public void sendOpenScreenEvent(Context context, String str) {
        net.one97.paytm.j.a.b(context, str);
    }

    public CJRHomePageItem getDeepLinkDataItemForHotel(Context context, String str) {
        return (CJRHomePageItem) new com.google.gson.f().a(new com.google.gson.f().b(ac.a(context, str)), CJRHomePageItem.class);
    }

    public void openPaymentPageForHotel(Activity activity, CJRRechargePayment cJRRechargePayment, final net.one97.paytm.hotels2.a.a aVar) {
        AnonymousClass1 r0 = new a.C0913a() {
            public void onStart() {
                aVar.a();
            }

            public void onError() {
                aVar.b();
            }

            public void onEnd() {
                aVar.c();
            }
        };
        if ("1".equals(cJRRechargePayment.isNativeEnabled())) {
            t.a(activity.getApplicationContext(), cJRRechargePayment, (FetchPayOptionsListener) new FetchPayOptionsListener(r0, activity, cJRRechargePayment) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ C0913a f50551a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ Activity f50552b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ CJRRechargePayment f50553c;

                public final void onPaymentOptionsReceived(CJPayMethodResponse cJPayMethodResponse) {
                }

                public final void onVpaReceived(VpaFetch vpaFetch) {
                }

                {
                    this.f50551a = r1;
                    this.f50552b = r2;
                    this.f50553c = r3;
                }

                public final void onRequestStart() {
                    this.f50551a.onStart();
                }

                public final void onPaymentOptionsError() {
                    this.f50551a.onError();
                    a.a(this.f50552b, this.f50553c);
                }

                public final void onRequestEnd(CJPayMethodResponse cJPayMethodResponse, VpaFetch vpaFetch) {
                    this.f50551a.onEnd();
                    PaytmSDK.setResponse(cJPayMethodResponse, vpaFetch);
                    a.a(this.f50552b, this.f50553c);
                }
            });
            return;
        }
        r0.onEnd();
        net.one97.paytm.hotels2.utils.a.a(activity, cJRRechargePayment);
    }

    public Intent getCalendar(Context context, String str, String str2, String str3, String str4, String str5, int i2, String str6) {
        return new com.travel.c(context, com.travel.common.a.c.HOTEL, com.travel.utils.f.ONE_WAY).a(str).a(0).e(str2).a(i2).d(str5).b(false).a(false).f((String) null).c(str3).b(str4).c(false).g((String) null).b();
    }

    public void getWalletToken(String str, Context context, com.paytm.network.listener.b bVar) {
        t.a((Activity) context, bVar, a.c.OAUTH);
    }

    public void getWalletToken(a.c cVar, Activity activity, com.paytm.network.listener.b bVar) {
        t.a(activity, bVar, cVar);
    }

    public Intent getLoginIntent(Context context) {
        return new Intent(context, AJRAuthActivity.class);
    }

    public boolean checkErrorCode(Context context, VolleyError volleyError) {
        return l.a(context, volleyError);
    }

    public void flightOrderSummaryGA(HashMap hashMap, List<HashMap<String, String>> list, String str, Activity activity) {
        net.one97.paytm.j.a.a(hashMap, list, str, activity);
    }

    public void sendOrderSummaryForVerticals(String str, String str2, boolean z, String str3, String str4, Context context, ArrayList<CJROrderedCart> arrayList, String str5) {
        net.one97.paytm.j.a.a(str, str2, z, str3, str4, context, arrayList, str5);
    }

    public void sendPulseEvents(String str, String str2, String str3, String str4, com.travel.common.a.c cVar, Map<String, Object> map) {
        if (!TextUtils.isEmpty(str)) {
            if (map == null) {
                map = new HashMap<>();
            }
            if (!TextUtils.isEmpty(str2)) {
                map.put(SDKConstants.EVENT_KEY_SCREEN_NAME, str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                map.put("event_category", str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                map.put("event_action", str4);
            }
            String name = cVar.name();
            if (!TextUtils.isEmpty(name)) {
                map.put("vertical_name", name.toLowerCase());
            }
            map.put(AppConstants.NOTIFICATION_DETAILS.EVENT, GAUtil.CUSTOM_EVENT);
            net.one97.paytm.j.a.a(map, str);
        }
    }

    public <T> void logHawkeyeEvent(T t) {
        if (t instanceof n) {
            au.e eVar = new au.e();
            eVar.f69690e = au.c.LocalError.stringValue;
            eVar.g(((n) t).toString());
            eVar.l = a.c.FLIGHT.name();
            eVar.t = au.f.SILENT.toString();
            au.a(eVar, au.c.LocalError.stringValue, getApplicationContext());
        } else if (t instanceof com.travel.flight.flightSRPV2.a.m) {
            au.e eVar2 = new au.e();
            eVar2.f69690e = au.c.LocalError.stringValue;
            eVar2.g(((com.travel.flight.flightSRPV2.a.m) t).toString());
            eVar2.l = a.c.FLIGHT.name();
            eVar2.t = au.f.USER_FACING.toString();
            au.a(eVar2, au.c.LocalError.stringValue, getApplicationContext());
        }
    }

    public String getSelectedProfileType(Context context) {
        return com.paytm.utility.b.ak(context);
    }

    public boolean isInStanceOfHomeTab(Object obj) {
        return obj instanceof HomeTabItem;
    }

    public String getHomeTabItemUrl(Object obj) {
        return ((HomeTabItem) obj).getUrlType();
    }

    public void showSessionTimeoutAlert(Activity activity, String str, Bundle bundle, Exception exc, boolean z, boolean z2) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putBoolean("close_pop_up", true);
        net.one97.paytm.travel.c.a();
        r.a(activity, str, bundle, z, z2);
    }

    public Intent getOneWayCalendarIntent(Context context, com.travel.common.a.c cVar, String str, long j, int i2, String str2, boolean z, boolean z2, String str3, String str4, String str5, String str6) {
        return new com.travel.c(context, cVar, com.travel.utils.f.ONE_WAY).a(str).a(j).a().d(str2).b(z2).a(true).b(i2).c(str4).b(str5).f(str3).c(z).g(str6).b();
    }

    public Intent getTwoWayCalendarIntent(Context context, com.travel.common.a.c cVar, com.travel.utils.m mVar, String str, long j, String str2, int i2, String str3, boolean z, boolean z2, String str4, String str5, String str6, String str7) {
        Context context2 = context;
        com.travel.common.a.c cVar2 = cVar;
        String str8 = str;
        com.travel.c a2 = new com.travel.c(context, cVar, com.travel.utils.f.TWO_WAY).a(str);
        k.c(mVar, "tabType");
        a2.f22822a.putExtra("intent extra tab type for two way calendar", mVar);
        long j2 = j;
        com.travel.c a3 = a2.a(j);
        String str9 = str2;
        int i3 = i2;
        String str10 = str3;
        boolean z3 = z;
        return a3.e(str2).a(i2).d(str3).b(z2).c(str5).b(str6).f(str4).c(z).g(str7).b();
    }

    public Intent getOneWayCalendarMultipleDateSelectIntent(Context context, com.travel.common.a.c cVar, String str, long j, String str2, int i2, String str3, boolean z, boolean z2, String str4, String str5, String str6, String str7) {
        Context context2 = context;
        com.travel.common.a.c cVar2 = cVar;
        String str8 = str;
        long j2 = j;
        String str9 = str2;
        int i3 = i2;
        String str10 = str3;
        boolean z3 = z2;
        String str11 = str4;
        boolean z4 = z;
        return new com.travel.c(context, cVar, com.travel.utils.f.ONE_WAY).a(str).a(j).e(str2).a(i2).d(str3).b(z2).a(false).f(str4).c(str5).b(str6).c(z).g(str7).b();
    }

    public TreeMap<String, String> getMappedItemsForSFGAPulse(String str, String str2, String str3, String str4, int i2, String str5, int i3, String str6, String str7, String str8) {
        StringBuilder sb;
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("id", str);
        if (!TextUtils.isEmpty(str5)) {
            str2 = str2 + "_" + str5;
        }
        treeMap.put("name", str2);
        if (!TextUtils.isEmpty(str3)) {
            str4 = str3 + "/" + str4;
        }
        treeMap.put("creative", str4);
        if (i3 == -1) {
            sb = new StringBuilder("slot_");
            sb.append(i2 + 1);
        } else {
            sb = new StringBuilder("slot_");
            sb.append(i2 + 1);
            sb.append("_");
            sb.append(i3 + 1);
        }
        treeMap.put(CLPConstants.ARGUMENT_KEY_POSITION, sb.toString());
        if (!TextUtils.isEmpty(str6)) {
            treeMap.put("dimension40", str6);
        }
        if (!TextUtils.isEmpty(str7)) {
            treeMap.put("variantInstanceId", str7);
        }
        treeMap.put("type", str8);
        return treeMap;
    }

    public void generateSmartLinkAndShare(final Context context, Map<String, String> map, final String str) {
        if (map != null) {
            final String str2 = map.get(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS);
            if (!TextUtils.isEmpty(str2)) {
                map.remove(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS);
            } else {
                str2 = map.get("title");
            }
            net.one97.paytm.utils.m mVar = net.one97.paytm.utils.m.f69757a;
            net.one97.paytm.utils.m.a(context, "whatsapp", (HashMap) map, new kotlin.g.a.m<String, Integer, Object>() {
                public Object invoke(String str, Integer num) {
                    if (context == null) {
                        return null;
                    }
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType("text/plain");
                    intent.addFlags(524288);
                    intent.putExtra("android.intent.extra.SUBJECT", str2);
                    intent.putExtra("android.intent.extra.TEXT", str + "\n\n" + str2 + "\n\n" + str);
                    context.startActivity(Intent.createChooser(intent, "Share link!"));
                    return null;
                }
            }, 0);
        }
    }

    public Intent getOneWayCalendarIntent(Context context, com.travel.common.a.c cVar, String str, long j, int i2, String str2, boolean z, boolean z2, String str3, String str4, String str5, String str6, boolean z3, String str7, String str8) {
        Context context2 = context;
        com.travel.common.a.c cVar2 = cVar;
        String str9 = str;
        long j2 = j;
        String str10 = str2;
        boolean z4 = z2;
        int i3 = i2;
        String str11 = str4;
        String str12 = str3;
        boolean z5 = z;
        com.travel.c g2 = new com.travel.c(context, cVar, com.travel.utils.f.ONE_WAY).a(str).a(j).a().d(str2).b(z2).a(true).b(i2).c(str4).b(str5).f(str3).c(z).g(str6);
        g2.f22822a.putExtra("intent_extra_end_date_range", str8);
        g2.f22822a.putExtra("intent_extra_start_date_range", str7);
        g2.f22822a.putExtra("is_from_order_modification", z3);
        return g2.b();
    }

    public void saveTransactionId(Context context, CJROrderSummary cJROrderSummary) {
        q.a("TrustList Util 111");
        if (context != null && cJROrderSummary != null && cJROrderSummary.getPaymentInfo() != null && cJROrderSummary.getPaymentInfo().size() > 0 && !TextUtils.isEmpty(cJROrderSummary.getPaymentInfo().get(0).getTransactionNumber())) {
            String transactionNumber = cJROrderSummary.getPaymentInfo().get(0).getTransactionNumber();
            String valueOf = String.valueOf(cJROrderSummary.getPaymentInfo().get(0).getPgAmount());
            q.a("TrustList Util 222" + valueOf + " " + transactionNumber);
            net.one97.paytm.trustlist.d.a(valueOf, transactionNumber);
        }
    }

    public void saveTransactionId(Context context, String str, String str2) {
        q.a("TrustList Util 111");
        if (context != null && str != null && str2 != null) {
            q.a("TrustList Util 222" + str2 + " " + str);
            net.one97.paytm.trustlist.d.a(str2, str);
        }
    }

    public void saveTransactionIdForBus(Context context, String str, Double d2) {
        q.a("TrustList Util 111");
        if (context != null && str != null && d2.doubleValue() > 0.0d && !TextUtils.isEmpty(str)) {
            String valueOf = String.valueOf(d2);
            q.a("TrustList Util 222" + valueOf + " " + str);
            net.one97.paytm.trustlist.d.a(valueOf, str);
        }
    }

    public String getPgToken(CJRPGTokenList cJRPGTokenList) {
        boolean z;
        ArrayList<CJRPGToken> pGTokenList = cJRPGTokenList.getPGTokenList();
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
            String[] split = cJRPGToken.getScopes().split(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA);
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

    public void addToQueue(List<TreeMap<String, String>> list, Context context) {
        if (net.one97.paytm.landingpage.utils.h.f53016a == null) {
            net.one97.paytm.landingpage.utils.h.f53016a = new net.one97.paytm.landingpage.utils.h();
        }
        ArrayList arrayList = new ArrayList(list);
        if (!arrayList.isEmpty()) {
            net.one97.paytm.common.b.d.a().a(context, (List<Map<String, String>>) new ArrayList(arrayList));
        }
    }
}
