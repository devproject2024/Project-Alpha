package net.one97.paytm.passbook.landing.e;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import com.appsflyer.internal.referrer.Payload;
import com.squareup.picasso.e;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.x;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.upi.BankAccountDetails;
import net.one97.paytm.passbook.beans.upi.UpiProfileDefaultBank;
import net.one97.paytm.passbook.beans.upi.UpiProfileModel;
import net.one97.paytm.passbook.main.widget.PassbookBalanceCardView;
import net.one97.paytm.passbook.mapping.a.f;
import net.one97.paytm.passbook.utility.q;
import net.one97.paytm.upi.util.UpiConstants;

public final class aa extends a {

    /* renamed from: a  reason: collision with root package name */
    private String f57613a;

    /* renamed from: b  reason: collision with root package name */
    private f<? extends UpiProfileModel> f57614b;

    public aa(f<? extends UpiProfileModel> fVar) {
        k.c(fVar, Payload.RESPONSE);
        this.f57614b = fVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0055, code lost:
        r0 = (r0 = r0.getResponse()).getProfileDetail();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.passbook.landing.f.a r25, android.widget.LinearLayout r26, net.one97.paytm.passbook.landing.c.a r27) {
        /*
            r24 = this;
            r10 = r24
            r11 = r26
            java.lang.String r0 = "balanceSummaryUIHandler"
            r12 = r25
            kotlin.g.b.k.c(r12, r0)
            java.lang.String r0 = "itemsLayout"
            kotlin.g.b.k.c(r11, r0)
            java.lang.String r0 = "balanceSummaryFragment"
            r13 = r27
            kotlin.g.b.k.c(r13, r0)
            net.one97.paytm.passbook.mapping.a.f<? extends net.one97.paytm.passbook.beans.upi.UpiProfileModel> r0 = r10.f57614b
            net.one97.paytm.passbook.mapping.a.j r0 = r0.f57886a
            int[] r1 = net.one97.paytm.passbook.landing.e.ab.f57634a
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r14 = 1
            if (r0 == r14) goto L_0x0033
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r25.j()
            android.view.View r0 = (android.view.View) r0
            r11.removeView(r0)
            r25.b(r26)
            return
        L_0x0033:
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r25.j()
            r0.a()
            kotlin.g.b.x$e r15 = new kotlin.g.b.x$e
            r15.<init>()
            net.one97.paytm.passbook.mapping.a.f<? extends net.one97.paytm.passbook.beans.upi.UpiProfileModel> r0 = r10.f57614b
            T r0 = r0.f57887b
            net.one97.paytm.passbook.beans.upi.UpiProfileModel r0 = (net.one97.paytm.passbook.beans.upi.UpiProfileModel) r0
            r15.element = r0
            T r0 = r15.element
            net.one97.paytm.passbook.beans.upi.UpiProfileModel r0 = (net.one97.paytm.passbook.beans.upi.UpiProfileModel) r0
            r16 = 0
            if (r0 == 0) goto L_0x0062
            net.one97.paytm.passbook.beans.upi.UpiProfileModel$AccountDetails r0 = r0.getResponse()
            if (r0 == 0) goto L_0x0062
            net.one97.paytm.passbook.beans.upi.UpiProfileModel$ProfileDetails r0 = r0.getProfileDetail()
            if (r0 == 0) goto L_0x0062
            java.util.List r0 = r0.getProfileVpaList()
            r17 = r0
            goto L_0x0064
        L_0x0062:
            r17 = r16
        L_0x0064:
            T r0 = r15.element
            net.one97.paytm.passbook.beans.upi.UpiProfileModel r0 = (net.one97.paytm.passbook.beans.upi.UpiProfileModel) r0
            if (r0 == 0) goto L_0x007b
            net.one97.paytm.passbook.beans.upi.UpiProfileModel$AccountDetails r0 = r0.getResponse()
            if (r0 == 0) goto L_0x007b
            net.one97.paytm.passbook.beans.upi.UpiProfileModel$ProfileDetails r0 = r0.getProfileDetail()
            if (r0 == 0) goto L_0x007b
            java.util.ArrayList r0 = r0.getBankAccountList()
            goto L_0x007d
        L_0x007b:
            r0 = r16
        L_0x007d:
            java.util.List r0 = (java.util.List) r0
            r1 = r17
            java.util.Collection r1 = (java.util.Collection) r1
            r9 = 0
            if (r1 == 0) goto L_0x008f
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x008d
            goto L_0x008f
        L_0x008d:
            r1 = 0
            goto L_0x0090
        L_0x008f:
            r1 = 1
        L_0x0090:
            if (r1 == 0) goto L_0x009c
            net.one97.paytm.passbook.main.widget.UPIInitCardV2 r1 = r25.u()
            android.view.View r1 = (android.view.View) r1
            r11.removeView(r1)
            goto L_0x00ff
        L_0x009c:
            r1 = r17
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x00a4:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00ff
            java.lang.Object r2 = r1.next()
            net.one97.paytm.passbook.beans.upi.UpiProfileDefaultBank r2 = (net.one97.paytm.passbook.beans.upi.UpiProfileDefaultBank) r2
            boolean r3 = r2.isPrimary()
            if (r3 == 0) goto L_0x00a4
            if (r2 == 0) goto L_0x00c3
            net.one97.paytm.passbook.beans.upi.BankAccountDetails$BankAccount r2 = r2.getDebitBank()
            if (r2 == 0) goto L_0x00c3
            java.lang.String r2 = r2.getAccount()
            goto L_0x00c5
        L_0x00c3:
            r2 = r16
        L_0x00c5:
            r10.f57613a = r2
            T r2 = r15.element
            net.one97.paytm.passbook.beans.upi.UpiProfileModel r2 = (net.one97.paytm.passbook.beans.upi.UpiProfileModel) r2
            if (r2 == 0) goto L_0x00ed
            net.one97.paytm.passbook.beans.upi.UpiProfileModel$AccountDetails r2 = r2.getResponse()
            if (r2 == 0) goto L_0x00ed
            net.one97.paytm.passbook.beans.upi.UpiProfileModel$ProfileDetails r2 = r2.getProfileDetail()
            if (r2 == 0) goto L_0x00ed
            java.util.ArrayList r2 = r2.getBankAccountList()
            if (r2 == 0) goto L_0x00ed
            int r2 = r2.size()
            if (r2 <= 0) goto L_0x00e7
            r2 = 1
            goto L_0x00e8
        L_0x00e7:
            r2 = 0
        L_0x00e8:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            goto L_0x00ef
        L_0x00ed:
            r2 = r16
        L_0x00ef:
            if (r2 == 0) goto L_0x00a4
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x00a4
            net.one97.paytm.passbook.main.widget.UPIInitCardV2 r0 = r25.u()
            r0.setVisibility(r9)
            return
        L_0x00ff:
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            if (r1 == 0) goto L_0x010d
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x010b
            goto L_0x010d
        L_0x010b:
            r1 = 0
            goto L_0x010e
        L_0x010d:
            r1 = 1
        L_0x010e:
            if (r1 == 0) goto L_0x0127
            net.one97.paytm.passbook.main.widget.UPIInitCardV2 r0 = r25.u()
            android.view.View r0 = (android.view.View) r0
            int r0 = r11.indexOfChild(r0)
            if (r0 <= 0) goto L_0x0369
            net.one97.paytm.passbook.main.widget.UPIInitCardV2 r0 = r25.u()
            android.view.View r0 = (android.view.View) r0
            r11.removeView(r0)
            goto L_0x0369
        L_0x0127:
            kotlin.g.b.x$c r8 = new kotlin.g.b.x$c
            r8.<init>()
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r1 = r25.j()
            android.view.View r1 = (android.view.View) r1
            int r1 = r11.indexOfChild(r1)
            r8.element = r1
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r1 = r25.j()
            android.view.View r1 = (android.view.View) r1
            r11.removeView(r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r2 = r0.iterator()
            r3 = 0
        L_0x014d:
            boolean r4 = r2.hasNext()
            java.lang.String r5 = "null cannot be cast to non-null type java.lang.String"
            java.lang.String r6 = "Paytm Payments Bank"
            if (r4 == 0) goto L_0x018f
            java.lang.Object r4 = r2.next()
            int r7 = r3 + 1
            if (r3 >= 0) goto L_0x0162
            kotlin.a.k.a()
        L_0x0162:
            net.one97.paytm.passbook.beans.upi.BankAccountDetails$BankAccount r4 = (net.one97.paytm.passbook.beans.upi.BankAccountDetails.BankAccount) r4
            java.lang.String r3 = r4.getAccount()
            java.lang.String r9 = r10.f57613a
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r9)
            if (r3 == 0) goto L_0x018c
            if (r4 == 0) goto L_0x018c
            java.lang.String r3 = r4.getBankName()
            if (r3 == 0) goto L_0x018c
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            if (r3 == 0) goto L_0x0186
            boolean r3 = r3.contentEquals(r6)
            if (r3 != 0) goto L_0x018c
            r1.add(r4)
            goto L_0x018c
        L_0x0186:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r5)
            throw r0
        L_0x018c:
            r3 = r7
            r9 = 0
            goto L_0x014d
        L_0x018f:
            java.util.Iterator r0 = r0.iterator()
            r2 = 0
        L_0x0194:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x01d3
            java.lang.Object r3 = r0.next()
            int r4 = r2 + 1
            if (r2 >= 0) goto L_0x01a5
            kotlin.a.k.a()
        L_0x01a5:
            net.one97.paytm.passbook.beans.upi.BankAccountDetails$BankAccount r3 = (net.one97.paytm.passbook.beans.upi.BankAccountDetails.BankAccount) r3
            if (r3 == 0) goto L_0x01d1
            java.lang.String r2 = r3.getBankName()
            if (r2 == 0) goto L_0x01d1
            r7 = r6
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r2 == 0) goto L_0x01cb
            boolean r2 = r2.contentEquals(r7)
            if (r2 != 0) goto L_0x01d1
            java.lang.String r2 = r3.getAccount()
            java.lang.String r7 = r10.f57613a
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r7)
            r2 = r2 ^ r14
            if (r2 == 0) goto L_0x01d1
            r1.add(r3)
            goto L_0x01d1
        L_0x01cb:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r5)
            throw r0
        L_0x01d1:
            r2 = r4
            goto L_0x0194
        L_0x01d3:
            java.util.List r1 = (java.util.List) r1
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r19 = r1.iterator()
            r0 = 0
        L_0x01dc:
            boolean r1 = r19.hasNext()
            if (r1 == 0) goto L_0x0369
            java.lang.Object r1 = r19.next()
            int r20 = r0 + 1
            if (r0 >= 0) goto L_0x01ed
            kotlin.a.k.a()
        L_0x01ed:
            r9 = r1
            net.one97.paytm.passbook.beans.upi.BankAccountDetails$BankAccount r9 = (net.one97.paytm.passbook.beans.upi.BankAccountDetails.BankAccount) r9
            if (r9 == 0) goto L_0x035c
            java.lang.String r0 = r9.getBankName()
            if (r0 == 0) goto L_0x035c
            T r0 = r15.element
            net.one97.paytm.passbook.beans.upi.UpiProfileModel r0 = (net.one97.paytm.passbook.beans.upi.UpiProfileModel) r0
            if (r0 == 0) goto L_0x021e
            net.one97.paytm.passbook.beans.upi.UpiProfileModel$AccountDetails r0 = r0.getResponse()
            if (r0 == 0) goto L_0x021e
            net.one97.paytm.passbook.beans.upi.UpiProfileModel$ProfileDetails r0 = r0.getProfileDetail()
            if (r0 == 0) goto L_0x021e
            java.util.ArrayList r0 = r0.getBankAccountList()
            if (r0 == 0) goto L_0x021e
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x0218
            r0 = 1
            goto L_0x0219
        L_0x0218:
            r0 = 0
        L_0x0219:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x0220
        L_0x021e:
            r0 = r16
        L_0x0220:
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r7 = new net.one97.paytm.passbook.main.widget.PassbookBalanceCardView
            android.content.Context r1 = r26.getContext()
            java.lang.String r2 = "itemsLayout.context"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            int r2 = net.one97.paytm.passbook.R.layout.pass_upi_card_view
            r7.<init>(r1, r2)
            r1 = 8
            r7.setVisibility(r1)
            r7.a()
            int r2 = r8.element
            if (r0 == 0) goto L_0x0250
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x0250
            r7.setVisibility(r1)
            net.one97.paytm.passbook.main.widget.UPIInitCardV2 r0 = r25.u()
            r3 = 0
            r0.setVisibility(r3)
            r6 = 0
            goto L_0x0301
        L_0x0250:
            r3 = 0
            r7.setVisibility(r3)
            int r0 = net.one97.paytm.passbook.R.id.ivWalletIcon
            android.view.View r0 = r7.findViewById(r0)
            androidx.appcompat.widget.AppCompatImageView r0 = (androidx.appcompat.widget.AppCompatImageView) r0
            r3 = 10
            int r4 = net.one97.paytm.passbook.mapping.a.c((int) r3)
            int r5 = net.one97.paytm.passbook.mapping.a.c((int) r3)
            int r6 = net.one97.paytm.passbook.mapping.a.c((int) r3)
            int r3 = net.one97.paytm.passbook.mapping.a.c((int) r3)
            r0.setPadding(r4, r5, r6, r3)
            java.lang.String r0 = r9.getBankLogoUrl()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x029b
            com.squareup.picasso.w r0 = com.squareup.picasso.w.a()
            java.lang.String r3 = r9.getBankLogoUrl()
            com.squareup.picasso.aa r0 = r0.a((java.lang.String) r3)
            int r3 = net.one97.paytm.passbook.R.id.ivWalletIcon
            android.view.View r3 = r7.findViewById(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            net.one97.paytm.passbook.landing.e.aa$c r4 = new net.one97.paytm.passbook.landing.e.aa$c
            r4.<init>(r7)
            com.squareup.picasso.e r4 = (com.squareup.picasso.e) r4
            r0.a((android.widget.ImageView) r3, (com.squareup.picasso.e) r4)
        L_0x029b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = r9.getBankName()
            r0.append(r3)
            java.lang.String r3 = " XX "
            r0.append(r3)
            java.lang.String r3 = r9.getAccount()
            java.lang.String r4 = "bankAccount.account"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            java.lang.String r3 = kotlin.m.p.h((java.lang.String) r3)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r7.setTitle((java.lang.String) r0)
            int r0 = net.one97.paytm.passbook.R.id.tvCheckBalance
            android.view.View r0 = r7.findViewById(r0)
            java.lang.String r3 = "upiCard.findViewById<App…iew>(R.id.tvCheckBalance)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            androidx.appcompat.widget.AppCompatTextView r0 = (androidx.appcompat.widget.AppCompatTextView) r0
            r6 = 0
            r0.setVisibility(r6)
            int r0 = net.one97.paytm.passbook.R.id.tvAmount
            android.view.View r0 = r7.findViewById(r0)
            java.lang.String r3 = "upiCard.findViewById<App…tTextView>(R.id.tvAmount)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            androidx.appcompat.widget.AppCompatTextView r0 = (androidx.appcompat.widget.AppCompatTextView) r0
            r0.setVisibility(r1)
            int r0 = net.one97.paytm.passbook.R.id.tvReactivate
            android.view.View r0 = r7.findViewById(r0)
            java.lang.String r3 = "upiCard.findViewById<App…tView>(R.id.tvReactivate)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            androidx.appcompat.widget.AppCompatTextView r0 = (androidx.appcompat.widget.AppCompatTextView) r0
            r0.setVisibility(r1)
            net.one97.paytm.passbook.landing.e.aa$d r0 = net.one97.paytm.passbook.landing.e.aa.d.f57633a
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r7.setOnClickListener(r0)
            r0 = r7
            android.view.View r0 = (android.view.View) r0
            r11.addView(r0, r2)
        L_0x0301:
            int r0 = r8.element
            int r0 = r0 + r14
            r8.element = r0
            r7.setBankAccount(r9)
            int r0 = net.one97.paytm.passbook.R.id.tvCheckBalance
            android.view.View r0 = r7.findViewById(r0)
            r5 = r0
            androidx.appcompat.widget.AppCompatTextView r5 = (androidx.appcompat.widget.AppCompatTextView) r5
            net.one97.paytm.passbook.landing.e.aa$a r18 = new net.one97.paytm.passbook.landing.e.aa$a
            r0 = r18
            r1 = r7
            r2 = r9
            r3 = r24
            r4 = r15
            r14 = r5
            r5 = r26
            r21 = 0
            r6 = r25
            r10 = r7
            r7 = r8
            r22 = r8
            r8 = r17
            r21 = r9
            r23 = 0
            r9 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r0 = r18
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r14.setOnClickListener(r0)
            int r0 = net.one97.paytm.passbook.R.id.tvReactivate
            android.view.View r0 = r10.findViewById(r0)
            r9 = r0
            androidx.appcompat.widget.AppCompatTextView r9 = (androidx.appcompat.widget.AppCompatTextView) r9
            net.one97.paytm.passbook.landing.e.aa$b r10 = new net.one97.paytm.passbook.landing.e.aa$b
            r0 = r10
            r1 = r21
            r2 = r24
            r3 = r15
            r4 = r26
            r5 = r25
            r6 = r22
            r7 = r17
            r8 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            android.view.View$OnClickListener r10 = (android.view.View.OnClickListener) r10
            r9.setOnClickListener(r10)
            goto L_0x0360
        L_0x035c:
            r22 = r8
            r23 = 0
        L_0x0360:
            r14 = 1
            r10 = r24
            r0 = r20
            r8 = r22
            goto L_0x01dc
        L_0x0369:
            r25.b(r26)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.landing.e.aa.a(net.one97.paytm.passbook.landing.f.a, android.widget.LinearLayout, net.one97.paytm.passbook.landing.c.a):void");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PassbookBalanceCardView f57615a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BankAccountDetails.BankAccount f57616b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ aa f57617c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ x.e f57618d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ LinearLayout f57619e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.passbook.landing.f.a f57620f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ x.c f57621g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ List f57622h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.passbook.landing.c.a f57623i;

        a(PassbookBalanceCardView passbookBalanceCardView, BankAccountDetails.BankAccount bankAccount, aa aaVar, x.e eVar, LinearLayout linearLayout, net.one97.paytm.passbook.landing.f.a aVar, x.c cVar, List list, net.one97.paytm.passbook.landing.c.a aVar2) {
            this.f57615a = passbookBalanceCardView;
            this.f57616b = bankAccount;
            this.f57617c = aaVar;
            this.f57618d = eVar;
            this.f57619e = linearLayout;
            this.f57620f = aVar;
            this.f57621g = cVar;
            this.f57622h = list;
            this.f57623i = aVar2;
        }

        public final void onClick(View view) {
            List list = this.f57622h;
            BankAccountDetails.BankAccount bankAccount = this.f57616b;
            net.one97.paytm.passbook.landing.c.a aVar = this.f57623i;
            PassbookBalanceCardView passbookBalanceCardView = this.f57615a;
            Collection collection = list;
            int i2 = 0;
            if (!(collection == null || collection.isEmpty())) {
                UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
                for (Object next : list) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        kotlin.a.k.a();
                    }
                    UpiProfileDefaultBank upiProfileDefaultBank2 = (UpiProfileDefaultBank) next;
                    if (upiProfileDefaultBank2.isPrimary()) {
                        upiProfileDefaultBank.setVirtualAddress(upiProfileDefaultBank2.getVirtualAddress());
                    }
                    i2 = i3;
                }
                upiProfileDefaultBank.setDebitBank(bankAccount);
                net.one97.paytm.passbook.landing.repositories.k kVar = net.one97.paytm.passbook.landing.repositories.k.f57801b;
                net.one97.paytm.passbook.landing.repositories.k.a(upiProfileDefaultBank);
                net.one97.paytm.passbook.landing.f.a aVar2 = aVar.f57594b;
                if (aVar2 != null) {
                    aVar2.a(passbookBalanceCardView);
                }
            }
            q.a(passbookBalanceCardView.getContext(), "uth_passbook", "Check_bal_item_clicked", "UPI", (String) null, "/uth_passbook_myaccounts", "PASSBOOK");
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BankAccountDetails.BankAccount f57624a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ aa f57625b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ x.e f57626c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ LinearLayout f57627d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.passbook.landing.f.a f57628e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ x.c f57629f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ List f57630g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.passbook.landing.c.a f57631h;

        b(BankAccountDetails.BankAccount bankAccount, aa aaVar, x.e eVar, LinearLayout linearLayout, net.one97.paytm.passbook.landing.f.a aVar, x.c cVar, List list, net.one97.paytm.passbook.landing.c.a aVar2) {
            this.f57624a = bankAccount;
            this.f57625b = aaVar;
            this.f57626c = eVar;
            this.f57627d = linearLayout;
            this.f57628e = aVar;
            this.f57629f = cVar;
            this.f57630g = list;
            this.f57631h = aVar2;
        }

        public final void onClick(View view) {
            net.one97.paytm.passbook.landing.f.a aVar = this.f57631h.f57594b;
            if (aVar != null) {
                aVar.A();
            }
        }
    }

    public static final class c implements e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PassbookBalanceCardView f57632a;

        public final void onSuccess() {
        }

        c(PassbookBalanceCardView passbookBalanceCardView) {
            this.f57632a = passbookBalanceCardView;
        }

        public final void onError(Exception exc) {
            this.f57632a.setIcon(R.drawable.pass_upi_icon);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final d f57633a = new d();

        d() {
        }

        public final void onClick(View view) {
            k.a((Object) view, "it");
            Context context = view.getContext();
            net.one97.paytm.passbook.mapping.f b2 = net.one97.paytm.passbook.d.b();
            k.a((Object) b2, "PassbookHelper.getImplListener()");
            Intent intent = new Intent(context, b2.c());
            intent.putExtra(UpiConstants.EXTRA_KEY_IS_FROM_PASSBOOK, true);
            intent.putExtra(UpiConstants.KEY_UPI_ITEM_TYPE, 0);
            view.getContext().startActivity(intent);
            q.a(view.getContext(), "uth_passbook", "UPI_clicked", "UPI_passbook", (String) null, "/uth_passbook_myaccounts", "PASSBOOK");
        }
    }
}
