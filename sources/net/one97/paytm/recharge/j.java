package net.one97.paytm.recharge;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.listeners.IGAEnableListener;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import com.paytmmall.clpartifact.utils.SFInterface;
import com.paytmmall.clpartifact.view.viewmodel.HomeResponse;
import com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget;
import com.paytmmall.clpartifact.widgets.blueprints.SFWidget;
import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.ab;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.a.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.cashback.posttxn.f;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderList;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageV2;
import net.one97.paytm.deeplink.h;
import net.one97.paytm.finance.JarvisFinanceHelper;
import net.one97.paytm.landingpage.activity.HomeActionBarBaseActivity;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.NativeSdkPromoHelper;
import net.one97.paytm.nativesdk.Utils.Server;
import net.one97.paytm.nativesdk.app.VerifyPromoCallbackListener;
import net.one97.paytm.nativesdk.orflow.interfaces.OnPromoActivityDestroyListener;
import net.one97.paytm.nativesdk.orflow.promo.PromoHelper;
import net.one97.paytm.nativesdk.orflow.promo.model.Request;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.VERTICAL;
import net.one97.paytm.utils.ac;
import net.one97.paytm.utils.au;
import net.one97.paytm.utils.ba;
import net.one97.paytm.utils.l;
import net.one97.paytm.utils.r;
import net.one97.paytm.utils.t;
import net.one97.paytm.wallet.activity.AJRConfirmIFSCActivity;

public final class j implements net.one97.paytm.recharge.di.e {

    /* renamed from: a  reason: collision with root package name */
    private final String f62775a = "pb_passcode_rsa_key";

    /* renamed from: b  reason: collision with root package name */
    private final Context f62776b;

    public final void openHoHoPaymentSuccessActivity(Activity activity, String str) {
        k.c(activity, "activity");
    }

    public final void updateStoreFrontResponseData(Activity activity, RecyclerView.a<RecyclerView.v> aVar, net.one97.paytm.recharge.ordersummary.f.d dVar, CJRHomePageV2 cJRHomePageV2) {
        k.c(activity, "activity");
        k.c(aVar, "adapter");
        k.c(dVar, "dataPopulatedListener");
        k.c(cJRHomePageV2, "newResponse");
    }

    public j(Context context) {
        k.c(context, "context");
        this.f62776b = context;
    }

    public final void openIFSCCodeActivity(Context context, int i2) {
        k.c(context, "context");
        if (context instanceof Activity) {
            Intent intent = new Intent(context, AJRConfirmIFSCActivity.class);
            intent.putExtra("show_ifsc_new_design", true);
            ((Activity) context).startActivityForResult(intent, i2);
        }
    }

    public final String getBankAuthPasscodeRSA() {
        net.one97.paytm.j.c.a();
        String a2 = net.one97.paytm.j.c.a(this.f62775a, (String) null);
        k.a((Object) a2, "GTMLoader.getInstance().…ring(PB_PASSCODE_RSA_KEY)");
        return a2;
    }

    public final void setRechargeHomePageTabs(CJRHomePageV2 cJRHomePageV2) {
        k.c(cJRHomePageV2, "rechargeHomePageTabs");
        Context appContext = CJRJarvisApplication.getAppContext();
        if (appContext != null) {
            ((CJRJarvisApplication) appContext).f49008d = cJRHomePageV2;
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.app.CJRJarvisApplication");
    }

    public final CJRHomePageV2 getRechargeHomePageTabs() {
        Context appContext = CJRJarvisApplication.getAppContext();
        if (appContext != null) {
            return ((CJRJarvisApplication) appContext).f49008d;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.app.CJRJarvisApplication");
    }

    public final HashMap<String, String> getCategoryIdUrlType() {
        HashMap<String, String> hashMap = HomeActionBarBaseActivity.r;
        k.a((Object) hashMap, "HomeActionBarBaseActivity.mCategoryIdUrlType");
        return hashMap;
    }

    public final Context getApplicationContext() {
        return this.f62776b;
    }

    public final ContextWrapper getWrapedContextWithRestring(Context context) {
        k.c(context, "context");
        ContextThemeWrapper a2 = net.one97.paytm.locale.b.e.a(context);
        k.a((Object) a2, "Restring.wrapContext(context)");
        return a2;
    }

    public final void dropBreadCrumb(String str, String str2) {
        k.c(str, "tag");
        k.c(str2, "label");
        l.a(str, str2);
    }

    public final boolean getPicassoIsInMemory() {
        return CJRJarvisApplication.f();
    }

    public final CJRFrequentOrderList getFrequentOrderList() {
        Context appContext = CJRJarvisApplication.getAppContext();
        if (appContext != null) {
            return ((CJRJarvisApplication) appContext).f49005a;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.app.CJRJarvisApplication");
    }

    public final void setFrequentOrderList(CJRFrequentOrderList cJRFrequentOrderList) {
        k.c(cJRFrequentOrderList, "frequentOrderList");
        Context appContext = CJRJarvisApplication.getAppContext();
        if (appContext != null) {
            ((CJRJarvisApplication) appContext).f49005a = cJRFrequentOrderList;
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.app.CJRJarvisApplication");
    }

    public final String getSSOToken(Context context) {
        k.c(context, "context");
        return t.b(context);
    }

    public final void signOut(Activity activity, boolean z, NetworkCustomError networkCustomError) {
        k.c(activity, "mSelectCardActivity");
        net.one97.paytm.auth.b.b.a(activity);
    }

    public final String getPgToken(CJRPGTokenList cJRPGTokenList) {
        return t.a(cJRPGTokenList);
    }

    public final String getWalletSSOToken(Context context) {
        k.c(context, "context");
        return t.c(context);
    }

    public final long getWalletTokenExpireTime(Context context) {
        k.c(context, "context");
        return t.d(context);
    }

    public final String getResourceId(Context context) {
        k.c(context, "context");
        return t.i(context);
    }

    public final void loadPage(Context context, String str, IJRDataModel iJRDataModel, String str2, int i2, ArrayList<? extends CJRItem> arrayList, boolean z, String str3) {
        k.c(context, "context");
        k.c(iJRDataModel, "dataModel");
        net.one97.paytm.utils.j.a(context, str, iJRDataModel, str2, i2, arrayList, z, str3, (net.one97.paytm.c) null);
    }

    public final void updateRecentHistory() {
        net.one97.paytm.quickpay.d.a.a().f();
    }

    public final HashMap<String, String> getCategoryIdUrl() {
        HashMap<String, String> hashMap = HomeActionBarBaseActivity.q;
        k.a((Object) hashMap, "HomeActionBarBaseActivity.mCategoryIdUrl");
        return hashMap;
    }

    public final View getPostTxnCashBackView(FragmentActivity fragmentActivity, Integer num, String str, int i2, String str2, String str3, SFWidget sFWidget) {
        int i3;
        k.c(fragmentActivity, "context");
        k.c(str, "verticalId");
        k.c(str3, "transactionType");
        net.one97.paytm.cashback.posttxn.e a2 = net.one97.paytm.deeplink.e.a() ? net.one97.paytm.cashback.posttxn.c.a() : null;
        if (a2 != null) {
            if (num == null) {
                i3 = 0;
            } else {
                i3 = num.intValue();
            }
            if (a2.a(i3, i2) && (fragmentActivity instanceof AppCompatActivity)) {
                AppCompatActivity appCompatActivity = (AppCompatActivity) fragmentActivity;
                Window window = appCompatActivity.getWindow();
                k.a((Object) window, "context.window");
                View findViewById = window.getDecorView().findViewById(16908290);
                if (!(findViewById instanceof View)) {
                    findViewById = null;
                }
                if (findViewById instanceof ViewGroup) {
                    a2.a(appCompatActivity);
                    f.a aVar = new f.a();
                    if (str2 == null) {
                        k.a();
                    }
                    aVar.f49546b = str2;
                    aVar.f49550f = str;
                    aVar.f49551g = String.valueOf(i2);
                    aVar.f49549e = str3;
                    a2.a(aVar.a(), (net.one97.paytm.cashback.posttxn.a) new b(sFWidget));
                }
            }
        }
        return null;
    }

    public static final class b implements net.one97.paytm.cashback.posttxn.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SFWidget f62777a;

        b(SFWidget sFWidget) {
            this.f62777a = sFWidget;
        }

        public final Point getFloatingWidgetPos(String str) {
            SFWidget sFWidget = this.f62777a;
            if (!(sFWidget instanceof IStaticWidget)) {
                return new Point();
            }
            IStaticWidget iStaticWidget = (IStaticWidget) sFWidget;
            if (str == null) {
                str = "";
            }
            Point viewPoint = iStaticWidget.getViewPoint(str);
            k.a((Object) viewPoint, "floatingBarWidgetView.getViewPoint(identifier?:\"\")");
            return viewPoint;
        }

        public final void onAnimationEnd(String str) {
            SFWidget sFWidget = this.f62777a;
            if (sFWidget instanceof IStaticWidget) {
                IStaticWidget iStaticWidget = (IStaticWidget) sFWidget;
                if (str == null) {
                    str = "";
                }
                iStaticWidget.AnimateView(str);
            }
        }
    }

    public final String getCartID(Context context) {
        k.c(context, "context");
        return t.g(context);
    }

    public final Map<String, String> getHeader(Context context) {
        k.c(context, "context");
        return t.e(context);
    }

    public final Fragment getFJRGoldSubscriptionListFragment() {
        Fragment fJRGoldSubscriptionListFragment = JarvisFinanceHelper.getInstance().getFinanceAccessProviderListener().getFJRGoldSubscriptionListFragment();
        k.a((Object) fJRGoldSubscriptionListFragment, "JarvisFinanceHelper.getI…ubscriptionListFragment()");
        return fJRGoldSubscriptionListFragment;
    }

    public final void checkDeepLinking(Context context, String str) {
        k.c(context, "context");
        k.c(str, "deeplink");
        net.one97.paytm.payments.d.a.a(context, str);
    }

    public final CJRHomePageItem getDeepLinkDataItem(Context context, String str) {
        k.c(context, "context");
        k.c(str, "url");
        CJRHomePageItem a2 = ac.a(context, str);
        k.a((Object) a2, "DeepLinkUtility.getDeepLinkDataItem(context, url)");
        return a2;
    }

    public final Intent getIntent(String str, Context context, CJRHomePageItem cJRHomePageItem) {
        k.c(str, "url");
        k.c(context, "context");
        k.c(cJRHomePageItem, "item");
        return new Intent();
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f62781a;

        e(Context context) {
            this.f62781a = context;
        }

        public final void onClick(View view) {
            Context context = this.f62781a;
            if (context != null) {
                l.a((Activity) context, view);
                return;
            }
            throw new u("null cannot be cast to non-null type android.app.Activity");
        }
    }

    public final void setupBottomTabs(Context context, LinearLayout linearLayout, View.OnClickListener onClickListener) {
        k.c(context, "context");
        k.c(linearLayout, "bottomTabsLinearLayout");
        k.c(onClickListener, "listener");
        try {
            new e(context);
            l.a((View) linearLayout);
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder("BottomNavigation at OrderSummary, results in Crash: ");
            String message = e2.getMessage();
            if (message == null) {
                message = "";
            }
            sb.append(message);
            com.google.firebase.crashlytics.c.a().a(sb.toString());
        }
    }

    public final void startBCLLSuccessBookingActivity(Activity activity, Intent intent, boolean z) {
        k.c(activity, "activity");
        k.c(intent, "resultIntent");
        ba.a(activity, intent, z);
    }

    public final void clearRiskData() {
        net.one97.paytm.f.b.a().c();
    }

    public final void setRiskExtendedInfo(Context context, String str, String str2, boolean z, String str3) {
        k.c(context, "context");
        net.one97.paytm.f.b.a().a(context, str, str2, z, str3, com.paytm.utility.a.g(context), com.paytm.utility.a.h(context));
    }

    public final String getRistJsonData() {
        net.one97.paytm.f.b a2 = net.one97.paytm.f.b.a();
        k.a((Object) a2, "RiskInformationController.getInstance()");
        String d2 = a2.d();
        k.a((Object) d2, "RiskInformationControlle…().jsonOfRiskExtendedInfo");
        return d2;
    }

    public final void handleError(Activity activity, Exception exc, String str, Bundle bundle, boolean z) {
        if (activity != null && exc != null) {
            r.a(activity, exc, str, bundle);
        }
    }

    public final boolean checkErrorCode(Context context, Exception exc) {
        k.c(exc, "inError1");
        return r.a(context, exc);
    }

    public final boolean reportError(Context context, NetworkCustomError networkCustomError, String str) {
        k.c(networkCustomError, "error");
        k.c(str, "mailId");
        return r.a(context, (Exception) networkCustomError, str);
    }

    public final void showSessionTimeoutAlert(Activity activity, String str, Bundle bundle, NetworkCustomError networkCustomError) {
        r.a(activity, str, bundle, false, true);
    }

    public final void showSessionTimeoutAlert(Activity activity, String str, Bundle bundle, NetworkCustomError networkCustomError, boolean z) {
        r.a(activity, str, bundle, z);
    }

    public final void showSessionTimeoutAlert(Activity activity, String str, Bundle bundle, NetworkCustomError networkCustomError, boolean z, boolean z2) {
        r.a(activity, str, bundle, z, z2);
    }

    public final void showSessionTimeoutAlert(Activity activity, Fragment fragment, String str, Bundle bundle, NetworkCustomError networkCustomError, boolean z, boolean z2) {
        k.c(fragment, "fragment");
        r.a(activity, fragment, str, bundle, (Exception) networkCustomError, z, z2);
    }

    public final void showSessionTimeoutAlert(Activity activity, Fragment fragment, String str, Bundle bundle, NetworkCustomError networkCustomError, boolean z, boolean z2, int i2) {
        k.c(fragment, "fragment");
        r.a(activity, fragment, str, bundle, networkCustomError, z, z2, i2);
    }

    public final void showSessionTimeoutAlert(Activity activity, String str, Bundle bundle, NetworkCustomError networkCustomError, boolean z, boolean z2, int i2) {
        r.a(activity, str, bundle, (Exception) networkCustomError, z, z2, i2);
    }

    public final String postRequestBodyForV2(Context context, String str, String str2) {
        k.c(str, "prevPage");
        k.c(str2, "currentPage");
        return r.a(context, str, str2);
    }

    public final void startHelpAndSupport(Context context) {
        k.c(context, "mContext");
        net.one97.paytm.payments.d.a.a(this.f62776b, "paytmmp://contactus");
    }

    static final class a extends kotlin.g.b.l implements kotlin.g.a.a<x> {
        final /* synthetic */ net.one97.paytm.recharge.ordersummary.f.d $dataPopulatedListener;
        final /* synthetic */ CJRHomePageV2 $response;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(CJRHomePageV2 cJRHomePageV2, net.one97.paytm.recharge.ordersummary.f.d dVar) {
            super(0);
            this.$response = cJRHomePageV2;
            this.$dataPopulatedListener = dVar;
        }

        public final void invoke() {
            HomeResponse homeResponse = (HomeResponse) new com.google.gson.f().a(new com.google.gsonhtcfix.f().a((Object) this.$response), HomeResponse.class);
            SFInterface sFInterface = SFInterface.INSTANCE;
            k.a((Object) homeResponse, "model");
            final SanitizedResponseModel sanitizedResponse$default = SFInterface.getSanitizedResponse$default(sFInterface, homeResponse, false, a.c.RECHARGES.name(), 0, (IGAEnableListener) null, 24, (Object) null);
            final x.e eVar = new x.e();
            eVar.element = new b(sanitizedResponse$default.getRvWidgets(), sanitizedResponse$default.getGaListener());
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), (CoroutineStart) null, new m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object>(this, (kotlin.d.d) null) {
                int label;
                private CoroutineScope p$;
                final /* synthetic */ a this$0;

                {
                    this.this$0 = r1;
                }

                public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                    k.c(dVar, "completion");
                    AnonymousClass1 r0 = 

                    public final RecyclerView.a<RecyclerView.v> getHomeFragmentWidgetAdapter(net.one97.paytm.recharge.ordersummary.f.a aVar, FragmentActivity fragmentActivity, CJRHomePageV2 cJRHomePageV2, String str, RecyclerView recyclerView, CJRItem cJRItem, View view, net.one97.paytm.recharge.ordersummary.f.d dVar, IGAHandlerListener iGAHandlerListener) {
                        k.c(aVar, "clickListener");
                        k.c(fragmentActivity, "activity");
                        k.c(cJRHomePageV2, Payload.RESPONSE);
                        k.c(str, "gaKey");
                        k.c(recyclerView, "fixedInfiniteGridHeader");
                        k.c(view, "infiniteTabBorder");
                        k.c(dVar, "dataPopulatedListener");
                        k.c(iGAHandlerListener, "gaHandlerListener");
                        com.paytm.utility.d.a.a(new a(cJRHomePageV2, dVar));
                        return null;
                    }

                    public final void getCstOrderIssueIntent(Context context, Bundle bundle) {
                        k.c(context, "context");
                        k.c(bundle, "bundle");
                        net.one97.paytm.deeplink.d.a(context, bundle);
                    }

                    public final void launchDeelink(Context context, String str, CJRHomePageItem cJRHomePageItem) {
                        k.c(context, "context");
                        k.c(str, "url");
                        k.c(cJRHomePageItem, "searchItem");
                        h.a aVar = h.f50349a;
                        h.a.a(context, str, (Bundle) null);
                    }

                    public final void getUpdatedCstOrderIssueIntent(Activity activity, Bundle bundle, net.one97.paytm.m mVar) {
                        k.c(bundle, "bundle");
                        if (activity != null) {
                            if (mVar != null) {
                                mVar.show();
                            }
                            net.one97.paytm.deeplink.d.a((Context) activity, bundle, mVar);
                        } else if (mVar != null) {
                            mVar.dismiss();
                        }
                    }

                    public final void sendEventToPaytmAnalytics(CJRRechargeErrorModel cJRRechargeErrorModel, Context context) {
                        String str;
                        k.c(cJRRechargeErrorModel, "error");
                        k.c(context, "context");
                        au.e eVar = new au.e();
                        VERTICAL verticalName = cJRRechargeErrorModel.getVerticalName();
                        if (verticalName == null || (str = verticalName.getValue()) == null) {
                            str = "rechargeAndUtilities";
                        }
                        eVar.l = str;
                        String errorCode = cJRRechargeErrorModel.getErrorCode();
                        eVar.p = errorCode != null ? Integer.parseInt(errorCode) : 0;
                        eVar.u = cJRRechargeErrorModel.getErrorMsg();
                        eVar.o = cJRRechargeErrorModel.getUrl();
                        eVar.t = String.valueOf(cJRRechargeErrorModel.getUserFacing());
                        eVar.m = cJRRechargeErrorModel.getScreenName();
                        eVar.A = cJRRechargeErrorModel.getCategoryId();
                        eVar.B = cJRRechargeErrorModel.getProductId();
                        y.a(new c(cJRRechargeErrorModel)).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new d(eVar, context));
                    }

                    static final class c<T> implements ab<T> {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ CJRRechargeErrorModel f62778a;

                        c(CJRRechargeErrorModel cJRRechargeErrorModel) {
                            this.f62778a = cJRRechargeErrorModel;
                        }

                        public final void subscribe(z<String> zVar) {
                            k.a((Object) zVar, "emitter");
                            if (!zVar.isDisposed()) {
                                try {
                                    zVar.onSuccess(new com.google.gsonhtcfix.f().a((Object) this.f62778a.getFlowName()));
                                } catch (Exception e2) {
                                    zVar.tryOnError(e2);
                                }
                            }
                        }
                    }

                    public static final class d implements aa<String> {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ au.e f62779a;

                        /* renamed from: b  reason: collision with root package name */
                        final /* synthetic */ Context f62780b;

                        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
                            k.c(cVar, "d");
                        }

                        d(au.e eVar, Context context) {
                            this.f62779a = eVar;
                            this.f62780b = context;
                        }

                        public final /* synthetic */ void onSuccess(Object obj) {
                            String str = (String) obj;
                            k.c(str, "t");
                            au.e eVar = this.f62779a;
                            eVar.n = str;
                            au.a(eVar, "error", this.f62780b);
                        }

                        public final void onError(Throwable th) {
                            k.c(th, "e");
                            au.a(this.f62779a, "error", this.f62780b);
                        }
                    }

                    public final String getStoreFrontAdApiBody(Context context) {
                        k.c(context, "context");
                        String a2 = r.a(context, "", "Recharge");
                        k.a((Object) a2, "CJRPaytmCommonUtility.po…UtilityConstant.RECHARGE)");
                        return a2;
                    }

                    public final void openPromoSelectionScreen(Context context, String str, double d2, String str2, String str3, VerifyPromoCallbackListener verifyPromoCallbackListener, OnPromoActivityDestroyListener onPromoActivityDestroyListener) {
                        Context context2 = context;
                        String str4 = str2;
                        VerifyPromoCallbackListener verifyPromoCallbackListener2 = verifyPromoCallbackListener;
                        OnPromoActivityDestroyListener onPromoActivityDestroyListener2 = onPromoActivityDestroyListener;
                        k.c(context, "context");
                        k.c(str4, "promoSearchApiResponse");
                        k.c(str3, "reqUrl");
                        k.c(verifyPromoCallbackListener2, "listener");
                        k.c(onPromoActivityDestroyListener2, "destroyListener");
                        PromoHelper.Configuration server = new PromoHelper.Configuration().setServer(p.a("release", SDKConstants.KEY_STAGING_API, true) ? Server.STAGING : Server.PRODUCTION);
                        String str5 = str == null ? "" : str;
                        String b2 = t.b(context);
                        k.a((Object) b2, "CJRServerUtility.getSSOToken(context)");
                        NativeSdkPromoHelper nativeSdkPromoHelper = new NativeSdkPromoHelper(str5, b2, "recharge", server);
                        if (TextUtils.isEmpty(str4)) {
                            Map hashMap = new HashMap();
                            String q = com.paytm.utility.a.q(context);
                            if (q == null) {
                                q = "";
                            }
                            hashMap.put(AppConstants.SSO_TOKEN, q);
                            nativeSdkPromoHelper.startPromoSearchActivityWithoutData(context, Double.valueOf(d2), new Request(0, str3, hashMap, (Map<String, String>) null, (String) null), verifyPromoCallbackListener2);
                        } else {
                            nativeSdkPromoHelper.startPromoSearchActivity(context, Double.valueOf(d2), str4, verifyPromoCallbackListener2);
                        }
                        nativeSdkPromoHelper.setOnPromoActivityDestroyListener(onPromoActivityDestroyListener2);
                    }

                    public final void fetchWalletToken(Context context, net.one97.paytm.recharge.common.e.b bVar) {
                        k.c(context, "activity");
                        k.c(bVar, "listener");
                        t.a(context, (com.paytm.network.listener.b) bVar, a.c.RECHARGES);
                    }

                    public final void openDetailPage(String str) {
                        k.c(str, "url");
                        net.one97.paytm.marketplace.a.c(str);
                    }
                }
