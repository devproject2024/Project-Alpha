package net.one97.paytm.v2.features.cashbackoffers.c;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.vipcashback.Facets;
import net.one97.paytm.common.entity.vipcashback.VoucherFilterResponse;
import net.one97.paytm.vipcashback.f.h;

public final class c extends ai {

    /* renamed from: a  reason: collision with root package name */
    public y<h<Object>> f20376a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public y<ArrayList<Facets>> f20377b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public y<h<Object>> f20378c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public net.one97.paytm.v2.features.cashbackoffers.b.c f20379d;

    /* renamed from: e  reason: collision with root package name */
    public LiveData<String> f20380e;

    static final class a<I, O> implements androidx.arch.core.c.a<X, Y> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f20381a;

        a(c cVar) {
            this.f20381a = cVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            h hVar = (h) obj;
            int i2 = hVar.f20893a;
            if (i2 == 101) {
                T t = hVar.f20894b;
                if (!(t instanceof VoucherFilterResponse)) {
                    return "result";
                }
                this.f20381a.f20377b.setValue(((VoucherFilterResponse) t).getFacetsList());
                return "result";
            } else if (i2 != 102 && i2 != 104) {
                return "result";
            } else {
                this.f20381a.f20378c.setValue(hVar);
                return "result";
            }
        }
    }

    public c() {
        LiveData<String> a2 = ah.a(this.f20376a, new a(this));
        k.a((Object) a2, "Transformations.map(apiR… }\n        \"result\"\n    }");
        this.f20380e = a2;
    }
}
