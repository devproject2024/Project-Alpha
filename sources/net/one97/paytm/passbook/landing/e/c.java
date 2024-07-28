package net.one97.paytm.passbook.landing.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.appsflyer.internal.referrer.Payload;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.CJRCashWallet;
import net.one97.paytm.passbook.beans.CJRCashWalletResponse;
import net.one97.paytm.passbook.beans.CJRSubWallet;
import net.one97.paytm.passbook.cashbackVoucher.CashbackVoucherActivity;
import net.one97.paytm.passbook.main.entity.MultiSubWallet;
import net.one97.paytm.passbook.main.widget.ExpandableBalanceCardView;
import net.one97.paytm.passbook.main.widget.PassbookBalanceCardView;
import net.one97.paytm.passbook.mapping.a.f;
import net.one97.paytm.passbook.subWallet.PassbookSubwalletActivity;
import net.one97.paytm.passbook.utility.m;
import net.one97.paytm.passbook.utility.n;
import net.one97.paytm.passbook.utility.q;

public final class c extends a {

    /* renamed from: a  reason: collision with root package name */
    public f<? extends CJRCashWallet> f57638a;

    /* renamed from: b  reason: collision with root package name */
    private int f57639b;

    public c(f<? extends CJRCashWallet> fVar) {
        k.c(fVar, Payload.RESPONSE);
        this.f57638a = fVar;
    }

    public static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRCashWallet f57640a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f57641b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.passbook.landing.f.a f57642c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ LinearLayout f57643d;

        public a(CJRCashWallet cJRCashWallet, c cVar, net.one97.paytm.passbook.landing.f.a aVar, LinearLayout linearLayout) {
            this.f57640a = cJRCashWallet;
            this.f57641b = cVar;
            this.f57642c = aVar;
            this.f57643d = linearLayout;
        }

        public final void onClick(View view) {
            k.a((Object) view, "cashbackVoucherCard");
            q.a(view.getContext(), "uth_passbook", "cb_vouchers_clicked", (String) null, (String) null, "/uth_passbook_myaccounts", "PASSBOOK");
            Context context = view.getContext();
            k.a((Object) context, "cashbackVoucherCard.context");
            CJRCashWalletResponse response = this.f57640a.getResponse();
            k.a((Object) response, "it.response");
            Intent intent = new Intent(context, CashbackVoucherActivity.class);
            intent.putExtra("cashWalletResponseKey", response);
            context.startActivity(intent);
        }
    }

    public static void a(ExpandableBalanceCardView expandableBalanceCardView) {
        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) expandableBalanceCardView.a(R.id.expandableCardShimmerLayout);
        k.a((Object) shimmerFrameLayout, "paytmBalanceCard.expandableCardShimmerLayout");
        shimmerFrameLayout.setVisibility(8);
    }

    /* renamed from: net.one97.paytm.passbook.landing.e.c$c  reason: collision with other inner class name */
    public static final class C1091c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f57649a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MultiSubWallet f57650b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ PassbookBalanceCardView f57651c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Collection f57652d;

        public C1091c(c cVar, MultiSubWallet multiSubWallet, PassbookBalanceCardView passbookBalanceCardView, Collection collection) {
            this.f57649a = cVar;
            this.f57650b = multiSubWallet;
            this.f57651c = passbookBalanceCardView;
            this.f57652d = collection;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0011, code lost:
            r9 = r9.get(0);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r9) {
            /*
                r8 = this;
                java.lang.String r0 = "it"
                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
                android.content.Context r1 = r9.getContext()
                net.one97.paytm.passbook.main.entity.MultiSubWallet r9 = r8.f57650b
                java.util.ArrayList r9 = r9.getSubWalletList()
                if (r9 == 0) goto L_0x001f
                r0 = 0
                java.lang.Object r9 = r9.get(r0)
                net.one97.paytm.passbook.beans.CJRSubWallet r9 = (net.one97.paytm.passbook.beans.CJRSubWallet) r9
                if (r9 == 0) goto L_0x001f
                java.lang.String r9 = r9.getDisplayName()
                goto L_0x0020
            L_0x001f:
                r9 = 0
            L_0x0020:
                r4 = r9
                r5 = 0
                java.lang.String r2 = "uth_passbook"
                java.lang.String r3 = "paytm_bal_item_clicked"
                java.lang.String r6 = "/uth_passbook_myaccounts"
                java.lang.String r7 = "PASSBOOK"
                net.one97.paytm.passbook.utility.q.a(r1, r2, r3, r4, r5, r6, r7)
                net.one97.paytm.passbook.main.entity.MultiSubWallet r9 = r8.f57650b
                int r9 = r9.getSubWalletType()
                net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r8.f57651c
                net.one97.paytm.passbook.main.entity.MultiSubWallet r1 = r8.f57650b
                net.one97.paytm.passbook.landing.e.c.a(r9, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.landing.e.c.C1091c.onClick(android.view.View):void");
        }
    }

    public final void a(ExpandableBalanceCardView expandableBalanceCardView, int i2, double d2, Collection<MultiSubWallet> collection) {
        CJRCashWalletResponse response;
        int unClaimedGVCount;
        ExpandableBalanceCardView expandableBalanceCardView2 = expandableBalanceCardView;
        ((LinearLayout) expandableBalanceCardView2.a(R.id.llSubWalletContainer)).removeAllViews();
        expandableBalanceCardView2.setVisibility(0);
        ((AppCompatTextView) expandableBalanceCardView2.a(R.id.tvTitle)).setText(i2);
        AppCompatTextView appCompatTextView = (AppCompatTextView) expandableBalanceCardView2.a(R.id.tvAmount);
        k.a((Object) appCompatTextView, "expandableBalanceCardView.tvAmount");
        String string = expandableBalanceCardView.getContext().getString(R.string.pass_rupee, new Object[]{net.one97.paytm.passbook.utility.f.b(d2)});
        k.a((Object) string, "expandableBalanceCardVie…e, total.amountFormat2())");
        net.one97.paytm.passbook.utility.f.a(appCompatTextView, string);
        int i3 = 0;
        for (Object next : collection) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                kotlin.a.k.a();
            }
            MultiSubWallet multiSubWallet = (MultiSubWallet) next;
            Context context = expandableBalanceCardView.getContext();
            k.a((Object) context, "expandableBalanceCardView.context");
            PassbookBalanceCardView passbookBalanceCardView = new PassbookBalanceCardView(context, R.layout.pass_sub_wallet_card_view);
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) passbookBalanceCardView.a(R.id.tvTitle);
            k.a((Object) appCompatTextView2, "view.tvTitle");
            appCompatTextView2.setText(multiSubWallet.getDisplayName());
            ArrayList<CJRSubWallet> subWalletList = multiSubWallet.getSubWalletList();
            if (subWalletList != null) {
                if (subWalletList.size() > 0) {
                    ArrayList<CJRSubWallet> subWalletList2 = multiSubWallet.getSubWalletList();
                    k.a((Object) subWalletList2, "wallet.subWalletList");
                    int size = subWalletList2.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        CJRSubWallet cJRSubWallet = multiSubWallet.getSubWalletList().get(i5);
                        k.a((Object) cJRSubWallet, "wallet.subWalletList[i]");
                        cJRSubWallet.getBalance();
                    }
                }
                AppCompatTextView appCompatTextView3 = (AppCompatTextView) passbookBalanceCardView.a(R.id.tvAmount);
                k.a((Object) appCompatTextView3, "view.tvAmount");
                appCompatTextView3.setText(context.getString(R.string.pass_rupee, new Object[]{net.one97.paytm.passbook.utility.f.b(multiSubWallet.getBalance())}));
            }
            ((AppCompatImageView) passbookBalanceCardView.a(R.id.ivWalletIcon)).setImageResource(q.a(multiSubWallet.getSubWalletType()));
            AppCompatImageView appCompatImageView = (AppCompatImageView) passbookBalanceCardView.a(R.id.ivWalletIcon);
            k.a((Object) appCompatImageView, "view.ivWalletIcon");
            appCompatImageView.setVisibility(0);
            if (multiSubWallet.getSubWalletType() == n.GIFT_VOUCHER.getValue()) {
                AppCompatTextView appCompatTextView4 = (AppCompatTextView) passbookBalanceCardView.a(R.id.tvTitle);
                k.a((Object) appCompatTextView4, "view.tvTitle");
                appCompatTextView4.setText(context.getString(R.string.pass_gift_voucher));
                CJRCashWallet cJRCashWallet = (CJRCashWallet) this.f57638a.f57887b;
                if (!(cJRCashWallet == null || (response = cJRCashWallet.getResponse()) == null || (unClaimedGVCount = response.getUnClaimedGVCount()) <= 0)) {
                    AppCompatTextView appCompatTextView5 = (AppCompatTextView) passbookBalanceCardView.a(R.id.tvGVCount);
                    k.a((Object) appCompatTextView5, "view.tvGVCount");
                    appCompatTextView5.setText(unClaimedGVCount + " New");
                    AppCompatTextView appCompatTextView6 = (AppCompatTextView) passbookBalanceCardView.a(R.id.tvGVCount);
                    k.a((Object) appCompatTextView6, "view.tvGVCount");
                    appCompatTextView6.setVisibility(0);
                }
            }
            if (multiSubWallet.getSubWalletType() == n.PAYTM_WALLET.getValue()) {
                if (a(context)) {
                    AppCompatTextView appCompatTextView7 = (AppCompatTextView) passbookBalanceCardView.a(R.id.tvCheckBalance);
                    k.a((Object) appCompatTextView7, "view.tvCheckBalance");
                    appCompatTextView7.setVisibility(0);
                    AppCompatTextView appCompatTextView8 = (AppCompatTextView) passbookBalanceCardView.a(R.id.tvAmount);
                    k.a((Object) appCompatTextView8, "view.tvAmount");
                    appCompatTextView8.setVisibility(8);
                    ((AppCompatTextView) passbookBalanceCardView.a(R.id.tvCheckBalance)).setText(R.string.pass_activate_now);
                } else {
                    AppCompatTextView appCompatTextView9 = (AppCompatTextView) passbookBalanceCardView.a(R.id.tvCheckBalance);
                    k.a((Object) appCompatTextView9, "view.tvCheckBalance");
                    appCompatTextView9.setVisibility(8);
                    AppCompatTextView appCompatTextView10 = (AppCompatTextView) passbookBalanceCardView.a(R.id.tvAmount);
                    k.a((Object) appCompatTextView10, "view.tvAmount");
                    appCompatTextView10.setVisibility(0);
                }
            }
            passbookBalanceCardView.setOnClickListener(new b(multiSubWallet, passbookBalanceCardView, this, expandableBalanceCardView, collection));
            ((LinearLayout) expandableBalanceCardView2.a(R.id.llSubWalletContainer)).addView(passbookBalanceCardView);
            i3 = i4;
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MultiSubWallet f57644a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PassbookBalanceCardView f57645b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ c f57646c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ExpandableBalanceCardView f57647d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Collection f57648e;

        b(MultiSubWallet multiSubWallet, PassbookBalanceCardView passbookBalanceCardView, c cVar, ExpandableBalanceCardView expandableBalanceCardView, Collection collection) {
            this.f57644a = multiSubWallet;
            this.f57645b = passbookBalanceCardView;
            this.f57646c = cVar;
            this.f57647d = expandableBalanceCardView;
            this.f57648e = collection;
        }

        public final void onClick(View view) {
            CJRSubWallet cJRSubWallet;
            ArrayList<CJRSubWallet> subWalletList;
            CJRSubWallet cJRSubWallet2;
            CJRSubWallet cJRSubWallet3;
            ExpandableBalanceCardView expandableBalanceCardView = this.f57647d;
            k.a((Object) view, "it");
            MultiSubWallet multiSubWallet = this.f57644a;
            AppCompatTextView appCompatTextView = (AppCompatTextView) expandableBalanceCardView.a(R.id.tvTitle);
            k.a((Object) appCompatTextView, "expandableBalanceCardView.tvTitle");
            String str = null;
            if (k.a((Object) appCompatTextView.getText().toString(), (Object) view.getContext().getString(R.string.paytm_balance1))) {
                Context context = view.getContext();
                ArrayList<CJRSubWallet> subWalletList2 = multiSubWallet.getSubWalletList();
                if (!(subWalletList2 == null || (cJRSubWallet3 = subWalletList2.get(0)) == null)) {
                    str = cJRSubWallet3.getDisplayName();
                }
                q.a(context, "uth_passbook", "paytm_bal_item_clicked", str, (String) null, "/uth_passbook_myaccounts", "PASSBOOK");
            } else {
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) expandableBalanceCardView.a(R.id.tvTitle);
                k.a((Object) appCompatTextView2, "expandableBalanceCardView.tvTitle");
                if (!(!k.a((Object) appCompatTextView2.getText().toString(), (Object) view.getContext().getString(R.string.other_wallets)) || (subWalletList = multiSubWallet.getSubWalletList()) == null || subWalletList.get(0) == null)) {
                    Context context2 = view.getContext();
                    ArrayList<CJRSubWallet> subWalletList3 = multiSubWallet.getSubWalletList();
                    if (!(subWalletList3 == null || (cJRSubWallet2 = subWalletList3.get(0)) == null)) {
                        str = cJRSubWallet2.getDisplayName();
                    }
                    q.a(context2, "uth_passbook", "view_all_accounts_other_wallets_clicked", str, (String) null, "/uth_passbook_myaccounts", "PASSBOOK");
                }
            }
            if (this.f57644a.getSubWalletType() == n.PAYTM_WALLET.getValue()) {
                Context context3 = view.getContext();
                k.a((Object) context3, "it.context");
                if (c.a(context3)) {
                    String a2 = net.one97.paytm.passbook.d.b().a("passNoKycUserDeeplink");
                    net.one97.paytm.passbook.mapping.f b2 = net.one97.paytm.passbook.d.b();
                    Context context4 = view.getContext();
                    if (context4 != null) {
                        b2.a(a2, (Activity) context4);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type android.app.Activity");
                }
            }
            ArrayList<CJRSubWallet> subWalletList4 = this.f57644a.getSubWalletList();
            if (subWalletList4 != null && (cJRSubWallet = subWalletList4.get(0)) != null) {
                c.a(cJRSubWallet.getSubWalletType(), this.f57645b, this.f57644a);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0018, code lost:
        r4 = r4.get(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(int r4, net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r5, net.one97.paytm.passbook.main.entity.MultiSubWallet r6) {
        /*
            android.content.Intent r0 = new android.content.Intent
            android.content.Context r1 = r5.getContext()
            java.lang.Class<net.one97.paytm.passbook.genericPassbook.activity.PassbookL2Activity> r2 = net.one97.paytm.passbook.genericPassbook.activity.PassbookL2Activity.class
            r0.<init>(r1, r2)
            java.lang.String r1 = "passbook_type"
            r0.putExtra(r1, r4)
            java.util.ArrayList r4 = r6.getSubWalletList()
            r1 = 0
            r2 = 0
            if (r4 == 0) goto L_0x0029
            java.lang.Object r4 = r4.get(r1)
            net.one97.paytm.passbook.beans.CJRSubWallet r4 = (net.one97.paytm.passbook.beans.CJRSubWallet) r4
            if (r4 == 0) goto L_0x0029
            int r4 = r4.getId()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x002a
        L_0x0029:
            r4 = r2
        L_0x002a:
            java.io.Serializable r4 = (java.io.Serializable) r4
            java.lang.String r3 = "clicked_wallet_id"
            r0.putExtra(r3, r4)
            java.util.ArrayList r4 = r6.getSubWalletList()
            if (r4 == 0) goto L_0x0044
            java.lang.Object r4 = r4.get(r1)
            net.one97.paytm.passbook.beans.CJRSubWallet r4 = (net.one97.paytm.passbook.beans.CJRSubWallet) r4
            if (r4 == 0) goto L_0x0044
            java.lang.String r4 = r4.getmIssuerId()
            goto L_0x0045
        L_0x0044:
            r4 = r2
        L_0x0045:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0064
            java.util.ArrayList r4 = r6.getSubWalletList()
            if (r4 == 0) goto L_0x005f
            java.lang.Object r4 = r4.get(r1)
            net.one97.paytm.passbook.beans.CJRSubWallet r4 = (net.one97.paytm.passbook.beans.CJRSubWallet) r4
            if (r4 == 0) goto L_0x005f
            java.lang.String r2 = r4.getmIssuerId()
        L_0x005f:
            java.lang.String r4 = "clickedWalletIssuerId"
            r0.putExtra(r4, r2)
        L_0x0064:
            r4 = 603979776(0x24000000, float:2.7755576E-17)
            r0.setFlags(r4)
            android.content.Context r4 = r5.getContext()
            r4.startActivity(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.landing.e.c.b(int, net.one97.paytm.passbook.main.widget.PassbookBalanceCardView, net.one97.paytm.passbook.main.entity.MultiSubWallet):void");
    }

    public final void b(ExpandableBalanceCardView expandableBalanceCardView) {
        m.a aVar = m.f59265a;
        net.one97.paytm.passbook.mapping.f b2 = net.one97.paytm.passbook.d.b();
        k.a((Object) b2, "PassbookHelper.getImplListener()");
        Context b3 = b2.b();
        k.a((Object) b3, "PassbookHelper.getImplLi…ener().applicationContext");
        String b4 = m.a.a(b3).b("kyc_state", "", true);
        CharSequence charSequence = b4;
        if (((charSequence == null || charSequence.length() == 0) || p.a(b4, "", true)) && this.f57639b < 2) {
            new Handler().postDelayed(new d(this, expandableBalanceCardView), 2000);
            this.f57639b++;
        } else if (b4 != null && !p.a(b4, "", true)) {
            if (p.a(b4, "Min Kyc Expired", true) || p.a(b4, "PAYTM_MIN_KYC_EXPIRED", true)) {
                AppCompatTextView appCompatTextView = (AppCompatTextView) expandableBalanceCardView.a(R.id.tvKycStatus);
                k.a((Object) appCompatTextView, "paytmBalanceCard.tvKycStatus");
                appCompatTextView.setVisibility(0);
                ((AppCompatTextView) expandableBalanceCardView.a(R.id.tvKycStatus)).setText(R.string.l1_min_kyc_expired);
            } else if (p.a(b4, "Adhaar OTP Kyc expired", true) || p.a(b4, "PAYTM_ADHAAR_OTP_KYC_EXPIRED", true)) {
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) expandableBalanceCardView.a(R.id.tvKycStatus);
                k.a((Object) appCompatTextView2, "paytmBalanceCard.tvKycStatus");
                appCompatTextView2.setVisibility(0);
                ((AppCompatTextView) expandableBalanceCardView.a(R.id.tvKycStatus)).setText(R.string.l1_aadhar_otp_exipred);
            }
        }
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f57653a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ExpandableBalanceCardView f57654b;

        d(c cVar, ExpandableBalanceCardView expandableBalanceCardView) {
            this.f57653a = cVar;
            this.f57654b = expandableBalanceCardView;
        }

        public final void run() {
            this.f57653a.b(this.f57654b);
        }
    }

    static boolean a(Context context) {
        if (p.a("", SDKConstants.KEY_STAGING_API, true)) {
            return false;
        }
        return net.one97.paytm.passbook.d.b().j(context);
    }

    public static final /* synthetic */ void a(int i2, PassbookBalanceCardView passbookBalanceCardView, MultiSubWallet multiSubWallet) {
        CJRSubWallet cJRSubWallet;
        if (!com.paytm.utility.b.c(passbookBalanceCardView.getContext())) {
            Context context = passbookBalanceCardView.getContext();
            if (context != null) {
                net.one97.paytm.passbook.mapping.c.g((Activity) context);
                return;
            }
            throw new u("null cannot be cast to non-null type android.app.Activity");
        } else if (i2 == n.PAYTM_WALLET.getValue()) {
            net.one97.paytm.passbook.mapping.f b2 = net.one97.paytm.passbook.d.b();
            Context context2 = passbookBalanceCardView.getContext();
            if (context2 != null) {
                b2.c((Activity) context2);
                return;
            }
            throw new u("null cannot be cast to non-null type android.app.Activity");
        } else if (i2 == n.LOYALTY_WALLET_TYPE_7.getValue()) {
            b(i2, passbookBalanceCardView, multiSubWallet);
        } else if (i2 == n.LOYALTY_WALLET.getValue()) {
            b(i2, passbookBalanceCardView, multiSubWallet);
        } else if (i2 == n.ALLOWALANCE_WALLET.getValue()) {
            b(i2, passbookBalanceCardView, multiSubWallet);
        } else if (i2 == n.FOOD_WALLET.getValue()) {
            b(i2, passbookBalanceCardView, multiSubWallet);
        } else {
            net.one97.paytm.passbook.mapping.f b3 = net.one97.paytm.passbook.d.b();
            net.one97.paytm.passbook.utility.k kVar = net.one97.paytm.passbook.utility.k.f59256a;
            if (i2 == n.GIFT_VOUCHER.getValue() && b3.a(net.one97.paytm.passbook.utility.k.i(), true)) {
                b(i2, passbookBalanceCardView, multiSubWallet);
                return;
            }
            if (i2 == n.TOLL.getValue() && net.one97.paytm.passbook.d.b().a("passMigratedFastagEnabled", true)) {
                b(i2, passbookBalanceCardView, multiSubWallet);
                return;
            }
            Intent intent = new Intent(passbookBalanceCardView.getContext(), PassbookSubwalletActivity.class);
            ArrayList<CJRSubWallet> subWalletList = multiSubWallet.getSubWalletList();
            intent.putExtra("display_name", (subWalletList == null || (cJRSubWallet = subWalletList.get(0)) == null) ? null : cJRSubWallet.getDisplayName());
            intent.putExtra("subwallet-list", multiSubWallet);
            intent.putExtra("sub_wallet_type", i2);
            intent.putExtra("isOpenFromNewPassbook", true);
            intent.setFlags(603979776);
            passbookBalanceCardView.getContext().startActivity(intent);
        }
    }
}
