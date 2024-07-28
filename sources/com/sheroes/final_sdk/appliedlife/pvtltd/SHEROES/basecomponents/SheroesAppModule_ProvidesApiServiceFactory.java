package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents;

import dagger.a.c;
import dagger.a.g;
import javax.a.a;
import retrofit2.Retrofit;

public final class SheroesAppModule_ProvidesApiServiceFactory implements c<SheroesAppServiceApi> {
    private final SheroesAppModule module;
    private final a<Retrofit> retrofitProvider;

    public SheroesAppModule_ProvidesApiServiceFactory(SheroesAppModule sheroesAppModule, a<Retrofit> aVar) {
        this.module = sheroesAppModule;
        this.retrofitProvider = aVar;
    }

    public final SheroesAppServiceApi get() {
        return provideInstance(this.module, this.retrofitProvider);
    }

    public static SheroesAppServiceApi provideInstance(SheroesAppModule sheroesAppModule, a<Retrofit> aVar) {
        return proxyProvidesApiService(sheroesAppModule, aVar.get());
    }

    public static SheroesAppModule_ProvidesApiServiceFactory create(SheroesAppModule sheroesAppModule, a<Retrofit> aVar) {
        return new SheroesAppModule_ProvidesApiServiceFactory(sheroesAppModule, aVar);
    }

    public static SheroesAppServiceApi proxyProvidesApiService(SheroesAppModule sheroesAppModule, Retrofit retrofit) {
        return (SheroesAppServiceApi) g.a(sheroesAppModule.providesApiService(retrofit), "Cannot return null from a non-@Nullable @Provides method");
    }
}
