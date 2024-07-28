package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.comment;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baseresponse.BaseResponse;

public class CommentAddDelete extends BaseResponse {
    @c(a = "participation_model")
    @a
    private Comment commentReactionModel = null;

    public Comment getCommentReactionModel() {
        return this.commentReactionModel;
    }

    public void setCommentReactionModel(Comment comment) {
        this.commentReactionModel = comment;
    }
}
