package com.paytmmall.clpartifact.customViews;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.am;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.common.NetworkUtils;
import com.paytmmall.clpartifact.databinding.FragmentHsVariantBottomSheetBinding;
import com.paytmmall.clpartifact.listeners.HSVariantBottomSheetRVAdapterListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.navigator.VariantBottomSheetNavigator;
import com.paytmmall.clpartifact.utils.GaHandler;
import com.paytmmall.clpartifact.view.adapter.HSVariantBottomSheetRVAdapter;
import com.paytmmall.clpartifact.view.viewmodel.VariantBottomSheetViewModel;
import java.util.ArrayList;
import java.util.Map;
import net.one97.paytm.i.f;

public class HSVariantBottomSheetFragment extends f implements HSVariantBottomSheetRVAdapterListener, VariantBottomSheetNavigator {
    FragmentHsVariantBottomSheetBinding mBinder;
    private HSVariantBottomSheetRVAdapter mRVAdapter;
    private VariantBottomSheetViewModel mViewModel;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mBinder = (FragmentHsVariantBottomSheetBinding) androidx.databinding.f.a(layoutInflater, R.layout.fragment_hs_variant_bottom_sheet, viewGroup, false);
        return this.mBinder.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mViewModel = (VariantBottomSheetViewModel) am.a((Fragment) this).a(VariantBottomSheetViewModel.class);
        this.mViewModel.setNavigator((VariantBottomSheetNavigator) this);
        this.mViewModel.setData(getArguments());
        this.mBinder.getRoot().findViewById(R.id.crossIcon).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                HSVariantBottomSheetFragment.this.lambda$onViewCreated$0$HSVariantBottomSheetFragment(view);
            }
        });
        initRecyclerView();
        loadSheet();
    }

    public /* synthetic */ void lambda$onViewCreated$0$HSVariantBottomSheetFragment(View view) {
        dismissAllowingStateLoss();
    }

    private void loadSheet() {
        if (NetworkUtils.isNetworkAvailable(getContext())) {
            this.mViewModel.loadSheet();
        } else {
            dismissAllowingStateLoss();
        }
    }

    private void initRecyclerView() {
        this.mViewModel.getVariantItems().clear();
        this.mRVAdapter = new HSVariantBottomSheetRVAdapter();
        this.mBinder.variantRV.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.mRVAdapter.setListener(this);
        this.mBinder.variantRV.setAdapter(this.mRVAdapter);
    }

    public void onProgress() {
        this.mBinder.progressBar.setVisibility(0);
    }

    public void onSuccess(ArrayList<CJRGridProduct> arrayList) {
        this.mBinder.progressBar.setVisibility(8);
        this.mBinder.variantNameTV.setText(String.format(getString(R.string.available_variant), new Object[]{this.mViewModel.getVariantLabel()}));
        this.mRVAdapter.updateAdapter(arrayList);
    }

    public void onFailed(Throwable th) {
        this.mBinder.progressBar.setVisibility(8);
    }

    public ArrayList<CJRGridProduct> getProducts() {
        return this.mViewModel.getVariantItems();
    }

    public String getVariantLabel() {
        return this.mViewModel.getVariantLabel();
    }

    public void onProductClick(int i2) {
        Item item = new Item();
        item.setUrl(this.mViewModel.getProductUrl());
        item.setUrlType(this.mViewModel.getUrlType());
        if (this.mViewModel.getProduct() != null) {
            GaHandler.getInstance().fireClickEvent(this.mViewModel.getProduct(), i2, (Map<String, Object>) null);
        }
        if (getActivity() != null) {
            CLPArtifact.getInstance().getCommunicationListener().handleDeepLink(getActivity(), item);
        }
    }
}
