package com.travel.flight.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.paytm.utility.RoboTextView;
import com.travel.flight.R;
import com.travel.flight.flightSRPV2.viewModel.SRPOneWayViewModel;

public abstract class au extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final bm f23636a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f23637b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f23638c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f23639d;

    /* renamed from: e  reason: collision with root package name */
    public final SwipeRefreshLayout f23640e;

    /* renamed from: f  reason: collision with root package name */
    public final RecyclerView f23641f;

    /* renamed from: g  reason: collision with root package name */
    public final RecyclerView f23642g;

    /* renamed from: h  reason: collision with root package name */
    public final RoboTextView f23643h;

    /* renamed from: i  reason: collision with root package name */
    protected SRPOneWayViewModel f23644i;

    public abstract void a(SRPOneWayViewModel sRPOneWayViewModel);

    protected au(Object obj, View view, bm bmVar, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, SwipeRefreshLayout swipeRefreshLayout, RecyclerView recyclerView, RecyclerView recyclerView2, RoboTextView roboTextView) {
        super(obj, view, 4);
        this.f23636a = bmVar;
        setContainedBinding(this.f23636a);
        this.f23637b = imageView;
        this.f23638c = imageView2;
        this.f23639d = linearLayout;
        this.f23640e = swipeRefreshLayout;
        this.f23641f = recyclerView;
        this.f23642g = recyclerView2;
        this.f23643h = roboTextView;
    }

    public static au a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (au) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_srp_one_way_v2, viewGroup, false, f.a());
    }
}
