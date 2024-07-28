package net.one97.travelpass.a;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.travelpass.f;
import net.one97.travelpass.f.o;
import net.one97.travelpass.f.p;
import net.one97.travelpass.f.q;
import net.one97.travelpass.f.r;
import net.one97.travelpass.f.s;
import net.one97.travelpass.f.t;
import net.one97.travelpass.f.u;
import net.one97.travelpass.f.v;
import net.one97.travelpass.f.w;
import net.one97.travelpass.f.y;
import net.one97.travelpass.f.z;
import net.one97.travelpass.g;
import net.one97.travelpass.ui.b.b;
import net.one97.travelpass.ui.c.d;
import net.one97.travelpass.ui.c.e;
import net.one97.travelpass.ui.c.h;
import net.one97.travelpass.ui.c.i;
import net.one97.travelpass.ui.c.j;

public final class c extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    int f30050a;

    /* renamed from: b  reason: collision with root package name */
    int f30051b;

    /* renamed from: c  reason: collision with root package name */
    private Context f30052c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<j> f30053d;

    /* renamed from: e  reason: collision with root package name */
    private com.one97.travelpass.a.c f30054e;

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView.l f30055f = new a(this);

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public c(Context context, ArrayList<j> arrayList, com.one97.travelpass.a.c cVar) {
        k.c(arrayList, "viewHolderList");
        k.c(cVar, "itemClickListener");
        this.f30052c = context;
        this.f30053d = arrayList;
        this.f30054e = cVar;
    }

    public final void a(ArrayList<j> arrayList) {
        k.c(arrayList, "<set-?>");
        this.f30053d = arrayList;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        RecyclerView.v vVar;
        k.c(viewGroup, "parent");
        b bVar = b.values()[i2];
        f.a aVar = f.f30337a;
        Context context = this.f30052c;
        k.c(viewGroup, "parent");
        if (bVar != null) {
            switch (g.f30469a[bVar.ordinal()]) {
                case 1:
                    vVar = new s(f.a.a(bVar, context, viewGroup));
                    break;
                case 2:
                    vVar = new com.one97.travelpass.b.b(f.a.a(bVar, context, viewGroup));
                    break;
                case 3:
                    vVar = new y(f.a.a(bVar, context, viewGroup));
                    break;
                case 4:
                    vVar = new v(f.a.a(bVar, context, viewGroup));
                    break;
                case 5:
                    vVar = new net.one97.travelpass.ui.c.c(f.a.a(bVar, context, viewGroup));
                    break;
                case 6:
                    vVar = new h(f.a.a(bVar, context, viewGroup));
                    break;
                case 7:
                    vVar = new net.one97.travelpass.ui.c.g(f.a.a(bVar, context, viewGroup));
                    break;
                case 8:
                    vVar = new r(f.a.a(bVar, context, viewGroup));
                    break;
                case 9:
                    vVar = new p(f.a.a(bVar, context, viewGroup));
                    break;
                case 10:
                    vVar = new z(f.a.a(bVar, context, viewGroup));
                    break;
                case 11:
                    vVar = new o(f.a.a(bVar, context, viewGroup));
                    break;
                case 12:
                    vVar = new e(f.a.a(bVar, context, viewGroup));
                    break;
                case 13:
                    vVar = new d(f.a.a(bVar, context, viewGroup));
                    break;
                case 14:
                    vVar = new u(f.a.a(bVar, context, viewGroup));
                    break;
                case 15:
                    vVar = new t(f.a.a(bVar, context, viewGroup));
                    break;
                case 16:
                    vVar = new net.one97.travelpass.ui.c.f(f.a.a(bVar, context, viewGroup));
                    break;
                case 17:
                    vVar = new w(f.a.a(bVar, context, viewGroup));
                    break;
                case 18:
                    vVar = new q(f.a.a(bVar, context, viewGroup));
                    break;
                case 19:
                    vVar = new net.one97.travelpass.ui.c.a(f.a.a(bVar, context, viewGroup));
                    break;
                case 20:
                    vVar = new i(f.a.a(bVar, context, viewGroup));
                    break;
                case 21:
                    vVar = new net.one97.travelpass.ui.c.b(f.a.a(bVar, context, viewGroup));
                    break;
            }
        }
        System.out.print("");
        vVar = new s(f.a.a(bVar, context, viewGroup));
        if (vVar instanceof h) {
            h hVar = (h) vVar;
            hVar.f30651d = this.f30055f;
            hVar.f30650c = this.f30051b;
            hVar.f30649b = this.f30050a;
            this.f30051b = 0;
            this.f30050a = 0;
        }
        return vVar;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        j jVar;
        b c2;
        k.c(vVar, "holder");
        if (vVar instanceof com.one97.travelpass.a.d) {
            ArrayList<j> arrayList = this.f30053d;
            if (!(arrayList == null || (jVar = arrayList.get(i2)) == null || (c2 = jVar.c()) == null || c2.ordinal() != b.TRAVEL_PASS_CAROUSEL.ordinal())) {
                vVar.setIsRecyclable(false);
            }
            if (vVar instanceof h) {
                h hVar = (h) vVar;
                hVar.f30649b = this.f30050a;
                hVar.f30650c = this.f30051b;
                this.f30051b = 0;
                this.f30050a = 0;
            }
            com.one97.travelpass.a.d dVar = (com.one97.travelpass.a.d) vVar;
            Context context = this.f30052c;
            ArrayList<j> arrayList2 = this.f30053d;
            if (arrayList2 == null) {
                k.a();
            }
            j jVar2 = arrayList2.get(i2);
            k.a((Object) jVar2, "viewHolderList!!.get(position)");
            j jVar3 = jVar2;
            com.one97.travelpass.a.c cVar = this.f30054e;
            if (cVar == null) {
                k.a();
            }
            dVar.a(context, i2, jVar3, cVar);
        }
    }

    public final void onViewRecycled(RecyclerView.v vVar) {
        k.c(vVar, "holder");
        super.onViewRecycled(vVar);
    }

    public final int getItemViewType(int i2) {
        StringBuilder sb = new StringBuilder("current holderList size : ");
        sb.append(this.f30053d.size());
        sb.append(" position: ");
        sb.append(i2);
        return this.f30053d.get(i2).c().ordinal();
    }

    public final int getItemCount() {
        ArrayList<j> arrayList = this.f30053d;
        if (arrayList == null) {
            k.a();
        }
        return arrayList.size();
    }

    public static final class a extends RecyclerView.l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f30056a;

        a(c cVar) {
            this.f30056a = cVar;
        }

        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            k.c(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            this.f30056a.f30050a += i2;
            this.f30056a.f30051b += i3;
        }

        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            k.c(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
        }
    }
}
