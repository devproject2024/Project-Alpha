package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.view.viewmodel.RatingVHViewModel;

public abstract class ClpItemChartBinding extends ViewDataBinding {
    protected Integer mRatingData;
    protected String mRatingTotal;
    protected String mStarNumber;
    protected RatingVHViewModel mViewModel;
    public final ProgressBar progressBar;
    public final TextView ratingTotal;
    public final ImageView starIcon;
    public final TextView startNumber;

    public abstract void setRatingData(Integer num);

    public abstract void setRatingTotal(String str);

    public abstract void setStarNumber(String str);

    public abstract void setViewModel(RatingVHViewModel ratingVHViewModel);

    protected ClpItemChartBinding(e eVar, View view, int i2, ProgressBar progressBar2, TextView textView, ImageView imageView, TextView textView2) {
        super(eVar, view, i2);
        this.progressBar = progressBar2;
        this.ratingTotal = textView;
        this.starIcon = imageView;
        this.startNumber = textView2;
    }

    public Integer getRatingData() {
        return this.mRatingData;
    }

    public String getStarNumber() {
        return this.mStarNumber;
    }

    public String getRatingTotal() {
        return this.mRatingTotal;
    }

    public RatingVHViewModel getViewModel() {
        return this.mViewModel;
    }

    public static ClpItemChartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ClpItemChartBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ClpItemChartBinding) f.a(layoutInflater, R.layout.clp_item_chart, viewGroup, z, eVar);
    }

    public static ClpItemChartBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ClpItemChartBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ClpItemChartBinding) f.a(layoutInflater, R.layout.clp_item_chart, (ViewGroup) null, false, eVar);
    }

    public static ClpItemChartBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ClpItemChartBinding bind(View view, e eVar) {
        return (ClpItemChartBinding) bind(eVar, view, R.layout.clp_item_chart);
    }
}
