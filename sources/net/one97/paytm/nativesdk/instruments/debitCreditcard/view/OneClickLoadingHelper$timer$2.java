package net.one97.paytm.nativesdk.instruments.debitCreditcard.view;

import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.flow.FlowCollector;

@f(b = "OneClickLoadingHelper.kt", c = {95, 96}, d = "invokeSuspend", e = "net.one97.paytm.nativesdk.instruments.debitCreditcard.view.OneClickLoadingHelper$timer$2")
final class OneClickLoadingHelper$timer$2 extends k implements m<FlowCollector<? super Integer>, d<? super x>, Object> {
    final /* synthetic */ int $time;
    int I$0;
    Object L$0;
    int label;
    private FlowCollector p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OneClickLoadingHelper$timer$2(int i2, d dVar) {
        super(2, dVar);
        this.$time = i2;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        OneClickLoadingHelper$timer$2 oneClickLoadingHelper$timer$2 = new OneClickLoadingHelper$timer$2(this.$time, dVar);
        oneClickLoadingHelper$timer$2.p$ = (FlowCollector) obj;
        return oneClickLoadingHelper$timer$2;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((OneClickLoadingHelper$timer$2) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            kotlin.d.a.a r0 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r1 = r8.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x002b
            if (r1 == r3) goto L_0x001f
            if (r1 != r2) goto L_0x0017
            int r1 = r8.I$0
            java.lang.Object r4 = r8.L$0
            kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4
            kotlin.ResultKt.a((java.lang.Object) r9)
            r9 = r4
            goto L_0x0032
        L_0x0017:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x001f:
            int r1 = r8.I$0
            java.lang.Object r4 = r8.L$0
            kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4
            kotlin.ResultKt.a((java.lang.Object) r9)
            r9 = r0
            r0 = r8
            goto L_0x004c
        L_0x002b:
            kotlin.ResultKt.a((java.lang.Object) r9)
            kotlinx.coroutines.flow.FlowCollector r9 = r8.p$
            int r1 = r8.$time
        L_0x0032:
            r4 = r0
            r0 = r8
        L_0x0034:
            if (r1 == 0) goto L_0x005f
            java.lang.Integer r5 = java.lang.Integer.valueOf(r1)
            int r1 = r1 + -1
            r0.L$0 = r9
            r0.I$0 = r1
            r0.label = r3
            java.lang.Object r5 = r9.emit(r5, r0)
            if (r5 != r4) goto L_0x0049
            return r4
        L_0x0049:
            r7 = r4
            r4 = r9
            r9 = r7
        L_0x004c:
            r5 = 1000(0x3e8, double:4.94E-321)
            r0.L$0 = r4
            r0.I$0 = r1
            r0.label = r2
            java.lang.Object r5 = kotlinx.coroutines.DelayKt.delay(r5, r0)
            if (r5 != r9) goto L_0x005b
            return r9
        L_0x005b:
            r7 = r4
            r4 = r9
            r9 = r7
            goto L_0x0034
        L_0x005f:
            kotlin.x r9 = kotlin.x.f47997a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.nativesdk.instruments.debitCreditcard.view.OneClickLoadingHelper$timer$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
