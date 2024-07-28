package com.paytmmall.clpartifact.widgets.component.smarticongrid;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.f;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.a;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.modal.StringResponseModel;
import com.paytmmall.clpartifact.network.Resource;
import com.paytmmall.clpartifact.utils.SFGsonUtils;
import com.paytmmall.clpartifact.view.viewmodel.HomeResponse;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;

public final class SmartIconGridRepository {
    private final String TAG = "StoreFrontIconController";

    public static /* synthetic */ LiveData loadData$default(SmartIconGridRepository smartIconGridRepository, Context context, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return smartIconGridRepository.loadData(context, z);
    }

    public final LiveData<Resource<HomeResponse>> loadData(Context context, boolean z) {
        String str;
        k.c(context, "applicationContext");
        if (CLPArtifact.isCLPListenerAvailable()) {
            CLPArtifact instance = CLPArtifact.getInstance();
            k.a((Object) instance, "CLPArtifact.getInstance()");
            str = instance.getCommunicationListener().getMoreUrl(context);
            k.a((Object) str, "CLPArtifact.getInstance(…reUrl(applicationContext)");
        } else {
            str = "";
        }
        return getMoreResponse(context, z, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0060, code lost:
        if ((r1 instanceof com.paytmmall.clpartifact.view.viewmodel.HomeResponse) != false) goto L_0x0064;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final androidx.lifecycle.LiveData<com.paytmmall.clpartifact.network.Resource<com.paytmmall.clpartifact.view.viewmodel.HomeResponse>> getMoreResponse(android.content.Context r5, boolean r6, java.lang.String r7) {
        /*
            r4 = this;
            androidx.lifecycle.y r0 = new androidx.lifecycle.y
            r0.<init>()
            if (r6 == 0) goto L_0x000c
            androidx.lifecycle.LiveData r5 = r4.callCategoryAPI(r5, r7, r6, r0)
            return r5
        L_0x000c:
            com.paytmmall.clpartifact.common.CLPArtifact r7 = com.paytmmall.clpartifact.common.CLPArtifact.getInstance()
            java.lang.String r1 = "CLPArtifact.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r1)
            com.paytmmall.clpartifact.listeners.ICLPCommunicationListener r7 = r7.getCommunicationListener()
            java.lang.String r7 = r7.getMoreUrl(r5)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r7)
            if (r7 == 0) goto L_0x0032
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            java.lang.String r3 = "?"
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r7 = kotlin.m.p.a((java.lang.CharSequence) r7, (java.lang.CharSequence) r3, false)
            goto L_0x0033
        L_0x0032:
            r7 = 1
        L_0x0033:
            if (r7 != 0) goto L_0x003b
            r7 = 0
            java.lang.String r7 = com.paytm.utility.c.a((android.content.Context) r5, (boolean) r7)
            goto L_0x003d
        L_0x003b:
            java.lang.String r7 = ""
        L_0x003d:
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            com.paytmmall.clpartifact.view.viewmodel.HomeResponse r2 = r4.getCacheData(r7, r5)
            if (r2 != 0) goto L_0x0063
            com.paytmmall.clpartifact.common.CLPArtifact r3 = com.paytmmall.clpartifact.common.CLPArtifact.getInstance()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r1)
            com.paytmmall.clpartifact.listeners.ICLPCommunicationListener r1 = r3.getCommunicationListener()
            com.paytmmall.clpartifact.view.viewmodel.HomeResponse r3 = new com.paytmmall.clpartifact.view.viewmodel.HomeResponse
            r3.<init>()
            com.paytmmall.clpartifact.view.viewmodel.HomeResponse r1 = r1.getBundleResponse(r5, r3)
            boolean r3 = r1 instanceof com.paytmmall.clpartifact.view.viewmodel.HomeResponse
            if (r3 == 0) goto L_0x0063
            goto L_0x0064
        L_0x0063:
            r1 = r2
        L_0x0064:
            if (r1 == 0) goto L_0x007c
            com.paytmmall.clpartifact.network.Resource$Builder r2 = new com.paytmmall.clpartifact.network.Resource$Builder
            r2.<init>()
            com.paytmmall.clpartifact.network.Resource$Builder r1 = r2.body(r1)
            com.paytmmall.clpartifact.network.Status r2 = com.paytmmall.clpartifact.network.Status.SUCCESS
            com.paytmmall.clpartifact.network.Resource$Builder r1 = r1.status(r2)
            com.paytmmall.clpartifact.network.Resource r1 = r1.build()
            r0.setValue(r1)
        L_0x007c:
            com.paytmmall.clpartifact.utils.CategoryImpressionAndApiHandler r1 = com.paytmmall.clpartifact.utils.CategoryImpressionAndApiHandler.INSTANCE
            boolean r1 = r1.isFirstApiCallFromCategoryPopup()
            if (r1 == 0) goto L_0x0087
            r4.callCategoryAPI(r5, r7, r6, r0)
        L_0x0087:
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.widgets.component.smarticongrid.SmartIconGridRepository.getMoreResponse(android.content.Context, boolean, java.lang.String):androidx.lifecycle.LiveData");
    }

    private final HomeResponse getCacheData(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str != null ? (HomeResponse) SFGsonUtils.getPojo$default(SFGsonUtils.INSTANCE, f.a(str, context), HomeResponse.class, false, 4, (Object) null) : new HomeResponse();
    }

    private final LiveData<Resource<HomeResponse>> callCategoryAPI(Context context, String str, boolean z, y<Resource<HomeResponse>> yVar) {
        y<Resource<HomeResponse>> yVar2 = yVar;
        HashMap hashMap = new HashMap();
        String a2 = a.a(context);
        String q = a.q(context);
        if (!TextUtils.isEmpty(a2) && a.p(context)) {
            k.a((Object) a2, "userId");
            hashMap.put("user_id", a2);
        }
        if (!TextUtils.isEmpty(q)) {
            k.a((Object) q, "ssoToken");
            hashMap.put(AppConstants.SSO_TOKEN, q);
        }
        Map map = hashMap;
        map.put("Content-Type", "application/json");
        new HashMap().put("", this.TAG);
        com.paytm.network.a createRequest = createRequest(context, str, new SmartIconGridRepository$callCategoryAPI$request$1(yVar2, z), map, (Map<String, String>) null, a.C0715a.POST, (String) null, new StringResponseModel(), a.c.HOME, a.b.SILENT);
        if (com.paytm.utility.a.m(context)) {
            createRequest.a();
        }
        return yVar2;
    }

    private final com.paytm.network.a createRequest(Context context, String str, b bVar, Map<String, String> map, Map<String, String> map2, a.C0715a aVar, String str2, IJRPaytmDataModel iJRPaytmDataModel, a.c cVar, a.b bVar2) {
        boolean a2 = p.a((CharSequence) str, (CharSequence) "?", false);
        com.paytm.network.b a3 = new com.paytm.network.b().a(context).a(cVar).a(aVar).a(bVar2).c(context.getClass().getSimpleName()).a(str).a(iJRPaytmDataModel).a(bVar);
        if (map != null) {
            k.a((Object) a3, "networkCallBuilder");
            a3.a(map);
        }
        if (!TextUtils.isEmpty(str2)) {
            k.a((Object) a3, "networkCallBuilder");
            a3.b(str2);
        }
        if (map2 != null && (!map2.isEmpty())) {
            a3.b((Map) map2);
        }
        a3.a(!a2);
        com.paytm.network.a l = a3.l();
        k.a((Object) l, "networkCallBuilder.build()");
        return l;
    }
}
