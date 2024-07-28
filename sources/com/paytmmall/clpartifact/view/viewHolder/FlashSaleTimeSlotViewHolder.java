package com.paytmmall.clpartifact.view.viewHolder;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.FlashSaleView;
import com.paytmmall.clpartifact.common.TimeUtils;
import com.paytmmall.clpartifact.databinding.ClpFlashSaleTimeSlotItemBinding;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.view.adapter.FlashSaleTimeSlotRVAdapter;

public class FlashSaleTimeSlotViewHolder extends RecyclerView.v {
    public ClpFlashSaleTimeSlotItemBinding mBinder;
    private Item mItem;
    private FlashSaleTimeSlotRVAdapter.OnItemSelectedListener mListener;

    public FlashSaleTimeSlotViewHolder(ClpFlashSaleTimeSlotItemBinding clpFlashSaleTimeSlotItemBinding, FlashSaleTimeSlotRVAdapter.OnItemSelectedListener onItemSelectedListener) {
        super(clpFlashSaleTimeSlotItemBinding.getRoot());
        this.mBinder = clpFlashSaleTimeSlotItemBinding;
        this.mListener = onItemSelectedListener;
        this.mBinder.time.setTimerStateChangedListener(new FlashSaleView.OnTimerStateChangedListener() {
            public void onEnded() {
                FlashSaleTimeSlotViewHolder.this.mBinder.title.setText(FlashSaleTimeSlotViewHolder.this.itemView.getResources().getString(R.string.sale_ended));
                FlashSaleTimeSlotViewHolder.this.setTime();
            }

            public void onUpdateRequired() {
                FlashSaleTimeSlotViewHolder.this.setTime();
            }
        });
    }

    public void bind(Item item, boolean z) {
        this.mItem = item;
        this.mBinder.setItem(item);
        this.mBinder.setHolder(this);
        this.mBinder.timeSlotContainer.setSelected(z);
        this.mBinder.flashSaleCircle.setVisibility(isFlashSaleStarted(item) ? 0 : 8);
        this.mBinder.title.setText(getTitle(item));
        this.mBinder.title.setTypeface(z ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
        setTime();
        this.mBinder.fragmentContainer.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FlashSaleTimeSlotViewHolder.this.lambda$bind$0$FlashSaleTimeSlotViewHolder(view);
            }
        });
        this.mBinder.executePendingBindings();
    }

    /* access modifiers changed from: private */
    public void setTime() {
        Item item = this.mItem;
        if (item != null) {
            boolean isFlashSaleStarted = isFlashSaleStarted(item);
            if (isFlashSaleStarted) {
                this.mBinder.time.setRemainingTime(TimeUtils.getTimeDiff(this.mItem.getEndTime()));
            } else {
                this.mBinder.time.setStaticText(isFutureSale() ? TimeUtils.getTime(this.mItem.getStartTime()) : "00:00:00");
            }
            this.mBinder.time.setTextColor(Color.parseColor(isFlashSaleStarted ? "#ff585d" : "#1d252d"));
            this.mBinder.time.setTypeface(isFlashSaleStarted ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
        }
    }

    private String getTitle(Item item) {
        long millisec = TimeUtils.getMillisec(item.getStartTime());
        long millisec2 = TimeUtils.getMillisec(item.getEndTime());
        long currentMillisec = TimeUtils.currentMillisec();
        long nextDayMillisec = TimeUtils.getNextDayMillisec();
        long dayAfter = TimeUtils.dayAfter(2);
        int i2 = (millisec2 > currentMillisec ? 1 : (millisec2 == currentMillisec ? 0 : -1));
        if (i2 < 0) {
            return this.itemView.getResources().getString(R.string.sale_ended);
        }
        int i3 = (millisec > currentMillisec ? 1 : (millisec == currentMillisec ? 0 : -1));
        if (i3 > 0 && millisec <= nextDayMillisec) {
            return this.itemView.getResources().getString(R.string.comming_soon);
        }
        if (i3 < 0 && i2 >= 0) {
            return this.itemView.getResources().getString(R.string.sale_ends_in);
        }
        if (millisec <= nextDayMillisec || millisec > dayAfter) {
            return TimeUtils.getDay(item.getStartTime());
        }
        return this.itemView.getResources().getString(R.string.tomorrow);
    }

    /* renamed from: onItemClick */
    public void lambda$bind$0$FlashSaleTimeSlotViewHolder(View view) {
        FlashSaleTimeSlotRVAdapter.OnItemSelectedListener onItemSelectedListener = this.mListener;
        if (onItemSelectedListener != null) {
            onItemSelectedListener.onItemSelected(view, getAdapterPosition(), !isFutureSale());
        }
    }

    private boolean isFlashSaleStarted(Item item) {
        long millisec = TimeUtils.getMillisec(item.getStartTime());
        long millisec2 = TimeUtils.getMillisec(item.getEndTime());
        long currentMillisec = TimeUtils.currentMillisec();
        return millisec < currentMillisec && millisec2 > currentMillisec;
    }

    private boolean isFutureSale() {
        Item item = this.mItem;
        if (item != null && TimeUtils.getMillisec(item.getStartTime()) > TimeUtils.currentMillisec()) {
            return true;
        }
        return false;
    }
}
