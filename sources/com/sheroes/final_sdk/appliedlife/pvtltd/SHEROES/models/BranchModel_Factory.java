package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models;

import com.google.gson.f;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.SheroesAppServiceApi;
import dagger.a.c;
import javax.a.a;

public final class BranchModel_Factory implements c<BranchModel> {
    private final a<f> gsonProvider;
    private final a<SheroesAppServiceApi> sheroesAppServiceApiProvider;

    public BranchModel_Factory(a<SheroesAppServiceApi> aVar, a<f> aVar2) {
        this.sheroesAppServiceApiProvider = aVar;
        this.gsonProvider = aVar2;
    }

    public final BranchModel get() {
        return provideInstance(this.sheroesAppServiceApiProvider, this.gsonProvider);
    }

    public static BranchModel provideInstance(a<SheroesAppServiceApi> aVar, a<f> aVar2) {
        return new BranchModel(aVar.get(), aVar2.get());
    }

    public static BranchModel_Factory create(a<SheroesAppServiceApi> aVar, a<f> aVar2) {
        return new BranchModel_Factory(aVar, aVar2);
    }

    public static BranchModel newBranchModel(SheroesAppServiceApi sheroesAppServiceApi, f fVar) {
        return new BranchModel(sheroesAppServiceApi, fVar);
    }
}
