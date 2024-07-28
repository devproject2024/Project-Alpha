package net.one97.paytm.phoenix.d;

import android.content.Intent;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import kotlin.g.b.k;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.provider.PaytmPhoenixWhitelistAppDataProvider;
import net.one97.paytm.phoenix.ui.PhoenixActivity;

public final class w extends net.one97.paytm.phoenix.core.a {
    public w() {
        super("paytmSessionExpired", "paytmLogin", "paytmFetchAuthToken", "paytmLogout");
    }

    /* JADX WARNING: Removed duplicated region for block: B:114:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0065 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01e3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(net.one97.paytm.phoenix.api.H5Event r18, net.one97.paytm.phoenix.api.b r19) {
        /*
            r17 = this;
            r11 = r17
            r7 = r18
            java.lang.String r0 = "event"
            kotlin.g.b.k.c(r7, r0)
            java.lang.String r0 = "bridgeContext"
            r1 = r19
            kotlin.g.b.k.c(r1, r0)
            super.a((net.one97.paytm.phoenix.api.H5Event) r18, (net.one97.paytm.phoenix.api.b) r19)
            boolean r0 = r17.a((net.one97.paytm.phoenix.api.H5Event) r18)
            r12 = 1
            if (r0 == 0) goto L_0x0237
            net.one97.paytm.phoenix.core.c r0 = net.one97.paytm.phoenix.core.c.f59399a
            net.one97.paytm.phoenix.api.f r0 = r0.b()
            java.lang.Class<net.one97.paytm.phoenix.provider.PhoenixAuthProvider> r1 = net.one97.paytm.phoenix.provider.PhoenixAuthProvider.class
            java.lang.String r1 = r1.getName()
            java.lang.String r2 = "PhoenixAuthProvider::class.java.name"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            java.lang.Object r0 = r0.a(r1)
            r1 = r0
            net.one97.paytm.phoenix.provider.PhoenixAuthProvider r1 = (net.one97.paytm.phoenix.provider.PhoenixAuthProvider) r1
            if (r1 != 0) goto L_0x003b
            net.one97.paytm.phoenix.api.a r0 = net.one97.paytm.phoenix.api.a.FORBIDDEN
            java.lang.String r2 = "No Implementation found for 'AuthProvider'"
            r11.a((net.one97.paytm.phoenix.api.H5Event) r7, (net.one97.paytm.phoenix.api.a) r0, (java.lang.String) r2)
        L_0x003b:
            android.app.Activity r0 = r18.getActivity()
            r2 = 0
            if (r0 == 0) goto L_0x0061
            android.app.Activity r0 = r18.getActivity()
            if (r0 != 0) goto L_0x004b
            kotlin.g.b.k.a()
        L_0x004b:
            boolean r0 = r0 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity
            if (r0 == 0) goto L_0x0061
            android.app.Activity r0 = r18.getActivity()
            if (r0 == 0) goto L_0x0059
            net.one97.paytm.phoenix.ui.PhoenixActivity r0 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r0
            r13 = r0
            goto L_0x0062
        L_0x0059:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity"
            r0.<init>(r1)
            throw r0
        L_0x0061:
            r13 = r2
        L_0x0062:
            r3 = 0
            if (r13 != 0) goto L_0x0066
            return r3
        L_0x0066:
            org.json.JSONObject r0 = r18.getParams()
            java.lang.String r14 = r18.getAction$phoenix_debug()
            if (r0 == 0) goto L_0x0077
            java.lang.String r4 = "requestCode"
            java.lang.Object r4 = r0.opt(r4)
            goto L_0x0078
        L_0x0077:
            r4 = r2
        L_0x0078:
            boolean r5 = r4 instanceof java.lang.Integer
            if (r5 != 0) goto L_0x007d
            r4 = r2
        L_0x007d:
            java.lang.Integer r4 = (java.lang.Integer) r4
            if (r4 == 0) goto L_0x0087
            int r4 = r4.intValue()
            r15 = r4
            goto L_0x008b
        L_0x0087:
            r4 = 56
            r15 = 56
        L_0x008b:
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>(r12)
            if (r0 == 0) goto L_0x00b2
            java.util.Iterator r4 = r0.keys()
        L_0x0096:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00b2
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r8 = r0.opt(r5)
            r9 = r6
            java.util.Map r9 = (java.util.Map) r9
            java.lang.String r10 = "key"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r10)
            r9.put(r5, r8)
            goto L_0x0096
        L_0x00b2:
            if (r0 == 0) goto L_0x00c1
            java.lang.String r4 = "logoutAllDevices"
            boolean r0 = r0.getBoolean(r4)     // Catch:{ Exception -> 0x00bb }
            goto L_0x00c2
        L_0x00bb:
            r0 = move-exception
            r0.printStackTrace()
            r9 = 0
            goto L_0x00c3
        L_0x00c1:
            r0 = 0
        L_0x00c2:
            r9 = r0
        L_0x00c3:
            net.one97.paytm.phoenix.core.c r0 = net.one97.paytm.phoenix.core.c.f59399a
            net.one97.paytm.phoenix.api.f r0 = r0.b()
            java.lang.Class<net.one97.paytm.phoenix.provider.PaytmPhoenixWhitelistAppDataProvider> r4 = net.one97.paytm.phoenix.provider.PaytmPhoenixWhitelistAppDataProvider.class
            java.lang.String r4 = r4.getName()
            java.lang.String r5 = "PaytmPhoenixWhitelistApp…Provider::class.java.name"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            java.lang.Object r0 = r0.a(r4)
            r10 = r0
            net.one97.paytm.phoenix.provider.PaytmPhoenixWhitelistAppDataProvider r10 = (net.one97.paytm.phoenix.provider.PaytmPhoenixWhitelistAppDataProvider) r10
            if (r14 != 0) goto L_0x00df
            goto L_0x0237
        L_0x00df:
            int r0 = r14.hashCode()
            r4 = 6
            java.lang.String r5 = "success"
            switch(r0) {
                case -567028024: goto L_0x0203;
                case -397993461: goto L_0x01bc;
                case -293618896: goto L_0x0188;
                case 128267032: goto L_0x00eb;
                default: goto L_0x00e9;
            }
        L_0x00e9:
            goto L_0x0237
        L_0x00eb:
            java.lang.String r0 = "paytmFetchAuthToken"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x0237
            if (r1 == 0) goto L_0x00fd
            r0 = r13
            android.app.Activity r0 = (android.app.Activity) r0
            net.one97.paytm.phoenix.provider.PhoenixAuthProvider$AuthData r0 = r1.provideAuthToken(r0)
            goto L_0x00fe
        L_0x00fd:
            r0 = r2
        L_0x00fe:
            if (r0 == 0) goto L_0x017f
            if (r10 == 0) goto L_0x017f
            java.lang.String r1 = r13.f59606d
            boolean r1 = r10.isAppWhitelisted(r1)
            java.lang.String r4 = r0.getAuthToken()
            if (r4 == 0) goto L_0x011a
            java.lang.String r4 = r0.getAuthToken()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x011b
        L_0x011a:
            r3 = 1
        L_0x011b:
            java.lang.String r4 = "message"
            java.lang.String r6 = "error"
            if (r1 == 0) goto L_0x0163
            if (r3 == 0) goto L_0x013f
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r11.a((java.lang.String) r5, (java.lang.Object) r0)
            net.one97.paytm.phoenix.api.a r0 = net.one97.paytm.phoenix.api.a.INVALID_PARAM
            int r0 = r0.ordinal()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r11.a((java.lang.String) r6, (java.lang.Object) r0)
            java.lang.String r0 = "No sso token!"
            r11.a((java.lang.String) r4, (java.lang.Object) r0)
            r11.a((net.one97.paytm.phoenix.api.H5Event) r7, (java.lang.Object) r2, (boolean) r12)
            goto L_0x0237
        L_0x013f:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r11.a((java.lang.String) r5, (java.lang.Object) r1)
            java.lang.String r1 = r0.getAuthToken()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r3 = "data"
            r11.a((java.lang.String) r3, (java.lang.Object) r1)
            java.lang.String r0 = r0.getAuthorizationValue()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "authorization"
            r11.a((java.lang.String) r1, (java.lang.Object) r0)
            r11.a((net.one97.paytm.phoenix.api.H5Event) r7, (java.lang.Object) r2, (boolean) r12)
            goto L_0x0237
        L_0x0163:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r11.a((java.lang.String) r5, (java.lang.Object) r0)
            net.one97.paytm.phoenix.api.a r0 = net.one97.paytm.phoenix.api.a.INVALID_PARAM
            int r0 = r0.ordinal()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r11.a((java.lang.String) r6, (java.lang.Object) r0)
            java.lang.String r0 = "Not authorized!"
            r11.a((java.lang.String) r4, (java.lang.Object) r0)
            r11.a((net.one97.paytm.phoenix.api.H5Event) r7, (java.lang.Object) r2, (boolean) r12)
            goto L_0x0237
        L_0x017f:
            net.one97.paytm.phoenix.api.a r0 = net.one97.paytm.phoenix.api.a.NOT_FOUND
            java.lang.String r1 = "Not found"
            r11.a((net.one97.paytm.phoenix.api.H5Event) r7, (net.one97.paytm.phoenix.api.a) r0, (java.lang.String) r1)
            goto L_0x0237
        L_0x0188:
            java.lang.String r0 = "paytmSessionExpired"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x0237
            if (r1 == 0) goto L_0x019d
            android.app.Activity r13 = (android.app.Activity) r13
            boolean r0 = r1.sessionExpired(r13, r6)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x019e
        L_0x019d:
            r0 = r2
        L_0x019e:
            if (r0 == 0) goto L_0x0237
            r0.booleanValue()
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x01b3
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r11.a((java.lang.String) r5, (java.lang.Object) r0)
            net.one97.paytm.phoenix.core.a.a(r11, r7, r2, r3, r4)
            goto L_0x0237
        L_0x01b3:
            net.one97.paytm.phoenix.api.a r0 = net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR
            java.lang.String r1 = "cannot expire session"
            r11.a((net.one97.paytm.phoenix.api.H5Event) r7, (net.one97.paytm.phoenix.api.a) r0, (java.lang.String) r1)
            goto L_0x0237
        L_0x01bc:
            java.lang.String r0 = "paytmLogout"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x0237
            if (r9 == 0) goto L_0x01d3
            if (r1 == 0) goto L_0x01e0
            android.app.Activity r13 = (android.app.Activity) r13
            boolean r0 = r1.logoutAllDevices(r13, r6)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x01e1
        L_0x01d3:
            if (r1 == 0) goto L_0x01e0
            android.app.Activity r13 = (android.app.Activity) r13
            boolean r0 = r1.logout(r13, r6)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x01e1
        L_0x01e0:
            r0 = r2
        L_0x01e1:
            if (r0 == 0) goto L_0x0237
            r0.booleanValue()
            boolean r1 = r0.booleanValue()
            if (r1 == 0) goto L_0x0237
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x01fb
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r11.a((java.lang.String) r5, (java.lang.Object) r0)
            net.one97.paytm.phoenix.core.a.a(r11, r7, r2, r3, r4)
            goto L_0x0237
        L_0x01fb:
            net.one97.paytm.phoenix.api.a r0 = net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR
            java.lang.String r1 = "cannot logout"
            r11.a((net.one97.paytm.phoenix.api.H5Event) r7, (net.one97.paytm.phoenix.api.a) r0, (java.lang.String) r1)
            goto L_0x0237
        L_0x0203:
            java.lang.String r0 = "paytmLogin"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x0237
            if (r1 == 0) goto L_0x0215
            r0 = r13
            android.app.Activity r0 = (android.app.Activity) r0
            android.content.Intent r0 = r1.login(r0, r6)
            goto L_0x0216
        L_0x0215:
            r0 = r2
        L_0x0216:
            if (r0 == 0) goto L_0x0237
            net.one97.paytm.phoenix.ui.PhoenixActivity$a r1 = r13.m
            r8 = r1
            java.util.Observable r8 = (java.util.Observable) r8
            net.one97.paytm.phoenix.d.w$a r16 = new net.one97.paytm.phoenix.d.w$a
            r1 = r16
            r2 = r0
            r3 = r17
            r4 = r14
            r5 = r13
            r7 = r18
            r12 = r8
            r8 = r15
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r1 = r16
            java.util.Observer r1 = (java.util.Observer) r1
            r12.addObserver(r1)
            r13.a(r0, r15, r14)
        L_0x0237:
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.w.a(net.one97.paytm.phoenix.api.H5Event, net.one97.paytm.phoenix.api.b):boolean");
    }

    static final class a implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Intent f59563a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ w f59564b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f59565c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ PhoenixActivity f59566d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ HashMap f59567e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ H5Event f59568f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ int f59569g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ boolean f59570h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ PaytmPhoenixWhitelistAppDataProvider f59571i;

        a(Intent intent, w wVar, String str, PhoenixActivity phoenixActivity, HashMap hashMap, H5Event h5Event, int i2, boolean z, PaytmPhoenixWhitelistAppDataProvider paytmPhoenixWhitelistAppDataProvider) {
            this.f59563a = intent;
            this.f59564b = wVar;
            this.f59565c = str;
            this.f59566d = phoenixActivity;
            this.f59567e = hashMap;
            this.f59568f = h5Event;
            this.f59569g = i2;
            this.f59570h = z;
            this.f59571i = paytmPhoenixWhitelistAppDataProvider;
        }

        public final void update(Observable observable, Object obj) {
            w wVar = this.f59564b;
            if (k.a(obj, (Object) Boolean.FALSE)) {
                wVar.a("success", (Object) Boolean.FALSE);
            } else if (obj != null) {
                wVar.a("success", obj);
            } else {
                wVar.a("success", (Object) Boolean.TRUE);
            }
            net.one97.paytm.phoenix.core.a.a(wVar, this.f59568f, (Object) null, false, 6);
            this.f59566d.m.deleteObservers();
        }
    }
}
