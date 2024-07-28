package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models;

import com.google.gson.f;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.SheroesAppServiceApi;
import dagger.a.c;
import javax.a.a;

public final class CommunityModel_Factory implements c<CommunityModel> {
    private final a<f> gsonProvider;
    private final a<SheroesAppServiceApi> sheroesAppServiceApiProvider;

    public CommunityModel_Factory(a<SheroesAppServiceApi> aVar, a<f> aVar2) {
        this.sheroesAppServiceApiProvider = aVar;
        this.gsonProvider = aVar2;
    }

    public final CommunityModel get() {
        return provideInstance(this.sheroesAppServiceApiProvider, this.gsonProvider);
    }

    public static CommunityModel provideInstance(a<SheroesAppServiceApi> aVar, a<f> aVar2) {
        return new CommunityModel(aVar.get(), aVar2.get());
    }

    public static CommunityModel_Factory create(a<SheroesAppServiceApi> aVar, a<f> aVar2) {
        return new CommunityModel_Factory(aVar, aVar2);
    }

    public static CommunityModel newCommunityModel(SheroesAppServiceApi sheroesAppServiceApi, f fVar) {
        return new CommunityModel(sheroesAppServiceApi, fVar);
    }
}
