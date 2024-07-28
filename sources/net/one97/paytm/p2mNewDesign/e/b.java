package net.one97.paytm.p2mNewDesign.e;

import android.content.Context;
import android.widget.LinearLayout;
import easypay.manager.Constants;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.p2mNewDesign.e.a.a;
import net.one97.paytm.p2mNewDesign.e.a.c;
import net.one97.paytm.p2mNewDesign.e.a.d;
import net.one97.paytm.p2mNewDesign.e.a.e;
import net.one97.paytm.p2mNewDesign.e.a.f;
import net.one97.paytm.p2mNewDesign.e.a.h;
import net.one97.paytm.p2mNewDesign.e.a.i;
import net.one97.paytm.p2mNewDesign.entity.InstrumentInfo;
import net.one97.paytm.p2mNewDesign.f.g;
import net.one97.paytm.p2mNewDesign.models.PaymentModesV2;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<a> f51248a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f51249b;

    /* renamed from: c  reason: collision with root package name */
    private g f51250c;

    /* renamed from: d  reason: collision with root package name */
    private String f51251d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<a> f51252e;

    /* renamed from: f  reason: collision with root package name */
    private Context f51253f;

    public b(Context context) {
        k.c(context, "context");
        this.f51253f = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:90:0x02f6, code lost:
        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.c(r0.f51253f) == false) goto L_0x02f8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.o<java.util.ArrayList<net.one97.paytm.p2mNewDesign.e.a>, java.util.ArrayList<net.one97.paytm.p2mNewDesign.e.a>> a(java.util.List<net.one97.paytm.p2mNewDesign.models.PaymentModesV2> r19, android.widget.LinearLayout r20, net.one97.paytm.p2mNewDesign.f.g r21, java.lang.String r22, java.util.List<? extends net.one97.paytm.p2mNewDesign.e.a> r23) {
        /*
            r18 = this;
            r0 = r18
            r1 = r20
            r2 = r21
            r3 = r22
            java.lang.String r4 = "paytmInstruments"
            r5 = r19
            kotlin.g.b.k.c(r5, r4)
            java.lang.String r4 = "view"
            kotlin.g.b.k.c(r1, r4)
            java.lang.String r4 = "onInteractionListener"
            kotlin.g.b.k.c(r2, r4)
            java.lang.String r4 = "mid"
            kotlin.g.b.k.c(r3, r4)
            java.lang.String r4 = "existList"
            r6 = r23
            kotlin.g.b.k.c(r6, r4)
            r0.f51249b = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r0.f51252e = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r0.f51248a = r1
            r0.f51250c = r2
            r0.f51251d = r3
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r1 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r4 = "DirectPaymentBl.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse r3 = r3.e()
            int r1 = r1.b((net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse) r3)
            java.util.Iterator r3 = r19.iterator()
        L_0x0053:
            boolean r5 = r3.hasNext()
            java.lang.String r6 = "disabled"
            if (r5 == 0) goto L_0x0798
            java.lang.Object r5 = r3.next()
            net.one97.paytm.p2mNewDesign.models.PaymentModesV2 r5 = (net.one97.paytm.p2mNewDesign.models.PaymentModesV2) r5
            java.lang.String r7 = r5.getPaymentMode()
            java.lang.String r8 = "BALANCE"
            r9 = 1
            boolean r7 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r8, (boolean) r9)
            java.lang.String r10 = "paymentInstrumentView"
            java.lang.String r11 = "listener"
            if (r7 == 0) goto L_0x0124
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r7 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r4)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r7 = r7.j()
            if (r7 == 0) goto L_0x0053
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r7 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r4)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r7 = r7.j()
            java.lang.String r9 = "DirectPaymentBl.getInstance().walletInstrumentInfo"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r9)
            java.lang.String r7 = r7.getPayMode()
            boolean r7 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.q(r7)
            if (r7 == 0) goto L_0x0104
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r6 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r4)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r6 = r6.j()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r9)
            java.lang.String r5 = r5.getPriority()
            r6.setPriority(r5)
            net.one97.paytm.p2mNewDesign.e.a r5 = r0.a((java.lang.String) r8)
            if (r5 == 0) goto L_0x00cd
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r6 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r4)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r6 = r6.j()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r9)
            java.lang.String r6 = r6.getPriority()
            r0.a((net.one97.paytm.p2mNewDesign.e.a) r5, (java.lang.String) r6)
            goto L_0x0053
        L_0x00cd:
            net.one97.paytm.p2mNewDesign.e.a.i r7 = new net.one97.paytm.p2mNewDesign.e.a.i
            r7.<init>()
            java.util.ArrayList<net.one97.paytm.p2mNewDesign.e.a> r5 = r0.f51248a
            r5.add(r7)
            net.one97.paytm.p2mNewDesign.f.g r5 = r0.f51250c
            if (r5 != 0) goto L_0x00de
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x00de:
            r7.a((net.one97.paytm.p2mNewDesign.f.g) r5)
            android.content.Context r8 = r0.f51253f
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r9 = r5.j()
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r10 = r5.k()
            net.one97.paytm.p2mNewDesign.f.g r5 = r0.f51250c
            if (r5 != 0) goto L_0x00fa
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x00fa:
            java.lang.String r11 = r5.d()
            r12 = 0
            r7.a(r8, r9, r10, r11, r12)
            goto L_0x0053
        L_0x0104:
            net.one97.paytm.p2mNewDesign.e.a r5 = r0.a((java.lang.String) r8)
            if (r5 == 0) goto L_0x0053
            java.util.ArrayList<net.one97.paytm.p2mNewDesign.e.a> r7 = r0.f51252e
            if (r7 != 0) goto L_0x0111
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x0111:
            r7.add(r5)
            android.widget.LinearLayout r6 = r0.f51249b
            if (r6 != 0) goto L_0x011b
            kotlin.g.b.k.a((java.lang.String) r10)
        L_0x011b:
            android.view.View r5 = r5.c()
            r6.removeView(r5)
            goto L_0x0053
        L_0x0124:
            java.lang.String r7 = r5.getPaymentMode()
            java.lang.String r8 = "PAYTM_DIGITAL_CREDIT"
            boolean r7 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r8, (boolean) r9)
            if (r7 == 0) goto L_0x01e8
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r7 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r4)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r7 = r7.h()
            if (r7 == 0) goto L_0x0053
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r7 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r4)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r7 = r7.h()
            java.lang.String r9 = "DirectPaymentBl.getInsta…().postpaidInstrumentInfo"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r9)
            java.lang.String r5 = r5.getPriority()
            r7.setPriority(r5)
            net.one97.paytm.p2mNewDesign.e.a r5 = r0.a((java.lang.String) r8)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r7 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r4)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r7 = r7.h()
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r9)
            java.lang.String r7 = r7.getPayMode()
            boolean r7 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.q(r7)
            if (r7 == 0) goto L_0x01cc
            net.one97.paytm.p2mNewDesign.e.a r5 = r0.a((java.lang.String) r8)
            if (r5 == 0) goto L_0x0190
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r6 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r4)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r6 = r6.h()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r9)
            java.lang.String r6 = r6.getPriority()
            r0.a((net.one97.paytm.p2mNewDesign.e.a) r5, (java.lang.String) r6)
            goto L_0x0053
        L_0x0190:
            net.one97.paytm.p2mNewDesign.e.a.f r7 = new net.one97.paytm.p2mNewDesign.e.a.f
            r7.<init>()
            java.util.ArrayList<net.one97.paytm.p2mNewDesign.e.a> r5 = r0.f51248a
            r5.add(r7)
            net.one97.paytm.p2mNewDesign.f.g r5 = r0.f51250c
            if (r5 != 0) goto L_0x01a1
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x01a1:
            r7.a((net.one97.paytm.p2mNewDesign.f.g) r5)
            java.lang.String r5 = r0.f51251d
            if (r5 != 0) goto L_0x01ad
            java.lang.String r6 = "mappingId"
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x01ad:
            r7.b((java.lang.String) r5)
            android.content.Context r8 = r0.f51253f
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r9 = r5.h()
            r10 = 0
            net.one97.paytm.p2mNewDesign.f.g r5 = r0.f51250c
            if (r5 != 0) goto L_0x01c2
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x01c2:
            java.lang.String r11 = r5.d()
            r12 = 0
            r7.a(r8, r9, r10, r11, r12)
            goto L_0x0053
        L_0x01cc:
            if (r5 == 0) goto L_0x0053
            java.util.ArrayList<net.one97.paytm.p2mNewDesign.e.a> r7 = r0.f51252e
            if (r7 != 0) goto L_0x01d5
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x01d5:
            r7.add(r5)
            android.widget.LinearLayout r6 = r0.f51249b
            if (r6 != 0) goto L_0x01df
            kotlin.g.b.k.a((java.lang.String) r10)
        L_0x01df:
            android.view.View r5 = r5.c()
            r6.removeView(r5)
            goto L_0x0053
        L_0x01e8:
            java.lang.String r7 = r5.getPaymentMode()
            java.lang.String r8 = "UPI"
            boolean r7 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r8, (boolean) r9)
            if (r7 == 0) goto L_0x02d9
            net.one97.paytm.wallet.utility.j$c r6 = net.one97.paytm.wallet.utility.j.c.NO_UPI
            int r6 = r6.getValue()
            if (r1 == r6) goto L_0x0230
            net.one97.paytm.wallet.utility.j$c r6 = net.one97.paytm.wallet.utility.j.c.UPI_CREATED_NO_BANK_LINK
            int r6 = r6.getValue()
            if (r1 != r6) goto L_0x0205
            goto L_0x0230
        L_0x0205:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r6 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r4)
            java.util.List r6 = r6.p()
            if (r6 == 0) goto L_0x0053
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r6 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r4)
            java.util.List r6 = r6.p()
            int r6 = r6.size()
            if (r6 <= 0) goto L_0x0053
            java.lang.String r6 = r5.getDisplayName()
            java.lang.String r5 = r5.getPriority()
            r0.a((java.lang.String) r6, (java.lang.String) r5)
            goto L_0x0053
        L_0x0230:
            java.lang.String r6 = "UPI"
            net.one97.paytm.p2mNewDesign.e.a r6 = r0.a((java.lang.String) r6)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r7 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r4)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r7 = r7.i()
            if (r7 == 0) goto L_0x0053
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r7 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r4)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r7 = r7.i()
            java.lang.String r8 = "DirectPaymentBl.getInstance().upiOnBoardingInfo"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)
            java.lang.String r5 = r5.getPriority()
            r7.setPriority(r5)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r4)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r5 = r5.i()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r8)
            java.lang.String r5 = r5.getPayMode()
            boolean r5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.q(r5)
            if (r5 == 0) goto L_0x02c7
            java.lang.String r5 = "UPI_ONBOARDING"
            net.one97.paytm.p2mNewDesign.e.a r5 = r0.a((java.lang.String) r5)
            if (r5 == 0) goto L_0x0294
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r6 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r4)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r6 = r6.i()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r8)
            java.lang.String r6 = r6.getPriority()
            r0.a((net.one97.paytm.p2mNewDesign.e.a) r5, (java.lang.String) r6)
            goto L_0x0053
        L_0x0294:
            net.one97.paytm.p2mNewDesign.e.a.h r7 = new net.one97.paytm.p2mNewDesign.e.a.h
            r7.<init>()
            java.util.ArrayList<net.one97.paytm.p2mNewDesign.e.a> r5 = r0.f51248a
            r5.add(r7)
            net.one97.paytm.p2mNewDesign.f.g r5 = r0.f51250c
            if (r5 != 0) goto L_0x02a5
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x02a5:
            r7.a((net.one97.paytm.p2mNewDesign.f.g) r5)
            android.content.Context r8 = r0.f51253f
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r4)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r9 = r5.i()
            r10 = 0
            net.one97.paytm.p2mNewDesign.f.g r5 = r0.f51250c
            if (r5 != 0) goto L_0x02bd
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x02bd:
            java.lang.String r11 = r5.d()
            r12 = 0
            r7.a(r8, r9, r10, r11, r12)
            goto L_0x0053
        L_0x02c7:
            if (r6 == 0) goto L_0x0053
            android.widget.LinearLayout r5 = r0.f51249b
            if (r5 != 0) goto L_0x02d0
            kotlin.g.b.k.a((java.lang.String) r10)
        L_0x02d0:
            android.view.View r6 = r6.c()
            r5.removeView(r6)
            goto L_0x0053
        L_0x02d9:
            java.lang.String r7 = r5.getPaymentMode()
            java.lang.String r8 = "PPBL"
            boolean r7 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r8, (boolean) r9)
            if (r7 == 0) goto L_0x03ba
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r7 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            boolean r7 = r7.y
            if (r7 == 0) goto L_0x02f8
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            android.content.Context r7 = r0.f51253f
            boolean r7 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.c((android.content.Context) r7)
            if (r7 != 0) goto L_0x03ba
        L_0x02f8:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r7 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            boolean r7 = r7.n()
            if (r7 == 0) goto L_0x03ba
            net.one97.paytm.p2mNewDesign.e.a r7 = r0.a((java.lang.String) r8)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r9 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r4)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r9 = r9.o()
            if (r9 == 0) goto L_0x0053
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r9 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r4)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r9 = r9.o()
            java.lang.String r12 = "DirectPaymentBl.getInsta…aymentsBankInstrumentInfo"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r12)
            java.lang.String r5 = r5.getPriority()
            r9.setPriority(r5)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r4)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r5 = r5.o()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r12)
            java.lang.String r5 = r5.getPayMode()
            boolean r5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.q(r5)
            if (r5 == 0) goto L_0x039e
            net.one97.paytm.p2mNewDesign.e.a r5 = r0.a((java.lang.String) r8)
            if (r5 == 0) goto L_0x0362
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r6 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r4)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r6 = r6.o()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r12)
            java.lang.String r6 = r6.getPriority()
            r0.a((net.one97.paytm.p2mNewDesign.e.a) r5, (java.lang.String) r6)
            goto L_0x0053
        L_0x0362:
            net.one97.paytm.p2mNewDesign.e.a.e r7 = new net.one97.paytm.p2mNewDesign.e.a.e
            r7.<init>()
            java.util.ArrayList<net.one97.paytm.p2mNewDesign.e.a> r5 = r0.f51248a
            r5.add(r7)
            net.one97.paytm.p2mNewDesign.f.g r5 = r0.f51250c
            if (r5 != 0) goto L_0x0373
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x0373:
            r7.a((net.one97.paytm.p2mNewDesign.f.g) r5)
            java.lang.String r5 = r0.f51251d
            if (r5 != 0) goto L_0x037f
            java.lang.String r6 = "mappingId"
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x037f:
            r7.b((java.lang.String) r5)
            android.content.Context r8 = r0.f51253f
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r9 = r5.o()
            r10 = 0
            net.one97.paytm.p2mNewDesign.f.g r5 = r0.f51250c
            if (r5 != 0) goto L_0x0394
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x0394:
            java.lang.String r11 = r5.d()
            r12 = 0
            r7.a(r8, r9, r10, r11, r12)
            goto L_0x0053
        L_0x039e:
            if (r7 == 0) goto L_0x0053
            java.util.ArrayList<net.one97.paytm.p2mNewDesign.e.a> r5 = r0.f51252e
            if (r5 != 0) goto L_0x03a7
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x03a7:
            r5.add(r7)
            android.widget.LinearLayout r5 = r0.f51249b
            if (r5 != 0) goto L_0x03b1
            kotlin.g.b.k.a((java.lang.String) r10)
        L_0x03b1:
            android.view.View r6 = r7.c()
            r5.removeView(r6)
            goto L_0x0053
        L_0x03ba:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r7 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r4)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r7 = r7.A()
            if (r7 == 0) goto L_0x048e
            java.lang.String r7 = r5.getPaymentMode()
            java.lang.String r8 = "GIFT_VOUCHER"
            boolean r7 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r8, (boolean) r9)
            if (r7 == 0) goto L_0x048e
            net.one97.paytm.p2mNewDesign.e.a r7 = r0.a((java.lang.String) r8)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r9 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r4)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r9 = r9.A()
            if (r9 == 0) goto L_0x0053
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r9 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r4)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r9 = r9.A()
            java.lang.String r12 = "DirectPaymentBl.getInstance().mgvInstrumentInfo"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r12)
            java.lang.String r5 = r5.getPriority()
            r9.setPriority(r5)
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r4)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r5 = r5.A()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r12)
            java.lang.String r5 = r5.getPayMode()
            boolean r5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.q(r5)
            if (r5 == 0) goto L_0x0472
            net.one97.paytm.p2mNewDesign.e.a r5 = r0.a((java.lang.String) r8)
            if (r5 == 0) goto L_0x0433
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r6 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r4)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r6 = r6.A()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r12)
            java.lang.String r6 = r6.getPriority()
            r0.a((net.one97.paytm.p2mNewDesign.e.a) r5, (java.lang.String) r6)
            goto L_0x0053
        L_0x0433:
            net.one97.paytm.p2mNewDesign.e.a.c r7 = new net.one97.paytm.p2mNewDesign.e.a.c
            r7.<init>()
            java.util.ArrayList<net.one97.paytm.p2mNewDesign.e.a> r5 = r0.f51248a
            r5.add(r7)
            net.one97.paytm.p2mNewDesign.f.g r5 = r0.f51250c
            if (r5 != 0) goto L_0x0444
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x0444:
            r7.a((net.one97.paytm.p2mNewDesign.f.g) r5)
            java.lang.String r5 = r0.f51251d
            if (r5 != 0) goto L_0x0450
            java.lang.String r6 = "mappingId"
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x0450:
            r7.c(r5)
            android.content.Context r8 = r0.f51253f
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r4)
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r9 = r5.A()
            r10 = 0
            net.one97.paytm.p2mNewDesign.f.g r5 = r0.f51250c
            if (r5 != 0) goto L_0x0468
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x0468:
            java.lang.String r11 = r5.d()
            r12 = 0
            r7.a(r8, r9, r10, r11, r12)
            goto L_0x0053
        L_0x0472:
            if (r7 == 0) goto L_0x0053
            java.util.ArrayList<net.one97.paytm.p2mNewDesign.e.a> r5 = r0.f51252e
            if (r5 != 0) goto L_0x047b
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x047b:
            r5.add(r7)
            android.widget.LinearLayout r5 = r0.f51249b
            if (r5 != 0) goto L_0x0485
            kotlin.g.b.k.a((java.lang.String) r10)
        L_0x0485:
            android.view.View r6 = r7.c()
            r5.removeView(r6)
            goto L_0x0053
        L_0x048e:
            java.lang.String r7 = r5.getPaymentMode()
            java.lang.String r8 = "DEBIT_CARD"
            boolean r7 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r8, (boolean) r9)
            if (r7 == 0) goto L_0x04ea
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.models.IsDisabledV2 r7 = r5.isDisabled()
            boolean r7 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.a((net.one97.paytm.p2mNewDesign.models.IsDisabledV2) r7)
            if (r7 != 0) goto L_0x04ea
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r6 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r7 = r5.getPaymentMode()
            boolean r6 = r6.p(r7)
            if (r6 == 0) goto L_0x04c2
            java.lang.String r5 = r5.getPriority()
            if (r5 == 0) goto L_0x0053
            r0.c(r5)
            kotlin.x r5 = kotlin.x.f47997a
            goto L_0x0053
        L_0x04c2:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r6 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r4)
            boolean r6 = r6.B()
            if (r6 != 0) goto L_0x0053
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r6 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r7 = r5.getPaymentMode()
            boolean r6 = r6.p(r7)
            if (r6 != 0) goto L_0x0053
            java.lang.String r5 = r5.getPriority()
            if (r5 == 0) goto L_0x0053
            r0.c(r5)
            kotlin.x r5 = kotlin.x.f47997a
            goto L_0x0053
        L_0x04ea:
            java.lang.String r7 = r5.getPaymentMode()
            java.lang.String r8 = "CREDIT_CARD"
            boolean r7 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r8, (boolean) r9)
            if (r7 == 0) goto L_0x0546
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.models.IsDisabledV2 r7 = r5.isDisabled()
            boolean r7 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.a((net.one97.paytm.p2mNewDesign.models.IsDisabledV2) r7)
            if (r7 != 0) goto L_0x0546
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r6 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r7 = r5.getPaymentMode()
            boolean r6 = r6.p(r7)
            if (r6 == 0) goto L_0x051e
            java.lang.String r5 = r5.getPriority()
            if (r5 == 0) goto L_0x0053
            r0.b((java.lang.String) r5)
            kotlin.x r5 = kotlin.x.f47997a
            goto L_0x0053
        L_0x051e:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r6 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r4)
            boolean r6 = r6.B()
            if (r6 != 0) goto L_0x0053
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r6 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r7 = r5.getPaymentMode()
            boolean r6 = r6.p(r7)
            if (r6 != 0) goto L_0x0053
            java.lang.String r5 = r5.getPriority()
            if (r5 == 0) goto L_0x0053
            r0.b((java.lang.String) r5)
            kotlin.x r5 = kotlin.x.f47997a
            goto L_0x0053
        L_0x0546:
            java.lang.String r7 = r5.getPaymentMode()
            java.lang.String r10 = "NET_BANKING"
            boolean r7 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r10, (boolean) r9)
            if (r7 == 0) goto L_0x05ac
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r7 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            boolean r7 = r7.x()
            if (r7 == 0) goto L_0x05ac
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.models.IsDisabledV2 r7 = r5.isDisabled()
            boolean r7 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.a((net.one97.paytm.p2mNewDesign.models.IsDisabledV2) r7)
            if (r7 != 0) goto L_0x05ac
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r6 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r7 = r5.getPaymentMode()
            boolean r6 = r6.p(r7)
            if (r6 == 0) goto L_0x0584
            java.lang.String r5 = r5.getPriority()
            if (r5 == 0) goto L_0x0053
            r0.e(r5)
            kotlin.x r5 = kotlin.x.f47997a
            goto L_0x0053
        L_0x0584:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r6 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r4)
            boolean r6 = r6.B()
            if (r6 != 0) goto L_0x0053
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r6 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r7 = r5.getPaymentMode()
            boolean r6 = r6.p(r7)
            if (r6 != 0) goto L_0x0053
            java.lang.String r5 = r5.getPriority()
            if (r5 == 0) goto L_0x0053
            r0.e(r5)
            kotlin.x r5 = kotlin.x.f47997a
            goto L_0x0053
        L_0x05ac:
            java.lang.String r7 = r5.getPaymentMode()
            java.lang.String r10 = "emi"
            boolean r7 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r10, (boolean) r9)
            if (r7 == 0) goto L_0x060e
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            net.one97.paytm.p2mNewDesign.models.IsDisabledV2 r7 = r5.isDisabled()
            boolean r7 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.a((net.one97.paytm.p2mNewDesign.models.IsDisabledV2) r7)
            if (r7 != 0) goto L_0x060e
            boolean r6 = r21.i()
            if (r6 == 0) goto L_0x0053
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r6 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r7 = r5.getPaymentMode()
            boolean r6 = r6.p(r7)
            if (r6 == 0) goto L_0x05e6
            java.lang.String r5 = r5.getPriority()
            if (r5 == 0) goto L_0x0053
            r0.d(r5)
            kotlin.x r5 = kotlin.x.f47997a
            goto L_0x0053
        L_0x05e6:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r6 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r4)
            boolean r6 = r6.B()
            if (r6 != 0) goto L_0x0053
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r6 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r7 = r5.getPaymentMode()
            boolean r6 = r6.p(r7)
            if (r6 != 0) goto L_0x0053
            java.lang.String r5 = r5.getPriority()
            if (r5 == 0) goto L_0x0053
            r0.d(r5)
            kotlin.x r5 = kotlin.x.f47997a
            goto L_0x0053
        L_0x060e:
            java.lang.String r7 = r5.getPaymentMode()
            java.lang.String r10 = "SAVED_CC"
            boolean r7 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r10, (boolean) r9)
            if (r7 == 0) goto L_0x06d3
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r7 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r9 = r5.getPaymentMode()
            boolean r7 = r7.p(r9)
            if (r7 == 0) goto L_0x062d
            r0.a((net.one97.paytm.p2mNewDesign.models.PaymentModesV2) r5)
            goto L_0x0053
        L_0x062d:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r7 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r4)
            boolean r7 = r7.B()
            if (r7 != 0) goto L_0x064d
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r7 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r9 = r5.getPaymentMode()
            boolean r7 = r7.p(r9)
            if (r7 != 0) goto L_0x064d
            r0.a((net.one97.paytm.p2mNewDesign.models.PaymentModesV2) r5)
            goto L_0x0053
        L_0x064d:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.util.List r5 = r5.h(r8)
            if (r5 == 0) goto L_0x0053
            java.util.Iterator r7 = r5.iterator()
        L_0x065b:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0053
            java.lang.Object r8 = r7.next()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r8 = (net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r8
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "instrumentInfo"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r10)
            java.lang.String r10 = r8.getPayMode()
            r9.append(r10)
            java.lang.String r8 = r8.getCardLastFourDigit()
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            net.one97.paytm.p2mNewDesign.e.a r8 = r0.a((java.lang.String) r8)
            if (r8 == 0) goto L_0x0694
            java.util.ArrayList<net.one97.paytm.p2mNewDesign.e.a> r9 = r0.f51252e
            if (r9 != 0) goto L_0x0690
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x0690:
            r9.add(r8)
            goto L_0x065b
        L_0x0694:
            java.util.Iterator r8 = r5.iterator()
        L_0x0698:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x065b
            java.lang.Object r9 = r8.next()
            r14 = r9
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r14 = (net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r14
            net.one97.paytm.p2mNewDesign.e.a.a r9 = new net.one97.paytm.p2mNewDesign.e.a.a
            r9.<init>()
            net.one97.paytm.p2mNewDesign.f.g r10 = r0.f51250c
            if (r10 != 0) goto L_0x06b1
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x06b1:
            r9.a((net.one97.paytm.p2mNewDesign.f.g) r10)
            android.content.Context r13 = r0.f51253f
            r15 = 0
            net.one97.paytm.p2mNewDesign.f.g r10 = r0.f51250c
            if (r10 != 0) goto L_0x06be
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x06be:
            java.lang.String r16 = r10.d()
            r17 = 0
            r12 = r9
            r12.a(r13, r14, r15, r16, r17)
            java.util.ArrayList<net.one97.paytm.p2mNewDesign.e.a> r10 = r0.f51252e
            if (r10 != 0) goto L_0x06cf
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x06cf:
            r10.add(r9)
            goto L_0x0698
        L_0x06d3:
            java.lang.String r7 = r5.getPaymentMode()
            java.lang.String r10 = "SAVED_DC"
            boolean r7 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r10, (boolean) r9)
            if (r7 == 0) goto L_0x0053
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r7 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r9 = r5.getPaymentMode()
            boolean r7 = r7.p(r9)
            if (r7 == 0) goto L_0x06f2
            r0.b((net.one97.paytm.p2mNewDesign.models.PaymentModesV2) r5)
            goto L_0x0053
        L_0x06f2:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r7 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r4)
            boolean r7 = r7.B()
            if (r7 != 0) goto L_0x0712
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r7 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.lang.String r9 = r5.getPaymentMode()
            boolean r7 = r7.p(r9)
            if (r7 != 0) goto L_0x0712
            r0.b((net.one97.paytm.p2mNewDesign.models.PaymentModesV2) r5)
            goto L_0x0053
        L_0x0712:
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b r5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f()
            java.util.List r5 = r5.h(r8)
            if (r5 == 0) goto L_0x0053
            java.util.Iterator r7 = r5.iterator()
        L_0x0720:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0053
            java.lang.Object r8 = r7.next()
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r8 = (net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r8
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "instrumentInfo"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r10)
            java.lang.String r10 = r8.getPayMode()
            r9.append(r10)
            java.lang.String r8 = r8.getCardLastFourDigit()
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            net.one97.paytm.p2mNewDesign.e.a r8 = r0.a((java.lang.String) r8)
            if (r8 == 0) goto L_0x0759
            java.util.ArrayList<net.one97.paytm.p2mNewDesign.e.a> r9 = r0.f51252e
            if (r9 != 0) goto L_0x0755
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x0755:
            r9.add(r8)
            goto L_0x0720
        L_0x0759:
            java.util.Iterator r8 = r5.iterator()
        L_0x075d:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x0720
            java.lang.Object r9 = r8.next()
            r14 = r9
            net.one97.paytm.p2mNewDesign.entity.InstrumentInfo r14 = (net.one97.paytm.p2mNewDesign.entity.InstrumentInfo) r14
            net.one97.paytm.p2mNewDesign.e.a.a r9 = new net.one97.paytm.p2mNewDesign.e.a.a
            r9.<init>()
            net.one97.paytm.p2mNewDesign.f.g r10 = r0.f51250c
            if (r10 != 0) goto L_0x0776
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x0776:
            r9.a((net.one97.paytm.p2mNewDesign.f.g) r10)
            android.content.Context r13 = r0.f51253f
            r15 = 0
            net.one97.paytm.p2mNewDesign.f.g r10 = r0.f51250c
            if (r10 != 0) goto L_0x0783
            kotlin.g.b.k.a((java.lang.String) r11)
        L_0x0783:
            java.lang.String r16 = r10.d()
            r17 = 0
            r12 = r9
            r12.a(r13, r14, r15, r16, r17)
            java.util.ArrayList<net.one97.paytm.p2mNewDesign.e.a> r10 = r0.f51252e
            if (r10 != 0) goto L_0x0794
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x0794:
            r10.add(r9)
            goto L_0x075d
        L_0x0798:
            java.util.ArrayList<net.one97.paytm.p2mNewDesign.e.a> r1 = r0.f51248a
            java.util.ArrayList<net.one97.paytm.p2mNewDesign.e.a> r2 = r0.f51252e
            if (r2 != 0) goto L_0x07a1
            kotlin.g.b.k.a((java.lang.String) r6)
        L_0x07a1:
            kotlin.o r1 = kotlin.t.a(r1, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.e.b.a(java.util.List, android.widget.LinearLayout, net.one97.paytm.p2mNewDesign.f.g, java.lang.String, java.util.List):kotlin.o");
    }

    private void a(a aVar, String str) {
        k.c(aVar, "controller");
        if (aVar instanceof i) {
            i iVar = (i) aVar;
            InstrumentInfo j = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().j();
            InstrumentInfo k = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().k();
            g gVar = this.f51250c;
            if (gVar == null) {
                k.a("listener");
            }
            iVar.a(j, k, gVar.d());
        } else if (aVar instanceof c) {
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
            k.a((Object) f2, "DirectPaymentBl.getInstance()");
            ((c) aVar).a(f2.A());
        } else if (aVar instanceof f) {
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f3 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
            k.a((Object) f3, "DirectPaymentBl.getInstance()");
            ((f) aVar).a(f3.h());
        } else if (aVar instanceof e) {
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f4 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
            k.a((Object) f4, "DirectPaymentBl.getInstance()");
            ((e) aVar).a(f4.o());
        } else if (aVar instanceof h) {
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f5 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
            k.a((Object) f5, "DirectPaymentBl.getInstance()");
            ((h) aVar).a(f5.i());
        } else if (aVar instanceof net.one97.paytm.p2mNewDesign.e.a.b) {
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f6 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
            k.a((Object) f6, "DirectPaymentBl.getInstance()");
            ((net.one97.paytm.p2mNewDesign.e.a.b) aVar).a(f6.m());
        } else if (aVar instanceof net.one97.paytm.p2mNewDesign.e.a.g) {
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f7 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
            k.a((Object) f7, "DirectPaymentBl.getInstance()");
            ((net.one97.paytm.p2mNewDesign.e.a.g) aVar).b(f7.p());
        } else if (aVar instanceof a) {
            ((a) aVar).j();
        } else if (aVar instanceof net.one97.paytm.p2mNewDesign.b.c) {
            InstrumentInfo instrumentInfo = new InstrumentInfo();
            instrumentInfo.setPayMode("NET_BANKING");
            instrumentInfo.setPriority(str);
            Context context = this.f51253f;
            g gVar2 = this.f51250c;
            if (gVar2 == null) {
                k.a("listener");
            }
            aVar.a(context, instrumentInfo, (InstrumentInfo) null, gVar2.d(), false);
        } else if (aVar instanceof net.one97.paytm.p2mNewDesign.b.b) {
            InstrumentInfo instrumentInfo2 = new InstrumentInfo();
            instrumentInfo2.setPayMode("emi");
            instrumentInfo2.setPriority(str);
            Context context2 = this.f51253f;
            g gVar3 = this.f51250c;
            if (gVar3 == null) {
                k.a("listener");
            }
            aVar.a(context2, instrumentInfo2, (InstrumentInfo) null, gVar3.d(), false);
        } else if (!(aVar instanceof d)) {
        } else {
            if (((d) aVar).g()) {
                InstrumentInfo instrumentInfo3 = new InstrumentInfo();
                instrumentInfo3.setPayMode(SDKConstants.DEBIT);
                instrumentInfo3.setPriority(str);
                Context context3 = this.f51253f;
                g gVar4 = this.f51250c;
                if (gVar4 == null) {
                    k.a("listener");
                }
                aVar.a(context3, instrumentInfo3, (InstrumentInfo) null, gVar4.d(), false);
                return;
            }
            InstrumentInfo instrumentInfo4 = new InstrumentInfo();
            instrumentInfo4.setPayMode(SDKConstants.CREDIT);
            instrumentInfo4.setPriority(str);
            Context context4 = this.f51253f;
            g gVar5 = this.f51250c;
            if (gVar5 == null) {
                k.a("listener");
            }
            aVar.a(context4, instrumentInfo4, (InstrumentInfo) null, gVar5.d(), false);
        }
    }

    private final a a(String str) {
        for (a aVar : this.f51248a) {
            if (p.a(aVar.a(), str, false)) {
                return aVar;
            }
        }
        return null;
    }

    private final void b(String str) {
        a a2 = a(SDKConstants.CREDIT);
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.q(SDKConstants.CREDIT)) {
            if (a2 != null) {
                a(a2, str);
                return;
            }
            d dVar = new d();
            this.f51248a.add(dVar);
            g gVar = this.f51250c;
            if (gVar == null) {
                k.a("listener");
            }
            dVar.a(gVar);
            InstrumentInfo instrumentInfo = new InstrumentInfo();
            instrumentInfo.setPriority(str);
            instrumentInfo.setEMICard(false);
            instrumentInfo.setPayMode(SDKConstants.CREDIT);
            Context context = this.f51253f;
            g gVar2 = this.f51250c;
            if (gVar2 == null) {
                k.a("listener");
            }
            dVar.a(context, instrumentInfo, (InstrumentInfo) null, gVar2.d(), false);
        } else if (a2 != null) {
            ArrayList<a> arrayList = this.f51252e;
            if (arrayList == null) {
                k.a("disabled");
            }
            arrayList.add(a2);
            LinearLayout linearLayout = this.f51249b;
            if (linearLayout == null) {
                k.a("paymentInstrumentView");
            }
            linearLayout.removeView(a2.c());
        }
    }

    private final void c(String str) {
        a a2 = a(SDKConstants.DEBIT);
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.q(SDKConstants.DEBIT)) {
            if (a2 != null) {
                a(a2, str);
                return;
            }
            d dVar = new d();
            this.f51248a.add(dVar);
            g gVar = this.f51250c;
            if (gVar == null) {
                k.a("listener");
            }
            dVar.a(gVar);
            InstrumentInfo instrumentInfo = new InstrumentInfo();
            instrumentInfo.setEMICard(false);
            instrumentInfo.setPayMode(SDKConstants.DEBIT);
            instrumentInfo.setPriority(str);
            Context context = this.f51253f;
            g gVar2 = this.f51250c;
            if (gVar2 == null) {
                k.a("listener");
            }
            dVar.a(context, instrumentInfo, (InstrumentInfo) null, gVar2.d(), false);
        } else if (a2 != null) {
            ArrayList<a> arrayList = this.f51252e;
            if (arrayList == null) {
                k.a("disabled");
            }
            arrayList.add(a2);
            LinearLayout linearLayout = this.f51249b;
            if (linearLayout == null) {
                k.a("paymentInstrumentView");
            }
            linearLayout.removeView(a2.c());
        }
    }

    private final void a(PaymentModesV2 paymentModesV2) {
        List<InstrumentInfo> h2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().h(SDKConstants.CREDIT);
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.q(SDKConstants.CREDIT) && h2 != null) {
            for (InstrumentInfo next : h2) {
                StringBuilder sb = new StringBuilder();
                k.a((Object) next, "instrumentInfo");
                sb.append(next.getPayMode());
                sb.append(next.getCardLastFourDigit());
                a a2 = a(sb.toString());
                if (a2 != null) {
                    a(a2, paymentModesV2.getPriority());
                } else {
                    String paymentDetails = next.getPaymentDetails();
                    k.a((Object) paymentDetails, "instrumentInfo.paymentDetails");
                    if (p.a((CharSequence) paymentDetails, (CharSequence) String.valueOf(paymentModesV2.getDisplayName()), false)) {
                        a aVar = new a();
                        this.f51248a.add(aVar);
                        g gVar = this.f51250c;
                        if (gVar == null) {
                            k.a("listener");
                        }
                        aVar.a(gVar);
                        next.setPriority(paymentModesV2.getPriority());
                        Context context = this.f51253f;
                        g gVar2 = this.f51250c;
                        if (gVar2 == null) {
                            k.a("listener");
                        }
                        aVar.a(context, next, (InstrumentInfo) null, gVar2.d(), false);
                    }
                }
            }
        }
    }

    private final void b(PaymentModesV2 paymentModesV2) {
        List<InstrumentInfo> h2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().h(SDKConstants.DEBIT);
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.q(Constants.EASYPAY_PAYTYPE_DEBIT_CARD) && h2 != null) {
            for (InstrumentInfo next : h2) {
                StringBuilder sb = new StringBuilder();
                k.a((Object) next, "instrumentInfo");
                sb.append(next.getPayMode());
                sb.append(next.getCardLastFourDigit());
                a a2 = a(sb.toString());
                if (a2 != null) {
                    a(a2, paymentModesV2.getPriority());
                } else {
                    String paymentDetails = next.getPaymentDetails();
                    k.a((Object) paymentDetails, "instrumentInfo.paymentDetails");
                    if (p.a((CharSequence) paymentDetails, (CharSequence) String.valueOf(paymentModesV2.getDisplayName()), false)) {
                        a aVar = new a();
                        this.f51248a.add(aVar);
                        g gVar = this.f51250c;
                        if (gVar == null) {
                            k.a("listener");
                        }
                        aVar.a(gVar);
                        next.setPriority(paymentModesV2.getPriority());
                        Context context = this.f51253f;
                        g gVar2 = this.f51250c;
                        if (gVar2 == null) {
                            k.a("listener");
                        }
                        aVar.a(context, next, (InstrumentInfo) null, gVar2.d(), false);
                    }
                }
            }
        }
    }

    private final void d(String str) {
        a a2 = a("emi");
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.q("emi")) {
            if (a2 != null) {
                a(a2, str);
                return;
            }
            g gVar = this.f51250c;
            if (gVar == null) {
                k.a("listener");
            }
            net.one97.paytm.p2mNewDesign.b.b bVar = new net.one97.paytm.p2mNewDesign.b.b(gVar.d());
            this.f51248a.add(bVar);
            g gVar2 = this.f51250c;
            if (gVar2 == null) {
                k.a("listener");
            }
            bVar.a(gVar2);
            InstrumentInfo instrumentInfo = new InstrumentInfo();
            instrumentInfo.setPayMode("emi");
            instrumentInfo.setPriority(str);
            Context context = this.f51253f;
            g gVar3 = this.f51250c;
            if (gVar3 == null) {
                k.a("listener");
            }
            bVar.a(context, instrumentInfo, (InstrumentInfo) null, gVar3.d(), false);
        } else if (a2 != null) {
            ArrayList<a> arrayList = this.f51252e;
            if (arrayList == null) {
                k.a("disabled");
            }
            arrayList.add(a2);
            LinearLayout linearLayout = this.f51249b;
            if (linearLayout == null) {
                k.a("paymentInstrumentView");
            }
            linearLayout.removeView(a2.c());
        }
    }

    private final void a(String str, String str2) {
        a a2 = a("UPI_ONBOARDING");
        if (a2 != null) {
            this.f51248a.remove(a2);
        }
        a a3 = a(SDKConstants.AI_KEY_PPBL);
        if (a3 != null && net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().y) {
            this.f51248a.remove(a3);
        }
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
        k.a((Object) f2, "DirectPaymentBl.getInstance()");
        List<InstrumentInfo> p = f2.p();
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.q("UPI") && p != null) {
            for (InstrumentInfo next : p) {
                k.a((Object) next, "instrumentInfo");
                if (p.a(next.getAccountNumber(), str, false)) {
                    a a4 = a("UPI" + next.getAccountNumber());
                    next.setPriority(str2);
                    if (a4 != null) {
                        a(a4, str2);
                        return;
                    }
                    int size = p.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        InstrumentInfo instrumentInfo = p.get(i2);
                        k.a((Object) instrumentInfo, "mUpiInstrumentInfoList[i]");
                        if (p.a(str, instrumentInfo.getAccountNumber(), true)) {
                            net.one97.paytm.p2mNewDesign.e.a.g gVar = new net.one97.paytm.p2mNewDesign.e.a.g();
                            this.f51248a.add(gVar);
                            g gVar2 = this.f51250c;
                            if (gVar2 == null) {
                                k.a("listener");
                            }
                            gVar.a(gVar2);
                            String str3 = this.f51251d;
                            if (str3 == null) {
                                k.a(CJRQRScanResultModel.KEY_MAPPING_ID);
                            }
                            gVar.b(str3);
                            InstrumentInfo instrumentInfo2 = p.get(i2);
                            k.a((Object) instrumentInfo2, "mUpiInstrumentInfoList[i]");
                            instrumentInfo2.setPriority(str2);
                            g gVar3 = this.f51250c;
                            if (gVar3 == null) {
                                k.a("listener");
                            }
                            Context q = gVar3.q();
                            InstrumentInfo instrumentInfo3 = p.get(i2);
                            g gVar4 = this.f51250c;
                            if (gVar4 == null) {
                                k.a("listener");
                            }
                            gVar.a(q, instrumentInfo3, (InstrumentInfo) null, gVar4.d(), false);
                        }
                    }
                    return;
                }
            }
        }
    }

    private final void e(String str) {
        a a2 = a("NET_BANKING");
        net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
        if (net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.q("NET_BANKING")) {
            if (a2 != null) {
                a(a2, str);
                return;
            }
            net.one97.paytm.p2mNewDesign.b.c cVar = new net.one97.paytm.p2mNewDesign.b.c();
            this.f51248a.add(cVar);
            g gVar = this.f51250c;
            if (gVar == null) {
                k.a("listener");
            }
            cVar.a(gVar);
            InstrumentInfo instrumentInfo = new InstrumentInfo();
            instrumentInfo.setPayMode("NET_BANKING");
            instrumentInfo.setPriority(str);
            Context context = this.f51253f;
            g gVar2 = this.f51250c;
            if (gVar2 == null) {
                k.a("listener");
            }
            cVar.a(context, instrumentInfo, (InstrumentInfo) null, gVar2.d(), false);
        } else if (a2 != null) {
            ArrayList<a> arrayList = this.f51252e;
            if (arrayList == null) {
                k.a("disabled");
            }
            arrayList.add(a2);
            LinearLayout linearLayout = this.f51249b;
            if (linearLayout == null) {
                k.a("paymentInstrumentView");
            }
            linearLayout.removeView(a2.c());
        }
    }
}
