package com.paytmmall.clpartifact.view;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.a;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.databinding.OptimizeLytRootRvBinding;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.view.adapter.CLPItemRVAdapter;
import com.paytmmall.clpartifact.view.decoration.ItemMarginDecoration;
import com.paytmmall.clpartifact.view.viewHolder.ClickableRVChildViewHolder;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;

public class HomeBanner3xnVHWithRV extends ClickableRVChildViewHolder {
    private CustomAction customAction;
    private OptimizeLytRootRvBinding viewDataBinding;

    public HomeBanner3xnVHWithRV(OptimizeLytRootRvBinding optimizeLytRootRvBinding, IGAHandlerListener iGAHandlerListener, CustomAction customAction2) {
        super(optimizeLytRootRvBinding, iGAHandlerListener, customAction2);
        this.viewDataBinding = optimizeLytRootRvBinding;
        RecyclerView recyclerView = (RecyclerView) optimizeLytRootRvBinding.getRoot().findViewById(R.id.rvThinBanner);
        recyclerView.addItemDecoration(new ItemMarginDecoration(3, a.a(16)));
        recyclerView.setHasFixedSize(true);
        this.customAction = customAction2;
    }

    public void doBinding(View view) {
        super.doBinding(view);
        if (this.viewDataBinding != null) {
            view.setType(ViewHolderFactory.TYPE_BANNER_3XN_HOME);
            this.viewDataBinding.setView(view);
            this.viewDataBinding.setAdapter(getAdapter(view));
            OptimizeLytRootRvBinding optimizeLytRootRvBinding = this.viewDataBinding;
            optimizeLytRootRvBinding.setLayoutManager(new GridLayoutManager(optimizeLytRootRvBinding.getRoot().getContext(), 3, 1, false));
            this.viewDataBinding.executePendingBindings();
        }
    }

    private CLPItemRVAdapter getAdapter(View view) {
        return new CLPItemRVAdapter(view, view.getItems(), getIgaHandlerListener(), view.getId(), this.customAction);
    }
}
