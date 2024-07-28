package com.paytm.business.merchantprofile.profileotp.repo;

import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import com.business.common_module.utilities.a.a;
import com.business.common_module.utilities.a.b;
import com.paytm.business.merchantprofile.ProfileConfig;
import com.paytm.business.merchantprofile.common.utility.GTMDataProviderImpl;
import com.paytm.business.merchantprofile.common.utility.RequestParamUtil;
import com.paytm.business.merchantprofile.model.GenerateOtpResponseModel;
import java.util.HashMap;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddMobileOTPRepo {
    public static AddMobileOTPRepo mInstance;

    public static AddMobileOTPRepo getInstance() {
        synchronized (AddMobileOTPRepo.class) {
            if (mInstance == null) {
                mInstance = new AddMobileOTPRepo();
            }
        }
        return mInstance;
    }

    public LiveData<b<GenerateOtpResponseModel>> generateOtp(String str, String str2, boolean z, String str3) {
        String str4;
        if (z) {
            str4 = GTMDataProviderImpl.Companion.getMInstance().getGenerateOtpUrlV2();
        } else {
            str4 = GTMDataProviderImpl.Companion.getMInstance().getGenerateOtpUrl();
        }
        if (!URLUtil.isValidUrl(str4)) {
            return new a();
        }
        final y yVar = new y();
        ProfileConfig.getInstance().getNetworkService().generateOtp(str4, RequestParamUtil.getRequestHeaderMidParam(ProfileConfig.getInstance().getAppContext()), getParams(str2, str3)).enqueue(new Callback<GenerateOtpResponseModel>(this) {
            public void onResponse(Call<GenerateOtpResponseModel> call, Response<GenerateOtpResponseModel> response) {
                if (!response.isSuccessful() || response.body() == null) {
                    yVar.setValue(b.a((Response<?>) response));
                } else {
                    yVar.setValue(b.a(response, response.body()));
                }
            }

            public void onFailure(Call<GenerateOtpResponseModel> call, Throwable th) {
                yVar.setValue(b.a(th));
            }
        });
        return yVar;
    }

    private Map<String, String> getParams(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("mobile", str);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("type", str2);
        }
        return hashMap;
    }
}
