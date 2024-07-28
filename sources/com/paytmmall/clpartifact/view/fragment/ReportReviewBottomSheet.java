package com.paytmmall.clpartifact.view.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.am;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.databinding.FragmentReportBinding;
import com.paytmmall.clpartifact.modal.ratingreview.CJRReviews;
import com.paytmmall.clpartifact.view.viewmodel.BaseViewModel;
import com.paytmmall.clpartifact.view.viewmodel.StoreRatingViewModel;
import net.one97.paytm.i.f;

public class ReportReviewBottomSheet extends f {
    StoreRatingViewModel viewModel;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.review_sheet_bottom_sheet);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        if (getActivity() != null) {
            this.viewModel = (StoreRatingViewModel) am.a(getActivity()).a(StoreRatingViewModel.class);
        }
        FragmentReportBinding fragmentReportBinding = (FragmentReportBinding) androidx.databinding.f.a(layoutInflater, R.layout.fragment_report, viewGroup, false);
        fragmentReportBinding.setFragment(this);
        fragmentReportBinding.setViewModel(this.viewModel);
        return fragmentReportBinding.getRoot();
    }

    public void onReportClick() {
        if (getArguments() != null && getActivity() != null) {
            if (this.viewModel.getShowReviewSuccess().get() != 0) {
                dismiss();
                return;
            }
            this.viewModel.reportReview((CJRReviews) getArguments().getSerializable(BaseViewModel.KEY_REVIEW_MODEL));
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        this.viewModel.getShowReviewSuccess().set(0);
    }
}
