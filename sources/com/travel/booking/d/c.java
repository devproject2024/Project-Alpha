package com.travel.booking.d;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ai;
import com.travel.a;

public final class c extends a {

    /* renamed from: a  reason: collision with root package name */
    private final ViewDataBinding f21478a;

    public c(ViewDataBinding viewDataBinding) {
        super(viewDataBinding.getRoot());
        this.f21478a = viewDataBinding;
    }

    public final void a(Object obj, ai aiVar) {
        this.f21478a.setVariable(a.f21418c, obj);
        this.f21478a.setVariable(a.f21417b, aiVar);
        this.f21478a.executePendingBindings();
    }
}
