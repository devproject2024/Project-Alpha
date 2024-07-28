package net.one97.paytm.games.fragment.a;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import kotlin.o;
import net.one97.paytm.games.e.f;
import net.one97.paytm.games.e.j;
import net.one97.paytm.games.model.GpCommonBaseResponse;
import net.one97.paytm.games.model.GpTasksListResponse;

public final class b extends a {
    public static final a j = new a((byte) 0);

    /* renamed from: h  reason: collision with root package name */
    public y<GpTasksListResponse.GpTask> f35639h = new y<>();

    /* renamed from: i  reason: collision with root package name */
    public boolean f35640i;
    private y<o<Integer, GpCommonBaseResponse>> k = new y<>();
    private com.paytm.network.a l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Application application) {
        super(application);
        k.c(application, "application");
    }

    public final void a(String str) {
        k.c(str, "ruleId");
        if (!this.f35640i) {
            Application application = getApplication();
            k.a((Object) application, "getApplication<Application>()");
            if (f.a((Context) application)) {
                this.f35640i = true;
                j jVar = j.f35626a;
                j.a(str, (com.paytm.network.listener.b) new C0597b(this, str));
            }
        }
    }

    /* renamed from: net.one97.paytm.games.fragment.a.b$b  reason: collision with other inner class name */
    public static final class C0597b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f35641a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f35642b;

        C0597b(b bVar, String str) {
            this.f35641a = bVar;
            this.f35642b = str;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f35641a.f35640i = false;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: net.one97.paytm.games.model.GpTasksListResponse$GpTask$Claim} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: net.one97.paytm.games.model.GpTasksListResponse$GpTask$Claim} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: net.one97.paytm.games.model.GpTasksListResponse$GpTask$Claim} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: net.one97.paytm.games.model.GpTasksListResponse$GpTask$Claim} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x00f3 A[EDGE_INSN: B:57:0x00f3->B:53:0x00f3 ?: BREAK  , SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onApiSuccess(com.paytm.network.model.IJRPaytmDataModel r12) {
            /*
                r11 = this;
                boolean r0 = r12 instanceof net.one97.paytm.games.model.GpTasksListResponse
                if (r0 == 0) goto L_0x00f7
                net.one97.paytm.games.model.GpTasksListResponse r12 = (net.one97.paytm.games.model.GpTasksListResponse) r12
                int r0 = r12.code
                r1 = 2001(0x7d1, float:2.804E-42)
                if (r0 != r1) goto L_0x00f7
                java.lang.String r0 = r12.status
                java.lang.String r1 = "SUCCESS"
                boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r1)
                if (r0 == 0) goto L_0x00f7
                java.util.ArrayList r0 = r12.getTasks()
                java.util.Collection r0 = (java.util.Collection) r0
                r1 = 0
                r2 = 1
                if (r0 == 0) goto L_0x0029
                boolean r0 = r0.isEmpty()
                if (r0 == 0) goto L_0x0027
                goto L_0x0029
            L_0x0027:
                r0 = 0
                goto L_0x002a
            L_0x0029:
                r0 = 1
            L_0x002a:
                if (r0 == 0) goto L_0x0032
                net.one97.paytm.games.fragment.a.b r12 = r11.f35641a
                r12.f35640i = false
                return
            L_0x0032:
                java.util.ArrayList r12 = r12.getTasks()
                java.lang.String r0 = "response.tasks"
                kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r0)
                java.lang.Iterable r12 = (java.lang.Iterable) r12
                java.util.Iterator r12 = r12.iterator()
            L_0x0041:
                boolean r0 = r12.hasNext()
                r3 = 0
                if (r0 == 0) goto L_0x00f2
                java.lang.Object r0 = r12.next()
                r4 = r0
                net.one97.paytm.games.model.GpTasksListResponse$GpTask r4 = (net.one97.paytm.games.model.GpTasksListResponse.GpTask) r4
                java.lang.String r5 = r11.f35642b
                java.lang.String r6 = "task"
                kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r6)
                java.lang.String r6 = r4.getRuleId()
                boolean r5 = kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.Object) r6)
                if (r5 == 0) goto L_0x00ee
                java.util.ArrayList r5 = r4.getClaims()
                java.util.Collection r5 = (java.util.Collection) r5
                if (r5 == 0) goto L_0x0072
                boolean r5 = r5.isEmpty()
                if (r5 == 0) goto L_0x0070
                goto L_0x0072
            L_0x0070:
                r5 = 0
                goto L_0x0073
            L_0x0072:
                r5 = 1
            L_0x0073:
                r5 = r5 ^ r2
                if (r5 == 0) goto L_0x0078
                r5 = r11
                goto L_0x0079
            L_0x0078:
                r5 = r3
            L_0x0079:
                net.one97.paytm.games.fragment.a.b$b r5 = (net.one97.paytm.games.fragment.a.b.C0597b) r5
                if (r5 == 0) goto L_0x00ee
                java.util.ArrayList r5 = r4.getClaims()
                java.lang.String r6 = "task.claims"
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
                java.lang.Iterable r5 = (java.lang.Iterable) r5
                java.util.Iterator r5 = r5.iterator()
            L_0x008d:
                boolean r6 = r5.hasNext()
                java.lang.String r7 = "claimed"
                if (r6 == 0) goto L_0x00be
                java.lang.Object r6 = r5.next()
                r8 = r6
                net.one97.paytm.games.model.GpTasksListResponse$GpTask$Claim r8 = (net.one97.paytm.games.model.GpTasksListResponse.GpTask.Claim) r8
                java.lang.String r9 = "claim"
                kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
                java.lang.String r9 = r8.getClaimStatus()
                java.lang.String r10 = "claimable"
                boolean r9 = kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.Object) r9)
                if (r9 != 0) goto L_0x00ba
                java.lang.String r8 = r8.getClaimStatus()
                boolean r8 = kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.Object) r8)
                if (r8 == 0) goto L_0x00b8
                goto L_0x00ba
            L_0x00b8:
                r8 = 0
                goto L_0x00bb
            L_0x00ba:
                r8 = 1
            L_0x00bb:
                if (r8 == 0) goto L_0x008d
                r3 = r6
            L_0x00be:
                net.one97.paytm.games.model.GpTasksListResponse$GpTask$Claim r3 = (net.one97.paytm.games.model.GpTasksListResponse.GpTask.Claim) r3
                if (r3 == 0) goto L_0x00ee
                java.lang.String r5 = r3.getClaimStatus()
                boolean r5 = kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.Object) r5)
                if (r5 == 0) goto L_0x00e7
                net.one97.paytm.games.fragment.a.b r5 = r11.f35641a
                r5.f35640i = false
                int r3 = r3.getPoints()
                r4.setPointsFromClaimBean(r3)
                java.lang.Long r3 = net.one97.paytm.games.e.f.a()
                net.one97.paytm.games.b.a.a((java.lang.Long) r3)
                net.one97.paytm.games.fragment.a.b r3 = r11.f35641a
                androidx.lifecycle.y<net.one97.paytm.games.model.GpTasksListResponse$GpTask> r3 = r3.f35639h
                r3.setValue(r4)
                goto L_0x00ec
            L_0x00e7:
                net.one97.paytm.games.fragment.a.b r5 = r11.f35641a
                net.one97.paytm.games.fragment.a.b.a(r5, r4, r3)
            L_0x00ec:
                r3 = 1
                goto L_0x00ef
            L_0x00ee:
                r3 = 0
            L_0x00ef:
                if (r3 == 0) goto L_0x0041
                goto L_0x00f3
            L_0x00f2:
                r0 = r3
            L_0x00f3:
                net.one97.paytm.games.model.GpTasksListResponse$GpTask r0 = (net.one97.paytm.games.model.GpTasksListResponse.GpTask) r0
                if (r0 != 0) goto L_0x00fc
            L_0x00f7:
                net.one97.paytm.games.fragment.a.b r12 = r11.f35641a
                r12.f35640i = false
            L_0x00fc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.games.fragment.a.b.C0597b.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void");
        }
    }

    public static final class c implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f35643a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ GpTasksListResponse.GpTask f35644b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ GpTasksListResponse.GpTask.Claim f35645c;

        c(b bVar, GpTasksListResponse.GpTask gpTask, GpTasksListResponse.GpTask.Claim claim) {
            this.f35643a = bVar;
            this.f35644b = gpTask;
            this.f35645c = claim;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f35643a.f35640i = false;
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            this.f35643a.f35640i = false;
            if (iJRPaytmDataModel instanceof GpCommonBaseResponse) {
                GpCommonBaseResponse gpCommonBaseResponse = (GpCommonBaseResponse) iJRPaytmDataModel;
                if (gpCommonBaseResponse.code == 2001 && k.a((Object) gpCommonBaseResponse.status, (Object) "SUCCESS")) {
                    this.f35644b.setPointsFromClaimBean(this.f35645c.getPoints());
                    net.one97.paytm.games.b.a.a(this.f35644b);
                    net.one97.paytm.games.b.a.a(Long.valueOf(System.currentTimeMillis()));
                    this.f35643a.f35639h.setValue(this.f35644b);
                }
            }
        }
    }

    public final void onCleared() {
        super.onCleared();
        com.paytm.network.a aVar = this.l;
        if (aVar != null) {
            aVar.b();
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void a(b bVar, GpTasksListResponse.GpTask gpTask, GpTasksListResponse.GpTask.Claim claim) {
        j jVar = j.f35626a;
        String ruleId = gpTask.getRuleId();
        k.a((Object) ruleId, "pTask.ruleId");
        String eventId = gpTask.getEventId();
        k.a((Object) eventId, "pTask.eventId");
        String claimId = claim.getClaimId();
        k.a((Object) claimId, "pClaimableTask.claimId");
        j.a(ruleId, eventId, claimId, (com.paytm.network.listener.b) new c(bVar, gpTask, claim));
    }
}
