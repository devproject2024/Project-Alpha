package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents;

import com.google.gson.f;
import dagger.a.c;
import dagger.a.g;

public final class SheroesAppModule_ProvideGsonFactory implements c<f> {
    private final SheroesAppModule module;

    public SheroesAppModule_ProvideGsonFactory(SheroesAppModule sheroesAppModule) {
        this.module = sheroesAppModule;
    }

    public final f get() {
        return provideInstance(this.module);
    }

    public static f provideInstance(SheroesAppModule sheroesAppModule) {
        return proxyProvideGson(sheroesAppModule);
    }

    public static SheroesAppModule_ProvideGsonFactory create(SheroesAppModule sheroesAppModule) {
        return new SheroesAppModule_ProvideGsonFactory(sheroesAppModule);
    }

    public static f proxyProvideGson(SheroesAppModule sheroesAppModule) {
        return (f) g.a(sheroesAppModule.provideGson(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
