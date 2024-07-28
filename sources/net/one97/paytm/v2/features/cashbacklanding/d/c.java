package net.one97.paytm.v2.features.cashbacklanding.d;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.k;
import net.one97.paytm.cashback.posttxn.Campaign;
import net.one97.paytm.common.entity.vipcashback.CampaignData;
import net.one97.paytm.v2.a.b;
import net.one97.paytm.vipcashback.d.a;
import net.one97.paytm.vipcashback.f.h;

public final class c extends ai implements net.one97.paytm.v2.features.cashbackoffers.c.a {

    /* renamed from: a  reason: collision with root package name */
    int f20257a = 1;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.a> f20258b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public b f20259c;

    /* renamed from: d  reason: collision with root package name */
    ArrayList<Campaign> f20260d = new ArrayList<>();
    /* access modifiers changed from: package-private */

    /* renamed from: e  reason: collision with root package name */
    public net.one97.paytm.v2.b.b f20261e = new net.one97.paytm.v2.b.b();

    /* renamed from: f  reason: collision with root package name */
    boolean f20262f;

    /* renamed from: g  reason: collision with root package name */
    int f20263g;

    /* renamed from: h  reason: collision with root package name */
    private String f20264h;

    /* renamed from: i  reason: collision with root package name */
    private LiveData<String> f20265i;

    public final LiveData<String> a() {
        return null;
    }

    static final class a<I, O> implements androidx.arch.core.c.a<X, Y> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f20266a;

        a(c cVar) {
            this.f20266a = cVar;
        }

        public final /* synthetic */ Object apply(Object obj) {
            h hVar = (h) obj;
            switch (hVar.f20893a) {
                case 101:
                    T t = hVar.f20894b;
                    boolean z = t instanceof CampaignData;
                    if (!z) {
                        return "result";
                    }
                    c cVar = this.f20266a;
                    if (!z) {
                        return "result";
                    }
                    cVar.f20257a++;
                    CampaignData campaignData = (CampaignData) t;
                    CampaignData.Data data = campaignData.getData();
                    Boolean bool = null;
                    ArrayList<Campaign> campaignsList = data != null ? data.getCampaignsList() : null;
                    Collection collection = campaignsList;
                    if (!(collection == null || collection.isEmpty())) {
                        ArrayList arrayList = new ArrayList();
                        Iterator<Campaign> it2 = campaignsList.iterator();
                        while (it2.hasNext()) {
                            Campaign next = it2.next();
                            a.C0382a.C0383a aVar = a.C0382a.f20768a;
                            int c2 = a.C0382a.f20771d;
                            k.a((Object) next, "item");
                            net.one97.paytm.v2.features.cashbacklanding.model.a aVar2 = new net.one97.paytm.v2.features.cashbacklanding.model.a(next.getNewOffersImageUrl(), next.getBackgroundImageUrl(), next.getOfferKeyword(), next.getOfferTextOverride(), c2, 32);
                            Boolean backgroundOverlay = next.getBackgroundOverlay();
                            k.a((Object) backgroundOverlay, "item.backgroundOverlay");
                            aVar2.f20295h = backgroundOverlay.booleanValue();
                            arrayList.add(aVar2);
                        }
                        if (cVar.f20262f) {
                            cVar.f20260d.clear();
                            ArrayList<net.one97.paytm.v2.features.cashbacklanding.model.a> arrayList2 = cVar.f20258b;
                            if (arrayList2 != null) {
                                arrayList2.clear();
                            }
                            cVar.f20262f = false;
                        }
                        if (arrayList.size() != 0) {
                            cVar.f20258b.addAll(arrayList);
                            cVar.f20261e.f20054a.setValue(h.a(cVar.f20258b));
                        }
                        cVar.f20260d.addAll(collection);
                        Campaign campaign = campaignsList != null ? campaignsList.get(campaignsList.size() - 1) : null;
                        k.a((Object) campaign, "campaignList?.get(campaignList.size-1)");
                        cVar.f20263g = campaign.getId();
                        y<Boolean> yVar = cVar.f20261e.f20058e;
                        CampaignData.Data data2 = campaignData.getData();
                        if (data2 != null) {
                            bool = Boolean.valueOf(data2.isNext());
                        }
                        yVar.setValue(bool);
                        return "result";
                    }
                    cVar.f20261e.f20054a.setValue(h.b());
                    return "result";
                case 102:
                case 104:
                    this.f20266a.f20261e.f20054a.setValue(hVar);
                    return "result";
                case 103:
                    if (this.f20266a.f20258b.size() != 0) {
                        return "result";
                    }
                    this.f20266a.f20261e.f20054a.setValue(hVar);
                    return "result";
                default:
                    return "result";
            }
        }
    }

    public c() {
        LiveData<String> a2 = ah.a(this.f20261e.f20055b, new a(this));
        k.a((Object) a2, "Transformations.map(basi… }\n        \"result\"\n    }");
        this.f20265i = a2;
    }

    public final void a(String str) {
        k.c(str, "offerTag");
        this.f20262f = true;
        this.f20257a = 0;
        this.f20263g = 0;
        this.f20261e.f20058e.setValue(Boolean.FALSE);
        b(str);
    }

    public final void b(String str) {
        k.c(str, "offerTag");
        this.f20264h = str;
        b bVar = this.f20259c;
        if (bVar == null) {
            k.a("repository");
        }
        bVar.a(this.f20261e.f20055b, str, this.f20263g, 1);
    }

    public final void f() {
        b bVar = this.f20259c;
        if (bVar == null) {
            k.a("repository");
        }
        bVar.a(this.f20261e.f20055b, this.f20264h, this.f20263g, this.f20257a);
    }

    public final LiveData<Boolean> e() {
        return this.f20261e.f20058e;
    }

    public final LiveData<h<Object>> b() {
        return this.f20261e.f20054a;
    }

    public final LiveData<Boolean> c() {
        return this.f20261e.f20056c;
    }

    public final LiveData<String> d() {
        return this.f20265i;
    }

    public final LiveData<Object> a(int i2) {
        y yVar = new y();
        if (i2 >= 0 && i2 < this.f20260d.size()) {
            yVar.setValue(this.f20260d.get(i2));
        }
        return yVar;
    }
}
