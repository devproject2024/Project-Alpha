package com.paytmmall.clpartifact.view.viewHolder;

import android.view.View;
import androidx.core.content.b;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.databinding.ItemSmartIconButton2xnRootBinding;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.CLPWidgetUtils;
import com.paytmmall.clpartifact.utils.Utils;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.view.adapter.CartItemRVAdapter;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.List;

public class CLPItemInCartViewHolder extends CLPItemVHWithRV {
    private CustomAction customAction;
    private ItemSmartIconButton2xnRootBinding mDataBinding;
    private List<Item> mItems;

    public CLPItemInCartViewHolder(ItemSmartIconButton2xnRootBinding itemSmartIconButton2xnRootBinding, IGAHandlerListener iGAHandlerListener, CustomAction customAction2) {
        super(itemSmartIconButton2xnRootBinding, iGAHandlerListener, customAction2);
        this.mDataBinding = itemSmartIconButton2xnRootBinding;
        this.customAction = customAction2;
        this.mDataBinding.rvThinBanner.setBackground(b.a(getContext(), R.drawable.clp_rounded_corner_pink));
    }

    private void hideRootView() {
        View root = this.mDataBinding.getRoot();
        root.setVisibility(8);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) root.getLayoutParams();
        layoutParams.width = 0;
        layoutParams.height = 0;
        root.setLayoutParams(layoutParams);
    }

    private void showRootView() {
        View root = this.mDataBinding.getRoot();
        root.setVisibility(0);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) root.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = (int) Utils.dp2px(200.0f);
        root.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public void doBinding(com.paytmmall.clpartifact.modal.clpCommon.View view) {
        super.doBinding(view);
        view.setItems(getItems(view));
        if (view.getItems() == null || view.getItems().size() == 0) {
            hideRootView();
        } else {
            showRootView();
        }
        view.setGaData(getGAData());
        this.mDataBinding.setView(view);
        this.mItems = view.getItems();
        this.mDataBinding.setHandler(this);
        this.mDataBinding.setAdapter(new CartItemRVAdapter(view, this.mItems, getIgaHandlerListener(), view.getId(), this.customAction));
        ItemSmartIconButton2xnRootBinding itemSmartIconButton2xnRootBinding = this.mDataBinding;
        itemSmartIconButton2xnRootBinding.setLayoutManager(new LinearLayoutManager(itemSmartIconButton2xnRootBinding.getRoot().getContext(), 0, false));
        this.mDataBinding.executePendingBindings();
    }

    /* access modifiers changed from: protected */
    public List<Item> getItems(com.paytmmall.clpartifact.modal.clpCommon.View view) {
        if (view == null) {
            return null;
        }
        String type = view.getType();
        char c2 = 65535;
        int hashCode = type.hashCode();
        if (hashCode != -1770280845) {
            if (hashCode != 565638350) {
                if (hashCode == 680782075 && type.equals(ViewHolderFactory.TYPE_RECENTLY_VIEWED)) {
                    c2 = 2;
                }
            } else if (type.equals(ViewHolderFactory.TYPE_ITEM_IN_CART)) {
                c2 = 0;
            }
        } else if (type.equals(ViewHolderFactory.TYPE_ITEM_IN_WISHLIST)) {
            c2 = 1;
        }
        if (c2 == 0) {
            view.setUrlType("cart");
            return CLPWidgetUtils.getCartItems();
        } else if (c2 == 1) {
            view.setUrlType(CLPConstants.WISHLIST);
            return CLPWidgetUtils.getWishListItems();
        } else if (c2 != 2) {
            return null;
        } else {
            return CLPWidgetUtils.getRecentlyViewedItems();
        }
    }
}
