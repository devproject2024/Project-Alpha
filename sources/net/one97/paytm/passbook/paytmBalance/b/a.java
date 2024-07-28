package net.one97.paytm.passbook.paytmBalance.b;

import android.view.View;
import com.appsflyer.internal.referrer.Payload;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.k;
import net.one97.paytm.passbook.beans.CJRCashWallet;
import net.one97.paytm.passbook.main.entity.MultiSubWallet;
import net.one97.paytm.passbook.main.widget.PassbookBalanceCardView;
import net.one97.paytm.passbook.mapping.a.f;

public final class a extends net.one97.paytm.passbook.landing.e.a {

    /* renamed from: a  reason: collision with root package name */
    public f<? extends CJRCashWallet> f58198a;

    public a(f<? extends CJRCashWallet> fVar) {
        k.c(fVar, Payload.RESPONSE);
        this.f58198a = fVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.passbook.paytmBalance.fragment.PaytmBalanceHeaderFragment r14, java.util.ArrayList<net.one97.paytm.passbook.main.entity.MultiSubWallet> r15) {
        /*
            r13 = this;
            int r0 = net.one97.paytm.passbook.R.id.itemsLayout
            android.view.View r0 = r14.a((int) r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r0.removeAllViews()
            java.util.Iterator r0 = r15.iterator()
        L_0x000f:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x01f5
            java.lang.Object r1 = r0.next()
            net.one97.paytm.passbook.main.entity.MultiSubWallet r1 = (net.one97.paytm.passbook.main.entity.MultiSubWallet) r1
            android.content.Context r2 = r14.getContext()
            r3 = 0
            if (r2 == 0) goto L_0x01da
            java.lang.String r4 = "wallet"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            java.lang.String r4 = "it"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r5 = new net.one97.paytm.passbook.main.widget.PassbookBalanceCardView
            r5.<init>(r2)
            java.util.ArrayList r6 = r1.getSubWalletList()
            r7 = 1
            r8 = 0
            if (r6 == 0) goto L_0x00b4
            java.lang.Object r6 = r6.get(r8)
            net.one97.paytm.passbook.beans.CJRSubWallet r6 = (net.one97.paytm.passbook.beans.CJRSubWallet) r6
            if (r6 == 0) goto L_0x00b4
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r4)
            int r4 = r6.getSubWalletType()
            r9 = 7
            if (r4 != r9) goto L_0x0071
            java.lang.String r4 = r6.getmIssuerId()
            if (r4 == 0) goto L_0x0071
            java.lang.String r4 = r6.getmIssuerId()
            net.one97.paytm.passbook.mapping.f r6 = net.one97.paytm.passbook.d.b()
            java.lang.String r9 = "PassbookHelper.getImplListener()"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r9)
            android.content.Context r6 = r6.b()
            int r9 = net.one97.paytm.passbook.R.string.pass_gamepind_wallet_issuer_id
            java.lang.String r6 = r6.getString(r9)
            boolean r4 = kotlin.m.p.a((java.lang.String) r4, (java.lang.String) r6, (boolean) r7)
            if (r4 == 0) goto L_0x0071
            r4 = 1
            goto L_0x0072
        L_0x0071:
            r4 = 0
        L_0x0072:
            if (r4 == 0) goto L_0x00b4
            r5.setVisibility(r8)
            int r2 = net.one97.paytm.passbook.R.string.pass_first_games_wallet_name
            r5.setTitle((int) r2)
            double r8 = r1.getBalance()
            r5.setAmount((double) r8)
            int r2 = net.one97.paytm.passbook.R.id.tvTitle
            android.view.View r2 = r5.a((int) r2)
            androidx.appcompat.widget.AppCompatTextView r2 = (androidx.appcompat.widget.AppCompatTextView) r2
            java.lang.String r4 = "paytmGameCardView.tvTitle"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            android.graphics.Typeface r4 = android.graphics.Typeface.DEFAULT
            r2.setTypeface(r4)
            int r2 = net.one97.paytm.passbook.R.id.tvAmount
            android.view.View r2 = r5.a((int) r2)
            androidx.appcompat.widget.AppCompatTextView r2 = (androidx.appcompat.widget.AppCompatTextView) r2
            java.lang.String r4 = "paytmGameCardView.tvAmount"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            android.graphics.Typeface r4 = android.graphics.Typeface.DEFAULT
            r2.setTypeface(r4)
            int r2 = net.one97.paytm.passbook.R.drawable.paytm_game_icon
            r5.setIcon(r2)
            r5.setFullIcon(r7)
            r5.setIconBackground(r3)
            goto L_0x01d9
        L_0x00b4:
            int r4 = net.one97.paytm.passbook.R.id.tvTitle
            android.view.View r4 = r5.a((int) r4)
            androidx.appcompat.widget.AppCompatTextView r4 = (androidx.appcompat.widget.AppCompatTextView) r4
            java.lang.String r6 = "view.tvTitle"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            java.lang.String r9 = r1.getDisplayName()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r4.setText(r9)
            java.util.ArrayList r4 = r1.getSubWalletList()
            java.lang.String r9 = "view.tvAmount"
            if (r4 == 0) goto L_0x012a
            int r4 = r4.size()
            if (r4 <= 0) goto L_0x0103
            java.util.ArrayList r4 = r1.getSubWalletList()
            java.lang.String r10 = "wallet.subWalletList"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r10)
            java.util.Collection r4 = (java.util.Collection) r4
            int r4 = r4.size()
            r10 = 0
        L_0x00eb:
            if (r10 >= r4) goto L_0x0103
            java.util.ArrayList r11 = r1.getSubWalletList()
            java.lang.Object r11 = r11.get(r10)
            java.lang.String r12 = "wallet.subWalletList[i]"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r12)
            net.one97.paytm.passbook.beans.CJRSubWallet r11 = (net.one97.paytm.passbook.beans.CJRSubWallet) r11
            r11.getBalance()
            int r10 = r10 + 1
            goto L_0x00eb
        L_0x0103:
            int r4 = net.one97.paytm.passbook.R.id.tvAmount
            android.view.View r4 = r5.a((int) r4)
            androidx.appcompat.widget.AppCompatTextView r4 = (androidx.appcompat.widget.AppCompatTextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r9)
            android.widget.TextView r4 = (android.widget.TextView) r4
            int r10 = net.one97.paytm.passbook.R.string.pass_rupee
            java.lang.Object[] r7 = new java.lang.Object[r7]
            double r11 = r1.getBalance()
            java.lang.String r11 = net.one97.paytm.passbook.utility.f.a((double) r11)
            r7[r8] = r11
            java.lang.String r7 = r2.getString(r10, r7)
            java.lang.String r10 = "context.getString(R.stri….balance.amountFormat1())"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r10)
            net.one97.paytm.passbook.utility.f.a(r4, r7)
        L_0x012a:
            int r4 = net.one97.paytm.passbook.R.id.tvTitle
            android.view.View r4 = r5.a((int) r4)
            androidx.appcompat.widget.AppCompatTextView r4 = (androidx.appcompat.widget.AppCompatTextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            android.graphics.Typeface r7 = android.graphics.Typeface.DEFAULT
            r4.setTypeface(r7)
            int r4 = net.one97.paytm.passbook.R.id.tvAmount
            android.view.View r4 = r5.a((int) r4)
            androidx.appcompat.widget.AppCompatTextView r4 = (androidx.appcompat.widget.AppCompatTextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r9)
            android.graphics.Typeface r7 = android.graphics.Typeface.DEFAULT
            r4.setTypeface(r7)
            int r4 = net.one97.paytm.passbook.R.id.ivWalletIcon
            android.view.View r4 = r5.a((int) r4)
            androidx.appcompat.widget.AppCompatImageView r4 = (androidx.appcompat.widget.AppCompatImageView) r4
            int r7 = r1.getSubWalletType()
            int r7 = net.one97.paytm.passbook.utility.q.a((int) r7)
            r4.setImageResource(r7)
            int r4 = net.one97.paytm.passbook.R.id.ivWalletIcon
            android.view.View r4 = r5.a((int) r4)
            androidx.appcompat.widget.AppCompatImageView r4 = (androidx.appcompat.widget.AppCompatImageView) r4
            java.lang.String r7 = "view.ivWalletIcon"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r7)
            r4.setBackground(r3)
            r3 = r1
            net.one97.paytm.passbook.beans.CJRSubWallet r3 = (net.one97.paytm.passbook.beans.CJRSubWallet) r3
            int r3 = r3.getSubWalletType()
            net.one97.paytm.passbook.utility.n r4 = net.one97.paytm.passbook.utility.n.GIFT_VOUCHER
            int r4 = r4.getValue()
            if (r3 != r4) goto L_0x01d9
            int r3 = net.one97.paytm.passbook.R.id.tvTitle
            android.view.View r3 = r5.a((int) r3)
            androidx.appcompat.widget.AppCompatTextView r3 = (androidx.appcompat.widget.AppCompatTextView) r3
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r6)
            int r4 = net.one97.paytm.passbook.R.string.pass_gift_voucher
            java.lang.String r2 = r2.getString(r4)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3.setText(r2)
            net.one97.paytm.passbook.mapping.a.f<? extends net.one97.paytm.passbook.beans.CJRCashWallet> r2 = r13.f58198a
            T r2 = r2.f57887b
            net.one97.paytm.passbook.beans.CJRCashWallet r2 = (net.one97.paytm.passbook.beans.CJRCashWallet) r2
            if (r2 == 0) goto L_0x01d9
            net.one97.paytm.passbook.beans.CJRCashWalletResponse r2 = r2.getResponse()
            if (r2 == 0) goto L_0x01d9
            int r2 = r2.getUnClaimedGVCount()
            if (r2 <= 0) goto L_0x01d9
            int r3 = net.one97.paytm.passbook.R.id.tvGVCount
            android.view.View r3 = r5.a((int) r3)
            androidx.appcompat.widget.AppCompatTextView r3 = (androidx.appcompat.widget.AppCompatTextView) r3
            java.lang.String r4 = "view.tvGVCount"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            java.lang.String r2 = " New"
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3.setText(r2)
            int r2 = net.one97.paytm.passbook.R.id.tvGVCount
            android.view.View r2 = r5.a((int) r2)
            androidx.appcompat.widget.AppCompatTextView r2 = (androidx.appcompat.widget.AppCompatTextView) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            r2.setVisibility(r8)
        L_0x01d9:
            r3 = r5
        L_0x01da:
            if (r3 == 0) goto L_0x01e6
            net.one97.paytm.passbook.paytmBalance.b.a$a r2 = new net.one97.paytm.passbook.paytmBalance.b.a$a
            r2.<init>(r13, r1, r3, r15)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r3.setOnClickListener(r2)
        L_0x01e6:
            int r1 = net.one97.paytm.passbook.R.id.itemsLayout
            android.view.View r1 = r14.a((int) r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            android.view.View r3 = (android.view.View) r3
            r1.addView(r3)
            goto L_0x000f
        L_0x01f5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.paytmBalance.b.a.a(net.one97.paytm.passbook.paytmBalance.fragment.PaytmBalanceHeaderFragment, java.util.ArrayList):void");
    }

    /* renamed from: net.one97.paytm.passbook.paytmBalance.b.a$a  reason: collision with other inner class name */
    static final class C1118a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f58199a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MultiSubWallet f58200b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ PassbookBalanceCardView f58201c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayList f58202d;

        C1118a(a aVar, MultiSubWallet multiSubWallet, PassbookBalanceCardView passbookBalanceCardView, ArrayList arrayList) {
            this.f58199a = aVar;
            this.f58200b = multiSubWallet;
            this.f58201c = passbookBalanceCardView;
            this.f58202d = arrayList;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x004a, code lost:
            r5 = r5.get(0);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r12) {
            /*
                r11 = this;
                net.one97.paytm.passbook.main.entity.MultiSubWallet r0 = r11.f58200b
                java.lang.String r1 = "wallet"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                java.util.ArrayList r0 = r0.getSubWalletList()
                r2 = 0
                r3 = 0
                if (r0 == 0) goto L_0x0092
                java.lang.Object r0 = r0.get(r3)
                net.one97.paytm.passbook.beans.CJRSubWallet r0 = (net.one97.paytm.passbook.beans.CJRSubWallet) r0
                if (r0 == 0) goto L_0x0092
                int r0 = r0.getSubWalletType()
                net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r4 = r11.f58201c
                net.one97.paytm.passbook.main.entity.MultiSubWallet r5 = r11.f58200b
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r1)
                java.util.ArrayList r6 = r11.f58202d
                java.util.Collection r6 = (java.util.Collection) r6
                net.one97.paytm.passbook.utility.n r7 = net.one97.paytm.passbook.utility.n.PAYTM_WALLET
                int r7 = r7.getValue()
                r8 = 603979776(0x24000000, float:2.7755576E-17)
                if (r0 == r7) goto L_0x0078
                net.one97.paytm.passbook.utility.n r7 = net.one97.paytm.passbook.utility.n.LOYALTY_WALLET_TYPE_7
                int r7 = r7.getValue()
                if (r0 != r7) goto L_0x0039
                goto L_0x0078
            L_0x0039:
                android.content.Intent r7 = new android.content.Intent
                android.content.Context r9 = r4.getContext()
                java.lang.Class<net.one97.paytm.passbook.subWallet.PassbookSubwalletActivity> r10 = net.one97.paytm.passbook.subWallet.PassbookSubwalletActivity.class
                r7.<init>(r9, r10)
                java.util.ArrayList r5 = r5.getSubWalletList()
                if (r5 == 0) goto L_0x0057
                java.lang.Object r5 = r5.get(r3)
                net.one97.paytm.passbook.beans.CJRSubWallet r5 = (net.one97.paytm.passbook.beans.CJRSubWallet) r5
                if (r5 == 0) goto L_0x0057
                java.lang.String r5 = r5.getDisplayName()
                goto L_0x0058
            L_0x0057:
                r5 = r2
            L_0x0058:
                java.lang.String r9 = "display_name"
                r7.putExtra(r9, r5)
                net.one97.paytm.passbook.main.entity.MultiSubWallet r5 = net.one97.paytm.passbook.paytmBalance.b.a.a((int) r0, (java.util.Collection<net.one97.paytm.passbook.main.entity.MultiSubWallet>) r6)
                java.io.Serializable r5 = (java.io.Serializable) r5
                java.lang.String r6 = "subwallet-list"
                r7.putExtra(r6, r5)
                java.lang.String r5 = "sub_wallet_type"
                r7.putExtra(r5, r0)
                r7.setFlags(r8)
                android.content.Context r0 = r4.getContext()
                r0.startActivity(r7)
                goto L_0x0092
            L_0x0078:
                android.content.Intent r5 = new android.content.Intent
                android.content.Context r6 = r4.getContext()
                java.lang.Class<net.one97.paytm.passbook.genericPassbook.activity.PassbookL2Activity> r7 = net.one97.paytm.passbook.genericPassbook.activity.PassbookL2Activity.class
                r5.<init>(r6, r7)
                java.lang.String r6 = "passbook_type"
                r5.putExtra(r6, r0)
                r5.setFlags(r8)
                android.content.Context r0 = r4.getContext()
                r0.startActivity(r5)
            L_0x0092:
                java.lang.String r0 = "it"
                kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r0)
                android.content.Context r4 = r12.getContext()
                net.one97.paytm.passbook.main.entity.MultiSubWallet r12 = r11.f58200b
                kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r1)
                java.util.ArrayList r12 = r12.getSubWalletList()
                if (r12 == 0) goto L_0x00b2
                java.lang.Object r12 = r12.get(r3)
                net.one97.paytm.passbook.beans.CJRSubWallet r12 = (net.one97.paytm.passbook.beans.CJRSubWallet) r12
                if (r12 == 0) goto L_0x00b2
                java.lang.String r2 = r12.getDisplayName()
            L_0x00b2:
                r7 = r2
                r8 = 0
                java.lang.String r5 = "uth_passbook"
                java.lang.String r6 = "total_bal_item_clicked"
                java.lang.String r9 = "/uth_passbook/paytmbalance"
                java.lang.String r10 = "PASSBOOK"
                net.one97.paytm.passbook.utility.q.a(r4, r5, r6, r7, r8, r9, r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.paytmBalance.b.a.C1118a.onClick(android.view.View):void");
        }
    }

    static MultiSubWallet a(int i2, Collection<MultiSubWallet> collection) {
        MultiSubWallet multiSubWallet = new MultiSubWallet(i2, false);
        for (MultiSubWallet next : collection) {
            if (next.getSubWalletType() == i2) {
                multiSubWallet.addSubWallet(next);
            }
        }
        return multiSubWallet;
    }
}
