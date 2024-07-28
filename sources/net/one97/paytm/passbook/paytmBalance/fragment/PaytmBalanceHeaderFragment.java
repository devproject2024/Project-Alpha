package net.one97.paytm.passbook.paytmBalance.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.h;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.paytmBalance.d.a;

public final class PaytmBalanceHeaderFragment extends h {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.passbook.paytmBalance.e.a f58223a;

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.passbook.paytmBalance.d.a f58224b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f58225c;

    public final View a(int i2) {
        if (this.f58225c == null) {
            this.f58225c = new HashMap();
        }
        View view = (View) this.f58225c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f58225c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class a<T> implements z<net.one97.paytm.passbook.landing.e.a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PaytmBalanceHeaderFragment f58226a;

        a(PaytmBalanceHeaderFragment paytmBalanceHeaderFragment) {
            this.f58226a = paytmBalanceHeaderFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.passbook.landing.e.a aVar = (net.one97.paytm.passbook.landing.e.a) obj;
            if (aVar != null) {
                PaytmBalanceHeaderFragment.a(this.f58226a, aVar);
            }
        }
    }

    public static final /* synthetic */ net.one97.paytm.passbook.paytmBalance.d.a a(PaytmBalanceHeaderFragment paytmBalanceHeaderFragment) {
        net.one97.paytm.passbook.paytmBalance.d.a aVar = paytmBalanceHeaderFragment.f58224b;
        if (aVar == null) {
            k.a("mPaytmBalanceUiHandler");
        }
        return aVar;
    }

    public final net.one97.paytm.passbook.paytmBalance.e.a a() {
        net.one97.paytm.passbook.paytmBalance.e.a aVar = this.f58223a;
        if (aVar == null) {
            k.a("mPaytmBalanceViewModel");
        }
        return aVar;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        ai a2 = am.a((Fragment) this).a(net.one97.paytm.passbook.paytmBalance.e.a.class);
        k.a((Object) a2, "ViewModelProviders.of(th…nceViewModel::class.java)");
        this.f58223a = (net.one97.paytm.passbook.paytmBalance.e.a) a2;
        this.f58224b = new net.one97.paytm.passbook.paytmBalance.d.a(this);
        return layoutInflater.inflate(R.layout.fragment_paytm_balance_header, viewGroup, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0154, code lost:
        if (net.one97.paytm.passbook.d.b().c(r0) != false) goto L_0x0138;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0180, code lost:
        r0 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r11, android.os.Bundle r12) {
        /*
            r10 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r11, r0)
            super.onViewCreated(r11, r12)
            net.one97.paytm.passbook.paytmBalance.e.a r11 = r10.f58223a
            java.lang.String r12 = "mPaytmBalanceViewModel"
            if (r11 != 0) goto L_0x0012
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x0012:
            r11.a()
            net.one97.paytm.passbook.paytmBalance.e.a r11 = r10.f58223a
            if (r11 != 0) goto L_0x001c
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x001c:
            androidx.lifecycle.y<net.one97.paytm.passbook.landing.e.a> r11 = r11.f58219a
            r0 = r10
            androidx.lifecycle.q r0 = (androidx.lifecycle.q) r0
            net.one97.paytm.passbook.paytmBalance.fragment.PaytmBalanceHeaderFragment$a r1 = new net.one97.paytm.passbook.paytmBalance.fragment.PaytmBalanceHeaderFragment$a
            r1.<init>(r10)
            androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
            r11.observe(r0, r1)
            net.one97.paytm.passbook.paytmBalance.e.a r11 = r10.f58223a
            if (r11 != 0) goto L_0x0032
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x0032:
            androidx.lifecycle.y<java.lang.Boolean> r11 = r11.f58220b
            net.one97.paytm.passbook.paytmBalance.fragment.PaytmBalanceHeaderFragment$b r12 = new net.one97.paytm.passbook.paytmBalance.fragment.PaytmBalanceHeaderFragment$b
            r12.<init>(r10)
            androidx.lifecycle.z r12 = (androidx.lifecycle.z) r12
            r11.observe(r0, r12)
            net.one97.paytm.passbook.paytmBalance.d.a r11 = r10.f58224b
            java.lang.String r12 = "mPaytmBalanceUiHandler"
            if (r11 != 0) goto L_0x0047
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x0047:
            net.one97.paytm.passbook.paytmBalance.fragment.PaytmBalanceHeaderFragment r0 = r11.f58212c
            android.content.Context r0 = r0.getContext()
            r1 = 0
            if (r0 == 0) goto L_0x005b
            net.one97.paytm.passbook.genericPassbook.d.a.d r2 = new net.one97.paytm.passbook.genericPassbook.d.a.d
            java.lang.String r3 = "it"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            r2.<init>(r0)
            goto L_0x005c
        L_0x005b:
            r2 = r1
        L_0x005c:
            if (r2 != 0) goto L_0x0061
            kotlin.g.b.k.a()
        L_0x0061:
            r11.f58210a = r2
            net.one97.paytm.passbook.paytmBalance.fragment.PaytmBalanceHeaderFragment r0 = r11.f58212c
            r0.getContext()
            java.lang.String r0 = net.one97.paytm.passbook.mapping.c.v()
            java.lang.String r0 = net.one97.paytm.passbook.paytmBalance.d.a.a((java.lang.String) r0)
            r11.f58211b = r0
            net.one97.paytm.passbook.paytmBalance.fragment.PaytmBalanceHeaderFragment r0 = r11.f58212c
            int r2 = net.one97.paytm.passbook.R.id.rl_download_statement
            android.view.View r0 = r0.a((int) r2)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            r2 = r11
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setOnClickListener(r2)
            net.one97.paytm.passbook.paytmBalance.fragment.PaytmBalanceHeaderFragment r0 = r11.f58212c
            int r3 = net.one97.paytm.passbook.R.id.rl_send_money_layout
            android.view.View r0 = r0.a((int) r3)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            r0.setOnClickListener(r2)
            net.one97.paytm.passbook.paytmBalance.fragment.PaytmBalanceHeaderFragment r0 = r11.f58212c
            int r3 = net.one97.paytm.passbook.R.id.rl_add_money_layout
            android.view.View r0 = r0.a((int) r3)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            r0.setOnClickListener(r2)
            net.one97.paytm.passbook.paytmBalance.fragment.PaytmBalanceHeaderFragment r0 = r11.f58212c
            int r3 = net.one97.paytm.passbook.R.id.rl_view_spend_analytics
            android.view.View r0 = r0.a((int) r3)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            r0.setOnClickListener(r2)
            net.one97.paytm.passbook.paytmBalance.fragment.PaytmBalanceHeaderFragment r0 = r11.f58212c
            android.content.Context r0 = r0.getContext()
            net.one97.paytm.passbook.mapping.f r2 = net.one97.paytm.passbook.d.b()
            java.lang.String r2 = r2.k()
            boolean r3 = com.paytm.utility.v.a((java.lang.String) r2)
            r4 = 8
            r5 = 0
            r6 = 1
            if (r3 != 0) goto L_0x01aa
            java.lang.String r3 = "addMoneyPassbookHideUsers"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            kotlin.m.l r3 = new kotlin.m.l
            java.lang.String r7 = ","
            r3.<init>((java.lang.String) r7)
            java.util.List r2 = r3.split(r2, r5)
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L_0x0106
            int r3 = r2.size()
            java.util.ListIterator r3 = r2.listIterator(r3)
        L_0x00e1:
            boolean r7 = r3.hasPrevious()
            if (r7 == 0) goto L_0x0106
            java.lang.Object r7 = r3.previous()
            java.lang.String r7 = (java.lang.String) r7
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            int r7 = r7.length()
            if (r7 != 0) goto L_0x00f7
            r7 = 1
            goto L_0x00f8
        L_0x00f7:
            r7 = 0
        L_0x00f8:
            if (r7 != 0) goto L_0x00e1
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            int r3 = r3.nextIndex()
            int r3 = r3 + r6
            java.util.List r2 = kotlin.a.k.b(r2, (int) r3)
            goto L_0x010a
        L_0x0106:
            kotlin.a.w r2 = kotlin.a.w.INSTANCE
            java.util.List r2 = (java.util.List) r2
        L_0x010a:
            java.util.Collection r2 = (java.util.Collection) r2
            java.lang.String[] r3 = new java.lang.String[r5]
            java.lang.Object[] r2 = r2.toArray(r3)
            if (r2 == 0) goto L_0x01a2
            java.lang.String[] r2 = (java.lang.String[]) r2
            int r3 = r2.length
            r7 = 0
        L_0x0118:
            if (r7 >= r3) goto L_0x0180
            r8 = r2[r7]
            java.lang.String r9 = "no_kyc"
            boolean r9 = kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.Object) r8)
            if (r9 == 0) goto L_0x013a
            net.one97.paytm.passbook.mapping.f r8 = net.one97.paytm.passbook.d.b()
            int r8 = r8.b((android.content.Context) r0)
            if (r8 != 0) goto L_0x017d
            net.one97.paytm.passbook.mapping.f r8 = net.one97.paytm.passbook.d.b()
            boolean r8 = r8.c((android.content.Context) r0)
            if (r8 != 0) goto L_0x017d
        L_0x0138:
            r0 = 1
            goto L_0x0181
        L_0x013a:
            java.lang.String r9 = "min_kyc"
            boolean r9 = kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.Object) r8)
            if (r9 == 0) goto L_0x0157
            net.one97.paytm.passbook.mapping.f r2 = net.one97.paytm.passbook.d.b()
            int r2 = r2.b((android.content.Context) r0)
            if (r2 != 0) goto L_0x0180
            net.one97.paytm.passbook.mapping.f r2 = net.one97.paytm.passbook.d.b()
            boolean r0 = r2.c((android.content.Context) r0)
            if (r0 == 0) goto L_0x0180
            goto L_0x0138
        L_0x0157:
            java.lang.String r9 = "no_kyc_expired"
            boolean r9 = kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.Object) r8)
            if (r9 == 0) goto L_0x016a
            net.one97.paytm.passbook.mapping.f r8 = net.one97.paytm.passbook.d.b()
            int r8 = r8.d((android.content.Context) r0)
            if (r8 != r6) goto L_0x017d
            goto L_0x0138
        L_0x016a:
            java.lang.String r9 = "full_kyc"
            boolean r8 = kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.Object) r8)
            if (r8 == 0) goto L_0x017d
            net.one97.paytm.passbook.mapping.f r8 = net.one97.paytm.passbook.d.b()
            int r8 = r8.b((android.content.Context) r0)
            if (r8 != r6) goto L_0x017d
            goto L_0x0138
        L_0x017d:
            int r7 = r7 + 1
            goto L_0x0118
        L_0x0180:
            r0 = 0
        L_0x0181:
            if (r0 == 0) goto L_0x01aa
            net.one97.paytm.passbook.paytmBalance.fragment.PaytmBalanceHeaderFragment r0 = r11.f58212c
            int r2 = net.one97.paytm.passbook.R.id.rl_add_money_layout
            android.view.View r0 = r0.a((int) r2)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            if (r0 == 0) goto L_0x01aa
            net.one97.paytm.passbook.paytmBalance.fragment.PaytmBalanceHeaderFragment r0 = r11.f58212c
            int r2 = net.one97.paytm.passbook.R.id.rl_add_money_layout
            android.view.View r0 = r0.a((int) r2)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            java.lang.String r2 = "paytmBalanceHeaderFragment.rl_add_money_layout"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            r0.setVisibility(r4)
            goto L_0x01aa
        L_0x01a2:
            kotlin.u r11 = new kotlin.u
            java.lang.String r12 = "null cannot be cast to non-null type kotlin.Array<T>"
            r11.<init>(r12)
            throw r11
        L_0x01aa:
            net.one97.paytm.passbook.mapping.f r0 = net.one97.paytm.passbook.d.b()
            java.lang.String r2 = "isSpendAnalyticsEnabledInPassbook8.6.5"
            boolean r0 = r0.a((java.lang.String) r2, (boolean) r6)
            java.lang.String r2 = "paytmBalanceHeaderFragment.rl_view_spend_analytics"
            if (r0 == 0) goto L_0x01c9
            net.one97.paytm.passbook.paytmBalance.fragment.PaytmBalanceHeaderFragment r11 = r11.f58212c
            int r0 = net.one97.paytm.passbook.R.id.rl_view_spend_analytics
            android.view.View r11 = r11.a((int) r0)
            android.widget.RelativeLayout r11 = (android.widget.RelativeLayout) r11
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r2)
            r11.setVisibility(r5)
            goto L_0x01d9
        L_0x01c9:
            net.one97.paytm.passbook.paytmBalance.fragment.PaytmBalanceHeaderFragment r11 = r11.f58212c
            int r0 = net.one97.paytm.passbook.R.id.rl_view_spend_analytics
            android.view.View r11 = r11.a((int) r0)
            android.widget.RelativeLayout r11 = (android.widget.RelativeLayout) r11
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r2)
            r11.setVisibility(r4)
        L_0x01d9:
            net.one97.paytm.passbook.paytmBalance.d.a r11 = r10.f58224b
            if (r11 != 0) goto L_0x01e0
            kotlin.g.b.k.a((java.lang.String) r12)
        L_0x01e0:
            net.one97.paytm.passbook.paytmBalance.fragment.PaytmBalanceHeaderFragment r12 = r11.f58212c
            androidx.fragment.app.FragmentActivity r12 = r12.getActivity()
            if (r12 == 0) goto L_0x01f4
            android.content.Intent r12 = r12.getIntent()
            if (r12 == 0) goto L_0x01f4
            java.lang.String r0 = "amount"
            java.lang.String r1 = r12.getStringExtra(r0)
        L_0x01f4:
            if (r1 == 0) goto L_0x0225
            double r0 = java.lang.Double.parseDouble(r1)
            java.lang.String r12 = net.one97.paytm.passbook.utility.f.c((double) r0)
            if (r12 == 0) goto L_0x0225
            net.one97.paytm.passbook.paytmBalance.fragment.PaytmBalanceHeaderFragment r0 = r11.f58212c
            int r1 = net.one97.paytm.passbook.R.id.tvPaytmBalanceAmount
            android.view.View r0 = r0.a((int) r1)
            androidx.appcompat.widget.AppCompatTextView r0 = (androidx.appcompat.widget.AppCompatTextView) r0
            java.lang.String r1 = "paytmBalanceHeaderFragment.tvPaytmBalanceAmount"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            net.one97.paytm.passbook.paytmBalance.fragment.PaytmBalanceHeaderFragment r11 = r11.f58212c
            int r1 = net.one97.paytm.passbook.R.string.pass_rupee
            java.lang.Object[] r2 = new java.lang.Object[r6]
            r2[r5] = r12
            java.lang.String r11 = r11.getString(r1, r2)
            java.lang.String r12 = "paytmBalanceHeaderFragme…R.string.pass_rupee, it1)"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r12)
            net.one97.paytm.passbook.utility.f.a(r0, r11)
        L_0x0225:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.paytmBalance.fragment.PaytmBalanceHeaderFragment.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        FragmentActivity activity;
        super.onActivityResult(i2, i3, intent);
        net.one97.paytm.passbook.paytmBalance.d.a aVar = this.f58224b;
        if (aVar == null) {
            k.a("mPaytmBalanceUiHandler");
        }
        if (i2 == 131) {
            if (intent != null && intent.getBooleanExtra("finish_activity", false) && (activity = aVar.f58212c.getActivity()) != null) {
                activity.finish();
            }
        } else if (i2 == 128 || i2 == 127 || i2 == 3) {
            aVar.f58212c.a().a();
        }
    }

    static final class b<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PaytmBalanceHeaderFragment f58227a;

        b(PaytmBalanceHeaderFragment paytmBalanceHeaderFragment) {
            this.f58227a = paytmBalanceHeaderFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.passbook.paytmBalance.d.a a2 = PaytmBalanceHeaderFragment.a(this.f58227a);
            if (a2 != null) {
                net.one97.paytm.passbook.mapping.a.a(a2.f58212c.getContext(), a2.f58212c.getString(R.string.pass_no_connection), a2.f58212c.getString(R.string.no_internet), a2.f58212c.getString(R.string.pass_network_retry_yes), (String) null, false, new a.C1120a(a2), (DialogInterface.OnClickListener) null);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x004a, code lost:
        r0 = r0.getResponse();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.passbook.paytmBalance.fragment.PaytmBalanceHeaderFragment r11, net.one97.paytm.passbook.landing.e.a r12) {
        /*
            boolean r0 = r12 instanceof net.one97.paytm.passbook.paytmBalance.b.a
            if (r0 == 0) goto L_0x017f
            net.one97.paytm.passbook.paytmBalance.b.a r12 = (net.one97.paytm.passbook.paytmBalance.b.a) r12
            java.lang.String r0 = "paytmBalanceHeaderFragment"
            kotlin.g.b.k.c(r11, r0)
            net.one97.paytm.passbook.mapping.a.f<? extends net.one97.paytm.passbook.beans.CJRCashWallet> r0 = r12.f58198a
            T r0 = r0.f57887b
            net.one97.paytm.passbook.beans.CJRCashWallet r0 = (net.one97.paytm.passbook.beans.CJRCashWallet) r0
            if (r0 == 0) goto L_0x017f
            java.lang.String r1 = r0.getStatusCode()
            r2 = 1
            java.lang.String r3 = "200"
            boolean r1 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r1, (boolean) r2)
            if (r1 == 0) goto L_0x017f
            r11.getContext()
            net.one97.paytm.passbook.beans.CJRCashWalletResponse r0 = r0.getResponse()
            java.lang.String r1 = "it.response"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r0 = r0.getWalletGrade()
            net.one97.paytm.passbook.mapping.c.aa(r0)
            int r0 = net.one97.paytm.passbook.R.id.vDivider
            android.view.View r0 = r11.a((int) r0)
            java.lang.String r1 = "paytmBalanceHeaderFragment.vDivider"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r1 = 0
            r0.setVisibility(r1)
            net.one97.paytm.passbook.mapping.a.f<? extends net.one97.paytm.passbook.beans.CJRCashWallet> r0 = r12.f58198a
            T r0 = r0.f57887b
            net.one97.paytm.passbook.beans.CJRCashWallet r0 = (net.one97.paytm.passbook.beans.CJRCashWallet) r0
            if (r0 == 0) goto L_0x0055
            net.one97.paytm.passbook.beans.CJRCashWalletResponse r0 = r0.getResponse()
            if (r0 == 0) goto L_0x0055
            java.util.List r0 = r0.getSubWalletDetailList()
            goto L_0x0056
        L_0x0055:
            r0 = 0
        L_0x0056:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            if (r0 == 0) goto L_0x0108
            r4 = 0
        L_0x005e:
            int r5 = r0.size()
            if (r4 >= r5) goto L_0x0108
            java.lang.Object r5 = r0.get(r4)
            net.one97.paytm.passbook.beans.CJRSubWallet r5 = (net.one97.paytm.passbook.beans.CJRSubWallet) r5
            int r6 = r5.getSubWalletType()
            net.one97.paytm.passbook.utility.n r7 = net.one97.paytm.passbook.utility.n.PAYTM_WALLET
            int r7 = r7.getValue()
            if (r6 == r7) goto L_0x0090
            int r6 = r5.getSubWalletType()
            net.one97.paytm.passbook.utility.n r7 = net.one97.paytm.passbook.utility.n.GIFT_VOUCHER
            int r7 = r7.getValue()
            if (r6 == r7) goto L_0x0090
            int r6 = r5.getSubWalletType()
            net.one97.paytm.passbook.utility.n r7 = net.one97.paytm.passbook.utility.n.TOLL
            int r7 = r7.getValue()
            if (r6 == r7) goto L_0x0090
            r6 = 1
            goto L_0x0091
        L_0x0090:
            r6 = 0
        L_0x0091:
            if (r6 == 0) goto L_0x0102
            net.one97.paytm.passbook.main.entity.MultiSubWallet r6 = new net.one97.paytm.passbook.main.entity.MultiSubWallet
            int r7 = r5.getSubWalletType()
            r6.<init>(r7, r1)
            r7 = r4
        L_0x009d:
            int r8 = r0.size()
            if (r4 >= r8) goto L_0x00ef
            java.lang.Object r8 = r0.get(r4)
            net.one97.paytm.passbook.beans.CJRSubWallet r8 = (net.one97.paytm.passbook.beans.CJRSubWallet) r8
            if (r7 != r4) goto L_0x00ae
        L_0x00ab:
            int r4 = r4 + 1
            goto L_0x009d
        L_0x00ae:
            if (r5 == 0) goto L_0x00ab
            if (r8 == 0) goto L_0x00ab
            java.lang.String r9 = r5.getmIssuerId()
            if (r9 == 0) goto L_0x00ab
            java.lang.String r9 = r8.getmIssuerId()
            if (r9 == 0) goto L_0x00ab
            int r9 = r5.getSubWalletType()
            int r10 = r8.getSubWalletType()
            if (r9 != r10) goto L_0x00ab
            java.lang.String r9 = r5.getmIssuerId()
            java.lang.String r10 = r8.getmIssuerId()
            boolean r9 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r10, (boolean) r2)
            if (r9 == 0) goto L_0x00ab
            java.util.ArrayList r7 = r6.getSubWalletList()
            int r7 = r7.size()
            if (r7 != 0) goto L_0x00ea
            r6.addSubWallet(r5)
            java.lang.String r7 = r5.getIssuerMetadata()
            r6.setIssuerMetadata(r7)
        L_0x00ea:
            r6.addSubWallet(r8)
            r7 = r4
            goto L_0x00ab
        L_0x00ef:
            java.util.ArrayList r4 = r6.getSubWalletList()
            int r4 = r4.size()
            if (r4 != 0) goto L_0x00fd
            r3.add(r5)
            goto L_0x0100
        L_0x00fd:
            r3.add(r6)
        L_0x0100:
            r4 = r7
            goto L_0x0105
        L_0x0102:
            r3.add(r5)
        L_0x0105:
            int r4 = r4 + r2
            goto L_0x005e
        L_0x0108:
            r4 = 0
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r3 = r3.iterator()
        L_0x0113:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x0154
            java.lang.Object r6 = r3.next()
            net.one97.paytm.passbook.beans.CJRSubWallet r6 = (net.one97.paytm.passbook.beans.CJRSubWallet) r6
            net.one97.paytm.passbook.main.entity.MultiSubWallet r7 = new net.one97.paytm.passbook.main.entity.MultiSubWallet
            java.lang.String r8 = "subWallet"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r8)
            int r8 = r6.getSubWalletType()
            r7.<init>(r8)
            r7.addSubWallet(r6)
            int r8 = r6.getSubWalletType()
            net.one97.paytm.passbook.utility.n r9 = net.one97.paytm.passbook.utility.n.LOYALTY_WALLET_TYPE_7
            int r9 = r9.getValue()
            if (r8 == r9) goto L_0x0148
            net.one97.paytm.passbook.utility.n r9 = net.one97.paytm.passbook.utility.n.LOYALTY_WALLET
            int r9 = r9.getValue()
            if (r8 != r9) goto L_0x0146
            goto L_0x0148
        L_0x0146:
            r8 = 0
            goto L_0x0149
        L_0x0148:
            r8 = 1
        L_0x0149:
            if (r8 != 0) goto L_0x0113
            r0.add(r7)
            double r6 = r6.getBalance()
            double r4 = r4 + r6
            goto L_0x0113
        L_0x0154:
            android.content.Context r3 = r11.getContext()
            if (r3 == 0) goto L_0x017c
            int r6 = net.one97.paytm.passbook.R.string.pass_rupee
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r4 = net.one97.paytm.passbook.utility.f.b((double) r4)
            r2[r1] = r4
            java.lang.String r1 = r3.getString(r6, r2)
            if (r1 == 0) goto L_0x017c
            int r2 = net.one97.paytm.passbook.R.id.tvPaytmBalanceAmount
            android.view.View r2 = r11.a((int) r2)
            androidx.appcompat.widget.AppCompatTextView r2 = (androidx.appcompat.widget.AppCompatTextView) r2
            java.lang.String r3 = "paytmBalanceHeaderFragment.tvPaytmBalanceAmount"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            android.widget.TextView r2 = (android.widget.TextView) r2
            net.one97.paytm.passbook.utility.f.a(r2, r1)
        L_0x017c:
            r12.a((net.one97.paytm.passbook.paytmBalance.fragment.PaytmBalanceHeaderFragment) r11, (java.util.ArrayList<net.one97.paytm.passbook.main.entity.MultiSubWallet>) r0)
        L_0x017f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.paytmBalance.fragment.PaytmBalanceHeaderFragment.a(net.one97.paytm.passbook.paytmBalance.fragment.PaytmBalanceHeaderFragment, net.one97.paytm.passbook.landing.e.a):void");
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f58225c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
