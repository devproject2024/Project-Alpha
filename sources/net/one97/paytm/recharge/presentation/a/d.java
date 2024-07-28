package net.one97.paytm.recharge.presentation.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrder;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.presentation.d.b;
import net.one97.paytm.recharge.presentation.f.a;
import net.one97.paytm.recharge.presentation.f.c;
import net.one97.paytm.recharge.presentation.f.f;

public final class d extends RecyclerView.a<f> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f64593a;

    /* renamed from: b  reason: collision with root package name */
    public List<CJRFrequentOrder> f64594b;

    /* renamed from: c  reason: collision with root package name */
    private final int f64595c = 3;

    /* renamed from: d  reason: collision with root package name */
    private final int f64596d = 1;

    /* renamed from: e  reason: collision with root package name */
    private final int f64597e = 2;

    /* renamed from: f  reason: collision with root package name */
    private final b f64598f;

    public d(List<CJRFrequentOrder> list, b bVar) {
        k.c(list, "orderList");
        k.c(bVar, "itemClickListener");
        this.f64594b = list;
        this.f64598f = bVar;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        f fVar = (f) vVar;
        k.c(fVar, "holder");
        if (i2 < getItemCount() - 1) {
            fVar.a(this.f64594b.get(i2));
        } else {
            fVar.a(null);
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        f fVar;
        k.c(viewGroup, "parent");
        if (i2 == this.f64597e) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_automatic_recents, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(pare…c_recents, parent, false)");
            fVar = new c(inflate, this.f64598f);
        } else {
            View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_new_number_automatic_setup, viewGroup, false);
            k.a((Object) inflate2, "LayoutInflater.from(pare…tic_setup, parent, false)");
            fVar = new a(inflate2, this.f64598f);
        }
        return fVar;
    }

    public final int getItemCount() {
        int size;
        boolean z = this.f64593a;
        if (z) {
            size = this.f64594b.size();
        } else if (z) {
            throw new m();
        } else if (this.f64594b.isEmpty()) {
            return 1;
        } else {
            int size2 = this.f64594b.size();
            int i2 = this.f64595c;
            if (size2 > i2) {
                return i2 + 1;
            }
            size = this.f64594b.size();
        }
        return size + 1;
    }

    public final int getItemViewType(int i2) {
        if (i2 == getItemCount() - 1) {
            return this.f64596d;
        }
        return this.f64597e;
    }
}
