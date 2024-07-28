package net.one97.paytm.phoenix.d;

import android.content.Context;
import android.os.Bundle;
import java.util.Observable;
import java.util.Observer;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.f;
import net.one97.paytm.phoenix.core.c;
import net.one97.paytm.phoenix.provider.PaymentProvider;
import net.one97.paytm.phoenix.provider.PhoenixBridgeInterceptorProvider;
import net.one97.paytm.phoenix.provider.PhoenixSessionTimeOutPopUpProvider;
import net.one97.paytm.phoenix.ui.PhoenixActivity;
import org.json.JSONObject;

public final class as extends net.one97.paytm.phoenix.core.a {
    public as() {
        super("paytmPayment");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0060  */
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
            r0 = 1
            if (r10 == 0) goto L_0x00fa
            net.one97.paytm.phoenix.core.c r10 = net.one97.paytm.phoenix.core.c.f59399a
            net.one97.paytm.phoenix.api.f r10 = r10.b()
            java.lang.Class<net.one97.paytm.phoenix.provider.PaymentProvider> r1 = net.one97.paytm.phoenix.provider.PaymentProvider.class
            java.lang.String r1 = r1.getName()
            java.lang.String r2 = "PaymentProvider::class.java.name"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            java.lang.Object r10 = r10.a(r1)
            r3 = r10
            net.one97.paytm.phoenix.provider.PaymentProvider r3 = (net.one97.paytm.phoenix.provider.PaymentProvider) r3
            r10 = 0
            if (r3 != 0) goto L_0x0037
            net.one97.paytm.phoenix.api.a r0 = net.one97.paytm.phoenix.api.a.FORBIDDEN
            java.lang.String r1 = "No implementation found for 'PaymentProvider'"
            r8.a((net.one97.paytm.phoenix.api.H5Event) r9, (net.one97.paytm.phoenix.api.a) r0, (java.lang.String) r1)
            return r10
        L_0x0037:
            android.app.Activity r1 = r9.getActivity()
            if (r1 == 0) goto L_0x005b
            android.app.Activity r1 = r9.getActivity()
            if (r1 != 0) goto L_0x0046
            kotlin.g.b.k.a()
        L_0x0046:
            boolean r1 = r1 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity
            if (r1 == 0) goto L_0x005b
            android.app.Activity r1 = r9.getActivity()
            if (r1 == 0) goto L_0x0053
            net.one97.paytm.phoenix.ui.PhoenixActivity r1 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r1
            goto L_0x005c
        L_0x0053:
            kotlin.u r9 = new kotlin.u
            java.lang.String r10 = "null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity"
            r9.<init>(r10)
            throw r9
        L_0x005b:
            r1 = 0
        L_0x005c:
            r4 = r1
            if (r4 != 0) goto L_0x0060
            return r10
        L_0x0060:
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
            org.json.JSONObject r1 = r9.getParams()
            net.one97.paytm.phoenix.util.g r2 = net.one97.paytm.phoenix.util.g.f59641a
            if (r1 != 0) goto L_0x0070
            kotlin.g.b.k.a()
        L_0x0070:
            net.one97.paytm.phoenix.util.g.a((org.json.JSONObject) r1, (android.os.Bundle) r5)
            java.lang.String r1 = "amount"
            java.lang.String r1 = r5.getString(r1)
            java.lang.String r2 = "orderId"
            java.lang.String r2 = r5.getString(r2)
            java.lang.String r6 = "txnToken"
            java.lang.String r6 = r5.getString(r6)
            java.lang.String r7 = "mid"
            java.lang.String r7 = r5.getString(r7)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x0098
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0096
            goto L_0x0098
        L_0x0096:
            r1 = 0
            goto L_0x0099
        L_0x0098:
            r1 = 1
        L_0x0099:
            if (r1 != 0) goto L_0x00f3
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x00a8
            int r1 = r2.length()
            if (r1 != 0) goto L_0x00a6
            goto L_0x00a8
        L_0x00a6:
            r1 = 0
            goto L_0x00a9
        L_0x00a8:
            r1 = 1
        L_0x00a9:
            if (r1 != 0) goto L_0x00f3
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            if (r6 == 0) goto L_0x00b8
            int r1 = r6.length()
            if (r1 != 0) goto L_0x00b6
            goto L_0x00b8
        L_0x00b6:
            r1 = 0
            goto L_0x00b9
        L_0x00b8:
            r1 = 1
        L_0x00b9:
            if (r1 != 0) goto L_0x00f3
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x00c5
            int r1 = r7.length()
            if (r1 != 0) goto L_0x00c6
        L_0x00c5:
            r10 = 1
        L_0x00c6:
            if (r10 == 0) goto L_0x00c9
            goto L_0x00f3
        L_0x00c9:
            r10 = r4
            android.app.Activity r10 = (android.app.Activity) r10
            boolean r10 = r3.openPayment(r10, r5)
            if (r10 == 0) goto L_0x00eb
            net.one97.paytm.phoenix.ui.PhoenixActivity$m r10 = r4.l
            java.util.Observable r10 = (java.util.Observable) r10
            r10.deleteObservers()
            net.one97.paytm.phoenix.ui.PhoenixActivity$m r10 = r4.l
            java.util.Observable r10 = (java.util.Observable) r10
            net.one97.paytm.phoenix.d.as$a r7 = new net.one97.paytm.phoenix.d.as$a
            r1 = r7
            r2 = r8
            r6 = r9
            r1.<init>(r2, r3, r4, r5, r6)
            java.util.Observer r7 = (java.util.Observer) r7
            r10.addObserver(r7)
            goto L_0x00fa
        L_0x00eb:
            net.one97.paytm.phoenix.api.a r10 = net.one97.paytm.phoenix.api.a.FORBIDDEN
            java.lang.String r1 = "Error"
            r8.a((net.one97.paytm.phoenix.api.H5Event) r9, (net.one97.paytm.phoenix.api.a) r10, (java.lang.String) r1)
            goto L_0x00fa
        L_0x00f3:
            net.one97.paytm.phoenix.api.a r10 = net.one97.paytm.phoenix.api.a.INVALID_PARAM
            java.lang.String r1 = "Insufficient parameters"
            r8.a((net.one97.paytm.phoenix.api.H5Event) r9, (net.one97.paytm.phoenix.api.a) r10, (java.lang.String) r1)
        L_0x00fa:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.as.a(net.one97.paytm.phoenix.api.H5Event, net.one97.paytm.phoenix.api.b):boolean");
    }

    static final class a implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ as f59527a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PaymentProvider f59528b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ PhoenixActivity f59529c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Bundle f59530d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ H5Event f59531e;

        a(as asVar, PaymentProvider paymentProvider, PhoenixActivity phoenixActivity, Bundle bundle, H5Event h5Event) {
            this.f59527a = asVar;
            this.f59528b = paymentProvider;
            this.f59529c = phoenixActivity;
            this.f59530d = bundle;
            this.f59531e = h5Event;
        }

        public final void update(Observable observable, Object obj) {
            f b2 = c.f59399a.b();
            String name = PhoenixBridgeInterceptorProvider.class.getName();
            k.a((Object) name, "PhoenixBridgeInterceptorProvider::class.java.name");
            PhoenixBridgeInterceptorProvider phoenixBridgeInterceptorProvider = (PhoenixBridgeInterceptorProvider) b2.a(name);
            if (phoenixBridgeInterceptorProvider != null) {
                Context context = this.f59529c;
                String action$phoenix_debug = this.f59531e.getAction$phoenix_debug();
                JSONObject params = this.f59531e.getParams();
                String str = null;
                String jSONObject = params != null ? params.toString() : null;
                String str2 = this.f59529c.f59606d;
                if (obj != null) {
                    str = obj.toString();
                }
                phoenixBridgeInterceptorProvider.onBridgeCalled(context, action$phoenix_debug, jSONObject, str2, false, str);
            }
            if (p.a((CharSequence) obj.toString(), (CharSequence) "session_timeout", false)) {
                f b3 = c.f59399a.b();
                String name2 = PhoenixSessionTimeOutPopUpProvider.class.getName();
                k.a((Object) name2, "PhoenixSessionTimeOutPop…Provider::class.java.name");
                PhoenixSessionTimeOutPopUpProvider phoenixSessionTimeOutPopUpProvider = (PhoenixSessionTimeOutPopUpProvider) b3.a(name2);
                if (phoenixSessionTimeOutPopUpProvider == null) {
                    this.f59527a.a(this.f59531e, net.one97.paytm.phoenix.api.a.FORBIDDEN, "No implementation found for 'PhoenixSessionTimeOutPopUpProvider'");
                } else {
                    phoenixSessionTimeOutPopUpProvider.showPopUp(this.f59529c);
                }
            } else {
                as asVar = this.f59527a;
                if (obj != null && (obj instanceof String)) {
                    if (((CharSequence) obj).length() == 0) {
                        net.one97.paytm.phoenix.core.a.a(asVar, this.f59531e, Boolean.FALSE, false, 4);
                        return;
                    }
                }
                net.one97.paytm.phoenix.core.a.a(asVar, this.f59531e, obj, false, 4);
            }
        }
    }
}
