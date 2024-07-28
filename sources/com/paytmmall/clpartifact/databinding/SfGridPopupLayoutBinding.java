package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.airbnb.lottie.LottieAnimationView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.customViews.CirclePageIndicator;
import com.paytmmall.clpartifact.view.SFCustomPager;
import com.paytmmall.clpartifact.widgets.component.smarticongrid.viewmodel.SmartGridDataModel;

public abstract class SfGridPopupLayoutBinding extends ViewDataBinding {
    public final SFCustomPager gridViewPager;
    public final Guideline guidelineBegin;
    public final Guideline guidelineEnd;
    public final Guideline guidelineTop;
    public final CirclePageIndicator indicator;
    protected SmartGridDataModel mDataModel;
    public final ConstraintLayout popupLayout;
    public final LottieAnimationView progressLottie;
    public final ImageView tickerIcon;
    public final LinearLayout tickerLayout;
    public final TextView tickerText;
    public final TextView titleTV;

    public abstract void setDataModel(SmartGridDataModel smartGridDataModel);

    protected SfGridPopupLayoutBinding(e eVar, View view, int i2, SFCustomPager sFCustomPager, Guideline guideline, Guideline guideline2, Guideline guideline3, CirclePageIndicator circlePageIndicator, ConstraintLayout constraintLayout, LottieAnimationView lottieAnimationView, ImageView imageView, LinearLayout linearLayout, TextView textView, TextView textView2) {
        super(eVar, view, i2);
        this.gridViewPager = sFCustomPager;
        this.guidelineBegin = guideline;
        this.guidelineEnd = guideline2;
        this.guidelineTop = guideline3;
        this.indicator = circlePageIndicator;
        this.popupLayout = constraintLayout;
        this.progressLottie = lottieAnimationView;
        this.tickerIcon = imageView;
        this.tickerLayout = linearLayout;
        this.tickerText = textView;
        this.titleTV = textView2;
    }

    public SmartGridDataModel getDataModel() {
        return this.mDataModel;
    }

    public static SfGridPopupLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static SfGridPopupLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (SfGridPopupLayoutBinding) f.a(layoutInflater, R.layout.sf_grid_popup_layout, viewGroup, z, eVar);
    }

    public static SfGridPopupLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static SfGridPopupLayoutBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (SfGridPopupLayoutBinding) f.a(layoutInflater, R.layout.sf_grid_popup_layout, (ViewGroup) null, false, eVar);
    }

    public static SfGridPopupLayoutBinding bind(View view) {
        return bind(view, f.a());
    }

    public static SfGridPopupLayoutBinding bind(View view, e eVar) {
        return (SfGridPopupLayoutBinding) bind(eVar, view, R.layout.sf_grid_popup_layout);
    }
}
