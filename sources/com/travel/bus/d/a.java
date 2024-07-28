package com.travel.bus.d;

import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.travel.bus.model.b;
import com.travel.bus.pojo.bussearch.CJRDeal;
import com.travel.bus.pojo.busticket.TripBusDetailsItem;
import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.ab;
import io.reactivex.rxjava3.a.z;
import io.reactivex.rxjava3.b.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;

public final class a extends ai {

    /* renamed from: a  reason: collision with root package name */
    public final y<List<com.travel.bus.model.b>> f22537a = new y<>();

    static final class b<T> implements ab<List<? extends com.travel.bus.model.b>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f22539a;

        b(ArrayList arrayList) {
            this.f22539a = arrayList;
        }

        public final void subscribe(z<List<com.travel.bus.model.b>> zVar) {
            com.travel.bus.model.b bVar;
            if (this.f22539a == null) {
                zVar.onError(new Throwable("List NULL"));
                return;
            }
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (TripBusDetailsItem tripBusDetailsItem : this.f22539a) {
                b.a aVar = com.travel.bus.model.b.f22542e;
                k.c(tripBusDetailsItem, "tripBusDetailsItem");
                if (tripBusDetailsItem.detailedFare == null) {
                    bVar = new com.travel.bus.model.b(tripBusDetailsItem.getFare(), (String) null, false, 14);
                } else if (tripBusDetailsItem.detailedFare.bHasDeals()) {
                    CJRDeal deal = tripBusDetailsItem.detailedFare.getDeal();
                    String valueOf = String.valueOf(tripBusDetailsItem.detailedFare.getBaseFare());
                    if (deal == null) {
                        k.a();
                    }
                    bVar = new com.travel.bus.model.b(valueOf, String.valueOf(deal.getRevisedBaseFare()), true, 8);
                } else {
                    bVar = new com.travel.bus.model.b(String.valueOf(tripBusDetailsItem.detailedFare.getBaseFare()), (String) null, false, 14);
                }
                String str = bVar.f22543a;
                if (str == null) {
                    k.a();
                }
                int parseDouble = (int) Double.parseDouble(str);
                if (!hashMap.containsKey(String.valueOf(parseDouble)) && parseDouble != 0) {
                    arrayList.add(bVar);
                    hashMap.put(String.valueOf(parseDouble), String.valueOf(parseDouble));
                }
            }
            kotlin.a.k.c(arrayList);
            zVar.onSuccess(arrayList);
        }
    }

    public final void a(ArrayList<TripBusDetailsItem> arrayList) {
        io.reactivex.rxjava3.a.y.a(new b(arrayList)).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new C0439a(this));
    }

    /* renamed from: com.travel.bus.d.a$a  reason: collision with other inner class name */
    public static final class C0439a implements aa<List<? extends com.travel.bus.model.b>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f22538a;

        public final void onSubscribe(c cVar) {
            k.c(cVar, "d");
        }

        C0439a(a aVar) {
            this.f22538a = aVar;
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            List list = (List) obj;
            k.c(list, "t");
            this.f22538a.f22537a.postValue(list);
        }

        public final void onError(Throwable th) {
            k.c(th, "e");
            this.f22538a.f22537a.postValue(new ArrayList(0));
        }
    }
}
