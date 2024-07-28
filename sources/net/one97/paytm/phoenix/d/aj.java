package net.one97.paytm.phoenix.d;

import android.text.TextUtils;
import kotlin.g.b.k;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.provider.PhoenixGenerateShortLinkProviderCallback;

public final class aj extends net.one97.paytm.phoenix.core.a {
    public aj() {
        super("paytmGenerateShortlink");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(net.one97.paytm.phoenix.api.H5Event r9, net.one97.paytm.phoenix.api.b r10) {
        /*
            r8 = this;
            java.lang.String r0 = "event"
            kotlin.g.b.k.c(r9, r0)
            java.lang.String r0 = "bridgeContext"
            kotlin.g.b.k.c(r10, r0)
            super.a((net.one97.paytm.phoenix.api.H5Event) r9, (net.one97.paytm.phoenix.api.b) r10)
            boolean r10 = r8.a((net.one97.paytm.phoenix.api.H5Event) r9)
            if (r10 == 0) goto L_0x00b4
            net.one97.paytm.phoenix.core.c r10 = net.one97.paytm.phoenix.core.c.f59399a
            net.one97.paytm.phoenix.api.f r10 = r10.b()
            java.lang.Class<net.one97.paytm.phoenix.provider.PhoenixGenerateShortLinkProvider> r0 = net.one97.paytm.phoenix.provider.PhoenixGenerateShortLinkProvider.class
            java.lang.String r0 = r0.getName()
            java.lang.String r1 = "PhoenixGenerateShortLinkProvider::class.java.name"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.Object r10 = r10.a(r0)
            net.one97.paytm.phoenix.provider.PhoenixGenerateShortLinkProvider r10 = (net.one97.paytm.phoenix.provider.PhoenixGenerateShortLinkProvider) r10
            r0 = 0
            if (r10 != 0) goto L_0x0035
            net.one97.paytm.phoenix.api.a r10 = net.one97.paytm.phoenix.api.a.FORBIDDEN
            java.lang.String r1 = "No implementation found for 'PhoenixGenerateShortLinkProvider'"
            r8.a((net.one97.paytm.phoenix.api.H5Event) r9, (net.one97.paytm.phoenix.api.a) r10, (java.lang.String) r1)
            return r0
        L_0x0035:
            android.app.Activity r1 = r9.getActivity()
            r2 = 0
            if (r1 == 0) goto L_0x005a
            android.app.Activity r1 = r9.getActivity()
            if (r1 != 0) goto L_0x0045
            kotlin.g.b.k.a()
        L_0x0045:
            boolean r1 = r1 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity
            if (r1 == 0) goto L_0x005a
            android.app.Activity r1 = r9.getActivity()
            if (r1 == 0) goto L_0x0052
            net.one97.paytm.phoenix.ui.PhoenixActivity r1 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r1
            goto L_0x005b
        L_0x0052:
            kotlin.u r9 = new kotlin.u
            java.lang.String r10 = "null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity"
            r9.<init>(r10)
            throw r9
        L_0x005a:
            r1 = r2
        L_0x005b:
            if (r1 != 0) goto L_0x005e
            return r0
        L_0x005e:
            org.json.JSONObject r0 = r9.getParams()
            if (r0 == 0) goto L_0x006a
            java.lang.String r2 = "parameters"
            org.json.JSONObject r2 = r0.optJSONObject(r2)
        L_0x006a:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            if (r2 == 0) goto L_0x00af
            int r3 = r2.length()
            if (r3 != 0) goto L_0x0078
            goto L_0x00af
        L_0x0078:
            java.util.Iterator r3 = r2.keys()
            java.lang.String r4 = "parameters.keys()"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
        L_0x0081:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x00a2
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            r5 = r0
            java.util.Map r5 = (java.util.Map) r5
            java.lang.String r6 = "key"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            java.lang.String r6 = r2.optString(r4)
            java.lang.String r7 = "parameters.optString(key)"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            r5.put(r4, r6)
            goto L_0x0081
        L_0x00a2:
            android.content.Context r1 = (android.content.Context) r1
            net.one97.paytm.phoenix.d.aj$a r2 = new net.one97.paytm.phoenix.d.aj$a
            r2.<init>(r8, r9)
            net.one97.paytm.phoenix.provider.PhoenixGenerateShortLinkProviderCallback r2 = (net.one97.paytm.phoenix.provider.PhoenixGenerateShortLinkProviderCallback) r2
            r10.generateShortLink(r1, r0, r2)
            goto L_0x00b4
        L_0x00af:
            net.one97.paytm.phoenix.api.a r10 = net.one97.paytm.phoenix.api.a.INVALID_PARAM
            r8.a((net.one97.paytm.phoenix.api.H5Event) r9, (net.one97.paytm.phoenix.api.a) r10, "")
        L_0x00b4:
            r9 = 1
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.aj.a(net.one97.paytm.phoenix.api.H5Event, net.one97.paytm.phoenix.api.b):boolean");
    }

    public static final class a implements PhoenixGenerateShortLinkProviderCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ aj f59501a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ H5Event f59502b;

        a(aj ajVar, H5Event h5Event) {
            this.f59501a = ajVar;
            this.f59502b = h5Event;
        }

        public final void onResult(Object obj) {
            k.c(obj, "shortLink");
            if (!(obj instanceof String) || !TextUtils.isEmpty((CharSequence) obj)) {
                this.f59501a.a("success", (Object) Boolean.TRUE);
                this.f59501a.a("shortlink", obj);
                net.one97.paytm.phoenix.core.a.a(this.f59501a, this.f59502b, (Object) null, false, 6);
                return;
            }
            this.f59501a.a(this.f59502b, net.one97.paytm.phoenix.api.a.UNKNOWN_ERROR, "");
        }
    }
}
