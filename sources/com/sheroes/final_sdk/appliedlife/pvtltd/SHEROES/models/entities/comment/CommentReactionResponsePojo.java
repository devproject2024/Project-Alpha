package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.comment;

import com.google.gson.a.a;
import com.google.gson.a.c;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baseresponse.BaseResponse;
import java.util.List;

public class CommentReactionResponsePojo extends BaseResponse {
    @c(a = "docs")
    @a
    private List<Comment> commentList = null;

    public List<Comment> getCommentList() {
        return this.commentList;
    }

    public void setCommentList(List<Comment> list) {
        this.commentList = list;
    }
}
