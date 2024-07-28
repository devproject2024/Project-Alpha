package net.one97.paytm.acceptPayment.f;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.a.m;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.x;
import net.one97.paytm.acceptPayment.model.Active;
import net.one97.paytm.acceptPayment.model.ApiError;
import net.one97.paytm.acceptPayment.model.ApiSuccesss;
import net.one97.paytm.acceptPayment.model.NetworkRequest;
import net.one97.paytm.acceptPayment.model.NoNetworkError;

public abstract class b {
    public static <T> LiveData<NetworkRequest> a(m<? super com.paytm.network.listener.b, ? super T, ? extends com.paytm.network.a> mVar, kotlin.g.a.b<? super NetworkRequest, x> bVar, kotlin.g.a.a<x> aVar, T t) {
        k.d(mVar, "getRequestData");
        x.e eVar = new x.e();
        eVar.element = null;
        y yVar = new y(new NetworkRequest(Active.INSTANCE, (IJRPaytmDataModel) null, (NetworkCustomError) null, (com.paytm.network.a) null, (kotlin.g.a.b) null, (kotlin.g.a.a) null, 62, (g) null));
        eVar.element = (com.paytm.network.a) mVar.invoke(new a(yVar, bVar, aVar, eVar), t);
        net.one97.paytm.acceptPayment.b.a b2 = net.one97.paytm.acceptPayment.configs.a.a().b();
        k.b(b2, "AcceptPaymentsConfig.get…tAcceptPaymentsListener()");
        if (com.paytm.utility.b.c(b2.a())) {
            yVar.setValue(new NetworkRequest(Active.INSTANCE, (IJRPaytmDataModel) null, (NetworkCustomError) null, (com.paytm.network.a) eVar.element, (kotlin.g.a.b) null, (kotlin.g.a.a) null, 54, (g) null));
            com.paytm.network.a aVar2 = (com.paytm.network.a) eVar.element;
            if (aVar2 != null) {
                aVar2.a();
            }
        } else {
            yVar.setValue(new NetworkRequest(NoNetworkError.INSTANCE, (IJRPaytmDataModel) null, (NetworkCustomError) null, (com.paytm.network.a) eVar.element, (kotlin.g.a.b) null, (kotlin.g.a.a) null, 48, (g) null));
        }
        return yVar;
    }

    public static final class a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ y f52062a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.b f52063b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.a f52064c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ x.e f52065d;

        a(y yVar, kotlin.g.a.b bVar, kotlin.g.a.a aVar, x.e eVar) {
            this.f52062a = yVar;
            this.f52063b = bVar;
            this.f52064c = aVar;
            this.f52065d = eVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            IJRPaytmDataModel iJRPaytmDataModel2 = iJRPaytmDataModel;
            NetworkCustomError networkCustomError2 = networkCustomError;
            this.f52062a.setValue(new NetworkRequest(ApiError.INSTANCE, iJRPaytmDataModel2, networkCustomError2, (com.paytm.network.a) this.f52065d.element, this.f52063b, this.f52064c));
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            IJRPaytmDataModel iJRPaytmDataModel2 = iJRPaytmDataModel;
            this.f52062a.setValue(new NetworkRequest(ApiSuccesss.INSTANCE, iJRPaytmDataModel2, (NetworkCustomError) null, (com.paytm.network.a) this.f52065d.element, this.f52063b, this.f52064c, 4, (g) null));
        }
    }
}
