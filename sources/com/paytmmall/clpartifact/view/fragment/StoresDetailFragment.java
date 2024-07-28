package com.paytmmall.clpartifact.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.databinding.FragmentItemListBinding;
import com.paytmmall.clpartifact.listeners.GridRVOnTouchListener;
import com.paytmmall.clpartifact.listeners.OnChildFragmentRVScrollListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.stores.CJRStoreList;
import com.paytmmall.clpartifact.modal.stores.CJRStores;
import com.paytmmall.clpartifact.view.viewmodel.StoreTabViewModel;
import java.util.List;
import net.one97.paytm.i.h;

public class StoresDetailFragment extends h {
    private static final String ARG_ADAPTER_POS = "adapterPosition";
    private static final String ARG_STORE_INFO = "store_info";
    private static final String ARG_STORE_NAME = "store_name";
    private static final String ARG_URL = "url";
    private int mColumnCount = 1;
    private FragmentItemListBinding mFragmentBinding;
    private List<CJRStoreList> mStoreList;
    private StoreTabViewModel viewModel;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    private void fetchStoreResponse() {
        String url = getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.viewModel.fetchStoreResponse(url).observe(this, new z() {
                public final void onChanged(Object obj) {
                    StoresDetailFragment.this.lambda$fetchStoreResponse$0$StoresDetailFragment((CJRStores) obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$fetchStoreResponse$0$StoresDetailFragment(CJRStores cJRStores) {
        if (cJRStores != null) {
            this.mStoreList = (cJRStores.getData() == null || cJRStores.getData().getStores() == null) ? null : cJRStores.getData().getStores();
            List<CJRStoreList> list = this.mStoreList;
            if (list == null || !list.isEmpty()) {
                setRecyclerview();
                return;
            }
        }
        this.mFragmentBinding.storeNotFoundLayout.setVisibility(0);
    }

    private String getUrl() {
        Bundle arguments = getArguments();
        if (arguments == null || !arguments.containsKey("url")) {
            return "";
        }
        return CLPArtifact.getInstance().getCommunicationListener().getDefaultParams(getActivity(), (String) arguments.get("url"));
    }

    public static Fragment getInstance(Item item, int i2, String str) {
        StoresDetailFragment storesDetailFragment = new StoresDetailFragment();
        storesDetailFragment.setArguments(getStoreActivityArguemnts(item, i2, str));
        return storesDetailFragment;
    }

    private static Bundle getStoreActivityArguemnts(Item item, int i2, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("url", item.getSeourl());
        bundle.putInt(ARG_ADAPTER_POS, i2);
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(ARG_STORE_NAME, str);
        }
        return bundle;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        onCLPChildFragmentChange(getUserVisibleHint());
    }

    private void onCLPChildFragmentChange(boolean z) {
        if (z && getView() != null && (getParentFragment() instanceof OnChildFragmentRVScrollListener)) {
            ((OnChildFragmentRVScrollListener) getParentFragment()).onChildFragmentChange(true, false);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mFragmentBinding = (FragmentItemListBinding) f.a(layoutInflater, R.layout.fragment_item_list, viewGroup, false);
        createViewModel();
        fetchStoreResponse();
        return this.mFragmentBinding.getRoot();
    }

    private void setRecyclerview() {
        Context context = this.mFragmentBinding.getRoot().getContext();
        RecyclerView recyclerView = this.mFragmentBinding.storeRecyclerview;
        this.mFragmentBinding.storelayout.setVisibility(0);
        if (this.mColumnCount <= 1) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        }
        recyclerView.setAdapter(new StoreListAdapter(this.mStoreList, getStoreName()));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.addOnItemTouchListener(getTouchListener(getActivity(), getPosition()));
    }

    private RecyclerView.k getTouchListener(FragmentActivity fragmentActivity, int i2) {
        return new GridRVOnTouchListener(i2);
    }

    private int getPosition() {
        Bundle arguments = getArguments();
        if (arguments == null || !arguments.containsKey(ARG_ADAPTER_POS)) {
            return 0;
        }
        return arguments.getInt(ARG_ADAPTER_POS);
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        onCLPChildFragmentChange(z);
    }

    private String getStoreName() {
        Bundle arguments = getArguments();
        return (arguments == null || !arguments.containsKey(ARG_STORE_NAME)) ? "" : arguments.getString(ARG_STORE_NAME);
    }

    private void createViewModel() {
        this.viewModel = (StoreTabViewModel) am.a((Fragment) this).a(StoreTabViewModel.class);
    }
}
