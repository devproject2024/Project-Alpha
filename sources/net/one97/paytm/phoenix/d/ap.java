package net.one97.paytm.phoenix.d;

import com.alipay.mobile.h5container.api.H5Plugin;
import kotlin.ResultKt;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import net.one97.paytm.phoenix.ui.PhoenixActivity;
import org.json.JSONArray;

public final class ap extends net.one97.paytm.phoenix.core.a {

    /* renamed from: a  reason: collision with root package name */
    private final CoroutineScope f59525a = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());

    /* renamed from: b  reason: collision with root package name */
    private JSONArray f59526b;

    public ap() {
        super(H5Plugin.CommonEvents.SET_OPTION_MENU, "showOptionMenu", H5Plugin.CommonEvents.HIDE_OPTION_MENU);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003c A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(net.one97.paytm.phoenix.api.H5Event r9, net.one97.paytm.phoenix.api.b r10) {
        /*
            r8 = this;
            java.lang.String r0 = "event"
            kotlin.g.b.k.c(r9, r0)
            java.lang.String r0 = "bridgeContext"
            kotlin.g.b.k.c(r10, r0)
            super.a((net.one97.paytm.phoenix.api.H5Event) r9, (net.one97.paytm.phoenix.api.b) r10)
            boolean r10 = r8.a((net.one97.paytm.phoenix.api.H5Event) r9)
            if (r10 == 0) goto L_0x00c3
            android.app.Activity r10 = r9.getActivity()
            r0 = 0
            if (r10 == 0) goto L_0x0038
            android.app.Activity r10 = r9.getActivity()
            if (r10 != 0) goto L_0x0023
            kotlin.g.b.k.a()
        L_0x0023:
            boolean r10 = r10 instanceof net.one97.paytm.phoenix.ui.PhoenixActivity
            if (r10 == 0) goto L_0x0038
            android.app.Activity r10 = r9.getActivity()
            if (r10 == 0) goto L_0x0030
            net.one97.paytm.phoenix.ui.PhoenixActivity r10 = (net.one97.paytm.phoenix.ui.PhoenixActivity) r10
            goto L_0x0039
        L_0x0030:
            kotlin.u r9 = new kotlin.u
            java.lang.String r10 = "null cannot be cast to non-null type net.one97.paytm.phoenix.ui.PhoenixActivity"
            r9.<init>(r10)
            throw r9
        L_0x0038:
            r10 = r0
        L_0x0039:
            r1 = 0
            if (r10 != 0) goto L_0x003d
            return r1
        L_0x003d:
            java.lang.String r2 = r9.getAction$phoenix_debug()
            if (r2 != 0) goto L_0x0045
            goto L_0x00c3
        L_0x0045:
            int r3 = r2.hashCode()
            r4 = -1327518127(0xffffffffb0dfae51, float:-1.6274929E-9)
            if (r3 == r4) goto L_0x008f
            r4 = 505699926(0x1e245e56, float:8.701596E-21)
            if (r3 == r4) goto L_0x0062
            r1 = 1849742710(0x6e40d576, float:1.4919795E28)
            if (r3 == r1) goto L_0x0059
            goto L_0x00c3
        L_0x0059:
            java.lang.String r1 = "setOptionMenu"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x00c3
            goto L_0x0098
        L_0x0062:
            java.lang.String r9 = "hideOptionMenu"
            boolean r9 = r2.equals(r9)
            if (r9 == 0) goto L_0x00c3
            org.json.JSONArray r9 = r8.f59526b
            if (r9 == 0) goto L_0x0076
            int r9 = r9.length()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r9)
        L_0x0076:
            if (r0 != 0) goto L_0x007b
            kotlin.g.b.k.a()
        L_0x007b:
            int r9 = r0.intValue()
            if (r9 <= 0) goto L_0x00c3
            org.json.JSONArray r9 = r10.x
            int r9 = r9.length()
            if (r9 <= 0) goto L_0x00c3
            r10.w = r1
            r10.invalidateOptionsMenu()
            goto L_0x00c3
        L_0x008f:
            java.lang.String r1 = "showOptionMenu"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x00c3
        L_0x0098:
            org.json.JSONObject r9 = r9.getParams()
            if (r9 == 0) goto L_0x00a5
            java.lang.String r1 = "items"
            org.json.JSONArray r9 = r9.optJSONArray(r1)
            goto L_0x00a6
        L_0x00a5:
            r9 = r0
        L_0x00a6:
            r8.f59526b = r9
            org.json.JSONArray r9 = r8.f59526b
            if (r9 == 0) goto L_0x00c3
            int r1 = r9.length()
            if (r1 <= 0) goto L_0x00c3
            kotlinx.coroutines.CoroutineScope r2 = r8.f59525a
            r3 = 0
            r4 = 0
            net.one97.paytm.phoenix.d.ap$a r1 = new net.one97.paytm.phoenix.d.ap$a
            r1.<init>(r9, r0, r8, r10)
            r5 = r1
            kotlin.g.a.m r5 = (kotlin.g.a.m) r5
            r6 = 3
            r7 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r2, r3, r4, r5, r6, r7)
        L_0x00c3:
            r9 = 1
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.phoenix.d.ap.a(net.one97.paytm.phoenix.api.H5Event, net.one97.paytm.phoenix.api.b):boolean");
    }

    static final class a extends k implements m<CoroutineScope, d<? super x>, Object> {
        final /* synthetic */ PhoenixActivity $activity$inlined;
        final /* synthetic */ JSONArray $keys;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ ap this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(JSONArray jSONArray, d dVar, ap apVar, PhoenixActivity phoenixActivity) {
            super(2, dVar);
            this.$keys = jSONArray;
            this.this$0 = apVar;
            this.$activity$inlined = phoenixActivity;
        }

        public final d<x> create(Object obj, d<?> dVar) {
            kotlin.g.b.k.c(dVar, "completion");
            a aVar = new a(this.$keys, dVar, this.this$0, this.$activity$inlined);
            aVar.p$ = (CoroutineScope) obj;
            return aVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((a) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.a(obj);
                PhoenixActivity phoenixActivity = this.$activity$inlined;
                JSONArray jSONArray = this.$keys;
                kotlin.g.b.k.c(jSONArray, "keys");
                phoenixActivity.w = true;
                phoenixActivity.x = jSONArray;
                phoenixActivity.invalidateOptionsMenu();
                return x.f47997a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
