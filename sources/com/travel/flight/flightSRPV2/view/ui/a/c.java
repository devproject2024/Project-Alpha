package com.travel.flight.flightSRPV2.view.ui.a;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.R;
import com.travel.flight.flightSRPV2.d.a;
import com.travel.flight.flightSRPV2.viewModel.DRTListViewModel;
import com.travel.flight.pojo.flightticket.CJRDiscountedStrip;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;

public final class c extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    public DRTListViewModel f24181a;

    /* renamed from: b  reason: collision with root package name */
    public List<? extends CJRDiscountedStrip> f24182b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<String> f24183c;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        DRTListViewModel dRTListViewModel = this.f24181a;
        CJRDiscountedStrip cJRDiscountedStrip = (CJRDiscountedStrip) this.f24182b.get(i2);
        ArrayList<String> arrayList = this.f24183c;
        k.c(cJRDiscountedStrip, "discountedStrip");
        aVar.f24176a.setVariable(com.travel.flight.a.f23479c, dRTListViewModel);
        aVar.f24176a.setVariable(com.travel.flight.a.J, cJRDiscountedStrip);
        aVar.f24176a.setVariable(com.travel.flight.a.n, arrayList);
        aVar.f24176a.executePendingBindings();
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        ViewDataBinding a2 = f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.item_drt_discount_strip, viewGroup, false);
        k.a((Object) a2, "DataBindingUtil.inflate(… layoutId, parent, false)");
        return new a(a2);
    }

    public c(DRTListViewModel dRTListViewModel, List<? extends CJRDiscountedStrip> list, ArrayList<String> arrayList) {
        k.c(dRTListViewModel, "viewModel");
        k.c(list, "discountedStrip");
        this.f24181a = dRTListViewModel;
        this.f24182b = list;
        this.f24183c = arrayList;
    }

    public final int getItemCount() {
        return this.f24182b.size();
    }

    public final int getItemViewType(int i2) {
        return R.layout.item_drt_discount_strip;
    }
}
