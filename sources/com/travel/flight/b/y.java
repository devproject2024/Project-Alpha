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
import com.travel.flight.flightSRPV2.viewModel.DRTListViewModel;
import com.travel.flight.flightSRPV2.viewModel.SRPSharedViewModel;

public abstract class y extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView f24046a;

    /* renamed from: b  reason: collision with root package name */
    public final bo f24047b;

    /* renamed from: c  reason: collision with root package name */
    public final bi f24048c;

    /* renamed from: d  reason: collision with root package name */
    public final RoboTextView f24049d;

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f24050e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f24051f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f24052g;

    /* renamed from: h  reason: collision with root package name */
    public final RoboTextView f24053h;

    /* renamed from: i  reason: collision with root package name */
    public final SwipeRefreshLayout f24054i;
    public final RoboTextView j;
    public final LinearLayout k;
    public final ImageView l;
    public final ImageView m;
    public final RoboTextView n;
    public final RecyclerView o;
    public final RecyclerView p;
    public final View q;
    public final View r;
    protected SRPSharedViewModel s;
    protected DRTListViewModel t;

    public abstract void a(DRTListViewModel dRTListViewModel);

    public abstract void a(SRPSharedViewModel sRPSharedViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected y(Object obj, View view, RecyclerView recyclerView, bo boVar, bi biVar, RoboTextView roboTextView, LinearLayout linearLayout, ImageView imageView, ImageView imageView2, RoboTextView roboTextView2, SwipeRefreshLayout swipeRefreshLayout, RoboTextView roboTextView3, LinearLayout linearLayout2, ImageView imageView3, ImageView imageView4, RoboTextView roboTextView4, RecyclerView recyclerView2, RecyclerView recyclerView3, View view2, View view3) {
        super(obj, view, 10);
        Object obj2 = obj;
        View view4 = view;
        this.f24046a = recyclerView;
        this.f24047b = boVar;
        setContainedBinding(this.f24047b);
        this.f24048c = biVar;
        setContainedBinding(this.f24048c);
        this.f24049d = roboTextView;
        this.f24050e = linearLayout;
        this.f24051f = imageView;
        this.f24052g = imageView2;
        this.f24053h = roboTextView2;
        this.f24054i = swipeRefreshLayout;
        this.j = roboTextView3;
        this.k = linearLayout2;
        this.l = imageView3;
        this.m = imageView4;
        this.n = roboTextView4;
        this.o = recyclerView2;
        this.p = recyclerView3;
        this.q = view2;
        this.r = view3;
    }

    public static y a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (y) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_domestic_round_trip, viewGroup, false, f.a());
    }
}
