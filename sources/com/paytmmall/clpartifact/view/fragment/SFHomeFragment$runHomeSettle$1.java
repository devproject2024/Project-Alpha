package com.paytmmall.clpartifact.view.fragment;

import androidx.lifecycle.z;
import com.paytmmall.clpartifact.modal.ForceReloadHomeModel;

public final class SFHomeFragment$runHomeSettle$1 implements z<ForceReloadHomeModel> {
    final /* synthetic */ SFHomeFragment this$0;

    SFHomeFragment$runHomeSettle$1(SFHomeFragment sFHomeFragment) {
        this.this$0 = sFHomeFragment;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001f, code lost:
        r3 = r3.getCommunicationListener();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onChanged(com.paytmmall.clpartifact.modal.ForceReloadHomeModel r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L_0x0042
            com.paytmmall.clpartifact.view.fragment.SFHomeFragment r0 = r2.this$0
            java.lang.String r0 = r0.getAPP_FOREGROUND_REFRESH_TAG()
            java.lang.String r3 = r3.getTag()
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L_0x0039
            boolean r3 = com.paytmmall.clpartifact.common.CLPArtifact.isCLPListenerAvailable()
            if (r3 == 0) goto L_0x0039
            com.paytmmall.clpartifact.common.CLPArtifact r3 = com.paytmmall.clpartifact.common.CLPArtifact.getInstance()
            r0 = 0
            if (r3 == 0) goto L_0x0030
            com.paytmmall.clpartifact.listeners.ICLPCommunicationListener r3 = r3.getCommunicationListener()
            if (r3 == 0) goto L_0x0030
            java.lang.String r1 = "isRecoRefreshEnabled"
            boolean r3 = r3.getGTMBoolean(r1, r0)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            goto L_0x0031
        L_0x0030:
            r3 = 0
        L_0x0031:
            if (r3 == 0) goto L_0x0037
            boolean r0 = r3.booleanValue()
        L_0x0037:
            if (r0 == 0) goto L_0x0042
        L_0x0039:
            com.paytmmall.clpartifact.view.fragment.SFHomeFragment r3 = r2.this$0
            com.paytmmall.clpartifact.view.viewmodel.SFHomeVM r3 = com.paytmmall.clpartifact.view.fragment.SFHomeFragment.access$getViewModel$p(r3)
            r3.forceReloadHome()
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.view.fragment.SFHomeFragment$runHomeSettle$1.onChanged(com.paytmmall.clpartifact.modal.ForceReloadHomeModel):void");
    }
}
