package com.paytmmall.clpartifact.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.databinding.FragmentVoucherBinding;
import com.paytmmall.clpartifact.listeners.GridRVOnTouchListener;
import com.paytmmall.clpartifact.listeners.OnChildFragmentRVScrollListener;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.network.RequestType;
import com.paytmmall.clpartifact.network.Resource;
import com.paytmmall.clpartifact.network.Status;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.InfiniteScrollListener;
import com.paytmmall.clpartifact.view.adapter.CLPVoucherAdapter;
import com.paytmmall.clpartifact.view.viewmodel.CustomViewModelFactory;
import com.paytmmall.clpartifact.view.viewmodel.VoucherViewModel;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.ArrayList;
import net.one97.paytm.i.h;

public class VoucherFragment extends h {
    private CustomAction customAction;
    private CLPVoucherAdapter mAdapter;
    private FragmentVoucherBinding mBinder;
    private InfiniteScrollListener mScrollListener = new InfiniteScrollListener() {
        public void onLoadMore() {
            VoucherFragment.this.mViewModel.loadVoucher(RequestType.LOAD_MORE);
        }

        public boolean isRequesting() {
            return VoucherFragment.this.mViewModel.isRequesting();
        }

        public boolean hasMore() {
            return VoucherFragment.this.mViewModel.hasMoreData();
        }
    };
    /* access modifiers changed from: private */
    public VoucherViewModel mViewModel;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mBinder = (FragmentVoucherBinding) f.a(layoutInflater, R.layout.fragment_voucher, viewGroup, false);
        return this.mBinder.getRoot();
    }

    public void setCustomAction(CustomAction customAction2) {
        this.customAction = customAction2;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        String str = "";
        if (getArguments() != null) {
            str = getArguments().getString(CLPConstants.GRID_URL, str);
        }
        this.mViewModel = (VoucherViewModel) am.a((Fragment) this, (al.b) new CustomViewModelFactory(getActivity().getApplication(), getArguments())).a(str, VoucherViewModel.class);
        this.mViewModel.setBundleData(getArguments());
        observeLiveData();
        initViews();
        onCLPChildFragmentChange(getUserVisibleHint());
    }

    private void initViews() {
        this.mBinder.progressBar.setVisibility(this.mViewModel.isInitialLoad() ? 0 : 8);
        this.mBinder.voucherRv.addOnScrollListener(this.mScrollListener);
        this.mBinder.voucherRv.addOnItemTouchListener(new GridRVOnTouchListener(this.mViewModel.getParentAdapterPosition()));
        this.mAdapter = new CLPVoucherAdapter(this.mViewModel.getVouchers(), (CustomAction) null);
        this.mBinder.voucherRv.setAdapter(this.mAdapter);
        this.mBinder.getRoot().findViewById(R.id.view_store).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                VoucherFragment.this.lambda$initViews$0$VoucherFragment(view);
            }
        });
    }

    public /* synthetic */ void lambda$initViews$0$VoucherFragment(View view) {
        CustomAction customAction2 = this.customAction;
        if (customAction2 != null && customAction2.getMallSdkVHListener() != null) {
            this.customAction.getMallSdkVHListener().openAllStoresTab();
        }
    }

    /* renamed from: com.paytmmall.clpartifact.view.fragment.VoucherFragment$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$paytmmall$clpartifact$network$Status = new int[Status.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.paytmmall.clpartifact.network.Status[] r0 = com.paytmmall.clpartifact.network.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$paytmmall$clpartifact$network$Status = r0
                int[] r0 = $SwitchMap$com$paytmmall$clpartifact$network$Status     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.paytmmall.clpartifact.network.Status r1 = com.paytmmall.clpartifact.network.Status.PROGRESS     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$paytmmall$clpartifact$network$Status     // Catch:{ NoSuchFieldError -> 0x001f }
                com.paytmmall.clpartifact.network.Status r1 = com.paytmmall.clpartifact.network.Status.SUCCESS     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$paytmmall$clpartifact$network$Status     // Catch:{ NoSuchFieldError -> 0x002a }
                com.paytmmall.clpartifact.network.Status r1 = com.paytmmall.clpartifact.network.Status.FAIL     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.view.fragment.VoucherFragment.AnonymousClass2.<clinit>():void");
        }
    }

    private void observeLiveData() {
        this.mViewModel.getVoucherLiveData().observe(this, new z() {
            public final void onChanged(Object obj) {
                VoucherFragment.this.lambda$observeLiveData$1$VoucherFragment((Resource) obj);
            }
        });
    }

    public /* synthetic */ void lambda$observeLiveData$1$VoucherFragment(Resource resource) {
        int i2 = AnonymousClass2.$SwitchMap$com$paytmmall$clpartifact$network$Status[resource.getStatus().ordinal()];
        if (i2 == 1) {
            onProgress(resource.getRequestType());
        } else if (i2 == 2) {
            onSuccess(resource);
        } else if (i2 == 3) {
            this.mBinder.progressBar.setVisibility(8);
            this.mAdapter.removeLoader();
        }
    }

    private void onSuccess(Resource<ArrayList<CJRGridProduct>> resource) {
        int i2 = 8;
        this.mBinder.progressBar.setVisibility(8);
        this.mAdapter.removeLoader();
        this.mAdapter.updateVoucherList(resource);
        this.mBinder.noVoucherLayout.setVisibility(this.mViewModel.getVouchers().isEmpty() ? 0 : 8);
        LinearLayout linearLayout = this.mBinder.buyVoucherContainer;
        if (!this.mViewModel.getVouchers().isEmpty()) {
            i2 = 0;
        }
        linearLayout.setVisibility(i2);
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        onCLPChildFragmentChange(z);
    }

    private void onCLPChildFragmentChange(boolean z) {
        if (z && getView() != null && (getParentFragment() instanceof OnChildFragmentRVScrollListener)) {
            ((OnChildFragmentRVScrollListener) getParentFragment()).onChildFragmentChange(true, false);
        }
    }

    private void onProgress(RequestType requestType) {
        if (requestType == RequestType.LOAD_MORE) {
            this.mAdapter.addLoader();
        } else {
            this.mBinder.progressBar.setVisibility(0);
        }
    }
}
