package com.paytmmall.clpartifact.view.viewHolder;

import android.text.TextUtils;
import android.view.View;
import com.paytmmall.clpartifact.databinding.ClpVoucherItemBinding;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.view.actions.ILoadMoreListener;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;

public class CLPVoucherRVViewHolder extends ClickableRVChildViewHolder {
    private boolean isCollapsed;
    private ILoadMoreListener loadMoreListener;
    private ClpVoucherItemBinding mBinder;

    public CLPVoucherRVViewHolder(ClpVoucherItemBinding clpVoucherItemBinding, CustomAction customAction) {
        super(clpVoucherItemBinding, (IGAHandlerListener) null, customAction);
        this.mBinder = clpVoucherItemBinding;
    }

    public void bind(CJRGridProduct cJRGridProduct, boolean z) {
        this.isCollapsed = z;
        this.mBinder.setProduct(cJRGridProduct);
        this.mBinder.setHolder(this);
        this.mBinder.executePendingBindings();
    }

    public String getCashback(CJRGridProduct cJRGridProduct) {
        try {
            return cJRGridProduct.getPromoData().get(0).getOffer_v1().getmText();
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
            return "";
        }
    }

    public boolean hasCashback(CJRGridProduct cJRGridProduct) {
        return !TextUtils.isEmpty(getCashback(cJRGridProduct));
    }

    public int getCashbackVisibility(CJRGridProduct cJRGridProduct) {
        return (cJRGridProduct == null || cJRGridProduct.getPromoData() == null || cJRGridProduct.getPromoData().isEmpty() || TextUtils.isEmpty(cJRGridProduct.getPromoData().get(0).getCashBack())) ? 4 : 0;
    }

    public boolean isCollapsed() {
        return this.isCollapsed;
    }

    public void viewMore(View view) {
        ILoadMoreListener iLoadMoreListener = this.loadMoreListener;
        if (iLoadMoreListener != null) {
            iLoadMoreListener.onLoadMore();
        }
    }

    public void setAdapter(ILoadMoreListener iLoadMoreListener) {
        this.loadMoreListener = iLoadMoreListener;
    }
}
