package net.one97.paytm.passbook.landing.c;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.paytm.utility.q;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.landing.e.ac;
import net.one97.paytm.passbook.landing.f.a;
import net.one97.paytm.passbook.landing.g.a;
import net.one97.paytm.passbook.main.widget.PassbookBalanceCardView;
import net.one97.paytm.passbook.main.widget.UPIInitCardV2;

public final class a extends net.one97.paytm.passbook.utility.b implements net.one97.paytm.passbook.landing.d.a {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.passbook.landing.g.a f57593a;

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.passbook.landing.f.a f57594b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f57595c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f57596d = true;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f57597e;

    public final View a(int i2) {
        if (this.f57597e == null) {
            this.f57597e = new HashMap();
        }
        View view = (View) this.f57597e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f57597e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void d() {
        HashMap hashMap = this.f57597e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        d();
    }

    static final class b<T> implements z<net.one97.paytm.passbook.landing.e.a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57601a;

        b(a aVar) {
            this.f57601a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.passbook.landing.e.a aVar = (net.one97.paytm.passbook.landing.e.a) obj;
            if (aVar != null) {
                a.a(this.f57601a);
                a.a(this.f57601a, aVar);
            }
        }
    }

    public final net.one97.paytm.passbook.landing.g.a a() {
        net.one97.paytm.passbook.landing.g.a aVar = this.f57593a;
        if (aVar == null) {
            k.a("mBalanceSummaryViewModel");
        }
        return aVar;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        ai a2 = am.a((Fragment) this).a(net.one97.paytm.passbook.landing.g.a.class);
        k.a((Object) a2, "ViewModelProviders.of(th…aryViewModel::class.java)");
        this.f57593a = (net.one97.paytm.passbook.landing.g.a) a2;
        return layoutInflater.inflate(R.layout.pass_fragment_balance_summary, viewGroup, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0029, code lost:
        r4 = r4.getIntent();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r11, android.os.Bundle r12) {
        /*
            r10 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r11, r0)
            super.onViewCreated(r11, r12)
            net.one97.paytm.passbook.landing.f.a r12 = new net.one97.paytm.passbook.landing.f.a
            r12.<init>(r10)
            r10.f57594b = r12
            net.one97.paytm.passbook.landing.f.a r12 = r10.f57594b
            r0 = 1
            r1 = 0
            java.lang.String r2 = "mBalanceSummaryViewModel"
            if (r12 == 0) goto L_0x0054
            net.one97.paytm.passbook.landing.g.a r3 = r10.f57593a
            if (r3 != 0) goto L_0x001e
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x001e:
            kotlin.g.b.k.c(r3, r2)
            net.one97.paytm.passbook.landing.c.a r4 = r12.N
            androidx.fragment.app.FragmentActivity r4 = r4.getActivity()
            if (r4 == 0) goto L_0x003b
            android.content.Intent r4 = r4.getIntent()
            if (r4 == 0) goto L_0x003b
            r5 = 0
            java.lang.String r6 = "extra_module_open_source"
            int r4 = r4.getIntExtra(r6, r5)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x003c
        L_0x003b:
            r4 = r1
        L_0x003c:
            r12.L = r4
            java.lang.Integer r12 = r12.L
            if (r12 != 0) goto L_0x0043
            goto L_0x004f
        L_0x0043:
            int r12 = r12.intValue()
            if (r12 != r0) goto L_0x004f
            net.one97.paytm.passbook.landing.g.d r12 = net.one97.paytm.passbook.landing.g.d.PAYMENTS_BANK
            r3.a((net.one97.paytm.passbook.landing.g.d) r12)
            goto L_0x0054
        L_0x004f:
            net.one97.paytm.passbook.landing.g.d r12 = net.one97.paytm.passbook.landing.g.d.HOME
            r3.a((net.one97.paytm.passbook.landing.g.d) r12)
        L_0x0054:
            int r12 = net.one97.paytm.passbook.R.id.itemsLayout
            android.view.View r12 = r11.findViewById(r12)
            android.widget.LinearLayout r12 = (android.widget.LinearLayout) r12
            if (r12 == 0) goto L_0x0065
            net.one97.paytm.passbook.landing.f.a r3 = r10.f57594b
            if (r3 == 0) goto L_0x0065
            r3.a((android.widget.LinearLayout) r12)
        L_0x0065:
            int r12 = net.one97.paytm.passbook.R.id.tvExpendCollapsSubwallet
            android.view.View r12 = r11.findViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            if (r12 == 0) goto L_0x0082
            net.one97.paytm.passbook.landing.f.a r3 = r10.f57594b
            if (r3 == 0) goto L_0x0082
            java.lang.String r4 = "expendCollapsSubwallet"
            kotlin.g.b.k.c(r12, r4)
            net.one97.paytm.passbook.landing.f.a$c r4 = new net.one97.paytm.passbook.landing.f.a$c
            r4.<init>(r3)
            android.view.View$OnClickListener r4 = (android.view.View.OnClickListener) r4
            r12.setOnClickListener(r4)
        L_0x0082:
            int r12 = net.one97.paytm.passbook.R.id.bannerContainer
            android.view.View r11 = r11.findViewById(r12)
            android.widget.FrameLayout r11 = (android.widget.FrameLayout) r11
            if (r11 == 0) goto L_0x00e2
            net.one97.paytm.passbook.landing.f.a r12 = r10.f57594b
            if (r12 == 0) goto L_0x00e2
            java.lang.String r3 = "bannerContainer"
            kotlin.g.b.k.c(r11, r3)
            net.one97.paytm.passbook.mapping.f r3 = net.one97.paytm.passbook.d.b()
            java.lang.String r4 = "pass2showBanner"
            boolean r0 = r3.a((java.lang.String) r4, (boolean) r0)
            if (r0 == 0) goto L_0x00e2
            net.one97.paytm.passbook.mapping.f r0 = net.one97.paytm.passbook.d.b()
            java.lang.String r3 = "passbookAdSlotApiURL"
            java.lang.String r6 = r0.a((java.lang.String) r3)
            net.one97.paytm.passbook.mapping.f r4 = net.one97.paytm.passbook.d.b()
            net.one97.paytm.passbook.landing.c.a r0 = r12.N
            androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
            r5 = r0
            android.app.Activity r5 = (android.app.Activity) r5
            com.paytm.network.a$c r7 = com.paytm.network.a.c.PASSBOOK
            r8 = r11
            android.view.View r8 = (android.view.View) r8
            r9 = 0
            androidx.fragment.app.Fragment r0 = r4.a((android.app.Activity) r5, (java.lang.String) r6, (com.paytm.network.a.c) r7, (android.view.View) r8, (java.lang.String) r9)
            net.one97.paytm.passbook.landing.c.a r12 = r12.N
            androidx.fragment.app.FragmentActivity r12 = r12.getActivity()
            if (r12 == 0) goto L_0x00d4
            androidx.fragment.app.j r12 = r12.getSupportFragmentManager()
            if (r12 == 0) goto L_0x00d4
            androidx.fragment.app.q r1 = r12.a()
        L_0x00d4:
            if (r1 == 0) goto L_0x00dd
            int r11 = r11.getId()
            r1.b(r11, r0)
        L_0x00dd:
            if (r1 == 0) goto L_0x00e2
            r1.c()
        L_0x00e2:
            net.one97.paytm.passbook.mapping.e r11 = net.one97.paytm.passbook.mapping.e.a()
            java.lang.String r12 = "GTMLoader.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r12)
            boolean r11 = net.one97.paytm.passbook.mapping.e.E()
            r10.f57596d = r11
            net.one97.paytm.passbook.landing.g.a r11 = r10.f57593a
            if (r11 != 0) goto L_0x00f8
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x00f8:
            r11.a()
            net.one97.paytm.passbook.landing.g.a r11 = r10.f57593a
            if (r11 != 0) goto L_0x0102
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0102:
            androidx.lifecycle.y<net.one97.paytm.passbook.landing.e.a> r11 = r11.f57738a
            r12 = r10
            androidx.lifecycle.q r12 = (androidx.lifecycle.q) r12
            net.one97.paytm.passbook.landing.c.a$b r0 = new net.one97.paytm.passbook.landing.c.a$b
            r0.<init>(r10)
            androidx.lifecycle.z r0 = (androidx.lifecycle.z) r0
            r11.observe(r12, r0)
            net.one97.paytm.passbook.landing.g.a r11 = r10.f57593a
            if (r11 != 0) goto L_0x0118
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0118:
            androidx.lifecycle.y<java.lang.Boolean> r11 = r11.f57739b
            net.one97.paytm.passbook.landing.c.a$c r0 = new net.one97.paytm.passbook.landing.c.a$c
            r0.<init>(r10)
            androidx.lifecycle.z r0 = (androidx.lifecycle.z) r0
            r11.observe(r12, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.landing.c.a.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    public static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f57603a;

        public d(TextView textView) {
            this.f57603a = textView;
        }

        public final void run() {
            this.f57603a.setVisibility(0);
        }
    }

    /* renamed from: net.one97.paytm.passbook.landing.c.a$a  reason: collision with other inner class name */
    public static final class C1089a implements ac.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.passbook.landing.f.a f57598a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f57599b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.passbook.landing.e.a f57600c;

        C1089a(net.one97.paytm.passbook.landing.f.a aVar, a aVar2, net.one97.paytm.passbook.landing.e.a aVar3) {
            this.f57598a = aVar;
            this.f57599b = aVar2;
            this.f57600c = aVar3;
        }

        public final void a() {
            net.one97.paytm.passbook.landing.g.a a2 = this.f57599b.a();
            net.one97.paytm.passbook.landing.repositories.k kVar = net.one97.paytm.passbook.landing.repositories.k.f57801b;
            Application application = a2.getApplication();
            k.a((Object) application, "getApplication()");
            net.one97.paytm.passbook.landing.repositories.k.a((Context) application).observeForever(new a.c(a2));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r1 = r1.getIntent();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void c() {
        /*
            r4 = this;
            net.one97.paytm.passbook.landing.f.a r0 = r4.f57594b
            if (r0 == 0) goto L_0x007b
            net.one97.paytm.passbook.landing.c.a r1 = r0.N
            androidx.fragment.app.FragmentActivity r1 = r1.getActivity()
            if (r1 == 0) goto L_0x001e
            android.content.Intent r1 = r1.getIntent()
            if (r1 == 0) goto L_0x001e
            r2 = 0
            java.lang.String r3 = "extra_module_open_source"
            int r1 = r1.getIntExtra(r3, r2)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x001f
        L_0x001e:
            r1 = 0
        L_0x001f:
            if (r1 != 0) goto L_0x0022
            return
        L_0x0022:
            int r1 = r1.intValue()
            r2 = 1
            if (r1 != r2) goto L_0x007b
            r0.D = r2
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r1 = r0.f57709e
            if (r1 != 0) goto L_0x0034
            java.lang.String r2 = "mPaymentsBankSA"
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0034:
            int r2 = net.one97.paytm.passbook.R.id.tvCheckBalance
            android.view.View r1 = r1.a((int) r2)
            androidx.appcompat.widget.AppCompatTextView r1 = (androidx.appcompat.widget.AppCompatTextView) r1
            r1.performClick()
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r1 = r0.f57710f
            if (r1 != 0) goto L_0x0048
            java.lang.String r2 = "mFixedDepositSA"
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0048:
            int r2 = net.one97.paytm.passbook.R.id.tvCheckBalance
            android.view.View r1 = r1.a((int) r2)
            androidx.appcompat.widget.AppCompatTextView r1 = (androidx.appcompat.widget.AppCompatTextView) r1
            r1.performClick()
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r1 = r0.f57711g
            if (r1 != 0) goto L_0x005c
            java.lang.String r2 = "mCurrentAccountCard"
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x005c:
            int r2 = net.one97.paytm.passbook.R.id.tvCheckBalance
            android.view.View r1 = r1.a((int) r2)
            androidx.appcompat.widget.AppCompatTextView r1 = (androidx.appcompat.widget.AppCompatTextView) r1
            r1.performClick()
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r0.f57712h
            if (r0 != 0) goto L_0x0070
            java.lang.String r1 = "mFDCurrentAccountCard"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0070:
            int r1 = net.one97.paytm.passbook.R.id.tvCheckBalance
            android.view.View r0 = r0.a((int) r1)
            androidx.appcompat.widget.AppCompatTextView r0 = (androidx.appcompat.widget.AppCompatTextView) r0
            r0.performClick()
        L_0x007b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.landing.c.a.c():void");
    }

    public final void onDestroy() {
        super.onDestroy();
        this.f57594b = null;
    }

    public final void b() {
        net.one97.paytm.passbook.landing.f.a aVar = this.f57594b;
        if (aVar != null) {
            aVar.M = true;
            aVar.y();
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        net.one97.paytm.passbook.landing.f.a aVar = this.f57594b;
        if (aVar != null) {
            if (i3 == -1) {
                if (i2 == 3) {
                    q.b("reloadData() called from onActivityResult()-CJRParamConstants.SIGN_REQ_CODE");
                    aVar.w();
                } else if (i2 == 112) {
                    PassbookBalanceCardView passbookBalanceCardView = aVar.k;
                    if (passbookBalanceCardView == null) {
                        k.a("mBhimUpiSelectedCard");
                    }
                    aVar.a(passbookBalanceCardView);
                } else if (i2 != 304) {
                    if (i2 == 1025) {
                        aVar.D = true;
                        aVar.y();
                    } else if (i2 == 2304) {
                        UPIInitCardV2 uPIInitCardV2 = aVar.z;
                        if (uPIInitCardV2 == null) {
                            k.a("mUpiInitCardV2");
                        }
                        uPIInitCardV2.a(i2, i3, intent);
                    }
                } else if (aVar.N.isAdded()) {
                    PassbookBalanceCardView passbookBalanceCardView2 = aVar.j;
                    if (passbookBalanceCardView2 == null) {
                        k.a("mBhimUPICard");
                    }
                    passbookBalanceCardView2.setVisibility(8);
                    q.b("hasUPIVPA() called from updateUPI()");
                    aVar.N.a().b();
                }
            }
            if (i2 == 0) {
                q.b("reloadData() called from onActivityResult()-UPIInitCardV2.KEY_LOADING_NEW_SCREEN");
                aVar.w();
            }
        }
    }

    static final class c<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57602a;

        c(a aVar) {
            this.f57602a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.passbook.landing.f.a aVar = this.f57602a.f57594b;
            if (aVar != null) {
                TextView textView = (TextView) aVar.N.a(R.id.tvExpendCollapsSubwallet);
                k.a((Object) textView, "balanceSummaryFragment.tvExpendCollapsSubwallet");
                textView.setVisibility(4);
                Context context = aVar.N.getContext();
                Context context2 = aVar.N.getContext();
                String str = null;
                String string = context2 != null ? context2.getString(R.string.pass_no_connection) : null;
                Context context3 = aVar.N.getContext();
                String string2 = context3 != null ? context3.getString(R.string.no_internet) : null;
                Context context4 = aVar.N.getContext();
                if (context4 != null) {
                    str = context4.getString(R.string.pass_network_retry_yes);
                }
                net.one97.paytm.passbook.mapping.a.a(context, string, string2, str, (String) null, false, new a.p(aVar), (DialogInterface.OnClickListener) null);
            }
        }
    }

    public static final /* synthetic */ void a(a aVar) {
        View view;
        TextView textView;
        TextView textView2;
        if (aVar.f57596d) {
            View view2 = aVar.getView();
            if ((view2 == null || (textView2 = (TextView) view2.findViewById(R.id.tvExpendCollapsSubwallet)) == null || textView2.getVisibility() != 0) && (view = aVar.getView()) != null && (textView = (TextView) view.findViewById(R.id.tvExpendCollapsSubwallet)) != null) {
                textView.setAlpha(0.0f);
                textView.setVisibility(0);
                textView.animate().alpha(1.0f).setDuration(300);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:452:0x0ee9, code lost:
        if (r3 != 2) goto L_0x0f68;
     */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x0710  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x073a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ kotlin.x a(net.one97.paytm.passbook.landing.c.a r22, net.one97.paytm.passbook.landing.e.a r23) {
        /*
            r0 = r22
            r1 = r23
            boolean r2 = r1 instanceof net.one97.paytm.passbook.landing.e.c
            java.lang.String r6 = "balanceSummaryUIHandler"
            r7 = 1
            r9 = 0
            if (r2 == 0) goto L_0x03d3
            net.one97.paytm.passbook.landing.f.a r2 = r0.f57594b
            if (r2 == 0) goto L_0x03d1
            android.view.View r10 = r22.getView()
            java.lang.String r11 = "GTMLoader.getInstance()"
            if (r10 == 0) goto L_0x03ba
            int r12 = net.one97.paytm.passbook.R.id.itemsLayout
            android.view.View r10 = r10.findViewById(r12)
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10
            if (r10 == 0) goto L_0x03ba
            net.one97.paytm.passbook.landing.e.c r1 = (net.one97.paytm.passbook.landing.e.c) r1
            kotlin.g.b.k.c(r2, r6)
            java.lang.String r6 = "itemsLayout"
            kotlin.g.b.k.c(r10, r6)
            net.one97.paytm.passbook.mapping.a.f<? extends net.one97.paytm.passbook.beans.CJRCashWallet> r6 = r1.f57638a
            net.one97.paytm.passbook.mapping.a.j r6 = r6.f57886a
            int[] r12 = net.one97.paytm.passbook.landing.e.d.f57655a
            int r6 = r6.ordinal()
            r6 = r12[r6]
            if (r6 == r7) goto L_0x0078
            net.one97.paytm.passbook.main.widget.ExpandableBalanceCardView r3 = r2.a()
            net.one97.paytm.passbook.landing.e.c.a((net.one97.paytm.passbook.main.widget.ExpandableBalanceCardView) r3)
            net.one97.paytm.passbook.main.widget.ExpandableBalanceCardView r3 = r2.a()
            android.view.View r3 = (android.view.View) r3
            r10.removeView(r3)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r3 = r2.d()
            android.view.View r3 = (android.view.View) r3
            r10.removeView(r3)
            net.one97.paytm.passbook.main.widget.ExpandableBalanceCardView r3 = r2.a()
            android.content.Context r3 = r3.getContext()
            boolean r4 = r3 instanceof android.app.Activity
            if (r4 != 0) goto L_0x0060
            r3 = 0
        L_0x0060:
            android.app.Activity r3 = (android.app.Activity) r3
            net.one97.paytm.passbook.mapping.a.f<? extends net.one97.paytm.passbook.beans.CJRCashWallet> r1 = r1.f57638a
            net.one97.paytm.passbook.mapping.a.d<? extends T> r1 = r1.f57888c
            if (r1 == 0) goto L_0x006b
            com.paytm.network.model.NetworkCustomError r8 = r1.f57879a
            goto L_0x006c
        L_0x006b:
            r8 = 0
        L_0x006c:
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            java.lang.Class<net.one97.paytm.passbook.landing.activity.PassbookLandingActivity> r1 = net.one97.paytm.passbook.landing.activity.PassbookLandingActivity.class
            r1.getName()
            net.one97.paytm.passbook.utility.j.a((android.app.Activity) r3, (java.lang.Throwable) r8)
            goto L_0x03b7
        L_0x0078:
            net.one97.paytm.passbook.main.widget.ExpandableBalanceCardView r6 = r2.a()
            net.one97.paytm.passbook.landing.e.c.a((net.one97.paytm.passbook.main.widget.ExpandableBalanceCardView) r6)
            net.one97.paytm.passbook.mapping.a.f<? extends net.one97.paytm.passbook.beans.CJRCashWallet> r6 = r1.f57638a
            T r6 = r6.f57887b
            net.one97.paytm.passbook.beans.CJRCashWallet r6 = (net.one97.paytm.passbook.beans.CJRCashWallet) r6
            if (r6 == 0) goto L_0x03b7
            java.lang.String r12 = r6.getStatusCode()
            java.lang.String r13 = "200"
            boolean r12 = kotlin.m.p.a((java.lang.String) r13, (java.lang.String) r12, (boolean) r7)
            if (r12 == 0) goto L_0x03b7
            net.one97.paytm.passbook.beans.CJRCashWalletResponse r12 = r6.getResponse()
            if (r12 == 0) goto L_0x03b7
            net.one97.paytm.passbook.main.widget.ExpandableBalanceCardView r12 = r2.a()
            r12.getContext()
            net.one97.paytm.passbook.beans.CJRCashWalletResponse r12 = r6.getResponse()
            java.lang.String r13 = "it.response"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r13)
            java.lang.String r12 = r12.getWalletGrade()
            net.one97.paytm.passbook.mapping.c.aa(r12)
            net.one97.paytm.passbook.beans.CJRCashWalletResponse r12 = r6.getResponse()
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r13)
            java.lang.String r12 = r12.getWalletGrade()
            java.lang.String r14 = "Non Wallet Account"
            boolean r12 = kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.Object) r14)
            if (r12 == 0) goto L_0x00d5
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r3 = r2.d()
            r3.setVisibility(r9)
            net.one97.paytm.passbook.main.widget.ExpandableBalanceCardView r3 = r2.a()
            android.view.View r3 = (android.view.View) r3
            r10.removeView(r3)
            goto L_0x03a9
        L_0x00d5:
            net.one97.paytm.passbook.main.widget.ExpandableBalanceCardView r12 = r2.a()
            r12.setVisibility(r9)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r12 = r2.d()
            android.view.View r12 = (android.view.View) r12
            r10.removeView(r12)
            net.one97.paytm.passbook.main.widget.ExpandableBalanceCardView r14 = r2.a()
            net.one97.paytm.passbook.main.widget.InitCards r15 = r2.y
            if (r15 != 0) goto L_0x00f2
            java.lang.String r12 = "mFastagInitCard"
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x00f2:
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r12 = r2.s
            if (r12 != 0) goto L_0x00fb
            java.lang.String r16 = "mFastagCard"
            kotlin.g.b.k.a((java.lang.String) r16)
        L_0x00fb:
            net.one97.paytm.passbook.beans.CJRCashWalletResponse r3 = r6.getResponse()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r13)
            java.util.List r3 = r3.getSubWalletDetailList()
            java.lang.String r4 = "it.response.subWalletDetailList"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r13 = 0
        L_0x0111:
            int r8 = r3.size()
            if (r13 >= r8) goto L_0x020a
            java.lang.Object r8 = r3.get(r13)
            net.one97.paytm.passbook.beans.CJRSubWallet r8 = (net.one97.paytm.passbook.beans.CJRSubWallet) r8
            int r5 = r8.getSubWalletType()
            net.one97.paytm.passbook.utility.n r19 = net.one97.paytm.passbook.utility.n.PAYTM_WALLET
            int r7 = r19.getValue()
            if (r5 == r7) goto L_0x0137
            int r5 = r8.getSubWalletType()
            net.one97.paytm.passbook.utility.n r7 = net.one97.paytm.passbook.utility.n.GIFT_VOUCHER
            int r7 = r7.getValue()
            if (r5 == r7) goto L_0x0137
            r5 = 1
            goto L_0x0138
        L_0x0137:
            r5 = 0
        L_0x0138:
            if (r5 == 0) goto L_0x01f6
            net.one97.paytm.passbook.main.entity.MultiSubWallet r5 = new net.one97.paytm.passbook.main.entity.MultiSubWallet
            int r7 = r8.getSubWalletType()
            r5.<init>(r7, r9)
            r7 = r13
        L_0x0144:
            int r9 = r3.size()
            if (r13 >= r9) goto L_0x01de
            java.lang.Object r9 = r3.get(r13)
            net.one97.paytm.passbook.beans.CJRSubWallet r9 = (net.one97.paytm.passbook.beans.CJRSubWallet) r9
            if (r7 != r13) goto L_0x0155
            int r13 = r13 + 1
            goto L_0x0144
        L_0x0155:
            r23 = r3
            int r3 = r8.getSubWalletType()
            net.one97.paytm.passbook.utility.n r20 = net.one97.paytm.passbook.utility.n.ALLOWALANCE_WALLET
            r21 = r7
            int r7 = r20.getValue()
            if (r3 != r7) goto L_0x01ab
            if (r8 == 0) goto L_0x01a8
            if (r9 == 0) goto L_0x01a8
            java.lang.String r3 = r8.getmIssuerId()
            if (r3 == 0) goto L_0x01a8
            java.lang.String r3 = r9.getmIssuerId()
            if (r3 == 0) goto L_0x01a8
            int r3 = r8.getSubWalletType()
            int r7 = r9.getSubWalletType()
            if (r3 != r7) goto L_0x01a8
            java.lang.String r3 = r8.getmIssuerId()
            java.lang.String r7 = r9.getmIssuerId()
            r20 = r12
            r12 = 1
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r7, (boolean) r12)
            if (r3 == 0) goto L_0x01d4
            java.util.ArrayList r3 = r5.getSubWalletList()
            int r3 = r3.size()
            if (r3 != 0) goto L_0x01a4
            r5.addSubWallet(r8)
            java.lang.String r3 = r8.getIssuerMetadata()
            r5.setIssuerMetadata(r3)
        L_0x01a4:
            r5.addSubWallet(r9)
            goto L_0x01d2
        L_0x01a8:
            r20 = r12
            goto L_0x01d4
        L_0x01ab:
            r20 = r12
            if (r8 == 0) goto L_0x01d4
            if (r9 == 0) goto L_0x01d4
            int r3 = r8.getSubWalletType()
            int r7 = r9.getSubWalletType()
            if (r3 != r7) goto L_0x01d4
            java.util.ArrayList r3 = r5.getSubWalletList()
            int r3 = r3.size()
            if (r3 != 0) goto L_0x01cf
            r5.addSubWallet(r8)
            java.lang.String r3 = r8.getIssuerMetadata()
            r5.setIssuerMetadata(r3)
        L_0x01cf:
            r5.addSubWallet(r9)
        L_0x01d2:
            r7 = r13
            goto L_0x01d6
        L_0x01d4:
            r7 = r21
        L_0x01d6:
            int r13 = r13 + 1
            r3 = r23
            r12 = r20
            goto L_0x0144
        L_0x01de:
            r23 = r3
            r21 = r7
            r20 = r12
            java.util.ArrayList r3 = r5.getSubWalletList()
            int r3 = r3.size()
            if (r3 != 0) goto L_0x01f2
            r4.add(r8)
            goto L_0x01ff
        L_0x01f2:
            r4.add(r5)
            goto L_0x01ff
        L_0x01f6:
            r23 = r3
            r20 = r12
            r4.add(r8)
            r21 = r13
        L_0x01ff:
            r3 = 1
            int r13 = r21 + 1
            r3 = r23
            r12 = r20
            r7 = 1
            r9 = 0
            goto L_0x0111
        L_0x020a:
            r20 = r12
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Iterator r4 = r4.iterator()
            r8 = 0
            r16 = 0
        L_0x021d:
            boolean r7 = r4.hasNext()
            if (r7 == 0) goto L_0x0270
            java.lang.Object r7 = r4.next()
            net.one97.paytm.passbook.beans.CJRSubWallet r7 = (net.one97.paytm.passbook.beans.CJRSubWallet) r7
            net.one97.paytm.passbook.main.entity.MultiSubWallet r9 = new net.one97.paytm.passbook.main.entity.MultiSubWallet
            java.lang.String r12 = "subWallet"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r12)
            int r12 = r7.getSubWalletType()
            r9.<init>(r12)
            r9.addSubWallet(r7)
            int r12 = r7.getSubWalletType()
            net.one97.paytm.passbook.utility.n r13 = net.one97.paytm.passbook.utility.n.TOLL
            int r13 = r13.getValue()
            if (r12 != r13) goto L_0x0248
            r8 = r9
            goto L_0x021d
        L_0x0248:
            int r12 = r7.getSubWalletType()
            net.one97.paytm.passbook.utility.n r13 = net.one97.paytm.passbook.utility.n.LOYALTY_WALLET_TYPE_7
            int r13 = r13.getValue()
            if (r12 == r13) goto L_0x025f
            net.one97.paytm.passbook.utility.n r13 = net.one97.paytm.passbook.utility.n.LOYALTY_WALLET
            int r13 = r13.getValue()
            if (r12 != r13) goto L_0x025d
            goto L_0x025f
        L_0x025d:
            r12 = 0
            goto L_0x0260
        L_0x025f:
            r12 = 1
        L_0x0260:
            if (r12 == 0) goto L_0x0266
            r5.add(r9)
            goto L_0x021d
        L_0x0266:
            r3.add(r9)
            double r12 = r7.getBalance()
            double r16 = r16 + r12
            goto L_0x021d
        L_0x0270:
            int r4 = net.one97.paytm.passbook.R.string.paytm_balance1
            java.util.Collection r3 = (java.util.Collection) r3
            r5 = r20
            r12 = r1
            r13 = r14
            r14 = r4
            r4 = r15
            r15 = r16
            r17 = r3
            r12.a(r13, r14, r15, r17)
            if (r8 == 0) goto L_0x037c
            if (r5 == 0) goto L_0x037c
            int r7 = net.one97.paytm.passbook.R.id.cardShimmerLayout
            android.view.View r7 = r5.a((int) r7)
            net.one97.paytm.common.views.ShimmerFrameLayout r7 = (net.one97.paytm.common.views.ShimmerFrameLayout) r7
            java.lang.String r9 = "view.cardShimmerLayout"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r9)
            r9 = 8
            r7.setVisibility(r9)
            int r7 = net.one97.paytm.passbook.R.id.tvTitle
            android.view.View r7 = r5.a((int) r7)
            androidx.appcompat.widget.AppCompatTextView r7 = (androidx.appcompat.widget.AppCompatTextView) r7
            java.lang.String r9 = "view.tvTitle"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r9)
            java.lang.String r9 = r8.getDisplayName()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r7.setText(r9)
            int r7 = net.one97.paytm.passbook.R.id.tvAmount
            android.view.View r7 = r5.a((int) r7)
            androidx.appcompat.widget.AppCompatTextView r7 = (androidx.appcompat.widget.AppCompatTextView) r7
            java.lang.String r9 = "view.tvAmount"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r9)
            android.content.Context r9 = r5.getContext()
            int r12 = net.one97.paytm.passbook.R.string.pass_rupee
            r13 = 1
            java.lang.Object[] r14 = new java.lang.Object[r13]
            double r15 = r8.getBalance()
            java.lang.String r13 = net.one97.paytm.passbook.utility.f.b((double) r15)
            r15 = 0
            r14[r15] = r13
            java.lang.String r9 = r9.getString(r12, r14)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r7.setText(r9)
            int r7 = net.one97.paytm.passbook.R.id.ivWalletIcon
            android.view.View r7 = r5.a((int) r7)
            androidx.appcompat.widget.AppCompatImageView r7 = (androidx.appcompat.widget.AppCompatImageView) r7
            int r9 = r8.getSubWalletType()
            int r9 = net.one97.paytm.passbook.utility.q.a((int) r9)
            r7.setImageResource(r9)
            int r7 = net.one97.paytm.passbook.R.id.ivWalletIcon
            android.view.View r7 = r5.a((int) r7)
            androidx.appcompat.widget.AppCompatImageView r7 = (androidx.appcompat.widget.AppCompatImageView) r7
            java.lang.String r9 = "view.ivWalletIcon"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r9)
            r9 = 0
            r7.setVisibility(r9)
            int r7 = net.one97.paytm.passbook.R.id.tvWalletSubTitle
            android.view.View r7 = r5.a((int) r7)
            androidx.appcompat.widget.AppCompatTextView r7 = (androidx.appcompat.widget.AppCompatTextView) r7
            java.lang.String r12 = "view.tvWalletSubTitle"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r12)
            r7.setVisibility(r9)
            int r7 = net.one97.paytm.passbook.R.id.tvWalletSubTitle
            android.view.View r7 = r5.a((int) r7)
            androidx.appcompat.widget.AppCompatTextView r7 = (androidx.appcompat.widget.AppCompatTextView) r7
            java.lang.String r9 = "view.tvWalletSubTitle"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r9)
            android.content.Context r9 = r5.getContext()
            int r12 = net.one97.paytm.passbook.R.string.pb_fastag_deduction_desc
            java.lang.String r9 = r9.getString(r12)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r7.setText(r9)
            int r7 = net.one97.paytm.passbook.R.id.tvWalletSubTitle
            android.view.View r7 = r5.a((int) r7)
            androidx.appcompat.widget.AppCompatTextView r7 = (androidx.appcompat.widget.AppCompatTextView) r7
            android.content.Context r9 = r5.getContext()
            java.lang.String r12 = "view.context"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r12)
            android.content.res.Resources r9 = r9.getResources()
            int r12 = net.one97.paytm.passbook.R.color.pass_landing_subtitle_color
            int r9 = r9.getColor(r12)
            r7.setTextColor(r9)
            int r7 = net.one97.paytm.passbook.R.id.tvAmountDesc
            android.view.View r7 = r5.a((int) r7)
            androidx.appcompat.widget.AppCompatTextView r7 = (androidx.appcompat.widget.AppCompatTextView) r7
            java.lang.String r9 = "view.tvAmountDesc"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r9)
            r9 = 0
            r7.setVisibility(r9)
            int r7 = net.one97.paytm.passbook.R.id.tvAmountDesc
            android.view.View r7 = r5.a((int) r7)
            androidx.appcompat.widget.AppCompatTextView r7 = (androidx.appcompat.widget.AppCompatTextView) r7
            java.lang.String r9 = "view.tvAmountDesc"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r9)
            android.content.Context r9 = r5.getContext()
            int r12 = net.one97.paytm.passbook.R.string.pb_fastag_rev_amount
            java.lang.String r9 = r9.getString(r12)
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r7.setText(r9)
            net.one97.paytm.passbook.landing.e.c$c r7 = new net.one97.paytm.passbook.landing.e.c$c
            r7.<init>(r1, r8, r5, r3)
            android.view.View$OnClickListener r7 = (android.view.View.OnClickListener) r7
            r5.setOnClickListener(r7)
        L_0x037c:
            if (r8 != 0) goto L_0x0396
            net.one97.paytm.passbook.mapping.e r3 = net.one97.paytm.passbook.mapping.e.a()
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r11)
            boolean r3 = net.one97.paytm.passbook.mapping.e.F()
            if (r3 == 0) goto L_0x0396
            r3 = 0
            r4.setVisibility(r3)
            r12 = r5
            android.view.View r12 = (android.view.View) r12
            r10.removeView(r12)
            goto L_0x03a2
        L_0x0396:
            r3 = 0
            if (r8 == 0) goto L_0x03a2
            r5.setVisibility(r3)
            r15 = r4
            android.view.View r15 = (android.view.View) r15
            r10.removeView(r15)
        L_0x03a2:
            net.one97.paytm.passbook.main.widget.ExpandableBalanceCardView r3 = r2.a()
            r1.b(r3)
        L_0x03a9:
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r3 = r2.l()
            net.one97.paytm.passbook.landing.e.c$a r4 = new net.one97.paytm.passbook.landing.e.c$a
            r4.<init>(r6, r1, r2, r10)
            android.view.View$OnClickListener r4 = (android.view.View.OnClickListener) r4
            r3.setOnClickListener(r4)
        L_0x03b7:
            r2.b(r10)
        L_0x03ba:
            net.one97.paytm.passbook.mapping.e r1 = net.one97.paytm.passbook.mapping.e.a()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r11)
            boolean r1 = net.one97.paytm.passbook.mapping.e.E()
            if (r1 != 0) goto L_0x03ce
            boolean r1 = r0.f57595c
            if (r1 != 0) goto L_0x03ce
            r1 = 1
            r0.f57595c = r1
        L_0x03ce:
            kotlin.x r0 = kotlin.x.f47997a
            return r0
        L_0x03d1:
            r0 = 0
            return r0
        L_0x03d3:
            boolean r2 = r1 instanceof net.one97.paytm.passbook.landing.e.p
            java.lang.String r3 = "balanceSummaryUIHandler.…tTextView>(R.id.tvAmount)"
            java.lang.String r4 = "itemLayout"
            if (r2 == 0) goto L_0x064e
            net.one97.paytm.passbook.landing.f.a r2 = r0.f57594b
            if (r2 == 0) goto L_0x064c
            android.view.View r0 = r22.getView()
            if (r0 == 0) goto L_0x064a
            int r5 = net.one97.paytm.passbook.R.id.itemsLayout
            android.view.View r0 = r0.findViewById(r5)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            if (r0 == 0) goto L_0x064a
            net.one97.paytm.passbook.landing.e.p r1 = (net.one97.paytm.passbook.landing.e.p) r1
            kotlin.g.b.k.c(r2, r6)
            kotlin.g.b.k.c(r0, r4)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r4 = r2.c()
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r5 = r2.b()
            net.one97.paytm.passbook.landing.e.p.a((net.one97.paytm.passbook.main.widget.PassbookBalanceCardView) r4, (net.one97.paytm.passbook.main.widget.PassbookBalanceCardView) r5)
            net.one97.paytm.passbook.mapping.a.f<net.one97.paytm.passbook.beans.CJRPaytmMoneyInfoV2> r4 = r1.f57671a
            net.one97.paytm.passbook.mapping.a.j r4 = r4.f57886a
            int[] r5 = net.one97.paytm.passbook.landing.e.q.f57686a
            int r4 = r4.ordinal()
            r4 = r5[r4]
            r5 = 1
            if (r4 == r5) goto L_0x0442
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r1 = r2.c()
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r3 = r2.b()
            net.one97.paytm.passbook.landing.e.p.a((net.one97.paytm.passbook.main.widget.PassbookBalanceCardView) r1, (net.one97.paytm.passbook.main.widget.PassbookBalanceCardView) r3)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r1 = r2.c()
            android.view.View r1 = (android.view.View) r1
            r0.removeView(r1)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r1 = r2.b()
            android.view.View r1 = (android.view.View) r1
            r0.removeView(r1)
            net.one97.paytm.passbook.main.widget.InitCards r1 = r2.p()
            android.view.View r1 = (android.view.View) r1
            r0.removeView(r1)
            net.one97.paytm.passbook.main.widget.InitCards r1 = r2.q()
            android.view.View r1 = (android.view.View) r1
            r0.removeView(r1)
            goto L_0x0645
        L_0x0442:
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r4 = r2.c()
            android.content.Context r4 = r4.getContext()
            java.lang.String r5 = "balanceSummaryUIHandler.mMutualFundCard.context"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            boolean r4 = net.one97.paytm.passbook.utility.f.a((android.content.Context) r4)
            if (r4 == 0) goto L_0x0621
            net.one97.paytm.passbook.mapping.a.f<net.one97.paytm.passbook.beans.CJRPaytmMoneyInfoV2> r4 = r1.f57671a
            T r4 = r4.f57887b
            net.one97.paytm.passbook.beans.CJRPaytmMoneyInfoV2 r4 = (net.one97.paytm.passbook.beans.CJRPaytmMoneyInfoV2) r4
            if (r4 == 0) goto L_0x047a
            net.one97.paytm.passbook.beans.DataInfo r4 = r4.getDataInfo()
            if (r4 == 0) goto L_0x047a
            java.lang.Double r4 = r4.getTotalCurrentValue()
            if (r4 == 0) goto L_0x047a
            java.lang.Number r4 = (java.lang.Number) r4
            double r4 = r4.doubleValue()
            r6 = 0
            int r4 = java.lang.Double.compare(r4, r6)
            if (r4 != 0) goto L_0x0478
            goto L_0x047a
        L_0x0478:
            r7 = 0
            goto L_0x047b
        L_0x047a:
            r7 = 1
        L_0x047b:
            net.one97.paytm.passbook.main.widget.InitCards r4 = r2.p()
            net.one97.paytm.passbook.landing.e.p$a r5 = new net.one97.paytm.passbook.landing.e.p$a
            r5.<init>(r1, r2)
            android.view.View$OnClickListener r5 = (android.view.View.OnClickListener) r5
            r4.setOnClickListener(r5)
            net.one97.paytm.passbook.main.widget.InitCards r4 = r2.q()
            net.one97.paytm.passbook.landing.e.p$b r5 = new net.one97.paytm.passbook.landing.e.p$b
            r5.<init>(r1, r2)
            android.view.View$OnClickListener r5 = (android.view.View.OnClickListener) r5
            r4.setOnClickListener(r5)
            if (r7 == 0) goto L_0x04bc
            net.one97.paytm.passbook.main.widget.InitCards r1 = r2.p()
            r3 = 0
            r1.setVisibility(r3)
            net.one97.paytm.passbook.main.widget.InitCards r1 = r2.q()
            r1.setVisibility(r3)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r1 = r2.c()
            android.view.View r1 = (android.view.View) r1
            r0.removeView(r1)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r1 = r2.b()
            android.view.View r1 = (android.view.View) r1
            r0.removeView(r1)
            goto L_0x0645
        L_0x04bc:
            net.one97.paytm.passbook.mapping.a.f<net.one97.paytm.passbook.beans.CJRPaytmMoneyInfoV2> r4 = r1.f57671a
            T r4 = r4.f57887b
            net.one97.paytm.passbook.beans.CJRPaytmMoneyInfoV2 r4 = (net.one97.paytm.passbook.beans.CJRPaytmMoneyInfoV2) r4
            if (r4 == 0) goto L_0x0560
            net.one97.paytm.passbook.beans.DataInfo r5 = r4.getDataInfo()
            if (r5 == 0) goto L_0x0560
            net.one97.paytm.passbook.beans.MFAndNpsItems r5 = r5.getMutualFunds()
            if (r5 == 0) goto L_0x0560
            java.lang.Double r5 = r5.getCurrentValue()
            if (r5 == 0) goto L_0x0560
            java.lang.Number r5 = (java.lang.Number) r5
            double r5 = r5.doubleValue()
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r7 = r2.c()
            int r8 = net.one97.paytm.passbook.R.id.tvTitle
            android.view.View r7 = r7.findViewById(r8)
            androidx.appcompat.widget.AppCompatTextView r7 = (androidx.appcompat.widget.AppCompatTextView) r7
            int r8 = net.one97.paytm.passbook.R.string.pass_mutual_funds
            r7.setText(r8)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r7 = r2.c()
            int r8 = net.one97.paytm.passbook.R.drawable.pb_mutual_funnd_new
            r7.setIcon(r8)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r7 = r2.c()
            int r8 = net.one97.paytm.passbook.R.id.tvAmount
            android.view.View r7 = r7.findViewById(r8)
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r3)
            android.widget.TextView r7 = (android.widget.TextView) r7
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r8 = r2.c()
            android.content.Context r8 = r8.getContext()
            int r9 = net.one97.paytm.passbook.R.string.pass_rupee
            r10 = 1
            java.lang.Object[] r11 = new java.lang.Object[r10]
            java.lang.String r5 = net.one97.paytm.passbook.utility.f.b((double) r5)
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r6 = 0
            r11[r6] = r5
            java.lang.String r5 = r8.getString(r9, r11)
            java.lang.String r6 = "balanceSummaryUIHandler.…ountFormat2().toString())"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            net.one97.paytm.passbook.utility.f.a(r7, r5)
            net.one97.paytm.passbook.beans.DataInfo r5 = r4.getDataInfo()
            if (r5 == 0) goto L_0x053a
            net.one97.paytm.passbook.beans.MFAndNpsItems r5 = r5.getMutualFunds()
            if (r5 == 0) goto L_0x053a
            java.lang.String r8 = r5.getDeeplink()
            goto L_0x053b
        L_0x053a:
            r8 = 0
        L_0x053b:
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r5 = r2.c()
            net.one97.paytm.passbook.landing.e.p$c r6 = new net.one97.paytm.passbook.landing.e.p$c
            r7 = r6
            r9 = r1
            r10 = r2
            r11 = r4
            r12 = r0
            r7.<init>(r8, r9, r10, r11, r12)
            android.view.View$OnClickListener r6 = (android.view.View.OnClickListener) r6
            r5.setOnClickListener(r6)
            net.one97.paytm.passbook.main.widget.InitCards r5 = r2.p()
            android.view.View r5 = (android.view.View) r5
            r0.removeView(r5)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r5 = r2.c()
            r6 = 0
            r5.setVisibility(r6)
            goto L_0x0571
        L_0x0560:
            r6 = 0
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r5 = r2.c()
            android.view.View r5 = (android.view.View) r5
            r0.removeView(r5)
            net.one97.paytm.passbook.main.widget.InitCards r5 = r2.p()
            r5.setVisibility(r6)
        L_0x0571:
            if (r4 == 0) goto L_0x060f
            net.one97.paytm.passbook.beans.DataInfo r5 = r4.getDataInfo()
            if (r5 == 0) goto L_0x060f
            net.one97.paytm.passbook.beans.MFAndNpsItems r5 = r5.getNps()
            if (r5 == 0) goto L_0x060f
            java.lang.Double r5 = r5.getCurrentValue()
            if (r5 == 0) goto L_0x060f
            java.lang.Number r5 = (java.lang.Number) r5
            double r5 = r5.doubleValue()
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r7 = r2.b()
            int r8 = net.one97.paytm.passbook.R.id.tvTitle
            android.view.View r7 = r7.findViewById(r8)
            androidx.appcompat.widget.AppCompatTextView r7 = (androidx.appcompat.widget.AppCompatTextView) r7
            int r8 = net.one97.paytm.passbook.R.string.pass_nps
            r7.setText(r8)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r7 = r2.b()
            int r8 = net.one97.paytm.passbook.R.drawable.pb_nps_new
            r7.setIcon(r8)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r7 = r2.b()
            int r8 = net.one97.paytm.passbook.R.id.tvAmount
            android.view.View r7 = r7.findViewById(r8)
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r3)
            android.widget.TextView r7 = (android.widget.TextView) r7
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r3 = r2.b()
            android.content.Context r3 = r3.getContext()
            int r8 = net.one97.paytm.passbook.R.string.pass_rupee
            r9 = 1
            java.lang.Object[] r9 = new java.lang.Object[r9]
            java.lang.String r5 = net.one97.paytm.passbook.utility.f.b((double) r5)
            java.lang.String r5 = java.lang.String.valueOf(r5)
            r6 = 0
            r9[r6] = r5
            java.lang.String r3 = r3.getString(r8, r9)
            java.lang.String r5 = "balanceSummaryUIHandler.…ountFormat2().toString())"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            net.one97.paytm.passbook.utility.f.a(r7, r3)
            net.one97.paytm.passbook.beans.DataInfo r3 = r4.getDataInfo()
            if (r3 == 0) goto L_0x05e9
            net.one97.paytm.passbook.beans.MFAndNpsItems r3 = r3.getNps()
            if (r3 == 0) goto L_0x05e9
            java.lang.String r8 = r3.getDeeplink()
            goto L_0x05ea
        L_0x05e9:
            r8 = 0
        L_0x05ea:
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r3 = r2.b()
            net.one97.paytm.passbook.landing.e.p$d r5 = new net.one97.paytm.passbook.landing.e.p$d
            r7 = r5
            r9 = r1
            r10 = r2
            r11 = r4
            r12 = r0
            r7.<init>(r8, r9, r10, r11, r12)
            android.view.View$OnClickListener r5 = (android.view.View.OnClickListener) r5
            r3.setOnClickListener(r5)
            net.one97.paytm.passbook.main.widget.InitCards r1 = r2.q()
            android.view.View r1 = (android.view.View) r1
            r0.removeView(r1)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r1 = r2.b()
            r3 = 0
            r1.setVisibility(r3)
            goto L_0x0645
        L_0x060f:
            r3 = 0
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r1 = r2.b()
            android.view.View r1 = (android.view.View) r1
            r0.removeView(r1)
            net.one97.paytm.passbook.main.widget.InitCards r1 = r2.q()
            r1.setVisibility(r3)
            goto L_0x0645
        L_0x0621:
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r1 = r2.c()
            android.view.View r1 = (android.view.View) r1
            r0.removeView(r1)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r1 = r2.b()
            android.view.View r1 = (android.view.View) r1
            r0.removeView(r1)
            net.one97.paytm.passbook.main.widget.InitCards r1 = r2.p()
            android.view.View r1 = (android.view.View) r1
            r0.removeView(r1)
            net.one97.paytm.passbook.main.widget.InitCards r1 = r2.q()
            android.view.View r1 = (android.view.View) r1
            r0.removeView(r1)
        L_0x0645:
            r2.b(r0)
            goto L_0x0f8c
        L_0x064a:
            r0 = 0
            return r0
        L_0x064c:
            r0 = 0
            return r0
        L_0x064e:
            boolean r2 = r1 instanceof net.one97.paytm.passbook.landing.e.x
            java.lang.String r5 = "listener"
            if (r2 == 0) goto L_0x07ce
            net.one97.paytm.passbook.landing.f.a r2 = r0.f57594b
            if (r2 == 0) goto L_0x07c9
            android.view.View r3 = r22.getView()
            if (r3 == 0) goto L_0x07c9
            int r7 = net.one97.paytm.passbook.R.id.itemsLayout
            android.view.View r3 = r3.findViewById(r7)
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            if (r3 == 0) goto L_0x07c9
            net.one97.paytm.passbook.landing.e.x r1 = (net.one97.paytm.passbook.landing.e.x) r1
            r7 = r0
            net.one97.paytm.passbook.landing.d.a r7 = (net.one97.paytm.passbook.landing.d.a) r7
            kotlin.g.b.k.c(r2, r6)
            kotlin.g.b.k.c(r3, r4)
            kotlin.g.b.k.c(r7, r5)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r4 = r2.e()
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r5 = r2.f()
            if (r4 == 0) goto L_0x0683
            r4.a()
        L_0x0683:
            if (r5 == 0) goto L_0x0688
            r5.a()
        L_0x0688:
            net.one97.paytm.passbook.mapping.a.f<? extends net.one97.paytm.passbook.beans.CustProductList> r4 = r1.f57698b
            net.one97.paytm.passbook.mapping.a.j r4 = r4.f57886a
            int[] r5 = net.one97.paytm.passbook.landing.e.y.f57703a
            int r4 = r4.ordinal()
            r4 = r5[r4]
            r5 = 1
            if (r4 == r5) goto L_0x06de
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r4 = r2.e()
            android.content.Context r8 = r4.getContext()
            boolean r4 = r8 instanceof android.app.Activity
            if (r4 != 0) goto L_0x06a4
            r8 = 0
        L_0x06a4:
            android.app.Activity r8 = (android.app.Activity) r8
            net.one97.paytm.passbook.mapping.a.f<? extends net.one97.paytm.passbook.beans.CustProductList> r4 = r1.f57698b
            net.one97.paytm.passbook.mapping.a.d<? extends T> r4 = r4.f57888c
            if (r4 == 0) goto L_0x06b1
            com.paytm.network.model.NetworkCustomError r4 = r4.f57879a
            r18 = r4
            goto L_0x06b3
        L_0x06b1:
            r18 = 0
        L_0x06b3:
            r4 = r18
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            java.lang.Class r1 = r1.getClass()
            r1.getName()
            net.one97.paytm.passbook.utility.j.a((android.app.Activity) r8, (java.lang.Throwable) r4)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r1 = r2.e()
            android.view.View r1 = (android.view.View) r1
            r3.removeView(r1)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r1 = r2.f()
            android.view.View r1 = (android.view.View) r1
            r3.removeView(r1)
            net.one97.paytm.passbook.main.widget.InitCards r1 = r2.r()
            android.view.View r1 = (android.view.View) r1
            r3.removeView(r1)
            goto L_0x07c6
        L_0x06de:
            net.one97.paytm.passbook.mapping.a.f<? extends net.one97.paytm.passbook.beans.CustProductList> r4 = r1.f57698b
            T r4 = r4.f57887b
            net.one97.paytm.passbook.beans.CustProductList r4 = (net.one97.paytm.passbook.beans.CustProductList) r4
            if (r4 == 0) goto L_0x06eb
            java.lang.String r8 = r4.getErrorMessage()
            goto L_0x06ec
        L_0x06eb:
            r8 = 0
        L_0x06ec:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r5 = android.text.TextUtils.isEmpty(r8)
            if (r5 == 0) goto L_0x070d
            if (r4 == 0) goto L_0x06fb
            java.lang.String r8 = r4.getIsaStatus()
            goto L_0x06fc
        L_0x06fb:
            r8 = 0
        L_0x06fc:
            java.lang.String r5 = "ISSUED"
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.Object) r8)
            if (r5 == 0) goto L_0x070b
            java.lang.String r5 = r4.getIsaAccNum()
            r1.f57697a = r5
            goto L_0x070d
        L_0x070b:
            r5 = 1
            goto L_0x070e
        L_0x070d:
            r5 = 0
        L_0x070e:
            if (r5 == 0) goto L_0x073a
            net.one97.paytm.passbook.main.widget.InitCards r5 = r2.r()
            r6 = 0
            r5.setVisibility(r6)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r5 = r2.e()
            android.view.View r5 = (android.view.View) r5
            r3.removeView(r5)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r5 = r2.f()
            android.view.View r5 = (android.view.View) r5
            r3.removeView(r5)
            net.one97.paytm.passbook.main.widget.InitCards r5 = r2.r()
            net.one97.paytm.passbook.landing.e.x$a r6 = new net.one97.paytm.passbook.landing.e.x$a
            r6.<init>(r1, r4)
            android.view.View$OnClickListener r6 = (android.view.View.OnClickListener) r6
            r5.setOnClickListener(r6)
            goto L_0x07c6
        L_0x073a:
            net.one97.paytm.passbook.main.widget.InitCards r4 = r2.r()
            android.view.View r4 = (android.view.View) r4
            r3.removeView(r4)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r4 = r2.e()
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r5 = r2.f()
            java.lang.String r1 = r1.f57697a
            r6 = 0
            r4.setVisibility(r6)
            android.content.Context r6 = r4.getContext()
            int r8 = net.one97.paytm.passbook.R.string.pass_paytm_bank
            java.lang.String r6 = r6.getString(r8)
            if (r1 == 0) goto L_0x0775
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r6)
            java.lang.String r6 = " XX "
            r8.append(r6)
            java.lang.String r1 = kotlin.m.p.h((java.lang.String) r1)
            r8.append(r1)
            java.lang.String r6 = r8.toString()
        L_0x0775:
            java.lang.String r1 = "title"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r1)
            r4.setTitle((java.lang.String) r6)
            int r1 = net.one97.paytm.passbook.R.drawable.pb_paytm_bank_new
            r4.setIcon(r1)
            int r1 = net.one97.paytm.passbook.R.string.fd_fixed_deposits
            r5.setTitle((int) r1)
            r1 = 1
            r4.a((boolean) r1)
            r5.a((boolean) r1)
            r1 = 0
            r4.b(r1)
            r5.b(r1)
            int r1 = net.one97.paytm.passbook.R.drawable.pb_fb_new
            r5.setIcon(r1)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r1 = r2.e()
            int r4 = net.one97.paytm.passbook.R.id.tvCheckBalance
            android.view.View r1 = r1.a((int) r4)
            androidx.appcompat.widget.AppCompatTextView r1 = (androidx.appcompat.widget.AppCompatTextView) r1
            net.one97.paytm.passbook.landing.e.x$b r4 = new net.one97.paytm.passbook.landing.e.x$b
            r4.<init>(r7)
            android.view.View$OnClickListener r4 = (android.view.View.OnClickListener) r4
            r1.setOnClickListener(r4)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r1 = r2.f()
            int r4 = net.one97.paytm.passbook.R.id.tvCheckBalance
            android.view.View r1 = r1.a((int) r4)
            androidx.appcompat.widget.AppCompatTextView r1 = (androidx.appcompat.widget.AppCompatTextView) r1
            net.one97.paytm.passbook.landing.e.x$c r4 = new net.one97.paytm.passbook.landing.e.x$c
            r4.<init>(r7)
            android.view.View$OnClickListener r4 = (android.view.View.OnClickListener) r4
            r1.setOnClickListener(r4)
        L_0x07c6:
            r2.b(r3)
        L_0x07c9:
            r22.c()
            goto L_0x0f8c
        L_0x07ce:
            boolean r2 = r1 instanceof net.one97.paytm.passbook.landing.e.v
            if (r2 == 0) goto L_0x0889
            net.one97.paytm.passbook.landing.f.a r2 = r0.f57594b
            if (r2 == 0) goto L_0x0887
            android.view.View r0 = r22.getView()
            if (r0 == 0) goto L_0x0885
            int r3 = net.one97.paytm.passbook.R.id.itemsLayout
            android.view.View r0 = r0.findViewById(r3)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            if (r0 == 0) goto L_0x0885
            net.one97.paytm.passbook.landing.e.v r1 = (net.one97.paytm.passbook.landing.e.v) r1
            kotlin.g.b.k.c(r2, r6)
            kotlin.g.b.k.c(r0, r4)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r2.e()
            r0.a()
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r2.f()
            r0.a()
            net.one97.paytm.passbook.mapping.a.f<? extends net.one97.paytm.passbook.beans.CJRAccountSummary> r0 = r1.f57695a
            net.one97.paytm.passbook.mapping.a.j r0 = r0.f57886a
            int[] r3 = net.one97.paytm.passbook.landing.e.w.f57696a
            int r0 = r0.ordinal()
            r0 = r3[r0]
            r3 = 1
            if (r0 == r3) goto L_0x081a
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r2.e()
            net.one97.paytm.passbook.landing.e.v.b(r0)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r2.f()
            net.one97.paytm.passbook.landing.e.v.b(r0)
            goto L_0x0882
        L_0x081a:
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r2.e()
            net.one97.paytm.passbook.landing.e.v.a(r0)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r2.f()
            net.one97.paytm.passbook.landing.e.v.a(r0)
            net.one97.paytm.passbook.mapping.a.f<? extends net.one97.paytm.passbook.beans.CJRAccountSummary> r0 = r1.f57695a
            T r0 = r0.f57887b
            net.one97.paytm.passbook.beans.CJRAccountSummary r0 = (net.one97.paytm.passbook.beans.CJRAccountSummary) r0
            if (r0 == 0) goto L_0x0849
            java.lang.String r0 = r0.getmTotalBalance()
            if (r0 == 0) goto L_0x0849
            java.lang.Double r0 = kotlin.m.p.b(r0)
            if (r0 == 0) goto L_0x0849
            java.lang.Number r0 = (java.lang.Number) r0
            double r3 = r0.doubleValue()
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r2.e()
            r0.setAmount((double) r3)
        L_0x0849:
            net.one97.paytm.passbook.mapping.a.f<? extends net.one97.paytm.passbook.beans.CJRAccountSummary> r0 = r1.f57695a
            T r0 = r0.f57887b
            net.one97.paytm.passbook.beans.CJRAccountSummary r0 = (net.one97.paytm.passbook.beans.CJRAccountSummary) r0
            if (r0 == 0) goto L_0x0882
            double r0 = r0.getSlfdBalance()
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r3 = r2.f()
            r3.setAmount((double) r0)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r2.f()
            int r1 = net.one97.paytm.passbook.R.id.tvAmountDesc
            android.view.View r0 = r0.findViewById(r1)
            androidx.appcompat.widget.AppCompatTextView r0 = (androidx.appcompat.widget.AppCompatTextView) r0
            int r1 = net.one97.paytm.passbook.R.string.pass_fd_invested_amt
            r0.setText(r1)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r2.f()
            int r1 = net.one97.paytm.passbook.R.id.tvAmountDesc
            android.view.View r0 = r0.findViewById(r1)
            java.lang.String r1 = "balanceSummaryUIHandler.…tView>(R.id.tvAmountDesc)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            androidx.appcompat.widget.AppCompatTextView r0 = (androidx.appcompat.widget.AppCompatTextView) r0
            r1 = 0
            r0.setVisibility(r1)
        L_0x0882:
            kotlin.x r0 = kotlin.x.f47997a
            return r0
        L_0x0885:
            r0 = 0
            return r0
        L_0x0887:
            r0 = 0
            return r0
        L_0x0889:
            boolean r2 = r1 instanceof net.one97.paytm.passbook.landing.e.l
            if (r2 == 0) goto L_0x0a07
            net.one97.paytm.passbook.landing.f.a r2 = r0.f57594b
            if (r2 == 0) goto L_0x0a02
            android.view.View r3 = r22.getView()
            if (r3 == 0) goto L_0x0a02
            int r7 = net.one97.paytm.passbook.R.id.itemsLayout
            android.view.View r3 = r3.findViewById(r7)
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            if (r3 == 0) goto L_0x0a02
            net.one97.paytm.passbook.landing.e.l r1 = (net.one97.paytm.passbook.landing.e.l) r1
            r7 = r0
            net.one97.paytm.passbook.landing.d.a r7 = (net.one97.paytm.passbook.landing.d.a) r7
            kotlin.g.b.k.c(r2, r6)
            kotlin.g.b.k.c(r3, r4)
            kotlin.g.b.k.c(r7, r5)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r4 = r2.g()
            if (r4 == 0) goto L_0x08b8
            r4.a()
        L_0x08b8:
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r4 = r2.h()
            if (r4 == 0) goto L_0x08c1
            r4.a()
        L_0x08c1:
            net.one97.paytm.passbook.mapping.a.f<? extends net.one97.paytm.passbook.beans.CustProductList> r4 = r1.f57664a
            net.one97.paytm.passbook.mapping.a.j r4 = r4.f57886a
            int[] r5 = net.one97.paytm.passbook.landing.e.m.f57667a
            int r4 = r4.ordinal()
            r4 = r5[r4]
            r5 = 1
            if (r4 == r5) goto L_0x08e7
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r1 = r2.g()
            android.view.View r1 = (android.view.View) r1
            r3.removeView(r1)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r1 = r2.h()
            android.view.View r1 = (android.view.View) r1
            r3.removeView(r1)
            r2.b(r3)
            goto L_0x0a02
        L_0x08e7:
            net.one97.paytm.passbook.mapping.a.f<? extends net.one97.paytm.passbook.beans.CustProductList> r1 = r1.f57664a
            T r1 = r1.f57887b
            net.one97.paytm.passbook.beans.CustProductList r1 = (net.one97.paytm.passbook.beans.CustProductList) r1
            if (r1 == 0) goto L_0x08f4
            java.lang.String r8 = r1.getErrorMessage()
            goto L_0x08f5
        L_0x08f4:
            r8 = 0
        L_0x08f5:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r4 = android.text.TextUtils.isEmpty(r8)
            if (r4 == 0) goto L_0x09c1
            if (r1 == 0) goto L_0x0904
            java.lang.String r8 = r1.getICAStatus()
            goto L_0x0905
        L_0x0904:
            r8 = 0
        L_0x0905:
            java.lang.String r1 = "ISSUED"
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r8)
            if (r1 == 0) goto L_0x09c1
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r1 = r2.g()
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r3 = r2.h()
            r4 = 0
            r1.setVisibility(r4)
            r3.setVisibility(r4)
            android.view.View r4 = r1.getMView()
            int r5 = net.one97.paytm.passbook.R.id.tvTitle
            android.view.View r4 = r4.findViewById(r5)
            androidx.appcompat.widget.AppCompatTextView r4 = (androidx.appcompat.widget.AppCompatTextView) r4
            java.lang.String r5 = "currentAccountCard.mView.tvTitle"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            android.content.Context r5 = r1.getContext()
            int r6 = net.one97.paytm.passbook.R.string.passbook_paytm_bank_current_account
            java.lang.String r5 = r5.getString(r6)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r4.setText(r5)
            android.view.View r4 = r3.getMView()
            int r5 = net.one97.paytm.passbook.R.id.tvTitle
            android.view.View r4 = r4.findViewById(r5)
            androidx.appcompat.widget.AppCompatTextView r4 = (androidx.appcompat.widget.AppCompatTextView) r4
            java.lang.String r5 = "fdCurrentAccountCard.mView.tvTitle"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            android.content.Context r5 = r3.getContext()
            int r6 = net.one97.paytm.passbook.R.string.pass_fd_fixed_deposits_ica
            java.lang.String r5 = r5.getString(r6)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r4.setText(r5)
            android.view.View r4 = r1.getMView()
            int r5 = net.one97.paytm.passbook.R.id.tvAmount
            android.view.View r4 = r4.findViewById(r5)
            androidx.appcompat.widget.AppCompatTextView r4 = (androidx.appcompat.widget.AppCompatTextView) r4
            java.lang.String r5 = "currentAccountCard.mView.tvAmount"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            r5 = 8
            r4.setVisibility(r5)
            android.view.View r4 = r3.getMView()
            int r6 = net.one97.paytm.passbook.R.id.tvAmount
            android.view.View r4 = r4.findViewById(r6)
            androidx.appcompat.widget.AppCompatTextView r4 = (androidx.appcompat.widget.AppCompatTextView) r4
            java.lang.String r6 = "fdCurrentAccountCard.mView.tvAmount"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            r4.setVisibility(r5)
            android.view.View r1 = r1.getMView()
            int r4 = net.one97.paytm.passbook.R.id.tvCheckBalance
            android.view.View r1 = r1.findViewById(r4)
            androidx.appcompat.widget.AppCompatTextView r1 = (androidx.appcompat.widget.AppCompatTextView) r1
            java.lang.String r4 = "currentAccountCard.mView.tvCheckBalance"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            r4 = 0
            r1.setVisibility(r4)
            android.view.View r1 = r3.getMView()
            int r5 = net.one97.paytm.passbook.R.id.tvCheckBalance
            android.view.View r1 = r1.findViewById(r5)
            androidx.appcompat.widget.AppCompatTextView r1 = (androidx.appcompat.widget.AppCompatTextView) r1
            java.lang.String r5 = "fdCurrentAccountCard.mView.tvCheckBalance"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            r1.setVisibility(r4)
            android.view.View r1 = r3.getMView()
            int r3 = net.one97.paytm.passbook.R.id.ivWalletIcon
            android.view.View r1 = r1.findViewById(r3)
            androidx.appcompat.widget.AppCompatImageView r1 = (androidx.appcompat.widget.AppCompatImageView) r1
            int r3 = net.one97.paytm.passbook.R.drawable.pb_fb_new
            r1.setImageResource(r3)
            goto L_0x09d6
        L_0x09c1:
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r1 = r2.g()
            android.view.View r1 = (android.view.View) r1
            r3.removeView(r1)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r1 = r2.h()
            android.view.View r1 = (android.view.View) r1
            r3.removeView(r1)
            r2.b(r3)
        L_0x09d6:
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r1 = r2.g()
            int r3 = net.one97.paytm.passbook.R.id.tvCheckBalance
            android.view.View r1 = r1.a((int) r3)
            androidx.appcompat.widget.AppCompatTextView r1 = (androidx.appcompat.widget.AppCompatTextView) r1
            net.one97.paytm.passbook.landing.e.l$a r3 = new net.one97.paytm.passbook.landing.e.l$a
            r3.<init>(r7)
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r1.setOnClickListener(r3)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r1 = r2.h()
            int r2 = net.one97.paytm.passbook.R.id.tvCheckBalance
            android.view.View r1 = r1.a((int) r2)
            androidx.appcompat.widget.AppCompatTextView r1 = (androidx.appcompat.widget.AppCompatTextView) r1
            net.one97.paytm.passbook.landing.e.l$b r2 = new net.one97.paytm.passbook.landing.e.l$b
            r2.<init>(r7)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r1.setOnClickListener(r2)
        L_0x0a02:
            r22.c()
            goto L_0x0f8c
        L_0x0a07:
            boolean r2 = r1 instanceof net.one97.paytm.passbook.landing.e.j
            if (r2 == 0) goto L_0x0a8f
            net.one97.paytm.passbook.landing.f.a r0 = r0.f57594b
            if (r0 == 0) goto L_0x0a8d
            net.one97.paytm.passbook.landing.e.j r1 = (net.one97.paytm.passbook.landing.e.j) r1
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r2 = r0.g()
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r0.h()
            java.lang.String r3 = "currentAccountCard"
            kotlin.g.b.k.c(r2, r3)
            java.lang.String r3 = "fdCurrentAccountCard"
            kotlin.g.b.k.c(r0, r3)
            r2.a()
            r0.a()
            net.one97.paytm.passbook.mapping.a.f<? extends net.one97.paytm.passbook.beans.CJRAccountSummary> r3 = r1.f57662a
            net.one97.paytm.passbook.mapping.a.j r3 = r3.f57886a
            int[] r4 = net.one97.paytm.passbook.landing.e.k.f57663a
            int r3 = r3.ordinal()
            r3 = r4[r3]
            r4 = 1
            if (r3 == r4) goto L_0x0a39
            goto L_0x0a8a
        L_0x0a39:
            net.one97.paytm.passbook.landing.e.j.a(r2)
            net.one97.paytm.passbook.landing.e.j.a(r0)
            int r3 = net.one97.paytm.passbook.R.id.tvAmount
            android.view.View r2 = r2.a((int) r3)
            androidx.appcompat.widget.AppCompatTextView r2 = (androidx.appcompat.widget.AppCompatTextView) r2
            java.lang.String r3 = "currentAccountCard.tvAmount"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            net.one97.paytm.passbook.mapping.a.f<? extends net.one97.paytm.passbook.beans.CJRAccountSummary> r3 = r1.f57662a
            T r3 = r3.f57887b
            net.one97.paytm.passbook.beans.CJRAccountSummary r3 = (net.one97.paytm.passbook.beans.CJRAccountSummary) r3
            if (r3 == 0) goto L_0x0a59
            java.lang.String r8 = r3.getmTotalBalance()
            goto L_0x0a5a
        L_0x0a59:
            r8 = 0
        L_0x0a5a:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r2.setText(r8)
            int r2 = net.one97.paytm.passbook.R.id.tvAmount
            android.view.View r0 = r0.a((int) r2)
            androidx.appcompat.widget.AppCompatTextView r0 = (androidx.appcompat.widget.AppCompatTextView) r0
            java.lang.String r2 = "fdCurrentAccountCard.tvAmount"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            net.one97.paytm.passbook.mapping.a.f<? extends net.one97.paytm.passbook.beans.CJRAccountSummary> r1 = r1.f57662a
            T r1 = r1.f57887b
            net.one97.paytm.passbook.beans.CJRAccountSummary r1 = (net.one97.paytm.passbook.beans.CJRAccountSummary) r1
            if (r1 == 0) goto L_0x0a7f
            double r1 = r1.getSlfdBalance()
            java.lang.Double r8 = java.lang.Double.valueOf(r1)
            r18 = r8
            goto L_0x0a81
        L_0x0a7f:
            r18 = 0
        L_0x0a81:
            java.lang.String r1 = java.lang.String.valueOf(r18)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
        L_0x0a8a:
            kotlin.x r0 = kotlin.x.f47997a
            return r0
        L_0x0a8d:
            r0 = 0
            return r0
        L_0x0a8f:
            boolean r2 = r1 instanceof net.one97.paytm.passbook.landing.e.s
            if (r2 == 0) goto L_0x0ab2
            net.one97.paytm.passbook.landing.f.a r2 = r0.f57594b
            if (r2 == 0) goto L_0x0ab0
            android.view.View r0 = r22.getView()
            if (r0 == 0) goto L_0x0aae
            int r3 = net.one97.paytm.passbook.R.id.itemsLayout
            android.view.View r0 = r0.findViewById(r3)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            if (r0 == 0) goto L_0x0aae
            net.one97.paytm.passbook.landing.e.s r1 = (net.one97.paytm.passbook.landing.e.s) r1
            r1.a(r2, r0)
            goto L_0x0f8c
        L_0x0aae:
            r0 = 0
            return r0
        L_0x0ab0:
            r0 = 0
            return r0
        L_0x0ab2:
            boolean r2 = r1 instanceof net.one97.paytm.passbook.landing.e.u
            if (r2 == 0) goto L_0x0aff
            net.one97.paytm.passbook.landing.f.a r1 = r0.f57594b
            if (r1 == 0) goto L_0x0afd
            android.view.View r0 = r22.getView()
            if (r0 == 0) goto L_0x0afb
            int r2 = net.one97.paytm.passbook.R.id.itemsLayout
            android.view.View r0 = r0.findViewById(r2)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            if (r0 == 0) goto L_0x0afb
            kotlin.g.b.k.c(r1, r6)
            kotlin.g.b.k.c(r0, r4)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r2 = r1.i()
            r2.a()
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r2 = r1.i()
            android.view.View r2 = (android.view.View) r2
            r0.removeView(r2)
            r1.b(r0)
            net.one97.paytm.passbook.main.widget.InitCards r0 = r1.s()
            r2 = 0
            r0.setVisibility(r2)
            net.one97.paytm.passbook.main.widget.InitCards r0 = r1.s()
            net.one97.paytm.passbook.landing.e.u$a r2 = new net.one97.paytm.passbook.landing.e.u$a
            r2.<init>(r1)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setOnClickListener(r2)
            goto L_0x0f8c
        L_0x0afb:
            r0 = 0
            return r0
        L_0x0afd:
            r0 = 0
            return r0
        L_0x0aff:
            boolean r2 = r1 instanceof net.one97.paytm.passbook.landing.e.e
            if (r2 == 0) goto L_0x0b29
            net.one97.paytm.passbook.landing.f.a r0 = r0.f57594b
            if (r0 == 0) goto L_0x0b27
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r0.l()
            java.lang.String r1 = "mCashBackVouchersCard"
            kotlin.g.b.k.c(r0, r1)
            r0.a()
            r1 = 0
            r0.setVisibility(r1)
            int r1 = net.one97.paytm.passbook.R.string.pass_cashback_vouchers
            r0.setTitle((int) r1)
            int r1 = net.one97.paytm.passbook.R.drawable.pass_cb_voucher
            r0.setIcon(r1)
            r1 = 1
            r0.a((boolean) r1)
            goto L_0x0f8c
        L_0x0b27:
            r0 = 0
            return r0
        L_0x0b29:
            boolean r2 = r1 instanceof net.one97.paytm.passbook.landing.e.b
            if (r2 == 0) goto L_0x0b5d
            net.one97.paytm.passbook.landing.f.a r0 = r0.f57594b
            if (r0 == 0) goto L_0x0b5b
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r0.o
            java.lang.String r1 = "mBrandRewardPointsCard"
            if (r0 != 0) goto L_0x0b3a
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0b3a:
            kotlin.g.b.k.c(r0, r1)
            r0.a()
            r1 = 0
            r0.setVisibility(r1)
            int r1 = net.one97.paytm.passbook.R.string.pass_brand_reward_points
            r0.setTitle((int) r1)
            int r1 = net.one97.paytm.passbook.R.drawable.pass_brand_vouchers_icon
            r0.setIcon(r1)
            r1 = 1
            r0.a((boolean) r1)
            net.one97.paytm.passbook.landing.e.b$a r1 = net.one97.paytm.passbook.landing.e.b.a.f57637a
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            goto L_0x0f8c
        L_0x0b5b:
            r0 = 0
            return r0
        L_0x0b5d:
            boolean r2 = r1 instanceof net.one97.paytm.passbook.landing.e.r
            if (r2 == 0) goto L_0x0b87
            net.one97.paytm.passbook.landing.f.a r0 = r0.f57594b
            if (r0 == 0) goto L_0x0b85
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r0.m()
            java.lang.String r1 = "mPaytmRewardPoints"
            kotlin.g.b.k.c(r0, r1)
            r0.a()
            r1 = 0
            r0.setVisibility(r1)
            int r1 = net.one97.paytm.passbook.R.string.pass_paytm_first_reward_points
            r0.setTitle((int) r1)
            int r1 = net.one97.paytm.passbook.R.drawable.pass_loyalty_rewards
            r0.setIcon(r1)
            r1 = 1
            r0.a((boolean) r1)
            goto L_0x0f8c
        L_0x0b85:
            r0 = 0
            return r0
        L_0x0b87:
            boolean r2 = r1 instanceof net.one97.paytm.passbook.landing.e.z
            if (r2 == 0) goto L_0x0bc0
            net.one97.paytm.passbook.landing.f.a r0 = r0.f57594b
            if (r0 == 0) goto L_0x0bbe
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r0.p
            if (r0 != 0) goto L_0x0b98
            java.lang.String r1 = "mStickersCard"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0b98:
            java.lang.String r1 = "mStickersCard"
            kotlin.g.b.k.c(r0, r1)
            r0.a()
            r1 = 0
            r0.setVisibility(r1)
            int r1 = net.one97.paytm.passbook.R.string.pass_stickers
            r0.setTitle((int) r1)
            int r1 = net.one97.paytm.passbook.R.drawable.pass_stickers_icon
            r0.setIcon(r1)
            r1 = 1
            r0.a((boolean) r1)
            net.one97.paytm.passbook.landing.e.z$a r1 = new net.one97.paytm.passbook.landing.e.z$a
            r1.<init>(r0)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            goto L_0x0f8c
        L_0x0bbe:
            r0 = 0
            return r0
        L_0x0bc0:
            boolean r2 = r1 instanceof net.one97.paytm.passbook.landing.e.aa
            if (r2 == 0) goto L_0x0be8
            net.one97.paytm.passbook.landing.f.a r2 = r0.f57594b
            if (r2 == 0) goto L_0x0be6
            java.lang.String r3 = "UPIResponseOperation"
            com.paytm.utility.q.b(r3)
            android.view.View r3 = r22.getView()
            if (r3 == 0) goto L_0x0be4
            int r4 = net.one97.paytm.passbook.R.id.itemsLayout
            android.view.View r3 = r3.findViewById(r4)
            android.widget.LinearLayout r3 = (android.widget.LinearLayout) r3
            if (r3 == 0) goto L_0x0be4
            net.one97.paytm.passbook.landing.e.aa r1 = (net.one97.paytm.passbook.landing.e.aa) r1
            r1.a(r2, r3, r0)
            goto L_0x0f8c
        L_0x0be4:
            r0 = 0
            return r0
        L_0x0be6:
            r0 = 0
            return r0
        L_0x0be8:
            boolean r2 = r1 instanceof net.one97.paytm.passbook.landing.e.ac
            r5 = 2
            if (r2 == 0) goto L_0x0d2d
            net.one97.paytm.passbook.landing.f.a r2 = r0.f57594b
            if (r2 == 0) goto L_0x0d2b
            java.lang.String r7 = "UpiHasVPAOperation"
            com.paytm.utility.q.b(r7)
            android.view.View r7 = r22.getView()
            if (r7 == 0) goto L_0x0d29
            int r8 = net.one97.paytm.passbook.R.id.itemsLayout
            android.view.View r7 = r7.findViewById(r8)
            android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
            if (r7 == 0) goto L_0x0d29
            r8 = r1
            net.one97.paytm.passbook.landing.e.ac r8 = (net.one97.paytm.passbook.landing.e.ac) r8
            net.one97.paytm.passbook.landing.c.a$a r9 = new net.one97.paytm.passbook.landing.c.a$a
            r9.<init>(r2, r0, r1)
            net.one97.paytm.passbook.landing.e.ac$a r9 = (net.one97.paytm.passbook.landing.e.ac.a) r9
            kotlin.g.b.k.c(r2, r6)
            kotlin.g.b.k.c(r7, r4)
            java.lang.String r0 = "upiUserCallback"
            kotlin.g.b.k.c(r9, r0)
            net.one97.paytm.passbook.mapping.a.f<net.one97.paytm.passbook.beans.upi.UpiAvailabilityModel> r0 = r8.f57635a
            net.one97.paytm.passbook.mapping.a.j r0 = r0.f57886a
            int[] r1 = net.one97.paytm.passbook.landing.e.ad.f57636a
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            if (r0 == r1) goto L_0x0c4c
            if (r0 == r5) goto L_0x0c2e
            goto L_0x0d1e
        L_0x0c2e:
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r2.j()
            r0.a()
            net.one97.paytm.passbook.main.widget.UPIInitCardV2 r0 = r2.u()
            android.view.View r0 = (android.view.View) r0
            r7.removeView(r0)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r2.j()
            android.view.View r0 = (android.view.View) r0
            r7.removeView(r0)
            r2.b(r7)
            goto L_0x0d1e
        L_0x0c4c:
            net.one97.paytm.passbook.mapping.a.f<net.one97.paytm.passbook.beans.upi.UpiAvailabilityModel> r0 = r8.f57635a
            T r0 = r0.f57887b
            if (r0 == 0) goto L_0x0d21
            net.one97.paytm.passbook.beans.upi.UpiAvailabilityModel r0 = (net.one97.paytm.passbook.beans.upi.UpiAvailabilityModel) r0
            java.lang.String r1 = r0.getStatus()
            java.lang.String r4 = "success"
            r5 = 1
            boolean r1 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r1, (boolean) r5)
            if (r1 == 0) goto L_0x0d1e
            net.one97.paytm.passbook.beans.upi.UpiAvailabilityModel$UpiAvailabilityResponse r0 = r0.getResponse()
            java.lang.String r1 = "upi"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            boolean r0 = r0.isUpiUser()
            net.one97.paytm.passbook.mapping.f r1 = net.one97.paytm.passbook.d.b()
            java.lang.String r4 = "isUpiInPassbookEnabledAndroid"
            java.lang.String r1 = r1.a((java.lang.String) r4)
            boolean r1 = java.lang.Boolean.parseBoolean(r1)
            if (r1 == 0) goto L_0x0d1b
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r1 = r2.j()
            int r4 = net.one97.paytm.passbook.R.string.pass_paytm_upi
            r1.setTitle((int) r4)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r1 = r2.j()
            int r4 = net.one97.paytm.passbook.R.id.ivWalletIcon
            android.view.View r1 = r1.findViewById(r4)
            androidx.appcompat.widget.AppCompatImageView r1 = (androidx.appcompat.widget.AppCompatImageView) r1
            r4 = 6
            r1.setPadding(r4, r4, r4, r4)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r1 = r2.j()
            int r4 = net.one97.paytm.passbook.R.drawable.pass_upi_icon
            r1.setIcon(r4)
            if (r0 == 0) goto L_0x0caf
            net.one97.paytm.passbook.main.widget.UPIInitCardV2 r0 = r2.u()
            android.view.View r0 = (android.view.View) r0
            r7.removeView(r0)
            r9.a()
            goto L_0x0d1b
        L_0x0caf:
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r2.j()
            r0.a()
            boolean r0 = net.one97.paytm.passbook.landing.e.ac.a()
            if (r0 == 0) goto L_0x0d0a
            net.one97.paytm.passbook.main.widget.UPIInitCardV2 r0 = r2.u()
            android.view.View r0 = (android.view.View) r0
            r7.removeView(r0)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r2.j()
            r1 = 0
            r0.setVisibility(r1)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r2.j()
            int r4 = net.one97.paytm.passbook.R.id.tvReactivate
            android.view.View r0 = r0.findViewById(r4)
            java.lang.String r4 = "balanceSummaryUIHandler.…tView>(R.id.tvReactivate)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            androidx.appcompat.widget.AppCompatTextView r0 = (androidx.appcompat.widget.AppCompatTextView) r0
            r0.setVisibility(r1)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r2.j()
            int r1 = net.one97.paytm.passbook.R.id.tvAmount
            android.view.View r0 = r0.findViewById(r1)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            androidx.appcompat.widget.AppCompatTextView r0 = (androidx.appcompat.widget.AppCompatTextView) r0
            r1 = 8
            r0.setVisibility(r1)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r2.j()
            int r3 = net.one97.paytm.passbook.R.id.tvCheckBalance
            android.view.View r0 = r0.findViewById(r3)
            java.lang.String r3 = "balanceSummaryUIHandler.…iew>(R.id.tvCheckBalance)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            androidx.appcompat.widget.AppCompatTextView r0 = (androidx.appcompat.widget.AppCompatTextView) r0
            r0.setVisibility(r1)
            goto L_0x0d1b
        L_0x0d0a:
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r2.j()
            android.view.View r0 = (android.view.View) r0
            r7.removeView(r0)
            net.one97.paytm.passbook.main.widget.UPIInitCardV2 r0 = r2.u()
            r1 = 0
            r0.setVisibility(r1)
        L_0x0d1b:
            r2.b(r7)
        L_0x0d1e:
            kotlin.x r0 = kotlin.x.f47997a
            return r0
        L_0x0d21:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type net.one97.paytm.passbook.beans.upi.UpiAvailabilityModel"
            r0.<init>(r1)
            throw r0
        L_0x0d29:
            r0 = 0
            return r0
        L_0x0d2b:
            r0 = 0
            return r0
        L_0x0d2d:
            boolean r2 = r1 instanceof net.one97.paytm.passbook.landing.e.f
            if (r2 == 0) goto L_0x0e18
            net.one97.paytm.passbook.landing.f.a r2 = r0.f57594b
            if (r2 == 0) goto L_0x0e16
            android.view.View r0 = r22.getView()
            if (r0 == 0) goto L_0x0e14
            int r3 = net.one97.paytm.passbook.R.id.itemsLayout
            android.view.View r0 = r0.findViewById(r3)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            if (r0 == 0) goto L_0x0e14
            net.one97.paytm.passbook.landing.e.f r1 = (net.one97.paytm.passbook.landing.e.f) r1
            kotlin.g.b.k.c(r2, r6)
            kotlin.g.b.k.c(r0, r4)
            net.one97.paytm.passbook.mapping.a.f<? extends net.one97.paytm.passbook.beans.creditcard.CreditCardInfoResponse> r3 = r1.f57656a
            net.one97.paytm.passbook.mapping.a.j r3 = r3.f57886a
            int[] r4 = net.one97.paytm.passbook.landing.e.g.f57657a
            int r3 = r3.ordinal()
            r3 = r4[r3]
            r4 = 1
            if (r3 == r4) goto L_0x0d71
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r1 = r2.k()
            r1.a()
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r1 = r2.k()
            android.view.View r1 = (android.view.View) r1
            r0.removeView(r1)
            r2.b(r0)
            goto L_0x0e11
        L_0x0d71:
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r3 = r2.k()
            r3.a()
            net.one97.paytm.passbook.mapping.a.f<? extends net.one97.paytm.passbook.beans.creditcard.CreditCardInfoResponse> r1 = r1.f57656a
            T r1 = r1.f57887b
            net.one97.paytm.passbook.beans.creditcard.CreditCardInfoResponse r1 = (net.one97.paytm.passbook.beans.creditcard.CreditCardInfoResponse) r1
            if (r1 == 0) goto L_0x0e05
            net.one97.paytm.passbook.beans.creditcard.CreditCardInfoResponse$Response r1 = r1.response
            if (r1 == 0) goto L_0x0df8
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r2.k()
            r3 = 0
            r0.setVisibility(r3)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r2.k()
            java.lang.String r3 = r1.cardName
            java.lang.String r4 = "it.cardName"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            r0.setTitle((java.lang.String) r3)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r2.k()
            int r3 = net.one97.paytm.passbook.R.id.tvWalletSubTitle
            android.view.View r0 = r0.findViewById(r3)
            java.lang.String r3 = "balanceSummaryUIHandler.…w>(R.id.tvWalletSubTitle)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            androidx.appcompat.widget.AppCompatTextView r0 = (androidx.appcompat.widget.AppCompatTextView) r0
            r4 = 0
            r0.setVisibility(r4)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r2.k()
            int r4 = net.one97.paytm.passbook.R.id.tvWalletSubTitle
            android.view.View r0 = r0.findViewById(r4)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            androidx.appcompat.widget.AppCompatTextView r0 = (androidx.appcompat.widget.AppCompatTextView) r0
            java.lang.String r1 = r1.cardNo
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r2.k()
            int r1 = net.one97.paytm.passbook.R.id.tvWalletSubTitle
            android.view.View r0 = r0.findViewById(r1)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            androidx.appcompat.widget.AppCompatTextView r0 = (androidx.appcompat.widget.AppCompatTextView) r0
            r1 = 1093664768(0x41300000, float:11.0)
            r0.setTextSize(r1)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r2.k()
            int r1 = net.one97.paytm.passbook.R.id.tvWalletSubTitle
            android.view.View r0 = r0.findViewById(r1)
            androidx.appcompat.widget.AppCompatTextView r0 = (androidx.appcompat.widget.AppCompatTextView) r0
            java.lang.String r1 = "#506d85"
            int r1 = android.graphics.Color.parseColor(r1)
            r0.setTextColor(r1)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r2.k()
            int r1 = net.one97.paytm.passbook.R.drawable.pass_ic_digital_credit
            r0.setIcon(r1)
            goto L_0x0e11
        L_0x0df8:
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r1 = r2.k()
            android.view.View r1 = (android.view.View) r1
            r0.removeView(r1)
            r2.b(r0)
            goto L_0x0e11
        L_0x0e05:
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r1 = r2.k()
            android.view.View r1 = (android.view.View) r1
            r0.removeView(r1)
            r2.b(r0)
        L_0x0e11:
            kotlin.x r0 = kotlin.x.f47997a
            return r0
        L_0x0e14:
            r0 = 0
            return r0
        L_0x0e16:
            r0 = 0
            return r0
        L_0x0e18:
            boolean r2 = r1 instanceof net.one97.paytm.passbook.landing.e.n
            if (r2 == 0) goto L_0x0eb3
            net.one97.paytm.passbook.landing.f.a r2 = r0.f57594b
            if (r2 == 0) goto L_0x0eb1
            android.view.View r0 = r22.getView()
            if (r0 == 0) goto L_0x0eaf
            int r3 = net.one97.paytm.passbook.R.id.itemsLayout
            android.view.View r0 = r0.findViewById(r3)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            if (r0 == 0) goto L_0x0eaf
            net.one97.paytm.passbook.landing.e.n r1 = (net.one97.paytm.passbook.landing.e.n) r1
            kotlin.g.b.k.c(r2, r6)
            kotlin.g.b.k.c(r0, r4)
            net.one97.paytm.passbook.genericPassbook.b<com.paytm.network.model.IJRPaytmDataModel> r3 = r1.f57668a
            net.one97.paytm.passbook.genericPassbook.c r3 = r3.f57331a
            int[] r4 = net.one97.paytm.passbook.landing.e.o.f57670a
            int r3 = r3.ordinal()
            r3 = r4[r3]
            r4 = 1
            if (r3 == r4) goto L_0x0eac
            if (r3 == r5) goto L_0x0e69
            r1 = 3
            if (r3 == r1) goto L_0x0e4d
            goto L_0x0eac
        L_0x0e4d:
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r1 = r2.n()
            r1.a()
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r1 = r2.n()
            r3 = 0
            net.one97.paytm.passbook.landing.e.n.a(r1, r3)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r1 = r2.n()
            android.view.View r1 = (android.view.View) r1
            r0.removeView(r1)
            r2.b(r0)
            goto L_0x0eac
        L_0x0e69:
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r2.n()
            r0.a()
            net.one97.paytm.passbook.mapping.f r0 = net.one97.paytm.passbook.d.b()
            java.lang.String r3 = "pfg_wallet_total"
            r4 = 1
            boolean r0 = r0.a((java.lang.String) r3, (boolean) r4)
            net.one97.paytm.passbook.genericPassbook.b<com.paytm.network.model.IJRPaytmDataModel> r1 = r1.f57668a
            T r1 = r1.f57332b
            if (r1 == 0) goto L_0x0ea4
            net.one97.paytm.passbook.beans.PFGWalletResponse r1 = (net.one97.paytm.passbook.beans.PFGWalletResponse) r1
            net.one97.paytm.passbook.beans.PFGWalletResponse$PFGWalletBalances r1 = r1.getData()
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r2 = r2.n()
            if (r0 == 0) goto L_0x0e97
            if (r1 != 0) goto L_0x0e92
            kotlin.g.b.k.a()
        L_0x0e92:
            java.lang.String r0 = r1.getTotal_balance()
            goto L_0x0ea0
        L_0x0e97:
            if (r1 != 0) goto L_0x0e9c
            kotlin.g.b.k.a()
        L_0x0e9c:
            java.lang.String r0 = r1.getBonus_balance()
        L_0x0ea0:
            net.one97.paytm.passbook.landing.e.n.a(r2, r0)
            goto L_0x0eac
        L_0x0ea4:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type net.one97.paytm.passbook.beans.PFGWalletResponse"
            r0.<init>(r1)
            throw r0
        L_0x0eac:
            kotlin.x r0 = kotlin.x.f47997a
            return r0
        L_0x0eaf:
            r0 = 0
            return r0
        L_0x0eb1:
            r0 = 0
            return r0
        L_0x0eb3:
            boolean r2 = r1 instanceof net.one97.paytm.passbook.landing.e.h
            if (r2 == 0) goto L_0x0f8c
            net.one97.paytm.passbook.landing.f.a r2 = r0.f57594b
            if (r2 == 0) goto L_0x0f8a
            android.view.View r0 = r22.getView()
            if (r0 == 0) goto L_0x0f88
            int r3 = net.one97.paytm.passbook.R.id.itemsLayout
            android.view.View r0 = r0.findViewById(r3)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            if (r0 == 0) goto L_0x0f88
            net.one97.paytm.passbook.landing.e.h r1 = (net.one97.paytm.passbook.landing.e.h) r1
            kotlin.g.b.k.c(r2, r6)
            kotlin.g.b.k.c(r0, r4)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r3 = r2.o()
            r3.a()
            net.one97.paytm.passbook.mapping.a.f<net.one97.paytm.passbook.beans.goldv2.GoldResponse> r3 = r1.f57658a
            net.one97.paytm.passbook.mapping.a.j r3 = r3.f57886a
            int[] r4 = net.one97.paytm.passbook.landing.e.i.f57661a
            int r3 = r3.ordinal()
            r3 = r4[r3]
            r4 = 1
            if (r3 == r4) goto L_0x0eef
            if (r3 == r5) goto L_0x0eed
            goto L_0x0f68
        L_0x0eed:
            r4 = 0
            goto L_0x0f58
        L_0x0eef:
            net.one97.paytm.passbook.mapping.a.f<net.one97.paytm.passbook.beans.goldv2.GoldResponse> r3 = r1.f57658a
            T r3 = r3.f57887b
            net.one97.paytm.passbook.beans.goldv2.GoldResponse r3 = (net.one97.paytm.passbook.beans.goldv2.GoldResponse) r3
            if (r3 == 0) goto L_0x0f68
            net.one97.paytm.passbook.beans.goldv2.GoldCustomer r3 = r3.getCustomer()
            if (r3 == 0) goto L_0x0f68
            java.lang.Double r3 = r3.getNetWorthInRs()
            if (r3 == 0) goto L_0x0eed
            java.lang.Number r3 = (java.lang.Number) r3
            double r3 = r3.doubleValue()
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0eed
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x0f68
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r5 = r2.o()
            r6 = 0
            r5.setVisibility(r6)
            net.one97.paytm.passbook.main.widget.InitCards r5 = r2.t()
            android.view.View r5 = (android.view.View) r5
            r0.removeView(r5)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r5 = r2.o()
            int r6 = net.one97.paytm.passbook.R.id.tvAmount
            android.view.View r5 = r5.a((int) r6)
            androidx.appcompat.widget.AppCompatTextView r5 = (androidx.appcompat.widget.AppCompatTextView) r5
            java.lang.String r6 = "balanceSummaryUIHandler.mPaytmGoldCard.tvAmount"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            android.widget.TextView r5 = (android.widget.TextView) r5
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r6 = r2.o()
            android.content.Context r6 = r6.getContext()
            int r7 = net.one97.paytm.passbook.R.string.pass_rupee
            r8 = 1
            java.lang.Object[] r8 = new java.lang.Object[r8]
            java.lang.String r3 = net.one97.paytm.passbook.utility.f.b((double) r3)
            r4 = 0
            r8[r4] = r3
            java.lang.String r3 = r6.getString(r7, r8)
            java.lang.String r4 = "balanceSummaryUIHandler.…, amount.amountFormat2())"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            net.one97.paytm.passbook.utility.f.a(r5, r3)
            goto L_0x0f68
        L_0x0f58:
            net.one97.paytm.passbook.main.widget.InitCards r3 = r2.t()
            r3.setVisibility(r4)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r3 = r2.o()
            android.view.View r3 = (android.view.View) r3
            r0.removeView(r3)
        L_0x0f68:
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r3 = r2.o()
            net.one97.paytm.passbook.landing.e.h$a r4 = new net.one97.paytm.passbook.landing.e.h$a
            r4.<init>(r1)
            android.view.View$OnClickListener r4 = (android.view.View.OnClickListener) r4
            r3.setOnClickListener(r4)
            net.one97.paytm.passbook.main.widget.InitCards r3 = r2.t()
            net.one97.paytm.passbook.landing.e.h$b r4 = new net.one97.paytm.passbook.landing.e.h$b
            r4.<init>(r1)
            android.view.View$OnClickListener r4 = (android.view.View.OnClickListener) r4
            r3.setOnClickListener(r4)
            r2.b(r0)
            goto L_0x0f8c
        L_0x0f88:
            r0 = 0
            return r0
        L_0x0f8a:
            r0 = 0
            return r0
        L_0x0f8c:
            kotlin.x r0 = kotlin.x.f47997a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.landing.c.a.a(net.one97.paytm.passbook.landing.c.a, net.one97.paytm.passbook.landing.e.a):kotlin.x");
    }
}
