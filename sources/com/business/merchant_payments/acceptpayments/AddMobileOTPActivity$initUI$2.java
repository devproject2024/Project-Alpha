package com.business.merchant_payments.acceptpayments;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.business.merchant_payments.common.fragment.OtpEditBoxesCommonFragment;
import com.business.merchant_payments.gtm.GAGTMTagAnalytics;

public final class AddMobileOTPActivity$initUI$2 implements View.OnClickListener {
    public final /* synthetic */ AddMobileOTPActivity this$0;

    public AddMobileOTPActivity$initUI$2(AddMobileOTPActivity addMobileOTPActivity) {
        this.this$0 = addMobileOTPActivity;
    }

    public final void onClick(View view) {
        String str;
        if (this.this$0.isFromAddMobileOTPActivity()) {
            GAGTMTagAnalytics.getSingleInstance().sendEventAndScreen(this.this$0, "Accept Payment", "Add-Change notification settings", "Verify another mobile number");
        }
        AddMobileOTPActivity addMobileOTPActivity = this.this$0;
        OtpEditBoxesCommonFragment otpEditBoxesCommonFragment = addMobileOTPActivity.getOtpEditBoxesCommonFragment();
        if (otpEditBoxesCommonFragment == null || (str = otpEditBoxesCommonFragment.getOtpCombined()) == null) {
            str = "";
        }
        addMobileOTPActivity.setOtp(str);
        if (!TextUtils.isEmpty(this.this$0.getOtp())) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("OTP", this.this$0.getOtp());
            bundle.putString("OTP_STATE", this.this$0.getOtpState());
            intent.putExtras(bundle);
            this.this$0.setResult(-1, intent);
            this.this$0.finish();
        }
    }
}
