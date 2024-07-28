package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents;

import com.google.gson.f;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.AllCommunitiesResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.RxSharedPreferences;
import dagger.a.c;
import dagger.a.g;
import javax.a.a;

public final class SheroesAppModule_ProvideAllCommunitiesFactory implements c<Preference<AllCommunitiesResponse>> {
    private final a<f> gsonProvider;
    private final SheroesAppModule module;
    private final a<RxSharedPreferences> rxSharedPreferencesProvider;

    public SheroesAppModule_ProvideAllCommunitiesFactory(SheroesAppModule sheroesAppModule, a<RxSharedPreferences> aVar, a<f> aVar2) {
        this.module = sheroesAppModule;
        this.rxSharedPreferencesProvider = aVar;
        this.gsonProvider = aVar2;
    }

    public final Preference<AllCommunitiesResponse> get() {
        return provideInstance(this.module, this.rxSharedPreferencesProvider, this.gsonProvider);
    }

    public static Preference<AllCommunitiesResponse> provideInstance(SheroesAppModule sheroesAppModule, a<RxSharedPreferences> aVar, a<f> aVar2) {
        return proxyProvideAllCommunities(sheroesAppModule, aVar.get(), aVar2.get());
    }

    public static SheroesAppModule_ProvideAllCommunitiesFactory create(SheroesAppModule sheroesAppModule, a<RxSharedPreferences> aVar, a<f> aVar2) {
        return new SheroesAppModule_ProvideAllCommunitiesFactory(sheroesAppModule, aVar, aVar2);
    }

    public static Preference<AllCommunitiesResponse> proxyProvideAllCommunities(SheroesAppModule sheroesAppModule, RxSharedPreferences rxSharedPreferences, f fVar) {
        return (Preference) g.a(sheroesAppModule.provideAllCommunities(rxSharedPreferences, fVar), "Cannot return null from a non-@Nullable @Provides method");
    }
}
