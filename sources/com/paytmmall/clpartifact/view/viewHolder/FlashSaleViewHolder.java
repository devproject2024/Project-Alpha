package com.paytmmall.clpartifact.view.viewHolder;

import android.view.View;
import androidx.fragment.app.j;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.paytmmall.clpartifact.common.RedirectorModel;
import com.paytmmall.clpartifact.databinding.ClpFlashSaleLayoutBinding;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.view.actions.IuserActions;
import com.paytmmall.clpartifact.view.adapter.FlashSaleTimeSlotRVAdapter;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.HashMap;

public class FlashSaleViewHolder extends ClickableRVChildViewHolder {
    private CustomAction customAction;
    private ClpFlashSaleLayoutBinding mBinder;
    private j mFragmentManager;
    private int mSelectedTab;
    private FlashSaleTimeSlotRVAdapter mTimeSlotRvAdapter = new FlashSaleTimeSlotRVAdapter(new FlashSaleTimeSlotRVAdapter.OnItemSelectedListener() {
        public final void onItemSelected(View view, int i2, boolean z) {
            FlashSaleViewHolder.this.selectTimeSlot(view, i2, z);
        }
    });
    private com.paytmmall.clpartifact.modal.clpCommon.View mView;

    public FlashSaleViewHolder(ClpFlashSaleLayoutBinding clpFlashSaleLayoutBinding, j jVar, IGAHandlerListener iGAHandlerListener, CustomAction customAction2) {
        super(clpFlashSaleLayoutBinding, iGAHandlerListener, customAction2);
        this.mBinder = clpFlashSaleLayoutBinding;
        this.customAction = customAction2;
        this.mFragmentManager = jVar;
        this.mBinder.timeSlotRv.setLayoutManager(new LinearLayoutManager(this.itemView.getContext(), 0, false));
        this.mBinder.timeSlotRv.setAdapter(this.mTimeSlotRvAdapter);
    }

    /* access modifiers changed from: protected */
    public void doBinding(com.paytmmall.clpartifact.modal.clpCommon.View view) {
        super.doBinding(view);
        this.mView = view;
        if (view != null) {
            this.mTimeSlotRvAdapter.updateAdapter(view.getItems(), this.mSelectedTab);
            bindInfiniteGrid();
        }
    }

    private void refreshCLPFragment(View view, final int i2, final boolean z) {
        CustomAction customAction2 = this.customAction;
        if (customAction2 != null && customAction2.getMallSdkVHListener() != null) {
            this.customAction.getMallSdkVHListener().setReDirectorValue(new RedirectorModel(IuserActions.ON_FLASHSALE_CLICK, new HashMap<String, Object>() {
                {
                    put("infiniteGridData", FlashSaleViewHolder.this.getFlashInfiniteData(i2));
                    put(CLPConstants.SHOW_GRID_PRODUCT_PRICE, Boolean.valueOf(z));
                }
            }));
        }
    }

    /* access modifiers changed from: private */
    public com.paytmmall.clpartifact.modal.clpCommon.View getFlashInfiniteData(int i2) {
        if (i2 == -1) {
            i2 = 0;
        }
        return this.mView.getItems().get(i2).getChildItems().get(0).getViews().get(0);
    }

    private void bindInfiniteGrid() {
        getViewForInfiniteGrid();
    }

    /* access modifiers changed from: private */
    public void selectTimeSlot(View view, int i2, boolean z) {
        if (this.mSelectedTab != i2) {
            this.mSelectedTab = i2 != -1 ? i2 : 0;
            FlashSaleTimeSlotRVAdapter flashSaleTimeSlotRVAdapter = this.mTimeSlotRvAdapter;
            if (flashSaleTimeSlotRVAdapter != null) {
                flashSaleTimeSlotRVAdapter.selectTimeSlot(this.mSelectedTab);
            }
            refreshCLPFragment(view, i2, z);
        }
    }

    private com.paytmmall.clpartifact.modal.clpCommon.View getViewForInfiniteGrid() {
        try {
            return this.mView.getItems().get(this.mSelectedTab).getChildItems().get(0).getViews().get(0);
        } catch (IndexOutOfBoundsException | NullPointerException unused) {
            return null;
        }
    }
}
