package net.one97.paytm.recharge.di.helper;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.widgets.blueprints.SFWidget;
import io.reactivex.rxjava3.j.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderList;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageV2;
import net.one97.paytm.m;
import net.one97.paytm.nativesdk.app.VerifyPromoCallbackListener;
import net.one97.paytm.nativesdk.orflow.interfaces.OnPromoActivityDestroyListener;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.e.b;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.di.e;
import net.one97.paytm.recharge.di.f;
import net.one97.paytm.recharge.ordersummary.f.a;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public final class CJRRechargeUtilities {
    public static final CJRRechargeUtilities INSTANCE = new CJRRechargeUtilities();
    private static c<Boolean> gtmContainerInitializationObservable;
    private static e mUtilites = f.f62644a.c();

    static {
        c<Boolean> a2 = c.a();
        k.a((Object) a2, "ReplaySubject.create()");
        gtmContainerInitializationObservable = a2;
    }

    private CJRRechargeUtilities() {
    }

    public final c<Boolean> getGtmContainerInitializationObservable() {
        return gtmContainerInitializationObservable;
    }

    public final void setGtmContainerInitializationObservable(c<Boolean> cVar) {
        k.c(cVar, "<set-?>");
        gtmContainerInitializationObservable = cVar;
    }

    public final Context getApplicationContext() {
        return mUtilites.getApplicationContext();
    }

    public final ContextWrapper getRestringValue(Context context) {
        k.c(context, "context");
        return mUtilites.getWrapedContextWithRestring(context);
    }

    public final void dropBreadCrumb(String str, String str2) {
        k.c(str, "simpleName");
        k.c(str2, "activity_created");
        mUtilites.dropBreadCrumb(str, str2);
    }

    public final boolean getPicassoIsInMemory() {
        return mUtilites.getPicassoIsInMemory();
    }

    public final CJRFrequentOrderList getFrequentOrderList() {
        return mUtilites.getFrequentOrderList();
    }

    public final void setFrequentOrderList(CJRFrequentOrderList cJRFrequentOrderList) {
        k.c(cJRFrequentOrderList, "frequentOrderList");
        mUtilites.setFrequentOrderList(cJRFrequentOrderList);
    }

    public final CJRHomePageV2 getRechargeHomePageTabs() {
        return mUtilites.getRechargeHomePageTabs();
    }

    public final void setRechargeHomePageTabs(CJRHomePageV2 cJRHomePageV2) {
        k.c(cJRHomePageV2, "rechargeHomePageTabs");
        mUtilites.setRechargeHomePageTabs(cJRHomePageV2);
    }

    public final String getSSOToken(Context context) {
        k.c(context, "context");
        String sSOToken = mUtilites.getSSOToken(context);
        return sSOToken == null ? "" : sSOToken;
    }

    public final void signOut(Activity activity, boolean z, NetworkCustomError networkCustomError) {
        k.c(activity, "mSelectCardActivity");
        mUtilites.signOut(activity, z, networkCustomError);
    }

    public final String getPgToken(CJRPGTokenList cJRPGTokenList) {
        return mUtilites.getPgToken(cJRPGTokenList);
    }

    public final String getWalletSSOToken(Context context) {
        k.c(context, "context");
        return mUtilites.getWalletSSOToken(context);
    }

    public final long getWalletTokenExpireTime(Context context) {
        k.c(context, "context");
        return mUtilites.getWalletTokenExpireTime(context);
    }

    public final String getResourceId(Context context) {
        k.c(context, "context");
        return mUtilites.getResourceId(context);
    }

    public final void getWalletToken(ai aiVar) {
        k.c(aiVar, "ijrPaytmDataModelListener");
        if (getApplicationContext() != null) {
            e eVar = mUtilites;
            Context applicationContext = getApplicationContext();
            if (applicationContext == null) {
                k.a();
            }
            eVar.fetchWalletToken(applicationContext, new b(aiVar, "wallet_token"));
        }
    }

    public final void loadPage(Context context, String str, IJRDataModel iJRDataModel, String str2, int i2, ArrayList<? extends CJRItem> arrayList, boolean z, String str3) {
        k.c(context, "context");
        k.c(iJRDataModel, "dataModel");
        mUtilites.loadPage(context, str, iJRDataModel, str2, i2, arrayList, z, str3);
    }

    public final void updateRecentHistory() {
        mUtilites.updateRecentHistory();
    }

    public final HashMap<String, String> getCategoryIdUrl() {
        return mUtilites.getCategoryIdUrl();
    }

    public final void setupBottomTabs(Context context, LinearLayout linearLayout, View.OnClickListener onClickListener) {
        k.c(context, "context");
        k.c(linearLayout, "bottomTabsLinearLayout");
        k.c(onClickListener, "listener");
        mUtilites.setupBottomTabs(context, linearLayout, onClickListener);
    }

    public final String getCartID(Context context) {
        k.c(context, "context");
        return mUtilites.getCartID(context);
    }

    public final Map<String, String> getHeader(Context context) {
        k.c(context, "context");
        return mUtilites.getHeader(context);
    }

    public final void openDetailPage(String str) {
        k.c(str, "url");
        mUtilites.openDetailPage(str);
    }

    public final View getPostTxnCashBackView(FragmentActivity fragmentActivity, Integer num, String str, int i2, String str2, String str3, SFWidget sFWidget) {
        k.c(fragmentActivity, "context");
        k.c(str, "verticalId");
        k.c(str3, "transactionType");
        return mUtilites.getPostTxnCashBackView(fragmentActivity, num, str, i2, str2, str3, sFWidget);
    }

    public final Fragment getFJRGoldSubscriptionListFragment() {
        return mUtilites.getFJRGoldSubscriptionListFragment();
    }

    public final void checkDeepLinking(Context context, String str) {
        k.c(context, "context");
        k.c(str, "deeplink");
        mUtilites.checkDeepLinking(context, str);
    }

    public final CJRHomePageItem getDeepLinkDataItem(Context context, String str) {
        k.c(context, "context");
        k.c(str, "url");
        return mUtilites.getDeepLinkDataItem(context, str);
    }

    public final Intent getIntent(String str, Context context, CJRHomePageItem cJRHomePageItem) {
        k.c(str, "url");
        k.c(context, "context");
        k.c(cJRHomePageItem, "item");
        return mUtilites.getIntent(str, context, cJRHomePageItem);
    }

    public final void startBCLLSuccessBookingActivity(Activity activity, Intent intent, boolean z) {
        k.c(activity, "activity");
        k.c(intent, "resultIntent");
        mUtilites.startBCLLSuccessBookingActivity(activity, intent, z);
    }

    public final void openHoHoPaymentSuccessActivity(Activity activity, String str) {
        k.c(activity, "activity");
        mUtilites.openHoHoPaymentSuccessActivity(activity, str);
    }

    public final HashMap<String, String> getCategoryIdUrlType() {
        return mUtilites.getCategoryIdUrlType();
    }

    public final void debugLog(String str) {
        k.c(str, "message");
        d dVar = d.f64967a;
        d.a(str);
    }

    public final void debugLogExceptions(Throwable th) {
        d dVar = d.f64967a;
        d.a(th);
    }

    public final void clearRiskData() {
        mUtilites.clearRiskData();
    }

    public final void setRiskExtendedInfo(Context context, String str, String str2, boolean z, String str3) {
        k.c(context, "context");
        mUtilites.setRiskExtendedInfo(context, str, str2, z, str3);
    }

    public final String getRiskJsonData() {
        return mUtilites.getRistJsonData();
    }

    public final void handleError(Activity activity, Exception exc, String str, Bundle bundle, boolean z) {
        mUtilites.handleError(activity, exc, str, bundle, z);
    }

    public final boolean checkErrorCode(String str, Context context, Exception exc, Object obj) {
        k.c(exc, "error");
        boolean checkErrorCode = mUtilites.checkErrorCode(context, exc);
        if (checkErrorCode && (obj instanceof CJRRechargeErrorModel)) {
            az azVar = az.f61525a;
            az.a((CJRRechargeErrorModel) obj);
        }
        return checkErrorCode;
    }

    public final boolean reportError(Context context, NetworkCustomError networkCustomError, String str) {
        k.c(networkCustomError, "error");
        k.c(str, "mailId");
        return mUtilites.reportError(context, networkCustomError, str);
    }

    public final void showSessionTimeoutAlert(Activity activity, String str, Bundle bundle, NetworkCustomError networkCustomError) {
        mUtilites.showSessionTimeoutAlert(activity, str, bundle, networkCustomError);
    }

    public final void showSessionTimeoutAlert(Activity activity, String str, Bundle bundle, NetworkCustomError networkCustomError, boolean z) {
        mUtilites.showSessionTimeoutAlert(activity, str, bundle, networkCustomError, z);
    }

    public final void showSessionTimeoutAlert(Activity activity, String str, Bundle bundle, NetworkCustomError networkCustomError, boolean z, boolean z2) {
        k.c(networkCustomError, "error");
        mUtilites.showSessionTimeoutAlert(activity, str, bundle, networkCustomError, z, z2);
    }

    public final void showSessionTimeoutAlert(Activity activity, String str, Bundle bundle, NetworkCustomError networkCustomError, boolean z, boolean z2, int i2) {
        k.c(networkCustomError, "error");
        mUtilites.showSessionTimeoutAlert(activity, str, bundle, networkCustomError, z, z2, i2);
    }

    public final void showSessionTimeoutAlert(Activity activity, Fragment fragment, String str, Bundle bundle, NetworkCustomError networkCustomError, boolean z, boolean z2) {
        k.c(fragment, "fragment");
        k.c(networkCustomError, "error");
        mUtilites.showSessionTimeoutAlert(activity, fragment, str, bundle, networkCustomError, z, z2);
    }

    public final void showSessionTimeoutAlert(Activity activity, Fragment fragment, String str, Bundle bundle, NetworkCustomError networkCustomError, boolean z, boolean z2, int i2) {
        k.c(fragment, "fragment");
        k.c(networkCustomError, "error");
        mUtilites.showSessionTimeoutAlert(activity, fragment, str, bundle, networkCustomError, z, z2, i2);
    }

    public final String postRequestBodyForV2(Context context, String str, String str2) {
        k.c(str, "prevPage");
        k.c(str2, "currentPage");
        return mUtilites.postRequestBodyForV2(context, str, str2);
    }

    public final void startHelpAndSupport(Context context) {
        k.c(context, "mContext");
        mUtilites.startHelpAndSupport(context);
    }

    public final RecyclerView.a<RecyclerView.v> getHomeFragmentWidgetAdapter(a aVar, FragmentActivity fragmentActivity, CJRHomePageV2 cJRHomePageV2, String str, RecyclerView recyclerView, CJRItem cJRItem, View view, net.one97.paytm.recharge.ordersummary.f.d dVar, IGAHandlerListener iGAHandlerListener) {
        k.c(aVar, "clickListener");
        k.c(fragmentActivity, "activity");
        k.c(cJRHomePageV2, Payload.RESPONSE);
        k.c(str, "GAKey");
        RecyclerView recyclerView2 = recyclerView;
        k.c(recyclerView2, "fixedInfiniteGridHeader");
        View view2 = view;
        k.c(view2, "infiniteTabBorder");
        net.one97.paytm.recharge.ordersummary.f.d dVar2 = dVar;
        k.c(dVar2, "dataPopulatedListener");
        IGAHandlerListener iGAHandlerListener2 = iGAHandlerListener;
        k.c(iGAHandlerListener2, "gaHandlerListener");
        return mUtilites.getHomeFragmentWidgetAdapter(aVar, fragmentActivity, cJRHomePageV2, str, recyclerView2, cJRItem, view2, dVar2, iGAHandlerListener2);
    }

    public final void updateStoreFrontResponseData(Activity activity, RecyclerView.a<RecyclerView.v> aVar, net.one97.paytm.recharge.ordersummary.f.d dVar, CJRHomePageV2 cJRHomePageV2) {
        k.c(activity, "context");
        k.c(aVar, "adapter");
        k.c(dVar, "dataPopulatedListener");
        k.c(cJRHomePageV2, "newResponse");
        mUtilites.updateStoreFrontResponseData(activity, aVar, dVar, cJRHomePageV2);
    }

    public final void getCstOrderIssueIntent(Context context, Bundle bundle) {
        k.c(context, "context");
        k.c(bundle, "bundle");
        mUtilites.getCstOrderIssueIntent(context, bundle);
    }

    public final void getUpdatedCstOrderIssueIntent(Activity activity, Bundle bundle, m mVar) {
        k.c(bundle, "bundle");
        mUtilites.getUpdatedCstOrderIssueIntent(activity, bundle, mVar);
    }

    public final void launchDeeplink(Context context, String str, CJRHomePageItem cJRHomePageItem) {
        k.c(context, "context");
        k.c(str, "url");
        k.c(cJRHomePageItem, "searchItem");
        mUtilites.launchDeelink(context, str, cJRHomePageItem);
    }

    public final void sendEventToPaytmAnalytics(CJRRechargeErrorModel cJRRechargeErrorModel, Context context) {
        CRUFlowModel flowName;
        k.c(cJRRechargeErrorModel, "t");
        k.c(context, "context");
        String name = ERROR_TYPE.NO_CONNECTION.name();
        CRUFlowModel flowName2 = cJRRechargeErrorModel.getFlowName();
        if (!k.a((Object) name, (Object) flowName2 != null ? flowName2.getErrorType() : null)) {
            if (cJRRechargeErrorModel.getRechargeItemCategoryId() != null) {
                CRUFlowModel flowName3 = cJRRechargeErrorModel.getFlowName();
                if (flowName3 != null) {
                    flowName3.setActionList(cJRRechargeErrorModel.getActionsMap().get(cJRRechargeErrorModel.getRechargeItemCategoryId()));
                }
            } else {
                CRUFlowModel flowName4 = cJRRechargeErrorModel.getFlowName();
                if (flowName4 != null) {
                    flowName4.setActionList((Stack<String>) null);
                }
            }
            CRUFlowModel flowName5 = cJRRechargeErrorModel.getFlowName();
            if (TextUtils.isEmpty(flowName5 != null ? flowName5.getJourneyStackTrace() : null) && (flowName = cJRRechargeErrorModel.getFlowName()) != null) {
                flowName.setJourneyStackTrace((StringBuilder) null);
            }
            String name2 = ERROR_TYPE.AUTH.name();
            CRUFlowModel flowName6 = cJRRechargeErrorModel.getFlowName();
            if (k.a((Object) name2, (Object) flowName6 != null ? flowName6.getErrorType() : null)) {
                CRUFlowModel flowName7 = cJRRechargeErrorModel.getFlowName();
                if (flowName7 != null) {
                    flowName7.setAlertType((String) null);
                }
                CRUFlowModel flowName8 = cJRRechargeErrorModel.getFlowName();
                if (flowName8 != null) {
                    flowName8.setJourneyStackTrace((StringBuilder) null);
                }
            }
            try {
                String errorCode = cJRRechargeErrorModel.getErrorCode();
                if (errorCode != null) {
                    Integer.parseInt(errorCode);
                }
            } catch (Exception unused) {
                cJRRechargeErrorModel.setErrorCode((String) null);
            }
            mUtilites.sendEventToPaytmAnalytics(cJRRechargeErrorModel, context);
        }
    }

    public final String getStoreFrontAdApiBody(Context context) {
        k.c(context, "context");
        return mUtilites.getStoreFrontAdApiBody(context);
    }

    public final String getBankAuthPasscodeRSA() {
        return mUtilites.getBankAuthPasscodeRSA();
    }

    public final void openIFSCCodeActivity(Context context, int i2) {
        k.c(context, "context");
        mUtilites.openIFSCCodeActivity(context, i2);
    }

    public final void openPromoSelectionScreen(Context context, String str, double d2, String str2, String str3, VerifyPromoCallbackListener verifyPromoCallbackListener, OnPromoActivityDestroyListener onPromoActivityDestroyListener) {
        k.c(context, "context");
        k.c(str2, "promoSearchApiResponse");
        String str4 = str3;
        k.c(str4, "reqUrl");
        VerifyPromoCallbackListener verifyPromoCallbackListener2 = verifyPromoCallbackListener;
        k.c(verifyPromoCallbackListener2, "listener");
        OnPromoActivityDestroyListener onPromoActivityDestroyListener2 = onPromoActivityDestroyListener;
        k.c(onPromoActivityDestroyListener2, "destroyListener");
        mUtilites.openPromoSelectionScreen(context, str, d2, str2, str4, verifyPromoCallbackListener2, onPromoActivityDestroyListener2);
    }

    public final boolean isAuthError(NetworkCustomError networkCustomError) {
        if (networkCustomError == null) {
            return false;
        }
        int statusCode = networkCustomError.getStatusCode();
        return statusCode == 401 || statusCode == 403 || statusCode == 410;
    }

    public static /* synthetic */ void handleError$default(CJRRechargeUtilities cJRRechargeUtilities, String str, Activity activity, Fragment fragment, NetworkCustomError networkCustomError, boolean z, int i2, Object obj, int i3, Object obj2) {
        cJRRechargeUtilities.handleError(str, activity, (i3 & 4) != 0 ? null : fragment, networkCustomError, (i3 & 16) != 0 ? true : z, (i3 & 32) != 0 ? 3 : i2, obj);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0191, code lost:
        if ((r5 != null ? r23.getAlertMessage() : null) != null) goto L_0x0193;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01bf, code lost:
        if ((r5 != null ? r23.getAlertMessage() : null) != null) goto L_0x01c1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleError(java.lang.String r20, android.app.Activity r21, androidx.fragment.app.Fragment r22, com.paytm.network.model.NetworkCustomError r23, boolean r24, int r25, java.lang.Object r26) {
        /*
            r19 = this;
            r9 = r19
            r0 = r20
            r5 = r23
            r1 = r26
            if (r21 != 0) goto L_0x0017
            boolean r0 = r1 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r0 == 0) goto L_0x0016
            net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a
            r0 = r1
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r0
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r0)
        L_0x0016:
            return
        L_0x0017:
            boolean r2 = r5 instanceof net.one97.paytm.recharge.common.utils.c
            if (r2 != 0) goto L_0x02c1
            com.paytm.network.model.NetworkCustomError$ErrorType r2 = com.paytm.network.model.NetworkCustomError.ErrorType.AuthFailureError
            r3 = 0
            if (r5 == 0) goto L_0x0025
            com.paytm.network.model.NetworkCustomError$ErrorType r4 = r23.getErrorType()
            goto L_0x0026
        L_0x0025:
            r4 = r3
        L_0x0026:
            if (r2 == r4) goto L_0x02c1
            boolean r2 = r9.isAuthError(r5)
            if (r2 != 0) goto L_0x02c1
            boolean r2 = r5 instanceof net.one97.paytm.recharge.common.utils.bc
            if (r2 == 0) goto L_0x0034
            goto L_0x02c1
        L_0x0034:
            boolean r2 = r5 instanceof net.one97.paytm.recharge.common.utils.ap
            if (r2 == 0) goto L_0x00a3
            boolean r0 = r1 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r0 == 0) goto L_0x0069
            r2 = r1
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r2 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r2
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r4 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.INVALID_URL
            r2.setErrorType(r4)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r4 = r2.getFlowName()
            if (r4 == 0) goto L_0x0053
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r5 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.INVALID_URL
            java.lang.String r5 = r5.name()
            r4.setErrorType(r5)
        L_0x0053:
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE$Companion r4 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.Companion
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r5 = r2.getFlowName()
            if (r5 == 0) goto L_0x005f
            java.lang.String r3 = r5.getActionType()
        L_0x005f:
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r5 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.UNDEFINED
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r3 = r4.getActionType(r3, r5)
            r16 = r2
            r12 = r3
            goto L_0x006c
        L_0x0069:
            r12 = r3
            r16 = r12
        L_0x006c:
            android.content.res.Resources r2 = r21.getResources()
            int r3 = net.one97.paytm.recharge.R.string.msg_invalid_url
            java.lang.String r14 = r2.getString(r3)
            java.lang.String r2 = "(activity?.resources.get….string.msg_invalid_url))"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r2)
            if (r24 == 0) goto L_0x0098
            net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a
            r10 = r21
            android.content.Context r10 = (android.content.Context) r10
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r11 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.INVALID_URL
            android.content.res.Resources r0 = r21.getResources()
            int r1 = net.one97.paytm.recharge.R.string.error
            java.lang.String r13 = r0.getString(r1)
            r15 = 0
            r17 = 0
            r18 = 1504(0x5e0, float:2.108E-42)
            net.one97.paytm.recharge.common.utils.az.a((android.content.Context) r10, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r11, (net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r12, (java.lang.String) r13, (java.lang.String) r14, (boolean) r15, (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r16, (boolean) r17, (int) r18)
            return
        L_0x0098:
            if (r0 == 0) goto L_0x00a2
            net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a
            r0 = r1
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r0
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r0)
        L_0x00a2:
            return
        L_0x00a3:
            boolean r2 = r5 instanceof net.one97.paytm.recharge.widgets.c.h
            java.lang.String r4 = "(activity!!.resources.ge…g.network_error_message))"
            if (r2 == 0) goto L_0x0112
            boolean r0 = r1 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r0 == 0) goto L_0x00da
            r2 = r1
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r2 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r2
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r5 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.NO_CONNECTION
            r2.setErrorType(r5)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r5 = r2.getFlowName()
            if (r5 == 0) goto L_0x00c4
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r6 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.NO_CONNECTION
            java.lang.String r6 = r6.name()
            r5.setErrorType(r6)
        L_0x00c4:
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE$Companion r5 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.Companion
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r6 = r2.getFlowName()
            if (r6 == 0) goto L_0x00d0
            java.lang.String r3 = r6.getActionType()
        L_0x00d0:
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r6 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.UNDEFINED
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r3 = r5.getActionType(r3, r6)
            r16 = r2
            r12 = r3
            goto L_0x00dd
        L_0x00da:
            r12 = r3
            r16 = r12
        L_0x00dd:
            android.content.res.Resources r2 = r21.getResources()
            int r3 = net.one97.paytm.recharge.R.string.network_error_message
            java.lang.String r14 = r2.getString(r3)
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r4)
            if (r24 == 0) goto L_0x0107
            net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a
            r10 = r21
            android.content.Context r10 = (android.content.Context) r10
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r11 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.NO_CONNECTION
            android.content.res.Resources r0 = r21.getResources()
            int r1 = net.one97.paytm.recharge.R.string.network_error_heading
            java.lang.String r13 = r0.getString(r1)
            r15 = 0
            r17 = 0
            r18 = 1504(0x5e0, float:2.108E-42)
            net.one97.paytm.recharge.common.utils.az.a((android.content.Context) r10, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r11, (net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r12, (java.lang.String) r13, (java.lang.String) r14, (boolean) r15, (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r16, (boolean) r17, (int) r18)
            return
        L_0x0107:
            if (r0 == 0) goto L_0x0111
            net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a
            r0 = r1
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r0
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r0)
        L_0x0111:
            return
        L_0x0112:
            boolean r2 = r5 instanceof net.one97.paytm.recharge.common.utils.as
            if (r2 == 0) goto L_0x017f
            boolean r0 = r1 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r0 == 0) goto L_0x0147
            r2 = r1
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r2 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r2
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r5 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            r2.setErrorType(r5)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r5 = r2.getFlowName()
            if (r5 == 0) goto L_0x0131
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r6 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r6 = r6.name()
            r5.setErrorType(r6)
        L_0x0131:
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE$Companion r5 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.Companion
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r6 = r2.getFlowName()
            if (r6 == 0) goto L_0x013d
            java.lang.String r3 = r6.getActionType()
        L_0x013d:
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r6 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.UNDEFINED
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r3 = r5.getActionType(r3, r6)
            r16 = r2
            r12 = r3
            goto L_0x014a
        L_0x0147:
            r12 = r3
            r16 = r12
        L_0x014a:
            android.content.res.Resources r2 = r21.getResources()
            int r3 = net.one97.paytm.recharge.R.string.network_error_message
            java.lang.String r14 = r2.getString(r3)
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r4)
            if (r24 == 0) goto L_0x0174
            net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a
            r10 = r21
            android.content.Context r10 = (android.content.Context) r10
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r11 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            android.content.res.Resources r0 = r21.getResources()
            int r1 = net.one97.paytm.recharge.R.string.network_error_heading
            java.lang.String r13 = r0.getString(r1)
            r15 = 0
            r17 = 0
            r18 = 1504(0x5e0, float:2.108E-42)
            net.one97.paytm.recharge.common.utils.az.a((android.content.Context) r10, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r11, (net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r12, (java.lang.String) r13, (java.lang.String) r14, (boolean) r15, (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r16, (boolean) r17, (int) r18)
            return
        L_0x0174:
            if (r0 == 0) goto L_0x017e
            net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a
            r0 = r1
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r0
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r0)
        L_0x017e:
            return
        L_0x017f:
            if (r5 == 0) goto L_0x0186
            java.lang.String r2 = r23.getMessage()
            goto L_0x0187
        L_0x0186:
            r2 = r3
        L_0x0187:
            if (r2 != 0) goto L_0x0193
            if (r5 == 0) goto L_0x0190
            java.lang.String r2 = r23.getAlertMessage()
            goto L_0x0191
        L_0x0190:
            r2 = r3
        L_0x0191:
            if (r2 == 0) goto L_0x01ad
        L_0x0193:
            r2 = r21
            android.content.Context r2 = (android.content.Context) r2
            r6 = r5
            java.lang.Exception r6 = (java.lang.Exception) r6
            boolean r2 = r9.checkErrorCode(r0, r2, r6, r1)
            if (r2 == 0) goto L_0x01ad
            boolean r0 = r1 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r0 == 0) goto L_0x02c0
            net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a
            r0 = r1
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r0
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r0)
            return
        L_0x01ad:
            if (r5 == 0) goto L_0x01b4
            java.lang.String r2 = r23.getMessage()
            goto L_0x01b5
        L_0x01b4:
            r2 = r3
        L_0x01b5:
            if (r2 != 0) goto L_0x01c1
            if (r5 == 0) goto L_0x01be
            java.lang.String r2 = r23.getAlertMessage()
            goto L_0x01bf
        L_0x01be:
            r2 = r3
        L_0x01bf:
            if (r2 == 0) goto L_0x02b4
        L_0x01c1:
            r10 = r21
            android.content.Context r10 = (android.content.Context) r10
            r2 = r5
            java.lang.Exception r2 = (java.lang.Exception) r2
            boolean r0 = r9.checkErrorCode(r0, r10, r2, r1)
            if (r0 != 0) goto L_0x02b4
            boolean r0 = r1 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r0 == 0) goto L_0x01fd
            r2 = r1
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r2 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r2
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r6 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            r2.setErrorType(r6)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r6 = r2.getFlowName()
            if (r6 == 0) goto L_0x01e9
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r7 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r7 = r7.name()
            r6.setErrorType(r7)
        L_0x01e9:
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE$Companion r6 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.Companion
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r7 = r2.getFlowName()
            if (r7 == 0) goto L_0x01f5
            java.lang.String r3 = r7.getActionType()
        L_0x01f5:
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r7 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.UNDEFINED
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r3 = r6.getActionType(r3, r7)
            r12 = r3
            goto L_0x01ff
        L_0x01fd:
            r2 = r3
            r12 = r2
        L_0x01ff:
            java.lang.String r3 = r23.getMessage()
            if (r3 == 0) goto L_0x0252
            java.lang.String r3 = r23.getMessage()
            r6 = 1
            java.lang.String r7 = "parsing_error"
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r7, (boolean) r6)
            if (r3 == 0) goto L_0x0252
            if (r2 == 0) goto L_0x0219
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r3 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.PARSING
            r2.setErrorType(r3)
        L_0x0219:
            if (r2 == 0) goto L_0x022a
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r3 = r2.getFlowName()
            if (r3 == 0) goto L_0x022a
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r4 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.PARSING
            java.lang.String r4 = r4.name()
            r3.setErrorType(r4)
        L_0x022a:
            if (r24 == 0) goto L_0x0247
            net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r11 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.PARSING
            java.lang.String r13 = r23.getUrl()
            int r0 = r23.getStatusCode()
            java.lang.String r14 = java.lang.String.valueOf(r0)
            r15 = 0
            r17 = 0
            r18 = 1504(0x5e0, float:2.108E-42)
            r16 = r2
            net.one97.paytm.recharge.common.utils.az.a((android.content.Context) r10, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r11, (net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r12, (java.lang.String) r13, (java.lang.String) r14, (boolean) r15, (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r16, (boolean) r17, (int) r18)
            return
        L_0x0247:
            if (r0 == 0) goto L_0x0251
            net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a
            r0 = r1
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r0
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r0)
        L_0x0251:
            return
        L_0x0252:
            java.lang.String r3 = r23.getAlertMessage()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0281
            java.lang.String r3 = r23.getAlertTitle()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0281
            net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r11 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r13 = r23.getAlertTitle()
            java.lang.String r14 = r23.getAlertMessage()
            r15 = 0
            r17 = 0
            r18 = 1504(0x5e0, float:2.108E-42)
            r16 = r2
            net.one97.paytm.recharge.common.utils.az.a((android.content.Context) r10, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r11, (net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r12, (java.lang.String) r13, (java.lang.String) r14, (boolean) r15, (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r16, (boolean) r17, (int) r18)
            return
        L_0x0281:
            android.content.res.Resources r3 = r21.getResources()
            int r5 = net.one97.paytm.recharge.R.string.network_error_message
            java.lang.String r14 = r3.getString(r5)
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r4)
            if (r24 == 0) goto L_0x02a9
            net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r11 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            android.content.res.Resources r0 = r21.getResources()
            int r1 = net.one97.paytm.recharge.R.string.network_error_heading
            java.lang.String r13 = r0.getString(r1)
            r15 = 0
            r17 = 0
            r18 = 1504(0x5e0, float:2.108E-42)
            r16 = r2
            net.one97.paytm.recharge.common.utils.az.a((android.content.Context) r10, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r11, (net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r12, (java.lang.String) r13, (java.lang.String) r14, (boolean) r15, (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r16, (boolean) r17, (int) r18)
            return
        L_0x02a9:
            if (r0 == 0) goto L_0x02b3
            net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a
            r0 = r1
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r0
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r0)
        L_0x02b3:
            return
        L_0x02b4:
            boolean r0 = r1 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r0 == 0) goto L_0x02c0
            net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a
            r0 = r1
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r0
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r0)
        L_0x02c0:
            return
        L_0x02c1:
            if (r24 == 0) goto L_0x033a
            boolean r0 = r1 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r0 == 0) goto L_0x030a
            r0 = r1
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r0
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r1 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.AUTH
            r0.setErrorType(r1)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r0.getFlowName()
            if (r1 == 0) goto L_0x02de
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.AUTH
            java.lang.String r2 = r2.name()
            r1.setErrorType(r2)
        L_0x02de:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r0.getFlowName()
            if (r1 == 0) goto L_0x02e9
            java.lang.String r2 = ""
            r1.setAlertType(r2)
        L_0x02e9:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r1 = r0.getFlowName()
            if (r1 == 0) goto L_0x02f8
            java.lang.StringBuilder r1 = r1.getJourneyStackTrace()
            if (r1 == 0) goto L_0x02f8
            kotlin.m.p.a(r1)
        L_0x02f8:
            boolean r1 = r5 instanceof net.one97.paytm.recharge.common.utils.av
            if (r1 == 0) goto L_0x0305
            r1 = r5
            net.one97.paytm.recharge.common.utils.av r1 = (net.one97.paytm.recharge.common.utils.av) r1
            boolean r1 = r1.isFrontEndError()
            if (r1 != 0) goto L_0x030a
        L_0x0305:
            net.one97.paytm.recharge.common.utils.az r1 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r0)
        L_0x030a:
            if (r22 == 0) goto L_0x0323
            r3 = 0
            r4 = 0
            if (r5 != 0) goto L_0x0313
            kotlin.g.b.k.a()
        L_0x0313:
            r6 = 0
            r7 = 1
            r0 = r19
            r1 = r21
            r2 = r22
            r5 = r23
            r8 = r25
            r0.showSessionTimeoutAlert(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        L_0x0323:
            r2 = 0
            r3 = 0
            if (r5 != 0) goto L_0x032a
            kotlin.g.b.k.a()
        L_0x032a:
            r6 = 0
            r7 = 1
            r0 = r19
            r1 = r21
            r4 = r23
            r5 = r6
            r6 = r7
            r7 = r25
            r0.showSessionTimeoutAlert((android.app.Activity) r1, (java.lang.String) r2, (android.os.Bundle) r3, (com.paytm.network.model.NetworkCustomError) r4, (boolean) r5, (boolean) r6, (int) r7)
            return
        L_0x033a:
            boolean r0 = r1 instanceof net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel
            if (r0 == 0) goto L_0x0346
            net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a
            r0 = r1
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r0 = (net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r0
            net.one97.paytm.recharge.common.utils.az.a((net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel) r0)
        L_0x0346:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.handleError(java.lang.String, android.app.Activity, androidx.fragment.app.Fragment, com.paytm.network.model.NetworkCustomError, boolean, int, java.lang.Object):void");
    }

    public final void fetchWalletToken(Context context, b bVar) {
        k.c(context, "activity");
        k.c(bVar, "listener");
        mUtilites.fetchWalletToken(context, bVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void launchDeeplinkOnRecreate(android.app.Activity r13, java.lang.String r14, java.util.Map<java.lang.String, java.lang.String> r15) {
        /*
            r12 = this;
            java.lang.String r0 = "activity"
            kotlin.g.b.k.c(r13, r0)
            net.one97.paytm.recharge.widgets.c.d r0 = net.one97.paytm.recharge.widgets.c.d.f64967a
            java.lang.String r0 = "Deeplink fired onReCreate"
            net.one97.paytm.recharge.widgets.c.d.a((java.lang.String) r0)
            net.one97.paytm.recharge.common.utils.y r0 = net.one97.paytm.recharge.common.utils.y.f61814b
            java.util.HashMap r0 = net.one97.paytm.recharge.common.utils.y.a()
            java.util.Map r0 = (java.util.Map) r0
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.collections.Map<K, *>"
            if (r0 == 0) goto L_0x010f
            boolean r0 = r0.containsKey(r14)
            r2 = 0
            if (r0 == 0) goto L_0x002e
            net.one97.paytm.recharge.common.utils.y r0 = net.one97.paytm.recharge.common.utils.y.f61814b
            java.util.HashMap r0 = net.one97.paytm.recharge.common.utils.y.a()
            java.util.Map r0 = (java.util.Map) r0
            java.lang.Object r0 = r0.get(r14)
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x002f
        L_0x002e:
            r0 = r2
        L_0x002f:
            net.one97.paytm.recharge.common.utils.y r3 = net.one97.paytm.recharge.common.utils.y.f61814b
            java.util.HashMap r3 = net.one97.paytm.recharge.common.utils.y.b()
            java.util.Map r3 = (java.util.Map) r3
            if (r3 == 0) goto L_0x0109
            boolean r1 = r3.containsKey(r14)
            if (r1 == 0) goto L_0x004e
            net.one97.paytm.recharge.common.utils.y r1 = net.one97.paytm.recharge.common.utils.y.f61814b
            java.util.HashMap r1 = net.one97.paytm.recharge.common.utils.y.b()
            java.util.Map r1 = (java.util.Map) r1
            java.lang.Object r14 = r1.get(r14)
            r2 = r14
            java.lang.String r2 = (java.lang.String) r2
        L_0x004e:
            r5 = r2
            r14 = r0
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            boolean r14 = android.text.TextUtils.isEmpty(r14)
            if (r14 != 0) goto L_0x0105
            r14 = r5
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            boolean r14 = android.text.TextUtils.isEmpty(r14)
            if (r14 != 0) goto L_0x0105
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r14 = new net.one97.paytm.common.entity.shopping.CJRHomePageItem
            r14.<init>()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "paytmmp://"
            r2.<init>(r3)
            r2.append(r5)
            java.lang.String r3 = "?url="
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            if (r15 == 0) goto L_0x00cb
            java.util.Set r15 = r15.entrySet()
            java.util.Iterator r15 = r15.iterator()
        L_0x008b:
            boolean r0 = r15.hasNext()
            if (r0 == 0) goto L_0x00cb
            java.lang.Object r0 = r15.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r2 = r0.getKey()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            r3 = r0
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x008b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "&"
            r3.<init>(r4)
            r3.append(r2)
            r2 = 61
            r3.append(r2)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r1.append(r0)
            java.lang.String r0 = "urlBuilder.append(\"&$key=$value\")"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r0)
            goto L_0x008b
        L_0x00cb:
            r14.setUrlType(r5)
            java.lang.String r15 = new java.lang.String
            r15.<init>(r1)
            r14.setUrl(r15)
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r3 = INSTANCE     // Catch:{ Exception -> 0x00ed }
            android.content.Context r4 = r13.getApplicationContext()     // Catch:{ Exception -> 0x00ed }
            java.lang.String r15 = "activity.applicationContext"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r15)     // Catch:{ Exception -> 0x00ed }
            r6 = r14
            net.one97.paytm.common.entity.IJRDataModel r6 = (net.one97.paytm.common.entity.IJRDataModel) r6     // Catch:{ Exception -> 0x00ed }
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r3.loadPage(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x00ed }
            return
        L_0x00ed:
            r14 = move-exception
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r15 = INSTANCE
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unable to handle activity-recreate : "
            r0.<init>(r1)
            java.lang.String r14 = r14.getMessage()
            r0.append(r14)
            java.lang.String r14 = r0.toString()
            r15.debugLog(r14)
        L_0x0105:
            net.one97.paytm.recharge.common.utils.ba.a((android.app.Activity) r13)
            return
        L_0x0109:
            kotlin.u r13 = new kotlin.u
            r13.<init>(r1)
            throw r13
        L_0x010f:
            kotlin.u r13 = new kotlin.u
            r13.<init>(r1)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.launchDeeplinkOnRecreate(android.app.Activity, java.lang.String, java.util.Map):void");
    }
}
