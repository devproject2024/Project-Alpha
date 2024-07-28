package com.travel.flight.flightorder.a;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.flight.flightorder.d.b;
import com.travel.flight.flightorder.g.f;
import java.util.List;

public final class c extends RecyclerView.a {

    /* renamed from: a  reason: collision with root package name */
    private final f f24333a;

    /* renamed from: b  reason: collision with root package name */
    private final List<b.a> f24334b;

    public c(List<b.a> list, f fVar) {
        this.f24334b = list;
        this.f24333a = fVar;
    }

    public final int getItemViewType(int i2) {
        return this.f24333a.a(i2);
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return this.f24333a.a(viewGroup, i2);
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        this.f24333a.a(vVar);
    }

    public final int getItemCount() {
        List<b.a> list = this.f24334b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
