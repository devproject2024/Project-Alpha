package com.paytmmall.clpartifact.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.listeners.VSVariantBottomSheetRVAdapterListener;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import com.paytmmall.clpartifact.view.viewHolder.VSVariantBottomSheetRVAdapterViewHolder;
import java.util.ArrayList;

public class VSVariantBottomSheetRVAdapter extends RecyclerView.a<VSVariantBottomSheetRVAdapterViewHolder> {
    private VSVariantBottomSheetRVAdapterListener mListener;

    public void setListener(VSVariantBottomSheetRVAdapterListener vSVariantBottomSheetRVAdapterListener) {
        this.mListener = vSVariantBottomSheetRVAdapterListener;
    }

    public VSVariantBottomSheetRVAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new VSVariantBottomSheetRVAdapterViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vs_variant_bottom_sheet_list_item, viewGroup, false), this.mListener);
    }

    public void onBindViewHolder(VSVariantBottomSheetRVAdapterViewHolder vSVariantBottomSheetRVAdapterViewHolder, int i2) {
        vSVariantBottomSheetRVAdapterViewHolder.bind();
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
