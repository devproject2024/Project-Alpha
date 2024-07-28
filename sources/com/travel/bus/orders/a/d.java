package com.travel.bus.orders.a;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.bus.orders.c.c;
import com.travel.bus.orders.f.i;
import java.util.List;

public final class d extends RecyclerView.a {

    /* renamed from: a  reason: collision with root package name */
    private final i f22567a;

    /* renamed from: b  reason: collision with root package name */
    private final List<c.a> f22568b;

    public d(List<c.a> list, i iVar) {
        this.f22568b = list;
        this.f22567a = iVar;
    }

    public final int getItemViewType(int i2) {
        return this.f22567a.a(i2);
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return this.f22567a.a(viewGroup, i2);
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        this.f22567a.a(vVar);
    }

    public final int getItemCount() {
        List<c.a> list = this.f22568b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
