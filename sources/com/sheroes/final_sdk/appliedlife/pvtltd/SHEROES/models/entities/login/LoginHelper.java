package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login;

import android.content.Context;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.AppInstallation;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.AppInstallationHelper;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.Configuration;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.AllCommunitiesResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.Bamboo;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.networkutills.NetworkUtil;
import io.reactivex.rxjava3.g.c;

public class LoginHelper {
    Preference<AllCommunitiesResponse> allCommunitiesResponsePreference;
    Preference<Configuration> configurationPreference;
    Preference<AppInstallation> mAppInstallation;
    private Context mContext;
    LoginModel mLoginModel;
    Preference<LoginResponse> mLoginResponse;

    public LoginHelper(Context context) {
        SheroesSdk.getAppComponent(context).inject(this);
        this.mContext = context;
    }

    public void authenticateSdk(String str, String str2, final SheroesSdk.LogInCallback logInCallback) {
        if (NetworkUtil.isConnected(SheroesSdk.getApplicationContext())) {
            PaytmLoginRequest paytmLoginRequest = new PaytmLoginRequest();
            paytmLoginRequest.setCustomerId(str);
            paytmLoginRequest.setAccessToken(str2);
            paytmLoginRequest.setAdvertisementID(CommonUtil.getDeviceManufacturer());
            paytmLoginRequest.setSource("android");
            paytmLoginRequest.setDeviceType("android");
            paytmLoginRequest.setDeviceId(CommonUtil.getDeviceId());
            this.mLoginModel.authenticateSdkApi(paytmLoginRequest).subscribe(new c<LoginResponse>() {
                public void onComplete() {
                }

                public void onError(Throwable th) {
                    Bamboo.d(LoginHelper.class.getSimpleName(), "Sheroes auth logged in failed", th);
                    logInCallback.onFailure();
                }

                public void onNext(LoginResponse loginResponse) {
                    if (loginResponse.getStatus().equalsIgnoreCase("FAILED")) {
                        logInCallback.onFailure();
                        return;
                    }
                    LoginHelper.this.mLoginResponse.set(loginResponse);
                    CommonUtil.setUserIdPref(AppConstants.SHEROES_USER_ID, Long.toString(loginResponse.getUserSummary().getUserId().longValue()));
                    logInCallback.onLoggedInSuccess();
                    Bamboo.d(LoginHelper.class.getSimpleName(), "Sheroes auth logged in successfully");
                }
            });
        }
    }

    public boolean isLoggedInUser() {
        Preference<LoginResponse> preference = this.mLoginResponse;
        return (preference == null || !preference.isSet() || this.mLoginResponse.get() == null) ? false : true;
    }

    public void onUserLoggedOut() {
        this.mLoginResponse.delete();
        this.allCommunitiesResponsePreference.delete();
        CommonUtil.clearPref(AppConstants.SHEROES_USER_ID);
        this.configurationPreference.delete();
        Preference<AppInstallation> preference = this.mAppInstallation;
        if (preference != null && preference.isSet()) {
            AppInstallation appInstallation = this.mAppInstallation.get();
            appInstallation.isLoggedOut = true;
            AppInstallationHelper appInstallationHelper = new AppInstallationHelper(SheroesSdk.getApplicationContext());
            appInstallationHelper.setAppInstallation(appInstallation);
            appInstallationHelper.saveInBackground(SheroesSdk.getApplicationContext(), new CommonUtil.Callback() {
                public void callBack(boolean z) {
                }
            });
        }
        Bamboo.d(LoginHelper.class.getSimpleName(), "Sheroes logged out successfully");
    }
}
