package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters;

import android.content.Context;
import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BasePresenter;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.enums.FeedParticipationEnum;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.Configuration;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.HomeModel;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.AllCommunitiesResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.MyCommunityRequest;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.LoginResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.networkutills.NetworkUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.viewlisteners.IPostBottomSheetView;
import io.reactivex.rxjava3.g.c;

public class PostBottomSheetPresenter extends BasePresenter<IPostBottomSheetView> {
    private final String TAG = PostBottomSheetPresenter.class.getName();
    Preference<AllCommunitiesResponse> mAllCommunities;
    Preference<Configuration> mConfiguration;
    HomeModel mHomeModel;
    Context mSheroesApplication;
    Preference<LoginResponse> mUserPreference;

    public PostBottomSheetPresenter(HomeModel homeModel, Context context, Preference<LoginResponse> preference, Preference<Configuration> preference2) {
        this.mHomeModel = homeModel;
        this.mSheroesApplication = context;
        this.mUserPreference = preference;
        this.mConfiguration = preference2;
    }

    public void detachView() {
        super.detachView();
    }

    public boolean isViewAttached() {
        return super.isViewAttached();
    }

    public void getAllCommunities(MyCommunityRequest myCommunityRequest) {
        if (!NetworkUtil.isConnected(this.mSheroesApplication)) {
            ((IPostBottomSheetView) getMvpView()).showError(AppConstants.CHECK_NETWORK_CONNECTION, FeedParticipationEnum.ERROR_MY_COMMUNITIES);
            return;
        }
        ((IPostBottomSheetView) getMvpView()).startProgressBar();
        this.mHomeModel.getAllCommunityFromModel(myCommunityRequest).compose(bindToLifecycle()).subscribe(new c<AllCommunitiesResponse>() {
            public void onComplete() {
                ((IPostBottomSheetView) PostBottomSheetPresenter.this.getMvpView()).stopProgressBar();
            }

            public void onError(Throwable th) {
                ((IPostBottomSheetView) PostBottomSheetPresenter.this.getMvpView()).stopProgressBar();
                ((IPostBottomSheetView) PostBottomSheetPresenter.this.getMvpView()).showError(PostBottomSheetPresenter.this.mSheroesApplication.getString(R.string.sheroes_ID_GENERIC_ERROR), FeedParticipationEnum.ERROR_MY_COMMUNITIES);
            }

            public void onNext(AllCommunitiesResponse allCommunitiesResponse) {
                ((IPostBottomSheetView) PostBottomSheetPresenter.this.getMvpView()).stopProgressBar();
                if (allCommunitiesResponse != null) {
                    PostBottomSheetPresenter.this.mAllCommunities.set(allCommunitiesResponse);
                }
            }
        });
    }

    public void onStop() {
        detachView();
    }
}
