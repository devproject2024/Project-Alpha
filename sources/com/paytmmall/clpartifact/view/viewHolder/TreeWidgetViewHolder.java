package com.paytmmall.clpartifact.view.viewHolder;

import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.GaHandler;
import com.paytmmall.clpartifact.utils.ValidateViewResponse;
import com.paytmmall.clpartifact.view.adapter.CLPTreeWidgetAdapter;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.List;

public class TreeWidgetViewHolder extends ClickableRVChildViewHolder {
    private CLPTreeWidgetAdapter clpTreeWidgetAdapter;
    private CustomAction customAction;
    private ViewDataBinding mChildBinding;

    public TreeWidgetViewHolder(ViewDataBinding viewDataBinding, IGAHandlerListener iGAHandlerListener, CustomAction customAction2) {
        super(viewDataBinding, iGAHandlerListener, customAction2);
        this.mChildBinding = viewDataBinding;
        this.customAction = customAction2;
    }

    /* access modifiers changed from: protected */
    public void doBinding(View view) {
        super.doBinding(view);
        if (ValidateViewResponse.validateData(view, this.mChildBinding)) {
            enableItemClick();
            this.mChildBinding.setVariable(BR.view, view);
            this.mChildBinding.executePendingBindings();
            RecyclerView recyclerView = (RecyclerView) this.mChildBinding.getRoot().findViewById(R.id.tree_recyclerview);
            recyclerView.setLayoutManager(new LinearLayoutManager(this.mChildBinding.getRoot().getContext()));
            setAdapter(view.getItems(), recyclerView, R.layout.item_tree_one);
            if (view.getLayout() != null && view.getLayout().getState() != -1) {
                int state = view.getLayout().getState();
                if (state == 0) {
                    this.mChildBinding.setVariable(BR.IS_COLLAPSED, Boolean.TRUE);
                } else if (state == 1) {
                    this.mChildBinding.setVariable(BR.IS_COLLAPSED, Boolean.FALSE);
                }
            }
        }
    }

    public void handleTreeClick(View view) {
        GaHandler.getInstance().fireClickEvent(view, getAdapterPosition());
        RecyclerView recyclerView = (RecyclerView) this.mChildBinding.getRoot().findViewById(R.id.tree_recyclerview);
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.getVisibility() == 0) {
            this.mChildBinding.setVariable(BR.IS_COLLAPSED, Boolean.TRUE);
            ((ImageView) this.mChildBinding.getRoot().findViewById(R.id.arrow_fixed)).setImageDrawable(this.mChildBinding.getRoot().getContext().getResources().getDrawable(R.drawable.clp_ic_arrow_down));
            recyclerView.setVisibility(8);
        } else if (recyclerView.getVisibility() == 8) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this.mChildBinding.getRoot().getContext()));
            ((ImageView) this.mChildBinding.getRoot().findViewById(R.id.arrow_fixed)).setImageDrawable(this.mChildBinding.getRoot().getContext().getResources().getDrawable(R.drawable.ic_up_arrow_24));
            setAdapter(view.getItems(), recyclerView, R.layout.item_tree_one);
            this.mChildBinding.setVariable(BR.IS_COLLAPSED, Boolean.FALSE);
        }
    }

    private CLPTreeWidgetAdapter setWidgetAdapter(List<Item> list, int i2) {
        CLPTreeWidgetAdapter cLPTreeWidgetAdapter = new CLPTreeWidgetAdapter(list, i2, getIgaHandlerListener(), getGAData(), this.customAction);
        this.clpTreeWidgetAdapter = cLPTreeWidgetAdapter;
        return cLPTreeWidgetAdapter;
    }

    private void setAdapter(List<Item> list, RecyclerView recyclerView, int i2) {
        recyclerView.setVisibility(0);
        CLPTreeWidgetAdapter cLPTreeWidgetAdapter = this.clpTreeWidgetAdapter;
        if (cLPTreeWidgetAdapter == null) {
            cLPTreeWidgetAdapter = setWidgetAdapter(list, i2);
        }
        this.clpTreeWidgetAdapter = cLPTreeWidgetAdapter;
        recyclerView.setAdapter(this.clpTreeWidgetAdapter);
    }
}
