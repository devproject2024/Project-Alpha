package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters;

import android.content.Context;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.SheroesAppServiceApi;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppUtils;
import dagger.a.c;
import javax.a.a;

public final class PostDetailViewImpl_Factory implements c<PostDetailViewImpl> {
    private final a<AppUtils> mAppUtilsProvider;
    private final a<SheroesAppServiceApi> sheroesAppServiceApiProvider;
    private final a<Context> sheroesApplicationProvider;

    public PostDetailViewImpl_Factory(a<SheroesAppServiceApi> aVar, a<Context> aVar2, a<AppUtils> aVar3) {
        this.sheroesAppServiceApiProvider = aVar;
        this.sheroesApplicationProvider = aVar2;
        this.mAppUtilsProvider = aVar3;
    }

    public final PostDetailViewImpl get() {
        return provideInstance(this.sheroesAppServiceApiProvider, this.sheroesApplicationProvider, this.mAppUtilsProvider);
    }

    public static PostDetailViewImpl provideInstance(a<SheroesAppServiceApi> aVar, a<Context> aVar2, a<AppUtils> aVar3) {
        PostDetailViewImpl postDetailViewImpl = new PostDetailViewImpl(aVar.get(), aVar2.get());
        PostDetailViewImpl_MembersInjector.injectMAppUtils(postDetailViewImpl, aVar3.get());
        return postDetailViewImpl;
    }

    public static PostDetailViewImpl_Factory create(a<SheroesAppServiceApi> aVar, a<Context> aVar2, a<AppUtils> aVar3) {
        return new PostDetailViewImpl_Factory(aVar, aVar2, aVar3);
    }

    public static PostDetailViewImpl newPostDetailViewImpl(SheroesAppServiceApi sheroesAppServiceApi, Context context) {
        return new PostDetailViewImpl(sheroesAppServiceApi, context);
    }
}
