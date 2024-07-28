package com.business.merchant_payments.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.merchant_payments.R;

public abstract class MpReportDownloadBottomSheetBinding extends ViewDataBinding {
    public final View currentDivider;
    public final TextView currentHeader;
    public final ConstraintLayout currentItem;
    public final TextView currentSummary;
    public final ImageView currentTickImg;
    public final View customDivider;
    public final TextView customHeader;
    public final ConstraintLayout customItem;
    public final TextView customSummary;
    public final ImageView customTickImg;
    public final TextView downloadBtn;
    public final View todayDivider;
    public final TextView todayHeader;
    public final ConstraintLayout todayItem;
    public final TextView todaySummary;
    public final ImageView todayTickImg;
    public final TextView viewPayment;
    public final View weekDivider;
    public final TextView weekHeader;
    public final ConstraintLayout weekItem;
    public final TextView weekSummary;
    public final ImageView weekTickImg;
    public final View yesterdayDivider;
    public final TextView yesterdayHeader;
    public final ConstraintLayout yesterdayItem;
    public final TextView yesterdaySummary;
    public final ImageView yesterdayTickImg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MpReportDownloadBottomSheetBinding(Object obj, View view, int i2, View view2, TextView textView, ConstraintLayout constraintLayout, TextView textView2, ImageView imageView, View view3, TextView textView3, ConstraintLayout constraintLayout2, TextView textView4, ImageView imageView2, TextView textView5, View view4, TextView textView6, ConstraintLayout constraintLayout3, TextView textView7, ImageView imageView3, TextView textView8, View view5, TextView textView9, ConstraintLayout constraintLayout4, TextView textView10, ImageView imageView4, View view6, TextView textView11, ConstraintLayout constraintLayout5, TextView textView12, ImageView imageView5) {
        super(obj, view, i2);
        this.currentDivider = view2;
        this.currentHeader = textView;
        this.currentItem = constraintLayout;
        this.currentSummary = textView2;
        this.currentTickImg = imageView;
        this.customDivider = view3;
        this.customHeader = textView3;
        this.customItem = constraintLayout2;
        this.customSummary = textView4;
        this.customTickImg = imageView2;
        this.downloadBtn = textView5;
        this.todayDivider = view4;
        this.todayHeader = textView6;
        this.todayItem = constraintLayout3;
        this.todaySummary = textView7;
        this.todayTickImg = imageView3;
        this.viewPayment = textView8;
        this.weekDivider = view5;
        this.weekHeader = textView9;
        this.weekItem = constraintLayout4;
        this.weekSummary = textView10;
        this.weekTickImg = imageView4;
        this.yesterdayDivider = view6;
        this.yesterdayHeader = textView11;
        this.yesterdayItem = constraintLayout5;
        this.yesterdaySummary = textView12;
        this.yesterdayTickImg = imageView5;
    }

    public static MpReportDownloadBottomSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static MpReportDownloadBottomSheetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (MpReportDownloadBottomSheetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_report_download_bottom_sheet, viewGroup, z, obj);
    }

    public static MpReportDownloadBottomSheetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static MpReportDownloadBottomSheetBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (MpReportDownloadBottomSheetBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.mp_report_download_bottom_sheet, (ViewGroup) null, false, obj);
    }

    public static MpReportDownloadBottomSheetBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static MpReportDownloadBottomSheetBinding bind(View view, Object obj) {
        return (MpReportDownloadBottomSheetBinding) ViewDataBinding.bind(obj, view, R.layout.mp_report_download_bottom_sheet);
    }
}
