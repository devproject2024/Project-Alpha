package net.one97.paytm.h5paytmsdk.b;

import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.nebula.provider.H5ProviderManager;
import com.alipay.mobile.nebulacore.Nebula;
import kotlin.g.b.k;
import net.one97.paytm.h5paytmsdk.c.q;
import net.one97.paytm.h5paytmsdk.c.r;

public final class l extends ad {
    public l() {
        super("paytmFetchValuesForKeys");
    }

    public final boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        super.handleEvent(h5Event, h5BridgeContext);
        if (b(h5Event)) {
            H5ProviderManager providerManager = Nebula.getProviderManager();
            q qVar = (q) (providerManager != null ? providerManager.getProvider(q.class.getName()) : null);
            if (qVar == null) {
                a(H5Event.Error.FORBIDDEN, "No implementation found for 'PaytmH5FetchValuesForKeysProvider'");
            }
            if (h5Event == null) {
                k.a();
            }
            com.alibaba.a.b jSONArray = h5Event.getParam().getJSONArray("keys");
            if (jSONArray == null) {
                jSONArray = new com.alibaba.a.b();
            }
            if (jSONArray.size() == 1) {
                Object obj = jSONArray.get(0);
                if ((obj instanceof String) && qVar != null) {
                    qVar.provideValuesForKeys((String) obj, new b(this, obj));
                }
            } else {
                for (Object next : jSONArray) {
                    if ((next instanceof String) && qVar != null) {
                        qVar.provideValuesForKeys((String) next, new a(next, this, qVar));
                    }
                }
                a((Object) null);
            }
        }
        return true;
    }

    public static final class b implements r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f17025a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f17026b;

        b(l lVar, Object obj) {
            this.f17025a = lVar;
            this.f17026b = obj;
        }

        public final void a(Object obj) {
            l lVar = this.f17025a;
            String str = (String) this.f17026b;
            if (obj == null) {
                obj = "";
            }
            lVar.a(str, obj);
            this.f17025a.a((Object) null);
        }
    }

    public static final class a implements r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f17022a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l f17023b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ q f17024c;

        a(Object obj, l lVar, q qVar) {
            this.f17022a = obj;
            this.f17023b = lVar;
            this.f17024c = qVar;
        }

        public final void a(Object obj) {
            l lVar = this.f17023b;
            String str = (String) this.f17022a;
            k.c(str, "key");
            k.c(str, "key");
            Object obj2 = lVar.f16977b.get(str);
            if (obj2 == null || k.a((Object) "", obj2)) {
                if (obj == null) {
                    obj = "";
                }
                lVar.a(str, obj);
            }
        }
    }
}
