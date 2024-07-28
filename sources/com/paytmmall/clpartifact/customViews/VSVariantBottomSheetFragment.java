package com.paytmmall.clpartifact.customViews;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.am;
import androidx.localbroadcastmanager.a.a;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.NetworkUtils;
import com.paytmmall.clpartifact.common.ViewUtils;
import com.paytmmall.clpartifact.databinding.FragmentVsVariantBottomSheetBinding;
import com.paytmmall.clpartifact.listeners.VSVariantBottomSheetRVAdapterListener;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.navigator.VariantBottomSheetNavigator;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.GaHandler;
import com.paytmmall.clpartifact.view.adapter.VSVariantBottomSheetRVAdapter;
import com.paytmmall.clpartifact.view.viewmodel.VariantBottomSheetViewModel;
import java.util.ArrayList;
import net.one97.paytm.i.f;

public class VSVariantBottomSheetFragment extends f implements VSVariantBottomSheetRVAdapterListener, VariantBottomSheetNavigator {
    /* access modifiers changed from: private */
    public FragmentVsVariantBottomSheetBinding mBinder;
    /* access modifiers changed from: private */
    public VSVariantBottomSheetRVAdapter mRVAdapter;
    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent != null && !TextUtils.isEmpty(intent.getAction())) {
                String action = intent.getAction();
                char c2 = 65535;
                int hashCode = action.hashCode();
                if (hashCode != -1572062803) {
                    if (hashCode != 1377863616) {
                        if (hashCode == 1409575749 && action.equals(CLPConstants.Action.ONFAILED_CART_UPDATE)) {
                            c2 = 1;
                        }
                    } else if (action.equals(CLPConstants.Action.ONSTART_CART_UPDATE)) {
                        c2 = 0;
                    }
                } else if (action.equals(CLPConstants.Action.ONSUCCESS_CART_UPDATE)) {
                    c2 = 2;
                }
                if (c2 == 0) {
                    VSVariantBottomSheetFragment.this.mBinder.progressBar.setVisibility(0);
                } else if (c2 == 1) {
                    VSVariantBottomSheetFragment.this.mBinder.progressBar.setVisibility(8);
                } else if (c2 == 2) {
                    VSVariantBottomSheetFragment.this.mBinder.progressBar.setVisibility(8);
                    VSVariantBottomSheetFragment.this.mRVAdapter.notifyDataSetChanged();
                }
            }
        }
    };
    private VariantBottomSheetViewModel mViewModel;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mBinder = (FragmentVsVariantBottomSheetBinding) androidx.databinding.f.a(layoutInflater, R.layout.fragment_vs_variant_bottom_sheet, viewGroup, false);
        return this.mBinder.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.mViewModel = (VariantBottomSheetViewModel) am.a((Fragment) this).a(VariantBottomSheetViewModel.class);
        this.mViewModel.setNavigator((VariantBottomSheetNavigator) this);
        this.mViewModel.setData(getArguments());
        setClicks();
        initRecyclerView();
        registerReceiver();
        loadSheet();
    }

    private void loadSheet() {
        if (NetworkUtils.isNetworkAvailable(getContext())) {
            this.mViewModel.loadSheet();
        } else {
            dismissAllowingStateLoss();
        }
    }

    private void setClicks() {
        this.mBinder.getRoot().findViewById(R.id.crossIcon).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                VSVariantBottomSheetFragment.this.lambda$setClicks$0$VSVariantBottomSheetFragment(view);
            }
        });
        this.mBinder.getRoot().findViewById(R.id.doneBtn).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                VSVariantBottomSheetFragment.this.lambda$setClicks$1$VSVariantBottomSheetFragment(view);
            }
        });
    }

    public /* synthetic */ void lambda$setClicks$0$VSVariantBottomSheetFragment(View view) {
        dismissAllowingStateLoss();
    }

    public /* synthetic */ void lambda$setClicks$1$VSVariantBottomSheetFragment(View view) {
        dismissAllowingStateLoss();
    }

    public void onDestroyView() {
        a.a(getContext()).a(this.mReceiver);
        super.onDestroyView();
    }

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(CLPConstants.Action.ONSUCCESS_CART_UPDATE);
        intentFilter.addAction(CLPConstants.Action.ONSTART_CART_UPDATE);
        intentFilter.addAction(CLPConstants.Action.ONFAILED_CART_UPDATE);
        a.a(getContext()).a(this.mReceiver, intentFilter);
    }

    private void initRecyclerView() {
        this.mViewModel.getVariantItems().clear();
        this.mRVAdapter = new VSVariantBottomSheetRVAdapter();
        this.mRVAdapter.setListener(this);
        this.mBinder.variantRV.setAdapter(this.mRVAdapter);
    }

    public void onAddToCartClick(int i2) {
        if (this.mViewModel != null) {
            GaHandler.getInstance().fireAddToCartEvent(this.mViewModel.getProduct());
        }
        this.mViewModel.onAddToCart(i2);
    }

    public void onRemoveFromCartClick(int i2) {
        this.mViewModel.onRemoveFromCart(i2);
    }

    public void onProgress() {
        this.mBinder.progressBar.setVisibility(0);
    }

    public void onSuccess(ArrayList<CJRGridProduct> arrayList) {
        this.mBinder.progressBar.setVisibility(8);
        ViewUtils.loadImage(this.mViewModel.getProductImage(), this.mBinder.varianrIV, R.drawable.picasso_default_placeholder);
        this.mBinder.variantNameTV.setText(this.mViewModel.getProductName());
        this.mBinder.doneBtn.setVisibility(0);
        this.mRVAdapter.updateAdapter(arrayList);
    }

    public void onFailed(Throwable th) {
        this.mBinder.progressBar.setVisibility(8);
    }

    public ArrayList<CJRGridProduct> getProducts() {
        return this.mViewModel.getVariantItems();
    }

    public boolean isItemInStock() {
        return this.mViewModel.isItemInStock();
    }
}
