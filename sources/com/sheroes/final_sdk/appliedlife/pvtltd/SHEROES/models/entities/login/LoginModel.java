package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login;

import com.google.gson.f;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.SheroesAppServiceApi;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.i.a;

public class LoginModel {
    private final String TAG = LoginModel.class.getName();
    f gson;
    private final SheroesAppServiceApi sheroesAppServiceApi;

    public LoginModel(SheroesAppServiceApi sheroesAppServiceApi2, f fVar) {
        this.sheroesAppServiceApi = sheroesAppServiceApi2;
        this.gson = fVar;
    }

    public p<LoginResponse> authenticateSdkApi(PaytmLoginRequest paytmLoginRequest) {
        return this.sheroesAppServiceApi.getLoginAuthToken(paytmLoginRequest).map(new h<LoginResponse, LoginResponse>() {
            public LoginResponse apply(LoginResponse loginResponse) {
                return loginResponse;
            }
        }).subscribeOn(a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a());
    }
}
