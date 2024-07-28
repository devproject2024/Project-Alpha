package net.one97.paytm.acceptPayment.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import net.one97.paytm.acceptPayment.R;

public abstract class i extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f51996a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f51997b;

    /* renamed from: c  reason: collision with root package name */
    public final SwipeRefreshLayout f51998c;

    /* renamed from: d  reason: collision with root package name */
    public final CoordinatorLayout f51999d;

    protected i(Object obj, View view, ConstraintLayout constraintLayout, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, CoordinatorLayout coordinatorLayout) {
        super(obj, view, 0);
        this.f51996a = constraintLayout;
        this.f51997b = recyclerView;
        this.f51998c = swipeRefreshLayout;
        this.f51999d = coordinatorLayout;
    }

    public static i a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (i) ViewDataBinding.inflateInternal(layoutInflater, R.layout.ap_fragment, viewGroup, false, f.a());
    }
}
