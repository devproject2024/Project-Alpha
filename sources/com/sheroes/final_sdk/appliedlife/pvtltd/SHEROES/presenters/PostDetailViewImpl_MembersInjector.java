package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppUtils;
import dagger.a;

public final class PostDetailViewImpl_MembersInjector implements a<PostDetailViewImpl> {
    private final javax.a.a<AppUtils> mAppUtilsProvider;

    public PostDetailViewImpl_MembersInjector(javax.a.a<AppUtils> aVar) {
        this.mAppUtilsProvider = aVar;
    }

    public static a<PostDetailViewImpl> create(javax.a.a<AppUtils> aVar) {
        return new PostDetailViewImpl_MembersInjector(aVar);
    }

    public final void injectMembers(PostDetailViewImpl postDetailViewImpl) {
        injectMAppUtils(postDetailViewImpl, this.mAppUtilsProvider.get());
    }

    public static void injectMAppUtils(PostDetailViewImpl postDetailViewImpl, AppUtils appUtils) {
        postDetailViewImpl.mAppUtils = appUtils;
    }
}
