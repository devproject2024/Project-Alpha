package net.one97.paytm.passbook.landing.e;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.appsflyer.internal.referrer.Payload;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.passbook.beans.postpaid.CJRPPApplicationStatusEnum;
import net.one97.paytm.passbook.beans.postpaid.CJRPPUserProfileKycTnc;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.a.f;
import net.one97.paytm.passbook.utility.q;

public final class s extends a {

    /* renamed from: a  reason: collision with root package name */
    Context f57687a;

    /* renamed from: b  reason: collision with root package name */
    CJRPPApplicationStatusEnum f57688b;

    /* renamed from: c  reason: collision with root package name */
    private f<CJRPPUserProfileKycTnc> f57689c;

    public s(f<CJRPPUserProfileKycTnc> fVar) {
        k.c(fVar, Payload.RESPONSE);
        this.f57689c = fVar;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(18:22|(1:24)|25|(3:27|(2:29|171)(1:172)|30)|170|31|(1:33)(1:34)|(11:36|(4:40|(2:42|(1:44)(2:45|(2:47|(3:49|(1:51)|52))(4:53|(4:55|(1:57)|58|(4:60|(1:62)|63|65))|64|65)))|66|(3:68|(1:70)|71))|78|79|(1:81)|82|83|84|85|(2:87|168)(1:169)|88)(11:72|(2:74|(1:76))|78|79|(0)|82|83|84|85|(0)(0)|88)|77|78|79|(0)|82|83|84|85|(0)(0)|88) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:84:0x0146 */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0221 A[Catch:{ Exception -> 0x02dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x014f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x013e A[Catch:{ Exception -> 0x0146 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x014c A[Catch:{ Exception -> 0x02dc }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.passbook.landing.f.a r18, android.widget.LinearLayout r19) {
        /*
            r17 = this;
            r1 = r17
            r0 = r19
            java.lang.String r2 = "balanceSummaryUIHandler"
            r3 = r18
            kotlin.g.b.k.c(r3, r2)
            java.lang.String r2 = "itemLayout"
            kotlin.g.b.k.c(r0, r2)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r2 = r18.i()
            android.content.Context r2 = r2.getContext()
            java.lang.String r4 = "balanceSummaryUIHandler.mPostPaidCard.context"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            r1.f57687a = r2
            net.one97.paytm.passbook.main.widget.InitCards r2 = r18.s()
            android.view.View r2 = (android.view.View) r2
            r0.removeView(r2)
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r2 = r18.i()
            if (r2 == 0) goto L_0x0031
            r2.a()
        L_0x0031:
            net.one97.paytm.passbook.mapping.a.f<net.one97.paytm.passbook.beans.postpaid.CJRPPUserProfileKycTnc> r2 = r1.f57689c
            net.one97.paytm.passbook.mapping.a.j r2 = r2.f57886a
            int[] r4 = net.one97.paytm.passbook.landing.e.t.f57692b
            int r2 = r2.ordinal()
            r2 = r4[r2]
            r4 = 1
            if (r2 == r4) goto L_0x004d
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r2 = r18.i()
            android.view.View r2 = (android.view.View) r2
            r0.removeView(r2)
            r18.b(r19)
            return
        L_0x004d:
            net.one97.paytm.passbook.mapping.a.f<net.one97.paytm.passbook.beans.postpaid.CJRPPUserProfileKycTnc> r0 = r1.f57689c     // Catch:{ Exception -> 0x02dc }
            T r0 = r0.f57887b     // Catch:{ Exception -> 0x02dc }
            if (r0 == 0) goto L_0x02d4
            net.one97.paytm.passbook.beans.postpaid.CJRPPUserProfileKycTnc r0 = (net.one97.paytm.passbook.beans.postpaid.CJRPPUserProfileKycTnc) r0     // Catch:{ Exception -> 0x02dc }
            r5 = 0
            net.one97.paytm.passbook.beans.postpaid.CJRPPApplicationStatusEnum r2 = net.one97.paytm.passbook.beans.postpaid.CJRPPApplicationStatusEnum.NONE     // Catch:{ Exception -> 0x02dc }
            net.one97.paytm.passbook.beans.postpaid.CJRPPAccount[] r7 = r0.getAccounts()     // Catch:{ Exception -> 0x02dc }
            if (r7 == 0) goto L_0x02c5
            net.one97.paytm.passbook.beans.postpaid.CJRPPAccount[] r7 = r0.getAccounts()     // Catch:{ Exception -> 0x02dc }
            if (r7 != 0) goto L_0x0068
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x02dc }
        L_0x0068:
            int r7 = r7.length     // Catch:{ Exception -> 0x02dc }
            if (r7 <= r4) goto L_0x0154
            net.one97.paytm.passbook.beans.postpaid.CJRPPAccount[] r7 = r0.getAccounts()     // Catch:{ Exception -> 0x02dc }
            if (r7 != 0) goto L_0x0074
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x02dc }
        L_0x0074:
            int r10 = r7.length     // Catch:{ Exception -> 0x02dc }
            r11 = r2
            r12 = r5
            r2 = 0
            r5 = 0
            r6 = 0
        L_0x007a:
            if (r2 >= r10) goto L_0x0189
            r14 = r7[r2]     // Catch:{ Exception -> 0x02dc }
            net.one97.paytm.passbook.beans.postpaid.CJRPPAccount[] r15 = r0.getAccounts()     // Catch:{ Exception -> 0x02dc }
            if (r15 != 0) goto L_0x0087
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x02dc }
        L_0x0087:
            int r8 = r15.length     // Catch:{ Exception -> 0x02dc }
            r4 = 0
            r9 = 0
        L_0x008a:
            if (r9 >= r8) goto L_0x0099
            r16 = r15[r9]     // Catch:{ Exception -> 0x02dc }
            boolean r16 = r16.isUserEligible()     // Catch:{ Exception -> 0x02dc }
            if (r16 == 0) goto L_0x0096
            int r4 = r4 + 1
        L_0x0096:
            int r9 = r9 + 1
            goto L_0x008a
        L_0x0099:
            r8 = 1
            if (r4 <= r8) goto L_0x009e
            r4 = 1
            goto L_0x009f
        L_0x009e:
            r4 = 0
        L_0x009f:
            if (r4 == 0) goto L_0x0125
            boolean r4 = r14.isUserEligible()     // Catch:{ Exception -> 0x02dc }
            if (r4 == 0) goto L_0x0138
            java.lang.String r4 = r14.getApplicationStatus()     // Catch:{ Exception -> 0x02dc }
            if (r4 == 0) goto L_0x0138
            r14.getApplicationStatus()     // Catch:{ Exception -> 0x02dc }
            net.one97.paytm.passbook.beans.postpaid.CJRPPApplicationStatusEnum r4 = net.one97.paytm.passbook.beans.postpaid.CJRPPApplicationStatusEnum.APPLICATION_REJECTED     // Catch:{ Exception -> 0x02dc }
            java.lang.String r4 = r14.getApplicationStatus()     // Catch:{ Exception -> 0x02dc }
            net.one97.paytm.passbook.beans.postpaid.CJRPPApplicationStatusEnum r8 = net.one97.paytm.passbook.beans.postpaid.CJRPPApplicationStatusEnum.APPLICATION_CONFIRMED     // Catch:{ Exception -> 0x02dc }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x02dc }
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r8)     // Catch:{ Exception -> 0x02dc }
            if (r4 != 0) goto L_0x0111
            java.lang.String r4 = r14.getApplicationStatus()     // Catch:{ Exception -> 0x02dc }
            net.one97.paytm.passbook.beans.postpaid.CJRPPApplicationStatusEnum r8 = net.one97.paytm.passbook.beans.postpaid.CJRPPApplicationStatusEnum.APPLICATION_ACCEPTED     // Catch:{ Exception -> 0x02dc }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x02dc }
            if (r4 != r8) goto L_0x00cf
            goto L_0x0111
        L_0x00cf:
            net.one97.paytm.passbook.beans.postpaid.CJRPPApplicationStatusEnum r4 = net.one97.paytm.passbook.beans.postpaid.CJRPPApplicationStatusEnum.APPLICATION_REJECTED     // Catch:{ Exception -> 0x02dc }
            if (r11 != r4) goto L_0x00e7
            java.lang.Double r4 = r14.getEligibleCreditLimit()     // Catch:{ Exception -> 0x02dc }
            if (r4 == 0) goto L_0x0136
            java.lang.Double r4 = r14.getEligibleCreditLimit()     // Catch:{ Exception -> 0x02dc }
            if (r4 != 0) goto L_0x00e2
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x02dc }
        L_0x00e2:
            double r12 = r4.doubleValue()     // Catch:{ Exception -> 0x02dc }
            goto L_0x0136
        L_0x00e7:
            java.lang.Double r4 = r14.getEligibleCreditLimit()     // Catch:{ Exception -> 0x02dc }
            if (r4 == 0) goto L_0x010e
            java.lang.Double r4 = r14.getEligibleCreditLimit()     // Catch:{ Exception -> 0x02dc }
            if (r4 != 0) goto L_0x00f6
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x02dc }
        L_0x00f6:
            double r8 = r4.doubleValue()     // Catch:{ Exception -> 0x02dc }
            int r4 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r4 <= 0) goto L_0x010e
            java.lang.Double r4 = r14.getEligibleCreditLimit()     // Catch:{ Exception -> 0x02dc }
            if (r4 != 0) goto L_0x0107
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x02dc }
        L_0x0107:
            double r12 = r4.doubleValue()     // Catch:{ Exception -> 0x02dc }
            r6 = r14
            r4 = 1
            goto L_0x010f
        L_0x010e:
            r4 = r5
        L_0x010f:
            r5 = r4
            goto L_0x0138
        L_0x0111:
            java.lang.Double r4 = r14.getEligibleCreditLimit()     // Catch:{ Exception -> 0x02dc }
            if (r4 == 0) goto L_0x0136
            java.lang.Double r4 = r14.getEligibleCreditLimit()     // Catch:{ Exception -> 0x02dc }
            if (r4 != 0) goto L_0x0120
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x02dc }
        L_0x0120:
            double r12 = r4.doubleValue()     // Catch:{ Exception -> 0x02dc }
            goto L_0x0136
        L_0x0125:
            boolean r4 = r14.isUserEligible()     // Catch:{ Exception -> 0x02dc }
            if (r4 == 0) goto L_0x0138
            java.lang.String r4 = r14.getApplicationStatus()     // Catch:{ Exception -> 0x02dc }
            if (r4 == 0) goto L_0x0136
            r14.getApplicationStatus()     // Catch:{ Exception -> 0x02dc }
            net.one97.paytm.passbook.beans.postpaid.CJRPPApplicationStatusEnum r4 = net.one97.paytm.passbook.beans.postpaid.CJRPPApplicationStatusEnum.APPLICATION_REJECTED     // Catch:{ Exception -> 0x02dc }
        L_0x0136:
            r6 = r14
            r5 = 1
        L_0x0138:
            java.lang.String r4 = r14.getApplicationStatus()     // Catch:{ Exception -> 0x0146 }
            if (r4 != 0) goto L_0x0141
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0146 }
        L_0x0141:
            net.one97.paytm.passbook.beans.postpaid.CJRPPApplicationStatusEnum r4 = net.one97.paytm.passbook.beans.postpaid.CJRPPApplicationStatusEnum.valueOf(r4)     // Catch:{ Exception -> 0x0146 }
            r11 = r4
        L_0x0146:
            net.one97.paytm.passbook.beans.postpaid.CJRPPAccount[] r4 = r0.getAccounts()     // Catch:{ Exception -> 0x02dc }
            if (r4 != 0) goto L_0x014f
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x02dc }
        L_0x014f:
            int r2 = r2 + 1
            r4 = 1
            goto L_0x007a
        L_0x0154:
            net.one97.paytm.passbook.beans.postpaid.CJRPPAccount[] r2 = r0.getAccounts()     // Catch:{ Exception -> 0x02dc }
            if (r2 != 0) goto L_0x015d
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x02dc }
        L_0x015d:
            int r2 = r2.length     // Catch:{ Exception -> 0x02dc }
            if (r2 != 0) goto L_0x0162
            r2 = 1
            goto L_0x0163
        L_0x0162:
            r2 = 0
        L_0x0163:
            r4 = 1
            r2 = r2 ^ r4
            if (r2 == 0) goto L_0x0187
            net.one97.paytm.passbook.beans.postpaid.CJRPPAccount[] r2 = r0.getAccounts()     // Catch:{ Exception -> 0x02dc }
            if (r2 != 0) goto L_0x0170
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x02dc }
        L_0x0170:
            r4 = 0
            r8 = r2[r4]     // Catch:{ Exception -> 0x02dc }
            boolean r2 = r8.isUserEligible()     // Catch:{ Exception -> 0x02dc }
            if (r2 == 0) goto L_0x0187
            java.lang.String r2 = r8.getApplicationStatus()     // Catch:{ Exception -> 0x02dc }
            if (r2 == 0) goto L_0x0184
            r8.getApplicationStatus()     // Catch:{ Exception -> 0x02dc }
            net.one97.paytm.passbook.beans.postpaid.CJRPPApplicationStatusEnum r2 = net.one97.paytm.passbook.beans.postpaid.CJRPPApplicationStatusEnum.APPLICATION_REJECTED     // Catch:{ Exception -> 0x02dc }
        L_0x0184:
            r6 = r8
            r5 = 1
            goto L_0x0189
        L_0x0187:
            r5 = 0
            r6 = 0
        L_0x0189:
            if (r5 == 0) goto L_0x02c5
            if (r6 == 0) goto L_0x02c5
            net.one97.paytm.passbook.beans.CJRSubWallet r2 = new net.one97.paytm.passbook.beans.CJRSubWallet     // Catch:{ Exception -> 0x02dc }
            r2.<init>()     // Catch:{ Exception -> 0x02dc }
            java.lang.Double r4 = r6.getAvailableCreditLimit()     // Catch:{ Exception -> 0x02dc }
            if (r4 == 0) goto L_0x01a1
            java.lang.Number r4 = (java.lang.Number) r4     // Catch:{ Exception -> 0x02dc }
            double r4 = r4.doubleValue()     // Catch:{ Exception -> 0x02dc }
            r2.setBalance(r4)     // Catch:{ Exception -> 0x02dc }
        L_0x01a1:
            r2.setTag(r6)     // Catch:{ Exception -> 0x02dc }
            net.one97.paytm.passbook.utility.n r4 = net.one97.paytm.passbook.utility.n.PAYTM_POSTPAID     // Catch:{ Exception -> 0x02dc }
            int r4 = r4.getValue()     // Catch:{ Exception -> 0x02dc }
            r2.setSubWalletType((int) r4)     // Catch:{ Exception -> 0x02dc }
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r4 = r18.i()     // Catch:{ Exception -> 0x02dc }
            java.lang.Object r2 = r2.getTag()     // Catch:{ Exception -> 0x02dc }
            if (r2 == 0) goto L_0x02bd
            net.one97.paytm.passbook.beans.postpaid.CJRPPAccount r2 = (net.one97.paytm.passbook.beans.postpaid.CJRPPAccount) r2     // Catch:{ Exception -> 0x02dc }
            java.lang.String r5 = r2.getApplicationStatus()     // Catch:{ Exception -> 0x02dc }
            if (r5 == 0) goto L_0x01e2
            java.lang.String r5 = r2.getApplicationStatus()     // Catch:{ Exception -> 0x02dc }
            if (r5 != 0) goto L_0x01c8
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x02dc }
        L_0x01c8:
            if (r5 == 0) goto L_0x01da
            java.lang.String r5 = r5.toUpperCase()     // Catch:{ Exception -> 0x02dc }
            java.lang.String r6 = "(this as java.lang.String).toUpperCase()"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x02dc }
            net.one97.paytm.passbook.beans.postpaid.CJRPPApplicationStatusEnum r5 = net.one97.paytm.passbook.beans.postpaid.CJRPPApplicationStatusEnum.valueOf(r5)     // Catch:{ Exception -> 0x02dc }
            r1.f57688b = r5     // Catch:{ Exception -> 0x02dc }
            goto L_0x01e2
        L_0x01da:
            kotlin.u r0 = new kotlin.u     // Catch:{ Exception -> 0x02dc }
            java.lang.String r2 = "null cannot be cast to non-null type java.lang.String"
            r0.<init>(r2)     // Catch:{ Exception -> 0x02dc }
            throw r0     // Catch:{ Exception -> 0x02dc }
        L_0x01e2:
            r2.getLender()     // Catch:{ Exception -> 0x02dc }
            net.one97.paytm.passbook.beans.postpaid.CJRPPApplicationStatusEnum r2 = r1.f57688b     // Catch:{ Exception -> 0x02dc }
            if (r2 == 0) goto L_0x021e
            net.one97.paytm.passbook.beans.postpaid.CJRPPApplicationStatusEnum r2 = r1.f57688b     // Catch:{ Exception -> 0x02dc }
            if (r2 != 0) goto L_0x01ee
            goto L_0x021e
        L_0x01ee:
            int[] r5 = net.one97.paytm.passbook.landing.e.t.f57693c     // Catch:{ Exception -> 0x02dc }
            int r2 = r2.ordinal()     // Catch:{ Exception -> 0x02dc }
            r2 = r5[r2]     // Catch:{ Exception -> 0x02dc }
            r8 = 1
            if (r2 == r8) goto L_0x021f
            r5 = 2
            if (r2 == r5) goto L_0x021f
            r5 = 3
            if (r2 == r5) goto L_0x0200
            goto L_0x021e
        L_0x0200:
            net.one97.paytm.passbook.utility.m$a r2 = net.one97.paytm.passbook.utility.m.f59265a     // Catch:{ Exception -> 0x02dc }
            net.one97.paytm.passbook.mapping.f r2 = net.one97.paytm.passbook.d.b()     // Catch:{ Exception -> 0x02dc }
            java.lang.String r5 = "PassbookHelper.getImplListener()"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)     // Catch:{ Exception -> 0x02dc }
            android.content.Context r2 = r2.b()     // Catch:{ Exception -> 0x02dc }
            java.lang.String r5 = "PassbookHelper.getImplLi…ener().applicationContext"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)     // Catch:{ Exception -> 0x02dc }
            com.paytm.b.a.a r2 = net.one97.paytm.passbook.utility.m.a.a(r2)     // Catch:{ Exception -> 0x02dc }
            java.lang.String r5 = "paytmpostpaidapprejectiontoast"
            r6 = 0
            r2.b((java.lang.String) r5, (boolean) r6, (boolean) r6)     // Catch:{ Exception -> 0x02dc }
        L_0x021e:
            r8 = 0
        L_0x021f:
            if (r8 != 0) goto L_0x02c5
            r2 = 0
            r4.setVisibility(r2)     // Catch:{ Exception -> 0x02dc }
            int r2 = net.one97.paytm.passbook.R.id.tvTitle     // Catch:{ Exception -> 0x02dc }
            android.view.View r2 = r4.a((int) r2)     // Catch:{ Exception -> 0x02dc }
            androidx.appcompat.widget.AppCompatTextView r2 = (androidx.appcompat.widget.AppCompatTextView) r2     // Catch:{ Exception -> 0x02dc }
            java.lang.String r5 = "postPaidCard.tvTitle"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)     // Catch:{ Exception -> 0x02dc }
            android.content.Context r5 = r1.f57687a     // Catch:{ Exception -> 0x02dc }
            java.lang.String r6 = "mContext"
            if (r5 != 0) goto L_0x023b
            kotlin.g.b.k.a((java.lang.String) r6)     // Catch:{ Exception -> 0x02dc }
        L_0x023b:
            int r7 = net.one97.paytm.passbook.R.string.paytm_postpaid     // Catch:{ Exception -> 0x02dc }
            java.lang.String r5 = r5.getString(r7)     // Catch:{ Exception -> 0x02dc }
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x02dc }
            r2.setText(r5)     // Catch:{ Exception -> 0x02dc }
            net.one97.paytm.passbook.utility.n r2 = net.one97.paytm.passbook.utility.n.PAYTM_POSTPAID     // Catch:{ Exception -> 0x02dc }
            int r2 = r2.getValue()     // Catch:{ Exception -> 0x02dc }
            int r2 = net.one97.paytm.passbook.utility.q.a((int) r2)     // Catch:{ Exception -> 0x02dc }
            r4.setIcon(r2)     // Catch:{ Exception -> 0x02dc }
            int r2 = net.one97.paytm.passbook.R.id.tvAmount     // Catch:{ Exception -> 0x02dc }
            android.view.View r2 = r4.a((int) r2)     // Catch:{ Exception -> 0x02dc }
            androidx.appcompat.widget.AppCompatTextView r2 = (androidx.appcompat.widget.AppCompatTextView) r2     // Catch:{ Exception -> 0x02dc }
            java.lang.String r5 = "postPaidCard.tvAmount"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)     // Catch:{ Exception -> 0x02dc }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02dc }
            r5.<init>()     // Catch:{ Exception -> 0x02dc }
            android.content.Context r7 = r1.f57687a     // Catch:{ Exception -> 0x02dc }
            if (r7 != 0) goto L_0x026c
            kotlin.g.b.k.a((java.lang.String) r6)     // Catch:{ Exception -> 0x02dc }
        L_0x026c:
            int r6 = net.one97.paytm.passbook.R.string.pass_rs_symbol     // Catch:{ Exception -> 0x02dc }
            java.lang.String r6 = r7.getString(r6)     // Catch:{ Exception -> 0x02dc }
            r5.append(r6)     // Catch:{ Exception -> 0x02dc }
            if (r0 == 0) goto L_0x0291
            net.one97.paytm.passbook.beans.postpaid.CJRPPAccount[] r0 = r0.getAccounts()     // Catch:{ Exception -> 0x02dc }
            if (r0 == 0) goto L_0x0291
            r6 = 0
            r0 = r0[r6]     // Catch:{ Exception -> 0x02dc }
            if (r0 == 0) goto L_0x0291
            java.lang.Double r0 = r0.getAvailableCreditLimit()     // Catch:{ Exception -> 0x02dc }
            if (r0 == 0) goto L_0x0291
            double r6 = r0.doubleValue()     // Catch:{ Exception -> 0x02dc }
            java.lang.String r8 = net.one97.paytm.passbook.utility.f.b((double) r6)     // Catch:{ Exception -> 0x02dc }
            goto L_0x0292
        L_0x0291:
            r8 = 0
        L_0x0292:
            r5.append(r8)     // Catch:{ Exception -> 0x02dc }
            java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x02dc }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x02dc }
            r2.setText(r0)     // Catch:{ Exception -> 0x02dc }
            int r0 = net.one97.paytm.passbook.R.id.tvAmountDesc     // Catch:{ Exception -> 0x02dc }
            android.view.View r0 = r4.findViewById(r0)     // Catch:{ Exception -> 0x02dc }
            java.lang.String r2 = "postPaidCard.findViewByI…tView>(R.id.tvAmountDesc)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x02dc }
            androidx.appcompat.widget.AppCompatTextView r0 = (androidx.appcompat.widget.AppCompatTextView) r0     // Catch:{ Exception -> 0x02dc }
            r2 = 0
            r0.setVisibility(r2)     // Catch:{ Exception -> 0x02dc }
            int r0 = net.one97.paytm.passbook.R.id.tvAmountDesc     // Catch:{ Exception -> 0x02dc }
            android.view.View r0 = r4.findViewById(r0)     // Catch:{ Exception -> 0x02dc }
            androidx.appcompat.widget.AppCompatTextView r0 = (androidx.appcompat.widget.AppCompatTextView) r0     // Catch:{ Exception -> 0x02dc }
            int r2 = net.one97.paytm.passbook.R.string.pass_available_limit     // Catch:{ Exception -> 0x02dc }
            r0.setText(r2)     // Catch:{ Exception -> 0x02dc }
            goto L_0x02c5
        L_0x02bd:
            kotlin.u r0 = new kotlin.u     // Catch:{ Exception -> 0x02dc }
            java.lang.String r2 = "null cannot be cast to non-null type net.one97.paytm.passbook.beans.postpaid.CJRPPAccount"
            r0.<init>(r2)     // Catch:{ Exception -> 0x02dc }
            throw r0     // Catch:{ Exception -> 0x02dc }
        L_0x02c5:
            net.one97.paytm.passbook.main.widget.PassbookBalanceCardView r0 = r18.i()     // Catch:{ Exception -> 0x02dc }
            net.one97.paytm.passbook.landing.e.s$a r2 = new net.one97.paytm.passbook.landing.e.s$a     // Catch:{ Exception -> 0x02dc }
            r2.<init>(r1)     // Catch:{ Exception -> 0x02dc }
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2     // Catch:{ Exception -> 0x02dc }
            r0.setOnClickListener(r2)     // Catch:{ Exception -> 0x02dc }
            return
        L_0x02d4:
            kotlin.u r0 = new kotlin.u     // Catch:{ Exception -> 0x02dc }
            java.lang.String r2 = "null cannot be cast to non-null type net.one97.paytm.passbook.beans.postpaid.CJRPPUserProfileKycTnc"
            r0.<init>(r2)     // Catch:{ Exception -> 0x02dc }
            throw r0     // Catch:{ Exception -> 0x02dc }
        L_0x02dc:
            r0 = move-exception
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            net.one97.paytm.common.utility.l.a((java.lang.Throwable) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.landing.e.s.a(net.one97.paytm.passbook.landing.f.a, android.widget.LinearLayout):void");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f57690a;

        a(s sVar) {
            this.f57690a = sVar;
        }

        public final void onClick(View view) {
            k.a((Object) view, "it");
            q.a(view.getContext(), "uth_passbook", "postpaid_clicked", "existing", (String) null, "/uth_passbook_myaccounts", "PASSBOOK");
            CJRPPApplicationStatusEnum cJRPPApplicationStatusEnum = this.f57690a.f57688b;
            if (cJRPPApplicationStatusEnum != null) {
                switch (t.f57691a[cJRPPApplicationStatusEnum.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        s sVar = this.f57690a;
                        net.one97.paytm.passbook.mapping.f b2 = d.b();
                        Context context = sVar.f57687a;
                        if (context == null) {
                            k.a("mContext");
                        }
                        if (context != null) {
                            b2.b((Activity) context);
                            return;
                        }
                        throw new u("null cannot be cast to non-null type android.app.Activity");
                    case 5:
                    case 6:
                        d.b();
                        Context context2 = this.f57690a.f57687a;
                        if (context2 == null) {
                            k.a("mContext");
                        }
                        if (context2 == null) {
                            throw new u("null cannot be cast to non-null type android.app.Activity");
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
