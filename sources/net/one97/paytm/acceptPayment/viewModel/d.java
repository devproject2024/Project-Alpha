package net.one97.paytm.acceptPayment.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.ai;
import androidx.lifecycle.w;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.google.gson.f;
import com.google.gson.g;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import kotlin.x;
import net.one97.paytm.acceptPayment.activities.AcceptPaymentInitActivity;
import net.one97.paytm.acceptPayment.model.Active;
import net.one97.paytm.acceptPayment.model.ApiError;
import net.one97.paytm.acceptPayment.model.ApiSuccesss;
import net.one97.paytm.acceptPayment.model.InActive;
import net.one97.paytm.acceptPayment.model.NetworkRequest;
import net.one97.paytm.acceptPayment.model.NoNetworkError;
import net.one97.paytm.acceptPayment.model.RequestStatus;

public abstract class d extends ai {

    /* renamed from: h  reason: collision with root package name */
    public String f52188h = "";

    /* renamed from: i  reason: collision with root package name */
    public w<n> f52189i = new w<>();
    public final f j = new g().a();
    final y<Integer> k;

    static final class c<T> implements z<i> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f52194a = new c();

        c() {
        }

        public final /* bridge */ /* synthetic */ void onChanged(Object obj) {
        }
    }

    static final class b<I, O> implements androidx.arch.core.c.a<NetworkRequest, i> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f52193a;

        b(d dVar) {
            this.f52193a = dVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            Integer value;
            NetworkRequest networkRequest = (NetworkRequest) obj;
            RequestStatus status = networkRequest.getStatus();
            if (k.a((Object) status, (Object) ApiSuccesss.INSTANCE)) {
                kotlin.g.a.b<NetworkRequest, x> onSuccess = networkRequest.getOnSuccess();
                if (onSuccess != null) {
                    k.b(networkRequest, "request");
                    onSuccess.invoke(networkRequest);
                }
            } else if (k.a((Object) status, (Object) ApiError.INSTANCE)) {
                kotlin.g.a.a<x> onError = networkRequest.getOnError();
                if (onError != null) {
                    onError.invoke();
                } else {
                    w<n> wVar = this.f52193a.f52189i;
                    String name = AcceptPaymentInitActivity.class.getName();
                    k.b(name, "AcceptPaymentInitActivity::class.java.name");
                    wVar.setValue(new f(name, networkRequest.getNetworkCustomError()));
                }
            } else if (k.a((Object) status, (Object) NoNetworkError.INSTANCE)) {
                this.f52193a.f52189i.setValue(new j(networkRequest.getCjrCommonNetworkCall()));
            }
            d dVar = this.f52193a;
            k.b(networkRequest, "request");
            k.d(networkRequest, "networkRequest");
            if (k.a((Object) networkRequest.getStatus(), (Object) Active.INSTANCE)) {
                Integer value2 = dVar.k.getValue();
                if (value2 != null) {
                    dVar.k.setValue(Integer.valueOf(value2.intValue() + 1));
                } else {
                    dVar.k.setValue(1);
                }
            } else if ((k.a((Object) networkRequest.getStatus(), (Object) ApiSuccesss.INSTANCE) || k.a((Object) networkRequest.getStatus(), (Object) ApiError.INSTANCE)) && (value = dVar.k.getValue()) != null && k.a(value.intValue(), 0) > 0) {
                dVar.k.setValue(Integer.valueOf(value.intValue() - 1));
            }
            return i.f52201a;
        }
    }

    /* renamed from: net.one97.paytm.acceptPayment.viewModel.d$d  reason: collision with other inner class name */
    static final class C0936d<I, O> implements androidx.arch.core.c.a<Boolean, LiveData<NetworkRequest>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.a f52195a;

        C0936d(kotlin.g.a.a aVar) {
            this.f52195a = aVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            if (((Boolean) obj).booleanValue()) {
                return (LiveData) this.f52195a.invoke();
            }
            y yVar = new y();
            yVar.setValue(new NetworkRequest(InActive.INSTANCE, (IJRPaytmDataModel) null, (NetworkCustomError) null, (com.paytm.network.a) null, (kotlin.g.a.b) null, (kotlin.g.a.a) null, 62, (kotlin.g.b.g) null));
            return yVar;
        }
    }

    public d() {
        y<Integer> yVar = new y<>();
        this.k = yVar;
        this.f52189i.addSource(yVar, new z<Integer>(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ d f52190a;

            {
                this.f52190a = r1;
            }

            public final /* synthetic */ void onChanged(Object obj) {
                if (((Integer) obj).intValue() > 0) {
                    this.f52190a.f52189i.setValue(l.f52204a);
                } else {
                    this.f52190a.f52189i.setValue(h.f52200a);
                }
            }
        });
    }

    public final void a(String str) {
        k.d(str, "<set-?>");
        this.f52188h = str;
    }

    public final a a(kotlin.g.a.a<? extends LiveData<NetworkRequest>> aVar) {
        k.d(aVar, "request");
        a aVar2 = new a();
        LiveData<NetworkRequest> b2 = ah.b(aVar2.f52192b, new C0936d(aVar));
        k.b(b2, "Transformations.switchMa…)\n            }\n        }");
        aVar2.f52191a = b2;
        a(b2);
        return aVar2;
    }

    private final void a(LiveData<NetworkRequest> liveData) {
        this.f52189i.addSource(ah.a(liveData, new b(this)), c.f52194a);
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        LiveData<NetworkRequest> f52191a;

        /* renamed from: b  reason: collision with root package name */
        final y<Boolean> f52192b = new y<>(Boolean.FALSE);

        public final boolean a() {
            return k.a((Object) this.f52192b.getValue(), (Object) Boolean.TRUE);
        }

        public final void b() {
            this.f52192b.postValue(Boolean.TRUE);
        }
    }
}
