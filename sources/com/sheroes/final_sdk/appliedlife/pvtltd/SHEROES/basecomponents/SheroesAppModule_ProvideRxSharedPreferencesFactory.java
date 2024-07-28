package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.RxSharedPreferences;
import dagger.a.c;
import dagger.a.g;

public final class SheroesAppModule_ProvideRxSharedPreferencesFactory implements c<RxSharedPreferences> {
    private final SheroesAppModule module;

    public SheroesAppModule_ProvideRxSharedPreferencesFactory(SheroesAppModule sheroesAppModule) {
        this.module = sheroesAppModule;
    }

    public final RxSharedPreferences get() {
        return provideInstance(this.module);
    }

    public static RxSharedPreferences provideInstance(SheroesAppModule sheroesAppModule) {
        return proxyProvideRxSharedPreferences(sheroesAppModule);
    }

    public static SheroesAppModule_ProvideRxSharedPreferencesFactory create(SheroesAppModule sheroesAppModule) {
        return new SheroesAppModule_ProvideRxSharedPreferencesFactory(sheroesAppModule);
    }

    public static RxSharedPreferences proxyProvideRxSharedPreferences(SheroesAppModule sheroesAppModule) {
        return (RxSharedPreferences) g.a(sheroesAppModule.provideRxSharedPreferences(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
