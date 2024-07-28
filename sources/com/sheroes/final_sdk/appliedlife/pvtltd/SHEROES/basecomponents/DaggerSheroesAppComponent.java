package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents;

import android.content.Context;
import com.google.gson.f;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.AppInstallation;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.AppInstallationHelper;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.AppInstallationHelper_MembersInjector;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.AppInstallationModel;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.AppInstallationModel_Factory;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.BranchModel;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.BranchModel_Factory;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.CommunityModel;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.Configuration;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.HomeModel;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.HomeModel_Factory;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.AllCommunitiesResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.InstallUpdateForMoEngage;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.LoginHelper;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.LoginHelper_MembersInjector;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.LoginModel;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.LoginModel_Factory;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.LoginResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.RxSharedPreferences;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters.AlbumPresenter;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters.CreatePostPresenter;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters.CreatePostPresenter_Factory;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters.CreatePostPresenter_MembersInjector;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters.FeedPresenter;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters.FeedPresenter_Factory;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters.FeedPresenter_MembersInjector;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters.PostBottomSheetPresenter;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters.PostBottomSheetPresenter_Factory;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters.PostBottomSheetPresenter_MembersInjector;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters.PostDetailViewImpl;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters.PostDetailViewImpl_Factory;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters.PostDetailViewImpl_MembersInjector;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters.UserLikedListPresenterImpl;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppUtils;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.DateUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.viewholder.UserPostCompactViewHolder;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.viewholder.UserPostCompactViewHolder_MembersInjector;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.AlbumActivity;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.AlbumActivity_MembersInjector;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.BranchDeepLink;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.BranchDeepLink_MembersInjector;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CollectionActivity;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity_MembersInjector;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.PostDetailActivity;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.PostDetailActivity_MembersInjector;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.FeedFragment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.FeedFragment_MembersInjector;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.LikeListBottomSheetFragment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.LikeListBottomSheetFragment_MembersInjector;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.PostBottomSheetFragment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.PostBottomSheetFragment_MembersInjector;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.ShareBottomSheetFragment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.ShareBottomSheetFragment_MembersInjector;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders.CarouselViewHolder;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders.CommentNewViewHolder;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders.CommentNewViewHolder_MembersInjector;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders.FeedCommunityPostHolder;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders.FeedCommunityPostHolder_MembersInjector;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders.FeedProgressBarHolder;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders.HomeHeaderViewHolder;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders.HomeHeaderViewHolder_MembersInjector;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders.ImageViewHolder;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders.UserPostHolder;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders.UserPostHolder_MembersInjector;
import dagger.a.b;
import dagger.a.g;
import javax.a.a;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public final class DaggerSheroesAppComponent implements SheroesAppComponent {
    private a<AppInstallationModel> appInstallationModelProvider;
    private a<BranchModel> branchModelProvider;
    private a<HomeModel> homeModelProvider;
    private a<LoginModel> loginModelProvider;
    private a<Preference<AllCommunitiesResponse>> provideAllCommunitiesProvider;
    private a<Preference<AppInstallation>> provideAppInstallationProvider;
    private a<AppUtils> provideAppUtilProvider;
    private a<Preference<Configuration>> provideConfigurationProvider;
    private a<DateUtil> provideDateUtilProvider;
    private a<f> provideGsonProvider;
    private a<Preference<InstallUpdateForMoEngage>> provideInstallUpdatePrefProvider;
    private a<Interceptor> provideInterceptorProvider;
    private a<OkHttpClient> provideOkHttpClientProvider;
    private a<RxSharedPreferences> provideRxSharedPreferencesProvider;
    private a<Retrofit> provideSheroesNetworkCallProvider;
    private a<Preference<LoginResponse>> provideTokenPrefProvider;
    private a<SheroesAppServiceApi> providesApiServiceProvider;
    private a<Context> providesApplicationProvider;

    public final void inject(AppInstallation appInstallation) {
    }

    public final void inject(CollectionActivity collectionActivity) {
    }

    public final void inject(CarouselViewHolder carouselViewHolder) {
    }

    public final void inject(FeedProgressBarHolder feedProgressBarHolder) {
    }

    public final void inject(ImageViewHolder imageViewHolder) {
    }

    private DaggerSheroesAppComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private CommunityModel getCommunityModel() {
        return new CommunityModel(this.providesApiServiceProvider.get(), this.provideGsonProvider.get());
    }

    private CreatePostPresenter getCreatePostPresenter() {
        return injectCreatePostPresenter(CreatePostPresenter_Factory.newCreatePostPresenter());
    }

    private PostBottomSheetPresenter getPostBottomSheetPresenter() {
        return injectPostBottomSheetPresenter(PostBottomSheetPresenter_Factory.newPostBottomSheetPresenter(this.homeModelProvider.get(), this.providesApplicationProvider.get(), this.provideTokenPrefProvider.get(), this.provideConfigurationProvider.get()));
    }

    private UserLikedListPresenterImpl getUserLikedListPresenterImpl() {
        return new UserLikedListPresenterImpl(this.providesApplicationProvider.get(), this.providesApiServiceProvider.get());
    }

    private PostDetailViewImpl getPostDetailViewImpl() {
        return injectPostDetailViewImpl(PostDetailViewImpl_Factory.newPostDetailViewImpl(this.providesApiServiceProvider.get(), this.providesApplicationProvider.get()));
    }

    private FeedPresenter getFeedPresenter() {
        return injectFeedPresenter(FeedPresenter_Factory.newFeedPresenter(this.homeModelProvider.get(), this.providesApplicationProvider.get(), this.provideTokenPrefProvider.get(), this.providesApiServiceProvider.get(), this.provideConfigurationProvider.get()));
    }

    private void initialize(Builder builder) {
        this.provideDateUtilProvider = b.a(SheroesAppModule_ProvideDateUtilFactory.create(builder.sheroesAppModule));
        this.provideRxSharedPreferencesProvider = b.a(SheroesAppModule_ProvideRxSharedPreferencesFactory.create(builder.sheroesAppModule));
        this.provideGsonProvider = b.a(SheroesAppModule_ProvideGsonFactory.create(builder.sheroesAppModule));
        this.provideTokenPrefProvider = b.a(SheroesAppModule_ProvideTokenPrefFactory.create(builder.sheroesAppModule, this.provideRxSharedPreferencesProvider, this.provideGsonProvider));
        this.provideConfigurationProvider = b.a(SheroesAppModule_ProvideConfigurationFactory.create(builder.sheroesAppModule, this.provideRxSharedPreferencesProvider, this.provideGsonProvider));
        this.provideInstallUpdatePrefProvider = b.a(SheroesAppModule_ProvideInstallUpdatePrefFactory.create(builder.sheroesAppModule, this.provideRxSharedPreferencesProvider, this.provideGsonProvider));
        this.provideInterceptorProvider = b.a(SheroesAppModule_ProvideInterceptorFactory.create(builder.sheroesAppModule, this.provideTokenPrefProvider));
        this.provideOkHttpClientProvider = b.a(SheroesAppModule_ProvideOkHttpClientFactory.create(builder.sheroesAppModule, this.provideInterceptorProvider));
        this.provideSheroesNetworkCallProvider = b.a(SheroesAppModule_ProvideSheroesNetworkCallFactory.create(builder.sheroesAppModule, this.provideOkHttpClientProvider, this.provideGsonProvider));
        this.providesApiServiceProvider = b.a(SheroesAppModule_ProvidesApiServiceFactory.create(builder.sheroesAppModule, this.provideSheroesNetworkCallProvider));
        this.provideAppUtilProvider = b.a(SheroesAppModule_ProvideAppUtilFactory.create(builder.sheroesAppModule));
        this.homeModelProvider = b.a(HomeModel_Factory.create(this.providesApiServiceProvider, this.provideGsonProvider));
        this.providesApplicationProvider = b.a(SheroesAppModule_ProvidesApplicationFactory.create(builder.sheroesAppModule));
        this.provideAllCommunitiesProvider = b.a(SheroesAppModule_ProvideAllCommunitiesFactory.create(builder.sheroesAppModule, this.provideRxSharedPreferencesProvider, this.provideGsonProvider));
        this.provideAppInstallationProvider = b.a(SheroesAppModule_ProvideAppInstallationFactory.create(builder.sheroesAppModule, this.provideRxSharedPreferencesProvider, this.provideGsonProvider));
        this.appInstallationModelProvider = b.a(AppInstallationModel_Factory.create(this.providesApiServiceProvider, this.provideGsonProvider));
        this.loginModelProvider = b.a(LoginModel_Factory.create(this.providesApiServiceProvider, this.provideGsonProvider));
        this.branchModelProvider = b.a(BranchModel_Factory.create(this.providesApiServiceProvider, this.provideGsonProvider));
    }

    public final void inject(FeedCommunityPostHolder feedCommunityPostHolder) {
        injectFeedCommunityPostHolder(feedCommunityPostHolder);
    }

    public final void inject(AlbumActivity albumActivity) {
        injectAlbumActivity(albumActivity);
    }

    public final void inject(CommunityPostActivity communityPostActivity) {
        injectCommunityPostActivity(communityPostActivity);
    }

    public final void inject(CreatePostPresenter createPostPresenter) {
        injectCreatePostPresenter(createPostPresenter);
    }

    public final void inject(PostBottomSheetFragment postBottomSheetFragment) {
        injectPostBottomSheetFragment(postBottomSheetFragment);
    }

    public final void inject(HomeHeaderViewHolder homeHeaderViewHolder) {
        injectHomeHeaderViewHolder(homeHeaderViewHolder);
    }

    public final void inject(LikeListBottomSheetFragment likeListBottomSheetFragment) {
        injectLikeListBottomSheetFragment(likeListBottomSheetFragment);
    }

    public final void inject(PostDetailActivity postDetailActivity) {
        injectPostDetailActivity(postDetailActivity);
    }

    public final void inject(UserPostHolder userPostHolder) {
        injectUserPostHolder(userPostHolder);
    }

    public final void inject(CommentNewViewHolder commentNewViewHolder) {
        injectCommentNewViewHolder(commentNewViewHolder);
    }

    public final void inject(FeedFragment feedFragment) {
        injectFeedFragment(feedFragment);
    }

    public final void inject(ShareBottomSheetFragment shareBottomSheetFragment) {
        injectShareBottomSheetFragment(shareBottomSheetFragment);
    }

    public final void inject(UserPostCompactViewHolder userPostCompactViewHolder) {
        injectUserPostCompactViewHolder(userPostCompactViewHolder);
    }

    public final void inject(AppInstallationHelper appInstallationHelper) {
        injectAppInstallationHelper(appInstallationHelper);
    }

    public final void inject(LoginHelper loginHelper) {
        injectLoginHelper(loginHelper);
    }

    public final void inject(BranchDeepLink branchDeepLink) {
        injectBranchDeepLink(branchDeepLink);
    }

    private FeedCommunityPostHolder injectFeedCommunityPostHolder(FeedCommunityPostHolder feedCommunityPostHolder) {
        FeedCommunityPostHolder_MembersInjector.injectMDateUtil(feedCommunityPostHolder, this.provideDateUtilProvider.get());
        FeedCommunityPostHolder_MembersInjector.injectUserPreference(feedCommunityPostHolder, this.provideTokenPrefProvider.get());
        FeedCommunityPostHolder_MembersInjector.injectMConfiguration(feedCommunityPostHolder, this.provideConfigurationProvider.get());
        FeedCommunityPostHolder_MembersInjector.injectMInstallUpdatePreference(feedCommunityPostHolder, this.provideInstallUpdatePrefProvider.get());
        return feedCommunityPostHolder;
    }

    private AlbumActivity injectAlbumActivity(AlbumActivity albumActivity) {
        AlbumActivity_MembersInjector.injectMAlbumPresenter(albumActivity, new AlbumPresenter());
        return albumActivity;
    }

    private CreatePostPresenter injectCreatePostPresenter(CreatePostPresenter createPostPresenter) {
        CreatePostPresenter_MembersInjector.injectCommunityModel(createPostPresenter, getCommunityModel());
        return createPostPresenter;
    }

    private CommunityPostActivity injectCommunityPostActivity(CommunityPostActivity communityPostActivity) {
        CommunityPostActivity_MembersInjector.injectMUserPreference(communityPostActivity, this.provideTokenPrefProvider.get());
        CommunityPostActivity_MembersInjector.injectMCreatePostPresenter(communityPostActivity, getCreatePostPresenter());
        CommunityPostActivity_MembersInjector.injectMAppUtils(communityPostActivity, this.provideAppUtilProvider.get());
        CommunityPostActivity_MembersInjector.injectMConfiguration(communityPostActivity, this.provideConfigurationProvider.get());
        return communityPostActivity;
    }

    private PostBottomSheetPresenter injectPostBottomSheetPresenter(PostBottomSheetPresenter postBottomSheetPresenter) {
        PostBottomSheetPresenter_MembersInjector.injectMUserPreference(postBottomSheetPresenter, this.provideTokenPrefProvider.get());
        PostBottomSheetPresenter_MembersInjector.injectMAllCommunities(postBottomSheetPresenter, this.provideAllCommunitiesProvider.get());
        PostBottomSheetPresenter_MembersInjector.injectMConfiguration(postBottomSheetPresenter, this.provideConfigurationProvider.get());
        return postBottomSheetPresenter;
    }

    private PostBottomSheetFragment injectPostBottomSheetFragment(PostBottomSheetFragment postBottomSheetFragment) {
        PostBottomSheetFragment_MembersInjector.injectMPostBottomSheetPresenter(postBottomSheetFragment, getPostBottomSheetPresenter());
        PostBottomSheetFragment_MembersInjector.injectMAllCommunities(postBottomSheetFragment, this.provideAllCommunitiesProvider.get());
        return postBottomSheetFragment;
    }

    private HomeHeaderViewHolder injectHomeHeaderViewHolder(HomeHeaderViewHolder homeHeaderViewHolder) {
        HomeHeaderViewHolder_MembersInjector.injectUserPreference(homeHeaderViewHolder, this.provideTokenPrefProvider.get());
        HomeHeaderViewHolder_MembersInjector.injectMConfiguration(homeHeaderViewHolder, this.provideConfigurationProvider.get());
        return homeHeaderViewHolder;
    }

    private LikeListBottomSheetFragment injectLikeListBottomSheetFragment(LikeListBottomSheetFragment likeListBottomSheetFragment) {
        LikeListBottomSheetFragment_MembersInjector.injectMUserLikedListPresenter(likeListBottomSheetFragment, getUserLikedListPresenterImpl());
        return likeListBottomSheetFragment;
    }

    private PostDetailViewImpl injectPostDetailViewImpl(PostDetailViewImpl postDetailViewImpl) {
        PostDetailViewImpl_MembersInjector.injectMAppUtils(postDetailViewImpl, this.provideAppUtilProvider.get());
        return postDetailViewImpl;
    }

    private PostDetailActivity injectPostDetailActivity(PostDetailActivity postDetailActivity) {
        PostDetailActivity_MembersInjector.injectMUserPreference(postDetailActivity, this.provideTokenPrefProvider.get());
        PostDetailActivity_MembersInjector.injectMConfiguration(postDetailActivity, this.provideConfigurationProvider.get());
        PostDetailActivity_MembersInjector.injectMAppUtils(postDetailActivity, this.provideAppUtilProvider.get());
        PostDetailActivity_MembersInjector.injectMPostDetailPresenter(postDetailActivity, getPostDetailViewImpl());
        return postDetailActivity;
    }

    private UserPostHolder injectUserPostHolder(UserPostHolder userPostHolder) {
        UserPostHolder_MembersInjector.injectMDateUtil(userPostHolder, this.provideDateUtilProvider.get());
        UserPostHolder_MembersInjector.injectUserPreference(userPostHolder, this.provideTokenPrefProvider.get());
        UserPostHolder_MembersInjector.injectMConfiguration(userPostHolder, this.provideConfigurationProvider.get());
        return userPostHolder;
    }

    private CommentNewViewHolder injectCommentNewViewHolder(CommentNewViewHolder commentNewViewHolder) {
        CommentNewViewHolder_MembersInjector.injectMDateUtil(commentNewViewHolder, this.provideDateUtilProvider.get());
        CommentNewViewHolder_MembersInjector.injectUserPreference(commentNewViewHolder, this.provideTokenPrefProvider.get());
        return commentNewViewHolder;
    }

    private FeedPresenter injectFeedPresenter(FeedPresenter feedPresenter) {
        FeedPresenter_MembersInjector.injectMAllCommunities(feedPresenter, this.provideAllCommunitiesProvider.get());
        FeedPresenter_MembersInjector.injectMConfiguration(feedPresenter, this.provideConfigurationProvider.get());
        return feedPresenter;
    }

    private FeedFragment injectFeedFragment(FeedFragment feedFragment) {
        BaseFragment_MembersInjector.injectUserPreference(feedFragment, this.provideTokenPrefProvider.get());
        FeedFragment_MembersInjector.injectMAppUtils(feedFragment, this.provideAppUtilProvider.get());
        FeedFragment_MembersInjector.injectMFeedPresenter(feedFragment, getFeedPresenter());
        FeedFragment_MembersInjector.injectMUserPreference(feedFragment, this.provideTokenPrefProvider.get());
        FeedFragment_MembersInjector.injectMConfiguration(feedFragment, this.provideConfigurationProvider.get());
        return feedFragment;
    }

    private ShareBottomSheetFragment injectShareBottomSheetFragment(ShareBottomSheetFragment shareBottomSheetFragment) {
        ShareBottomSheetFragment_MembersInjector.injectMConfiguration(shareBottomSheetFragment, this.provideConfigurationProvider.get());
        return shareBottomSheetFragment;
    }

    private UserPostCompactViewHolder injectUserPostCompactViewHolder(UserPostCompactViewHolder userPostCompactViewHolder) {
        UserPostCompactViewHolder_MembersInjector.injectMDateUtil(userPostCompactViewHolder, this.provideDateUtilProvider.get());
        UserPostCompactViewHolder_MembersInjector.injectUserPreference(userPostCompactViewHolder, this.provideTokenPrefProvider.get());
        UserPostCompactViewHolder_MembersInjector.injectMConfiguration(userPostCompactViewHolder, this.provideConfigurationProvider.get());
        return userPostCompactViewHolder;
    }

    private AppInstallationHelper injectAppInstallationHelper(AppInstallationHelper appInstallationHelper) {
        AppInstallationHelper_MembersInjector.injectMAppInstallationPref(appInstallationHelper, this.provideAppInstallationProvider.get());
        AppInstallationHelper_MembersInjector.injectMLoginResponse(appInstallationHelper, this.provideTokenPrefProvider.get());
        AppInstallationHelper_MembersInjector.injectAppInstallationModel(appInstallationHelper, this.appInstallationModelProvider.get());
        return appInstallationHelper;
    }

    private LoginHelper injectLoginHelper(LoginHelper loginHelper) {
        LoginHelper_MembersInjector.injectMLoginResponse(loginHelper, this.provideTokenPrefProvider.get());
        LoginHelper_MembersInjector.injectMLoginModel(loginHelper, this.loginModelProvider.get());
        LoginHelper_MembersInjector.injectMAppInstallation(loginHelper, this.provideAppInstallationProvider.get());
        LoginHelper_MembersInjector.injectAllCommunitiesResponsePreference(loginHelper, this.provideAllCommunitiesProvider.get());
        LoginHelper_MembersInjector.injectConfigurationPreference(loginHelper, this.provideConfigurationProvider.get());
        return loginHelper;
    }

    private BranchDeepLink injectBranchDeepLink(BranchDeepLink branchDeepLink) {
        BranchDeepLink_MembersInjector.injectMBranchModel(branchDeepLink, this.branchModelProvider.get());
        return branchDeepLink;
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public SheroesAppModule sheroesAppModule;

        private Builder() {
        }

        public final SheroesAppComponent build() {
            if (this.sheroesAppModule != null) {
                return new DaggerSheroesAppComponent(this);
            }
            throw new IllegalStateException(SheroesAppModule.class.getCanonicalName() + " must be set");
        }

        public final Builder sheroesAppModule(SheroesAppModule sheroesAppModule2) {
            this.sheroesAppModule = (SheroesAppModule) g.a(sheroesAppModule2);
            return this;
        }
    }
}
