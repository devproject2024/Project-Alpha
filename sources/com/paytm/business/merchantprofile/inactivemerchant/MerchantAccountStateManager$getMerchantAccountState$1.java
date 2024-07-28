package com.paytm.business.merchantprofile.inactivemerchant;

import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;

@f(b = "MerchantAccountStateManager.kt", c = {41, 43, 62}, d = "invokeSuspend", e = "com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager$getMerchantAccountState$1")
public final class MerchantAccountStateManager$getMerchantAccountState$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    public final /* synthetic */ Boolean $poll;
    public final /* synthetic */ long $pollTime;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public CoroutineScope p$;
    public final /* synthetic */ MerchantAccountStateManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MerchantAccountStateManager$getMerchantAccountState$1(MerchantAccountStateManager merchantAccountStateManager, Boolean bool, long j, d dVar) {
        super(2, dVar);
        this.this$0 = merchantAccountStateManager;
        this.$poll = bool;
        this.$pollTime = j;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.d(dVar, "completion");
        MerchantAccountStateManager$getMerchantAccountState$1 merchantAccountStateManager$getMerchantAccountState$1 = new MerchantAccountStateManager$getMerchantAccountState$1(this.this$0, this.$poll, this.$pollTime, dVar);
        merchantAccountStateManager$getMerchantAccountState$1.p$ = (CoroutineScope) obj;
        return merchantAccountStateManager$getMerchantAccountState$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((MerchantAccountStateManager$getMerchantAccountState$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b1, code lost:
        if (r11.equals(com.paytm.business.merchantprofile.inactivemerchant.ReactivationStatusNetwork.LEAD_CLOSED) != false) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ba, code lost:
        if (r11.equals(com.paytm.business.merchantprofile.inactivemerchant.ReactivationStatusNetwork.MERCHANT_REACTIVATION_SUCCESS) != false) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00bc, code lost:
        r10.this$0.getInactiveMerchantData().getAccountState().setValue(com.paytm.business.merchantprofile.inactivemerchant.MerchantReactivationSuccess.INSTANCE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ec, code lost:
        if (r11.equals(com.paytm.business.merchantprofile.inactivemerchant.ReactivationStatusNetwork.AWAITING_CLOSE) != false) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0115, code lost:
        r0 = (com.paytm.business.merchantprofile.inactivemerchant.ReactivationEligibility) r0.getResults();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01a2, code lost:
        if (r11.equals(com.paytm.business.merchantprofile.inactivemerchant.ReactivationStatusNetwork.LEAD_CREATED) != false) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01a4, code lost:
        r10.this$0.getInactiveMerchantData().getUiState().setValue(new com.paytm.business.merchantprofile.inactivemerchant.Success((java.lang.Object) null, 1, (kotlin.g.b.g) null));
        r10.this$0.getInactiveMerchantData().getAccountState().setValue(com.paytm.business.merchantprofile.inactivemerchant.ReActivationInProgress.INSTANCE);
        r10.this$0.isAccountReactivationPending(java.lang.Boolean.TRUE);
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01ef  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x022e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(T r11) {
        /*
            r10 = this;
            kotlin.d.a.a r0 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r1 = r10.label
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L_0x0039
            if (r1 == r4) goto L_0x0029
            if (r1 == r3) goto L_0x001d
            if (r1 != r2) goto L_0x0015
            kotlin.ResultKt.a((java.lang.Object) r11)
            goto L_0x0107
        L_0x0015:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x001d:
            java.lang.Object r1 = r10.L$1
            kotlin.g.b.x$e r1 = (kotlin.g.b.x.e) r1
            java.lang.Object r3 = r10.L$0
            kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
            kotlin.ResultKt.a((java.lang.Object) r11)
            goto L_0x008a
        L_0x0029:
            java.lang.Object r1 = r10.L$2
            kotlin.g.b.x$e r1 = (kotlin.g.b.x.e) r1
            java.lang.Object r6 = r10.L$1
            kotlin.g.b.x$e r6 = (kotlin.g.b.x.e) r6
            java.lang.Object r7 = r10.L$0
            kotlinx.coroutines.CoroutineScope r7 = (kotlinx.coroutines.CoroutineScope) r7
            kotlin.ResultKt.a((java.lang.Object) r11)
            goto L_0x0066
        L_0x0039:
            kotlin.ResultKt.a((java.lang.Object) r11)
            kotlinx.coroutines.CoroutineScope r11 = r10.p$
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager r1 = r10.this$0
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountState r1 = r1.getInactiveMerchantData()
            androidx.lifecycle.y r1 = r1.getUiState()
            com.paytm.business.merchantprofile.inactivemerchant.ActivationStatusCheckInProgress r6 = com.paytm.business.merchantprofile.inactivemerchant.ActivationStatusCheckInProgress.INSTANCE
            r1.setValue(r6)
            kotlin.g.b.x$e r1 = new kotlin.g.b.x$e
            r1.<init>()
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager r6 = r10.this$0
            r10.L$0 = r11
            r10.L$1 = r1
            r10.L$2 = r1
            r10.label = r4
            java.lang.Object r6 = r6.getReactivationStatus(r10)
            if (r6 != r0) goto L_0x0063
            return r0
        L_0x0063:
            r7 = r11
            r11 = r6
            r6 = r1
        L_0x0066:
            com.business.common_module.utilities.a.b r11 = (com.business.common_module.utilities.a.b) r11
            r1.element = r11
            java.lang.Boolean r11 = r10.$poll
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            boolean r11 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r1)
            if (r11 == 0) goto L_0x0088
            long r8 = r10.$pollTime
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager$getMerchantAccountState$1$1 r11 = new com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager$getMerchantAccountState$1$1
            r11.<init>(r10, r6, r5)
            r10.L$0 = r7
            r10.L$1 = r6
            r10.label = r3
            java.lang.Object r11 = kotlinx.coroutines.TimeoutKt.withTimeoutOrNull(r8, r11, r10)
            if (r11 != r0) goto L_0x0088
            return r0
        L_0x0088:
            r1 = r6
            r3 = r7
        L_0x008a:
            T r11 = r1.element
            com.business.common_module.utilities.a.b r11 = (com.business.common_module.utilities.a.b) r11
            com.business.common_module.utilities.a.e r6 = r11.f7357b
            com.business.common_module.utilities.a.e r7 = com.business.common_module.utilities.a.e.SUCCESS
            if (r6 != r7) goto L_0x01ef
            T r11 = r11.f7358c
            com.paytm.business.merchantprofile.inactivemerchant.ReactivationStatusNetworkResponse r11 = (com.paytm.business.merchantprofile.inactivemerchant.ReactivationStatusNetworkResponse) r11
            if (r11 == 0) goto L_0x009f
            java.lang.String r11 = r11.getLeadStatus()
            goto L_0x00a0
        L_0x009f:
            r11 = r5
        L_0x00a0:
            if (r11 == 0) goto L_0x01cd
            int r6 = r11.hashCode()
            switch(r6) {
                case -941740827: goto L_0x019c;
                case -911523156: goto L_0x00f0;
                case 959219365: goto L_0x00e6;
                case 1038035132: goto L_0x00cd;
                case 1333738308: goto L_0x00b4;
                case 1626962863: goto L_0x00ab;
                default: goto L_0x00a9;
            }
        L_0x00a9:
            goto L_0x01cd
        L_0x00ab:
            java.lang.String r0 = "LEAD_CLOSED"
            boolean r11 = r11.equals(r0)
            if (r11 == 0) goto L_0x01cd
            goto L_0x00bc
        L_0x00b4:
            java.lang.String r0 = "MERCHANT_REACTIVATION_SUCCESS"
            boolean r11 = r11.equals(r0)
            if (r11 == 0) goto L_0x01cd
        L_0x00bc:
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager r11 = r10.this$0
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountState r11 = r11.getInactiveMerchantData()
            androidx.lifecycle.y r11 = r11.getAccountState()
            com.paytm.business.merchantprofile.inactivemerchant.MerchantReactivationSuccess r0 = com.paytm.business.merchantprofile.inactivemerchant.MerchantReactivationSuccess.INSTANCE
            r11.setValue(r0)
            goto L_0x01dc
        L_0x00cd:
            java.lang.String r0 = "MERCHANT_REACTIVATION_FAILED"
            boolean r11 = r11.equals(r0)
            if (r11 == 0) goto L_0x01cd
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager r11 = r10.this$0
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountState r11 = r11.getInactiveMerchantData()
            androidx.lifecycle.y r11 = r11.getAccountState()
            com.paytm.business.merchantprofile.inactivemerchant.ReActivationFailed r0 = com.paytm.business.merchantprofile.inactivemerchant.ReActivationFailed.INSTANCE
            r11.setValue(r0)
            goto L_0x01dc
        L_0x00e6:
            java.lang.String r0 = "AWAITING_CLOSE"
            boolean r11 = r11.equals(r0)
            if (r11 == 0) goto L_0x01cd
            goto L_0x01a4
        L_0x00f0:
            java.lang.String r6 = "LEAD_NOT_PRESENT"
            boolean r11 = r11.equals(r6)
            if (r11 == 0) goto L_0x01cd
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager r11 = r10.this$0
            r10.L$0 = r3
            r10.L$1 = r1
            r10.label = r2
            java.lang.Object r11 = r11.getReactivationEligibility(r10)
            if (r11 != r0) goto L_0x0107
            return r0
        L_0x0107:
            com.business.common_module.utilities.a.b r11 = (com.business.common_module.utilities.a.b) r11
            com.business.common_module.utilities.a.e r0 = r11.f7357b
            com.business.common_module.utilities.a.e r1 = com.business.common_module.utilities.a.e.SUCCESS
            if (r0 != r1) goto L_0x0178
            T r0 = r11.f7358c
            com.paytm.business.merchantprofile.inactivemerchant.NetworkResponse r0 = (com.paytm.business.merchantprofile.inactivemerchant.NetworkResponse) r0
            if (r0 == 0) goto L_0x0122
            java.lang.Object r0 = r0.getResults()
            com.paytm.business.merchantprofile.inactivemerchant.ReactivationEligibility r0 = (com.paytm.business.merchantprofile.inactivemerchant.ReactivationEligibility) r0
            if (r0 == 0) goto L_0x0122
            java.lang.String r0 = r0.getStatus()
            goto L_0x0123
        L_0x0122:
            r0 = r5
        L_0x0123:
            r1 = 0
            java.lang.String r2 = "ACTIVE"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r1)
            if (r0 == 0) goto L_0x013d
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager r11 = r10.this$0
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountState r11 = r11.getInactiveMerchantData()
            androidx.lifecycle.y r11 = r11.getAccountState()
            com.paytm.business.merchantprofile.inactivemerchant.MerchantReactivationSuccess r0 = com.paytm.business.merchantprofile.inactivemerchant.MerchantReactivationSuccess.INSTANCE
            r11.setValue(r0)
            goto L_0x01dc
        L_0x013d:
            T r11 = r11.f7358c
            com.paytm.business.merchantprofile.inactivemerchant.NetworkResponse r11 = (com.paytm.business.merchantprofile.inactivemerchant.NetworkResponse) r11
            if (r11 == 0) goto L_0x0168
            java.lang.Object r11 = r11.getResults()
            com.paytm.business.merchantprofile.inactivemerchant.ReactivationEligibility r11 = (com.paytm.business.merchantprofile.inactivemerchant.ReactivationEligibility) r11
            if (r11 == 0) goto L_0x0168
            boolean r11 = r11.getInstantActivation()
            if (r11 != r4) goto L_0x0168
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager r11 = r10.this$0
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountState r11 = r11.getInactiveMerchantData()
            androidx.lifecycle.y r11 = r11.getAccountState()
            com.paytm.business.merchantprofile.inactivemerchant.DeActivatedEligibleForInstantReactivation r0 = com.paytm.business.merchantprofile.inactivemerchant.DeActivatedEligibleForInstantReactivation.INSTANCE
            r11.setValue(r0)
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager r11 = r10.this$0
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r11.isAccountReactivationPending(r0)
            goto L_0x01dc
        L_0x0168:
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager r11 = r10.this$0
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountState r11 = r11.getInactiveMerchantData()
            androidx.lifecycle.y r11 = r11.getAccountState()
            com.paytm.business.merchantprofile.inactivemerchant.DeActivatedNotEligibleForInstantReactivation r0 = com.paytm.business.merchantprofile.inactivemerchant.DeActivatedNotEligibleForInstantReactivation.INSTANCE
            r11.setValue(r0)
            goto L_0x01dc
        L_0x0178:
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager r0 = r10.this$0
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountState r0 = r0.getInactiveMerchantData()
            androidx.lifecycle.y r0 = r0.getAccountState()
            com.paytm.business.merchantprofile.inactivemerchant.DeActivatedNotEligibleForInstantReactivation r1 = com.paytm.business.merchantprofile.inactivemerchant.DeActivatedNotEligibleForInstantReactivation.INSTANCE
            r0.setValue(r1)
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager r0 = r10.this$0
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountState r0 = r0.getInactiveMerchantData()
            androidx.lifecycle.y r0 = r0.getUiState()
            com.paytm.business.merchantprofile.inactivemerchant.Error r1 = new com.paytm.business.merchantprofile.inactivemerchant.Error
            retrofit2.Response<?> r11 = r11.f7356a
            r1.<init>(r11)
            r0.setValue(r1)
            goto L_0x01dc
        L_0x019c:
            java.lang.String r0 = "LEAD_CREATED"
            boolean r11 = r11.equals(r0)
            if (r11 == 0) goto L_0x01cd
        L_0x01a4:
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager r11 = r10.this$0
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountState r11 = r11.getInactiveMerchantData()
            androidx.lifecycle.y r11 = r11.getUiState()
            com.paytm.business.merchantprofile.inactivemerchant.Success r0 = new com.paytm.business.merchantprofile.inactivemerchant.Success
            r0.<init>(r5, r4, r5)
            r11.setValue(r0)
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager r11 = r10.this$0
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountState r11 = r11.getInactiveMerchantData()
            androidx.lifecycle.y r11 = r11.getAccountState()
            com.paytm.business.merchantprofile.inactivemerchant.ReActivationInProgress r0 = com.paytm.business.merchantprofile.inactivemerchant.ReActivationInProgress.INSTANCE
            r11.setValue(r0)
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager r11 = r10.this$0
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r11.isAccountReactivationPending(r0)
            goto L_0x01dc
        L_0x01cd:
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager r11 = r10.this$0
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountState r11 = r11.getInactiveMerchantData()
            androidx.lifecycle.y r11 = r11.getAccountState()
            com.paytm.business.merchantprofile.inactivemerchant.DeActivatedNotEligibleForInstantReactivation r0 = com.paytm.business.merchantprofile.inactivemerchant.DeActivatedNotEligibleForInstantReactivation.INSTANCE
            r11.setValue(r0)
        L_0x01dc:
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager r11 = r10.this$0
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountState r11 = r11.getInactiveMerchantData()
            androidx.lifecycle.y r11 = r11.getUiState()
            com.paytm.business.merchantprofile.inactivemerchant.Success r0 = new com.paytm.business.merchantprofile.inactivemerchant.Success
            r0.<init>(r5, r4, r5)
            r11.setValue(r0)
            goto L_0x0216
        L_0x01ef:
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager r11 = r10.this$0
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountState r11 = r11.getInactiveMerchantData()
            androidx.lifecycle.y r11 = r11.getAccountState()
            com.paytm.business.merchantprofile.inactivemerchant.DeActivatedNotEligibleForInstantReactivation r0 = com.paytm.business.merchantprofile.inactivemerchant.DeActivatedNotEligibleForInstantReactivation.INSTANCE
            r11.setValue(r0)
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager r11 = r10.this$0
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountState r11 = r11.getInactiveMerchantData()
            androidx.lifecycle.y r11 = r11.getUiState()
            com.paytm.business.merchantprofile.inactivemerchant.Error r0 = new com.paytm.business.merchantprofile.inactivemerchant.Error
            T r1 = r1.element
            com.business.common_module.utilities.a.b r1 = (com.business.common_module.utilities.a.b) r1
            retrofit2.Response<?> r1 = r1.f7356a
            r0.<init>(r1)
            r11.setValue(r0)
        L_0x0216:
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager r11 = r10.this$0
            com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountState r11 = r11.getInactiveMerchantData()
            androidx.lifecycle.y r11 = r11.getAccountState()
            java.lang.Object r11 = r11.getValue()
            com.paytm.business.merchantprofile.inactivemerchant.AccountActivationState r11 = (com.paytm.business.merchantprofile.inactivemerchant.AccountActivationState) r11
            com.paytm.business.merchantprofile.inactivemerchant.MerchantReactivationSuccess r0 = com.paytm.business.merchantprofile.inactivemerchant.MerchantReactivationSuccess.INSTANCE
            boolean r11 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r0)
            if (r11 == 0) goto L_0x023e
            com.paytm.business.merchantprofile.ProfileConfig r11 = com.paytm.business.merchantprofile.ProfileConfig.getInstance()
            java.lang.String r0 = "ProfileConfig.getInstance()"
            kotlin.g.b.k.b(r11, r0)
            com.business.common_module.b.i r11 = r11.getMerchantDataProvider()
            r11.L()
        L_0x023e:
            kotlin.x r11 = kotlin.x.f47997a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.business.merchantprofile.inactivemerchant.MerchantAccountStateManager$getMerchantAccountState$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
