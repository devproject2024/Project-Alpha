package net.one97.paytm.bankOpen.ica.d;

import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import kotlin.g.b.x;
import net.one97.paytm.bankCommon.b.c;
import net.one97.paytm.bankCommon.g.g;

public final class f extends ai {

    static final class a<T> implements g.b<IJRPaytmDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f16608a;

        a(x.e eVar) {
            this.f16608a = eVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            c.a aVar = c.f16215d;
            ((y) this.f16608a.element).postValue(c.a.a((IJRPaytmDataModel) obj));
        }
    }

    public static y<c<Object>> a() {
        x.e eVar = new x.e();
        eVar.element = new y();
        net.one97.paytm.bankOpen.ica.a aVar = net.one97.paytm.bankOpen.ica.a.f16435a;
        net.one97.paytm.bankOpen.ica.a.c(new a(eVar), new b(eVar));
        return (y) eVar.element;
    }

    static final class b implements g.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f16609a;

        b(x.e eVar) {
            this.f16609a = eVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            c.a aVar = c.f16215d;
            k.a((Object) networkCustomError, "p2");
            ((y) this.f16609a.element).postValue(c.a.a((Throwable) networkCustomError));
        }
    }
}
