package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters;

import android.content.Context;
import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BasePresenter;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.SheroesAppServiceApi;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.enums.FeedParticipationEnum;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.comment.CommentReactionRequestPojo;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.comment.CommentReactionResponsePojo;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.networkutills.NetworkUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.viewlisteners.IUserLikedListView;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.g.c;
import io.reactivex.rxjava3.i.a;
import java.util.ArrayList;

public class UserLikedListPresenterImpl extends BasePresenter<IUserLikedListView> {
    Context mSheroesApplication;
    SheroesAppServiceApi sheroesAppServiceApi;

    public UserLikedListPresenterImpl(Context context, SheroesAppServiceApi sheroesAppServiceApi2) {
        this.mSheroesApplication = context;
        this.sheroesAppServiceApi = sheroesAppServiceApi2;
    }

    public void getUserLikedList(CommentReactionRequestPojo commentReactionRequestPojo, boolean z, int i2) {
        if (!NetworkUtil.isConnected(this.mSheroesApplication)) {
            ((IUserLikedListView) getMvpView()).showError(AppConstants.CHECK_NETWORK_CONNECTION, FeedParticipationEnum.ERROR_COMMENT_REACTION);
            return;
        }
        ((IUserLikedListView) getMvpView()).startProgressBar();
        getAllCommentListFromModel(commentReactionRequestPojo, z).compose(bindToLifecycle()).subscribe(new c<CommentReactionResponsePojo>() {
            public void onComplete() {
                ((IUserLikedListView) UserLikedListPresenterImpl.this.getMvpView()).stopProgressBar();
            }

            public void onError(Throwable th) {
                ((IUserLikedListView) UserLikedListPresenterImpl.this.getMvpView()).stopProgressBar();
                ((IUserLikedListView) UserLikedListPresenterImpl.this.getMvpView()).showError(UserLikedListPresenterImpl.this.mSheroesApplication.getString(R.string.sheroes_ID_SERVER_PROBLEM), FeedParticipationEnum.ERROR_COMMENT_REACTION);
            }

            public void onNext(CommentReactionResponsePojo commentReactionResponsePojo) {
                ((IUserLikedListView) UserLikedListPresenterImpl.this.getMvpView()).stopProgressBar();
                new ArrayList();
                ((IUserLikedListView) UserLikedListPresenterImpl.this.getMvpView()).showUserLikedList(commentReactionResponsePojo.getCommentList());
            }
        });
    }

    public p<CommentReactionResponsePojo> getAllCommentListFromModel(CommentReactionRequestPojo commentReactionRequestPojo, boolean z) {
        if (!z) {
            return this.sheroesAppServiceApi.getCommentFromApi(commentReactionRequestPojo).map(new h<CommentReactionResponsePojo, CommentReactionResponsePojo>() {
                public CommentReactionResponsePojo apply(CommentReactionResponsePojo commentReactionResponsePojo) {
                    return commentReactionResponsePojo;
                }
            }).subscribeOn(a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a());
        }
        return this.sheroesAppServiceApi.getAllReactionFromApi(commentReactionRequestPojo).map(new h<CommentReactionResponsePojo, CommentReactionResponsePojo>() {
            public CommentReactionResponsePojo apply(CommentReactionResponsePojo commentReactionResponsePojo) {
                return commentReactionResponsePojo;
            }
        }).subscribeOn(a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a());
    }
}
