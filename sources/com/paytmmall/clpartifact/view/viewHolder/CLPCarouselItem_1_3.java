package com.paytmmall.clpartifact.view.viewHolder;

import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.paytm.utility.a;
import com.paytmmall.clpartifact.BR;
import com.paytmmall.clpartifact.databinding.ItemCarousel13Binding;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.ImageUtility;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;

public class CLPCarouselItem_1_3 extends CLPItemRVViewHolder {
    private final ItemCarousel13Binding mViewDataBinding;
    private int maxItemCount;

    public void setMaxItemCount(int i2) {
        this.maxItemCount = i2;
    }

    public CLPCarouselItem_1_3(ItemCarousel13Binding itemCarousel13Binding, IGAHandlerListener iGAHandlerListener, CustomAction customAction) {
        super(itemCarousel13Binding, iGAHandlerListener, customAction);
        this.mViewDataBinding = itemCarousel13Binding;
    }

    public void bindItem(Item item, View view) {
        setGAData(view.getGaData());
        handleGAImpression(item, getAdapterPosition());
        enableItemClick();
        this.mViewDataBinding.setVariable(BR.item, item);
        this.mViewDataBinding.setVariable(BR.position, Integer.valueOf(getAdapterPosition()));
        this.mViewDataBinding.executePendingBindings();
        setDrawable(item);
    }

    public void setDrawable(Item item) {
        setImageWidthBasedOnDisplaySize(this.mViewDataBinding.carousel13Image);
        ConstraintLayout constraintLayout = this.mViewDataBinding.carousel13Container;
        if (getAdapterPosition() == 0) {
            constraintLayout.setLayoutParams(setContainerSpacing(15, 3));
        } else if (getAdapterPosition() == this.maxItemCount - 1) {
            constraintLayout.setLayoutParams(setContainerSpacing(3, 15));
        } else {
            constraintLayout.setLayoutParams(setContainerSpacing(3, 3));
        }
        if (item != null) {
            ImageUtility.getInstance().loadImageWithPlaceHolder(this.mViewDataBinding.carousel13Image, item.getImageUrl(), a.a(15), false, getContext());
        }
    }

    public ConstraintLayout.LayoutParams setContainerSpacing(int i2, int i3) {
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(a.a(i2), a.a(0), a.a(i3), a.a(0));
        return layoutParams;
    }

    public void setImageWidthBasedOnDisplaySize(ImageView imageView) {
        Display defaultDisplay = ((WindowManager) imageView.getContext().getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int i2 = point.x;
        imageView.getLayoutParams().width = i2 - a.a(35);
    }
}
