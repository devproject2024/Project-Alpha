package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.LoginResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import dagger.a.c;
import dagger.a.g;
import javax.a.a;
import okhttp3.Interceptor;

public final class SheroesAppModule_ProvideInterceptorFactory implements c<Interceptor> {
    private final SheroesAppModule module;
    private final a<Preference<LoginResponse>> userPreferenceProvider;

    public SheroesAppModule_ProvideInterceptorFactory(SheroesAppModule sheroesAppModule, a<Preference<LoginResponse>> aVar) {
        this.module = sheroesAppModule;
        this.userPreferenceProvider = aVar;
    }

    public final Interceptor get() {
        return provideInstance(this.module, this.userPreferenceProvider);
    }

    public static Interceptor provideInstance(SheroesAppModule sheroesAppModule, a<Preference<LoginResponse>> aVar) {
        return proxyProvideInterceptor(sheroesAppModule, aVar.get());
    }

    public static SheroesAppModule_ProvideInterceptorFactory create(SheroesAppModule sheroesAppModule, a<Preference<LoginResponse>> aVar) {
        return new SheroesAppModule_ProvideInterceptorFactory(sheroesAppModule, aVar);
    }

    public static Interceptor proxyProvideInterceptor(SheroesAppModule sheroesAppModule, Preference<LoginResponse> preference) {
        return (Interceptor) g.a(sheroesAppModule.provideInterceptor(preference), "Cannot return null from a non-@Nullable @Provides method");
    }
}
