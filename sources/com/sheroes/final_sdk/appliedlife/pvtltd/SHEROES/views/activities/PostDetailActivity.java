package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.t;
import androidx.core.app.f;
import androidx.core.app.p;
import androidx.core.content.b;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.y;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.play.core.splitcompat.a;
import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.AnalyticsManager;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.Event;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.EventProperty;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseActivity;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.CommentCallBack;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.PostDetailCallBack;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.SheroesPresenter;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baseresponse.BaseResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.Configuration;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.comment.Comment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.FeedDetail;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.UserPostSolrObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.LoginResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters.PostDetailViewImpl;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppUtils;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.stringutils.StringUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.adapters.PostDetailAdapter;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CircleImageView;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.FeedFragment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.LikeListBottomSheetFragment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.viewlisteners.IPostDetailView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.parceler.g;

public class PostDetailActivity extends BaseActivity implements CommentCallBack, PostDetailCallBack, IPostDetailView {
    public static final String IS_POST_DELETED = "Is Post Deleted";
    public static final int MAX_LINE = 5;
    public static final String SCREEN_LABEL = "Post Detail Screen";
    public static final String SCREEN_LABEL_PAYTM = "/sheroes/post-detail";
    public static final String SHOW_KEYBOARD = "Show Keyboard";
    public static final int SINGLE_LINE = 1;
    LinearLayout liUserPostTypeSelection;
    AppUtils mAppUtils;
    Preference<Configuration> mConfiguration;
    private int mFromNotification;
    EditText mInputText;
    private boolean mIsAnonymous;
    public int mPositionInFeed = -1;
    private PostDetailAdapter mPostDetailListAdapter;
    PostDetailViewImpl mPostDetailPresenter;
    private String mPrimaryColor = "#ffffff";
    ProgressBar mProgressBar;
    RecyclerView mRecyclerView;
    ImageView mSendButton;
    private String mStatusBarColor = "#aaaaaa";
    private boolean mStatusBarColorEmpty = true;
    private String mTitleTextColor = "#3c3c3c";
    TextView mTitleToolbar;
    Toolbar mToolbar;
    private String mToolbarIconColor = "#90949C";
    CircleImageView mUserPic;
    private String mUserPostId;
    private UserPostSolrObj mUserPostObj;
    Preference<LoginResponse> mUserPreference;
    int profileSize;
    private String streamType;
    TextView tvAnonymousPost;
    TextView tvUserNameForPost;

    public String getScreenName() {
        return SCREEN_LABEL_PAYTM;
    }

    public void onSpamMenuClicked(UserPostSolrObj userPostSolrObj, TextView textView) {
    }

    public boolean shouldTrackScreen() {
        return true;
    }

    public boolean trackScreenTime() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SheroesSdk.getAppComponent(this).inject(this);
        setContentView(R.layout.activity_sheroes_post_detail);
        this.mToolbar = (Toolbar) findViewById(R.id.sheroes_toolbar);
        this.mProgressBar = (ProgressBar) findViewById(R.id.sheroes_progress_bar);
        this.mRecyclerView = (RecyclerView) findViewById(R.id.sheroes_user_comment_list);
        this.mTitleToolbar = (TextView) findViewById(R.id.sheroes_title_toolbar);
        this.mInputText = (EditText) findViewById(R.id.sheroes_input_edit_text);
        this.mUserPic = (CircleImageView) findViewById(R.id.sheroes_user_pic);
        this.mSendButton = (ImageView) findViewById(R.id.sheroes_sendButton);
        this.mSendButton.setOnClickListener(this);
        this.liUserPostTypeSelection = (LinearLayout) findViewById(R.id.sheroes_li_user_comment_post_type_selection);
        this.tvUserNameForPost = (TextView) findViewById(R.id.sheroes_tv_user_name_for_post);
        this.tvUserNameForPost.setOnClickListener(this);
        this.tvAnonymousPost = (TextView) findViewById(R.id.sheroes_tv_anonymous_post);
        this.tvAnonymousPost.setOnClickListener(this);
        this.profileSize = getResources().getDimensionPixelSize(R.dimen.sheroes_dp_size_36);
        this.mPostDetailPresenter.attachView(this);
        this.mUserPic.setCircularImage(true);
        Parcelable parcelableExtra = getIntent().getParcelableExtra(UserPostSolrObj.USER_POST_OBJ);
        if (parcelableExtra != null) {
            this.mUserPostObj = (UserPostSolrObj) g.a(parcelableExtra);
            this.mPositionInFeed = this.mUserPostObj.getItemPosition();
            this.streamType = this.mUserPostObj.getStreamType();
            if (getIntent().getExtras().getBoolean(SHOW_KEYBOARD, false)) {
                getWindow().setSoftInputMode(4);
            }
        } else {
            this.mUserPostId = getIntent().getStringExtra(UserPostSolrObj.USER_POST_ID);
            if (!CommonUtil.isNotEmpty(this.mUserPostId)) {
                return;
            }
        }
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            this.mFromNotification = getIntent().getExtras().getInt(AppConstants.FROM_PUSH_NOTIFICATION);
            this.mPrimaryColor = getIntent().getExtras().getString(FeedFragment.PRIMARY_COLOR, this.mPrimaryColor);
            this.mTitleTextColor = getIntent().getExtras().getString(FeedFragment.TITLE_TEXT_COLOR, this.mTitleTextColor);
            if (getIntent().getExtras().getString(FeedFragment.PRIMARY_COLOR) == null) {
                this.mStatusBarColorEmpty = true;
            }
        }
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        ((y) this.mRecyclerView.getItemAnimator()).m = false;
        initAdapter();
        this.mPostDetailPresenter.setUserPost(this.mUserPostObj, this.mUserPostId);
        this.mPostDetailPresenter.fetchUserPost();
        Preference<LoginResponse> preference = this.mUserPreference;
        if (preference != null && preference.isSet() && this.mUserPreference.get().getUserSummary() != null && StringUtil.isNotNullOrEmptyString(this.mUserPreference.get().getUserSummary().getFirstName())) {
            this.tvUserNameForPost.setText(this.mUserPreference.get().getUserSummary().getFirstName());
            this.mUserPic.setCircularImage(true);
            String photoUrl = this.mUserPreference.get().getUserSummary().getPhotoUrl();
            int i2 = this.profileSize;
            this.mUserPic.bindImage(CommonUtil.getThumborUri(photoUrl, i2, i2));
        }
        setSupportActionBar(this.mToolbar);
        getSupportActionBar().c(false);
        getSupportActionBar().b(true);
        UserPostSolrObj userPostSolrObj = this.mUserPostObj;
        if (userPostSolrObj != null && StringUtil.isNotNullOrEmptyString(userPostSolrObj.getAuthorName())) {
            TextView textView = this.mTitleToolbar;
            textView.setText(this.mUserPostObj.getAuthorName() + "'s post");
        }
        Preference<Configuration> preference2 = this.mConfiguration;
        if (preference2 == null || !preference2.isSet() || this.mConfiguration.get().configData == null) {
            this.mInputText.setHint("Type your comment here...");
        } else {
            this.mInputText.setHint(this.mConfiguration.get().configData.mCommentHolderText);
        }
        setupEditInputText();
        setupToolbarItemsColor();
    }

    public void userNamePostForComment() {
        this.mIsAnonymous = false;
        this.tvUserNameForPost.setTextColor(b.c(this, R.color.colorPrimary));
        this.tvAnonymousPost.setTextColor(b.c(this, R.color.sheroes_search_box_text_color));
    }

    public void anonymousPostForComment() {
        this.mIsAnonymous = true;
        this.tvUserNameForPost.setTextColor(b.c(this, R.color.sheroes_search_box_text_color));
        this.tvAnonymousPost.setTextColor(b.c(this, R.color.colorPrimary));
    }

    public Event getEventScreenName() {
        return Event.POST_DETAIL_SCREEN_LOADED;
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showError(int i2) {
        Snackbar.a((View) this.mRecyclerView, i2, 0).c();
    }

    public void onBackPressed() {
        Intent a2 = f.a(this);
        if (a2 != null) {
            if (f.a((Activity) this, a2)) {
                p.a((Context) this).b(a2).a();
            } else if (this.mFromNotification > 0) {
                p.a((Context) this).b(a2).a();
            }
        }
        setResult();
        super.onBackPressed();
    }

    public void onResume() {
        super.onResume();
        a.a((Context) this);
        a.b((Context) this);
    }

    public SheroesPresenter getPresenter() {
        return this.mPostDetailPresenter;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        CommonUtil.hideKeyboard(this);
        if (menuItem.getItemId() != 16908332) {
            return true;
        }
        onBackPressed();
        return true;
    }

    private void setResult() {
        UserPostSolrObj userPostObj = this.mPostDetailPresenter.getUserPostObj();
        if (userPostObj != null) {
            userPostObj.setItemPosition(this.mPositionInFeed);
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putParcelable(UserPostSolrObj.USER_POST_OBJ, g.a(userPostObj));
            intent.putExtras(bundle);
            setResult(-1, intent);
        }
    }

    public void addAllPost(int i2, List<Comment> list) {
        this.mPostDetailListAdapter.addDatas(i2, list);
    }

    public void addData(int i2, BaseResponse baseResponse) {
        this.mPostDetailListAdapter.addData(baseResponse, i2);
    }

    public void removeData(int i2) {
        this.mPostDetailListAdapter.removeData(i2);
    }

    public void setData(int i2, BaseResponse baseResponse) {
        this.mPostDetailListAdapter.setData(i2, baseResponse);
    }

    public void onPostDeleted() {
        UserPostSolrObj userPostObj = this.mPostDetailPresenter.getUserPostObj();
        userPostObj.setItemPosition(this.mPositionInFeed);
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putParcelable(UserPostSolrObj.USER_POST_OBJ, g.a(userPostObj));
        bundle.putBoolean(IS_POST_DELETED, true);
        intent.putExtras(bundle);
        setResult(-1, intent);
        super.onBackPressed();
    }

    public void editLastComment() {
        Comment lastComment = this.mPostDetailPresenter.getLastComment();
        if (lastComment != null) {
            onEditMenuClicked(lastComment);
        }
    }

    public void deleteLastComment() {
        Comment lastComment = this.mPostDetailPresenter.getLastComment();
        if (lastComment != null) {
            onDeleteMenuClicked(lastComment);
        }
    }

    public String getStreamType() {
        return this.streamType;
    }

    public void addData(BaseResponse baseResponse) {
        this.mPostDetailListAdapter.addData(baseResponse);
    }

    public void setHasMoreComments(boolean z) {
        this.mPostDetailListAdapter.setHasMoreComments(z);
    }

    public void smoothScrollToBottom() {
        UserPostSolrObj userPostObj;
        this.mRecyclerView.smoothScrollToPosition(this.mPostDetailListAdapter.getItemCount() - 1);
        if (this.mUserPostObj == null && (userPostObj = this.mPostDetailPresenter.getUserPostObj()) != null && StringUtil.isNotNullOrEmptyString(userPostObj.getAuthorName())) {
            TextView textView = this.mTitleToolbar;
            textView.setText(userPostObj.getAuthorName() + "'s post");
        }
    }

    public void commentStartedLoading() {
        this.mPostDetailListAdapter.commentStartedLoading();
    }

    public void commentFinishedLoading() {
        this.mPostDetailListAdapter.commentFinishedLoading();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && intent != null && i2 == 5001 && intent.getExtras() != null) {
            this.mPostDetailPresenter.updateUserPost((UserPostSolrObj) g.a(intent.getParcelableExtra(AppConstants.COMMUNITY_POST_FRAGMENT)));
        }
    }

    public static void navigateTo(Activity activity, String str, UserPostSolrObj userPostSolrObj, int i2, HashMap<String, Object> hashMap, boolean z) {
        Intent intent = new Intent(activity, PostDetailActivity.class);
        intent.putExtra(BaseActivity.SOURCE_SCREEN, str);
        intent.putExtra(UserPostSolrObj.USER_POST_OBJ, g.a(userPostSolrObj));
        intent.putExtra(SHOW_KEYBOARD, z);
        if (!CommonUtil.isEmpty(hashMap)) {
            intent.putExtra(BaseActivity.SOURCE_PROPERTIES, hashMap);
        }
        androidx.core.app.a.a(activity, intent, i2, (Bundle) null);
    }

    private void setupEditInputText() {
        this.mInputText.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void afterTextChanged(Editable editable) {
                if (PostDetailActivity.this.mInputText.getText().toString().length() == 0) {
                    PostDetailActivity.this.mInputText.setMaxLines(1);
                    PostDetailActivity.this.mSendButton.setColorFilter(PostDetailActivity.this.getResources().getColor(R.color.colorAccentOpacity), PorterDuff.Mode.MULTIPLY);
                    return;
                }
                PostDetailActivity.this.mInputText.setMaxLines(5);
                PostDetailActivity.this.mSendButton.setColorFilter(PostDetailActivity.this.getResources().getColor(R.color.colorAccent), PorterDuff.Mode.MULTIPLY);
            }
        });
    }

    private void initAdapter() {
        this.mPostDetailListAdapter = new PostDetailAdapter(this, this, this);
        this.mRecyclerView.setAdapter(this.mPostDetailListAdapter);
    }

    /* access modifiers changed from: private */
    public void shareWithMultipleOption(BaseResponse baseResponse) {
        String str;
        FeedDetail feedDetail = (FeedDetail) baseResponse;
        if (StringUtil.isNotNullOrEmptyString(feedDetail.getPostShortBranchUrls())) {
            str = feedDetail.getPostShortBranchUrls();
        } else {
            str = feedDetail.getDeepLinkUrl();
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str);
        startActivity(Intent.createChooser(intent, AppConstants.SHARE));
        HashMap<String, Object> postProperties = AnalyticsManager.getPostProperties(feedDetail, getScreenName());
        postProperties.put(EventProperty.SHARED_TO.getString(), AppConstants.SHARE_CHOOSER);
        AnalyticsManager.trackEvent(Event.POST_SHARED, getScreenName(), (Map<String, Object>) postProperties);
    }

    private CharSequence menuIconWithText(Drawable drawable, String str) {
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        SpannableString spannableString = new SpannableString("    ".concat(String.valueOf(str)));
        spannableString.setSpan(new ImageSpan(drawable, 0), 0, 1, 33);
        return spannableString;
    }

    /* access modifiers changed from: private */
    public String getCreatorType(UserPostSolrObj userPostSolrObj) {
        if (userPostSolrObj.isAnonymous()) {
            return AppConstants.ANONYMOUS;
        }
        return userPostSolrObj.getEntityOrParticipantTypeId().intValue() == 15 ? AppConstants.COMMUNITY_OWNER : AppConstants.USER;
    }

    /* access modifiers changed from: private */
    public void onDeleteMenuClicked(Comment comment) {
        HashMap<String, Object> build = new EventProperty.Builder().id(Long.toString((long) comment.getId())).title(comment.getComment()).positionInList(Integer.valueOf(comment.getItemPosition())).build();
        EventProperty.Builder communityId = new EventProperty.Builder().communityId(comment.getCommunityId());
        UserPostSolrObj userPostSolrObj = this.mUserPostObj;
        trackEvent(Event.REPLY_DELETED, new EventProperty.Builder().eventLabel(build).eventLabel2(communityId.communityName(userPostSolrObj != null ? userPostSolrObj.getPostCommunityName() : "").streamType(this.streamType).build()).build());
        this.mPostDetailPresenter.editCommentListFromPresenter(AppUtils.editCommentRequestBuilder(comment.getEntityId(), comment.getComment(), false, false, (long) comment.getId()), 1);
    }

    /* access modifiers changed from: private */
    public void onEditMenuClicked(Comment comment) {
        HashMap<String, Object> build = new EventProperty.Builder().id(Long.toString((long) comment.getId())).title(comment.getComment()).build();
        EventProperty.Builder communityId = new EventProperty.Builder().communityId(comment.getCommunityId());
        UserPostSolrObj userPostSolrObj = this.mUserPostObj;
        trackEvent(Event.REPLY_EDITED, new EventProperty.Builder().eventLabel(build).eventLabel2(communityId.communityName(userPostSolrObj != null ? userPostSolrObj.getPostCommunityName() : "").streamType(this.streamType).build()).positionInList(Integer.valueOf(comment.getItemPosition())).build());
        this.mInputText.setText(comment.getComment());
        this.mInputText.setSelection(comment.getComment().length());
        this.mPostDetailPresenter.editCommentListFromPresenter(AppUtils.editCommentRequestBuilder(comment.getEntityId(), comment.getComment(), false, false, (long) comment.getId()), 1);
    }

    private void setupToolbarItemsColor() {
        Drawable a2 = b.a((Context) this, R.drawable.vector_sheroes_back_arrow);
        if (a2 != null) {
            a2.mutate();
            a2.setColorFilter(Color.parseColor(this.mTitleTextColor), PorterDuff.Mode.SRC_ATOP);
        }
        this.mTitleToolbar.setTextColor(Color.parseColor(this.mTitleTextColor));
        if (Build.VERSION.SDK_INT >= 21) {
            if (this.mStatusBarColorEmpty) {
                if (a2 != null) {
                    a2.setColorFilter(Color.parseColor(this.mToolbarIconColor), PorterDuff.Mode.SRC_ATOP);
                }
                getWindow().setStatusBarColor(CommonUtil.colorBurn(Color.parseColor(this.mStatusBarColor)));
            } else {
                getWindow().setStatusBarColor(CommonUtil.colorBurn(Color.parseColor(this.mPrimaryColor)));
            }
        }
        getSupportActionBar().b(a2);
        this.mToolbar.setBackgroundColor(Color.parseColor(this.mPrimaryColor));
    }

    public void startProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void stopProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void showError(java.lang.String r4, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.enums.FeedParticipationEnum r5) {
        /*
            r3 = this;
            int r5 = r4.hashCode()
            r0 = 1152552230(0x44b28d26, float:1428.4109)
            r1 = 0
            r2 = 1
            if (r5 == r0) goto L_0x001b
            r0 = 1883304631(0x7040f2b7, float:2.3885818E29)
            if (r5 == r0) goto L_0x0011
            goto L_0x0025
        L_0x0011:
            java.lang.String r5 = "HTTP 401 Unauthorized"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0025
            r4 = 1
            goto L_0x0026
        L_0x001b:
            java.lang.String r5 = "Oops! There is some connectivity issue. Please check your internet connection."
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0025
            r4 = 0
            goto L_0x0026
        L_0x0025:
            r4 = -1
        L_0x0026:
            if (r4 == 0) goto L_0x003e
            if (r4 == r2) goto L_0x0034
            int r4 = com.sheroes.final_sdk.R.string.sheroes_ID_GENERIC_ERROR
            java.lang.String r4 = r3.getString(r4)
            r3.showNetworkTimeoutDoalog(r2, r1, r4)
            return
        L_0x0034:
            int r4 = com.sheroes.final_sdk.R.string.sheroes_IDS_INVALID_USER_PASSWORD
            java.lang.String r4 = r3.getString(r4)
            r3.showNetworkTimeoutDoalog(r2, r1, r4)
            return
        L_0x003e:
            int r4 = com.sheroes.final_sdk.R.string.sheroes_IDS_STR_NETWORK_TIME_OUT_DESCRIPTION
            java.lang.String r4 = r3.getString(r4)
            r3.showNetworkTimeoutDoalog(r2, r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.PostDetailActivity.showError(java.lang.String, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.enums.FeedParticipationEnum):void");
    }

    public void loadMoreComments() {
        AnalyticsManager.getPostProperties(this.mUserPostObj, getScreenName());
        AnalyticsManager.trackEvent(Event.POST_SHARED_CLICKED, getScreenName(), (Map<String, Object>) AnalyticsManager.getPostProperties(this.mUserPostObj, getScreenName()));
        this.mPostDetailPresenter.fetchMoreComments();
    }

    public void onPostImageClicked(UserPostSolrObj userPostSolrObj) {
        AlbumActivity.navigateTo(this, userPostSolrObj, SCREEN_LABEL, (HashMap<String, Object>) null);
    }

    public void onPostMenuClicked(final UserPostSolrObj userPostSolrObj, TextView textView) {
        t tVar = new t(this, textView);
        Preference<LoginResponse> preference = this.mUserPreference;
        long longValue = (preference == null || !preference.isSet() || this.mUserPreference.get() == null || this.mUserPreference.get().getUserSummary() == null) ? -1 : this.mUserPreference.get().getUserSummary().getUserId().longValue();
        Preference<LoginResponse> preference2 = this.mUserPreference;
        if (!(preference2 == null || !preference2.isSet() || this.mUserPreference.get() == null || this.mUserPreference.get().getUserSummary() == null)) {
            int userTypeId = this.mUserPreference.get().getUserSummary().getUserBO() != null ? this.mUserPreference.get().getUserSummary().getUserBO().getUserTypeId() : 0;
            androidx.appcompat.view.menu.g gVar = tVar.f1796a;
            gVar.add(0, R.id.sheroes_share, 1, menuIconWithText(getResources().getDrawable(R.drawable.vector_sheroes_share_black), getResources().getString(R.string.sheroes_ID_SHARE)));
            gVar.add(0, R.id.sheroes_edit, 2, menuIconWithText(getResources().getDrawable(R.drawable.vector_sheroes_create), getResources().getString(R.string.sheroes_ID_EDIT)));
            gVar.add(0, R.id.sheroes_delete, 3, menuIconWithText(getResources().getDrawable(R.drawable.vector_sheroes_delete), getResources().getString(R.string.sheroes_ID_DELETE)));
            gVar.add(0, R.id.sheroes_top_post, 4, menuIconWithText(getResources().getDrawable(R.drawable.vector_sheroes_create), getResources().getString(R.string.sheroes_FEATURE_POST)));
            if (userPostSolrObj.getAuthorId() == longValue || userPostSolrObj.isCommunityOwner() || userTypeId == 2) {
                tVar.f1796a.findItem(R.id.sheroes_delete).setVisible(true);
                if (!userPostSolrObj.isCommunityOwner() && userTypeId != 2) {
                    tVar.f1796a.findItem(R.id.sheroes_edit).setVisible(true);
                } else if (userPostSolrObj.getAuthorId() == longValue) {
                    tVar.f1796a.findItem(R.id.sheroes_edit).setVisible(true);
                } else {
                    tVar.f1796a.findItem(R.id.sheroes_edit).setVisible(false);
                }
            } else {
                tVar.f1796a.findItem(R.id.sheroes_delete).setVisible(false);
                tVar.f1796a.findItem(R.id.sheroes_edit).setVisible(false);
            }
            tVar.f1796a.findItem(R.id.sheroes_share).setVisible(true);
            if (longValue == userPostSolrObj.getAuthorId() || userTypeId != 2) {
                tVar.f1796a.findItem(R.id.sheroes_edit).setEnabled(true);
            } else {
                tVar.f1796a.findItem(R.id.sheroes_edit).setEnabled(false);
            }
            if (userTypeId == 2 || userPostSolrObj.isCommunityOwner()) {
                tVar.f1796a.findItem(R.id.sheroes_top_post).setVisible(true);
                if (userPostSolrObj.isTopPost()) {
                    tVar.f1796a.findItem(R.id.sheroes_top_post).setTitle(R.string.sheroes_UNFEATURE_POST);
                } else {
                    tVar.f1796a.findItem(R.id.sheroes_top_post).setTitle(R.string.sheroes_FEATURE_POST);
                }
            } else {
                tVar.f1796a.findItem(R.id.sheroes_top_post).setVisible(false);
            }
            if (userPostSolrObj.communityId.longValue() == 0) {
                tVar.f1796a.findItem(R.id.sheroes_delete).setVisible(false);
            }
            if (userPostSolrObj.isSpamPost()) {
                tVar.f1796a.findItem(R.id.sheroes_share).setVisible(false);
            }
            tVar.f1798c = new t.b() {
                public boolean onMenuItemClick(MenuItem menuItem) {
                    if (menuItem.getItemId() == R.id.sheroes_edit) {
                        PostDetailActivity postDetailActivity = PostDetailActivity.this;
                        CommunityPostActivity.navigateTo(postDetailActivity, postDetailActivity.mPostDetailPresenter.getUserPostObj(), 5001, (HashMap<String, Object>) null);
                        return true;
                    } else if (menuItem.getItemId() == R.id.sheroes_delete) {
                        AnalyticsManager.trackPostAction(Event.POST_DELETED, userPostSolrObj, PostDetailActivity.this.getScreenName());
                        PostDetailActivity.this.mPostDetailPresenter.deleteCommunityPostFromPresenter(AppUtils.deleteCommunityPostRequest(userPostSolrObj.getIdOfEntityOrParticipant()));
                        return true;
                    } else if (menuItem.getItemId() == R.id.sheroes_top_post) {
                        AnalyticsManager.trackPostAction(Event.POST_TOP_POST, userPostSolrObj, PostDetailActivity.this.getScreenName());
                        PostDetailActivity.this.mPostDetailPresenter.editTopPost(AppUtils.topCommunityPostRequestBuilder(userPostSolrObj.communityId, PostDetailActivity.this.getCreatorType(userPostSolrObj), userPostSolrObj.getListDescription(), userPostSolrObj.getIdOfEntityOrParticipant(), !userPostSolrObj.isTopPost()));
                        return true;
                    } else if (menuItem.getItemId() != R.id.sheroes_share) {
                        return false;
                    } else {
                        PostDetailActivity.this.shareWithMultipleOption(userPostSolrObj);
                        return true;
                    }
                }
            };
        }
        tVar.f1797b.a();
    }

    public void onShareButtonClicked(UserPostSolrObj userPostSolrObj, TextView textView) {
        String str;
        if (StringUtil.isNotNullOrEmptyString(userPostSolrObj.getPostShortBranchUrls())) {
            str = userPostSolrObj.getPostShortBranchUrls();
        } else {
            str = userPostSolrObj.getDeepLinkUrl();
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        Preference<Configuration> preference = this.mConfiguration;
        if (preference == null || !preference.isSet() || this.mConfiguration.get() == null || this.mConfiguration.get().configData == null || !this.mConfiguration.get().configData.isWhatsAppShare) {
            intent.putExtra("android.intent.extra.TEXT", str);
            startActivity(Intent.createChooser(intent, AppConstants.SHARE));
        } else if (CommonUtil.isAppInstalled(this, AppConstants.WHATS_APP)) {
            intent.setPackage(AppConstants.WHATS_APP);
            intent.putExtra("android.intent.extra.TEXT", str);
            startActivity(intent);
        }
        HashMap<String, Object> postProperties = AnalyticsManager.getPostProperties(userPostSolrObj, getScreenName());
        postProperties.put(EventProperty.SHARED_TO.getString(), AppConstants.SHARE_CHOOSER);
        AnalyticsManager.trackEvent(Event.POST_SHARED, getScreenName(), (Map<String, Object>) postProperties);
    }

    public void onPostLikeClicked(UserPostSolrObj userPostSolrObj) {
        this.mPostDetailPresenter.getPostLikesFromPresenter(this.mAppUtils.likeRequestBuilder(userPostSolrObj.getEntityOrParticipantId(), 10), userPostSolrObj);
    }

    public void onPostUnLikeClicked(UserPostSolrObj userPostSolrObj) {
        this.mPostDetailPresenter.getPostUnLikesFromPresenter(this.mAppUtils.likeRequestBuilder(userPostSolrObj.getEntityOrParticipantId(), 0), userPostSolrObj);
    }

    public void onSpamApprovedClicked(UserPostSolrObj userPostSolrObj, TextView textView) {
        this.mPostDetailPresenter.getSpamPostApproveFromPresenter(this.mAppUtils.spamPostApprovedRequestBuilder(userPostSolrObj, true, false, true), userPostSolrObj);
    }

    public void onSpamPostDeleteClicked(UserPostSolrObj userPostSolrObj, TextView textView) {
        this.mPostDetailPresenter.getSpamPostApproveFromPresenter(this.mAppUtils.spamPostApprovedRequestBuilder(userPostSolrObj, true, true, false), userPostSolrObj);
    }

    public Map<String, Object> getExtraPropertiesToTrack() {
        new EventProperty.Builder();
        return AnalyticsManager.getPostProperties(this.mPostDetailPresenter.getUserPostObj(), getScreenName());
    }

    public void onCommentButtonClicked() {
        this.mInputText.requestFocus();
    }

    public void onLikeCountClicked(UserPostSolrObj userPostSolrObj) {
        LikeListBottomSheetFragment.showDialog(this, "", userPostSolrObj.getEntityOrParticipantId(), userPostSolrObj);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.sheroes_sendButton) {
            onSendButtonClicked();
        }
        if (id == R.id.sheroes_tv_user_name_for_post) {
            userNamePostForComment();
        }
        if (id == R.id.sheroes_tv_anonymous_post) {
            anonymousPostForComment();
        }
    }

    public void onSendButtonClicked() {
        String trim = this.mInputText.getText().toString().trim();
        if (!TextUtils.isEmpty(trim)) {
            this.mPostDetailPresenter.addComment(trim, this.mIsAnonymous);
            this.mInputText.setText("");
        }
    }

    public void onCommentMenuClicked(final Comment comment, ImageView imageView) {
        t tVar = new t(this, imageView);
        Preference<LoginResponse> preference = this.mUserPreference;
        if (!(preference == null || !preference.isSet() || this.mUserPreference.get() == null || this.mUserPreference.get().getUserSummary() == null)) {
            int userTypeId = this.mUserPreference.get().getUserSummary().getUserBO() != null ? this.mUserPreference.get().getUserSummary().getUserBO().getUserTypeId() : 0;
            tVar.f1796a.add(0, R.id.sheroes_edit, 1, menuIconWithText(getResources().getDrawable(R.drawable.ic_sheroes_create), getResources().getString(R.string.sheroes_ID_EDIT)));
            tVar.f1796a.add(0, R.id.sheroes_delete, 2, menuIconWithText(getResources().getDrawable(R.drawable.ic_sheroes_delete), getResources().getString(R.string.sheroes_ID_DELETE)));
            if (comment.isMyOwnParticipation() || userTypeId != 2) {
                tVar.f1796a.findItem(R.id.sheroes_edit).setEnabled(true);
            } else {
                tVar.f1796a.findItem(R.id.sheroes_edit).setEnabled(false);
            }
            tVar.f1798c = new t.b() {
                public boolean onMenuItemClick(MenuItem menuItem) {
                    if (menuItem.getItemId() == R.id.sheroes_edit) {
                        PostDetailActivity.this.onEditMenuClicked(comment);
                        return true;
                    } else if (menuItem.getItemId() != R.id.sheroes_delete) {
                        return false;
                    } else {
                        PostDetailActivity.this.onDeleteMenuClicked(comment);
                        return true;
                    }
                }
            };
        }
        tVar.f1797b.a();
    }

    public void userCommentLikeRequest(Comment comment, boolean z, int i2) {
        if (z) {
            this.mPostDetailPresenter.getCommentLikesFromPresenter(this.mAppUtils.likeRequestBuilder(comment.getEntityId(), 10, comment.getCommentsId()), comment);
        } else {
            this.mPostDetailPresenter.getCommentUnLikesFromPresenter(this.mAppUtils.unLikeRequestBuilder(comment.getEntityId(), comment.getCommentsId()), comment);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.mPostDetailPresenter.detachView();
    }
}
