package com.paytmmall.clpartifact.view.viewHolder;

import android.graphics.Color;
import androidx.core.content.b;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.ViewUtils;
import com.paytmmall.clpartifact.customViews.CirclePageIndicator;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;

public class HomeH1BannerVHWithVP extends CLPItemVHWithVP {
    /* access modifiers changed from: protected */
    public boolean isInfiniteCarouselEnabled() {
        return false;
    }

    public HomeH1BannerVHWithVP(ViewDataBinding viewDataBinding, IGAHandlerListener iGAHandlerListener, CustomAction customAction) {
        super(viewDataBinding, iGAHandlerListener, customAction);
    }

    /* access modifiers changed from: protected */
    public void setPagerMargin(ViewPager viewPager) {
        viewPager.setPageMargin(ViewUtils.convertDpToPixel(16.0f, viewPager.getContext()));
    }

    /* access modifiers changed from: protected */
    public void setPagerIndicatorCosmetics(CirclePageIndicator circlePageIndicator) {
        circlePageIndicator.setStrokeWidth(1.0f);
        try {
            circlePageIndicator.setStrokeColor(Color.parseColor("#ffffff"));
            circlePageIndicator.setFillColor(b.c(circlePageIndicator.getContext(), R.color.blue));
            circlePageIndicator.setRadius((float) ViewUtils.convertDpToPixel(2.0f, circlePageIndicator.getContext()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void doBinding(View view) {
        super.doBinding(view);
        try {
            handleGAImpression((Item) this.mItems.get(0), 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
