package com.travel.flight.flightSRPV2.viewModel;

import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

@f(b = "DRTListViewModel.kt", c = {247, 266}, d = "invokeSuspend", e = "com.travel.flight.flightSRPV2.viewModel.DRTListViewModel$updateFlightSorting$1")
final class DRTListViewModel$updateFlightSorting$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    final /* synthetic */ Job $delayTask;
    final /* synthetic */ boolean $isOnwardJourney;
    final /* synthetic */ long $startTime;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ DRTListViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DRTListViewModel$updateFlightSorting$1(DRTListViewModel dRTListViewModel, boolean z, Job job, long j, d dVar) {
        super(2, dVar);
        this.this$0 = dRTListViewModel;
        this.$isOnwardJourney = z;
        this.$delayTask = job;
        this.$startTime = j;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        DRTListViewModel$updateFlightSorting$1 dRTListViewModel$updateFlightSorting$1 = new DRTListViewModel$updateFlightSorting$1(this.this$0, this.$isOnwardJourney, this.$delayTask, this.$startTime, dVar);
        dRTListViewModel$updateFlightSorting$1.p$ = (CoroutineScope) obj;
        return dRTListViewModel$updateFlightSorting$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((DRTListViewModel$updateFlightSorting$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0184  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            r14 = this;
            kotlin.d.a.a r0 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r1 = r14.label
            r2 = 0
            r3 = 2
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L_0x002f
            if (r1 == r5) goto L_0x0023
            if (r1 != r3) goto L_0x001b
            java.lang.Object r0 = r14.L$2
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r1 = r14.L$1
            com.travel.flight.flightSRPV2.a.ae r1 = (com.travel.flight.flightSRPV2.a.ae) r1
            kotlin.ResultKt.a((java.lang.Object) r15)
            goto L_0x0140
        L_0x001b:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0023:
            java.lang.Object r0 = r14.L$2
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r1 = r14.L$1
            com.travel.flight.flightSRPV2.a.ae r1 = (com.travel.flight.flightSRPV2.a.ae) r1
            kotlin.ResultKt.a((java.lang.Object) r15)
            goto L_0x0094
        L_0x002f:
            kotlin.ResultKt.a((java.lang.Object) r15)
            kotlinx.coroutines.CoroutineScope r15 = r14.p$
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel r1 = r14.this$0
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r1 = r1.getParentViewModel()
            r1.setProgressState(r3)
            boolean r1 = r14.$isOnwardJourney
            if (r1 == 0) goto L_0x00ea
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel r1 = r14.this$0
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r1 = r1.getParentViewModel()
            androidx.lifecycle.y r1 = r1.getRoundTripOnwardSortOption()
            java.lang.Object r1 = r1.getValue()
            com.travel.flight.flightSRPV2.a.ae r1 = (com.travel.flight.flightSRPV2.a.ae) r1
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel r3 = r14.this$0
            androidx.lifecycle.y r3 = r3.getOnwardFlightList()
            java.lang.Object r3 = r3.getValue()
            if (r3 != 0) goto L_0x0060
            kotlin.g.b.k.a()
        L_0x0060:
            java.util.List r3 = (java.util.List) r3
            if (r1 == 0) goto L_0x006e
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Comparator r6 = r1.c()
            java.util.List r3 = kotlin.a.k.a(r3, r6)
        L_0x006e:
            java.util.Iterator r6 = r3.iterator()
        L_0x0072:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0082
            java.lang.Object r7 = r6.next()
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r7 = (com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r7
            r7.setmIsParent(r5)
            goto L_0x0072
        L_0x0082:
            kotlinx.coroutines.Job r6 = r14.$delayTask
            r14.L$0 = r15
            r14.L$1 = r1
            r14.L$2 = r3
            r14.label = r5
            java.lang.Object r15 = r6.join(r14)
            if (r15 != r0) goto L_0x0093
            return r0
        L_0x0093:
            r0 = r3
        L_0x0094:
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel r15 = r14.this$0
            androidx.lifecycle.y r15 = r15.getOnwardFlightList()
            r15.postValue(r0)
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel r15 = r14.this$0
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r5 = r15.getParentViewModel()
            r9 = 0
            com.travel.flight.flightSRPV2.a.b r10 = new com.travel.flight.flightSRPV2.a.b
            if (r1 != 0) goto L_0x00ab
            kotlin.g.b.k.a()
        L_0x00ab:
            java.lang.String r15 = r1.b()
            r10.<init>(r15, r4)
            long r11 = r14.$startTime
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel r15 = r14.this$0
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r15 = r15.getParentViewModel()
            androidx.lifecycle.y r15 = r15.getSrpResult()
            java.lang.Object r15 = r15.getValue()
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r15 = (com.travel.flight.pojo.flightticket.CJRFlightSearchResult) r15
            if (r15 == 0) goto L_0x00d6
            com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation r15 = r15.getmOnwardReturnFlights()
            if (r15 == 0) goto L_0x00d6
            com.travel.flight.pojo.flightticket.CJROnwardFlights r15 = r15.getmOnwardFlights()
            if (r15 == 0) goto L_0x00d6
            java.util.ArrayList r4 = r15.getmFlightDetails()
        L_0x00d6:
            if (r4 != 0) goto L_0x00db
            kotlin.g.b.k.a()
        L_0x00db:
            int r13 = r4.size()
            java.lang.String r6 = "DRT"
            java.lang.String r7 = "SORT"
            java.lang.String r8 = "ONWARD"
            r5.logProcessingEvent(r6, r7, r8, r9, r10, r11, r13)
            goto L_0x0194
        L_0x00ea:
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel r1 = r14.this$0
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r1 = r1.getParentViewModel()
            androidx.lifecycle.y r1 = r1.getRoundTripReturnSortOption()
            java.lang.Object r1 = r1.getValue()
            com.travel.flight.flightSRPV2.a.ae r1 = (com.travel.flight.flightSRPV2.a.ae) r1
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel r6 = r14.this$0
            androidx.lifecycle.y r6 = r6.getReturnFlightList()
            java.lang.Object r6 = r6.getValue()
            if (r6 != 0) goto L_0x0109
            kotlin.g.b.k.a()
        L_0x0109:
            java.util.List r6 = (java.util.List) r6
            if (r1 == 0) goto L_0x0117
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Comparator r7 = r1.c()
            java.util.List r6 = kotlin.a.k.a(r6, r7)
        L_0x0117:
            java.util.Iterator r7 = r6.iterator()
        L_0x011b:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x012e
            java.lang.Object r8 = r7.next()
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r8 = (com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r8
            r8.setmIsParent(r5)
            r8.setSelected(r2)
            goto L_0x011b
        L_0x012e:
            kotlinx.coroutines.Job r5 = r14.$delayTask
            r14.L$0 = r15
            r14.L$1 = r1
            r14.L$2 = r6
            r14.label = r3
            java.lang.Object r15 = r5.join(r14)
            if (r15 != r0) goto L_0x013f
            return r0
        L_0x013f:
            r0 = r6
        L_0x0140:
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel r15 = r14.this$0
            androidx.lifecycle.y r15 = r15.getReturnFlightList()
            r15.postValue(r0)
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel r15 = r14.this$0
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r5 = r15.getParentViewModel()
            r9 = 0
            com.travel.flight.flightSRPV2.a.b r10 = new com.travel.flight.flightSRPV2.a.b
            if (r1 != 0) goto L_0x0157
            kotlin.g.b.k.a()
        L_0x0157:
            java.lang.String r15 = r1.b()
            r10.<init>(r4, r15)
            long r11 = r14.$startTime
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel r15 = r14.this$0
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r15 = r15.getParentViewModel()
            androidx.lifecycle.y r15 = r15.getSrpResult()
            java.lang.Object r15 = r15.getValue()
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r15 = (com.travel.flight.pojo.flightticket.CJRFlightSearchResult) r15
            if (r15 == 0) goto L_0x0182
            com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation r15 = r15.getmOnwardReturnFlights()
            if (r15 == 0) goto L_0x0182
            com.travel.flight.pojo.flightticket.CJROnwardFlights r15 = r15.getmOnwardFlights()
            if (r15 == 0) goto L_0x0182
            java.util.ArrayList r4 = r15.getmFlightDetails()
        L_0x0182:
            if (r4 != 0) goto L_0x0187
            kotlin.g.b.k.a()
        L_0x0187:
            int r13 = r4.size()
            java.lang.String r6 = "DRT"
            java.lang.String r7 = "SORT"
            java.lang.String r8 = "RETURN"
            r5.logProcessingEvent(r6, r7, r8, r9, r10, r11, r13)
        L_0x0194:
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel r15 = r14.this$0
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r15 = r15.getParentViewModel()
            r15.setProgressState(r2)
            kotlin.x r15 = kotlin.x.f47997a
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightSRPV2.viewModel.DRTListViewModel$updateFlightSorting$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
