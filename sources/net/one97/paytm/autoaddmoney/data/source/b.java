package net.one97.paytm.autoaddmoney.data.source;

import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5Param;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.addmoney.h;
import net.one97.paytm.autoaddmoney.data.source.a;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.auth.TncData;

public final class b implements a {

    /* renamed from: b  reason: collision with root package name */
    public static final a f49239b = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static b f49240d;

    /* renamed from: a  reason: collision with root package name */
    public final a f49241a;

    /* renamed from: c  reason: collision with root package name */
    private final a f49242c;

    public b(a aVar, a aVar2) {
        k.c(aVar, "amRemoteDataSource");
        k.c(aVar2, "amLocalDataSource");
        this.f49241a = aVar;
        this.f49242c = aVar2;
    }

    public final void a(a.d dVar) {
        k.c(dVar, "subscriptionStatus");
        this.f49241a.a(dVar);
    }

    public final void a(a.b bVar) {
        k.c(bVar, "disableSubscription");
        this.f49241a.a(bVar);
    }

    public final void a(String str, a.i iVar) {
        k.c(iVar, H5Event.TYPE_CALL_BACK);
        this.f49241a.a(str, iVar);
    }

    public final void a(IJRDataModel iJRDataModel, String str, String str2, String str3, a.C0872a aVar) {
        k.c(str3, "requestType");
        k.c(aVar, H5Event.TYPE_CALL_BACK);
        this.f49241a.a(iJRDataModel, str, str2, str3, aVar);
    }

    public final void a(boolean z, a.h hVar) {
        k.c(hVar, "savedCardListener");
        this.f49241a.a(z, hVar);
    }

    public final void a(String str, a.e eVar) {
        k.c(str, "cardString");
        k.c(eVar, H5Event.TYPE_CALL_BACK);
        this.f49241a.a(str, eVar);
    }

    public final void a(ArrayList<TncData> arrayList, a.g gVar) {
        k.c(arrayList, "tncDataList");
        k.c(gVar, "saveTncListener");
        this.f49241a.a(arrayList, gVar);
    }

    public final void a(a.f fVar) {
        k.c(fVar, H5Param.PARAM);
        this.f49241a.a(fVar);
    }

    public final void a(String str, a.j jVar) {
        k.c(jVar, "walletSSOTokenListener");
        this.f49241a.a(str, jVar);
    }

    public final void a(h hVar) {
        k.c(hVar, H5Event.TYPE_CALL_BACK);
        this.f49241a.a(hVar);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static b a(a aVar, a aVar2) {
            b a2;
            k.c(aVar, "amRemoteDataSource");
            k.c(aVar2, "amLocalDataSource");
            b a3 = b.f49240d;
            if (a3 != null) {
                return a3;
            }
            synchronized (b.class) {
                a2 = b.f49240d;
                if (a2 == null) {
                    a2 = new b(aVar, aVar2);
                    b.f49240d = a2;
                }
            }
            return a2;
        }
    }
}
