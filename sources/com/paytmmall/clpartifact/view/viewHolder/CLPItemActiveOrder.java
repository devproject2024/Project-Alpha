package com.paytmmall.clpartifact.view.viewHolder;

import android.text.TextUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.customViews.CLPRobotoTextView;
import com.paytmmall.clpartifact.databinding.ItemRootRvNewBinding;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.Utils;
import com.paytmmall.clpartifact.view.adapter.CartItemRVAdapter;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.ArrayList;

public class CLPItemActiveOrder extends CLPItemVHWithRV {
    private CustomAction customAction;
    private ItemRootRvNewBinding itemActiveOrderBinding;

    public CLPItemActiveOrder(ItemRootRvNewBinding itemRootRvNewBinding, IGAHandlerListener iGAHandlerListener, CustomAction customAction2) {
        super(itemRootRvNewBinding, iGAHandlerListener, customAction2);
        this.itemActiveOrderBinding = itemRootRvNewBinding;
        this.customAction = customAction2;
    }

    /* access modifiers changed from: protected */
    public void doBinding(View view) {
        super.doBinding(view);
        ArrayList<Item> activeOrderCache = CLPArtifact.getInstance().getCommunicationListener().getActiveOrderCache();
        if (activeOrderCache == null || activeOrderCache.isEmpty()) {
            hideRootView();
        } else {
            showRootView();
        }
        view.setGaData(getGAData());
        this.itemActiveOrderBinding.setHandler(this);
        this.itemActiveOrderBinding.setTitle(Boolean.valueOf(!TextUtils.isEmpty(getActiveOrdersTitle())));
        int i2 = 0;
        this.itemActiveOrderBinding.rvThinBanner.setLayoutManager(new LinearLayoutManager(this.mViewDataBinding.getRoot().getContext(), 0, false));
        this.itemActiveOrderBinding.rvThinBanner.setAdapter(new CartItemRVAdapter(view, activeOrderCache, getIgaHandlerListener(), view.getId(), this.customAction));
        this.itemActiveOrderBinding.executePendingBindings();
        this.itemActiveOrderBinding.viewName.setText(getActiveOrdersTitle());
        CLPRobotoTextView cLPRobotoTextView = this.itemActiveOrderBinding.viewName;
        if (activeOrderCache == null || activeOrderCache.isEmpty()) {
            i2 = 8;
        }
        cLPRobotoTextView.setVisibility(i2);
    }

    private String getActiveOrdersTitle() {
        return this.itemView.getContext().getString(R.string.active_orders);
    }

    private void showRootView() {
        android.view.View root = this.itemActiveOrderBinding.getRoot();
        root.setVisibility(0);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) root.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = (int) Utils.dp2px(120.0f);
        root.setLayoutParams(layoutParams);
    }

    private void hideRootView() {
        android.view.View root = this.itemActiveOrderBinding.getRoot();
        root.setVisibility(8);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) root.getLayoutParams();
        layoutParams.width = 0;
        layoutParams.height = 0;
        root.setLayoutParams(layoutParams);
    }
}
