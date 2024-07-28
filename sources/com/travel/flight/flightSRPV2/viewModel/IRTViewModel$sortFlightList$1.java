package com.travel.flight.flightSRPV2.viewModel;

import androidx.lifecycle.y;
import com.travel.flight.R;
import com.travel.flight.flightSRPV2.a.ae;
import com.travel.flight.flightSRPV2.a.b;
import com.travel.flight.flightSRPV2.a.q;
import com.travel.flight.flightSRPV2.a.t;
import com.travel.flight.flightSRPV2.b.c;
import com.travel.flight.flightSRPV2.b.e;
import com.travel.flight.pojo.flightticket.CJRFlightSearchResult;
import com.travel.flight.pojo.flightticket.CJRIntlFlightList;
import com.travel.flight.pojo.flightticket.CJRIntlFlightMapping;
import com.travel.flight.pojo.flightticket.CJROnwardReturnFlightInformation;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.m.p;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

@f(b = "IRTViewModel.kt", c = {201}, d = "invokeSuspend", e = "com.travel.flight.flightSRPV2.viewModel.IRTViewModel$sortFlightList$1")
final class IRTViewModel$sortFlightList$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    final /* synthetic */ Job $delayTask;
    final /* synthetic */ long $startTime;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ IRTViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IRTViewModel$sortFlightList$1(IRTViewModel iRTViewModel, Job job, long j, d dVar) {
        super(2, dVar);
        this.this$0 = iRTViewModel;
        this.$delayTask = job;
        this.$startTime = j;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        IRTViewModel$sortFlightList$1 iRTViewModel$sortFlightList$1 = new IRTViewModel$sortFlightList$1(this.this$0, this.$delayTask, this.$startTime, dVar);
        iRTViewModel$sortFlightList$1.p$ = (CoroutineScope) obj;
        return iRTViewModel$sortFlightList$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((IRTViewModel$sortFlightList$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        ae aeVar;
        List<CJRIntlFlightMapping> list;
        int i2;
        int i3;
        a aVar = a.COROUTINE_SUSPENDED;
        int i4 = this.label;
        boolean z = false;
        if (i4 == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = this.p$;
            this.this$0.getParentViewModel().setProgressState(2);
            ae value = this.this$0.getParentViewModel().getIrtSortOption().getValue();
            if (value == null) {
                value = new q((byte) 0);
            }
            aeVar = value;
            CJRFlightSearchResult value2 = this.this$0.getParentViewModel().getCopiedSrpResult().getValue();
            if (value2 == null) {
                kotlin.g.b.k.a();
            }
            List<CJRIntlFlightMapping> list2 = value2.getmOnwardReturnFlights().getmMapping();
            kotlin.g.b.k.a((Object) list2, "parentViewModel.copiedSr…rnFlights().getmMapping()");
            list = kotlin.a.k.a(list2, aeVar.d());
            Iterable iterable = list;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                Iterator it2 = iterable.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    CharSequence flightId = ((CJRIntlFlightMapping) it2.next()).getFlightId();
                    if (!(flightId == null || p.a(flightId))) {
                        i3 = 1;
                        break;
                    }
                }
            }
            i3 = 0;
            int i5 = i3 ^ 1;
            Job job = this.$delayTask;
            this.L$0 = coroutineScope;
            this.L$1 = aeVar;
            this.L$2 = list;
            this.I$0 = i5;
            this.label = 1;
            if (job.join(this) == aVar) {
                return aVar;
            }
            i2 = i5;
        } else if (i4 == 1) {
            i2 = this.I$0;
            list = (List) this.L$2;
            aeVar = (ae) this.L$1;
            ResultKt.a(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.getParentViewModel().setProgressState(0);
        CJRFlightSearchResult value3 = this.this$0.getParentViewModel().getCopiedSrpResult().getValue();
        if (value3 == null) {
            kotlin.g.b.k.a();
        }
        CJROnwardReturnFlightInformation cJROnwardReturnFlightInformation = value3.getmOnwardReturnFlights();
        kotlin.g.b.k.a((Object) cJROnwardReturnFlightInformation, "parentViewModel.copiedSr…getmOnwardReturnFlights()");
        cJROnwardReturnFlightInformation.setmMapping(list);
        CJRFlightSearchResult value4 = this.this$0.getParentViewModel().getCopiedSrpResult().getValue();
        if (value4 == null) {
            kotlin.g.b.k.a();
        }
        CJRFlightSearchResult cJRFlightSearchResult = value4;
        cJRFlightSearchResult.setmOnwardReturnFlights(cJROnwardReturnFlightInformation);
        cJRFlightSearchResult.setmInternationalFlightList(aeVar);
        this.this$0.getParentViewModel().getCopiedSrpResult().postValue(cJRFlightSearchResult);
        CJRFlightSearchResult value5 = this.this$0.getParentViewModel().getCopiedSrpResult().getValue();
        if (value5 == null) {
            kotlin.g.b.k.a();
        }
        Collection collection = value5.getmInternationalFlightList();
        if (collection == null || collection.isEmpty()) {
            z = true;
        }
        if (z) {
            i2 = 1;
        }
        y<List<CJRIntlFlightList>> intlFlightList = this.this$0.getIntlFlightList();
        CJRFlightSearchResult value6 = this.this$0.getParentViewModel().getCopiedSrpResult().getValue();
        if (value6 == null) {
            kotlin.g.b.k.a();
        }
        intlFlightList.postValue(value6.getmInternationalFlightList());
        if (i2 != 0) {
            this.this$0.getParentViewModel().navigate(new c("PAGE_NO_FLIGHTS_FOUND", (e) null, R.id.container_child, true, "PAGE_NO_FLIGHTS_FOUND"));
        }
        SRPSharedViewModel parentViewModel = this.this$0.getParentViewModel();
        String b2 = t.b(aeVar);
        com.travel.flight.flightSRPV2.a.a aVar2 = new com.travel.flight.flightSRPV2.a.a((List<String>) null, (List<String>) null);
        b a2 = t.a(aeVar);
        long j = this.$startTime;
        CJRFlightSearchResult value7 = this.this$0.getParentViewModel().getCopiedSrpResult().getValue();
        if (value7 == null) {
            kotlin.g.b.k.a();
        }
        List<CJRIntlFlightMapping> list3 = value7.getmOnwardReturnFlights().getmMapping();
        if (list3 == null) {
            kotlin.g.b.k.a();
        }
        parentViewModel.logProcessingEvent("IRT", "SORT", b2, aVar2, a2, j, list3.size());
        return x.f47997a;
    }
}
