package com.travel.booking.d;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ai;
import com.travel.a;

public final class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private final ViewDataBinding f21477a;

    public b(ViewDataBinding viewDataBinding) {
        super(viewDataBinding.getRoot());
        this.f21477a = viewDataBinding;
    }

    public final void a(Object obj, ai aiVar) {
        this.f21477a.setVariable(a.f21418c, obj);
        this.f21477a.setVariable(a.f21417b, aiVar);
        this.f21477a.executePendingBindings();
    }
}
