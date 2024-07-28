package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models;

import com.google.gson.f;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.SheroesAppServiceApi;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.i.a;

public class AppInstallationModel {
    private final String TAG = AppInstallationModel.class.getName();
    f gson;
    private final SheroesAppServiceApi sheroesAppServiceApi;

    public AppInstallationModel(SheroesAppServiceApi sheroesAppServiceApi2, f fVar) {
        this.sheroesAppServiceApi = sheroesAppServiceApi2;
        this.gson = fVar;
    }

    public p<AppInstallation> getAppInstallation(final AppInstallation appInstallation) {
        return this.sheroesAppServiceApi.saveInstallation(appInstallation).map(new h<AppInstallation, AppInstallation>() {
            public AppInstallation apply(AppInstallation appInstallation) {
                return appInstallation;
            }
        }).subscribeOn(a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a());
    }
}
