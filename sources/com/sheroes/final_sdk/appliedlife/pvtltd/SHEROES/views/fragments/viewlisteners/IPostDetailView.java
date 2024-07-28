package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.viewlisteners;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseMvpView;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baseresponse.BaseResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.comment.Comment;
import java.util.List;

public interface IPostDetailView extends BaseMvpView {
    void addAllPost(int i2, List<Comment> list);

    void addData(int i2, BaseResponse baseResponse);

    void addData(BaseResponse baseResponse);

    void commentFinishedLoading();

    void commentStartedLoading();

    void deleteLastComment();

    void editLastComment();

    String getStreamType();

    void hideProgressBar();

    void onPostDeleted();

    void removeData(int i2);

    void setData(int i2, BaseResponse baseResponse);

    void setHasMoreComments(boolean z);

    void showError(int i2);

    void showProgressBar();

    void smoothScrollToBottom();
}
