package net.one97.paytm.h5paytmsdk.b;

public final class af extends ad {
    public af() {
        super("paytmShowTitleBar", "paytmChangeStatusBarColor");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0057, code lost:
        if (r5 == null) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a8, code lost:
        if (r5 == null) goto L_0x00aa;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleEvent(com.alipay.mobile.h5container.api.H5Event r7, com.alipay.mobile.h5container.api.H5BridgeContext r8) {
        /*
            r6 = this;
            super.handleEvent(r7, r8)
            boolean r8 = r6.a((com.alipay.mobile.h5container.api.H5Event) r7)
            r0 = 1
            if (r8 == 0) goto L_0x00b4
            if (r7 == 0) goto L_0x00b4
            java.lang.String r8 = r7.getAction()
            if (r8 == 0) goto L_0x00b4
            int r1 = r8.hashCode()
            r2 = -1994296199(0xffffffff89217479, float:-1.9434435E-33)
            java.lang.String r3 = "success"
            r4 = 0
            r5 = 0
            if (r1 == r2) goto L_0x0063
            r2 = -986139725(0xffffffffc538b3b3, float:-2955.2312)
            if (r1 == r2) goto L_0x0027
            goto L_0x00b4
        L_0x0027:
            java.lang.String r1 = "paytmChangeStatusBarColor"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x00b4
            com.alibaba.a.e r8 = r7.getParam()
            java.lang.String r1 = "color"
            java.lang.String r8 = r8.getString(r1)
            if (r8 == 0) goto L_0x0059
            android.app.Activity r7 = r7.getActivity()
            if (r7 == 0) goto L_0x0057
            boolean r1 = r7 instanceof net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity
            if (r1 == 0) goto L_0x004b
            net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity r7 = (net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity) r7
            boolean r4 = r7.a((java.lang.String) r8)
        L_0x004b:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r4)
            r6.a((java.lang.String) r3, (java.lang.Object) r7)
            r6.a((java.lang.Object) r5)
            kotlin.x r5 = kotlin.x.f47997a
        L_0x0057:
            if (r5 != 0) goto L_0x00b4
        L_0x0059:
            com.alipay.mobile.h5container.api.H5Event$Error r7 = com.alipay.mobile.h5container.api.H5Event.Error.INVALID_PARAM
            java.lang.String r8 = "color empty!"
            r6.a((com.alipay.mobile.h5container.api.H5Event.Error) r7, (java.lang.String) r8)
            kotlin.x r7 = kotlin.x.f47997a
            goto L_0x00b4
        L_0x0063:
            java.lang.String r1 = "paytmShowTitleBar"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x00b4
            com.alibaba.a.e r8 = r7.getParam()
            java.lang.String r1 = "value"
            java.lang.Boolean r8 = r8.getBoolean(r1)
            if (r8 == 0) goto L_0x00aa
            boolean r8 = r8.booleanValue()
            android.app.Activity r7 = r7.getActivity()
            if (r7 == 0) goto L_0x00a8
            boolean r1 = r7 instanceof net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity
            if (r1 == 0) goto L_0x009e
            net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity r7 = (net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity) r7
            if (r8 == 0) goto L_0x009b
            com.alipay.iap.android.common.b.c.c()
            r7.n = r0
            int r8 = net.one97.paytm.h5paytmsdk.R.id.h5_title_bar_layout
            android.view.View r7 = r7.findViewById(r8)
            if (r7 == 0) goto L_0x009e
            r7.setVisibility(r4)
            goto L_0x009e
        L_0x009b:
            r7.b()
        L_0x009e:
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            r6.a((java.lang.String) r3, (java.lang.Object) r7)
            r6.a((java.lang.Object) r5)
            kotlin.x r5 = kotlin.x.f47997a
        L_0x00a8:
            if (r5 != 0) goto L_0x00b4
        L_0x00aa:
            com.alipay.mobile.h5container.api.H5Event$Error r7 = com.alipay.mobile.h5container.api.H5Event.Error.INVALID_PARAM
            java.lang.String r8 = "value empty!"
            r6.a((com.alipay.mobile.h5container.api.H5Event.Error) r7, (java.lang.String) r8)
            kotlin.x r7 = kotlin.x.f47997a
        L_0x00b4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.h5paytmsdk.b.af.handleEvent(com.alipay.mobile.h5container.api.H5Event, com.alipay.mobile.h5container.api.H5BridgeContext):boolean");
    }
}
