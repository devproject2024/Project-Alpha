package net.one97.paytm.v2.features.cashbackoffers.c;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.k;
import net.one97.paytm.cashback.posttxn.Campaign;
import net.one97.paytm.cashback.posttxn.CashbackBaseTagOfferListModel;
import net.one97.paytm.cashback.posttxn.CashbackTagOffersListModel;
import net.one97.paytm.cashback.posttxn.InfoV4;
import net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4;
import net.one97.paytm.vipcashback.d.a;
import net.one97.paytm.vipcashback.f.h;

public final class b extends ai implements a {
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.a> f20368a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.v2.a.b f20369b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<Campaign> f20370c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    ArrayList<VIPCashBackOfferV4> f20371d = new ArrayList<>();
    /* access modifiers changed from: package-private */

    /* renamed from: e  reason: collision with root package name */
    public net.one97.paytm.v2.b.b f20372e = new net.one97.paytm.v2.b.b();

    /* renamed from: f  reason: collision with root package name */
    boolean f20373f;

    /* renamed from: g  reason: collision with root package name */
    private LiveData<String> f20374g;

    public final LiveData<String> a() {
        return null;
    }

    public final void f() {
    }

    static final class a<I, O> implements androidx.arch.core.c.a<X, Y> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f20375a;

        a(b bVar) {
            this.f20375a = bVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            Campaign campaign;
            h hVar = (h) obj;
            switch (hVar.f20893a) {
                case 101:
                    T t = hVar.f20894b;
                    boolean z = t instanceof CashbackBaseTagOfferListModel;
                    if (!z) {
                        return "result";
                    }
                    b bVar = this.f20375a;
                    bVar.f20372e.f20056c.setValue(Boolean.FALSE);
                    if (!z) {
                        return "result";
                    }
                    CashbackBaseTagOfferListModel cashbackBaseTagOfferListModel = (CashbackBaseTagOfferListModel) t;
                    CashbackTagOffersListModel data = cashbackBaseTagOfferListModel.getData();
                    ArrayList<Campaign> newOffers = data != null ? data.getNewOffers() : null;
                    CashbackTagOffersListModel data2 = cashbackBaseTagOfferListModel.getData();
                    ArrayList<VIPCashBackOfferV4> myOffers = data2 != null ? data2.getMyOffers() : null;
                    ArrayList arrayList = new ArrayList();
                    boolean z2 = false;
                    if (bVar.f20373f) {
                        bVar.f20370c.clear();
                        bVar.f20371d.clear();
                        ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.a> arrayList2 = bVar.f20368a;
                        if (arrayList2 != null) {
                            arrayList2.clear();
                        }
                        bVar.f20373f = false;
                    }
                    Collection collection = myOffers;
                    if (!(collection == null || collection.isEmpty())) {
                        Iterator<VIPCashBackOfferV4> it2 = myOffers.iterator();
                        while (it2.hasNext()) {
                            VIPCashBackOfferV4 next = it2.next();
                            a.C0382a.C0383a aVar = a.C0382a.f20768a;
                            int a2 = a.C0382a.f20769b;
                            k.a((Object) next, "item");
                            InfoV4 info = next.getInfo();
                            arrayList.add(new net.one97.paytm.v2.features.cashbacklanding.model.a((info == null || (campaign = info.getCampaign()) == null) ? null : campaign.getNewOffersImageUrl(), (String) null, next.getUnlock_text(), (String) null, a2, 32));
                        }
                        bVar.f20371d.addAll(collection);
                    }
                    Collection collection2 = newOffers;
                    if (collection2 == null || collection2.isEmpty()) {
                        z2 = true;
                    }
                    if (!z2) {
                        Iterator<Campaign> it3 = newOffers.iterator();
                        while (it3.hasNext()) {
                            Campaign next2 = it3.next();
                            a.C0382a.C0383a aVar2 = a.C0382a.f20768a;
                            int c2 = a.C0382a.f20771d;
                            k.a((Object) next2, "item");
                            net.one97.paytm.v2.features.cashbacklanding.model.a aVar3 = new net.one97.paytm.v2.features.cashbacklanding.model.a(next2.getNewOffersImageUrl(), next2.getBackgroundImageUrl(), next2.getOfferKeyword(), next2.getOfferTextOverride(), c2, 32);
                            Boolean backgroundOverlay = next2.getBackgroundOverlay();
                            k.a((Object) backgroundOverlay, "item.backgroundOverlay");
                            aVar3.f20295h = backgroundOverlay.booleanValue();
                            arrayList.add(aVar3);
                        }
                        bVar.f20370c.addAll(collection2);
                    }
                    if (arrayList.size() != 0) {
                        bVar.f20368a.addAll(arrayList);
                        bVar.f20372e.f20054a.setValue(h.a(bVar.f20368a));
                        return "result";
                    } else if (bVar.f20368a.size() != 0) {
                        return "result";
                    } else {
                        bVar.f20372e.f20054a.setValue(h.b());
                        return "result";
                    }
                case 102:
                case 104:
                    this.f20375a.f20372e.f20054a.setValue(hVar);
                    return "result";
                case 103:
                    if (this.f20375a.f20368a.size() != 0) {
                        return "result";
                    }
                    this.f20375a.f20372e.f20054a.setValue(hVar);
                    return "result";
                default:
                    return "result";
            }
        }
    }

    public b() {
        LiveData<String> a2 = ah.a(this.f20372e.f20055b, new a(this));
        k.a((Object) a2, "Transformations.map(basi… }\n        \"result\"\n    }");
        this.f20374g = a2;
    }

    public final LiveData<h<Object>> b() {
        return this.f20372e.f20054a;
    }

    public final LiveData<Boolean> c() {
        return this.f20372e.f20056c;
    }

    public final LiveData<String> d() {
        return this.f20374g;
    }

    public final void a(String str) {
        k.c(str, "offerTag");
        this.f20373f = true;
        this.f20372e.f20058e.setValue(Boolean.FALSE);
        b(str);
    }

    public final void b(String str) {
        k.c(str, "offerTag");
        net.one97.paytm.v2.a.b bVar = this.f20369b;
        if (bVar == null) {
            k.a("repository");
        }
        bVar.a(this.f20372e.f20055b, str);
    }

    public final LiveData<Boolean> e() {
        return this.f20372e.f20058e;
    }

    public final LiveData<Object> a(int i2) {
        y yVar = new y();
        if (i2 >= 0 && i2 < this.f20371d.size()) {
            yVar.setValue(this.f20371d.get(i2));
        } else if (i2 >= this.f20371d.size() && i2 < this.f20370c.size() + this.f20371d.size()) {
            yVar.setValue(this.f20370c.get(i2 - this.f20371d.size()));
        }
        return yVar;
    }
}
