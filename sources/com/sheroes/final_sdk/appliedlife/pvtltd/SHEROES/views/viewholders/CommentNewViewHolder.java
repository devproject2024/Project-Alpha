package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.b;
import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseViewHolder;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.CommentCallBack;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.comment.Comment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.LoginResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.DateUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.stringutils.StringUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CircleImageView;

public class CommentNewViewHolder extends BaseViewHolder<Comment> {
    private final String TAG = CommentNewViewHolder.class.getName();
    private int authorProfileSize;
    private long mAdminId;
    private Comment mComment;
    private TextView mCommentAuthorName;
    private CommentCallBack mCommentCallback;
    private TextView mCommentLike;
    private TextView mCommentTime;
    private Context mContext;
    DateUtil mDateUtil;
    private ImageView mProfileVerfied;
    private TextView mUserComment;
    private ImageView mUserCommentListMenu;
    private CircleImageView mUserProfilePic;
    Preference<LoginResponse> userPreference;

    private void onCommentWithNameClick() {
    }

    public void viewRecycled() {
    }

    public CommentNewViewHolder(View view, CommentCallBack commentCallBack) {
        super(view);
        this.mProfileVerfied = (ImageView) view.findViewById(R.id.sheroes_profile_verified);
        this.mUserProfilePic = (CircleImageView) view.findViewById(R.id.sheroes_user_profile_pic);
        this.mUserComment = (TextView) view.findViewById(R.id.sheroes_tv_list_user_comment);
        this.mUserComment.setOnClickListener(this);
        this.mUserCommentListMenu = (ImageView) view.findViewById(R.id.sheroes_tv_user_comment_list_menu);
        this.mUserCommentListMenu.setOnClickListener(this);
        this.mCommentTime = (TextView) view.findViewById(R.id.sheroes_tv_list_user_comment_time);
        this.mCommentLike = (TextView) view.findViewById(R.id.sheroes_like);
        this.mCommentLike.setOnClickListener(this);
        this.mCommentAuthorName = (TextView) view.findViewById(R.id.sheroes_comment_author_name);
        this.authorProfileSize = view.getResources().getDimensionPixelSize(R.dimen.sheroes_dp_size_40);
        this.mCommentCallback = commentCallBack;
        SheroesSdk.getAppComponent(view.getContext()).inject(this);
        Preference<LoginResponse> preference = this.userPreference;
        if (preference != null && preference.isSet() && this.userPreference.get() != null && this.userPreference.get().getUserSummary() != null && this.userPreference.get().getUserSummary().getUserBO() != null) {
            this.mAdminId = (long) this.userPreference.get().getUserSummary().getUserBO().getUserTypeId();
        }
    }

    public void bindData(Comment comment, Context context, int i2) {
        this.mComment = comment;
        this.mComment.setItemPosition(i2);
        this.mContext = context;
        if (StringUtil.isNotNullOrEmptyString(this.mComment.getPostedDate())) {
            this.mCommentTime.setText(this.mComment.getPostedDate());
        } else {
            this.mCommentTime.setText(this.mContext.getString(R.string.sheroes_ID_JUST_NOW));
        }
        if (this.mComment.isMyOwnParticipation() || this.mAdminId == 2) {
            this.mUserCommentListMenu.setVisibility(0);
        } else {
            this.mUserCommentListMenu.setVisibility(8);
        }
        this.mCommentAuthorName.setText(this.mComment.getParticipantName());
        this.mUserProfilePic.setCircularImage(true);
        invalidateLikeView(comment);
        if (!((Activity) this.mContext).isFinishing()) {
            if (comment.isAnonymous() && StringUtil.isNotNullOrEmptyString(this.mComment.getParticipantName())) {
                String participantImageUrl = this.mComment.getParticipantImageUrl();
                int i3 = this.authorProfileSize;
                this.mUserProfilePic.bindImage(CommonUtil.getThumborUri(participantImageUrl, i3, i3));
                SpannableString spannableString = new SpannableString(this.mComment.getParticipantName() + ": " + this.mComment.getComment());
                int length = this.mComment.getParticipantName().length() + 1;
                spannableString.setSpan(new TypefaceSpan(this.mContext.getResources().getString(R.string.sheroes_ID_ROBOTO_REGULAR)), 0, length, 18);
                spannableString.setSpan(new ForegroundColorSpan(b.c(this.mContext, R.color.sheroes_feed_title)), 0, length, 33);
                this.mUserComment.setText(StringUtil.hashTagColorInString(this.mComment.getComment()));
                StringUtil.linkifyURLs(this.mUserComment);
            } else if (StringUtil.isNotNullOrEmptyString(this.mComment.getComment()) && StringUtil.isNotNullOrEmptyString(this.mComment.getParticipantName())) {
                String participantImageUrl2 = this.mComment.getParticipantImageUrl();
                int i4 = this.authorProfileSize;
                this.mUserProfilePic.bindImage(CommonUtil.getThumborUri(participantImageUrl2, i4, i4));
                this.mUserComment.setText(StringUtil.hashTagColorInString(this.mComment.getComment()));
                StringUtil.linkifyURLs(this.mUserComment);
                if (!this.mComment.getParticipantName().equalsIgnoreCase(this.mContext.getString(R.string.sheroes_ID_COMMUNITY_ANNONYMOUS))) {
                    if (this.mComment.isVerifiedMentor()) {
                        this.mProfileVerfied.setVisibility(0);
                        return;
                    } else {
                        this.mProfileVerfied.setVisibility(8);
                        return;
                    }
                }
            } else {
                return;
            }
            this.mProfileVerfied.setVisibility(8);
        }
    }

    private void invalidateLikeView(Comment comment) {
        if (comment.likeCount > 0) {
            this.mCommentLike.setText(Integer.toString(comment.likeCount));
        } else {
            this.mCommentLike.setText("");
        }
        if (comment.isLiked) {
            this.mCommentLike.setCompoundDrawablesWithIntrinsicBounds(R.drawable.vector_sheroes_likes_heart, 0, 0, 0);
        } else {
            this.mCommentLike.setCompoundDrawablesWithIntrinsicBounds(R.drawable.vector_sheroes_likes_heart_in_active, 0, 0, 0);
        }
    }

    private void onCommentMenuClick() {
        this.mComment.setItemPosition(getAdapterPosition());
        this.mCommentCallback.onCommentMenuClicked(this.mComment, this.mUserCommentListMenu);
    }

    private void onCommentLikeClicked() {
        if (this.mComment.isLiked) {
            this.mCommentCallback.userCommentLikeRequest(this.mComment, false, getAdapterPosition());
        } else {
            this.mCommentCallback.userCommentLikeRequest(this.mComment, true, getAdapterPosition());
        }
        if (this.mComment.isLiked) {
            Comment comment = this.mComment;
            comment.isLiked = false;
            comment.likeCount--;
        } else {
            Comment comment2 = this.mComment;
            comment2.isLiked = true;
            comment2.likeCount++;
        }
        invalidateLikeView(this.mComment);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.sheroes_like) {
            onCommentLikeClicked();
        }
        if (id == R.id.sheroes_tv_list_user_comment) {
            onCommentWithNameClick();
        }
        if (id == R.id.sheroes_tv_user_comment_list_menu) {
            onCommentMenuClick();
        }
    }
}
