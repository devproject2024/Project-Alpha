package com.paytmmall.clpartifact.view.viewmodel;

import android.app.Application;
import androidx.lifecycle.w;
import androidx.lifecycle.z;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.network.Resource;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.b.l;

final class SFHomeVM$responseLiveData$2 extends l implements a<w<Resource<List<? extends View>>>> {
    final /* synthetic */ Application $application;
    final /* synthetic */ SFHomeVM this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SFHomeVM$responseLiveData$2(SFHomeVM sFHomeVM, Application application) {
        super(0);
        this.this$0 = sFHomeVM;
        this.$application = application;
    }

    public final w<Resource<List<View>>> invoke() {
        final w<Resource<List<View>>> wVar = new w<>();
        wVar.addSource(this.this$0.repository.loadInitialPage(this.this$0.getPrewarmResponseFetchInitiated()), new z<S>(this) {
            final /* synthetic */ SFHomeVM$responseLiveData$2 this$0;

            {
                this.this$0 = r1;
            }

            public final void onChanged(Resource<HomeResponse> resource) {
                this.this$0.this$0.handleResponse(wVar, resource);
                if (com.paytm.utility.a.m(this.this$0.$application)) {
                    this.this$0.this$0.refreshHome();
                }
            }
        });
        return wVar;
    }
}
