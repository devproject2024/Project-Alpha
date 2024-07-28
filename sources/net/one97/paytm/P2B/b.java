package net.one97.paytm.p2b;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.paytm.network.a;
import com.paytm.network.model.CJRError;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.e;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.widgets.blueprints.IStaticWidget;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.addmoney.utils.j;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.cashback.posttxn.f;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.deeplink.h;
import net.one97.paytm.landingpage.activity.AJRMainActivity;
import net.one97.paytm.m;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity;
import net.one97.paytm.n.b;
import net.one97.paytm.network.g;
import net.one97.paytm.p2b.b.a;
import net.one97.paytm.p2b.d.h;
import net.one97.paytm.upgradeKyc.activity.UpgradeKycActivity;
import net.one97.paytm.upi.util.UpiRequestBuilder;
import net.one97.paytm.utils.r;
import net.one97.paytm.utils.t;
import net.one97.paytm.wallet.activity.AJRConfirmIFSCActivity;
import net.one97.paytm.wallet.f.f;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f56868a = new a((byte) 0);

    /* renamed from: d  reason: collision with root package name */
    private static b f56869d;

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.wallet.d.c f56870b;

    /* renamed from: c  reason: collision with root package name */
    private net.one97.paytm.n.c f56871c;

    public final String p() {
        return "net.one97.paytm";
    }

    public final boolean a(String str, boolean z) {
        k.c(str, "key");
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(str, z);
    }

    public final void a(Activity activity, com.paytm.network.listener.b bVar) {
        t.a(activity, bVar, a.c.P2B);
    }

    public final void a(Context context, String str) {
        k.c(str, "deeplink");
        h.a aVar = h.f50349a;
        h.a.a(context, str, (Bundle) null);
    }

    public final String a(String str) {
        k.c(str, "key");
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(str, (String) null);
    }

    public final String a(String str, String str2) {
        k.c(str, "key");
        String a2 = a(str);
        return TextUtils.isEmpty(a2) ? str2 : a2;
    }

    public final String a(Context context) {
        return context != null ? t.b(context) : "";
    }

    public final String a() {
        k.a((Object) net.one97.paytm.j.c.a(), "GTMLoader.getInstance()");
        String a2 = net.one97.paytm.j.c.a("walletLimitV2", (String) null);
        return TextUtils.isEmpty(a2) ? "https://trust.paytm.in/wallet-web/v2/walletLimits" : a2;
    }

    public final String b() {
        k.a((Object) net.one97.paytm.j.c.a(), "GTMLoader.getInstance()");
        return net.one97.paytm.j.c.M();
    }

    public final String c() {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a("searchUserTransactionHistoryUrl", (String) null);
    }

    public final String d() {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.N();
    }

    public final String e() {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.x();
    }

    public final String f() {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.L();
    }

    public final String g() {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a("getBeneficiaryKYC", (String) null);
    }

    public final String h() {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.p();
    }

    public final void a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        net.one97.paytm.j.a.a(context, str, str2, str3, str4, str5, str6, str7);
    }

    public final void a(String str, Map<String, ? extends Object> map, Context context) {
        net.one97.paytm.j.a.b(str, (Map<String, Object>) map, context);
    }

    public final String i() {
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a("transferToBank", (String) null);
    }

    public final void j() {
        if (this.f56871c != null) {
            net.one97.paytm.n.d dVar = net.one97.paytm.n.d.f55759a;
            net.one97.paytm.n.d.a();
        }
    }

    public final String a(CJRPGTokenList cJRPGTokenList) {
        k.c(cJRPGTokenList, "tokenList");
        return t.a(cJRPGTokenList);
    }

    public final String b(Context context, String str) {
        return UpiRequestBuilder.getBankIconUrl(context, str);
    }

    public final void a(Activity activity, String str, boolean z) {
        r.a(activity, str, (Bundle) null, false, z);
    }

    public final Intent b(Context context) {
        return new Intent(context, MoneyTransferV3Activity.class);
    }

    public final Intent c(Context context) {
        k.c(context, "context");
        return new Intent(context, UpgradeKycActivity.class);
    }

    public final String d(Context context) {
        String d2 = j.d(context);
        String str = "";
        for (e.a aVar : e.a.values()) {
            if (d2 != null && p.a(d2, aVar.getWalletUserState(), true)) {
                str = aVar.getv2UserState();
                k.a((Object) str, "mapping.getv2UserState()");
            }
        }
        return str;
    }

    public final String k() {
        k.a((Object) net.one97.paytm.j.c.a(), "GTMLoader.getInstance()");
        return net.one97.paytm.j.c.O();
    }

    public final ContextWrapper e(Context context) {
        if (context != null) {
            return net.one97.paytm.locale.b.e.a(context);
        }
        return null;
    }

    public final void a(Activity activity, Bundle bundle, m mVar) {
        net.one97.paytm.deeplink.d.a((Context) activity, bundle, mVar);
    }

    public final void b(Activity activity) {
        a(activity, "paytmmp://cash_wallet?featuretype=add_money&tab=wallet");
    }

    public final void c(Activity activity) {
        a(activity, "paytmmp://cash_wallet?featuretype=cash_ledger&tab=prepaid_wallet");
    }

    private static void a(Activity activity, String str) {
        k.c(activity, "context");
        k.c(str, "url");
        h.a aVar = h.f50349a;
        h.a.a(activity, str, (Bundle) null);
        activity.finish();
    }

    public final Intent f(Context context) {
        return new Intent(context, AJRConfirmIFSCActivity.class);
    }

    public final boolean l() {
        return net.one97.paytm.upgradeKyc.utils.j.j(s());
    }

    public final int m() {
        return net.one97.paytm.upgradeKyc.utils.j.b(s());
    }

    public final void a(String str, String str2, String str3, String str4, Context context) {
        net.one97.paytm.j.a.a(str, str2, str3, str4, context);
    }

    public final CJRError a(Context context, NetworkCustomError networkCustomError) {
        k.c(networkCustomError, "volleyError");
        return r.b(context, (Exception) networkCustomError);
    }

    public final CJRError c(Context context, String str) {
        return r.a(context, str);
    }

    public final void a(Context context, NetworkCustomError networkCustomError, String str) {
        r.a(context, (Exception) networkCustomError, str);
    }

    public final String n() {
        k.a((Object) net.one97.paytm.j.c.a(), "GTMLoader.getInstance()");
        return net.one97.paytm.j.c.a("p2bpopuptext", (String) null);
    }

    public final boolean d(Activity activity) {
        k.c(activity, "mActivity");
        return activity instanceof AJRMainActivity;
    }

    public final void a(Activity activity, net.one97.paytm.p2b.b.b bVar) {
        if (this.f56870b == null) {
            this.f56870b = new net.one97.paytm.wallet.d.c();
        }
        net.one97.paytm.wallet.d.c cVar = this.f56870b;
        if (cVar != null) {
            cVar.a(activity, (f) new c(bVar));
        }
    }

    public static final class c implements f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.p2b.b.b f56875a;

        public final void onAddMoneyVerifyResponse(String str) {
        }

        c(net.one97.paytm.p2b.b.b bVar) {
            this.f56875a = bVar;
        }

        public final void onAddMoneyRequestStart() {
            net.one97.paytm.p2b.b.b bVar = this.f56875a;
            if (bVar != null) {
                bVar.a();
            }
        }

        public final void onAddMoneyInvalidAmountEntered(String str) {
            net.one97.paytm.p2b.b.b bVar = this.f56875a;
            if (bVar != null) {
                bVar.a(str);
            }
        }

        public final void onAddMoneyRequestComplete() {
            net.one97.paytm.p2b.b.b bVar = this.f56875a;
            if (bVar != null) {
                bVar.b();
            }
        }
    }

    public final void o() {
        net.one97.paytm.wallet.d.c cVar = this.f56870b;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final void a(IStaticWidget iStaticWidget, Context context, String str, String str2) {
        net.one97.paytm.cashback.posttxn.e a2;
        k.c(str2, "verticalId");
        if (net.one97.paytm.deeplink.e.a() && (a2 = net.one97.paytm.cashback.posttxn.c.a()) != null && a2.a(net.one97.paytm.utils.b.a.P2B.getId(), 0)) {
            if (context != null) {
                a2.a((AppCompatActivity) context);
                f.a aVar = new f.a();
                if (str != null) {
                    aVar.f49548d = str;
                }
                aVar.f49550f = a.c.P2B.name();
                a2.a(aVar.a(), (net.one97.paytm.cashback.posttxn.a) new d(a2, context, str, iStaticWidget));
                return;
            }
            throw new u("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        }
    }

    public static final class d implements net.one97.paytm.cashback.posttxn.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.cashback.posttxn.e f56876a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f56877b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f56878c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ IStaticWidget f56879d;

        d(net.one97.paytm.cashback.posttxn.e eVar, Context context, String str, IStaticWidget iStaticWidget) {
            this.f56876a = eVar;
            this.f56877b = context;
            this.f56878c = str;
            this.f56879d = iStaticWidget;
        }

        public final void onAnimationEnd(String str) {
            IStaticWidget iStaticWidget = this.f56879d;
            if (iStaticWidget != null) {
                if (str == null) {
                    str = "cashback";
                }
                iStaticWidget.AnimateView(str);
            }
        }

        public final Point getFloatingWidgetPos(String str) {
            IStaticWidget iStaticWidget = this.f56879d;
            if (iStaticWidget == null) {
                return null;
            }
            if (str == null) {
                str = "cashback";
            }
            return iStaticWidget.getViewPoint(str);
        }
    }

    public final void b(String str, String str2) {
        net.one97.paytm.wallet.d.c cVar = this.f56870b;
        if (cVar != null) {
            cVar.a(str, true, str2);
        }
    }

    public final Boolean a(Context context, Exception exc) {
        return Boolean.valueOf(r.a(context, exc));
    }

    public static void a(Activity activity, Exception exc, Boolean bool) {
        k.c(exc, "error1");
        if (bool != null) {
            bool.booleanValue();
            r.a(activity, exc, (String) null, (Bundle) null);
            return;
        }
        r.a(activity, exc, (String) null, (Bundle) null);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private static Context s() {
        Context appContext = CJRJarvisApplication.getAppContext();
        k.a((Object) appContext, "CJRJarvisApplication.getAppContext()");
        return appContext;
    }

    public final int a(String str, int i2) {
        k.c(str, "key");
        net.one97.paytm.j.c.a();
        return net.one97.paytm.j.c.a(str, i2);
    }

    /* renamed from: net.one97.paytm.p2b.b$b  reason: collision with other inner class name */
    public static final class C1059b implements net.one97.paytm.n.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f56872a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.p2b.view.c.c f56873b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.p2b.b.e f56874c;

        public /* synthetic */ void g(boolean z) {
            b.CC.$default$g(this, z);
        }

        C1059b(b bVar, net.one97.paytm.p2b.view.c.c cVar, net.one97.paytm.p2b.b.e eVar) {
            this.f56872a = bVar;
            this.f56873b = cVar;
            this.f56874c = eVar;
        }

        public final void a(boolean z) {
            this.f56874c.a(z);
        }

        public final void a() {
            this.f56874c.g();
        }

        public final void ae_() {
            this.f56874c.f();
        }

        public final void a(g gVar) {
            k.c(gVar, "paytmCommonError");
            if (gVar.f55801c != null && this.f56873b.getActivity() != null && (gVar.f55801c instanceof Exception)) {
                Activity activity = this.f56873b.getActivity();
                NetworkCustomError networkCustomError = gVar.f55801c;
                if (networkCustomError != null) {
                    b.a(activity, (Exception) networkCustomError, Boolean.FALSE);
                    return;
                }
                throw new u("null cannot be cast to non-null type kotlin.Exception /* = java.lang.Exception */");
            }
        }
    }

    public final void a(net.one97.paytm.p2b.view.c.c cVar, net.one97.paytm.p2b.b.e eVar) {
        k.c(cVar, "p2BTransferSummaryFragment");
        k.c(eVar, "passcodeFlowListenerP2B");
        this.f56871c = new net.one97.paytm.n.c((net.one97.paytm.n.b) new C1059b(this, cVar, eVar), (Fragment) cVar);
    }

    public final void a(int i2, int i3, Intent intent) {
        net.one97.paytm.n.c cVar;
        if (intent != null && (cVar = this.f56871c) != null) {
            cVar.a(i2, i3);
        }
    }

    public final void q() {
        net.one97.paytm.n.c cVar = this.f56871c;
        if (cVar != null) {
            cVar.a((String) null, (String) null);
        }
    }

    public final void a(Activity activity) {
        try {
            net.one97.paytm.payments.d.a.a(activity, net.one97.paytm.payments.d.a.a() + "upgrade_wallet?call_back_url=" + URLEncoder.encode("", AppConstants.UTF_8) + "&vertical=" + "kyc" + "&aadhaar_otp=false&non_aadhaar=false");
        } catch (UnsupportedEncodingException e2) {
            q.b(e2.getMessage());
        }
    }

    public static final void r() {
        if (f56869d == null) {
            f56869d = new b();
        }
        h.a aVar = net.one97.paytm.p2b.d.h.f12718a;
        b bVar = f56869d;
        if (bVar == null) {
            k.a();
        }
        net.one97.paytm.p2b.b.a aVar2 = bVar;
        k.c(aVar2, "IP2bInteractionListener");
        if (net.one97.paytm.p2b.d.h.f12719c == null) {
            net.one97.paytm.p2b.d.h.f12719c = new net.one97.paytm.p2b.d.h();
            net.one97.paytm.p2b.d.h a2 = net.one97.paytm.p2b.d.h.f12719c;
            if (a2 == null) {
                k.a();
            }
            a2.f12720b = aVar2;
        }
    }
}
