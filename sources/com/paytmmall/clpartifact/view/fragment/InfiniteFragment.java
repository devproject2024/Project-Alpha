package com.paytmmall.clpartifact.view.fragment;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.localbroadcastmanager.a.a;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.android.volley.VolleyError;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.gson.o;
import com.paytm.utility.b.b;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.common.CartUtils;
import com.paytmmall.clpartifact.common.GridItemDecoration;
import com.paytmmall.clpartifact.common.StringUtils;
import com.paytmmall.clpartifact.common.ViewUtils;
import com.paytmmall.clpartifact.customViews.InfiniteGridCustomRecyclerview;
import com.paytmmall.clpartifact.databinding.ItemInfiniteGridContainerBinding;
import com.paytmmall.clpartifact.listeners.GridRVOnTouchListener;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.listeners.IGridResponseUpdateListener;
import com.paytmmall.clpartifact.listeners.IOnReloadComponent;
import com.paytmmall.clpartifact.listeners.InfiniteGridRVAdapterListener;
import com.paytmmall.clpartifact.listeners.OnChildFragmentRVScrollListener;
import com.paytmmall.clpartifact.listeners.RVScrollDispatchListener;
import com.paytmmall.clpartifact.modal.grid.CJRFilterItem;
import com.paytmmall.clpartifact.modal.grid.CJRFrontEndFilter;
import com.paytmmall.clpartifact.modal.grid.CJRGrid;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.modal.grid.CJRSortingKeys;
import com.paytmmall.clpartifact.network.CLPNetworkService;
import com.paytmmall.clpartifact.utils.CLPCacheUtils;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.FilterWidgetUtils;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.paytmmall.clpartifact.utils.GaHandler;
import com.paytmmall.clpartifact.utils.InfiniteScrollListener;
import com.paytmmall.clpartifact.utils.LogUtils;
import com.paytmmall.clpartifact.utils.UrlUtils;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.view.adapter.CLPGridSortingAdapter;
import com.paytmmall.clpartifact.view.adapter.CLPInfiniteRowWidgetAdapter;
import com.paytmmall.clpartifact.view.viewmodel.InfiniteGridViewModel;
import com.paytmmall.clpartifact.widgets.callback.ActivityListener;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.i.h;

public class InfiniteFragment extends h implements IGridResponseUpdateListener, IOnReloadComponent, InfiniteGridRVAdapterListener, RVScrollDispatchListener, ActivityListener {
    private static final String KEY_POSITION = "position";
    public static final String KEY_URL = "url";
    public static final String TAG = InfiniteFragment.class.getSimpleName();
    private static HashMap<String, Object> staticGAData;
    /* access modifiers changed from: private */
    public boolean addToCart;
    /* access modifiers changed from: private */
    public CJRGrid cacheCjrGrid;
    private CustomAction customAction;
    /* access modifiers changed from: private */
    public int dY = 0;
    private String gridViewType;
    private boolean isGAImpressionEnabled;
    ArrayList<CJRGridProduct> list = null;
    private CLPInfiniteRowWidgetAdapter mAdapter;
    /* access modifiers changed from: private */
    public ItemInfiniteGridContainerBinding mFragmentBinding;
    private Map<String, Object> mGAData;
    private IGAHandlerListener mGAHandlerListener;
    private InfiniteScrollListener mInfiniteScrollListener = new InfiniteScrollListener() {
        public void onLoadMore() {
            InfiniteFragment.this.pageCount++;
            InfiniteFragment infiniteFragment = InfiniteFragment.this;
            String unused = infiniteFragment.mUrl = UrlUtils.getUpdatedUrl(infiniteFragment.mUrl, "page_count", String.valueOf(InfiniteFragment.this.pageCount));
            InfiniteFragment.this.hitApi(true);
        }

        public boolean isRequesting() {
            return InfiniteFragment.this.mViewModel.isRequesting();
        }

        public boolean hasMore() {
            return InfiniteFragment.this.hasMoreData();
        }
    };
    /* access modifiers changed from: private */
    public boolean mIsFromNetwork;
    private ArrayList<CJRGridProduct> mItemList;
    private int mPosition;
    private BroadcastReceiver mReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (!TextUtils.isEmpty(intent.getAction())) {
                String action = intent.getAction();
                char c2 = 65535;
                switch (action.hashCode()) {
                    case -1572062803:
                        if (action.equals(CLPConstants.Action.ONSUCCESS_CART_UPDATE)) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -295609167:
                        if (action.equals(CLPConstants.ACTION_UPDATE_CLP)) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 1377863616:
                        if (action.equals(CLPConstants.Action.ONSTART_CART_UPDATE)) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 1409575749:
                        if (action.equals(CLPConstants.Action.ONFAILED_CART_UPDATE)) {
                            c2 = 1;
                            break;
                        }
                        break;
                }
                if (c2 != 0) {
                    if (c2 != 1) {
                        if (c2 != 2) {
                            if (c2 != 3) {
                                return;
                            }
                        } else if (InfiniteFragment.this.getView() != null) {
                            InfiniteFragment.this.mFragmentBinding.mainProgressBar.setVisibility(8);
                            if (!(InfiniteFragment.this.recyclerView == null || InfiniteFragment.this.recyclerView.getAdapter() == null)) {
                                InfiniteFragment.this.recyclerView.getAdapter().notifyDataSetChanged();
                            }
                            if (InfiniteFragment.this.recyclerView != null) {
                                InfiniteFragment.this.recyclerView.setPadding(0, 0, 0, (int) InfiniteFragment.this.getResources().getDimension(CartUtils.isCartEmpty() ? R.dimen.dimen_0dp : R.dimen.dimen_70dp));
                            }
                        }
                        if (InfiniteFragment.this.getView() != null) {
                            InfiniteFragment.this.updateCLP();
                        }
                    } else if (InfiniteFragment.this.getView() != null) {
                        InfiniteFragment.this.mFragmentBinding.mainProgressBar.setVisibility(8);
                    }
                } else if (InfiniteFragment.this.getUserVisibleHint() && InfiniteFragment.this.getView() != null) {
                    InfiniteFragment.this.mFragmentBinding.mainProgressBar.setVisibility(0);
                }
            }
        }
    };
    private final RecyclerView.l mScrollListener = new RecyclerView.l() {
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            super.onScrolled(recyclerView, i2, i3);
            if (InfiniteFragment.this.dY <= 0) {
                if (i3 > 0) {
                    a.a(InfiniteFragment.this.getContext()).a(new Intent(CLPConstants.ACTION_ANIMATE_BOTTOMBAR_OUT));
                }
            } else if (i3 < 0) {
                a.a(InfiniteFragment.this.getContext()).a(new Intent(CLPConstants.ACTION_ANIMATE_BOTTOMBAR_IN));
            }
            int unused = InfiniteFragment.this.dY = i3;
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            int access$900;
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 0 && (access$900 = InfiniteFragment.this.getFirstVisibleIndex(recyclerView)) >= 0 && (InfiniteFragment.this.getParentFragment() instanceof OnChildFragmentRVScrollListener)) {
                ((OnChildFragmentRVScrollListener) InfiniteFragment.this.getParentFragment()).onChildFragmentRVScroll(access$900 == 0);
            }
        }
    };
    /* access modifiers changed from: private */
    public String mUrl;
    /* access modifiers changed from: private */
    public InfiniteGridViewModel mViewModel;
    private BroadcastReceiver mVisibleReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null) {
                String action = intent.getAction();
                char c2 = 65535;
                if (action.hashCode() == 633835331 && action.equals(CLPConstants.Action.SCROLL_INFINITE_GRIDE_TO_TOP)) {
                    c2 = 0;
                }
                if (c2 == 0) {
                    InfiniteFragment.this.mFragmentBinding.gridTabsContainer.smoothScrollToPosition(0);
                }
            }
        }
    };
    private float oldY;
    int pageCount = 1;
    RecyclerView recyclerView;

    public static InfiniteFragment getInstance(String str, int i2, boolean z) {
        InfiniteFragment infiniteFragment = new InfiniteFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        bundle.putInt("position", i2);
        bundle.putBoolean(CLPConstants.SHOW_GRID_PRODUCT_PRICE, z);
        infiniteFragment.setArguments(bundle);
        return infiniteFragment;
    }

    public void setGAData(IGAHandlerListener iGAHandlerListener, Map<String, Object> map) {
        this.mGAHandlerListener = iGAHandlerListener;
        if (map != null) {
            this.mGAData = new HashMap(map);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mFragmentBinding = (ItemInfiniteGridContainerBinding) f.a(layoutInflater, R.layout.item_infinite_grid_container, viewGroup, false);
        this.mViewModel = (InfiniteGridViewModel) am.a((Fragment) this).a(InfiniteGridViewModel.class);
        this.mUrl = getUrl();
        this.mPosition = getPosition();
        loadData();
        this.recyclerView = this.mFragmentBinding.gridTabsContainer;
        hitApi(false);
        this.mFragmentBinding.retryButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (view != null && view.getVisibility() == 0) {
                    InfiniteFragment.this.hitApi(false);
                }
            }
        });
        this.customAction = new CustomAction.Builder().hostActivityListener(this).build();
        return this.mFragmentBinding.getRoot();
    }

    private void loadData() {
        if (!com.paytm.utility.a.m(getContext())) {
            this.mFragmentBinding.progressBar.setVisibility(8);
            this.mFragmentBinding.noNetworkLL.setVisibility(0);
            return;
        }
        this.mFragmentBinding.noNetworkLL.setVisibility(8);
        CLPCacheUtils.getInstance().loadFromCache(this.mUrl, new CLPNetworkService.IResponseListener() {
            public void onSuccess(String str, o oVar) {
                try {
                    CJRGrid unused = InfiniteFragment.this.cacheCjrGrid = (CJRGrid) new com.google.gson.f().a(str, CJRGrid.class);
                    InfiniteFragment infiniteFragment = InfiniteFragment.this;
                    boolean z = true;
                    if (InfiniteFragment.this.cacheCjrGrid == null || InfiniteFragment.this.cacheCjrGrid.getAddToCart() != 1) {
                        z = false;
                    }
                    boolean unused2 = infiniteFragment.addToCart = z;
                    boolean unused3 = InfiniteFragment.this.mIsFromNetwork = false;
                    RecyclerView unused4 = InfiniteFragment.this.setInfiniteGridRecyclerview(InfiniteFragment.this.cacheCjrGrid);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

            public void onError(VolleyError volleyError) {
                LogUtils.printStackTrace(volleyError);
            }
        });
    }

    public void onViewCreated(View view, Bundle bundle) {
        RecyclerView recyclerView2;
        super.onViewCreated(view, bundle);
        if (!CartUtils.isCartEmpty() && (recyclerView2 = this.recyclerView) != null) {
            recyclerView2.setPadding(0, 0, 0, (int) getResources().getDimension(CartUtils.isCartEmpty() ? R.dimen.dimen_0dp : R.dimen.dimen_70dp));
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(CLPConstants.Action.ONSTART_CART_UPDATE);
        intentFilter.addAction(CLPConstants.Action.ONFAILED_CART_UPDATE);
        intentFilter.addAction(CLPConstants.Action.ONSUCCESS_CART_UPDATE);
        intentFilter.addAction(CLPConstants.ACTION_UPDATE_CLP);
        this.mFragmentBinding.gridTabsContainer.addOnScrollListener(this.mScrollListener);
        this.mFragmentBinding.gridTabsContainer.addOnScrollListener(this.mInfiniteScrollListener);
        a.a(getContext()).a(this.mReceiver, intentFilter);
    }

    public void onDestroyView() {
        a.a(getContext()).a(this.mReceiver);
        super.onDestroyView();
    }

    /* access modifiers changed from: private */
    public void hitApi(boolean z) {
        if (!TextUtils.isEmpty(this.mUrl)) {
            if (!com.paytm.utility.a.m(getContext())) {
                this.mFragmentBinding.noNetworkLL.setVisibility(0);
            } else {
                this.mFragmentBinding.noNetworkLL.setVisibility(8);
            }
            FragmentActivity activity = getActivity();
            this.mFragmentBinding.progressBar.setVisibility(0);
            this.mViewModel.setRequesting(true);
            this.mViewModel.fetchGridResponse(activity, this.mUrl).observe(this, new z(z) {
                private final /* synthetic */ boolean f$1;

                {
                    this.f$1 = r2;
                }

                public final void onChanged(Object obj) {
                    InfiniteFragment.this.lambda$hitApi$0$InfiniteFragment(this.f$1, (CJRGrid) obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$hitApi$0$InfiniteFragment(boolean z, CJRGrid cJRGrid) {
        this.mFragmentBinding.progressBar.setVisibility(8);
        boolean z2 = false;
        this.mViewModel.setRequesting(false);
        if (cJRGrid != null && cJRGrid.getAddToCart() == 1) {
            z2 = true;
        }
        this.addToCart = z2;
        if (cJRGrid != null) {
            this.mIsFromNetwork = true;
            if (z) {
                handleLoadMore(cJRGrid);
            } else if (!cJRGrid.equals(this.cacheCjrGrid)) {
                handleSuccessResponse(cJRGrid);
            }
        } else {
            LogUtils.e(TAG, "Failed to load data");
        }
        this.cacheCjrGrid = cJRGrid;
    }

    private void handleSuccessResponse(CJRGrid cJRGrid) {
        ArrayList<CJRSortingKeys> arrayList;
        ArrayList<CJRFilterItem> arrayList2;
        ArrayList<CJRFrontEndFilter> arrayList3;
        if (cJRGrid != null) {
            String str = TAG;
            StringBuilder sb = new StringBuilder("handleSuccessResponse: ");
            sb.append(cJRGrid != null ? Boolean.valueOf(cJRGrid.getHasMore()) : "Unknown");
            LogUtils.d(str, sb.toString());
            ArrayList<CJRFrontEndFilter> arrayList4 = null;
            if (cJRGrid != null) {
                arrayList3 = cJRGrid.getFrontEndFilterList();
                arrayList2 = cJRGrid.getFilterList();
                arrayList2.retainAll(FilterWidgetUtils.VALID_FILTER_ITEMS);
                arrayList = cJRGrid.getSortingKeys();
                this.list = cJRGrid.getGridLayout();
            } else {
                arrayList3 = null;
                arrayList2 = null;
                arrayList = null;
            }
            if (arrayList2 != null) {
                FilterWidgetUtils.appendSortFilter(arrayList2, arrayList);
            }
            FragmentActivity activity = getActivity();
            if (!(arrayList2 == null || activity == null || activity.isFinishing())) {
                if (arrayList3 != null && arrayList3.size() > 0) {
                    arrayList4 = arrayList3;
                }
                FilterWidgetUtils.appendCategory(arrayList3, arrayList2, FilterWidgetUtils.getCategoryDisplayName(activity, arrayList4));
            }
            ArrayList<CJRGridProduct> arrayList5 = this.list;
            if (arrayList5 != null && arrayList5.size() > 0) {
                this.recyclerView = setInfiniteGridRecyclerview(cJRGrid);
                setFilterRecyclerview(cJRGrid);
                setTouchListener(this.recyclerView);
            }
        }
    }

    private boolean isOfflineFlow() {
        return !TextUtils.isEmpty(this.mUrl) && UrlUtils.isOfflineFlow(this.mUrl);
    }

    /* access modifiers changed from: private */
    public int getFirstVisibleIndex(RecyclerView recyclerView2) {
        if (recyclerView2 == null || !(recyclerView2.getLayoutManager() instanceof LinearLayoutManager)) {
            return -1;
        }
        return ((LinearLayoutManager) recyclerView2.getLayoutManager()).findFirstVisibleItemPosition();
    }

    /* access modifiers changed from: private */
    public boolean hasMoreData() {
        CJRGrid cJRGrid = this.cacheCjrGrid;
        return cJRGrid == null || cJRGrid.getHasMore();
    }

    public void onResume() {
        super.onResume();
        CLPInfiniteRowWidgetAdapter cLPInfiniteRowWidgetAdapter = this.mAdapter;
        if (cLPInfiniteRowWidgetAdapter != null) {
            cLPInfiniteRowWidgetAdapter.onResume();
        }
        if (getContext() != null) {
            a.a(getContext()).a(this.mVisibleReceiver, new IntentFilter(CLPConstants.Action.SCROLL_INFINITE_GRIDE_TO_TOP));
        }
    }

    public void onPause() {
        super.onPause();
        if (getContext() != null) {
            a.a(getContext()).a(this.mVisibleReceiver);
        }
    }

    private void handleLoadMore(CJRGrid cJRGrid) {
        if (cJRGrid != null) {
            int size = this.list.size();
            if (cJRGrid.getGridLayout() != null) {
                this.list.addAll(cJRGrid.getGridLayout());
            }
            this.recyclerView.getAdapter().notifyItemRangeChanged(size, cJRGrid.getGridLayout().size());
            prefetchImages(cJRGrid.getGridLayout());
        }
    }

    private void prefetchImages(ArrayList<CJRGridProduct> arrayList) {
        if (arrayList != null) {
            for (int i2 = 0; i2 < arrayList.size() - 10; i2++) {
                if (getActivity() != null) {
                    b.a.C0750a a2 = b.a(getActivity());
                    a2.f43753a = arrayList.get(i2).getImageUrl();
                    b.a.C0750a.a(a2, (ImageView) null, (com.paytm.utility.b.b.b) null, 3);
                }
            }
        }
    }

    private void setFilterRecyclerview(CJRGrid cJRGrid) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            RecyclerView recyclerView2 = this.mFragmentBinding.filterContainer;
            if (cJRGrid.getSortingKeys() != null && cJRGrid.getSortingKeys().size() > 0) {
                recyclerView2.setVisibility(0);
            }
            recyclerView2.setLayoutManager(new LinearLayoutManager(activity, 0, false));
            recyclerView2.setAdapter(new CLPGridSortingAdapter(this, getActivity(), cJRGrid, this.mUrl, getUrl(), this.customAction));
        }
    }

    /* access modifiers changed from: private */
    public RecyclerView setInfiniteGridRecyclerview(CJRGrid cJRGrid) {
        ArrayList<CJRGridProduct> gridLayout = cJRGrid.getGridLayout();
        this.gridViewType = TextUtils.isEmpty(getViewType()) ? CLPConstants.DEFAULT_GRID_VIEW_TYPE : cJRGrid.getViewType();
        setupGAData(cJRGrid);
        InfiniteGridCustomRecyclerview infiniteGridCustomRecyclerview = this.mFragmentBinding.gridTabsContainer;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return infiniteGridCustomRecyclerview;
        }
        infiniteGridCustomRecyclerview.setLayoutManager(new GridLayoutManager((Context) activity, ViewHolderFactory.getGridSpan(getViewType()), 1, false));
        this.mAdapter = new CLPInfiniteRowWidgetAdapter(gridLayout, this.mGAData, isOfflineFlow(), this.customAction);
        this.mAdapter.setAdapterListener(this);
        infiniteGridCustomRecyclerview.setAdapter(this.mAdapter);
        infiniteGridCustomRecyclerview.addItemDecoration(new GridItemDecoration(getContext(), R.drawable.clp_infinite_grid_divider));
        infiniteGridCustomRecyclerview.setNestedScrollingEnabled(true);
        return infiniteGridCustomRecyclerview;
    }

    private void setupGAData(CJRGrid cJRGrid) {
        if (this.mGAData == null) {
            this.mGAData = new HashMap();
        }
        this.mGAData.put(GAUtil.KEY_FILTER_AVAILABLE, (cJRGrid.getFilterList() == null || cJRGrid.getFilterList().isEmpty()) ? "no" : H5AppHandler.CHECK_VALUE);
        this.mGAData.put(GAUtil.KEY_LIST_ID_TYPE, cJRGrid.getmID());
        this.mGAData.put(GAUtil.KEY_TABBED_GRID_EXPERIMENT, cJRGrid.getExperiment());
    }

    private String getUrl() {
        Bundle arguments = getArguments();
        if (arguments == null || !arguments.containsKey("url")) {
            return "";
        }
        return UrlUtils.appendGridQueryParameter(UrlUtils.appendGridQueryParameter(UrlUtils.appendGridQueryParameter(UrlUtils.appendChildSiteId(CLPArtifact.getInstance().getCommunicationListener().getDefaultParams(getActivity(), (String) arguments.get("url"))), AppConstants.TAG_LANG_ID, CLPArtifact.getInstance().getCommunicationListener().getLangId(getActivity())), "page_count", 1), "items_per_page", 16);
    }

    private int getPosition() {
        Bundle arguments = getArguments();
        if (arguments == null || !arguments.containsKey("position")) {
            return -1;
        }
        return arguments.getInt("position");
    }

    private void setTouchListener(RecyclerView recyclerView2) {
        recyclerView2.addOnItemTouchListener(new GridRVOnTouchListener(this.mPosition));
    }

    public void onGridUpdate(String str, CJRGrid cJRGrid) {
        this.mUrl = str;
        handleSuccessResponse(cJRGrid);
    }

    public void onSortingSelected(CJRSortingKeys cJRSortingKeys) {
        String str = cJRSortingKeys.getDefault();
        if (str != null) {
            String[] split = str.split("=");
            if (split.length >= 2) {
                removeExistingSortingParameters();
                this.mUrl = UrlUtils.getUpdatedUrl(this.mUrl, split[0], split[1]);
                this.pageCount = 1;
                this.mUrl = UrlUtils.getUpdatedUrl(this.mUrl, "page_count", String.valueOf(this.pageCount));
                hitApi(false);
            }
        }
    }

    private void removeExistingSortingParameters() {
        Iterator<String> it2 = CLPConstants.PARAMETERS_SORTING.iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            if (this.mUrl.contains(next)) {
                this.mUrl = UrlUtils.getUpdatedUrl(this.mUrl, next, "");
            }
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 != 122 || i3 != -1) {
            super.onActivityResult(i2, i3, intent);
        } else if (intent.getSerializableExtra(CLPConstants.INTENT_KEY_GRID_DATA) != null) {
            CJRGrid cJRGrid = (CJRGrid) intent.getSerializableExtra(CLPConstants.INTENT_KEY_GRID_DATA);
            this.mUrl = !intent.getStringExtra(CLPConstants.INTENT_KEY_GRID_URL).isEmpty() ? intent.getStringExtra(CLPConstants.INTENT_KEY_GRID_URL) : getUrl();
            handleSuccessResponse(cJRGrid);
        }
    }

    private RecyclerView getMainRecyclerView(RecyclerView recyclerView2) {
        try {
            return (RecyclerView) recyclerView2.getParent().getParent().getParent().getParent().getParent();
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void updateCLP() {
        try {
            if (this.recyclerView != null && this.recyclerView.getAdapter() != null) {
                this.mFragmentBinding.gridTabsContainer.getAdapter().notifyDataSetChanged();
            }
        } catch (Exception unused) {
        }
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        onCLPChildFragmentChange(z);
    }

    private void onCLPChildFragmentChange(boolean z) {
        int firstVisibleIndex;
        if (z && getView() != null && (firstVisibleIndex = getFirstVisibleIndex(this.mFragmentBinding.gridTabsContainer)) >= 0 && (getParentFragment() instanceof OnChildFragmentRVScrollListener)) {
            ((OnChildFragmentRVScrollListener) getParentFragment()).onChildFragmentChange(false, firstVisibleIndex == 0);
        }
    }

    public String getViewType() {
        return TextUtils.isEmpty(this.gridViewType) ? CLPConstants.DEFAULT_GRID_VIEW_TYPE : this.gridViewType;
    }

    public void onVariantClick(CJRGridProduct cJRGridProduct) {
        ViewUtils.performVariantClick(getChildFragmentManager(), this.mUrl, getRenderUrl(), StringUtils.isList(getViewType()), cJRGridProduct);
    }

    public boolean showAddToCart() {
        return this.addToCart;
    }

    public boolean shouldShowProductPrice() {
        return getArguments() != null && getArguments().getBoolean(CLPConstants.SHOW_GRID_PRODUCT_PRICE, true);
    }

    public void fireGridProductImpression(CJRGridProduct cJRGridProduct, int i2) {
        IGAHandlerListener iGAHandlerListener = this.mGAHandlerListener;
        if (iGAHandlerListener != null) {
            iGAHandlerListener.fireInfiniteGridProductImpression(cJRGridProduct, i2);
        } else {
            GaHandler.getInstance().fireInfiniteGridProductImpression(cJRGridProduct, i2);
        }
    }

    private String getRenderUrl() {
        CJRGrid cJRGrid = this.cacheCjrGrid;
        return cJRGrid != null ? cJRGrid.getRenderUrl() : "";
    }

    public void onReload() {
        hitApi(false);
    }

    public void onDispatchScroll() {
        if (this.mFragmentBinding.gridTabsContainer != null) {
            this.mFragmentBinding.gridTabsContainer.smoothScrollToPosition(0);
        }
    }

    public boolean isDispatchRequired() {
        if (this.mFragmentBinding.gridTabsContainer != null && (this.mFragmentBinding.gridTabsContainer.getLayoutManager() instanceof LinearLayoutManager)) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.mFragmentBinding.gridTabsContainer.getLayoutManager();
            int findFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            if (findFirstCompletelyVisibleItemPosition == 0) {
                return false;
            }
            if (findFirstCompletelyVisibleItemPosition <= 0 && findLastVisibleItemPosition <= 1) {
                return false;
            }
            return true;
        }
        return false;
    }

    public Activity getHostActivity() {
        return getActivity();
    }
}
