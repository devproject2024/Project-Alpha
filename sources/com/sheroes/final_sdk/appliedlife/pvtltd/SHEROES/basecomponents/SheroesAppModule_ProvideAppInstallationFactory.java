package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents;

import com.google.gson.f;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.AppInstallation;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.RxSharedPreferences;
import dagger.a.c;
import dagger.a.g;
import javax.a.a;

public final class SheroesAppModule_ProvideAppInstallationFactory implements c<Preference<AppInstallation>> {
    private final a<f> gsonProvider;
    private final SheroesAppModule module;
    private final a<RxSharedPreferences> rxSharedPreferencesProvider;

    public SheroesAppModule_ProvideAppInstallationFactory(SheroesAppModule sheroesAppModule, a<RxSharedPreferences> aVar, a<f> aVar2) {
        this.module = sheroesAppModule;
        this.rxSharedPreferencesProvider = aVar;
        this.gsonProvider = aVar2;
    }

    public final Preference<AppInstallation> get() {
        return provideInstance(this.module, this.rxSharedPreferencesProvider, this.gsonProvider);
    }

    public static Preference<AppInstallation> provideInstance(SheroesAppModule sheroesAppModule, a<RxSharedPreferences> aVar, a<f> aVar2) {
        return proxyProvideAppInstallation(sheroesAppModule, aVar.get(), aVar2.get());
    }

    public static SheroesAppModule_ProvideAppInstallationFactory create(SheroesAppModule sheroesAppModule, a<RxSharedPreferences> aVar, a<f> aVar2) {
        return new SheroesAppModule_ProvideAppInstallationFactory(sheroesAppModule, aVar, aVar2);
    }

    public static Preference<AppInstallation> proxyProvideAppInstallation(SheroesAppModule sheroesAppModule, RxSharedPreferences rxSharedPreferences, f fVar) {
        return (Preference) g.a(sheroesAppModule.provideAppInstallation(rxSharedPreferences, fVar), "Cannot return null from a non-@Nullable @Provides method");
    }
}
