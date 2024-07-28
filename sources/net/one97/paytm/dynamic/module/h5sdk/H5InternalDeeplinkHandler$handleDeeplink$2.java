package net.one97.paytm.dynamic.module.h5sdk;

import android.os.Bundle;
import kotlin.g.b.x;
import net.one97.paytm.h5.b.c;
import net.one97.paytm.h5paytmsdk.PaytmH5Manager;
import net.one97.paytm.phoenix.PhoenixManager;

public final class H5InternalDeeplinkHandler$handleDeeplink$2 implements c.a {
    final /* synthetic */ x.e $appId;
    final /* synthetic */ String $deeplink;
    final /* synthetic */ Bundle $extraData;
    final /* synthetic */ x.e $path;
    final /* synthetic */ x.a $phoenixFlag;
    final /* synthetic */ x.e $qParam;
    final /* synthetic */ x.e $sParamsFromDeepLink;

    H5InternalDeeplinkHandler$handleDeeplink$2(x.e eVar, x.e eVar2, x.e eVar3, Bundle bundle, String str, x.a aVar, x.e eVar4) {
        this.$path = eVar;
        this.$qParam = eVar2;
        this.$sParamsFromDeepLink = eVar3;
        this.$extraData = bundle;
        this.$deeplink = str;
        this.$phoenixFlag = aVar;
        this.$appId = eVar4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008c, code lost:
        r1 = (r1 = r1.getMetaInfo()).getStartupParams();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x012b, code lost:
        if (r1 == null) goto L_0x012d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onAppDataFetched(net.one97.paytm.h5.model.H5AppDetailsForUserModel r14) {
        /*
            r13 = this;
            if (r14 == 0) goto L_0x02dd
            net.one97.paytm.h5.model.H5AppDataResponseModel r0 = r14.getResponse()
            if (r0 == 0) goto L_0x02cd
            net.one97.paytm.h5.model.H5AppMetaInfoModel r0 = r0.getMetaInfo()
            if (r0 == 0) goto L_0x02cd
            net.one97.paytm.h5.model.H5AppUrlInfoModel r0 = r0.getUrlMetaInfo()
            if (r0 == 0) goto L_0x02cd
            java.lang.String r0 = r0.getAppDeepLink()
            if (r0 == 0) goto L_0x02cd
            java.lang.String r1 = java.lang.String.valueOf(r0)
            java.lang.String r2 = "handleDeeplink() url:"
            r2.concat(r1)
            com.alipay.iap.android.common.b.c.c()
            kotlin.g.b.x$e r1 = r13.$path
            T r1 = r1.element
            java.lang.String r1 = (java.lang.String) r1
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x0053
            kotlin.g.b.x$e r1 = r13.$path
            net.one97.paytm.h5.model.H5AppDataResponseModel r3 = r14.getResponse()
            if (r3 == 0) goto L_0x0050
            net.one97.paytm.h5.model.H5AppMetaInfoModel r3 = r3.getMetaInfo()
            if (r3 == 0) goto L_0x0050
            net.one97.paytm.h5.model.H5AppStartupParamsModel r3 = r3.getStartupParams()
            if (r3 == 0) goto L_0x0050
            java.lang.String r3 = r3.getPath()
            if (r3 != 0) goto L_0x0051
        L_0x0050:
            r3 = r2
        L_0x0051:
            r1.element = r3
        L_0x0053:
            kotlin.g.b.x$e r1 = r13.$qParam
            T r1 = r1.element
            java.lang.String r1 = (java.lang.String) r1
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x007f
            kotlin.g.b.x$e r1 = r13.$qParam
            net.one97.paytm.h5.model.H5AppDataResponseModel r3 = r14.getResponse()
            if (r3 == 0) goto L_0x007d
            net.one97.paytm.h5.model.H5AppMetaInfoModel r3 = r3.getMetaInfo()
            if (r3 == 0) goto L_0x007d
            net.one97.paytm.h5.model.H5AppStartupParamsModel r3 = r3.getStartupParams()
            if (r3 == 0) goto L_0x007d
            java.lang.String r3 = r3.getParams()
            if (r3 != 0) goto L_0x007c
            goto L_0x007d
        L_0x007c:
            r2 = r3
        L_0x007d:
            r1.element = r2
        L_0x007f:
            net.one97.paytm.h5.model.H5AppDataResponseModel r1 = r14.getResponse()
            r2 = 0
            if (r1 == 0) goto L_0x0097
            net.one97.paytm.h5.model.H5AppMetaInfoModel r1 = r1.getMetaInfo()
            if (r1 == 0) goto L_0x0097
            net.one97.paytm.h5.model.H5AppStartupParamsModel r1 = r1.getStartupParams()
            if (r1 == 0) goto L_0x0097
            java.util.HashMap r1 = r1.getSparams()
            goto L_0x0098
        L_0x0097:
            r1 = r2
        L_0x0098:
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            if (r1 == 0) goto L_0x012d
            kotlin.g.b.x$e r5 = r13.$sParamsFromDeepLink
            T r5 = r5.element
            org.json.JSONObject r5 = (org.json.JSONObject) r5
            if (r5 == 0) goto L_0x00c2
            int r5 = r5.length()
            if (r5 != 0) goto L_0x00c2
            net.one97.paytm.dynamic.module.h5sdk.H5InternalDeeplinkHandler r3 = net.one97.paytm.dynamic.module.h5sdk.H5InternalDeeplinkHandler.INSTANCE
            org.json.JSONObject r5 = new org.json.JSONObject
            java.util.Map r1 = (java.util.Map) r1
            r5.<init>(r1)
            r3.addJsonDataInBundle(r4, r5)
            kotlin.x r1 = kotlin.x.f47997a
            goto L_0x012b
        L_0x00c2:
            kotlin.g.b.x$e r5 = r13.$sParamsFromDeepLink
            T r5 = r5.element
            org.json.JSONObject r5 = (org.json.JSONObject) r5
            if (r5 == 0) goto L_0x00cf
            java.util.Iterator r5 = r5.keys()
            goto L_0x00d0
        L_0x00cf:
            r5 = r2
        L_0x00d0:
            if (r5 == 0) goto L_0x012a
        L_0x00d2:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00fe
            java.lang.Object r6 = r5.next()
            java.lang.String r7 = "it.next()"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            java.lang.String r6 = (java.lang.String) r6
            kotlin.g.b.x$e r7 = r13.$sParamsFromDeepLink
            T r7 = r7.element
            org.json.JSONObject r7 = (org.json.JSONObject) r7
            if (r7 == 0) goto L_0x00f0
            java.lang.Object r7 = r7.opt(r6)
            goto L_0x00f1
        L_0x00f0:
            r7 = r2
        L_0x00f1:
            r3.put(r6, r7)
            boolean r7 = r1.containsKey(r6)
            if (r7 == 0) goto L_0x00d2
            r1.remove(r6)
            goto L_0x00d2
        L_0x00fe:
            java.util.Map r1 = (java.util.Map) r1
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0108:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x0122
            java.lang.Object r5 = r1.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r6 = r5.getKey()
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r5 = r5.getValue()
            r3.put(r6, r5)
            goto L_0x0108
        L_0x0122:
            net.one97.paytm.dynamic.module.h5sdk.H5InternalDeeplinkHandler r1 = net.one97.paytm.dynamic.module.h5sdk.H5InternalDeeplinkHandler.INSTANCE
            r1.addJsonDataInBundle(r4, r3)
            kotlin.x r1 = kotlin.x.f47997a
            goto L_0x012b
        L_0x012a:
            r1 = r2
        L_0x012b:
            if (r1 != 0) goto L_0x013c
        L_0x012d:
            kotlin.g.b.x$e r1 = r13.$sParamsFromDeepLink
            T r1 = r1.element
            org.json.JSONObject r1 = (org.json.JSONObject) r1
            if (r1 == 0) goto L_0x013c
            net.one97.paytm.dynamic.module.h5sdk.H5InternalDeeplinkHandler r3 = net.one97.paytm.dynamic.module.h5sdk.H5InternalDeeplinkHandler.INSTANCE
            r3.addJsonDataInBundle(r4, r1)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x013c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "bundle for phoenix: "
            r1.<init>(r3)
            java.lang.String r3 = r4.toString()
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            com.paytm.utility.q.d(r1)
            android.os.Bundle r1 = r13.$extraData
            net.one97.paytm.h5.model.H5AppDataResponseModel r3 = r14.getResponse()
            if (r3 == 0) goto L_0x015e
            java.lang.String r3 = r3.getAppName()
            goto L_0x015f
        L_0x015e:
            r3 = r2
        L_0x015f:
            java.lang.String r5 = "app_name"
            r1.putString(r5, r3)
            android.os.Bundle r1 = r13.$extraData
            net.one97.paytm.h5.model.H5AppDataResponseModel r3 = r14.getResponse()
            if (r3 == 0) goto L_0x0177
            net.one97.paytm.h5.model.H5AppMetaInfoModel r3 = r3.getMetaInfo()
            if (r3 == 0) goto L_0x0177
            java.lang.String r3 = r3.getCategoryName()
            goto L_0x0178
        L_0x0177:
            r3 = r2
        L_0x0178:
            java.lang.String r5 = "category"
            r1.putString(r5, r3)
            android.os.Bundle r1 = r13.$extraData
            net.one97.paytm.h5.model.H5AppDataResponseModel r3 = r14.getResponse()
            if (r3 == 0) goto L_0x0190
            net.one97.paytm.h5.model.H5AppMetaInfoModel r3 = r3.getMetaInfo()
            if (r3 == 0) goto L_0x0190
            java.lang.String r3 = r3.getTitle()
            goto L_0x0191
        L_0x0190:
            r3 = r2
        L_0x0191:
            java.lang.String r5 = "title"
            r1.putString(r5, r3)
            android.os.Bundle r1 = r13.$extraData
            net.one97.paytm.h5.model.H5AppDataResponseModel r3 = r14.getResponse()
            if (r3 == 0) goto L_0x01aa
            net.one97.paytm.h5.model.H5AppMetaInfoModel r3 = r3.getMetaInfo()
            if (r3 == 0) goto L_0x01aa
            java.lang.String r3 = r3.getSubtitle()
            goto L_0x01ab
        L_0x01aa:
            r3 = r2
        L_0x01ab:
            java.lang.String r5 = "subtitle"
            r1.putString(r5, r3)
            android.os.Bundle r1 = r13.$extraData
            java.lang.String r3 = r13.$deeplink
            java.lang.String r5 = "deeplink"
            r1.putString(r5, r3)
            android.os.Bundle r1 = r13.$extraData
            net.one97.paytm.h5.model.H5AppDataResponseModel r3 = r14.getResponse()
            if (r3 == 0) goto L_0x01d3
            net.one97.paytm.h5.model.H5AppMetaInfoModel r3 = r3.getMetaInfo()
            if (r3 == 0) goto L_0x01d3
            net.one97.paytm.h5.model.H5AppUrlInfoModel r3 = r3.getUrlMetaInfo()
            if (r3 == 0) goto L_0x01d3
            java.lang.String r3 = r3.getIcon()
            goto L_0x01d4
        L_0x01d3:
            r3 = r2
        L_0x01d4:
            java.lang.String r5 = "icon"
            r1.putString(r5, r3)
            android.os.Bundle r1 = r13.$extraData
            net.one97.paytm.h5.model.H5AppDataResponseModel r3 = r14.getResponse()
            if (r3 == 0) goto L_0x01e5
            java.lang.String r2 = r3.getAppType()
        L_0x01e5:
            java.lang.String r3 = "appType"
            r1.putString(r3, r2)
            android.os.Bundle r1 = r13.$extraData
            kotlin.g.b.x$e r2 = r13.$path
            T r2 = r2.element
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = "path"
            r1.putString(r3, r2)
            android.os.Bundle r1 = r13.$extraData
            kotlin.g.b.x$e r2 = r13.$qParam
            T r2 = r2.element
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = "qParam"
            r1.putString(r3, r2)
            android.os.Bundle r1 = r13.$extraData
            java.lang.String r2 = "sParams"
            r1.putBundle(r2, r4)
            kotlin.g.b.x$a r1 = r13.$phoenixFlag
            net.one97.paytm.h5.model.H5AppDataResponseModel r14 = r14.getResponse()
            java.lang.String r2 = "appData.response"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r2)
            java.lang.Boolean r14 = r14.getPhoenixStatus()
            if (r14 == 0) goto L_0x0221
            boolean r14 = r14.booleanValue()
            goto L_0x0222
        L_0x0221:
            r14 = 1
        L_0x0222:
            r1.element = r14
            kotlin.g.b.x$a r14 = r13.$phoenixFlag
            boolean r14 = r14.element
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.CharSequence"
            if (r14 == 0) goto L_0x027d
            net.one97.paytm.dynamic.module.h5sdk.PhoenixManagerImpl r14 = net.one97.paytm.dynamic.module.h5sdk.PhoenixManagerImpl.INSTANCE
            kotlin.g.b.x$e r2 = r13.$appId
            T r2 = r2.element
            java.lang.String r2 = (java.lang.String) r2
            r14.addAppListingData(r2)
            kotlin.g.b.x$e r14 = r13.$appId
            T r14 = r14.element
            r2 = r14
            java.lang.String r2 = (java.lang.String) r2
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            if (r0 == 0) goto L_0x0277
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.CharSequence r0 = kotlin.m.p.b(r0)
            java.lang.String r0 = r0.toString()
            r14.append(r0)
            kotlin.g.b.x$e r0 = r13.$path
            T r0 = r0.element
            java.lang.String r0 = (java.lang.String) r0
            r14.append(r0)
            kotlin.g.b.x$e r0 = r13.$qParam
            T r0 = r0.element
            java.lang.String r0 = (java.lang.String) r0
            r14.append(r0)
            java.lang.String r3 = r14.toString()
            r4 = 0
            android.os.Bundle r5 = r13.$extraData
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 496(0x1f0, float:6.95E-43)
            r12 = 0
            net.one97.paytm.phoenix.PhoenixManager.loadPage$default(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        L_0x0277:
            kotlin.u r14 = new kotlin.u
            r14.<init>(r1)
            throw r14
        L_0x027d:
            net.one97.paytm.dynamic.module.h5sdk.PaytmH5ManagerImpl r14 = net.one97.paytm.dynamic.module.h5sdk.PaytmH5ManagerImpl.INSTANCE
            kotlin.g.b.x$e r2 = r13.$appId
            T r2 = r2.element
            java.lang.String r2 = (java.lang.String) r2
            r14.addAppListingData(r2)
            kotlin.g.b.x$e r14 = r13.$appId
            T r14 = r14.element
            r2 = r14
            java.lang.String r2 = (java.lang.String) r2
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            if (r0 == 0) goto L_0x02c7
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.CharSequence r0 = kotlin.m.p.b(r0)
            java.lang.String r0 = r0.toString()
            r14.append(r0)
            kotlin.g.b.x$e r0 = r13.$path
            T r0 = r0.element
            java.lang.String r0 = (java.lang.String) r0
            r14.append(r0)
            kotlin.g.b.x$e r0 = r13.$qParam
            T r0 = r0.element
            java.lang.String r0 = (java.lang.String) r0
            r14.append(r0)
            java.lang.String r3 = r14.toString()
            r4 = 0
            android.os.Bundle r5 = r13.$extraData
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 240(0xf0, float:3.36E-43)
            r11 = 0
            net.one97.paytm.h5paytmsdk.PaytmH5Manager.loadPage$default(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        L_0x02c7:
            kotlin.u r14 = new kotlin.u
            r14.<init>(r1)
            throw r14
        L_0x02cd:
            kotlin.g.b.x$a r14 = r13.$phoenixFlag
            boolean r14 = r14.element
            java.lang.String r0 = "ADN"
            if (r14 == 0) goto L_0x02d9
            net.one97.paytm.phoenix.PhoenixManager.loadError(r0)
            return
        L_0x02d9:
            net.one97.paytm.h5paytmsdk.PaytmH5Manager.loadError(r0)
            return
        L_0x02dd:
            kotlin.g.b.x$a r14 = r13.$phoenixFlag
            boolean r14 = r14.element
            java.lang.String r0 = "AN"
            if (r14 == 0) goto L_0x02e9
            net.one97.paytm.phoenix.PhoenixManager.loadError(r0)
            return
        L_0x02e9:
            net.one97.paytm.h5paytmsdk.PaytmH5Manager.loadError(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.dynamic.module.h5sdk.H5InternalDeeplinkHandler$handleDeeplink$2.onAppDataFetched(net.one97.paytm.h5.model.H5AppDetailsForUserModel):void");
    }

    public final void onError(String str) {
        if (this.$phoenixFlag.element) {
            PhoenixManager.loadError(str);
        } else {
            PaytmH5Manager.loadError(str);
        }
    }
}
