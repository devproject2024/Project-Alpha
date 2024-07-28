package net.one97.paytm.moneytransferv4.b.a.a;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.contacts.entities.beans.ContactsResponse;
import net.one97.paytm.moneytransferv4.b.a.a.a.a.a;
import net.one97.paytm.moneytransferv4.b.a.a.a.b.a;
import net.one97.paytm.moneytransferv4.b.a.a.a.c.a;
import net.one97.paytm.moneytransferv4.b.a.a.a.d.b;
import net.one97.paytm.moneytransferv4.b.a.a.a.e.a;
import net.one97.paytm.moneytransferv4.b.a.a.a.e.b;
import net.one97.paytm.moneytransferv4.b.a.a.a.f.a;
import net.one97.paytm.moneytransferv4.b.a.a.a.g.a;
import net.one97.paytm.moneytransferv4.b.a.a.a.g.f;
import net.one97.paytm.moneytransferv4.b.a.a.a.h.a;
import net.one97.paytm.moneytransferv4.b.a.a.a.i.a;
import net.one97.paytm.moneytransferv4.b.a.a.a.j.b;
import net.one97.paytm.moneytransferv4.b.a.a.f;
import net.one97.paytm.moneytransferv4.b.a.a.h;
import net.one97.paytm.upi.common.upi.UpiPendingRequestModel;

public final class c extends b<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    public int f55343a = -1;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<e<RecyclerView.v>> f55344b;

    /* renamed from: c  reason: collision with root package name */
    private d f55345c;

    /* renamed from: d  reason: collision with root package name */
    private final j f55346d;

    public c(ArrayList<e<RecyclerView.v>> arrayList, j jVar) {
        k.c(arrayList, "widgetItemManagers");
        k.c(jVar, "supportFragmentManager");
        this.f55344b = arrayList;
        this.f55346d = jVar;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        h.a aVar = h.f55349a;
        d dVar = this.f55345c;
        if (dVar == null) {
            k.a("clickListener");
        }
        k.c(viewGroup, "parent");
        k.c(dVar, "onWidgetClickListener");
        f.a aVar2 = f.f55348a;
        View a2 = f.a.a(viewGroup, i2);
        if (i2 == g.WIDGET_TYPE_TITLE.getId()) {
            return new a.C1017a(a2);
        }
        if (i2 == g.WIDGET_TYPE_SEARCH.getId()) {
            return new a.C1016a(a2);
        }
        if (i2 == g.WIDGET_TYPE_PAYMENT_OPTIONS.getId()) {
            return new f.a(a2, dVar);
        }
        if (i2 == g.WIDGET_TYPE_BENEFICIARIES.getId()) {
            return new a.C1002a(a2, dVar);
        }
        if (i2 == g.WIDGET_TYPE_UPI_REGISTRATION.getId()) {
            return new b.a(a2, dVar);
        }
        if (i2 == g.WIDGET_TYPE_CONTACTS.getId()) {
            return new a.C1009a(a2, dVar);
        }
        if (i2 == g.WIDGET_TYPE_CONTACT_PERMISSION.getId()) {
            return new b.a(a2, dVar);
        }
        if (i2 == g.WIDGET_TYPE_CONTACT_MOTIF.getId()) {
            return new a.C1013a(a2);
        }
        if (i2 == g.WIDGET_TYPE_ALL_IN_ONE.getId()) {
            return new a.C1001a(a2);
        }
        if (i2 == g.WIDGET_TYPE_ADD_BANK.getId()) {
            return new a.C1000a(a2);
        }
        if (i2 == g.WIDGET_TYPE_COLLECT_REQUEST.getId()) {
            return new b.a(a2);
        }
        return new a.C1017a(a2);
    }

    public final int getItemViewType(int i2) {
        e<RecyclerView.v> eVar = this.f55344b.get(i2);
        k.a((Object) eVar, "widgetItemManagers[position]");
        return eVar.a();
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        e<RecyclerView.v> eVar = this.f55344b.get(i2);
        k.a((Object) eVar, "widgetItemManagers[position]");
        e eVar2 = eVar;
        eVar2.f55347a = i2;
        eVar2.a(vVar, i2);
    }

    public final int getItemCount() {
        return this.f55344b.size();
    }

    public final void a(d dVar) {
        k.c(dVar, "clickListener");
        this.f55345c = dVar;
        Iterator<e<RecyclerView.v>> it2 = this.f55344b.iterator();
        while (it2.hasNext()) {
            it2.next().a(dVar);
        }
    }

    public final void a(a aVar) {
        k.c(aVar, "dataModel");
        if (aVar instanceof net.one97.paytm.moneytransferv4.b.a.a.a.c.c) {
            net.one97.paytm.moneytransferv4.b.a.a.a.c.c cVar = (net.one97.paytm.moneytransferv4.b.a.a.a.c.c) aVar;
            Iterator<e<RecyclerView.v>> it2 = this.f55344b.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                e next = it2.next();
                if (!(next instanceof net.one97.paytm.moneytransferv4.b.a.a.a.c.a)) {
                    next = null;
                }
                net.one97.paytm.moneytransferv4.b.a.a.a.c.a aVar2 = (net.one97.paytm.moneytransferv4.b.a.a.a.c.a) next;
                if (aVar2 != null) {
                    a aVar3 = cVar;
                    k.c(aVar3, "model");
                    aVar2.f55189d = true;
                    net.one97.paytm.moneytransferv4.b.a.a.a.c.c cVar2 = (net.one97.paytm.moneytransferv4.b.a.a.a.c.c) aVar3;
                    ArrayList<ContactsResponse> arrayList = cVar2.f55216a;
                    if (arrayList == null || arrayList.size() != 0) {
                        aVar2.f55188c = false;
                    } else {
                        aVar2.f55188c = true;
                    }
                    aVar2.f55187b = cVar2.f55216a;
                    aVar2.notifyItemChanged(0);
                    notifyItemChanged(i2);
                    return;
                }
                i2++;
            }
        } else if (aVar instanceof net.one97.paytm.moneytransferv4.b.a.a.a.j.a) {
            net.one97.paytm.moneytransferv4.b.a.a.a.j.a aVar4 = (net.one97.paytm.moneytransferv4.b.a.a.a.j.a) aVar;
            Iterator<e<RecyclerView.v>> it3 = this.f55344b.iterator();
            int i3 = 0;
            while (it3.hasNext()) {
                e next2 = it3.next();
                if (!(next2 instanceof net.one97.paytm.moneytransferv4.b.a.a.a.j.b)) {
                    next2 = null;
                }
                net.one97.paytm.moneytransferv4.b.a.a.a.j.b bVar = (net.one97.paytm.moneytransferv4.b.a.a.a.j.b) next2;
                if (bVar != null) {
                    a aVar5 = aVar4;
                    k.c(aVar5, "model");
                    bVar.f55321b = ((net.one97.paytm.moneytransferv4.b.a.a.a.j.a) aVar5).f55320a;
                    bVar.notifyItemChanged(0);
                    notifyItemChanged(i3);
                    return;
                }
                i3++;
            }
        }
    }

    public final void a(int i2) {
        if (i2 == -1) {
            int i3 = this.f55343a;
            if (i3 >= 0) {
                e<RecyclerView.v> eVar = this.f55344b.get(i3);
                if (eVar != null) {
                    ((net.one97.paytm.moneytransferv4.b.a.a.a.e.a) eVar).a(false);
                    notifyItemChanged(this.f55343a);
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.moneytransferv4.common.baserecycleradapter.core.widgets.contacts.ContactItemAdapter");
                }
            }
        } else {
            e<RecyclerView.v> eVar2 = this.f55344b.get(i2);
            if (eVar2 != null) {
                ((net.one97.paytm.moneytransferv4.b.a.a.a.e.a) eVar2).a(true);
                notifyItemChanged(i2);
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.moneytransferv4.common.baserecycleradapter.core.widgets.contacts.ContactItemAdapter");
            }
        }
        this.f55343a = i2;
    }

    public final void onViewAttachedToWindow(RecyclerView.v vVar) {
        k.c(vVar, "holder");
        super.onViewAttachedToWindow(vVar);
        if (vVar instanceof f.a) {
            int id = ((f.a) vVar).f55313a.getId();
            Fragment c2 = this.f55346d.c(id);
            if (c2 == null) {
                q a2 = this.f55346d.a();
                a.C1014a aVar = net.one97.paytm.moneytransferv4.b.a.a.a.g.a.f55292b;
                a2.a(id, (Fragment) a.C1014a.a((Bundle) null)).e();
                return;
            }
            this.f55346d.a().a(c2).e();
            q a3 = this.f55346d.a();
            a.C1014a aVar2 = net.one97.paytm.moneytransferv4.b.a.a.a.g.a.f55292b;
            a3.b(id, a.C1014a.a((Bundle) null)).e();
        }
    }

    public final void onViewDetachedFromWindow(RecyclerView.v vVar) {
        Fragment c2;
        k.c(vVar, "holder");
        super.onViewDetachedFromWindow(vVar);
        if ((vVar instanceof f.a) && (c2 = this.f55346d.c(((f.a) vVar).f55313a.getId())) != null) {
            this.f55346d.a().a(c2).c();
        }
    }

    public final void a(String str, int i2) {
        k.c(str, "txId");
        if (this.f55344b.get(i2).a() == g.WIDGET_TYPE_COLLECT_REQUEST.getId()) {
            e<RecyclerView.v> eVar = this.f55344b.get(i2);
            if (eVar != null) {
                net.one97.paytm.moneytransferv4.b.a.a.a.d.b bVar = (net.one97.paytm.moneytransferv4.b.a.a.a.d.b) eVar;
                if (bVar.f55230c.size() == 1) {
                    this.f55344b.remove(i2);
                    notifyItemRemoved(i2);
                    return;
                }
                Iterator<UpiPendingRequestModel> it2 = bVar.f55230c.iterator();
                k.a((Object) it2, "currentAdapter.getPendingRequest().iterator()");
                while (true) {
                    if (it2.hasNext()) {
                        if (it2.next().getTxnId().equals(str)) {
                            it2.remove();
                            break;
                        }
                    } else {
                        break;
                    }
                }
                bVar.a(bVar.f55230c);
                notifyItemChanged(i2);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.moneytransferv4.common.baserecycleradapter.core.widgets.collectrequest.CollectRequestAdapter");
        }
    }
}
