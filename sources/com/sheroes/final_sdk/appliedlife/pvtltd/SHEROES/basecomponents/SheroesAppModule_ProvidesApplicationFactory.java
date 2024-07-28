package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents;

import android.content.Context;
import dagger.a.c;
import dagger.a.g;

public final class SheroesAppModule_ProvidesApplicationFactory implements c<Context> {
    private final SheroesAppModule module;

    public SheroesAppModule_ProvidesApplicationFactory(SheroesAppModule sheroesAppModule) {
        this.module = sheroesAppModule;
    }

    public final Context get() {
        return provideInstance(this.module);
    }

    public static Context provideInstance(SheroesAppModule sheroesAppModule) {
        return proxyProvidesApplication(sheroesAppModule);
    }

    public static SheroesAppModule_ProvidesApplicationFactory create(SheroesAppModule sheroesAppModule) {
        return new SheroesAppModule_ProvidesApplicationFactory(sheroesAppModule);
    }

    public static Context proxyProvidesApplication(SheroesAppModule sheroesAppModule) {
        return (Context) g.a(sheroesAppModule.providesApplication(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
