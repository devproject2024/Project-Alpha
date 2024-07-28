package com.paytm.paymentsettings.merchantSubscriptions.a;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.y;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.paymentsettings.R;
import com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem;
import com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionRequestBody;
import com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionRequestHead;
import com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionResponse;
import com.paytm.paymentsettings.merchantSubscriptions.model.AuthorisedEditSubscriptionRequestBody;
import com.paytm.paymentsettings.merchantSubscriptions.model.AuthorisedEditSubscriptionRequestHead;
import com.paytm.paymentsettings.merchantSubscriptions.model.AuthorisedEditSubscriptionResponse;
import com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionRequestBody;
import com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionRequestHead;
import com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionResponse;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.d.b.a.f;
import kotlin.g.a.m;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.x;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class a extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    public y<List<ActiveSubscriptionDetailsItem>> f43454a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public y<NetworkCustomError> f43455b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public y<Boolean> f43456c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public y<Boolean> f43457d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public y<Boolean> f43458e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    public y<Boolean> f43459f = new y<>();

    /* renamed from: g  reason: collision with root package name */
    public boolean f43460g;

    /* renamed from: h  reason: collision with root package name */
    public String f43461h = "";

    /* renamed from: i  reason: collision with root package name */
    public y<C0737a> f43462i = new y<>();
    public y<ActiveSubscriptionDetailsItem> j = new y<>();
    public y<String> k = new y<>();
    public y<Boolean> l = new y<>();
    public final CoroutineScope m = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(this.o));
    /* access modifiers changed from: private */
    public final Context n;
    private final CompletableJob o = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
    /* access modifiers changed from: private */
    public final com.paytm.paymentsettings.common.data.a p;
    /* access modifiers changed from: private */
    public final String q;

    /* renamed from: com.paytm.paymentsettings.merchantSubscriptions.a.a$a  reason: collision with other inner class name */
    public enum C0737a {
        TRUE_POSITIVE,
        NEGATIVE,
        FALSE_POSITIVE
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(com.paytm.paymentsettings.common.data.a aVar, Application application, String str) {
        super(application);
        k.c(aVar, "repository");
        k.c(application, "application");
        this.p = aVar;
        this.q = str;
        this.n = application;
    }

    public final void onCleared() {
        super.onCleared();
        try {
            Job.DefaultImpls.cancel$default(this.o, (CancellationException) null, 1, (Object) null);
        } catch (Exception e2) {
            new StringBuilder("Coroutine clear exception caught ").append(e2.getMessage());
        } catch (Throwable th) {
            new StringBuilder("Coroutine verify exception caught ").append(th.getMessage());
        }
    }

    @f(b = "ActiveSubscriptionViewModel.kt", c = {156}, d = "invokeSuspend", e = "com.paytm.paymentsettings.merchantSubscriptions.viewmodel.ActiveSubscriptionViewModel$callAuthorisedEditSubscriptionAPI$1")
    public static final class b extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ String $otp;
        final /* synthetic */ String $state;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(a aVar, String str, String str2, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = aVar;
            this.$state = str;
            this.$otp = str2;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            k.c(dVar, "completion");
            b bVar = new b(this.this$0, this.$state, this.$otp, dVar);
            bVar.p$ = (CoroutineScope) obj;
            return bVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((b) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        @f(b = "ActiveSubscriptionViewModel.kt", c = {154}, d = "invokeSuspend", e = "com.paytm.paymentsettings.merchantSubscriptions.viewmodel.ActiveSubscriptionViewModel$callAuthorisedEditSubscriptionAPI$1$result$1")
        /* renamed from: com.paytm.paymentsettings.merchantSubscriptions.a.a$b$a  reason: collision with other inner class name */
        static final class C0738a extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super AuthorisedEditSubscriptionResponse>, Object> {
            final /* synthetic */ AuthorisedEditSubscriptionRequestBody $body;
            final /* synthetic */ AuthorisedEditSubscriptionRequestHead $head;
            Object L$0;
            int label;
            private CoroutineScope p$;
            final /* synthetic */ b this$0;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0738a(b bVar, AuthorisedEditSubscriptionRequestBody authorisedEditSubscriptionRequestBody, AuthorisedEditSubscriptionRequestHead authorisedEditSubscriptionRequestHead, kotlin.d.d dVar) {
                super(2, dVar);
                this.this$0 = bVar;
                this.$body = authorisedEditSubscriptionRequestBody;
                this.$head = authorisedEditSubscriptionRequestHead;
            }

            public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                k.c(dVar, "completion");
                C0738a aVar = new C0738a(this.this$0, this.$body, this.$head, dVar);
                aVar.p$ = (CoroutineScope) obj;
                return aVar;
            }

            public final Object invoke(Object obj, Object obj2) {
                return ((C0738a) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
            }

            public final Object invokeSuspend(Object obj) {
                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                int i2 = this.label;
                if (i2 == 0) {
                    ResultKt.a(obj);
                    CoroutineScope coroutineScope = this.p$;
                    com.paytm.paymentsettings.common.data.a b2 = this.this$0.this$0.p;
                    String c2 = this.this$0.this$0.q;
                    AuthorisedEditSubscriptionRequestBody authorisedEditSubscriptionRequestBody = this.$body;
                    AuthorisedEditSubscriptionRequestHead authorisedEditSubscriptionRequestHead = this.$head;
                    this.L$0 = coroutineScope;
                    this.label = 1;
                    obj = b2.a(c2, authorisedEditSubscriptionRequestBody, authorisedEditSubscriptionRequestHead, (kotlin.d.d<? super AuthorisedEditSubscriptionResponse>) this);
                    if (obj == aVar) {
                        return aVar;
                    }
                } else if (i2 == 1) {
                    ResultKt.a(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return obj;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object obj2;
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.a(obj);
                CoroutineScope coroutineScope = this.p$;
                ActiveSubscriptionDetailsItem value = this.this$0.j.getValue();
                AuthorisedEditSubscriptionRequestBody authorisedEditSubscriptionRequestBody = new AuthorisedEditSubscriptionRequestBody(value != null ? value.getMerchantId() : null, this.$state, this.$otp);
                AuthorisedEditSubscriptionRequestHead authorisedEditSubscriptionRequestHead = new AuthorisedEditSubscriptionRequestHead("v1", "time", (String) null, SDKConstants.SSO, com.paytm.utility.d.a(this.this$0.n), 4, (g) null);
                Deferred async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new C0738a(this, authorisedEditSubscriptionRequestBody, authorisedEditSubscriptionRequestHead, (kotlin.d.d) null), 2, (Object) null);
                this.L$0 = coroutineScope;
                this.L$1 = authorisedEditSubscriptionRequestBody;
                this.L$2 = authorisedEditSubscriptionRequestHead;
                this.L$3 = async$default;
                this.label = 1;
                obj2 = async$default.await(this);
                if (obj2 == aVar) {
                    return aVar;
                }
            } else if (i2 == 1) {
                try {
                    ResultKt.a(obj);
                    obj2 = obj;
                } catch (Exception e2) {
                    com.paytm.paymentsettings.common.b.b.a(e2);
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a.a(this.this$0, (AuthorisedEditSubscriptionResponse) obj2);
            return x.f47997a;
        }
    }

    @f(b = "ActiveSubscriptionViewModel.kt", c = {129}, d = "invokeSuspend", e = "com.paytm.paymentsettings.merchantSubscriptions.viewmodel.ActiveSubscriptionViewModel$callEditSubscriptionAPI$1")
    public static final class c extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ String $actionType;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(a aVar, String str, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = aVar;
            this.$actionType = str;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            k.c(dVar, "completion");
            c cVar = new c(this.this$0, this.$actionType, dVar);
            cVar.p$ = (CoroutineScope) obj;
            return cVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((c) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        @f(b = "ActiveSubscriptionViewModel.kt", c = {127}, d = "invokeSuspend", e = "com.paytm.paymentsettings.merchantSubscriptions.viewmodel.ActiveSubscriptionViewModel$callEditSubscriptionAPI$1$result$1")
        /* renamed from: com.paytm.paymentsettings.merchantSubscriptions.a.a$c$a  reason: collision with other inner class name */
        static final class C0739a extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super EditSubscriptionResponse>, Object> {
            final /* synthetic */ EditSubscriptionRequestBody $body;
            final /* synthetic */ EditSubscriptionRequestHead $head;
            Object L$0;
            int label;
            private CoroutineScope p$;
            final /* synthetic */ c this$0;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0739a(c cVar, EditSubscriptionRequestBody editSubscriptionRequestBody, EditSubscriptionRequestHead editSubscriptionRequestHead, kotlin.d.d dVar) {
                super(2, dVar);
                this.this$0 = cVar;
                this.$body = editSubscriptionRequestBody;
                this.$head = editSubscriptionRequestHead;
            }

            public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                k.c(dVar, "completion");
                C0739a aVar = new C0739a(this.this$0, this.$body, this.$head, dVar);
                aVar.p$ = (CoroutineScope) obj;
                return aVar;
            }

            public final Object invoke(Object obj, Object obj2) {
                return ((C0739a) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
            }

            public final Object invokeSuspend(Object obj) {
                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                int i2 = this.label;
                if (i2 == 0) {
                    ResultKt.a(obj);
                    CoroutineScope coroutineScope = this.p$;
                    com.paytm.paymentsettings.common.data.a b2 = this.this$0.this$0.p;
                    String c2 = this.this$0.this$0.q;
                    EditSubscriptionRequestBody editSubscriptionRequestBody = this.$body;
                    EditSubscriptionRequestHead editSubscriptionRequestHead = this.$head;
                    this.L$0 = coroutineScope;
                    this.label = 1;
                    obj = b2.a(c2, editSubscriptionRequestBody, editSubscriptionRequestHead, (kotlin.d.d<? super EditSubscriptionResponse>) this);
                    if (obj == aVar) {
                        return aVar;
                    }
                } else if (i2 == 1) {
                    ResultKt.a(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return obj;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object obj2;
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.a(obj);
                CoroutineScope coroutineScope = this.p$;
                Context unused = this.this$0.n;
                ActiveSubscriptionDetailsItem value = this.this$0.j.getValue();
                String b2 = com.paytm.utility.b.b(value != null ? value.getSubscriptionEndDate() : null, this.this$0.n.getString(R.string.date_output_format_details), this.this$0.n.getString(R.string.expiry_date_format));
                ActiveSubscriptionDetailsItem value2 = this.this$0.j.getValue();
                String merchantId = value2 != null ? value2.getMerchantId() : null;
                ActiveSubscriptionDetailsItem value3 = this.this$0.j.getValue();
                EditSubscriptionRequestBody editSubscriptionRequestBody = new EditSubscriptionRequestBody(b2, this.$actionType, value3 != null ? value3.getSubscriptionId() : null, merchantId);
                EditSubscriptionRequestHead editSubscriptionRequestHead = new EditSubscriptionRequestHead(com.paytm.utility.b.k(), "", SDKConstants.SSO, "v1", "time", com.paytm.utility.d.a(this.this$0.n));
                Deferred async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new C0739a(this, editSubscriptionRequestBody, editSubscriptionRequestHead, (kotlin.d.d) null), 2, (Object) null);
                this.L$0 = coroutineScope;
                this.L$1 = b2;
                this.L$2 = editSubscriptionRequestBody;
                this.L$3 = editSubscriptionRequestHead;
                this.L$4 = async$default;
                this.label = 1;
                obj2 = async$default.await(this);
                if (obj2 == aVar) {
                    return aVar;
                }
            } else if (i2 == 1) {
                try {
                    ResultKt.a(obj);
                    obj2 = obj;
                } catch (Exception e2) {
                    com.paytm.paymentsettings.common.b.b.a(e2);
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a.a(this.this$0, (EditSubscriptionResponse) obj2);
            return x.f47997a;
        }
    }

    @f(b = "ActiveSubscriptionViewModel.kt", c = {97}, d = "invokeSuspend", e = "com.paytm.paymentsettings.merchantSubscriptions.viewmodel.ActiveSubscriptionViewModel$callSubscriptionAPI$1")
    public static final class d extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(a aVar, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = aVar;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            k.c(dVar, "completion");
            d dVar2 = new d(this.this$0, dVar);
            dVar2.p$ = (CoroutineScope) obj;
            return dVar2;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((d) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        @f(b = "ActiveSubscriptionViewModel.kt", c = {95}, d = "invokeSuspend", e = "com.paytm.paymentsettings.merchantSubscriptions.viewmodel.ActiveSubscriptionViewModel$callSubscriptionAPI$1$result$1")
        /* renamed from: com.paytm.paymentsettings.merchantSubscriptions.a.a$d$a  reason: collision with other inner class name */
        static final class C0740a extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super ActiveSubscriptionResponse>, Object> {
            final /* synthetic */ ActiveSubscriptionRequestBody $body;
            final /* synthetic */ ActiveSubscriptionRequestHead $head;
            Object L$0;
            int label;
            private CoroutineScope p$;
            final /* synthetic */ d this$0;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0740a(d dVar, ActiveSubscriptionRequestBody activeSubscriptionRequestBody, ActiveSubscriptionRequestHead activeSubscriptionRequestHead, kotlin.d.d dVar2) {
                super(2, dVar2);
                this.this$0 = dVar;
                this.$body = activeSubscriptionRequestBody;
                this.$head = activeSubscriptionRequestHead;
            }

            public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                k.c(dVar, "completion");
                C0740a aVar = new C0740a(this.this$0, this.$body, this.$head, dVar);
                aVar.p$ = (CoroutineScope) obj;
                return aVar;
            }

            public final Object invoke(Object obj, Object obj2) {
                return ((C0740a) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
            }

            public final Object invokeSuspend(Object obj) {
                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                int i2 = this.label;
                if (i2 == 0) {
                    ResultKt.a(obj);
                    CoroutineScope coroutineScope = this.p$;
                    com.paytm.paymentsettings.common.data.a b2 = this.this$0.this$0.p;
                    String c2 = this.this$0.this$0.q;
                    ActiveSubscriptionRequestBody activeSubscriptionRequestBody = this.$body;
                    ActiveSubscriptionRequestHead activeSubscriptionRequestHead = this.$head;
                    this.L$0 = coroutineScope;
                    this.label = 1;
                    obj = b2.a(c2, activeSubscriptionRequestBody, activeSubscriptionRequestHead, (kotlin.d.d<? super ActiveSubscriptionResponse>) this);
                    if (obj == aVar) {
                        return aVar;
                    }
                } else if (i2 == 1) {
                    ResultKt.a(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return obj;
            }
        }

        public final Object invokeSuspend(Object obj) {
            Object obj2;
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.a(obj);
                CoroutineScope coroutineScope = this.p$;
                ActiveSubscriptionRequestBody activeSubscriptionRequestBody = new ActiveSubscriptionRequestBody("", "", false, 4, (g) null);
                ActiveSubscriptionRequestHead activeSubscriptionRequestHead = new ActiveSubscriptionRequestHead(com.paytm.utility.b.k(), "", SDKConstants.SSO, (String) null, "", com.paytm.utility.d.a(this.this$0.n), 8, (g) null);
                Deferred async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new C0740a(this, activeSubscriptionRequestBody, activeSubscriptionRequestHead, (kotlin.d.d) null), 2, (Object) null);
                this.L$0 = coroutineScope;
                this.L$1 = activeSubscriptionRequestBody;
                this.L$2 = activeSubscriptionRequestHead;
                this.L$3 = async$default;
                this.label = 1;
                obj2 = async$default.await(this);
                if (obj2 == aVar) {
                    return aVar;
                }
            } else if (i2 == 1) {
                try {
                    ResultKt.a(obj);
                    obj2 = obj;
                } catch (Exception e2) {
                    com.paytm.paymentsettings.common.b.b.a(e2);
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a.a(this.this$0, (ActiveSubscriptionResponse) obj2);
            return x.f47997a;
        }
    }

    /* JADX WARNING: type inference failed for: r3v6, types: [java.util.List] */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01f9, code lost:
        com.paytm.utility.q.d(r12.getBody().getResultInfo().getStatus() + com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COLON + r12.getBody().getResultInfo().getMessage());
        r11.f43462i.postValue(com.paytm.paymentsettings.merchantSubscriptions.a.a.C0737a.FALSE_POSITIVE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x022d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x023b, code lost:
        r11.l.postValue(java.lang.Boolean.TRUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0018, code lost:
        r0 = r0.getResultInfo();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0141, code lost:
        com.paytm.utility.q.d(r12.getBody().getResultInfo().getStatus() + com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COLON + r12.getBody().getResultInfo().getMessage());
        r11.f43462i.postValue(com.paytm.paymentsettings.merchantSubscriptions.a.a.C0737a.FALSE_POSITIVE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0175, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0183, code lost:
        r11.l.postValue(java.lang.Boolean.TRUE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x018a, code lost:
        return;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(com.paytm.paymentsettings.merchantSubscriptions.a.a r11, com.paytm.network.model.IJRPaytmDataModel r12) {
        /*
            androidx.lifecycle.y<java.lang.Boolean> r0 = r11.f43456c
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r0.postValue(r1)
            boolean r0 = r12 instanceof com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionResponse
            java.lang.String r1 = "3006"
            java.lang.String r2 = "400"
            r3 = 0
            if (r0 == 0) goto L_0x007e
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionResponse r12 = (com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionResponse) r12
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionsBody r0 = r12.getBody()
            if (r0 == 0) goto L_0x0023
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionsResultInfo r0 = r0.getResultInfo()
            if (r0 == 0) goto L_0x0023
            java.lang.String r0 = r0.getCode()
            goto L_0x0024
        L_0x0023:
            r0 = r3
        L_0x0024:
            if (r0 != 0) goto L_0x0027
            goto L_0x0073
        L_0x0027:
            int r4 = r0.hashCode()
            switch(r4) {
                case 49586: goto L_0x0063;
                case 51508: goto L_0x0055;
                case 52469: goto L_0x0045;
                case 1567011: goto L_0x002f;
                default: goto L_0x002e;
            }
        L_0x002e:
            goto L_0x0073
        L_0x002f:
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0073
            androidx.lifecycle.y<java.util.List<com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem>> r11 = r11.f43454a
            com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionsBody r12 = r12.getBody()
            if (r12 == 0) goto L_0x0041
            java.util.List r3 = r12.getSubscriptionDetails()
        L_0x0041:
            r11.postValue(r3)
            return
        L_0x0045:
            java.lang.String r12 = "500"
            boolean r12 = r0.equals(r12)
            if (r12 == 0) goto L_0x0073
            androidx.lifecycle.y<java.lang.Boolean> r11 = r11.f43458e
            java.lang.Boolean r12 = java.lang.Boolean.TRUE
            r11.postValue(r12)
            return
        L_0x0055:
            boolean r12 = r0.equals(r2)
            if (r12 == 0) goto L_0x0073
            androidx.lifecycle.y<java.lang.Boolean> r11 = r11.l
            java.lang.Boolean r12 = java.lang.Boolean.TRUE
            r11.postValue(r12)
            return
        L_0x0063:
            java.lang.String r12 = "200"
            boolean r12 = r0.equals(r12)
            if (r12 == 0) goto L_0x0073
            androidx.lifecycle.y<java.lang.Boolean> r11 = r11.f43457d
            java.lang.Boolean r12 = java.lang.Boolean.TRUE
            r11.postValue(r12)
            return
        L_0x0073:
            androidx.lifecycle.y<com.paytm.network.model.NetworkCustomError> r11 = r11.f43455b
            com.paytm.network.model.NetworkCustomError r12 = new com.paytm.network.model.NetworkCustomError
            r12.<init>()
            r11.postValue(r12)
            return
        L_0x007e:
            boolean r0 = r12 instanceof com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionResponse
            java.lang.String r4 = ":"
            java.lang.String r5 = "3017"
            java.lang.String r6 = "3010"
            java.lang.String r7 = "3005"
            java.lang.String r8 = "3004"
            java.lang.String r9 = "939"
            java.lang.String r10 = "401"
            if (r0 == 0) goto L_0x018b
            com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionResponse r12 = (com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionResponse) r12
            com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionResponseBody r0 = r12.getBody()
            if (r0 == 0) goto L_0x00a2
            com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionResponseResultInfo r0 = r0.getResultInfo()
            if (r0 == 0) goto L_0x00a2
            java.lang.String r3 = r0.getCode()
        L_0x00a2:
            if (r3 != 0) goto L_0x00a5
            return
        L_0x00a5:
            int r0 = r3.hashCode()
            switch(r0) {
                case 51508: goto L_0x017d;
                case 51509: goto L_0x0176;
                case 56415: goto L_0x013b;
                case 1567009: goto L_0x0134;
                case 1567010: goto L_0x012d;
                case 1567011: goto L_0x011f;
                case 1567036: goto L_0x0118;
                case 1567043: goto L_0x0111;
                case 1567103: goto L_0x00d5;
                case 1567107: goto L_0x00cb;
                case 1567129: goto L_0x00c1;
                case 1567130: goto L_0x00b7;
                case 1567133: goto L_0x00ad;
                default: goto L_0x00ac;
            }
        L_0x00ac:
            return
        L_0x00ad:
            java.lang.String r0 = "3044"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0242
            goto L_0x0141
        L_0x00b7:
            java.lang.String r0 = "3041"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0242
            goto L_0x0141
        L_0x00c1:
            java.lang.String r0 = "3040"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0242
            goto L_0x0141
        L_0x00cb:
            java.lang.String r0 = "3039"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0242
            goto L_0x0141
        L_0x00d5:
            java.lang.String r0 = "3035"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0242
            com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionResponseBody r0 = r12.getBody()
            java.lang.String r0 = r0.getState()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x00f2
            int r0 = r0.length()
            if (r0 != 0) goto L_0x00f0
            goto L_0x00f2
        L_0x00f0:
            r0 = 0
            goto L_0x00f3
        L_0x00f2:
            r0 = 1
        L_0x00f3:
            if (r0 != 0) goto L_0x0242
            com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionResponseBody r0 = r12.getBody()
            com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionResponseResultInfo r0 = r0.getResultInfo()
            java.lang.String r0 = r0.getMessage()
            r11.f43461h = r0
            androidx.lifecycle.y<java.lang.String> r11 = r11.k
            com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionResponseBody r12 = r12.getBody()
            java.lang.String r12 = r12.getState()
            r11.postValue(r12)
            return
        L_0x0111:
            boolean r0 = r3.equals(r5)
            if (r0 == 0) goto L_0x0242
            goto L_0x0141
        L_0x0118:
            boolean r0 = r3.equals(r6)
            if (r0 == 0) goto L_0x0242
            goto L_0x0141
        L_0x011f:
            boolean r12 = r3.equals(r1)
            if (r12 == 0) goto L_0x0242
            androidx.lifecycle.y<com.paytm.paymentsettings.merchantSubscriptions.a.a$a> r11 = r11.f43462i
            com.paytm.paymentsettings.merchantSubscriptions.a.a$a r12 = com.paytm.paymentsettings.merchantSubscriptions.a.a.C0737a.TRUE_POSITIVE
            r11.postValue(r12)
            return
        L_0x012d:
            boolean r0 = r3.equals(r7)
            if (r0 == 0) goto L_0x0242
            goto L_0x0141
        L_0x0134:
            boolean r0 = r3.equals(r8)
            if (r0 == 0) goto L_0x0242
            goto L_0x0141
        L_0x013b:
            boolean r0 = r3.equals(r9)
            if (r0 == 0) goto L_0x0242
        L_0x0141:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionResponseBody r1 = r12.getBody()
            com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionResponseResultInfo r1 = r1.getResultInfo()
            java.lang.String r1 = r1.getStatus()
            r0.append(r1)
            r0.append(r4)
            com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionResponseBody r12 = r12.getBody()
            com.paytm.paymentsettings.merchantSubscriptions.model.EditSubscriptionResponseResultInfo r12 = r12.getResultInfo()
            java.lang.String r12 = r12.getMessage()
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            com.paytm.utility.q.d(r12)
            androidx.lifecycle.y<com.paytm.paymentsettings.merchantSubscriptions.a.a$a> r11 = r11.f43462i
            com.paytm.paymentsettings.merchantSubscriptions.a.a$a r12 = com.paytm.paymentsettings.merchantSubscriptions.a.a.C0737a.FALSE_POSITIVE
            r11.postValue(r12)
            return
        L_0x0176:
            boolean r12 = r3.equals(r10)
            if (r12 == 0) goto L_0x0242
            goto L_0x0183
        L_0x017d:
            boolean r12 = r3.equals(r2)
            if (r12 == 0) goto L_0x0242
        L_0x0183:
            androidx.lifecycle.y<java.lang.Boolean> r11 = r11.l
            java.lang.Boolean r12 = java.lang.Boolean.TRUE
            r11.postValue(r12)
            return
        L_0x018b:
            boolean r0 = r12 instanceof com.paytm.paymentsettings.merchantSubscriptions.model.AuthorisedEditSubscriptionResponse
            if (r0 == 0) goto L_0x0242
            com.paytm.paymentsettings.merchantSubscriptions.model.AuthorisedEditSubscriptionResponse r12 = (com.paytm.paymentsettings.merchantSubscriptions.model.AuthorisedEditSubscriptionResponse) r12
            com.paytm.paymentsettings.merchantSubscriptions.model.AuthorisedEditSubscriptionResponseBody r0 = r12.getBody()
            if (r0 == 0) goto L_0x01a1
            com.paytm.paymentsettings.merchantSubscriptions.model.AuthorisedEditSubscriptionResponseResultInfo r0 = r0.getResultInfo()
            if (r0 == 0) goto L_0x01a1
            java.lang.String r3 = r0.getCode()
        L_0x01a1:
            if (r3 != 0) goto L_0x01a4
            return
        L_0x01a4:
            int r0 = r3.hashCode()
            switch(r0) {
                case 51508: goto L_0x0235;
                case 51509: goto L_0x022e;
                case 56415: goto L_0x01f3;
                case 1567009: goto L_0x01ec;
                case 1567010: goto L_0x01e5;
                case 1567036: goto L_0x01de;
                case 1567043: goto L_0x01d7;
                case 1567104: goto L_0x01c7;
                case 1567131: goto L_0x01be;
                case 1567132: goto L_0x01ad;
                default: goto L_0x01ab;
            }
        L_0x01ab:
            goto L_0x0242
        L_0x01ad:
            java.lang.String r12 = "3043"
            boolean r12 = r3.equals(r12)
            if (r12 == 0) goto L_0x0242
            androidx.lifecycle.y<java.lang.Boolean> r11 = r11.f43459f
            java.lang.Boolean r12 = java.lang.Boolean.TRUE
            r11.postValue(r12)
            goto L_0x0242
        L_0x01be:
            java.lang.String r0 = "3042"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L_0x0242
            goto L_0x01f9
        L_0x01c7:
            java.lang.String r12 = "3036"
            boolean r12 = r3.equals(r12)
            if (r12 == 0) goto L_0x0242
            androidx.lifecycle.y<com.paytm.paymentsettings.merchantSubscriptions.a.a$a> r11 = r11.f43462i
            com.paytm.paymentsettings.merchantSubscriptions.a.a$a r12 = com.paytm.paymentsettings.merchantSubscriptions.a.a.C0737a.TRUE_POSITIVE
            r11.postValue(r12)
            return
        L_0x01d7:
            boolean r0 = r3.equals(r5)
            if (r0 == 0) goto L_0x0242
            goto L_0x01f9
        L_0x01de:
            boolean r0 = r3.equals(r6)
            if (r0 == 0) goto L_0x0242
            goto L_0x01f9
        L_0x01e5:
            boolean r0 = r3.equals(r7)
            if (r0 == 0) goto L_0x0242
            goto L_0x01f9
        L_0x01ec:
            boolean r0 = r3.equals(r8)
            if (r0 == 0) goto L_0x0242
            goto L_0x01f9
        L_0x01f3:
            boolean r0 = r3.equals(r9)
            if (r0 == 0) goto L_0x0242
        L_0x01f9:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.paytm.paymentsettings.merchantSubscriptions.model.AuthorisedEditSubscriptionResponseBody r1 = r12.getBody()
            com.paytm.paymentsettings.merchantSubscriptions.model.AuthorisedEditSubscriptionResponseResultInfo r1 = r1.getResultInfo()
            java.lang.String r1 = r1.getStatus()
            r0.append(r1)
            r0.append(r4)
            com.paytm.paymentsettings.merchantSubscriptions.model.AuthorisedEditSubscriptionResponseBody r12 = r12.getBody()
            com.paytm.paymentsettings.merchantSubscriptions.model.AuthorisedEditSubscriptionResponseResultInfo r12 = r12.getResultInfo()
            java.lang.String r12 = r12.getMessage()
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            com.paytm.utility.q.d(r12)
            androidx.lifecycle.y<com.paytm.paymentsettings.merchantSubscriptions.a.a$a> r11 = r11.f43462i
            com.paytm.paymentsettings.merchantSubscriptions.a.a$a r12 = com.paytm.paymentsettings.merchantSubscriptions.a.a.C0737a.FALSE_POSITIVE
            r11.postValue(r12)
            return
        L_0x022e:
            boolean r12 = r3.equals(r10)
            if (r12 == 0) goto L_0x0242
            goto L_0x023b
        L_0x0235:
            boolean r12 = r3.equals(r2)
            if (r12 == 0) goto L_0x0242
        L_0x023b:
            androidx.lifecycle.y<java.lang.Boolean> r11 = r11.l
            java.lang.Boolean r12 = java.lang.Boolean.TRUE
            r11.postValue(r12)
        L_0x0242:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.paymentsettings.merchantSubscriptions.a.a.a(com.paytm.paymentsettings.merchantSubscriptions.a.a, com.paytm.network.model.IJRPaytmDataModel):void");
    }
}
