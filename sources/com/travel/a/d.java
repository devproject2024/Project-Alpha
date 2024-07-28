package com.travel.a;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.k;
import androidx.lifecycle.q;
import androidx.lifecycle.t;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;

public final class d extends RecyclerView.v implements q {

    /* renamed from: a  reason: collision with root package name */
    final ViewDataBinding f21435a;

    /* renamed from: b  reason: collision with root package name */
    private final t f21436b = new t(this);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(ViewDataBinding viewDataBinding) {
        super(viewDataBinding.getRoot());
        k.c(viewDataBinding, "binding");
        this.f21435a = viewDataBinding;
        this.f21436b.a(k.b.INITIALIZED);
    }

    public final androidx.lifecycle.k getLifecycle() {
        return this.f21436b;
    }
}
