package com.paytmmall.clpartifact.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.common.RedirectorModel;
import com.paytmmall.clpartifact.databinding.RatingReviewFragmentBinding;
import com.paytmmall.clpartifact.listeners.OnChildFragmentRVScrollListener;
import com.paytmmall.clpartifact.modal.clpCommon.CJRRatingReview;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.modal.ratingreview.IRatingReviewModel;
import com.paytmmall.clpartifact.view.adapter.StoreRatingAdapter;
import com.paytmmall.clpartifact.view.viewmodel.BaseViewModel;
import com.paytmmall.clpartifact.view.viewmodel.StoreRatingViewModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RatingsReviewFragment extends BaseFragment {
    private static final String ARG_ADAPTER_POS = "adapterPosition";
    private static final String ARG_STORE_INFO = "store_info";
    private static final String ARG_STORE_RATING = "store_rating";
    private static final String ARG_URL = "url";
    private StoreRatingAdapter adapter;
    private RatingReviewFragmentBinding mFragmentBinding;
    private StoreRatingViewModel ratingViewModel;

    public static Fragment getInstance(Item item, int i2, View view) {
        RatingsReviewFragment ratingsReviewFragment = new RatingsReviewFragment();
        ratingsReviewFragment.setArguments(getReviewSheetArguments(item, i2, view));
        return ratingsReviewFragment;
    }

    private static Bundle getReviewSheetArguments(Item item, int i2, View view) {
        Bundle bundle = new Bundle();
        bundle.putString("url", item.getSeourl());
        bundle.putInt(ARG_ADAPTER_POS, i2);
        if (view != null) {
            bundle.putSerializable("store_info", view.getStoreInfo());
            bundle.putSerializable(ARG_STORE_RATING, view.getRatingReview());
        }
        return bundle;
    }

    public android.view.View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        createViewModel();
        this.adapter = new StoreRatingAdapter(this.ratingViewModel);
        setBinding(layoutInflater, viewGroup);
        this.ratingViewModel.getReviews().observe(this, new z() {
            public final void onChanged(Object obj) {
                RatingsReviewFragment.this.lambda$onCreateView$0$RatingsReviewFragment((List) obj);
            }
        });
        this.ratingViewModel.setInitData(getInitialData(getArguments()), getPosition(getArguments()));
        return this.mFragmentBinding.getRoot();
    }

    public /* synthetic */ void lambda$onCreateView$0$RatingsReviewFragment(List list) {
        this.adapter.updateList(list);
    }

    private int getPosition(Bundle bundle) {
        if (bundle != null) {
            return bundle.getInt(ARG_ADAPTER_POS, 1);
        }
        return 1;
    }

    public void onViewCreated(android.view.View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        setupListData();
        onCLPChildFragmentChange(getUserVisibleHint());
    }

    private void onCLPChildFragmentChange(boolean z) {
        if (z && getView() != null && (getParentFragment() instanceof OnChildFragmentRVScrollListener)) {
            ((OnChildFragmentRVScrollListener) getParentFragment()).onChildFragmentChange(true, false);
        }
    }

    private void setBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.mFragmentBinding = (RatingReviewFragmentBinding) f.a(layoutInflater, R.layout.rating_review_fragment, viewGroup, false);
        this.mFragmentBinding.setModel(this.ratingViewModel);
        this.mFragmentBinding.setAdapter(this.adapter);
    }

    private void createViewModel() {
        this.ratingViewModel = (StoreRatingViewModel) am.a(getActivity()).a(StoreRatingViewModel.class);
        this.ratingViewModel.getRefreshPageLiveData().observe(getViewLifecycleOwner(), new z() {
            public final void onChanged(Object obj) {
                RatingsReviewFragment.this.lambda$createViewModel$1$RatingsReviewFragment((Boolean) obj);
            }
        });
    }

    public /* synthetic */ void lambda$createViewModel$1$RatingsReviewFragment(Boolean bool) {
        if (bool.booleanValue()) {
            this.ratingViewModel.fetchReviews(getRatingModel(getArguments()), true);
        }
    }

    /* access modifiers changed from: protected */
    public BaseViewModel getViewModel() {
        return this.ratingViewModel;
    }

    private List<IRatingReviewModel> getInitialData(Bundle bundle) {
        CJRRatingReview ratingModel;
        ArrayList arrayList = new ArrayList();
        if (!(bundle == null || (ratingModel = getRatingModel(bundle)) == null)) {
            arrayList.add(ratingModel);
        }
        return arrayList;
    }

    private CJRRatingReview getRatingModel(Bundle bundle) {
        if (bundle != null) {
            return (CJRRatingReview) bundle.getSerializable(ARG_STORE_RATING);
        }
        return null;
    }

    private void setupListData() {
        this.ratingViewModel.fetchReviews(getRatingModel(getArguments()), false);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        onCLPChildFragmentChange(z);
    }

    /* access modifiers changed from: protected */
    public void handleRedirection(RedirectorModel redirectorModel) {
        if (redirectorModel.getRequest() == 1001 && getFragmentManager() != null) {
            WriteAReviewBottomSheet writeAReviewBottomSheet = new WriteAReviewBottomSheet();
            writeAReviewBottomSheet.setArguments(getReviewSheetArguments(redirectorModel.getDataMap()));
            writeAReviewBottomSheet.show(getFragmentManager(), "WRITE_REVIEW_TAG");
        } else if (redirectorModel.getRequest() != 1003 || getFragmentManager() == null) {
            super.handleRedirection(redirectorModel);
        } else if (!TextUtils.isEmpty(CLPArtifact.getInstance().getCommunicationListener().getSSOToken(getContext()))) {
            showReportSheet(redirectorModel);
        } else {
            CLPArtifact.getInstance().getCommunicationListener().openLoginScreen(getContext());
        }
    }

    private void showReportSheet(RedirectorModel redirectorModel) {
        ReportReviewBottomSheet reportReviewBottomSheet = new ReportReviewBottomSheet();
        reportReviewBottomSheet.setArguments(getReportSheetArgument(redirectorModel.getDataMap()));
        reportReviewBottomSheet.show(getFragmentManager(), "REPORT_REVIEW_TAG");
    }

    private Bundle getReviewSheetArguments(Map<String, Object> map) {
        Bundle bundle = new Bundle();
        if (map != null && map.containsKey(BaseViewModel.KEY_RATING_MODEL)) {
            bundle.putSerializable(BaseViewModel.KEY_RATING_MODEL, (Serializable) map.get(BaseViewModel.KEY_RATING_MODEL));
        }
        return bundle;
    }

    private Bundle getReportSheetArgument(Map<String, Object> map) {
        Bundle bundle = new Bundle();
        if (map != null && map.containsKey(BaseViewModel.KEY_REVIEW_MODEL)) {
            bundle.putSerializable(BaseViewModel.KEY_REVIEW_MODEL, (Serializable) map.get(BaseViewModel.KEY_REVIEW_MODEL));
        }
        return bundle;
    }
}
