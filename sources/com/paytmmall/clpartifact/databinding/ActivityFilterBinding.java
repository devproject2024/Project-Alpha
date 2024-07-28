package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.view.FilterActivity;

public abstract class ActivityFilterBinding extends ViewDataBinding {
    public final LinearLayout lytFilterClose;
    public final FrameLayout lytFilterDetail;
    public final LinearLayout lytFilterHeader;
    public final LinearLayout lytFilterList;
    protected FilterActivity mHandler;
    public final ProgressBar progressBar;
    public final RecyclerView rvFilter;

    public abstract void setHandler(FilterActivity filterActivity);

    protected ActivityFilterBinding(e eVar, View view, int i2, LinearLayout linearLayout, FrameLayout frameLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, ProgressBar progressBar2, RecyclerView recyclerView) {
        super(eVar, view, i2);
        this.lytFilterClose = linearLayout;
        this.lytFilterDetail = frameLayout;
        this.lytFilterHeader = linearLayout2;
        this.lytFilterList = linearLayout3;
        this.progressBar = progressBar2;
        this.rvFilter = recyclerView;
    }

    public FilterActivity getHandler() {
        return this.mHandler;
    }

    public static ActivityFilterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ActivityFilterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ActivityFilterBinding) f.a(layoutInflater, R.layout.activity_filter, viewGroup, z, eVar);
    }

    public static ActivityFilterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ActivityFilterBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ActivityFilterBinding) f.a(layoutInflater, R.layout.activity_filter, (ViewGroup) null, false, eVar);
    }

    public static ActivityFilterBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ActivityFilterBinding bind(View view, e eVar) {
        return (ActivityFilterBinding) bind(eVar, view, R.layout.activity_filter);
    }
}
