package com.paytmmall.clpartifact.view.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.databinding.ClpFreeDealsItemBinding;
import com.paytmmall.clpartifact.databinding.DealsItemClpBinding;
import com.paytmmall.clpartifact.databinding.ItemRowInfiniteGrid1xnBinding;
import com.paytmmall.clpartifact.listeners.InfiniteGridRVAdapterListener;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import com.paytmmall.clpartifact.view.viewHolder.CLPInfiniteGridFoodViewHolder;
import com.paytmmall.clpartifact.view.viewHolder.CLPInfiniteGridHolder;
import com.paytmmall.clpartifact.view.viewHolder.CLPInfiniteGrid_1XNHolder;
import com.paytmmall.clpartifact.view.viewHolder.DealsItemViewHolder;
import com.paytmmall.clpartifact.view.viewHolder.FreeDealsItemViewHolder;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.ArrayList;
import java.util.Map;

public class CLPInfiniteRowWidgetAdapter extends RecyclerView.a<RecyclerView.v> {
    private static final String TAG = CLPItemRVAdapter.class.getSimpleName();
    private CustomAction customAction;
    private int gridType;
    private boolean isOffline;
    private Map<String, Object> mGAData;
    private ArrayList<CJRGridProduct> mItemList;
    private InfiniteGridRVAdapterListener mListener;
    String rupeeeSymbol = FilterPriceSliderFragment.RUPEE_SYMBOL;

    public CLPInfiniteRowWidgetAdapter(ArrayList<CJRGridProduct> arrayList, Map<String, Object> map, boolean z, CustomAction customAction2) {
        this.mItemList = arrayList;
        this.mGAData = map;
        this.isOffline = z;
        this.customAction = customAction2;
    }

    public void setAdapterListener(InfiniteGridRVAdapterListener infiniteGridRVAdapterListener) {
        this.mListener = infiniteGridRVAdapterListener;
    }

    public int getItemViewType(int i2) {
        return ViewHolderFactory.getGridViewType(this.mListener.getViewType());
    }

    public RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 1) {
            return new CLPInfiniteGrid_1XNHolder((ItemRowInfiniteGrid1xnBinding) f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.item_row_infinite_grid_1xn, viewGroup, false), this.mListener, this.customAction);
        }
        if (i2 == 3) {
            return new CLPInfiniteGridFoodViewHolder(f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.clp_food_item, viewGroup, false), this.mListener, this.customAction);
        }
        if (i2 == 4) {
            return new DealsItemViewHolder((DealsItemClpBinding) f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.deals_item_clp, viewGroup, false), this.mListener, this.customAction);
        }
        if (i2 != 5) {
            return new CLPInfiniteGridHolder(f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.item_row_infinite_grid, viewGroup, false), this.mListener, this.customAction);
        }
        return new FreeDealsItemViewHolder((ClpFreeDealsItemBinding) f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.clp_free_deals_item, viewGroup, false), this.mListener, this.customAction);
    }

    public void onBindViewHolder(RecyclerView.v vVar, int i2) {
        CJRGridProduct cJRGridProduct = this.mItemList.get(i2);
        cJRGridProduct.setGaData(this.mGAData);
        if (vVar instanceof CLPInfiniteGridHolder) {
            ((CLPInfiniteGridHolder) vVar).bind(cJRGridProduct, i2, this.isOffline);
        } else if (vVar instanceof CLPInfiniteGridFoodViewHolder) {
            ((CLPInfiniteGridFoodViewHolder) vVar).bind(cJRGridProduct);
        }
    }

    public int getItemCount() {
        ArrayList<CJRGridProduct> arrayList = this.mItemList;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    private String appendDiscountPercent(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str + " % ";
    }

    private String appendRupeeSymbol(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return this.rupeeeSymbol + str;
    }

    public void onResume() {
        notifyDataSetChanged();
    }
}
