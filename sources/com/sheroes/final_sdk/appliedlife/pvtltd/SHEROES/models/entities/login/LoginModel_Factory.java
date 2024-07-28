package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login;

import com.google.gson.f;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.SheroesAppServiceApi;
import dagger.a.c;
import javax.a.a;

public final class LoginModel_Factory implements c<LoginModel> {
    private final a<f> gsonProvider;
    private final a<SheroesAppServiceApi> sheroesAppServiceApiProvider;

    public LoginModel_Factory(a<SheroesAppServiceApi> aVar, a<f> aVar2) {
        this.sheroesAppServiceApiProvider = aVar;
        this.gsonProvider = aVar2;
    }

    public final LoginModel get() {
        return provideInstance(this.sheroesAppServiceApiProvider, this.gsonProvider);
    }

    public static LoginModel provideInstance(a<SheroesAppServiceApi> aVar, a<f> aVar2) {
        return new LoginModel(aVar.get(), aVar2.get());
    }

    public static LoginModel_Factory create(a<SheroesAppServiceApi> aVar, a<f> aVar2) {
        return new LoginModel_Factory(aVar, aVar2);
    }

    public static LoginModel newLoginModel(SheroesAppServiceApi sheroesAppServiceApi, f fVar) {
        return new LoginModel(sheroesAppServiceApi, fVar);
    }
}
