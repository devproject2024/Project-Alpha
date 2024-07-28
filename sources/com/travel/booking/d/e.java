package com.travel.booking.d;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ai;
import com.travel.a;

public final class e extends a {

    /* renamed from: a  reason: collision with root package name */
    private final ViewDataBinding f21480a;

    public e(ViewDataBinding viewDataBinding) {
        super(viewDataBinding.getRoot());
        this.f21480a = viewDataBinding;
    }

    public final void a(Object obj, ai aiVar) {
        this.f21480a.setVariable(a.f21418c, obj);
        this.f21480a.setVariable(a.f21417b, aiVar);
        this.f21480a.executePendingBindings();
    }
}
