package com.business.merchant_payments.acceptpayments.viewModel;

import androidx.arch.core.c.a;
import androidx.lifecycle.LiveData;
import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.model.GenerateOtpResponseModel;
import kotlin.g.b.k;

public final class AddMobileOTPViewModel$initDefaultParams$1<I, O> implements a<Boolean, LiveData<b<GenerateOtpResponseModel>>> {
    public final /* synthetic */ AddMobileOTPViewModel this$0;

    public AddMobileOTPViewModel$initDefaultParams$1(AddMobileOTPViewModel addMobileOTPViewModel) {
        this.this$0 = addMobileOTPViewModel;
    }

    public final LiveData<b<GenerateOtpResponseModel>> apply(Boolean bool) {
        k.b(bool, "flag");
        if (bool.booleanValue()) {
            return this.this$0.hitFetchOTP();
        }
        return com.business.common_module.utilities.a.a.a();
    }
}
