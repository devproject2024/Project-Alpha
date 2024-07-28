package com.paytmmall.clpartifact.view.viewHolder;

import android.os.Handler;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.h;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.listeners.GridRVOnTouchListener;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.network.RequestType;
import com.paytmmall.clpartifact.network.Resource;
import com.paytmmall.clpartifact.network.Status;
import com.paytmmall.clpartifact.utils.InfiniteScrollListener;
import com.paytmmall.clpartifact.view.actions.ILoadMoreListener;
import com.paytmmall.clpartifact.view.adapter.CLPVoucherAdapter;
import com.paytmmall.clpartifact.view.viewmodel.VoucherVHViewModel;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.ArrayList;
import java.util.List;

public class CLPDealsVH extends CLPItemVHWithoutRV {
    private CustomAction customAction;
    private InfiniteScrollListener mScrollListener = new InfiniteScrollListener() {
        public void onLoadMore() {
            CLPDealsVH.this.viewModel.loadVoucher(RequestType.LOAD_MORE);
        }

        public boolean isRequesting() {
            return CLPDealsVH.this.viewModel.isRequesting();
        }

        public boolean hasMore() {
            return CLPDealsVH.this.viewModel.hasMoreData();
        }
    };
    private ViewDataBinding mViewDataBinding;
    private GridRVOnTouchListener onTouchListener = new GridRVOnTouchListener(getAdapterPosition());
    /* access modifiers changed from: private */
    public VoucherVHViewModel viewModel;
    /* access modifiers changed from: private */
    public CLPVoucherAdapter voucherAdapter;

    public CLPDealsVH(ViewDataBinding viewDataBinding, IGAHandlerListener iGAHandlerListener, CustomAction customAction2) {
        super(viewDataBinding, iGAHandlerListener, customAction2);
        this.customAction = customAction2;
        this.mViewDataBinding = viewDataBinding;
        this.viewModel = new VoucherVHViewModel(viewDataBinding.getRoot().getContext());
        this.voucherAdapter = new CLPVoucherAdapter(this.viewModel.getVouchers(), customAction2);
        this.voucherAdapter.setOnLoadMoreListener(new ILoadMoreListener() {
            public final void onLoadMore() {
                CLPDealsVH.this.lambda$new$0$CLPDealsVH();
            }
        });
        this.viewModel.getIsCollapsed().addOnPropertyChangedCallback(new h.a() {
            public void onPropertyChanged(h hVar, int i2) {
                boolean z = ((ObservableBoolean) hVar).get();
                if (CLPDealsVH.this.voucherAdapter != null) {
                    CLPDealsVH.this.voucherAdapter.updateState(Boolean.valueOf(z));
                }
            }
        });
    }

    public /* synthetic */ void lambda$new$0$CLPDealsVH() {
        if (!this.viewModel.isRequesting() && this.viewModel.hasMoreData()) {
            this.viewModel.loadVoucher(RequestType.LOAD_MORE);
        } else if (!this.viewModel.hasMoreData()) {
            this.viewModel.setCollapsed(false);
        }
    }

    /* access modifiers changed from: protected */
    public void doBinding(View view) {
        super.doBinding(view);
        observeLiveData();
        this.mViewDataBinding.setVariable(BR.view, view);
        this.mViewDataBinding.setVariable(BR.clickHandler, this);
        this.mViewDataBinding.setVariable(BR.viewModel, this.viewModel);
        this.mViewDataBinding.executePendingBindings();
        if (this.viewModel.setUrl(view.getmSeeAllSeoUrl())) {
            Resource<ArrayList<CJRGridProduct>> previousResponseList = getPreviousResponseList(view.getItems());
            this.voucherAdapter.updateVoucherList(previousResponseList);
            this.voucherAdapter.updateState(Boolean.valueOf(previousResponseList.getData().size() > 10));
        }
    }

    private ArrayList<CJRGridProduct> getVouchersList(List<Item> list) {
        ArrayList<CJRGridProduct> arrayList = new ArrayList<>();
        if (list != null) {
            for (Item next : list) {
                CJRGridProduct cJRGridProduct = new CJRGridProduct();
                cJRGridProduct.setName(next.getName());
                cJRGridProduct.setDiscountedPrice(next.getOfferPrice());
                cJRGridProduct.setUrl(next.getSeourl());
                cJRGridProduct.setUrlType(next.getUrlType());
                cJRGridProduct.setBrand(next.getmBrand());
                cJRGridProduct.setAncestorID("0");
                cJRGridProduct.setMerchantId(getMerchantId(next.getMerchandID()));
                arrayList.add(cJRGridProduct);
            }
        }
        return arrayList;
    }

    private int getMerchantId(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    private Resource<ArrayList<CJRGridProduct>> getPreviousResponseList(List<Item> list) {
        return new Resource.Builder().body(getVouchersList(list)).error((Throwable) null).requestType(RequestType.FRESH).status(Status.SUCCESS).build();
    }

    public RecyclerView.a<?> getAdapter() {
        return this.voucherAdapter;
    }

    public RecyclerView.k getOnTouchListener() {
        return this.onTouchListener;
    }

    public RecyclerView.l getOnScrollListener() {
        return this.mScrollListener;
    }

    public static void bindRecyclerViewAdapter(RecyclerView recyclerView, RecyclerView.a<?> aVar, RecyclerView.l lVar, RecyclerView.k kVar) {
        if (aVar != null) {
            recyclerView.setAdapter(aVar);
        }
        if (kVar != null) {
            recyclerView.addOnItemTouchListener(kVar);
        }
    }

    private void observeLiveData() {
        this.viewModel.getVoucherLiveData().observe((FragmentActivity) this.mViewDataBinding.getRoot().getContext(), new z() {
            public final void onChanged(Object obj) {
                CLPDealsVH.this.lambda$observeLiveData$1$CLPDealsVH((Resource) obj);
            }
        });
    }

    /* renamed from: com.paytmmall.clpartifact.view.viewHolder.CLPDealsVH$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
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
            throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.view.viewHolder.CLPDealsVH.AnonymousClass3.<clinit>():void");
        }
    }

    public /* synthetic */ void lambda$observeLiveData$1$CLPDealsVH(Resource resource) {
        if (resource != null) {
            int i2 = AnonymousClass3.$SwitchMap$com$paytmmall$clpartifact$network$Status[resource.getStatus().ordinal()];
            if (i2 == 1) {
                onProgress(resource.getRequestType());
            } else if (i2 == 2) {
                onSuccess(resource);
            }
        }
    }

    private void onSuccess(Resource<ArrayList<CJRGridProduct>> resource) {
        this.voucherAdapter.updateVoucherList(resource);
    }

    private void onProgress(RequestType requestType) {
        if (requestType == RequestType.LOAD_MORE) {
            this.voucherAdapter.addLoader();
        }
    }

    public void scrollToTop(RecyclerView recyclerView) {
        CustomAction customAction2 = this.customAction;
        if (!(customAction2 == null || customAction2.getMallSdkVHListener() == null)) {
            this.customAction.getMallSdkVHListener().passAdapterPosFromVH(getAdapterPosition());
        }
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                CLPDealsVH.this.lambda$scrollToTop$2$CLPDealsVH();
            }
        }, 0);
    }

    public /* synthetic */ void lambda$scrollToTop$2$CLPDealsVH() {
        this.viewModel.setCollapsed(true);
    }
}
