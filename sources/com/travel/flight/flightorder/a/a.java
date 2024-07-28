package com.travel.flight.flightorder.a;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.R;
import com.travel.flight.b.di;
import com.travel.flight.flightorder.j.e;
import com.travel.flight.pojo.b;
import java.util.ArrayList;
import java.util.List;

public final class a extends RecyclerView.a<e> {

    /* renamed from: a  reason: collision with root package name */
    private List<b> f24328a;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        e eVar = (e) vVar;
        b bVar = this.f24328a.get(i2);
        eVar.f24478b = bVar;
        eVar.f24477a.a(bVar);
        eVar.f24477a.a(eVar.f24479c);
        eVar.f24477a.executePendingBindings();
    }

    public a(List<b> list) {
        this.f24328a = list;
        if (this.f24328a == null) {
            this.f24328a = new ArrayList();
        }
    }

    public final int getItemCount() {
        return this.f24328a.size();
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new e((di) ViewDataBinding.inflateInternal(LayoutInflater.from(viewGroup.getContext()), R.layout.pre_f_item_view_order_summary_hotel_option, viewGroup, false, f.a()));
    }
}
