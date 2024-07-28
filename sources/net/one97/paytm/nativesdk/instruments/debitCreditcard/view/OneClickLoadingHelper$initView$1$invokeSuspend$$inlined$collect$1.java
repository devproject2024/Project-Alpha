package net.one97.paytm.nativesdk.instruments.debitCreditcard.view;

import kotlin.g.b.x;
import kotlinx.coroutines.flow.FlowCollector;

public final class OneClickLoadingHelper$initView$1$invokeSuspend$$inlined$collect$1 implements FlowCollector<Integer> {
    final /* synthetic */ x.e $description$inlined;
    final /* synthetic */ x.c $rightImageDrawable$inlined;
    final /* synthetic */ OneClickLoadingHelper$initView$1 this$0;

    public OneClickLoadingHelper$initView$1$invokeSuspend$$inlined$collect$1(OneClickLoadingHelper$initView$1 oneClickLoadingHelper$initView$1, x.e eVar, x.c cVar) {
        this.this$0 = oneClickLoadingHelper$initView$1;
        this.$description$inlined = eVar;
        this.$rightImageDrawable$inlined = cVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object emit(java.lang.Object r10, kotlin.d.d r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof net.one97.paytm.nativesdk.instruments.debitCreditcard.view.OneClickLoadingHelper$initView$1$invokeSuspend$$inlined$collect$1.AnonymousClass1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            net.one97.paytm.nativesdk.instruments.debitCreditcard.view.OneClickLoadingHelper$initView$1$invokeSuspend$$inlined$collect$1$1 r0 = (net.one97.paytm.nativesdk.instruments.debitCreditcard.view.OneClickLoadingHelper$initView$1$invokeSuspend$$inlined$collect$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            net.one97.paytm.nativesdk.instruments.debitCreditcard.view.OneClickLoadingHelper$initView$1$invokeSuspend$$inlined$collect$1$1 r0 = new net.one97.paytm.nativesdk.instruments.debitCreditcard.view.OneClickLoadingHelper$initView$1$invokeSuspend$$inlined$collect$1$1
            r0.<init>(r9, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            kotlin.d.a.a r1 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.a((java.lang.Object) r11)
            goto L_0x00ed
        L_0x0029:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0031:
            kotlin.ResultKt.a((java.lang.Object) r11)
            r11 = r0
            kotlin.d.d r11 = (kotlin.d.d) r11
            r2 = r10
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            net.one97.paytm.nativesdk.instruments.debitCreditcard.view.OneClickLoadingHelper$initView$1 r4 = r9.this$0
            net.one97.paytm.nativesdk.instruments.debitCreditcard.view.OneClickLoadingHelper r4 = r4.this$0
            r4.flowExitedTime = r2
            net.one97.paytm.nativesdk.instruments.debitCreditcard.view.OneClickLoadingHelper$initView$1 r4 = r9.this$0
            net.one97.paytm.nativesdk.instruments.debitCreditcard.view.OneClickLoadingHelper r4 = r4.this$0
            int r4 = r4.messageSwitchTime
            int r4 = r2 % r4
            if (r4 != 0) goto L_0x00cc
            net.one97.paytm.nativesdk.instruments.debitCreditcard.view.OneClickLoadingHelper$initView$1 r4 = r9.this$0
            net.one97.paytm.nativesdk.instruments.debitCreditcard.view.OneClickLoadingHelper r4 = r4.this$0
            boolean r4 = r4.interrupt
            if (r4 != 0) goto L_0x00c2
            net.one97.paytm.nativesdk.instruments.debitCreditcard.view.OneClickLoadingHelper$initView$1 r4 = r9.this$0
            kotlin.g.b.x$e r4 = r4.$iterator
            T r4 = r4.element
            java.util.Iterator r4 = (java.util.Iterator) r4
            boolean r4 = r4.hasNext()
            if (r4 != 0) goto L_0x0080
            net.one97.paytm.nativesdk.instruments.debitCreditcard.view.OneClickLoadingHelper$initView$1 r4 = r9.this$0
            kotlin.g.b.x$e r4 = r4.$iterator
            net.one97.paytm.nativesdk.instruments.debitCreditcard.view.OneClickLoadingHelper$initView$1 r5 = r9.this$0
            net.one97.paytm.nativesdk.instruments.debitCreditcard.view.OneClickLoadingHelper r5 = r5.this$0
            java.util.HashSet r5 = r5.descriptionTextMap
            java.util.Iterator r5 = r5.iterator()
            java.lang.String r6 = "descriptionTextMap.iterator()"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            r4.element = r5
        L_0x0080:
            net.one97.paytm.nativesdk.instruments.debitCreditcard.view.OneClickLoadingHelper$initView$1 r4 = r9.this$0
            kotlin.g.b.x$e r4 = r4.$iterator
            T r4 = r4.element
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r4 = r4.next()
            java.lang.String r5 = "iterator.next()"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            net.one97.paytm.nativesdk.instruments.debitCreditcard.view.ProcessingInfo r4 = (net.one97.paytm.nativesdk.instruments.debitCreditcard.view.ProcessingInfo) r4
            kotlin.g.b.x$e r5 = r9.$description$inlined
            java.lang.String r6 = r4.getText()
            r5.element = r6
            kotlin.g.b.x$c r5 = r9.$rightImageDrawable$inlined
            int r4 = r4.getRightImageUrl()
            r5.element = r4
            net.one97.paytm.nativesdk.instruments.debitCreditcard.view.OneClickLoadingHelper$initView$1 r4 = r9.this$0
            net.one97.paytm.nativesdk.instruments.debitCreditcard.view.OneClickLoadingHelper r4 = r4.this$0
            net.one97.paytm.nativesdk.instruments.debitCreditcard.view.OneClickTransactionInfo r4 = r4.getPaytmSdkCallback()
            if (r4 == 0) goto L_0x00cc
            net.one97.paytm.nativesdk.instruments.debitCreditcard.view.State r5 = net.one97.paytm.nativesdk.instruments.debitCreditcard.view.State.PROCESSING
            net.one97.paytm.nativesdk.instruments.debitCreditcard.view.ProcessingInfo r6 = new net.one97.paytm.nativesdk.instruments.debitCreditcard.view.ProcessingInfo
            kotlin.g.b.x$e r7 = r9.$description$inlined
            T r7 = r7.element
            java.lang.String r7 = (java.lang.String) r7
            kotlin.g.b.x$c r8 = r9.$rightImageDrawable$inlined
            int r8 = r8.element
            r6.<init>(r7, r8)
            r4.oneClickProgressInfo(r5, r6)
            goto L_0x00cc
        L_0x00c2:
            java.lang.Exception r10 = new java.lang.Exception
            java.lang.String r11 = "Interrupting job"
            r10.<init>(r11)
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            throw r10
        L_0x00cc:
            if (r2 != r3) goto L_0x00ed
            kotlinx.coroutines.MainCoroutineDispatcher r4 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.d.f r4 = (kotlin.d.f) r4
            net.one97.paytm.nativesdk.instruments.debitCreditcard.view.OneClickLoadingHelper$initView$1$invokeSuspend$$inlined$collect$1$lambda$1 r5 = new net.one97.paytm.nativesdk.instruments.debitCreditcard.view.OneClickLoadingHelper$initView$1$invokeSuspend$$inlined$collect$1$lambda$1
            r6 = 0
            r5.<init>(r6, r9)
            kotlin.g.a.m r5 = (kotlin.g.a.m) r5
            r0.L$0 = r9
            r0.L$1 = r10
            r0.L$2 = r11
            r0.I$0 = r2
            r0.label = r3
            java.lang.Object r10 = kotlinx.coroutines.BuildersKt.withContext(r4, r5, r0)
            if (r10 != r1) goto L_0x00ed
            return r1
        L_0x00ed:
            kotlin.x r10 = kotlin.x.f47997a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.instruments.debitCreditcard.view.OneClickLoadingHelper$initView$1$invokeSuspend$$inlined$collect$1.emit(java.lang.Object, kotlin.d.d):java.lang.Object");
    }
}
