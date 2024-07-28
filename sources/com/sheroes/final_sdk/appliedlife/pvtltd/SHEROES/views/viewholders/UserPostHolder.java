package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.b;
import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseViewHolder;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.PostDetailCallBack;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.Configuration;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.FeedDetail;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.UserPostSolrObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.LoginResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.Bamboo;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.DateUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.stringutils.StringUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CircleImageView;
import com.squareup.picasso.af;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.List;

public class UserPostHolder extends BaseViewHolder<FeedDetail> {
    private static final int COMMUNITY_TYPE_ID = 15;
    private final String TAG = UserPostHolder.class.getName();
    private int authorPicIconSize;
    private FrameLayout flSpamPostUi;
    /* access modifiers changed from: private */
    public FrameLayout fmImageThumb;
    /* access modifiers changed from: private */
    public ImageView ivLinkThumbnail;
    /* access modifiers changed from: private */
    public ImageView ivPlay;
    private LinearLayout liApproveDelete;
    private LinearLayout liViewLinkRender;
    private int mAdminId;
    private CircleImageView mAuthorIcon;
    private ImageView mAuthorVerifiedIcon;
    private TextView mCommentButtonText;
    private TextView mCommentsCount;
    Preference<Configuration> mConfiguration;
    private Context mContext;
    DateUtil mDateUtil;
    private TextView mLikeButtonText;
    private RelativeLayout mLikeCommentCountCointainer;
    private TextView mLikeHeartIconForCount;
    private TextView mLikesCount;
    private TextView mPostDescription;
    private PostDetailCallBack mPostDetailCallback;
    private TextView mPostMenu;
    private TextView mPostTime;
    private TextView mShare;
    private TextView mTitle;
    private long mUserId;
    /* access modifiers changed from: private */
    public UserPostSolrObj mUserPostObj;
    /* access modifiers changed from: private */
    public ProgressBar pbLink;
    private RelativeLayout topPostView;
    private TextView tvApproveSpamPost;
    private TextView tvDeleteSpamPost;
    private TextView tvLinkSubTitle;
    private TextView tvLinkTitle;
    private TextView tvReviewDescription;
    private TextView tvSpamPostMenu;
    private LinearLayout userPostImages;
    Preference<LoginResponse> userPreference;
    private LinearLayout viewContainer;

    private void onReviewDescriptionClick() {
    }

    public void viewRecycled() {
    }

    public UserPostHolder(View view, PostDetailCallBack postDetailCallBack) {
        super(view);
        this.mPostDetailCallback = postDetailCallBack;
        this.viewContainer = (LinearLayout) view.findViewById(R.id.sheroes_view_container);
        this.topPostView = (RelativeLayout) view.findViewById(R.id.sheroes_top_post_view);
        this.mAuthorIcon = (CircleImageView) view.findViewById(R.id.sheroes_author_pic_icon);
        this.mAuthorVerifiedIcon = (ImageView) view.findViewById(R.id.sheroes_author_verified_icon);
        this.mTitle = (TextView) view.findViewById(R.id.sheroes_title);
        this.mPostTime = (TextView) view.findViewById(R.id.sheroes_post_time);
        this.mPostMenu = (TextView) view.findViewById(R.id.sheroes_post_menu);
        this.mPostMenu.setOnClickListener(this);
        this.mPostDescription = (TextView) view.findViewById(R.id.sheroes_description);
        this.liViewLinkRender = (LinearLayout) view.findViewById(R.id.sheroes_li_post_link_render);
        this.liViewLinkRender.setOnClickListener(this);
        this.fmImageThumb = (FrameLayout) view.findViewById(R.id.sheroes_fm_image_thumb);
        this.ivLinkThumbnail = (ImageView) view.findViewById(R.id.sheroes_iv_post_link_thumbnail);
        this.ivPlay = (ImageView) view.findViewById(R.id.sheroes_iv_play);
        this.pbLink = (ProgressBar) view.findViewById(R.id.sheroes_progress_bar_post_link);
        this.tvLinkTitle = (TextView) view.findViewById(R.id.sheroes_tv_post_link_title);
        this.tvLinkSubTitle = (TextView) view.findViewById(R.id.sheroes_tv_post_link_sub_title);
        this.userPostImages = (LinearLayout) view.findViewById(R.id.sheroes_user_post_images);
        this.userPostImages.setOnClickListener(this);
        this.mLikeCommentCountCointainer = (RelativeLayout) view.findViewById(R.id.sheroes_like_comment_count_view);
        this.mLikeHeartIconForCount = (TextView) view.findViewById(R.id.sheroes_like_heart_icon);
        this.mLikesCount = (TextView) view.findViewById(R.id.sheroes_likes_count);
        this.mLikesCount.setOnClickListener(this);
        this.mLikeButtonText = (TextView) view.findViewById(R.id.sheroes_like_button);
        this.mLikeButtonText.setOnClickListener(this);
        this.mCommentsCount = (TextView) view.findViewById(R.id.sheroes_comment_counts);
        this.mCommentButtonText = (TextView) view.findViewById(R.id.sheroes_comment_button);
        this.mCommentButtonText.setOnClickListener(this);
        this.mShare = (TextView) view.findViewById(R.id.sheroes_share_button);
        this.mShare.setOnClickListener(this);
        this.flSpamPostUi = (FrameLayout) view.findViewById(R.id.sheroes_fl_spam_post_ui);
        this.flSpamPostUi.setOnClickListener(this);
        this.tvReviewDescription = (TextView) view.findViewById(R.id.sheroes_tv_review_description);
        this.liApproveDelete = (LinearLayout) view.findViewById(R.id.sheroes_li_approve_delete);
        this.tvSpamPostMenu = (TextView) view.findViewById(R.id.sheroes_tv_spam_post_menu);
        this.tvSpamPostMenu.setOnClickListener(this);
        this.tvDeleteSpamPost = (TextView) view.findViewById(R.id.sheroes_tv_delete_spam_post);
        this.tvDeleteSpamPost.setOnClickListener(this);
        this.tvApproveSpamPost = (TextView) view.findViewById(R.id.sheroes_tv_approve_spam_post);
        this.tvApproveSpamPost.setOnClickListener(this);
        this.authorPicIconSize = view.getResources().getDimensionPixelSize(R.dimen.sheroes_dp_size_40);
        SheroesSdk.getAppComponent(view.getContext()).inject(this);
        Preference<LoginResponse> preference = this.userPreference;
        if (preference != null && preference.isSet() && this.userPreference.get() != null && this.userPreference.get().getUserSummary() != null) {
            this.mUserId = this.userPreference.get().getUserSummary().getUserId().longValue();
            if (this.userPreference.get().getUserSummary().getUserBO() != null) {
                this.mAdminId = this.userPreference.get().getUserSummary().getUserBO().getUserTypeId();
            }
        }
    }

    public void bindData(FeedDetail feedDetail, Context context, int i2) {
        this.mUserPostObj = (UserPostSolrObj) feedDetail;
        this.mContext = context;
        if (this.mUserPostObj.isTopPost()) {
            this.topPostView.setVisibility(0);
        } else {
            this.topPostView.setVisibility(8);
        }
        this.mUserPostObj.setItemPosition(i2);
        normalCommunityPostUi(this.mUserId, this.mAdminId);
        if (this.mUserPostObj.isSpamPost()) {
            handlingSpamUi(this.mUserId, this.mAdminId);
            return;
        }
        this.viewContainer.setBackgroundColor(b.c(this.mContext, R.color.sheroes_white));
        this.viewContainer.setAlpha(1.0f);
        this.flSpamPostUi.setVisibility(8);
        this.liApproveDelete.setVisibility(8);
        this.tvReviewDescription.setVisibility(0);
    }

    private void normalCommunityPostUi(long j, int i2) {
        this.viewContainer.setVisibility(0);
        this.mLikeButtonText.setTag(Boolean.TRUE);
        UserPostSolrObj userPostSolrObj = this.mUserPostObj;
        userPostSolrObj.setLastReactionValue(userPostSolrObj.getReactionValue());
        imageOperations(this.mContext);
        if (StringUtil.isNotNullOrEmptyString(this.mUserPostObj.getOgRequestedUrlS())) {
            this.userPostImages.removeAllViews();
            this.userPostImages.removeAllViewsInLayout();
            this.userPostImages.setVisibility(8);
            this.liViewLinkRender.setVisibility(0);
            setLinkData();
        } else {
            this.liViewLinkRender.setVisibility(8);
        }
        multipleImageURLs();
        populatePostText();
        allTextViewStringOperations(this.mContext);
        likeCommentOps();
        this.mPostMenu.setVisibility(0);
    }

    private void tvLinkClick() {
        UserPostSolrObj userPostSolrObj = this.mUserPostObj;
        if (userPostSolrObj != null) {
            this.mContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(userPostSolrObj.getOgRequestedUrlS())));
        }
    }

    private void setLinkData() {
        if (StringUtil.isNotNullOrEmptyString(this.mUserPostObj.getOgTitleS())) {
            this.tvLinkTitle.setText(this.mUserPostObj.getOgTitleS());
        }
        if (StringUtil.isNotNullOrEmptyString(this.mUserPostObj.getOgDescriptionS())) {
            this.tvLinkSubTitle.setText(this.mUserPostObj.getOgDescriptionS());
        }
        if (StringUtil.isNotNullOrEmptyString(this.mUserPostObj.getOgImageUrlS())) {
            AnonymousClass1 r0 = new af() {
                public void onBitmapFailed(Exception exc, Drawable drawable) {
                }

                public void onPrepareLoad(Drawable drawable) {
                }

                public void onBitmapLoaded(Bitmap bitmap, w.d dVar) {
                    UserPostHolder.this.fmImageThumb.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                    UserPostHolder.this.ivLinkThumbnail.setVisibility(0);
                    UserPostHolder.this.ivLinkThumbnail.setImageBitmap(bitmap);
                    UserPostHolder.this.pbLink.setVisibility(8);
                    if (UserPostHolder.this.mUserPostObj.isOgVideoLinkB()) {
                        UserPostHolder.this.ivPlay.setVisibility(0);
                    } else {
                        UserPostHolder.this.ivPlay.setVisibility(8);
                    }
                }
            };
            this.ivLinkThumbnail.setTag(r0);
            w.a().a(this.mUserPostObj.getOgImageUrlS()).a((af) r0);
            this.liViewLinkRender.setVisibility(0);
            return;
        }
        this.liViewLinkRender.setVisibility(8);
    }

    private void multipleImageURLs() {
        this.mPostDescription.setVisibility(0);
        if (StringUtil.isNotEmptyCollection(this.mUserPostObj.getImageUrls())) {
            this.userPostImages.setVisibility(0);
            List<String> imageUrls = this.mUserPostObj.getImageUrls();
            int size = imageUrls.size();
            if (size <= 0) {
                return;
            }
            if (size == 1) {
                this.userPostImages.removeAllViews();
                this.userPostImages.removeAllViewsInLayout();
                if (StringUtil.isNotEmptyCollection(imageUrls) && StringUtil.isNotNullOrEmptyString(imageUrls.get(0))) {
                    feedAlbum(this.mContext, imageUrls.get(0), (String) null, (String) null, 1);
                }
            } else if (size == 2) {
                this.userPostImages.removeAllViews();
                this.userPostImages.removeAllViewsInLayout();
                if (StringUtil.isNotEmptyCollection(imageUrls) && StringUtil.isNotNullOrEmptyString(imageUrls.get(0)) && StringUtil.isNotNullOrEmptyString(imageUrls.get(1))) {
                    feedAlbum(this.mContext, imageUrls.get(0), imageUrls.get(1), (String) null, 2);
                }
            } else if (size == 3) {
                this.userPostImages.removeAllViews();
                this.userPostImages.removeAllViewsInLayout();
                if (StringUtil.isNotEmptyCollection(imageUrls) && StringUtil.isNotNullOrEmptyString(imageUrls.get(0)) && StringUtil.isNotNullOrEmptyString(imageUrls.get(1)) && StringUtil.isNotNullOrEmptyString(imageUrls.get(2))) {
                    feedAlbum(this.mContext, imageUrls.get(0), imageUrls.get(1), imageUrls.get(2), 3);
                }
            } else if (size != 4) {
                this.userPostImages.removeAllViews();
                this.userPostImages.removeAllViewsInLayout();
                if (StringUtil.isNotEmptyCollection(imageUrls) && StringUtil.isNotNullOrEmptyString(imageUrls.get(0)) && StringUtil.isNotNullOrEmptyString(imageUrls.get(1)) && StringUtil.isNotNullOrEmptyString(imageUrls.get(2)) && StringUtil.isNotNullOrEmptyString(imageUrls.get(3))) {
                    feedAlbum(this.mContext, imageUrls.get(0), imageUrls.get(1), imageUrls.get(2), size);
                }
            } else {
                this.userPostImages.removeAllViews();
                this.userPostImages.removeAllViewsInLayout();
                if (StringUtil.isNotEmptyCollection(imageUrls) && StringUtil.isNotNullOrEmptyString(imageUrls.get(0)) && StringUtil.isNotNullOrEmptyString(imageUrls.get(1)) && StringUtil.isNotNullOrEmptyString(imageUrls.get(2)) && StringUtil.isNotNullOrEmptyString(imageUrls.get(3))) {
                    feedAlbum(this.mContext, imageUrls.get(0), imageUrls.get(1), imageUrls.get(2), 4);
                }
            }
        } else {
            this.userPostImages.removeAllViews();
            this.userPostImages.removeAllViewsInLayout();
            this.userPostImages.setVisibility(8);
        }
    }

    private void allTextViewStringOperations(Context context) {
        String str;
        if (StringUtil.isNotNullOrEmptyString(this.mUserPostObj.getAuthorName())) {
            StringBuilder sb = new StringBuilder();
            String authorName = this.mUserPostObj.getAuthorName();
            String challengeAcceptPostTextS = this.mUserPostObj.getChallengeAcceptPostTextS() == null ? "" : this.mUserPostObj.getChallengeAcceptPostTextS();
            if (this.mUserPostObj.communityId.longValue() == 0) {
                str = challengeAcceptPostTextS + " Challenge";
            } else {
                str = this.mUserPostObj.getPostCommunityName();
            }
            if (StringUtil.isNotNullOrEmptyString(authorName)) {
                if (authorName.equalsIgnoreCase(this.mContext.getString(R.string.sheroes_ID_COMMUNITY_ANNONYMOUS))) {
                    this.mAuthorVerifiedIcon.setVisibility(8);
                } else if (this.mUserPostObj.isAuthorMentor()) {
                    this.mAuthorVerifiedIcon.setVisibility(0);
                } else {
                    this.mAuthorVerifiedIcon.setVisibility(8);
                }
                if (this.mUserPostObj.getCommunityTypeId() == 10) {
                    if (!authorName.equalsIgnoreCase(this.mContext.getString(R.string.sheroes_ID_COMMUNITY_ANNONYMOUS))) {
                        sb.append(authorName);
                        sb.append(" ");
                        sb.append(this.mContext.getString(R.string.sheroes_ID_POSTED_ASK_FEEDBACK));
                        sb.append(" ");
                        sb.append(str);
                        clickOnMentorAndCommunityName(sb.toString(), authorName, this.mContext.getString(R.string.sheroes_ID_POSTED_ASK_FEEDBACK));
                    } else {
                        String string = this.mContext.getString(R.string.sheroes_ID_ANONYMOUS);
                        sb.append(string);
                        sb.append(" ");
                        sb.append(this.mContext.getString(R.string.sheroes_ID_POSTED_ASK_FEEDBACK));
                        sb.append(" ");
                        sb.append(str);
                        clickOnMentorAndCommunityName(sb.toString(), string, this.mContext.getString(R.string.sheroes_ID_POSTED_ASK_FEEDBACK));
                    }
                } else if (this.mUserPostObj.getCommunityTypeId() == 3) {
                    if (!authorName.equalsIgnoreCase(this.mContext.getString(R.string.sheroes_ID_ADMIN))) {
                        sb.append(authorName);
                        sb.append(" ");
                        sb.append(this.mContext.getString(R.string.sheroes_ID_ASKED));
                        sb.append(" ");
                        sb.append(str);
                        clickOnMentorName(sb.toString(), authorName, this.mContext.getString(R.string.sheroes_ID_ASKED));
                    } else if (authorName.equalsIgnoreCase(this.mContext.getString(R.string.sheroes_ID_ADMIN))) {
                        String postCommunityName = this.mUserPostObj.getPostCommunityName();
                        sb.append(postCommunityName);
                        sb.append(" ");
                        sb.append(this.mContext.getString(R.string.sheroes_ID_ASKED));
                        sb.append(" ");
                        clickOnMentorName(sb.toString(), postCommunityName, this.mContext.getString(R.string.sheroes_ID_ASKED));
                    } else {
                        String string2 = this.mContext.getString(R.string.sheroes_ID_ANONYMOUS);
                        sb.append(string2);
                        sb.append(" ");
                        sb.append(this.mContext.getString(R.string.sheroes_ID_ASKED));
                        sb.append(" ");
                        sb.append(str);
                        clickOnMentorName(sb.toString(), string2, this.mContext.getString(R.string.sheroes_ID_POSTED_IN));
                    }
                } else if (!authorName.equalsIgnoreCase(this.mContext.getString(R.string.sheroes_ID_ADMIN))) {
                    sb.append(authorName);
                    sb.append(" ");
                    sb.append(this.mContext.getString(R.string.sheroes_ID_POSTED_IN));
                    sb.append(" ");
                    sb.append(str);
                    clickOnMentorAndCommunityName(sb.toString(), authorName, this.mContext.getString(R.string.sheroes_ID_POSTED_IN));
                } else if (authorName.equalsIgnoreCase(this.mContext.getString(R.string.sheroes_ID_ADMIN))) {
                    String postCommunityName2 = this.mUserPostObj.getPostCommunityName();
                    sb.append(postCommunityName2);
                    sb.append(" ");
                    sb.append(this.mContext.getString(R.string.sheroes_ID_POSTED));
                    sb.append(" ");
                    clickOnCommunityName(sb.toString(), postCommunityName2, this.mContext.getString(R.string.sheroes_ID_POSTED));
                } else {
                    String string3 = this.mContext.getString(R.string.sheroes_ID_ANONYMOUS);
                    sb.append(string3);
                    sb.append(" ");
                    sb.append(this.mContext.getString(R.string.sheroes_ID_POSTED_IN));
                    sb.append(" ");
                    sb.append(str);
                    clickOnMentorAndCommunityName(sb.toString(), string3, this.mContext.getString(R.string.sheroes_ID_POSTED_IN));
                }
            }
        }
        if (StringUtil.isNotNullOrEmptyString(this.mUserPostObj.getCreatedDate())) {
            this.mPostTime.setText(this.mDateUtil.getRoundedDifferenceInHours(System.currentTimeMillis(), this.mDateUtil.getTimeInMillis(this.mUserPostObj.getCreatedDate(), AppConstants.DATE_FORMAT)));
        } else {
            this.mPostTime.setText(this.mContext.getString(R.string.sheroes_ID_JUST_NOW));
        }
    }

    private void likeCommentOps() {
        String str;
        if (this.mUserPostObj.getNoOfLikes() <= 0 && this.mUserPostObj.getNoOfComments() <= 0) {
            this.mLikeButtonText.setCompoundDrawablesWithIntrinsicBounds(R.drawable.vector_sheroes_heart_in_active, 0, 0, 0);
            this.mLikeCommentCountCointainer.setVisibility(8);
        }
        this.mLikeHeartIconForCount.setVisibility(0);
        int noOfLikes = this.mUserPostObj.getNoOfLikes();
        if (noOfLikes == 0) {
            if (this.mUserPostObj.getNoOfComments() > 0) {
                this.mLikeCommentCountCointainer.setVisibility(0);
                this.mLikesCount.setVisibility(8);
                this.mLikeHeartIconForCount.setVisibility(4);
                this.mCommentsCount.setVisibility(0);
            } else {
                this.mLikeCommentCountCointainer.setVisibility(8);
            }
            userLike();
        } else if (noOfLikes != 1) {
            this.mLikeCommentCountCointainer.setVisibility(0);
            this.mLikesCount.setVisibility(0);
            userLike();
        } else {
            this.mLikeCommentCountCointainer.setVisibility(0);
            this.mLikesCount.setVisibility(0);
            userLike();
        }
        String quantityString = this.mContext.getResources().getQuantityString(R.plurals.numberOfLikes, this.mUserPostObj.getNoOfLikes());
        TextView textView = this.mLikesCount;
        textView.setText(String.valueOf(this.mUserPostObj.getNoOfLikes() + " " + quantityString));
        int noOfComments = this.mUserPostObj.getNoOfComments();
        if (noOfComments != 0) {
            if (noOfComments != 1) {
                this.mCommentsCount.setVisibility(0);
            } else {
                this.mCommentsCount.setVisibility(0);
            }
        } else if (this.mUserPostObj.getNoOfLikes() > 0) {
            this.mLikeCommentCountCointainer.setVisibility(0);
            this.mLikesCount.setVisibility(0);
            this.mLikeHeartIconForCount.setVisibility(0);
            this.mCommentsCount.setVisibility(4);
        } else {
            this.mLikeCommentCountCointainer.setVisibility(8);
        }
        if (this.mUserPostObj.getCommunityTypeId() == 3) {
            str = this.mContext.getResources().getQuantityString(R.plurals.numberOfAnswers, this.mUserPostObj.getNoOfComments());
        } else {
            str = this.mContext.getResources().getQuantityString(R.plurals.numberOfComments, this.mUserPostObj.getNoOfComments());
        }
        TextView textView2 = this.mCommentsCount;
        textView2.setText(String.valueOf(this.mUserPostObj.getNoOfComments() + " " + str));
    }

    private void populatePostText() {
        Preference<Configuration> preference = this.mConfiguration;
        if (preference == null || !preference.isSet() || this.mConfiguration.get() == null || this.mConfiguration.get().configData == null || !this.mConfiguration.get().configData.isWhatsAppShare) {
            this.mShare.setCompoundDrawablesWithIntrinsicBounds(b.a(this.mContext, R.drawable.vector_sheroes_share_white_out), (Drawable) null, (Drawable) null, (Drawable) null);
            this.mShare.setText(this.mContext.getString(R.string.sheroes_ID_SHARE));
            this.mShare.setTextColor(b.c(this.mContext, R.color.sheroes_recent_post_comment));
        } else {
            this.mShare.setCompoundDrawablesWithIntrinsicBounds(b.a(this.mContext, R.drawable.vector_sheroes_share_card), (Drawable) null, (Drawable) null, (Drawable) null);
            this.mShare.setText(this.mContext.getString(R.string.sheroes_ID_SHARE_ON_WHATS_APP));
            this.mShare.setTextColor(b.c(this.mContext, R.color.sheroes_share_color));
        }
        String listDescription = this.mUserPostObj.getListDescription();
        if (!StringUtil.isNotNullOrEmptyString(listDescription)) {
            this.mPostDescription.setText("");
            this.mPostDescription.setVisibility(8);
            return;
        }
        this.mPostDescription.setText(StringUtil.hashTagColorInString(listDescription));
        this.mPostDescription.setVisibility(0);
        StringUtil.linkifyURLs(this.mPostDescription);
    }

    private void userLike() {
        int reactionValue = this.mUserPostObj.getReactionValue();
        if (reactionValue == 0) {
            this.mLikeButtonText.setCompoundDrawablesWithIntrinsicBounds(R.drawable.vector_sheroes_heart_in_active, 0, 0, 0);
        } else if (reactionValue == 10) {
            this.mLikeButtonText.setCompoundDrawablesWithIntrinsicBounds(R.drawable.vector_sheroes_heart_active, 0, 0, 0);
        } else if (reactionValue != 20 && reactionValue != 30 && reactionValue != 40 && reactionValue != 50) {
            String str = this.TAG;
            Bamboo.e(str, "Case not handled on :  " + this.TAG + " " + this.mUserPostObj.getReactionValue());
        }
    }

    private void imageOperations(Context context) {
        String authorImageUrl = this.mUserPostObj.getAuthorImageUrl();
        if (StringUtil.isNotNullOrEmptyString(authorImageUrl)) {
            this.mAuthorIcon.setCircularImage(true);
            CircleImageView circleImageView = this.mAuthorIcon;
            if (circleImageView != null && CommonUtil.isValidContextForGlide(circleImageView.getContext())) {
                int i2 = this.authorPicIconSize;
                this.mAuthorIcon.bindImage(CommonUtil.getThumborUri(authorImageUrl, i2, i2));
            }
        }
    }

    private void feedAlbum(Context context, String str, String str2, String str3, int i2) {
        int i3;
        String str4;
        String str5;
        String str6 = str;
        String str7 = str2;
        int i4 = i2;
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.feed_sheroes_community_post_feed_album, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.sheroes_li_feed_album);
        double doubleValue = this.mUserPostObj.getImageRatio().get(0).doubleValue();
        if (doubleValue > 1.5d) {
            doubleValue = 1.5d;
        }
        if (CommonUtil.isNotEmpty(str2)) {
            i3 = (int) (((double) CommonUtil.getWindowWidth(this.mContext)) * 0.6666666666666666d);
        } else {
            i3 = (int) (doubleValue * ((double) CommonUtil.getWindowWidth(this.mContext)));
        }
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, i3));
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.sheroes_li_holder);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.sheroes_iv_first);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.sheroes_iv_second);
        ImageView imageView3 = (ImageView) inflate.findViewById(R.id.sheroes_iv_third);
        TextView textView = (TextView) inflate.findViewById(R.id.sheroes_tv_feed_community_more_image);
        textView.setVisibility(8);
        if (i4 == 1) {
            ((LinearLayout.LayoutParams) linearLayout2.getLayoutParams()).weight = 0.0f;
        } else if (i4 == 2) {
            ((LinearLayout.LayoutParams) imageView.getLayoutParams()).weight = 1.0f;
            ((LinearLayout.LayoutParams) imageView2.getLayoutParams()).weight = 0.0f;
        } else if (i4 != 3) {
            textView.setText(String.valueOf("+".concat(String.valueOf(i4 - 2))));
            textView.setVisibility(0);
        } else {
            ((LinearLayout.LayoutParams) linearLayout2.getLayoutParams()).weight = 1.0f;
            ((LinearLayout.LayoutParams) imageView.getLayoutParams()).weight = 2.0f;
            ((LinearLayout.LayoutParams) imageView2.getLayoutParams()).weight = 1.0f;
        }
        imageView.setOnClickListener(this);
        if (StringUtil.isNotNullOrEmptyString(str)) {
            if (i4 == 1) {
                str5 = CommonUtil.getThumborUri(str6, CommonUtil.getWindowWidth(context), i3);
            } else {
                str5 = CommonUtil.getThumborUri(str6, CommonUtil.getWindowWidth(context) / 2, i3);
            }
            w.a().a(str5).a(imageView, (e) null);
        }
        if (StringUtil.isNotNullOrEmptyString(str2)) {
            imageView2.setOnClickListener(this);
            if (i4 == 2) {
                str4 = CommonUtil.getThumborUri(str7, CommonUtil.getWindowWidth(context), i3);
            } else {
                str4 = CommonUtil.getThumborUri(str7, CommonUtil.getWindowWidth(context), i3 / 2);
            }
            w.a().a(str4).a(R.drawable.background_image_placeholder).a(imageView2, (e) null);
        }
        if (StringUtil.isNotNullOrEmptyString(str3)) {
            imageView3.setOnClickListener(this);
            w.a().a(CommonUtil.getThumborUri(str3, CommonUtil.getWindowWidth(context), i3 / 2)).a(R.drawable.background_image_placeholder).a(imageView3, (e) null);
        }
        this.userPostImages.addView(inflate);
    }

    private void communityPostImageClick() {
        this.mPostDetailCallback.onPostImageClicked(this.mUserPostObj);
    }

    private void userMenuClick() {
        if (!this.mUserPostObj.isSpamPost()) {
            this.mPostDetailCallback.onPostMenuClicked(this.mUserPostObj, this.mPostMenu);
        }
    }

    private void spamMenuClick() {
        this.mPostDetailCallback.onPostMenuClicked(this.mUserPostObj, this.tvSpamPostMenu);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.sheroes_iv_first) {
            this.mUserPostObj.setItemPosition(0);
            this.mPostDetailCallback.onPostImageClicked(this.mUserPostObj);
        }
        if (id == R.id.sheroes_iv_second) {
            this.mUserPostObj.setItemPosition(1);
            this.mPostDetailCallback.onPostImageClicked(this.mUserPostObj);
        }
        if (id == R.id.sheroes_iv_third) {
            this.mUserPostObj.setItemPosition(2);
            this.mPostDetailCallback.onPostImageClicked(this.mUserPostObj);
        }
        if (id == R.id.sheroes_share_button) {
            tvShareClick();
        }
        if (id == R.id.sheroes_like_button) {
            userReactionClick();
        }
        if (id == R.id.sheroes_fl_spam_post_ui) {
            onReviewDescriptionClick();
        }
        if (id == R.id.sheroes_tv_approve_spam_post) {
            onApproveSpamPostClick();
        }
        if (id == R.id.sheroes_tv_delete_spam_post) {
            onDeleteSpamPostClick();
        }
        if (id == R.id.sheroes_comment_button) {
            onCommentButtonClicked();
        }
        if (id == R.id.sheroes_likes_count) {
            onLikeCountClicked();
        }
        if (id == R.id.sheroes_tv_spam_post_menu) {
            spamMenuClick();
        }
        if (id == R.id.sheroes_post_menu) {
            userMenuClick();
        }
        if (id == R.id.sheroes_user_post_images) {
            communityPostImageClick();
        }
        if (id == R.id.sheroes_li_post_link_render) {
            tvLinkClick();
        }
    }

    private void tvShareClick() {
        this.mPostDetailCallback.onShareButtonClicked(this.mUserPostObj, this.mShare);
    }

    private void userReactionClick() {
        if (!((Boolean) this.mLikeButtonText.getTag()).booleanValue()) {
            return;
        }
        if (this.mUserPostObj.getReactedValue() != 0) {
            this.mUserPostObj.setReactionValue(0);
            UserPostSolrObj userPostSolrObj = this.mUserPostObj;
            userPostSolrObj.setNoOfLikes(userPostSolrObj.getNoOfLikes() - 1);
            this.mLikeButtonText.setCompoundDrawablesWithIntrinsicBounds(R.drawable.vector_sheroes_heart_in_active, 0, 0, 0);
            this.mPostDetailCallback.onPostUnLikeClicked(this.mUserPostObj);
            return;
        }
        this.mUserPostObj.setReactionValue(10);
        UserPostSolrObj userPostSolrObj2 = this.mUserPostObj;
        userPostSolrObj2.setNoOfLikes(userPostSolrObj2.getNoOfLikes() + 1);
        this.mLikeButtonText.setCompoundDrawablesWithIntrinsicBounds(R.drawable.vector_sheroes_heart_active, 0, 0, 0);
        this.mPostDetailCallback.onPostLikeClicked(this.mUserPostObj);
    }

    private void clickOnMentorAndCommunityName(String str, String str2, String str3) {
        SpannableString spannableString = new SpannableString(str);
        AnonymousClass2 r1 = new ClickableSpan() {
            public void onClick(View view) {
            }

            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        };
        AnonymousClass3 r2 = new ClickableSpan() {
            public void onClick(View view) {
            }

            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        };
        AnonymousClass4 r3 = new ClickableSpan() {
            public void onClick(View view) {
            }

            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        };
        if (StringUtil.isNotNullOrEmptyString(str2)) {
            spannableString.setSpan(r1, 0, str2.length(), 0);
            if (!str2.equalsIgnoreCase(this.mContext.getString(R.string.sheroes_ID_COMMUNITY_ANNONYMOUS))) {
                if (this.mUserPostObj.isAuthorMentor()) {
                    spannableString.setSpan(new ForegroundColorSpan(b.c(this.mContext, R.color.sheroes_feed_title)), 0, str2.length(), 0);
                } else {
                    spannableString.setSpan(new ForegroundColorSpan(b.c(this.mContext, R.color.sheroes_feed_title)), 0, str2.length(), 0);
                }
                spannableString.setSpan(new TypefaceSpan(this.mContext.getResources().getString(R.string.sheroes_ID_ROBOTO_MEDIUM)), 0, str2.length(), 0);
            } else {
                spannableString.setSpan(new TypefaceSpan(this.mContext.getResources().getString(R.string.sheroes_ID_ROBOTO_REGULAR)), 0, str2.length(), 0);
                spannableString.setSpan(new ForegroundColorSpan(b.c(this.mContext, R.color.sheroes_feed_article_label)), 0, str2.length(), 0);
            }
            if (StringUtil.isNotNullOrEmptyString(str3) && StringUtil.isNotNullOrEmptyString(str)) {
                spannableString.setSpan(r2, str2.length(), str2.length() + str3.length() + 3, 0);
                spannableString.setSpan(r3, str2.length() + str3.length() + 2, str.length(), 0);
                spannableString.setSpan(new ForegroundColorSpan(b.c(this.mContext, R.color.sheroes_feed_title)), str2.length(), str2.length() + str3.length() + 3, 0);
                spannableString.setSpan(new TypefaceSpan(this.mContext.getResources().getString(R.string.sheroes_ID_ROBOTO_REGULAR)), str2.length(), str2.length() + str3.length() + 3, 0);
                spannableString.setSpan(new TypefaceSpan(this.mContext.getResources().getString(R.string.sheroes_ID_ROBOTO_MEDIUM)), str2.length() + str3.length() + 2, str.length(), 0);
                spannableString.setSpan(new ForegroundColorSpan(b.c(this.mContext, R.color.sheroes_feed_title)), str2.length() + str3.length() + 2, str.length(), 0);
            }
            this.mTitle.setMovementMethod(LinkMovementMethod.getInstance());
            this.mTitle.setText(spannableString, TextView.BufferType.SPANNABLE);
            this.mTitle.setSelected(true);
        }
    }

    private void clickOnMentorName(String str, String str2, String str3) {
        SpannableString spannableString = new SpannableString(str);
        AnonymousClass5 r1 = new ClickableSpan() {
            public void onClick(View view) {
            }

            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        };
        AnonymousClass6 r2 = new ClickableSpan() {
            public void onClick(View view) {
            }

            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        };
        if (StringUtil.isNotNullOrEmptyString(str2)) {
            spannableString.setSpan(r1, 0, str2.length(), 0);
            if (!str2.equalsIgnoreCase(this.mContext.getString(R.string.sheroes_ID_COMMUNITY_ANNONYMOUS))) {
                if (this.mUserPostObj.isAuthorMentor()) {
                    spannableString.setSpan(new ForegroundColorSpan(b.c(this.mContext, R.color.sheroes_feed_article_label)), 0, str2.length(), 0);
                } else {
                    spannableString.setSpan(new ForegroundColorSpan(b.c(this.mContext, R.color.sheroes_feed_article_label)), 0, str2.length(), 0);
                }
                spannableString.setSpan(new TypefaceSpan(this.mContext.getResources().getString(R.string.sheroes_ID_ROBOTO_MEDIUM)), 0, str2.length(), 0);
            } else {
                spannableString.setSpan(new TypefaceSpan(this.mContext.getResources().getString(R.string.sheroes_ID_ROBOTO_REGULAR)), 0, str2.length(), 0);
                spannableString.setSpan(new ForegroundColorSpan(b.c(this.mContext, R.color.sheroes_feed_article_label)), 0, str2.length(), 0);
            }
            if (StringUtil.isNotNullOrEmptyString(str3) && StringUtil.isNotNullOrEmptyString(str)) {
                spannableString.setSpan(new ForegroundColorSpan(b.c(this.mContext, R.color.sheroes_feed_title)), str2.length(), str2.length() + str3.length() + 1, 0);
                spannableString.setSpan(r2, str2.length() + str3.length() + 2, str.length(), 0);
                spannableString.setSpan(new TypefaceSpan(this.mContext.getResources().getString(R.string.sheroes_ID_ROBOTO_MEDIUM)), str2.length(), str2.length() + str3.length() + 3, 0);
                spannableString.setSpan(new TypefaceSpan(this.mContext.getResources().getString(R.string.sheroes_ID_ROBOTO_MEDIUM)), str2.length() + str3.length() + 2, str.length(), 0);
                spannableString.setSpan(new ForegroundColorSpan(b.c(this.mContext, R.color.sheroes_feed_title)), str2.length() + str3.length() + 2, str.length(), 0);
            }
            this.mTitle.setMovementMethod(LinkMovementMethod.getInstance());
            this.mTitle.setText(spannableString, TextView.BufferType.SPANNABLE);
            this.mTitle.setSelected(true);
        }
    }

    private void clickOnCommunityName(String str, String str2, String str3) {
        SpannableString spannableString = new SpannableString(str);
        AnonymousClass7 r1 = new ClickableSpan() {
            public void onClick(View view) {
            }

            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        };
        AnonymousClass8 r2 = new ClickableSpan() {
            public void onClick(View view) {
            }

            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        };
        if (StringUtil.isNotNullOrEmptyString(str2)) {
            spannableString.setSpan(r1, 0, str2.length(), 0);
            spannableString.setSpan(new ForegroundColorSpan(b.c(this.mContext, R.color.sheroes_feed_article_label)), 0, str2.length(), 0);
            if (StringUtil.isNotNullOrEmptyString(str3) && StringUtil.isNotNullOrEmptyString(str)) {
                spannableString.setSpan(r2, str2.length(), str.length(), 0);
                spannableString.setSpan(new ForegroundColorSpan(b.c(this.mContext, R.color.sheroes_feed_title)), str2.length(), str.length(), 0);
                spannableString.setSpan(new StyleSpan(0), str2.length(), str.length(), 0);
            }
            this.mTitle.setMovementMethod(LinkMovementMethod.getInstance());
            this.mTitle.setText(spannableString, TextView.BufferType.SPANNABLE);
            this.mTitle.setSelected(true);
        }
    }

    private void handlingSpamUi(long j, int i2) {
        if (i2 == 2 || this.mUserPostObj.isCommunityOwner()) {
            this.viewContainer.setBackgroundColor(b.c(this.mContext, R.color.sheroes_white));
            this.viewContainer.setAlpha(1.0f);
            this.flSpamPostUi.setVisibility(0);
            this.liApproveDelete.setVisibility(0);
            this.tvReviewDescription.setVisibility(8);
        } else if (this.mUserPostObj.getAuthorId() == j) {
            this.viewContainer.setBackgroundColor(b.c(this.mContext, R.color.sheroes_spam_post));
            this.viewContainer.setAlpha(0.2f);
            this.flSpamPostUi.setVisibility(0);
            this.liApproveDelete.setVisibility(8);
            this.tvReviewDescription.setVisibility(0);
        } else {
            this.viewContainer.setBackgroundColor(b.c(this.mContext, R.color.sheroes_white));
            this.viewContainer.setAlpha(1.0f);
            this.flSpamPostUi.setVisibility(8);
            this.liApproveDelete.setVisibility(8);
            this.tvReviewDescription.setVisibility(0);
        }
    }

    private void onApproveSpamPostClick() {
        this.mPostDetailCallback.onSpamApprovedClicked(this.mUserPostObj, this.tvApproveSpamPost);
    }

    private void onDeleteSpamPostClick() {
        this.mPostDetailCallback.onSpamPostDeleteClicked(this.mUserPostObj, this.tvDeleteSpamPost);
    }

    private void onCommentButtonClicked() {
        this.mPostDetailCallback.onCommentButtonClicked();
    }

    private void onLikeCountClicked() {
        this.mPostDetailCallback.onLikeCountClicked(this.mUserPostObj);
    }
}
