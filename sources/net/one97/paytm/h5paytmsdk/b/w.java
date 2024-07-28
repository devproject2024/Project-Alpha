package net.one97.paytm.h5paytmsdk.b;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.alibaba.a.e;
import com.alipay.iap.android.webapp.sdk.app.SubAppConfig;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.nebula.provider.H5ProviderManager;
import com.alipay.mobile.nebulacore.Nebula;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.h5paytmsdk.a.b;
import net.one97.paytm.h5paytmsdk.c.aa;
import net.one97.paytm.h5paytmsdk.c.ac;
import net.one97.paytm.h5paytmsdk.c.m;
import net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity;

public final class w extends ad {
    public w() {
        super("paytmPayment");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: net.one97.paytm.h5paytmsdk.c.aa} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v18, resolved type: net.one97.paytm.h5paytmsdk.c.aa} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v19, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v30, resolved type: net.one97.paytm.h5paytmsdk.c.aa} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleEvent(com.alipay.mobile.h5container.api.H5Event r9, com.alipay.mobile.h5container.api.H5BridgeContext r10) {
        /*
            r8 = this;
            super.handleEvent(r9, r10)
            boolean r10 = r8.b(r9)
            r0 = 1
            if (r10 == 0) goto L_0x00cf
            if (r9 != 0) goto L_0x000f
            kotlin.g.b.k.a()
        L_0x000f:
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
            com.alibaba.a.e r10 = r9.getParam()
            net.one97.paytm.h5paytmsdk.b.v$a r1 = net.one97.paytm.h5paytmsdk.b.v.f17055a
            java.lang.String r1 = "params"
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r1)
            net.one97.paytm.h5paytmsdk.b.v.a.a(r5, r10)
            java.lang.String r10 = "amount"
            java.lang.String r10 = r5.getString(r10)
            java.lang.String r1 = "orderId"
            java.lang.String r1 = r5.getString(r1)
            java.lang.String r2 = "txnToken"
            java.lang.String r2 = r5.getString(r2)
            java.lang.String r3 = "mid"
            java.lang.String r3 = r5.getString(r3)
            java.lang.String r4 = "type"
            r5.getString(r4)
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r4 = 0
            if (r10 == 0) goto L_0x004f
            int r10 = r10.length()
            if (r10 != 0) goto L_0x004d
            goto L_0x004f
        L_0x004d:
            r10 = 0
            goto L_0x0050
        L_0x004f:
            r10 = 1
        L_0x0050:
            if (r10 != 0) goto L_0x00c8
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x005f
            int r10 = r1.length()
            if (r10 != 0) goto L_0x005d
            goto L_0x005f
        L_0x005d:
            r10 = 0
            goto L_0x0060
        L_0x005f:
            r10 = 1
        L_0x0060:
            if (r10 != 0) goto L_0x00c8
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x006f
            int r10 = r2.length()
            if (r10 != 0) goto L_0x006d
            goto L_0x006f
        L_0x006d:
            r10 = 0
            goto L_0x0070
        L_0x006f:
            r10 = 1
        L_0x0070:
            if (r10 != 0) goto L_0x00c8
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L_0x007c
            int r10 = r3.length()
            if (r10 != 0) goto L_0x007d
        L_0x007c:
            r4 = 1
        L_0x007d:
            if (r4 == 0) goto L_0x0080
            goto L_0x00c8
        L_0x0080:
            com.alipay.mobile.nebula.provider.H5ProviderManager r10 = com.alipay.mobile.nebulacore.Nebula.getProviderManager()
            if (r10 == 0) goto L_0x0091
            java.lang.Class<net.one97.paytm.h5paytmsdk.c.aa> r1 = net.one97.paytm.h5paytmsdk.c.aa.class
            java.lang.String r1 = r1.getName()
            java.lang.Object r10 = r10.getProvider(r1)
            goto L_0x0092
        L_0x0091:
            r10 = 0
        L_0x0092:
            r4 = r10
            net.one97.paytm.h5paytmsdk.c.aa r4 = (net.one97.paytm.h5paytmsdk.c.aa) r4
            if (r4 != 0) goto L_0x009f
            com.alipay.mobile.h5container.api.H5Event$Error r9 = com.alipay.mobile.h5container.api.H5Event.Error.FORBIDDEN
            java.lang.String r10 = "No implementation found for 'PaytmH5PaymentProvider'"
            r8.a((com.alipay.mobile.h5container.api.H5Event.Error) r9, (java.lang.String) r10)
            goto L_0x00cf
        L_0x009f:
            android.app.Activity r2 = r9.getActivity()
            if (r2 == 0) goto L_0x00cf
            r4.a(r2, r5)
            boolean r10 = r2 instanceof net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity
            if (r10 == 0) goto L_0x00cf
            r10 = r2
            net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity r10 = (net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity) r10
            net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity$l r1 = r10.f17110h
            java.util.Observable r1 = (java.util.Observable) r1
            r1.deleteObservers()
            net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity$l r10 = r10.f17110h
            java.util.Observable r10 = (java.util.Observable) r10
            net.one97.paytm.h5paytmsdk.b.w$a r7 = new net.one97.paytm.h5paytmsdk.b.w$a
            r1 = r7
            r3 = r8
            r6 = r9
            r1.<init>(r2, r3, r4, r5, r6)
            java.util.Observer r7 = (java.util.Observer) r7
            r10.addObserver(r7)
            goto L_0x00cf
        L_0x00c8:
            com.alipay.mobile.h5container.api.H5Event$Error r9 = com.alipay.mobile.h5container.api.H5Event.Error.INVALID_PARAM
            java.lang.String r10 = "Insufficient parameters"
            r8.a((com.alipay.mobile.h5container.api.H5Event.Error) r9, (java.lang.String) r10)
        L_0x00cf:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.h5paytmsdk.b.w.handleEvent(com.alipay.mobile.h5container.api.H5Event, com.alipay.mobile.h5container.api.H5BridgeContext):boolean");
    }

    static final class a implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f17063a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ w f17064b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ aa f17065c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Bundle f17066d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ H5Event f17067e;

        a(Activity activity, w wVar, aa aaVar, Bundle bundle, H5Event h5Event) {
            this.f17063a = activity;
            this.f17064b = wVar;
            this.f17065c = aaVar;
            this.f17066d = bundle;
            this.f17067e = h5Event;
        }

        public final void update(Observable observable, Object obj) {
            String str;
            H5ProviderManager providerManager = Nebula.getProviderManager();
            Object obj2 = null;
            m mVar = (m) (providerManager != null ? providerManager.getProvider(m.class.getName()) : null);
            if (mVar != null) {
                Context context = this.f17063a;
                String action = this.f17067e.getAction();
                e param = this.f17067e.getParam();
                String jSONString = param != null ? param.toJSONString() : null;
                String a2 = ((PaytmH5Activity) this.f17063a).a();
                b a3 = b.a();
                k.a((Object) a3, "IAPIntegrationHelper.getInstance()");
                Map<String, SubAppConfig> b2 = a3.b();
                if (b2 != null) {
                    b2.containsKey(((PaytmH5Activity) this.f17063a).a());
                }
                if (obj != null) {
                    str = obj.toString();
                } else {
                    str = null;
                }
                mVar.a(context, action, jSONString, a2, str);
            }
            boolean z = false;
            if (p.a(obj.toString(), "session_timeout", false)) {
                H5ProviderManager providerManager2 = Nebula.getProviderManager();
                if (providerManager2 != null) {
                    obj2 = providerManager2.getProvider(ac.class.getName());
                }
                ac acVar = (ac) obj2;
                if (acVar == null) {
                    this.f17064b.a(H5Event.Error.FORBIDDEN, "No implementation found for 'PaytmH5SessionTimeOutPopUpProvider'");
                    return;
                }
                Activity activity = this.f17067e.getActivity();
                k.a((Object) activity, "event.activity");
                acVar.a(activity);
                return;
            }
            w wVar = this.f17064b;
            if (obj != null && (obj instanceof String)) {
                if (((CharSequence) obj).length() == 0) {
                    z = true;
                }
                if (z) {
                    wVar.a((Object) Boolean.FALSE);
                    return;
                }
            }
            wVar.a(obj);
        }
    }
}
