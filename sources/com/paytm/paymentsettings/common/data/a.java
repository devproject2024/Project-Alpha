package com.paytm.paymentsettings.common.data;

import android.content.Context;
import com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionRequestBody;
import com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionRequestHead;
import com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionResponse;
import com.paytm.paymentsettings.merchantSubscriptions.model.AuthorisedEditSubscriptionRequestBody;
import com.paytm.paymentsettings.merchantSubscriptions.model.AuthorisedEditSubscriptionRequestHead;
import com.paytm.paymentsettings.merchantSubscriptions.model.AuthorisedEditSubscriptionResponse;
import com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionRequestBody;
import com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionRequestHead;
import com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionResponse;
import kotlin.d.b.a.d;
import kotlin.d.b.a.f;
import kotlin.g.b.k;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f43433a;

    /* renamed from: b  reason: collision with root package name */
    private final com.paytm.network.b f43434b;

    @f(b = "PaymentSettingsRepository.kt", c = {49}, d = "getAuthorizedEditSubscriptionApi", e = "com.paytm.paymentsettings.common.data.PaymentSettingsRepository")
    /* renamed from: com.paytm.paymentsettings.common.data.a$a  reason: collision with other inner class name */
    static final class C0736a extends d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0736a(a aVar, kotlin.d.d dVar) {
            super(dVar);
            this.this$0 = aVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.a((String) null, (AuthorisedEditSubscriptionRequestBody) null, (AuthorisedEditSubscriptionRequestHead) null, (kotlin.d.d<? super AuthorisedEditSubscriptionResponse>) this);
        }
    }

    @f(b = "PaymentSettingsRepository.kt", c = {37}, d = "getEditSubscriptionApi", e = "com.paytm.paymentsettings.common.data.PaymentSettingsRepository")
    static final class b extends d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar, kotlin.d.d dVar) {
            super(dVar);
            this.this$0 = aVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.a((String) null, (EditSubscriptionRequestBody) null, (EditSubscriptionRequestHead) null, (kotlin.d.d<? super EditSubscriptionResponse>) this);
        }
    }

    @f(b = "PaymentSettingsRepository.kt", c = {25}, d = "getSubscriptionList", e = "com.paytm.paymentsettings.common.data.PaymentSettingsRepository")
    static final class c extends d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a aVar, kotlin.d.d dVar) {
            super(dVar);
            this.this$0 = aVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.a((String) null, (ActiveSubscriptionRequestBody) null, (ActiveSubscriptionRequestHead) null, (kotlin.d.d<? super ActiveSubscriptionResponse>) this);
        }
    }

    public a(Context context, com.paytm.network.b bVar) {
        k.c(context, "context");
        this.f43433a = context;
        this.f43434b = bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.lang.String r18, com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionRequestBody r19, com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionRequestHead r20, kotlin.d.d<? super com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionResponse> r21) {
        /*
            r17 = this;
            r0 = r17
            r12 = r18
            r9 = r19
            r10 = r20
            r1 = r21
            boolean r2 = r1 instanceof com.paytm.paymentsettings.common.data.a.c
            if (r2 == 0) goto L_0x001e
            r2 = r1
            com.paytm.paymentsettings.common.data.a$c r2 = (com.paytm.paymentsettings.common.data.a.c) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x001e
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x0023
        L_0x001e:
            com.paytm.paymentsettings.common.data.a$c r2 = new com.paytm.paymentsettings.common.data.a$c
            r2.<init>(r0, r1)
        L_0x0023:
            r13 = r2
            java.lang.Object r1 = r13.result
            kotlin.d.a.a r14 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r2 = r13.label
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            kotlin.ResultKt.a((java.lang.Object) r1)
            goto L_0x00dc
        L_0x0034:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003c:
            kotlin.ResultKt.a((java.lang.Object) r1)
            android.content.Context r8 = r0.f43433a
            com.paytm.network.b r11 = r0.f43434b
            r13.L$0 = r0
            r13.L$1 = r12
            r13.L$2 = r9
            r13.L$3 = r10
            r13.label = r3
            kotlin.d.h r15 = new kotlin.d.h
            kotlin.d.d r1 = kotlin.d.a.b.a(r13)
            r15.<init>(r1)
            r5 = r15
            kotlin.d.d r5 = (kotlin.d.d) r5
            java.lang.String r2 = "https://securegw.paytm.in/subscription/subscription/list/all "
            java.lang.String r1 = com.paytm.utility.d.a(r8)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            android.text.TextUtils.isEmpty(r1)
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionRequest r1 = new com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionRequest
            r1.<init>(r10, r9)
            com.google.gsonhtcfix.f r3 = new com.google.gsonhtcfix.f
            r3.<init>()
            java.lang.String r4 = r3.a((java.lang.Object) r1)
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r3 = r1
            java.util.Map r3 = (java.util.Map) r3
            java.lang.String r1 = "Content-Type"
            java.lang.String r6 = "application/json"
            r3.put(r1, r6)
            long r6 = java.lang.System.currentTimeMillis()
            if (r11 == 0) goto L_0x00cc
            com.paytm.network.b r1 = r11.c(r12)
            com.paytm.network.a$a r0 = com.paytm.network.a.C0715a.POST
            com.paytm.network.b r0 = r1.a((com.paytm.network.a.C0715a) r0)
            com.paytm.network.b r0 = r0.a((java.lang.String) r2)
            com.paytm.network.b r0 = r0.a((java.util.Map<java.lang.String, java.lang.String>) r3)
            java.lang.String r1 = r4.toString()
            com.paytm.network.b r0 = r0.b((java.lang.String) r1)
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionResponse r1 = new com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionResponse
            r9 = 3
            r10 = 0
            r1.<init>(r10, r10, r9, r10)
            com.paytm.network.model.IJRPaytmDataModel r1 = (com.paytm.network.model.IJRPaytmDataModel) r1
            com.paytm.network.b r0 = r0.a((com.paytm.network.model.IJRPaytmDataModel) r1)
            com.paytm.paymentsettings.common.a.a$c r16 = new com.paytm.paymentsettings.common.a.a$c
            r1 = r16
            r9 = r19
            r10 = r20
            r12 = r18
            r1.<init>(r2, r3, r4, r5, r6, r8, r9, r10, r11, r12)
            r1 = r16
            com.paytm.network.listener.b r1 = (com.paytm.network.listener.b) r1
            com.paytm.network.b r0 = r0.a((com.paytm.network.listener.b) r1)
            com.paytm.network.a r0 = r0.l()
            r0.a()
            kotlin.x r0 = kotlin.x.f47997a
        L_0x00cc:
            java.lang.Object r1 = r15.a()
            kotlin.d.a.a r0 = kotlin.d.a.a.COROUTINE_SUSPENDED
            if (r1 != r0) goto L_0x00d9
            java.lang.String r0 = "frame"
            kotlin.g.b.k.d(r13, r0)
        L_0x00d9:
            if (r1 != r14) goto L_0x00dc
            return r14
        L_0x00dc:
            if (r1 == 0) goto L_0x00e1
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionResponse r1 = (com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionResponse) r1
            return r1
        L_0x00e1:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionResponse"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.paymentsettings.common.data.a.a(java.lang.String, com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionRequestBody, com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionRequestHead, kotlin.d.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.lang.String r18, com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionRequestBody r19, com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionRequestHead r20, kotlin.d.d<? super com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionResponse> r21) {
        /*
            r17 = this;
            r0 = r17
            r12 = r18
            r9 = r19
            r10 = r20
            r1 = r21
            boolean r2 = r1 instanceof com.paytm.paymentsettings.common.data.a.b
            if (r2 == 0) goto L_0x001e
            r2 = r1
            com.paytm.paymentsettings.common.data.a$b r2 = (com.paytm.paymentsettings.common.data.a.b) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x001e
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x0023
        L_0x001e:
            com.paytm.paymentsettings.common.data.a$b r2 = new com.paytm.paymentsettings.common.data.a$b
            r2.<init>(r0, r1)
        L_0x0023:
            r13 = r2
            java.lang.Object r1 = r13.result
            kotlin.d.a.a r14 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r2 = r13.label
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            kotlin.ResultKt.a((java.lang.Object) r1)
            goto L_0x00dc
        L_0x0034:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003c:
            kotlin.ResultKt.a((java.lang.Object) r1)
            android.content.Context r8 = r0.f43433a
            com.paytm.network.b r11 = r0.f43434b
            r13.L$0 = r0
            r13.L$1 = r12
            r13.L$2 = r9
            r13.L$3 = r10
            r13.label = r3
            kotlin.d.h r15 = new kotlin.d.h
            kotlin.d.d r1 = kotlin.d.a.b.a(r13)
            r15.<init>(r1)
            r5 = r15
            kotlin.d.d r5 = (kotlin.d.d) r5
            java.lang.String r2 = "https://securegw.paytm.in/subscription/v3/edit"
            java.lang.String r1 = com.paytm.utility.d.a(r8)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            android.text.TextUtils.isEmpty(r1)
            com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionRequest r1 = new com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionRequest
            r1.<init>(r10, r9)
            com.google.gsonhtcfix.f r3 = new com.google.gsonhtcfix.f
            r3.<init>()
            java.lang.String r4 = r3.a((java.lang.Object) r1)
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r3 = r1
            java.util.Map r3 = (java.util.Map) r3
            java.lang.String r1 = "Content-Type"
            java.lang.String r6 = "application/json"
            r3.put(r1, r6)
            long r6 = java.lang.System.currentTimeMillis()
            if (r11 == 0) goto L_0x00cc
            com.paytm.network.b r1 = r11.c(r12)
            com.paytm.network.a$a r0 = com.paytm.network.a.C0715a.POST
            com.paytm.network.b r0 = r1.a((com.paytm.network.a.C0715a) r0)
            com.paytm.network.b r0 = r0.a((java.lang.String) r2)
            com.paytm.network.b r0 = r0.a((java.util.Map<java.lang.String, java.lang.String>) r3)
            java.lang.String r1 = r4.toString()
            com.paytm.network.b r0 = r0.b((java.lang.String) r1)
            com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionResponse r1 = new com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionResponse
            r9 = 3
            r10 = 0
            r1.<init>(r10, r10, r9, r10)
            com.paytm.network.model.IJRPaytmDataModel r1 = (com.paytm.network.model.IJRPaytmDataModel) r1
            com.paytm.network.b r0 = r0.a((com.paytm.network.model.IJRPaytmDataModel) r1)
            com.paytm.paymentsettings.common.a.a$b r16 = new com.paytm.paymentsettings.common.a.a$b
            r1 = r16
            r9 = r19
            r10 = r20
            r12 = r18
            r1.<init>(r2, r3, r4, r5, r6, r8, r9, r10, r11, r12)
            r1 = r16
            com.paytm.network.listener.b r1 = (com.paytm.network.listener.b) r1
            com.paytm.network.b r0 = r0.a((com.paytm.network.listener.b) r1)
            com.paytm.network.a r0 = r0.l()
            r0.a()
            kotlin.x r0 = kotlin.x.f47997a
        L_0x00cc:
            java.lang.Object r1 = r15.a()
            kotlin.d.a.a r0 = kotlin.d.a.a.COROUTINE_SUSPENDED
            if (r1 != r0) goto L_0x00d9
            java.lang.String r0 = "frame"
            kotlin.g.b.k.d(r13, r0)
        L_0x00d9:
            if (r1 != r14) goto L_0x00dc
            return r14
        L_0x00dc:
            if (r1 == 0) goto L_0x00e1
            com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionResponse r1 = (com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionResponse) r1
            return r1
        L_0x00e1:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionResponse"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.paymentsettings.common.data.a.a(java.lang.String, com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionRequestBody, com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionRequestHead, kotlin.d.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.lang.String r18, com.paytm.paymentsettings.merchantSubscriptions.model.AuthorisedEditSubscriptionRequestBody r19, com.paytm.paymentsettings.merchantSubscriptions.model.AuthorisedEditSubscriptionRequestHead r20, kotlin.d.d<? super com.paytm.paymentsettings.merchantSubscriptions.model.AuthorisedEditSubscriptionResponse> r21) {
        /*
            r17 = this;
            r0 = r17
            r12 = r18
            r9 = r19
            r10 = r20
            r1 = r21
            boolean r2 = r1 instanceof com.paytm.paymentsettings.common.data.a.C0736a
            if (r2 == 0) goto L_0x001e
            r2 = r1
            com.paytm.paymentsettings.common.data.a$a r2 = (com.paytm.paymentsettings.common.data.a.C0736a) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x001e
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x0023
        L_0x001e:
            com.paytm.paymentsettings.common.data.a$a r2 = new com.paytm.paymentsettings.common.data.a$a
            r2.<init>(r0, r1)
        L_0x0023:
            r13 = r2
            java.lang.Object r1 = r13.result
            kotlin.d.a.a r14 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r2 = r13.label
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            kotlin.ResultKt.a((java.lang.Object) r1)
            goto L_0x00dc
        L_0x0034:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003c:
            kotlin.ResultKt.a((java.lang.Object) r1)
            android.content.Context r8 = r0.f43433a
            com.paytm.network.b r11 = r0.f43434b
            r13.L$0 = r0
            r13.L$1 = r12
            r13.L$2 = r9
            r13.L$3 = r10
            r13.label = r3
            kotlin.d.h r15 = new kotlin.d.h
            kotlin.d.d r1 = kotlin.d.a.b.a(r13)
            r15.<init>(r1)
            r5 = r15
            kotlin.d.d r5 = (kotlin.d.d) r5
            java.lang.String r2 = "https://securegw.paytm.in/subscription/v3/edit/authorize"
            java.lang.String r1 = com.paytm.utility.d.a(r8)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            android.text.TextUtils.isEmpty(r1)
            com.paytm.paymentsettings.merchantSubscriptions.model.AuthorisedEditSubscriptionRequest r1 = new com.paytm.paymentsettings.merchantSubscriptions.model.AuthorisedEditSubscriptionRequest
            r1.<init>(r10, r9)
            com.google.gsonhtcfix.f r3 = new com.google.gsonhtcfix.f
            r3.<init>()
            java.lang.String r4 = r3.a((java.lang.Object) r1)
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r3 = r1
            java.util.Map r3 = (java.util.Map) r3
            java.lang.String r1 = "Content-Type"
            java.lang.String r6 = "application/json"
            r3.put(r1, r6)
            long r6 = java.lang.System.currentTimeMillis()
            if (r11 == 0) goto L_0x00cc
            com.paytm.network.b r1 = r11.c(r12)
            com.paytm.network.a$a r0 = com.paytm.network.a.C0715a.POST
            com.paytm.network.b r0 = r1.a((com.paytm.network.a.C0715a) r0)
            com.paytm.network.b r0 = r0.a((java.lang.String) r2)
            com.paytm.network.b r0 = r0.a((java.util.Map<java.lang.String, java.lang.String>) r3)
            java.lang.String r1 = r4.toString()
            com.paytm.network.b r0 = r0.b((java.lang.String) r1)
            com.paytm.paymentsettings.merchantSubscriptions.model.AuthorisedEditSubscriptionResponse r1 = new com.paytm.paymentsettings.merchantSubscriptions.model.AuthorisedEditSubscriptionResponse
            r9 = 3
            r10 = 0
            r1.<init>(r10, r10, r9, r10)
            com.paytm.network.model.IJRPaytmDataModel r1 = (com.paytm.network.model.IJRPaytmDataModel) r1
            com.paytm.network.b r0 = r0.a((com.paytm.network.model.IJRPaytmDataModel) r1)
            com.paytm.paymentsettings.common.a.a$a r16 = new com.paytm.paymentsettings.common.a.a$a
            r1 = r16
            r9 = r19
            r10 = r20
            r12 = r18
            r1.<init>(r2, r3, r4, r5, r6, r8, r9, r10, r11, r12)
            r1 = r16
            com.paytm.network.listener.b r1 = (com.paytm.network.listener.b) r1
            com.paytm.network.b r0 = r0.a((com.paytm.network.listener.b) r1)
            com.paytm.network.a r0 = r0.l()
            r0.a()
            kotlin.x r0 = kotlin.x.f47997a
        L_0x00cc:
            java.lang.Object r1 = r15.a()
            kotlin.d.a.a r0 = kotlin.d.a.a.COROUTINE_SUSPENDED
            if (r1 != r0) goto L_0x00d9
            java.lang.String r0 = "frame"
            kotlin.g.b.k.d(r13, r0)
        L_0x00d9:
            if (r1 != r14) goto L_0x00dc
            return r14
        L_0x00dc:
            if (r1 == 0) goto L_0x00e1
            com.paytm.paymentsettings.merchantSubscriptions.model.AuthorisedEditSubscriptionResponse r1 = (com.paytm.paymentsettings.merchantSubscriptions.model.AuthorisedEditSubscriptionResponse) r1
            return r1
        L_0x00e1:
            kotlin.u r0 = new kotlin.u
            java.lang.String r1 = "null cannot be cast to non-null type com.paytm.paymentsettings.merchantSubscriptions.model.AuthorisedEditSubscriptionResponse"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.paymentsettings.common.data.a.a(java.lang.String, com.paytm.paymentsettings.merchantSubscriptions.model.AuthorisedEditSubscriptionRequestBody, com.paytm.paymentsettings.merchantSubscriptions.model.AuthorisedEditSubscriptionRequestHead, kotlin.d.d):java.lang.Object");
    }
}
