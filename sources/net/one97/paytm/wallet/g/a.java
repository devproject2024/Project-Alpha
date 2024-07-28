package net.one97.paytm.wallet.g;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.business.merchant_payments.common.utility.AppUtility;
import com.paytm.utility.v;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.i.f;
import net.one97.paytm.p2mNewDesign.f.j;
import net.one97.paytm.wallet.R;

public final class a extends f {

    /* renamed from: a  reason: collision with root package name */
    public static final C1418a f70365a = new C1418a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private final int f70366b = 2;

    /* renamed from: c  reason: collision with root package name */
    private View f70367c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Context f70368d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public j f70369e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f70370f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f70371g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public String f70372h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f70373i;
    private final String j = "₹ ";
    private HashMap k;

    public static final /* synthetic */ j a(a aVar) {
        j jVar = aVar.f70369e;
        if (jVar == null) {
            k.a("listener");
        }
        return jVar;
    }

    /* renamed from: net.one97.paytm.wallet.g.a$a  reason: collision with other inner class name */
    public static final class C1418a {
        private C1418a() {
        }

        public /* synthetic */ C1418a(byte b2) {
            this();
        }

        public static a a(String str, String str2, String str3, Context context, String str4, j jVar) {
            k.c(str, "amount");
            k.c(str2, "convFee");
            k.c(str3, "netAmount");
            k.c(context, "context");
            k.c(str4, "merchantName");
            k.c(jVar, "listener");
            a aVar = new a();
            aVar.setArguments(new Bundle());
            aVar.f70368d = context;
            aVar.f70370f = str;
            aVar.f70371g = str2;
            aVar.f70372h = str3;
            aVar.f70373i = str4;
            aVar.f70369e = jVar;
            return aVar;
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            com.paytm.utility.b.e((Activity) activity);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001e, code lost:
        r13 = r13.j();
     */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0328  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0341  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.LayoutInflater r13, android.view.ViewGroup r14, android.os.Bundle r15) {
        /*
            r12 = this;
            java.lang.String r15 = "DirectPaymentBl.getInstance()"
            java.lang.String r0 = "rootView"
            java.lang.String r1 = "inflater"
            kotlin.g.b.k.c(r13, r1)
            int r1 = net.one97.paytm.wallet.R.layout.bottom_post_conv_fragment
            r2 = 0
            android.view.View r13 = r13.inflate(r1, r14, r2)
            java.lang.String r14 = "inflater.inflate(R.layou…agment, container, false)"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r14)
            r12.f70367c = r13
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r13 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0323 }
            r14 = 0
            if (r13 == 0) goto L_0x0029
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r13 = r13.j()     // Catch:{ Exception -> 0x0323 }
            if (r13 == 0) goto L_0x0029
            java.lang.String r13 = r13.getTotalBalance()     // Catch:{ Exception -> 0x0323 }
            goto L_0x002a
        L_0x0029:
            r13 = r14
        L_0x002a:
            r3 = 0
            if (r13 == 0) goto L_0x0033
            double r5 = java.lang.Double.parseDouble(r13)     // Catch:{ Exception -> 0x0323 }
            goto L_0x0034
        L_0x0033:
            r5 = r3
        L_0x0034:
            java.lang.String r13 = r12.f70372h     // Catch:{ Exception -> 0x0323 }
            java.lang.String r1 = "netAmount"
            if (r13 != 0) goto L_0x003d
            kotlin.g.b.k.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0323 }
        L_0x003d:
            double r7 = java.lang.Double.parseDouble(r13)     // Catch:{ Exception -> 0x0323 }
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r13 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0323 }
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r15)     // Catch:{ Exception -> 0x0323 }
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r13 = r13.l()     // Catch:{ Exception -> 0x0323 }
            if (r13 == 0) goto L_0x0052
            java.lang.String r14 = r13.getPayMode()     // Catch:{ Exception -> 0x0323 }
        L_0x0052:
            java.lang.String r13 = "BALANCE"
            r9 = 1
            boolean r13 = kotlin.m.p.a((java.lang.String) r14, (java.lang.String) r13, (boolean) r9)     // Catch:{ Exception -> 0x0323 }
            java.lang.String r14 = "rootView.but_pcf_pay"
            java.lang.String r10 = "java.lang.String.format(format, *args)"
            java.lang.String r11 = "mContext"
            if (r13 == 0) goto L_0x02b0
            int r13 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r13 <= 0) goto L_0x02b0
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r13 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0323 }
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r15)     // Catch:{ Exception -> 0x0323 }
            boolean r13 = r13.E()     // Catch:{ Exception -> 0x0323 }
            if (r13 == 0) goto L_0x01e7
            android.view.View r13 = r12.f70367c     // Catch:{ Exception -> 0x0323 }
            if (r13 != 0) goto L_0x0079
            kotlin.g.b.k.a((java.lang.String) r0)     // Catch:{ Exception -> 0x0323 }
        L_0x0079:
            int r14 = net.one97.paytm.wallet.R.id.tv_pcf_label     // Catch:{ Exception -> 0x0323 }
            android.view.View r13 = r13.findViewById(r14)     // Catch:{ Exception -> 0x0323 }
            android.widget.TextView r13 = (android.widget.TextView) r13     // Catch:{ Exception -> 0x0323 }
            java.lang.String r14 = "rootView.tv_pcf_label"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r14)     // Catch:{ Exception -> 0x0323 }
            int r14 = net.one97.paytm.wallet.R.string.addnpay_intermediate_title     // Catch:{ Exception -> 0x0323 }
            java.lang.String r14 = r12.getString(r14)     // Catch:{ Exception -> 0x0323 }
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14     // Catch:{ Exception -> 0x0323 }
            r13.setText(r14)     // Catch:{ Exception -> 0x0323 }
            android.view.View r13 = r12.f70367c     // Catch:{ Exception -> 0x0323 }
            if (r13 != 0) goto L_0x0098
            kotlin.g.b.k.a((java.lang.String) r0)     // Catch:{ Exception -> 0x0323 }
        L_0x0098:
            int r14 = net.one97.paytm.wallet.R.id.tv_ic_amount_value     // Catch:{ Exception -> 0x0323 }
            android.view.View r13 = r13.findViewById(r14)     // Catch:{ Exception -> 0x0323 }
            android.widget.TextView r13 = (android.widget.TextView) r13     // Catch:{ Exception -> 0x0323 }
            java.lang.String r14 = "rootView.tv_ic_amount_value"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r14)     // Catch:{ Exception -> 0x0323 }
            r14 = 2
            java.lang.String[] r3 = new java.lang.String[r14]     // Catch:{ Exception -> 0x0323 }
            java.lang.String r4 = r12.j     // Catch:{ Exception -> 0x0323 }
            r3[r2] = r4     // Catch:{ Exception -> 0x0323 }
            java.lang.String r4 = r12.f70370f     // Catch:{ Exception -> 0x0323 }
            if (r4 != 0) goto L_0x00b5
            java.lang.String r5 = "txnAmount"
            kotlin.g.b.k.a((java.lang.String) r5)     // Catch:{ Exception -> 0x0323 }
        L_0x00b5:
            r3[r9] = r4     // Catch:{ Exception -> 0x0323 }
            java.lang.String r3 = com.paytm.utility.v.a((java.lang.String[]) r3)     // Catch:{ Exception -> 0x0323 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x0323 }
            r13.setText(r3)     // Catch:{ Exception -> 0x0323 }
            android.view.View r13 = r12.f70367c     // Catch:{ Exception -> 0x0323 }
            if (r13 != 0) goto L_0x00c7
            kotlin.g.b.k.a((java.lang.String) r0)     // Catch:{ Exception -> 0x0323 }
        L_0x00c7:
            int r3 = net.one97.paytm.wallet.R.id.tv_ic_convfee_value     // Catch:{ Exception -> 0x0323 }
            android.view.View r13 = r13.findViewById(r3)     // Catch:{ Exception -> 0x0323 }
            android.widget.TextView r13 = (android.widget.TextView) r13     // Catch:{ Exception -> 0x0323 }
            java.lang.String r3 = "rootView.tv_ic_convfee_value"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r3)     // Catch:{ Exception -> 0x0323 }
            java.lang.String[] r3 = new java.lang.String[r14]     // Catch:{ Exception -> 0x0323 }
            java.lang.String r4 = r12.j     // Catch:{ Exception -> 0x0323 }
            r3[r2] = r4     // Catch:{ Exception -> 0x0323 }
            java.lang.String r4 = r12.f70371g     // Catch:{ Exception -> 0x0323 }
            if (r4 != 0) goto L_0x00e3
            java.lang.String r5 = "convFee"
            kotlin.g.b.k.a((java.lang.String) r5)     // Catch:{ Exception -> 0x0323 }
        L_0x00e3:
            r3[r9] = r4     // Catch:{ Exception -> 0x0323 }
            java.lang.String r3 = com.paytm.utility.v.a((java.lang.String[]) r3)     // Catch:{ Exception -> 0x0323 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x0323 }
            r13.setText(r3)     // Catch:{ Exception -> 0x0323 }
            android.view.View r13 = r12.f70367c     // Catch:{ Exception -> 0x0323 }
            if (r13 != 0) goto L_0x00f5
            kotlin.g.b.k.a((java.lang.String) r0)     // Catch:{ Exception -> 0x0323 }
        L_0x00f5:
            int r3 = net.one97.paytm.wallet.R.id.tv_ic_net_amount_value     // Catch:{ Exception -> 0x0323 }
            android.view.View r13 = r13.findViewById(r3)     // Catch:{ Exception -> 0x0323 }
            android.widget.TextView r13 = (android.widget.TextView) r13     // Catch:{ Exception -> 0x0323 }
            java.lang.String r3 = "rootView.tv_ic_net_amount_value"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r3)     // Catch:{ Exception -> 0x0323 }
            java.lang.String[] r3 = new java.lang.String[r14]     // Catch:{ Exception -> 0x0323 }
            java.lang.String r4 = r12.j     // Catch:{ Exception -> 0x0323 }
            r3[r2] = r4     // Catch:{ Exception -> 0x0323 }
            java.lang.String r4 = r12.f70372h     // Catch:{ Exception -> 0x0323 }
            if (r4 != 0) goto L_0x010f
            kotlin.g.b.k.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0323 }
        L_0x010f:
            r3[r9] = r4     // Catch:{ Exception -> 0x0323 }
            java.lang.String r1 = com.paytm.utility.v.a((java.lang.String[]) r3)     // Catch:{ Exception -> 0x0323 }
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x0323 }
            r13.setText(r1)     // Catch:{ Exception -> 0x0323 }
            android.view.View r13 = r12.f70367c     // Catch:{ Exception -> 0x0323 }
            if (r13 != 0) goto L_0x0121
            kotlin.g.b.k.a((java.lang.String) r0)     // Catch:{ Exception -> 0x0323 }
        L_0x0121:
            int r1 = net.one97.paytm.wallet.R.id.tv_ic_pcf_subtitle     // Catch:{ Exception -> 0x0323 }
            android.view.View r13 = r13.findViewById(r1)     // Catch:{ Exception -> 0x0323 }
            android.widget.TextView r13 = (android.widget.TextView) r13     // Catch:{ Exception -> 0x0323 }
            java.lang.String r1 = "rootView.tv_ic_pcf_subtitle"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r1)     // Catch:{ Exception -> 0x0323 }
            kotlin.g.b.aa r1 = kotlin.g.b.aa.f47921a     // Catch:{ Exception -> 0x0323 }
            android.content.Context r1 = r12.f70368d     // Catch:{ Exception -> 0x0323 }
            if (r1 != 0) goto L_0x0137
            kotlin.g.b.k.a((java.lang.String) r11)     // Catch:{ Exception -> 0x0323 }
        L_0x0137:
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ Exception -> 0x0323 }
            int r3 = net.one97.paytm.wallet.R.string.merchant_charges_you_an_amount_as_convenience_fee     // Catch:{ Exception -> 0x0323 }
            java.lang.String r1 = r1.getString(r3)     // Catch:{ Exception -> 0x0323 }
            java.lang.String r3 = "mContext.resources.getSt…mount_as_convenience_fee)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)     // Catch:{ Exception -> 0x0323 }
            java.lang.Object[] r3 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x0323 }
            java.lang.String r4 = r12.f70373i     // Catch:{ Exception -> 0x0323 }
            if (r4 != 0) goto L_0x0151
            java.lang.String r5 = "merchantName"
            kotlin.g.b.k.a((java.lang.String) r5)     // Catch:{ Exception -> 0x0323 }
        L_0x0151:
            r3[r2] = r4     // Catch:{ Exception -> 0x0323 }
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r3, r9)     // Catch:{ Exception -> 0x0323 }
            java.lang.String r1 = java.lang.String.format(r1, r3)     // Catch:{ Exception -> 0x0323 }
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r10)     // Catch:{ Exception -> 0x0323 }
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x0323 }
            r13.setText(r1)     // Catch:{ Exception -> 0x0323 }
            android.view.View r13 = r12.f70367c     // Catch:{ Exception -> 0x0323 }
            if (r13 != 0) goto L_0x016a
            kotlin.g.b.k.a((java.lang.String) r0)     // Catch:{ Exception -> 0x0323 }
        L_0x016a:
            int r1 = net.one97.paytm.wallet.R.id.tv_available_bal     // Catch:{ Exception -> 0x0323 }
            android.view.View r13 = r13.findViewById(r1)     // Catch:{ Exception -> 0x0323 }
            android.widget.TextView r13 = (android.widget.TextView) r13     // Catch:{ Exception -> 0x0323 }
            java.lang.String r1 = "rootView.tv_available_bal"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r1)     // Catch:{ Exception -> 0x0323 }
            java.lang.String[] r14 = new java.lang.String[r14]     // Catch:{ Exception -> 0x0323 }
            java.lang.String r1 = r12.j     // Catch:{ Exception -> 0x0323 }
            r14[r2] = r1     // Catch:{ Exception -> 0x0323 }
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r1 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()     // Catch:{ Exception -> 0x0323 }
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r15)     // Catch:{ Exception -> 0x0323 }
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r15 = r1.j()     // Catch:{ Exception -> 0x0323 }
            java.lang.String r1 = "DirectPaymentBl.getInstance().walletInstrumentInfo"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r1)     // Catch:{ Exception -> 0x0323 }
            java.lang.String r15 = r15.getTotalBalance()     // Catch:{ Exception -> 0x0323 }
            r14[r9] = r15     // Catch:{ Exception -> 0x0323 }
            java.lang.String r14 = com.paytm.utility.v.a((java.lang.String[]) r14)     // Catch:{ Exception -> 0x0323 }
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14     // Catch:{ Exception -> 0x0323 }
            r13.setText(r14)     // Catch:{ Exception -> 0x0323 }
            android.view.View r13 = r12.f70367c     // Catch:{ Exception -> 0x0323 }
            if (r13 != 0) goto L_0x01a3
            kotlin.g.b.k.a((java.lang.String) r0)     // Catch:{ Exception -> 0x0323 }
        L_0x01a3:
            int r14 = net.one97.paytm.wallet.R.id.but_ic_pcf_pay     // Catch:{ Exception -> 0x0323 }
            android.view.View r13 = r13.findViewById(r14)     // Catch:{ Exception -> 0x0323 }
            android.widget.Button r13 = (android.widget.Button) r13     // Catch:{ Exception -> 0x0323 }
            net.one97.paytm.wallet.g.a$d r14 = new net.one97.paytm.wallet.g.a$d     // Catch:{ Exception -> 0x0323 }
            r14.<init>(r12)     // Catch:{ Exception -> 0x0323 }
            android.view.View$OnClickListener r14 = (android.view.View.OnClickListener) r14     // Catch:{ Exception -> 0x0323 }
            r13.setOnClickListener(r14)     // Catch:{ Exception -> 0x0323 }
            android.view.View r13 = r12.f70367c     // Catch:{ Exception -> 0x0323 }
            if (r13 != 0) goto L_0x01bc
            kotlin.g.b.k.a((java.lang.String) r0)     // Catch:{ Exception -> 0x0323 }
        L_0x01bc:
            int r14 = net.one97.paytm.wallet.R.id.lyt_default     // Catch:{ Exception -> 0x0323 }
            android.view.View r13 = r13.findViewById(r14)     // Catch:{ Exception -> 0x0323 }
            android.widget.RelativeLayout r13 = (android.widget.RelativeLayout) r13     // Catch:{ Exception -> 0x0323 }
            java.lang.String r14 = "rootView.lyt_default"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r14)     // Catch:{ Exception -> 0x0323 }
            r14 = 8
            r13.setVisibility(r14)     // Catch:{ Exception -> 0x0323 }
            android.view.View r13 = r12.f70367c     // Catch:{ Exception -> 0x0323 }
            if (r13 != 0) goto L_0x01d5
            kotlin.g.b.k.a((java.lang.String) r0)     // Catch:{ Exception -> 0x0323 }
        L_0x01d5:
            int r14 = net.one97.paytm.wallet.R.id.insufficient_balance_lyt     // Catch:{ Exception -> 0x0323 }
            android.view.View r13 = r13.findViewById(r14)     // Catch:{ Exception -> 0x0323 }
            android.widget.RelativeLayout r13 = (android.widget.RelativeLayout) r13     // Catch:{ Exception -> 0x0323 }
            java.lang.String r14 = "rootView.insufficient_balance_lyt"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r14)     // Catch:{ Exception -> 0x0323 }
            r13.setVisibility(r2)     // Catch:{ Exception -> 0x0323 }
            goto L_0x0324
        L_0x01e7:
            r12.a()     // Catch:{ Exception -> 0x0323 }
            double r7 = r7 - r5
            int r13 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r13 <= 0) goto L_0x01f9
            r3 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r13 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r13 >= 0) goto L_0x01f9
            double r7 = java.lang.Math.ceil(r7)     // Catch:{ Exception -> 0x0323 }
        L_0x01f9:
            java.text.DecimalFormat r13 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x0323 }
            java.lang.String r15 = "#0.00"
            r13.<init>(r15)     // Catch:{ Exception -> 0x0323 }
            java.lang.String r13 = r13.format(r7)     // Catch:{ Exception -> 0x0323 }
            java.lang.String r15 = "format.format(addPayAmount)"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r15)     // Catch:{ Exception -> 0x0323 }
            java.lang.String r15 = "."
            boolean r15 = kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.Object) r15)     // Catch:{ Exception -> 0x0323 }
            if (r15 == 0) goto L_0x0225
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0323 }
            r13.<init>()     // Catch:{ Exception -> 0x0323 }
            java.lang.String r15 = r12.j     // Catch:{ Exception -> 0x0323 }
            r13.append(r15)     // Catch:{ Exception -> 0x0323 }
            r15 = 46
            r13.append(r15)     // Catch:{ Exception -> 0x0323 }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x0323 }
            goto L_0x0258
        L_0x0225:
            java.math.BigDecimal r15 = new java.math.BigDecimal     // Catch:{ Exception -> 0x0323 }
            r15.<init>(r13)     // Catch:{ Exception -> 0x0323 }
            java.text.DecimalFormat r1 = new java.text.DecimalFormat     // Catch:{ Exception -> 0x0323 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0323 }
            r3.<init>()     // Catch:{ Exception -> 0x0323 }
            java.lang.String r4 = r12.j     // Catch:{ Exception -> 0x0323 }
            r3.append(r4)     // Catch:{ Exception -> 0x0323 }
            java.lang.String r4 = "##,##,##,##,###."
            r3.append(r4)     // Catch:{ Exception -> 0x0323 }
            java.lang.String r13 = r12.a((java.lang.String) r13)     // Catch:{ Exception -> 0x0323 }
            r3.append(r13)     // Catch:{ Exception -> 0x0323 }
            java.lang.String r13 = r3.toString()     // Catch:{ Exception -> 0x0323 }
            java.util.Locale r3 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x0323 }
            java.text.DecimalFormatSymbols r3 = java.text.DecimalFormatSymbols.getInstance(r3)     // Catch:{ Exception -> 0x0323 }
            r1.<init>(r13, r3)     // Catch:{ Exception -> 0x0323 }
            java.lang.String r13 = r1.format(r15)     // Catch:{ Exception -> 0x0323 }
            java.lang.String r15 = "formatter.format(parsed)"
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r15)     // Catch:{ Exception -> 0x0323 }
        L_0x0258:
            android.view.View r15 = r12.f70367c     // Catch:{ Exception -> 0x0323 }
            if (r15 != 0) goto L_0x025f
            kotlin.g.b.k.a((java.lang.String) r0)     // Catch:{ Exception -> 0x0323 }
        L_0x025f:
            int r1 = net.one97.paytm.wallet.R.id.but_pcf_pay     // Catch:{ Exception -> 0x0323 }
            android.view.View r15 = r15.findViewById(r1)     // Catch:{ Exception -> 0x0323 }
            android.widget.Button r15 = (android.widget.Button) r15     // Catch:{ Exception -> 0x0323 }
            net.one97.paytm.wallet.g.a$b r1 = new net.one97.paytm.wallet.g.a$b     // Catch:{ Exception -> 0x0323 }
            r1.<init>(r12)     // Catch:{ Exception -> 0x0323 }
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1     // Catch:{ Exception -> 0x0323 }
            r15.setOnClickListener(r1)     // Catch:{ Exception -> 0x0323 }
            android.view.View r15 = r12.f70367c     // Catch:{ Exception -> 0x0323 }
            if (r15 != 0) goto L_0x0278
            kotlin.g.b.k.a((java.lang.String) r0)     // Catch:{ Exception -> 0x0323 }
        L_0x0278:
            int r1 = net.one97.paytm.wallet.R.id.but_pcf_pay     // Catch:{ Exception -> 0x0323 }
            android.view.View r15 = r15.findViewById(r1)     // Catch:{ Exception -> 0x0323 }
            android.widget.Button r15 = (android.widget.Button) r15     // Catch:{ Exception -> 0x0323 }
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r14)     // Catch:{ Exception -> 0x0323 }
            kotlin.g.b.aa r14 = kotlin.g.b.aa.f47921a     // Catch:{ Exception -> 0x0323 }
            android.content.Context r14 = r12.f70368d     // Catch:{ Exception -> 0x0323 }
            if (r14 != 0) goto L_0x028c
            kotlin.g.b.k.a((java.lang.String) r11)     // Catch:{ Exception -> 0x0323 }
        L_0x028c:
            android.content.res.Resources r14 = r14.getResources()     // Catch:{ Exception -> 0x0323 }
            int r1 = net.one97.paytm.wallet.R.string.add_money_to_pay     // Catch:{ Exception -> 0x0323 }
            java.lang.String r14 = r14.getString(r1)     // Catch:{ Exception -> 0x0323 }
            java.lang.String r1 = "mContext.resources.getSt….string.add_money_to_pay)"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r1)     // Catch:{ Exception -> 0x0323 }
            java.lang.Object[] r1 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x0323 }
            r1[r2] = r13     // Catch:{ Exception -> 0x0323 }
            java.lang.Object[] r13 = java.util.Arrays.copyOf(r1, r9)     // Catch:{ Exception -> 0x0323 }
            java.lang.String r13 = java.lang.String.format(r14, r13)     // Catch:{ Exception -> 0x0323 }
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r10)     // Catch:{ Exception -> 0x0323 }
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13     // Catch:{ Exception -> 0x0323 }
            r15.setText(r13)     // Catch:{ Exception -> 0x0323 }
            goto L_0x0324
        L_0x02b0:
            r12.a()     // Catch:{ Exception -> 0x0323 }
            android.view.View r13 = r12.f70367c     // Catch:{ Exception -> 0x0323 }
            if (r13 != 0) goto L_0x02ba
            kotlin.g.b.k.a((java.lang.String) r0)     // Catch:{ Exception -> 0x0323 }
        L_0x02ba:
            int r15 = net.one97.paytm.wallet.R.id.but_pcf_pay     // Catch:{ Exception -> 0x0323 }
            android.view.View r13 = r13.findViewById(r15)     // Catch:{ Exception -> 0x0323 }
            android.widget.Button r13 = (android.widget.Button) r13     // Catch:{ Exception -> 0x0323 }
            net.one97.paytm.wallet.g.a$c r15 = new net.one97.paytm.wallet.g.a$c     // Catch:{ Exception -> 0x0323 }
            r15.<init>(r12)     // Catch:{ Exception -> 0x0323 }
            android.view.View$OnClickListener r15 = (android.view.View.OnClickListener) r15     // Catch:{ Exception -> 0x0323 }
            r13.setOnClickListener(r15)     // Catch:{ Exception -> 0x0323 }
            android.view.View r13 = r12.f70367c     // Catch:{ Exception -> 0x0323 }
            if (r13 != 0) goto L_0x02d3
            kotlin.g.b.k.a((java.lang.String) r0)     // Catch:{ Exception -> 0x0323 }
        L_0x02d3:
            int r15 = net.one97.paytm.wallet.R.id.but_pcf_pay     // Catch:{ Exception -> 0x0323 }
            android.view.View r13 = r13.findViewById(r15)     // Catch:{ Exception -> 0x0323 }
            android.widget.Button r13 = (android.widget.Button) r13     // Catch:{ Exception -> 0x0323 }
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r14)     // Catch:{ Exception -> 0x0323 }
            kotlin.g.b.aa r14 = kotlin.g.b.aa.f47921a     // Catch:{ Exception -> 0x0323 }
            android.content.Context r14 = r12.f70368d     // Catch:{ Exception -> 0x0323 }
            if (r14 != 0) goto L_0x02e7
            kotlin.g.b.k.a((java.lang.String) r11)     // Catch:{ Exception -> 0x0323 }
        L_0x02e7:
            android.content.res.Resources r14 = r14.getResources()     // Catch:{ Exception -> 0x0323 }
            int r15 = net.one97.paytm.wallet.R.string.pay_rs     // Catch:{ Exception -> 0x0323 }
            java.lang.String r14 = r14.getString(r15)     // Catch:{ Exception -> 0x0323 }
            java.lang.String r15 = "mContext.resources.getString(R.string.pay_rs)"
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r15)     // Catch:{ Exception -> 0x0323 }
            java.lang.Object[] r15 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x0323 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0323 }
            r3.<init>()     // Catch:{ Exception -> 0x0323 }
            java.lang.String r4 = r12.j     // Catch:{ Exception -> 0x0323 }
            r3.append(r4)     // Catch:{ Exception -> 0x0323 }
            java.lang.String r4 = r12.f70372h     // Catch:{ Exception -> 0x0323 }
            if (r4 != 0) goto L_0x0309
            kotlin.g.b.k.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0323 }
        L_0x0309:
            r3.append(r4)     // Catch:{ Exception -> 0x0323 }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x0323 }
            r15[r2] = r1     // Catch:{ Exception -> 0x0323 }
            java.lang.Object[] r15 = java.util.Arrays.copyOf(r15, r9)     // Catch:{ Exception -> 0x0323 }
            java.lang.String r14 = java.lang.String.format(r14, r15)     // Catch:{ Exception -> 0x0323 }
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r10)     // Catch:{ Exception -> 0x0323 }
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14     // Catch:{ Exception -> 0x0323 }
            r13.setText(r14)     // Catch:{ Exception -> 0x0323 }
            goto L_0x0324
        L_0x0323:
        L_0x0324:
            android.view.View r13 = r12.f70367c
            if (r13 != 0) goto L_0x032b
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x032b:
            int r14 = net.one97.paytm.wallet.R.id.iv_close_pcf
            android.view.View r13 = r13.findViewById(r14)
            android.widget.ImageView r13 = (android.widget.ImageView) r13
            net.one97.paytm.wallet.g.a$e r14 = new net.one97.paytm.wallet.g.a$e
            r14.<init>(r12)
            android.view.View$OnClickListener r14 = (android.view.View.OnClickListener) r14
            r13.setOnClickListener(r14)
            android.view.View r13 = r12.f70367c
            if (r13 != 0) goto L_0x0344
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0344:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.g.a.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f70377a;

        e(a aVar) {
            this.f70377a = aVar;
        }

        public final void onClick(View view) {
            this.f70377a.dismissAllowingStateLoss();
        }
    }

    private final void a() {
        View view = this.f70367c;
        if (view == null) {
            k.a("rootView");
        }
        TextView textView = (TextView) view.findViewById(R.id.tv_amount_value);
        k.a((Object) textView, "rootView.tv_amount_value");
        String[] strArr = new String[2];
        strArr[0] = this.j;
        String str = this.f70370f;
        if (str == null) {
            k.a("txnAmount");
        }
        strArr[1] = str;
        textView.setText(v.a(strArr));
        View view2 = this.f70367c;
        if (view2 == null) {
            k.a("rootView");
        }
        TextView textView2 = (TextView) view2.findViewById(R.id.tv_convfee_value);
        k.a((Object) textView2, "rootView.tv_convfee_value");
        String[] strArr2 = new String[2];
        strArr2[0] = this.j;
        String str2 = this.f70371g;
        if (str2 == null) {
            k.a("convFee");
        }
        strArr2[1] = str2;
        textView2.setText(v.a(strArr2));
        View view3 = this.f70367c;
        if (view3 == null) {
            k.a("rootView");
        }
        TextView textView3 = (TextView) view3.findViewById(R.id.tv_net_amount_value);
        k.a((Object) textView3, "rootView.tv_net_amount_value");
        String[] strArr3 = new String[2];
        strArr3[0] = this.j;
        String str3 = this.f70372h;
        if (str3 == null) {
            k.a("netAmount");
        }
        strArr3[1] = str3;
        textView3.setText(v.a(strArr3));
        View view4 = this.f70367c;
        if (view4 == null) {
            k.a("rootView");
        }
        TextView textView4 = (TextView) view4.findViewById(R.id.tv_pcf_subtitle);
        k.a((Object) textView4, "rootView.tv_pcf_subtitle");
        aa aaVar = aa.f47921a;
        Context context = this.f70368d;
        if (context == null) {
            k.a("mContext");
        }
        String string = context.getResources().getString(R.string.merchant_charges_you_an_amount_as_convenience_fee);
        k.a((Object) string, "mContext.resources.getSt…mount_as_convenience_fee)");
        Object[] objArr = new Object[1];
        String str4 = this.f70373i;
        if (str4 == null) {
            k.a("merchantName");
        }
        objArr[0] = str4;
        String format = String.format(string, Arrays.copyOf(objArr, 1));
        k.a((Object) format, "java.lang.String.format(format, *args)");
        textView4.setText(format);
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f70374a;

        b(a aVar) {
            this.f70374a = aVar;
        }

        public final void onClick(View view) {
            a.a(this.f70374a).b();
            this.f70374a.dismissAllowingStateLoss();
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f70375a;

        c(a aVar) {
            this.f70375a = aVar;
        }

        public final void onClick(View view) {
            a.a(this.f70375a).a();
            this.f70375a.dismissAllowingStateLoss();
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f70376a;

        d(a aVar) {
            this.f70376a = aVar;
        }

        public final void onClick(View view) {
            a.a(this.f70376a).c();
            this.f70376a.dismissAllowingStateLoss();
        }
    }

    private final String a(String str) {
        int i2 = 0;
        int length = (str.length() - 1) - p.a((CharSequence) str, AppUtility.CENTER_DOT, 0, false, 6);
        String str2 = "";
        while (i2 < length && i2 < this.f70366b) {
            str2 = str2 + "0";
            i2++;
        }
        return str2;
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.k;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
