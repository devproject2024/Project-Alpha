package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.DateUtil;
import dagger.a.c;
import dagger.a.g;

public final class SheroesAppModule_ProvideDateUtilFactory implements c<DateUtil> {
    private final SheroesAppModule module;

    public SheroesAppModule_ProvideDateUtilFactory(SheroesAppModule sheroesAppModule) {
        this.module = sheroesAppModule;
    }

    public final DateUtil get() {
        return provideInstance(this.module);
    }

    public static DateUtil provideInstance(SheroesAppModule sheroesAppModule) {
        return proxyProvideDateUtil(sheroesAppModule);
    }

    public static SheroesAppModule_ProvideDateUtilFactory create(SheroesAppModule sheroesAppModule) {
        return new SheroesAppModule_ProvideDateUtilFactory(sheroesAppModule);
    }

    public static DateUtil proxyProvideDateUtil(SheroesAppModule sheroesAppModule) {
        return (DateUtil) g.a(sheroesAppModule.provideDateUtil(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
