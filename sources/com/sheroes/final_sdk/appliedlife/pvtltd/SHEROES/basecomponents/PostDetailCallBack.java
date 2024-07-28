package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents;

import android.widget.TextView;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.UserPostSolrObj;

public interface PostDetailCallBack {
    void loadMoreComments();

    void onCommentButtonClicked();

    void onLikeCountClicked(UserPostSolrObj userPostSolrObj);

    void onPostImageClicked(UserPostSolrObj userPostSolrObj);

    void onPostLikeClicked(UserPostSolrObj userPostSolrObj);

    void onPostMenuClicked(UserPostSolrObj userPostSolrObj, TextView textView);

    void onPostUnLikeClicked(UserPostSolrObj userPostSolrObj);

    void onShareButtonClicked(UserPostSolrObj userPostSolrObj, TextView textView);

    void onSpamApprovedClicked(UserPostSolrObj userPostSolrObj, TextView textView);

    void onSpamMenuClicked(UserPostSolrObj userPostSolrObj, TextView textView);

    void onSpamPostDeleteClicked(UserPostSolrObj userPostSolrObj, TextView textView);
}
