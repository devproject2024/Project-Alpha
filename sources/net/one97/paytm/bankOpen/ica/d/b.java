package net.one97.paytm.bankOpen.ica.d;

import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.g.b.x;
import net.one97.paytm.bankCommon.b.c;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.PBTncData;

public final class b extends ai {

    /* renamed from: a  reason: collision with root package name */
    y<net.one97.paytm.bankCommon.b.c<Object>> f16590a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public y<net.one97.paytm.bankCommon.b.c<Object>> f16591b = new y<>();

    public static final class a<T> implements g.b<IJRPaytmDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f16592a;

        public a(b bVar) {
            this.f16592a = bVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            c.a aVar = net.one97.paytm.bankCommon.b.c.f16215d;
            this.f16592a.f16591b.postValue(c.a.a((IJRPaytmDataModel) obj));
        }
    }

    static final class c<T> implements g.b<IJRPaytmDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f16594a;

        c(b bVar) {
            this.f16594a = bVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            c.a aVar = net.one97.paytm.bankCommon.b.c.f16215d;
            this.f16594a.f16590a.postValue(c.a.a((IJRPaytmDataModel) obj));
        }
    }

    static final class e<T> implements g.b<IJRPaytmDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f16596a;

        e(x.e eVar) {
            this.f16596a = eVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            c.a aVar = net.one97.paytm.bankCommon.b.c.f16215d;
            ((y) this.f16596a.element).postValue(c.a.a((IJRPaytmDataModel) obj));
        }
    }

    static final class g<T> implements g.b<IJRPaytmDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f16598a;

        g(x.e eVar) {
            this.f16598a = eVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            c.a aVar = net.one97.paytm.bankCommon.b.c.f16215d;
            ((y) this.f16598a.element).postValue(c.a.a((IJRPaytmDataModel) obj));
        }
    }

    public static y<net.one97.paytm.bankCommon.b.c<Object>> a() {
        x.e eVar = new x.e();
        eVar.element = new y();
        net.one97.paytm.bankOpen.ica.a aVar = net.one97.paytm.bankOpen.ica.a.f16435a;
        net.one97.paytm.bankOpen.ica.a.b(new e(eVar), new f(eVar));
        return (y) eVar.element;
    }

    static final class f implements g.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f16597a;

        f(x.e eVar) {
            this.f16597a = eVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            c.a aVar = net.one97.paytm.bankCommon.b.c.f16215d;
            k.a((Object) networkCustomError, "p2");
            ((y) this.f16597a.element).postValue(c.a.a((Throwable) networkCustomError));
        }
    }

    public final y<net.one97.paytm.bankCommon.b.c<Object>> b() {
        net.one97.paytm.bankOpen.ica.a.f16435a.d(new c(this), new d(this));
        return this.f16590a;
    }

    static final class d implements g.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f16595a;

        d(b bVar) {
            this.f16595a = bVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            c.a aVar = net.one97.paytm.bankCommon.b.c.f16215d;
            k.a((Object) networkCustomError, "p2");
            this.f16595a.f16590a.postValue(c.a.a((Throwable) networkCustomError));
        }
    }

    /* renamed from: net.one97.paytm.bankOpen.ica.d.b$b  reason: collision with other inner class name */
    public static final class C0242b implements g.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f16593a;

        public C0242b(b bVar) {
            this.f16593a = bVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            c.a aVar = net.one97.paytm.bankCommon.b.c.f16215d;
            k.a((Object) networkCustomError, "p2");
            this.f16593a.f16591b.postValue(c.a.a((Throwable) networkCustomError));
        }
    }

    public static y<net.one97.paytm.bankCommon.b.c<Object>> a(ArrayList<PBTncData> arrayList, ArrayList<PBTncData> arrayList2) {
        k.c(arrayList, "mTncDataList");
        k.c(arrayList2, "mPostPaidTnc");
        x.e eVar = new x.e();
        eVar.element = new y();
        ArrayList arrayList3 = new ArrayList();
        arrayList3.addAll(arrayList);
        arrayList3.addAll(arrayList2);
        net.one97.paytm.bankOpen.ica.a.f16435a.a(arrayList3, new g(eVar), new h(eVar));
        return (y) eVar.element;
    }

    static final class h implements g.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f16599a;

        h(x.e eVar) {
            this.f16599a = eVar;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            c.a aVar = net.one97.paytm.bankCommon.b.c.f16215d;
            k.a((Object) networkCustomError, "p2");
            ((y) this.f16599a.element).postValue(c.a.a((Throwable) networkCustomError));
        }
    }
}
