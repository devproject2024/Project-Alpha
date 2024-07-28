package net.one97.paytm.recharge.presentation.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.q;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.y;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.g;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.view.actions.IuserActions;
import com.paytmmall.clpartifact.view.viewmodel.SharedHomeVM;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.l;
import kotlin.m.p;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.Utils.FetchPayOptionsListener;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.VpaFetch;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.automatic.b.a.a;
import net.one97.paytm.recharge.automatic.b.a.h;
import net.one97.paytm.recharge.domain.entities.CJRBankToken;
import net.one97.paytm.recharge.domain.entities.CJRCreateSubscriptionApiResponse;
import net.one97.paytm.recharge.domain.entities.CJRFetchBalanceResponse;
import net.one97.paytm.recharge.domain.entities.CJRNativeWithDrawDetails;
import net.one97.paytm.recharge.domain.entities.CJRPayChannelOptions;
import net.one97.paytm.recharge.domain.entities.CJRPaymentModes;
import net.one97.paytm.recharge.domain.entities.CJRPaymentOptionResponse;
import net.one97.paytm.recharge.emandate.activity.AJRBankAccountDetailsActivity;
import net.one97.paytm.recharge.presentation.activity.AJRAutomaticSetupActivity;
import net.one97.paytm.recharge.presentation.activity.AJRAutomaticSubscriptionTnCWebView;
import net.one97.paytm.recharge.presentation.b.i;
import net.one97.paytm.recharge.presentation.b.k;
import net.one97.paytm.recharge.widgets.model.CJRTaggedObservable;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.UpiConstants;

public final class b extends net.one97.paytm.i.h implements io.reactivex.rxjava3.d.g<CJRTaggedObservable<?>>, FetchPayOptionsListener, net.one97.paytm.recharge.widgets.b.a {
    /* access modifiers changed from: private */
    public static a F;

    /* renamed from: a  reason: collision with root package name */
    public static final C1279b f64805a = new C1279b((byte) 0);
    private String A;
    private String B;
    private String C;
    private String D;
    private boolean E;
    private HashMap G;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.recharge.presentation.g.a f64806b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Bundle f64807c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public net.one97.paytm.recharge.presentation.a.h f64808d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f64809e;

    /* renamed from: f  reason: collision with root package name */
    private String f64810f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f64811g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f64812h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f64813i;
    /* access modifiers changed from: private */
    public String j;
    /* access modifiers changed from: private */
    public net.one97.paytm.recharge.presentation.b.k k;
    private int l = 3;
    /* access modifiers changed from: private */
    public String m;
    /* access modifiers changed from: private */
    public String n;
    private CJRBankToken o;
    private String p;
    private String q;
    private String r;
    /* access modifiers changed from: private */
    public net.one97.paytm.recharge.widgets.widget.a s;
    /* access modifiers changed from: private */
    public long t;
    private String u;
    /* access modifiers changed from: private */
    public CJRCreateSubscriptionApiResponse v;
    /* access modifiers changed from: private */
    public String w;
    /* access modifiers changed from: private */
    public CJRPayChannelOptions x;
    /* access modifiers changed from: private */
    public long y = -1;
    private int z = -1;

    public interface a {
        void a(boolean z, boolean z2);
    }

    public final View a(int i2) {
        if (this.G == null) {
            this.G = new HashMap();
        }
        View view = (View) this.G.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.G.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onPaymentOptionsError() {
    }

    public final void onPaymentOptionsReceived(CJPayMethodResponse cJPayMethodResponse) {
    }

    public final void onRequestStart() {
    }

    public final void onVpaReceived(VpaFetch vpaFetch) {
    }

    static final class h extends l implements kotlin.g.a.b<net.one97.paytm.recharge.presentation.g.b<CJRPaymentOptionResponse>, x> {
        final /* synthetic */ b this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(b bVar) {
            super(1);
            this.this$0 = bVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((net.one97.paytm.recharge.presentation.g.b<CJRPaymentOptionResponse>) (net.one97.paytm.recharge.presentation.g.b) obj);
            return x.f47997a;
        }

        public final void invoke(net.one97.paytm.recharge.presentation.g.b<CJRPaymentOptionResponse> bVar) {
            net.one97.paytm.recharge.presentation.g.c cVar;
            NetworkCustomError networkCustomError;
            CJRPaymentOptionResponse cJRPaymentOptionResponse;
            FrameLayout frameLayout;
            if (bVar != null) {
                cVar = bVar.f64955c;
            } else {
                cVar = null;
            }
            if (cVar != null) {
                int i2 = c.f64823a[cVar.ordinal()];
                if (i2 == 1) {
                    FrameLayout frameLayout2 = (FrameLayout) this.this$0.a(R.id.lyt_progress_bar);
                    if (frameLayout2 != null) {
                        frameLayout2.setVisibility(0);
                    }
                } else if (!(i2 == 2 || i2 != 3 || (frameLayout = (FrameLayout) this.this$0.a(R.id.lyt_progress_bar)) == null)) {
                    frameLayout.setVisibility(8);
                }
            }
            if (!(bVar == null || (cJRPaymentOptionResponse = (CJRPaymentOptionResponse) bVar.f64954b) == null)) {
                b.a(this.this$0, cJRPaymentOptionResponse);
                FrameLayout frameLayout3 = (FrameLayout) this.this$0.a(R.id.lyt_progress_bar);
                if (frameLayout3 != null) {
                    frameLayout3.setVisibility(8);
                }
            }
            if (bVar != null && (networkCustomError = bVar.f64953a) != null) {
                net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
                net.one97.paytm.recharge.automatic.c.a.a.a(this.this$0.getActivity(), this.this$0, networkCustomError, IuserActions.HIDE_KEYBOARD);
            }
        }
    }

    static final class i extends l implements kotlin.g.a.b<net.one97.paytm.recharge.presentation.g.b<CJRRechargePayment>, x> {
        final /* synthetic */ b this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(b bVar) {
            super(1);
            this.this$0 = bVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((net.one97.paytm.recharge.presentation.g.b<CJRRechargePayment>) (net.one97.paytm.recharge.presentation.g.b) obj);
            return x.f47997a;
        }

        public final void invoke(net.one97.paytm.recharge.presentation.g.b<CJRRechargePayment> bVar) {
            FrameLayout frameLayout;
            if (bVar != null) {
                int i2 = c.f64824b[bVar.f64955c.ordinal()];
                if (i2 == 1) {
                    FrameLayout frameLayout2 = (FrameLayout) this.this$0.a(R.id.lyt_progress_bar);
                    if (frameLayout2 != null) {
                        frameLayout2.setVisibility(0);
                    }
                } else if ((i2 == 2 || i2 == 3) && (frameLayout = (FrameLayout) this.this$0.a(R.id.lyt_progress_bar)) != null) {
                    frameLayout.setVisibility(8);
                }
                CJRRechargePayment cJRRechargePayment = (CJRRechargePayment) bVar.f64954b;
                if (cJRRechargePayment != null) {
                    this.this$0.a(cJRRechargePayment);
                }
            }
        }
    }

    static final class j extends l implements kotlin.g.a.b<net.one97.paytm.recharge.presentation.g.b<CJROrderSummary>, x> {
        final /* synthetic */ b this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(b bVar) {
            super(1);
            this.this$0 = bVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((net.one97.paytm.recharge.presentation.g.b<CJROrderSummary>) (net.one97.paytm.recharge.presentation.g.b) obj);
            return x.f47997a;
        }

        public final void invoke(net.one97.paytm.recharge.presentation.g.b<CJROrderSummary> bVar) {
            net.one97.paytm.recharge.presentation.b.k a2;
            if (bVar != null) {
                if (c.f64825c[bVar.f64955c.ordinal()] == 1 && (a2 = this.this$0.k) != null) {
                    a2.dismissAllowingStateLoss();
                }
                CJROrderSummary cJROrderSummary = (CJROrderSummary) bVar.f64954b;
                if (cJROrderSummary != null) {
                    b.a(this.this$0, cJROrderSummary);
                }
                NetworkCustomError networkCustomError = bVar.f64953a;
                if (networkCustomError != null) {
                    net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
                    Context context = this.this$0.getContext();
                    if (context != null) {
                        net.one97.paytm.recharge.automatic.c.a.a.a((Activity) context, networkCustomError, (int) IuserActions.ON_FLASHSALE_CLICK);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type android.app.Activity");
                }
            }
        }
    }

    static final class k extends l implements kotlin.g.a.b<net.one97.paytm.recharge.presentation.g.b<CJRCreateSubscriptionApiResponse>, x> {
        final /* synthetic */ b this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(b bVar) {
            super(1);
            this.this$0 = bVar;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((net.one97.paytm.recharge.presentation.g.b<CJRCreateSubscriptionApiResponse>) (net.one97.paytm.recharge.presentation.g.b) obj);
            return x.f47997a;
        }

        public final void invoke(net.one97.paytm.recharge.presentation.g.b<CJRCreateSubscriptionApiResponse> bVar) {
            net.one97.paytm.recharge.presentation.b.k a2;
            if (bVar != null) {
                int i2 = c.f64826d[bVar.f64955c.ordinal()];
                if (i2 == 1) {
                    this.this$0.a(true);
                } else if (!(i2 == 2 || i2 != 3 || (a2 = this.this$0.k) == null)) {
                    a2.dismissAllowingStateLoss();
                }
                CJRCreateSubscriptionApiResponse cJRCreateSubscriptionApiResponse = (CJRCreateSubscriptionApiResponse) bVar.f64954b;
                if (cJRCreateSubscriptionApiResponse != null) {
                    CJRNativeWithDrawDetails nativeWithDrawDetail = cJRCreateSubscriptionApiResponse.getNativeWithDrawDetail();
                    if (!TextUtils.isEmpty(nativeWithDrawDetail != null ? nativeWithDrawDetail.getTxnToken() : null)) {
                        this.this$0.v = cJRCreateSubscriptionApiResponse;
                        this.this$0.y = System.currentTimeMillis();
                        this.this$0.b();
                    }
                }
                NetworkCustomError networkCustomError = bVar.f64953a;
                if (networkCustomError != null) {
                    net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
                    net.one97.paytm.recharge.automatic.c.a.a.a(this.this$0.getActivity(), this.this$0, networkCustomError, IuserActions.SCROLL_MAIN_RV);
                }
            }
        }
    }

    /* renamed from: net.one97.paytm.recharge.presentation.c.b$b  reason: collision with other inner class name */
    public static final class C1279b {
        private C1279b() {
        }

        public /* synthetic */ C1279b(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        String str;
        String str2;
        y<net.one97.paytm.recharge.presentation.g.b<CJRPaymentOptionResponse>> yVar;
        y<net.one97.paytm.recharge.presentation.g.b<CJRRechargePayment>> yVar2;
        y<net.one97.paytm.recharge.presentation.g.b<CJROrderSummary>> yVar3;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        y<net.one97.paytm.recharge.presentation.g.b<CJRCreateSubscriptionApiResponse>> yVar4 = null;
        this.f64810f = arguments != null ? arguments.getString("from", "") : null;
        Bundle arguments2 = getArguments();
        this.f64811g = arguments2 != null ? arguments2.getString("txn_token") : null;
        Bundle arguments3 = getArguments();
        this.f64812h = arguments3 != null ? arguments3.getString("channel_id") : null;
        Bundle arguments4 = getArguments();
        this.f64813i = arguments4 != null ? arguments4.getString("key_mid") : null;
        Bundle arguments5 = getArguments();
        this.j = arguments5 != null ? arguments5.getString("key_order_id") : null;
        Bundle arguments6 = getArguments();
        this.p = arguments6 != null ? arguments6.getString("card_id") : null;
        Bundle arguments7 = getArguments();
        this.q = arguments7 != null ? arguments7.getString("key_payment_bank") : null;
        Bundle arguments8 = getArguments();
        this.r = arguments8 != null ? arguments8.getString("key_bank_mandate") : null;
        Bundle arguments9 = getArguments();
        this.u = arguments9 != null ? arguments9.getString("service_paytype", (String) null) : null;
        Bundle arguments10 = getArguments();
        int i2 = -1;
        if (arguments10 != null) {
            i2 = arguments10.getInt(CLPConstants.PRODUCT_ID, -1);
        }
        this.z = i2;
        Bundle arguments11 = getArguments();
        if (arguments11 == null || (str = arguments11.getString("key_account", "")) == null) {
            str = "";
        }
        this.A = str;
        Bundle arguments12 = getArguments();
        if (arguments12 == null || (str2 = arguments12.getString("operator_logo", "")) == null) {
            str2 = "";
        }
        this.B = str2;
        Bundle arguments13 = getArguments();
        boolean z2 = false;
        if (arguments13 != null) {
            z2 = arguments13.getBoolean("is_bank_mandate_enabled", false);
        }
        this.E = z2;
        Bundle arguments14 = getArguments();
        this.D = arguments14 != null ? arguments14.getString("last_four_digits", "") : null;
        Bundle arguments15 = getArguments();
        this.C = arguments15 != null ? arguments15.getString("first_four_digits", "") : null;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            kotlin.g.b.k.a();
        }
        this.f64806b = (net.one97.paytm.recharge.presentation.g.a) am.a(activity, (al.b) new net.one97.paytm.recharge.presentation.e.a()).a(net.one97.paytm.recharge.presentation.g.a.class);
        net.one97.paytm.recharge.presentation.g.a aVar = this.f64806b;
        if (aVar != null) {
            yVar = aVar.f64929f;
        } else {
            yVar = null;
        }
        net.one97.paytm.recharge.automatic.b.a.d.a(this, yVar, new h(this));
        net.one97.paytm.recharge.presentation.g.a aVar2 = this.f64806b;
        if (aVar2 != null) {
            yVar2 = aVar2.f64930g;
        } else {
            yVar2 = null;
        }
        net.one97.paytm.recharge.automatic.b.a.d.a(this, yVar2, new i(this));
        net.one97.paytm.recharge.presentation.g.a aVar3 = this.f64806b;
        if (aVar3 != null) {
            yVar3 = aVar3.j;
        } else {
            yVar3 = null;
        }
        net.one97.paytm.recharge.automatic.b.a.d.a(this, yVar3, new j(this));
        net.one97.paytm.recharge.presentation.g.a aVar4 = this.f64806b;
        if (aVar4 != null) {
            yVar4 = aVar4.f64928e;
        }
        net.one97.paytm.recharge.automatic.b.a.d.a(this, yVar4, new k(this));
        a();
    }

    public final void a(String str, Bundle bundle) {
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -1588683517) {
                if (hashCode == 1509838845 && str.equals("tag.alert.order.success")) {
                    boolean z2 = bundle != null ? bundle.getBoolean("isPending") : false;
                    net.one97.paytm.recharge.presentation.b.k kVar = this.k;
                    if (kVar != null) {
                        kVar.dismissAllowingStateLoss();
                    }
                    a aVar = F;
                    if (aVar != null) {
                        aVar.a(false, z2);
                    }
                }
            } else if (str.equals("tag.alert.order.failed")) {
                net.one97.paytm.recharge.presentation.b.k kVar2 = this.k;
                if (kVar2 != null) {
                    kVar2.dismissAllowingStateLoss();
                }
                FragmentActivity activity = getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        }
    }

    static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f64820a;

        e(b bVar) {
            this.f64820a = bVar;
        }

        public final void run() {
            net.one97.paytm.recharge.presentation.g.a e2;
            Context context = this.f64820a.getContext();
            if (context != null && !TextUtils.isEmpty(this.f64820a.m) && com.paytm.utility.b.c(context) && (e2 = this.f64820a.f64806b) != null) {
                Context context2 = this.f64820a.getContext();
                if (context2 == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) context2, "context!!");
                String d2 = this.f64820a.m;
                if (d2 == null) {
                    kotlin.g.b.k.a();
                }
                e2.a(context2, d2, this.f64820a.n);
            }
        }
    }

    private final void a(String str) {
        try {
            if (getContext() != null) {
                net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
                Context context = getContext();
                if (context == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) context, "context!!");
                a.C1160a aVar2 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                String a2 = net.one97.paytm.recharge.automatic.b.a.a.f60240b;
                String str2 = this.u;
                if (str2 == null) {
                    str2 = "";
                }
                net.one97.paytm.recharge.automatic.c.a.a.a(context, a2, str, "", str2, (Object) null, (Object) null, 96);
            }
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    public final void a(CJRRechargePayment cJRRechargePayment) {
        String str;
        List<String> list;
        Bundle bundle = this.f64807c;
        if (bundle != null) {
            boolean z2 = bundle.getBoolean("is_new_card_selected");
            if (z2) {
                String string = bundle.getString(SDKConstants.AI_KEY_EXPIRY);
                if (string != null) {
                    list = p.a((CharSequence) string, new String[]{"/"});
                } else {
                    list = null;
                }
                StringBuilder sb = new StringBuilder("|");
                sb.append(bundle.getString(SDKConstants.AI_KEY_CARD_NUMBER));
                sb.append("|");
                sb.append(bundle.getString(SDKConstants.AI_KEY_CVV));
                sb.append("|");
                if (list == null) {
                    kotlin.g.b.k.a();
                }
                sb.append(list.get(0));
                h.a aVar = net.one97.paytm.recharge.automatic.b.a.h.f60252a;
                String str2 = list.get(1);
                kotlin.g.b.k.c(str2, "inputYear");
                String valueOf = String.valueOf(Calendar.getInstance().get(1) / 100);
                StringBuilder sb2 = new StringBuilder(str2);
                sb2.insert(0, valueOf);
                String sb3 = sb2.toString();
                kotlin.g.b.k.a((Object) sb3, "newExpiryValidity.toString()");
                sb.append(sb3);
                str = sb.toString();
            } else {
                str = bundle.getString("card_id") + "||" + bundle.getString(SDKConstants.AI_KEY_CVV) + "|";
            }
            if (z2) {
                bundle.putString("card_type", this.f64809e);
            }
            a(false);
            RecyclerView recyclerView = (RecyclerView) a(R.id.rv_saved_cards);
            if (recyclerView != null) {
                recyclerView.postDelayed(new d(str, z2, this, cJRRechargePayment), 1000);
            }
        }
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f64816a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f64817b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b f64818c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CJRRechargePayment f64819d;

        d(String str, boolean z, b bVar, CJRRechargePayment cJRRechargePayment) {
            this.f64816a = str;
            this.f64817b = z;
            this.f64818c = bVar;
            this.f64819d = cJRRechargePayment;
        }

        public final void run() {
            b bVar = this.f64818c;
            Fragment fragment = bVar;
            String str = this.f64816a;
            CJRRechargePayment cJRRechargePayment = this.f64819d;
            boolean z = this.f64817b;
            Bundle g2 = bVar.f64807c;
            if (g2 == null) {
                kotlin.g.b.k.a();
            }
            String string = g2.getString("card_type");
            Bundle arguments = this.f64818c.getArguments();
            net.one97.paytm.recharge.automatic.b.a.c.a(fragment, "otp", str, cJRRechargePayment, z, string, arguments != null ? arguments.getString(UpiConstants.EXTRA_SUBSCRIPTION_ID) : null);
            net.one97.paytm.recharge.presentation.a.h h2 = this.f64818c.f64808d;
            if (h2 == null) {
                return;
            }
            if (h2.f64608a != -1 && h2.f64608a != -5) {
                h2.notifyItemChanged(h2.f64608a);
            } else if (h2.f64608a == -5) {
                h2.f64609b = false;
                h2.notifyDataSetChanged();
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.g.b.k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_payment_options, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        kotlin.g.b.k.c(view, "view");
        super.onViewCreated(view, bundle);
        if (p.a(this.f64810f, "manage_screen", true)) {
            TextView textView = (TextView) a(R.id.txt_heading);
            kotlin.g.b.k.a((Object) textView, "txt_heading");
            Context context = getContext();
            textView.setText(context != null ? context.getString(R.string.payment_option_heading_second) : null);
        }
    }

    public static final class f implements net.one97.paytm.recharge.presentation.d.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f64821a;

        public final String c() {
            return "1";
        }

        f(b bVar) {
            this.f64821a = bVar;
        }

        public final void a() {
            if (com.paytm.utility.b.c(this.f64821a.getContext())) {
                b.i(this.f64821a);
            } else {
                this.f64821a.b((int) SharedHomeVM.UPDATE_NON_RV_WIDGETS);
            }
        }

        public final void a(String str) {
            kotlin.g.b.k.c(str, "cardType");
            this.f64821a.f64809e = str;
        }

        public final io.reactivex.rxjava3.j.c<CJRTaggedObservable<CJRFetchBalanceResponse>> b() {
            io.reactivex.rxjava3.j.c<CJRTaggedObservable<CJRFetchBalanceResponse>> cVar;
            net.one97.paytm.recharge.presentation.g.a e2 = this.f64821a.f64806b;
            if (e2 != null) {
                cVar = e2.m;
            } else {
                cVar = null;
            }
            if ((cVar == null || !cVar.d()) && this.f64821a.getActivity() != null) {
                h.a aVar = net.one97.paytm.recharge.automatic.b.a.h.f60252a;
                h.a.e("getPPBLBalance() : onClick() : fetch PPBL balance again");
                net.one97.paytm.recharge.presentation.g.a e3 = this.f64821a.f64806b;
                if (e3 != null) {
                    FragmentActivity activity = this.f64821a.getActivity();
                    if (activity == null) {
                        kotlin.g.b.k.a();
                    }
                    kotlin.g.b.k.a((Object) activity, "activity!!");
                    Context context = activity;
                    String k = this.f64821a.f64813i;
                    if (k == null) {
                        kotlin.g.b.k.a();
                    }
                    String l = this.f64821a.j;
                    if (l == null) {
                        kotlin.g.b.k.a();
                    }
                    String m = this.f64821a.f64811g;
                    if (m == null) {
                        kotlin.g.b.k.a();
                    }
                    String n = this.f64821a.f64812h;
                    if (n == null) {
                        kotlin.g.b.k.a();
                    }
                    e3.a(context, k, l, m, n, false);
                }
            }
            return cVar;
        }

        public final io.reactivex.rxjava3.j.c<CJRTaggedObservable<?>> a(int i2, Bundle bundle) {
            kotlin.g.b.k.c(bundle, "bundle");
            if (!com.paytm.utility.b.c((Context) this.f64821a.getActivity())) {
                return null;
            }
            if (i2 == -5) {
                this.f64821a.a(true, bundle);
                return null;
            }
            net.one97.paytm.recharge.presentation.a.h h2 = this.f64821a.f64808d;
            if (h2 == null) {
                kotlin.g.b.k.a();
            }
            if (h2.getItemViewType(i2) != 3) {
                this.f64821a.a(false, bundle);
            } else if (!TextUtils.isEmpty(bundle.getString(SDKConstants.AI_KEY_CVV))) {
                return null;
            }
            return null;
        }

        public final androidx.fragment.app.j d() {
            androidx.fragment.app.j childFragmentManager = this.f64821a.getChildFragmentManager();
            kotlin.g.b.k.a((Object) childFragmentManager, "childFragmentManager");
            return childFragmentManager;
        }

        public final void a(CJRTaggedObservable<?> cJRTaggedObservable) {
            this.f64821a.accept(cJRTaggedObservable);
        }

        public final void a(CJRPaymentModes cJRPaymentModes) {
            kotlin.g.b.k.c(cJRPaymentModes, "payModes");
            i.a aVar = net.one97.paytm.recharge.presentation.b.i.f64781a;
            net.one97.paytm.recharge.presentation.d.c cVar = this;
            kotlin.g.b.k.c(cJRPaymentModes, "payModes");
            kotlin.g.b.k.c(cVar, "ijrPaymentOptionActionListener");
            net.one97.paytm.recharge.presentation.b.i.f64782f = cVar;
            net.one97.paytm.recharge.presentation.b.i iVar = new net.one97.paytm.recharge.presentation.b.i();
            Bundle bundle = new Bundle();
            bundle.putSerializable("pay_channel", cJRPaymentModes);
            iVar.setArguments(bundle);
            iVar.show(this.f64821a.getChildFragmentManager(), kotlin.g.b.y.b(net.one97.paytm.recharge.presentation.b.i.class).b());
        }

        public final void a(String str, CJRPayChannelOptions cJRPayChannelOptions, boolean z) {
            String str2;
            kotlin.g.b.k.c(str, "paymentModes");
            kotlin.g.b.k.c(cJRPayChannelOptions, "payChannelOption");
            this.f64821a.w = str;
            this.f64821a.x = cJRPayChannelOptions;
            this.f64821a.e();
            String str3 = "";
            if (z) {
                StringBuilder sb = new StringBuilder("popular_");
                String channelName = cJRPayChannelOptions.getChannelName();
                if (channelName != null) {
                    str3 = channelName;
                }
                sb.append(str3);
                str2 = sb.toString();
            } else {
                StringBuilder sb2 = new StringBuilder("other_");
                String channelName2 = cJRPayChannelOptions.getChannelName();
                if (channelName2 != null) {
                    str3 = channelName2;
                }
                sb2.append(str3);
                str2 = sb2.toString();
            }
            b.c(this.f64821a, "emandate");
            b.d(this.f64821a, str2);
        }
    }

    private final void b(String str) {
        try {
            if (getActivity() != null) {
                net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
                FragmentActivity activity = getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) activity, "activity!!");
                Context context = activity;
                a.C1160a aVar2 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                String a2 = net.one97.paytm.recharge.automatic.b.a.a.f60240b;
                a.C1160a aVar3 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                String J = net.one97.paytm.recharge.automatic.b.a.a.M;
                String str2 = this.u;
                if (str2 == null) {
                    str2 = "";
                }
                String str3 = str2;
                a.C1160a aVar4 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                net.one97.paytm.recharge.automatic.c.a.a.a(context, a2, J, "", str3, net.one97.paytm.recharge.automatic.b.a.a.P, str);
            }
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    public final void b() {
        Long txnAmount;
        CJRNativeWithDrawDetails nativeWithDrawDetail;
        CJRNativeWithDrawDetails nativeWithDrawDetail2;
        if (getActivity() != null) {
            Intent intent = new Intent(getActivity(), AJRBankAccountDetailsActivity.class);
            intent.putExtra("pay_channel", this.x);
            String str = this.w;
            if (str == null) {
                str = "";
            }
            HashMap hashMap = new HashMap();
            CJRCreateSubscriptionApiResponse cJRCreateSubscriptionApiResponse = this.v;
            String str2 = null;
            hashMap.put("key_mid", cJRCreateSubscriptionApiResponse != null ? cJRCreateSubscriptionApiResponse.getMid() : null);
            CJRCreateSubscriptionApiResponse cJRCreateSubscriptionApiResponse2 = this.v;
            hashMap.put("key_order_id", cJRCreateSubscriptionApiResponse2 != null ? cJRCreateSubscriptionApiResponse2.getOrderId() : null);
            CJRCreateSubscriptionApiResponse cJRCreateSubscriptionApiResponse3 = this.v;
            hashMap.put("txn_token", (cJRCreateSubscriptionApiResponse3 == null || (nativeWithDrawDetail2 = cJRCreateSubscriptionApiResponse3.getNativeWithDrawDetail()) == null) ? null : nativeWithDrawDetail2.getTxnToken());
            CJRCreateSubscriptionApiResponse cJRCreateSubscriptionApiResponse4 = this.v;
            hashMap.put(UpiConstants.EXTRA_SUBSCRIPTION_ID, (cJRCreateSubscriptionApiResponse4 == null || (nativeWithDrawDetail = cJRCreateSubscriptionApiResponse4.getNativeWithDrawDetail()) == null) ? null : nativeWithDrawDetail.getSubscriptionId());
            CJRCreateSubscriptionApiResponse cJRCreateSubscriptionApiResponse5 = this.v;
            hashMap.put("txn_amount", (cJRCreateSubscriptionApiResponse5 == null || (txnAmount = cJRCreateSubscriptionApiResponse5.getTxnAmount()) == null) ? null : String.valueOf(txnAmount.longValue()));
            CJRCreateSubscriptionApiResponse cJRCreateSubscriptionApiResponse6 = this.v;
            hashMap.put(CJRGTMConstants.MT_V4_TXN_STATUS, cJRCreateSubscriptionApiResponse6 != null ? cJRCreateSubscriptionApiResponse6.getStatus() : null);
            CJRCreateSubscriptionApiResponse cJRCreateSubscriptionApiResponse7 = this.v;
            hashMap.put("key_native_withdraw", cJRCreateSubscriptionApiResponse7 != null ? cJRCreateSubscriptionApiResponse7.getNativeWithDraw() : null);
            Bundle arguments = getArguments();
            if (arguments != null) {
                str2 = arguments.getString("recharge_number");
            }
            hashMap.put("recharge_number", str2);
            hashMap.put("paymentMode", str);
            hashMap.put("from", this.f64810f);
            intent.putExtra("e_mandate_bundle", hashMap);
            intent.putExtra("ga_label_key", this.u);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.startActivityForResult(intent, 1090);
            }
            RecyclerView recyclerView = (RecyclerView) a(R.id.rv_saved_cards);
            if (recyclerView != null) {
                recyclerView.postDelayed(new g(this), 300);
            }
        }
        if (!TextUtils.isEmpty(this.f64810f) && p.a(this.f64810f, "manage_screen", true)) {
            b("emandate");
        }
    }

    static final class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f64822a;

        g(b bVar) {
            this.f64822a = bVar;
        }

        public final void run() {
            net.one97.paytm.recharge.presentation.b.k a2 = this.f64822a.k;
            if (a2 != null) {
                a2.dismissAllowingStateLoss();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void a(boolean z2, Bundle bundle) {
        String str;
        if (getContext() != null) {
            bundle.putBoolean("is_new_card_selected", z2);
            this.f64807c = bundle;
            a(d());
            if (z2) {
                b("add new");
            } else if (bundle.containsKey("card_type")) {
                Object obj = bundle.get("card_type");
                if (obj instanceof String) {
                    str = SDKConstants.CREDIT.equals(obj) ? "credit card" : p.a(SDKConstants.DEBIT, (String) obj, true) ? "debit card" : BaseViewModel.PaymentType.PPB;
                } else {
                    str = "";
                }
                b(str);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void a(boolean z2) {
        if (getContext() instanceof FragmentActivity) {
            k.a aVar = net.one97.paytm.recharge.presentation.b.k.f64792a;
            this.k = new net.one97.paytm.recharge.presentation.b.k();
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_bank_mandate_enabled", z2);
            net.one97.paytm.recharge.presentation.b.k kVar = this.k;
            if (kVar != null) {
                kVar.setArguments(bundle);
            }
            net.one97.paytm.recharge.presentation.b.k kVar2 = this.k;
            if (kVar2 != null) {
                Context context = getContext();
                if (context != null) {
                    kVar2.show(((FragmentActivity) context).getSupportFragmentManager(), net.one97.paytm.recharge.presentation.b.k.class.getSimpleName());
                    return;
                }
                throw new u("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            }
        }
    }

    private final void c() {
        int i2;
        if (getActivity() instanceof AJRAutomaticSetupActivity) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.presentation.activity.AJRAutomaticSetupActivity");
            } else if (((AJRAutomaticSetupActivity) activity).a()) {
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    AJRAutomaticSetupActivity aJRAutomaticSetupActivity = (AJRAutomaticSetupActivity) activity2;
                    net.one97.paytm.recharge.presentation.a.h hVar = this.f64808d;
                    if (hVar != null) {
                        i2 = hVar.f64608a;
                    } else {
                        i2 = -1;
                    }
                    aJRAutomaticSetupActivity.a(i2);
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.presentation.activity.AJRAutomaticSetupActivity");
            }
        }
    }

    /* access modifiers changed from: private */
    public final void a(String str, String str2) {
        if (getContext() == null || !com.paytm.utility.d.c(getContext())) {
            net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
            Context context = getContext();
            if (context != null) {
                net.one97.paytm.recharge.automatic.c.a.a.a((Activity) context, (int) IuserActions.ON_FLASHSALE_CLICK);
                return;
            }
            throw new u("null cannot be cast to non-null type android.app.Activity");
        } else if (com.paytm.utility.b.c(getContext())) {
            net.one97.paytm.recharge.presentation.g.a aVar2 = this.f64806b;
            if (aVar2 != null) {
                Context context2 = getContext();
                if (context2 == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) context2, "context!!");
                aVar2.a(context2, str, str2);
            }
        } else {
            b((int) IuserActions.ON_FLASHSALE_CLICK);
        }
    }

    /* renamed from: a */
    public final void accept(CJRTaggedObservable<?> cJRTaggedObservable) {
        String tag = cJRTaggedObservable != null ? cJRTaggedObservable.getTag() : null;
        if (tag == null || tag.hashCode() != 508779047 || !tag.equals("tag.get.ppbl.access.token")) {
            return;
        }
        if (cJRTaggedObservable.getData() instanceof CJRBankToken) {
            Object data = cJRTaggedObservable.getData();
            if (data != null) {
                CJRBankToken cJRBankToken = (CJRBankToken) data;
                if (!TextUtils.isEmpty(cJRBankToken.getAccessToken())) {
                    this.o = cJRBankToken;
                    Bundle bundle = new Bundle();
                    bundle.putString("card_type", SDKConstants.AI_KEY_PPBL);
                    a(false, bundle);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.domain.entities.CJRBankToken");
        } else if (cJRTaggedObservable.getData() instanceof NetworkCustomError) {
            net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
            Activity activity = getActivity();
            Object data2 = cJRTaggedObservable.getData();
            if (data2 != null) {
                net.one97.paytm.recharge.automatic.c.a.a.a(activity, (NetworkCustomError) data2, (int) SharedHomeVM.UPDATE_NOTIFICATION_ICON);
                return;
            }
            throw new u("null cannot be cast to non-null type com.paytm.network.model.NetworkCustomError");
        }
    }

    public final void onRequestEnd(CJPayMethodResponse cJPayMethodResponse, VpaFetch vpaFetch) {
        PaytmSDK.setResponse(cJPayMethodResponse, vpaFetch);
        a(d());
    }

    private final CJRRechargePayment d() {
        CJRRechargePayment cJRRechargePayment = new CJRRechargePayment();
        Bundle arguments = getArguments();
        String str = null;
        cJRRechargePayment.setmMID(arguments != null ? arguments.getString("key_mid") : null);
        Bundle arguments2 = getArguments();
        cJRRechargePayment.setmOrderId(arguments2 != null ? arguments2.getString("key_order_id") : null);
        Bundle arguments3 = getArguments();
        cJRRechargePayment.setmTxnToken(arguments3 != null ? arguments3.getString("txn_token") : null);
        Bundle arguments4 = getArguments();
        cJRRechargePayment.setTxnAmount(arguments4 != null ? arguments4.getString("txn_amount") : null);
        Bundle arguments5 = getArguments();
        cJRRechargePayment.setmStatus(arguments5 != null ? arguments5.getString(CJRGTMConstants.MT_V4_TXN_STATUS) : null);
        Bundle arguments6 = getArguments();
        if (arguments6 != null) {
            str = arguments6.getString("key_native_withdraw");
        }
        cJRRechargePayment.setmNativeEnabled(str);
        if (this.o != null) {
            HashMap<String, String> pGParams = cJRRechargePayment.getPGParams();
            if (pGParams == null) {
                pGParams = new HashMap<>();
            }
            Map map = pGParams;
            CJRBankToken cJRBankToken = this.o;
            if (cJRBankToken == null) {
                kotlin.g.b.k.a();
            }
            map.put("tag.get.ppbl.access.token", cJRBankToken.getAccessToken());
        }
        return cJRRechargePayment;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0020, code lost:
        r0 = r0.f64929f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r7 = this;
            android.content.Context r0 = r7.getContext()
            r1 = 1011(0x3f3, float:1.417E-42)
            if (r0 == 0) goto L_0x0067
            android.content.Context r0 = r7.getContext()
            boolean r0 = com.paytm.utility.d.c(r0)
            if (r0 == 0) goto L_0x0067
            android.content.Context r0 = r7.getContext()
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
            if (r0 == 0) goto L_0x0063
            net.one97.paytm.recharge.presentation.g.a r0 = r7.f64806b
            if (r0 == 0) goto L_0x002b
            androidx.lifecycle.y<net.one97.paytm.recharge.presentation.g.b<net.one97.paytm.recharge.domain.entities.CJRPaymentOptionResponse>> r0 = r0.f64929f
            if (r0 == 0) goto L_0x002b
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.recharge.presentation.g.b r0 = (net.one97.paytm.recharge.presentation.g.b) r0
            goto L_0x002c
        L_0x002b:
            r0 = 0
        L_0x002c:
            if (r0 != 0) goto L_0x0085
            net.one97.paytm.recharge.presentation.g.a r1 = r7.f64806b
            if (r1 == 0) goto L_0x0062
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            if (r0 != 0) goto L_0x003b
            kotlin.g.b.k.a()
        L_0x003b:
            java.lang.String r2 = "activity!!"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            java.lang.String r3 = r7.f64813i
            if (r3 != 0) goto L_0x004a
            kotlin.g.b.k.a()
        L_0x004a:
            java.lang.String r4 = r7.j
            if (r4 != 0) goto L_0x0051
            kotlin.g.b.k.a()
        L_0x0051:
            java.lang.String r5 = r7.f64811g
            if (r5 != 0) goto L_0x0058
            kotlin.g.b.k.a()
        L_0x0058:
            java.lang.String r6 = r7.f64812h
            if (r6 != 0) goto L_0x005f
            kotlin.g.b.k.a()
        L_0x005f:
            r1.a(r2, r3, r4, r5, r6)
        L_0x0062:
            return
        L_0x0063:
            r7.b((int) r1)
            return
        L_0x0067:
            android.content.Context r0 = r7.getContext()
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L_0x0085
            net.one97.paytm.recharge.automatic.c.a.a r0 = net.one97.paytm.recharge.automatic.c.a.a.f60256a
            android.content.Context r0 = r7.getContext()
            if (r0 == 0) goto L_0x007d
            android.app.Activity r0 = (android.app.Activity) r0
            net.one97.paytm.recharge.automatic.c.a.a.a((android.app.Activity) r0, (int) r1)
            goto L_0x0085
        L_0x007d:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type android.app.Activity"
            r0.<init>(r1)
            throw r0
        L_0x0085:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.presentation.c.b.a():void");
    }

    /* access modifiers changed from: private */
    public final void b(int i2) {
        this.s = new net.one97.paytm.recharge.widgets.widget.a();
        net.one97.paytm.recharge.widgets.widget.a aVar = this.s;
        if (aVar != null) {
            aVar.a(new c(this, i2));
        }
        q a2 = getChildFragmentManager().a();
        int i3 = R.id.offline_lyt_container;
        net.one97.paytm.recharge.widgets.widget.a aVar2 = this.s;
        if (aVar2 == null) {
            kotlin.g.b.k.a();
        }
        a2.a(i3, aVar2, "").e();
        FrameLayout frameLayout = (FrameLayout) a(R.id.offline_lyt_container);
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f64814a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f64815b;

        c(b bVar, int i2) {
            this.f64814a = bVar;
            this.f64815b = i2;
        }

        public final void onClick(View view) {
            if (SystemClock.elapsedRealtime() - this.f64814a.t >= 2000) {
                this.f64814a.t = SystemClock.elapsedRealtime();
                if (this.f64814a.getActivity() != null && com.paytm.utility.b.c((Context) this.f64814a.getActivity())) {
                    q a2 = this.f64814a.getChildFragmentManager().a();
                    net.one97.paytm.recharge.widgets.widget.a q = this.f64814a.s;
                    if (q == null) {
                        kotlin.g.b.k.a();
                    }
                    a2.a((Fragment) q).b();
                    FrameLayout frameLayout = (FrameLayout) this.f64814a.a(R.id.offline_lyt_container);
                    if (frameLayout != null) {
                        frameLayout.setVisibility(8);
                    }
                    int i2 = this.f64815b;
                    if (i2 == 1011) {
                        this.f64814a.a();
                    } else if (i2 == 1012) {
                        b bVar = this.f64814a;
                        String d2 = bVar.m;
                        if (d2 == null) {
                            kotlin.g.b.k.a();
                        }
                        bVar.a(d2, this.f64814a.n);
                    } else if (i2 == 1016) {
                        b.i(this.f64814a);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
        r0 = r0.f64928e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e() {
        /*
            r4 = this;
            androidx.fragment.app.FragmentActivity r0 = r4.getActivity()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            boolean r0 = r4.h()
            if (r0 == 0) goto L_0x0055
            androidx.fragment.app.FragmentActivity r0 = r4.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            boolean r0 = com.paytm.utility.d.c(r0)
            r1 = 0
            if (r0 == 0) goto L_0x003b
            net.one97.paytm.recharge.presentation.g.a r0 = r4.f64806b
            if (r0 == 0) goto L_0x0029
            androidx.lifecycle.y<net.one97.paytm.recharge.presentation.g.b<net.one97.paytm.recharge.domain.entities.CJRCreateSubscriptionApiResponse>> r0 = r0.f64928e
            if (r0 == 0) goto L_0x0029
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.recharge.presentation.g.b r0 = (net.one97.paytm.recharge.presentation.g.b) r0
            goto L_0x002a
        L_0x0029:
            r0 = r1
        L_0x002a:
            if (r0 == 0) goto L_0x0037
            net.one97.paytm.recharge.presentation.g.a r0 = r4.f64806b
            if (r0 == 0) goto L_0x0037
            androidx.lifecycle.y<net.one97.paytm.recharge.presentation.g.b<net.one97.paytm.recharge.domain.entities.CJRCreateSubscriptionApiResponse>> r0 = r0.f64928e
            if (r0 == 0) goto L_0x0037
            r0.setValue(r1)
        L_0x0037:
            r4.f()
            return
        L_0x003b:
            r4.v = r1
            net.one97.paytm.recharge.automatic.c.a.a r0 = net.one97.paytm.recharge.automatic.c.a.a.f60256a
            androidx.fragment.app.FragmentActivity r0 = r4.getActivity()
            android.app.Activity r0 = (android.app.Activity) r0
            r1 = r4
            androidx.fragment.app.Fragment r1 = (androidx.fragment.app.Fragment) r1
            net.one97.paytm.recharge.widgets.c.a r2 = new net.one97.paytm.recharge.widgets.c.a
            r2.<init>()
            com.paytm.network.model.NetworkCustomError r2 = (com.paytm.network.model.NetworkCustomError) r2
            r3 = 1018(0x3fa, float:1.427E-42)
            net.one97.paytm.recharge.automatic.c.a.a.a(r0, r1, r2, r3)
            return
        L_0x0055:
            r4.b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.presentation.c.b.e():void");
    }

    private final void f() {
        if (getActivity() != null) {
            if (!com.paytm.utility.b.c((Context) getActivity())) {
                net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
                net.one97.paytm.recharge.automatic.c.a.a.a((Activity) getActivity(), (NetworkCustomError) new net.one97.paytm.recharge.widgets.c.h(), 0);
                return;
            }
            net.one97.paytm.recharge.presentation.g.a aVar2 = this.f64806b;
            if (aVar2 != null) {
                FragmentActivity activity = getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) activity, "activity!!");
                aVar2.a((Context) activity, g());
            }
        }
    }

    private final Bundle g() {
        Bundle bundle = new Bundle();
        Bundle arguments = getArguments();
        boolean z2 = true;
        if (arguments != null) {
            z2 = arguments.getBoolean("is_postpaid", true);
        }
        bundle.putBoolean("is_postpaid", z2);
        Bundle arguments2 = getArguments();
        String str = null;
        bundle.putString("recharge_days", arguments2 != null ? arguments2.getString("recharge_days", "") : null);
        Bundle arguments3 = getArguments();
        bundle.putString("recharge_amount", arguments3 != null ? arguments3.getString("recharge_amount") : null);
        Bundle arguments4 = getArguments();
        bundle.putString("recharge_date", arguments4 != null ? arguments4.getString("recharge_date") : null);
        Bundle arguments5 = getArguments();
        bundle.putString("recharge_number", arguments5 != null ? arguments5.getString("recharge_number") : null);
        Bundle arguments6 = getArguments();
        bundle.putString(UpiConstants.EXTRA_SUBSCRIPTION_ID, arguments6 != null ? arguments6.getString(UpiConstants.EXTRA_SUBSCRIPTION_ID) : null);
        bundle.putString("from", this.f64810f);
        Bundle arguments7 = getArguments();
        if (arguments7 != null) {
            str = arguments7.getString("product_id_option");
        }
        bundle.putString(CLPConstants.PRODUCT_ID, str);
        return bundle;
    }

    private final boolean h() {
        y<net.one97.paytm.recharge.presentation.g.b<CJRCreateSubscriptionApiResponse>> yVar;
        if (this.v == null) {
            return true;
        }
        if (System.currentTimeMillis() - this.y <= 60000) {
            return false;
        }
        net.one97.paytm.recharge.presentation.g.a aVar = this.f64806b;
        if (!(aVar == null || (yVar = aVar.f64928e) == null)) {
            yVar.setValue(null);
        }
        this.v = null;
        return true;
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        y<net.one97.paytm.recharge.presentation.g.b<CJRCreateSubscriptionApiResponse>> yVar;
        y<net.one97.paytm.recharge.presentation.g.b<CJRCreateSubscriptionApiResponse>> yVar2;
        String str = null;
        if (i3 == 0 || intent == null) {
            net.one97.paytm.recharge.presentation.b.k kVar = this.k;
            if (kVar != null) {
                kVar.dismissAllowingStateLoss();
            }
            net.one97.paytm.recharge.presentation.g.a aVar = this.f64806b;
            if (!(aVar == null || (yVar = aVar.f64928e) == null)) {
                yVar.setValue(null);
            }
            this.v = null;
            c();
        } else if (1012 == i2) {
            this.m = intent != null ? intent.getStringExtra("intent_extra_wallet_order_id") : null;
            if (this.m == null && intent != null && intent.hasExtra("order_id")) {
                this.m = intent.getStringExtra("order_id");
            }
            if (intent != null) {
                str = intent.getStringExtra("pg_screen");
            }
            this.n = str;
            if (!TextUtils.isEmpty(this.m)) {
                String str2 = this.m;
                if (str2 == null) {
                    kotlin.g.b.k.a();
                }
                a(str2, this.n);
                return;
            }
            net.one97.paytm.recharge.presentation.b.k kVar2 = this.k;
            if (kVar2 != null) {
                kVar2.dismissAllowingStateLoss();
            }
        } else if (1011 == i2) {
            a();
        } else if (1012 == i2) {
            String str3 = this.m;
            if (str3 == null) {
                kotlin.g.b.k.a();
            }
            a(str3, this.n);
        } else if (1018 == i2) {
            e();
        } else if (i2 == 1090) {
            net.one97.paytm.recharge.presentation.g.a aVar2 = this.f64806b;
            if (!(aVar2 == null || (yVar2 = aVar2.f64928e) == null)) {
                yVar2.setValue(null);
            }
            this.v = null;
            c();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x005f, code lost:
        r1 = r1.getMerchantPayOption();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.recharge.presentation.c.b r19, net.one97.paytm.recharge.domain.entities.CJRPaymentOptionResponse r20) {
        /*
            r0 = r19
            int r1 = net.one97.paytm.recharge.automatic.R.id.rv_saved_cards
            android.view.View r1 = r0.a((int) r1)
            androidx.recyclerview.widget.RecyclerView r1 = (androidx.recyclerview.widget.RecyclerView) r1
            r2 = 1
            r1.setHasFixedSize(r2)
            int r1 = net.one97.paytm.recharge.automatic.R.id.rv_saved_cards
            android.view.View r1 = r0.a((int) r1)
            androidx.recyclerview.widget.RecyclerView r1 = (androidx.recyclerview.widget.RecyclerView) r1
            java.lang.String r3 = "rv_saved_cards"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            r4 = 0
            r1.setNestedScrollingEnabled(r4)
            androidx.fragment.app.FragmentActivity r1 = r19.getActivity()
            if (r1 == 0) goto L_0x0058
            int r5 = net.one97.paytm.recharge.automatic.R.id.rv_saved_cards
            android.view.View r5 = r0.a((int) r5)
            androidx.recyclerview.widget.RecyclerView r5 = (androidx.recyclerview.widget.RecyclerView) r5
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r3)
            androidx.recyclerview.widget.LinearLayoutManager r3 = new androidx.recyclerview.widget.LinearLayoutManager
            r6 = r1
            android.content.Context r6 = (android.content.Context) r6
            r3.<init>(r6, r2, r4)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r3 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r3
            r5.setLayoutManager(r3)
            int r3 = net.one97.paytm.recharge.automatic.R.id.rv_saved_cards
            android.view.View r3 = r0.a((int) r3)
            androidx.recyclerview.widget.RecyclerView r3 = (androidx.recyclerview.widget.RecyclerView) r3
            if (r3 == 0) goto L_0x0058
            net.one97.paytm.recharge.automatic.b.a.g r4 = new net.one97.paytm.recharge.automatic.b.a.g
            java.lang.String r5 = "it"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            r1 = 54
            r4.<init>(r6, r1)
            androidx.recyclerview.widget.RecyclerView$h r4 = (androidx.recyclerview.widget.RecyclerView.h) r4
            r3.addItemDecoration(r4)
        L_0x0058:
            net.one97.paytm.recharge.domain.entities.CJRPaymentOptionBody r1 = r20.getBody()
            r3 = 0
            if (r1 == 0) goto L_0x006a
            net.one97.paytm.recharge.domain.entities.CJRMerchantPayOption r1 = r1.getMerchantPayOption()
            if (r1 == 0) goto L_0x006a
            java.util.ArrayList r1 = r1.getPaymentModes()
            goto L_0x006b
        L_0x006a:
            r1 = r3
        L_0x006b:
            java.lang.String r4 = "iterator.next()"
            if (r1 == 0) goto L_0x00a7
            java.util.Iterator r1 = r1.iterator()
            java.lang.String r5 = "paymentModes.iterator()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
        L_0x0078:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x00a7
            java.lang.Object r5 = r1.next()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r4)
            net.one97.paytm.recharge.domain.entities.CJRPaymentModes r5 = (net.one97.paytm.recharge.domain.entities.CJRPaymentModes) r5
            java.lang.String r6 = r5.getPaymentMode()
            java.lang.String r7 = "PPBL"
            boolean r6 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r6, (boolean) r2)
            if (r6 != 0) goto L_0x0078
            java.lang.String r5 = r5.getPaymentMode()
            java.lang.String r6 = "BANK_MANDATE"
            boolean r5 = kotlin.m.p.a((java.lang.String) r6, (java.lang.String) r5, (boolean) r2)
            if (r5 == 0) goto L_0x00a3
            boolean r5 = r0.E
            if (r5 != 0) goto L_0x0078
        L_0x00a3:
            r1.remove()
            goto L_0x0078
        L_0x00a7:
            net.one97.paytm.recharge.automatic.c.a.b r1 = net.one97.paytm.recharge.automatic.c.a.b.f60258a
            boolean r1 = net.one97.paytm.recharge.automatic.c.a.b.h()
            if (r1 != 0) goto L_0x0149
            net.one97.paytm.recharge.domain.entities.CJRPaymentOptionBody r1 = r20.getBody()
            if (r1 == 0) goto L_0x00c0
            net.one97.paytm.recharge.domain.entities.CJRMerchantPayOption r1 = r1.getMerchantPayOption()
            if (r1 == 0) goto L_0x00c0
            java.util.ArrayList r1 = r1.getSavedInstruments()
            goto L_0x00c1
        L_0x00c0:
            r1 = r3
        L_0x00c1:
            if (r1 == 0) goto L_0x0149
            net.one97.paytm.recharge.domain.entities.CJRPaymentOptionBody r1 = r20.getBody()
            if (r1 == 0) goto L_0x00dd
            net.one97.paytm.recharge.domain.entities.CJRMerchantPayOption r1 = r1.getMerchantPayOption()
            if (r1 == 0) goto L_0x00dd
            java.util.ArrayList r1 = r1.getSavedInstruments()
            if (r1 == 0) goto L_0x00dd
            boolean r1 = r1.isEmpty()
            if (r1 != r2) goto L_0x00dd
            goto L_0x0149
        L_0x00dd:
            net.one97.paytm.recharge.domain.entities.CJRPaymentOptionBody r1 = r20.getBody()
            if (r1 == 0) goto L_0x00ee
            net.one97.paytm.recharge.domain.entities.CJRMerchantPayOption r1 = r1.getMerchantPayOption()
            if (r1 == 0) goto L_0x00ee
            java.util.ArrayList r1 = r1.getSavedInstruments()
            goto L_0x00ef
        L_0x00ee:
            r1 = r3
        L_0x00ef:
            if (r1 != 0) goto L_0x00f4
            kotlin.g.b.k.a()
        L_0x00f4:
            java.util.Iterator r1 = r1.iterator()
            java.lang.String r5 = "paymentOptionResponse.bo…dInstruments!!.iterator()"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
        L_0x00fd:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x0149
            java.lang.Object r5 = r1.next()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r4)
            net.one97.paytm.recharge.domain.entities.CJRSavedInstrument r5 = (net.one97.paytm.recharge.domain.entities.CJRSavedInstrument) r5
            net.one97.paytm.recharge.domain.entities.CJRCardDetails r6 = r5.getCardDetails()
            if (r6 == 0) goto L_0x0117
            java.lang.String r6 = r6.getCardType()
            goto L_0x0118
        L_0x0117:
            r6 = r3
        L_0x0118:
            net.one97.paytm.recharge.automatic.c.a.b r7 = net.one97.paytm.recharge.automatic.c.a.b.f60258a
            java.util.ArrayList r7 = net.one97.paytm.recharge.automatic.c.a.b.m()
            r8 = r6
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x012f
            java.lang.String r8 = "DEBIT_CARD"
            boolean r6 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r6, (boolean) r2)
            if (r6 != 0) goto L_0x0145
        L_0x012f:
            r6 = r7
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r6.isEmpty()
            r6 = r6 ^ r2
            if (r6 == 0) goto L_0x00fd
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.lang.String r5 = r5.getIssuingBank()
            boolean r5 = kotlin.a.k.a(r7, r5)
            if (r5 == 0) goto L_0x00fd
        L_0x0145:
            r1.remove()
            goto L_0x00fd
        L_0x0149:
            net.one97.paytm.recharge.presentation.a.h r1 = new net.one97.paytm.recharge.presentation.a.h
            java.lang.String r7 = r0.p
            java.lang.String r8 = r0.C
            java.lang.String r9 = r0.D
            java.lang.String r10 = r0.q
            java.lang.String r11 = r0.r
            net.one97.paytm.recharge.domain.entities.CJRPaymentOptionBody r4 = r20.getBody()
            if (r4 == 0) goto L_0x0167
            net.one97.paytm.recharge.domain.entities.CJRMerchantPayOption r4 = r4.getMerchantPayOption()
            if (r4 == 0) goto L_0x0167
            java.util.ArrayList r4 = r4.getSavedInstruments()
            r12 = r4
            goto L_0x0168
        L_0x0167:
            r12 = r3
        L_0x0168:
            net.one97.paytm.recharge.domain.entities.CJRPaymentOptionBody r4 = r20.getBody()
            if (r4 == 0) goto L_0x0178
            net.one97.paytm.recharge.domain.entities.CJRMerchantPayOption r4 = r4.getMerchantPayOption()
            if (r4 == 0) goto L_0x0178
            java.util.ArrayList r3 = r4.getPaymentModes()
        L_0x0178:
            r13 = r3
            java.lang.String r14 = r0.f64810f
            java.lang.String r15 = r0.u
            java.lang.String r3 = r0.A
            java.lang.String r4 = r0.B
            net.one97.paytm.recharge.presentation.c.b$f r5 = new net.one97.paytm.recharge.presentation.c.b$f
            r5.<init>(r0)
            r18 = r5
            net.one97.paytm.recharge.presentation.d.c r18 = (net.one97.paytm.recharge.presentation.d.c) r18
            r6 = r1
            r16 = r3
            r17 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r0.f64808d = r1
            int r1 = net.one97.paytm.recharge.automatic.R.id.rv_saved_cards
            android.view.View r1 = r0.a((int) r1)
            androidx.recyclerview.widget.RecyclerView r1 = (androidx.recyclerview.widget.RecyclerView) r1
            if (r1 == 0) goto L_0x01a5
            net.one97.paytm.recharge.presentation.a.h r3 = r0.f64808d
            androidx.recyclerview.widget.RecyclerView$a r3 = (androidx.recyclerview.widget.RecyclerView.a) r3
            r1.setAdapter(r3)
        L_0x01a5:
            net.one97.paytm.recharge.presentation.a.h r1 = r0.f64808d
            if (r1 == 0) goto L_0x0216
            int r0 = r0.z
            r3 = -1
            if (r0 == r3) goto L_0x0216
            r1.f64608a = r0
            int r0 = r1.f64608a
            int r0 = r1.getItemViewType(r0)
            r3 = 2
            if (r0 != r3) goto L_0x01cf
            java.util.ArrayList<net.one97.paytm.recharge.domain.entities.CJRSavedInstrument> r0 = r1.f64612e
            if (r0 != 0) goto L_0x01c0
            kotlin.g.b.k.a()
        L_0x01c0:
            int r3 = r1.f64608a
            int r4 = r1.f64610c
            int r3 = r3 - r4
            java.lang.Object r0 = r0.get(r3)
            net.one97.paytm.recharge.domain.entities.CJRSavedInstrument r0 = (net.one97.paytm.recharge.domain.entities.CJRSavedInstrument) r0
            r0.setSelected(r2)
            goto L_0x0213
        L_0x01cf:
            r3 = 3
            if (r0 != r3) goto L_0x01ed
            int r0 = r1.f64608a
            int r3 = r1.a()
            int r0 = r0 - r3
            int r3 = r1.f64610c
            int r0 = r0 - r3
            java.util.ArrayList<net.one97.paytm.recharge.domain.entities.CJRPaymentModes> r3 = r1.f64613f
            if (r3 != 0) goto L_0x01e3
            kotlin.g.b.k.a()
        L_0x01e3:
            java.lang.Object r0 = r3.get(r0)
            net.one97.paytm.recharge.domain.entities.CJRPaymentModes r0 = (net.one97.paytm.recharge.domain.entities.CJRPaymentModes) r0
            r0.setSelected(r2)
            goto L_0x0213
        L_0x01ed:
            r3 = 4
            if (r0 != r3) goto L_0x020b
            int r0 = r1.f64608a
            int r3 = r1.a()
            int r0 = r0 - r3
            int r3 = r1.f64610c
            int r0 = r0 - r3
            java.util.ArrayList<net.one97.paytm.recharge.domain.entities.CJRPaymentModes> r3 = r1.f64613f
            if (r3 != 0) goto L_0x0201
            kotlin.g.b.k.a()
        L_0x0201:
            java.lang.Object r0 = r3.get(r0)
            net.one97.paytm.recharge.domain.entities.CJRPaymentModes r0 = (net.one97.paytm.recharge.domain.entities.CJRPaymentModes) r0
            r0.setSelected(r2)
            goto L_0x0213
        L_0x020b:
            r3 = 5
            if (r0 != r3) goto L_0x0213
            net.one97.paytm.recharge.domain.entities.CJRPaymentModes r0 = r1.f64611d
            r0.setSelected(r2)
        L_0x0213:
            r1.notifyDataSetChanged()
        L_0x0216:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.presentation.c.b.a(net.one97.paytm.recharge.presentation.c.b, net.one97.paytm.recharge.domain.entities.CJRPaymentOptionResponse):void");
    }

    public static final /* synthetic */ void a(b bVar, CJROrderSummary cJROrderSummary) {
        String str;
        int i2;
        int orderStatus = cJROrderSummary.getOrderStatus();
        if (orderStatus == 1) {
            net.one97.paytm.recharge.presentation.b.k kVar = bVar.k;
            if (kVar != null) {
                kVar.dismissAllowingStateLoss();
            }
        } else if (orderStatus == 2) {
            ArrayList<CJROrderedCart> orderedCartList = cJROrderSummary.getOrderedCartList();
            if (orderedCartList != null && (!orderedCartList.isEmpty())) {
                CJROrderedCart cJROrderedCart = cJROrderSummary.getOrderedCartList().get(0);
                kotlin.g.b.k.a((Object) cJROrderedCart, "cjrOrderSummary.orderedCartList[0]");
                if (!kotlin.g.b.k.a((Object) "6", (Object) cJROrderedCart.getItemStatus())) {
                    CJROrderedCart cJROrderedCart2 = cJROrderSummary.getOrderedCartList().get(0);
                    kotlin.g.b.k.a((Object) cJROrderedCart2, "cjrOrderSummary.orderedCartList[0]");
                    if (!kotlin.g.b.k.a((Object) "210", (Object) cJROrderedCart2.getItemStatus()) && (i2 = bVar.l) != 0) {
                        bVar.l = i2 - 1;
                        RecyclerView recyclerView = (RecyclerView) bVar.a(R.id.rv_saved_cards);
                        if (recyclerView != null) {
                            recyclerView.postDelayed(new e(bVar), 1000);
                            return;
                        }
                        return;
                    }
                }
                CJROrderedCart cJROrderedCart3 = cJROrderSummary.getOrderedCartList().get(0);
                kotlin.g.b.k.a((Object) cJROrderedCart3, "cjrOrderSummary.orderedCartList[0]");
                boolean a2 = kotlin.g.b.k.a((Object) "210", (Object) cJROrderedCart3.getItemStatus());
                if (a2) {
                    net.one97.paytm.recharge.presentation.b.k kVar2 = bVar.k;
                    if (kVar2 != null) {
                        kVar2.dismissAllowingStateLoss();
                    }
                    a aVar = F;
                    if (aVar != null) {
                        aVar.a(a2, false);
                    }
                    a.C1160a aVar2 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                    bVar.a(net.one97.paytm.recharge.automatic.b.a.a.r);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("isPending", false);
                com.paytm.utility.g.a((g.a) new net.one97.paytm.recharge.widgets.a.a("tag.alert.order.success", bVar, bundle));
                CJROrderedCart cJROrderedCart4 = cJROrderSummary.getOrderedCartList().get(0);
                kotlin.g.b.k.a((Object) cJROrderedCart4, "cjrOrderSummary.orderedCartList[0]");
                String itemStatus = cJROrderedCart4.getItemStatus();
                if (itemStatus != null && itemStatus.hashCode() == 54 && itemStatus.equals("6")) {
                    str = bVar.getString(R.string.automatic_subscription_failed);
                    kotlin.g.b.k.a((Object) str, "getString(R.string.automatic_subscription_failed)");
                    a.C1160a aVar3 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                    bVar.a(net.one97.paytm.recharge.automatic.b.a.a.s);
                } else {
                    str = bVar.getString(R.string.automatic_subscription_pending);
                    kotlin.g.b.k.a((Object) str, "getString(R.string.automatic_subscription_pending)");
                }
                com.paytm.utility.g.b(bVar.getContext(), "", str);
            }
        } else if (orderStatus == 4 || orderStatus == 8) {
            net.one97.paytm.recharge.presentation.b.k kVar3 = bVar.k;
            if (kVar3 != null) {
                kVar3.dismissAllowingStateLoss();
            }
            com.paytm.utility.g.a((g.a) new net.one97.paytm.recharge.widgets.a.a("tag.alert.order.failed", bVar));
            com.paytm.utility.b.b(bVar.getContext(), "", bVar.getString(R.string.automatic_card_not_verified_msg));
        }
    }

    public static final /* synthetic */ void i(b bVar) {
        if (bVar.getActivity() != null) {
            Intent intent = new Intent(bVar.getActivity(), AJRAutomaticSubscriptionTnCWebView.class);
            intent.putExtra("url", "https://www.paytmbank.com/Terms&Conditions");
            bVar.startActivity(intent);
        }
    }

    public static final /* synthetic */ void c(b bVar, String str) {
        try {
            if (bVar.getActivity() != null) {
                net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
                FragmentActivity activity = bVar.getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) activity, "activity!!");
                Context context = activity;
                a.C1160a aVar2 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                String a2 = net.one97.paytm.recharge.automatic.b.a.a.f60240b;
                a.C1160a aVar3 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                String n2 = net.one97.paytm.recharge.automatic.b.a.a.q;
                String str2 = bVar.u;
                if (str2 == null) {
                    str2 = "";
                }
                String str3 = str2;
                a.C1160a aVar4 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                net.one97.paytm.recharge.automatic.c.a.a.a(context, a2, n2, "", str3, net.one97.paytm.recharge.automatic.b.a.a.P, str);
            }
        } catch (Throwable unused) {
        }
    }

    public static final /* synthetic */ void d(b bVar, String str) {
        try {
            if (bVar.getActivity() != null) {
                net.one97.paytm.recharge.automatic.c.a.a aVar = net.one97.paytm.recharge.automatic.c.a.a.f60256a;
                FragmentActivity activity = bVar.getActivity();
                if (activity == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) activity, "activity!!");
                Context context = activity;
                a.C1160a aVar2 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                String a2 = net.one97.paytm.recharge.automatic.b.a.a.f60240b;
                a.C1160a aVar3 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                String B2 = net.one97.paytm.recharge.automatic.b.a.a.E;
                String str2 = bVar.u;
                if (str2 == null) {
                    str2 = "";
                }
                String str3 = str2;
                a.C1160a aVar4 = net.one97.paytm.recharge.automatic.b.a.a.f60239a;
                net.one97.paytm.recharge.automatic.c.a.a.a(context, a2, B2, "", str3, net.one97.paytm.recharge.automatic.b.a.a.P, str);
            }
        } catch (Throwable unused) {
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.G;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
