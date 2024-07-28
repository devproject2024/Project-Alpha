package net.one97.paytm.p2mNewDesign.j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.j;
import androidx.lifecycle.LiveData;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.view.actions.IuserActions;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.network.f;
import net.one97.paytm.p2mNewDesign.activity.EMIBankListActivity;
import net.one97.paytm.p2mNewDesign.b.d;
import net.one97.paytm.p2mNewDesign.e.c;
import net.one97.paytm.p2mNewDesign.entity.InstrumentInfo;
import net.one97.paytm.p2mNewDesign.f.a;
import net.one97.paytm.p2mNewDesign.f.g;
import net.one97.paytm.p2mNewDesign.models.PaymentModesV2;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.newdesign.utils.CustomDialog;

public final class b implements View.OnClickListener, a, g, CustomDialog.OkClickListener {
    private net.one97.paytm.p2mNewDesign.d.g A;
    /* access modifiers changed from: private */
    public Activity B;
    private boolean C;
    private List<PaymentModesV2> D = new ArrayList();
    private List<PaymentModesV2> E = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f13373a;

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.p2mNewDesign.b.a f13374b;

    /* renamed from: c  reason: collision with root package name */
    public net.one97.paytm.p2mNewDesign.b.a f13375c;

    /* renamed from: d  reason: collision with root package name */
    View f13376d;

    /* renamed from: e  reason: collision with root package name */
    boolean f13377e;

    /* renamed from: f  reason: collision with root package name */
    public c f13378f = new c();

    /* renamed from: g  reason: collision with root package name */
    public g f13379g;

    /* renamed from: h  reason: collision with root package name */
    private View f13380h;

    /* renamed from: i  reason: collision with root package name */
    private String f13381i;
    private Context j;
    private net.one97.paytm.p2mNewDesign.b.a k;
    private net.one97.paytm.p2mNewDesign.b.a l;
    private Map<String, net.one97.paytm.p2mNewDesign.e.a> m = new LinkedHashMap();
    private ArrayList<net.one97.paytm.p2mNewDesign.e.a> n;
    private List<View> o;
    private View p;
    private LinearLayout q;
    private LinearLayout r;
    private RelativeLayout s;
    private net.one97.paytm.p2mNewDesign.b.c t;
    private net.one97.paytm.p2mNewDesign.b.b u;
    private d v;
    private String w;
    private boolean x;
    private String y = "₹ ";
    private View z;

    public final void onClick(View view) {
    }

    public final View a(Activity activity, net.one97.paytm.p2mNewDesign.d.g gVar, String str, String str2, boolean z2) {
        this.j = activity;
        this.B = activity;
        this.f13381i = str;
        this.w = str2;
        this.x = z2;
        this.A = gVar;
        this.f13378f.a((Context) activity);
        if (this.f13380h == null) {
            l();
        }
        this.n = new ArrayList<>();
        b();
        x();
        return this.f13380h;
    }

    public final View a(Activity activity, net.one97.paytm.p2mNewDesign.d.g gVar, String str, String str2, boolean z2, boolean z3) {
        this.j = activity;
        this.B = activity;
        this.f13381i = str;
        this.w = str2;
        this.x = z2;
        this.f13377e = z3;
        this.A = gVar;
        this.f13378f.a((Context) activity);
        if (this.f13380h == null) {
            l();
        }
        b();
        this.s.findViewById(R.id.footer_view).setVisibility(8);
        return this.f13380h;
    }

    private void l() {
        this.f13380h = this.B.getLayoutInflater().inflate(R.layout.lyt_payment_options, (ViewGroup) null, false);
        this.s = (RelativeLayout) this.f13380h.findViewById(R.id.rl_test);
        this.f13373a = (LinearLayout) this.f13380h.findViewById(R.id.ll_paytm_instruments);
        this.p = this.f13380h.findViewById(R.id.divider_instruments);
    }

    private static void a(View view) {
        ((RelativeLayout) view.findViewById(R.id.rl_pay_mode_pg)).performClick();
    }

    private static void b(View view) {
        ((LinearLayout) view.findViewById(R.id.lyt_paytm_instrument)).performClick();
    }

    private void m() {
        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n == null) {
            return;
        }
        if (!net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().d(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode()) || (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode().equalsIgnoreCase(SDKConstants.AI_KEY_PPBL) && Double.valueOf(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().j.getBalance()).doubleValue() < Double.valueOf(this.f13381i).doubleValue())) {
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
            if (!net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.u() || (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13093i != null && (TextUtils.isEmpty(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13093i.getBalance()) || Double.valueOf(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13093i.getBalance()).doubleValue() < Double.valueOf(this.f13381i).doubleValue()))) {
                v();
            } else {
                b(this.z);
            }
        }
    }

    private void v() {
        if (!net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().r()) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                /* JADX WARNING: Code restructure failed: missing block: B:10:0x0043, code lost:
                    r1 = "Balance error";
                    r0 = "Balance could not be loaded, please try after some time.";
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:12:0x004a, code lost:
                    net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:13:0x0051, code lost:
                    if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.u() == false) goto L_0x006a;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:15:0x005b, code lost:
                    if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().t() == false) goto L_0x006a;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:16:0x005d, code lost:
                    r0 = net.one97.paytm.p2mNewDesign.j.b.a(r9.f13382a).getString(net.one97.paytm.wallet.R.string.insufficient_balance_payment_postpaid);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:17:0x006a, code lost:
                    r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
                    net.one97.paytm.p2mNewDesign.j.b.a(r9.f13382a);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:18:0x0077, code lost:
                    if (r0.n() == false) goto L_0x0090;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:20:0x0081, code lost:
                    if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().s() == false) goto L_0x0090;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:21:0x0083, code lost:
                    r0 = net.one97.paytm.p2mNewDesign.j.b.a(r9.f13382a).getString(net.one97.paytm.wallet.R.string.insufficient_balance_payment_bank);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
                    r0 = null;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:23:0x0092, code lost:
                    net.one97.paytm.wallet.newdesign.utils.CustomDialog.showAlert(net.one97.paytm.p2mNewDesign.j.b.a(r9.f13382a), r1, r0, false, net.one97.paytm.p2mNewDesign.j.b.a(r9.f13382a).getString(net.one97.paytm.wallet.R.string.try_again_lower_amount), net.one97.paytm.p2mNewDesign.j.b.a(r9.f13382a).getString(net.one97.paytm.wallet.R.string.cancel), new net.one97.paytm.p2mNewDesign.j.b.AnonymousClass1.AnonymousClass1(r9));
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b9, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:3:0x001c, code lost:
                    if (r0.n() == false) goto L_0x001e;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:7:0x002f, code lost:
                    if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.u() != false) goto L_0x0031;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:8:0x0031, code lost:
                    r1 = "Insufficient balance";
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:9:0x0041, code lost:
                    if (android.text.TextUtils.isEmpty(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().j.getBalance()) == false) goto L_0x004a;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    /*
                        r9 = this;
                        net.one97.paytm.p2mNewDesign.j.b r0 = net.one97.paytm.p2mNewDesign.j.b.this
                        net.one97.paytm.wallet.newdesign.utils.CustomDialog.initListener(r0)
                        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
                        boolean r0 = r0.s()
                        if (r0 == 0) goto L_0x001e
                        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
                        net.one97.paytm.p2mNewDesign.j.b r1 = net.one97.paytm.p2mNewDesign.j.b.this
                        android.app.Activity unused = r1.B
                        boolean r0 = r0.n()
                        if (r0 != 0) goto L_0x0031
                    L_0x001e:
                        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
                        boolean r0 = r0.t()
                        if (r0 == 0) goto L_0x00ba
                        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
                        boolean r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.u()
                        if (r0 == 0) goto L_0x00ba
                    L_0x0031:
                        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
                        net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r0.j
                        java.lang.String r0 = r0.getBalance()
                        boolean r0 = android.text.TextUtils.isEmpty(r0)
                        java.lang.String r1 = "Insufficient balance"
                        if (r0 == 0) goto L_0x004a
                        java.lang.String r1 = "Balance error"
                        java.lang.String r0 = "Balance could not be loaded, please try after some time."
                    L_0x0047:
                        r4 = r0
                        r3 = r1
                        goto L_0x0092
                    L_0x004a:
                        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
                        boolean r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.u()
                        if (r0 == 0) goto L_0x006a
                        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
                        boolean r0 = r0.t()
                        if (r0 == 0) goto L_0x006a
                        net.one97.paytm.p2mNewDesign.j.b r0 = net.one97.paytm.p2mNewDesign.j.b.this
                        android.app.Activity r0 = r0.B
                        int r2 = net.one97.paytm.wallet.R.string.insufficient_balance_payment_postpaid
                        java.lang.String r0 = r0.getString(r2)
                        goto L_0x0047
                    L_0x006a:
                        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
                        net.one97.paytm.p2mNewDesign.j.b r2 = net.one97.paytm.p2mNewDesign.j.b.this
                        android.app.Activity unused = r2.B
                        boolean r0 = r0.n()
                        if (r0 == 0) goto L_0x0090
                        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r0 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
                        boolean r0 = r0.s()
                        if (r0 == 0) goto L_0x0090
                        net.one97.paytm.p2mNewDesign.j.b r0 = net.one97.paytm.p2mNewDesign.j.b.this
                        android.app.Activity r0 = r0.B
                        int r2 = net.one97.paytm.wallet.R.string.insufficient_balance_payment_bank
                        java.lang.String r0 = r0.getString(r2)
                        goto L_0x0047
                    L_0x0090:
                        r0 = 0
                        goto L_0x0047
                    L_0x0092:
                        net.one97.paytm.p2mNewDesign.j.b r0 = net.one97.paytm.p2mNewDesign.j.b.this
                        android.app.Activity r2 = r0.B
                        r5 = 0
                        net.one97.paytm.p2mNewDesign.j.b r0 = net.one97.paytm.p2mNewDesign.j.b.this
                        android.app.Activity r0 = r0.B
                        int r1 = net.one97.paytm.wallet.R.string.try_again_lower_amount
                        java.lang.String r6 = r0.getString(r1)
                        net.one97.paytm.p2mNewDesign.j.b r0 = net.one97.paytm.p2mNewDesign.j.b.this
                        android.app.Activity r0 = r0.B
                        int r1 = net.one97.paytm.wallet.R.string.cancel
                        java.lang.String r7 = r0.getString(r1)
                        net.one97.paytm.p2mNewDesign.j.b$1$1 r8 = new net.one97.paytm.p2mNewDesign.j.b$1$1
                        r8.<init>()
                        net.one97.paytm.wallet.newdesign.utils.CustomDialog.showAlert(r2, r3, r4, r5, r6, r7, r8)
                        return
                    L_0x00ba:
                        net.one97.paytm.p2mNewDesign.j.b r0 = net.one97.paytm.p2mNewDesign.j.b.this
                        android.app.Activity r0 = r0.B
                        net.one97.paytm.p2mNewDesign.j.b$1$2 r1 = new net.one97.paytm.p2mNewDesign.j.b$1$2
                        r1.<init>()
                        java.lang.String r2 = "Error"
                        java.lang.String r3 = "Merchant doesn't have any other pay methods. Please try again later."
                        net.one97.paytm.wallet.newdesign.utils.CustomDialog.showErrorDialog(r0, r2, r3, r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.j.b.AnonymousClass1.run():void");
                }
            }, 500);
        }
        if ((net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n != null && !net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().d(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode())) || ((net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode().equalsIgnoreCase(SDKConstants.AI_KEY_PPBL) && Double.valueOf(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().j.getBalance()).doubleValue() < Double.valueOf(this.f13381i).doubleValue()) || (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode().equalsIgnoreCase("PAYTM_DIGITAL_CREDIT") && Double.valueOf(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13093i.getBalance()).doubleValue() < Double.valueOf(this.f13381i).doubleValue()))) {
            if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().m != null && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().m.size() > 0 && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().d("UPI")) {
                b(this.o.get(0));
                net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().m.get(0));
            } else if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().h(SDKConstants.DEBIT) != null && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().h(SDKConstants.DEBIT).size() > 0 && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().d(SDKConstants.DEBIT)) {
                net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().h(SDKConstants.DEBIT).get(0));
            } else if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().h(SDKConstants.CREDIT) != null && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().h(SDKConstants.CREDIT).size() > 0 && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().d(SDKConstants.CREDIT)) {
                net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().a(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().h(SDKConstants.CREDIT).get(0));
            }
        }
        w();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public final void run() {
                b.this.f13379g.a(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n, "updateSelection");
            }
        }, 500);
    }

    private void w() {
        if ((net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n != null && !net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().d(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode())) || ((net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode().equalsIgnoreCase(SDKConstants.AI_KEY_PPBL) && Double.valueOf(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().j.getBalance()).doubleValue() < Double.valueOf(this.f13381i).doubleValue()) || (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode().equalsIgnoreCase("PAYTM_DIGITAL_CREDIT") && Double.valueOf(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13093i.getBalance()).doubleValue() < Double.valueOf(this.f13381i).doubleValue()))) {
            for (PaymentModesV2 next : net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().b()) {
                if (next == null || !next.getPaymentMode().equalsIgnoreCase(SDKConstants.DEBIT)) {
                    if (next == null || !next.getPaymentMode().equalsIgnoreCase(SDKConstants.CREDIT)) {
                        if (next == null || !next.getPaymentMode().equalsIgnoreCase("NET_BANKING")) {
                            if (next != null) {
                                next.getPaymentMode().equalsIgnoreCase("UPI");
                            }
                        } else if (next.isDisabled() == null || !next.isDisabled().getStatus().booleanValue()) {
                            a(this.f13376d);
                            return;
                        }
                    } else if (next.isDisabled() == null || !next.isDisabled().getStatus().booleanValue()) {
                        a((View) this.r);
                        return;
                    }
                } else if (next.isDisabled() == null || !next.isDisabled().getStatus().booleanValue()) {
                    a((View) this.q);
                    return;
                }
            }
        }
    }

    public final void a(InstrumentInfo instrumentInfo, String str) {
        String str2;
        String str3;
        String PaymodeType;
        String str4;
        boolean z2;
        String str5;
        String str6;
        Context context;
        d dVar;
        net.one97.paytm.p2mNewDesign.b.c cVar;
        net.one97.paytm.p2mNewDesign.b.a aVar;
        net.one97.paytm.p2mNewDesign.b.a aVar2;
        net.one97.paytm.p2mNewDesign.b.a aVar3;
        net.one97.paytm.p2mNewDesign.b.a aVar4;
        net.one97.paytm.p2mNewDesign.b.a aVar5;
        net.one97.paytm.p2mNewDesign.b.a aVar6;
        net.one97.paytm.p2mNewDesign.b.a aVar7;
        net.one97.paytm.p2mNewDesign.b.a aVar8;
        if (str.equalsIgnoreCase("uncheck")) {
            if (!instrumentInfo.getPayMode().equalsIgnoreCase(SDKConstants.DEBIT) && (aVar8 = this.k) != null) {
                aVar8.b(instrumentInfo.getPaymentDetails());
            }
            if (instrumentInfo.getPayMode().equalsIgnoreCase(SDKConstants.DEBIT) && this.k != null && TextUtils.isEmpty(instrumentInfo.getDisplayPrimaryInfo())) {
                this.k.b(instrumentInfo.getPaymentDetails());
            }
            if (!instrumentInfo.getPayMode().equalsIgnoreCase(SDKConstants.CREDIT) && (aVar7 = this.l) != null) {
                aVar7.b(instrumentInfo.getPaymentDetails());
            }
            if (instrumentInfo.getPayMode().equalsIgnoreCase(SDKConstants.CREDIT) && this.l != null && TextUtils.isEmpty(instrumentInfo.getDisplayPrimaryInfo())) {
                this.l.b(instrumentInfo.getPaymentDetails());
            }
            if (!instrumentInfo.getPayMode().equalsIgnoreCase("emi") && this.u != null && !instrumentInfo.isEmiClicked()) {
                this.u.d();
            }
            if (!instrumentInfo.getPayMode().equalsIgnoreCase(SDKConstants.DEBIT) && (aVar6 = this.f13374b) != null) {
                aVar6.b(instrumentInfo.getPaymentDetails());
            }
            if (instrumentInfo.getPayMode().equalsIgnoreCase(SDKConstants.DEBIT) && this.f13374b != null && TextUtils.isEmpty(instrumentInfo.getDisplayPrimaryInfo())) {
                this.f13374b.b(instrumentInfo.getPaymentDetails());
            }
            if (!instrumentInfo.getPayMode().equalsIgnoreCase(SDKConstants.CREDIT) && (aVar5 = this.f13375c) != null) {
                aVar5.b(instrumentInfo.getPaymentDetails());
            }
            if (instrumentInfo.getPayMode().equalsIgnoreCase(SDKConstants.CREDIT) && this.f13375c != null && TextUtils.isEmpty(instrumentInfo.getDisplayPrimaryInfo())) {
                this.f13375c.b(instrumentInfo.getPaymentDetails());
            }
        }
        if (str.equalsIgnoreCase("sectionClose") && instrumentInfo != null && !TextUtils.isEmpty(instrumentInfo.getPayMode())) {
            if (!instrumentInfo.getPayMode().equalsIgnoreCase(SDKConstants.DEBIT) && (aVar4 = this.k) != null) {
                aVar4.a();
            }
            if (instrumentInfo.getPayMode().equalsIgnoreCase(SDKConstants.DEBIT) && this.k != null && !TextUtils.isEmpty(instrumentInfo.getDisplayPrimaryInfo())) {
                this.k.a();
            }
            if (!instrumentInfo.getPayMode().equalsIgnoreCase(SDKConstants.DEBIT) && (aVar3 = this.f13374b) != null) {
                aVar3.a();
            }
            if (instrumentInfo.getPayMode().equalsIgnoreCase(SDKConstants.DEBIT) && this.f13374b != null && !TextUtils.isEmpty(instrumentInfo.getDisplayPrimaryInfo())) {
                this.f13374b.a();
            }
            if (!instrumentInfo.getPayMode().equalsIgnoreCase(SDKConstants.CREDIT) && (aVar2 = this.l) != null) {
                aVar2.a();
            }
            if (instrumentInfo.getPayMode().equalsIgnoreCase(SDKConstants.CREDIT) && this.l != null && !TextUtils.isEmpty(instrumentInfo.getDisplayPrimaryInfo())) {
                this.l.a();
            }
            if (!instrumentInfo.getPayMode().equalsIgnoreCase(SDKConstants.CREDIT) && (aVar = this.f13375c) != null) {
                aVar.a();
            }
            if (instrumentInfo.getPayMode().equalsIgnoreCase(SDKConstants.CREDIT) && this.f13375c != null && !TextUtils.isEmpty(instrumentInfo.getDisplayPrimaryInfo())) {
                this.f13375c.a();
            }
            if (!instrumentInfo.getPayMode().equalsIgnoreCase("NET_BANKING") && (cVar = this.t) != null) {
                cVar.d();
            }
            if (!instrumentInfo.getPayMode().equalsIgnoreCase("BHIM UPI") && (dVar = this.v) != null) {
                dVar.a();
            }
        }
        if (str.equalsIgnoreCase("proceedtoPay") || str.equalsIgnoreCase("updateSelection")) {
            this.f13379g.a(instrumentInfo, str);
        }
        if (str.equalsIgnoreCase("closeSheet")) {
            this.f13379g.a(instrumentInfo, str);
        }
        if (str.equalsIgnoreCase("onboardingupiflow")) {
            this.f13379g.a(instrumentInfo, str);
        }
        if (str.equalsIgnoreCase("autofetchbalance") && ((instrumentInfo != null && instrumentInfo.getPayMode().equalsIgnoreCase(SDKConstants.AI_KEY_PPBL) && Double.valueOf(instrumentInfo.getBalance()).doubleValue() < Double.valueOf(this.f13381i).doubleValue()) || TextUtils.isEmpty(instrumentInfo.getBalance()))) {
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
            if (!net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.u() || !net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().t()) {
                v();
            } else {
                m();
            }
        }
        if (str.equalsIgnoreCase("openEMIBankList")) {
            Intent intent = new Intent(this.j, EMIBankListActivity.class);
            intent.putExtra("amount", this.f13379g.d());
            this.A.startActivityForResult(intent, IuserActions.ON_FLASHSALE_CLICK);
        }
        if (str.equalsIgnoreCase("openEMIPlanBottomSheet")) {
            c a2 = c.a();
            String str7 = "";
            if (instrumentInfo != null) {
                if (!(instrumentInfo.getSelectedEMIPlan() == null || instrumentInfo.getSelectedEMIPlan().f56918a == null)) {
                    str7 = instrumentInfo.getSelectedEMIPlan().f56918a;
                }
                Context context2 = this.j;
                str2 = this.w;
                String bankCode = instrumentInfo.getBankCode();
                String bankName = instrumentInfo.getBankName();
                String d2 = this.f13379g.d();
                boolean isFromSavedCard = instrumentInfo.isFromSavedCard();
                PaymodeType = instrumentInfo.getPayMode();
                str3 = str7;
                str4 = d2;
                z2 = isFromSavedCard;
                str5 = bankCode;
                str6 = bankName;
                context = context2;
            } else {
                if (!(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getSelectedEMIPlan() == null || net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getSelectedEMIPlan().f56918a == null)) {
                    str7 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getSelectedEMIPlan().f56918a;
                }
                Context context3 = this.j;
                str2 = this.w;
                String bankCode2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getBankCode();
                String bankName2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getBankName();
                String d3 = this.f13379g.d();
                boolean v2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().v();
                str3 = str7;
                PaymodeType = "emi".equalsIgnoreCase(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode()) ? net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.PaymodeType() : net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode();
                str4 = d3;
                z2 = v2;
                str5 = bankCode2;
                str6 = bankName2;
                context = context3;
            }
            a2.a(context, str2, str5, str6, str3, str4, this, z2, PaymodeType);
            a2.show(this.A.getFragmentManager(), "select_emi_plan_bottom_sheet");
        }
    }

    public final void onOkClick() {
        this.f13379g.a(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n, "closeSheet");
        this.f13379g.a(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n, "focusEditText");
    }

    private void x() {
        this.s.findViewById(R.id.footer_view).setVisibility(this.C ? 0 : 8);
    }

    public final void b(String str) {
        this.f13381i = str;
        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().A == null || Double.parseDouble(str) <= Double.parseDouble(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().A)) {
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().B = false;
        } else {
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().B = true;
        }
        this.f13378f.a(str);
    }

    public final String d() {
        return this.f13379g.d();
    }

    public final void c(String str) {
        this.f13378f.a(str);
    }

    public final void c(boolean z2) {
        this.f13379g.c(z2);
    }

    public final void a(String str, boolean z2, boolean z3) {
        this.A.a(str, z2, z3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0170  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(boolean r13) {
        /*
            r12 = this;
            java.lang.String r0 = "CREDIT_CARD"
            java.lang.String r1 = "DEBIT_CARD"
            if (r13 == 0) goto L_0x003b
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r13 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r13 = r13.n
            if (r13 != 0) goto L_0x000f
            return
        L_0x000f:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r13 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r13 = r13.n
            java.lang.String r13 = r13.getPayMode()
            boolean r13 = r1.equalsIgnoreCase(r13)
            if (r13 == 0) goto L_0x0025
            net.one97.paytm.p2mNewDesign.e.c r13 = r12.f13378f
            r13.c()
            return
        L_0x0025:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r13 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r13 = r13.n
            java.lang.String r13 = r13.getPayMode()
            boolean r13 = r0.equalsIgnoreCase(r13)
            if (r13 == 0) goto L_0x01a0
            net.one97.paytm.p2mNewDesign.e.c r13 = r12.f13378f
            r13.c()
            return
        L_0x003b:
            net.one97.paytm.p2mNewDesign.e.c r13 = r12.f13378f
            java.lang.String r2 = "emi"
            net.one97.paytm.p2mNewDesign.e.a r13 = r13.c((java.lang.String) r2)
            if (r13 == 0) goto L_0x01a0
            net.one97.paytm.p2mNewDesign.b.b r13 = (net.one97.paytm.p2mNewDesign.b.b) r13
            net.one97.paytm.p2mNewDesign.f.g r2 = r13.f13227a
            r3 = 0
            r2.e(r3)
            net.one97.paytm.p2mNewDesign.j.a r2 = r13.f13228b
            if (r2 == 0) goto L_0x01a0
            net.one97.paytm.p2mNewDesign.j.a r13 = r13.f13228b
            android.view.View r2 = r13.f13365b
            r13.a(r2)
            android.view.View r2 = r13.f13365b
            int r4 = net.one97.paytm.wallet.R.id.tv_select_emi
            android.view.View r2 = r2.findViewById(r4)
            r2.setVisibility(r3)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r2.n
            net.one97.paytm.p2mNewDesign.models.a r2 = r2.getSelectedEMIPlan()
            if (r2 == 0) goto L_0x01a0
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r4 = r4.n
            r13.f13366c = r4
            android.view.View r4 = r13.f13365b
            int r5 = net.one97.paytm.wallet.R.id.tv_select_emi
            android.view.View r4 = r4.findViewById(r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "₹ "
            r5.<init>(r6)
            java.lang.Double r6 = r2.f56919b
            double r6 = r6.doubleValue()
            java.lang.String r6 = com.paytm.utility.b.c((double) r6)
            r5.append(r6)
            java.lang.String r6 = " per month ( for "
            r5.append(r6)
            java.lang.String r2 = r2.a()
            r5.append(r2)
            java.lang.String r2 = " months)"
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            r4.setText(r2)
            android.widget.LinearLayout r2 = r13.f13367d
            r2.removeAllViews()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r2 = r13.f13366c
            java.lang.String r2 = r2.getCardType()
            boolean r2 = r1.equalsIgnoreCase(r2)
            r4 = 1
            if (r2 == 0) goto L_0x00f9
            net.one97.paytm.p2mNewDesign.b.a r0 = r13.f13369f
            android.content.Context r2 = r13.f13364a
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r5 = r13.f13366c
            java.lang.String r5 = r5.getBankCode()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r6 = r13.f13366c
            net.one97.paytm.p2mNewDesign.models.a r6 = r6.getSelectedEMIPlan()
            java.util.List r0 = r0.a((android.content.Context) r2, (java.lang.String) r1, (java.lang.String) r5, (net.one97.paytm.p2mNewDesign.models.a) r6)
            if (r0 == 0) goto L_0x0132
            int r2 = r0.size()
            if (r2 <= 0) goto L_0x0132
            android.widget.LinearLayout r2 = r13.f13367d
            r2.setVisibility(r3)
            java.util.Iterator r0 = r0.iterator()
            r2 = 0
        L_0x00e6:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x0133
            java.lang.Object r2 = r0.next()
            android.view.View r2 = (android.view.View) r2
            android.widget.LinearLayout r5 = r13.f13367d
            r5.addView(r2)
            r2 = 1
            goto L_0x00e6
        L_0x00f9:
            net.one97.paytm.p2mNewDesign.b.a r2 = r13.f13368e
            android.content.Context r5 = r13.f13364a
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r6 = r13.f13366c
            java.lang.String r6 = r6.getBankCode()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r7 = r13.f13366c
            net.one97.paytm.p2mNewDesign.models.a r7 = r7.getSelectedEMIPlan()
            java.util.List r0 = r2.a((android.content.Context) r5, (java.lang.String) r0, (java.lang.String) r6, (net.one97.paytm.p2mNewDesign.models.a) r7)
            if (r0 == 0) goto L_0x0132
            int r2 = r0.size()
            if (r2 <= 0) goto L_0x0132
            android.widget.LinearLayout r2 = r13.f13367d
            r2.setVisibility(r3)
            java.util.Iterator r0 = r0.iterator()
            r2 = 0
        L_0x011f:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x0133
            java.lang.Object r2 = r0.next()
            android.view.View r2 = (android.view.View) r2
            android.widget.LinearLayout r5 = r13.f13367d
            r5.addView(r2)
            r2 = 1
            goto L_0x011f
        L_0x0132:
            r2 = 0
        L_0x0133:
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r13.f13366c
            java.lang.String r0 = r0.getCardType()
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0170
            net.one97.paytm.p2mNewDesign.b.a r6 = r13.f13369f
            android.content.Context r7 = r13.f13364a
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r13.f13366c
            java.lang.String r9 = r0.getBankCode()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r13.f13366c
            net.one97.paytm.p2mNewDesign.models.a r10 = r0.getSelectedEMIPlan()
            java.lang.String r8 = "DEBIT_CARD"
            r11 = r2
            android.widget.LinearLayout r0 = r6.a((android.content.Context) r7, (java.lang.String) r8, (java.lang.String) r9, (net.one97.paytm.p2mNewDesign.models.a) r10, (boolean) r11)
            if (r0 == 0) goto L_0x016f
            android.widget.LinearLayout r1 = r13.f13367d
            r1.setVisibility(r3)
            android.widget.LinearLayout r1 = r13.f13367d
            r1.addView(r0)
            if (r2 != 0) goto L_0x016a
            net.one97.paytm.p2mNewDesign.b.a r13 = r13.f13368e
            r13.c()
            return
        L_0x016a:
            android.view.View r0 = r13.f13365b
            r13.a(r0)
        L_0x016f:
            return
        L_0x0170:
            net.one97.paytm.p2mNewDesign.b.a r6 = r13.f13368e
            android.content.Context r7 = r13.f13364a
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r13.f13366c
            java.lang.String r9 = r0.getBankCode()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r0 = r13.f13366c
            net.one97.paytm.p2mNewDesign.models.a r10 = r0.getSelectedEMIPlan()
            java.lang.String r8 = "CREDIT_CARD"
            r11 = r2
            android.widget.LinearLayout r0 = r6.a((android.content.Context) r7, (java.lang.String) r8, (java.lang.String) r9, (net.one97.paytm.p2mNewDesign.models.a) r10, (boolean) r11)
            if (r0 == 0) goto L_0x01a0
            android.widget.LinearLayout r1 = r13.f13367d
            r1.setVisibility(r3)
            android.widget.LinearLayout r1 = r13.f13367d
            r1.addView(r0)
            if (r2 != 0) goto L_0x019b
            net.one97.paytm.p2mNewDesign.b.a r13 = r13.f13368e
            r13.c()
            return
        L_0x019b:
            android.view.View r0 = r13.f13365b
            r13.a(r0)
        L_0x01a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.j.b.a(boolean):void");
    }

    public final j getFragmentManager() {
        return this.A.getFragmentManager();
    }

    public final net.one97.paytm.p2mNewDesign.b.a g() {
        if (this.f13375c == null) {
            this.f13375c = new net.one97.paytm.p2mNewDesign.b.a();
            this.f13375c.f13210a = this.f13379g;
        }
        return this.f13375c;
    }

    public final net.one97.paytm.p2mNewDesign.b.a h() {
        if (this.f13374b == null) {
            this.f13374b = new net.one97.paytm.p2mNewDesign.b.a();
            this.f13374b.f13210a = this.f13379g;
        }
        return this.f13374b;
    }

    public final void e(boolean z2) {
        this.f13379g.e(z2);
    }

    public final String e() {
        return this.A.e();
    }

    public final boolean i() {
        return this.f13379g.i();
    }

    public final void b(boolean z2) {
        this.f13378f.a(z2);
    }

    public final boolean j() {
        return this.A.getFragmentManager().c("select_emi_plan_bottom_sheet") != null;
    }

    public final boolean k() {
        return this.f13379g.k();
    }

    public final void e(String str) {
        c cVar = this.f13378f;
        k.c("GIFT_VOUCHER", SDKConstants.KEY_PAYMODE);
        k.c(str, "status");
        for (net.one97.paytm.p2mNewDesign.e.a aVar : cVar.f51255b) {
            if (p.a(aVar.a(), "GIFT_VOUCHER", false)) {
                if (aVar != null) {
                    net.one97.paytm.p2mNewDesign.e.a.c cVar2 = (net.one97.paytm.p2mNewDesign.e.a.c) aVar;
                    if (cVar2 == null) {
                        return;
                    }
                    if (p.a(str, "SUCCESS", true)) {
                        cVar2.f13287b = 0;
                        cVar2.a("GIFT_VOUCHER", false);
                        return;
                    }
                    cVar2.f13287b = 0;
                    cVar2.b("GIFT_VOUCHER");
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.p2mNewDesign.instruments.controllers.MGVIntrumentController");
            }
        }
    }

    public final void n() {
        this.A.n();
    }

    public final void o() {
        this.f13379g.o();
    }

    public final void p() {
        this.f13379g.p();
    }

    public final boolean a(String str, Bundle bundle, NetworkCustomError networkCustomError) {
        return this.f13379g.a(str, bundle, networkCustomError);
    }

    public final LiveData<f> a(Context context, String str) {
        return this.f13379g.a(context, str);
    }

    public final LiveData<f> a(String str, Context context, String str2, boolean z2) {
        return this.f13379g.a(str, context, str2, z2);
    }

    public final Activity q() {
        return this.f13379g.q();
    }

    public final void a(InstrumentInfo instrumentInfo) {
        if ((instrumentInfo != null && instrumentInfo.getPayMode().equalsIgnoreCase(SDKConstants.AI_KEY_PPBL) && Double.valueOf(instrumentInfo.getBalance()).doubleValue() < Double.valueOf(this.f13381i).doubleValue()) || TextUtils.isEmpty(instrumentInfo.getBalance())) {
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
            if (!net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.u() || !net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().t()) {
                v();
            } else {
                m();
            }
        }
    }

    public final void a() {
        Intent intent = new Intent(this.j, EMIBankListActivity.class);
        intent.putExtra("amount", d());
        this.A.startActivityForResult(intent, IuserActions.ON_FLASHSALE_CLICK);
    }

    public final void b(InstrumentInfo instrumentInfo) {
        String str;
        boolean z2;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Context context;
        c a2 = c.a();
        String str7 = "";
        if (instrumentInfo != null) {
            if (!(instrumentInfo.getSelectedEMIPlan() == null || instrumentInfo.getSelectedEMIPlan().f56918a == null)) {
                str7 = instrumentInfo.getSelectedEMIPlan().f56918a;
            }
            context = this.j;
            str6 = this.w;
            str5 = instrumentInfo.getBankCode();
            str4 = instrumentInfo.getBankName();
            String d2 = this.f13379g.d();
            boolean isFromSavedCard = instrumentInfo.isFromSavedCard();
            str = instrumentInfo.getPayMode();
            z2 = isFromSavedCard;
            str2 = d2;
            str3 = str7;
        } else {
            if (!(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getSelectedEMIPlan() == null || net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getSelectedEMIPlan().f56918a == null)) {
                str7 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getSelectedEMIPlan().f56918a;
            }
            Context context2 = this.j;
            String str8 = this.w;
            String bankCode = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getBankCode();
            String bankName = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getBankName();
            String d3 = this.f13379g.d();
            z2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().v();
            str = "emi".equalsIgnoreCase(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode()) ? net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.PaymodeType() : net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().n.getPayMode();
            str3 = str7;
            str2 = d3;
            str4 = bankName;
            str5 = bankCode;
            str6 = str8;
            context = context2;
        }
        a2.a(context, str6, str5, str4, str3, str2, this, z2, str);
        a2.show(this.A.getFragmentManager(), "select_emi_plan_bottom_sheet");
    }

    public final void r() {
        this.f13379g.r();
    }

    public final void d(String str) {
        this.f13378f.b(str);
    }

    public final void b() {
        List y2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().y();
        if (y2 == null || y2.size() == 0) {
            y2 = new ArrayList();
            PaymentModesV2 paymentModesV2 = new PaymentModesV2();
            paymentModesV2.setPaymentMode("BALANCE");
            if (TextUtils.isEmpty(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13087c.getPriority())) {
                paymentModesV2.setPriority("1");
            } else {
                paymentModesV2.setPriority(net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13087c.getPriority());
            }
            y2.add(paymentModesV2);
        }
        o<ArrayList<net.one97.paytm.p2mNewDesign.e.a>, ArrayList<net.one97.paytm.p2mNewDesign.e.a>> a2 = new net.one97.paytm.p2mNewDesign.e.b(this.j).a(y2, this.f13373a, this.f13379g, this.w, this.f13378f.f51255b);
        this.f13378f.a(this.f13373a, a2.getFirst(), a2.getSecond());
    }

    public final void f(String str) {
        this.f13378f.d(str);
    }

    public final void c() {
        net.one97.paytm.p2mNewDesign.b.a aVar = this.k;
        if (aVar != null) {
            aVar.d();
            this.k.g();
        }
        net.one97.paytm.p2mNewDesign.b.a aVar2 = this.l;
        if (aVar2 != null) {
            aVar2.d();
            this.k.f();
        }
        this.f13378f.f();
    }

    public final void f() {
        net.one97.paytm.p2mNewDesign.b.a aVar = this.k;
        if (aVar != null) {
            aVar.e();
            this.k.i();
        }
        net.one97.paytm.p2mNewDesign.b.a aVar2 = this.l;
        if (aVar2 != null) {
            aVar2.e();
            this.l.h();
        }
        this.f13378f.g();
    }

    public final void a(String str) {
        this.f13379g.a(str, false, false);
    }

    public final void s() {
        this.f13378f.b();
    }

    public final boolean t() {
        return this.f13379g.t();
    }

    public final boolean g(String str) {
        boolean e2 = this.f13378f.e(str);
        if (!e2) {
            this.f13378f.b();
        }
        return e2;
    }

    public final void f(boolean z2) {
        this.f13378f.b(z2);
    }

    public final void d(boolean z2) {
        this.f13378f.c(z2);
    }

    public final void u() {
        this.A.u();
    }
}
