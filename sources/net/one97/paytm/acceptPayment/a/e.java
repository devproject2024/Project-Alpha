package net.one97.paytm.acceptPayment.a;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentContainerView;
import com.google.android.material.appbar.AppBarLayout;

public abstract class e extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final AppBarLayout f51980a;

    /* renamed from: b  reason: collision with root package name */
    public final FragmentContainerView f51981b;

    /* renamed from: c  reason: collision with root package name */
    public final CoordinatorLayout f51982c;

    /* renamed from: d  reason: collision with root package name */
    public final Toolbar f51983d;

    protected e(Object obj, View view, AppBarLayout appBarLayout, FragmentContainerView fragmentContainerView, CoordinatorLayout coordinatorLayout, Toolbar toolbar) {
        super(obj, view, 0);
        this.f51980a = appBarLayout;
        this.f51981b = fragmentContainerView;
        this.f51982c = coordinatorLayout;
        this.f51983d = toolbar;
    }
}
