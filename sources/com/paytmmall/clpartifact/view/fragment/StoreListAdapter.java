package com.paytmmall.clpartifact.view.fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.databinding.FragmentItemBinding;
import com.paytmmall.clpartifact.modal.stores.CJRStoreList;
import com.paytmmall.clpartifact.view.viewHolder.StoreListViewHolder;
import java.util.List;

public class StoreListAdapter extends RecyclerView.a<StoreListViewHolder> {
    private String mStoreName;
    private final List<CJRStoreList> mValues;

    public StoreListAdapter(List<CJRStoreList> list, String str) {
        this.mValues = list;
        this.mStoreName = str;
    }

    public StoreListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new StoreListViewHolder((FragmentItemBinding) f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.fragment_item, viewGroup, false));
    }

    public void onBindViewHolder(StoreListViewHolder storeListViewHolder, int i2) {
        storeListViewHolder.bind(this.mValues.get(i2), this.mStoreName);
    }

    public int getItemCount() {
        List<CJRStoreList> list = this.mValues;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        return this.mValues.size();
    }
}
