package com.paytmmall.clpartifact.widgets.component.smarticongrid.view;

import android.view.View;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.widgets.component.smarticongrid.GroupGridLayoutDataModel;
import com.paytmmall.clpartifact.widgets.component.smarticongrid.view.SFSmartIconFragment;
import kotlin.g.b.k;

final class SFSmartIconFragment$SmartIconPagerAdapter$setTickerClickListner$1 implements View.OnClickListener {
    final /* synthetic */ int $position;
    final /* synthetic */ SFSmartIconFragment.SmartIconPagerAdapter this$0;

    SFSmartIconFragment$SmartIconPagerAdapter$setTickerClickListner$1(SFSmartIconFragment.SmartIconPagerAdapter smartIconPagerAdapter, int i2) {
        this.this$0 = smartIconPagerAdapter;
        this.$position = i2;
    }

    public final void onClick(View view) {
        if (this.this$0.this$0.finalList.size() > this.$position) {
            if (((GroupGridLayoutDataModel) this.this$0.this$0.finalList.get(this.$position)).getMTickerItem() == null || ((GroupGridLayoutDataModel) this.this$0.this$0.finalList.get(this.$position)).getMTickerItem().getUrl() == null) {
                CLPArtifact instance = CLPArtifact.getInstance();
                k.a((Object) instance, "CLPArtifact.getInstance()");
                instance.getCommunicationListener().handleDeepLink(this.this$0.this$0.getActivity(), this.this$0.constructItem("paytmmp://cash_wallet?featuretype=vip&screen=newvouchers"));
            } else {
                SFSmartIconFragment.OnItemClickListner access$getItemClickListner$p = this.this$0.this$0.itemClickListner;
                if (access$getItemClickListner$p != null) {
                    access$getItemClickListner$p.onTickerItemClick(this.$position, ((GroupGridLayoutDataModel) this.this$0.this$0.finalList.get(this.$position)).getMTickerItem());
                }
            }
        }
        this.this$0.this$0.dismiss();
    }
}
