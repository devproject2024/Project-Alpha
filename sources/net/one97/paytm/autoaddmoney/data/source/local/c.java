package net.one97.paytm.autoaddmoney.data.source.local;

import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5Param;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.n;
import kotlin.x;
import net.one97.paytm.addmoney.h;
import net.one97.paytm.autoaddmoney.data.source.a;
import net.one97.paytm.autoaddmoney.util.b;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.auth.TncData;

public final class c implements net.one97.paytm.autoaddmoney.data.source.a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f49249a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static c f49250d;

    /* renamed from: b  reason: collision with root package name */
    private final b f49251b;

    /* renamed from: c  reason: collision with root package name */
    private final a f49252c;

    private c(b bVar, a aVar) {
        this.f49251b = bVar;
        this.f49252c = aVar;
    }

    public /* synthetic */ c(b bVar, a aVar, byte b2) {
        this(bVar, aVar);
    }

    public final void a(a.d dVar) {
        k.c(dVar, "subscriptionStatus");
        throw new n("An operation is not implemented: ".concat("not implemented"));
    }

    public final void a(a.b bVar) {
        k.c(bVar, "disableSubscription");
        throw new n("An operation is not implemented: ".concat("not implemented"));
    }

    public final void a(h hVar) {
        k.c(hVar, "callBack");
        throw new n("An operation is not implemented: ".concat("Not yet implemented"));
    }

    public final void a(IJRDataModel iJRDataModel, String str, String str2, String str3, a.C0872a aVar) {
        k.c(str3, "requestType");
        k.c(aVar, H5Event.TYPE_CALL_BACK);
        throw new n("An operation is not implemented: ".concat("not implemented"));
    }

    public final void a(boolean z, a.h hVar) {
        k.c(hVar, "savedCardListener");
        throw new n("An operation is not implemented: ".concat("Not yet implemented"));
    }

    public final void a(String str, a.e eVar) {
        k.c(str, "cardString");
        k.c(eVar, H5Event.TYPE_CALL_BACK);
        throw new n("An operation is not implemented: ".concat("not implemented"));
    }

    public final void a(String str, a.i iVar) {
        k.c(iVar, H5Event.TYPE_CALL_BACK);
        throw new n("An operation is not implemented: ".concat("not implemented"));
    }

    public final void a(a.f fVar) {
        k.c(fVar, H5Param.PARAM);
        throw new n("An operation is not implemented: ".concat("not implemented"));
    }

    public final void a(ArrayList<TncData> arrayList, a.g gVar) {
        k.c(arrayList, "tncDataList");
        k.c(gVar, "saveTncListener");
        throw new n("An operation is not implemented: ".concat("not implemented"));
    }

    public final void a(String str, a.j jVar) {
        k.c(jVar, "walletSSOTokenListener");
        throw new n("An operation is not implemented: ".concat("not implemented"));
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static c a(b bVar, a aVar) {
            k.c(bVar, "appExecutors");
            k.c(aVar, "tasksDao");
            if (c.f49250d == null) {
                synchronized (d.INSTANCE) {
                    c.f49250d = new c(bVar, aVar, (byte) 0);
                    x xVar = x.f47997a;
                }
            }
            c a2 = c.f49250d;
            if (a2 == null) {
                k.a();
            }
            return a2;
        }
    }
}
