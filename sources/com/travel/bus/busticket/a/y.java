package com.travel.bus.busticket.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.bus.R;
import com.travel.bus.busticket.b.a;
import com.travel.bus.busticket.e.o;
import com.travel.bus.pojo.busticket.CJRBusTicketFilterItem;
import java.util.ArrayList;
import java.util.List;

public final class y extends RecyclerView.a<o> implements a {

    /* renamed from: a  reason: collision with root package name */
    public List<CJRBusTicketFilterItem> f21804a = null;

    /* renamed from: b  reason: collision with root package name */
    private LayoutInflater f21805b = null;

    /* renamed from: c  reason: collision with root package name */
    private a f21806c;

    /* renamed from: d  reason: collision with root package name */
    private View f21807d;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        o oVar = (o) vVar;
        CJRBusTicketFilterItem cJRBusTicketFilterItem = this.f21804a.get(i2);
        oVar.f22194b = cJRBusTicketFilterItem;
        oVar.f22193a.setText(com.travel.bus.busticket.i.o.a(cJRBusTicketFilterItem));
    }

    public y(LayoutInflater layoutInflater, a aVar, View view) {
        this.f21805b = layoutInflater;
        this.f21806c = aVar;
        this.f21804a = new ArrayList();
        this.f21807d = view;
    }

    public final int getItemCount() {
        return this.f21804a.size();
    }

    public final void onFilterRemoved(CJRBusTicketFilterItem cJRBusTicketFilterItem) {
        this.f21804a.remove(cJRBusTicketFilterItem);
        notifyDataSetChanged();
        a();
        this.f21806c.onFilterRemoved(cJRBusTicketFilterItem);
    }

    public final void a(List<CJRBusTicketFilterItem> list) {
        this.f21804a.clear();
        for (CJRBusTicketFilterItem add : list) {
            this.f21804a.add(add);
        }
        notifyDataSetChanged();
        a();
    }

    public final void a() {
        this.f21807d.setVisibility(this.f21804a.size() > 0 ? 0 : 8);
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new o(this.f21805b.inflate(R.layout.pre_b_layout_list_item_bus_srp_filter, viewGroup, false), this);
    }
}
