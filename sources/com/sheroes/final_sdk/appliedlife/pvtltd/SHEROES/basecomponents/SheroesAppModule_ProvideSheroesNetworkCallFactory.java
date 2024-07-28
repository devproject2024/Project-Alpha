package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents;

import com.google.gson.f;
import dagger.a.c;
import dagger.a.g;
import javax.a.a;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public final class SheroesAppModule_ProvideSheroesNetworkCallFactory implements c<Retrofit> {
    private final a<f> gsonProvider;
    private final SheroesAppModule module;
    private final a<OkHttpClient> okHttpClientProvider;

    public SheroesAppModule_ProvideSheroesNetworkCallFactory(SheroesAppModule sheroesAppModule, a<OkHttpClient> aVar, a<f> aVar2) {
        this.module = sheroesAppModule;
        this.okHttpClientProvider = aVar;
        this.gsonProvider = aVar2;
    }

    public final Retrofit get() {
        return provideInstance(this.module, this.okHttpClientProvider, this.gsonProvider);
    }

    public static Retrofit provideInstance(SheroesAppModule sheroesAppModule, a<OkHttpClient> aVar, a<f> aVar2) {
        return proxyProvideSheroesNetworkCall(sheroesAppModule, aVar.get(), aVar2.get());
    }

    public static SheroesAppModule_ProvideSheroesNetworkCallFactory create(SheroesAppModule sheroesAppModule, a<OkHttpClient> aVar, a<f> aVar2) {
        return new SheroesAppModule_ProvideSheroesNetworkCallFactory(sheroesAppModule, aVar, aVar2);
    }

    public static Retrofit proxyProvideSheroesNetworkCall(SheroesAppModule sheroesAppModule, OkHttpClient okHttpClient, f fVar) {
        return (Retrofit) g.a(sheroesAppModule.provideSheroesNetworkCall(okHttpClient, fVar), "Cannot return null from a non-@Nullable @Provides method");
    }
}
