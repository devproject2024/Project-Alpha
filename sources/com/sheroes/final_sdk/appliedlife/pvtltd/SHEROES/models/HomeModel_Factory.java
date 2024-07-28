package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models;

import com.google.gson.f;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.SheroesAppServiceApi;
import dagger.a.c;
import javax.a.a;

public final class HomeModel_Factory implements c<HomeModel> {
    private final a<f> gsonProvider;
    private final a<SheroesAppServiceApi> sheroesAppServiceApiProvider;

    public HomeModel_Factory(a<SheroesAppServiceApi> aVar, a<f> aVar2) {
        this.sheroesAppServiceApiProvider = aVar;
        this.gsonProvider = aVar2;
    }

    public final HomeModel get() {
        return provideInstance(this.sheroesAppServiceApiProvider, this.gsonProvider);
    }

    public static HomeModel provideInstance(a<SheroesAppServiceApi> aVar, a<f> aVar2) {
        return new HomeModel(aVar.get(), aVar2.get());
    }

    public static HomeModel_Factory create(a<SheroesAppServiceApi> aVar, a<f> aVar2) {
        return new HomeModel_Factory(aVar, aVar2);
    }

    public static HomeModel newHomeModel(SheroesAppServiceApi sheroesAppServiceApi, f fVar) {
        return new HomeModel(sheroesAppServiceApi, fVar);
    }
}
