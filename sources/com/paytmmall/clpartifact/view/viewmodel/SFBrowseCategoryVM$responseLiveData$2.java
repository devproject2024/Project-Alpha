package com.paytmmall.clpartifact.view.viewmodel;

import androidx.lifecycle.w;
import androidx.lifecycle.z;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.network.Resource;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.b.k;
import kotlin.g.b.l;

final class SFBrowseCategoryVM$responseLiveData$2 extends l implements a<w<Resource<List<? extends View>>>> {
    final /* synthetic */ SFBrowseCategoryVM this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SFBrowseCategoryVM$responseLiveData$2(SFBrowseCategoryVM sFBrowseCategoryVM) {
        super(0);
        this.this$0 = sFBrowseCategoryVM;
    }

    public final w<Resource<List<View>>> invoke() {
        final w<Resource<List<View>>> wVar = new w<>();
        wVar.addSource(this.this$0.repository.getMoreResponse(), new z<S>(this) {
            final /* synthetic */ SFBrowseCategoryVM$responseLiveData$2 this$0;

            {
                this.this$0 = r1;
            }

            public final void onChanged(Resource<HomeResponse> resource) {
                SFBrowseCategoryVM sFBrowseCategoryVM = this.this$0.this$0;
                w wVar = wVar;
                k.a((Object) resource, "it");
                sFBrowseCategoryVM.handleResponse(wVar, resource);
            }
        });
        return wVar;
    }
}
