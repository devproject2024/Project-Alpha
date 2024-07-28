package net.one97.paytm.phoenix.d;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import net.one97.paytm.phoenix.PhoenixManager;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.provider.UserWhitelistedForDeveloperModeCallback;
import net.one97.paytm.phoenix.ui.PhoenixActivity;
import net.one97.paytm.phoenix.util.j;

public final class ac extends net.one97.paytm.phoenix.core.a {
    public ac() {
        super("paytmOpenInDeveloperMode");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(net.one97.paytm.phoenix.api.H5Event r10, net.one97.paytm.phoenix.api.b r11) {
        /*
            r9 = this;
            java.lang.String r0 = "event"
            kotlin.g.b.k.c(r10, r0)
            java.lang.String r0 = "bridgeContext"
            kotlin.g.b.k.c(r11, r0)
            super.a((net.one97.paytm.phoenix.api.H5Event) r10, (net.one97.paytm.phoenix.api.b) r11)
            boolean r11 = r9.a((net.one97.paytm.phoenix.api.H5Event) r10)
            if (r11 == 0) goto L_0x00db
            android.app.Activity r11 = r10.getActivity()
            if (r11 == 0) goto L_0x0037
            android.app.Activity r11 = r10.getActivity()
            if (r11 != 0) goto L_0x0022
            kotlin.g.b.k.a()
        L_0x0022:
            boolean r11 = r11 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity
            if (r11 == 0) goto L_0x0037
            android.app.Activity r11 = r10.getActivity()
            if (r11 == 0) goto L_0x002f
            net.one97.paytm.phoenix.ui.PhoenixActivity r11 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r11
            goto L_0x0038
        L_0x002f:
            kotlin.u r10 = new kotlin.u
            java.lang.String r11 = "null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity"
            r10.<init>(r11)
            throw r10
        L_0x0037:
            r11 = 0
        L_0x0038:
            r2 = r11
            r11 = 0
            if (r2 != 0) goto L_0x003d
            return r11
        L_0x003d:
            net.one97.paytm.phoenix.core.c r0 = net.one97.paytm.phoenix.core.c.f59399a
            net.one97.paytm.phoenix.api.f r0 = r0.b()
            java.lang.Class<net.one97.paytm.phoenix.provider.PhoenixDeveloperModeWhitelisDataProvider> r1 = net.one97.paytm.phoenix.provider.PhoenixDeveloperModeWhitelisDataProvider.class
            java.lang.String r1 = r1.getName()
            java.lang.String r3 = "PhoenixDeveloperModeWhit…Provider::class.java.name"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            java.lang.Object r0 = r0.a(r1)
            r6 = r0
            net.one97.paytm.phoenix.provider.PhoenixDeveloperModeWhitelisDataProvider r6 = (net.one97.paytm.phoenix.provider.PhoenixDeveloperModeWhitelisDataProvider) r6
            if (r6 == 0) goto L_0x0061
            net.one97.paytm.phoenix.PhoenixManager r11 = net.one97.paytm.phoenix.PhoenixManager.INSTANCE
            java.lang.String r11 = r11.getLastOpenedAppUniqueId()
            boolean r11 = r6.isAppIdWhitelistedForDeveloperMode(r11)
        L_0x0061:
            if (r11 == 0) goto L_0x00b4
            org.json.JSONObject r11 = r10.getParams()
            java.lang.String r0 = ""
            if (r11 == 0) goto L_0x0076
            java.lang.String r1 = "aid"
            java.lang.String r1 = r11.getString(r1)
            if (r1 != 0) goto L_0x0074
            goto L_0x0076
        L_0x0074:
            r7 = r1
            goto L_0x0077
        L_0x0076:
            r7 = r0
        L_0x0077:
            if (r11 == 0) goto L_0x0084
            java.lang.String r1 = "url"
            java.lang.String r11 = r11.getString(r1)
            if (r11 != 0) goto L_0x0082
            goto L_0x0084
        L_0x0082:
            r4 = r11
            goto L_0x0085
        L_0x0084:
            r4 = r0
        L_0x0085:
            r11 = r7
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x00ac
            r11 = r4
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 == 0) goto L_0x0098
            goto L_0x00ac
        L_0x0098:
            if (r6 == 0) goto L_0x00db
            r11 = r2
            android.content.Context r11 = (android.content.Context) r11
            net.one97.paytm.phoenix.d.ac$a r8 = new net.one97.paytm.phoenix.d.ac$a
            r0 = r8
            r1 = r9
            r3 = r7
            r5 = r10
            r0.<init>(r1, r2, r3, r4, r5)
            net.one97.paytm.phoenix.provider.UserWhitelistedForDeveloperModeCallback r8 = (net.one97.paytm.phoenix.provider.UserWhitelistedForDeveloperModeCallback) r8
            r6.isUserWhitelistedForDeveloperMode(r11, r7, r8)
            goto L_0x00db
        L_0x00ac:
            net.one97.paytm.phoenix.api.a r11 = net.one97.paytm.phoenix.api.a.INVALID_PARAM
            java.lang.String r0 = "Aid or Url can't be empty"
            r9.a((net.one97.paytm.phoenix.api.H5Event) r10, (net.one97.paytm.phoenix.api.a) r11, (java.lang.String) r0)
            goto L_0x00db
        L_0x00b4:
            net.one97.paytm.phoenix.api.a r11 = net.one97.paytm.phoenix.api.a.FORBIDDEN
            java.lang.String r0 = "Aid Not allowed to use devMode"
            r9.a((net.one97.paytm.phoenix.api.H5Event) r10, (net.one97.paytm.phoenix.api.a) r11, (java.lang.String) r0)
            net.one97.paytm.phoenix.util.j r10 = net.one97.paytm.phoenix.util.j.f59646a
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "Aid "
            r10.<init>(r11)
            net.one97.paytm.phoenix.PhoenixManager r11 = net.one97.paytm.phoenix.PhoenixManager.INSTANCE
            java.lang.String r11 = r11.getLastOpenedAppUniqueId()
            r10.append(r11)
            java.lang.String r11 = " not allowed to use devMode"
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            java.lang.String r11 = "paytmOpenInDeveloperMode"
            net.one97.paytm.phoenix.util.j.c(r11, r10)
        L_0x00db:
            r10 = 1
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.ac.a(net.one97.paytm.phoenix.api.H5Event, net.one97.paytm.phoenix.api.b):boolean");
    }

    public static final class a implements UserWhitelistedForDeveloperModeCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ac f59451a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PhoenixActivity f59452b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f59453c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f59454d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ H5Event f59455e;

        a(ac acVar, PhoenixActivity phoenixActivity, String str, String str2, H5Event h5Event) {
            this.f59451a = acVar;
            this.f59452b = phoenixActivity;
            this.f59453c = str;
            this.f59454d = str2;
            this.f59455e = h5Event;
        }

        public final void onSuccess() {
            Bundle bundle = new Bundle();
            bundle.putBoolean("devModeEnabled", true);
            bundle.putBoolean("isFromDeeplink", PhoenixManager.INSTANCE.isFromDeepLinkStatus$phoenix_debug());
            androidx.localbroadcastmanager.a.a.a((Context) this.f59452b).a(new Intent("PHOENIX_EXIT_SESSION_INTENT"));
            PhoenixManager.loadPage$default(this.f59453c, this.f59454d, (PhoenixManager.a) null, bundle, (String) null, false, PhoenixManager.INSTANCE.getMapOfTempPlugins().get(this.f59453c), PhoenixManager.INSTANCE.getMapOfTempProviders().get(this.f59453c), this.f59452b, 48, (Object) null);
            this.f59451a.a("success", (Object) Boolean.TRUE);
            net.one97.paytm.phoenix.core.a.a(this.f59451a, this.f59455e, (Object) null, false, 6);
        }

        public final void onError() {
            this.f59451a.a(this.f59455e, net.one97.paytm.phoenix.api.a.FORBIDDEN, "Aid Not allowed to use devMode");
            j jVar = j.f59646a;
            j.c("paytmOpenInDeveloperMode", "Aid " + PhoenixManager.INSTANCE.getLastOpenedAppUniqueId() + " not allowed to use devMode");
        }
    }
}
