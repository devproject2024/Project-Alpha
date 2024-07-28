package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppUtils;
import dagger.a.c;
import dagger.a.g;

public final class SheroesAppModule_ProvideAppUtilFactory implements c<AppUtils> {
    private final SheroesAppModule module;

    public SheroesAppModule_ProvideAppUtilFactory(SheroesAppModule sheroesAppModule) {
        this.module = sheroesAppModule;
    }

    public final AppUtils get() {
        return provideInstance(this.module);
    }

    public static AppUtils provideInstance(SheroesAppModule sheroesAppModule) {
        return proxyProvideAppUtil(sheroesAppModule);
    }

    public static SheroesAppModule_ProvideAppUtilFactory create(SheroesAppModule sheroesAppModule) {
        return new SheroesAppModule_ProvideAppUtilFactory(sheroesAppModule);
    }

    public static AppUtils proxyProvideAppUtil(SheroesAppModule sheroesAppModule) {
        return (AppUtils) g.a(sheroesAppModule.provideAppUtil(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
