package com.paytmmall.clpartifact.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.databinding.HsVariantBottomSheetListItemBinding;
import com.paytmmall.clpartifact.listeners.HSVariantBottomSheetRVAdapterListener;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.view.viewHolder.HSVariantBottomSheetRVAdapterViewHolder;
import java.util.ArrayList;

public class HSVariantBottomSheetRVAdapter extends RecyclerView.a<HSVariantBottomSheetRVAdapterViewHolder> {
    private HSVariantBottomSheetRVAdapterListener mListener;

    public void setListener(HSVariantBottomSheetRVAdapterListener hSVariantBottomSheetRVAdapterListener) {
        this.mListener = hSVariantBottomSheetRVAdapterListener;
    }

    public HSVariantBottomSheetRVAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new HSVariantBottomSheetRVAdapterViewHolder((HsVariantBottomSheetListItemBinding) f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.hs_variant_bottom_sheet_list_item, viewGroup, false), this.mListener);
    }

    public void onBindViewHolder(HSVariantBottomSheetRVAdapterViewHolder hSVariantBottomSheetRVAdapterViewHolder, int i2) {
        hSVariantBottomSheetRVAdapterViewHolder.bind();
    }

    public int getItemCount() {
        return this.mListener.getProducts().size();
    }

    public void updateAdapter(ArrayList<CJRGridProduct> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = this.mListener.getProducts().size();
            this.mListener.getProducts().addAll(arrayList);
            notifyItemRangeInserted(size, arrayList.size());
        }
    }
}
