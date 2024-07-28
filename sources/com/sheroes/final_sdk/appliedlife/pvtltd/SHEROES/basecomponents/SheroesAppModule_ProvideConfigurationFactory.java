package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents;

import com.google.gson.f;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.Configuration;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.RxSharedPreferences;
import dagger.a.c;
import dagger.a.g;
import javax.a.a;

public final class SheroesAppModule_ProvideConfigurationFactory implements c<Preference<Configuration>> {
    private final a<f> gsonProvider;
    private final SheroesAppModule module;
    private final a<RxSharedPreferences> rxSharedPreferencesProvider;

    public SheroesAppModule_ProvideConfigurationFactory(SheroesAppModule sheroesAppModule, a<RxSharedPreferences> aVar, a<f> aVar2) {
        this.module = sheroesAppModule;
        this.rxSharedPreferencesProvider = aVar;
        this.gsonProvider = aVar2;
    }

    public final Preference<Configuration> get() {
        return provideInstance(this.module, this.rxSharedPreferencesProvider, this.gsonProvider);
    }

    public static Preference<Configuration> provideInstance(SheroesAppModule sheroesAppModule, a<RxSharedPreferences> aVar, a<f> aVar2) {
        return proxyProvideConfiguration(sheroesAppModule, aVar.get(), aVar2.get());
    }

    public static SheroesAppModule_ProvideConfigurationFactory create(SheroesAppModule sheroesAppModule, a<RxSharedPreferences> aVar, a<f> aVar2) {
        return new SheroesAppModule_ProvideConfigurationFactory(sheroesAppModule, aVar, aVar2);
    }

    public static Preference<Configuration> proxyProvideConfiguration(SheroesAppModule sheroesAppModule, RxSharedPreferences rxSharedPreferences, f fVar) {
        return (Preference) g.a(sheroesAppModule.provideConfiguration(rxSharedPreferences, fVar), "Cannot return null from a non-@Nullable @Provides method");
    }
}
