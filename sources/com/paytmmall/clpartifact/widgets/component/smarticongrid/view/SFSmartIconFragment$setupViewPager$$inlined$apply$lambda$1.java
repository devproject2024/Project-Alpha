package com.paytmmall.clpartifact.widgets.component.smarticongrid.view;

import android.content.Context;
import androidx.viewpager.widget.ViewPager;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.widgets.component.smarticongrid.GroupGridLayoutDataModel;
import com.paytmmall.clpartifact.widgets.component.smarticongrid.SmartIconGridConstants;
import com.paytmmall.clpartifact.widgets.component.smarticongrid.view.SFSmartIconFragment;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.g.b.x;

public final class SFSmartIconFragment$setupViewPager$$inlined$apply$lambda$1 implements ViewPager.e {
    final /* synthetic */ x.a $first$inlined;
    final /* synthetic */ ViewPager $this_apply;
    final /* synthetic */ SFSmartIconFragment this$0;

    SFSmartIconFragment$setupViewPager$$inlined$apply$lambda$1(ViewPager viewPager, SFSmartIconFragment sFSmartIconFragment, x.a aVar) {
        this.$this_apply = viewPager;
        this.this$0 = sFSmartIconFragment;
        this.$first$inlined = aVar;
    }

    public final void onPageScrollStateChanged(int i2) {
        if (CLPArtifact.isCLPListenerAvailable()) {
            CLPArtifact instance = CLPArtifact.getInstance();
            k.a((Object) instance, "CLPArtifact.getInstance()");
            if (instance.getCommunicationListener().getGTMBoolean(SmartIconGridConstants.IS_NEED_POPUP_SCROLL, true)) {
                this.this$0.handleScrollState(this.$this_apply, i2);
                this.this$0.mScrollState = i2;
            }
        }
    }

    public final void onPageScrolled(int i2, float f2, int i3) {
        if (this.$first$inlined.element && f2 == 0.0f && i3 == 0) {
            onPageSelected(0);
            this.$first$inlined.element = false;
        }
    }

    public final void onPageSelected(int i2) {
        this.this$0.mCurrentPosition = i2;
        this.this$0.getDataModel().setPosition(i2);
        SFSmartIconFragment.Companion companion = SFSmartIconFragment.Companion;
        GroupGridLayoutDataModel groupGridLayoutDataModel = (GroupGridLayoutDataModel) kotlin.a.k.a(this.this$0.finalList, i2);
        ArrayList<Item> mGridItemlist = groupGridLayoutDataModel != null ? groupGridLayoutDataModel.getMGridItemlist() : null;
        Context context = this.$this_apply.getContext();
        k.a((Object) context, "context");
        SFSmartIconFragment.Companion.sendImpressionEvent$default(companion, mGridItemlist, context, (String) null, this.this$0.promotionName, 0, (String) null, 48, (Object) null);
    }
}
