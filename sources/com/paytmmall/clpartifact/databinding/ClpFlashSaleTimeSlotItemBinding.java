package com.paytmmall.clpartifact.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import androidx.databinding.f;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.FlashSaleView;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.viewHolder.FlashSaleTimeSlotViewHolder;

public abstract class ClpFlashSaleTimeSlotItemBinding extends ViewDataBinding {
    public final FrameLayout flashSaleCircle;
    public final FrameLayout fragmentContainer;
    protected FlashSaleTimeSlotViewHolder mHolder;
    protected Item mItem;
    public final FlashSaleView time;
    public final LinearLayout timeSlotContainer;
    public final TextView title;

    public abstract void setHolder(FlashSaleTimeSlotViewHolder flashSaleTimeSlotViewHolder);

    public abstract void setItem(Item item);

    protected ClpFlashSaleTimeSlotItemBinding(e eVar, View view, int i2, FrameLayout frameLayout, FrameLayout frameLayout2, FlashSaleView flashSaleView, LinearLayout linearLayout, TextView textView) {
        super(eVar, view, i2);
        this.flashSaleCircle = frameLayout;
        this.fragmentContainer = frameLayout2;
        this.time = flashSaleView;
        this.timeSlotContainer = linearLayout;
        this.title = textView;
    }

    public Item getItem() {
        return this.mItem;
    }

    public FlashSaleTimeSlotViewHolder getHolder() {
        return this.mHolder;
    }

    public static ClpFlashSaleTimeSlotItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, f.a());
    }

    public static ClpFlashSaleTimeSlotItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, e eVar) {
        return (ClpFlashSaleTimeSlotItemBinding) f.a(layoutInflater, R.layout.clp_flash_sale_time_slot_item, viewGroup, z, eVar);
    }

    public static ClpFlashSaleTimeSlotItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, f.a());
    }

    public static ClpFlashSaleTimeSlotItemBinding inflate(LayoutInflater layoutInflater, e eVar) {
        return (ClpFlashSaleTimeSlotItemBinding) f.a(layoutInflater, R.layout.clp_flash_sale_time_slot_item, (ViewGroup) null, false, eVar);
    }

    public static ClpFlashSaleTimeSlotItemBinding bind(View view) {
        return bind(view, f.a());
    }

    public static ClpFlashSaleTimeSlotItemBinding bind(View view, e eVar) {
        return (ClpFlashSaleTimeSlotItemBinding) bind(eVar, view, R.layout.clp_flash_sale_time_slot_item);
    }
}
