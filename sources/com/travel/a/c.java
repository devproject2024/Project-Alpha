package com.travel.a;

import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.c;
import androidx.recyclerview.widget.h;
import androidx.recyclerview.widget.r;
import kotlin.g.b.k;

public abstract class c<T> extends r<T, d> {
    /* access modifiers changed from: protected */
    public abstract ViewDataBinding a(ViewGroup viewGroup);

    /* access modifiers changed from: protected */
    public abstract void a(ViewDataBinding viewDataBinding, T t, int i2);

    public /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        d dVar = (d) vVar;
        k.c(dVar, "holder");
        if (i2 < getItemCount()) {
            a(dVar.f21435a, a(i2), i2);
            dVar.f21435a.executePendingBindings();
        }
    }

    public /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        return new d(a(viewGroup));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(h.c<T> cVar) {
        super(new c.a(cVar).a());
        k.c(cVar, "diffCallback");
    }
}
