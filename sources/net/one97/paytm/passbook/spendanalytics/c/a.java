package net.one97.paytm.passbook.spendanalytics.c;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.passbook.spendanalytics.activities.SpendAnalyticsTransactionDetailActivity;
import net.one97.paytm.passbook.spendanalytics.model.Response;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f58559a;

    public a(Context context) {
        k.c(context, "context");
        this.f58559a = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0050, code lost:
        r11 = r11.getDistribution();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.util.ArrayList<net.one97.paytm.passbook.spendanalytics.model.Response> r20, net.one97.paytm.passbook.spendanalytics.piechart.CircularGraphView r21, androidx.recyclerview.widget.RecyclerView r22, net.one97.paytm.passbook.spendanalytics.activities.SpendAnalyticsMainActivity r23, java.lang.String r24, com.paytm.utility.RoboTextView r25) {
        /*
            r19 = this;
            r1 = r20
            r0 = r21
            r6 = r22
            r2 = r23
            r4 = r24
            r3 = r25
            java.lang.String r5 = "moneySpentReceivedList"
            kotlin.g.b.k.c(r1, r5)
            java.lang.String r5 = "moneySpentReceivedChart"
            kotlin.g.b.k.c(r0, r5)
            java.lang.String r5 = "rvMoneySpentReceived"
            kotlin.g.b.k.c(r6, r5)
            java.lang.String r5 = "activity"
            kotlin.g.b.k.c(r2, r5)
            java.lang.String r5 = "chartType"
            kotlin.g.b.k.c(r4, r5)
            java.lang.String r5 = "tvAmount"
            kotlin.g.b.k.c(r3, r5)
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.lang.String r7 = "money_received_chart"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r7)
            int r8 = r20.size()
            r9 = 0
            r10 = 0
        L_0x003b:
            java.lang.String r11 = "money_spent_chart"
            r12 = 0
            if (r10 >= r8) goto L_0x00f5
            boolean r11 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r11)
            if (r11 == 0) goto L_0x0099
            net.one97.paytm.passbook.spendanalytics.a r11 = net.one97.paytm.passbook.spendanalytics.a.f58478a
            java.lang.Object r11 = r1.get(r10)
            net.one97.paytm.passbook.spendanalytics.model.Response r11 = (net.one97.paytm.passbook.spendanalytics.model.Response) r11
            if (r11 == 0) goto L_0x005b
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r11 = r11.getDistribution()
            if (r11 == 0) goto L_0x005b
            java.lang.String r11 = r11.getKey()
            goto L_0x005c
        L_0x005b:
            r11 = r12
        L_0x005c:
            java.lang.Integer r11 = net.one97.paytm.passbook.spendanalytics.a.d(r11)
            java.lang.Object r13 = r1.get(r10)
            net.one97.paytm.passbook.spendanalytics.model.Response r13 = (net.one97.paytm.passbook.spendanalytics.model.Response) r13
            if (r13 == 0) goto L_0x007d
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r13 = r13.getDistribution()
            if (r13 == 0) goto L_0x007d
            java.lang.String r13 = r13.getSum()
            if (r13 == 0) goto L_0x007d
            float r13 = java.lang.Float.parseFloat(r13)
            java.lang.Float r13 = java.lang.Float.valueOf(r13)
            goto L_0x007e
        L_0x007d:
            r13 = r12
        L_0x007e:
            java.lang.Object r14 = r1.get(r10)
            net.one97.paytm.passbook.spendanalytics.model.Response r14 = (net.one97.paytm.passbook.spendanalytics.model.Response) r14
            if (r14 == 0) goto L_0x0090
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r14 = r14.getDistribution()
            if (r14 == 0) goto L_0x0090
            java.lang.String r12 = r14.getKey()
        L_0x0090:
            net.one97.paytm.passbook.spendanalytics.piechart.a r14 = new net.one97.paytm.passbook.spendanalytics.piechart.a
            r14.<init>(r11, r13, r12, r9)
            r5.add(r14)
            goto L_0x00f1
        L_0x0099:
            boolean r11 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r7)
            if (r11 == 0) goto L_0x00f1
            net.one97.paytm.passbook.spendanalytics.a r11 = net.one97.paytm.passbook.spendanalytics.a.f58478a
            java.lang.Object r11 = r1.get(r10)
            net.one97.paytm.passbook.spendanalytics.model.Response r11 = (net.one97.paytm.passbook.spendanalytics.model.Response) r11
            if (r11 == 0) goto L_0x00b4
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r11 = r11.getDistribution()
            if (r11 == 0) goto L_0x00b4
            java.lang.String r11 = r11.getKey()
            goto L_0x00b5
        L_0x00b4:
            r11 = r12
        L_0x00b5:
            java.lang.Integer r11 = net.one97.paytm.passbook.spendanalytics.a.g(r11)
            java.lang.Object r13 = r1.get(r10)
            net.one97.paytm.passbook.spendanalytics.model.Response r13 = (net.one97.paytm.passbook.spendanalytics.model.Response) r13
            if (r13 == 0) goto L_0x00d6
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r13 = r13.getDistribution()
            if (r13 == 0) goto L_0x00d6
            java.lang.String r13 = r13.getSum()
            if (r13 == 0) goto L_0x00d6
            float r13 = java.lang.Float.parseFloat(r13)
            java.lang.Float r13 = java.lang.Float.valueOf(r13)
            goto L_0x00d7
        L_0x00d6:
            r13 = r12
        L_0x00d7:
            java.lang.Object r14 = r1.get(r10)
            net.one97.paytm.passbook.spendanalytics.model.Response r14 = (net.one97.paytm.passbook.spendanalytics.model.Response) r14
            if (r14 == 0) goto L_0x00e9
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r14 = r14.getDistribution()
            if (r14 == 0) goto L_0x00e9
            java.lang.String r12 = r14.getKey()
        L_0x00e9:
            net.one97.paytm.passbook.spendanalytics.piechart.a r14 = new net.one97.paytm.passbook.spendanalytics.piechart.a
            r14.<init>(r11, r13, r12, r9)
            r5.add(r14)
        L_0x00f1:
            int r10 = r10 + 1
            goto L_0x003b
        L_0x00f5:
            int r8 = r5.size()
            if (r8 != 0) goto L_0x0218
            net.one97.paytm.passbook.spendanalytics.piechart.a r8 = new net.one97.paytm.passbook.spendanalytics.piechart.a
            java.lang.String r10 = "#dde5ed"
            int r10 = android.graphics.Color.parseColor(r10)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r13 = 1065353216(0x3f800000, float:1.0)
            java.lang.Float r13 = java.lang.Float.valueOf(r13)
            r8.<init>(r10, r13, r12, r9)
            r5.add(r8)
            boolean r7 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r7)
            r8 = 2
            if (r7 == 0) goto L_0x016f
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r7 = new net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution
            r14 = 0
            r16 = 0
            java.lang.String r15 = "0"
            java.lang.String r17 = "0"
            java.lang.String r18 = "7"
            r13 = r7
            r13.<init>(r14, r15, r16, r17, r18)
            net.one97.paytm.passbook.spendanalytics.model.Response r9 = new net.one97.paytm.passbook.spendanalytics.model.Response
            r9.<init>(r7, r12, r8, r12)
            r1.add(r9)
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r7 = new net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution
            java.lang.String r15 = "0"
            java.lang.String r17 = "0"
            java.lang.String r18 = "5"
            r13 = r7
            r13.<init>(r14, r15, r16, r17, r18)
            net.one97.paytm.passbook.spendanalytics.model.Response r9 = new net.one97.paytm.passbook.spendanalytics.model.Response
            r9.<init>(r7, r12, r8, r12)
            r1.add(r9)
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r7 = new net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution
            java.lang.String r15 = "0"
            java.lang.String r17 = "0"
            java.lang.String r18 = "2"
            r13 = r7
            r13.<init>(r14, r15, r16, r17, r18)
            net.one97.paytm.passbook.spendanalytics.model.Response r9 = new net.one97.paytm.passbook.spendanalytics.model.Response
            r9.<init>(r7, r12, r8, r12)
            r1.add(r9)
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r7 = new net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution
            java.lang.String r15 = "0"
            java.lang.String r17 = "0"
            java.lang.String r18 = "45"
            r13 = r7
            r13.<init>(r14, r15, r16, r17, r18)
            net.one97.paytm.passbook.spendanalytics.model.Response r9 = new net.one97.paytm.passbook.spendanalytics.model.Response
            r9.<init>(r7, r12, r8, r12)
            r1.add(r9)
            goto L_0x0213
        L_0x016f:
            boolean r7 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r11)
            if (r7 == 0) goto L_0x0213
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r7 = new net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution
            r14 = 0
            r16 = 0
            java.lang.String r15 = "0"
            java.lang.String r17 = "0"
            java.lang.String r18 = "Travel"
            r13 = r7
            r13.<init>(r14, r15, r16, r17, r18)
            net.one97.paytm.passbook.spendanalytics.model.Response r9 = new net.one97.paytm.passbook.spendanalytics.model.Response
            r9.<init>(r7, r12, r8, r12)
            r1.add(r9)
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r7 = new net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution
            java.lang.String r15 = "0"
            java.lang.String r17 = "0"
            java.lang.String r18 = "Food & Beverage"
            r13 = r7
            r13.<init>(r14, r15, r16, r17, r18)
            net.one97.paytm.passbook.spendanalytics.model.Response r9 = new net.one97.paytm.passbook.spendanalytics.model.Response
            r9.<init>(r7, r12, r8, r12)
            r1.add(r9)
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r7 = new net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution
            java.lang.String r15 = "0"
            java.lang.String r17 = "0"
            java.lang.String r18 = "Shopping"
            r13 = r7
            r13.<init>(r14, r15, r16, r17, r18)
            net.one97.paytm.passbook.spendanalytics.model.Response r9 = new net.one97.paytm.passbook.spendanalytics.model.Response
            r9.<init>(r7, r12, r8, r12)
            r1.add(r9)
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r7 = new net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution
            java.lang.String r15 = "0"
            java.lang.String r17 = "0"
            java.lang.String r18 = "Entertainment"
            r13 = r7
            r13.<init>(r14, r15, r16, r17, r18)
            net.one97.paytm.passbook.spendanalytics.model.Response r9 = new net.one97.paytm.passbook.spendanalytics.model.Response
            r9.<init>(r7, r12, r8, r12)
            r1.add(r9)
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r7 = new net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution
            java.lang.String r15 = "0"
            java.lang.String r17 = "0"
            java.lang.String r18 = "Recharges & Bill Payment"
            r13 = r7
            r13.<init>(r14, r15, r16, r17, r18)
            net.one97.paytm.passbook.spendanalytics.model.Response r9 = new net.one97.paytm.passbook.spendanalytics.model.Response
            r9.<init>(r7, r12, r8, r12)
            r1.add(r9)
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r7 = new net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution
            java.lang.String r15 = "0"
            java.lang.String r17 = "0"
            java.lang.String r18 = "Others"
            r13 = r7
            r13.<init>(r14, r15, r16, r17, r18)
            net.one97.paytm.passbook.spendanalytics.model.Response r9 = new net.one97.paytm.passbook.spendanalytics.model.Response
            r9.<init>(r7, r12, r8, r12)
            r1.add(r9)
            r7 = r19
            android.content.Context r8 = r7.f58559a
            if (r8 == 0) goto L_0x020b
            net.one97.paytm.passbook.spendanalytics.activities.SpendAnalyticsMainActivity r8 = (net.one97.paytm.passbook.spendanalytics.activities.SpendAnalyticsMainActivity) r8
            int r9 = net.one97.paytm.passbook.R.id.tvSpendsByCategory
            android.view.View r8 = r8.a((int) r9)
            com.paytm.utility.RoboTextView r8 = (com.paytm.utility.RoboTextView) r8
            java.lang.String r9 = "(mContext as SpendAnalyt…ivity).tvSpendsByCategory"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            r9 = 8
            r8.setVisibility(r9)
            goto L_0x0215
        L_0x020b:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type net.one97.paytm.passbook.spendanalytics.activities.SpendAnalyticsMainActivity"
            r0.<init>(r1)
            throw r0
        L_0x0213:
            r7 = r19
        L_0x0215:
            r8 = 1
            r9 = 1
            goto L_0x021a
        L_0x0218:
            r7 = r19
        L_0x021a:
            r0.setData(r5)
            net.one97.paytm.passbook.spendanalytics.a.a r8 = new net.one97.paytm.passbook.spendanalytics.a.a
            java.util.ArrayList r3 = a((java.util.ArrayList<net.one97.paytm.passbook.spendanalytics.model.Response>) r1, (com.paytm.utility.RoboTextView) r3)
            r5 = r2
            net.one97.paytm.passbook.spendanalytics.a.a$a r5 = (net.one97.paytm.passbook.spendanalytics.a.a.C1129a) r5
            r0 = r8
            r1 = r20
            r2 = r3
            r3 = r5
            r4 = r24
            r5 = r9
            r0.<init>(r1, r2, r3, r4, r5)
            r0 = r8
            androidx.recyclerview.widget.RecyclerView$a r0 = (androidx.recyclerview.widget.RecyclerView.a) r0
            r6.setAdapter(r0)
            r8.notifyDataSetChanged()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.spendanalytics.c.a.a(java.util.ArrayList, net.one97.paytm.passbook.spendanalytics.piechart.CircularGraphView, androidx.recyclerview.widget.RecyclerView, net.one97.paytm.passbook.spendanalytics.activities.SpendAnalyticsMainActivity, java.lang.String, com.paytm.utility.RoboTextView):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008f, code lost:
        r10 = (r10 = r10.getDistribution()).getSum();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<java.lang.String> a(java.util.ArrayList<net.one97.paytm.passbook.spendanalytics.model.Response> r13, com.paytm.utility.RoboTextView r14) {
        /*
            java.lang.String r0 = "0"
            java.lang.String r1 = "moneySpentReceivedList"
            kotlin.g.b.k.c(r13, r1)
            java.lang.String r1 = "tvAmount"
            kotlin.g.b.k.c(r14, r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r2 = r13.size()
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
        L_0x001a:
            r7 = 0
            if (r5 >= r2) goto L_0x0046
            java.lang.Object r8 = r13.get(r5)
            net.one97.paytm.passbook.spendanalytics.model.Response r8 = (net.one97.paytm.passbook.spendanalytics.model.Response) r8
            if (r8 == 0) goto L_0x0039
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r8 = r8.getDistribution()
            if (r8 == 0) goto L_0x0039
            java.lang.String r8 = r8.getSum()
            if (r8 == 0) goto L_0x0039
            float r7 = java.lang.Float.parseFloat(r8)
            java.lang.Float r7 = java.lang.Float.valueOf(r7)
        L_0x0039:
            if (r7 != 0) goto L_0x003e
            kotlin.g.b.k.a()
        L_0x003e:
            float r7 = r7.floatValue()
            float r6 = r6 + r7
            int r5 = r5 + 1
            goto L_0x001a
        L_0x0046:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r5 = "₹"
            r2.<init>(r5)
            java.lang.String r5 = java.lang.String.valueOf(r6)
            java.lang.String r5 = net.one97.paytm.passbook.utility.c.c(r5)
            if (r5 == 0) goto L_0x0061
            java.lang.String r8 = ".00"
            java.lang.String r9 = ""
            java.lang.String r5 = kotlin.m.p.a(r5, r8, r9, r4)
            goto L_0x0062
        L_0x0061:
            r5 = r7
        L_0x0062:
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r14.setText(r2)
            java.text.DecimalFormat r14 = new java.text.DecimalFormat
            java.lang.String r2 = "###.##"
            r14.<init>(r2)
            r2 = 1120403456(0x42c80000, float:100.0)
            int r5 = r13.size()     // Catch:{ NumberFormatException -> 0x00ee }
            r8 = 1
            int r5 = r5 - r8
            r3 = 0
            r9 = 0
        L_0x007f:
            if (r4 >= r5) goto L_0x00f0
            java.lang.Object r10 = r13.get(r4)     // Catch:{ NumberFormatException -> 0x00e4 }
            net.one97.paytm.passbook.spendanalytics.model.Response r10 = (net.one97.paytm.passbook.spendanalytics.model.Response) r10     // Catch:{ NumberFormatException -> 0x00e4 }
            if (r10 == 0) goto L_0x009e
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r10 = r10.getDistribution()     // Catch:{ NumberFormatException -> 0x00e4 }
            if (r10 == 0) goto L_0x009e
            java.lang.String r10 = r10.getSum()     // Catch:{ NumberFormatException -> 0x00e4 }
            if (r10 == 0) goto L_0x009e
            float r10 = java.lang.Float.parseFloat(r10)     // Catch:{ NumberFormatException -> 0x00e4 }
            java.lang.Float r10 = java.lang.Float.valueOf(r10)     // Catch:{ NumberFormatException -> 0x00e4 }
            goto L_0x009f
        L_0x009e:
            r10 = r7
        L_0x009f:
            if (r10 != 0) goto L_0x00a4
            kotlin.g.b.k.a()     // Catch:{ NumberFormatException -> 0x00e4 }
        L_0x00a4:
            float r10 = r10.floatValue()     // Catch:{ NumberFormatException -> 0x00e4 }
            float r10 = r10 / r6
            float r10 = r10 * r2
            java.lang.String r11 = java.lang.String.valueOf(r10)     // Catch:{ NumberFormatException -> 0x00e4 }
            java.lang.String r12 = "NaN"
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12     // Catch:{ NumberFormatException -> 0x00e4 }
            if (r11 == 0) goto L_0x00e6
            boolean r11 = r11.contentEquals(r12)     // Catch:{ NumberFormatException -> 0x00e4 }
            if (r11 == 0) goto L_0x00c0
            r1.add(r0)     // Catch:{ NumberFormatException -> 0x00e4 }
            r3 = 1
            goto L_0x00e1
        L_0x00c0:
            java.lang.Float r11 = java.lang.Float.valueOf(r10)     // Catch:{ NumberFormatException -> 0x00e4 }
            java.lang.String r11 = r14.format(r11)     // Catch:{ NumberFormatException -> 0x00e4 }
            java.lang.String r12 = "df.format(percent)"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r12)     // Catch:{ NumberFormatException -> 0x00e4 }
            float r11 = java.lang.Float.parseFloat(r11)     // Catch:{ NumberFormatException -> 0x00e4 }
            float r9 = r9 + r11
            java.lang.Float r10 = java.lang.Float.valueOf(r10)     // Catch:{ NumberFormatException -> 0x00e4 }
            java.lang.String r10 = r14.format(r10)     // Catch:{ NumberFormatException -> 0x00e4 }
            java.lang.String r10 = r10.toString()     // Catch:{ NumberFormatException -> 0x00e4 }
            r1.add(r10)     // Catch:{ NumberFormatException -> 0x00e4 }
        L_0x00e1:
            int r4 = r4 + 1
            goto L_0x007f
        L_0x00e4:
            goto L_0x00f0
        L_0x00e6:
            kotlin.u r13 = new kotlin.u     // Catch:{ NumberFormatException -> 0x00e4 }
            java.lang.String r4 = "null cannot be cast to non-null type java.lang.String"
            r13.<init>(r4)     // Catch:{ NumberFormatException -> 0x00e4 }
            throw r13     // Catch:{ NumberFormatException -> 0x00e4 }
        L_0x00ee:
            r3 = 0
            r9 = 0
        L_0x00f0:
            if (r3 == 0) goto L_0x00f6
            r1.add(r0)
            goto L_0x0106
        L_0x00f6:
            float r2 = r2 - r9
            java.lang.Float r13 = java.lang.Float.valueOf(r2)
            java.lang.String r13 = r14.format(r13)
            java.lang.String r13 = r13.toString()
            r1.add(r13)
        L_0x0106:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.spendanalytics.c.a.a(java.util.ArrayList, com.paytm.utility.RoboTextView):java.util.ArrayList");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0077, code lost:
        r7 = (r7 = r6.getDistribution()).getSum();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.util.ArrayList<net.one97.paytm.passbook.spendanalytics.model.Response> r12, android.content.Context r13) {
        /*
            java.lang.String r0 = "moneySpentList"
            kotlin.g.b.k.c(r12, r0)
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r13, r0)
            r0 = r12
            java.util.Collection r0 = (java.util.Collection) r0
            int r0 = r0.size()
            r1 = 0
            r2 = -1
            r3 = 0
            r6 = r3
            r4 = 0
            r5 = -1
        L_0x0017:
            if (r4 >= r0) goto L_0x004a
            java.lang.Object r7 = r12.get(r4)
            net.one97.paytm.passbook.spendanalytics.model.Response r7 = (net.one97.paytm.passbook.spendanalytics.model.Response) r7
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r7 = r7.getDistribution()
            java.lang.String r7 = r7.getKey()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            java.lang.String r8 = "Others"
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            if (r7 == 0) goto L_0x0042
            boolean r7 = r7.contentEquals(r8)
            if (r7 == 0) goto L_0x003f
            java.lang.Object r5 = r12.get(r4)
            net.one97.paytm.passbook.spendanalytics.model.Response r5 = (net.one97.paytm.passbook.spendanalytics.model.Response) r5
            r6 = r5
            r5 = r4
        L_0x003f:
            int r4 = r4 + 1
            goto L_0x0017
        L_0x0042:
            kotlin.u r12 = new kotlin.u
            java.lang.String r13 = "null cannot be cast to non-null type java.lang.String"
            r12.<init>(r13)
            throw r12
        L_0x004a:
            if (r5 == r2) goto L_0x0054
            r12.remove(r5)
            if (r6 == 0) goto L_0x0054
            r12.add(r6)
        L_0x0054:
            int r0 = r12.size()
            r2 = 5
            if (r0 <= r2) goto L_0x00e1
            r0 = 0
            int r4 = r12.size()
            r0 = 5
            r5 = 0
        L_0x0062:
            if (r0 >= r4) goto L_0x00b6
            java.lang.Object r6 = r12.get(r0)
            java.lang.String r7 = "moneySpentList[i]"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            net.one97.paytm.passbook.spendanalytics.model.Response r6 = (net.one97.paytm.passbook.spendanalytics.model.Response) r6
            if (r6 == 0) goto L_0x0086
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r7 = r6.getDistribution()
            if (r7 == 0) goto L_0x0086
            java.lang.String r7 = r7.getSum()
            if (r7 == 0) goto L_0x0086
            float r7 = java.lang.Float.parseFloat(r7)
            java.lang.Float r7 = java.lang.Float.valueOf(r7)
            goto L_0x0087
        L_0x0086:
            r7 = r3
        L_0x0087:
            if (r7 != 0) goto L_0x008c
            kotlin.g.b.k.a()
        L_0x008c:
            float r7 = r7.floatValue()
            float r5 = r5 + r7
            if (r6 == 0) goto L_0x00a8
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r6 = r6.getDistribution()
            if (r6 == 0) goto L_0x00a8
            java.lang.String r6 = r6.getCnt()
            if (r6 == 0) goto L_0x00a8
            int r6 = java.lang.Integer.parseInt(r6)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            goto L_0x00a9
        L_0x00a8:
            r6 = r3
        L_0x00a9:
            if (r6 != 0) goto L_0x00ae
            kotlin.g.b.k.a()
        L_0x00ae:
            int r6 = r6.intValue()
            int r1 = r1 + r6
            int r0 = r0 + 1
            goto L_0x0062
        L_0x00b6:
            net.one97.paytm.passbook.spendanalytics.model.Response r0 = new net.one97.paytm.passbook.spendanalytics.model.Response
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r4 = new net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution
            r7 = 0
            java.lang.String r8 = java.lang.String.valueOf(r1)
            r9 = 0
            java.lang.String r10 = java.lang.String.valueOf(r5)
            int r1 = net.one97.paytm.passbook.R.string.pass_sa_other_categories
            java.lang.String r11 = r13.getString(r1)
            r6 = r4
            r6.<init>(r7, r8, r9, r10, r11)
            r13 = 2
            r0.<init>(r4, r3, r13, r3)
            r12.add(r2, r0)
            r13 = 6
            int r0 = r12.size()
            java.util.List r12 = r12.subList(r13, r0)
            r12.clear()
        L_0x00e1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.spendanalytics.c.a.a(java.util.ArrayList, android.content.Context):void");
    }

    public static void a(boolean z, ArrayList<View> arrayList, ShimmerFrameLayout shimmerFrameLayout) {
        k.c(arrayList, "viewList");
        if (shimmerFrameLayout != null) {
            shimmerFrameLayout.b();
        }
        if (z) {
            if (shimmerFrameLayout != null) {
                shimmerFrameLayout.setVisibility(0);
            }
            if (shimmerFrameLayout != null) {
                shimmerFrameLayout.a();
            }
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = arrayList.get(i2);
                k.a((Object) view, "viewList[i]");
                view.setVisibility(4);
            }
            return;
        }
        if (shimmerFrameLayout != null) {
            shimmerFrameLayout.setVisibility(4);
        }
        if (shimmerFrameLayout != null) {
            shimmerFrameLayout.b();
        }
        int size2 = arrayList.size();
        for (int i3 = 0; i3 < size2; i3++) {
            View view2 = arrayList.get(i3);
            k.a((Object) view2, "viewList[i]");
            view2.setVisibility(0);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00ce, code lost:
        r16 = r16.getDistribution();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(net.one97.paytm.passbook.spendanalytics.activities.SpendAnalyticsMainActivity r18, java.util.ArrayList<net.one97.paytm.passbook.spendanalytics.model.Response> r19, java.lang.String r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r20
            java.lang.String r4 = "spendAnalyticsMainActivity"
            kotlin.g.b.k.c(r1, r4)
            java.lang.String r4 = "favStoresList"
            kotlin.g.b.k.c(r2, r4)
            java.lang.String r4 = "selectedMonth"
            kotlin.g.b.k.c(r3, r4)
            int r4 = r19.size()
            java.lang.String r5 = "spendAnalyticsMainActivity.tvFavStores"
            java.lang.String r6 = "spendAnalyticsMainActivity.layoutFavStores"
            r7 = 0
            if (r4 != 0) goto L_0x003f
            int r4 = net.one97.paytm.passbook.R.id.tvFavStores
            android.view.View r4 = r1.a((int) r4)
            com.paytm.utility.RoboTextView r4 = (com.paytm.utility.RoboTextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            r5 = 8
            r4.setVisibility(r5)
            int r4 = net.one97.paytm.passbook.R.id.layoutFavStores
            android.view.View r4 = r1.a((int) r4)
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            r4.setVisibility(r5)
            goto L_0x0059
        L_0x003f:
            int r4 = net.one97.paytm.passbook.R.id.tvFavStores
            android.view.View r4 = r1.a((int) r4)
            com.paytm.utility.RoboTextView r4 = (com.paytm.utility.RoboTextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            r4.setVisibility(r7)
            int r4 = net.one97.paytm.passbook.R.id.layoutFavStores
            android.view.View r4 = r1.a((int) r4)
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
            r4.setVisibility(r7)
        L_0x0059:
            int r4 = net.one97.paytm.passbook.R.id.favStoreCv1
            android.view.View r4 = r1.a((int) r4)
            androidx.cardview.widget.CardView r4 = (androidx.cardview.widget.CardView) r4
            java.lang.String r5 = "spendAnalyticsMainActivity.favStoreCv1"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            r8 = 4
            r4.setVisibility(r8)
            int r4 = net.one97.paytm.passbook.R.id.favStoreCv2
            android.view.View r4 = r1.a((int) r4)
            androidx.cardview.widget.CardView r4 = (androidx.cardview.widget.CardView) r4
            java.lang.String r9 = "spendAnalyticsMainActivity.favStoreCv2"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r9)
            r4.setVisibility(r8)
            int r4 = net.one97.paytm.passbook.R.id.favStoreCv3
            android.view.View r4 = r1.a((int) r4)
            androidx.cardview.widget.CardView r4 = (androidx.cardview.widget.CardView) r4
            java.lang.String r10 = "spendAnalyticsMainActivity.favStoreCv3"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r10)
            r4.setVisibility(r8)
            r4 = r2
            java.util.Collection r4 = (java.util.Collection) r4
            int r4 = r4.size()
            r8 = 0
        L_0x0092:
            if (r8 >= r4) goto L_0x02cd
            int r11 = net.one97.paytm.passbook.R.id.layoutFavStores
            android.view.View r11 = r1.a((int) r11)
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r6)
            r11.setVisibility(r7)
            java.lang.String r11 = ""
            java.lang.String r12 = ".00"
            java.lang.String r13 = "CJRAppUtils.getFormatted…tion]?.distribution?.sum)"
            java.lang.String r14 = "₹"
            if (r8 == 0) goto L_0x0211
            r15 = 1
            if (r8 == r15) goto L_0x0163
            r15 = 2
            if (r8 == r15) goto L_0x00b4
        L_0x00b1:
            r13 = 0
            goto L_0x02c8
        L_0x00b4:
            int r15 = net.one97.paytm.passbook.R.id.favStoreCv3
            android.view.View r15 = r1.a((int) r15)
            androidx.cardview.widget.CardView r15 = (androidx.cardview.widget.CardView) r15
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r10)
            r15.setVisibility(r7)
            com.squareup.picasso.w r15 = com.squareup.picasso.w.a()
            java.lang.Object r16 = r2.get(r8)
            net.one97.paytm.passbook.spendanalytics.model.Response r16 = (net.one97.paytm.passbook.spendanalytics.model.Response) r16
            if (r16 == 0) goto L_0x00db
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r16 = r16.getDistribution()
            if (r16 == 0) goto L_0x00db
            java.lang.String r16 = r16.getLogo()
            r7 = r16
            goto L_0x00dc
        L_0x00db:
            r7 = 0
        L_0x00dc:
            com.squareup.picasso.aa r7 = r15.a((java.lang.String) r7)
            int r15 = net.one97.paytm.passbook.R.id.favStoreivStoreIcon3
            android.view.View r15 = r1.a((int) r15)
            net.one97.paytm.passbook.customview.CircularImageView r15 = (net.one97.paytm.passbook.customview.CircularImageView) r15
            r7.a((android.widget.ImageView) r15)
            int r7 = net.one97.paytm.passbook.R.id.favStoretvSpentAmount3
            android.view.View r7 = r1.a((int) r7)
            com.paytm.utility.RoboTextView r7 = (com.paytm.utility.RoboTextView) r7
            java.lang.String r15 = "spendAnalyticsMainActivity.favStoretvSpentAmount3"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r15)
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>(r14)
            java.lang.Object r14 = r2.get(r8)
            net.one97.paytm.passbook.spendanalytics.model.Response r14 = (net.one97.paytm.passbook.spendanalytics.model.Response) r14
            if (r14 == 0) goto L_0x0110
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r14 = r14.getDistribution()
            if (r14 == 0) goto L_0x0110
            java.lang.String r14 = r14.getSum()
            goto L_0x0111
        L_0x0110:
            r14 = 0
        L_0x0111:
            java.lang.String r14 = net.one97.paytm.passbook.utility.c.c(r14)
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r13)
            r13 = 0
            java.lang.String r11 = kotlin.m.p.a(r14, r12, r11, r13)
            r15.append(r11)
            java.lang.String r11 = r15.toString()
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r7.setText(r11)
            int r7 = net.one97.paytm.passbook.R.id.favStoretvStoreName3
            android.view.View r7 = r1.a((int) r7)
            com.paytm.utility.RoboTextView r7 = (com.paytm.utility.RoboTextView) r7
            java.lang.String r11 = "spendAnalyticsMainActivity.favStoretvStoreName3"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r11)
            java.lang.Object r11 = r2.get(r8)
            net.one97.paytm.passbook.spendanalytics.model.Response r11 = (net.one97.paytm.passbook.spendanalytics.model.Response) r11
            if (r11 == 0) goto L_0x0149
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r11 = r11.getDistribution()
            if (r11 == 0) goto L_0x0149
            java.lang.String r15 = r11.getMdn()
            goto L_0x014a
        L_0x0149:
            r15 = 0
        L_0x014a:
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            r7.setText(r15)
            int r7 = net.one97.paytm.passbook.R.id.favStoreCv3
            android.view.View r7 = r1.a((int) r7)
            androidx.cardview.widget.CardView r7 = (androidx.cardview.widget.CardView) r7
            net.one97.paytm.passbook.spendanalytics.c.a$c r11 = new net.one97.paytm.passbook.spendanalytics.c.a$c
            r11.<init>(r0, r2, r8, r3)
            android.view.View$OnClickListener r11 = (android.view.View.OnClickListener) r11
            r7.setOnClickListener(r11)
            goto L_0x00b1
        L_0x0163:
            int r7 = net.one97.paytm.passbook.R.id.favStoreCv2
            android.view.View r7 = r1.a((int) r7)
            androidx.cardview.widget.CardView r7 = (androidx.cardview.widget.CardView) r7
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r9)
            r15 = 0
            r7.setVisibility(r15)
            com.squareup.picasso.w r7 = com.squareup.picasso.w.a()
            java.lang.Object r15 = r2.get(r8)
            net.one97.paytm.passbook.spendanalytics.model.Response r15 = (net.one97.paytm.passbook.spendanalytics.model.Response) r15
            if (r15 == 0) goto L_0x0189
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r15 = r15.getDistribution()
            if (r15 == 0) goto L_0x0189
            java.lang.String r15 = r15.getLogo()
            goto L_0x018a
        L_0x0189:
            r15 = 0
        L_0x018a:
            com.squareup.picasso.aa r7 = r7.a((java.lang.String) r15)
            int r15 = net.one97.paytm.passbook.R.id.favStoreivStoreIcon2
            android.view.View r15 = r1.a((int) r15)
            net.one97.paytm.passbook.customview.CircularImageView r15 = (net.one97.paytm.passbook.customview.CircularImageView) r15
            r7.a((android.widget.ImageView) r15)
            int r7 = net.one97.paytm.passbook.R.id.favStoretvSpentAmount2
            android.view.View r7 = r1.a((int) r7)
            com.paytm.utility.RoboTextView r7 = (com.paytm.utility.RoboTextView) r7
            java.lang.String r15 = "spendAnalyticsMainActivity.favStoretvSpentAmount2"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r15)
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>(r14)
            java.lang.Object r14 = r2.get(r8)
            net.one97.paytm.passbook.spendanalytics.model.Response r14 = (net.one97.paytm.passbook.spendanalytics.model.Response) r14
            if (r14 == 0) goto L_0x01be
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r14 = r14.getDistribution()
            if (r14 == 0) goto L_0x01be
            java.lang.String r14 = r14.getSum()
            goto L_0x01bf
        L_0x01be:
            r14 = 0
        L_0x01bf:
            java.lang.String r14 = net.one97.paytm.passbook.utility.c.c(r14)
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r13)
            r13 = 0
            java.lang.String r11 = kotlin.m.p.a(r14, r12, r11, r13)
            r15.append(r11)
            java.lang.String r11 = r15.toString()
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r7.setText(r11)
            int r7 = net.one97.paytm.passbook.R.id.favStoretvStoreName2
            android.view.View r7 = r1.a((int) r7)
            com.paytm.utility.RoboTextView r7 = (com.paytm.utility.RoboTextView) r7
            java.lang.String r11 = "spendAnalyticsMainActivity.favStoretvStoreName2"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r11)
            java.lang.Object r11 = r2.get(r8)
            net.one97.paytm.passbook.spendanalytics.model.Response r11 = (net.one97.paytm.passbook.spendanalytics.model.Response) r11
            if (r11 == 0) goto L_0x01f7
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r11 = r11.getDistribution()
            if (r11 == 0) goto L_0x01f7
            java.lang.String r15 = r11.getMdn()
            goto L_0x01f8
        L_0x01f7:
            r15 = 0
        L_0x01f8:
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            r7.setText(r15)
            int r7 = net.one97.paytm.passbook.R.id.favStoreCv2
            android.view.View r7 = r1.a((int) r7)
            androidx.cardview.widget.CardView r7 = (androidx.cardview.widget.CardView) r7
            net.one97.paytm.passbook.spendanalytics.c.a$b r11 = new net.one97.paytm.passbook.spendanalytics.c.a$b
            r11.<init>(r0, r2, r8, r3)
            android.view.View$OnClickListener r11 = (android.view.View.OnClickListener) r11
            r7.setOnClickListener(r11)
            goto L_0x00b1
        L_0x0211:
            int r7 = net.one97.paytm.passbook.R.id.favStoreCv1
            android.view.View r7 = r1.a((int) r7)
            androidx.cardview.widget.CardView r7 = (androidx.cardview.widget.CardView) r7
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r5)
            r15 = 0
            r7.setVisibility(r15)
            com.squareup.picasso.w r7 = com.squareup.picasso.w.a()
            java.lang.Object r15 = r2.get(r8)
            net.one97.paytm.passbook.spendanalytics.model.Response r15 = (net.one97.paytm.passbook.spendanalytics.model.Response) r15
            if (r15 == 0) goto L_0x0237
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r15 = r15.getDistribution()
            if (r15 == 0) goto L_0x0237
            java.lang.String r15 = r15.getLogo()
            goto L_0x0238
        L_0x0237:
            r15 = 0
        L_0x0238:
            com.squareup.picasso.aa r7 = r7.a((java.lang.String) r15)
            net.one97.paytm.passbook.customview.b r15 = new net.one97.paytm.passbook.customview.b
            r15.<init>()
            com.squareup.picasso.ah r15 = (com.squareup.picasso.ah) r15
            com.squareup.picasso.aa r7 = r7.a((com.squareup.picasso.ah) r15)
            int r15 = net.one97.paytm.passbook.R.id.favStoreivStoreIcon1
            android.view.View r15 = r1.a((int) r15)
            net.one97.paytm.passbook.customview.CircularImageView r15 = (net.one97.paytm.passbook.customview.CircularImageView) r15
            r7.a((android.widget.ImageView) r15)
            int r7 = net.one97.paytm.passbook.R.id.favStoretvSpentAmount1
            android.view.View r7 = r1.a((int) r7)
            com.paytm.utility.RoboTextView r7 = (com.paytm.utility.RoboTextView) r7
            java.lang.String r15 = "spendAnalyticsMainActivity.favStoretvSpentAmount1"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r15)
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>(r14)
            java.lang.Object r14 = r2.get(r8)
            net.one97.paytm.passbook.spendanalytics.model.Response r14 = (net.one97.paytm.passbook.spendanalytics.model.Response) r14
            if (r14 == 0) goto L_0x0277
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r14 = r14.getDistribution()
            if (r14 == 0) goto L_0x0277
            java.lang.String r14 = r14.getSum()
            goto L_0x0278
        L_0x0277:
            r14 = 0
        L_0x0278:
            java.lang.String r14 = net.one97.paytm.passbook.utility.c.c(r14)
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r13)
            r13 = 0
            java.lang.String r11 = kotlin.m.p.a(r14, r12, r11, r13)
            r15.append(r11)
            java.lang.String r11 = r15.toString()
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r7.setText(r11)
            int r7 = net.one97.paytm.passbook.R.id.favStoretvStoreName1
            android.view.View r7 = r1.a((int) r7)
            com.paytm.utility.RoboTextView r7 = (com.paytm.utility.RoboTextView) r7
            java.lang.String r11 = "spendAnalyticsMainActivity.favStoretvStoreName1"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r11)
            java.lang.Object r11 = r2.get(r8)
            net.one97.paytm.passbook.spendanalytics.model.Response r11 = (net.one97.paytm.passbook.spendanalytics.model.Response) r11
            if (r11 == 0) goto L_0x02b0
            net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsDistribution r11 = r11.getDistribution()
            if (r11 == 0) goto L_0x02b0
            java.lang.String r15 = r11.getMdn()
            goto L_0x02b1
        L_0x02b0:
            r15 = 0
        L_0x02b1:
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            r7.setText(r15)
            int r7 = net.one97.paytm.passbook.R.id.favStoreCv1
            android.view.View r7 = r1.a((int) r7)
            androidx.cardview.widget.CardView r7 = (androidx.cardview.widget.CardView) r7
            net.one97.paytm.passbook.spendanalytics.c.a$a r11 = new net.one97.paytm.passbook.spendanalytics.c.a$a
            r11.<init>(r0, r2, r8, r3)
            android.view.View$OnClickListener r11 = (android.view.View.OnClickListener) r11
            r7.setOnClickListener(r11)
        L_0x02c8:
            int r8 = r8 + 1
            r7 = 0
            goto L_0x0092
        L_0x02cd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.spendanalytics.c.a.a(net.one97.paytm.passbook.spendanalytics.activities.SpendAnalyticsMainActivity, java.util.ArrayList, java.lang.String):void");
    }

    /* renamed from: net.one97.paytm.passbook.spendanalytics.c.a$a  reason: collision with other inner class name */
    static final class C1131a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f58560a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f58561b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f58562c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f58563d;

        C1131a(a aVar, ArrayList arrayList, int i2, String str) {
            this.f58560a = aVar;
            this.f58561b = arrayList;
            this.f58562c = i2;
            this.f58563d = str;
        }

        public final void onClick(View view) {
            a aVar = this.f58560a;
            Object obj = this.f58561b.get(this.f58562c);
            k.a(obj, "favStoresList[position]");
            a.a(aVar, (Response) obj, this.f58563d);
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f58564a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f58565b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f58566c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f58567d;

        b(a aVar, ArrayList arrayList, int i2, String str) {
            this.f58564a = aVar;
            this.f58565b = arrayList;
            this.f58566c = i2;
            this.f58567d = str;
        }

        public final void onClick(View view) {
            a aVar = this.f58564a;
            Object obj = this.f58565b.get(this.f58566c);
            k.a(obj, "favStoresList[position]");
            a.a(aVar, (Response) obj, this.f58567d);
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f58568a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f58569b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f58570c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f58571d;

        c(a aVar, ArrayList arrayList, int i2, String str) {
            this.f58568a = aVar;
            this.f58569b = arrayList;
            this.f58570c = i2;
            this.f58571d = str;
        }

        public final void onClick(View view) {
            a aVar = this.f58568a;
            Object obj = this.f58569b.get(this.f58570c);
            k.a(obj, "favStoresList[position]");
            a.a(aVar, (Response) obj, this.f58571d);
        }
    }

    public static ArrayList<Response> a(ArrayList<Response> arrayList) {
        k.c(arrayList, "spendsByCategoryList");
        int size = arrayList.size();
        int i2 = 0;
        Response response = null;
        int i3 = -1;
        while (i2 < size) {
            String valueOf = String.valueOf(arrayList.get(i2).getDistribution().getKey());
            if (valueOf != null) {
                if (valueOf.contentEquals(r6)) {
                    response = arrayList.get(i2);
                    i3 = i2;
                }
                i2++;
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        }
        if (i3 != -1) {
            arrayList.remove(i3);
            if (response != null) {
                arrayList.add(response);
            }
        }
        return arrayList;
    }

    public static final /* synthetic */ void a(a aVar, Response response, String str) {
        net.one97.paytm.passbook.spendanalytics.model.a aVar2 = new net.one97.paytm.passbook.spendanalytics.model.a(response.getDistribution().getCnt(), response.getDistribution().getKey(), response.getDistribution().getLogo(), response.getDistribution().getMdn(), response.getDistribution().getSum(), str);
        Intent intent = new Intent(aVar.f58559a, SpendAnalyticsTransactionDetailActivity.class);
        intent.putExtra("request_store_history", aVar2);
        aVar.f58559a.startActivity(intent);
    }
}
