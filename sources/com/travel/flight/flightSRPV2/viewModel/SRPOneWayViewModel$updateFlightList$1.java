package com.travel.flight.flightSRPV2.viewModel;

import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;

@f(b = "SRPOneWayViewModel.kt", c = {69}, d = "invokeSuspend", e = "com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel$updateFlightList$1")
final class SRPOneWayViewModel$updateFlightList$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    final /* synthetic */ long $startTime;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ SRPOneWayViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SRPOneWayViewModel$updateFlightList$1(SRPOneWayViewModel sRPOneWayViewModel, long j, d dVar) {
        super(2, dVar);
        this.this$0 = sRPOneWayViewModel;
        this.$startTime = j;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        SRPOneWayViewModel$updateFlightList$1 sRPOneWayViewModel$updateFlightList$1 = new SRPOneWayViewModel$updateFlightList$1(this.this$0, this.$startTime, dVar);
        sRPOneWayViewModel$updateFlightList$1.p$ = (CoroutineScope) obj;
        return sRPOneWayViewModel$updateFlightList$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((SRPOneWayViewModel$updateFlightList$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            r14 = this;
            kotlin.d.a.a r0 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r1 = r14.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0025
            if (r1 != r3) goto L_0x001d
            int r0 = r14.I$0
            java.lang.Object r1 = r14.L$4
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r3 = r14.L$2
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r4 = r14.L$1
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r4 = (com.travel.flight.pojo.flightticket.CJRFlightSearchResult) r4
            kotlin.ResultKt.a((java.lang.Object) r15)
            goto L_0x00c9
        L_0x001d:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0025:
            kotlin.ResultKt.a((java.lang.Object) r15)
            kotlinx.coroutines.CoroutineScope r15 = r14.p$
            com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel r1 = r14.this$0
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r1 = r1.getParentViewModel()
            androidx.lifecycle.y r1 = r1.getSrpResult()
            java.lang.Object r1 = r1.getValue()
            r4 = r1
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r4 = (com.travel.flight.pojo.flightticket.CJRFlightSearchResult) r4
            if (r4 != 0) goto L_0x0040
            kotlin.x r15 = kotlin.x.f47997a
            return r15
        L_0x0040:
            com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel r1 = r14.this$0
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r1 = r1.getParentViewModel()
            r5 = 2
            r1.setProgressState(r5)
            com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel r1 = r14.this$0
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r1 = r1.getParentViewModel()
            androidx.lifecycle.y r1 = r1.getOnwardFilterList()
            java.lang.Object r1 = r1.getValue()
            java.util.List r1 = (java.util.List) r1
            if (r1 != 0) goto L_0x0060
            kotlin.a.w r1 = kotlin.a.w.INSTANCE
            java.util.List r1 = (java.util.List) r1
        L_0x0060:
            kotlinx.coroutines.Job r5 = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(kotlinx.coroutines.GlobalScope.INSTANCE, (kotlin.d.f) null, (kotlinx.coroutines.CoroutineStart) null, new com.travel.flight.flightSRPV2.a.t.f(500, (kotlin.d.d) null), 3, (java.lang.Object) null)
            com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel r6 = r14.this$0
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r6 = r6.getParentViewModel()
            androidx.lifecycle.y r6 = r6.getOneWaySortOption()
            java.lang.Object r6 = r6.getValue()
            com.travel.flight.flightSRPV2.a.ae r6 = (com.travel.flight.flightSRPV2.a.ae) r6
            java.util.List r6 = com.travel.flight.flightSRPV2.a.t.a((com.travel.flight.pojo.flightticket.CJRFlightSearchResult) r4, (java.util.List<? extends com.travel.flight.flightSRPV2.a.x>) r1, (com.travel.flight.flightSRPV2.a.ae) r6)
            r7 = r6
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            boolean r8 = r7 instanceof java.util.Collection
            if (r8 == 0) goto L_0x0088
            r8 = r7
            java.util.Collection r8 = (java.util.Collection) r8
            boolean r8 = r8.isEmpty()
            if (r8 != 0) goto L_0x00af
        L_0x0088:
            java.util.Iterator r7 = r7.iterator()
        L_0x008c:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x00af
            java.lang.Object r8 = r7.next()
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r8 = (com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r8
            java.lang.String r8 = r8.getmFlightId()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            if (r8 == 0) goto L_0x00a9
            boolean r8 = kotlin.m.p.a(r8)
            if (r8 == 0) goto L_0x00a7
            goto L_0x00a9
        L_0x00a7:
            r8 = 0
            goto L_0x00aa
        L_0x00a9:
            r8 = 1
        L_0x00aa:
            r8 = r8 ^ r3
            if (r8 == 0) goto L_0x008c
            r7 = 1
            goto L_0x00b0
        L_0x00af:
            r7 = 0
        L_0x00b0:
            r7 = r7 ^ r3
            r14.L$0 = r15
            r14.L$1 = r4
            r14.L$2 = r1
            r14.L$3 = r5
            r14.L$4 = r6
            r14.I$0 = r7
            r14.label = r3
            java.lang.Object r15 = r5.join(r14)
            if (r15 != r0) goto L_0x00c6
            return r0
        L_0x00c6:
            r3 = r1
            r1 = r6
            r0 = r7
        L_0x00c9:
            com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel r15 = r14.this$0
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r15 = r15.getParentViewModel()
            r15.setProgressState(r2)
            com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel r15 = r14.this$0
            androidx.lifecycle.y r15 = r15.getOnwardFlightList()
            com.travel.flight.flightSRPV2.c.a r2 = new com.travel.flight.flightSRPV2.c.a
            java.util.Collection r1 = (java.util.Collection) r1
            r2.<init>(r1)
            r15.postValue(r2)
            if (r0 == 0) goto L_0x00fd
            com.travel.flight.flightSRPV2.b.c r15 = new com.travel.flight.flightSRPV2.b.c
            r7 = 0
            int r8 = com.travel.flight.R.id.container_child
            r9 = 1
            java.lang.String r6 = "PAGE_NO_FLIGHTS_FOUND"
            java.lang.String r10 = "PAGE_NO_FLIGHTS_FOUND"
            r5 = r15
            r5.<init>(r6, r7, r8, r9, r10)
            com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel r0 = r14.this$0
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r0 = r0.getParentViewModel()
            com.travel.flight.flightSRPV2.b.d r15 = (com.travel.flight.flightSRPV2.b.d) r15
            r0.navigate(r15)
        L_0x00fd:
            com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation r15 = r4.getmOnwardReturnFlights()
            java.lang.String r0 = "flightsInfo"
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r0)
            java.lang.String r15 = r15.getJourney_type()
            java.lang.String r0 = net.one97.paytmflight.common.b.b.f30019i
            boolean r15 = kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.Object) r0)
            if (r15 == 0) goto L_0x0115
            java.lang.String r15 = "IOW"
            goto L_0x0117
        L_0x0115:
            java.lang.String r15 = "DOW"
        L_0x0117:
            r6 = r15
            com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel r15 = r14.this$0
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r5 = r15.getParentViewModel()
            com.travel.flight.flightSRPV2.a.a r9 = new com.travel.flight.flightSRPV2.a.a
            java.util.List r15 = com.travel.flight.flightSRPV2.a.t.b((java.util.List<? extends com.travel.flight.flightSRPV2.a.x>) r3)
            r0 = 0
            r9.<init>(r15, r0)
            com.travel.flight.flightSRPV2.a.b r10 = new com.travel.flight.flightSRPV2.a.b
            com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel r15 = r14.this$0
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r15 = r15.getParentViewModel()
            androidx.lifecycle.y r15 = r15.getOneWaySortOption()
            java.lang.Object r15 = r15.getValue()
            if (r15 != 0) goto L_0x013d
            kotlin.g.b.k.a()
        L_0x013d:
            com.travel.flight.flightSRPV2.a.ae r15 = (com.travel.flight.flightSRPV2.a.ae) r15
            java.lang.String r15 = r15.b()
            r10.<init>(r15, r0)
            long r11 = r14.$startTime
            com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation r15 = r4.getmOnwardReturnFlights()
            com.travel.flight.pojo.flightticket.CJROnwardFlights r15 = r15.getmOnwardFlights()
            java.util.ArrayList r15 = r15.getmFlightDetails()
            int r13 = r15.size()
            java.lang.String r7 = "FILTER"
            java.lang.String r8 = "ONWARD"
            r5.logProcessingEvent(r6, r7, r8, r9, r10, r11, r13)
            kotlin.x r15 = kotlin.x.f47997a
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel$updateFlightList$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
