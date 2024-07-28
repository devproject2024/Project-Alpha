package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.viewlisteners;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseMvpView;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.comment.Comment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.comment.CommentAddDelete;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.comment.CommentReactionResponsePojo;

public interface AllCommentReactionView extends BaseMvpView {
    void commentSuccess(CommentAddDelete commentAddDelete, int i2);

    void getAllCommentsAndReactions(CommentReactionResponsePojo commentReactionResponsePojo, int i2);

    void invalidateCommentLikeUnlike(Comment comment);
}
