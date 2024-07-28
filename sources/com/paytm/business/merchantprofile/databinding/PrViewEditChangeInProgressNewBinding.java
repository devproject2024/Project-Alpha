package com.paytm.business.merchantprofile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.business.common_module.view.widget.CustomTextView;
import com.paytm.business.merchantprofile.R;

public abstract class PrViewEditChangeInProgressNewBinding extends ViewDataBinding {
    public final ImageView ivTicketStatus;
    public final RelativeLayout parent;
    public final ProgressBar progress;
    public final TextView tvDescription;
    public final CustomTextView tvUpload;

    public PrViewEditChangeInProgressNewBinding(Object obj, View view, int i2, ImageView imageView, RelativeLayout relativeLayout, ProgressBar progressBar, TextView textView, CustomTextView customTextView) {
        super(obj, view, i2);
        this.ivTicketStatus = imageView;
        this.parent = relativeLayout;
        this.progress = progressBar;
        this.tvDescription = textView;
        this.tvUpload = customTextView;
    }

    public static PrViewEditChangeInProgressNewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    @Deprecated
    public static PrViewEditChangeInProgressNewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (PrViewEditChangeInProgressNewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_view_edit_change_in_progress_new, viewGroup, z, obj);
    }

    public static PrViewEditChangeInProgressNewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    @Deprecated
    public static PrViewEditChangeInProgressNewBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (PrViewEditChangeInProgressNewBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.pr_view_edit_change_in_progress_new, (ViewGroup) null, false, obj);
    }

    public static PrViewEditChangeInProgressNewBinding bind(View view) {
        return bind(view, f.a());
    }

    @Deprecated
    public static PrViewEditChangeInProgressNewBinding bind(View view, Object obj) {
        return (PrViewEditChangeInProgressNewBinding) ViewDataBinding.bind(obj, view, R.layout.pr_view_edit_change_in_progress_new);
    }
}
