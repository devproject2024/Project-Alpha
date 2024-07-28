package com.paytmmall.clpartifact.view.viewmodel;

import androidx.lifecycle.w;
import com.paytmmall.clpartifact.network.Resource;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.x;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;

@f(b = "SFBrowseCategoryVM.kt", c = {62, 65}, d = "invokeSuspend", e = "com/paytmmall/clpartifact/view/viewmodel/SFBrowseCategoryVM$handleSuccesResponse$1")
final class SFBrowseCategoryVM$handleSuccesResponse$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    final /* synthetic */ HomeResponse $data;
    final /* synthetic */ w $liveData;
    final /* synthetic */ Resource $response;
    final /* synthetic */ x.e $sanitizedList;
    Object L$0;
    Object L$1;
    int label;
    private CoroutineScope p$;
    final /* synthetic */ SFBrowseCategoryVM this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SFBrowseCategoryVM$handleSuccesResponse$1(SFBrowseCategoryVM sFBrowseCategoryVM, HomeResponse homeResponse, x.e eVar, Resource resource, w wVar, d dVar) {
        super(2, dVar);
        this.this$0 = sFBrowseCategoryVM;
        this.$data = homeResponse;
        this.$sanitizedList = eVar;
        this.$response = resource;
        this.$liveData = wVar;
    }

    public final d<kotlin.x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        SFBrowseCategoryVM$handleSuccesResponse$1 sFBrowseCategoryVM$handleSuccesResponse$1 = new SFBrowseCategoryVM$handleSuccesResponse$1(this.this$0, this.$data, this.$sanitizedList, this.$response, this.$liveData, dVar);
        sFBrowseCategoryVM$handleSuccesResponse$1.p$ = (CoroutineScope) obj;
        return sFBrowseCategoryVM$handleSuccesResponse$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((SFBrowseCategoryVM$handleSuccesResponse$1) create(obj, (d) obj2)).invokeSuspend(kotlin.x.f47997a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ab  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(T r8) {
        /*
            r7 = this;
            kotlin.d.a.a r0 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r1 = r7.label
            r2 = 1
            if (r1 == 0) goto L_0x001f
            if (r1 != r2) goto L_0x0017
            java.lang.Object r0 = r7.L$1
            kotlin.g.b.x$e r0 = (kotlin.g.b.x.e) r0
            boolean r1 = r8 instanceof kotlin.p.b
            if (r1 != 0) goto L_0x0012
            goto L_0x004c
        L_0x0012:
            kotlin.p$b r8 = (kotlin.p.b) r8
            java.lang.Throwable r8 = r8.exception
            throw r8
        L_0x0017:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x001f:
            boolean r1 = r8 instanceof kotlin.p.b
            if (r1 != 0) goto L_0x00b7
            com.paytmmall.clpartifact.view.viewmodel.HomeResponse r8 = r7.$data
            if (r8 == 0) goto L_0x0050
            kotlin.g.b.x$e r1 = r7.$sanitizedList
            com.paytmmall.clpartifact.view.viewmodel.SFBrowseCategoryVM r3 = r7.this$0
            com.paytmmall.clpartifact.network.Resource r4 = r7.$response
            java.lang.Object r4 = r4.getData()
            com.paytmmall.clpartifact.view.viewmodel.HomeResponse r4 = (com.paytmmall.clpartifact.view.viewmodel.HomeResponse) r4
            com.paytmmall.clpartifact.view.viewmodel.SFBrowseCategoryVM r5 = r7.this$0
            android.content.Context r5 = r5.context
            java.lang.String r6 = "context"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            r7.L$0 = r8
            r7.L$1 = r1
            r7.label = r2
            java.lang.Object r8 = r3.sanitizeResponse(r4, r5, r7)
            if (r8 != r0) goto L_0x004b
            return r0
        L_0x004b:
            r0 = r1
        L_0x004c:
            java.util.List r8 = (java.util.List) r8
            r0.element = r8
        L_0x0050:
            kotlin.g.b.x$e r8 = r7.$sanitizedList
            T r8 = r8.element
            java.util.List r8 = (java.util.List) r8
            java.util.Collection r8 = (java.util.Collection) r8
            boolean r8 = r8.isEmpty()
            r8 = r8 ^ r2
            if (r8 == 0) goto L_0x00ab
            com.paytmmall.clpartifact.network.Resource r8 = r7.$response
            com.paytmmall.clpartifact.network.RequestType r8 = r8.getRequestType()
            if (r8 != 0) goto L_0x0068
            goto L_0x0082
        L_0x0068:
            int[] r0 = com.paytmmall.clpartifact.view.viewmodel.SFBrowseCategoryVM.WhenMappings.$EnumSwitchMapping$0
            int r8 = r8.ordinal()
            r8 = r0[r8]
            if (r8 == r2) goto L_0x007d
            r0 = 2
            if (r8 == r0) goto L_0x0076
            goto L_0x0082
        L_0x0076:
            com.paytmmall.clpartifact.view.viewmodel.SFBrowseCategoryVM r8 = r7.this$0
            r0 = 0
            r8.setFromCache(r0)
            goto L_0x0082
        L_0x007d:
            com.paytmmall.clpartifact.view.viewmodel.SFBrowseCategoryVM r8 = r7.this$0
            r8.setFromCache(r2)
        L_0x0082:
            androidx.lifecycle.w r8 = r7.$liveData
            com.paytmmall.clpartifact.network.Resource$Builder r0 = new com.paytmmall.clpartifact.network.Resource$Builder
            r0.<init>()
            com.paytmmall.clpartifact.network.Resource r1 = r7.$response
            com.paytmmall.clpartifact.network.RequestType r1 = r1.getRequestType()
            com.paytmmall.clpartifact.network.Resource$Builder r0 = r0.requestType(r1)
            com.paytmmall.clpartifact.network.Status r1 = com.paytmmall.clpartifact.network.Status.SUCCESS
            com.paytmmall.clpartifact.network.Resource$Builder r0 = r0.status(r1)
            kotlin.g.b.x$e r1 = r7.$sanitizedList
            T r1 = r1.element
            java.util.List r1 = (java.util.List) r1
            com.paytmmall.clpartifact.network.Resource$Builder r0 = r0.body(r1)
            com.paytmmall.clpartifact.network.Resource r0 = r0.build()
            r8.setValue(r0)
            goto L_0x00b4
        L_0x00ab:
            com.paytmmall.clpartifact.view.viewmodel.SFBrowseCategoryVM r8 = r7.this$0
            androidx.lifecycle.w r0 = r7.$liveData
            com.paytmmall.clpartifact.network.Resource r1 = r7.$response
            r8.handleErrorResponse(r0, r1)
        L_0x00b4:
            kotlin.x r8 = kotlin.x.f47997a
            return r8
        L_0x00b7:
            kotlin.p$b r8 = (kotlin.p.b) r8
            java.lang.Throwable r8 = r8.exception
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.view.viewmodel.SFBrowseCategoryVM$handleSuccesResponse$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
