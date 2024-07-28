package com.paytmmall.clpartifact.view.viewmodel;

import com.paytmmall.clpartifact.modal.clpCommon.View;
import java.util.ArrayList;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;

@f(b = "SFBrowseCategoryVM.kt", c = {86}, d = "invokeSuspend", e = "com/paytmmall/clpartifact/view/viewmodel/SFBrowseCategoryVM$sanitizeResponse$2")
final class SFBrowseCategoryVM$sanitizeResponse$2 extends k implements m<CoroutineScope, d<? super ArrayList<View>>, Object> {
    final /* synthetic */ HomeResponse $data;
    int label;
    private CoroutineScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SFBrowseCategoryVM$sanitizeResponse$2(HomeResponse homeResponse, d dVar) {
        super(2, dVar);
        this.$data = homeResponse;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        SFBrowseCategoryVM$sanitizeResponse$2 sFBrowseCategoryVM$sanitizeResponse$2 = new SFBrowseCategoryVM$sanitizeResponse$2(this.$data, dVar);
        sFBrowseCategoryVM$sanitizeResponse$2.p$ = (CoroutineScope) obj;
        return sFBrowseCategoryVM$sanitizeResponse$2;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((SFBrowseCategoryVM$sanitizeResponse$2) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        r0 = r0.getPage();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            kotlin.d.a.a r0 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r0 = r12.label
            if (r0 != 0) goto L_0x0147
            boolean r0 = r13 instanceof kotlin.p.b
            if (r0 != 0) goto L_0x0142
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            com.paytmmall.clpartifact.view.viewmodel.HomeResponse r0 = r12.$data
            r1 = 0
            if (r0 == 0) goto L_0x001f
            java.util.List r0 = r0.getPage()
            if (r0 == 0) goto L_0x001f
            int r0 = r0.size()
            goto L_0x0020
        L_0x001f:
            r0 = 0
        L_0x0020:
            r2 = 0
        L_0x0021:
            if (r2 >= r0) goto L_0x0141
            com.paytmmall.clpartifact.view.viewmodel.HomeResponse r3 = r12.$data
            r4 = 0
            if (r3 == 0) goto L_0x003b
            java.util.List r3 = r3.getPage()
            if (r3 == 0) goto L_0x003b
            java.lang.Object r3 = r3.get(r2)
            com.paytmmall.clpartifact.modal.clpCommon.Page r3 = (com.paytmmall.clpartifact.modal.clpCommon.Page) r3
            if (r3 == 0) goto L_0x003b
            java.util.List r3 = r3.getViews()
            goto L_0x003c
        L_0x003b:
            r3 = r4
        L_0x003c:
            if (r3 == 0) goto L_0x0043
            int r5 = r3.size()
            goto L_0x0044
        L_0x0043:
            r5 = 0
        L_0x0044:
            r6 = 0
        L_0x0045:
            if (r6 >= r5) goto L_0x013d
            if (r3 == 0) goto L_0x0139
            java.lang.Object r7 = r3.get(r6)
            com.paytmmall.clpartifact.modal.clpCommon.View r7 = (com.paytmmall.clpartifact.modal.clpCommon.View) r7
            if (r7 == 0) goto L_0x0139
            java.lang.Object r7 = r3.get(r6)
            com.paytmmall.clpartifact.modal.clpCommon.View r7 = (com.paytmmall.clpartifact.modal.clpCommon.View) r7
            if (r7 == 0) goto L_0x0064
            java.util.List r7 = r7.getItems()
            if (r7 == 0) goto L_0x0064
            int r7 = r7.size()
            goto L_0x0065
        L_0x0064:
            r7 = 0
        L_0x0065:
            r8 = 1
            if (r7 <= 0) goto L_0x006a
            r7 = 1
            goto L_0x006b
        L_0x006a:
            r7 = 0
        L_0x006b:
            if (r7 == 0) goto L_0x0139
            java.lang.Object r7 = r3.get(r6)
            com.paytmmall.clpartifact.modal.clpCommon.View r7 = (com.paytmmall.clpartifact.modal.clpCommon.View) r7
            if (r7 == 0) goto L_0x007a
            java.lang.String r7 = r7.getType()
            goto L_0x007b
        L_0x007a:
            r7 = r4
        L_0x007b:
            java.lang.String r9 = "recents-list"
            boolean r7 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r9, (boolean) r1)
            java.lang.String r9 = "viewList[j]"
            if (r7 == 0) goto L_0x00bd
            com.paytmmall.clpartifact.utils.RecentsManager r7 = com.paytmmall.clpartifact.utils.RecentsManager.INSTANCE
            java.lang.Object r10 = r3.get(r6)
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r9)
            com.paytmmall.clpartifact.modal.clpCommon.View r10 = (com.paytmmall.clpartifact.modal.clpCommon.View) r10
            java.util.List r7 = r7.getFilteredRecents(r10)
            r10 = r7
            java.util.Collection r10 = (java.util.Collection) r10
            boolean r10 = r10.isEmpty()
            r8 = r8 ^ r10
            if (r8 == 0) goto L_0x0139
            java.lang.Object r8 = r3.get(r6)
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            com.paytmmall.clpartifact.modal.clpCommon.View r8 = (com.paytmmall.clpartifact.modal.clpCommon.View) r8
            r8.setItems(r7)
            java.lang.Object r7 = r3.get(r6)
            com.paytmmall.clpartifact.modal.clpCommon.View r7 = (com.paytmmall.clpartifact.modal.clpCommon.View) r7
            r7.setItemData()
            java.lang.Object r7 = r3.get(r6)
            r13.add(r7)
            goto L_0x0139
        L_0x00bd:
            java.lang.Object r7 = r3.get(r6)
            r13.add(r7)
            java.lang.Object r7 = r3.get(r6)
            com.paytmmall.clpartifact.modal.clpCommon.View r7 = (com.paytmmall.clpartifact.modal.clpCommon.View) r7
            if (r7 == 0) goto L_0x00d2
            java.util.List r7 = r7.getItems()
            if (r7 != 0) goto L_0x00d9
        L_0x00d2:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.List r7 = (java.util.List) r7
        L_0x00d9:
            java.util.Iterator r7 = r7.iterator()
        L_0x00dd:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0139
            java.lang.Object r8 = r7.next()
            com.paytmmall.clpartifact.modal.clpCommon.Item r8 = (com.paytmmall.clpartifact.modal.clpCommon.Item) r8
            java.lang.String r10 = "item"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r10)
            java.lang.Object r10 = r3.get(r6)
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r9)
            com.paytmmall.clpartifact.modal.clpCommon.View r10 = (com.paytmmall.clpartifact.modal.clpCommon.View) r10
            java.lang.Long r10 = r10.getId()
            long r10 = r10.longValue()
            java.lang.String r10 = java.lang.String.valueOf(r10)
            r8.setParentId(r10)
            java.lang.String r10 = "/-category-icons"
            r8.setPromoName(r10)
            java.lang.Object r10 = r3.get(r6)
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r9)
            com.paytmmall.clpartifact.modal.clpCommon.View r10 = (com.paytmmall.clpartifact.modal.clpCommon.View) r10
            java.util.ArrayList r10 = r10.getDataSources()
            if (r10 == 0) goto L_0x012a
            java.util.List r10 = (java.util.List) r10
            java.lang.Object r10 = kotlin.a.k.a(r10, (int) r1)
            com.paytmmall.clpartifact.modal.clpCommon.ViewDataSource r10 = (com.paytmmall.clpartifact.modal.clpCommon.ViewDataSource) r10
            if (r10 == 0) goto L_0x012a
            java.lang.String r10 = r10.getContainerInstanceId()
            if (r10 != 0) goto L_0x012c
        L_0x012a:
            java.lang.String r10 = ""
        L_0x012c:
            r8.setContainerinstatnceid(r10)
            java.lang.Object r8 = r3.get(r6)
            com.paytmmall.clpartifact.modal.clpCommon.View r8 = (com.paytmmall.clpartifact.modal.clpCommon.View) r8
            r8.setItemData()
            goto L_0x00dd
        L_0x0139:
            int r6 = r6 + 1
            goto L_0x0045
        L_0x013d:
            int r2 = r2 + 1
            goto L_0x0021
        L_0x0141:
            return r13
        L_0x0142:
            kotlin.p$b r13 = (kotlin.p.b) r13
            java.lang.Throwable r13 = r13.exception
            throw r13
        L_0x0147:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.view.viewmodel.SFBrowseCategoryVM$sanitizeResponse$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
