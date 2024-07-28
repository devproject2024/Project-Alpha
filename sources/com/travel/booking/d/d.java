package com.travel.booking.d;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ai;
import com.travel.a;
import kotlin.g.b.k;

public final class d extends a {

    /* renamed from: a  reason: collision with root package name */
    private final ViewDataBinding f21479a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(ViewDataBinding viewDataBinding) {
        super(viewDataBinding.getRoot());
        k.c(viewDataBinding, "binding");
        this.f21479a = viewDataBinding;
    }

    public final void a(Object obj, ai aiVar) {
        k.c(obj, "obj");
        k.c(aiVar, "viewmodel");
        this.f21479a.setVariable(a.f21418c, obj);
        this.f21479a.setVariable(a.f21417b, aiVar);
        this.f21479a.executePendingBindings();
    }
}
