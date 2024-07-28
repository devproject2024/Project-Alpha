package com.travel.flight.flightSRPV2.viewModel;

import androidx.lifecycle.y;
import com.travel.flight.flightSRPV2.a.ad;
import com.travel.flight.flightSRPV2.a.t;
import com.travel.flight.pojo.flightticket.CJRFlightSearchResult;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.m.p;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;

@f(b = "SRPSharedViewModel.kt", c = {}, d = "invokeSuspend", e = "com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel$handleSecondarySRPResult$1")
final class SRPSharedViewModel$handleSecondarySRPResult$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    final /* synthetic */ CJRFlightSearchResult $secondarySrpResult;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ SRPSharedViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SRPSharedViewModel$handleSecondarySRPResult$1(SRPSharedViewModel sRPSharedViewModel, CJRFlightSearchResult cJRFlightSearchResult, d dVar) {
        super(2, dVar);
        this.this$0 = sRPSharedViewModel;
        this.$secondarySrpResult = cJRFlightSearchResult;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        SRPSharedViewModel$handleSecondarySRPResult$1 sRPSharedViewModel$handleSecondarySRPResult$1 = new SRPSharedViewModel$handleSecondarySRPResult$1(this.this$0, this.$secondarySrpResult, dVar);
        sRPSharedViewModel$handleSecondarySRPResult$1.p$ = (CoroutineScope) obj;
        return sRPSharedViewModel$handleSecondarySRPResult$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((SRPSharedViewModel$handleSecondarySRPResult$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.a(obj);
            String a2 = t.a(this.this$0.getSrpResult().getValue(), this.$secondarySrpResult);
            CharSequence charSequence = a2;
            if (!(charSequence == null || p.a(charSequence))) {
                y<ad> secondarySrpResult = this.this$0.getSecondarySrpResult();
                CJRFlightSearchResult cJRFlightSearchResult = this.$secondarySrpResult;
                if (cJRFlightSearchResult == null) {
                    kotlin.g.b.k.a();
                }
                secondarySrpResult.postValue(new ad(a2, cJRFlightSearchResult));
            }
            return x.f47997a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
