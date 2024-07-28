package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.viewholders;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
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
import androidx.cardview.widget.CardView;
import androidx.core.content.b;
import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseHolderInterface;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseViewHolder;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.FeedItemCallback;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.ConfigData;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.Configuration;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.comment.Comment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.FeedDetail;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.UserPostSolrObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.InstallUpdateForMoEngage;
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

public class FeedCommunityPostHolder extends BaseViewHolder<FeedDetail> {
    private static final String LEFT_HTML_TAG = "<font color='#3c3c3c'>";
    private static final String LEFT_POSTED = "<font color='#8a8d8e'>";
    private static final String RIGHT_HTML_TAG = "</font>";
    private static final String RIGHT_POSTED = "</font>";
    private final String TAG = FeedCommunityPostHolder.class.getName();
    private int authorPicSize;
    private int authorPicSizeFourty;
    private FrameLayout flSpamPostUi;
    /* access modifiers changed from: private */
    public FrameLayout fmImageThumb;
    private LayoutInflater inflater = null;
    private boolean isToolTipForUser;
    private ImageView ivCompanyThumbnailCommPost;
    private CircleImageView ivFeedCommunityPostCircleIcon;
    private ImageView ivFeedCommunityPostCircleIconVerified;
    private CircleImageView ivFeedCommunityPostLoginUserPic;
    private ImageView ivFeedCommunityPostUserIconVerified;
    private CircleImageView ivFeedCommunityPostUserPic;
    /* access modifiers changed from: private */
    public ImageView ivLinkThumbnail;
    /* access modifiers changed from: private */
    public ImageView ivPlay;
    private LinearLayout liApproveDelete;
    private LinearLayout liCommunityPostMainLayout;
    private LinearLayout liFeedCommunityPostUserComments;
    private LinearLayout liFeedCommunityUserPostImages;
    private LinearLayout liViewLinkRender;
    private View lineForNoImage;
    private String loggedInUser;
    private int mAdminId;
    private TextView mCommentLike;
    private TextView mCommentLikeCount;
    Preference<Configuration> mConfiguration;
    private Context mContext;
    DateUtil mDateUtil;
    private Handler mHandler;
    Preference<InstallUpdateForMoEngage> mInstallUpdatePreference;
    private int mItemPosition;
    private TextView mJoinConveration;
    private String mPhotoUrl;
    private long mUserId;
    /* access modifiers changed from: private */
    public UserPostSolrObj mUserPostObj;
    private View orgCommPostSeparateLine;
    /* access modifiers changed from: private */
    public ProgressBar pbLink;
    private RelativeLayout rlFeedCommunityPostNoReactionComment;
    private RelativeLayout rlFeedPostComment;
    private RelativeLayout rlOrgCompanyFeedCard;
    private CardView rootLayout;
    private RelativeLayout topPostView;
    private TextView tvApproveSpamPost;
    private TextView tvCompanyNameCommPost;
    private TextView tvDeleteSpamPost;
    /* access modifiers changed from: private */
    public TextView tvFeedCommunityPostCardTitle;
    private TextView tvFeedCommunityPostLoginUserName;
    private TextView tvFeedCommunityPostReaction1;
    /* access modifiers changed from: private */
    public TextView tvFeedCommunityPostText;
    private TextView tvFeedCommunityPostTime;
    private TextView tvFeedCommunityPostTotalReactions;
    private TextView tvFeedCommunityPostTotalReplies;
    private TextView tvFeedCommunityPostUserComment;
    private TextView tvFeedCommunityPostUserCommentPost;
    private TextView tvFeedCommunityPostUserCommentPostMenu;
    private TextView tvFeedCommunityPostUserCommentPostTime;
    private TextView tvFeedCommunityPostUserCommentPostViewMore;
    private TextView tvFeedCommunityPostUserMenu;
    private TextView tvFeedCommunityPostUserName;
    private TextView tvFeedCommunityPostUserReaction;
    private TextView tvFeedCommunityPostUserShare;
    /* access modifiers changed from: private */
    public TextView tvFeedCommunityPostViewMore;
    private TextView tvLinkSubTitle;
    private TextView tvLinkTitle;
    private TextView tvReviewDescription;
    private TextView tvSpamPostMenu;
    Preference<LoginResponse> userPreference;
    private View view = null;
    /* access modifiers changed from: private */
    public BaseHolderInterface viewInterface;

    private void onReviewDescriptionClick() {
    }

    public void viewRecycled() {
    }

    public FeedCommunityPostHolder(View view2, BaseHolderInterface baseHolderInterface) {
        super(view2);
        this.rootLayout = (CardView) view2.findViewById(R.id.sheroes_card_view_post);
        this.rootLayout.setOnClickListener(this);
        this.topPostView = (RelativeLayout) view2.findViewById(R.id.sheroes_top_post_view);
        this.flSpamPostUi = (FrameLayout) view2.findViewById(R.id.sheroes_fl_spam_post_ui);
        this.flSpamPostUi.setOnClickListener(this);
        this.tvReviewDescription = (TextView) view2.findViewById(R.id.sheroes_tv_review_description);
        this.liApproveDelete = (LinearLayout) view2.findViewById(R.id.sheroes_li_approve_delete);
        this.tvDeleteSpamPost = (TextView) view2.findViewById(R.id.sheroes_tv_delete_spam_post);
        this.tvDeleteSpamPost.setOnClickListener(this);
        this.tvApproveSpamPost = (TextView) view2.findViewById(R.id.sheroes_tv_approve_spam_post);
        this.tvApproveSpamPost.setOnClickListener(this);
        this.mJoinConveration = (TextView) view2.findViewById(R.id.sheroes_tv_join_conversation);
        this.mJoinConveration.setOnClickListener(this);
        this.liCommunityPostMainLayout = (LinearLayout) view2.findViewById(R.id.sheroes_li_community_post_main_layout);
        this.liFeedCommunityPostUserComments = (LinearLayout) view2.findViewById(R.id.sheroes_li_feed_community_post_user_comments);
        this.liFeedCommunityPostUserComments.setOnClickListener(this);
        this.mCommentLike = (TextView) view2.findViewById(R.id.sheroes_comment_like);
        this.mCommentLike.setOnClickListener(this);
        this.mCommentLikeCount = (TextView) view2.findViewById(R.id.sheroes_comment_like_count);
        this.liFeedCommunityUserPostImages = (LinearLayout) view2.findViewById(R.id.sheroes_li_feed_community_user_post_images);
        this.liFeedCommunityUserPostImages.setOnClickListener(this);
        this.ivFeedCommunityPostCircleIcon = (CircleImageView) view2.findViewById(R.id.sheroes_iv_feed_community_post_circle_icon);
        this.ivFeedCommunityPostLoginUserPic = (CircleImageView) view2.findViewById(R.id.sheroes_iv_feed_community_post_login_user_pic);
        this.tvFeedCommunityPostLoginUserName = (TextView) view2.findViewById(R.id.sheroes_tv_feed_community_post_login_user_name);
        this.ivFeedCommunityPostCircleIconVerified = (ImageView) view2.findViewById(R.id.sheroes_iv_feed_community_post_circle_icon_verified);
        this.ivFeedCommunityPostUserIconVerified = (ImageView) view2.findViewById(R.id.sheroes_iv_feed_community_post_user_icon_verified);
        this.tvFeedCommunityPostUserShare = (TextView) view2.findViewById(R.id.sheroes_tv_feed_community_post_user_share);
        this.tvFeedCommunityPostUserShare.setOnClickListener(this);
        this.tvFeedCommunityPostUserReaction = (TextView) view2.findViewById(R.id.sheroes_tv_feed_community_post_user_reaction);
        this.tvFeedCommunityPostUserReaction.setOnClickListener(this);
        this.tvFeedCommunityPostUserComment = (TextView) view2.findViewById(R.id.sheroes_tv_feed_community_post_user_comment);
        this.tvFeedCommunityPostUserComment.setOnClickListener(this);
        this.tvFeedCommunityPostViewMore = (TextView) view2.findViewById(R.id.sheroes_tv_feed_community_post_view_more);
        this.tvFeedCommunityPostViewMore.setOnClickListener(this);
        this.tvFeedCommunityPostUserCommentPostViewMore = (TextView) view2.findViewById(R.id.sheroes_tv_feed_community_post_user_comment_post_view_more);
        this.tvFeedCommunityPostUserCommentPostViewMore.setOnClickListener(this);
        this.ivFeedCommunityPostUserPic = (CircleImageView) view2.findViewById(R.id.sheroes_iv_feed_community_post_user_pic);
        this.tvFeedCommunityPostCardTitle = (TextView) view2.findViewById(R.id.sheroes_tv_feed_community_post_card_title);
        this.tvFeedCommunityPostTime = (TextView) view2.findViewById(R.id.sheroes_tv_feed_community_post_time);
        this.tvFeedCommunityPostText = (TextView) view2.findViewById(R.id.sheroes_tv_feed_community_post_text);
        this.tvFeedCommunityPostUserMenu = (TextView) view2.findViewById(R.id.sheroes_tv_feed_community_post_user_menu);
        this.tvFeedCommunityPostUserMenu.setOnClickListener(this);
        this.tvSpamPostMenu = (TextView) view2.findViewById(R.id.sheroes_tv_spam_post_menu);
        this.tvSpamPostMenu.setOnClickListener(this);
        this.tvFeedCommunityPostReaction1 = (TextView) view2.findViewById(R.id.sheroes_tv_feed_community_post_reaction1);
        this.tvFeedCommunityPostReaction1.setOnClickListener(this);
        this.tvFeedCommunityPostTotalReactions = (TextView) view2.findViewById(R.id.sheroes_tv_feed_community_post_total_reactions);
        this.tvFeedCommunityPostTotalReactions.setOnClickListener(this);
        this.tvFeedCommunityPostTotalReplies = (TextView) view2.findViewById(R.id.sheroes_tv_feed_community_post_total_replies);
        this.tvFeedCommunityPostTotalReplies.setOnClickListener(this);
        this.tvFeedCommunityPostUserCommentPost = (TextView) view2.findViewById(R.id.sheroes_tv_feed_community_post_user_comment_post);
        this.tvFeedCommunityPostUserCommentPost.setOnClickListener(this);
        this.tvFeedCommunityPostUserName = (TextView) view2.findViewById(R.id.sheroes_tv_feed_community_post_user_name);
        this.lineForNoImage = view2.findViewById(R.id.sheroes_line_for_no_image);
        this.rlFeedPostComment = (RelativeLayout) view2.findViewById(R.id.sheroes_rl_feed_post_comment);
        this.rlFeedCommunityPostNoReactionComment = (RelativeLayout) view2.findViewById(R.id.sheroes_rl_feed_community_post_no_reaction_comments);
        this.tvFeedCommunityPostUserCommentPostMenu = (TextView) view2.findViewById(R.id.sheroes_tv_feed_community_post_user_comment_post_menu);
        this.tvFeedCommunityPostUserCommentPostMenu.setOnClickListener(this);
        this.tvFeedCommunityPostUserCommentPostTime = (TextView) view2.findViewById(R.id.sheroes_tv_feed_community_post_user_comment_post_time);
        this.pbLink = (ProgressBar) view2.findViewById(R.id.sheroes_progress_bar_post_link);
        this.ivPlay = (ImageView) view2.findViewById(R.id.sheroes_iv_play);
        this.fmImageThumb = (FrameLayout) view2.findViewById(R.id.sheroes_fm_image_thumb);
        this.ivLinkThumbnail = (ImageView) view2.findViewById(R.id.sheroes_iv_post_link_thumbnail);
        this.liViewLinkRender = (LinearLayout) view2.findViewById(R.id.sheroes_li_post_link_render);
        this.liViewLinkRender.setOnClickListener(this);
        this.tvLinkTitle = (TextView) view2.findViewById(R.id.sheroes_tv_post_link_title);
        this.tvLinkSubTitle = (TextView) view2.findViewById(R.id.sheroes_tv_post_link_sub_title);
        this.rlOrgCompanyFeedCard = (RelativeLayout) view2.findViewById(R.id.sheroes_rl_comm_post_org_details);
        this.ivCompanyThumbnailCommPost = (ImageView) view2.findViewById(R.id.sheroes_iv_company_icon_community_post);
        this.tvCompanyNameCommPost = (TextView) view2.findViewById(R.id.sheroes_tv_review_company_title_community_post);
        this.orgCommPostSeparateLine = view2.findViewById(R.id.sheroes_line_for_organsiation_text);
        this.authorPicSize = view2.getResources().getDimensionPixelSize(R.dimen.sheroes_dp_size_30);
        this.authorPicSizeFourty = view2.getResources().getDimensionPixelSize(R.dimen.sheroes_dp_size_40);
        this.mHandler = new Handler();
        this.viewInterface = baseHolderInterface;
        SheroesSdk.getAppComponent(view2.getContext()).inject(this);
        Preference<LoginResponse> preference = this.userPreference;
        if (!(preference == null || !preference.isSet() || this.userPreference.get() == null || this.userPreference.get().getUserSummary() == null)) {
            this.mUserId = this.userPreference.get().getUserSummary().getUserId().longValue();
            if (this.userPreference.get().getUserSummary().getUserBO() != null) {
                this.mAdminId = this.userPreference.get().getUserSummary().getUserBO().getUserTypeId();
            }
            if (StringUtil.isNotNullOrEmptyString(this.userPreference.get().getUserSummary().getPhotoUrl())) {
                this.mPhotoUrl = this.userPreference.get().getUserSummary().getPhotoUrl();
            }
            String firstName = this.userPreference.get().getUserSummary().getFirstName();
            String lastName = this.userPreference.get().getUserSummary().getLastName();
            if (StringUtil.isNotNullOrEmptyString(firstName) || StringUtil.isNotNullOrEmptyString(lastName)) {
                this.loggedInUser = firstName + " " + lastName;
            }
        }
        if (!this.mInstallUpdatePreference.get().isWalkThroughShown()) {
            this.isToolTipForUser = false;
        } else if (CommonUtil.ensureFirstTime(AppConstants.HOME_USER_NAME_PREF)) {
            this.isToolTipForUser = true;
            InstallUpdateForMoEngage installUpdateForMoEngage = this.mInstallUpdatePreference.get();
            installUpdateForMoEngage.setWalkThroughShown(false);
            this.mInstallUpdatePreference.set(installUpdateForMoEngage);
        }
    }

    public void bindData(FeedDetail feedDetail, Context context, int i2) {
        this.mUserPostObj = (UserPostSolrObj) feedDetail;
        this.mContext = context;
        Preference<Configuration> preference = this.mConfiguration;
        if (preference == null || !preference.isSet() || this.mConfiguration.get().configData == null) {
            this.mJoinConveration.setText(new ConfigData().mCommentHolderText);
        } else {
            this.mJoinConveration.setText(this.mConfiguration.get().configData.mCommentHolderText);
        }
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
        this.liCommunityPostMainLayout.setBackgroundColor(b.c(this.mContext, R.color.sheroes_white));
        this.liCommunityPostMainLayout.setAlpha(1.0f);
        this.flSpamPostUi.setVisibility(8);
        this.liApproveDelete.setVisibility(8);
        this.tvReviewDescription.setVisibility(0);
    }

    private void normalCommunityPostUi(long j, int i2) {
        this.liCommunityPostMainLayout.setVisibility(0);
        this.tvFeedCommunityPostUserReaction.setTag(Boolean.TRUE);
        UserPostSolrObj userPostSolrObj = this.mUserPostObj;
        userPostSolrObj.setLastReactionValue(userPostSolrObj.getReactionValue());
        imageOperations(this.mContext);
        if (StringUtil.isNotNullOrEmptyString(this.mUserPostObj.getOgRequestedUrlS())) {
            this.liFeedCommunityUserPostImages.removeAllViews();
            this.liFeedCommunityUserPostImages.removeAllViewsInLayout();
            this.liFeedCommunityUserPostImages.setVisibility(8);
            this.liViewLinkRender.setVisibility(0);
            setLinkData();
        } else {
            this.liViewLinkRender.setVisibility(8);
        }
        multipleImageURLs();
        populatePostText();
        allTextViewStringOperations(this.mContext);
        likeCommentOps();
        if (this.mUserPostObj.getAuthorId() == j || this.mUserPostObj.isCommunityOwner() || i2 == 2) {
            this.mUserPostObj.getCommunityId().longValue();
        }
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
                    FeedCommunityPostHolder.this.fmImageThumb.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                    FeedCommunityPostHolder.this.ivLinkThumbnail.setVisibility(0);
                    FeedCommunityPostHolder.this.ivLinkThumbnail.setImageBitmap(bitmap);
                    FeedCommunityPostHolder.this.pbLink.setVisibility(8);
                    if (FeedCommunityPostHolder.this.mUserPostObj.isOgVideoLinkB()) {
                        FeedCommunityPostHolder.this.ivPlay.getBackground().setAlpha(75);
                        FeedCommunityPostHolder.this.ivPlay.setVisibility(0);
                        return;
                    }
                    FeedCommunityPostHolder.this.ivPlay.setVisibility(8);
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
        this.tvFeedCommunityPostText.setVisibility(0);
        if (StringUtil.isNotEmptyCollection(this.mUserPostObj.getImageUrls())) {
            this.liFeedCommunityUserPostImages.setVisibility(0);
            List<String> imageUrls = this.mUserPostObj.getImageUrls();
            int size = imageUrls.size();
            if (size <= 0) {
                return;
            }
            if (size == 1) {
                this.liFeedCommunityUserPostImages.removeAllViews();
                this.liFeedCommunityUserPostImages.removeAllViewsInLayout();
                if (StringUtil.isNotEmptyCollection(imageUrls) && StringUtil.isNotNullOrEmptyString(imageUrls.get(0))) {
                    feedAlbum(this.mContext, imageUrls.get(0), (String) null, (String) null, 1);
                }
            } else if (size == 2) {
                this.liFeedCommunityUserPostImages.removeAllViews();
                this.liFeedCommunityUserPostImages.removeAllViewsInLayout();
                if (StringUtil.isNotEmptyCollection(imageUrls) && StringUtil.isNotNullOrEmptyString(imageUrls.get(0)) && StringUtil.isNotNullOrEmptyString(imageUrls.get(1))) {
                    feedAlbum(this.mContext, imageUrls.get(0), imageUrls.get(1), (String) null, 2);
                }
            } else if (size == 3) {
                this.liFeedCommunityUserPostImages.removeAllViews();
                this.liFeedCommunityUserPostImages.removeAllViewsInLayout();
                if (StringUtil.isNotEmptyCollection(imageUrls) && StringUtil.isNotNullOrEmptyString(imageUrls.get(0)) && StringUtil.isNotNullOrEmptyString(imageUrls.get(1)) && StringUtil.isNotNullOrEmptyString(imageUrls.get(2))) {
                    feedAlbum(this.mContext, imageUrls.get(0), imageUrls.get(1), imageUrls.get(2), 3);
                }
            } else if (size != 4) {
                this.liFeedCommunityUserPostImages.removeAllViews();
                this.liFeedCommunityUserPostImages.removeAllViewsInLayout();
                if (StringUtil.isNotEmptyCollection(imageUrls) && StringUtil.isNotNullOrEmptyString(imageUrls.get(0)) && StringUtil.isNotNullOrEmptyString(imageUrls.get(1)) && StringUtil.isNotNullOrEmptyString(imageUrls.get(2)) && StringUtil.isNotNullOrEmptyString(imageUrls.get(3))) {
                    feedAlbum(this.mContext, imageUrls.get(0), imageUrls.get(1), imageUrls.get(2), size);
                }
            } else {
                this.liFeedCommunityUserPostImages.removeAllViews();
                this.liFeedCommunityUserPostImages.removeAllViewsInLayout();
                if (StringUtil.isNotEmptyCollection(imageUrls) && StringUtil.isNotNullOrEmptyString(imageUrls.get(0)) && StringUtil.isNotNullOrEmptyString(imageUrls.get(1)) && StringUtil.isNotNullOrEmptyString(imageUrls.get(2)) && StringUtil.isNotNullOrEmptyString(imageUrls.get(3))) {
                    feedAlbum(this.mContext, imageUrls.get(0), imageUrls.get(1), imageUrls.get(2), 4);
                }
            }
        } else {
            this.liFeedCommunityUserPostImages.removeAllViews();
            this.liFeedCommunityUserPostImages.removeAllViewsInLayout();
            this.liFeedCommunityUserPostImages.setVisibility(8);
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
                    this.ivFeedCommunityPostCircleIconVerified.setVisibility(8);
                } else if (this.mUserPostObj.isAuthorMentor()) {
                    this.ivFeedCommunityPostCircleIconVerified.setVisibility(0);
                } else {
                    this.ivFeedCommunityPostCircleIconVerified.setVisibility(8);
                }
                if (this.mUserPostObj.getCommunityTypeId() == 10) {
                    this.rlOrgCompanyFeedCard.setVisibility(0);
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
                    if (StringUtil.isNotNullOrEmptyString(this.mUserPostObj.getSolrIgnorePostCommunityLogo())) {
                        w.a().a(this.mUserPostObj.getSolrIgnorePostCommunityLogo()).a(this.ivCompanyThumbnailCommPost, (e) null);
                    }
                    this.tvCompanyNameCommPost.setText(str);
                    this.orgCommPostSeparateLine.setVisibility(0);
                } else if (this.mUserPostObj.getCommunityTypeId() == 3) {
                    this.rlOrgCompanyFeedCard.setVisibility(8);
                    this.orgCommPostSeparateLine.setVisibility(8);
                    if (!authorName.equalsIgnoreCase(this.mContext.getString(R.string.sheroes_ID_ADMIN))) {
                        sb.append(authorName);
                        sb.append(" ");
                        sb.append(this.mContext.getString(R.string.sheroes_ID_ASKED));
                        sb.append(" ");
                        sb.append(str);
                        clickOnCommunityName(sb.toString(), authorName, this.mContext.getString(R.string.sheroes_ID_ASKED));
                    } else if (authorName.equalsIgnoreCase(this.mContext.getString(R.string.sheroes_ID_ADMIN))) {
                        String postCommunityName = this.mUserPostObj.getPostCommunityName();
                        sb.append(postCommunityName);
                        sb.append(" ");
                        sb.append(this.mContext.getString(R.string.sheroes_ID_ASKED));
                        sb.append(" ");
                        clickOnCommunityName(sb.toString(), postCommunityName, this.mContext.getString(R.string.sheroes_ID_ASKED));
                    } else {
                        String string2 = this.mContext.getString(R.string.sheroes_ID_ANONYMOUS);
                        sb.append(string2);
                        sb.append(" ");
                        sb.append(this.mContext.getString(R.string.sheroes_ID_ASKED));
                        sb.append(" ");
                        sb.append(str);
                        clickOnCommunityName(sb.toString(), string2, this.mContext.getString(R.string.sheroes_ID_POSTED_IN));
                    }
                } else {
                    this.rlOrgCompanyFeedCard.setVisibility(8);
                    this.orgCommPostSeparateLine.setVisibility(8);
                    if (!authorName.equalsIgnoreCase(this.mContext.getString(R.string.sheroes_ID_ADMIN))) {
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
        }
        if (StringUtil.isNotNullOrEmptyString(this.mUserPostObj.getCreatedDate())) {
            this.tvFeedCommunityPostTime.setText(this.mDateUtil.getRoundedDifferenceInHours(System.currentTimeMillis(), this.mDateUtil.getTimeInMillis(this.mUserPostObj.getCreatedDate(), AppConstants.DATE_FORMAT)));
        } else {
            this.tvFeedCommunityPostTime.setText(this.mContext.getString(R.string.sheroes_ID_JUST_NOW));
        }
    }

    private void likeCommentOps() {
        String str;
        if (this.mUserPostObj.getNoOfLikes() <= 0 && this.mUserPostObj.getNoOfComments() <= 0) {
            this.tvFeedCommunityPostUserReaction.setCompoundDrawablesWithIntrinsicBounds(R.drawable.vector_sheroes_heart_in_active, 0, 0, 0);
            this.rlFeedCommunityPostNoReactionComment.setVisibility(8);
            this.lineForNoImage.setVisibility(8);
        }
        this.tvFeedCommunityPostReaction1.setVisibility(0);
        int noOfLikes = this.mUserPostObj.getNoOfLikes();
        if (noOfLikes == 0) {
            if (this.mUserPostObj.getNoOfComments() > 0) {
                this.rlFeedCommunityPostNoReactionComment.setVisibility(0);
                this.lineForNoImage.setVisibility(0);
                this.tvFeedCommunityPostTotalReactions.setVisibility(8);
                this.tvFeedCommunityPostReaction1.setVisibility(4);
                this.tvFeedCommunityPostTotalReplies.setVisibility(0);
            } else {
                this.rlFeedCommunityPostNoReactionComment.setVisibility(8);
                this.lineForNoImage.setVisibility(8);
            }
            userLike();
        } else if (noOfLikes != 1) {
            this.rlFeedCommunityPostNoReactionComment.setVisibility(0);
            this.lineForNoImage.setVisibility(0);
            this.tvFeedCommunityPostTotalReactions.setVisibility(0);
            userLike();
        } else {
            this.rlFeedCommunityPostNoReactionComment.setVisibility(0);
            this.lineForNoImage.setVisibility(0);
            this.tvFeedCommunityPostTotalReactions.setVisibility(0);
            userLike();
        }
        String quantityString = this.mContext.getResources().getQuantityString(R.plurals.numberOfLikes, this.mUserPostObj.getNoOfLikes());
        TextView textView = this.tvFeedCommunityPostTotalReactions;
        textView.setText(String.valueOf(this.mUserPostObj.getNoOfLikes() + " " + quantityString));
        int noOfComments = this.mUserPostObj.getNoOfComments();
        if (noOfComments == 0) {
            if (this.mUserPostObj.getNoOfLikes() > 0) {
                this.rlFeedCommunityPostNoReactionComment.setVisibility(0);
                this.lineForNoImage.setVisibility(0);
                this.tvFeedCommunityPostTotalReactions.setVisibility(0);
                this.tvFeedCommunityPostReaction1.setVisibility(0);
                this.tvFeedCommunityPostTotalReplies.setVisibility(4);
            } else {
                this.rlFeedCommunityPostNoReactionComment.setVisibility(8);
                this.lineForNoImage.setVisibility(8);
            }
            userComments();
        } else if (noOfComments != 1) {
            this.tvFeedCommunityPostTotalReplies.setVisibility(0);
            this.liFeedCommunityPostUserComments.setVisibility(0);
            userComments();
        } else {
            this.tvFeedCommunityPostTotalReplies.setVisibility(0);
            this.liFeedCommunityPostUserComments.setVisibility(0);
            userComments();
        }
        if (this.mUserPostObj.getCommunityTypeId() == 3) {
            str = this.mContext.getResources().getQuantityString(R.plurals.numberOfAnswers, this.mUserPostObj.getNoOfComments());
        } else {
            str = this.mContext.getResources().getQuantityString(R.plurals.numberOfComments, this.mUserPostObj.getNoOfComments());
        }
        TextView textView2 = this.tvFeedCommunityPostTotalReplies;
        textView2.setText(String.valueOf(this.mUserPostObj.getNoOfComments() + " " + str));
    }

    private void populatePostText() {
        Preference<Configuration> preference = this.mConfiguration;
        if (preference == null || !preference.isSet() || this.mConfiguration.get().configData == null || !this.mConfiguration.get().configData.isWhatsAppShare) {
            this.tvFeedCommunityPostUserShare.setCompoundDrawablesWithIntrinsicBounds(b.a(this.mContext, R.drawable.vector_sheroes_share_white_out), (Drawable) null, (Drawable) null, (Drawable) null);
            this.tvFeedCommunityPostUserShare.setText(this.mContext.getString(R.string.sheroes_ID_SHARE));
            this.tvFeedCommunityPostUserShare.setTextColor(b.c(this.mContext, R.color.sheroes_recent_post_comment));
        } else {
            this.tvFeedCommunityPostUserShare.setCompoundDrawablesWithIntrinsicBounds(b.a(this.mContext, R.drawable.vector_sheroes_share_card), (Drawable) null, (Drawable) null, (Drawable) null);
            this.tvFeedCommunityPostUserShare.setText(this.mContext.getString(R.string.sheroes_ID_SHARE_ON_WHATS_APP));
            this.tvFeedCommunityPostUserShare.setTextColor(b.c(this.mContext, R.color.sheroes_share_color));
        }
        final String listDescription = this.mUserPostObj.getListDescription();
        if (!StringUtil.isNotNullOrEmptyString(listDescription)) {
            this.tvFeedCommunityPostText.setVisibility(8);
            this.tvFeedCommunityPostViewMore.setVisibility(8);
            return;
        }
        this.tvFeedCommunityPostText.setVisibility(0);
        this.mHandler.post(new Runnable() {
            public void run() {
                FeedCommunityPostHolder.this.tvFeedCommunityPostText.setMaxLines(Integer.MAX_VALUE);
                if (!FeedCommunityPostHolder.this.mUserPostObj.isTextExpanded.booleanValue()) {
                    FeedCommunityPostHolder.this.tvFeedCommunityPostText.setText(StringUtil.hashTagColorInString(listDescription));
                    StringUtil.linkifyURLs(FeedCommunityPostHolder.this.tvFeedCommunityPostText);
                    if (FeedCommunityPostHolder.this.tvFeedCommunityPostText.getLineCount() > 4) {
                        FeedCommunityPostHolder.this.collapseFeedPostText();
                        return;
                    }
                    FeedCommunityPostHolder.this.tvFeedCommunityPostText.setVisibility(0);
                    FeedCommunityPostHolder.this.tvFeedCommunityPostViewMore.setVisibility(8);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void collapseFeedPostText() {
        this.mUserPostObj.isTextExpanded = Boolean.FALSE;
        this.tvFeedCommunityPostText.setMaxLines(4);
        this.tvFeedCommunityPostText.setVisibility(0);
        if (Build.VERSION.SDK_INT >= 24) {
            TextView textView = this.tvFeedCommunityPostViewMore;
            textView.setText(Html.fromHtml("<font color='#3c3c3c'>...</font>" + this.mContext.getString(R.string.sheroes_ID_VIEW_MORE), 0));
        } else {
            TextView textView2 = this.tvFeedCommunityPostViewMore;
            textView2.setText(Html.fromHtml("<font color='#3c3c3c'>...</font>" + this.mContext.getString(R.string.sheroes_ID_VIEW_MORE)));
        }
        this.tvFeedCommunityPostViewMore.setVisibility(0);
    }

    private void expandFeedPostText() {
        this.mUserPostObj.isTextExpanded = Boolean.TRUE;
        this.tvFeedCommunityPostText.setMaxLines(Integer.MAX_VALUE);
        this.tvFeedCommunityPostText.setVisibility(0);
        this.tvFeedCommunityPostViewMore.setText(this.mContext.getString(R.string.sheroes_ID_LESS));
        this.tvFeedCommunityPostViewMore.setVisibility(0);
    }

    private void userLike() {
        int reactionValue = this.mUserPostObj.getReactionValue();
        if (reactionValue == 0) {
            this.tvFeedCommunityPostUserReaction.setCompoundDrawablesWithIntrinsicBounds(R.drawable.vector_sheroes_heart_in_active, 0, 0, 0);
        } else if (reactionValue == 10) {
            this.tvFeedCommunityPostUserReaction.setCompoundDrawablesWithIntrinsicBounds(R.drawable.vector_sheroes_heart_active, 0, 0, 0);
        } else if (reactionValue != 20 && reactionValue != 30 && reactionValue != 40 && reactionValue != 50) {
            String str = this.TAG;
            Bamboo.e(str, "Case not handled on :  " + this.TAG + " " + this.mUserPostObj.getReactionValue());
        }
    }

    private void userComments() {
        List<Comment> lastComments = this.mUserPostObj.getLastComments();
        if (StringUtil.isNotEmptyCollection(lastComments)) {
            this.mItemPosition = lastComments.size() - 1;
            Comment comment = lastComments.get(this.mItemPosition);
            this.ivFeedCommunityPostUserPic.setCircularImage(true);
            invalidateCommentLike(comment);
            if (comment.isAnonymous()) {
                if (StringUtil.isNotNullOrEmptyString(comment.getParticipantName())) {
                    String participantImageUrl = comment.getParticipantImageUrl();
                    int i2 = this.authorPicSize;
                    this.ivFeedCommunityPostUserPic.bindImage(CommonUtil.getThumborUri(participantImageUrl, i2, i2));
                    this.tvFeedCommunityPostUserName.setText(comment.getParticipantName());
                    this.tvFeedCommunityPostUserName.setTextColor(b.c(this.mContext, R.color.sheroes_comment_text));
                    this.tvFeedCommunityPostUserCommentPost.setText(StringUtil.hashTagColorInString(comment.getComment()));
                    this.ivFeedCommunityPostUserIconVerified.setVisibility(8);
                    invalidateCommentLike(comment);
                }
            } else if (StringUtil.isNotNullOrEmptyString(comment.getComment()) && StringUtil.isNotNullOrEmptyString(comment.getParticipantName())) {
                String participantImageUrl2 = comment.getParticipantImageUrl();
                int i3 = this.authorPicSize;
                this.ivFeedCommunityPostUserPic.bindImage(CommonUtil.getThumborUri(participantImageUrl2, i3, i3));
                this.tvFeedCommunityPostUserName.setText(comment.getParticipantName());
                this.tvFeedCommunityPostUserName.setTextColor(b.c(this.mContext, R.color.sheroes_feed_title));
                this.tvFeedCommunityPostUserCommentPost.setText(StringUtil.hashTagColorInString(comment.getComment()));
                if (comment.getParticipantName().equalsIgnoreCase(this.mContext.getString(R.string.sheroes_ID_COMMUNITY_ANNONYMOUS))) {
                    this.ivFeedCommunityPostUserIconVerified.setVisibility(8);
                } else if (comment.isVerifiedMentor()) {
                    this.ivFeedCommunityPostUserIconVerified.setVisibility(0);
                } else {
                    this.ivFeedCommunityPostUserIconVerified.setVisibility(8);
                }
            }
            StringUtil.linkifyURLs(this.tvFeedCommunityPostUserCommentPost);
            if (this.tvFeedCommunityPostUserCommentPost.getLineCount() > 3) {
                this.tvFeedCommunityPostUserCommentPostViewMore.setVisibility(0);
                if (Build.VERSION.SDK_INT >= 24) {
                    TextView textView = this.tvFeedCommunityPostUserCommentPostViewMore;
                    textView.setText(Html.fromHtml("<font color='#3c3c3c'>...</font>" + this.mContext.getString(R.string.sheroes_ID_VIEW_MORE), 0));
                } else {
                    TextView textView2 = this.tvFeedCommunityPostUserCommentPostViewMore;
                    textView2.setText(Html.fromHtml("<font color='#3c3c3c'>...</font>" + this.mContext.getString(R.string.sheroes_ID_VIEW_MORE)));
                }
            } else {
                this.tvFeedCommunityPostUserCommentPostViewMore.setVisibility(8);
            }
            if (StringUtil.isNotNullOrEmptyString(comment.getLastModifiedOn())) {
                this.tvFeedCommunityPostUserCommentPostTime.setText(this.mDateUtil.getRoundedDifferenceInHours(System.currentTimeMillis(), this.mDateUtil.getTimeInMillis(comment.getLastModifiedOn(), AppConstants.DATE_FORMAT)));
            } else {
                this.tvFeedCommunityPostUserCommentPostTime.setText(this.mContext.getString(R.string.sheroes_ID_JUST_NOW));
            }
            Preference<LoginResponse> preference = this.userPreference;
            if (!(preference == null || !preference.isSet() || this.userPreference.get() == null || this.userPreference.get().getUserSummary() == null || this.userPreference.get().getUserSummary().getUserBO() == null)) {
                this.mAdminId = this.userPreference.get().getUserSummary().getUserBO().getUserTypeId();
            }
            if (comment.isMyOwnParticipation() || this.mAdminId == 2) {
                this.tvFeedCommunityPostUserCommentPostMenu.setVisibility(0);
            } else {
                this.tvFeedCommunityPostUserCommentPostMenu.setVisibility(8);
            }
        } else {
            this.liFeedCommunityPostUserComments.setVisibility(8);
            this.tvFeedCommunityPostTotalReplies.setVisibility(8);
        }
    }

    private void invalidateCommentLike(Comment comment) {
        if (comment.likeCount > 0) {
            this.mCommentLikeCount.setVisibility(0);
            this.mCommentLikeCount.setText(Integer.toString(comment.likeCount));
        } else {
            this.mCommentLikeCount.setVisibility(8);
        }
        if (comment.isLiked) {
            this.mCommentLike.setTextColor(this.mContext.getResources().getColor(R.color.sheroes_toolbar_title_text));
        } else {
            this.mCommentLike.setTextColor(this.mContext.getResources().getColor(R.color.sheroes_posted_in));
        }
    }

    private void imageOperations(Context context) {
        String authorImageUrl = this.mUserPostObj.getAuthorImageUrl();
        if (StringUtil.isNotNullOrEmptyString(authorImageUrl)) {
            this.ivFeedCommunityPostCircleIcon.setCircularImage(true);
            int i2 = this.authorPicSizeFourty;
            this.ivFeedCommunityPostCircleIcon.bindImage(CommonUtil.getThumborUri(authorImageUrl, i2, i2));
        }
        this.ivFeedCommunityPostLoginUserPic.setCircularImage(true);
        String str = this.mPhotoUrl;
        int i3 = this.authorPicSizeFourty;
        this.ivFeedCommunityPostLoginUserPic.bindImage(CommonUtil.getThumborUri(str, i3, i3));
        if (StringUtil.isNotNullOrEmptyString(this.loggedInUser)) {
            this.tvFeedCommunityPostLoginUserName.setVisibility(0);
            this.tvFeedCommunityPostLoginUserName.setText(this.loggedInUser);
            return;
        }
        this.tvFeedCommunityPostLoginUserName.setVisibility(8);
    }

    private void feedAlbum(Context context, String str, String str2, String str3, int i2) {
        int i3;
        int i4;
        String str4;
        String str5;
        String str6 = str;
        String str7 = str2;
        int i5 = i2;
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
        if (i5 == 1) {
            ((LinearLayout.LayoutParams) linearLayout2.getLayoutParams()).weight = 0.0f;
        } else if (i5 == 2) {
            ((LinearLayout.LayoutParams) linearLayout2.getLayoutParams()).setMargins(5, 0, 0, 0);
            ((LinearLayout.LayoutParams) imageView.getLayoutParams()).weight = 1.0f;
            ((LinearLayout.LayoutParams) imageView2.getLayoutParams()).weight = 0.0f;
        } else if (i5 != 3) {
            textView.setText(String.valueOf("+".concat(String.valueOf(i5 - 2))));
            textView.setVisibility(0);
        } else {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout2.getLayoutParams();
            layoutParams.weight = 1.0f;
            layoutParams.setMargins(5, 0, 0, 0);
            ((LinearLayout.LayoutParams) imageView.getLayoutParams()).weight = 2.0f;
            ((LinearLayout.LayoutParams) imageView2.getLayoutParams()).weight = 1.0f;
        }
        imageView.setOnClickListener(this);
        if (StringUtil.isNotNullOrEmptyString(str)) {
            if (i5 == 1) {
                str5 = CommonUtil.getThumborUri(str6, CommonUtil.getWindowWidth(context), i3);
                i4 = 2;
            } else {
                i4 = 2;
                str5 = CommonUtil.getThumborUri(str6, CommonUtil.getWindowWidth(context) / 2, i3);
            }
            w.a().a(str5).a(imageView, (e) null);
        } else {
            i4 = 2;
        }
        if (StringUtil.isNotNullOrEmptyString(str2)) {
            imageView2.setOnClickListener(this);
            if (i5 == i4) {
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
        this.liFeedCommunityUserPostImages.addView(inflate);
    }

    private void repliesClick() {
        BaseHolderInterface baseHolderInterface = this.viewInterface;
        if (baseHolderInterface instanceof FeedItemCallback) {
            ((FeedItemCallback) baseHolderInterface).onUserPostClicked(this.mUserPostObj);
        } else {
            baseHolderInterface.handleOnClick(this.mUserPostObj, this.tvFeedCommunityPostUserComment);
        }
    }

    private void joinConversationClick() {
        onJoinConversationClicked();
    }

    private void onJoinConversationClicked() {
        BaseHolderInterface baseHolderInterface = this.viewInterface;
        if (baseHolderInterface instanceof FeedItemCallback) {
            ((FeedItemCallback) baseHolderInterface).onUserPostCommentClicked(this.mUserPostObj);
        } else {
            baseHolderInterface.handleOnClick(this.mUserPostObj, this.mJoinConveration);
        }
    }

    private void communityPostImageClick() {
        BaseHolderInterface baseHolderInterface = this.viewInterface;
        if (baseHolderInterface instanceof FeedItemCallback) {
            ((FeedItemCallback) baseHolderInterface).onUserPostImageClicked(this.mUserPostObj);
        } else {
            baseHolderInterface.dataOperationOnClick(this.mUserPostObj);
        }
    }

    private void userMenuClick() {
        BaseHolderInterface baseHolderInterface = this.viewInterface;
        if (baseHolderInterface instanceof FeedItemCallback) {
            ((FeedItemCallback) baseHolderInterface).onPostMenuClicked(this.mUserPostObj, this.tvFeedCommunityPostUserMenu);
        } else {
            baseHolderInterface.handleOnClick(this.mUserPostObj, this.tvFeedCommunityPostUserMenu);
        }
    }

    private void spamMenuClick() {
        BaseHolderInterface baseHolderInterface = this.viewInterface;
        if (baseHolderInterface instanceof FeedItemCallback) {
            ((FeedItemCallback) baseHolderInterface).onPostMenuClicked(this.mUserPostObj, this.tvSpamPostMenu);
        } else {
            baseHolderInterface.handleOnClick(this.mUserPostObj, this.tvSpamPostMenu);
        }
    }

    private void userCommentMenuClick() {
        this.mUserPostObj.setNoOfOpenings(this.mItemPosition);
        BaseHolderInterface baseHolderInterface = this.viewInterface;
        if (baseHolderInterface instanceof FeedItemCallback) {
            ((FeedItemCallback) baseHolderInterface).onCommentMenuClicked(this.mUserPostObj, this.tvFeedCommunityPostUserCommentPostMenu);
        } else {
            baseHolderInterface.handleOnClick(this.mUserPostObj, this.tvFeedCommunityPostUserCommentPostMenu);
        }
    }

    private void onViewMoreClicked() {
        if (this.tvFeedCommunityPostViewMore.getText().equals(this.mContext.getString(R.string.sheroes_ID_LESS))) {
            collapseFeedPostText();
        } else if (this.tvFeedCommunityPostText.getLineCount() > 16) {
            BaseHolderInterface baseHolderInterface = this.viewInterface;
            if (baseHolderInterface instanceof FeedItemCallback) {
                ((FeedItemCallback) baseHolderInterface).onUserPostClicked(this.mUserPostObj);
            } else {
                baseHolderInterface.handleOnClick(this.mUserPostObj, this.tvFeedCommunityPostUserComment);
            }
        } else {
            expandFeedPostText();
        }
    }

    public void onClick(View view2) {
        int id = view2.getId();
        if (id == R.id.sheroes_iv_first) {
            this.mUserPostObj.setItemPosition(0);
            BaseHolderInterface baseHolderInterface = this.viewInterface;
            if (baseHolderInterface instanceof FeedItemCallback) {
                ((FeedItemCallback) baseHolderInterface).onUserPostImageClicked(this.mUserPostObj);
            } else {
                baseHolderInterface.dataOperationOnClick(this.mUserPostObj);
            }
        }
        if (id == R.id.sheroes_iv_second) {
            this.mUserPostObj.setItemPosition(1);
            BaseHolderInterface baseHolderInterface2 = this.viewInterface;
            if (baseHolderInterface2 instanceof FeedItemCallback) {
                ((FeedItemCallback) baseHolderInterface2).onUserPostImageClicked(this.mUserPostObj);
            } else {
                baseHolderInterface2.dataOperationOnClick(this.mUserPostObj);
            }
        }
        if (id == R.id.sheroes_iv_third) {
            this.mUserPostObj.setItemPosition(2);
            BaseHolderInterface baseHolderInterface3 = this.viewInterface;
            if (baseHolderInterface3 instanceof FeedItemCallback) {
                ((FeedItemCallback) baseHolderInterface3).onUserPostImageClicked(this.mUserPostObj);
            } else {
                baseHolderInterface3.dataOperationOnClick(this.mUserPostObj);
            }
        }
        if (id == R.id.sheroes_comment_like) {
            onCommentLikeClicked();
        }
        if (id == R.id.sheroes_tv_feed_community_post_user_comment) {
            onJoinConversationClicked();
        }
        if (id == R.id.sheroes_tv_join_conversation) {
            joinConversationClick();
        }
        if (id == R.id.sheroes_li_feed_community_user_post_images) {
            communityPostImageClick();
        }
        if (id == R.id.sheroes_li_post_link_render) {
            tvLinkClick();
        }
        if (id == R.id.sheroes_tv_feed_community_post_view_more) {
            onViewMoreClicked();
        }
        if (id == R.id.sheroes_tv_feed_community_post_user_share) {
            tvShareClick();
        }
        if (id == R.id.sheroes_tv_feed_community_post_user_menu) {
            userMenuClick();
        }
        if (id == R.id.sheroes_tv_feed_community_post_total_reactions) {
            reactionClick();
        }
        if (id == R.id.sheroes_tv_feed_community_post_reaction1) {
            reaction1Click();
        }
        if (id == R.id.sheroes_tv_feed_community_post_user_reaction) {
            userReactionClick();
        }
        if (id == R.id.sheroes_tv_feed_community_post_total_replies || id == R.id.sheroes_tv_feed_community_post_user_comment_post || id == R.id.sheroes_li_feed_community_post_user_comments || id == R.id.sheroes_tv_feed_community_post_user_comment_post_view_more || id == R.id.sheroes_card_view_post) {
            repliesClick();
        }
        if (id == R.id.sheroes_tv_spam_post_menu) {
            spamMenuClick();
        }
        if (id == R.id.sheroes_tv_feed_community_post_user_comment_post_menu) {
            userCommentMenuClick();
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
    }

    private void tvShareClick() {
        BaseHolderInterface baseHolderInterface = this.viewInterface;
        if (baseHolderInterface instanceof FeedItemCallback) {
            ((FeedItemCallback) baseHolderInterface).onPostShared(this.mUserPostObj);
        } else {
            baseHolderInterface.handleOnClick(this.mUserPostObj, this.tvFeedCommunityPostUserShare);
        }
    }

    private void reactionClick() {
        BaseHolderInterface baseHolderInterface = this.viewInterface;
        if (baseHolderInterface instanceof FeedItemCallback) {
            ((FeedItemCallback) baseHolderInterface).onLikesCountClicked(this.mUserPostObj);
        } else {
            baseHolderInterface.handleOnClick(this.mUserPostObj, this.tvFeedCommunityPostTotalReactions);
        }
    }

    private void reaction1Click() {
        this.viewInterface.handleOnClick(this.mUserPostObj, this.tvFeedCommunityPostTotalReactions);
    }

    private void userReactionClick() {
        if (this.viewInterface instanceof FeedItemCallback) {
            if (this.mUserPostObj.getReactionValue() != 0) {
                this.mUserPostObj.setReactionValue(0);
                UserPostSolrObj userPostSolrObj = this.mUserPostObj;
                userPostSolrObj.setNoOfLikes(userPostSolrObj.getNoOfLikes() - 1);
                this.tvFeedCommunityPostUserReaction.setCompoundDrawablesWithIntrinsicBounds(R.drawable.vector_sheroes_heart_in_active, 0, 0, 0);
                ((FeedItemCallback) this.viewInterface).onUserPostUnLiked(this.mUserPostObj);
            } else {
                this.mUserPostObj.setReactionValue(10);
                UserPostSolrObj userPostSolrObj2 = this.mUserPostObj;
                userPostSolrObj2.setNoOfLikes(userPostSolrObj2.getNoOfLikes() + 1);
                this.tvFeedCommunityPostUserReaction.setCompoundDrawablesWithIntrinsicBounds(R.drawable.vector_sheroes_heart_active, 0, 0, 0);
                ((FeedItemCallback) this.viewInterface).onUserPostLiked(this.mUserPostObj);
            }
            likeCommentOps();
        } else if (((Boolean) this.tvFeedCommunityPostUserReaction.getTag()).booleanValue()) {
            userReactionWithouLongPress();
        }
    }

    private void userReactionWithouLongPress() {
        this.tvFeedCommunityPostUserReaction.setTag(Boolean.FALSE);
        this.mUserPostObj.setLongPress(false);
        if (this.mUserPostObj.getReactionValue() != 0) {
            this.viewInterface.userCommentLikeRequest(this.mUserPostObj, 0, getAdapterPosition());
        } else {
            this.viewInterface.userCommentLikeRequest(this.mUserPostObj, 10, getAdapterPosition());
        }
        if (this.mUserPostObj.getReactionValue() != 0) {
            this.mUserPostObj.setReactionValue(0);
            UserPostSolrObj userPostSolrObj = this.mUserPostObj;
            userPostSolrObj.setNoOfLikes(userPostSolrObj.getNoOfLikes() - 1);
            this.tvFeedCommunityPostUserReaction.setCompoundDrawablesWithIntrinsicBounds(R.drawable.vector_sheroes_heart_in_active, 0, 0, 0);
        } else {
            this.mUserPostObj.setReactionValue(10);
            UserPostSolrObj userPostSolrObj2 = this.mUserPostObj;
            userPostSolrObj2.setNoOfLikes(userPostSolrObj2.getNoOfLikes() + 1);
            this.tvFeedCommunityPostUserReaction.setCompoundDrawablesWithIntrinsicBounds(R.drawable.vector_sheroes_heart_active, 0, 0, 0);
        }
        likeCommentOps();
    }

    private void clickOnMentorAndCommunityName(String str, String str2, String str3) {
        SpannableString spannableString = new SpannableString(str);
        AnonymousClass3 r1 = new ClickableSpan() {
            public void onClick(View view) {
            }

            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        };
        AnonymousClass4 r2 = new ClickableSpan() {
            public void onClick(View view) {
            }

            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        };
        AnonymousClass5 r3 = new ClickableSpan() {
            public void onClick(View view) {
                FeedCommunityPostHolder.this.viewInterface.handleOnClick(FeedCommunityPostHolder.this.mUserPostObj, FeedCommunityPostHolder.this.tvFeedCommunityPostCardTitle);
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
                spannableString.setSpan(new ForegroundColorSpan(b.c(this.mContext, R.color.sheroes_feed_title)), 0, str2.length(), 0);
            }
            if (StringUtil.isNotNullOrEmptyString(str3) && StringUtil.isNotNullOrEmptyString(str)) {
                spannableString.setSpan(r2, str2.length(), str2.length() + str3.length() + 3, 0);
                spannableString.setSpan(r3, str2.length() + str3.length() + 2, str.length(), 0);
                spannableString.setSpan(new ForegroundColorSpan(b.c(this.mContext, R.color.sheroes_feed_title)), str2.length(), str2.length() + str3.length() + 3, 0);
                spannableString.setSpan(new TypefaceSpan(this.mContext.getResources().getString(R.string.sheroes_ID_ROBOTO_REGULAR)), str2.length(), str2.length() + str3.length() + 3, 0);
                spannableString.setSpan(new TypefaceSpan(this.mContext.getResources().getString(R.string.sheroes_ID_ROBOTO_MEDIUM)), str2.length() + str3.length() + 2, str.length(), 0);
                spannableString.setSpan(new ForegroundColorSpan(b.c(this.mContext, R.color.sheroes_feed_title)), str2.length() + str3.length() + 2, str.length(), 0);
            }
            this.tvFeedCommunityPostCardTitle.setMovementMethod(LinkMovementMethod.getInstance());
            this.tvFeedCommunityPostCardTitle.setText(spannableString, TextView.BufferType.SPANNABLE);
            this.tvFeedCommunityPostCardTitle.setSelected(true);
        }
    }

    private void clickOnCommunityName(String str, String str2, String str3) {
        SpannableString spannableString = new SpannableString(str);
        AnonymousClass6 r1 = new ClickableSpan() {
            public void onClick(View view) {
            }

            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        };
        AnonymousClass7 r2 = new ClickableSpan() {
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
                spannableString.setSpan(new TypefaceSpan(this.mContext.getResources().getString(R.string.sheroes_ID_ROBOTO_MEDIUM)), str2.length() + str3.length() + 2, str.length(), 0);
                spannableString.setSpan(new ForegroundColorSpan(b.c(this.mContext, R.color.sheroes_feed_title)), str2.length() + str3.length() + 2, str.length(), 0);
            }
            this.tvFeedCommunityPostCardTitle.setMovementMethod(LinkMovementMethod.getInstance());
            this.tvFeedCommunityPostCardTitle.setText(spannableString, TextView.BufferType.SPANNABLE);
            this.tvFeedCommunityPostCardTitle.setSelected(true);
        }
    }

    private void handlingSpamUi(long j, int i2) {
        if (i2 == 2 || this.mUserPostObj.isCommunityOwner()) {
            this.liCommunityPostMainLayout.setBackgroundColor(b.c(this.mContext, R.color.sheroes_white));
            this.liCommunityPostMainLayout.setAlpha(1.0f);
            this.flSpamPostUi.setVisibility(0);
            this.liFeedCommunityPostUserComments.setVisibility(8);
            this.liApproveDelete.setVisibility(0);
            this.tvReviewDescription.setVisibility(8);
        } else if (this.mUserPostObj.getAuthorId() == j) {
            this.liCommunityPostMainLayout.setBackgroundColor(b.c(this.mContext, R.color.sheroes_spam_post));
            this.liCommunityPostMainLayout.setAlpha(0.2f);
            this.flSpamPostUi.setVisibility(0);
            this.liFeedCommunityPostUserComments.setVisibility(8);
            this.liApproveDelete.setVisibility(8);
            this.tvReviewDescription.setVisibility(0);
        } else {
            this.liCommunityPostMainLayout.setBackgroundColor(b.c(this.mContext, R.color.sheroes_white));
            this.liCommunityPostMainLayout.setAlpha(1.0f);
            this.flSpamPostUi.setVisibility(8);
            this.liFeedCommunityPostUserComments.setVisibility(0);
            this.liApproveDelete.setVisibility(8);
            this.tvReviewDescription.setVisibility(0);
        }
    }

    private void onApproveSpamPostClick() {
        BaseHolderInterface baseHolderInterface = this.viewInterface;
        if (baseHolderInterface instanceof FeedItemCallback) {
            ((FeedItemCallback) baseHolderInterface).onSpamPostApprove(this.mUserPostObj);
        } else {
            baseHolderInterface.handleOnClick(this.mUserPostObj, this.tvApproveSpamPost);
        }
    }

    private void onDeleteSpamPostClick() {
        BaseHolderInterface baseHolderInterface = this.viewInterface;
        if (baseHolderInterface instanceof FeedItemCallback) {
            ((FeedItemCallback) baseHolderInterface).onSpamPostDelete(this.mUserPostObj);
        } else {
            baseHolderInterface.handleOnClick(this.mUserPostObj, this.tvDeleteSpamPost);
        }
    }

    private void onCommentLikeClicked() {
        List<Comment> lastComments = this.mUserPostObj.getLastComments();
        if (StringUtil.isNotEmptyCollection(lastComments)) {
            this.mItemPosition = lastComments.size() - 1;
            Comment comment = lastComments.get(this.mItemPosition);
            comment.setItemPosition(this.mUserPostObj.getItemPosition());
            if (comment.isLiked) {
                comment.isLiked = false;
                comment.likeCount--;
            } else {
                comment.isLiked = true;
                comment.likeCount++;
            }
            invalidateCommentLike(comment);
            if (this.viewInterface instanceof FeedItemCallback) {
                if (comment.isLiked) {
                    ((FeedItemCallback) this.viewInterface).userCommentLikeRequest(this.mUserPostObj, true, getAdapterPosition());
                } else {
                    ((FeedItemCallback) this.viewInterface).userCommentLikeRequest(this.mUserPostObj, false, getAdapterPosition());
                }
            } else if (!comment.isLiked) {
                this.viewInterface.userCommentLikeRequest(comment, 0, getAdapterPosition());
            } else {
                this.viewInterface.userCommentLikeRequest(comment, 10, getAdapterPosition());
            }
        }
    }
}
