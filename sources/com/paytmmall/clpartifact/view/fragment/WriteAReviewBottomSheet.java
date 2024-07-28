package com.paytmmall.clpartifact.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.am;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.databinding.FragmentReviewBinding;
import com.paytmmall.clpartifact.modal.clpCommon.CJRRatingReview;
import com.paytmmall.clpartifact.view.viewmodel.BaseViewModel;
import com.paytmmall.clpartifact.view.viewmodel.StoreRatingViewModel;
import net.one97.paytm.i.f;

public class WriteAReviewBottomSheet extends f {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.review_sheet_bottom_sheet);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        FragmentReviewBinding fragmentReviewBinding = (FragmentReviewBinding) androidx.databinding.f.a(layoutInflater, R.layout.fragment_review, viewGroup, false);
        fragmentReviewBinding.setViewModel((StoreRatingViewModel) am.a(getActivity()).a(StoreRatingViewModel.class));
        fragmentReviewBinding.setFragment(this);
        if (getArguments() != null) {
            fragmentReviewBinding.setRatingModel((CJRRatingReview) getArguments().getSerializable(BaseViewModel.KEY_RATING_MODEL));
        }
        if (!(getDialog() == null || getDialog().getWindow() == null)) {
            getDialog().getWindow().setSoftInputMode(20);
        }
        return fragmentReviewBinding.getRoot();
    }
}
