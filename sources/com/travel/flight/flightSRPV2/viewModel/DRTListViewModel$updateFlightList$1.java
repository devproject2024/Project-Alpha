package com.travel.flight.flightSRPV2.viewModel;

import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

@f(b = "DRTListViewModel.kt", c = {149, 167}, d = "invokeSuspend", e = "com.travel.flight.flightSRPV2.viewModel.DRTListViewModel$updateFlightList$1")
final class DRTListViewModel$updateFlightList$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    final /* synthetic */ Job $delayTask;
    final /* synthetic */ boolean $isOnwardJourney;
    final /* synthetic */ long $startTime;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ DRTListViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DRTListViewModel$updateFlightList$1(DRTListViewModel dRTListViewModel, boolean z, Job job, long j, d dVar) {
        super(2, dVar);
        this.this$0 = dRTListViewModel;
        this.$isOnwardJourney = z;
        this.$delayTask = job;
        this.$startTime = j;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        DRTListViewModel$updateFlightList$1 dRTListViewModel$updateFlightList$1 = new DRTListViewModel$updateFlightList$1(this.this$0, this.$isOnwardJourney, this.$delayTask, this.$startTime, dVar);
        dRTListViewModel$updateFlightList$1.p$ = (CoroutineScope) obj;
        return dRTListViewModel$updateFlightList$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((DRTListViewModel$updateFlightList$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0060, code lost:
        r7 = r7.getmOnwardReturnFlights();
     */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x02a6 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x02a7  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x02bf  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x02eb  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x031b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            kotlin.d.a.a r1 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 0
            r5 = 0
            r6 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 == r6) goto L_0x002b
            if (r2 != r3) goto L_0x0023
            int r1 = r0.I$0
            java.lang.Object r2 = r0.L$3
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r3 = r0.L$2
            com.travel.flight.flightSRPV2.a.ae r3 = (com.travel.flight.flightSRPV2.a.ae) r3
            java.lang.Object r6 = r0.L$1
            java.util.List r6 = (java.util.List) r6
            kotlin.ResultKt.a((java.lang.Object) r18)
            goto L_0x02ab
        L_0x0023:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x002b:
            int r1 = r0.I$0
            java.lang.Object r2 = r0.L$3
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r3 = r0.L$2
            com.travel.flight.flightSRPV2.a.ae r3 = (com.travel.flight.flightSRPV2.a.ae) r3
            java.lang.Object r6 = r0.L$1
            java.util.List r6 = (java.util.List) r6
            kotlin.ResultKt.a((java.lang.Object) r18)
            r7 = r3
            r3 = r6
            goto L_0x0182
        L_0x0040:
            kotlin.ResultKt.a((java.lang.Object) r18)
            kotlinx.coroutines.CoroutineScope r2 = r0.p$
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel r7 = r0.this$0
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r7 = r7.getParentViewModel()
            r7.setProgressState(r3)
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel r7 = r0.this$0
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r7 = r7.getParentViewModel()
            androidx.lifecycle.y r7 = r7.getSrpResult()
            java.lang.Object r7 = r7.getValue()
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r7 = (com.travel.flight.pojo.flightticket.CJRFlightSearchResult) r7
            if (r7 == 0) goto L_0x006b
            com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation r7 = r7.getmOnwardReturnFlights()
            if (r7 == 0) goto L_0x006b
            java.util.ArrayList r7 = r7.getDiscountedStrip()
            goto L_0x006c
        L_0x006b:
            r7 = r5
        L_0x006c:
            java.util.Collection r7 = (java.util.Collection) r7
            if (r7 == 0) goto L_0x0079
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L_0x0077
            goto L_0x0079
        L_0x0077:
            r7 = 0
            goto L_0x007a
        L_0x0079:
            r7 = 1
        L_0x007a:
            if (r7 != 0) goto L_0x00ae
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel r7 = r0.this$0
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r8 = r7.getParentViewModel()
            androidx.lifecycle.y r8 = r8.getOnwardFilterList()
            java.lang.Object r8 = r8.getValue()
            java.util.List r8 = (java.util.List) r8
            if (r8 != 0) goto L_0x0092
            kotlin.a.w r8 = kotlin.a.w.INSTANCE
            java.util.List r8 = (java.util.List) r8
        L_0x0092:
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel r9 = r0.this$0
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r9 = r9.getParentViewModel()
            androidx.lifecycle.y r9 = r9.getReturnFilterList()
            java.lang.Object r9 = r9.getValue()
            java.util.List r9 = (java.util.List) r9
            if (r9 != 0) goto L_0x00a8
            kotlin.a.w r9 = kotlin.a.w.INSTANCE
            java.util.List r9 = (java.util.List) r9
        L_0x00a8:
            boolean r10 = r0.$isOnwardJourney
            r7.checkForAirlineFilter(r8, r9, r10)
            goto L_0x00d9
        L_0x00ae:
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel r7 = r0.this$0
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r7 = r7.getParentViewModel()
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel r8 = r0.this$0
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r8 = r8.getParentViewModel()
            androidx.lifecycle.y r8 = r8.getSrpResult()
            java.lang.Object r8 = r8.getValue()
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r8 = (com.travel.flight.pojo.flightticket.CJRFlightSearchResult) r8
            if (r8 == 0) goto L_0x00d1
            com.travel.flight.pojo.flightticket.CJRMetadetails r8 = r8.getmMetaDetails()
            if (r8 == 0) goto L_0x00d1
            java.lang.String r8 = r8.getmRequestId()
            goto L_0x00d2
        L_0x00d1:
            r8 = r5
        L_0x00d2:
            java.lang.String r9 = "DRT"
            java.lang.String r10 = "discounted_strip key is null/empty in srp-response"
            r7.sendHawkeyeErrorEvent(r9, r10, r8)
        L_0x00d9:
            boolean r7 = r0.$isOnwardJourney
            if (r7 == 0) goto L_0x0204
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel r3 = r0.this$0
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r3 = r3.getParentViewModel()
            androidx.lifecycle.y r3 = r3.getOnwardFilterList()
            java.lang.Object r3 = r3.getValue()
            java.util.List r3 = (java.util.List) r3
            if (r3 != 0) goto L_0x00f3
            kotlin.a.w r3 = kotlin.a.w.INSTANCE
            java.util.List r3 = (java.util.List) r3
        L_0x00f3:
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel r7 = r0.this$0
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r7 = r7.getParentViewModel()
            androidx.lifecycle.y r7 = r7.getRoundTripOnwardSortOption()
            java.lang.Object r7 = r7.getValue()
            com.travel.flight.flightSRPV2.a.ae r7 = (com.travel.flight.flightSRPV2.a.ae) r7
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel r8 = r0.this$0
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r8 = r8.getParentViewModel()
            androidx.lifecycle.y r8 = r8.getSrpResult()
            java.lang.Object r8 = r8.getValue()
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r8 = (com.travel.flight.pojo.flightticket.CJRFlightSearchResult) r8
            if (r8 == 0) goto L_0x0126
            com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation r8 = r8.getmOnwardReturnFlights()
            if (r8 == 0) goto L_0x0126
            com.travel.flight.pojo.flightticket.CJROnwardFlights r8 = r8.getmOnwardFlights()
            if (r8 == 0) goto L_0x0126
            java.util.ArrayList r8 = r8.getmFlightDetails()
            goto L_0x0127
        L_0x0126:
            r8 = r5
        L_0x0127:
            if (r8 != 0) goto L_0x012c
            kotlin.g.b.k.a()
        L_0x012c:
            java.util.List r8 = (java.util.List) r8
            java.util.List r8 = com.travel.flight.flightSRPV2.a.t.a((java.util.List<? extends com.travel.flight.pojo.flightticket.CJRFlightDetailsItem>) r8, (java.util.List<? extends com.travel.flight.flightSRPV2.a.x>) r3, (com.travel.flight.flightSRPV2.a.ae) r7)
            r9 = r8
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            boolean r10 = r9 instanceof java.util.Collection
            if (r10 == 0) goto L_0x0142
            r10 = r9
            java.util.Collection r10 = (java.util.Collection) r10
            boolean r10 = r10.isEmpty()
            if (r10 != 0) goto L_0x0169
        L_0x0142:
            java.util.Iterator r9 = r9.iterator()
        L_0x0146:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x0169
            java.lang.Object r10 = r9.next()
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r10 = (com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r10
            java.lang.String r10 = r10.getmFlightId()
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            if (r10 == 0) goto L_0x0163
            boolean r10 = kotlin.m.p.a(r10)
            if (r10 == 0) goto L_0x0161
            goto L_0x0163
        L_0x0161:
            r10 = 0
            goto L_0x0164
        L_0x0163:
            r10 = 1
        L_0x0164:
            r10 = r10 ^ r6
            if (r10 == 0) goto L_0x0146
            r9 = 1
            goto L_0x016a
        L_0x0169:
            r9 = 0
        L_0x016a:
            r9 = r9 ^ r6
            kotlinx.coroutines.Job r10 = r0.$delayTask
            r0.L$0 = r2
            r0.L$1 = r3
            r0.L$2 = r7
            r0.L$3 = r8
            r0.I$0 = r9
            r0.label = r6
            java.lang.Object r2 = r10.join(r0)
            if (r2 != r1) goto L_0x0180
            return r1
        L_0x0180:
            r2 = r8
            r1 = r9
        L_0x0182:
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel r6 = r0.this$0
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r6 = r6.getParentViewModel()
            r6.setProgressState(r4)
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel r4 = r0.this$0
            androidx.lifecycle.y r4 = r4.getOnwardFlightList()
            r4.postValue(r2)
            if (r1 == 0) goto L_0x01af
            com.travel.flight.flightSRPV2.b.c r1 = new com.travel.flight.flightSRPV2.b.c
            r10 = 0
            int r11 = com.travel.flight.R.id.container_child
            r12 = 1
            java.lang.String r9 = "PAGE_NO_FLIGHTS_FOUND"
            java.lang.String r13 = "PAGE_NO_FLIGHTS_FOUND"
            r8 = r1
            r8.<init>(r9, r10, r11, r12, r13)
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel r2 = r0.this$0
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r2 = r2.getParentViewModel()
            com.travel.flight.flightSRPV2.b.d r1 = (com.travel.flight.flightSRPV2.b.d) r1
            r2.navigate(r1)
        L_0x01af:
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel r1 = r0.this$0
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r8 = r1.getParentViewModel()
            com.travel.flight.flightSRPV2.a.a r12 = new com.travel.flight.flightSRPV2.a.a
            java.util.List r1 = com.travel.flight.flightSRPV2.a.t.b((java.util.List<? extends com.travel.flight.flightSRPV2.a.x>) r3)
            r12.<init>(r1, r5)
            com.travel.flight.flightSRPV2.a.b r13 = new com.travel.flight.flightSRPV2.a.b
            if (r7 != 0) goto L_0x01c5
            kotlin.g.b.k.a()
        L_0x01c5:
            java.lang.String r1 = r7.b()
            r13.<init>(r1, r5)
            long r14 = r0.$startTime
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel r1 = r0.this$0
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r1 = r1.getParentViewModel()
            androidx.lifecycle.y r1 = r1.getSrpResult()
            java.lang.Object r1 = r1.getValue()
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r1 = (com.travel.flight.pojo.flightticket.CJRFlightSearchResult) r1
            if (r1 == 0) goto L_0x01f0
            com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation r1 = r1.getmOnwardReturnFlights()
            if (r1 == 0) goto L_0x01f0
            com.travel.flight.pojo.flightticket.CJROnwardFlights r1 = r1.getmOnwardFlights()
            if (r1 == 0) goto L_0x01f0
            java.util.ArrayList r5 = r1.getmFlightDetails()
        L_0x01f0:
            if (r5 != 0) goto L_0x01f5
            kotlin.g.b.k.a()
        L_0x01f5:
            int r16 = r5.size()
            java.lang.String r9 = "DRT"
            java.lang.String r10 = "FILTER"
            java.lang.String r11 = "ONWARD"
            r8.logProcessingEvent(r9, r10, r11, r12, r13, r14, r16)
            goto L_0x032b
        L_0x0204:
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel r7 = r0.this$0
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r7 = r7.getParentViewModel()
            androidx.lifecycle.y r7 = r7.getReturnFilterList()
            java.lang.Object r7 = r7.getValue()
            java.util.List r7 = (java.util.List) r7
            if (r7 != 0) goto L_0x021a
            kotlin.a.w r7 = kotlin.a.w.INSTANCE
            java.util.List r7 = (java.util.List) r7
        L_0x021a:
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel r8 = r0.this$0
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r8 = r8.getParentViewModel()
            androidx.lifecycle.y r8 = r8.getRoundTripReturnSortOption()
            java.lang.Object r8 = r8.getValue()
            com.travel.flight.flightSRPV2.a.ae r8 = (com.travel.flight.flightSRPV2.a.ae) r8
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel r9 = r0.this$0
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r9 = r9.getParentViewModel()
            androidx.lifecycle.y r9 = r9.getSrpResult()
            java.lang.Object r9 = r9.getValue()
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r9 = (com.travel.flight.pojo.flightticket.CJRFlightSearchResult) r9
            if (r9 == 0) goto L_0x024d
            com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation r9 = r9.getmOnwardReturnFlights()
            if (r9 == 0) goto L_0x024d
            com.travel.flight.pojo.flightticket.CJROnwardFlights r9 = r9.getmReturnFlights()
            if (r9 == 0) goto L_0x024d
            java.util.ArrayList r9 = r9.getmFlightDetails()
            goto L_0x024e
        L_0x024d:
            r9 = r5
        L_0x024e:
            if (r9 != 0) goto L_0x0253
            kotlin.g.b.k.a()
        L_0x0253:
            java.util.List r9 = (java.util.List) r9
            java.util.List r9 = com.travel.flight.flightSRPV2.a.t.a((java.util.List<? extends com.travel.flight.pojo.flightticket.CJRFlightDetailsItem>) r9, (java.util.List<? extends com.travel.flight.flightSRPV2.a.x>) r7, (com.travel.flight.flightSRPV2.a.ae) r8)
            r10 = r9
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            boolean r11 = r10 instanceof java.util.Collection
            if (r11 == 0) goto L_0x0269
            r11 = r10
            java.util.Collection r11 = (java.util.Collection) r11
            boolean r11 = r11.isEmpty()
            if (r11 != 0) goto L_0x0290
        L_0x0269:
            java.util.Iterator r10 = r10.iterator()
        L_0x026d:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x0290
            java.lang.Object r11 = r10.next()
            com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r11 = (com.travel.flight.pojo.flightticket.CJRFlightDetailsItem) r11
            java.lang.String r11 = r11.getmFlightId()
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            if (r11 == 0) goto L_0x028a
            boolean r11 = kotlin.m.p.a(r11)
            if (r11 == 0) goto L_0x0288
            goto L_0x028a
        L_0x0288:
            r11 = 0
            goto L_0x028b
        L_0x028a:
            r11 = 1
        L_0x028b:
            r11 = r11 ^ r6
            if (r11 == 0) goto L_0x026d
            r10 = 1
            goto L_0x0291
        L_0x0290:
            r10 = 0
        L_0x0291:
            r6 = r6 ^ r10
            kotlinx.coroutines.Job r10 = r0.$delayTask
            r0.L$0 = r2
            r0.L$1 = r7
            r0.L$2 = r8
            r0.L$3 = r9
            r0.I$0 = r6
            r0.label = r3
            java.lang.Object r2 = r10.join(r0)
            if (r2 != r1) goto L_0x02a7
            return r1
        L_0x02a7:
            r1 = r6
            r6 = r7
            r3 = r8
            r2 = r9
        L_0x02ab:
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel r7 = r0.this$0
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r7 = r7.getParentViewModel()
            r7.setProgressState(r4)
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel r4 = r0.this$0
            androidx.lifecycle.y r4 = r4.getReturnFlightList()
            r4.postValue(r2)
            if (r1 == 0) goto L_0x02d8
            com.travel.flight.flightSRPV2.b.c r1 = new com.travel.flight.flightSRPV2.b.c
            r9 = 0
            int r10 = com.travel.flight.R.id.container_child
            r11 = 1
            java.lang.String r8 = "PAGE_NO_FLIGHTS_FOUND"
            java.lang.String r12 = "PAGE_NO_FLIGHTS_FOUND"
            r7 = r1
            r7.<init>(r8, r9, r10, r11, r12)
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel r2 = r0.this$0
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r2 = r2.getParentViewModel()
            com.travel.flight.flightSRPV2.b.d r1 = (com.travel.flight.flightSRPV2.b.d) r1
            r2.navigate(r1)
        L_0x02d8:
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel r1 = r0.this$0
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r7 = r1.getParentViewModel()
            com.travel.flight.flightSRPV2.a.a r11 = new com.travel.flight.flightSRPV2.a.a
            java.util.List r1 = com.travel.flight.flightSRPV2.a.t.b((java.util.List<? extends com.travel.flight.flightSRPV2.a.x>) r6)
            r11.<init>(r5, r1)
            com.travel.flight.flightSRPV2.a.b r12 = new com.travel.flight.flightSRPV2.a.b
            if (r3 != 0) goto L_0x02ee
            kotlin.g.b.k.a()
        L_0x02ee:
            java.lang.String r1 = r3.b()
            r12.<init>(r5, r1)
            long r13 = r0.$startTime
            com.travel.flight.flightSRPV2.viewModel.DRTListViewModel r1 = r0.this$0
            com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel r1 = r1.getParentViewModel()
            androidx.lifecycle.y r1 = r1.getSrpResult()
            java.lang.Object r1 = r1.getValue()
            com.travel.flight.pojo.flightticket.CJRFlightSearchResult r1 = (com.travel.flight.pojo.flightticket.CJRFlightSearchResult) r1
            if (r1 == 0) goto L_0x0319
            com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation r1 = r1.getmOnwardReturnFlights()
            if (r1 == 0) goto L_0x0319
            com.travel.flight.pojo.flightticket.CJROnwardFlights r1 = r1.getmOnwardFlights()
            if (r1 == 0) goto L_0x0319
            java.util.ArrayList r5 = r1.getmFlightDetails()
        L_0x0319:
            if (r5 != 0) goto L_0x031e
            kotlin.g.b.k.a()
        L_0x031e:
            int r15 = r5.size()
            java.lang.String r8 = "DRT"
            java.lang.String r9 = "FILTER"
            java.lang.String r10 = "RETURN"
            r7.logProcessingEvent(r8, r9, r10, r11, r12, r13, r15)
        L_0x032b:
            kotlin.x r1 = kotlin.x.f47997a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightSRPV2.viewModel.DRTListViewModel$updateFlightList$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
