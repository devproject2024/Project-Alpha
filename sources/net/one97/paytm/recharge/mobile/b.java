package net.one97.paytm.recharge.mobile;

import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.recharge.common.b.c;
import net.one97.paytm.recharge.common.e.ai;
import org.json.JSONObject;

public final class b extends c implements c {

    /* renamed from: c  reason: collision with root package name */
    public static final a f63674c = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static volatile b f63675e;

    /* renamed from: d  reason: collision with root package name */
    private final c f63676d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(net.one97.paytm.recharge.common.b.b.b bVar, c cVar) {
        super(bVar, cVar);
        k.c(bVar, "rechargeLocalDataSource");
        k.c(cVar, "mobileRemoteDataSource");
        this.f63676d = cVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public final b a(net.one97.paytm.recharge.common.b.b.b bVar, c cVar) {
            b bVar2;
            k.c(bVar, "rechargeLocalDataSource");
            k.c(cVar, "rechargeRemoteDataSource");
            b c2 = b.f63675e;
            if (c2 != null) {
                return c2;
            }
            synchronized (this) {
                bVar2 = new b(bVar, cVar);
                b.f63675e = bVar2;
            }
            return bVar2;
        }
    }

    public final void e(String str, ai aiVar, String str2, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        k.c(str2, "mobileNumber");
        this.f63676d.e(str, aiVar, str2, obj);
    }

    public final void f(String str, ai aiVar, String str2, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        k.c(str2, "mobileNumber");
        this.f63676d.f(str, aiVar, str2, obj);
    }

    public final void a(String str, ai aiVar, String str2, long j, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        k.c(str2, "mobileNumber");
        this.f63676d.a(str, aiVar, str2, j, obj);
    }

    public final void a(String str, ai aiVar, String str2, String str3, List<? extends Map<?, ?>> list, List<? extends Map<?, ?>> list2, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        k.c(str2, "browsePlansCategory");
        k.c(str3, "groupingQueryParams");
        this.f63676d.a(str, aiVar, str2, str3, list, list2, obj);
    }

    public final void a(String str, ai aiVar, String str2, long j, String str3, String str4, Object obj, boolean z) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        k.c(str2, "categoryId");
        String str5 = str3;
        k.c(str5, "mobileNumber");
        this.f63676d.a(str, aiVar, str2, j, str5, str4, obj, z);
    }

    public final void a(String str, ai aiVar, String str2, JSONObject jSONObject, String str3, String[] strArr, List<? extends Map<?, ?>> list, List<? extends Map<?, ?>> list2, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        k.c(str2, "browsePlansCategory");
        k.c(jSONObject, "filters");
        String str4 = str3;
        k.c(str4, "query");
        String[] strArr2 = strArr;
        k.c(strArr2, "searchKeys");
        this.f63676d.a(str, aiVar, str2, jSONObject, str4, strArr2, list, list2, obj);
    }

    public final void a(String str, ai aiVar, String str2, String str3, List<? extends Map<?, ?>> list, List<? extends Map<?, ?>> list2, String str4, int i2, int i3, boolean z, Object obj) {
        k.c(str, "tag");
        k.c(aiVar, "onSuccess");
        String str5 = str2;
        k.c(str5, "browsePlansCategory");
        this.f63676d.a(str, aiVar, str5, str3, list, list2, str4, i2, i3, z, obj);
    }
}
