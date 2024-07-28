package net.one97.paytm.p2mNewDesign.i;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.w;
import androidx.lifecycle.y;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.p;
import kotlin.x;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import net.one97.paytm.p2mNewDesign.db.PaymentInstrumentDatabase;
import net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse;

public final class c extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    long f51298a;

    /* renamed from: b  reason: collision with root package name */
    LiveData<List<net.one97.paytm.p2mNewDesign.db.b.c>> f51299b = new y();

    /* renamed from: c  reason: collision with root package name */
    public y<net.one97.paytm.p2mNewDesign.db.b.b> f51300c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    List<net.one97.paytm.p2mNewDesign.db.b.a> f51301d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    final PaymentInstrumentDatabase f51302e;

    /* renamed from: f  reason: collision with root package name */
    final String f51303f;

    /* renamed from: g  reason: collision with root package name */
    private w<List<net.one97.paytm.p2mNewDesign.db.b.c>> f51304g = new w<>();

    /* renamed from: h  reason: collision with root package name */
    private final String f51305h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(PaymentInstrumentDatabase paymentInstrumentDatabase, Application application, String str, String str2) {
        super(application);
        kotlin.g.b.k.c(paymentInstrumentDatabase, "database");
        kotlin.g.b.k.c(application, "application");
        kotlin.g.b.k.c(str, "mId");
        kotlin.g.b.k.c(str2, "custId");
        this.f51302e = paymentInstrumentDatabase;
        this.f51303f = str;
        this.f51305h = str2;
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (kotlin.d.f) null, (CoroutineStart) null, new j(this, this.f51305h, this.f51303f, (kotlin.d.d) null), 3, (Object) null);
        Job unused2 = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (kotlin.d.f) null, (CoroutineStart) null, new g(this, (kotlin.d.d) null), 3, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object a(long j2, kotlin.d.d<? super x> dVar) {
        return BuildersKt.withContext(Dispatchers.getIO(), new l(this, j2, (kotlin.d.d) null), dVar);
    }

    @kotlin.d.b.a.f(b = "FJRQRSendMoneyViewModel.kt", c = {110, 116, 130, 133, 135, 136, 156, 159, 162, 163, 166}, d = "invokeSuspend", e = "net/one97/paytm/p2mNewDesign/viewmodel/FJRQRSendMoneyViewModel$updateDB$1")
    static final class m extends kotlin.d.b.a.k implements kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ String $custId;
        final /* synthetic */ String $mId;
        final /* synthetic */ CJRFetchPayMethodResponse $methodResponse;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(c cVar, CJRFetchPayMethodResponse cJRFetchPayMethodResponse, String str, String str2, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = cVar;
            this.$methodResponse = cJRFetchPayMethodResponse;
            this.$custId = str;
            this.$mId = str2;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            m mVar = new m(this.this$0, this.$methodResponse, this.$custId, this.$mId, dVar);
            mVar.p$ = (CoroutineScope) obj;
            return mVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((m) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        public static final class a<T> implements Comparator<T> {
            public final int compare(T t, T t2) {
                return kotlin.b.a.a(Integer.valueOf(((net.one97.paytm.p2mNewDesign.db.b.c) t).f51244d), Integer.valueOf(((net.one97.paytm.p2mNewDesign.db.b.c) t2).f51244d));
            }
        }

        public static final class b<T> implements Comparator<T> {
            public final int compare(T t, T t2) {
                return kotlin.b.a.a(Long.valueOf(((net.one97.paytm.p2mNewDesign.db.b.b) t).f51240f), Long.valueOf(((net.one97.paytm.p2mNewDesign.db.b.b) t2).f51240f));
            }
        }

        /* renamed from: net.one97.paytm.p2mNewDesign.i.c$m$c  reason: collision with other inner class name */
        public static final class C0928c<T> implements Comparator<T> {
            public final int compare(T t, T t2) {
                return kotlin.b.a.a(Long.valueOf(((net.one97.paytm.p2mNewDesign.db.b.b) t).f51240f), Long.valueOf(((net.one97.paytm.p2mNewDesign.db.b.b) t2).f51240f));
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:100:0x0221, code lost:
            if (r5 == null) goto L_0x01f7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:102:0x022b, code lost:
            if ((!r5.isEmpty()) == false) goto L_0x01f7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:103:0x022d, code lost:
            r5.get(0).setBalanceInfo((net.one97.paytm.p2mNewDesign.models.BalanceInfoV2) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:104:0x0237, code lost:
            r14.$methodResponse.body.setOrderId((java.lang.String) null);
            r15 = r14.$custId;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:105:0x0240, code lost:
            if (r15 == null) goto L_0x02eb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:106:0x0242, code lost:
            r2 = r14.this$0;
            r3 = r14.$mId;
            r14.L$0 = r1;
            r14.L$1 = r15;
            r14.L$2 = r2;
            r14.label = 6;
            r3 = r2.a(r15, r3, (kotlin.d.d<? super java.lang.Long>) r14);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:107:0x0253, code lost:
            if (r3 != r0) goto L_0x0256;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:108:0x0255, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:109:0x0256, code lost:
            r12 = r3;
            r3 = r15;
            r15 = r12;
            r13 = r2;
            r2 = r1;
            r1 = r13;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:110:0x025c, code lost:
            r1.f51298a = ((java.lang.Number) r15).longValue();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:111:0x026c, code lost:
            if (r14.this$0.f51298a != 0) goto L_0x02a3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:112:0x026e, code lost:
            r15 = r14.this$0;
            r1 = r14.$methodResponse;
            r14.L$0 = r2;
            r14.L$1 = r3;
            r14.label = 7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:113:0x027d, code lost:
            if (r15.a(r1, (kotlin.d.d<? super kotlin.x>) r14) != r0) goto L_0x0280;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:114:0x027f, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:115:0x0280, code lost:
            r1 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:116:0x0281, code lost:
            r15 = r14.this$0;
            r3 = r14.$mId;
            r14.L$0 = r2;
            r14.L$1 = r1;
            r14.L$2 = r15;
            r14.label = 8;
            r3 = r15.a(r1, r3, (kotlin.d.d<? super java.lang.Long>) r14);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:117:0x0293, code lost:
            if (r3 != r0) goto L_0x0296;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:118:0x0295, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:119:0x0296, code lost:
            r12 = r1;
            r1 = r15;
            r15 = r3;
            r3 = r12;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:120:0x029a, code lost:
            r1.f51298a = ((java.lang.Number) r15).longValue();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:121:0x02a3, code lost:
            r7 = r14.this$0;
            r9 = r7.f51298a;
            r8 = r14.$methodResponse;
            r14.L$0 = r2;
            r14.L$1 = r3;
            r14.label = 9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:122:0x02c4, code lost:
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getIO(), new net.one97.paytm.p2mNewDesign.i.c.n(r7, r8, r9, (kotlin.d.d) null), r14) != r0) goto L_0x02c7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:123:0x02c6, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:124:0x02c7, code lost:
            r5 = r14.this$0;
            r7 = r5.f51298a;
            r6 = r14.$methodResponse;
            r14.L$0 = r2;
            r14.L$1 = r3;
            r14.label = 10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:125:0x02e8, code lost:
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getIO(), new net.one97.paytm.p2mNewDesign.i.c.a(r5, r6, r7, (kotlin.d.d) null), r14) != r0) goto L_0x02eb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:126:0x02ea, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:128:0x02ed, code lost:
            return kotlin.x.f47997a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e6, code lost:
            r1 = (java.util.List) r15;
            r15 = r1.size();
            r5 = net.one97.paytm.wallet.communicator.b.a();
            r6 = net.one97.paytm.wallet.communicator.b.a();
            kotlin.g.b.k.a((java.lang.Object) r6, "WalletCommManager.getWalletCommunicator()");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x0104, code lost:
            if (r15 < r5.getIntegerFromGTM(r6.getContext(), "MaxInstrumentCacheLimitAndroid")) goto L_0x01e1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x0106, code lost:
            r15 = new kotlin.g.b.x.e();
            r15.element = (java.util.List) new java.util.ArrayList();
            r5 = r1.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x011f, code lost:
            if (r5.hasNext() == false) goto L_0x0133;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x0121, code lost:
            r6 = (net.one97.paytm.p2mNewDesign.db.b.b) r5.next();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x0129, code lost:
            if (r6.f51239e != false) goto L_0x011b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x012b, code lost:
            ((java.util.List) r15.element).add(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x013b, code lost:
            if (((java.util.List) r15.element).size() <= 0) goto L_0x01a3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x013d, code lost:
            r5 = r14.this$0.f51299b.getValue();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x0147, code lost:
            if (r5 == null) goto L_0x0159;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x014d, code lost:
            if (r5.size() <= 1) goto L_0x0159;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:68:0x014f, code lost:
            kotlin.a.k.a(r5, new net.one97.paytm.p2mNewDesign.i.c.m.a());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x0159, code lost:
            r5 = (java.util.List) r15.element;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x0161, code lost:
            if (r5.size() <= 1) goto L_0x016d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x0163, code lost:
            kotlin.a.k.a(r5, new net.one97.paytm.p2mNewDesign.i.c.m.b());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x016d, code lost:
            r14.L$0 = r1;
            r14.L$1 = r15;
            r14.label = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:73:0x0184, code lost:
            if (r14.this$0.a((net.one97.paytm.p2mNewDesign.db.b.b) ((java.util.List) r15.element).get(0), (kotlin.d.d<? super kotlin.x>) r14) != r0) goto L_0x0187;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:0x0186, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x0187, code lost:
            r5 = r14.this$0;
            r6 = ((net.one97.paytm.p2mNewDesign.db.b.b) ((java.util.List) r15.element).get(0)).f51235a;
            r14.L$0 = r1;
            r14.L$1 = r15;
            r14.label = 3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x01a0, code lost:
            if (r5.b(r6, r14) != r0) goto L_0x01e1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x01a2, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x01a7, code lost:
            if (r1.size() <= 1) goto L_0x01b3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:80:0x01a9, code lost:
            kotlin.a.k.a(r1, new net.one97.paytm.p2mNewDesign.i.c.m.C0928c());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:0x01b3, code lost:
            r14.L$0 = r1;
            r14.L$1 = r15;
            r14.label = 4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x01c6, code lost:
            if (r14.this$0.a((net.one97.paytm.p2mNewDesign.db.b.b) r1.get(0), (kotlin.d.d<? super kotlin.x>) r14) != r0) goto L_0x01c9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x01c8, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:0x01c9, code lost:
            r5 = r14.this$0;
            r6 = ((net.one97.paytm.p2mNewDesign.db.b.b) r1.get(0)).f51235a;
            r14.L$0 = r1;
            r14.L$1 = r15;
            r14.label = 5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:85:0x01de, code lost:
            if (r5.b(r6, r14) != r0) goto L_0x01e1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:0x01e0, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:87:0x01e1, code lost:
            r15 = r14.$methodResponse.body.getMerchantPayOption();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:0x01e9, code lost:
            if (r15 == null) goto L_0x0237;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x01eb, code lost:
            r15 = r15.getPaymentModes();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x01ef, code lost:
            if (r15 == null) goto L_0x0237;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x01f1, code lost:
            r15 = r15.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:0x01fb, code lost:
            if (r15.hasNext() == false) goto L_0x0237;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:0x01fd, code lost:
            r5 = (net.one97.paytm.p2mNewDesign.models.PaymentModesV2) r15.next();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:95:0x020d, code lost:
            if (kotlin.m.p.a(r5.getPaymentMode(), "BALANCE", true) != false) goto L_0x021b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x0219, code lost:
            if (kotlin.m.p.a(r5.getPaymentMode(), "GIFT_VOUCHER", true) == false) goto L_0x01f7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:98:0x021b, code lost:
            if (r5 == null) goto L_0x01f7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:99:0x021d, code lost:
            r5 = r5.getPayChannelOptions();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                r14 = this;
                kotlin.d.a.a r0 = kotlin.d.a.a.COROUTINE_SUSPENDED
                int r1 = r14.label
                r2 = 0
                r3 = 0
                r4 = 1
                switch(r1) {
                    case 0: goto L_0x00ca;
                    case 1: goto L_0x00c0;
                    case 2: goto L_0x00ab;
                    case 3: goto L_0x009c;
                    case 4: goto L_0x0087;
                    case 5: goto L_0x0078;
                    case 6: goto L_0x005e;
                    case 7: goto L_0x004b;
                    case 8: goto L_0x0031;
                    case 9: goto L_0x001d;
                    case 10: goto L_0x0012;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r15.<init>(r0)
                throw r15
            L_0x0012:
                boolean r0 = r15 instanceof kotlin.p.b
                if (r0 != 0) goto L_0x0018
                goto L_0x02eb
            L_0x0018:
                kotlin.p$b r15 = (kotlin.p.b) r15
                java.lang.Throwable r15 = r15.exception
                throw r15
            L_0x001d:
                java.lang.Object r1 = r14.L$1
                java.lang.String r1 = (java.lang.String) r1
                java.lang.Object r2 = r14.L$0
                java.util.List r2 = (java.util.List) r2
                boolean r3 = r15 instanceof kotlin.p.b
                if (r3 != 0) goto L_0x002c
                r3 = r1
                goto L_0x02c7
            L_0x002c:
                kotlin.p$b r15 = (kotlin.p.b) r15
                java.lang.Throwable r15 = r15.exception
                throw r15
            L_0x0031:
                java.lang.Object r1 = r14.L$2
                net.one97.paytm.p2mNewDesign.i.c r1 = (net.one97.paytm.p2mNewDesign.i.c) r1
                java.lang.Object r2 = r14.L$1
                java.lang.String r2 = (java.lang.String) r2
                java.lang.Object r3 = r14.L$0
                java.util.List r3 = (java.util.List) r3
                boolean r4 = r15 instanceof kotlin.p.b
                if (r4 != 0) goto L_0x0046
                r12 = r3
                r3 = r2
                r2 = r12
                goto L_0x029a
            L_0x0046:
                kotlin.p$b r15 = (kotlin.p.b) r15
                java.lang.Throwable r15 = r15.exception
                throw r15
            L_0x004b:
                java.lang.Object r1 = r14.L$1
                java.lang.String r1 = (java.lang.String) r1
                java.lang.Object r2 = r14.L$0
                java.util.List r2 = (java.util.List) r2
                boolean r3 = r15 instanceof kotlin.p.b
                if (r3 != 0) goto L_0x0059
                goto L_0x0281
            L_0x0059:
                kotlin.p$b r15 = (kotlin.p.b) r15
                java.lang.Throwable r15 = r15.exception
                throw r15
            L_0x005e:
                java.lang.Object r1 = r14.L$2
                net.one97.paytm.p2mNewDesign.i.c r1 = (net.one97.paytm.p2mNewDesign.i.c) r1
                java.lang.Object r2 = r14.L$1
                java.lang.String r2 = (java.lang.String) r2
                java.lang.Object r3 = r14.L$0
                java.util.List r3 = (java.util.List) r3
                boolean r4 = r15 instanceof kotlin.p.b
                if (r4 != 0) goto L_0x0073
                r12 = r3
                r3 = r2
                r2 = r12
                goto L_0x025c
            L_0x0073:
                kotlin.p$b r15 = (kotlin.p.b) r15
                java.lang.Throwable r15 = r15.exception
                throw r15
            L_0x0078:
                java.lang.Object r1 = r14.L$0
                java.util.List r1 = (java.util.List) r1
                boolean r5 = r15 instanceof kotlin.p.b
                if (r5 != 0) goto L_0x0082
                goto L_0x01e1
            L_0x0082:
                kotlin.p$b r15 = (kotlin.p.b) r15
                java.lang.Throwable r15 = r15.exception
                throw r15
            L_0x0087:
                java.lang.Object r1 = r14.L$1
                kotlin.g.b.x$e r1 = (kotlin.g.b.x.e) r1
                java.lang.Object r5 = r14.L$0
                java.util.List r5 = (java.util.List) r5
                boolean r6 = r15 instanceof kotlin.p.b
                if (r6 != 0) goto L_0x0097
                r15 = r1
                r1 = r5
                goto L_0x01c9
            L_0x0097:
                kotlin.p$b r15 = (kotlin.p.b) r15
                java.lang.Throwable r15 = r15.exception
                throw r15
            L_0x009c:
                java.lang.Object r1 = r14.L$0
                java.util.List r1 = (java.util.List) r1
                boolean r5 = r15 instanceof kotlin.p.b
                if (r5 != 0) goto L_0x00a6
                goto L_0x01e1
            L_0x00a6:
                kotlin.p$b r15 = (kotlin.p.b) r15
                java.lang.Throwable r15 = r15.exception
                throw r15
            L_0x00ab:
                java.lang.Object r1 = r14.L$1
                kotlin.g.b.x$e r1 = (kotlin.g.b.x.e) r1
                java.lang.Object r5 = r14.L$0
                java.util.List r5 = (java.util.List) r5
                boolean r6 = r15 instanceof kotlin.p.b
                if (r6 != 0) goto L_0x00bb
                r15 = r1
                r1 = r5
                goto L_0x0187
            L_0x00bb:
                kotlin.p$b r15 = (kotlin.p.b) r15
                java.lang.Throwable r15 = r15.exception
                throw r15
            L_0x00c0:
                boolean r1 = r15 instanceof kotlin.p.b
                if (r1 != 0) goto L_0x00c5
                goto L_0x00e6
            L_0x00c5:
                kotlin.p$b r15 = (kotlin.p.b) r15
                java.lang.Throwable r15 = r15.exception
                throw r15
            L_0x00ca:
                boolean r1 = r15 instanceof kotlin.p.b
                if (r1 != 0) goto L_0x02ee
                net.one97.paytm.p2mNewDesign.i.c r15 = r14.this$0
                r14.label = r4
                kotlinx.coroutines.CoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getIO()
                kotlin.d.f r1 = (kotlin.d.f) r1
                net.one97.paytm.p2mNewDesign.i.c$k r5 = new net.one97.paytm.p2mNewDesign.i.c$k
                r5.<init>(r15, r2)
                kotlin.g.a.m r5 = (kotlin.g.a.m) r5
                java.lang.Object r15 = kotlinx.coroutines.BuildersKt.withContext(r1, r5, r14)
                if (r15 != r0) goto L_0x00e6
                return r0
            L_0x00e6:
                r1 = r15
                java.util.List r1 = (java.util.List) r1
                int r15 = r1.size()
                net.one97.paytm.wallet.communicator.c r5 = net.one97.paytm.wallet.communicator.b.a()
                net.one97.paytm.wallet.communicator.c r6 = net.one97.paytm.wallet.communicator.b.a()
                java.lang.String r7 = "WalletCommManager.getWalletCommunicator()"
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
                android.content.Context r6 = r6.getContext()
                java.lang.String r7 = "MaxInstrumentCacheLimitAndroid"
                int r5 = r5.getIntegerFromGTM((android.content.Context) r6, (java.lang.String) r7)
                if (r15 < r5) goto L_0x01e1
                kotlin.g.b.x$e r15 = new kotlin.g.b.x$e
                r15.<init>()
                java.util.ArrayList r5 = new java.util.ArrayList
                r5.<init>()
                java.util.List r5 = (java.util.List) r5
                r15.element = r5
                r5 = r1
                java.lang.Iterable r5 = (java.lang.Iterable) r5
                java.util.Iterator r5 = r5.iterator()
            L_0x011b:
                boolean r6 = r5.hasNext()
                if (r6 == 0) goto L_0x0133
                java.lang.Object r6 = r5.next()
                net.one97.paytm.p2mNewDesign.db.b.b r6 = (net.one97.paytm.p2mNewDesign.db.b.b) r6
                boolean r7 = r6.f51239e
                if (r7 != 0) goto L_0x011b
                T r7 = r15.element
                java.util.List r7 = (java.util.List) r7
                r7.add(r6)
                goto L_0x011b
            L_0x0133:
                T r5 = r15.element
                java.util.List r5 = (java.util.List) r5
                int r5 = r5.size()
                if (r5 <= 0) goto L_0x01a3
                net.one97.paytm.p2mNewDesign.i.c r5 = r14.this$0
                androidx.lifecycle.LiveData<java.util.List<net.one97.paytm.p2mNewDesign.db.b.c>> r5 = r5.f51299b
                java.lang.Object r5 = r5.getValue()
                java.util.List r5 = (java.util.List) r5
                if (r5 == 0) goto L_0x0159
                int r6 = r5.size()
                if (r6 <= r4) goto L_0x0159
                net.one97.paytm.p2mNewDesign.i.c$m$a r6 = new net.one97.paytm.p2mNewDesign.i.c$m$a
                r6.<init>()
                java.util.Comparator r6 = (java.util.Comparator) r6
                kotlin.a.k.a(r5, r6)
            L_0x0159:
                T r5 = r15.element
                java.util.List r5 = (java.util.List) r5
                int r6 = r5.size()
                if (r6 <= r4) goto L_0x016d
                net.one97.paytm.p2mNewDesign.i.c$m$b r6 = new net.one97.paytm.p2mNewDesign.i.c$m$b
                r6.<init>()
                java.util.Comparator r6 = (java.util.Comparator) r6
                kotlin.a.k.a(r5, r6)
            L_0x016d:
                net.one97.paytm.p2mNewDesign.i.c r5 = r14.this$0
                T r6 = r15.element
                java.util.List r6 = (java.util.List) r6
                java.lang.Object r6 = r6.get(r3)
                net.one97.paytm.p2mNewDesign.db.b.b r6 = (net.one97.paytm.p2mNewDesign.db.b.b) r6
                r14.L$0 = r1
                r14.L$1 = r15
                r7 = 2
                r14.label = r7
                java.lang.Object r5 = r5.a((net.one97.paytm.p2mNewDesign.db.b.b) r6, (kotlin.d.d<? super kotlin.x>) r14)
                if (r5 != r0) goto L_0x0187
                return r0
            L_0x0187:
                net.one97.paytm.p2mNewDesign.i.c r5 = r14.this$0
                T r6 = r15.element
                java.util.List r6 = (java.util.List) r6
                java.lang.Object r6 = r6.get(r3)
                net.one97.paytm.p2mNewDesign.db.b.b r6 = (net.one97.paytm.p2mNewDesign.db.b.b) r6
                long r6 = r6.f51235a
                r14.L$0 = r1
                r14.L$1 = r15
                r15 = 3
                r14.label = r15
                java.lang.Object r15 = r5.b(r6, r14)
                if (r15 != r0) goto L_0x01e1
                return r0
            L_0x01a3:
                int r5 = r1.size()
                if (r5 <= r4) goto L_0x01b3
                net.one97.paytm.p2mNewDesign.i.c$m$c r5 = new net.one97.paytm.p2mNewDesign.i.c$m$c
                r5.<init>()
                java.util.Comparator r5 = (java.util.Comparator) r5
                kotlin.a.k.a(r1, r5)
            L_0x01b3:
                net.one97.paytm.p2mNewDesign.i.c r5 = r14.this$0
                java.lang.Object r6 = r1.get(r3)
                net.one97.paytm.p2mNewDesign.db.b.b r6 = (net.one97.paytm.p2mNewDesign.db.b.b) r6
                r14.L$0 = r1
                r14.L$1 = r15
                r7 = 4
                r14.label = r7
                java.lang.Object r5 = r5.a((net.one97.paytm.p2mNewDesign.db.b.b) r6, (kotlin.d.d<? super kotlin.x>) r14)
                if (r5 != r0) goto L_0x01c9
                return r0
            L_0x01c9:
                net.one97.paytm.p2mNewDesign.i.c r5 = r14.this$0
                java.lang.Object r6 = r1.get(r3)
                net.one97.paytm.p2mNewDesign.db.b.b r6 = (net.one97.paytm.p2mNewDesign.db.b.b) r6
                long r6 = r6.f51235a
                r14.L$0 = r1
                r14.L$1 = r15
                r15 = 5
                r14.label = r15
                java.lang.Object r15 = r5.b(r6, r14)
                if (r15 != r0) goto L_0x01e1
                return r0
            L_0x01e1:
                net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse r15 = r14.$methodResponse
                net.one97.paytm.p2mNewDesign.models.BodyV2 r15 = r15.body
                net.one97.paytm.p2mNewDesign.models.MerchantPayOptionV2 r15 = r15.getMerchantPayOption()
                if (r15 == 0) goto L_0x0237
                java.util.ArrayList r15 = r15.getPaymentModes()
                if (r15 == 0) goto L_0x0237
                java.lang.Iterable r15 = (java.lang.Iterable) r15
                java.util.Iterator r15 = r15.iterator()
            L_0x01f7:
                boolean r5 = r15.hasNext()
                if (r5 == 0) goto L_0x0237
                java.lang.Object r5 = r15.next()
                net.one97.paytm.p2mNewDesign.models.PaymentModesV2 r5 = (net.one97.paytm.p2mNewDesign.models.PaymentModesV2) r5
                java.lang.String r6 = r5.getPaymentMode()
                java.lang.String r7 = "BALANCE"
                boolean r6 = kotlin.m.p.a((java.lang.String) r6, (java.lang.String) r7, (boolean) r4)
                if (r6 != 0) goto L_0x021b
                java.lang.String r6 = r5.getPaymentMode()
                java.lang.String r7 = "GIFT_VOUCHER"
                boolean r6 = kotlin.m.p.a((java.lang.String) r6, (java.lang.String) r7, (boolean) r4)
                if (r6 == 0) goto L_0x01f7
            L_0x021b:
                if (r5 == 0) goto L_0x01f7
                java.util.ArrayList r5 = r5.getPayChannelOptions()
                if (r5 == 0) goto L_0x01f7
                r6 = r5
                java.util.Collection r6 = (java.util.Collection) r6
                boolean r6 = r6.isEmpty()
                r6 = r6 ^ r4
                if (r6 == 0) goto L_0x01f7
                java.lang.Object r5 = r5.get(r3)
                net.one97.paytm.p2mNewDesign.models.PayChannelOptionsV2 r5 = (net.one97.paytm.p2mNewDesign.models.PayChannelOptionsV2) r5
                r5.setBalanceInfo(r2)
                goto L_0x01f7
            L_0x0237:
                net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse r15 = r14.$methodResponse
                net.one97.paytm.p2mNewDesign.models.BodyV2 r15 = r15.body
                r15.setOrderId(r2)
                java.lang.String r15 = r14.$custId
                if (r15 == 0) goto L_0x02eb
                net.one97.paytm.p2mNewDesign.i.c r2 = r14.this$0
                java.lang.String r3 = r14.$mId
                r14.L$0 = r1
                r14.L$1 = r15
                r14.L$2 = r2
                r4 = 6
                r14.label = r4
                java.lang.Object r3 = r2.a((java.lang.String) r15, (java.lang.String) r3, (kotlin.d.d<? super java.lang.Long>) r14)
                if (r3 != r0) goto L_0x0256
                return r0
            L_0x0256:
                r12 = r3
                r3 = r15
                r15 = r12
                r13 = r2
                r2 = r1
                r1 = r13
            L_0x025c:
                java.lang.Number r15 = (java.lang.Number) r15
                long r4 = r15.longValue()
                r1.f51298a = r4
                net.one97.paytm.p2mNewDesign.i.c r15 = r14.this$0
                long r4 = r15.f51298a
                r6 = 0
                int r15 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r15 != 0) goto L_0x02a3
                net.one97.paytm.p2mNewDesign.i.c r15 = r14.this$0
                net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse r1 = r14.$methodResponse
                r14.L$0 = r2
                r14.L$1 = r3
                r4 = 7
                r14.label = r4
                java.lang.Object r15 = r15.a((net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse) r1, (kotlin.d.d<? super kotlin.x>) r14)
                if (r15 != r0) goto L_0x0280
                return r0
            L_0x0280:
                r1 = r3
            L_0x0281:
                net.one97.paytm.p2mNewDesign.i.c r15 = r14.this$0
                java.lang.String r3 = r14.$mId
                r14.L$0 = r2
                r14.L$1 = r1
                r14.L$2 = r15
                r4 = 8
                r14.label = r4
                java.lang.Object r3 = r15.a((java.lang.String) r1, (java.lang.String) r3, (kotlin.d.d<? super java.lang.Long>) r14)
                if (r3 != r0) goto L_0x0296
                return r0
            L_0x0296:
                r12 = r1
                r1 = r15
                r15 = r3
                r3 = r12
            L_0x029a:
                java.lang.Number r15 = (java.lang.Number) r15
                long r4 = r15.longValue()
                r1.f51298a = r4
                goto L_0x02c7
            L_0x02a3:
                net.one97.paytm.p2mNewDesign.i.c r7 = r14.this$0
                long r9 = r7.f51298a
                net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse r8 = r14.$methodResponse
                r14.L$0 = r2
                r14.L$1 = r3
                r15 = 9
                r14.label = r15
                kotlinx.coroutines.CoroutineDispatcher r15 = kotlinx.coroutines.Dispatchers.getIO()
                kotlin.d.f r15 = (kotlin.d.f) r15
                net.one97.paytm.p2mNewDesign.i.c$n r1 = new net.one97.paytm.p2mNewDesign.i.c$n
                r11 = 0
                r6 = r1
                r6.<init>(r7, r8, r9, r11)
                kotlin.g.a.m r1 = (kotlin.g.a.m) r1
                java.lang.Object r15 = kotlinx.coroutines.BuildersKt.withContext(r15, r1, r14)
                if (r15 != r0) goto L_0x02c7
                return r0
            L_0x02c7:
                net.one97.paytm.p2mNewDesign.i.c r5 = r14.this$0
                long r7 = r5.f51298a
                net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse r6 = r14.$methodResponse
                r14.L$0 = r2
                r14.L$1 = r3
                r15 = 10
                r14.label = r15
                kotlinx.coroutines.CoroutineDispatcher r15 = kotlinx.coroutines.Dispatchers.getIO()
                kotlin.d.f r15 = (kotlin.d.f) r15
                net.one97.paytm.p2mNewDesign.i.c$a r1 = new net.one97.paytm.p2mNewDesign.i.c$a
                r9 = 0
                r4 = r1
                r4.<init>(r5, r6, r7, r9)
                kotlin.g.a.m r1 = (kotlin.g.a.m) r1
                java.lang.Object r15 = kotlinx.coroutines.BuildersKt.withContext(r15, r1, r14)
                if (r15 != r0) goto L_0x02eb
                return r0
            L_0x02eb:
                kotlin.x r15 = kotlin.x.f47997a
                return r15
            L_0x02ee:
                kotlin.p$b r15 = (kotlin.p.b) r15
                java.lang.Throwable r15 = r15.exception
                throw r15
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.i.c.m.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void a(CJRFetchPayMethodResponse cJRFetchPayMethodResponse, String str, String str2) {
        kotlin.g.b.k.c(cJRFetchPayMethodResponse, "methodResponse");
        kotlin.g.b.k.c(str2, "mId");
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (kotlin.d.f) null, (CoroutineStart) null, new m(this, cJRFetchPayMethodResponse, str, str2, (kotlin.d.d) null), 3, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object b(long j2, kotlin.d.d<? super x> dVar) {
        return BuildersKt.withContext(Dispatchers.getIO(), new d(this, j2, (kotlin.d.d) null), dVar);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object a(net.one97.paytm.p2mNewDesign.db.b.b bVar, kotlin.d.d<? super x> dVar) {
        return BuildersKt.withContext(Dispatchers.getIO(), new f(this, bVar, (kotlin.d.d) null), dVar);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object a(CJRFetchPayMethodResponse cJRFetchPayMethodResponse, kotlin.d.d<? super x> dVar) {
        return BuildersKt.withContext(Dispatchers.getIO(), new b(this, cJRFetchPayMethodResponse, (kotlin.d.d) null), dVar);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object a(String str, String str2, kotlin.d.d<? super Long> dVar) {
        return BuildersKt.withContext(Dispatchers.getIO(), new i(this, str, str2, (kotlin.d.d) null), dVar);
    }

    @kotlin.d.b.a.f(b = "FJRQRSendMoneyViewModel.kt", c = {215}, d = "invokeSuspend", e = "net/one97/paytm/p2mNewDesign/viewmodel/FJRQRSendMoneyViewModel$addRecordInInstrumentTable$2")
    static final class a extends kotlin.d.b.a.k implements kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ long $mapId;
        final /* synthetic */ CJRFetchPayMethodResponse $methodResponse;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(c cVar, CJRFetchPayMethodResponse cJRFetchPayMethodResponse, long j, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = cVar;
            this.$methodResponse = cJRFetchPayMethodResponse;
            this.$mapId = j;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            a aVar = new a(this.this$0, this.$methodResponse, this.$mapId, dVar);
            aVar.p$ = (CoroutineScope) obj;
            return aVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((a) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
            r2 = r2.getMerchantPayOption();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                r19 = this;
                r0 = r19
                r1 = r20
                kotlin.d.a.a r2 = kotlin.d.a.a.COROUTINE_SUSPENDED
                int r2 = r0.label
                if (r2 != 0) goto L_0x0226
                boolean r2 = r1 instanceof kotlin.p.b
                if (r2 != 0) goto L_0x0221
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>()
                java.util.List r1 = (java.util.List) r1
                net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse r2 = r0.$methodResponse
                net.one97.paytm.p2mNewDesign.models.BodyV2 r2 = r2.body
                r3 = 0
                if (r2 == 0) goto L_0x0027
                net.one97.paytm.p2mNewDesign.models.MerchantPayOptionV2 r2 = r2.getMerchantPayOption()
                if (r2 == 0) goto L_0x0027
                java.util.ArrayList r2 = r2.getPaymentModes()
                goto L_0x0028
            L_0x0027:
                r2 = r3
            L_0x0028:
                java.lang.String r4 = "instrumentDetail"
                java.lang.String r5 = ""
                if (r2 == 0) goto L_0x0198
                java.lang.Iterable r2 = (java.lang.Iterable) r2
                java.util.Iterator r2 = r2.iterator()
            L_0x0034:
                boolean r6 = r2.hasNext()
                if (r6 == 0) goto L_0x0196
                java.lang.Object r6 = r2.next()
                net.one97.paytm.p2mNewDesign.models.PaymentModesV2 r6 = (net.one97.paytm.p2mNewDesign.models.PaymentModesV2) r6
                java.lang.String r7 = r6.getDisplayName()
                r8 = 1
                java.lang.String r9 = "BHIM UPI"
                boolean r7 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r9, (boolean) r8)
                if (r7 == 0) goto L_0x0159
                net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse r7 = r0.$methodResponse
                net.one97.paytm.p2mNewDesign.models.BodyV2 r7 = r7.body
                if (r7 == 0) goto L_0x005e
                net.one97.paytm.p2mNewDesign.models.MerchantPayOptionV2 r7 = r7.getMerchantPayOption()
                if (r7 == 0) goto L_0x005e
                net.one97.paytm.p2mNewDesign.models.UserProfileSarvatraV2 r7 = r7.getUserProfileSarvatra()
                goto L_0x005f
            L_0x005e:
                r7 = r3
            L_0x005f:
                net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse r9 = r0.$methodResponse
                net.one97.paytm.p2mNewDesign.models.BodyV2 r9 = r9.body
                if (r9 == 0) goto L_0x0070
                net.one97.paytm.p2mNewDesign.models.MerchantPayOptionV2 r9 = r9.getMerchantPayOption()
                if (r9 == 0) goto L_0x0070
                net.one97.paytm.p2mNewDesign.models.UPIProfileV2 r9 = r9.getUpiProfile()
                goto L_0x0071
            L_0x0070:
                r9 = r3
            L_0x0071:
                if (r7 == 0) goto L_0x007e
                net.one97.paytm.p2mNewDesign.models.ResponseV2 r10 = r7.getResponse()
                if (r10 == 0) goto L_0x007e
                java.util.ArrayList r10 = r10.getBankAccounts()
                goto L_0x007f
            L_0x007e:
                r10 = r3
            L_0x007f:
                r11 = 0
                if (r10 == 0) goto L_0x0099
                if (r7 == 0) goto L_0x0097
                net.one97.paytm.p2mNewDesign.models.ResponseV2 r10 = r7.getResponse()
                if (r10 == 0) goto L_0x0097
                java.util.ArrayList r10 = r10.getBankAccounts()
                if (r10 == 0) goto L_0x0097
                int r10 = r10.size()
                if (r10 != 0) goto L_0x0097
                goto L_0x0099
            L_0x0097:
                r10 = 0
                goto L_0x009a
            L_0x0099:
                r10 = 1
            L_0x009a:
                if (r9 == 0) goto L_0x00ad
                net.one97.paytm.p2mNewDesign.models.RespDetailsV2 r12 = r9.getRespDetails()
                if (r12 == 0) goto L_0x00ad
                net.one97.paytm.p2mNewDesign.models.ProfileDetailV2 r12 = r12.getProfileDetail()
                if (r12 == 0) goto L_0x00ad
                java.util.ArrayList r12 = r12.getVpaDetails()
                goto L_0x00ae
            L_0x00ad:
                r12 = r3
            L_0x00ae:
                if (r12 == 0) goto L_0x00cc
                if (r9 == 0) goto L_0x00cb
                net.one97.paytm.p2mNewDesign.models.RespDetailsV2 r9 = r9.getRespDetails()
                if (r9 == 0) goto L_0x00cb
                net.one97.paytm.p2mNewDesign.models.ProfileDetailV2 r9 = r9.getProfileDetail()
                if (r9 == 0) goto L_0x00cb
                java.util.ArrayList r9 = r9.getVpaDetails()
                if (r9 == 0) goto L_0x00cb
                int r9 = r9.size()
                if (r9 != 0) goto L_0x00cb
                goto L_0x00cc
            L_0x00cb:
                r8 = 0
            L_0x00cc:
                if (r8 != 0) goto L_0x0034
                if (r10 != 0) goto L_0x0034
                com.google.gson.f r9 = new com.google.gson.f
                r9.<init>()
                if (r8 != 0) goto L_0x0111
                if (r7 == 0) goto L_0x00de
                net.one97.paytm.p2mNewDesign.models.ResponseV2 r7 = r7.getResponse()
                goto L_0x00df
            L_0x00de:
                r7 = r3
            L_0x00df:
                java.lang.Class<net.one97.paytm.p2mNewDesign.models.UPIProfileV2> r8 = net.one97.paytm.p2mNewDesign.models.UPIProfileV2.class
                java.lang.reflect.Type r8 = (java.lang.reflect.Type) r8
                java.lang.String r15 = r9.a((java.lang.Object) r7, (java.lang.reflect.Type) r8)
                java.lang.String r7 = "gson.toJson(userProfileS…UPIProfileV2::class.java)"
                kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r7)
                long r11 = r0.$mapId
                java.lang.String r7 = r6.getDisplayName()
                if (r7 != 0) goto L_0x00f6
                r13 = r5
                goto L_0x00f7
            L_0x00f6:
                r13 = r7
            L_0x00f7:
                java.lang.String r6 = r6.getPriority()
                if (r6 != 0) goto L_0x0100
                kotlin.g.b.k.a()
            L_0x0100:
                int r14 = java.lang.Integer.parseInt(r6)
                long r16 = java.lang.System.currentTimeMillis()
                net.one97.paytm.p2mNewDesign.db.b.c r6 = new net.one97.paytm.p2mNewDesign.db.b.c
                r18 = 0
                r10 = r6
                r10.<init>(r11, r13, r14, r15, r16, r18)
                goto L_0x014e
            L_0x0111:
                if (r10 == 0) goto L_0x014d
                if (r7 == 0) goto L_0x011a
                net.one97.paytm.p2mNewDesign.models.ResponseV2 r7 = r7.getResponse()
                goto L_0x011b
            L_0x011a:
                r7 = r3
            L_0x011b:
                java.lang.Class<net.one97.paytm.p2mNewDesign.models.UserProfileSarvatraV2> r8 = net.one97.paytm.p2mNewDesign.models.UserProfileSarvatraV2.class
                java.lang.reflect.Type r8 = (java.lang.reflect.Type) r8
                java.lang.String r15 = r9.a((java.lang.Object) r7, (java.lang.reflect.Type) r8)
                java.lang.String r7 = "gson.toJson(userProfileS…leSarvatraV2::class.java)"
                kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r7)
                long r11 = r0.$mapId
                java.lang.String r7 = r6.getDisplayName()
                if (r7 != 0) goto L_0x0132
                r13 = r5
                goto L_0x0133
            L_0x0132:
                r13 = r7
            L_0x0133:
                java.lang.String r6 = r6.getPriority()
                if (r6 != 0) goto L_0x013c
                kotlin.g.b.k.a()
            L_0x013c:
                int r14 = java.lang.Integer.parseInt(r6)
                long r16 = java.lang.System.currentTimeMillis()
                net.one97.paytm.p2mNewDesign.db.b.c r6 = new net.one97.paytm.p2mNewDesign.db.b.c
                r18 = 0
                r10 = r6
                r10.<init>(r11, r13, r14, r15, r16, r18)
                goto L_0x014e
            L_0x014d:
                r6 = r3
            L_0x014e:
                if (r6 == 0) goto L_0x0034
                boolean r6 = r1.add(r6)
                java.lang.Boolean.valueOf(r6)
                goto L_0x0034
            L_0x0159:
                com.google.gson.f r7 = new com.google.gson.f
                r7.<init>()
                java.lang.Class<net.one97.paytm.p2mNewDesign.models.PaymentModesV2> r8 = net.one97.paytm.p2mNewDesign.models.PaymentModesV2.class
                java.lang.reflect.Type r8 = (java.lang.reflect.Type) r8
                java.lang.String r14 = r7.a((java.lang.Object) r6, (java.lang.reflect.Type) r8)
                long r10 = r0.$mapId
                java.lang.String r7 = r6.getDisplayName()
                if (r7 != 0) goto L_0x0170
                r12 = r5
                goto L_0x0171
            L_0x0170:
                r12 = r7
            L_0x0171:
                kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r4)
                java.lang.String r6 = r6.getPriority()
                if (r6 != 0) goto L_0x017d
                kotlin.g.b.k.a()
            L_0x017d:
                int r13 = java.lang.Integer.parseInt(r6)
                long r15 = java.lang.System.currentTimeMillis()
                net.one97.paytm.p2mNewDesign.db.b.c r6 = new net.one97.paytm.p2mNewDesign.db.b.c
                r17 = 0
                r9 = r6
                r9.<init>(r10, r12, r13, r14, r15, r17)
                boolean r6 = r1.add(r6)
                java.lang.Boolean.valueOf(r6)
                goto L_0x0034
            L_0x0196:
                kotlin.x r2 = kotlin.x.f47997a
            L_0x0198:
                net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse r2 = r0.$methodResponse
                net.one97.paytm.p2mNewDesign.models.BodyV2 r2 = r2.body
                if (r2 == 0) goto L_0x01a8
                net.one97.paytm.p2mNewDesign.models.MerchantPayOptionV2 r2 = r2.getMerchantPayOption()
                if (r2 == 0) goto L_0x01a8
                java.util.ArrayList r3 = r2.getSavedInstruments()
            L_0x01a8:
                if (r3 == 0) goto L_0x01fa
                java.lang.Iterable r3 = (java.lang.Iterable) r3
                java.util.Iterator r2 = r3.iterator()
            L_0x01b0:
                boolean r3 = r2.hasNext()
                if (r3 == 0) goto L_0x01f8
                java.lang.Object r3 = r2.next()
                net.one97.paytm.p2mNewDesign.models.SavedInstrumentsV2 r3 = (net.one97.paytm.p2mNewDesign.models.SavedInstrumentsV2) r3
                com.google.gson.f r6 = new com.google.gson.f
                r6.<init>()
                java.lang.Class<net.one97.paytm.p2mNewDesign.models.SavedInstrumentsV2> r7 = net.one97.paytm.p2mNewDesign.models.SavedInstrumentsV2.class
                java.lang.reflect.Type r7 = (java.lang.reflect.Type) r7
                java.lang.String r13 = r6.a((java.lang.Object) r3, (java.lang.reflect.Type) r7)
                long r9 = r0.$mapId
                java.lang.String r6 = r3.getDisplayName()
                if (r6 != 0) goto L_0x01d3
                r11 = r5
                goto L_0x01d4
            L_0x01d3:
                r11 = r6
            L_0x01d4:
                kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r4)
                java.lang.String r3 = r3.getPriority()
                if (r3 != 0) goto L_0x01e0
                kotlin.g.b.k.a()
            L_0x01e0:
                int r12 = java.lang.Integer.parseInt(r3)
                long r14 = java.lang.System.currentTimeMillis()
                net.one97.paytm.p2mNewDesign.db.b.c r3 = new net.one97.paytm.p2mNewDesign.db.b.c
                r16 = 0
                r8 = r3
                r8.<init>(r9, r11, r12, r13, r14, r16)
                boolean r3 = r1.add(r3)
                java.lang.Boolean.valueOf(r3)
                goto L_0x01b0
            L_0x01f8:
                kotlin.x r2 = kotlin.x.f47997a
            L_0x01fa:
                int r2 = r1.size()
                if (r2 <= 0) goto L_0x021e
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.Iterator r1 = r1.iterator()
            L_0x0206:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x021e
                java.lang.Object r2 = r1.next()
                net.one97.paytm.p2mNewDesign.db.b.c r2 = (net.one97.paytm.p2mNewDesign.db.b.c) r2
                net.one97.paytm.p2mNewDesign.i.c r3 = r0.this$0
                net.one97.paytm.p2mNewDesign.db.PaymentInstrumentDatabase r3 = r3.f51302e
                net.one97.paytm.p2mNewDesign.db.a.e r3 = r3.b()
                r3.a((net.one97.paytm.p2mNewDesign.db.b.c) r2)
                goto L_0x0206
            L_0x021e:
                kotlin.x r1 = kotlin.x.f47997a
                return r1
            L_0x0221:
                kotlin.p$b r1 = (kotlin.p.b) r1
                java.lang.Throwable r1 = r1.exception
                throw r1
            L_0x0226:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.i.c.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.d.b.a.f(b = "FJRQRSendMoneyViewModel.kt", c = {199}, d = "invokeSuspend", e = "net/one97/paytm/p2mNewDesign/viewmodel/FJRQRSendMoneyViewModel$addRecordInMappingTable$2")
    static final class b extends kotlin.d.b.a.k implements kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ CJRFetchPayMethodResponse $methodResponse;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(c cVar, CJRFetchPayMethodResponse cJRFetchPayMethodResponse, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = cVar;
            this.$methodResponse = cJRFetchPayMethodResponse;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            b bVar = new b(this.this$0, this.$methodResponse, dVar);
            bVar.p$ = (CoroutineScope) obj;
            return bVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((b) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else if (!(obj instanceof p.b)) {
                String a2 = new com.google.gson.f().a((Object) this.$methodResponse, (Type) CJRFetchPayMethodResponse.class);
                String n = com.paytm.utility.b.n((Context) this.this$0.getApplication());
                kotlin.g.b.k.a((Object) n, "CJRAppCommonUtility.getUserId(getApplication())");
                String str = this.this$0.f51303f;
                long currentTimeMillis = System.currentTimeMillis();
                kotlin.g.b.k.a((Object) a2, "jsonBody");
                this.this$0.f51302e.c().a(new net.one97.paytm.p2mNewDesign.db.b.b(n, str, a2, currentTimeMillis));
                return x.f47997a;
            } else {
                throw ((p.b) obj).exception;
            }
        }
    }

    @kotlin.d.b.a.f(b = "FJRQRSendMoneyViewModel.kt", c = {277}, d = "invokeSuspend", e = "net/one97/paytm/p2mNewDesign/viewmodel/FJRQRSendMoneyViewModel$deleteCachingByMerchantId$2")
    /* renamed from: net.one97.paytm.p2mNewDesign.i.c$c  reason: collision with other inner class name */
    static final class C0927c extends kotlin.d.b.a.k implements kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ String $mId;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0927c(c cVar, String str, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = cVar;
            this.$mId = str;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            C0927c cVar = new C0927c(this.this$0, this.$mId, dVar);
            cVar.p$ = (CoroutineScope) obj;
            return cVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((C0927c) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else if (!(obj instanceof p.b)) {
                this.this$0.f51302e.c().a(this.$mId);
                return x.f47997a;
            } else {
                throw ((p.b) obj).exception;
            }
        }
    }

    @kotlin.d.b.a.f(b = "FJRQRSendMoneyViewModel.kt", c = {172}, d = "invokeSuspend", e = "net/one97/paytm/p2mNewDesign/viewmodel/FJRQRSendMoneyViewModel$deleteInstrumentsForThisRecordFromInstrumentTable$2")
    static final class d extends kotlin.d.b.a.k implements kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ long $mapId;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(c cVar, long j, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = cVar;
            this.$mapId = j;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            d dVar2 = new d(this.this$0, this.$mapId, dVar);
            dVar2.p$ = (CoroutineScope) obj;
            return dVar2;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((d) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else if (!(obj instanceof p.b)) {
                this.this$0.f51302e.b().a(this.$mapId);
                return x.f47997a;
            } else {
                throw ((p.b) obj).exception;
            }
        }
    }

    @kotlin.d.b.a.f(b = "FJRQRSendMoneyViewModel.kt", c = {271, 273}, d = "invokeSuspend", e = "net/one97/paytm/p2mNewDesign/viewmodel/FJRQRSendMoneyViewModel$deletePaymentInstruments$1")
    public static final class e extends kotlin.d.b.a.k implements kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ String $mId;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(c cVar, String str, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = cVar;
            this.$mId = str;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            e eVar = new e(this.this$0, this.$mId, dVar);
            eVar.p$ = (CoroutineScope) obj;
            return eVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((e) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else if (obj instanceof p.b) {
                    throw ((p.b) obj).exception;
                }
            } else if (!(obj instanceof p.b)) {
                c cVar = this.this$0;
                String str = this.$mId;
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getIO(), new C0927c(cVar, str, (kotlin.d.d) null), this) == aVar) {
                    return aVar;
                }
            } else {
                throw ((p.b) obj).exception;
            }
            return x.f47997a;
        }
    }

    @kotlin.d.b.a.f(b = "FJRQRSendMoneyViewModel.kt", c = {178}, d = "invokeSuspend", e = "net/one97/paytm/p2mNewDesign/viewmodel/FJRQRSendMoneyViewModel$deleteRecordFromMappingTable$2")
    static final class f extends kotlin.d.b.a.k implements kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ net.one97.paytm.p2mNewDesign.db.b.b $record;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(c cVar, net.one97.paytm.p2mNewDesign.db.b.b bVar, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = cVar;
            this.$record = bVar;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            f fVar = new f(this.this$0, this.$record, dVar);
            fVar.p$ = (CoroutineScope) obj;
            return fVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((f) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else if (!(obj instanceof p.b)) {
                this.this$0.f51302e.c().c(this.$record);
                return x.f47997a;
            } else {
                throw ((p.b) obj).exception;
            }
        }
    }

    @kotlin.d.b.a.f(b = "FJRQRSendMoneyViewModel.kt", c = {58, 61}, d = "invokeSuspend", e = "net/one97/paytm/p2mNewDesign/viewmodel/FJRQRSendMoneyViewModel$getLastUsedInstrumentFromDB$1")
    static final class g extends kotlin.d.b.a.k implements kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        int label;
        private CoroutineScope p$;
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(c cVar, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = cVar;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            g gVar = new g(this.this$0, dVar);
            gVar.p$ = (CoroutineScope) obj;
            return gVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((g) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else if (obj instanceof p.b) {
                    throw ((p.b) obj).exception;
                }
            } else if (!(obj instanceof p.b)) {
                c cVar = this.this$0;
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getIO(), new h(cVar, (kotlin.d.d) null), this) == aVar) {
                    return aVar;
                }
            } else {
                throw ((p.b) obj).exception;
            }
            net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b f2 = net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f();
            kotlin.g.b.k.a((Object) f2, "DirectPaymentBl.getInstance()");
            f2.a(this.this$0.f51301d);
            return x.f47997a;
        }
    }

    @kotlin.d.b.a.f(b = "FJRQRSendMoneyViewModel.kt", c = {67}, d = "invokeSuspend", e = "net/one97/paytm/p2mNewDesign/viewmodel/FJRQRSendMoneyViewModel$getLastUsedPaymentInstrumentFromDB$2")
    static final class h extends kotlin.d.b.a.k implements kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        int label;
        private CoroutineScope p$;
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(c cVar, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = cVar;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            h hVar = new h(this.this$0, dVar);
            hVar.p$ = (CoroutineScope) obj;
            return hVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((h) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else if (!(obj instanceof p.b)) {
                c cVar = this.this$0;
                net.one97.paytm.p2mNewDesign.db.a.a a2 = cVar.f51302e.a();
                net.one97.paytm.wallet.communicator.c a3 = net.one97.paytm.wallet.communicator.b.a();
                net.one97.paytm.wallet.communicator.c a4 = net.one97.paytm.wallet.communicator.b.a();
                kotlin.g.b.k.a((Object) a4, "WalletCommManager.getWalletCommunicator()");
                List<net.one97.paytm.p2mNewDesign.db.b.a> a5 = a2.a(a3.getIntegerFromGTM(a4.getContext(), "MaxLastUsedInstrumentAndroid"));
                kotlin.g.b.k.c(a5, "<set-?>");
                cVar.f51301d = a5;
                return x.f47997a;
            } else {
                throw ((p.b) obj).exception;
            }
        }
    }

    @kotlin.d.b.a.f(b = "FJRQRSendMoneyViewModel.kt", c = {208}, d = "invokeSuspend", e = "net/one97/paytm/p2mNewDesign/viewmodel/FJRQRSendMoneyViewModel$getMapId$2")
    static final class i extends kotlin.d.b.a.k implements kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super Long>, Object> {
        final /* synthetic */ String $custId;
        final /* synthetic */ String $mId;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(c cVar, String str, String str2, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = cVar;
            this.$custId = str;
            this.$mId = str2;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            i iVar = new i(this.this$0, this.$custId, this.$mId, dVar);
            iVar.p$ = (CoroutineScope) obj;
            return iVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((i) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else if (!(obj instanceof p.b)) {
                c cVar = this.this$0;
                cVar.f51298a = cVar.f51302e.c().a(this.$custId, this.$mId);
                return kotlin.d.b.a.b.a(this.this$0.f51298a);
            } else {
                throw ((p.b) obj).exception;
            }
        }
    }

    @kotlin.d.b.a.f(b = "FJRQRSendMoneyViewModel.kt", c = {44, 47, 49, 50, 52, 53}, d = "invokeSuspend", e = "net/one97/paytm/p2mNewDesign/viewmodel/FJRQRSendMoneyViewModel$getMappingId$1")
    static final class j extends kotlin.d.b.a.k implements kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ String $custId;
        final /* synthetic */ String $mId;
        Object L$0;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(c cVar, String str, String str2, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = cVar;
            this.$custId = str;
            this.$mId = str2;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            j jVar = new j(this.this$0, this.$custId, this.$mId, dVar);
            jVar.p$ = (CoroutineScope) obj;
            return jVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((j) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        /* JADX WARNING: Removed duplicated region for block: B:41:0x00a0 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x00b5 A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                kotlin.d.a.a r0 = kotlin.d.a.a.COROUTINE_SUSPENDED
                int r1 = r10.label
                r2 = 5
                r3 = 4
                r4 = 3
                r5 = 2
                r6 = 1
                if (r1 == 0) goto L_0x0059
                if (r1 == r6) goto L_0x004b
                if (r1 == r5) goto L_0x0041
                if (r1 == r4) goto L_0x0033
                if (r1 == r3) goto L_0x0028
                if (r1 != r2) goto L_0x0020
                boolean r0 = r11 instanceof kotlin.p.b
                if (r0 != 0) goto L_0x001b
                goto L_0x00c3
            L_0x001b:
                kotlin.p$b r11 = (kotlin.p.b) r11
                java.lang.Throwable r11 = r11.exception
                throw r11
            L_0x0020:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L_0x0028:
                boolean r0 = r11 instanceof kotlin.p.b
                if (r0 != 0) goto L_0x002e
                goto L_0x00c3
            L_0x002e:
                kotlin.p$b r11 = (kotlin.p.b) r11
                java.lang.Throwable r11 = r11.exception
                throw r11
            L_0x0033:
                java.lang.Object r1 = r10.L$0
                net.one97.paytm.p2mNewDesign.i.c r1 = (net.one97.paytm.p2mNewDesign.i.c) r1
                boolean r2 = r11 instanceof kotlin.p.b
                if (r2 != 0) goto L_0x003c
                goto L_0x00a1
            L_0x003c:
                kotlin.p$b r11 = (kotlin.p.b) r11
                java.lang.Throwable r11 = r11.exception
                throw r11
            L_0x0041:
                boolean r1 = r11 instanceof kotlin.p.b
                if (r1 != 0) goto L_0x0046
                goto L_0x0090
            L_0x0046:
                kotlin.p$b r11 = (kotlin.p.b) r11
                java.lang.Throwable r11 = r11.exception
                throw r11
            L_0x004b:
                java.lang.Object r1 = r10.L$0
                net.one97.paytm.p2mNewDesign.i.c r1 = (net.one97.paytm.p2mNewDesign.i.c) r1
                boolean r6 = r11 instanceof kotlin.p.b
                if (r6 != 0) goto L_0x0054
                goto L_0x006e
            L_0x0054:
                kotlin.p$b r11 = (kotlin.p.b) r11
                java.lang.Throwable r11 = r11.exception
                throw r11
            L_0x0059:
                boolean r1 = r11 instanceof kotlin.p.b
                if (r1 != 0) goto L_0x00c6
                net.one97.paytm.p2mNewDesign.i.c r1 = r10.this$0
                java.lang.String r11 = r10.$custId
                java.lang.String r7 = r10.$mId
                r10.L$0 = r1
                r10.label = r6
                java.lang.Object r11 = r1.a((java.lang.String) r11, (java.lang.String) r7, (kotlin.d.d<? super java.lang.Long>) r10)
                if (r11 != r0) goto L_0x006e
                return r0
            L_0x006e:
                java.lang.Number r11 = (java.lang.Number) r11
                long r6 = r11.longValue()
                r1.f51298a = r6
                net.one97.paytm.p2mNewDesign.i.c r11 = r10.this$0
                long r6 = r11.f51298a
                r8 = 0
                int r11 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r11 != 0) goto L_0x00b6
                net.one97.paytm.p2mNewDesign.i.c r11 = r10.this$0
                net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse r1 = new net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse
                r1.<init>()
                r10.label = r5
                java.lang.Object r11 = r11.a((net.one97.paytm.p2mNewDesign.entity.CJRFetchPayMethodResponse) r1, (kotlin.d.d<? super kotlin.x>) r10)
                if (r11 != r0) goto L_0x0090
                return r0
            L_0x0090:
                net.one97.paytm.p2mNewDesign.i.c r1 = r10.this$0
                java.lang.String r11 = r10.$custId
                java.lang.String r2 = r10.$mId
                r10.L$0 = r1
                r10.label = r4
                java.lang.Object r11 = r1.a((java.lang.String) r11, (java.lang.String) r2, (kotlin.d.d<? super java.lang.Long>) r10)
                if (r11 != r0) goto L_0x00a1
                return r0
            L_0x00a1:
                java.lang.Number r11 = (java.lang.Number) r11
                long r4 = r11.longValue()
                r1.f51298a = r4
                net.one97.paytm.p2mNewDesign.i.c r11 = r10.this$0
                long r1 = r11.f51298a
                r10.label = r3
                java.lang.Object r11 = r11.a((long) r1, (kotlin.d.d<? super kotlin.x>) r10)
                if (r11 != r0) goto L_0x00c3
                return r0
            L_0x00b6:
                net.one97.paytm.p2mNewDesign.i.c r11 = r10.this$0
                long r3 = r11.f51298a
                r10.label = r2
                java.lang.Object r11 = r11.a((long) r3, (kotlin.d.d<? super kotlin.x>) r10)
                if (r11 != r0) goto L_0x00c3
                return r0
            L_0x00c3:
                kotlin.x r11 = kotlin.x.f47997a
                return r11
            L_0x00c6:
                kotlin.p$b r11 = (kotlin.p.b) r11
                java.lang.Throwable r11 = r11.exception
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.i.c.j.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.d.b.a.f(b = "FJRQRSendMoneyViewModel.kt", c = {184}, d = "invokeSuspend", e = "net/one97/paytm/p2mNewDesign/viewmodel/FJRQRSendMoneyViewModel$getMappingTableData$2")
    static final class k extends kotlin.d.b.a.k implements kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super List<net.one97.paytm.p2mNewDesign.db.b.b>>, Object> {
        int label;
        private CoroutineScope p$;
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(c cVar, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = cVar;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            k kVar = new k(this.this$0, dVar);
            kVar.p$ = (CoroutineScope) obj;
            return kVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((k) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else if (!(obj instanceof p.b)) {
                return this.this$0.f51302e.c().a();
            } else {
                throw ((p.b) obj).exception;
            }
        }
    }

    @kotlin.d.b.a.f(b = "FJRQRSendMoneyViewModel.kt", c = {73}, d = "invokeSuspend", e = "net/one97/paytm/p2mNewDesign/viewmodel/FJRQRSendMoneyViewModel$getMerchantJSONFromDB$2")
    static final class l extends kotlin.d.b.a.k implements kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ long $mapId;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(c cVar, long j, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = cVar;
            this.$mapId = j;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            l lVar = new l(this.this$0, this.$mapId, dVar);
            lVar.p$ = (CoroutineScope) obj;
            return lVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((l) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else if (!(obj instanceof p.b)) {
                this.this$0.f51300c.postValue(this.this$0.f51302e.c().a(this.$mapId));
                return x.f47997a;
            } else {
                throw ((p.b) obj).exception;
            }
        }
    }

    @kotlin.d.b.a.f(b = "FJRQRSendMoneyViewModel.kt", c = {190}, d = "invokeSuspend", e = "net/one97/paytm/p2mNewDesign/viewmodel/FJRQRSendMoneyViewModel$updateRecordInMappingTable$2")
    static final class n extends kotlin.d.b.a.k implements kotlin.g.a.m<CoroutineScope, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ long $mapId;
        final /* synthetic */ CJRFetchPayMethodResponse $methodResponse;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(c cVar, CJRFetchPayMethodResponse cJRFetchPayMethodResponse, long j, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = cVar;
            this.$methodResponse = cJRFetchPayMethodResponse;
            this.$mapId = j;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            n nVar = new n(this.this$0, this.$methodResponse, this.$mapId, dVar);
            nVar.p$ = (CoroutineScope) obj;
            return nVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((n) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else if (!(obj instanceof p.b)) {
                String a2 = new com.google.gson.f().a((Object) this.$methodResponse, (Type) CJRFetchPayMethodResponse.class);
                long j = this.$mapId;
                String n = com.paytm.utility.b.n((Context) this.this$0.getApplication());
                kotlin.g.b.k.a((Object) n, "CJRAppCommonUtility.getUserId(getApplication())");
                String str = this.this$0.f51303f;
                long currentTimeMillis = System.currentTimeMillis();
                kotlin.g.b.k.a((Object) a2, "jsonBody");
                this.this$0.f51302e.c().b(new net.one97.paytm.p2mNewDesign.db.b.b(j, n, str, a2, false, currentTimeMillis));
                return x.f47997a;
            } else {
                throw ((p.b) obj).exception;
            }
        }
    }
}
