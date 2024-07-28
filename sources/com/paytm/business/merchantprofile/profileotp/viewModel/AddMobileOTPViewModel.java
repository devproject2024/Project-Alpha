package com.paytm.business.merchantprofile.profileotp.viewModel;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.y;
import com.business.common_module.utilities.a.b;
import com.business.common_module.utilities.a.c;
import com.business.common_module.utilities.i;
import com.paytm.business.merchantprofile.ProfileConfig;
import com.paytm.business.merchantprofile.model.GenerateOtpResponseModel;
import com.paytm.business.merchantprofile.profileotp.repo.AddMobileOTPRepo;
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
            com.paytm.business.merchantprofile.ProfileConfig r0 = com.paytm.business.merchantprofile.ProfileConfig.getInstance()
            java.lang.String r1 = "ProfileConfig.getInstance()"
            kotlin.g.b.k.b(r0, r1)
            android.app.Application r0 = r0.getApplication()
            r2.<init>(r0)
            java.lang.String r0 = ""
            r2.mobNum = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.business.merchantprofile.profileotp.viewModel.AddMobileOTPViewModel.<init>():void");
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
        ProfileConfig instance = ProfileConfig.getInstance();
        k.b(instance, "ProfileConfig.getInstance()");
        if (!i.a(instance.getApplication())) {
            y yVar = new y();
            yVar.setValue(b.a("NO NETWORK"));
            return yVar;
        }
        LiveData<b<GenerateOtpResponseModel>> generateOtp = AddMobileOTPRepo.getInstance().generateOtp("ADD_MOBILE_OTP_SCREEN", this.mobNum, true, this.mOtpType);
        k.b(generateOtp, "AddMobileOTPRepo.getInst…EN,mobNum,true, mOtpType)");
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
