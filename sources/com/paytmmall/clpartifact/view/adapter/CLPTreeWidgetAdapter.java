package com.paytmmall.clpartifact.view.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.utils.DataBindingUtils;
import com.paytmmall.clpartifact.view.viewHolder.CLPTreeViewHolder;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.List;
import java.util.Map;

public class CLPTreeWidgetAdapter extends RecyclerView.a<CLPTreeViewHolder> {
    private CustomAction customAction;
    private Map<String, Object> gaData;
    private IGAHandlerListener gaHandler;
    private List<Item> mItem;
    private int mLayout;

    public CLPTreeWidgetAdapter(List<Item> list, int i2, IGAHandlerListener iGAHandlerListener, Map<String, Object> map, CustomAction customAction2) {
        this.mItem = list;
        this.mLayout = i2;
        this.gaHandler = iGAHandlerListener;
        this.gaData = map;
        this.customAction = customAction2;
    }

    public CLPTreeViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new CLPTreeViewHolder(DataBindingUtils.getViewBinding(viewGroup, this.mLayout), this.gaHandler, this.gaData, this.customAction);
    }

    public void onBindViewHolder(CLPTreeViewHolder cLPTreeViewHolder, int i2) {
        cLPTreeViewHolder.bind(this.mItem.get(i2));
    }

    public int getItemCount() {
        List<Item> list = this.mItem;
        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
