package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents;

import dagger.a.c;
import dagger.a.g;
import javax.a.a;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

public final class SheroesAppModule_ProvideOkHttpClientFactory implements c<OkHttpClient> {
    private final a<Interceptor> interceptorProvider;
    private final SheroesAppModule module;

    public SheroesAppModule_ProvideOkHttpClientFactory(SheroesAppModule sheroesAppModule, a<Interceptor> aVar) {
        this.module = sheroesAppModule;
        this.interceptorProvider = aVar;
    }

    public final OkHttpClient get() {
        return provideInstance(this.module, this.interceptorProvider);
    }

    public static OkHttpClient provideInstance(SheroesAppModule sheroesAppModule, a<Interceptor> aVar) {
        return proxyProvideOkHttpClient(sheroesAppModule, aVar.get());
    }

    public static SheroesAppModule_ProvideOkHttpClientFactory create(SheroesAppModule sheroesAppModule, a<Interceptor> aVar) {
        return new SheroesAppModule_ProvideOkHttpClientFactory(sheroesAppModule, aVar);
    }

    public static OkHttpClient proxyProvideOkHttpClient(SheroesAppModule sheroesAppModule, Interceptor interceptor) {
        return (OkHttpClient) g.a(sheroesAppModule.provideOkHttpClient(interceptor), "Cannot return null from a non-@Nullable @Provides method");
    }
}
