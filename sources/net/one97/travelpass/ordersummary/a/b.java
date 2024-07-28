package net.one97.travelpass.ordersummary.a;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import kotlin.g.b.k;
import net.one97.travelpass.b;
import net.one97.travelpass.c;
import net.one97.travelpass.f.d;
import net.one97.travelpass.f.e;
import net.one97.travelpass.f.f;
import net.one97.travelpass.f.g;
import net.one97.travelpass.f.h;
import net.one97.travelpass.f.i;
import net.one97.travelpass.f.j;
import net.one97.travelpass.f.l;
import net.one97.travelpass.f.m;
import net.one97.travelpass.f.n;
import net.one97.travelpass.ordersummary.g.a;

public final class b extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<a> f30491a;

    /* renamed from: b  reason: collision with root package name */
    private Context f30492b;

    /* renamed from: c  reason: collision with root package name */
    private com.one97.travelpass.a.b f30493c;

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final int getItemViewType(int i2) {
        return i2;
    }

    public b(Context context, ArrayList<a> arrayList, com.one97.travelpass.a.b bVar) {
        k.c(arrayList, "viewHolderListTP");
        k.c(bVar, "itemClickListener");
        this.f30492b = context;
        this.f30491a = arrayList;
        this.f30493c = bVar;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        ArrayList<a> arrayList = this.f30491a;
        if (arrayList == null) {
            k.a();
        }
        net.one97.travelpass.ordersummary.b.a b2 = arrayList.get(i2).b();
        b.a aVar = net.one97.travelpass.b.f30057a;
        Context context = this.f30492b;
        k.c(viewGroup, "parent");
        if (b2 != null) {
            switch (c.f30312a[b2.ordinal()]) {
                case 1:
                    return new f(b.a.a(b2, context, viewGroup));
                case 2:
                    return new net.one97.travelpass.f.a(b.a.a(b2, context, viewGroup));
                case 3:
                    return new net.one97.travelpass.f.b(b.a.a(b2, context, viewGroup));
                case 4:
                    return new e(b.a.a(b2, context, viewGroup));
                case 5:
                    return new com.one97.travelpass.b.a(b.a.a(b2, context, viewGroup));
                case 6:
                    return new net.one97.travelpass.f.c(b.a.a(b2, context, viewGroup));
                case 7:
                    return new i(b.a.a(b2, context, viewGroup));
                case 8:
                    return new m(b.a.a(b2, context, viewGroup));
                case 9:
                    return new d(b.a.a(b2, context, viewGroup));
                case 10:
                    return new h(b.a.a(b2, context, viewGroup));
                case 11:
                    return new g(b.a.a(b2, context, viewGroup));
                case 12:
                    return new j(b.a.a(b2, context, viewGroup));
                case 13:
                    return new net.one97.travelpass.f.k(b.a.a(b2, context, viewGroup));
                case 14:
                    return new l(b.a.a(b2, context, viewGroup));
                case 15:
                    return new n(b.a.a(b2, context, viewGroup));
            }
        }
        System.out.print("");
        return new f(b.a.a(b2, context, viewGroup));
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        if (vVar instanceof com.one97.travelpass.a.a) {
            com.one97.travelpass.a.a aVar = (com.one97.travelpass.a.a) vVar;
            Context context = this.f30492b;
            ArrayList<a> arrayList = this.f30491a;
            if (arrayList == null) {
                k.a();
            }
            a aVar2 = arrayList.get(i2);
            k.a((Object) aVar2, "viewHolderList!!.get(position)");
            aVar.a(context, i2, aVar2, this.f30493c);
        }
    }

    public final int getItemCount() {
        ArrayList<a> arrayList = this.f30491a;
        if (arrayList == null) {
            k.a();
        }
        return arrayList.size();
    }
}
