package net.one97.paytm.passbook.transactionDetail;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.NetworkCustomError;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.base.BaseActivity;
import net.one97.paytm.passbook.beans.CJRLedger;
import net.one97.paytm.passbook.beans.CJRTransaction;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.utility.j;

public final class RecentTransactionsActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.passbook.transactionDetail.d.b f58996a;

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.passbook.transactionDetail.a.b f58997b;

    /* renamed from: c  reason: collision with root package name */
    public CJRTransaction f58998c;

    /* renamed from: d  reason: collision with root package name */
    private int f58999d = 1;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f59000e;

    public interface a {
        void a(CJRTransaction cJRTransaction);
    }

    public final View a(int i2) {
        if (this.f59000e == null) {
            this.f59000e = new HashMap();
        }
        View view = (View) this.f59000e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f59000e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class d<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecentTransactionsActivity f59003a;

        d(RecentTransactionsActivity recentTransactionsActivity) {
            this.f59003a = recentTransactionsActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            if (bool == null) {
                k.a();
            }
            if (bool.booleanValue()) {
                LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f59003a.a(R.id.loader);
                k.a((Object) lottieAnimationView, "loader");
                lottieAnimationView.setVisibility(0);
                net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f59003a.a(R.id.loader));
                return;
            }
            net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f59003a.a(R.id.loader));
            LottieAnimationView lottieAnimationView2 = (LottieAnimationView) this.f59003a.a(R.id.loader);
            k.a((Object) lottieAnimationView2, "loader");
            lottieAnimationView2.setVisibility(8);
        }
    }

    public final net.one97.paytm.passbook.transactionDetail.d.b a() {
        net.one97.paytm.passbook.transactionDetail.d.b bVar = this.f58996a;
        if (bVar == null) {
            k.a("viewModel");
        }
        return bVar;
    }

    public final net.one97.paytm.passbook.transactionDetail.a.b b() {
        net.one97.paytm.passbook.transactionDetail.a.b bVar = this.f58997b;
        if (bVar == null) {
            k.a("adapter");
        }
        return bVar;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0447  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0456  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0493  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x04da  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0570  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x0687  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x068e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r17) {
        /*
            r16 = this;
            r0 = r16
            super.onCreate(r17)
            int r1 = net.one97.paytm.passbook.R.layout.pass_activity_recent_transactions
            r0.setContentView((int) r1)
            android.content.Intent r1 = r16.getIntent()
            java.lang.String r2 = "data"
            java.io.Serializable r1 = r1.getSerializableExtra(r2)
            if (r1 == 0) goto L_0x0695
            net.one97.paytm.passbook.beans.CJRTransaction r1 = (net.one97.paytm.passbook.beans.CJRTransaction) r1
            r0.f58998c = r1
            android.content.Intent r1 = r16.getIntent()
            r2 = 0
            java.lang.String r3 = "index"
            int r1 = r1.getIntExtra(r3, r2)
            r0.f58999d = r1
            r1 = r0
            androidx.fragment.app.FragmentActivity r1 = (androidx.fragment.app.FragmentActivity) r1
            androidx.lifecycle.al r1 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r1)
            java.lang.Class<net.one97.paytm.passbook.transactionDetail.d.b> r3 = net.one97.paytm.passbook.transactionDetail.d.b.class
            androidx.lifecycle.ai r1 = r1.a(r3)
            java.lang.String r3 = "ViewModelProviders.of(th…ionViewModel::class.java)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            net.one97.paytm.passbook.transactionDetail.d.b r1 = (net.one97.paytm.passbook.transactionDetail.d.b) r1
            r0.f58996a = r1
            int r1 = net.one97.paytm.passbook.R.id.backArrow
            android.view.View r1 = r0.a((int) r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            net.one97.paytm.passbook.transactionDetail.RecentTransactionsActivity$b r3 = new net.one97.paytm.passbook.transactionDetail.RecentTransactionsActivity$b
            r3.<init>(r0)
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r1.setOnClickListener(r3)
            net.one97.paytm.passbook.transactionDetail.a.b r1 = new net.one97.paytm.passbook.transactionDetail.a.b
            net.one97.paytm.passbook.transactionDetail.RecentTransactionsActivity$c r3 = new net.one97.paytm.passbook.transactionDetail.RecentTransactionsActivity$c
            r3.<init>(r0)
            net.one97.paytm.passbook.transactionDetail.RecentTransactionsActivity$a r3 = (net.one97.paytm.passbook.transactionDetail.RecentTransactionsActivity.a) r3
            r1.<init>(r3)
            r0.f58997b = r1
            int r1 = net.one97.paytm.passbook.R.id.transactionsListRv
            android.view.View r1 = r0.a((int) r1)
            androidx.recyclerview.widget.RecyclerView r1 = (androidx.recyclerview.widget.RecyclerView) r1
            java.lang.String r3 = "transactionsListRv"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            androidx.recyclerview.widget.LinearLayoutManager r4 = new androidx.recyclerview.widget.LinearLayoutManager
            r5 = r0
            android.content.Context r5 = (android.content.Context) r5
            r6 = 1
            r4.<init>(r5, r6, r2)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r4 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r4
            r1.setLayoutManager(r4)
            int r1 = net.one97.paytm.passbook.R.id.transactionsListRv
            android.view.View r1 = r0.a((int) r1)
            androidx.recyclerview.widget.RecyclerView r1 = (androidx.recyclerview.widget.RecyclerView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            net.one97.paytm.passbook.transactionDetail.a.b r3 = r0.f58997b
            if (r3 != 0) goto L_0x008c
            java.lang.String r4 = "adapter"
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x008c:
            androidx.recyclerview.widget.RecyclerView$a r3 = (androidx.recyclerview.widget.RecyclerView.a) r3
            r1.setAdapter(r3)
            net.one97.paytm.passbook.transactionDetail.d.b r1 = r0.f58996a
            java.lang.String r3 = "viewModel"
            if (r1 != 0) goto L_0x009a
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x009a:
            androidx.lifecycle.y<java.lang.Boolean> r1 = r1.f59154d
            r4 = r0
            androidx.lifecycle.q r4 = (androidx.lifecycle.q) r4
            net.one97.paytm.passbook.transactionDetail.RecentTransactionsActivity$d r7 = new net.one97.paytm.passbook.transactionDetail.RecentTransactionsActivity$d
            r7.<init>(r0)
            androidx.lifecycle.z r7 = (androidx.lifecycle.z) r7
            r1.observe(r4, r7)
            net.one97.paytm.passbook.transactionDetail.d.b r1 = r0.f58996a
            if (r1 != 0) goto L_0x00b0
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x00b0:
            androidx.lifecycle.y<net.one97.paytm.passbook.mapping.a.e> r1 = r1.f59155e
            net.one97.paytm.passbook.transactionDetail.RecentTransactionsActivity$e r7 = new net.one97.paytm.passbook.transactionDetail.RecentTransactionsActivity$e
            r7.<init>(r0)
            androidx.lifecycle.z r7 = (androidx.lifecycle.z) r7
            r1.observe(r4, r7)
            net.one97.paytm.passbook.transactionDetail.d.b r1 = r0.f58996a
            if (r1 != 0) goto L_0x00c3
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x00c3:
            androidx.lifecycle.y<net.one97.paytm.passbook.mapping.IJRDataModel> r1 = r1.f59156f
            net.one97.paytm.passbook.transactionDetail.RecentTransactionsActivity$f r7 = new net.one97.paytm.passbook.transactionDetail.RecentTransactionsActivity$f
            r7.<init>(r0)
            androidx.lifecycle.z r7 = (androidx.lifecycle.z) r7
            r1.observe(r4, r7)
            net.one97.paytm.passbook.transactionDetail.d.b r1 = r0.f58996a
            if (r1 != 0) goto L_0x00d6
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x00d6:
            androidx.lifecycle.y<com.paytm.network.model.NetworkCustomError> r1 = r1.f59157g
            net.one97.paytm.passbook.transactionDetail.RecentTransactionsActivity$g r7 = new net.one97.paytm.passbook.transactionDetail.RecentTransactionsActivity$g
            r7.<init>(r0)
            androidx.lifecycle.z r7 = (androidx.lifecycle.z) r7
            r1.observe(r4, r7)
            int r1 = net.one97.paytm.passbook.R.id.retryBtn
            android.view.View r1 = r0.a((int) r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            net.one97.paytm.passbook.transactionDetail.RecentTransactionsActivity$h r4 = new net.one97.paytm.passbook.transactionDetail.RecentTransactionsActivity$h
            r4.<init>(r0)
            android.view.View$OnClickListener r4 = (android.view.View.OnClickListener) r4
            r1.setOnClickListener(r4)
            int r1 = net.one97.paytm.passbook.R.id.titleTv
            android.view.View r1 = r0.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            net.one97.paytm.passbook.transactionDetail.a r4 = net.one97.paytm.passbook.transactionDetail.a.f59009a
            net.one97.paytm.passbook.beans.CJRTransaction r4 = r0.f58998c
            java.lang.String r7 = "mTransaction"
            if (r4 != 0) goto L_0x0107
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x0107:
            java.lang.String r8 = "context"
            kotlin.g.b.k.c(r5, r8)
            java.lang.String r8 = "transaction"
            kotlin.g.b.k.c(r4, r8)
            java.lang.String r8 = r4.getType()
            java.lang.String r9 = "22"
            java.lang.String r10 = "5"
            java.lang.String r11 = "1"
            java.lang.String r12 = "DR"
            if (r8 != 0) goto L_0x0121
            goto L_0x0433
        L_0x0121:
            int r13 = r8.hashCode()
            r14 = 49
            java.lang.String r15 = "context.getString(R.stri…erchantName(transaction))"
            if (r13 == r14) goto L_0x041a
            r14 = 50
            if (r13 == r14) goto L_0x03ff
            r14 = 53
            if (r13 == r14) goto L_0x03c9
            r14 = 1568(0x620, float:2.197E-42)
            if (r13 == r14) goto L_0x03b4
            r14 = 1598(0x63e, float:2.239E-42)
            java.lang.String r2 = "context.getString(R.stri…y_to_wallet_transactions)"
            if (r13 == r14) goto L_0x03a1
            r14 = 1600(0x640, float:2.242E-42)
            if (r13 == r14) goto L_0x038e
            r14 = 1635(0x663, float:2.291E-42)
            if (r13 == r14) goto L_0x0379
            r14 = 1669(0x685, float:2.339E-42)
            if (r13 == r14) goto L_0x0364
            r14 = 1691(0x69b, float:2.37E-42)
            if (r13 == r14) goto L_0x034f
            r14 = 1694(0x69e, float:2.374E-42)
            if (r13 == r14) goto L_0x033c
            r2 = 1761(0x6e1, float:2.468E-42)
            if (r13 == r2) goto L_0x0327
            r2 = 55
            if (r13 == r2) goto L_0x0312
            r2 = 56
            if (r13 == r2) goto L_0x02fd
            r2 = 1606(0x646, float:2.25E-42)
            if (r13 == r2) goto L_0x02e8
            r2 = 1607(0x647, float:2.252E-42)
            if (r13 == r2) goto L_0x02d3
            r2 = 1730(0x6c2, float:2.424E-42)
            if (r13 == r2) goto L_0x02be
            r2 = 1731(0x6c3, float:2.426E-42)
            if (r13 == r2) goto L_0x028b
            r2 = 1755(0x6db, float:2.459E-42)
            if (r13 == r2) goto L_0x0276
            r2 = 1756(0x6dc, float:2.46E-42)
            if (r13 == r2) goto L_0x0261
            java.lang.String r2 = "context.getString(R.stri…nt_disputed_transactions)"
            java.lang.String r4 = "context.getString(R.stri…ent_disputed_resolutions)"
            switch(r13) {
                case 1570: goto L_0x024d;
                case 1571: goto L_0x023b;
                case 1572: goto L_0x0228;
                case 1573: goto L_0x0215;
                default: goto L_0x017c;
            }
        L_0x017c:
            switch(r13) {
                case 1664: goto L_0x0200;
                case 1665: goto L_0x01eb;
                case 1666: goto L_0x01d6;
                case 1667: goto L_0x01c3;
                default: goto L_0x017f;
            }
        L_0x017f:
            switch(r13) {
                case 1696: goto L_0x01ae;
                case 1697: goto L_0x0199;
                case 1698: goto L_0x0184;
                default: goto L_0x0182;
            }
        L_0x0182:
            goto L_0x0433
        L_0x0184:
            java.lang.String r2 = "57"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x0433
            int r2 = net.one97.paytm.passbook.R.string.recent_addition_to_fuel_wallet
            java.lang.String r2 = r5.getString(r2)
            java.lang.String r4 = "context.getString(R.stri…_addition_to_fuel_wallet)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            goto L_0x043e
        L_0x0199:
            java.lang.String r2 = "56"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x0433
            int r2 = net.one97.paytm.passbook.R.string.recent_addition_to_allowance_wallet
            java.lang.String r2 = r5.getString(r2)
            java.lang.String r4 = "context.getString(R.stri…tion_to_allowance_wallet)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            goto L_0x043e
        L_0x01ae:
            java.lang.String r2 = "55"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x0433
            int r2 = net.one97.paytm.passbook.R.string.recent_addition_to_loyality_wallet
            java.lang.String r2 = r5.getString(r2)
            java.lang.String r4 = "context.getString(R.stri…ition_to_loyality_wallet)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            goto L_0x043e
        L_0x01c3:
            java.lang.String r2 = "47"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x0433
            int r2 = net.one97.paytm.passbook.R.string.recent_disputed_resolutions
            java.lang.String r2 = r5.getString(r2)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            goto L_0x043e
        L_0x01d6:
            java.lang.String r2 = "46"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x0433
            int r2 = net.one97.paytm.passbook.R.string.recent_addition_to_gift_wallet
            java.lang.String r2 = r5.getString(r2)
            java.lang.String r4 = "context.getString(R.stri…_addition_to_gift_wallet)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            goto L_0x043e
        L_0x01eb:
            java.lang.String r2 = "45"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x0433
            int r2 = net.one97.paytm.passbook.R.string.recent_addition_to_food_wallet
            java.lang.String r2 = r5.getString(r2)
            java.lang.String r4 = "context.getString(R.stri…_addition_to_food_wallet)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            goto L_0x043e
        L_0x0200:
            java.lang.String r2 = "44"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x0433
            int r2 = net.one97.paytm.passbook.R.string.recent_commission_rollback
            java.lang.String r2 = r5.getString(r2)
            java.lang.String r4 = "context.getString(R.stri…cent_commission_rollback)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            goto L_0x043e
        L_0x0215:
            java.lang.String r2 = "16"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x0433
            int r2 = net.one97.paytm.passbook.R.string.recent_disputed_resolutions
            java.lang.String r2 = r5.getString(r2)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            goto L_0x043e
        L_0x0228:
            java.lang.String r2 = "15"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x0433
            int r2 = net.one97.paytm.passbook.R.string.recent_disputed_resolutions
            java.lang.String r2 = r5.getString(r2)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            goto L_0x043e
        L_0x023b:
            java.lang.String r4 = "14"
            boolean r4 = r8.equals(r4)
            if (r4 == 0) goto L_0x0433
            int r4 = net.one97.paytm.passbook.R.string.recent_disputed_transactions
            java.lang.String r4 = r5.getString(r4)
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r2)
            goto L_0x025e
        L_0x024d:
            java.lang.String r4 = "13"
            boolean r4 = r8.equals(r4)
            if (r4 == 0) goto L_0x0433
            int r4 = net.one97.paytm.passbook.R.string.recent_disputed_transactions
            java.lang.String r4 = r5.getString(r4)
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r2)
        L_0x025e:
            r2 = r4
            goto L_0x043e
        L_0x0261:
            java.lang.String r2 = "73"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x0433
            int r2 = net.one97.paytm.passbook.R.string.recent_addition_to_communication_wallet
            java.lang.String r2 = r5.getString(r2)
            java.lang.String r4 = "context.getString(R.stri…_to_communication_wallet)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            goto L_0x043e
        L_0x0276:
            java.lang.String r2 = "72"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x0433
            int r2 = net.one97.paytm.passbook.R.string.recent_lien_deductions
            java.lang.String r2 = r5.getString(r2)
            java.lang.String r4 = "context.getString(R.string.recent_lien_deductions)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            goto L_0x043e
        L_0x028b:
            java.lang.String r2 = "69"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x0433
            java.lang.String r2 = r4.getTxnType()
            boolean r2 = kotlin.m.p.a((java.lang.String) r12, (java.lang.String) r2, (boolean) r6)
            if (r2 == 0) goto L_0x02aa
            int r2 = net.one97.paytm.passbook.R.string.recent_transaction_with_merchant
            java.lang.String r2 = r5.getString(r2)
            java.lang.String r4 = "context.getString(R.stri…ransaction_with_merchant)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            goto L_0x043e
        L_0x02aa:
            int r2 = net.one97.paytm.passbook.R.string.recent_payment_from_
            java.lang.Object[] r8 = new java.lang.Object[r6]
            java.lang.String r4 = net.one97.paytm.passbook.transactionDetail.a.a((net.one97.paytm.passbook.beans.CJRTransaction) r4)
            r13 = 0
            r8[r13] = r4
            java.lang.String r2 = r5.getString(r2, r8)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r15)
            goto L_0x043e
        L_0x02be:
            java.lang.String r2 = "68"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x0433
            int r2 = net.one97.paytm.passbook.R.string.recent_gift_vouchers
            java.lang.String r2 = r5.getString(r2)
            java.lang.String r4 = "context.getString(R.string.recent_gift_vouchers)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            goto L_0x043e
        L_0x02d3:
            java.lang.String r2 = "29"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x0433
            int r2 = net.one97.paytm.passbook.R.string.recent_transfers_from_wallet_to_bank
            java.lang.String r2 = r5.getString(r2)
            java.lang.String r4 = "context.getString(R.stri…fers_from_wallet_to_bank)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            goto L_0x043e
        L_0x02e8:
            java.lang.String r2 = "28"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x0433
            int r2 = net.one97.paytm.passbook.R.string.cashback_rollbacks_from_wallet
            java.lang.String r2 = r5.getString(r2)
            java.lang.String r4 = "context.getString(R.stri…ck_rollbacks_from_wallet)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            goto L_0x043e
        L_0x02fd:
            java.lang.String r2 = "8"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x0433
            int r2 = net.one97.paytm.passbook.R.string.recent_rollbacks
            java.lang.String r2 = r5.getString(r2)
            java.lang.String r4 = "context.getString(R.string.recent_rollbacks)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            goto L_0x043e
        L_0x0312:
            java.lang.String r2 = "7"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x0433
            int r2 = net.one97.paytm.passbook.R.string.cashback_received
            java.lang.String r2 = r5.getString(r2)
            java.lang.String r4 = "context.getString(R.string.cashback_received)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            goto L_0x043e
        L_0x0327:
            java.lang.String r2 = "78"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x0433
            int r2 = net.one97.paytm.passbook.R.string.recent_lien_refunds
            java.lang.String r2 = r5.getString(r2)
            java.lang.String r4 = "context.getString(R.string.recent_lien_refunds)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            goto L_0x043e
        L_0x033c:
            java.lang.String r4 = "53"
            boolean r4 = r8.equals(r4)
            if (r4 == 0) goto L_0x0433
            int r4 = net.one97.paytm.passbook.R.string.auto_add_money_to_wallet_transactions
            java.lang.String r4 = r5.getString(r4)
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r2)
            goto L_0x025e
        L_0x034f:
            java.lang.String r2 = "50"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x0433
            int r2 = net.one97.paytm.passbook.R.string.recent_transactions
            java.lang.String r2 = r5.getString(r2)
            java.lang.String r4 = "context.getString(R.string.recent_transactions)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            goto L_0x043e
        L_0x0364:
            java.lang.String r2 = "49"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x0433
            int r2 = net.one97.paytm.passbook.R.string.recent_addition_to_toll_wallet
            java.lang.String r2 = r5.getString(r2)
            java.lang.String r4 = "context.getString(R.stri…_addition_to_toll_wallet)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            goto L_0x043e
        L_0x0379:
            java.lang.String r2 = "36"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x0433
            int r2 = net.one97.paytm.passbook.R.string.add_money_to_wallet_via_cash
            java.lang.String r2 = r5.getString(r2)
            java.lang.String r4 = "context.getString(R.stri…money_to_wallet_via_cash)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            goto L_0x043e
        L_0x038e:
            boolean r2 = r8.equals(r9)
            if (r2 == 0) goto L_0x0433
            int r2 = net.one97.paytm.passbook.R.string.recent_on_hold_transactions
            java.lang.String r2 = r5.getString(r2)
            java.lang.String r4 = "context.getString(R.stri…ent_on_hold_transactions)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            goto L_0x043e
        L_0x03a1:
            java.lang.String r4 = "20"
            boolean r4 = r8.equals(r4)
            if (r4 == 0) goto L_0x0433
            int r4 = net.one97.paytm.passbook.R.string.add_money_to_wallet_transactions
            java.lang.String r4 = r5.getString(r4)
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r2)
            goto L_0x025e
        L_0x03b4:
            java.lang.String r2 = "11"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x0433
            int r2 = net.one97.paytm.passbook.R.string.recents_refund_to_source
            java.lang.String r2 = r5.getString(r2)
            java.lang.String r4 = "context.getString(R.stri…recents_refund_to_source)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            goto L_0x043e
        L_0x03c9:
            boolean r2 = r8.equals(r10)
            if (r2 == 0) goto L_0x0433
            java.lang.String r2 = r4.getTxnType()
            boolean r2 = kotlin.m.p.a((java.lang.String) r12, (java.lang.String) r2, (boolean) r6)
            if (r2 == 0) goto L_0x03ec
            int r2 = net.one97.paytm.passbook.R.string.recent_transaction_with_
            java.lang.Object[] r8 = new java.lang.Object[r6]
            java.lang.String r4 = net.one97.paytm.passbook.transactionDetail.a.a((net.one97.paytm.passbook.beans.CJRTransaction) r4)
            r13 = 0
            r8[r13] = r4
            java.lang.String r2 = r5.getString(r2, r8)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r15)
            goto L_0x043e
        L_0x03ec:
            r13 = 0
            int r2 = net.one97.paytm.passbook.R.string.recent_transaction_with_
            java.lang.Object[] r8 = new java.lang.Object[r6]
            java.lang.String r4 = net.one97.paytm.passbook.transactionDetail.a.a((net.one97.paytm.passbook.beans.CJRTransaction) r4)
            r8[r13] = r4
            java.lang.String r2 = r5.getString(r2, r8)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r15)
            goto L_0x043e
        L_0x03ff:
            java.lang.String r2 = "2"
            boolean r2 = r8.equals(r2)
            if (r2 == 0) goto L_0x0433
            int r2 = net.one97.paytm.passbook.R.string.recent_transaction_with_
            java.lang.Object[] r8 = new java.lang.Object[r6]
            java.lang.String r4 = net.one97.paytm.passbook.transactionDetail.a.a((net.one97.paytm.passbook.beans.CJRTransaction) r4)
            r13 = 0
            r8[r13] = r4
            java.lang.String r2 = r5.getString(r2, r8)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r15)
            goto L_0x043e
        L_0x041a:
            r13 = 0
            boolean r2 = r8.equals(r11)
            if (r2 == 0) goto L_0x0433
            int r2 = net.one97.paytm.passbook.R.string.recent_transaction_with_
            java.lang.Object[] r8 = new java.lang.Object[r6]
            java.lang.String r4 = net.one97.paytm.passbook.transactionDetail.a.a((net.one97.paytm.passbook.beans.CJRTransaction) r4)
            r8[r13] = r4
            java.lang.String r2 = r5.getString(r2, r8)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r15)
            goto L_0x043e
        L_0x0433:
            int r2 = net.one97.paytm.passbook.R.string.recent
            java.lang.String r2 = r5.getString(r2)
            java.lang.String r4 = "context.getString(R.string.recent)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
        L_0x043e:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f58998c
            if (r1 != 0) goto L_0x044a
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x044a:
            java.lang.String r1 = r1.getRecentName()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x048f
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f58998c
            if (r1 != 0) goto L_0x045d
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x045d:
            java.lang.String r1 = r1.getType()
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r1)
            if (r1 == 0) goto L_0x048f
            int r1 = net.one97.paytm.passbook.R.id.titleTv
            android.view.View r1 = r0.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            java.lang.String r2 = "titleTv"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            int r2 = net.one97.paytm.passbook.R.string.recent_transaction_with_
            java.lang.Object[] r4 = new java.lang.Object[r6]
            net.one97.paytm.passbook.beans.CJRTransaction r8 = r0.f58998c
            if (r8 != 0) goto L_0x047f
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x047f:
            java.lang.String r8 = r8.getRecentName()
            r11 = 0
            r4[r11] = r8
            java.lang.String r2 = r0.getString(r2, r4)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
        L_0x048f:
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r0.f58998c
            if (r1 != 0) goto L_0x0496
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x0496:
            r2 = 4
            java.lang.Integer[] r2 = new java.lang.Integer[r2]
            int r4 = net.one97.paytm.passbook.R.color.color_ffc756
            int r4 = androidx.core.content.b.c(r5, r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r8 = 0
            r2[r8] = r4
            int r4 = net.one97.paytm.passbook.R.color.color_5697ff
            int r4 = androidx.core.content.b.c(r5, r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r2[r6] = r4
            r4 = 2
            int r8 = net.one97.paytm.passbook.R.color.color_7ae3b4
            int r8 = androidx.core.content.b.c(r5, r8)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r2[r4] = r8
            r4 = 3
            int r8 = net.one97.paytm.passbook.R.color.color_ffa67a
            int r5 = androidx.core.content.b.c(r5, r8)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r2[r4] = r5
            java.lang.String r4 = r1.getType()
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r10)
            java.lang.String r5 = "icon"
            java.lang.String r8 = "payer_payee_icon_with_text"
            if (r4 == 0) goto L_0x0570
            java.lang.String r4 = r1.getPayeeInitials()
            if (r4 == 0) goto L_0x053d
            int r4 = net.one97.paytm.passbook.R.id.icon
            android.view.View r4 = r0.a((int) r4)
            net.one97.paytm.passbook.customview.CircularImageView r4 = (net.one97.paytm.passbook.customview.CircularImageView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            r5 = 8
            r4.setVisibility(r5)
            int r4 = net.one97.paytm.passbook.R.id.payer_payee_icon_with_text
            android.view.View r4 = r0.a((int) r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r8)
            r5 = 0
            r4.setVisibility(r5)
            int r4 = net.one97.paytm.passbook.R.id.payer_payee_icon_with_text
            android.view.View r4 = r0.a((int) r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r8)
            java.lang.String r1 = r1.getPayeeInitials()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r4.setText(r1)
            int r1 = net.one97.paytm.passbook.R.id.payer_payee_icon_with_text
            android.view.View r1 = r0.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r8)
            android.graphics.drawable.Drawable r1 = r1.getBackground()
            if (r1 == 0) goto L_0x0535
            android.graphics.drawable.GradientDrawable r1 = (android.graphics.drawable.GradientDrawable) r1
            int r4 = r0.f58999d
            int r4 = r4 % 4
            r2 = r2[r4]
            int r2 = r2.intValue()
            r1.setColor(r2)
            goto L_0x0683
        L_0x0535:
            kotlin.u r1 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable"
            r1.<init>(r2)
            throw r1
        L_0x053d:
            int r2 = net.one97.paytm.passbook.R.id.icon
            android.view.View r2 = r0.a((int) r2)
            net.one97.paytm.passbook.customview.CircularImageView r2 = (net.one97.paytm.passbook.customview.CircularImageView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            r4 = 0
            r2.setVisibility(r4)
            com.squareup.picasso.w r2 = com.squareup.picasso.w.a()
            java.lang.String r1 = r1.getImageUrl()
            com.squareup.picasso.aa r1 = r2.a((java.lang.String) r1)
            net.one97.paytm.passbook.customview.b r2 = new net.one97.paytm.passbook.customview.b
            r2.<init>()
            com.squareup.picasso.ah r2 = (com.squareup.picasso.ah) r2
            com.squareup.picasso.aa r1 = r1.a((com.squareup.picasso.ah) r2)
            int r2 = net.one97.paytm.passbook.R.id.icon
            android.view.View r2 = r0.a((int) r2)
            net.one97.paytm.passbook.customview.CircularImageView r2 = (net.one97.paytm.passbook.customview.CircularImageView) r2
            r1.a((android.widget.ImageView) r2)
            goto L_0x0683
        L_0x0570:
            int r2 = net.one97.paytm.passbook.R.id.payer_payee_icon_with_text
            android.view.View r2 = r0.a((int) r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r8)
            r4 = 8
            r2.setVisibility(r4)
            int r2 = net.one97.paytm.passbook.R.id.icon
            android.view.View r2 = r0.a((int) r2)
            net.one97.paytm.passbook.customview.CircularImageView r2 = (net.one97.paytm.passbook.customview.CircularImageView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            r4 = 0
            r2.setVisibility(r4)
            java.lang.String r2 = r1.getImageUrl()
            boolean r2 = android.webkit.URLUtil.isValidUrl(r2)
            if (r2 == 0) goto L_0x05bd
            com.squareup.picasso.w r2 = com.squareup.picasso.w.a()
            java.lang.String r1 = r1.getImageUrl()
            com.squareup.picasso.aa r1 = r2.a((java.lang.String) r1)
            net.one97.paytm.passbook.customview.b r2 = new net.one97.paytm.passbook.customview.b
            r2.<init>()
            com.squareup.picasso.ah r2 = (com.squareup.picasso.ah) r2
            com.squareup.picasso.aa r1 = r1.a((com.squareup.picasso.ah) r2)
            int r2 = net.one97.paytm.passbook.R.id.icon
            android.view.View r2 = r0.a((int) r2)
            net.one97.paytm.passbook.customview.CircularImageView r2 = (net.one97.paytm.passbook.customview.CircularImageView) r2
            r1.a((android.widget.ImageView) r2)
            goto L_0x0683
        L_0x05bd:
            java.lang.String r2 = r1.getTxnType()
            if (r2 == 0) goto L_0x0624
            java.lang.String r4 = "CR"
            boolean r4 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r4, (boolean) r6)
            if (r4 == 0) goto L_0x0624
            java.lang.String r1 = r1.getNarration()
            java.lang.String r2 = "transaction.narration"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.String r2 = "Added "
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r4 = 0
            boolean r1 = kotlin.m.p.a((java.lang.CharSequence) r1, (java.lang.CharSequence) r2, (boolean) r4)
            if (r1 == 0) goto L_0x0603
            com.squareup.picasso.w r1 = com.squareup.picasso.w.a()
            java.lang.String r2 = "https://assetscdn.paytm.com/images/catalog/pg/Add-money.jpg"
            com.squareup.picasso.aa r1 = r1.a((java.lang.String) r2)
            net.one97.paytm.passbook.customview.b r2 = new net.one97.paytm.passbook.customview.b
            r2.<init>()
            com.squareup.picasso.ah r2 = (com.squareup.picasso.ah) r2
            com.squareup.picasso.aa r1 = r1.a((com.squareup.picasso.ah) r2)
            int r2 = net.one97.paytm.passbook.R.id.icon
            android.view.View r2 = r0.a((int) r2)
            net.one97.paytm.passbook.customview.CircularImageView r2 = (net.one97.paytm.passbook.customview.CircularImageView) r2
            r1.a((android.widget.ImageView) r2)
            goto L_0x0683
        L_0x0603:
            com.squareup.picasso.w r1 = com.squareup.picasso.w.a()
            java.lang.String r2 = "https://assetscdn.paytm.com/images/catalog/pg/Cashback.jpg"
            com.squareup.picasso.aa r1 = r1.a((java.lang.String) r2)
            net.one97.paytm.passbook.customview.b r2 = new net.one97.paytm.passbook.customview.b
            r2.<init>()
            com.squareup.picasso.ah r2 = (com.squareup.picasso.ah) r2
            com.squareup.picasso.aa r1 = r1.a((com.squareup.picasso.ah) r2)
            int r2 = net.one97.paytm.passbook.R.id.icon
            android.view.View r2 = r0.a((int) r2)
            net.one97.paytm.passbook.customview.CircularImageView r2 = (net.one97.paytm.passbook.customview.CircularImageView) r2
            r1.a((android.widget.ImageView) r2)
            goto L_0x0683
        L_0x0624:
            if (r2 == 0) goto L_0x0683
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r12, (boolean) r6)
            if (r2 == 0) goto L_0x0683
            java.lang.String r2 = r1.getType()
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r9, (boolean) r6)
            if (r2 == 0) goto L_0x0663
            java.lang.String r1 = r1.getNarration()
            java.lang.String r2 = "transaction.narration"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r2 = net.one97.paytm.passbook.R.string.auth
            java.lang.String r2 = r0.getString(r2)
            java.lang.String r4 = "getString(R.string.auth)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r4 = 0
            boolean r1 = kotlin.m.p.a((java.lang.CharSequence) r1, (java.lang.CharSequence) r2, (boolean) r4)
            if (r1 == 0) goto L_0x0663
            int r1 = net.one97.paytm.passbook.R.id.icon
            android.view.View r1 = r0.a((int) r1)
            net.one97.paytm.passbook.customview.CircularImageView r1 = (net.one97.paytm.passbook.customview.CircularImageView) r1
            int r2 = net.one97.paytm.passbook.R.drawable.pass_ic_on_hold_txn
            r1.setImageResource(r2)
            goto L_0x0683
        L_0x0663:
            com.squareup.picasso.w r1 = com.squareup.picasso.w.a()
            java.lang.String r2 = "https://assetscdn.paytm.com/images/catalog/pg/Paytm-cash-sent.jpg"
            com.squareup.picasso.aa r1 = r1.a((java.lang.String) r2)
            net.one97.paytm.passbook.customview.b r2 = new net.one97.paytm.passbook.customview.b
            r2.<init>()
            com.squareup.picasso.ah r2 = (com.squareup.picasso.ah) r2
            com.squareup.picasso.aa r1 = r1.a((com.squareup.picasso.ah) r2)
            int r2 = net.one97.paytm.passbook.R.id.icon
            android.view.View r2 = r0.a((int) r2)
            net.one97.paytm.passbook.customview.CircularImageView r2 = (net.one97.paytm.passbook.customview.CircularImageView) r2
            r1.a((android.widget.ImageView) r2)
        L_0x0683:
            net.one97.paytm.passbook.transactionDetail.d.b r1 = r0.f58996a
            if (r1 != 0) goto L_0x068a
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x068a:
            net.one97.paytm.passbook.beans.CJRTransaction r2 = r0.f58998c
            if (r2 != 0) goto L_0x0691
            kotlin.g.b.k.a((java.lang.String) r7)
        L_0x0691:
            r1.a((net.one97.paytm.passbook.beans.CJRTransaction) r2)
            return
        L_0x0695:
            kotlin.u r1 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type net.one97.paytm.passbook.beans.CJRTransaction"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.transactionDetail.RecentTransactionsActivity.onCreate(android.os.Bundle):void");
    }

    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        net.one97.paytm.passbook.transactionDetail.a.b bVar = this.f58997b;
        if (bVar == null) {
            k.a("adapter");
        }
        bVar.f59014a = new ArrayList<>();
        bVar.notifyDataSetChanged();
        net.one97.paytm.passbook.transactionDetail.d.b bVar2 = this.f58996a;
        if (bVar2 == null) {
            k.a("viewModel");
        }
        bVar2.f59153c = 0;
        bVar2.f59151a = false;
        bVar2.f59152b = false;
        TextView textView = (TextView) a(R.id.totalReceivedTv);
        k.a((Object) textView, "totalReceivedTv");
        textView.setText(getString(R.string.simple_amount, new Object[]{"---"}));
        TextView textView2 = (TextView) a(R.id.totalSentTv);
        k.a((Object) textView2, "totalSentTv");
        textView2.setText(getString(R.string.simple_amount, new Object[]{"---"}));
        a(false);
        Serializable serializableExtra = intent != null ? intent.getSerializableExtra("data") : null;
        if (serializableExtra != null) {
            this.f58998c = (CJRTransaction) serializableExtra;
            CJRTransaction cJRTransaction = this.f58998c;
            if (cJRTransaction == null) {
                k.a("mTransaction");
            }
            if (cJRTransaction != null) {
                net.one97.paytm.passbook.transactionDetail.d.b bVar3 = this.f58996a;
                if (bVar3 == null) {
                    k.a("viewModel");
                }
                CJRTransaction cJRTransaction2 = this.f58998c;
                if (cJRTransaction2 == null) {
                    k.a("mTransaction");
                }
                bVar3.a(cJRTransaction2);
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.passbook.beans.CJRTransaction");
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecentTransactionsActivity f59001a;

        b(RecentTransactionsActivity recentTransactionsActivity) {
            this.f59001a = recentTransactionsActivity;
        }

        public final void onClick(View view) {
            this.f59001a.onBackPressed();
        }
    }

    public static final class c implements a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecentTransactionsActivity f59002a;

        c(RecentTransactionsActivity recentTransactionsActivity) {
            this.f59002a = recentTransactionsActivity;
        }

        public final void a(CJRTransaction cJRTransaction) {
            k.c(cJRTransaction, "transaction");
            Intent intent = new Intent(this.f59002a, PassbookTransactionDetailsActivity.class);
            intent.putExtra("passbook_detail_data", cJRTransaction);
            this.f59002a.startActivity(intent);
        }
    }

    public static final class e implements z<net.one97.paytm.passbook.mapping.a.e> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecentTransactionsActivity f59004a;

        e(RecentTransactionsActivity recentTransactionsActivity) {
            this.f59004a = recentTransactionsActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.passbook.mapping.a.a((net.one97.paytm.passbook.mapping.a.e) obj, this.f59004a, new a(this));
        }

        static final class a implements DialogInterface.OnCancelListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ e f59005a;

            a(e eVar) {
                this.f59005a = eVar;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                TextView textView = (TextView) this.f59005a.f59004a.a(R.id.msgTv);
                k.a((Object) textView, "msgTv");
                textView.setText(this.f59005a.f59004a.getString(R.string.failed_to_load_transactions));
                TextView textView2 = (TextView) this.f59005a.f59004a.a(R.id.msgTv);
                k.a((Object) textView2, "msgTv");
                textView2.setVisibility(0);
                ImageView imageView = (ImageView) this.f59005a.f59004a.a(R.id.retryBtn);
                k.a((Object) imageView, "retryBtn");
                imageView.setVisibility(0);
            }
        }
    }

    public static final class f implements z<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecentTransactionsActivity f59006a;

        f(RecentTransactionsActivity recentTransactionsActivity) {
            this.f59006a = recentTransactionsActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            IJRDataModel iJRDataModel = (IJRDataModel) obj;
            TextView textView = (TextView) this.f59006a.a(R.id.msgTv);
            k.a((Object) textView, "msgTv");
            textView.setVisibility(8);
            ImageView imageView = (ImageView) this.f59006a.a(R.id.retryBtn);
            k.a((Object) imageView, "retryBtn");
            imageView.setVisibility(8);
            if (iJRDataModel != null && (iJRDataModel instanceof CJRLedger)) {
                CJRLedger cJRLedger = (CJRLedger) iJRDataModel;
                if (p.a("SUCCESS", cJRLedger.getStatusCode(), true)) {
                    ArrayList<CJRTransaction> transactionList = cJRLedger.getTransactionList();
                    a aVar = a.f59009a;
                    k.a((Object) transactionList, "transactionList");
                    List<CJRTransaction> a2 = a.a(transactionList);
                    transactionList.clear();
                    transactionList.addAll(a2);
                    if (transactionList.size() > 0) {
                        this.f59006a.a().f59153c += transactionList.size();
                        net.one97.paytm.passbook.transactionDetail.a.b b2 = this.f59006a.b();
                        k.c(transactionList, "transactionList");
                        b2.f59014a.addAll(transactionList);
                        this.f59006a.b().notifyDataSetChanged();
                        RecentTransactionsActivity.a(this.f59006a, transactionList);
                    } else {
                        if (this.f59006a.a().f59153c == 0) {
                            TextView textView2 = (TextView) this.f59006a.a(R.id.msgTv);
                            k.a((Object) textView2, "msgTv");
                            textView2.setText(this.f59006a.getString(R.string.no_transaction_found));
                            TextView textView3 = (TextView) this.f59006a.a(R.id.msgTv);
                            k.a((Object) textView3, "msgTv");
                            textView3.setVisibility(0);
                        }
                        this.f59006a.a().f59151a = true;
                    }
                    this.f59006a.a().f59152b = false;
                }
            }
        }
    }

    public static final class g implements z<NetworkCustomError> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecentTransactionsActivity f59007a;

        g(RecentTransactionsActivity recentTransactionsActivity) {
            this.f59007a = recentTransactionsActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            NetworkCustomError networkCustomError = (NetworkCustomError) obj;
            this.f59007a.a().f59152b = false;
            if (!j.a((Context) this.f59007a, networkCustomError) && networkCustomError != null) {
                TextView textView = (TextView) this.f59007a.a(R.id.msgTv);
                k.a((Object) textView, "msgTv");
                textView.setText(networkCustomError.getAlertMessage());
                TextView textView2 = (TextView) this.f59007a.a(R.id.msgTv);
                k.a((Object) textView2, "msgTv");
                textView2.setVisibility(0);
            }
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecentTransactionsActivity f59008a;

        h(RecentTransactionsActivity recentTransactionsActivity) {
            this.f59008a = recentTransactionsActivity;
        }

        public final void onClick(View view) {
            net.one97.paytm.passbook.transactionDetail.d.b a2 = this.f59008a.a();
            CJRTransaction cJRTransaction = this.f59008a.f58998c;
            if (cJRTransaction == null) {
                k.a("mTransaction");
            }
            a2.a(cJRTransaction);
            TextView textView = (TextView) this.f59008a.a(R.id.msgTv);
            k.a((Object) textView, "msgTv");
            textView.setVisibility(8);
            ImageView imageView = (ImageView) this.f59008a.a(R.id.retryBtn);
            k.a((Object) imageView, "retryBtn");
            imageView.setVisibility(8);
        }
    }

    private final void a(boolean z) {
        int i2 = z ? 4 : 0;
        b(i2);
        c(i2);
    }

    private final void b(int i2) {
        TextView textView = (TextView) a(R.id.textView2);
        k.a((Object) textView, "textView2");
        textView.setVisibility(i2);
        TextView textView2 = (TextView) a(R.id.totalReceivedTv);
        k.a((Object) textView2, "totalReceivedTv");
        textView2.setVisibility(i2);
        CJRTransaction cJRTransaction = this.f58998c;
        if (cJRTransaction == null) {
            k.a("mTransaction");
        }
        if (!k.a((Object) cJRTransaction.getType(), (Object) "20")) {
            CJRTransaction cJRTransaction2 = this.f58998c;
            if (cJRTransaction2 == null) {
                k.a("mTransaction");
            }
            if (!k.a((Object) cJRTransaction2.getType(), (Object) "36")) {
                CJRTransaction cJRTransaction3 = this.f58998c;
                if (cJRTransaction3 == null) {
                    k.a("mTransaction");
                }
                if (!k.a((Object) cJRTransaction3.getType(), (Object) "53")) {
                    ImageView imageView = (ImageView) a(R.id.imv2);
                    k.a((Object) imageView, "imv2");
                    imageView.setVisibility(8);
                    return;
                }
            }
        }
        ImageView imageView2 = (ImageView) a(R.id.imv2);
        k.a((Object) imageView2, "imv2");
        imageView2.setVisibility(8);
    }

    private final void c(int i2) {
        TextView textView = (TextView) a(R.id.sub_title1);
        k.a((Object) textView, "sub_title1");
        textView.setVisibility(i2);
        TextView textView2 = (TextView) a(R.id.totalSentTv);
        k.a((Object) textView2, "totalSentTv");
        textView2.setVisibility(i2);
        ImageView imageView = (ImageView) a(R.id.imv1);
        k.a((Object) imageView, "imv1");
        imageView.setVisibility(i2);
        if (i2 == 4) {
            androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
            cVar.b((ConstraintLayout) a(R.id.constLayout));
            cVar.a(R.id.textView2, 3, R.id.iconRl, 3);
            cVar.a(R.id.textView2, 6, R.id.iconRl, 7, 30);
            cVar.c((ConstraintLayout) a(R.id.constLayout));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0182 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:62:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.passbook.transactionDetail.RecentTransactionsActivity r14, java.util.ArrayList r15) {
        /*
            java.util.Iterator r15 = r15.iterator()
            r0 = 0
            r2 = r0
        L_0x0007:
            boolean r4 = r15.hasNext()
            java.lang.String r5 = "DR"
            r6 = 1
            if (r4 == 0) goto L_0x0042
            java.lang.Object r4 = r15.next()
            net.one97.paytm.passbook.beans.CJRTransaction r4 = (net.one97.paytm.passbook.beans.CJRTransaction) r4
            java.lang.String r7 = r4.getTxnAmount()
            if (r7 == 0) goto L_0x0007
            java.lang.String r7 = r4.getTxnType()
            boolean r5 = kotlin.m.p.a((java.lang.String) r5, (java.lang.String) r7, (boolean) r6)
            java.lang.String r6 = "transaction.txnAmount"
            if (r5 == 0) goto L_0x0035
            java.lang.String r4 = r4.getTxnAmount()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            double r4 = java.lang.Double.parseDouble(r4)
            double r2 = r2 + r4
            goto L_0x0007
        L_0x0035:
            java.lang.String r4 = r4.getTxnAmount()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            double r4 = java.lang.Double.parseDouble(r4)
            double r0 = r0 + r4
            goto L_0x0007
        L_0x0042:
            net.one97.paytm.passbook.transactionDetail.a r15 = net.one97.paytm.passbook.transactionDetail.a.f59009a
            net.one97.paytm.passbook.beans.CJRTransaction r15 = r14.f58998c
            java.lang.String r4 = "mTransaction"
            if (r15 != 0) goto L_0x004d
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x004d:
            boolean r15 = net.one97.paytm.passbook.transactionDetail.a.c(r15)
            r7 = 8
            java.lang.String r8 = "--.--"
            r9 = 4
            java.lang.String r10 = "5"
            r11 = 0
            if (r15 == 0) goto L_0x00a0
            int r15 = net.one97.paytm.passbook.R.id.totalReceivedTv
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            int r12 = net.one97.paytm.passbook.R.string.simple_amount
            java.lang.Object[] r13 = new java.lang.Object[r6]
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r0 = net.one97.paytm.passbook.utility.c.a((java.lang.String) r0)
            r13[r11] = r0
            java.lang.String r0 = r14.getString(r12, r13)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r15.setText(r0)
            int r15 = net.one97.paytm.passbook.R.id.textView2
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r0 = "textView2"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r0)
            net.one97.paytm.passbook.transactionDetail.a r0 = net.one97.paytm.passbook.transactionDetail.a.f59009a
            r0 = r14
            android.content.Context r0 = (android.content.Context) r0
            net.one97.paytm.passbook.beans.CJRTransaction r1 = r14.f58998c
            if (r1 != 0) goto L_0x0093
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0093:
            java.lang.String r0 = net.one97.paytm.passbook.transactionDetail.a.c(r0, r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r15.setText(r0)
            r14.b(r11)
            goto L_0x00e6
        L_0x00a0:
            net.one97.paytm.passbook.beans.CJRTransaction r15 = r14.f58998c
            if (r15 != 0) goto L_0x00a7
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x00a7:
            java.lang.String r15 = r15.getType()
            boolean r15 = kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.Object) r10)
            if (r15 == 0) goto L_0x00e3
            net.one97.paytm.passbook.beans.CJRTransaction r15 = r14.f58998c
            if (r15 != 0) goto L_0x00b8
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x00b8:
            java.lang.String r15 = r15.getTxnType()
            boolean r15 = kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.Object) r5)
            if (r15 != 0) goto L_0x00c3
            goto L_0x00e3
        L_0x00c3:
            int r15 = net.one97.paytm.passbook.R.id.totalReceivedTv
            android.view.View r15 = r14.a((int) r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            r0 = r8
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r15.setText(r0)
            int r15 = net.one97.paytm.passbook.R.id.imv2
            android.view.View r15 = r14.a((int) r15)
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            java.lang.String r0 = "imv2"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r0)
            r15.setVisibility(r7)
            r15 = 0
            goto L_0x00e7
        L_0x00e3:
            r14.b(r9)
        L_0x00e6:
            r15 = 1
        L_0x00e7:
            net.one97.paytm.passbook.transactionDetail.a r0 = net.one97.paytm.passbook.transactionDetail.a.f59009a
            net.one97.paytm.passbook.beans.CJRTransaction r0 = r14.f58998c
            if (r0 != 0) goto L_0x00f0
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x00f0:
            boolean r0 = net.one97.paytm.passbook.transactionDetail.a.b(r0)
            if (r0 == 0) goto L_0x013b
            int r0 = net.one97.paytm.passbook.R.id.totalSentTv
            android.view.View r0 = r14.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            int r1 = net.one97.paytm.passbook.R.string.simple_amount
            java.lang.Object[] r5 = new java.lang.Object[r6]
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r2 = net.one97.paytm.passbook.utility.c.a((java.lang.String) r2)
            r5[r11] = r2
            java.lang.String r1 = r14.getString(r1, r5)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            int r0 = net.one97.paytm.passbook.R.id.sub_title1
            android.view.View r0 = r14.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "sub_title1"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            net.one97.paytm.passbook.transactionDetail.a r1 = net.one97.paytm.passbook.transactionDetail.a.f59009a
            r1 = r14
            android.content.Context r1 = (android.content.Context) r1
            net.one97.paytm.passbook.beans.CJRTransaction r2 = r14.f58998c
            if (r2 != 0) goto L_0x012e
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x012e:
            java.lang.String r1 = net.one97.paytm.passbook.transactionDetail.a.b(r1, r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            r14.c(r11)
            goto L_0x017f
        L_0x013b:
            net.one97.paytm.passbook.beans.CJRTransaction r0 = r14.f58998c
            if (r0 != 0) goto L_0x0142
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0142:
            java.lang.String r0 = r0.getType()
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r10)
            if (r0 == 0) goto L_0x017c
            net.one97.paytm.passbook.beans.CJRTransaction r0 = r14.f58998c
            if (r0 != 0) goto L_0x0153
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0153:
            java.lang.String r0 = r0.getTxnType()
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r5)
            if (r0 != 0) goto L_0x015e
            goto L_0x017c
        L_0x015e:
            int r0 = net.one97.paytm.passbook.R.id.totalSentTv
            android.view.View r0 = r14.a((int) r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r0.setText(r8)
            int r0 = net.one97.paytm.passbook.R.id.imv1
            android.view.View r0 = r14.a((int) r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            java.lang.String r1 = "imv1"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r0.setVisibility(r7)
            goto L_0x0180
        L_0x017c:
            r14.c(r9)
        L_0x017f:
            r11 = 1
        L_0x0180:
            if (r15 != 0) goto L_0x0187
            if (r11 != 0) goto L_0x0187
            r14.a((boolean) r6)
        L_0x0187:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.transactionDetail.RecentTransactionsActivity.a(net.one97.paytm.passbook.transactionDetail.RecentTransactionsActivity, java.util.ArrayList):void");
    }
}
