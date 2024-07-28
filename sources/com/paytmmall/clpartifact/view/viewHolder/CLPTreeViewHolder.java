package com.paytmmall.clpartifact.view.viewHolder;

import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.view.adapter.CLPTreeWidgetAdapter;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.List;
import java.util.Map;

public class CLPTreeViewHolder extends ClickableRVChildViewHolder {
    private CLPTreeWidgetAdapter clpTreeWidgetAdapter;
    private CustomAction customAction;
    private ImageView imageViewArrow;
    private ViewDataBinding mViewDataBinding;
    private RecyclerView treeExpandRV = ((RecyclerView) this.mViewDataBinding.getRoot().findViewById(R.id.tree_expande));

    public CLPTreeViewHolder(ViewDataBinding viewDataBinding, IGAHandlerListener iGAHandlerListener, Map<String, Object> map, CustomAction customAction2) {
        super(viewDataBinding, iGAHandlerListener, customAction2);
        this.mViewDataBinding = viewDataBinding;
        this.imageViewArrow = (ImageView) viewDataBinding.getRoot().findViewById(R.id.imageViewArrow);
        this.customAction = customAction2;
        setGAData(map);
        RecyclerView recyclerView = this.treeExpandRV;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new GridLayoutManager(this.mViewDataBinding.getRoot().getContext(), 3, 1, false));
        }
    }

    public void bind(Item item) {
        handleGAImpression(item, getAdapterPosition());
        enableItemClick();
        this.mViewDataBinding.setVariable(BR.item, item);
        this.mViewDataBinding.setVariable(BR.position, Integer.valueOf(getAdapterPosition()));
        this.mViewDataBinding.setVariable(BR.label, getLabel(item));
        this.mViewDataBinding.executePendingBindings();
        RecyclerView recyclerView = this.treeExpandRV;
        if (recyclerView != null) {
            recyclerView.setVisibility(isTreeExpanded(item) ? 0 : 8);
        }
        ImageView imageView = this.imageViewArrow;
        if (imageView != null) {
            imageView.setImageDrawable(this.itemView.getResources().getDrawable(isTreeExpanded(item) ? R.drawable.ic_up_arrow_24 : R.drawable.clp_ic_arrow_down));
        }
        if (this.treeExpandRV != null) {
            setAdapter(item.getItems(), this.treeExpandRV, R.layout.expand_tree);
        }
    }

    private boolean isTreeExpanded(Item item) {
        return item != null && item.isExpanded();
    }

    private String getLabel(Item item) {
        if (item == null || item.getLayout() == null) {
            return "";
        }
        return item.getLayout().getmLabel();
    }

    public void ExpandTreeList(Item item) {
        if (item != null) {
            CLPArtifact.getInstance().getCommunicationListener().sendCustomGTMEvents(this.mViewDataBinding.getRoot().getContext(), CLPConstants.CHANNEL_NAME, "with promo name = " + item.getTitle() + "<GAkey>-L1 creative name = ", null + " cart_widget", (String) null, CLPConstants.GA_CHANNEL_NAME, "homescreen");
            item.setExpanded(item.isExpanded() ^ true);
        }
        RecyclerView recyclerView = this.treeExpandRV;
        if (recyclerView != null) {
            recyclerView.setVisibility(isTreeExpanded(item) ? 0 : 8);
        }
        ImageView imageView = this.imageViewArrow;
        if (imageView != null) {
            imageView.setImageDrawable(this.itemView.getResources().getDrawable(isTreeExpanded(item) ? R.drawable.ic_up_arrow_24 : R.drawable.clp_ic_arrow_down));
        }
    }

    private CLPTreeWidgetAdapter setWidgetAdapter(List<Item> list, int i2) {
        CLPTreeWidgetAdapter cLPTreeWidgetAdapter = new CLPTreeWidgetAdapter(list, i2, getIgaHandlerListener(), getGAData(), this.customAction);
        this.clpTreeWidgetAdapter = cLPTreeWidgetAdapter;
        return cLPTreeWidgetAdapter;
    }

    private void setAdapter(List<Item> list, RecyclerView recyclerView, int i2) {
        CLPTreeWidgetAdapter cLPTreeWidgetAdapter = this.clpTreeWidgetAdapter;
        if (cLPTreeWidgetAdapter == null) {
            cLPTreeWidgetAdapter = setWidgetAdapter(list, i2);
        }
        this.clpTreeWidgetAdapter = cLPTreeWidgetAdapter;
        recyclerView.setAdapter(this.clpTreeWidgetAdapter);
    }
}
