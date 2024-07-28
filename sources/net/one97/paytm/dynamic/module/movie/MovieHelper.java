package net.one97.paytm.dynamic.module.movie;

import android.app.Activity;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import androidx.appcompat.app.AppCompatActivity;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.android.volley.VolleyError;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.a;
import com.paytm.network.model.CJRError;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget;
import com.paytmmall.clpartifact.widgets.blueprints.SFWidget;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.AJROrderSummaryActivity;
import net.one97.paytm.AJRRechargePaymentActivity;
import net.one97.paytm.AJRYoutubeVideoPlay;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.cashback.posttxn.e;
import net.one97.paytm.cashback.posttxn.f;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.CJRSelectCityModel;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRNpsTrackingResponse;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJRParcelTrackingInfo;
import net.one97.paytm.deeplink.d;
import net.one97.paytm.deeplink.k;
import net.one97.paytm.deeplink.u;
import net.one97.paytm.i;
import net.one97.paytm.j.a;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.m;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.NativeSdkPromoHelper;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.Utils.FetchPayOptionsListener;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;
import net.one97.paytm.nativesdk.app.VerifyPromoCallbackListener;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.VpaFetch;
import net.one97.paytm.nativesdk.orflow.interfaces.OnPromoActivityDestroyListener;
import net.one97.paytm.nativesdk.orflow.promo.model.Request;
import net.one97.paytm.o2o.movies.b.g;
import net.one97.paytm.o2o.movies.common.c.b;
import net.one97.paytm.o2o.movies.common.c.c;
import net.one97.paytm.o2o.movies.common.movies.booking.CJRMovieCart;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.utils.ac;
import net.one97.paytm.utils.ar;
import net.one97.paytm.utils.j;
import net.one97.paytm.utils.l;
import net.one97.paytm.utils.r;
import net.one97.paytm.utils.t;
import net.one97.paytm.utils.v;
import net.one97.paytm.y;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MovieHelper extends c {
    public void clearRisk() {
    }

    public boolean containsError(CJRMovieCart cJRMovieCart, Context context) {
        return false;
    }

    public void dropBreadCrumb(String str, String str2) {
    }

    public Intent getIntent(String str, Context context, CJRHomePageItem cJRHomePageItem) {
        return null;
    }

    public String getJsonOfRiskExtendedInfo() {
        return "";
    }

    public boolean isBranchShareUrl(String str) {
        return false;
    }

    public boolean isDebugType() {
        return false;
    }

    public void sendCrashAnalyticLogs(String str) {
    }

    public void sendCustomEvents(String str, Context context) {
    }

    public void sendMoviePromotionImpressionClick(String str, Context context, int i2, String str2, String str3) {
    }

    public void setRiskExtendedInfo(Context context, String str, String str2, boolean z, String str3) {
    }

    public void shareBranchLink(Context context, String str) {
    }

    public void showASimpleMessageToUser(Context context, String str) {
    }

    private MovieHelper() {
    }

    public static void initMoviesLib(Application application) {
        createInstance();
        c cVar = mInstance;
        if (b.f75032a == null) {
            b bVar = new b();
            b.f75032a = bVar;
            bVar.f75033b = cVar;
        }
    }

    private static void createInstance() {
        if (mInstance == null) {
            mInstance = new MovieHelper();
        }
    }

    public Map<String, Class<? extends Activity>> getPaytmActivityMap() {
        return new HashMap<String, Class<? extends Activity>>() {
            {
                put("authActivity", AJRAuthActivity.class);
                put("mainActivity", AJRMainActivity.class);
                put("paymentActivity", AJRRechargePaymentActivity.class);
                put("AJRYoutubeVideoPlay", AJRYoutubeVideoPlay.class);
                put("AJRRechargePaymentActivity", AJRRechargePaymentActivity.class);
                put("ordersummary", AJROrderSummaryActivity.class);
                try {
                    put("AJRCSTOrderIssues", Class.forName("net.one97.paytm.cst.activity.AJRCSTOrderIssues"));
                } catch (ClassNotFoundException e2) {
                    q.b(e2.getMessage());
                }
            }
        };
    }

    public void loadpdpBrand(Context context, String str, IJRDataModel iJRDataModel, String str2, int i2, ArrayList<? extends CJRItem> arrayList, boolean z, String str3, IJRPaytmDataModel iJRPaytmDataModel, String str4, String str5, String str6, String str7, String str8) {
        j.a(context, str, iJRDataModel, str2, i2, arrayList, z, str3, str4, str5, str6, str7, str8);
    }

    public void sendGTMOrderSummaryTag(Context context, CJROrderSummary cJROrderSummary, CJRParcelTrackingInfo cJRParcelTrackingInfo, String str, boolean z, String str2, String str3, long j) {
        a.a(context, cJROrderSummary, cJRParcelTrackingInfo, str, z, str2, str3, j);
    }

    public String getAJRShoppingCartActivityClass() {
        return net.one97.paytm.marketplace.a.j().getName();
    }

    public void getWalletTokenMovies(String str, Activity activity, com.paytm.network.listener.b bVar) {
        t.a(activity, bVar, a.c.MOVIES);
    }

    public void showCustomAlert(Activity activity, String str, String str2) {
        net.one97.paytm.wallet.utility.a.a(activity, str, str2);
    }

    public boolean containsError(CJRRechargeCart cJRRechargeCart, Context context) {
        return l.a(cJRRechargeCart, context);
    }

    public View getPostTxnCashBackHelperInstance(Context context, androidx.fragment.app.j jVar, String str) {
        e a2 = net.one97.paytm.deeplink.e.a() ? net.one97.paytm.cashback.posttxn.c.a() : null;
        if (a2 == null) {
            return new View(context);
        }
        a2.a((AppCompatActivity) context);
        f.a aVar = new f.a();
        aVar.f49546b = str;
        a2.a(aVar.a(), (net.one97.paytm.cashback.posttxn.a) null);
        return new View(context);
    }

    public void showSessionTimeoutAlert(Activity activity, String str, Bundle bundle, Exception exc) {
        r.a(activity, str, bundle);
    }

    public void loadPage(Activity activity, String str, IJRDataModel iJRDataModel, String str2, int i2, ArrayList<? extends CJRItem> arrayList, boolean z, String str3) {
        j.a((Context) activity, str, iJRDataModel, str2, i2, arrayList, z, str3, (net.one97.paytm.c) null);
    }

    public String postRequestBodyForV2(Context context, String str, String str2) {
        return l.a(context, str, str2);
    }

    public String createRequestBodyForV2(Context context, String str, String str2, CJRSelectCityModel cJRSelectCityModel) {
        return r.a(context, str, str2, cJRSelectCityModel);
    }

    public boolean getClassInstance(Context context) {
        return context instanceof AJROrderSummaryActivity;
    }

    public boolean checkErrorCode(Context context, NetworkCustomError networkCustomError) {
        return r.a(context, networkCustomError);
    }

    public Map<String, String> getConstantMap() {
        return new HashMap<String, String>() {
            {
                put("BUILD_TYPE", "release");
                put("IS_DEBUG", "false");
                put("APPLICATION_ID", "net.one97.paytm");
            }
        };
    }

    public void sendNewCustomGTMEvents(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        net.one97.paytm.j.a.a(context, str, str2, str3, str4, str5, str6, str7);
    }

    public ContextWrapper getBaseContext(Context context) {
        return net.one97.paytm.locale.b.e.a(context);
    }

    public void sendOpenScreenWithDeviceInfo(String str, String str2, Context context) {
        net.one97.paytm.j.a.b(str, str2, context);
    }

    public void sendOpenScreenEvent(Context context, String str) {
        net.one97.paytm.j.a.b(context, str);
    }

    public void sendOrderSummaryPGEvent(Context context, CJROrderSummary cJROrderSummary) {
        net.one97.paytm.j.a.a(context, cJROrderSummary);
    }

    public void sendGTMThankYouScreen(Context context, boolean z, CJROrderSummary cJROrderSummary, String str, String str2) {
        net.one97.paytm.j.a.a(context, z, cJROrderSummary, str, str2);
    }

    public void sendPaytmAssistGAEvents(CJROrderSummary cJROrderSummary, y yVar, Context context) {
        net.one97.paytm.j.a.a(cJROrderSummary, yVar, context);
    }

    public void sendPromotionImpression(CJRHomePageItem cJRHomePageItem, Context context, int i2, String str) {
        net.one97.paytm.j.a.a(cJRHomePageItem, context, i2, str);
    }

    public void sendMoviePromotionImpressionClick(CJRHomePageItem cJRHomePageItem, Context context, int i2, String str, String str2) {
        net.one97.paytm.j.a.b(cJRHomePageItem, context, i2, str, str2);
    }

    public void sendPromotionClick(CJRHomePageItem cJRHomePageItem, Context context, int i2, String str, String str2) {
        net.one97.paytm.j.a.e(cJRHomePageItem, context, i2, str2);
    }

    public void sendMoviePromotionImpression(CJRHomePageItem cJRHomePageItem, Context context, int i2, String str, String str2) {
        net.one97.paytm.j.a.a(cJRHomePageItem, context, i2, str, str2);
    }

    public void sendDeepLinkOpen(String str, CJRHomePageItem cJRHomePageItem, Context context) {
        net.one97.paytm.j.a.a(str, cJRHomePageItem, context);
    }

    public void sendCustomEventWithMap(String str, Map<String, Object> map, Context context) {
        net.one97.paytm.j.a.b(str, map, context);
    }

    public void sendCustomEventWithMultipleLabel(Context context, String str, String str2, ArrayList<String> arrayList, String str3, String str4, String str5) {
        net.one97.paytm.j.a.a(context, str, str2, arrayList, str3, str4, str5);
    }

    public Context getAppContext() {
        return CJRJarvisApplication.getAppContext();
    }

    public void handlePlayServicesError(Activity activity) {
        net.one97.paytm.common.utility.e eVar = net.one97.paytm.common.utility.e.f49603a;
        net.one97.paytm.common.utility.e.a(activity);
    }

    public String getSSOToken(Context context) {
        return t.b(context);
    }

    public String getPgToken(CJRPGTokenList cJRPGTokenList) {
        return t.a(cJRPGTokenList);
    }

    public <T> void sendEventToPaytmAnalytics(T t, String str, boolean z) {
        net.one97.paytm.j.a.b(t, str);
    }

    public void handleError(Activity activity, Exception exc, String str, Bundle bundle, boolean z) {
        r.a(activity, exc, str, bundle);
    }

    public boolean reportError(Context context, Exception exc, String str) {
        return r.a(context, exc, str);
    }

    public CJRError getDataDisplayError(Context context, String str) {
        return r.a(context, str);
    }

    public String getContainerInstanceId(CJRHomePageLayoutV2 cJRHomePageLayoutV2) {
        return l.a(cJRHomePageLayoutV2);
    }

    public boolean getPicassoIsInMemory() {
        return CJRJarvisApplication.f();
    }

    public String getCustomerId(Context context) {
        return com.paytm.utility.a.q(context) != null ? com.paytm.utility.a.a(context) : "";
    }

    public CJRError getError(Context context, Exception exc) {
        return r.b(context, exc);
    }

    public void fetchPaymentOptions(Activity activity, CJRRechargePayment cJRRechargePayment, ProgressDialog progressDialog, CJRRechargeCart cJRRechargeCart) {
        final ProgressDialog progressDialog2 = progressDialog;
        final Activity activity2 = activity;
        final CJRRechargePayment cJRRechargePayment2 = cJRRechargePayment;
        final CJRRechargeCart cJRRechargeCart2 = cJRRechargeCart;
        t.a((Context) activity, cJRRechargePayment, (FetchPayOptionsListener) new FetchPayOptionsListener() {
            public void onPaymentOptionsReceived(CJPayMethodResponse cJPayMethodResponse) {
            }

            public void onRequestStart() {
            }

            public void onVpaReceived(VpaFetch vpaFetch) {
            }

            public void onPaymentOptionsError() {
                MovieHelper.this.removeProgressDialog(progressDialog2, activity2);
                MovieHelper.this.moveToPGActivity(activity2, cJRRechargePayment2, cJRRechargeCart2);
            }

            public void onRequestEnd(CJPayMethodResponse cJPayMethodResponse, VpaFetch vpaFetch) {
                MovieHelper.this.removeProgressDialog(progressDialog2, activity2);
                PaytmSDK.setResponse(cJPayMethodResponse, vpaFetch);
                MovieHelper.this.moveToPGActivity(activity2, cJRRechargePayment2, cJRRechargeCart2);
            }
        });
    }

    public void fetchPaymentOptions(final Activity activity, final CJRRechargePayment cJRRechargePayment, final ProgressDialog progressDialog, CJRMovieCart cJRMovieCart) {
        removeProgressDialog(progressDialog, activity);
        t.a((Context) activity, cJRRechargePayment, (FetchPayOptionsListener) new FetchPayOptionsListener() {
            public void onPaymentOptionsReceived(CJPayMethodResponse cJPayMethodResponse) {
            }

            public void onRequestStart() {
            }

            public void onVpaReceived(VpaFetch vpaFetch) {
            }

            public void onPaymentOptionsError() {
                MovieHelper.this.removeProgressDialog(progressDialog, activity);
                MovieHelper.this.moveToPGActivity(activity, cJRRechargePayment, (CJRRechargeCart) null);
            }

            public void onRequestEnd(CJPayMethodResponse cJPayMethodResponse, VpaFetch vpaFetch) {
                MovieHelper.this.removeProgressDialog(progressDialog, activity);
                PaytmSDK.setResponse(cJPayMethodResponse, vpaFetch);
                MovieHelper.this.moveToPGActivity(activity, cJRRechargePayment, (CJRRechargeCart) null);
            }
        });
    }

    public void fetchPaymentOptions(Activity activity, ProgressDialog progressDialog, CJRMovieCart cJRMovieCart, PaytmSDKRequestClient.OtherPayOptionsListener otherPayOptionsListener, boolean z, g gVar) {
        if (gVar != null) {
            gVar.e();
        } else {
            removeProgressDialog(progressDialog, activity);
        }
        if (otherPayOptionsListener != null) {
            otherPayOptionsListener.setFetchPayOptionsResponse(cJRMovieCart.getCart().getInstruments(), cJRMovieCart.getCart().paymentInfo.txnAmount.f75143a);
            return;
        }
        PaytmSDK.setResponse(cJRMovieCart.getCart().getInstruments(), (VpaFetch) null);
        moveToPGActivity(activity, cJRMovieCart, z);
    }

    public void sendUAEventWithValue(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(i.f52406a);
        sb.append(str);
        i.a();
    }

    public CJRHomePageItem getDeepLinkDataItem(String str, Context context) {
        return ac.a(context, str);
    }

    public void launchDeeplink(String str, Context context, String str2) {
        l.a(str, context, (String) null);
    }

    public void sendTransactionBetaOutForWallet(Context context, String str, String str2, String str3, String str4) {
        ar.a("movies");
    }

    public boolean isMainActivityInstance(Activity activity) {
        return activity instanceof AJRMainActivity;
    }

    public void sendAppsFlyerPurchaseEvent(String str, String str2, String str3, String str4, String str5, ArrayList<String> arrayList, String str6, String str7, String str8) {
        v.f69802a.a(CJRJarvisApplication.getAppContext(), str, str2, str3, str4, str5, arrayList, str6, str7, str8);
    }

    /* access modifiers changed from: private */
    public void removeProgressDialog(ProgressDialog progressDialog, Activity activity) {
        if (progressDialog != null && progressDialog.isShowing() && activity != null && !activity.isFinishing()) {
            progressDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public void moveToPGActivity(Activity activity, CJRRechargePayment cJRRechargePayment, CJRRechargeCart cJRRechargeCart) {
        Intent intent = new Intent(activity, b.f75032a.f75033b.getPaytmActivityMap().get("paymentActivity"));
        if (!TextUtils.isEmpty(cJRRechargePayment.getmTxnToken())) {
            intent.putExtra("txnToken", cJRRechargePayment.getmTxnToken());
            intent.putExtra("mid", cJRRechargePayment.getMID());
            intent.putExtra("orderid", cJRRechargePayment.getOrderId());
            intent.putExtra("nativeSdkEnabled", true);
            intent.putExtra("price", cJRRechargePayment.getTxnAmount());
        } else {
            intent.putExtra("nativeSdkEnabled", false);
        }
        intent.putExtra(UpiConstants.FROM, "MoviesPage");
        intent.putExtra("is_movie_ticket", true);
        intent.putExtra(SDKConstants.PAYMENT_INFO, cJRRechargePayment);
        activity.startActivityForResult(intent, 4524);
    }

    private void moveToPGActivity(Activity activity, CJRMovieCart cJRMovieCart, boolean z) {
        Intent intent = new Intent(activity, b.f75032a.f75033b.getPaytmActivityMap().get("paymentActivity"));
        intent.putExtra("merchant_id", cJRMovieCart.getCart().paymentInfo.mid);
        intent.putExtra("nativeSdkEnabled", true);
        intent.putExtra("price", Double.toString(cJRMovieCart.getCart().paymentInfo.txnAmount.f75143a));
        if (z) {
            intent.putExtra(SDKConstants.IS_BANK_OFFER, true);
        }
        intent.putExtra(UpiConstants.FROM, "MoviesPage");
        intent.putExtra("is_movie_ticket", true);
        activity.startActivityForResult(intent, 4524);
    }

    public void openCSTscreen(Activity activity, Bundle bundle, m mVar) {
        mVar.show();
        d.a((Context) activity, bundle, mVar);
    }

    public void openPromoScreen(String str, Context context, double d2, String str2, VerifyPromoCallbackListener verifyPromoCallbackListener, OnPromoActivityDestroyListener onPromoActivityDestroyListener) {
        NativeSdkPromoHelper nativeSdkPromoHelper = new NativeSdkPromoHelper(str, getSSOToken(context), "movie");
        nativeSdkPromoHelper.startPromoSearchActivity(context, Double.valueOf(d2), str2, verifyPromoCallbackListener);
        nativeSdkPromoHelper.setOnPromoActivityDestroyListener(onPromoActivityDestroyListener);
    }

    public void openPromoSearchActivityWithoutData(String str, Context context, double d2, Request request, VerifyPromoCallbackListener verifyPromoCallbackListener, OnPromoActivityDestroyListener onPromoActivityDestroyListener) {
        NativeSdkPromoHelper nativeSdkPromoHelper = new NativeSdkPromoHelper(str, getSSOToken(context), "movie");
        nativeSdkPromoHelper.startPromoSearchActivityWithoutData(context, Double.valueOf(d2), request, verifyPromoCallbackListener);
        nativeSdkPromoHelper.setOnPromoActivityDestroyListener(onPromoActivityDestroyListener);
    }

    public void openPromoPayOptionsBottomSheet(String str, Context context, androidx.fragment.app.j jVar, double d2, CJPayMethodResponse cJPayMethodResponse, VerifyPromoCallbackListener verifyPromoCallbackListener, OnPromoActivityDestroyListener onPromoActivityDestroyListener, PaytmSDKRequestClient.VerifyResponseData verifyResponseData) {
        Context context2 = context;
        String str2 = str;
        NativeSdkPromoHelper nativeSdkPromoHelper = new NativeSdkPromoHelper(str, getSSOToken(context), "movie");
        nativeSdkPromoHelper.openPromoPayOptionsBottomSheet(jVar, d2, cJPayMethodResponse, verifyResponseData, verifyPromoCallbackListener);
        nativeSdkPromoHelper.setOnPromoActivityDestroyListener(onPromoActivityDestroyListener);
    }

    public String getStringFromGTM(String str, String str2) {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(str, str2);
    }

    public int getIntFromGTM(String str, int i2) {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(str, i2);
    }

    public void sendEnhancedEcommerceEvent(String str, Map<String, Object> map, Context context) {
        net.one97.paytm.j.a.a(str, map);
    }

    public void openH5(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("pullRefresh", false);
        bundle.putBoolean("canPullDown", false);
        bundle.putString("buildType", k.c());
        bundle.putString("jsVersion", EventUtility.getJsVersion());
        bundle.putString("fixVersion", EventUtility.getFixVersion());
        u a2 = u.a();
        net.one97.paytm.j.c.a();
        a2.a(EventsModuleManager.MODULE_NAME, net.one97.paytm.j.c.a(EventsH5Constant.EVENTS_UNIQUE_APP_ID, (String) null), str, bundle, (String) null, context);
    }

    public View onTransactionComplete(final SFWidget sFWidget, Context context, String str, net.one97.paytm.utils.b.a aVar) {
        e a2;
        if (!net.one97.paytm.deeplink.e.a() || (a2 = net.one97.paytm.cashback.posttxn.c.a()) == null || !a2.a(aVar.getId(), 0)) {
            return null;
        }
        a2.a((AppCompatActivity) context);
        f.a aVar2 = new f.a();
        aVar2.f49546b = str;
        aVar2.f49550f = a.c.MOVIES.name();
        a2.a(aVar2.a(), (net.one97.paytm.cashback.posttxn.a) new net.one97.paytm.cashback.posttxn.a() {
            public void onAnimationEnd(String str) {
                ((IStaticWidget) sFWidget).AnimateView(str);
            }

            public Point getFloatingWidgetPos(String str) {
                ((IStaticWidget) sFWidget).getViewPoint(str);
                return null;
            }
        });
        return null;
    }

    public void makeNPSTrackingApiCall(Context context, int i2, String str, String str2, ArrayList<String> arrayList, com.paytm.network.listener.b bVar) {
        net.one97.paytm.j.c.a();
        String a2 = net.one97.paytm.j.c.a("npsFeedbackUrl", (String) null);
        if (URLUtil.isValidUrl(a2)) {
            String b2 = com.paytm.utility.b.b(context, a2);
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Payload.RESPONSE, i2);
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("orderid", str);
                }
                jSONObject.put("category", str2);
                jSONObject.put("items", new JSONArray(arrayList));
                jSONObject.put("utm_source", AppManagerUtil.EXTEND_PREFIX_DEFAULT);
            } catch (JSONException e2) {
                q.b(e2.getMessage());
            }
            if (com.paytm.utility.a.m(context)) {
                com.paytm.network.b bVar2 = new com.paytm.network.b();
                bVar2.f42877a = context;
                bVar2.f42878b = a.c.HOME;
                bVar2.f42879c = a.C0715a.POST;
                bVar2.n = a.b.SILENT;
                bVar2.o = context.getClass().getSimpleName();
                bVar2.f42880d = b2;
                bVar2.f42882f = hashMap;
                bVar2.f42884h = jSONObject.toString();
                bVar2.f42885i = new CJRNpsTrackingResponse();
                bVar2.j = bVar;
                bVar2.l().a();
            }
        }
    }

    public void signOut(Activity activity, boolean z, VolleyError volleyError) {
        try {
            net.one97.paytm.auth.b.b.a(activity, false);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    public void crashlyticsLogs(String str) {
        if (str != null) {
            com.google.firebase.crashlytics.c.a().a(str);
        }
    }
}
