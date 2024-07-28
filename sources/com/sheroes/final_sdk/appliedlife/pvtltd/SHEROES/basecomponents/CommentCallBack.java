package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents;

import android.widget.ImageView;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.comment.Comment;

public interface CommentCallBack {
    void onCommentMenuClicked(Comment comment, ImageView imageView);

    void userCommentLikeRequest(Comment comment, boolean z, int i2);
}
