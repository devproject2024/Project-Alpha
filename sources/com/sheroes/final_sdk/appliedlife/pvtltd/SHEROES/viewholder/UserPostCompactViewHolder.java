package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.viewholder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.b;
import androidx.recyclerview.widget.RecyclerView;
import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseHolderInterface;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.FeedItemCallback;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.ConfigData;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.Configuration;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.comment.Comment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.UserPostSolrObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.LoginResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.DateUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.stringutils.StringUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CircleImageView;
import com.squareup.picasso.af;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.List;

public class UserPostCompactViewHolder extends RecyclerView.v {
    private int authorProfileSize;
    private int commentAuthorProfileSize;
    private int mAuthorPicSize;
    private ImageView mAuthorVerifiedIcon;
    private CircleImageView mCommentAuthorImage;
    private TextView mCommentAuthorName;
    private ImageView mCommentAuthorVerifiedIcon;
    private RelativeLayout mCommentContainer;
    private TextView mCommentDescription;
    private TextView mCommentLike;
    private TextView mCommentRelativeTime;
    Preference<Configuration> mConfiguration;
    private Context mContext;
    private CircleImageView mConversationAuthorImageConversation;
    private ImageView mConversationAuthorVerifiedIcon;
    DateUtil mDateUtil;
    private RelativeLayout mImageContainer;
    private ImageView mImageFirst;
    private ImageView mImageSecond;
    private TextView mJoinConversation;
    private RelativeLayout mJoinConversationContainer;
    private RelativeLayout mLastCommentContainer;
    private RelativeLayout mLinkContainer;
    private TextView mLinkDescription;
    /* access modifiers changed from: private */
    public ImageView mLinkImage;
    private int mLinkImageHeight;
    private TextView mLinkSubTitle;
    private TextView mMoreImageCount;
    /* access modifiers changed from: private */
    public ImageView mPlayIcon;
    private CircleImageView mPostAuthorImage;
    private TextView mPostCommentButton;
    private TextView mPostCommentsCount;
    private TextView mPostDescription;
    private TextView mPostLikeButton;
    private TextView mPostLikeCount;
    private TextView mPostRelativeTime;
    private TextView mPostShareButton;
    private RelativeLayout mSecondImageContainer;
    private TextView mTitle;
    private CardView mUserCompactCard;
    /* access modifiers changed from: private */
    public UserPostSolrObj mUserPostObj;
    Preference<LoginResponse> userPreference;
    private BaseHolderInterface viewInterface;

    public UserPostCompactViewHolder(View view, Context context, BaseHolderInterface baseHolderInterface) {
        super(view);
        this.mUserCompactCard = (CardView) view.findViewById(R.id.sheroes_user_post_compact_card);
        this.mUserCompactCard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UserPostCompactViewHolder.this.onUserCardClicked();
            }
        });
        this.mPostAuthorImage = (CircleImageView) view.findViewById(R.id.sheroes_post_author_image);
        this.mAuthorVerifiedIcon = (ImageView) view.findViewById(R.id.sheroes_author_verified_icon);
        this.mTitle = (TextView) view.findViewById(R.id.sheroes_post_title);
        this.mPostRelativeTime = (TextView) view.findViewById(R.id.sheroes_post_relative_time);
        this.mPostDescription = (TextView) view.findViewById(R.id.sheroes_post_description);
        this.mImageContainer = (RelativeLayout) view.findViewById(R.id.sheroes_image_container);
        this.mImageFirst = (ImageView) view.findViewById(R.id.sheroes_image_first);
        this.mImageSecond = (ImageView) view.findViewById(R.id.sheroes_image_second);
        this.mSecondImageContainer = (RelativeLayout) view.findViewById(R.id.sheroes_second_image_container);
        this.mMoreImageCount = (TextView) view.findViewById(R.id.sheroes_more_image_count);
        this.mLinkContainer = (RelativeLayout) view.findViewById(R.id.sheroes_link_detail_container);
        this.mLinkImage = (ImageView) view.findViewById(R.id.sheroes_link_image);
        this.mPlayIcon = (ImageView) view.findViewById(R.id.sheroes_play_icon);
        this.mLinkDescription = (TextView) view.findViewById(R.id.sheroes_link_description);
        this.mLinkSubTitle = (TextView) view.findViewById(R.id.sheroes_link_sub_title);
        this.mPostCommentButton = (TextView) view.findViewById(R.id.sheroes_post_comment_button);
        this.mPostLikeButton = (TextView) view.findViewById(R.id.sheroes_post_like_button);
        this.mPostLikeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UserPostCompactViewHolder.this.onCommentLikeClicked();
            }
        });
        this.mPostCommentsCount = (TextView) view.findViewById(R.id.sheroes_post_comments_count);
        this.mPostLikeCount = (TextView) view.findViewById(R.id.sheroes_post_like_count);
        this.mCommentContainer = (RelativeLayout) view.findViewById(R.id.sheroes_comment_container);
        this.mCommentAuthorVerifiedIcon = (ImageView) view.findViewById(R.id.sheroes_comment_author_verified_icon);
        this.mCommentAuthorImage = (CircleImageView) view.findViewById(R.id.sheroes_comment_author_image);
        this.mLastCommentContainer = (RelativeLayout) view.findViewById(R.id.sheroes_last_comment_container);
        this.mPostShareButton = (TextView) view.findViewById(R.id.sheroes_post_share_button);
        this.mPostShareButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UserPostCompactViewHolder.this.onPostShareClicked();
            }
        });
        this.mCommentAuthorName = (TextView) view.findViewById(R.id.sheroes_comment_author_name);
        this.mCommentDescription = (TextView) view.findViewById(R.id.sheroes_comment_description);
        this.mCommentRelativeTime = (TextView) view.findViewById(R.id.sheroes_comment_relative_time);
        this.mCommentLike = (TextView) view.findViewById(R.id.sheroes_comment_like);
        this.mCommentLike.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                UserPostCompactViewHolder.this.userReactionClick();
            }
        });
        this.mConversationAuthorVerifiedIcon = (ImageView) view.findViewById(R.id.sheroes_conversation_author_verified_icon);
        this.mConversationAuthorImageConversation = (CircleImageView) view.findViewById(R.id.sheroes_conversation_author_image_conversation);
        this.mJoinConversationContainer = (RelativeLayout) view.findViewById(R.id.sheroes_join_conversation_container);
        this.mJoinConversation = (TextView) view.findViewById(R.id.sheroes_join_conversation);
        this.mAuthorPicSize = view.getResources().getDimensionPixelSize(R.dimen.sheroes_dp_size_150);
        this.mLinkImageHeight = view.getResources().getDimensionPixelSize(R.dimen.sheroes_dp_size_100);
        this.authorProfileSize = view.getResources().getDimensionPixelSize(R.dimen.sheroes_dp_size_40);
        this.commentAuthorProfileSize = view.getResources().getDimensionPixelSize(R.dimen.sheroes_dp_size_30);
        SheroesSdk.getAppComponent(view.getContext()).inject(this);
        this.mContext = context;
        this.viewInterface = baseHolderInterface;
    }

    public void bindData(UserPostSolrObj userPostSolrObj, Context context) {
        String str;
        if (this.mDateUtil == null) {
            this.mDateUtil = DateUtil.getInstance();
        }
        this.mUserPostObj = userPostSolrObj;
        if (CommonUtil.isNotEmpty(userPostSolrObj.getAuthorImageUrl())) {
            this.mPostAuthorImage.setCircularImage(true);
            String authorImageUrl = userPostSolrObj.getAuthorImageUrl();
            int i2 = this.authorProfileSize;
            this.mPostAuthorImage.bindImage(CommonUtil.getThumborUri(authorImageUrl, i2, i2));
        }
        Preference<Configuration> preference = this.mConfiguration;
        if (preference == null || !preference.isSet() || this.mConfiguration.get().configData == null) {
            this.mJoinConversation.setText(new ConfigData().mCommentHolderText);
        } else {
            this.mJoinConversation.setText(this.mConfiguration.get().configData.mCommentHolderText);
        }
        String quantityString = this.mContext.getResources().getQuantityString(R.plurals.numberOfLikes, userPostSolrObj.getNoOfLikes());
        TextView textView = this.mPostLikeCount;
        textView.setText(String.valueOf(userPostSolrObj.getNoOfLikes() + " " + quantityString));
        if (userPostSolrObj.getCommunityTypeId() == 3) {
            str = this.mContext.getResources().getQuantityString(R.plurals.numberOfAnswers, userPostSolrObj.getNoOfComments());
        } else {
            str = this.mContext.getResources().getQuantityString(R.plurals.numberOfComments, userPostSolrObj.getNoOfComments());
        }
        TextView textView2 = this.mPostCommentsCount;
        textView2.setText(String.valueOf(userPostSolrObj.getNoOfComments() + " " + str));
        String listDescription = userPostSolrObj.getListDescription();
        if (!StringUtil.isNotNullOrEmptyString(listDescription)) {
            this.mPostDescription.setText("");
            this.mPostDescription.setVisibility(0);
        } else {
            this.mPostDescription.setText(StringUtil.hashTagColorInString(listDescription));
            this.mPostDescription.setVisibility(0);
        }
        StringUtil.linkifyURLs(this.mPostDescription);
        allTextViewStringOperations(this.mContext);
        if (!CommonUtil.isEmpty(this.mUserPostObj.getImageUrls())) {
            this.mLinkContainer.setVisibility(8);
            this.mImageContainer.setVisibility(0);
            this.mCommentContainer.setVisibility(8);
            this.mPostDescription.setMaxLines(1);
            setImage();
        } else if (StringUtil.isNotNullOrEmptyString(this.mUserPostObj.getOgRequestedUrlS())) {
            this.mLinkContainer.setVisibility(0);
            this.mImageContainer.setVisibility(8);
            this.mCommentContainer.setVisibility(8);
            this.mPostDescription.setMaxLines(1);
            setLinkData();
        } else {
            this.mPostDescription.setMaxLines(2);
            this.mLinkContainer.setVisibility(8);
            this.mImageContainer.setVisibility(8);
            this.mCommentContainer.setVisibility(0);
            userComments();
        }
        invalidatePostLike(userPostSolrObj);
    }

    private void setImage() {
        this.mPostDescription.setLines(1);
        if (!CommonUtil.isEmpty(this.mUserPostObj.getImageUrls())) {
            this.mImageContainer.setVisibility(0);
            if (this.mUserPostObj.getImageUrls().size() >= 2) {
                this.mImageFirst.setVisibility(0);
                this.mImageSecond.setVisibility(0);
                this.mSecondImageContainer.setVisibility(0);
                w.a().a(CommonUtil.getThumborUri(this.mUserPostObj.getImageUrls().get(0), CommonUtil.getWindowWidth(this.mContext) / 2, this.mAuthorPicSize)).a(this.mImageFirst, (e) null);
                this.mImageFirst.setVisibility(0);
                w.a().a(CommonUtil.getThumborUri(this.mUserPostObj.getImageUrls().get(1), CommonUtil.getWindowWidth(this.mContext) / 2, this.mAuthorPicSize)).a(this.mImageSecond, (e) null);
                if (this.mUserPostObj.getImageUrls().size() > 2) {
                    this.mMoreImageCount.setVisibility(0);
                    TextView textView = this.mMoreImageCount;
                    textView.setText("+ " + Integer.toString(this.mUserPostObj.getImageUrls().size() - 1));
                    this.mImageSecond.setBackgroundColor(this.mContext.getResources().getColor(R.color.sheroes_feed_article_label));
                    return;
                }
                this.mMoreImageCount.setVisibility(8);
                this.mImageSecond.setBackgroundColor(0);
                return;
            }
            this.mImageSecond.setVisibility(8);
            this.mSecondImageContainer.setVisibility(8);
            this.mImageFirst.setVisibility(0);
            w.a().a(CommonUtil.getThumborUri(this.mUserPostObj.getImageUrls().get(0), CommonUtil.getWindowWidth(this.mContext), this.mAuthorPicSize)).a(this.mImageFirst, (e) null);
            return;
        }
        this.mImageContainer.setVisibility(8);
        this.mCommentContainer.setVisibility(0);
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
            this.mPostRelativeTime.setText(this.mDateUtil.getRoundedDifferenceInHours(System.currentTimeMillis(), this.mDateUtil.getTimeInMillis(this.mUserPostObj.getCreatedDate(), AppConstants.DATE_FORMAT)));
        } else {
            this.mPostRelativeTime.setText(this.mContext.getString(R.string.sheroes_ID_JUST_NOW));
        }
    }

    private void clickOnMentorAndCommunityName(String str, String str2, String str3) {
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
        AnonymousClass7 r3 = new ClickableSpan() {
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
            this.mTitle.setMovementMethod(LinkMovementMethod.getInstance());
            this.mTitle.setText(spannableString, TextView.BufferType.SPANNABLE);
            this.mTitle.setSelected(true);
        }
    }

    private void clickOnMentorName(String str, String str2, String str3) {
        SpannableString spannableString = new SpannableString(str);
        AnonymousClass8 r1 = new ClickableSpan() {
            public void onClick(View view) {
            }

            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        };
        AnonymousClass9 r2 = new ClickableSpan() {
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
                spannableString.setSpan(new ForegroundColorSpan(b.c(this.mContext, R.color.sheroes_feed_title)), 0, str2.length(), 0);
            }
            if (StringUtil.isNotNullOrEmptyString(str3) && StringUtil.isNotNullOrEmptyString(str)) {
                spannableString.setSpan(new ForegroundColorSpan(b.c(this.mContext, R.color.sheroes_feed_title)), str2.length(), str2.length() + str3.length() + 1, 0);
                spannableString.setSpan(r2, str2.length() + str3.length() + 2, str.length(), 0);
                spannableString.setSpan(new TypefaceSpan(this.mContext.getResources().getString(R.string.sheroes_ID_ROBOTO_REGULAR)), str2.length(), str2.length() + str3.length() + 3, 0);
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
        AnonymousClass10 r1 = new ClickableSpan() {
            public void onClick(View view) {
            }

            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        };
        AnonymousClass11 r2 = new ClickableSpan() {
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
                spannableString.setSpan(new TypefaceSpan(this.mContext.getResources().getString(R.string.sheroes_ID_ROBOTO_REGULAR)), str2.length(), str.length(), 0);
            }
            this.mTitle.setMovementMethod(LinkMovementMethod.getInstance());
            this.mTitle.setText(spannableString, TextView.BufferType.SPANNABLE);
            this.mTitle.setSelected(true);
        }
    }

    private void setLinkData() {
        this.mPostDescription.setLines(1);
        if (StringUtil.isNotNullOrEmptyString(this.mUserPostObj.getOgTitleS())) {
            this.mLinkDescription.setText(this.mUserPostObj.getOgTitleS());
        }
        if (StringUtil.isNotNullOrEmptyString(this.mUserPostObj.getOgDescriptionS())) {
            this.mLinkSubTitle.setText(this.mUserPostObj.getOgDescriptionS());
        }
        if (StringUtil.isNotNullOrEmptyString(this.mUserPostObj.getOgImageUrlS())) {
            String thumborUri = CommonUtil.getThumborUri(this.mUserPostObj.getOgImageUrlS(), CommonUtil.getWindowWidth(this.mContext), this.mLinkImageHeight);
            AnonymousClass12 r1 = new af() {
                public void onBitmapFailed(Exception exc, Drawable drawable) {
                }

                public void onPrepareLoad(Drawable drawable) {
                }

                public void onBitmapLoaded(Bitmap bitmap, w.d dVar) {
                    new LinearLayout.LayoutParams(-1, -2);
                    UserPostCompactViewHolder.this.mLinkImage.setVisibility(0);
                    UserPostCompactViewHolder.this.mLinkImage.setImageBitmap(bitmap);
                    if (UserPostCompactViewHolder.this.mUserPostObj.isOgVideoLinkB()) {
                        UserPostCompactViewHolder.this.mPlayIcon.getBackground().setAlpha(75);
                        UserPostCompactViewHolder.this.mPlayIcon.setVisibility(0);
                        return;
                    }
                    UserPostCompactViewHolder.this.mPlayIcon.setVisibility(8);
                }
            };
            this.mLinkImage.setTag(r1);
            w.a().a(thumborUri).a((af) r1);
            this.mLinkContainer.setVisibility(0);
            return;
        }
        this.mLinkContainer.setVisibility(8);
    }

    private void userComments() {
        List<Comment> lastComments = this.mUserPostObj.getLastComments();
        this.mPostDescription.setLines(2);
        if (StringUtil.isNotEmptyCollection(lastComments)) {
            this.mLastCommentContainer.setVisibility(0);
            this.mJoinConversationContainer.setVisibility(8);
            Comment comment = lastComments.get(lastComments.size() - 1);
            this.mCommentAuthorImage.setCircularImage(true);
            invalidateCommentLike(comment);
            if (comment.isAnonymous()) {
                if (StringUtil.isNotNullOrEmptyString(comment.getParticipantName())) {
                    String participantImageUrl = comment.getParticipantImageUrl();
                    int i2 = this.commentAuthorProfileSize;
                    this.mCommentAuthorImage.bindImage(CommonUtil.getThumborUri(participantImageUrl, i2, i2));
                    this.mCommentAuthorName.setText(comment.getParticipantName());
                    this.mCommentDescription.setText(StringUtil.hashTagColorInString(comment.getComment()));
                    this.mCommentAuthorVerifiedIcon.setVisibility(8);
                    invalidateCommentLike(comment);
                }
            } else if (StringUtil.isNotNullOrEmptyString(comment.getComment()) && StringUtil.isNotNullOrEmptyString(comment.getParticipantName())) {
                String participantImageUrl2 = comment.getParticipantImageUrl();
                int i3 = this.authorProfileSize;
                this.mCommentAuthorImage.bindImage(CommonUtil.getThumborUri(participantImageUrl2, i3, i3));
                this.mCommentAuthorName.setText(comment.getParticipantName());
                this.mCommentDescription.setText(StringUtil.hashTagColorInString(comment.getComment()));
                if (comment.getParticipantName().equalsIgnoreCase(this.mContext.getString(R.string.sheroes_ID_COMMUNITY_ANNONYMOUS))) {
                    this.mCommentAuthorVerifiedIcon.setVisibility(8);
                } else if (comment.isVerifiedMentor()) {
                    this.mCommentAuthorVerifiedIcon.setVisibility(0);
                } else {
                    this.mCommentAuthorVerifiedIcon.setVisibility(8);
                }
            }
            StringUtil.linkifyURLs(this.mCommentDescription);
            if (StringUtil.isNotNullOrEmptyString(comment.getLastModifiedOn())) {
                this.mCommentRelativeTime.setText(this.mDateUtil.getRoundedDifferenceInHours(System.currentTimeMillis(), this.mDateUtil.getTimeInMillis(comment.getLastModifiedOn(), AppConstants.DATE_FORMAT)));
            } else {
                this.mCommentRelativeTime.setText(this.mContext.getString(R.string.sheroes_ID_JUST_NOW));
            }
            if (comment.isMyOwnParticipation()) {
                this.mCommentRelativeTime.setVisibility(0);
            } else {
                this.mCommentRelativeTime.setVisibility(8);
            }
        } else {
            this.mLastCommentContainer.setVisibility(8);
            this.mJoinConversationContainer.setVisibility(0);
            if (StringUtil.isNotNullOrEmptyString(this.userPreference.get().getUserSummary().getPhotoUrl())) {
                String photoUrl = this.userPreference.get().getUserSummary().getPhotoUrl();
                int i4 = this.commentAuthorProfileSize;
                String thumborUri = CommonUtil.getThumborUri(photoUrl, i4, i4);
                this.mConversationAuthorImageConversation.setCircularImage(true);
                this.mConversationAuthorImageConversation.bindImage(thumborUri);
            }
        }
    }

    private void invalidateCommentLike(Comment comment) {
        this.mCommentLike.setVisibility(0);
        if (comment.likeCount == 0) {
            this.mCommentLike.setText("");
        } else {
            this.mCommentLike.setText(Integer.toString(comment.likeCount));
        }
        if (comment.isLiked) {
            this.mCommentLike.setCompoundDrawablesWithIntrinsicBounds(R.drawable.vector_sheroes_heart_activie_16dp, 0, 0, 0);
        } else {
            this.mCommentLike.setCompoundDrawablesWithIntrinsicBounds(R.drawable.vector_sheroes_heart_inactive_16dp, 0, 0, 0);
        }
    }

    private void invalidatePostLike(UserPostSolrObj userPostSolrObj) {
        if (this.mUserPostObj.getReactedValue() == 0) {
            this.mPostLikeButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.vector_sheroes_heart_in_active, 0, 0, 0);
        } else {
            this.mPostLikeButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.vector_sheroes_heart_active, 0, 0, 0);
        }
    }

    /* access modifiers changed from: private */
    public void onUserCardClicked() {
        ((FeedItemCallback) this.viewInterface).onUserPostClicked(this.mUserPostObj);
    }

    /* access modifiers changed from: private */
    public void userReactionClick() {
        if (this.viewInterface instanceof FeedItemCallback) {
            if (this.mUserPostObj.getReactionValue() != 0) {
                this.mUserPostObj.setReactionValue(0);
                UserPostSolrObj userPostSolrObj = this.mUserPostObj;
                userPostSolrObj.setNoOfLikes(userPostSolrObj.getNoOfLikes() - 1);
                this.mPostLikeButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.vector_sheroes_heart_in_active, 0, 0, 0);
                ((FeedItemCallback) this.viewInterface).onUserPostUnLiked(this.mUserPostObj);
            } else {
                this.mUserPostObj.setReactionValue(10);
                UserPostSolrObj userPostSolrObj2 = this.mUserPostObj;
                userPostSolrObj2.setNoOfLikes(userPostSolrObj2.getNoOfLikes() + 1);
                this.mPostLikeButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.vector_sheroes_heart_active, 0, 0, 0);
                ((FeedItemCallback) this.viewInterface).onUserPostLiked(this.mUserPostObj);
            }
            String quantityString = this.mContext.getResources().getQuantityString(R.plurals.numberOfLikes, this.mUserPostObj.getNoOfLikes());
            TextView textView = this.mPostLikeCount;
            textView.setText(String.valueOf(this.mUserPostObj.getNoOfLikes() + " " + quantityString));
        }
    }

    /* access modifiers changed from: private */
    public void onCommentLikeClicked() {
        List<Comment> lastComments = this.mUserPostObj.getLastComments();
        if (StringUtil.isNotEmptyCollection(lastComments)) {
            Comment comment = lastComments.get(lastComments.size() - 1);
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

    /* access modifiers changed from: private */
    public void onPostShareClicked() {
        BaseHolderInterface baseHolderInterface = this.viewInterface;
        if (baseHolderInterface instanceof FeedItemCallback) {
            ((FeedItemCallback) baseHolderInterface).onPostShared(this.mUserPostObj);
        }
    }
}
