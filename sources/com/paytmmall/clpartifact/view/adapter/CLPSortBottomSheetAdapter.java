package com.paytmmall.clpartifact.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.databinding.ItemSortfilterDetailBinding;
import com.paytmmall.clpartifact.listeners.IGridResponseUpdateListener;
import com.paytmmall.clpartifact.modal.grid.CJRSortingKeys;
import com.paytmmall.clpartifact.view.viewHolder.CLPSortBottomSheetVH;
import java.util.ArrayList;

public class CLPSortBottomSheetAdapter extends RecyclerView.a<CLPSortBottomSheetVH> {
    private IGridResponseUpdateListener mGridResponseUpdateListener;
    private ArrayList<CJRSortingKeys> mSortingKeys;

    public CLPSortBottomSheetAdapter(ArrayList<CJRSortingKeys> arrayList, IGridResponseUpdateListener iGridResponseUpdateListener) {
        this.mSortingKeys = arrayList;
        this.mGridResponseUpdateListener = iGridResponseUpdateListener;
    }

    public CLPSortBottomSheetVH onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new CLPSortBottomSheetVH(this.mGridResponseUpdateListener, (ItemSortfilterDetailBinding) f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.item_sortfilter_detail, viewGroup, false));
    }

    public void onBindViewHolder(CLPSortBottomSheetVH cLPSortBottomSheetVH, int i2) {
        cLPSortBottomSheetVH.bind(this.mSortingKeys.get(i2));
    }

    public int getItemCount() {
        ArrayList<CJRSortingKeys> arrayList = this.mSortingKeys;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }
}
