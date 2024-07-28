package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.viewlisteners;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseMvpView;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.comment.Comment;
import java.util.List;

public interface IUserLikedListView extends BaseMvpView {
    void showUserLikedList(List<Comment> list);
}
