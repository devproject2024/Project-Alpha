package com.paytmmall.clpartifact.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.databinding.ClpFlashSaleTimeSlotItemBinding;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.paytmmall.clpartifact.view.viewHolder.FlashSaleTimeSlotViewHolder;
import java.util.ArrayList;
import java.util.List;

public class FlashSaleTimeSlotRVAdapter extends RecyclerView.a<FlashSaleTimeSlotViewHolder> {
    private ArrayList<Item> mItems;
    private OnItemSelectedListener mListener;
    private int mSelected;

    public interface OnItemSelectedListener {
        void onItemSelected(View view, int i2, boolean z);
    }

    public FlashSaleTimeSlotRVAdapter(OnItemSelectedListener onItemSelectedListener) {
        this.mListener = onItemSelectedListener;
    }

    public FlashSaleTimeSlotViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new FlashSaleTimeSlotViewHolder((ClpFlashSaleTimeSlotItemBinding) f.a(LayoutInflater.from(viewGroup.getContext()), R.layout.clp_flash_sale_time_slot_item, viewGroup, false), this.mListener);
    }

    public void onBindViewHolder(FlashSaleTimeSlotViewHolder flashSaleTimeSlotViewHolder, int i2) {
        boolean z = false;
        flashSaleTimeSlotViewHolder.bind(this.mItems.get(i2), i2 == this.mSelected);
        if (i2 == this.mItems.size() - 1) {
            z = true;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) flashSaleTimeSlotViewHolder.itemView.getLayoutParams();
        layoutParams.rightMargin = (int) flashSaleTimeSlotViewHolder.itemView.getResources().getDimension(z ? R.dimen.dimen_16dp : R.dimen.dimen_0dp);
        flashSaleTimeSlotViewHolder.itemView.setLayoutParams(layoutParams);
    }

    public int getItemCount() {
        ArrayList<Item> arrayList = this.mItems;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public void updateAdapter(List<Item> list, int i2) {
        this.mItems = new ArrayList<>(list);
        selectTimeSlot(i2);
    }

    public void selectTimeSlot(int i2) {
        this.mSelected = i2;
        ArrayList<Item> arrayList = this.mItems;
        if (!(arrayList == null || arrayList.size() <= i2 || this.mItems.get(i2) == null)) {
            GAUtil.setFlashSaleSlotInfo(this.mItems.get(i2).getName());
        }
        notifyDataSetChanged();
    }
}
