package net.one97.paytm.nativesdk.paymethods.views.fragments;

import androidx.lifecycle.z;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.paymethods.viewmodel.TranscationStatus;
import net.one97.paytm.nativesdk.paymethods.views.fragments.OrderSummaryFragment;

final class OrderSummaryFragment$onViewCreated$2<T> implements z<TranscationStatus> {
    final /* synthetic */ OrderSummaryFragment this$0;

    OrderSummaryFragment$onViewCreated$2(OrderSummaryFragment orderSummaryFragment) {
        this.this$0 = orderSummaryFragment;
    }

    public final void onChanged(TranscationStatus transcationStatus) {
        if (transcationStatus != null) {
            int i2 = OrderSummaryFragment.WhenMappings.$EnumSwitchMapping$0[transcationStatus.ordinal()];
            if (i2 == 1) {
                if (SDKUtility.isAppInvokeFlow()) {
                    SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_SUCCESS_TXN_SCREEN, ""));
                }
                this.this$0.inflateSuccessView();
            } else if (i2 == 2) {
                if (SDKUtility.isAppInvokeFlow()) {
                    SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_PENDING_TXN_SCREEN, ""));
                }
                this.this$0.inflatePendingView();
            } else if (i2 == 3) {
                if (SDKUtility.isAppInvokeFlow()) {
                    SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_FAILURE_TXN_SCREEN, ""));
                }
                this.this$0.inflateFailureView();
            }
        }
    }
}
