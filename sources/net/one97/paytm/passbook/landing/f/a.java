package net.one97.paytm.passbook.landing.f;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.appbar.AppBarLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.x;
import kotlin.x;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.CJRAccountSummary;
import net.one97.paytm.passbook.beans.upi.AccountProviderBody;
import net.one97.paytm.passbook.beans.upi.BankAccountDetails;
import net.one97.paytm.passbook.beans.upi.UPICheckBalanceListenerCallback;
import net.one97.paytm.passbook.beans.upi.UpiProfileDefaultBank;
import net.one97.paytm.passbook.beans.upi.UserUpiDetails;
import net.one97.paytm.passbook.landing.activity.PassbookLandingActivity;
import net.one97.paytm.passbook.landing.c.a;
import net.one97.paytm.passbook.landing.e.v;
import net.one97.paytm.passbook.main.widget.ExpandableBalanceCardView;
import net.one97.paytm.passbook.main.widget.InitCards;
import net.one97.paytm.passbook.main.widget.PassbookBalanceCardView;
import net.one97.paytm.passbook.main.widget.PassbookHeaderLayout;
import net.one97.paytm.passbook.main.widget.UPIInitCardV2;
import net.one97.paytm.passbook.utility.CustomToggleButton;
import net.one97.paytm.upi.util.UpiConstants;

public final class a {
    public PassbookHeaderLayout A;
    public PassbookHeaderLayout B;
    public C1092a C;
    public boolean D;
    String E;
    Double F;
    Double G;
    String H;
    Double I;
    Double J;
    String K;
    public Integer L;
    public boolean M;
    public final net.one97.paytm.passbook.landing.c.a N;
    private int O;
    private boolean P;
    private View.OnClickListener Q = new o(this);

    /* renamed from: a  reason: collision with root package name */
    public ExpandableBalanceCardView f57705a;

    /* renamed from: b  reason: collision with root package name */
    public PassbookBalanceCardView f57706b;

    /* renamed from: c  reason: collision with root package name */
    public PassbookBalanceCardView f57707c;

    /* renamed from: d  reason: collision with root package name */
    public PassbookBalanceCardView f57708d;

    /* renamed from: e  reason: collision with root package name */
    public PassbookBalanceCardView f57709e;

    /* renamed from: f  reason: collision with root package name */
    public PassbookBalanceCardView f57710f;

    /* renamed from: g  reason: collision with root package name */
    public PassbookBalanceCardView f57711g;

    /* renamed from: h  reason: collision with root package name */
    public PassbookBalanceCardView f57712h;

    /* renamed from: i  reason: collision with root package name */
    public PassbookBalanceCardView f57713i;
    public PassbookBalanceCardView j;
    public PassbookBalanceCardView k;
    public PassbookBalanceCardView l;
    public PassbookBalanceCardView m;
    public PassbookBalanceCardView n;
    public PassbookBalanceCardView o;
    public PassbookBalanceCardView p;
    public PassbookBalanceCardView q;
    public PassbookBalanceCardView r;
    public PassbookBalanceCardView s;
    public InitCards t;
    public InitCards u;
    public InitCards v;
    public InitCards w;
    public InitCards x;
    public InitCards y;
    public UPIInitCardV2 z;

    /* renamed from: net.one97.paytm.passbook.landing.f.a$a  reason: collision with other inner class name */
    public enum C1092a {
        PPB_SA,
        PPB_FD,
        ICA,
        ICA_FD
    }

    static final class m<T> implements z<net.one97.paytm.passbook.landing.e.a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57726a;

        m(a aVar) {
            this.f57726a = aVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.String} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Double} */
        /* JADX WARNING: type inference failed for: r1v0 */
        /* JADX WARNING: type inference failed for: r1v6 */
        /* JADX WARNING: type inference failed for: r1v7 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r5) {
            /*
                r4 = this;
                net.one97.paytm.passbook.landing.e.a r5 = (net.one97.paytm.passbook.landing.e.a) r5
                boolean r0 = r5 instanceof net.one97.paytm.passbook.landing.e.j
                r1 = 0
                if (r0 == 0) goto L_0x004c
                net.one97.paytm.passbook.landing.f.a r0 = r4.f57726a
                net.one97.paytm.passbook.landing.e.j r5 = (net.one97.paytm.passbook.landing.e.j) r5
                net.one97.paytm.passbook.mapping.a.f<? extends net.one97.paytm.passbook.beans.CJRAccountSummary> r2 = r5.f57662a
                T r2 = r2.f57887b
                net.one97.paytm.passbook.beans.CJRAccountSummary r2 = (net.one97.paytm.passbook.beans.CJRAccountSummary) r2
                if (r2 == 0) goto L_0x0018
                java.lang.String r2 = r2.getAccountNumber()
                goto L_0x0019
            L_0x0018:
                r2 = r1
            L_0x0019:
                r0.H = r2
                net.one97.paytm.passbook.landing.f.a r0 = r4.f57726a
                net.one97.paytm.passbook.mapping.a.f<? extends net.one97.paytm.passbook.beans.CJRAccountSummary> r2 = r5.f57662a
                T r2 = r2.f57887b
                net.one97.paytm.passbook.beans.CJRAccountSummary r2 = (net.one97.paytm.passbook.beans.CJRAccountSummary) r2
                if (r2 == 0) goto L_0x0034
                java.lang.String r2 = r2.getmTotalBalance()
                if (r2 == 0) goto L_0x0034
                double r2 = java.lang.Double.parseDouble(r2)
                java.lang.Double r2 = java.lang.Double.valueOf(r2)
                goto L_0x0035
            L_0x0034:
                r2 = r1
            L_0x0035:
                r0.I = r2
                net.one97.paytm.passbook.landing.f.a r0 = r4.f57726a
                net.one97.paytm.passbook.mapping.a.f<? extends net.one97.paytm.passbook.beans.CJRAccountSummary> r5 = r5.f57662a
                T r5 = r5.f57887b
                net.one97.paytm.passbook.beans.CJRAccountSummary r5 = (net.one97.paytm.passbook.beans.CJRAccountSummary) r5
                if (r5 == 0) goto L_0x0049
                double r1 = r5.getSlfdBalance()
                java.lang.Double r1 = java.lang.Double.valueOf(r1)
            L_0x0049:
                r0.J = r1
                return
            L_0x004c:
                boolean r0 = r5 instanceof net.one97.paytm.passbook.landing.e.l
                if (r0 == 0) goto L_0x0062
                net.one97.paytm.passbook.landing.f.a r0 = r4.f57726a
                net.one97.paytm.passbook.landing.e.l r5 = (net.one97.paytm.passbook.landing.e.l) r5
                net.one97.paytm.passbook.mapping.a.f<? extends net.one97.paytm.passbook.beans.CustProductList> r5 = r5.f57664a
                T r5 = r5.f57887b
                net.one97.paytm.passbook.beans.CustProductList r5 = (net.one97.paytm.passbook.beans.CustProductList) r5
                if (r5 == 0) goto L_0x0060
                java.lang.String r1 = r5.getICARefId()
            L_0x0060:
                r0.K = r1
            L_0x0062:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.landing.f.a.m.onChanged(java.lang.Object):void");
        }
    }

    static final class n<T> implements z<net.one97.paytm.passbook.landing.e.a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57727a;

        n(a aVar) {
            this.f57727a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str;
            net.one97.paytm.passbook.landing.e.a aVar = (net.one97.paytm.passbook.landing.e.a) obj;
            if (aVar instanceof v) {
                a aVar2 = this.f57727a;
                v vVar = (v) aVar;
                CJRAccountSummary cJRAccountSummary = (CJRAccountSummary) vVar.f57695a.f57887b;
                Double d2 = null;
                aVar2.E = cJRAccountSummary != null ? cJRAccountSummary.getAccountNumber() : null;
                a aVar3 = this.f57727a;
                CJRAccountSummary cJRAccountSummary2 = (CJRAccountSummary) vVar.f57695a.f57887b;
                aVar3.F = (cJRAccountSummary2 == null || (str = cJRAccountSummary2.getmTotalBalance()) == null) ? null : Double.valueOf(Double.parseDouble(str));
                a aVar4 = this.f57727a;
                CJRAccountSummary cJRAccountSummary3 = (CJRAccountSummary) vVar.f57695a.f57887b;
                if (cJRAccountSummary3 != null) {
                    d2 = Double.valueOf(cJRAccountSummary3.getSlfdBalance());
                }
                aVar4.G = d2;
                if (this.f57727a.C != null) {
                    C1092a aVar5 = this.f57727a.C;
                    if (aVar5 == null) {
                        kotlin.g.b.k.a("cardClickSource");
                    }
                    if (aVar5 == C1092a.PPB_FD && !this.f57727a.M) {
                        this.f57727a.z();
                    }
                }
                this.f57727a.M = false;
            }
        }
    }

    public a(net.one97.paytm.passbook.landing.c.a aVar) {
        kotlin.g.b.k.c(aVar, "balanceSummaryFragment");
        this.N = aVar;
    }

    public final ExpandableBalanceCardView a() {
        ExpandableBalanceCardView expandableBalanceCardView = this.f57705a;
        if (expandableBalanceCardView == null) {
            kotlin.g.b.k.a("mPaytmWalletCard");
        }
        return expandableBalanceCardView;
    }

    public final PassbookBalanceCardView b() {
        PassbookBalanceCardView passbookBalanceCardView = this.f57706b;
        if (passbookBalanceCardView == null) {
            kotlin.g.b.k.a("mNPSCard");
        }
        return passbookBalanceCardView;
    }

    public final PassbookBalanceCardView c() {
        PassbookBalanceCardView passbookBalanceCardView = this.f57707c;
        if (passbookBalanceCardView == null) {
            kotlin.g.b.k.a("mMutualFundCard");
        }
        return passbookBalanceCardView;
    }

    public final PassbookBalanceCardView d() {
        PassbookBalanceCardView passbookBalanceCardView = this.f57708d;
        if (passbookBalanceCardView == null) {
            kotlin.g.b.k.a("mPaytmWalletActivateCard");
        }
        return passbookBalanceCardView;
    }

    public final PassbookBalanceCardView e() {
        PassbookBalanceCardView passbookBalanceCardView = this.f57709e;
        if (passbookBalanceCardView == null) {
            kotlin.g.b.k.a("mPaymentsBankSA");
        }
        return passbookBalanceCardView;
    }

    public final PassbookBalanceCardView f() {
        PassbookBalanceCardView passbookBalanceCardView = this.f57710f;
        if (passbookBalanceCardView == null) {
            kotlin.g.b.k.a("mFixedDepositSA");
        }
        return passbookBalanceCardView;
    }

    public final PassbookBalanceCardView g() {
        PassbookBalanceCardView passbookBalanceCardView = this.f57711g;
        if (passbookBalanceCardView == null) {
            kotlin.g.b.k.a("mCurrentAccountCard");
        }
        return passbookBalanceCardView;
    }

    public final PassbookBalanceCardView h() {
        PassbookBalanceCardView passbookBalanceCardView = this.f57712h;
        if (passbookBalanceCardView == null) {
            kotlin.g.b.k.a("mFDCurrentAccountCard");
        }
        return passbookBalanceCardView;
    }

    public final PassbookBalanceCardView i() {
        PassbookBalanceCardView passbookBalanceCardView = this.f57713i;
        if (passbookBalanceCardView == null) {
            kotlin.g.b.k.a("mPostPaidCard");
        }
        return passbookBalanceCardView;
    }

    public final PassbookBalanceCardView j() {
        PassbookBalanceCardView passbookBalanceCardView = this.j;
        if (passbookBalanceCardView == null) {
            kotlin.g.b.k.a("mBhimUPICard");
        }
        return passbookBalanceCardView;
    }

    public final PassbookBalanceCardView k() {
        PassbookBalanceCardView passbookBalanceCardView = this.l;
        if (passbookBalanceCardView == null) {
            kotlin.g.b.k.a("mCreditCardView");
        }
        return passbookBalanceCardView;
    }

    public final PassbookBalanceCardView l() {
        PassbookBalanceCardView passbookBalanceCardView = this.m;
        if (passbookBalanceCardView == null) {
            kotlin.g.b.k.a("mCashBackVouchersCard");
        }
        return passbookBalanceCardView;
    }

    public final PassbookBalanceCardView m() {
        PassbookBalanceCardView passbookBalanceCardView = this.n;
        if (passbookBalanceCardView == null) {
            kotlin.g.b.k.a("mPaytmRewardPointsCard");
        }
        return passbookBalanceCardView;
    }

    public final PassbookBalanceCardView n() {
        PassbookBalanceCardView passbookBalanceCardView = this.q;
        if (passbookBalanceCardView == null) {
            kotlin.g.b.k.a("mPFGCard");
        }
        return passbookBalanceCardView;
    }

    public final PassbookBalanceCardView o() {
        PassbookBalanceCardView passbookBalanceCardView = this.r;
        if (passbookBalanceCardView == null) {
            kotlin.g.b.k.a("mPaytmGoldCard");
        }
        return passbookBalanceCardView;
    }

    public final InitCards p() {
        InitCards initCards = this.t;
        if (initCards == null) {
            kotlin.g.b.k.a("mMutualFundInitCard");
        }
        return initCards;
    }

    public final InitCards q() {
        InitCards initCards = this.u;
        if (initCards == null) {
            kotlin.g.b.k.a("mNPSInitCard");
        }
        return initCards;
    }

    public final InitCards r() {
        InitCards initCards = this.v;
        if (initCards == null) {
            kotlin.g.b.k.a("mPaymentsBankInitCardV2");
        }
        return initCards;
    }

    public final InitCards s() {
        InitCards initCards = this.w;
        if (initCards == null) {
            kotlin.g.b.k.a("mPostPaidInitCard");
        }
        return initCards;
    }

    public final InitCards t() {
        InitCards initCards = this.x;
        if (initCards == null) {
            kotlin.g.b.k.a("mPaytmGoldInitCard");
        }
        return initCards;
    }

    public final UPIInitCardV2 u() {
        UPIInitCardV2 uPIInitCardV2 = this.z;
        if (uPIInitCardV2 == null) {
            kotlin.g.b.k.a("mUpiInitCardV2");
        }
        return uPIInitCardV2;
    }

    public final void a(C1092a aVar) {
        kotlin.g.b.k.c(aVar, "<set-?>");
        this.C = aVar;
    }

    public final void a(LinearLayout linearLayout) {
        kotlin.g.b.k.c(linearLayout, "itemsLayout");
        Context context = linearLayout.getContext();
        kotlin.g.b.k.a((Object) context, "itemsLayout.context");
        ExpandableBalanceCardView expandableBalanceCardView = new ExpandableBalanceCardView(context);
        ((AppCompatImageView) expandableBalanceCardView.a(R.id.ivWalletIcon)).setImageResource(R.drawable.pb_paytm_wallet_new);
        View findViewById = expandableBalanceCardView.findViewById(R.id.card_top_border);
        kotlin.g.b.k.a((Object) findViewById, "findViewById<View>(R.id.card_top_border)");
        findViewById.setVisibility(8);
        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) expandableBalanceCardView.findViewById(R.id.expandableCardShimmerLayout);
        if (shimmerFrameLayout != null) {
            shimmerFrameLayout.a();
            x xVar = x.f47997a;
        }
        x xVar2 = x.f47997a;
        this.f57705a = expandableBalanceCardView;
        Context context2 = linearLayout.getContext();
        kotlin.g.b.k.a((Object) context2, "itemsLayout.context");
        PassbookBalanceCardView passbookBalanceCardView = new PassbookBalanceCardView(context2);
        passbookBalanceCardView.setVisibility(0);
        passbookBalanceCardView.b();
        x xVar3 = x.f47997a;
        this.f57713i = passbookBalanceCardView;
        Context context3 = linearLayout.getContext();
        kotlin.g.b.k.a((Object) context3, "itemsLayout.context");
        PassbookBalanceCardView passbookBalanceCardView2 = new PassbookBalanceCardView(context3, R.layout.pass_sa_card_view);
        passbookBalanceCardView2.setVisibility(0);
        passbookBalanceCardView2.b();
        x xVar4 = x.f47997a;
        this.f57709e = passbookBalanceCardView2;
        Context context4 = linearLayout.getContext();
        kotlin.g.b.k.a((Object) context4, "itemsLayout.context");
        PassbookBalanceCardView passbookBalanceCardView3 = new PassbookBalanceCardView(context4);
        passbookBalanceCardView3.setVisibility(8);
        passbookBalanceCardView3.b();
        x xVar5 = x.f47997a;
        this.f57710f = passbookBalanceCardView3;
        Context context5 = linearLayout.getContext();
        kotlin.g.b.k.a((Object) context5, "itemsLayout.context");
        PassbookBalanceCardView passbookBalanceCardView4 = new PassbookBalanceCardView(context5, R.layout.pass_upi_card_view);
        passbookBalanceCardView4.setVisibility(0);
        passbookBalanceCardView4.b();
        x xVar6 = x.f47997a;
        this.j = passbookBalanceCardView4;
        Context context6 = linearLayout.getContext();
        kotlin.g.b.k.a((Object) context6, "itemsLayout.context");
        PassbookBalanceCardView passbookBalanceCardView5 = new PassbookBalanceCardView(context6);
        passbookBalanceCardView5.setVisibility(8);
        passbookBalanceCardView5.b();
        x xVar7 = x.f47997a;
        this.s = passbookBalanceCardView5;
        Context context7 = linearLayout.getContext();
        kotlin.g.b.k.a((Object) context7, "itemsLayout.context");
        PassbookBalanceCardView passbookBalanceCardView6 = new PassbookBalanceCardView(context7);
        passbookBalanceCardView6.setVisibility(8);
        passbookBalanceCardView6.b();
        x xVar8 = x.f47997a;
        this.f57707c = passbookBalanceCardView6;
        Context context8 = linearLayout.getContext();
        kotlin.g.b.k.a((Object) context8, "itemsLayout.context");
        PassbookBalanceCardView passbookBalanceCardView7 = new PassbookBalanceCardView(context8);
        passbookBalanceCardView7.setVisibility(8);
        passbookBalanceCardView7.b();
        x xVar9 = x.f47997a;
        this.f57706b = passbookBalanceCardView7;
        Context context9 = linearLayout.getContext();
        kotlin.g.b.k.a((Object) context9, "itemsLayout.context");
        PassbookBalanceCardView passbookBalanceCardView8 = new PassbookBalanceCardView(context9);
        passbookBalanceCardView8.setVisibility(8);
        passbookBalanceCardView8.b();
        x xVar10 = x.f47997a;
        this.f57711g = passbookBalanceCardView8;
        Context context10 = linearLayout.getContext();
        kotlin.g.b.k.a((Object) context10, "itemsLayout.context");
        PassbookBalanceCardView passbookBalanceCardView9 = new PassbookBalanceCardView(context10);
        passbookBalanceCardView9.setVisibility(8);
        passbookBalanceCardView9.b();
        x xVar11 = x.f47997a;
        this.f57712h = passbookBalanceCardView9;
        ExpandableBalanceCardView expandableBalanceCardView2 = this.f57705a;
        if (expandableBalanceCardView2 == null) {
            kotlin.g.b.k.a("mPaytmWalletCard");
        }
        expandableBalanceCardView2.setOnClickListener(this.Q);
        ExpandableBalanceCardView expandableBalanceCardView3 = this.f57705a;
        if (expandableBalanceCardView3 == null) {
            kotlin.g.b.k.a("mPaytmWalletCard");
        }
        ((CustomToggleButton) expandableBalanceCardView3.findViewById(R.id.expendCollapsBtn)).setOnClickListener(new d(this));
        ExpandableBalanceCardView expandableBalanceCardView4 = this.f57705a;
        if (expandableBalanceCardView4 == null) {
            kotlin.g.b.k.a("mPaytmWalletCard");
        }
        ((CustomToggleButton) expandableBalanceCardView4.findViewById(R.id.expendCollapsBtn)).setOnCheckedChangeListener(new e(this));
        Context context11 = linearLayout.getContext();
        kotlin.g.b.k.a((Object) context11, "itemsLayout.context");
        PassbookBalanceCardView passbookBalanceCardView10 = new PassbookBalanceCardView(context11);
        passbookBalanceCardView10.setVisibility(8);
        ((AppCompatImageView) passbookBalanceCardView10.a(R.id.ivWalletIcon)).setImageResource(R.drawable.pb_paytm_wallet_new);
        View findViewById2 = passbookBalanceCardView10.findViewById(R.id.card_top_border);
        kotlin.g.b.k.a((Object) findViewById2, "findViewById<View>(R.id.card_top_border)");
        findViewById2.setVisibility(8);
        View findViewById3 = passbookBalanceCardView10.findViewById(R.id.cardShimmerLayout);
        kotlin.g.b.k.a((Object) findViewById3, "findViewById<ShimmerFram…>(R.id.cardShimmerLayout)");
        ((ShimmerFrameLayout) findViewById3).setVisibility(8);
        passbookBalanceCardView10.a(true);
        passbookBalanceCardView10.b(false);
        String string = linearLayout.getContext().getString(R.string.pass_activate_now);
        kotlin.g.b.k.a((Object) string, "itemsLayout.context.getS…string.pass_activate_now)");
        passbookBalanceCardView10.a(string);
        x xVar12 = x.f47997a;
        this.f57708d = passbookBalanceCardView10;
        PassbookBalanceCardView passbookBalanceCardView11 = this.f57708d;
        if (passbookBalanceCardView11 == null) {
            kotlin.g.b.k.a("mPaytmWalletActivateCard");
        }
        passbookBalanceCardView11.setOnClickListener(this.Q);
        Context context12 = linearLayout.getContext();
        kotlin.g.b.k.a((Object) context12, "itemsLayout.context");
        InitCards initCards = new InitCards(context12, R.layout.pass_init_cards_layout);
        initCards.setVisibility(8);
        ((AppCompatImageView) initCards.a(R.id.ivInitIcon)).setImageResource(R.drawable.pb_mutual_funnd_new);
        ((AppCompatTextView) initCards.a(R.id.tvInitCardTitle)).setText(R.string.pb_mutual_funds);
        ((AppCompatTextView) initCards.a(R.id.tvInitCardSubTitle)).setText(R.string.pb_mf_init_text);
        ((AppCompatTextView) initCards.a(R.id.tvInitCTA)).setText(R.string.pass_invest_now_cta);
        x xVar13 = x.f47997a;
        this.t = initCards;
        Context context13 = linearLayout.getContext();
        kotlin.g.b.k.a((Object) context13, "itemsLayout.context");
        InitCards initCards2 = new InitCards(context13, R.layout.pass_init_cards_layout);
        initCards2.setVisibility(8);
        ((AppCompatImageView) initCards2.a(R.id.ivInitIcon)).setImageResource(R.drawable.pb_nps_new);
        ((AppCompatTextView) initCards2.a(R.id.tvInitCardTitle)).setText(R.string.pass_nps);
        ((AppCompatTextView) initCards2.a(R.id.tvInitCardSubTitle)).setText(R.string.pass_nps_subtitle);
        ((AppCompatTextView) initCards2.a(R.id.tvInitCTA)).setText(R.string.pass_invest_now_cta);
        x xVar14 = x.f47997a;
        this.u = initCards2;
        Context context14 = linearLayout.getContext();
        kotlin.g.b.k.a((Object) context14, "itemsLayout.context");
        InitCards initCards3 = new InitCards(context14, R.layout.pass_init_cards_layout);
        initCards3.setVisibility(8);
        ((AppCompatImageView) initCards3.a(R.id.ivInitIcon)).setImageResource(R.drawable.pb_paytm_bank_new);
        ((AppCompatTextView) initCards3.a(R.id.tvInitCardTitle)).setText(R.string.pass_ppbl_init_title);
        ((AppCompatTextView) initCards3.a(R.id.tvInitCardSubTitle)).setText(R.string.pass_ppbl_init_subtitle);
        ((AppCompatTextView) initCards3.a(R.id.tvInitCTA)).setText(R.string.pass_ppbl_init_cta);
        x xVar15 = x.f47997a;
        this.v = initCards3;
        Context context15 = linearLayout.getContext();
        kotlin.g.b.k.a((Object) context15, "itemsLayout.context");
        InitCards initCards4 = new InitCards(context15, R.layout.pass_init_cards_layout);
        initCards4.setVisibility(8);
        ((AppCompatImageView) initCards4.a(R.id.ivInitIcon)).setImageResource(R.drawable.pb_paytm_fastag_new);
        ((AppCompatTextView) initCards4.a(R.id.tvInitCardTitle)).setText(R.string.pass_paytm_payments_bank_fastag);
        ((AppCompatTextView) initCards4.a(R.id.tvInitCardSubTitle)).setText(R.string.pass_zip_through_tolls_like_vip);
        ((AppCompatTextView) initCards4.a(R.id.tvInitCTA)).setText(R.string.pass_get_now);
        x xVar16 = x.f47997a;
        this.y = initCards4;
        PassbookBalanceCardView passbookBalanceCardView12 = this.f57709e;
        if (passbookBalanceCardView12 == null) {
            kotlin.g.b.k.a("mPaymentsBankSA");
        }
        passbookBalanceCardView12.setOnClickListener(new f(this));
        PassbookBalanceCardView passbookBalanceCardView13 = this.f57710f;
        if (passbookBalanceCardView13 == null) {
            kotlin.g.b.k.a("mFixedDepositSA");
        }
        passbookBalanceCardView13.setOnClickListener(new g(this));
        InitCards initCards5 = this.y;
        if (initCards5 == null) {
            kotlin.g.b.k.a("mFastagInitCard");
        }
        initCards5.setOnClickListener(new h(this));
        PassbookBalanceCardView passbookBalanceCardView14 = this.f57711g;
        if (passbookBalanceCardView14 == null) {
            kotlin.g.b.k.a("mCurrentAccountCard");
        }
        passbookBalanceCardView14.setOnClickListener(new i(this));
        PassbookBalanceCardView passbookBalanceCardView15 = this.f57712h;
        if (passbookBalanceCardView15 == null) {
            kotlin.g.b.k.a("mFDCurrentAccountCard");
        }
        passbookBalanceCardView15.setOnClickListener(new j(this));
        D();
        Context context16 = linearLayout.getContext();
        kotlin.g.b.k.a((Object) context16, "itemsLayout.context");
        InitCards initCards6 = new InitCards(context16, R.layout.pass_init_cards_layout);
        initCards6.setVisibility(8);
        ((AppCompatImageView) initCards6.a(R.id.ivInitIcon)).setImageResource(R.drawable.pb_paytm_postpaid_new);
        ((AppCompatTextView) initCards6.a(R.id.tvInitCardTitle)).setText(R.string.paytm_postpaid);
        ((AppCompatTextView) initCards6.a(R.id.tvInitCardSubTitle)).setText(R.string.postpaid_activate_now);
        ((AppCompatTextView) initCards6.a(R.id.tvInitCTA)).setText(R.string.pp_activate_now);
        x xVar17 = x.f47997a;
        this.w = initCards6;
        UPIInitCardV2 uPIInitCardV2 = new UPIInitCardV2(linearLayout.getContext());
        uPIInitCardV2.setVisibility(8);
        View view = uPIInitCardV2;
        ((AppCompatImageView) view.findViewById(R.id.ivInitIcon)).setImageResource(R.drawable.pb_link_bank_account);
        ((AppCompatTextView) view.findViewById(R.id.tvInitCardTitle)).setText(R.string.pass_upi_init_title);
        ((AppCompatTextView) view.findViewById(R.id.tvInitCardSubTitle)).setText(R.string.pb_new_bank_link_subtitle);
        ((AppCompatTextView) view.findViewById(R.id.tvInitCTA)).setText(R.string.pass_upi_link_now);
        x xVar18 = x.f47997a;
        this.z = uPIInitCardV2;
        UPIInitCardV2 uPIInitCardV22 = this.z;
        if (uPIInitCardV22 == null) {
            kotlin.g.b.k.a("mUpiInitCardV2");
        }
        uPIInitCardV22.setListener(new k(this));
        PassbookBalanceCardView passbookBalanceCardView16 = this.j;
        if (passbookBalanceCardView16 == null) {
            kotlin.g.b.k.a("mBhimUPICard");
        }
        ((AppCompatTextView) passbookBalanceCardView16.findViewById(R.id.tvReactivate)).setOnClickListener(new l(this));
        Context context17 = linearLayout.getContext();
        kotlin.g.b.k.a((Object) context17, "itemsLayout.context");
        PassbookBalanceCardView passbookBalanceCardView17 = new PassbookBalanceCardView(context17);
        passbookBalanceCardView17.setVisibility(8);
        passbookBalanceCardView17.b();
        x xVar19 = x.f47997a;
        this.l = passbookBalanceCardView17;
        Context context18 = linearLayout.getContext();
        kotlin.g.b.k.a((Object) context18, "itemsLayout.context");
        PassbookBalanceCardView passbookBalanceCardView18 = new PassbookBalanceCardView(context18);
        passbookBalanceCardView18.setVisibility(8);
        passbookBalanceCardView18.setTitle(R.string.pass_cashback_vouchers);
        passbookBalanceCardView18.setIcon(R.drawable.pass_cb_voucher);
        passbookBalanceCardView18.a(true);
        ((AppCompatImageView) passbookBalanceCardView18.a(R.id.ivWalletIcon)).setPadding(net.one97.paytm.passbook.mapping.a.c(8), 0, net.one97.paytm.passbook.mapping.a.c(8), 0);
        passbookBalanceCardView18.b();
        x xVar20 = x.f47997a;
        this.m = passbookBalanceCardView18;
        Context context19 = linearLayout.getContext();
        kotlin.g.b.k.a((Object) context19, "itemsLayout.context");
        PassbookBalanceCardView passbookBalanceCardView19 = new PassbookBalanceCardView(context19);
        passbookBalanceCardView19.setVisibility(8);
        ((AppCompatImageView) passbookBalanceCardView19.a(R.id.ivWalletIcon)).setPadding(net.one97.paytm.passbook.mapping.a.c(8), 0, net.one97.paytm.passbook.mapping.a.c(8), 0);
        passbookBalanceCardView19.b();
        x xVar21 = x.f47997a;
        this.n = passbookBalanceCardView19;
        Context context20 = linearLayout.getContext();
        kotlin.g.b.k.a((Object) context20, "itemsLayout.context");
        PassbookBalanceCardView passbookBalanceCardView20 = new PassbookBalanceCardView(context20);
        passbookBalanceCardView20.setVisibility(8);
        ((AppCompatImageView) passbookBalanceCardView20.a(R.id.ivWalletIcon)).setPadding(net.one97.paytm.passbook.mapping.a.c(8), 0, net.one97.paytm.passbook.mapping.a.c(8), 0);
        passbookBalanceCardView20.b();
        x xVar22 = x.f47997a;
        this.o = passbookBalanceCardView20;
        Context context21 = linearLayout.getContext();
        kotlin.g.b.k.a((Object) context21, "itemsLayout.context");
        PassbookBalanceCardView passbookBalanceCardView21 = new PassbookBalanceCardView(context21);
        passbookBalanceCardView21.setVisibility(8);
        ((AppCompatImageView) passbookBalanceCardView21.a(R.id.ivWalletIcon)).setPadding(net.one97.paytm.passbook.mapping.a.c(8), 0, net.one97.paytm.passbook.mapping.a.c(8), 0);
        passbookBalanceCardView21.b();
        x xVar23 = x.f47997a;
        this.p = passbookBalanceCardView21;
        Context context22 = linearLayout.getContext();
        kotlin.g.b.k.a((Object) context22, "itemsLayout.context");
        PassbookHeaderLayout passbookHeaderLayout = new PassbookHeaderLayout(context22, R.layout.pass_landing_viewmore_header);
        passbookHeaderLayout.setHeader(true);
        passbookHeaderLayout.setCustomBackgroundColor(Integer.valueOf(R.color.color_fafafa));
        x xVar24 = x.f47997a;
        this.A = passbookHeaderLayout;
        Context context23 = linearLayout.getContext();
        kotlin.g.b.k.a((Object) context23, "itemsLayout.context");
        PassbookHeaderLayout passbookHeaderLayout2 = new PassbookHeaderLayout(context23, R.layout.pass_landing_viewmore_header);
        ((AppCompatTextView) passbookHeaderLayout2.findViewById(R.id.tvLayoutTitle)).setText(R.string.pass_vouchers_heading);
        ((AppCompatTextView) passbookHeaderLayout2.findViewById(R.id.tvLayoutDescription)).setText(R.string.pass_vouchers_description);
        passbookHeaderLayout2.setHeader(true);
        passbookHeaderLayout2.setCustomBackgroundColor(Integer.valueOf(R.color.color_fafafa));
        x xVar25 = x.f47997a;
        this.B = passbookHeaderLayout2;
        Context context24 = linearLayout.getContext();
        kotlin.g.b.k.a((Object) context24, "itemsLayout.context");
        PassbookBalanceCardView passbookBalanceCardView22 = new PassbookBalanceCardView(context24);
        ((AppCompatImageView) passbookBalanceCardView22.a(R.id.ivWalletIcon)).setPadding(net.one97.paytm.passbook.mapping.a.c(8), 0, net.one97.paytm.passbook.mapping.a.c(8), 0);
        passbookBalanceCardView22.setVisibility(8);
        passbookBalanceCardView22.b();
        x xVar26 = x.f47997a;
        this.q = passbookBalanceCardView22;
        Context context25 = linearLayout.getContext();
        kotlin.g.b.k.a((Object) context25, "itemsLayout.context");
        InitCards initCards7 = new InitCards(context25, R.layout.pass_init_cards_layout);
        initCards7.setVisibility(8);
        ((AppCompatImageView) initCards7.a(R.id.ivInitIcon)).setImageResource(R.drawable.pb_paytm_gold_new);
        ((AppCompatTextView) initCards7.a(R.id.tvInitCardTitle)).setText(R.string.paytm_gold_wallet);
        ((AppCompatTextView) initCards7.a(R.id.tvInitCardSubTitle)).setText(R.string.pass_gold_init_subtitle);
        ((AppCompatTextView) initCards7.a(R.id.tvInitCTA)).setText(R.string.pass_invest_now_cta);
        x xVar27 = x.f47997a;
        this.x = initCards7;
        Context context26 = linearLayout.getContext();
        kotlin.g.b.k.a((Object) context26, "itemsLayout.context");
        PassbookBalanceCardView passbookBalanceCardView23 = new PassbookBalanceCardView(context26);
        passbookBalanceCardView23.setVisibility(8);
        ((AppCompatTextView) passbookBalanceCardView23.a(R.id.tvTitle)).setText(R.string.paytm_gold_wallet);
        passbookBalanceCardView23.b();
        ((AppCompatImageView) passbookBalanceCardView23.a(R.id.ivWalletIcon)).setImageResource(R.drawable.pb_paytm_gold_new);
        x xVar28 = x.f47997a;
        this.r = passbookBalanceCardView23;
        c(linearLayout);
        C();
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57717a;

        d(a aVar) {
            this.f57717a = aVar;
        }

        public final void onClick(View view) {
            a.a(this.f57717a);
        }
    }

    static final class e implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57718a;

        e(a aVar) {
            this.f57718a = aVar;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            ExpandableBalanceCardView a2 = this.f57718a.a();
            View a3 = this.f57718a.a();
            kotlin.g.b.k.c(a3, "view");
            if (z) {
                AppCompatTextView appCompatTextView = (AppCompatTextView) a3.findViewById(R.id.tvTitle);
                kotlin.g.b.k.a((Object) appCompatTextView, "view.tvTitle");
                String obj = appCompatTextView.getText().toString();
                if (kotlin.g.b.k.a((Object) obj, (Object) a2.getContext().getString(R.string.paytm_balance1))) {
                    net.one97.paytm.passbook.utility.q.a(a2.getContext(), "uth_passbook", "paytm_bal_clicked", (String) null, (String) null, "/uth_passbook_myaccounts", "PASSBOOK");
                } else if (kotlin.g.b.k.a((Object) obj, (Object) a2.getContext().getString(R.string.paytm_money))) {
                    net.one97.paytm.passbook.utility.q.a(a2.getContext(), "uth_passbook", "Paytm_money_dropdown_clicked", (String) null, (String) null, "/uth_passbook_myaccounts", "PASSBOOK");
                }
            }
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57719a;

        f(a aVar) {
            this.f57719a = aVar;
        }

        public final void onClick(View view) {
            this.f57719a.a(C1092a.PPB_SA);
            if (!this.f57719a.M) {
                this.f57719a.x();
            }
            net.one97.paytm.passbook.utility.q.a(this.f57719a.N.getContext(), "uth_passbook", "SA_clicked", "SA_passbook", (String) null, "/uth_passbook_myaccounts", "PASSBOOK");
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57720a;

        g(a aVar) {
            this.f57720a = aVar;
        }

        public final void onClick(View view) {
            this.f57720a.a(C1092a.PPB_FD);
            if (!this.f57720a.M) {
                this.f57720a.x();
            }
            net.one97.paytm.passbook.utility.q.a(this.f57720a.N.getContext(), "uth_passbook", "SA_FD_clicked", "SA_FD_passbook", (String) null, "/uth_passbook_myaccounts", "PASSBOOK");
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57721a;

        h(a aVar) {
            this.f57721a = aVar;
        }

        public final void onClick(View view) {
            Context context;
            net.one97.paytm.passbook.landing.c.a aVar = this.f57721a.N;
            if (aVar != null && aVar.getActivity() != null && (context = this.f57721a.N.getContext()) != null) {
                kotlin.g.b.k.a((Object) context, "context");
                if (net.one97.paytm.passbook.utility.f.a(context)) {
                    String a2 = net.one97.paytm.passbook.d.b().a("passBuyFastagDeeplink");
                    if (TextUtils.isEmpty(a2)) {
                        a2 = "paytmmp://product?url=https://catalog.paytm.com/v1/mobile/product/131709010";
                    }
                    net.one97.paytm.passbook.d.b().a(a2, (Activity) this.f57721a.N.getActivity());
                    return;
                }
                net.one97.paytm.passbook.mapping.c.a(context, context.getString(R.string.no_connection), context.getString(R.string.no_internet_body));
            }
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57722a;

        i(a aVar) {
            this.f57722a = aVar;
        }

        public final void onClick(View view) {
            this.f57722a.a(C1092a.ICA);
            this.f57722a.x();
            net.one97.paytm.passbook.utility.q.a(this.f57722a.N.getContext(), "uth_passbook", "CA_clicked", "CA_passbook", (String) null, "/uth_passbook_myaccounts", "PASSBOOK");
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57723a;

        j(a aVar) {
            this.f57723a = aVar;
        }

        public final void onClick(View view) {
            this.f57723a.a(C1092a.ICA_FD);
            this.f57723a.x();
            net.one97.paytm.passbook.utility.q.a(this.f57723a.N.getContext(), "uth_passbook", "CA_FD_clicked", "CA_FD_passbook", (String) null, "/uth_passbook_myaccounts", "PASSBOOK");
        }
    }

    public static final class k implements UPIInitCardV2.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57724a;

        k(a aVar) {
            this.f57724a = aVar;
        }

        public final Fragment a() {
            if (this.f57724a.N.isAdded()) {
                return this.f57724a.N;
            }
            return null;
        }
    }

    static final class l implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57725a;

        l(a aVar) {
            this.f57725a = aVar;
        }

        public final void onClick(View view) {
            this.f57725a.A();
        }
    }

    private final void C() {
        PassbookBalanceCardView passbookBalanceCardView = this.n;
        if (passbookBalanceCardView == null) {
            kotlin.g.b.k.a("mPaytmRewardPointsCard");
        }
        passbookBalanceCardView.setOnClickListener(this.Q);
        PassbookBalanceCardView passbookBalanceCardView2 = this.j;
        if (passbookBalanceCardView2 == null) {
            kotlin.g.b.k.a("mBhimUPICard");
        }
        passbookBalanceCardView2.setOnClickListener(this.Q);
        PassbookBalanceCardView passbookBalanceCardView3 = this.l;
        if (passbookBalanceCardView3 == null) {
            kotlin.g.b.k.a("mCreditCardView");
        }
        passbookBalanceCardView3.setOnClickListener(this.Q);
    }

    static final class o implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57728a;

        o(a aVar) {
            this.f57728a = aVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity;
            if (kotlin.g.b.k.a((Object) view, (Object) this.f57728a.m())) {
                a aVar = this.f57728a;
                net.one97.paytm.passbook.landing.c.a aVar2 = aVar.N;
                if (aVar2 != null && (activity = aVar2.getActivity()) != null) {
                    Context context = aVar.N.getContext();
                    Context context2 = aVar.N.getContext();
                    net.one97.paytm.passbook.utility.q.a(context, "uth_passbook", "view_all_accounts_item_clicked", context2 != null ? context2.getString(R.string.pass_paytm_coins) : null, (String) null, "/uth_passbook_myaccounts", "PASSBOOK");
                    net.one97.paytm.passbook.d.b().a(net.one97.paytm.passbook.d.b().a("passPaytmCoinsDeeplink"), (Activity) activity);
                    net.one97.paytm.passbook.d.b().a(aVar.N.getContext(), "paytm_coins", "coins_passbook_clicked", (ArrayList<String>) null, "/paytm_passbook", "passbook");
                }
            } else if (kotlin.g.b.k.a((Object) view, (Object) this.f57728a.j())) {
                a aVar3 = this.f57728a;
                PassbookBalanceCardView passbookBalanceCardView = aVar3.j;
                if (passbookBalanceCardView == null) {
                    kotlin.g.b.k.a("mBhimUPICard");
                }
                View findViewById = passbookBalanceCardView.findViewById(R.id.tvReactivate);
                kotlin.g.b.k.a((Object) findViewById, "mBhimUPICard.findViewByI…tView>(R.id.tvReactivate)");
                if (((AppCompatTextView) findViewById).getVisibility() != 0) {
                    Context context3 = aVar3.N.getContext();
                    net.one97.paytm.passbook.mapping.f b2 = net.one97.paytm.passbook.d.b();
                    kotlin.g.b.k.a((Object) b2, "PassbookHelper.getImplListener()");
                    Intent intent = new Intent(context3, b2.c());
                    intent.putExtra(UpiConstants.EXTRA_KEY_IS_FROM_PASSBOOK, true);
                    intent.putExtra(UpiConstants.KEY_UPI_ITEM_TYPE, 0);
                    aVar3.N.startActivity(intent);
                }
                net.one97.paytm.passbook.utility.q.a(aVar3.N.getContext(), "uth_passbook", "UPI_clicked", "UPI_passbook", (String) null, "/uth_passbook_myaccounts", "PASSBOOK");
            } else if (kotlin.g.b.k.a((Object) view, (Object) this.f57728a.a())) {
                a.a(this.f57728a);
            } else if (kotlin.g.b.k.a((Object) view, (Object) this.f57728a.k())) {
                a aVar4 = this.f57728a;
                net.one97.paytm.passbook.utility.q.a(aVar4.N.getContext(), "uth_passbook", "pfcc_clicked", (String) null, (String) null, "/uth_passbook_myaccounts", "PASSBOOK");
                net.one97.paytm.passbook.d.b().a("paytmmp://paytmfirstcard?featuretype=passbook", (Activity) aVar4.N.getActivity());
            } else if (kotlin.g.b.k.a((Object) view, (Object) this.f57728a.d())) {
                a aVar5 = this.f57728a;
                net.one97.paytm.passbook.landing.b.b bVar = new net.one97.paytm.passbook.landing.b.b();
                net.one97.paytm.passbook.landing.c.a aVar6 = aVar5.N;
                if (aVar6 != null && aVar6.getChildFragmentManager() != null) {
                    bVar.show(aVar5.N.getChildFragmentManager().a(), bVar.getClass().getName());
                }
            }
        }
    }

    public final void a(PassbookBalanceCardView passbookBalanceCardView) {
        FragmentActivity activity;
        kotlin.g.b.k.c(passbookBalanceCardView, "upiCard");
        Context context = passbookBalanceCardView.getContext();
        if (context != null && net.one97.paytm.passbook.utility.f.a(context) && (activity = this.N.getActivity()) != null) {
            this.k = passbookBalanceCardView;
            net.one97.paytm.passbook.landing.repositories.k kVar = net.one97.paytm.passbook.landing.repositories.k.f57801b;
            kotlin.g.b.k.a((Object) activity, "fragmentActivity");
            net.one97.paytm.passbook.landing.repositories.k.a(passbookBalanceCardView, (Activity) activity, this.N, (UPICheckBalanceListenerCallback) new b(this, passbookBalanceCardView));
        }
    }

    public static final class b implements UPICheckBalanceListenerCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57714a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PassbookBalanceCardView f57715b;

        b(a aVar, PassbookBalanceCardView passbookBalanceCardView) {
            this.f57714a = aVar;
            this.f57715b = passbookBalanceCardView;
        }

        public final void onRequestStart() {
            net.one97.paytm.passbook.genericPassbook.d.a.f fVar = net.one97.paytm.passbook.genericPassbook.d.a.f.f57462b;
            net.one97.paytm.passbook.genericPassbook.d.a.f.a((LottieAnimationView) this.f57715b.findViewById(R.id.loaderCheckBalance), true);
            View findViewById = this.f57715b.findViewById(R.id.tvCheckBalance);
            kotlin.g.b.k.a((Object) findViewById, "upiCard.findViewById<App…iew>(R.id.tvCheckBalance)");
            ((AppCompatTextView) findViewById).setVisibility(4);
        }

        public final void onRequestEnd() {
            net.one97.paytm.passbook.genericPassbook.d.a.f fVar = net.one97.paytm.passbook.genericPassbook.d.a.f.f57462b;
            net.one97.paytm.passbook.genericPassbook.d.a.f.a((LottieAnimationView) this.f57715b.findViewById(R.id.loaderCheckBalance), false);
            View findViewById = this.f57715b.findViewById(R.id.tvCheckBalance);
            kotlin.g.b.k.a((Object) findViewById, "upiCard.findViewById<App…iew>(R.id.tvCheckBalance)");
            ((AppCompatTextView) findViewById).setVisibility(0);
        }

        public final void onFetchBalanceSuccess(String str, String str2, String str3) {
            kotlin.g.b.k.c(str3, "accountType");
            net.one97.paytm.passbook.genericPassbook.d.a.f fVar = net.one97.paytm.passbook.genericPassbook.d.a.f.f57462b;
            net.one97.paytm.passbook.genericPassbook.d.a.f.a((LottieAnimationView) this.f57715b.findViewById(R.id.loaderCheckBalance), false);
            View findViewById = this.f57715b.findViewById(R.id.tvCheckBalance);
            kotlin.g.b.k.a((Object) findViewById, "upiCard.findViewById<App…iew>(R.id.tvCheckBalance)");
            ((AppCompatTextView) findViewById).setVisibility(0);
            a aVar = this.f57714a;
            PassbookBalanceCardView passbookBalanceCardView = this.f57715b;
            if (aVar.N.isVisible()) {
                String str4 = null;
                if (!TextUtils.isEmpty(str2)) {
                    AppCompatTextView appCompatTextView = (AppCompatTextView) passbookBalanceCardView.a(R.id.tvCheckBalance);
                    kotlin.g.b.k.a((Object) appCompatTextView, "upiCard.tvCheckBalance");
                    appCompatTextView.setVisibility(8);
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) passbookBalanceCardView.a(R.id.tvAmount);
                    kotlin.g.b.k.a((Object) appCompatTextView2, "upiCard.tvAmount");
                    appCompatTextView2.setVisibility(0);
                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) passbookBalanceCardView.a(R.id.tvAmount);
                    kotlin.g.b.k.a((Object) appCompatTextView3, "upiCard.tvAmount");
                    TextView textView = appCompatTextView3;
                    Context context = passbookBalanceCardView.getContext();
                    int i2 = R.string.pass_rupee;
                    Object[] objArr = new Object[1];
                    if (str2 != null) {
                        str4 = net.one97.paytm.passbook.utility.f.b(Double.parseDouble(str2));
                    }
                    objArr[0] = str4;
                    String string = context.getString(i2, objArr);
                    kotlin.g.b.k.a((Object) string, "upiCard.context.getStrin…ouble()?.amountFormat2())");
                    net.one97.paytm.passbook.utility.f.a(textView, string);
                    return;
                }
                AppCompatTextView appCompatTextView4 = (AppCompatTextView) passbookBalanceCardView.a(R.id.tvCheckBalance);
                kotlin.g.b.k.a((Object) appCompatTextView4, "upiCard.tvCheckBalance");
                appCompatTextView4.setVisibility(0);
                AppCompatTextView appCompatTextView5 = (AppCompatTextView) passbookBalanceCardView.a(R.id.tvAmount);
                kotlin.g.b.k.a((Object) appCompatTextView5, "upiCard.tvAmount");
                appCompatTextView5.setVisibility(8);
                if (kotlin.g.b.k.a((Object) "ZM", (Object) null)) {
                    Toast.makeText(passbookBalanceCardView.getContext(), R.string.upi_incorrect_mpin, 1).show();
                }
            }
        }

        public final void onError(String str) {
            try {
                net.one97.paytm.passbook.genericPassbook.d.a.f fVar = net.one97.paytm.passbook.genericPassbook.d.a.f.f57462b;
                net.one97.paytm.passbook.genericPassbook.d.a.f.a((LottieAnimationView) this.f57715b.findViewById(R.id.loaderCheckBalance), false);
                View findViewById = this.f57715b.findViewById(R.id.tvCheckBalance);
                kotlin.g.b.k.a((Object) findViewById, "upiCard.findViewById<App…iew>(R.id.tvCheckBalance)");
                ((AppCompatTextView) findViewById).setVisibility(0);
                Toast.makeText(this.f57715b.getContext(), str, 0).show();
            } catch (Exception e2) {
                net.one97.paytm.common.utility.l.a((Throwable) e2);
            }
        }
    }

    private final void c(LinearLayout linearLayout) {
        ExpandableBalanceCardView expandableBalanceCardView = this.f57705a;
        if (expandableBalanceCardView == null) {
            kotlin.g.b.k.a("mPaytmWalletCard");
        }
        linearLayout.addView(expandableBalanceCardView);
        Integer num = this.L;
        if (num != null && num.intValue() == 0) {
            PassbookBalanceCardView passbookBalanceCardView = this.f57713i;
            if (passbookBalanceCardView == null) {
                kotlin.g.b.k.a("mPostPaidCard");
            }
            linearLayout.addView(passbookBalanceCardView);
        }
        PassbookBalanceCardView passbookBalanceCardView2 = this.f57709e;
        if (passbookBalanceCardView2 == null) {
            kotlin.g.b.k.a("mPaymentsBankSA");
        }
        linearLayout.addView(passbookBalanceCardView2);
        PassbookBalanceCardView passbookBalanceCardView3 = this.f57710f;
        if (passbookBalanceCardView3 == null) {
            kotlin.g.b.k.a("mFixedDepositSA");
        }
        linearLayout.addView(passbookBalanceCardView3);
        PassbookBalanceCardView passbookBalanceCardView4 = this.j;
        if (passbookBalanceCardView4 == null) {
            kotlin.g.b.k.a("mBhimUPICard");
        }
        linearLayout.addView(passbookBalanceCardView4);
        PassbookBalanceCardView passbookBalanceCardView5 = this.s;
        if (passbookBalanceCardView5 == null) {
            kotlin.g.b.k.a("mFastagCard");
        }
        linearLayout.addView(passbookBalanceCardView5);
        if (net.one97.paytm.passbook.d.b().a("pass2PFCCEnabled", false)) {
            PassbookBalanceCardView passbookBalanceCardView6 = this.l;
            if (passbookBalanceCardView6 == null) {
                kotlin.g.b.k.a("mCreditCardView");
            }
            linearLayout.addView(passbookBalanceCardView6);
        }
        if (net.one97.paytm.passbook.d.b().a("icaEnabled", false)) {
            PassbookBalanceCardView passbookBalanceCardView7 = this.f57711g;
            if (passbookBalanceCardView7 == null) {
                kotlin.g.b.k.a("mCurrentAccountCard");
            }
            linearLayout.addView(passbookBalanceCardView7);
            PassbookBalanceCardView passbookBalanceCardView8 = this.f57712h;
            if (passbookBalanceCardView8 == null) {
                kotlin.g.b.k.a("mFDCurrentAccountCard");
            }
            linearLayout.addView(passbookBalanceCardView8);
        }
        boolean a2 = net.one97.paytm.passbook.d.b().a("pass2PaytmMoneyEnabled", false);
        boolean a3 = net.one97.paytm.passbook.d.b().a("pass2PaytmGoldEnabled", true);
        Integer num2 = this.L;
        if (num2 != null && num2.intValue() == 0) {
            if (net.one97.paytm.passbook.d.b().a("pfg_passbook_card", true)) {
                PassbookBalanceCardView passbookBalanceCardView9 = this.q;
                if (passbookBalanceCardView9 == null) {
                    kotlin.g.b.k.a("mPFGCard");
                }
                linearLayout.addView(passbookBalanceCardView9);
            }
            if (net.one97.paytm.passbook.d.b().a("passVoucherSectionEnabled", false)) {
                if (net.one97.paytm.passbook.d.b().a("pass2CashbackVouchersEnabled", false)) {
                    PassbookBalanceCardView passbookBalanceCardView10 = this.m;
                    if (passbookBalanceCardView10 == null) {
                        kotlin.g.b.k.a("mCashBackVouchersCard");
                    }
                    linearLayout.addView(passbookBalanceCardView10);
                }
                if (net.one97.paytm.passbook.d.b().a("passPaytmRewardPointsEnabled", false)) {
                    PassbookBalanceCardView passbookBalanceCardView11 = this.n;
                    if (passbookBalanceCardView11 == null) {
                        kotlin.g.b.k.a("mPaytmRewardPointsCard");
                    }
                    linearLayout.addView(passbookBalanceCardView11);
                }
                if (net.one97.paytm.passbook.d.b().a("pass2LoyaltyRewardsEnabled", false)) {
                    PassbookBalanceCardView passbookBalanceCardView12 = this.o;
                    if (passbookBalanceCardView12 == null) {
                        kotlin.g.b.k.a("mBrandRewardPointsCard");
                    }
                    linearLayout.addView(passbookBalanceCardView12);
                }
                if (net.one97.paytm.passbook.d.b().a("passStickersEnabled", false)) {
                    PassbookBalanceCardView passbookBalanceCardView13 = this.p;
                    if (passbookBalanceCardView13 == null) {
                        kotlin.g.b.k.a("mStickersCard");
                    }
                    linearLayout.addView(passbookBalanceCardView13);
                }
            }
            if (a2) {
                PassbookBalanceCardView passbookBalanceCardView14 = this.f57707c;
                if (passbookBalanceCardView14 == null) {
                    kotlin.g.b.k.a("mMutualFundCard");
                }
                linearLayout.addView(passbookBalanceCardView14);
            }
            if (a3) {
                PassbookBalanceCardView passbookBalanceCardView15 = this.r;
                if (passbookBalanceCardView15 == null) {
                    kotlin.g.b.k.a("mPaytmGoldCard");
                }
                linearLayout.addView(passbookBalanceCardView15);
            }
            if (a2) {
                PassbookBalanceCardView passbookBalanceCardView16 = this.f57706b;
                if (passbookBalanceCardView16 == null) {
                    kotlin.g.b.k.a("mNPSCard");
                }
                linearLayout.addView(passbookBalanceCardView16);
            }
        }
        PassbookBalanceCardView passbookBalanceCardView17 = this.f57708d;
        if (passbookBalanceCardView17 == null) {
            kotlin.g.b.k.a("mPaytmWalletActivateCard");
        }
        linearLayout.addView(passbookBalanceCardView17);
        Integer num3 = this.L;
        if (num3 != null && num3.intValue() == 0) {
            InitCards initCards = this.w;
            if (initCards == null) {
                kotlin.g.b.k.a("mPostPaidInitCard");
            }
            linearLayout.addView(initCards);
        }
        InitCards initCards2 = this.v;
        if (initCards2 == null) {
            kotlin.g.b.k.a("mPaymentsBankInitCardV2");
        }
        linearLayout.addView(initCards2);
        UPIInitCardV2 uPIInitCardV2 = this.z;
        if (uPIInitCardV2 == null) {
            kotlin.g.b.k.a("mUpiInitCardV2");
        }
        linearLayout.addView(uPIInitCardV2);
        InitCards initCards3 = this.y;
        if (initCards3 == null) {
            kotlin.g.b.k.a("mFastagInitCard");
        }
        linearLayout.addView(initCards3);
        Integer num4 = this.L;
        if (num4 != null && num4.intValue() == 0) {
            if (a2) {
                InitCards initCards4 = this.t;
                if (initCards4 == null) {
                    kotlin.g.b.k.a("mMutualFundInitCard");
                }
                linearLayout.addView(initCards4);
            }
            if (a3) {
                InitCards initCards5 = this.x;
                if (initCards5 == null) {
                    kotlin.g.b.k.a("mPaytmGoldInitCard");
                }
                linearLayout.addView(initCards5);
            }
            if (a2) {
                InitCards initCards6 = this.u;
                if (initCards6 == null) {
                    kotlin.g.b.k.a("mNPSInitCard");
                }
                linearLayout.addView(initCards6);
            }
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57716a;

        public c(a aVar) {
            this.f57716a = aVar;
        }

        public final void onClick(View view) {
            this.f57716a.v();
        }
    }

    public final void v() {
        TextView textView;
        LinearLayout linearLayout;
        if (this.O == 0 && (linearLayout = (LinearLayout) this.N.a(R.id.itemsLayout)) != null) {
            LayoutTransition layoutTransition = new LayoutTransition();
            layoutTransition.disableTransitionType(3);
            linearLayout.setLayoutTransition(layoutTransition);
        }
        x.c cVar = new x.c();
        x.c cVar2 = new x.c();
        if (this.P) {
            if (this.O == 0) {
                net.one97.paytm.passbook.utility.q.a(this.N.getContext(), "uth_passbook", "view_less_accounts_clicked", (String) null, (String) null, "/uth_passbook_myaccounts", "PASSBOOK");
            }
            this.P = false;
            LinearLayout linearLayout2 = (LinearLayout) this.N.a(R.id.itemsLayout);
            kotlin.g.b.k.a((Object) linearLayout2, "balanceSummaryFragment.itemsLayout");
            b(linearLayout2);
            cVar.element = R.string.view_all_accounts;
            cVar2.element = R.drawable.pass_arrow_icon_red;
            ExpandableBalanceCardView expandableBalanceCardView = this.f57705a;
            if (expandableBalanceCardView == null) {
                kotlin.g.b.k.a("mPaytmWalletCard");
            }
            LinearLayout linearLayout3 = (LinearLayout) expandableBalanceCardView.a(R.id.llSubWalletContainer);
            kotlin.g.b.k.a((Object) linearLayout3, "mPaytmWalletCard.llSubWalletContainer");
            linearLayout3.setVisibility(8);
            a(false);
            View view = this.N.getView();
            if (!(view == null || (textView = (TextView) view.findViewById(R.id.tvExpendCollapsSubwallet)) == null)) {
                textView.setVisibility(4);
                new Handler().postDelayed(new a.d(textView), 300);
            }
        } else {
            net.one97.paytm.passbook.utility.q.a(this.N.getContext(), "uth_passbook", "view_all_accounts_clicked", (String) null, (String) null, "/uth_passbook_myaccounts", "PASSBOOK");
            LinearLayout linearLayout4 = (LinearLayout) this.N.a(R.id.itemsLayout);
            kotlin.g.b.k.a((Object) linearLayout4, "balanceSummaryFragment.itemsLayout");
            d(linearLayout4);
            cVar.element = R.string.view_less;
            cVar2.element = R.drawable.pass_arrow_up_icon_pdp;
            ExpandableBalanceCardView expandableBalanceCardView2 = this.f57705a;
            if (expandableBalanceCardView2 == null) {
                kotlin.g.b.k.a("mPaytmWalletCard");
            }
            LinearLayout linearLayout5 = (LinearLayout) expandableBalanceCardView2.a(R.id.llSubWalletContainer);
            kotlin.g.b.k.a((Object) linearLayout5, "mPaytmWalletCard.llSubWalletContainer");
            linearLayout5.setVisibility(0);
            a(true);
            this.P = true;
        }
        TextView textView2 = (TextView) this.N.a(R.id.tvExpendCollapsSubwallet);
        textView2.setText(cVar.element);
        textView2.setCompoundDrawablesWithIntrinsicBounds(0, 0, cVar2.element, 0);
        ((LinearLayout) this.N.a(R.id.itemsLayout)).requestLayout();
        this.O++;
    }

    private final void a(boolean z2) {
        AppBarLayout appBarLayout;
        if (!z2) {
            try {
                net.one97.paytm.passbook.landing.c.a aVar = this.N;
                FragmentActivity activity = aVar != null ? aVar.getActivity() : null;
                if (!(activity instanceof PassbookLandingActivity)) {
                    activity = null;
                }
                PassbookLandingActivity passbookLandingActivity = (PassbookLandingActivity) activity;
                if (!(passbookLandingActivity == null || (appBarLayout = (AppBarLayout) passbookLandingActivity.findViewById(R.id.appbar)) == null)) {
                    appBarLayout.setExpanded(!z2);
                }
            } catch (Exception e2) {
                net.one97.paytm.common.utility.l.a((Throwable) e2);
                return;
            }
        }
        ExpandableBalanceCardView expandableBalanceCardView = this.f57705a;
        if (expandableBalanceCardView == null) {
            kotlin.g.b.k.a("mPaytmWalletCard");
        }
        CustomToggleButton customToggleButton = (CustomToggleButton) expandableBalanceCardView.a(R.id.expendCollapsBtn);
        kotlin.g.b.k.a((Object) customToggleButton, "mPaytmWalletCard.expendCollapsBtn");
        customToggleButton.setChecked(z2);
    }

    public final void w() {
        LinearLayout linearLayout;
        net.one97.paytm.passbook.landing.c.a aVar = this.N;
        if (!(aVar == null || (linearLayout = (LinearLayout) aVar.a(R.id.itemsLayout)) == null)) {
            linearLayout.removeAllViews();
        }
        net.one97.paytm.passbook.landing.c.a aVar2 = this.N;
        LinearLayout linearLayout2 = aVar2 != null ? (LinearLayout) aVar2.a(R.id.itemsLayout) : null;
        kotlin.g.b.k.a((Object) linearLayout2, "balanceSummaryFragment?.itemsLayout");
        a(linearLayout2);
        B();
    }

    public final void x() {
        if (this.D) {
            y();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("ENTER_HEADER", "paytm_saving_account_confirm");
        net.one97.paytm.passbook.d.b().a((Activity) this.N.getActivity(), intent);
        this.N.startActivityForResult(intent, 1025);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00f9, code lost:
        if (r0.getVisibility() == 0) goto L_0x00fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0040, code lost:
        if (r0.getVisibility() == 0) goto L_0x0042;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void y() {
        /*
            r8 = this;
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r8.f57709e
            java.lang.String r1 = "mPaymentsBankSA"
            if (r0 != 0) goto L_0x0009
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0009:
            android.view.View r0 = r0.getMView()
            int r2 = net.one97.paytm.passbook.R.id.tvCheckBalance
            android.view.View r0 = r0.findViewById(r2)
            androidx.appcompat.widget.AppCompatTextView r0 = (androidx.appcompat.widget.AppCompatTextView) r0
            java.lang.String r2 = "mPaymentsBankSA.mView.tvCheckBalance"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            int r0 = r0.getVisibility()
            java.lang.String r3 = "mFixedDepositSA.mView.tvCheckBalance"
            r4 = 1
            java.lang.String r5 = "mFixedDepositSA"
            r6 = 4
            if (r0 == 0) goto L_0x0042
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r8.f57710f
            if (r0 != 0) goto L_0x002d
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x002d:
            android.view.View r0 = r0.getMView()
            int r7 = net.one97.paytm.passbook.R.id.tvCheckBalance
            android.view.View r0 = r0.findViewById(r7)
            androidx.appcompat.widget.AppCompatTextView r0 = (androidx.appcompat.widget.AppCompatTextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x00bb
        L_0x0042:
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r8.f57709e
            if (r0 != 0) goto L_0x0049
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0049:
            android.view.View r0 = r0.getMView()
            int r7 = net.one97.paytm.passbook.R.id.tvCheckBalance
            android.view.View r0 = r0.findViewById(r7)
            androidx.appcompat.widget.AppCompatTextView r0 = (androidx.appcompat.widget.AppCompatTextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            r0.setVisibility(r6)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r8.f57710f
            if (r0 != 0) goto L_0x0062
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0062:
            android.view.View r0 = r0.getMView()
            int r2 = net.one97.paytm.passbook.R.id.tvCheckBalance
            android.view.View r0 = r0.findViewById(r2)
            androidx.appcompat.widget.AppCompatTextView r0 = (androidx.appcompat.widget.AppCompatTextView) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            r0.setVisibility(r6)
            net.one97.paytm.passbook.genericPassbook.d.a.f r0 = net.one97.paytm.passbook.genericPassbook.d.a.f.f57462b
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r8.f57709e
            if (r0 != 0) goto L_0x007d
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x007d:
            int r1 = net.one97.paytm.passbook.R.id.loaderCheckBalance
            android.view.View r0 = r0.findViewById(r1)
            com.airbnb.lottie.LottieAnimationView r0 = (com.airbnb.lottie.LottieAnimationView) r0
            net.one97.paytm.passbook.genericPassbook.d.a.f.a(r0, r4)
            net.one97.paytm.passbook.genericPassbook.d.a.f r0 = net.one97.paytm.passbook.genericPassbook.d.a.f.f57462b
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r8.f57710f
            if (r0 != 0) goto L_0x0091
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0091:
            int r1 = net.one97.paytm.passbook.R.id.loaderCheckBalance
            android.view.View r0 = r0.findViewById(r1)
            com.airbnb.lottie.LottieAnimationView r0 = (com.airbnb.lottie.LottieAnimationView) r0
            net.one97.paytm.passbook.genericPassbook.d.a.f.a(r0, r4)
            net.one97.paytm.passbook.landing.c.a r0 = r8.N
            net.one97.paytm.passbook.landing.g.a r0 = r0.a()
            r0.c()
            net.one97.paytm.passbook.landing.c.a r0 = r8.N
            net.one97.paytm.passbook.landing.g.a r0 = r0.a()
            androidx.lifecycle.y<net.one97.paytm.passbook.landing.e.a> r0 = r0.f57738a
            net.one97.paytm.passbook.landing.c.a r1 = r8.N
            androidx.lifecycle.q r1 = (androidx.lifecycle.q) r1
            net.one97.paytm.passbook.landing.f.a$n r2 = new net.one97.paytm.passbook.landing.f.a$n
            r2.<init>(r8)
            androidx.lifecycle.z r2 = (androidx.lifecycle.z) r2
            r0.observe(r1, r2)
        L_0x00bb:
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r8.f57711g
            if (r0 != 0) goto L_0x00c4
            java.lang.String r1 = "mCurrentAccountCard"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00c4:
            android.view.View r0 = r0.getMView()
            int r1 = net.one97.paytm.passbook.R.id.tvCheckBalance
            android.view.View r0 = r0.findViewById(r1)
            androidx.appcompat.widget.AppCompatTextView r0 = (androidx.appcompat.widget.AppCompatTextView) r0
            java.lang.String r1 = "mCurrentAccountCard.mView.tvCheckBalance"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            int r0 = r0.getVisibility()
            if (r0 == 0) goto L_0x00fb
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r8.f57712h
            if (r0 != 0) goto L_0x00e4
            java.lang.String r1 = "mFDCurrentAccountCard"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00e4:
            android.view.View r0 = r0.getMView()
            int r1 = net.one97.paytm.passbook.R.id.tvCheckBalance
            android.view.View r0 = r0.findViewById(r1)
            androidx.appcompat.widget.AppCompatTextView r0 = (androidx.appcompat.widget.AppCompatTextView) r0
            java.lang.String r1 = "mFDCurrentAccountCard.mView.tvCheckBalance"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0108
        L_0x00fb:
            java.lang.String r0 = r8.K
            if (r0 == 0) goto L_0x0108
            net.one97.paytm.passbook.landing.c.a r1 = r8.N
            net.one97.paytm.passbook.landing.g.a r1 = r1.a()
            r1.a((java.lang.String) r0)
        L_0x0108:
            r0 = r8
            net.one97.paytm.passbook.landing.f.a r0 = (net.one97.paytm.passbook.landing.f.a) r0
            net.one97.paytm.passbook.landing.f.a$a r0 = r0.C
            if (r0 == 0) goto L_0x017c
            boolean r0 = r8.M
            if (r0 != 0) goto L_0x017c
            net.one97.paytm.passbook.landing.f.a$a r0 = r8.C
            if (r0 != 0) goto L_0x011c
            java.lang.String r1 = "cardClickSource"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x011c:
            int[] r1 = net.one97.paytm.passbook.landing.f.b.f57734a
            int r0 = r0.ordinal()
            r0 = r1[r0]
            java.lang.String r1 = "passbook_type"
            if (r0 == r4) goto L_0x015b
            r2 = 2
            if (r0 == r2) goto L_0x0157
            r2 = 3
            if (r0 == r2) goto L_0x0135
            if (r0 == r6) goto L_0x0131
            goto L_0x017c
        L_0x0131:
            r8.E()
            goto L_0x017c
        L_0x0135:
            android.content.Intent r0 = new android.content.Intent
            net.one97.paytm.passbook.landing.c.a r2 = r8.N
            android.content.Context r2 = r2.getContext()
            java.lang.Class<net.one97.paytm.passbook.genericPassbook.activity.PassbookL2Activity> r3 = net.one97.paytm.passbook.genericPassbook.activity.PassbookL2Activity.class
            r0.<init>(r2, r3)
            net.one97.paytm.passbook.utility.n r2 = net.one97.paytm.passbook.utility.n.ICA_CURRENT_ACCOUNT
            int r2 = r2.getValue()
            r0.putExtra(r1, r2)
            net.one97.paytm.passbook.landing.c.a r1 = r8.N
            android.content.Context r1 = r1.getContext()
            if (r1 == 0) goto L_0x0156
            r1.startActivity(r0)
        L_0x0156:
            return
        L_0x0157:
            r8.z()
            return
        L_0x015b:
            android.content.Intent r0 = new android.content.Intent
            net.one97.paytm.passbook.landing.c.a r2 = r8.N
            android.content.Context r2 = r2.getContext()
            java.lang.Class<net.one97.paytm.passbook.genericPassbook.activity.PassbookL2Activity> r3 = net.one97.paytm.passbook.genericPassbook.activity.PassbookL2Activity.class
            r0.<init>(r2, r3)
            net.one97.paytm.passbook.utility.n r2 = net.one97.paytm.passbook.utility.n.SAVINGS_ACCOUNT
            int r2 = r2.getValue()
            r0.putExtra(r1, r2)
            net.one97.paytm.passbook.landing.c.a r1 = r8.N
            android.content.Context r1 = r1.getContext()
            if (r1 == 0) goto L_0x017c
            r1.startActivity(r0)
        L_0x017c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.landing.f.a.y():void");
    }

    private final void D() {
        this.N.a().f57738a.observe(this.N, new m(this));
    }

    private final void E() {
        if (this.I != null && this.J != null) {
            net.one97.paytm.passbook.mapping.f b2 = net.one97.paytm.passbook.d.b();
            Activity activity = this.N.getActivity();
            String str = this.H;
            Double d2 = this.I;
            if (d2 == null) {
                kotlin.g.b.k.a();
            }
            double doubleValue = d2.doubleValue();
            Double d3 = this.J;
            if (d3 == null) {
                kotlin.g.b.k.a();
            }
            b2.a(activity, str, doubleValue, d3.doubleValue(), this.K);
        }
    }

    /* access modifiers changed from: package-private */
    public final void z() {
        if (this.E != null && this.F != null && this.G != null) {
            net.one97.paytm.passbook.mapping.f b2 = net.one97.paytm.passbook.d.b();
            Activity activity = this.N.getActivity();
            String str = this.E;
            Double d2 = this.F;
            if (d2 == null) {
                kotlin.g.b.k.a();
            }
            double doubleValue = d2.doubleValue();
            Double d3 = this.G;
            if (d3 == null) {
                kotlin.g.b.k.a();
            }
            b2.a(activity, str, doubleValue, d3.doubleValue());
        }
    }

    public final void a(String str, String str2) {
        if (this.N.isVisible()) {
            if (!TextUtils.isEmpty(str)) {
                PassbookBalanceCardView passbookBalanceCardView = this.j;
                if (passbookBalanceCardView == null) {
                    kotlin.g.b.k.a("mBhimUPICard");
                }
                View findViewById = passbookBalanceCardView.findViewById(R.id.tvCheckBalance);
                kotlin.g.b.k.a((Object) findViewById, "mBhimUPICard.findViewByI…iew>(R.id.tvCheckBalance)");
                ((AppCompatTextView) findViewById).setVisibility(8);
                PassbookBalanceCardView passbookBalanceCardView2 = this.j;
                if (passbookBalanceCardView2 == null) {
                    kotlin.g.b.k.a("mBhimUPICard");
                }
                View findViewById2 = passbookBalanceCardView2.findViewById(R.id.tvAmount);
                kotlin.g.b.k.a((Object) findViewById2, "mBhimUPICard.findViewByI…tTextView>(R.id.tvAmount)");
                ((AppCompatTextView) findViewById2).setVisibility(0);
                PassbookBalanceCardView passbookBalanceCardView3 = this.j;
                if (passbookBalanceCardView3 == null) {
                    kotlin.g.b.k.a("mBhimUPICard");
                }
                View findViewById3 = passbookBalanceCardView3.findViewById(R.id.tvAmount);
                kotlin.g.b.k.a((Object) findViewById3, "mBhimUPICard.findViewByI…tTextView>(R.id.tvAmount)");
                TextView textView = (TextView) findViewById3;
                PassbookBalanceCardView passbookBalanceCardView4 = this.j;
                if (passbookBalanceCardView4 == null) {
                    kotlin.g.b.k.a("mBhimUPICard");
                }
                Context context = passbookBalanceCardView4.getContext();
                int i2 = R.string.pass_rupee;
                Object[] objArr = new Object[1];
                objArr[0] = str != null ? net.one97.paytm.passbook.utility.f.b(Double.parseDouble(str)) : null;
                String string = context.getString(i2, objArr);
                kotlin.g.b.k.a((Object) string, "mBhimUPICard.context.get…ouble()?.amountFormat2())");
                net.one97.paytm.passbook.utility.f.a(textView, string);
                return;
            }
            PassbookBalanceCardView passbookBalanceCardView5 = this.j;
            if (passbookBalanceCardView5 == null) {
                kotlin.g.b.k.a("mBhimUPICard");
            }
            View findViewById4 = passbookBalanceCardView5.findViewById(R.id.tvCheckBalance);
            kotlin.g.b.k.a((Object) findViewById4, "mBhimUPICard.findViewByI…iew>(R.id.tvCheckBalance)");
            ((AppCompatTextView) findViewById4).setVisibility(0);
            PassbookBalanceCardView passbookBalanceCardView6 = this.j;
            if (passbookBalanceCardView6 == null) {
                kotlin.g.b.k.a("mBhimUPICard");
            }
            View findViewById5 = passbookBalanceCardView6.findViewById(R.id.tvAmount);
            kotlin.g.b.k.a((Object) findViewById5, "mBhimUPICard.findViewByI…tTextView>(R.id.tvAmount)");
            ((AppCompatTextView) findViewById5).setVisibility(8);
            if (kotlin.g.b.k.a((Object) "ZM", (Object) str2)) {
                Toast.makeText(this.N.getContext(), R.string.upi_incorrect_mpin, 1).show();
            }
        }
    }

    public static final class q implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57730a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.paytm.utility.h f57731b;

        public q(a aVar, com.paytm.utility.h hVar) {
            this.f57730a = aVar;
            this.f57731b = hVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.passbook.landing.repositories.k kVar = net.one97.paytm.passbook.landing.repositories.k.f57801b;
            net.one97.paytm.passbook.landing.repositories.k.a(this.f57730a.N);
            this.f57731b.dismiss();
        }
    }

    public static final class r implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57732a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.paytm.utility.h f57733b;

        public r(a aVar, com.paytm.utility.h hVar) {
            this.f57732a = aVar;
            this.f57733b = hVar;
        }

        public final void onClick(View view) {
            BankAccountDetails.BankAccount debitBank;
            List arrayList = new ArrayList();
            net.one97.paytm.passbook.landing.repositories.k kVar = net.one97.paytm.passbook.landing.repositories.k.f57801b;
            UpiProfileDefaultBank b2 = net.one97.paytm.passbook.landing.repositories.k.b();
            if (!(b2 == null || (debitBank = b2.getDebitBank()) == null)) {
                arrayList.add(debitBank);
            }
            net.one97.paytm.passbook.landing.repositories.k kVar2 = net.one97.paytm.passbook.landing.repositories.k.f57801b;
            UpiProfileDefaultBank b3 = net.one97.paytm.passbook.landing.repositories.k.b();
            this.f57732a.N.startActivityForResult(net.one97.paytm.passbook.d.b().a(this.f57732a.N.getContext(), new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, b3 != null ? b3.getVirtualAddress() : null).setBankAccountList(arrayList).build()), 288);
            this.f57733b.dismiss();
        }
    }

    public final void A() {
        Context context = this.N.getContext();
        net.one97.paytm.passbook.mapping.f b2 = net.one97.paytm.passbook.d.b();
        kotlin.g.b.k.a((Object) b2, "PassbookHelper.getImplListener()");
        Intent intent = new Intent(context, b2.e());
        intent.putExtra("redirect", 304);
        this.N.startActivityForResult(intent, 304);
    }

    public static final class p implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57729a;

        public p(a aVar) {
            this.f57729a = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            TextView textView = (TextView) this.f57729a.N.a(R.id.tvExpendCollapsSubwallet);
            kotlin.g.b.k.a((Object) textView, "balanceSummaryFragment.tvExpendCollapsSubwallet");
            textView.setVisibility(0);
            this.f57729a.B();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0013, code lost:
        r0 = (r0 = r0.getActivity()).getSupportFragmentManager();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void B() {
        /*
            r2 = this;
            net.one97.paytm.passbook.landing.c.a r0 = r2.N
            net.one97.paytm.passbook.landing.g.a r0 = r0.a()
            r0.a()
            net.one97.paytm.passbook.landing.c.a r0 = r2.N
            if (r0 == 0) goto L_0x0020
            androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
            if (r0 == 0) goto L_0x0020
            androidx.fragment.app.j r0 = r0.getSupportFragmentManager()
            if (r0 == 0) goto L_0x0020
            int r1 = net.one97.paytm.passbook.R.id.paymentHistoryFragmentContainer
            androidx.fragment.app.Fragment r0 = r0.c((int) r1)
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            boolean r1 = r0 instanceof net.one97.paytm.passbook.landing.c.b
            if (r1 == 0) goto L_0x002a
            net.one97.paytm.passbook.landing.c.b r0 = (net.one97.paytm.passbook.landing.c.b) r0
            r0.c()
        L_0x002a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.landing.f.a.B():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(android.widget.LinearLayout r9) {
        /*
            r8 = this;
            java.lang.String r0 = "itemsLayout"
            kotlin.g.b.k.c(r9, r0)
            boolean r0 = r8.P
            java.lang.String r1 = "mFixedDepositSA"
            if (r0 != 0) goto L_0x001c
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r8.f57710f
            if (r0 != 0) goto L_0x0012
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0012:
            android.view.View r0 = (android.view.View) r0
            int r0 = r9.indexOfChild(r0)
            if (r0 <= 0) goto L_0x001c
            r0 = 6
            goto L_0x001d
        L_0x001c:
            r0 = 5
        L_0x001d:
            int r2 = r9.getChildCount()
            r3 = 8
            if (r2 < 0) goto L_0x004d
            r4 = 0
            r5 = 0
        L_0x0027:
            android.view.View r6 = r9.getChildAt(r5)
            if (r6 == 0) goto L_0x0048
            boolean r7 = r8.P
            if (r7 != 0) goto L_0x0038
            if (r5 >= r0) goto L_0x0034
            goto L_0x0038
        L_0x0034:
            r6.setVisibility(r3)
            goto L_0x0048
        L_0x0038:
            r6.setVisibility(r4)
            if (r5 != 0) goto L_0x0048
            int r7 = net.one97.paytm.passbook.R.id.card_top_border
            android.view.View r6 = r6.findViewById(r7)
            if (r6 == 0) goto L_0x0048
            r6.setVisibility(r3)
        L_0x0048:
            if (r5 == r2) goto L_0x004d
            int r5 = r5 + 1
            goto L_0x0027
        L_0x004d:
            boolean r0 = r8.P
            if (r0 != 0) goto L_0x006a
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r8.f57710f
            if (r0 != 0) goto L_0x0058
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0058:
            android.view.View r0 = (android.view.View) r0
            int r9 = r9.indexOfChild(r0)
            if (r9 <= 0) goto L_0x006a
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r9 = r8.f57710f
            if (r9 != 0) goto L_0x0067
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0067:
            r9.setVisibility(r3)
        L_0x006a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.landing.f.a.b(android.widget.LinearLayout):void");
    }

    private static void d(LinearLayout linearLayout) {
        kotlin.g.b.k.c(linearLayout, "itemsLayout");
        int childCount = linearLayout.getChildCount();
        if (childCount >= 0) {
            int i2 = 0;
            while (true) {
                View childAt = linearLayout.getChildAt(i2);
                if (childAt != null) {
                    childAt.setVisibility(0);
                }
                if (i2 != childCount) {
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public static final /* synthetic */ void a(a aVar) {
        boolean z2;
        kotlin.g.b.k.a((Object) net.one97.paytm.passbook.mapping.e.a(), "GTMLoader.getInstance()");
        if (net.one97.paytm.passbook.mapping.e.E()) {
            if (aVar.P) {
                z2 = net.one97.paytm.passbook.d.b().a("passCollapseOnCardClick", false);
            } else {
                z2 = net.one97.paytm.passbook.d.b().a("passExpandOnCardClick", false);
            }
            if (z2) {
                aVar.v();
            }
        }
    }
}
