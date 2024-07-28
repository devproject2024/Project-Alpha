package com.paytmmall.clpartifact.utils;

import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import com.paytmmall.clpartifact.network.Resource;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;

@f(b = "HomeUtils.kt", c = {175}, d = "invokeSuspend", e = "com/paytmmall/clpartifact/utils/HomeUtils$getSanitizedResponse$2")
final class HomeUtils$getSanitizedResponse$2 extends k implements m<CoroutineScope, d<? super SanitizedResponseModel>, Object> {
    final /* synthetic */ Resource $response;
    int label;
    private CoroutineScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeUtils$getSanitizedResponse$2(Resource resource, d dVar) {
        super(2, dVar);
        this.$response = resource;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        HomeUtils$getSanitizedResponse$2 homeUtils$getSanitizedResponse$2 = new HomeUtils$getSanitizedResponse$2(this.$response, dVar);
        homeUtils$getSanitizedResponse$2.p$ = (CoroutineScope) obj;
        return homeUtils$getSanitizedResponse$2;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((HomeUtils$getSanitizedResponse$2) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x002e, code lost:
        r0 = r0.getContext();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            kotlin.d.a.a r0 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r0 = r10.label
            if (r0 != 0) goto L_0x004b
            boolean r0 = r11 instanceof kotlin.p.b
            if (r0 != 0) goto L_0x0046
            com.paytmmall.clpartifact.utils.HomeUtils r11 = com.paytmmall.clpartifact.utils.HomeUtils.INSTANCE
            com.paytmmall.clpartifact.network.Resource r0 = r10.$response
            kotlin.o r11 = r11.runSanitisation(r0)
            java.lang.Object r0 = r11.component1()
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            java.lang.Object r11 = r11.component2()
            r3 = r11
            java.util.LinkedHashMap r3 = (java.util.LinkedHashMap) r3
            com.paytmmall.clpartifact.modal.SanitizedResponseModel r11 = new com.paytmmall.clpartifact.modal.SanitizedResponseModel
            r2 = r0
            java.util.List r2 = (java.util.List) r2
            com.paytmmall.clpartifact.network.Resource r0 = r10.$response
            java.lang.Object r0 = r0.getData()
            com.paytmmall.clpartifact.view.viewmodel.HomeResponse r0 = (com.paytmmall.clpartifact.view.viewmodel.HomeResponse) r0
            if (r0 == 0) goto L_0x0039
            com.paytmmall.clpartifact.view.viewmodel.UserContext r0 = r0.getContext()
            if (r0 == 0) goto L_0x0039
            java.lang.String r0 = r0.getMrequestid()
            goto L_0x003a
        L_0x0039:
            r0 = 0
        L_0x003a:
            r4 = r0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 56
            r9 = 0
            r1 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            return r11
        L_0x0046:
            kotlin.p$b r11 = (kotlin.p.b) r11
            java.lang.Throwable r11 = r11.exception
            throw r11
        L_0x004b:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.utils.HomeUtils$getSanitizedResponse$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
