package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import androidx.databinding.n;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.appbar.AppBarLayout;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.view.adapter.SFHomeAdapter;
import com.paytmmall.clpartifact.view.viewmodel.SFHomeVM;

public abstract class FragmentHomeBinding extends ViewDataBinding {
    public final View commonToolbar;
    public final CoordinatorLayout container;
    public final FrameLayout floatingNavContainer;
    public final AppBarLayout homeAppBar;
    public final RecyclerView homeRv;
    protected SFHomeAdapter mAdapter;
    protected SFHomeVM mViewModel;
    public final n noNetwork;
    public final LottieAnimationView progressLoader;
    public final TextView scanBtn;
    public final View screenoverlay;

    public abstract void setAdapter(SFHomeAdapter sFHomeAdapter);

    public abstract void setViewModel(SFHomeVM sFHomeVM);

    protected FragmentHomeBinding(e eVar, View view, int i2, View view2, CoordinatorLayout coordinatorLayout, FrameLayout frameLayout, AppBarLayout appBarLayout, RecyclerView recyclerView, n nVar, LottieAnimationView lottieAnimationView, TextView textView, View view3) {
        super(eVar, view, i2);
        this.commonToolbar = view2;
        this.container = coordinatorLayout;
        this.floatingNavContainer = frameLayout;
        this.homeAppBar = appBarLayout;
        this.homeRv = recyclerView;
        this.noNetwork = nVar;
        this.progressLoader = lottieAnimationView;
        this.scanBtn = textView;
        this.screenoverlay = view3;
    }

    public SFHomeAdapter getAdapter() {
        return this.mAdapter;
    }

    public SFHomeVM getViewModel() {
        return this.mViewModel;
    }

    public static FragmentHomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static FragmentHomeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (FragmentHomeBinding) f.a(layoutInflater, R.layout.fragment_home, viewGroup, z, eVar);
    }

    public static FragmentHomeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static FragmentHomeBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (FragmentHomeBinding) f.a(layoutInflater, R.layout.fragment_home, (ViewGroup) null, false, eVar);
    }

    public static FragmentHomeBinding bind(View view) {
        return bind(view, f.a());
    }

    public static FragmentHomeBinding bind(View view, e eVar) {
        return (FragmentHomeBinding) bind(eVar, view, R.layout.fragment_home);
    }
}
