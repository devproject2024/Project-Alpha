package com.travel.flight.flightSRPV2.viewModel;

import com.paytm.network.b.g;
import com.travel.flight.R;
import com.travel.flight.flightSRPV2.a.ae;
import com.travel.flight.flightSRPV2.a.q;
import com.travel.flight.flightSRPV2.b.c;
import com.travel.flight.flightSRPV2.b.e;
import com.travel.flight.pojo.flightticket.CJRFlightSearchResult;
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

@f(b = "IRTViewModel.kt", c = {124}, d = "invokeSuspend", e = "com.travel.flight.flightSRPV2.viewModel.IRTViewModel$updateSRPCopy$1")
final class IRTViewModel$updateSRPCopy$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    final /* synthetic */ Job $delayTask;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ IRTViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IRTViewModel$updateSRPCopy$1(IRTViewModel iRTViewModel, Job job, d dVar) {
        super(2, dVar);
        this.this$0 = iRTViewModel;
        this.$delayTask = job;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        IRTViewModel$updateSRPCopy$1 iRTViewModel$updateSRPCopy$1 = new IRTViewModel$updateSRPCopy$1(this.this$0, this.$delayTask, dVar);
        iRTViewModel$updateSRPCopy$1.p$ = (CoroutineScope) obj;
        return iRTViewModel$updateSRPCopy$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((IRTViewModel$updateSRPCopy$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        boolean z;
        a aVar = a.COROUTINE_SUSPENDED;
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.a(obj);
            CoroutineScope coroutineScope = this.p$;
            this.this$0.getParentViewModel().setProgressState(2);
            CJRFlightSearchResult value = this.this$0.getParentViewModel().getSrpResult().getValue();
            if (value == null) {
                kotlin.g.b.k.a();
            }
            kotlin.g.b.k.a((Object) value, "parentViewModel.srpResult.value!!");
            String str2 = value.getNetworkResponse().headers.get("Content-Encoding");
            CharSequence charSequence = str2;
            if ((charSequence == null || charSequence.length() == 0) || !kotlin.g.b.k.a((Object) str2, (Object) "gzip")) {
                CJRFlightSearchResult value2 = this.this$0.getParentViewModel().getSrpResult().getValue();
                if (value2 == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) value2, "parentViewModel.srpResult.value!!");
                byte[] bArr = value2.getNetworkResponse().data;
                kotlin.g.b.k.a((Object) bArr, "parentViewModel.srpResul…ue!!.networkResponse.data");
                str = new String(bArr, kotlin.m.d.f47971a);
            } else {
                CJRFlightSearchResult value3 = this.this$0.getParentViewModel().getSrpResult().getValue();
                if (value3 == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) value3, "parentViewModel.srpResult.value!!");
                str = g.a(g.a(value3.getNetworkResponse().data));
                kotlin.g.b.k.a((Object) str, "GzipUtils.convertString(…!!.networkResponse.data))");
            }
            CJRFlightSearchResult cJRFlightSearchResult = (CJRFlightSearchResult) new com.google.gsonhtcfix.f().a(str, CJRFlightSearchResult.class);
            ae value4 = this.this$0.getParentViewModel().getIrtSortOption().getValue();
            if (value4 == null) {
                value4 = new q((byte) 0);
            }
            cJRFlightSearchResult.setmInternationalFlightList(value4);
            List<CJRIntlFlightMapping> list = cJRFlightSearchResult.getmOnwardReturnFlights().getmMapping();
            kotlin.g.b.k.a((Object) list, "model.getmOnwardReturnFlights().getmMapping()");
            List<CJRIntlFlightMapping> a2 = kotlin.a.k.a(list, value4.d());
            Iterable iterable = a2;
            if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                Iterator it2 = iterable.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    CharSequence flightId = ((CJRIntlFlightMapping) it2.next()).getFlightId();
                    if (!(flightId == null || p.a(flightId))) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            boolean z2 = !z;
            CJROnwardReturnFlightInformation cJROnwardReturnFlightInformation = cJRFlightSearchResult.getmOnwardReturnFlights();
            kotlin.g.b.k.a((Object) cJROnwardReturnFlightInformation, "model.getmOnwardReturnFlights()");
            cJROnwardReturnFlightInformation.setmMapping(a2);
            kotlin.g.b.k.a((Object) cJRFlightSearchResult, "model");
            cJRFlightSearchResult.setmOnwardReturnFlights(cJROnwardReturnFlightInformation);
            cJRFlightSearchResult.setmInternationalFlightList(value4);
            this.this$0.getParentViewModel().getCopiedSrpResult().postValue(cJRFlightSearchResult);
            Collection collection = cJRFlightSearchResult.getmInternationalFlightList();
            if (collection == null || collection.isEmpty()) {
                z2 = true;
            }
            this.this$0.getIntlFlightList().postValue(cJRFlightSearchResult.getmInternationalFlightList());
            if (z2) {
                this.this$0.getParentViewModel().navigate(new c("PAGE_NO_FLIGHTS_FOUND", (e) null, R.id.container_child, true, "PAGE_NO_FLIGHTS_FOUND"));
            }
            Job job = this.$delayTask;
            this.L$0 = coroutineScope;
            this.L$1 = str2;
            this.L$2 = str;
            this.L$3 = cJRFlightSearchResult;
            this.L$4 = value4;
            this.L$5 = a2;
            this.L$6 = cJROnwardReturnFlightInformation;
            this.L$7 = cJRFlightSearchResult;
            this.label = 1;
            if (job.join(this) == aVar) {
                return aVar;
            }
        } else if (i2 == 1) {
            ResultKt.a(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.getParentViewModel().setProgressState(0);
        return x.f47997a;
    }
}
