package com.paytmmall.clpartifact.utils;

import android.content.Context;
import com.alipay.mobile.nebulacore.wallet.H5Logger;
import com.appsflyer.internal.referrer.Payload;
import com.google.gson.f;
import com.paytm.network.a;
import com.paytm.network.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.listeners.IGAEnableListener;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import com.paytmmall.clpartifact.modal.StringResponseModel;
import com.paytmmall.clpartifact.modal.clpCommon.Page;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.network.SFCallbackListener;
import com.paytmmall.clpartifact.view.viewmodel.HomeResponse;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;

public final class SFUtils {
    public static final SFUtils INSTANCE = new SFUtils();
    private static final HashSet<String> specialWidgetSet = new SFUtils$specialWidgetSet$1();

    private SFUtils() {
    }

    public static /* synthetic */ SanitizedResponseModel getSanitizedResponse$default(SFUtils sFUtils, HomeResponse homeResponse, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return sFUtils.getSanitizedResponse(homeResponse, z);
    }

    public final SanitizedResponseModel getSanitizedResponse(HomeResponse homeResponse, boolean z) {
        k.c(homeResponse, Payload.RESPONSE);
        return getSanitizedResponse(homeResponse, z, (String) null, 1004, (IGAEnableListener) null);
    }

    private final boolean isValidWidget(List<View> list) {
        for (View type : list) {
            if (specialWidgetSet.contains(type.getType())) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ void getStoreFrontReponse$default(SFUtils sFUtils, String str, HashMap hashMap, a.c cVar, SFCallbackListener sFCallbackListener, String str2, int i2, IGAEnableListener iGAEnableListener, int i3, Object obj) {
        sFUtils.getStoreFrontReponse(str, hashMap, cVar, sFCallbackListener, (i3 & 16) != 0 ? null : str2, (i3 & 32) != 0 ? 1004 : i2, (i3 & 64) != 0 ? null : iGAEnableListener);
    }

    public final void getStoreFrontReponse(String str, HashMap<String, String> hashMap, a.c cVar, SFCallbackListener sFCallbackListener, String str2, int i2, IGAEnableListener iGAEnableListener) {
        k.c(str, "url");
        k.c(hashMap, H5Logger.HEADER);
        k.c(cVar, "verticalId");
        k.c(sFCallbackListener, "listener");
        CLPArtifact instance = CLPArtifact.getInstance();
        k.a((Object) instance, "CLPArtifact.getInstance()");
        Context context = instance.getContext();
        b a2 = new b().a(context).a(cVar).a(a.C0715a.POST).a(a.b.SILENT).c(cVar.name()).a(str).a((IJRPaytmDataModel) new StringResponseModel()).a((com.paytm.network.listener.b) new SFUtils$getStoreFrontReponse$networkCallBuilder$1(sFCallbackListener, str2, i2, iGAEnableListener));
        k.a((Object) a2, "networkCallBuilder");
        k.a((Object) context, "context");
        a2.a((Map<String, String>) getRequestHeaders(context, hashMap));
        a l = a2.l();
        l.b(false);
        l.a();
    }

    /* access modifiers changed from: private */
    public final void handleErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, SFCallbackListener sFCallbackListener) {
        sFCallbackListener.onFailure(i2, iJRPaytmDataModel, networkCustomError);
    }

    /* access modifiers changed from: private */
    public final void handleApiResponse(IJRPaytmDataModel iJRPaytmDataModel, SFCallbackListener sFCallbackListener, String str, int i2, IGAEnableListener iGAEnableListener) {
        HomeResponse parsedResponse = getParsedResponse(iJRPaytmDataModel);
        if (parsedResponse != null) {
            List<Page> page = parsedResponse.getPage();
            boolean z = false;
            if (page != null && !page.isEmpty()) {
                z = true;
            }
            if (z) {
                sFCallbackListener.onSuccess(getSanitizedResponse(parsedResponse, false, str, i2, iGAEnableListener));
                return;
            }
        }
        NetworkCustomError networkCustomError = new NetworkCustomError();
        networkCustomError.setErrorType(NetworkCustomError.ErrorType.ParsingError);
        sFCallbackListener.onFailure(1000, iJRPaytmDataModel, networkCustomError);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000e, code lost:
        r2 = r2.getCommunicationListener();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.HashMap<java.lang.String, java.lang.String> getRequestHeaders(android.content.Context r6, java.util.HashMap<java.lang.String, java.lang.String> r7) {
        /*
            r5 = this;
            java.util.HashMap r0 = com.paytm.utility.a.i()
            java.lang.String r1 = com.paytm.utility.a.a((android.content.Context) r6)
            com.paytmmall.clpartifact.common.CLPArtifact r2 = com.paytmmall.clpartifact.common.CLPArtifact.getInstance()
            if (r2 == 0) goto L_0x0019
            com.paytmmall.clpartifact.listeners.ICLPCommunicationListener r2 = r2.getCommunicationListener()
            if (r2 == 0) goto L_0x0019
            java.lang.String r2 = r2.getSSOToken(r6)
            goto L_0x001a
        L_0x0019:
            r2 = 0
        L_0x001a:
            r3 = r1
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            java.lang.String r4 = "headers"
            if (r3 != 0) goto L_0x0037
            boolean r6 = com.paytm.utility.a.p(r6)
            if (r6 == 0) goto L_0x0037
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            r6 = r0
            java.util.Map r6 = (java.util.Map) r6
            java.lang.String r3 = "user_id"
            r6.put(r3, r1)
        L_0x0037:
            r6 = r2
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x004c
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            r6 = r0
            java.util.Map r6 = (java.util.Map) r6
            java.lang.String r1 = "sso_token"
            r6.put(r1, r2)
        L_0x004c:
            java.lang.String r6 = "Content-Type"
            java.lang.String r1 = "application/json"
            r0.put(r6, r1)
            boolean r6 = r7.isEmpty()
            if (r6 != 0) goto L_0x005e
            java.util.Map r7 = (java.util.Map) r7
            r0.putAll(r7)
        L_0x005e:
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.utils.SFUtils.getRequestHeaders(android.content.Context, java.util.HashMap):java.util.HashMap");
    }

    private final HomeResponse getParsedResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        f fVar = new f();
        try {
            if (iJRPaytmDataModel instanceof StringResponseModel) {
                return (HomeResponse) fVar.a(((StringResponseModel) iJRPaytmDataModel).getRawResponse(), HomeResponse.class);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public final void refreshHome(String str) {
        k.c(str, "uniqueOrderID");
        HomeUtils.INSTANCE.setForceRefreshLiveData(str);
    }

    public static /* synthetic */ SanitizedResponseModel getSanitizedResponse$default(SFUtils sFUtils, HomeResponse homeResponse, boolean z, String str, int i2, IGAEnableListener iGAEnableListener, int i3, Object obj) {
        return sFUtils.getSanitizedResponse(homeResponse, z, str, (i3 & 8) != 0 ? 1004 : i2, iGAEnableListener);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0030, code lost:
        r1 = r0.getViews();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.paytmmall.clpartifact.modal.SanitizedResponseModel getSanitizedResponse(com.paytmmall.clpartifact.view.viewmodel.HomeResponse r17, boolean r18, java.lang.String r19, int r20, com.paytmmall.clpartifact.listeners.IGAEnableListener r21) {
        /*
            r16 = this;
            java.lang.String r0 = "response"
            r7 = r17
            kotlin.g.b.k.c(r7, r0)
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.LinkedHashMap r9 = new java.util.LinkedHashMap
            r9.<init>()
            java.util.List r0 = r17.getPage()
            java.lang.String r1 = "pages"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r10 = r0.iterator()
        L_0x0020:
            boolean r0 = r10.hasNext()
            r11 = 0
            if (r0 == 0) goto L_0x015d
            java.lang.Object r0 = r10.next()
            com.paytmmall.clpartifact.modal.clpCommon.Page r0 = (com.paytmmall.clpartifact.modal.clpCommon.Page) r0
            r12 = 0
            if (r0 == 0) goto L_0x003b
            java.util.List r1 = r0.getViews()
            if (r1 == 0) goto L_0x003b
            int r1 = r1.size()
            goto L_0x003c
        L_0x003b:
            r1 = 0
        L_0x003c:
            if (r0 == 0) goto L_0x0057
            java.util.List r2 = r0.getViews()
            if (r2 == 0) goto L_0x0057
            java.lang.Object r2 = r2.get(r12)
            com.paytmmall.clpartifact.modal.clpCommon.View r2 = (com.paytmmall.clpartifact.modal.clpCommon.View) r2
            if (r2 == 0) goto L_0x0057
            java.util.List r2 = r2.getItems()
            if (r2 == 0) goto L_0x0057
            int r2 = r2.size()
            goto L_0x0058
        L_0x0057:
            r2 = -1
        L_0x0058:
            if (r0 == 0) goto L_0x005f
            java.util.List r3 = r0.getViews()
            goto L_0x0060
        L_0x005f:
            r3 = r11
        L_0x0060:
            if (r1 <= 0) goto L_0x0020
            if (r3 == 0) goto L_0x0020
            com.paytmmall.clpartifact.utils.SFUtils r1 = INSTANCE
            boolean r1 = r1.isValidWidget(r3)
            if (r1 != 0) goto L_0x006e
            if (r2 <= 0) goto L_0x0020
        L_0x006e:
            java.util.List r0 = r0.getViews()
            java.lang.String r1 = "page.views"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r13 = r0.iterator()
        L_0x007d:
            boolean r0 = r13.hasNext()
            if (r0 == 0) goto L_0x0020
            java.lang.Object r0 = r13.next()
            r1 = r0
            com.paytmmall.clpartifact.modal.clpCommon.View r1 = (com.paytmmall.clpartifact.modal.clpCommon.View) r1
            java.lang.Long r0 = r17.getPageId()
            if (r0 == 0) goto L_0x009a
            long r2 = r0.longValue()
            java.lang.String r0 = java.lang.String.valueOf(r2)
            if (r0 != 0) goto L_0x009c
        L_0x009a:
            java.lang.String r0 = ""
        L_0x009c:
            com.paytmmall.clpartifact.view.viewmodel.UserContext r2 = r17.getContext()
            if (r2 == 0) goto L_0x00a7
            java.lang.String r2 = r2.getMrequestid()
            goto L_0x00a8
        L_0x00a7:
            r2 = r11
        L_0x00a8:
            r1.setPageParams(r0, r2)
            boolean r0 = com.paytmmall.clpartifact.widgets.factory.SFWidgetFactory.isSFWidget(r1)
            r2 = 1
            java.lang.String r3 = "view"
            if (r0 == 0) goto L_0x00e3
            java.lang.String r0 = r1.getType()
            boolean r0 = com.paytmmall.clpartifact.widgets.factory.SFWidgetFactory.isApiOnlyWidget(r0)
            if (r0 == 0) goto L_0x00c1
            if (r18 != 0) goto L_0x0127
        L_0x00c1:
            com.paytmmall.clpartifact.widgets.blueprints.IWidgetProvider r0 = com.paytmmall.clpartifact.widgets.factory.SFWidgetFactory.getWidgetProvider(r1)
            if (r0 == 0) goto L_0x0127
            boolean r4 = r0.isValid()
            if (r4 != r2) goto L_0x0127
            r1.setItemData()
            java.lang.String r2 = r17.getGaKey()
            r1.setGaKey(r2)
            int r2 = r0.getWidgetType()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r9.put(r2, r0)
            goto L_0x0127
        L_0x00e3:
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            java.lang.String r0 = r1.getType()
            java.lang.String r4 = "recents-list"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r4)
            if (r0 == 0) goto L_0x010c
            com.paytmmall.clpartifact.utils.RecentsManager r0 = com.paytmmall.clpartifact.utils.RecentsManager.INSTANCE
            java.util.List r0 = r0.getFilteredRecents(r1)
            r4 = r0
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            r2 = r2 ^ r4
            if (r2 == 0) goto L_0x0127
            r1.setItems(r0)
            r1.setItemData()
            r8.add(r1)
            goto L_0x0127
        L_0x010c:
            com.paytmmall.clpartifact.utils.WidgetLayoutType$Companion r0 = com.paytmmall.clpartifact.utils.WidgetLayoutType.Companion
            int r0 = r0.getLayoutTypeIndexfromName((com.paytmmall.clpartifact.modal.clpCommon.View) r1)
            net.one97.paytm.common.entity.shopping.LayoutType r2 = net.one97.paytm.common.entity.shopping.LayoutType.LAYOUT_IGNORE_TYPE
            int r2 = r2.getIndex()
            if (r0 == r2) goto L_0x0127
            r1.setItemData()
            java.lang.String r0 = r17.getGaKey()
            r1.setGaKey(r0)
            r8.add(r1)
        L_0x0127:
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            java.lang.String r0 = r1.getType()
            java.lang.String r2 = "smart-icon-header-v2"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 == 0) goto L_0x007d
            if (r18 != 0) goto L_0x007d
            java.util.List<com.paytmmall.clpartifact.modal.clpCommon.Item> r0 = r1.mItems
            if (r0 == 0) goto L_0x0142
            int r0 = r0.size()
            goto L_0x0143
        L_0x0142:
            r0 = 0
        L_0x0143:
            r2 = 2
            if (r0 > r2) goto L_0x007d
            java.util.concurrent.Executor r14 = android.os.AsyncTask.SERIAL_EXECUTOR
            com.paytmmall.clpartifact.utils.SFUtils$getSanitizedResponse$$inlined$forEach$lambda$1 r15 = new com.paytmmall.clpartifact.utils.SFUtils$getSanitizedResponse$$inlined$forEach$lambda$1
            r0 = r15
            r2 = r17
            r3 = r18
            r4 = r17
            r5 = r9
            r6 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6)
            java.lang.Runnable r15 = (java.lang.Runnable) r15
            r14.execute(r15)
            goto L_0x007d
        L_0x015d:
            com.paytmmall.clpartifact.modal.SanitizedResponseModel r10 = new com.paytmmall.clpartifact.modal.SanitizedResponseModel
            r1 = r8
            java.util.List r1 = (java.util.List) r1
            com.paytmmall.clpartifact.view.viewmodel.UserContext r0 = r17.getContext()
            if (r0 == 0) goto L_0x016e
            java.lang.String r0 = r0.getMrequestid()
            r3 = r0
            goto L_0x016f
        L_0x016e:
            r3 = r11
        L_0x016f:
            r0 = r10
            r2 = r9
            r4 = r19
            r5 = r20
            r6 = r21
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.utils.SFUtils.getSanitizedResponse(com.paytmmall.clpartifact.view.viewmodel.HomeResponse, boolean, java.lang.String, int, com.paytmmall.clpartifact.listeners.IGAEnableListener):com.paytmmall.clpartifact.modal.SanitizedResponseModel");
    }

    public static /* synthetic */ void getRefreshableResponse$default(SFUtils sFUtils, String str, HashMap hashMap, a.c cVar, SFCallbackListener sFCallbackListener, String str2, int i2, IGAEnableListener iGAEnableListener, int i3, Object obj) {
        sFUtils.getRefreshableResponse(str, hashMap, cVar, sFCallbackListener, (i3 & 16) != 0 ? null : str2, (i3 & 32) != 0 ? 1004 : i2, (i3 & 64) != 0 ? null : iGAEnableListener);
    }

    public final void getRefreshableResponse(String str, HashMap<String, String> hashMap, a.c cVar, SFCallbackListener sFCallbackListener, String str2, int i2, IGAEnableListener iGAEnableListener) {
        k.c(str, "url");
        k.c(hashMap, H5Logger.HEADER);
        k.c(cVar, "verticalId");
        k.c(sFCallbackListener, "listener");
        CLPArtifact instance = CLPArtifact.getInstance();
        k.a((Object) instance, "CLPArtifact.getInstance()");
        Context context = instance.getContext();
        String appendQueryParameter = UrlUtils.appendQueryParameter(str, "tag", "refreshable");
        k.a((Object) appendQueryParameter, "UrlUtils.appendQueryPara…rl, \"tag\", \"refreshable\")");
        b a2 = new b().a(context).a(cVar).a(a.C0715a.POST).a(a.b.SILENT).c(cVar.name()).a(appendQueryParameter).a((IJRPaytmDataModel) new StringResponseModel()).a((com.paytm.network.listener.b) new SFUtils$getRefreshableResponse$networkCallBuilder$1(sFCallbackListener, str2, i2, iGAEnableListener));
        k.a((Object) a2, "networkCallBuilder");
        k.a((Object) context, "context");
        a2.a((Map<String, String>) getRequestHeaders(context, hashMap));
        a l = a2.l();
        l.b(false);
        l.a();
    }
}
