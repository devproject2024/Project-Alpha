package com.business.merchant_payments.acceptpayments.viewModel;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.y;
import com.business.common_module.utilities.a.b;
import com.business.common_module.utilities.a.c;
import com.business.common_module.utilities.i;
import com.business.merchant_payments.PaymentsConfig;
import com.business.merchant_payments.model.GenerateOtpResponseModel;
import com.business.merchant_payments.settlement.model.SettlementRepository;
import kotlin.g.b.k;

public final class AddMobileOTPViewModel extends c {
    public LiveData<b<GenerateOtpResponseModel>> generateOtpLiveData;
    public String mOtpType;
    public String mobNum;
    public y<Boolean> otpGenerateFlag;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AddMobileOTPViewModel() {
        /*
            r2 = this;
            com.business.merchant_payments.PaymentsConfig r0 = com.business.merchant_payments.PaymentsConfig.getInstance()
            java.lang.String r1 = "PaymentsConfig.getInstance()"
            kotlin.g.b.k.b(r0, r1)
            android.app.Application r0 = r0.getApplication()
            r2.<init>(r0)
            java.lang.String r0 = ""
            r2.mobNum = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.acceptpayments.viewModel.AddMobileOTPViewModel.<init>():void");
    }

    public final LiveData<b<GenerateOtpResponseModel>> getGenerateOtpLiveData() {
        LiveData<b<GenerateOtpResponseModel>> liveData = this.generateOtpLiveData;
        if (liveData == null) {
            k.a("generateOtpLiveData");
        }
        return liveData;
    }

    public final void setGenerateOtpLiveData(LiveData<b<GenerateOtpResponseModel>> liveData) {
        k.d(liveData, "<set-?>");
        this.generateOtpLiveData = liveData;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AddMobileOTPViewModel(Application application) {
        this();
        k.d(application, "application");
    }

    public final void initDefaultParams() {
        y<Boolean> yVar = new y<>();
        this.otpGenerateFlag = yVar;
        LiveData<b<GenerateOtpResponseModel>> b2 = ah.b(yVar, new AddMobileOTPViewModel$initDefaultParams$1(this));
        k.b(b2, "Transformations.switchMa…)\n            }\n        }");
        this.generateOtpLiveData = b2;
    }

    /* access modifiers changed from: private */
    public final LiveData<b<GenerateOtpResponseModel>> hitFetchOTP() {
        PaymentsConfig instance = PaymentsConfig.getInstance();
        k.b(instance, "PaymentsConfig.getInstance()");
        if (!i.a(instance.getApplication())) {
            y yVar = new y();
            yVar.setValue(b.a("NO NETWORK"));
            return yVar;
        }
        LiveData<b<GenerateOtpResponseModel>> generateOtp = SettlementRepository.getInstance().generateOtp("ADD_MOBILE_OTP_SCREEN", this.mobNum, true, this.mOtpType);
        k.b(generateOtp, "SettlementRepository.get…EN,mobNum,true, mOtpType)");
        return generateOtp;
    }

    public final void hitgenerateOtp(String str, String str2) {
        k.d(str, "mobNum");
        y<Boolean> yVar = this.otpGenerateFlag;
        if (yVar == null) {
            k.a("otpGenerateFlag");
        }
        yVar.setValue(Boolean.TRUE);
        this.mobNum = str;
        this.mOtpType = str2;
    }
}
