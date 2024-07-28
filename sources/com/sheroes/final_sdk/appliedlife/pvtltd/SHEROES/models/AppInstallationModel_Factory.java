package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models;

import com.google.gson.f;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.SheroesAppServiceApi;
import dagger.a.c;
import javax.a.a;

public final class AppInstallationModel_Factory implements c<AppInstallationModel> {
    private final a<f> gsonProvider;
    private final a<SheroesAppServiceApi> sheroesAppServiceApiProvider;

    public AppInstallationModel_Factory(a<SheroesAppServiceApi> aVar, a<f> aVar2) {
        this.sheroesAppServiceApiProvider = aVar;
        this.gsonProvider = aVar2;
    }

    public final AppInstallationModel get() {
        return provideInstance(this.sheroesAppServiceApiProvider, this.gsonProvider);
    }

    public static AppInstallationModel provideInstance(a<SheroesAppServiceApi> aVar, a<f> aVar2) {
        return new AppInstallationModel(aVar.get(), aVar2.get());
    }

    public static AppInstallationModel_Factory create(a<SheroesAppServiceApi> aVar, a<f> aVar2) {
        return new AppInstallationModel_Factory(aVar, aVar2);
    }

    public static AppInstallationModel newAppInstallationModel(SheroesAppServiceApi sheroesAppServiceApi, f fVar) {
        return new AppInstallationModel(sheroesAppServiceApi, fVar);
    }
}
