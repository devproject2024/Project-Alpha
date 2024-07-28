package com.paytmmall.clpartifact.widgets.component.smarticongrid.view;

import androidx.lifecycle.z;
import com.paytmmall.clpartifact.widgets.component.smarticongrid.GroupGridLayoutDataModel;
import java.util.List;
import kotlin.g.b.k;

public final class SFSmartIconFragment$onViewCreated$1 implements z<List<? extends GroupGridLayoutDataModel>> {
    final /* synthetic */ SFSmartIconFragment this$0;

    SFSmartIconFragment$onViewCreated$1(SFSmartIconFragment sFSmartIconFragment) {
        this.this$0 = sFSmartIconFragment;
    }

    public final void onChanged(List<GroupGridLayoutDataModel> list) {
        k.c(list, "reponseList");
        this.this$0.handleResponseList(list);
    }
}
