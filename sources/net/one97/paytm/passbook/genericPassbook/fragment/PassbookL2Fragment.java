package net.one97.paytm.passbook.genericPassbook.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.business.merchant_payments.common.utility.AppUtility;
import com.google.android.material.appbar.AppBarLayout;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.RoboTextView;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.search.a.a;
import net.one97.paytm.passbook.subWallet.b.f;
import net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity;
import net.one97.paytm.passbook.utility.g;
import net.one97.paytm.passbook.utility.n;

public final class PassbookL2Fragment extends net.one97.paytm.passbook.utility.b implements AppBarLayout.b, net.one97.paytm.passbook.genericPassbook.b.c, a.c {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.passbook.genericPassbook.b.b f57494a;

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.passbook.genericPassbook.a f57495b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f57496c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f57497d;

    /* renamed from: e  reason: collision with root package name */
    public RoboTextView f57498e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f57499f;

    /* renamed from: g  reason: collision with root package name */
    private g f57500g;

    /* renamed from: h  reason: collision with root package name */
    private LinearLayout f57501h;

    /* renamed from: i  reason: collision with root package name */
    private LinearLayout f57502i;
    private TextView j;
    private TextView k;
    private TextView l;
    private ImageView m;
    private AppBarLayout n;
    private Toolbar o;
    /* access modifiers changed from: private */
    public int p;
    /* access modifiers changed from: private */
    public Integer q;
    private String r = "---";
    private HashMap s;

    public final View a(int i2) {
        if (this.s == null) {
            this.s = new HashMap();
        }
        View view = (View) this.s.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.s.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void d() {
        HashMap hashMap = this.s;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        d();
    }

    static final class a<T> implements z<net.one97.paytm.passbook.genericPassbook.b<? extends IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PassbookL2Fragment f57503a;

        a(PassbookL2Fragment passbookL2Fragment) {
            this.f57503a = passbookL2Fragment;
        }

        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v7, types: [java.lang.Throwable] */
        /* JADX WARNING: type inference failed for: r0v9, types: [net.one97.paytm.passbook.beans.CJRSubWallet] */
        /* JADX WARNING: type inference failed for: r0v16 */
        /* JADX WARNING: type inference failed for: r0v17 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r7) {
            /*
                r6 = this;
                net.one97.paytm.passbook.genericPassbook.b r7 = (net.one97.paytm.passbook.genericPassbook.b) r7
                r0 = 0
                if (r7 == 0) goto L_0x0008
                net.one97.paytm.passbook.genericPassbook.c r1 = r7.f57331a
                goto L_0x0009
            L_0x0008:
                r1 = r0
            L_0x0009:
                net.one97.paytm.passbook.genericPassbook.c r2 = net.one97.paytm.passbook.genericPassbook.c.SUCCESS
                if (r1 != r2) goto L_0x008d
                if (r7 == 0) goto L_0x0014
                T r1 = r7.f57332b
                com.paytm.network.model.IJRPaytmDataModel r1 = (com.paytm.network.model.IJRPaytmDataModel) r1
                goto L_0x0015
            L_0x0014:
                r1 = r0
            L_0x0015:
                boolean r1 = r1 instanceof net.one97.paytm.passbook.beans.CJRCashWallet
                if (r1 == 0) goto L_0x006c
                net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment r0 = r6.f57503a
                net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment.b(r0)
                net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment r0 = r6.f57503a
                java.lang.Integer r0 = r0.q
                r1 = 0
                if (r7 == 0) goto L_0x0062
                T r7 = r7.f57332b
                net.one97.paytm.passbook.beans.CJRCashWallet r7 = (net.one97.paytm.passbook.beans.CJRCashWallet) r7
                if (r7 == 0) goto L_0x0062
                net.one97.paytm.passbook.beans.CJRCashWalletResponse r7 = r7.getResponse()
                if (r7 == 0) goto L_0x0062
                java.util.List r7 = r7.getSubWalletDetailList()
                if (r7 == 0) goto L_0x0062
                java.util.Iterator r7 = r7.iterator()
            L_0x003e:
                boolean r3 = r7.hasNext()
                if (r3 == 0) goto L_0x0062
                java.lang.Object r3 = r7.next()
                net.one97.paytm.passbook.beans.CJRSubWallet r3 = (net.one97.paytm.passbook.beans.CJRSubWallet) r3
                java.lang.String r4 = "i"
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
                int r4 = r3.getSubWalletType()
                if (r0 != 0) goto L_0x0056
                goto L_0x003e
            L_0x0056:
                int r5 = r0.intValue()
                if (r4 != r5) goto L_0x003e
                double r3 = r3.getBalance()
                double r1 = r1 + r3
                goto L_0x003e
            L_0x0062:
                net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment r7 = r6.f57503a
                java.lang.String r0 = java.lang.String.valueOf(r1)
                net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment.a((net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment) r7, (java.lang.String) r0)
                goto L_0x00af
            L_0x006c:
                if (r7 == 0) goto L_0x0073
                T r1 = r7.f57332b
                com.paytm.network.model.IJRPaytmDataModel r1 = (com.paytm.network.model.IJRPaytmDataModel) r1
                goto L_0x0074
            L_0x0073:
                r1 = r0
            L_0x0074:
                boolean r1 = r1 instanceof net.one97.paytm.passbook.beans.CJRSubWallet
                if (r1 == 0) goto L_0x00af
                net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment r1 = r6.f57503a
                if (r7 == 0) goto L_0x0081
                T r7 = r7.f57332b
                r0 = r7
                net.one97.paytm.passbook.beans.CJRSubWallet r0 = (net.one97.paytm.passbook.beans.CJRSubWallet) r0
            L_0x0081:
                double r2 = r0.getBalance()
                java.lang.String r7 = java.lang.String.valueOf(r2)
                net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment.a((net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment) r1, (java.lang.String) r7)
                goto L_0x00af
            L_0x008d:
                if (r7 == 0) goto L_0x0092
                net.one97.paytm.passbook.genericPassbook.c r1 = r7.f57331a
                goto L_0x0093
            L_0x0092:
                r1 = r0
            L_0x0093:
                net.one97.paytm.passbook.genericPassbook.c r2 = net.one97.paytm.passbook.genericPassbook.c.ERROR
                if (r1 != r2) goto L_0x00af
                net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment r1 = r6.f57503a
                androidx.fragment.app.FragmentActivity r1 = r1.getActivity()
                android.app.Activity r1 = (android.app.Activity) r1
                if (r7 == 0) goto L_0x00a3
                java.lang.Throwable r0 = r7.f57333c
            L_0x00a3:
                net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment r7 = r6.f57503a
                java.lang.Class r7 = r7.getClass()
                r7.getSimpleName()
                net.one97.paytm.passbook.utility.j.a((android.app.Activity) r1, (java.lang.Throwable) r0)
            L_0x00af:
                net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment r7 = r6.f57503a
                int r0 = net.one97.paytm.passbook.R.id.loader_ll
                android.view.View r7 = r7.a((int) r0)
                android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
                java.lang.String r0 = "loader_ll"
                kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r0)
                r0 = 8
                r7.setVisibility(r0)
                net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment r7 = r6.f57503a
                int r0 = net.one97.paytm.passbook.R.id.wallet_loader
                android.view.View r7 = r7.a((int) r0)
                com.airbnb.lottie.LottieAnimationView r7 = (com.airbnb.lottie.LottieAnimationView) r7
                java.lang.String r0 = "wallet_loader"
                kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r0)
                java.lang.Boolean r0 = java.lang.Boolean.FALSE
                net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment.a((com.airbnb.lottie.LottieAnimationView) r7, (java.lang.Boolean) r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment.a.onChanged(java.lang.Object):void");
        }
    }

    static final class b<T> implements z<net.one97.paytm.passbook.genericPassbook.b<? extends IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PassbookL2Fragment f57504a;

        b(PassbookL2Fragment passbookL2Fragment) {
            this.f57504a = passbookL2Fragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.passbook.genericPassbook.c cVar;
            net.one97.paytm.passbook.genericPassbook.c cVar2;
            net.one97.paytm.passbook.genericPassbook.b bVar = (net.one97.paytm.passbook.genericPassbook.b) obj;
            Throwable th = null;
            if (bVar != null) {
                cVar = bVar.f57331a;
            } else {
                cVar = null;
            }
            if (cVar == net.one97.paytm.passbook.genericPassbook.c.SUCCESS) {
                PassbookL2Fragment.c(this.f57504a).g();
                if (PassbookL2Fragment.c(this.f57504a).j() == 0) {
                    RecyclerView recyclerView = (RecyclerView) this.f57504a.a(R.id.rvPassbookEntries);
                    k.a((Object) recyclerView, "rvPassbookEntries");
                    recyclerView.setVisibility(4);
                    RelativeLayout relativeLayout = (RelativeLayout) this.f57504a.a(R.id.rlNoData);
                    k.a((Object) relativeLayout, "rlNoData");
                    relativeLayout.setVisibility(0);
                    NestedScrollView nestedScrollView = (NestedScrollView) this.f57504a.a(R.id.nsvNoDataLayout);
                    k.a((Object) nestedScrollView, "nsvNoDataLayout");
                    nestedScrollView.setVisibility(0);
                } else {
                    RecyclerView recyclerView2 = (RecyclerView) this.f57504a.a(R.id.rvPassbookEntries);
                    k.a((Object) recyclerView2, "rvPassbookEntries");
                    recyclerView2.setVisibility(0);
                    RelativeLayout relativeLayout2 = (RelativeLayout) this.f57504a.a(R.id.rlNoData);
                    k.a((Object) relativeLayout2, "rlNoData");
                    relativeLayout2.setVisibility(4);
                    NestedScrollView nestedScrollView2 = (NestedScrollView) this.f57504a.a(R.id.nsvNoDataLayout);
                    k.a((Object) nestedScrollView2, "nsvNoDataLayout");
                    nestedScrollView2.setVisibility(8);
                }
            } else {
                if (bVar != null) {
                    cVar2 = bVar.f57331a;
                } else {
                    cVar2 = null;
                }
                if (cVar2 == net.one97.paytm.passbook.genericPassbook.c.ERROR) {
                    net.one97.paytm.passbook.genericPassbook.b.b c2 = PassbookL2Fragment.c(this.f57504a);
                    if (bVar != null) {
                        th = bVar.f57333c;
                    }
                    c2.a(th);
                }
            }
            PassbookL2Fragment.g(this.f57504a);
            PassbookL2Fragment.h(this.f57504a);
        }
    }

    public static final /* synthetic */ net.one97.paytm.passbook.genericPassbook.a b(PassbookL2Fragment passbookL2Fragment) {
        net.one97.paytm.passbook.genericPassbook.a aVar = passbookL2Fragment.f57495b;
        if (aVar == null) {
            k.a("mL2EventHandler");
        }
        return aVar;
    }

    public static final /* synthetic */ net.one97.paytm.passbook.genericPassbook.b.b c(PassbookL2Fragment passbookL2Fragment) {
        net.one97.paytm.passbook.genericPassbook.b.b bVar = passbookL2Fragment.f57494a;
        if (bVar == null) {
            k.a("mDataModel");
        }
        return bVar;
    }

    public static final /* synthetic */ ImageView e(PassbookL2Fragment passbookL2Fragment) {
        ImageView imageView = passbookL2Fragment.m;
        if (imageView == null) {
            k.a("mFilterActiveImv");
        }
        return imageView;
    }

    public static final /* synthetic */ TextView f(PassbookL2Fragment passbookL2Fragment) {
        TextView textView = passbookL2Fragment.l;
        if (textView == null) {
            k.a("mFilterTitleTv");
        }
        return textView;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0017, code lost:
        r5 = r5.getIntent();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.LayoutInflater r4, android.view.ViewGroup r5, android.os.Bundle r6) {
        /*
            r3 = this;
            java.lang.String r6 = "inflater"
            kotlin.g.b.k.c(r4, r6)
            int r6 = net.one97.paytm.passbook.R.layout.pass_fragment_passbook_l2
            r0 = 0
            android.view.View r4 = r4.inflate(r6, r5, r0)
            java.lang.String r5 = "view"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            androidx.fragment.app.FragmentActivity r5 = r3.getActivity()
            if (r5 == 0) goto L_0x002a
            android.content.Intent r5 = r5.getIntent()
            if (r5 == 0) goto L_0x002a
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            java.lang.String r1 = "passbook_type"
            int r5 = r5.getIntExtra(r1, r6)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            goto L_0x002b
        L_0x002a:
            r5 = 0
        L_0x002b:
            r3.q = r5
            int r5 = net.one97.paytm.passbook.R.id.appbar
            android.view.View r5 = r4.findViewById(r5)
            java.lang.String r6 = "view.findViewById(R.id.appbar)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            com.google.android.material.appbar.AppBarLayout r5 = (com.google.android.material.appbar.AppBarLayout) r5
            r3.n = r5
            com.google.android.material.appbar.AppBarLayout r5 = r3.n
            if (r5 != 0) goto L_0x0045
            java.lang.String r6 = "appBarLayout"
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x0045:
            r6 = r3
            com.google.android.material.appbar.AppBarLayout$b r6 = (com.google.android.material.appbar.AppBarLayout.b) r6
            r5.a((com.google.android.material.appbar.AppBarLayout.b) r6)
            int r5 = net.one97.paytm.passbook.R.id.ll_toolbar_balance
            android.view.View r5 = r4.findViewById(r5)
            java.lang.String r6 = "view.findViewById(R.id.ll_toolbar_balance)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            r3.f57501h = r5
            int r5 = net.one97.paytm.passbook.R.id.ll_toolbar_header
            android.view.View r5 = r4.findViewById(r5)
            java.lang.String r6 = "view.findViewById(R.id.ll_toolbar_header)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            r3.f57502i = r5
            int r5 = net.one97.paytm.passbook.R.id.tv_wallet_balance
            android.view.View r5 = r4.findViewById(r5)
            java.lang.String r6 = "view.findViewById(R.id.tv_wallet_balance)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r3.j = r5
            int r5 = net.one97.paytm.passbook.R.id.wallet_filter_text
            android.view.View r5 = r4.findViewById(r5)
            java.lang.String r6 = "view.findViewById(R.id.wallet_filter_text)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            com.paytm.utility.RoboTextView r5 = (com.paytm.utility.RoboTextView) r5
            r3.f57498e = r5
            int r5 = net.one97.paytm.passbook.R.id.toolbar
            android.view.View r5 = r4.findViewById(r5)
            java.lang.String r6 = "view.findViewById(R.id.toolbar)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            androidx.appcompat.widget.Toolbar r5 = (androidx.appcompat.widget.Toolbar) r5
            r3.o = r5
            int r5 = net.one97.paytm.passbook.R.id.toolbar_title
            android.view.View r5 = r4.findViewById(r5)
            java.lang.String r6 = "view.findViewById(R.id.toolbar_title)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r3.k = r5
            int r5 = net.one97.paytm.passbook.R.id.toolbar_header_title
            android.view.View r5 = r4.findViewById(r5)
            java.lang.String r6 = "view.findViewById(R.id.toolbar_header_title)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r3.f57496c = r5
            int r5 = net.one97.paytm.passbook.R.id.logo
            android.view.View r5 = r4.findViewById(r5)
            java.lang.String r6 = "view.findViewById(R.id.logo)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r3.f57497d = r5
            int r5 = net.one97.paytm.passbook.R.id.filter_title_tv
            android.view.View r5 = r4.findViewById(r5)
            java.lang.String r6 = "view.findViewById(R.id.filter_title_tv)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r3.l = r5
            int r5 = net.one97.paytm.passbook.R.id.active_imv
            android.view.View r5 = r4.findViewById(r5)
            java.lang.String r6 = "view.findViewById(R.id.active_imv)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r3.m = r5
            int r5 = net.one97.paytm.passbook.R.id.balanceTitleTv
            android.view.View r5 = r4.findViewById(r5)
            java.lang.String r6 = "view.findViewById(R.id.balanceTitleTv)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r3.f57499f = r5
            androidx.fragment.app.FragmentActivity r5 = r3.getActivity()
            java.lang.String r6 = "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity"
            if (r5 == 0) goto L_0x0158
            androidx.appcompat.app.AppCompatActivity r5 = (androidx.appcompat.app.AppCompatActivity) r5
            androidx.appcompat.widget.Toolbar r1 = r3.o
            java.lang.String r2 = "mToolbar"
            if (r1 != 0) goto L_0x0103
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0103:
            r5.setSupportActionBar(r1)
            androidx.appcompat.widget.Toolbar r5 = r3.o
            if (r5 != 0) goto L_0x010d
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x010d:
            int r1 = net.one97.paytm.common.widgets.R.drawable.back_arrow
            r5.setNavigationIcon((int) r1)
            androidx.fragment.app.FragmentActivity r5 = r3.getActivity()
            if (r5 == 0) goto L_0x0152
            androidx.appcompat.app.AppCompatActivity r5 = (androidx.appcompat.app.AppCompatActivity) r5
            androidx.appcompat.app.ActionBar r5 = r5.getSupportActionBar()
            if (r5 == 0) goto L_0x0123
            r5.c((boolean) r0)
        L_0x0123:
            androidx.appcompat.widget.Toolbar r5 = r3.o
            if (r5 != 0) goto L_0x012a
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x012a:
            net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment$d r6 = new net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment$d
            r6.<init>(r3)
            android.view.View$OnClickListener r6 = (android.view.View.OnClickListener) r6
            r5.setNavigationOnClickListener(r6)
            net.one97.paytm.passbook.utility.g r5 = new net.one97.paytm.passbook.utility.g
            android.content.Context r6 = r4.getContext()
            android.widget.LinearLayout r0 = r3.f57501h
            if (r0 != 0) goto L_0x0143
            java.lang.String r1 = "llToolbarBalance"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0143:
            android.widget.LinearLayout r1 = r3.f57502i
            if (r1 != 0) goto L_0x014c
            java.lang.String r2 = "llToolbarHeader"
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x014c:
            r5.<init>(r6, r0, r1)
            r3.f57500g = r5
            return r4
        L_0x0152:
            kotlin.u r4 = new kotlin.u
            r4.<init>(r6)
            throw r4
        L_0x0158:
            kotlin.u r4 = new kotlin.u
            r4.<init>(r6)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PassbookL2Fragment f57508a;

        d(PassbookL2Fragment passbookL2Fragment) {
            this.f57508a = passbookL2Fragment;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f57508a.getActivity();
            if (activity != null) {
                ((AppCompatActivity) activity).onBackPressed();
                return;
            }
            throw new u("null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PassbookL2Fragment f57505a;

        public c(PassbookL2Fragment passbookL2Fragment) {
            this.f57505a = passbookL2Fragment;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0041, code lost:
            r10 = r10.getIntent();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r10) {
            /*
                r9 = this;
                net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment r10 = r9.f57505a
                java.lang.Integer r10 = r10.q
                if (r10 == 0) goto L_0x007f
                java.lang.Number r10 = (java.lang.Number) r10
                int r10 = r10.intValue()
                net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment r0 = r9.f57505a
                net.one97.paytm.passbook.genericPassbook.a r0 = net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment.b(r0)
                net.one97.paytm.passbook.utility.n r1 = net.one97.paytm.passbook.utility.n.SAVINGS_ACCOUNT
                int r1 = r1.getValue()
                r2 = 0
                if (r10 != r1) goto L_0x0024
                java.lang.String r2 = "/passbook/ppb"
                java.lang.String r10 = "ppb"
            L_0x0021:
                r5 = r10
                r7 = r2
                goto L_0x006e
            L_0x0024:
                net.one97.paytm.passbook.utility.n r1 = net.one97.paytm.passbook.utility.n.PAYTM_WALLET
                int r1 = r1.getValue()
                if (r10 != r1) goto L_0x0031
                java.lang.String r2 = "/passbook/wallet"
                java.lang.String r10 = "wallet"
                goto L_0x0021
            L_0x0031:
                net.one97.paytm.passbook.utility.n r1 = net.one97.paytm.passbook.utility.n.LOYALTY_WALLET_TYPE_7
                int r1 = r1.getValue()
                if (r10 != r1) goto L_0x006c
                android.content.Context r10 = r0.f57254a
                if (r10 == 0) goto L_0x0064
                android.app.Activity r10 = (android.app.Activity) r10
                if (r10 == 0) goto L_0x004e
                android.content.Intent r10 = r10.getIntent()
                if (r10 == 0) goto L_0x004e
                java.lang.String r1 = "passbookTypeFirstGames"
                java.io.Serializable r10 = r10.getSerializableExtra(r1)
                goto L_0x004f
            L_0x004e:
                r10 = r2
            L_0x004f:
                boolean r1 = r10 instanceof net.one97.paytm.passbook.utility.n
                if (r1 != 0) goto L_0x0054
                r10 = r2
            L_0x0054:
                net.one97.paytm.passbook.utility.n r10 = (net.one97.paytm.passbook.utility.n) r10
                net.one97.paytm.passbook.utility.n r1 = net.one97.paytm.passbook.utility.n.PAYTM_FIRST_GAMES_WALLET
                if (r10 != r1) goto L_0x005f
                java.lang.String r2 = "/passbook/first-games"
                java.lang.String r10 = "paytm first games"
                goto L_0x0021
            L_0x005f:
                java.lang.String r2 = "/passbook/loyalty-wallet"
                java.lang.String r10 = "loyalty wallet"
                goto L_0x0021
            L_0x0064:
                kotlin.u r10 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type android.app.Activity"
                r10.<init>(r0)
                throw r10
            L_0x006c:
                r5 = r2
                r7 = r5
            L_0x006e:
                net.one97.paytm.passbook.mapping.f r1 = net.one97.paytm.passbook.d.b()
                android.content.Context r2 = r0.f57254a
                java.lang.String r3 = "passbook"
                java.lang.String r4 = "filter_clicked"
                java.lang.String r6 = ""
                java.lang.String r8 = "passbook"
                r1.a(r2, r3, r4, r5, r6, r7, r8)
            L_0x007f:
                net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment r10 = r9.f57505a
                net.one97.paytm.passbook.genericPassbook.b.b r10 = net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment.c(r10)
                kotlin.o r10 = r10.f()
                net.one97.paytm.passbook.utility.i r0 = new net.one97.paytm.passbook.utility.i
                java.lang.Object r1 = r10.getFirst()
                java.lang.String r1 = (java.lang.String) r1
                java.lang.Object r10 = r10.getSecond()
                java.util.ArrayList r10 = (java.util.ArrayList) r10
                net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment r2 = r9.f57505a
                int r2 = r2.p
                r0.<init>(r1, r10, r2)
                net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment r10 = r9.f57505a
                androidx.fragment.app.FragmentActivity r10 = r10.getActivity()
                if (r10 == 0) goto L_0x00b5
                androidx.fragment.app.j r10 = r10.getSupportFragmentManager()
                if (r10 == 0) goto L_0x00b5
                java.lang.String r1 = r0.getTag()
                r0.show((androidx.fragment.app.j) r10, (java.lang.String) r1)
            L_0x00b5:
                net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment$c$1 r10 = new net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment$c$1
                r10.<init>(r9)
                net.one97.paytm.passbook.utility.i$a r10 = (net.one97.paytm.passbook.utility.i.a) r10
                r0.a((net.one97.paytm.passbook.utility.i.a) r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment.c.onClick(android.view.View):void");
        }
    }

    public final void a() {
        Integer num = this.q;
        int value = n.TOLL.getValue();
        if (num != null && num.intValue() == value) {
            LinearLayout linearLayout = (LinearLayout) a(R.id.filterLayout);
            k.a((Object) linearLayout, "filterLayout");
            linearLayout.setVisibility(8);
            View a2 = a(R.id.layout_transaction_items);
            k.a((Object) a2, "layout_transaction_items");
            a2.setVisibility(8);
            LinearLayout linearLayout2 = (LinearLayout) a(R.id.transactionContainer);
            k.a((Object) linearLayout2, "transactionContainer");
            linearLayout2.setVisibility(0);
            f fVar = new f();
            Bundle bundle = new Bundle();
            bundle.putString("wallet card type", getString(R.string.passbook_paytm_toll));
            fVar.setArguments(bundle);
            getChildFragmentManager().a().b(R.id.transactionContainer, fVar).c();
            return;
        }
        LottieAnimationView lottieAnimationView = (LottieAnimationView) a(R.id.loaderBottom);
        k.a((Object) lottieAnimationView, "loaderBottom");
        if (!a(lottieAnimationView)) {
            e();
        }
        net.one97.paytm.passbook.genericPassbook.b.b bVar = this.f57494a;
        if (bVar == null) {
            k.a("mDataModel");
        }
        bVar.a(this.p).observe(this, new b(this));
    }

    public final void b() {
        LinearLayout linearLayout = (LinearLayout) a(R.id.loader_ll);
        k.a((Object) linearLayout, "loader_ll");
        linearLayout.setVisibility(0);
        LottieAnimationView lottieAnimationView = (LottieAnimationView) a(R.id.wallet_loader);
        k.a((Object) lottieAnimationView, "wallet_loader");
        a(lottieAnimationView, Boolean.TRUE);
        net.one97.paytm.passbook.genericPassbook.b.b bVar = this.f57494a;
        if (bVar == null) {
            k.a("mDataModel");
        }
        bVar.d().observe(this, new a(this));
    }

    public final void onClick(View view) {
        k.c(view, "viewId");
        Context context = getContext();
        if (context != null) {
            net.one97.paytm.passbook.genericPassbook.b.b bVar = this.f57494a;
            if (bVar == null) {
                k.a("mDataModel");
            }
            k.a((Object) context, "it");
            bVar.a(context, view);
        }
    }

    public final void c() {
        net.one97.paytm.passbook.genericPassbook.b.b bVar = this.f57494a;
        if (bVar == null) {
            k.a("mDataModel");
        }
        if (bVar.e()) {
            LottieAnimationView lottieAnimationView = (LottieAnimationView) a(R.id.loaderBottom);
            k.a((Object) lottieAnimationView, "loaderBottom");
            a(lottieAnimationView, Boolean.TRUE);
            a();
        }
    }

    private final void e() {
        LottieAnimationView lottieAnimationView = (LottieAnimationView) a(R.id.loaderCenter);
        k.a((Object) lottieAnimationView, "loaderCenter");
        a(lottieAnimationView, Boolean.TRUE);
    }

    public final void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
        if (i2 == 0 || i2 >= -180) {
            LinearLayout linearLayout = this.f57501h;
            if (linearLayout == null) {
                k.a("llToolbarBalance");
            }
            linearLayout.setVisibility(8);
            LinearLayout linearLayout2 = this.f57502i;
            if (linearLayout2 == null) {
                k.a("llToolbarHeader");
            }
            if (linearLayout2.getVisibility() == 8) {
                g gVar = this.f57500g;
                if (gVar == null) {
                    k.a("layoutSlideAnimationUtil");
                }
                gVar.b();
                g gVar2 = this.f57500g;
                if (gVar2 == null) {
                    k.a("layoutSlideAnimationUtil");
                }
                gVar2.d();
                LinearLayout linearLayout3 = this.f57502i;
                if (linearLayout3 == null) {
                    k.a("llToolbarHeader");
                }
                linearLayout3.setVisibility(0);
                return;
            }
            return;
        }
        LinearLayout linearLayout4 = this.f57502i;
        if (linearLayout4 == null) {
            k.a("llToolbarHeader");
        }
        linearLayout4.setVisibility(8);
        LinearLayout linearLayout5 = this.f57501h;
        if (linearLayout5 == null) {
            k.a("llToolbarBalance");
        }
        if (linearLayout5.getVisibility() == 8) {
            g gVar3 = this.f57500g;
            if (gVar3 == null) {
                k.a("layoutSlideAnimationUtil");
            }
            gVar3.c();
            g gVar4 = this.f57500g;
            if (gVar4 == null) {
                k.a("layoutSlideAnimationUtil");
            }
            gVar4.a();
            LinearLayout linearLayout6 = this.f57501h;
            if (linearLayout6 == null) {
                k.a("llToolbarBalance");
            }
            linearLayout6.setVisibility(0);
            TextView textView = this.k;
            if (textView == null) {
                k.a("toolbarHeaderTitle");
            }
            net.one97.paytm.passbook.genericPassbook.b.b bVar = this.f57494a;
            if (bVar == null) {
                k.a("mDataModel");
            }
            textView.setText(getString((bVar != null ? Integer.valueOf(bVar.f57337i) : null).intValue()));
            net.one97.paytm.passbook.mapping.c.b("₹ " + this.r, (TextView) a(R.id.tv_toolbar_total_balance));
        }
    }

    public static final /* synthetic */ void g(PassbookL2Fragment passbookL2Fragment) {
        LottieAnimationView lottieAnimationView = (LottieAnimationView) passbookL2Fragment.a(R.id.loaderCenter);
        k.a((Object) lottieAnimationView, "loaderCenter");
        a(lottieAnimationView, Boolean.FALSE);
    }

    public static final /* synthetic */ void h(PassbookL2Fragment passbookL2Fragment) {
        LottieAnimationView lottieAnimationView = (LottieAnimationView) passbookL2Fragment.a(R.id.loaderBottom);
        k.a((Object) lottieAnimationView, "loaderBottom");
        a(lottieAnimationView, Boolean.FALSE);
    }

    public static final /* synthetic */ void a(PassbookL2Fragment passbookL2Fragment, String str) {
        String a2 = PassbookTransactionDetailsActivity.a(str);
        k.a((Object) a2, "PassbookTransactionDetai…ity.formatAmount(balance)");
        passbookL2Fragment.r = a2;
        if (passbookL2Fragment.f57495b == null) {
            k.a("mL2EventHandler");
        }
        String str2 = passbookL2Fragment.r;
        k.c(str2, "mTotalBalance");
        if (p.b(str2, AppUtility.CENTER_DOT, false)) {
            str2 = "0".concat(String.valueOf(str2));
        }
        passbookL2Fragment.r = str2;
        String str3 = passbookL2Fragment.r;
        TextView textView = passbookL2Fragment.j;
        if (textView == null) {
            k.a("tvWalletBalance");
        }
        net.one97.paytm.passbook.mapping.c.b(str3, textView);
    }
}
