package com.paytmmall.clpartifact.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.view.adapter.InfiniteGridViewPagerAdapter;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import net.one97.paytm.i.h;

public class SearchFragment extends h {
    public static final String ARG_CLP_CONTEXT_PARAMS = "context_params";
    public static final String ARG_SEARCH_DATA = "search_data";
    public static final String ARG_STORE_DATA = "store_data";
    private InfiniteGridViewPagerAdapter adapter;
    private CustomAction customAction;
    private boolean isAttachedPending;
    private Item searchData;
    private View storeData;

    public static SearchFragment getInstance(InfiniteGridViewPagerAdapter infiniteGridViewPagerAdapter, View view, Item item) {
        SearchFragment searchFragment = new SearchFragment();
        searchFragment.setAdapter(infiniteGridViewPagerAdapter);
        searchFragment.setStoreData(view);
        searchFragment.setSearchData(item);
        return searchFragment;
    }

    public void setCustomAction(CustomAction customAction2) {
        this.customAction = customAction2;
    }

    private void setSearchData(Item item) {
        this.searchData = item;
    }

    private void setStoreData(View view) {
        this.storeData = view;
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    SearchFragment.this.lambda$setUserVisibleHint$0$SearchFragment();
                }
            }, 500);
        }
        handleSwitchClick(z);
    }

    public /* synthetic */ void lambda$setUserVisibleHint$0$SearchFragment() {
        InfiniteGridViewPagerAdapter infiniteGridViewPagerAdapter = this.adapter;
        if (infiniteGridViewPagerAdapter != null) {
            infiniteGridViewPagerAdapter.setViewPager(1);
        }
    }

    private void handleSwitchClick(boolean z) {
        if (!z) {
            return;
        }
        if (getActivity() != null) {
            Intent intent = new Intent(getActivity(), SearchActivity.class);
            intent.putExtra(ARG_STORE_DATA, this.storeData);
            intent.putExtra(ARG_SEARCH_DATA, this.searchData);
            CustomAction customAction2 = this.customAction;
            if (!(customAction2 == null || customAction2.getMallSdkVHListener() == null)) {
                intent.putExtra(ARG_CLP_CONTEXT_PARAMS, this.customAction.getMallSdkVHListener().getContextParams());
            }
            startActivity(intent);
            return;
        }
        this.isAttachedPending = true;
    }

    private void setAdapter(InfiniteGridViewPagerAdapter infiniteGridViewPagerAdapter) {
        this.adapter = infiniteGridViewPagerAdapter;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (this.isAttachedPending) {
            handleSwitchClick(true);
            this.isAttachedPending = false;
        }
    }
}
