package com.paytm.business.merchantprofile.view;

import android.view.View;
import com.business.common_module.e.b;
import com.paytm.business.merchantprofile.listener.MerchantSwitchListener;
import com.paytm.business.merchantprofile.widget.BaseCustomRadioButton;
import com.paytm.business.merchantprofile.widget.CustomRadioGroup;

public final class MerchantSwitchBottomSheet$onCreateView$1 implements CustomRadioGroup.OnCheckedChangeListener {
    public final /* synthetic */ MerchantSwitchBottomSheet this$0;

    public MerchantSwitchBottomSheet$onCreateView$1(MerchantSwitchBottomSheet merchantSwitchBottomSheet) {
        this.this$0 = merchantSwitchBottomSheet;
    }

    public final void onCheckedChanged(View view, View view2, boolean z, int i2) {
        MerchantSwitchListener access$getMerchantSwitchListener$p = this.this$0.merchantSwitchListener;
        if (access$getMerchantSwitchListener$p != null) {
            if (view2 != null) {
                Object data = ((BaseCustomRadioButton) view2).getData();
                if (data != null) {
                    access$getMerchantSwitchListener$p.onMerchantSwitch((b) data);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.business.common_module.merchantdata.Merchants");
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.paytm.business.merchantprofile.widget.BaseCustomRadioButton");
            }
        }
        this.this$0.dismiss();
    }
}
