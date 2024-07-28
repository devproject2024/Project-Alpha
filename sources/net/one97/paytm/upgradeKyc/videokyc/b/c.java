package net.one97.paytm.upgradeKyc.videokyc.b;

import android.app.Application;
import androidx.lifecycle.y;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import kotlin.d.b.a.f;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import net.one97.paytm.upgradeKyc.kycV3.b.b;

public final class c extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    public y<b<String>> f66466a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    private final Application f66467b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final net.one97.paytm.upgradeKyc.kycV3.b.c f66468c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Application application, net.one97.paytm.upgradeKyc.kycV3.b.c cVar) {
        super(application);
        k.c(application, AppManagerUtil.EXTEND_PREFIX_DEFAULT);
        k.c(cVar, "kycRepository");
        this.f66467b = application;
        this.f66468c = cVar;
    }

    @f(b = "VideoKYCCheckListViewModel.kt", c = {}, d = "invokeSuspend", e = "net.one97.paytm.upgradeKyc.videokyc.viewmodel.VideoKYCCheckListViewModel$checkConnectionSpeed$1")
    public static final class a extends kotlin.d.b.a.k implements m<CoroutineScope, d<? super x>, Object> {
        int label;
        private CoroutineScope p$;
        final /* synthetic */ c this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(c cVar, d dVar) {
            super(2, dVar);
            this.this$0 = cVar;
        }

        public final d<x> create(Object obj, d<?> dVar) {
            k.c(dVar, "completion");
            a aVar = new a(this.this$0, dVar);
            aVar.p$ = (CoroutineScope) obj;
            return aVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((a) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
            r5 = r5 + (java.lang.System.currentTimeMillis() - r15);
            r11.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f2, code lost:
            if (r17.exists() != false) goto L_0x00f4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x00f4, code lost:
            r17.delete();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:0x0144, code lost:
            if (r17.exists() != false) goto L_0x00f4;
         */
        /* JADX WARNING: Removed duplicated region for block: B:101:0x01bc  */
        /* JADX WARNING: Removed duplicated region for block: B:103:0x01c1  */
        /* JADX WARNING: Removed duplicated region for block: B:116:0x014e A[EDGE_INSN: B:116:0x014e->B:82:0x014e ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x0131  */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x0136  */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x013b  */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x0140  */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x014a A[LOOP:0: B:7:0x0033->B:81:0x014a, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:99:0x01b7  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r25) {
            /*
                r24 = this;
                r1 = r24
                r0 = r25
                kotlin.d.a.a r2 = kotlin.d.a.a.COROUTINE_SUSPENDED
                int r2 = r1.label
                if (r2 != 0) goto L_0x01e7
                boolean r2 = r0 instanceof kotlin.p.b
                if (r2 != 0) goto L_0x01e2
                net.one97.paytm.upgradeKyc.videokyc.b.c r0 = r1.this$0
                net.one97.paytm.upgradeKyc.kycV3.b.c r0 = r0.f66468c
                net.one97.paytm.upgradeKyc.videokyc.b.c r2 = r1.this$0
                androidx.lifecycle.y r2 = r2.f66466a
                java.lang.String r3 = "networkLiveData"
                kotlin.g.b.k.c(r2, r3)
                android.content.Context r0 = r0.f66175b
                boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
                if (r0 == 0) goto L_0x01d0
                net.one97.paytm.upgradeKyc.kycV3.b.b$a r0 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d
                net.one97.paytm.upgradeKyc.kycV3.b.b r0 = net.one97.paytm.upgradeKyc.kycV3.b.b.a.a()
                r2.postValue(r0)
                r0 = 1
                r5 = 0
            L_0x0033:
                r7 = 4677269688000970752(0x40e9000000000000, double:51200.0)
                java.lang.String r10 = "temp"
                java.lang.String r11 = ""
                java.io.File r10 = java.io.File.createTempFile(r10, r11)     // Catch:{ Exception -> 0x011c, all -> 0x0115 }
                r10.deleteOnExit()     // Catch:{ Exception -> 0x0110, all -> 0x0109 }
                okhttp3.Request$Builder r11 = new okhttp3.Request$Builder     // Catch:{ Exception -> 0x0110, all -> 0x0109 }
                r11.<init>()     // Catch:{ Exception -> 0x0110, all -> 0x0109 }
                net.one97.paytm.upgradeKyc.helper.d$a r12 = net.one97.paytm.upgradeKyc.helper.d.f66026a     // Catch:{ Exception -> 0x0110, all -> 0x0109 }
                net.one97.paytm.upgradeKyc.helper.d r12 = net.one97.paytm.upgradeKyc.helper.d.a.a()     // Catch:{ Exception -> 0x0110, all -> 0x0109 }
                if (r12 != 0) goto L_0x0050
                kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0110, all -> 0x0109 }
            L_0x0050:
                java.lang.String r12 = "videoKycSpeedTestServerUrl"
                java.lang.String r12 = net.one97.paytm.upgradeKyc.helper.d.a((java.lang.String) r12)     // Catch:{ Exception -> 0x0110, all -> 0x0109 }
                okhttp3.Request$Builder r11 = r11.url((java.lang.String) r12)     // Catch:{ Exception -> 0x0110, all -> 0x0109 }
                okhttp3.Request r11 = r11.build()     // Catch:{ Exception -> 0x0110, all -> 0x0109 }
                java.lang.String r12 = "Request.Builder()\n      …                 .build()"
                kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r12)     // Catch:{ Exception -> 0x0110, all -> 0x0109 }
                okhttp3.OkHttpClient r12 = new okhttp3.OkHttpClient     // Catch:{ Exception -> 0x0110, all -> 0x0109 }
                r12.<init>()     // Catch:{ Exception -> 0x0110, all -> 0x0109 }
                okhttp3.Call r11 = r12.newCall(r11)     // Catch:{ Exception -> 0x0110, all -> 0x0109 }
                okhttp3.Response r11 = com.google.firebase.perf.network.FirebasePerfOkHttpClient.execute(r11)     // Catch:{ Exception -> 0x0110, all -> 0x0109 }
                java.lang.String r12 = "OkHttpClient().newCall(request).execute()"
                kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r12)     // Catch:{ Exception -> 0x0110, all -> 0x0109 }
                okhttp3.ResponseBody r12 = r11.body()     // Catch:{ Exception -> 0x0110, all -> 0x0109 }
                if (r12 == 0) goto L_0x0080
                i.e r12 = r12.source()     // Catch:{ Exception -> 0x0110, all -> 0x0109 }
                goto L_0x0081
            L_0x0080:
                r12 = 0
            L_0x0081:
                if (r10 != 0) goto L_0x0086
                kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0105, all -> 0x0101 }
            L_0x0086:
                i.u r13 = i.n.b((java.io.File) r10)     // Catch:{ Exception -> 0x0105, all -> 0x0101 }
                i.d r13 = i.n.a((i.u) r13)     // Catch:{ Exception -> 0x0105, all -> 0x0101 }
                i.c r14 = r13.a()     // Catch:{ Exception -> 0x00fd, all -> 0x00f8 }
                java.lang.String r15 = "sink.buffer()"
                kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r15)     // Catch:{ Exception -> 0x00fd, all -> 0x00f8 }
                long r15 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00fd, all -> 0x00f8 }
                r17 = 0
            L_0x009d:
                if (r12 == 0) goto L_0x00aa
                r3 = 10240(0x2800, double:5.059E-320)
                long r3 = r12.read(r14, r3)     // Catch:{ Exception -> 0x00fd, all -> 0x00f8 }
                java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ Exception -> 0x00fd, all -> 0x00f8 }
                goto L_0x00ab
            L_0x00aa:
                r3 = 0
            L_0x00ab:
                if (r3 != 0) goto L_0x00b0
                kotlin.g.b.k.a()     // Catch:{ Exception -> 0x00fd, all -> 0x00f8 }
            L_0x00b0:
                long r19 = r3.longValue()     // Catch:{ Exception -> 0x00fd, all -> 0x00f8 }
                if (r3 != 0) goto L_0x00b7
                goto L_0x00c1
            L_0x00b7:
                long r3 = r3.longValue()     // Catch:{ Exception -> 0x00fd, all -> 0x00f8 }
                r21 = -1
                int r23 = (r3 > r21 ? 1 : (r3 == r21 ? 0 : -1))
                if (r23 == 0) goto L_0x00df
            L_0x00c1:
                r13.c()     // Catch:{ Exception -> 0x00fd, all -> 0x00f8 }
                long r3 = r17 + r19
                r17 = r10
                double r9 = (double) r3
                int r18 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
                if (r18 <= 0) goto L_0x00da
                long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00ff, all -> 0x00d7 }
                long r3 = r3 - r15
                long r5 = r5 + r3
                r11.close()     // Catch:{ Exception -> 0x00ff, all -> 0x00d7 }
                goto L_0x00e1
            L_0x00d7:
                r0 = move-exception
                goto L_0x01b5
            L_0x00da:
                r10 = r17
                r17 = r3
                goto L_0x009d
            L_0x00df:
                r17 = r10
            L_0x00e1:
                r13.flush()
                r13.close()
                if (r12 == 0) goto L_0x00ec
                r12.close()
            L_0x00ec:
                if (r17 == 0) goto L_0x0147
                boolean r3 = r17.exists()
                if (r3 == 0) goto L_0x0147
            L_0x00f4:
                r17.delete()
                goto L_0x0147
            L_0x00f8:
                r0 = move-exception
                r17 = r10
                goto L_0x01b5
            L_0x00fd:
                r17 = r10
            L_0x00ff:
                r9 = r13
                goto L_0x0120
            L_0x0101:
                r0 = move-exception
                r17 = r10
                goto L_0x010d
            L_0x0105:
                r17 = r10
                r9 = 0
                goto L_0x0120
            L_0x0109:
                r0 = move-exception
                r17 = r10
                r12 = 0
            L_0x010d:
                r13 = 0
                goto L_0x01b5
            L_0x0110:
                r17 = r10
                r9 = 0
                r12 = 0
                goto L_0x0120
            L_0x0115:
                r0 = move-exception
                r12 = 0
                r13 = 0
                r17 = 0
                goto L_0x01b5
            L_0x011c:
                r9 = 0
                r12 = 0
                r17 = 0
            L_0x0120:
                net.one97.paytm.upgradeKyc.kycV3.b.b$a r3 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d     // Catch:{ all -> 0x01b3 }
                net.one97.paytm.upgradeKyc.activity.b$d r3 = net.one97.paytm.upgradeKyc.activity.b.d.EXCEPTION     // Catch:{ all -> 0x01b3 }
                java.lang.String r3 = r3.name()     // Catch:{ all -> 0x01b3 }
                net.one97.paytm.upgradeKyc.kycV3.b.b r3 = net.one97.paytm.upgradeKyc.kycV3.b.b.a.a(r3)     // Catch:{ all -> 0x01b3 }
                r2.postValue(r3)     // Catch:{ all -> 0x01b3 }
                if (r9 == 0) goto L_0x0134
                r9.flush()
            L_0x0134:
                if (r9 == 0) goto L_0x0139
                r9.close()
            L_0x0139:
                if (r12 == 0) goto L_0x013e
                r12.close()
            L_0x013e:
                if (r17 == 0) goto L_0x0147
                boolean r3 = r17.exists()
                if (r3 == 0) goto L_0x0147
                goto L_0x00f4
            L_0x0147:
                r3 = 2
                if (r0 == r3) goto L_0x014e
                int r0 = r0 + 1
                goto L_0x0033
            L_0x014e:
                r3 = 2
                long r5 = r5 / r3
                double r3 = (double) r5
                double r7 = r7 / r3
                r3 = 4652007308841189376(0x408f400000000000, double:1000.0)
                double r7 = r7 * r3
                r3 = 4652218415073722368(0x4090000000000000, double:1024.0)
                double r7 = r7 / r3
                net.one97.paytm.upgradeKyc.helper.d$a r0 = net.one97.paytm.upgradeKyc.helper.d.f66026a
                net.one97.paytm.upgradeKyc.helper.d r0 = net.one97.paytm.upgradeKyc.helper.d.a.a()
                if (r0 != 0) goto L_0x0168
                kotlin.g.b.k.a()
            L_0x0168:
                java.lang.String r0 = "videoKycBandwidthlowSpeedKBps"
                int r0 = net.one97.paytm.upgradeKyc.helper.d.b(r0)
                double r3 = (double) r0
                int r0 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
                if (r0 >= 0) goto L_0x0180
                net.one97.paytm.upgradeKyc.kycV3.b.b$a r0 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d
                net.one97.paytm.upgradeKyc.activity.b$d r0 = net.one97.paytm.upgradeKyc.activity.b.d.LOW
                java.lang.String r0 = r0.name()
                net.one97.paytm.upgradeKyc.kycV3.b.b r0 = net.one97.paytm.upgradeKyc.kycV3.b.b.a.a(r0)
                goto L_0x01af
            L_0x0180:
                net.one97.paytm.upgradeKyc.helper.d$a r0 = net.one97.paytm.upgradeKyc.helper.d.f66026a
                net.one97.paytm.upgradeKyc.helper.d r0 = net.one97.paytm.upgradeKyc.helper.d.a.a()
                if (r0 != 0) goto L_0x018b
                kotlin.g.b.k.a()
            L_0x018b:
                java.lang.String r0 = "videoKycBandwidthSpeedKBps"
                int r0 = net.one97.paytm.upgradeKyc.helper.d.b(r0)
                double r3 = (double) r0
                int r0 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
                if (r0 >= 0) goto L_0x01a3
                net.one97.paytm.upgradeKyc.kycV3.b.b$a r0 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d
                net.one97.paytm.upgradeKyc.activity.b$d r0 = net.one97.paytm.upgradeKyc.activity.b.d.AVERAGE
                java.lang.String r0 = r0.name()
                net.one97.paytm.upgradeKyc.kycV3.b.b r0 = net.one97.paytm.upgradeKyc.kycV3.b.b.a.a(r0)
                goto L_0x01af
            L_0x01a3:
                net.one97.paytm.upgradeKyc.kycV3.b.b$a r0 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d
                net.one97.paytm.upgradeKyc.activity.b$d r0 = net.one97.paytm.upgradeKyc.activity.b.d.ACCEPTABLE
                java.lang.String r0 = r0.name()
                net.one97.paytm.upgradeKyc.kycV3.b.b r0 = net.one97.paytm.upgradeKyc.kycV3.b.b.a.a(r0)
            L_0x01af:
                r2.postValue(r0)
                goto L_0x01df
            L_0x01b3:
                r0 = move-exception
                r13 = r9
            L_0x01b5:
                if (r13 == 0) goto L_0x01ba
                r13.flush()
            L_0x01ba:
                if (r13 == 0) goto L_0x01bf
                r13.close()
            L_0x01bf:
                if (r12 == 0) goto L_0x01c4
                r12.close()
            L_0x01c4:
                if (r17 == 0) goto L_0x01cf
                boolean r2 = r17.exists()
                if (r2 == 0) goto L_0x01cf
                r17.delete()
            L_0x01cf:
                throw r0
            L_0x01d0:
                net.one97.paytm.upgradeKyc.kycV3.b.b$a r0 = net.one97.paytm.upgradeKyc.kycV3.b.b.f66167d
                net.one97.paytm.upgradeKyc.activity.b$d r0 = net.one97.paytm.upgradeKyc.activity.b.d.NO_NETWORK
                java.lang.String r0 = r0.name()
                net.one97.paytm.upgradeKyc.kycV3.b.b r0 = net.one97.paytm.upgradeKyc.kycV3.b.b.a.a(r0)
                r2.postValue(r0)
            L_0x01df:
                kotlin.x r0 = kotlin.x.f47997a
                return r0
            L_0x01e2:
                kotlin.p$b r0 = (kotlin.p.b) r0
                java.lang.Throwable r0 = r0.exception
                throw r0
            L_0x01e7:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.videokyc.b.c.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
