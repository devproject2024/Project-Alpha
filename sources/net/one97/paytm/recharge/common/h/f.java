package net.one97.paytm.recharge.common.h;

import android.text.TextUtils;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import kotlin.g.a.q;
import kotlin.g.b.i;
import kotlin.g.b.k;
import kotlin.k.d;
import kotlin.m.p;
import kotlin.x;
import net.one97.paytm.recharge.common.b.c;
import net.one97.paytm.recharge.common.utils.j;
import net.one97.paytm.recharge.common.utils.w;
import net.one97.paytm.recharge.model.rechargeutility.CJRGetUserConsentApiResponse;
import net.one97.paytm.recharge.model.rechargeutility.CJRSetUserConsentApiResponse;
import net.one97.paytm.recharge.model.rechargeutility.UnsubscribeApiResponse;
import net.one97.paytm.recharge.model.v4.CJRInstruct;
import net.one97.paytm.recharge.model.v4.Data;
import net.one97.paytm.recharge.model.v4.DataState;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public final class f extends ai {

    /* renamed from: a  reason: collision with root package name */
    public final y<Data<CJRSetUserConsentApiResponse>> f61438a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public final y<Data<CJRGetUserConsentApiResponse>> f61439b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public final y<Data<UnsubscribeApiResponse>> f61440c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public j f61441d;

    /* renamed from: e  reason: collision with root package name */
    public y<Boolean> f61442e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    public final w f61443f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap<Object, Object> f61444g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private final c f61445h;

    static final /* synthetic */ class a extends i implements kotlin.g.a.b<CJRInstruct, x> {
        a(f fVar) {
            super(1, fVar);
        }

        public final String getName() {
            return "performUIOperation";
        }

        public final d getOwner() {
            return kotlin.g.b.y.b(f.class);
        }

        public final String getSignature() {
            return "performUIOperation(Lnet/one97/paytm/recharge/model/v4/CJRInstruct;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((CJRInstruct) obj);
            return x.f47997a;
        }

        public final void invoke(CJRInstruct cJRInstruct) {
            k.c(cJRInstruct, "p1");
            f fVar = (f) this.receiver;
            k.c(cJRInstruct, "cjrInstruct");
            if (cJRInstruct instanceof CJRInstruct.updateCreateBillResponse) {
                fVar.f61438a.postValue(new Data(DataState.SUCCESS, ((CJRInstruct.updateCreateBillResponse) cJRInstruct).getSetUserConsentResponse(), (String) null));
            } else if (cJRInstruct instanceof CJRInstruct.updateGetBillResponse) {
                fVar.f61439b.postValue(new Data(DataState.SUCCESS, ((CJRInstruct.updateGetBillResponse) cJRInstruct).getGetUserConsentResponse(), (String) null));
            } else if (cJRInstruct instanceof CJRInstruct.updateUnsubscribeBillResponse) {
                fVar.f61440c.postValue(new Data(DataState.SUCCESS, ((CJRInstruct.updateUnsubscribeBillResponse) cJRInstruct).getUnsubscribeResponse(), (String) null));
            }
        }
    }

    static final /* synthetic */ class b extends i implements q<String, NetworkCustomError, Object, x> {
        b(f fVar) {
            super(3, fVar);
        }

        public final String getName() {
            return "onErrorResponse";
        }

        public final d getOwner() {
            return kotlin.g.b.y.b(f.class);
        }

        public final String getSignature() {
            return "onErrorResponse(Ljava/lang/String;Lcom/paytm/network/model/NetworkCustomError;Ljava/lang/Object;)V";
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            invoke((String) obj, (NetworkCustomError) obj2, obj3);
            return x.f47997a;
        }

        public final void invoke(String str, NetworkCustomError networkCustomError, Object obj) {
            f fVar = (f) this.receiver;
            if (networkCustomError != null && (networkCustomError instanceof net.one97.paytm.recharge.common.utils.d)) {
                String url = ((net.one97.paytm.recharge.common.utils.d) networkCustomError).getUrl();
                CharSequence charSequence = url;
                if (!TextUtils.isEmpty(charSequence)) {
                    k.a((Object) url, "url");
                    if (p.a(charSequence, (CharSequence) "getBill", false)) {
                        fVar.f61439b.postValue(new Data(DataState.ERROR, null, (String) null));
                    } else if (p.a(charSequence, (CharSequence) "createBill", false)) {
                        fVar.f61438a.postValue(new Data(DataState.ERROR, null, (String) null));
                    }
                }
            }
        }
    }

    public f(c cVar, w wVar) {
        k.c(cVar, "rechargeRepo");
        k.c(wVar, "rechargeProceedHelper");
        this.f61445h = cVar;
        this.f61443f = wVar;
        w wVar2 = this.f61443f;
        f fVar = this;
        wVar2.f61787g = new a(fVar);
        wVar2.f61789i = this.f61445h;
        wVar2.f61788h = new b(fVar);
    }

    public final void a(HashMap<Object, Object> hashMap) {
        k.c(hashMap, "<set-?>");
        this.f61444g = hashMap;
    }

    public final void b(HashMap<Object, Object> hashMap) {
        k.c(hashMap, "params");
        this.f61438a.postValue(new Data(DataState.LOADING, null, (String) null));
        w wVar = this.f61443f;
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        wVar.a("fetch_set_user_consent", hashMap, (Object) net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null));
    }

    public final void a(net.one97.paytm.recharge.common.e.ai aiVar, String str, HashMap<Object, Object> hashMap) {
        k.c(aiVar, "onSuccess");
        k.c(str, "customerId");
        k.c(hashMap, "params");
        w wVar = this.f61443f;
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        wVar.a("fetch_set_user_consent", aiVar, str, hashMap, (Object) net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null));
    }

    public final void c(HashMap<Object, Object> hashMap) {
        k.c(hashMap, "paramMap");
        w wVar = this.f61443f;
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        wVar.b("fetch_get_user_consent", hashMap, (Object) net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null));
    }

    public final void a(boolean z) {
        this.f61442e.setValue(Boolean.valueOf(z));
    }
}
