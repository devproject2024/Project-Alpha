package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters;

import android.content.Context;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.SheroesAppServiceApi;
import dagger.a.c;
import javax.a.a;

public final class UserLikedListPresenterImpl_Factory implements c<UserLikedListPresenterImpl> {
    private final a<SheroesAppServiceApi> sheroesAppServiceApiProvider;
    private final a<Context> sheroesApplicationProvider;

    public UserLikedListPresenterImpl_Factory(a<Context> aVar, a<SheroesAppServiceApi> aVar2) {
        this.sheroesApplicationProvider = aVar;
        this.sheroesAppServiceApiProvider = aVar2;
    }

    public final UserLikedListPresenterImpl get() {
        return provideInstance(this.sheroesApplicationProvider, this.sheroesAppServiceApiProvider);
    }

    public static UserLikedListPresenterImpl provideInstance(a<Context> aVar, a<SheroesAppServiceApi> aVar2) {
        return new UserLikedListPresenterImpl(aVar.get(), aVar2.get());
    }

    public static UserLikedListPresenterImpl_Factory create(a<Context> aVar, a<SheroesAppServiceApi> aVar2) {
        return new UserLikedListPresenterImpl_Factory(aVar, aVar2);
    }

    public static UserLikedListPresenterImpl newUserLikedListPresenterImpl(Context context, SheroesAppServiceApi sheroesAppServiceApi) {
        return new UserLikedListPresenterImpl(context, sheroesAppServiceApi);
    }
}
