package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.view.fragment.ReportReviewBottomSheet;
import com.paytmmall.clpartifact.view.viewmodel.StoreRatingViewModel;

public abstract class FragmentReportBinding extends ViewDataBinding {
    public final ImageView closeButton;
    public final TextView content;
    public final TextView header;
    protected ReportReviewBottomSheet mFragment;
    protected StoreRatingViewModel mViewModel;
    public final ImageView tickIcon;

    public abstract void setFragment(ReportReviewBottomSheet reportReviewBottomSheet);

    public abstract void setViewModel(StoreRatingViewModel storeRatingViewModel);

    protected FragmentReportBinding(e eVar, View view, int i2, ImageView imageView, TextView textView, TextView textView2, ImageView imageView2) {
        super(eVar, view, i2);
        this.closeButton = imageView;
        this.content = textView;
        this.header = textView2;
        this.tickIcon = imageView2;
    }

    public ReportReviewBottomSheet getFragment() {
        return this.mFragment;
    }

    public StoreRatingViewModel getViewModel() {
        return this.mViewModel;
    }

    public static FragmentReportBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static FragmentReportBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (FragmentReportBinding) f.a(layoutInflater, R.layout.fragment_report, viewGroup, z, eVar);
    }

    public static FragmentReportBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static FragmentReportBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (FragmentReportBinding) f.a(layoutInflater, R.layout.fragment_report, (ViewGroup) null, false, eVar);
    }

    public static FragmentReportBinding bind(View view) {
        return bind(view, f.a());
    }

    public static FragmentReportBinding bind(View view, e eVar) {
        return (FragmentReportBinding) bind(eVar, view, R.layout.fragment_report);
    }
}
