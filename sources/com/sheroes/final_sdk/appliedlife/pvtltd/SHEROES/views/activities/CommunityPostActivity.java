package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.StrictMode;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.Base64;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.t;
import androidx.cardview.widget.CardView;
import androidx.core.app.f;
import androidx.core.app.p;
import androidx.core.content.b;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.y;
import com.alipay.mobile.h5container.api.H5Param;
import com.business.merchant_payments.mapqr.vision.ViewFinder;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.play.core.splitcompat.a;
import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.AnalyticsManager;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.Event;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.EventProperty;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseActivity;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.SheroesPresenter;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.Configuration;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.LinkRenderResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.FeedDetail;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.UserPostSolrObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.LoginResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.UserSummary;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.post.Community;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.post.CommunityPost;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.post.MyCommunities;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.post.Photo;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters.CreatePostPresenter;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppUtils;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.Bamboo;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CircleTransform;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.stringutils.StringUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.adapters.PostPhotoAdapter;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImage;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImageView;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.RippleViewLinear;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.FeedFragment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.PostBottomSheetFragment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.viewlisteners.ICommunityPostView;
import com.squareup.picasso.af;
import com.squareup.picasso.ah;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.parceler.g;

public class CommunityPostActivity extends BaseActivity implements ICommunityPostView {
    public static final String IS_FROM_BRANCH = "Is from branch";
    public static final String IS_FROM_COMMUNITY = "Is from community";
    public static final int MAX_IMAGE = 5;
    public static final String POSITION_ON_FEED = "POSITION_ON_FEED";
    public static final String SCREEN_LABEL = "Create Communities Post Screen";
    public static final String SCREEN_LABEL_PAYTM = "/sheroes/create-post";
    public static final String TYPE_FILE = "file";
    public static final String TYPE_IMAGE = "image/";
    public static final String TYPE_TEXT = "text/plain";
    private String actionDefault = "#00b9f1";
    private View anonymousToolTip;
    private CardView cardViewLinkRender;
    /* access modifiers changed from: private */
    public List<Long> deletedImageIdList = new ArrayList();
    /* access modifiers changed from: private */
    public boolean isLinkRendered;
    private boolean isSharedContent = false;
    /* access modifiers changed from: private */
    public boolean isSharedFromOtherApp;
    /* access modifiers changed from: private */
    public ImageView ivLinkThumbnail;
    private TextView mAction;
    /* access modifiers changed from: private */
    public CheckBox mAnonymousSelect;
    RelativeLayout mAnonymousView;
    AppUtils mAppUtils;
    private int mAuthorPicSize;
    private TextView mCommunityName;
    private CommunityPost mCommunityPost;
    Preference<Configuration> mConfiguration;
    CreatePostPresenter mCreatePostPresenter;
    /* access modifiers changed from: private */
    public EditText mEtDefaultText;
    private int mFeedPosition;
    private boolean mHasPermission = false;
    private TextView mImageCount;
    /* access modifiers changed from: private */
    public List<Photo> mImageList = new ArrayList();
    /* access modifiers changed from: private */
    public RecyclerView mImageListView;
    private LinearLayout mImageUploadView;
    /* access modifiers changed from: private */
    public boolean mIsAnonymous;
    private boolean mIsChallengePost;
    private boolean mIsCommunityOwner;
    private boolean mIsCompanyAdmin;
    /* access modifiers changed from: private */
    public boolean mIsEditPost;
    private boolean mIsFromBranch;
    /* access modifiers changed from: private */
    public boolean mIsFromCommunity;
    /* access modifiers changed from: private */
    public boolean mIsPostScheduled = false;
    private boolean mIsProgressBarVisible;
    private LinkRenderResponse mLinkRenderResponse = null;
    /* access modifiers changed from: private */
    public MyCommunities mMyCommunities;
    private String mOldText;
    /* access modifiers changed from: private */
    public boolean mPostAsCommunitySelected;
    /* access modifiers changed from: private */
    public Dialog mPostNowOrLaterDialog;
    /* access modifiers changed from: private */
    public PostPhotoAdapter mPostPhotoAdapter;
    private String mPrimaryColor = "#FFFFFF";
    private ProgressBar mProgressBar;
    /* access modifiers changed from: private */
    public Dialog mScheduledConfirmationDialog;
    private String mStatusBarColor = "#012B74";
    private boolean mStatusBarColorEmpty = false;
    private String mTitleTextColor = "#00b9f1";
    private TextView mTitleToolbar;
    private Toolbar mToolbar;
    private String mToolbarIconColor = "#90949C";
    private ImageView mUserDropDownView;
    private TextView mUserName;
    private ImageView mUserPicView;
    Preference<LoginResponse> mUserPreference;
    private UserSummary mUserSummary;
    private List<String> newEncodedImages = new ArrayList();
    /* access modifiers changed from: private */
    public ProgressBar pbLink;
    private RippleViewLinear rippleViewLinearAddImage;
    private RippleViewLinear rippleViewLinearCamera;
    private TextView tvLinkSubTitle;
    private TextView tvLinkTitle;
    private View viewAnonymous;

    public String getScreenName() {
        return SCREEN_LABEL_PAYTM;
    }

    public boolean shouldTrackScreen() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SheroesSdk.getAppComponent(this).inject(this);
        setContentView(R.layout.activity_sheroes_community_post);
        this.mToolbar = (Toolbar) findViewById(R.id.sheroes_toolbar);
        this.mTitleToolbar = (TextView) findViewById(R.id.sheroes_title_toolbar);
        this.mProgressBar = (ProgressBar) findViewById(R.id.sheroes_progress_bar);
        this.mAnonymousView = (RelativeLayout) findViewById(R.id.sheroes_anonymous);
        this.viewAnonymous = findViewById(R.id.sheroes_view_anonymous);
        this.mAction = (TextView) findViewById(R.id.sheroes_action);
        this.mAction.setOnClickListener(this);
        this.mAnonymousSelect = (CheckBox) findViewById(R.id.sheroes_anonymous_select);
        this.mUserPicView = (ImageView) findViewById(R.id.sheroes_user_pic);
        this.mUserDropDownView = (ImageView) findViewById(R.id.sheroes_user_drop_down);
        this.mUserDropDownView.setOnClickListener(this);
        this.mUserName = (TextView) findViewById(R.id.sheroes_user_name);
        this.mCommunityName = (TextView) findViewById(R.id.sheroes_community_name);
        this.mEtDefaultText = (EditText) findViewById(R.id.sheroes_et_default_hint_text);
        this.rippleViewLinearAddImage = (RippleViewLinear) findViewById(R.id.sheroes_add_image);
        this.rippleViewLinearAddImage.setOnClickListener(this);
        this.rippleViewLinearCamera = (RippleViewLinear) findViewById(R.id.sheroes_camera);
        this.rippleViewLinearCamera.setOnClickListener(this);
        this.pbLink = (ProgressBar) findViewById(R.id.sheroes_progress_bar_link);
        this.ivLinkThumbnail = (ImageView) findViewById(R.id.sheroes_iv_link_thumbnail);
        this.cardViewLinkRender = (CardView) findViewById(R.id.sheroes_card_link_render);
        this.tvLinkTitle = (TextView) findViewById(R.id.sheroes_tv_link_title);
        this.tvLinkSubTitle = (TextView) findViewById(R.id.sheroes_tv_link_sub_title);
        this.mImageListView = (RecyclerView) findViewById(R.id.sheroes_image_list_view);
        this.mImageCount = (TextView) findViewById(R.id.sheroes_image_count);
        this.mImageUploadView = (LinearLayout) findViewById(R.id.sheroes_image_upload_view);
        this.mAuthorPicSize = getResources().getDimensionPixelSize(R.dimen.sheroes_authorPicSize);
        this.mCreatePostPresenter.attachView(this);
        if (getIntent() != null) {
            this.mFeedPosition = getIntent().getIntExtra(POSITION_ON_FEED, -1);
            this.mIsFromCommunity = getIntent().getBooleanExtra(IS_FROM_COMMUNITY, false);
            this.mIsFromBranch = getIntent().getBooleanExtra(IS_FROM_BRANCH, false);
        }
        if (this.mIsFromBranch) {
            branchUrlHandle();
            return;
        }
        this.isSharedFromOtherApp = false;
        Preference<Configuration> preference = this.mConfiguration;
        if (!(preference == null || !preference.isSet() || this.mConfiguration.get().configData == null)) {
            this.mEtDefaultText.setHint(this.mConfiguration.get().configData.mCreatePostText);
        }
        if (getIntent() == null || getIntent().getExtras() == null) {
            this.mPrimaryColor = getResources().getString(R.color.colorPrimary + 0);
            this.mTitleTextColor = getResources().getString(R.color.sheroes_toolbar_title_text + 0);
            this.actionDefault = getResources().getString(R.color.sheroes_toolbar_title_text + 0);
        } else {
            this.mPrimaryColor = getIntent().getExtras().getString(FeedFragment.PRIMARY_COLOR, this.mPrimaryColor);
            this.mTitleTextColor = getIntent().getExtras().getString(FeedFragment.TITLE_TEXT_COLOR, this.mTitleTextColor);
            if (getIntent().getExtras().getString(FeedFragment.PRIMARY_COLOR) == null) {
                this.mStatusBarColorEmpty = true;
            }
            Parcelable parcelableExtra = getIntent().getParcelableExtra(CommunityPost.COMMUNITY_POST_OBJ);
            if (parcelableExtra != null) {
                this.mCommunityPost = (CommunityPost) g.a(parcelableExtra);
                this.mIsEditPost = this.mCommunityPost.isEdit;
                this.mIsChallengePost = this.mCommunityPost.isChallengeType;
            }
        }
        if (this.mIsChallengePost) {
            this.mAnonymousView.setVisibility(8);
            if (CommonUtil.isNotEmpty(this.mCommunityPost.challengeHashTag)) {
                EditText editText = this.mEtDefaultText;
                editText.setText(" #" + this.mCommunityPost.challengeHashTag);
                this.mEtDefaultText.requestFocus();
                this.mEtDefaultText.setSelection(0);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mUserName.getLayoutParams();
            layoutParams.addRule(13, -1);
            this.mUserName.setLayoutParams(layoutParams);
        }
        if (this.mIsEditPost) {
            this.mPostAsCommunitySelected = this.mCommunityPost.isPostByCommunity;
            this.mIsAnonymous = this.mCommunityPost.isAnonymous;
            this.mEtDefaultText.setText(this.mCommunityPost.body);
            this.mEtDefaultText.requestFocus();
            this.mEtDefaultText.setSelection(this.mCommunityPost.body.length());
            if (this.mIsAnonymous) {
                this.mAnonymousSelect.setChecked(true);
                this.mPostAsCommunitySelected = false;
            } else {
                this.mAnonymousSelect.setChecked(false);
            }
            this.mOldText = this.mCommunityPost.body;
            invalidateUserDropDownView();
        } else {
            CommunityPost communityPost = this.mCommunityPost;
            if (!(communityPost == null || communityPost.createPostRequestFrom == 201)) {
                this.mEtDefaultText.requestFocus();
                if (!this.mIsFromCommunity && !this.mIsChallengePost) {
                    PostBottomSheetFragment.showDialog(this, BaseActivity.SOURCE_SCREEN);
                }
            }
        }
        setSupportActionBar(this.mToolbar);
        Preference<LoginResponse> preference2 = this.mUserPreference;
        if (preference2 != null) {
            if (preference2.isSet() && this.mUserPreference.get().getUserSummary() != null) {
                this.mUserSummary = this.mUserPreference.get().getUserSummary();
                this.mIsCompanyAdmin = this.mUserPreference.get().getUserSummary().getUserBO().getUserTypeId() == 2;
            }
            if (this.mUserSummary != null) {
                this.mImageListView.setLayoutManager(new LinearLayoutManager(this, 0, false));
                ((y) this.mImageListView.getItemAnimator()).m = false;
                getSupportActionBar().c(false);
                getSupportActionBar().b(true);
                setupUserView();
                setupImageListView();
                setCommunityName();
                setupTextChangeListener();
                setupCommunityNameListener();
                setupAnonymousSlelectListener();
                setViewByCreatePostCall();
                setupToolbarItemsColor();
                externalImageWithTextShare();
                setupToolBarItem();
            }
        }
    }

    public void onResume() {
        super.onResume();
        a.a((Context) this);
        a.b((Context) this);
    }

    private void branchUrlHandle() {
        Parcelable parcelableExtra;
        if (!(getIntent() == null || getIntent().getExtras() == null || (parcelableExtra = getIntent().getParcelableExtra(CommunityPost.COMMUNITY_POST_OBJ)) == null)) {
            this.mCommunityPost = (CommunityPost) g.a(parcelableExtra);
            this.mIsChallengePost = this.mCommunityPost.isChallengeType;
        }
        if (this.mIsChallengePost) {
            this.mAnonymousSelect.setVisibility(8);
            this.mAnonymousView.setVisibility(8);
            if (CommonUtil.isNotEmpty(this.mCommunityPost.challengeHashTag)) {
                EditText editText = this.mEtDefaultText;
                editText.setText(" #" + this.mCommunityPost.challengeHashTag);
                this.mEtDefaultText.requestFocus();
                this.mEtDefaultText.setSelection(0);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mUserName.getLayoutParams();
            layoutParams.addRule(13, -1);
            this.mUserName.setLayoutParams(layoutParams);
        } else {
            this.mIsAnonymous = this.mCommunityPost.isAnonymous;
            if (StringUtil.isNotNullOrEmptyString(this.mCommunityPost.body)) {
                this.mEtDefaultText.setText(this.mCommunityPost.body);
                this.mEtDefaultText.requestFocus();
                this.mEtDefaultText.setSelection(this.mCommunityPost.body.length());
                this.mOldText = this.mCommunityPost.body;
            }
        }
        invalidateUserDropDownView();
        CommunityPost communityPost = this.mCommunityPost;
        if (!(communityPost == null || communityPost.createPostRequestFrom == 201)) {
            this.mEtDefaultText.requestFocus();
        }
        setSupportActionBar(this.mToolbar);
        Preference<LoginResponse> preference = this.mUserPreference;
        if (preference != null) {
            if (preference.isSet() && this.mUserPreference.get().getUserSummary() != null) {
                this.mUserSummary = this.mUserPreference.get().getUserSummary();
                this.mIsCompanyAdmin = this.mUserPreference.get().getUserSummary().getUserBO().getUserTypeId() == 2;
            }
            if (this.mUserSummary != null) {
                this.mImageListView.setLayoutManager(new LinearLayoutManager(this, 0, false));
                ((y) this.mImageListView.getItemAnimator()).m = false;
                getSupportActionBar().c(false);
                getSupportActionBar().b(true);
                setupUserView();
                setupImageListView();
                setCommunityName();
                setupTextChangeListener();
                setupCommunityNameListener();
                setupAnonymousSlelectListener();
                setViewByCreatePostCall();
                setupToolbarItemsColor();
                setupToolBarItem();
            }
        }
    }

    private void externalImageWithTextShare() {
        Intent intent = getIntent();
        if (!(intent == null || intent.getType() == null)) {
            this.mTitleToolbar.setText(R.string.sheroes_title_create_post);
            String action = intent.getAction();
            String type = intent.getType();
            if ("android.intent.action.SEND".equals(action) && type != null) {
                this.isSharedFromOtherApp = true;
                if ("text/plain".equals(type)) {
                    handleSendText(intent);
                } else if (type.startsWith(TYPE_IMAGE)) {
                    String stringExtra = intent.getStringExtra("android.intent.extra.TEXT");
                    if (StringUtil.isNotNullOrEmptyString(stringExtra)) {
                        this.mEtDefaultText.setText(stringExtra);
                        this.mEtDefaultText.requestFocus();
                        this.mEtDefaultText.setSelection(0);
                    }
                    handleSendImage((Uri) intent.getParcelableExtra("android.intent.extra.STREAM"));
                }
                PostBottomSheetFragment.showDialog(this, BaseActivity.SOURCE_SCREEN);
            } else if ("android.intent.action.SEND_MULTIPLE".equals(action) && type != null) {
                this.isSharedFromOtherApp = true;
                if (type.startsWith(TYPE_IMAGE)) {
                    handleSendMultipleImages(intent);
                }
                PostBottomSheetFragment.showDialog(this, BaseActivity.SOURCE_SCREEN);
            }
        }
        if (this.isSharedFromOtherApp && this.mCommunityPost == null) {
            this.mCommunityPost = new CommunityPost();
            this.mCommunityPost.isEdit = false;
        }
    }

    private void setupToolBarItem() {
        int i2 = this.mCommunityPost.createPostRequestFrom;
        if (i2 == 101) {
            this.mAction.setText(getResources().getString(R.string.sheroes_action_post));
        } else if (i2 != 201) {
            this.mAction.setText(getResources().getString(R.string.sheroes_action_post));
        } else {
            this.mAction.setText(getResources().getString(R.string.sheroes_action_mentor_post));
        }
        if (this.mStatusBarColorEmpty) {
            this.mAction.setTextColor(Color.parseColor(this.actionDefault));
        } else {
            this.mAction.setTextColor(Color.parseColor(this.mTitleTextColor));
        }
    }

    /* access modifiers changed from: package-private */
    public void handleSendMultipleImages(Intent intent) {
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("android.intent.extra.STREAM");
        if (parcelableArrayListExtra != null) {
            int size = parcelableArrayListExtra.size();
            if (parcelableArrayListExtra.size() > 5) {
                showMessage(R.string.sheroes_MAX_IMAGE_OVERFLOW_MESSAGE);
                size = 5;
            }
            for (int i2 = 0; i2 < size; i2++) {
                handleSendImage((Uri) parcelableArrayListExtra.get(i2));
            }
        }
    }

    private void handleSendImage(Uri uri) {
        File file;
        if (uri != null) {
            try {
                Photo photo = new Photo();
                String filePath = getFilePath(uri);
                if (filePath == null) {
                    Bitmap decodeStream = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
                    File filFromBitmap = CommonUtil.getFilFromBitmap(this, decodeStream);
                    decodeStream.recycle();
                    file = filFromBitmap;
                } else {
                    file = new File(filePath);
                }
                photo.isNew = true;
                photo.file = file;
                this.mImageList.add(photo);
                setImageCount();
                this.mPostPhotoAdapter.addPhoto(photo);
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            }
        }
    }

    private String getFilePath(Uri uri) {
        if (uri.getScheme().equalsIgnoreCase(TYPE_FILE)) {
            return uri.getPath();
        }
        return CommonUtil.getImagePathFromInputStreamUri(this, uri);
    }

    private void handleSendText(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.TEXT");
        if (stringExtra != null) {
            this.mIsEditPost = false;
            this.isSharedContent = true;
            this.mEtDefaultText.setText(stringExtra);
        }
    }

    private void setViewByCreatePostCall() {
        CommunityPost communityPost = this.mCommunityPost;
        if (communityPost != null) {
            int i2 = communityPost.createPostRequestFrom;
            if (i2 == 101) {
                this.mTitleToolbar.setText(R.string.sheroes_title_create_post);
            } else if (i2 != 201) {
                this.mTitleToolbar.setText(R.string.sheroes_title_create_post);
            } else {
                this.mTitleToolbar.setText(R.string.sheroes_title_ask_question);
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return true;
        }
        onBackPress();
        return true;
    }

    public void sendPost() {
        if (this.mHasPermission && this.mCommunityPost != null) {
            AnalyticsManager.trackEvent(Event.FACEBOOK_PUBLISHED, getScreenName(), (Map<String, Object>) new EventProperty.Builder().id(Integer.toString(this.mCommunityPost.remote_id)).title(this.mCommunityPost.title).build());
        }
        if (!this.mIsEditPost) {
            this.mCreatePostPresenter.sendPost(AppUtils.createCommunityPostRequestBuilder(Long.valueOf(this.mCommunityPost.community.id), getCreatorType(), this.mEtDefaultText.getText().toString().trim(), getImageUrls(), 0L, this.mLinkRenderResponse, this.mHasPermission));
            return;
        }
        CommunityPost communityPost = this.mCommunityPost;
        if (communityPost != null) {
            this.mCreatePostPresenter.editPost(AppUtils.editCommunityPostRequestBuilder(Long.valueOf(communityPost.community.id), getCreatorType(), this.mEtDefaultText.getText().toString().trim(), this.newEncodedImages, Long.valueOf((long) this.mCommunityPost.remote_id), this.deletedImageIdList, this.mLinkRenderResponse));
        }
    }

    private void selectPostNowOrLater() {
        Dialog dialog = this.mPostNowOrLaterDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.mPostNowOrLaterDialog = new Dialog(this);
        this.mPostNowOrLaterDialog.requestWindowFeature(1);
        this.mPostNowOrLaterDialog.setCancelable(false);
        this.mPostNowOrLaterDialog.setContentView(R.layout.dialog_sheroes_post_type_confirmation);
        ((TextView) this.mPostNowOrLaterDialog.findViewById(R.id.sheroes_post_now)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                boolean unused = CommunityPostActivity.this.mIsPostScheduled = false;
                CommunityPostActivity.this.sendPost();
                CommunityPostActivity.this.mPostNowOrLaterDialog.dismiss();
            }
        });
        ((TextView) this.mPostNowOrLaterDialog.findViewById(R.id.sheroes_schedule_post)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                boolean unused = CommunityPostActivity.this.mIsPostScheduled = true;
                CommunityPostActivity.this.datePicker();
                CommunityPostActivity.this.mPostNowOrLaterDialog.dismiss();
            }
        });
        this.mPostNowOrLaterDialog.show();
    }

    /* access modifiers changed from: private */
    public void datePicker() {
        Calendar instance = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
                CommunityPostActivity.this.timePicker(i2, i3, i4);
            }
        }, instance.get(1), instance.get(2), instance.get(5));
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
        datePickerDialog.show();
    }

    /* access modifiers changed from: private */
    public void timePicker(int i2, int i3, int i4) {
        Calendar instance = Calendar.getInstance();
        final Calendar calendar = instance;
        final int i5 = i2;
        final int i6 = i3;
        final int i7 = i4;
        new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            public void onTimeSet(TimePicker timePicker, int i2, int i3) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(AppConstants.DATE_FORMAT);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                calendar.set(i5, i6, i7, i2, i3, 0);
                String format = simpleDateFormat.format(calendar.getTime());
                if (i2 < calendar.get(11) || i3 < calendar.get(12)) {
                    Toast.makeText(CommunityPostActivity.this.getApplicationContext(), "Invalid Time", 1).show();
                    return;
                }
                CommunityPostActivity.this.scheduleConfirmation(format, new SimpleDateFormat("dd MMM yyyy hh.mm a").format(calendar.getTime()));
            }
        }, instance.get(11), instance.get(12) + 1, false).show();
    }

    /* access modifiers changed from: private */
    public void postForAdmin(String str) {
        this.mCreatePostPresenter.sendPost(AppUtils.schedulePost(Long.valueOf(this.mCommunityPost.community.id), getCreatorType(), this.mEtDefaultText.getText().toString(), getImageUrls(), 0L, this.mLinkRenderResponse, this.mHasPermission, str));
    }

    private boolean validateFields() {
        if (isDirty() || this.mIsEditPost) {
            CommunityPost communityPost = this.mCommunityPost;
            if (communityPost == null || communityPost.community != null || this.mCommunityPost.isChallengeType) {
                return true;
            }
            showMessage(R.string.sheroes_error_choose_community);
            return false;
        }
        showMessage(R.string.sheroes_error_blank);
        return false;
    }

    private void deleteFileFromCache() {
        File externalCacheDir = getExternalCacheDir();
        if (externalCacheDir != null) {
            File file = new File(Uri.fromFile(new File(externalCacheDir.getPath(), AppConstants.IMAGE_CLICK_BY_CAMERA)).getPath());
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public void invalidateOptionsMenu() {
        super.invalidateOptionsMenu();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        Bitmap decodeFile;
        byte[] bytesFromBitmap;
        super.onActivityResult(i2, i3, intent);
        if (intent == null) {
            return;
        }
        if (i2 != 203) {
            Bamboo.e(SCREEN_LABEL, "Case not handled on :  Create Communities Post Screen ".concat(String.valueOf(i2)));
            return;
        }
        CropImage.ActivityResult activityResult = CropImage.getActivityResult(intent);
        if (i3 == -1) {
            try {
                Photo photo = new Photo();
                photo.isNew = true;
                photo.file = new File(activityResult.getUri().getPath());
                this.mImageList.add(photo);
                setImageCount();
                if (!(!this.mIsEditPost || (decodeFile = decodeFile(photo.file)) == null || (bytesFromBitmap = getBytesFromBitmap(decodeFile)) == null)) {
                    String encodeToString = Base64.encodeToString(bytesFromBitmap, 0);
                    if (StringUtil.isNotNullOrEmptyString(encodeToString)) {
                        this.newEncodedImages.add(encodeToString);
                    }
                }
                this.mPostPhotoAdapter.addPhoto(photo);
                deleteFileFromCache();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (i3 == 204) {
            Toast.makeText(this, "Cropping failed: " + activityResult.getError(), 1).show();
        }
    }

    public void onStop() {
        super.onStop();
        Dialog dialog = this.mPostNowOrLaterDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        Dialog dialog2 = this.mScheduledConfirmationDialog;
        if (dialog2 != null) {
            dialog2.dismiss();
        }
    }

    public Event getEventScreenName() {
        return Event.CREATE_POST_SCREEN_LOADED;
    }

    public void startProgressBar() {
        this.mIsProgressBarVisible = true;
        CommonUtil.hideKeyboard(this);
        this.mProgressBar.setVisibility(0);
    }

    public void stopProgressBar() {
        this.mIsProgressBarVisible = false;
        this.mProgressBar.setVisibility(8);
    }

    public void onBackPressed() {
        onBackPress();
    }

    public SheroesPresenter getPresenter() {
        return this.mCreatePostPresenter;
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
        throw new UnsupportedOperationException("Method not decompiled: com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity.showError(java.lang.String, com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.enums.FeedParticipationEnum):void");
    }

    /* access modifiers changed from: protected */
    public final void scheduleConfirmation(final String str, String str2) {
        Dialog dialog = this.mScheduledConfirmationDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.mScheduledConfirmationDialog = new Dialog(this);
        this.mScheduledConfirmationDialog.requestWindowFeature(1);
        this.mScheduledConfirmationDialog.setCancelable(false);
        this.mScheduledConfirmationDialog.setContentView(R.layout.dialog_sheroes_schedule_post_confirmation);
        ((TextView) this.mScheduledConfirmationDialog.findViewById(R.id.sheroes_message)).setText(StringUtil.fromHtml(getResources().getString(R.string.sheroes_post_schedule_message, new Object[]{this.mCommunityPost.community.name, str2})));
        ((TextView) this.mScheduledConfirmationDialog.findViewById(R.id.sheroes_ok)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CommunityPostActivity.this.postForAdmin(str);
                CommunityPostActivity.this.mScheduledConfirmationDialog.dismiss();
            }
        });
        ((TextView) this.mScheduledConfirmationDialog.findViewById(R.id.sheroes_edit)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CommunityPostActivity.this.datePicker();
                CommunityPostActivity.this.mScheduledConfirmationDialog.dismiss();
            }
        });
        this.mScheduledConfirmationDialog.show();
    }

    public void onPostSend(FeedDetail feedDetail) {
        if (feedDetail != null) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            if (this.mIsEditPost) {
                feedDetail.setItemPosition(this.mFeedPosition);
                bundle.putParcelable(AppConstants.COMMUNITY_POST_FRAGMENT, g.a(feedDetail));
            }
            intent.putExtras(bundle);
            setResult(-1, intent);
            navigateToParentActivity();
        }
    }

    private String getCreatorType() {
        if (this.mPostAsCommunitySelected) {
            return AppConstants.COMMUNITY_OWNER;
        }
        return this.mIsAnonymous ? AppConstants.ANONYMOUS : AppConstants.USER;
    }

    private List<String> getImageUrls() {
        byte[] bytesFromBitmap;
        ArrayList arrayList = new ArrayList();
        if (StringUtil.isNotEmptyCollection(this.mImageList)) {
            for (Photo photo : this.mImageList) {
                Bitmap decodeFile = decodeFile(photo.file);
                if (!(decodeFile == null || (bytesFromBitmap = getBytesFromBitmap(decodeFile)) == null)) {
                    String encodeToString = Base64.encodeToString(bytesFromBitmap, 0);
                    if (StringUtil.isNotNullOrEmptyString(encodeToString)) {
                        arrayList.add(encodeToString);
                    }
                }
            }
        }
        return arrayList;
    }

    private void setupAnonymousSlelectListener() {
        this.mAnonymousSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                boolean unused = CommunityPostActivity.this.mIsAnonymous = z;
                boolean unused2 = CommunityPostActivity.this.mPostAsCommunitySelected = false;
                CommunityPostActivity.this.setupUserView();
            }
        });
    }

    private void setupCommunityNameListener() {
        this.mCommunityName.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!CommunityPostActivity.this.mIsEditPost && !CommunityPostActivity.this.mIsFromCommunity) {
                    CommunityPostActivity communityPostActivity = CommunityPostActivity.this;
                    PostBottomSheetFragment.showDialog(communityPostActivity, BaseActivity.SOURCE_SCREEN, communityPostActivity.mMyCommunities);
                }
            }
        });
    }

    private byte[] getBytesFromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private void setupTextChangeListener() {
        this.mEtDefaultText.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            /* JADX WARNING: Code restructure failed: missing block: B:14:0x0057, code lost:
                r0 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppUtils.findNthIndexOf(r4.toLowerCase(), "www", 1);
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void afterTextChanged(android.text.Editable r4) {
                /*
                    r3 = this;
                    int r4 = r4.length()
                    if (r4 <= 0) goto L_0x00ba
                    com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity r4 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity.this
                    android.widget.EditText r4 = r4.mEtDefaultText
                    android.text.Editable r4 = r4.getText()
                    java.lang.String r4 = r4.toString()
                    boolean r4 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.stringutils.StringUtil.isNotNullOrEmptyString(r4)
                    if (r4 == 0) goto L_0x00ba
                    com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity r4 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity.this
                    boolean r4 = r4.isLinkRendered
                    if (r4 != 0) goto L_0x00ba
                    com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity r4 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity.this
                    android.widget.EditText r4 = r4.mEtDefaultText
                    android.text.Editable r4 = r4.getText()
                    java.lang.String r4 = r4.toString()
                    java.lang.String r4 = r4.trim()
                    java.lang.String r0 = "https"
                    boolean r1 = r4.contains(r0)
                    r2 = 1
                    if (r1 != 0) goto L_0x0089
                    java.lang.String r1 = "Http"
                    boolean r1 = r4.contains(r1)
                    if (r1 == 0) goto L_0x0046
                    goto L_0x0089
                L_0x0046:
                    java.lang.String r0 = "www"
                    boolean r1 = r4.contains(r0)
                    if (r1 != 0) goto L_0x0057
                    java.lang.String r1 = "WWW"
                    boolean r1 = r4.contains(r1)
                    if (r1 == 0) goto L_0x00ba
                L_0x0057:
                    java.lang.String r1 = r4.toLowerCase()
                    int r0 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppUtils.findNthIndexOf(r1, r0, r2)
                    com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity r1 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity.this
                    int r1 = r1.getUrlLength(r4, r0)
                    int r2 = r4.length()
                    if (r1 > r2) goto L_0x00ba
                    java.lang.String r4 = r4.substring(r0, r1)
                    com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity r0 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity.this
                    com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppUtils r0 = r0.mAppUtils
                    boolean r0 = r0.checkWWWUrl(r4)
                    if (r0 == 0) goto L_0x00ba
                    com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity r0 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity.this
                    com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters.CreatePostPresenter r0 = r0.mCreatePostPresenter
                    com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity r1 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity.this
                    com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppUtils r1 = r1.mAppUtils
                    com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.LinkRequest r4 = r1.linkRequestBuilder(r4)
                    r0.fetchLinkDetails(r4)
                    goto L_0x00ba
                L_0x0089:
                    java.lang.String r1 = r4.toLowerCase()
                    int r0 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppUtils.findNthIndexOf(r1, r0, r2)
                    com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity r1 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity.this
                    int r1 = r1.getUrlLength(r4, r0)
                    int r2 = r4.length()
                    if (r1 > r2) goto L_0x00ba
                    java.lang.String r4 = r4.substring(r0, r1)
                    com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity r0 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity.this
                    com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppUtils r0 = r0.mAppUtils
                    boolean r0 = r0.checkUrl(r4)
                    if (r0 == 0) goto L_0x00ba
                    com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity r0 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity.this
                    com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters.CreatePostPresenter r0 = r0.mCreatePostPresenter
                    com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity r1 = com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity.this
                    com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppUtils r1 = r1.mAppUtils
                    com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.community.LinkRequest r4 = r1.linkRequestBuilder(r4)
                    r0.fetchLinkDetails(r4)
                L_0x00ba:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity.AnonymousClass9.afterTextChanged(android.text.Editable):void");
            }
        });
    }

    private void disableEditTextForLinks() {
        if (this.isLinkRendered) {
            this.mEtDefaultText.setFocusable(false);
            this.mEtDefaultText.setFocusableInTouchMode(false);
            this.mEtDefaultText.setClickable(false);
        }
    }

    private Bitmap decodeFile(File file) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i2 = 1;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(new FileInputStream(file), (Rect) null, options);
            int i3 = options.outWidth;
            int i4 = options.outHeight;
            while (i3 / 2 >= 512 && i4 / 2 >= 512) {
                i3 /= 2;
                i4 /= 2;
                i2 *= 2;
            }
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inSampleSize = i2;
            return BitmapFactory.decodeStream(new FileInputStream(file), (Rect) null, options2);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public int getUrlLength(String str, int i2) {
        int i3 = i2;
        while (i2 < str.length() && str.charAt(i2) != ' ') {
            i3++;
            i2++;
        }
        return i3;
    }

    private void setCommunityName() {
        CommunityPost communityPost = this.mCommunityPost;
        if (communityPost == null || communityPost.createPostRequestFrom != 201) {
            if (this.mIsChallengePost) {
                this.mCommunityName.setVisibility(8);
            }
            CommunityPost communityPost2 = this.mCommunityPost;
            if (communityPost2 != null && communityPost2.community != null) {
                this.mCommunityName.setText(this.mCommunityPost.community.name);
                return;
            }
            return;
        }
        this.mCommunityName.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        SpannableString spannableString = new SpannableString(getString(R.string.sheroes_ID_ASKING) + " " + this.mCommunityPost.community.name);
        spannableString.setSpan((Object) null, 0, getString(R.string.sheroes_ID_ASKING).length(), 0);
        spannableString.setSpan(new ForegroundColorSpan(b.c(this, R.color.sheroes_recent_post_comment)), 0, getString(R.string.sheroes_ID_ASKING).length(), 0);
        this.mCommunityName.setEnabled(false);
        this.mCommunityName.setMovementMethod(LinkMovementMethod.getInstance());
        this.mCommunityName.setText(spannableString, TextView.BufferType.SPANNABLE);
        this.mCommunityName.setSelected(true);
        this.mEtDefaultText.setHint(getString(R.string.sheroes_ID_WHAT_IS_QUESTION));
        this.mEtDefaultText.requestFocus();
    }

    private void invalidateUserDropDownView() {
        if (this.mCommunityPost.community.isOwner) {
            this.mIsCompanyAdmin = true;
            this.mUserDropDownView.setVisibility(0);
            return;
        }
        this.mUserDropDownView.setVisibility(8);
    }

    public boolean isPostModified() {
        return !this.mOldText.equals(this.mEtDefaultText.getText().toString()) || !CommonUtil.isEmpty(this.newEncodedImages) || !CommonUtil.isEmpty(this.deletedImageIdList);
    }

    public static void navigateTo(Activity activity, FeedDetail feedDetail, int i2, HashMap<String, Object> hashMap) {
        Intent intent = new Intent(activity, CommunityPostActivity.class);
        UserPostSolrObj userPostSolrObj = (UserPostSolrObj) feedDetail;
        if (feedDetail != null) {
            CommunityPost communityPost = new CommunityPost();
            communityPost.remote_id = (int) userPostSolrObj.getIdOfEntityOrParticipant();
            communityPost.community = new Community();
            communityPost.community.id = userPostSolrObj.getCommunityTypeId();
            communityPost.body = userPostSolrObj.getListDescription();
            communityPost.community.name = userPostSolrObj.getPostCommunityName();
            communityPost.community.isOwner = userPostSolrObj.isCommunityOwner();
            communityPost.isMyPost = userPostSolrObj.isCommunityOwner();
            communityPost.community.thumbImageUrl = userPostSolrObj.getSolrIgnorePostCommunityLogo();
            communityPost.isAnonymous = userPostSolrObj.isAnonymous();
            communityPost.isEdit = true;
            communityPost.isPostByCommunity = userPostSolrObj.isCommunityPost();
            if (!CommonUtil.isEmpty(userPostSolrObj.getImageUrls()) && !CommonUtil.isEmpty(userPostSolrObj.getImagesIds())) {
                for (String str : userPostSolrObj.getImageUrls()) {
                    Photo photo = new Photo();
                    photo.url = str;
                    communityPost.photos.add(photo);
                }
                int i3 = 0;
                for (Long intValue : userPostSolrObj.getImagesIds()) {
                    communityPost.photos.get(i3).remote_id = intValue.intValue();
                    i3++;
                }
            }
            intent.putExtra(CommunityPost.COMMUNITY_POST_OBJ, g.a(communityPost));
            intent.putExtra(POSITION_ON_FEED, feedDetail.getItemPosition());
        }
        androidx.core.app.a.a(activity, intent, i2, (Bundle) null);
    }

    public static void navigateTo(FeedFragment feedFragment, FeedDetail feedDetail, int i2, String str, String str2, HashMap<String, Object> hashMap) {
        Intent intent = new Intent(feedFragment.getActivity(), CommunityPostActivity.class);
        UserPostSolrObj userPostSolrObj = (UserPostSolrObj) feedDetail;
        if (feedDetail != null) {
            CommunityPost communityPost = new CommunityPost();
            communityPost.remote_id = (int) userPostSolrObj.getIdOfEntityOrParticipant();
            communityPost.community = new Community();
            communityPost.community.id = userPostSolrObj.getCommunityTypeId();
            communityPost.body = userPostSolrObj.getListDescription();
            communityPost.community.name = userPostSolrObj.getPostCommunityName();
            communityPost.community.isOwner = userPostSolrObj.isCommunityOwner();
            communityPost.isMyPost = userPostSolrObj.isCommunityOwner();
            communityPost.community.thumbImageUrl = userPostSolrObj.getSolrIgnorePostCommunityLogo();
            communityPost.isAnonymous = userPostSolrObj.isAnonymous();
            communityPost.isEdit = true;
            communityPost.isPostByCommunity = userPostSolrObj.isCommunityPost();
            if (!CommonUtil.isEmpty(userPostSolrObj.getImageUrls()) && !CommonUtil.isEmpty(userPostSolrObj.getImagesIds())) {
                for (String str3 : userPostSolrObj.getImageUrls()) {
                    Photo photo = new Photo();
                    photo.url = str3;
                    communityPost.photos.add(photo);
                }
                int i3 = 0;
                for (Long intValue : userPostSolrObj.getImagesIds()) {
                    communityPost.photos.get(i3).remote_id = intValue.intValue();
                    i3++;
                }
            }
            intent.putExtra(CommunityPost.COMMUNITY_POST_OBJ, g.a(communityPost));
            intent.putExtra(POSITION_ON_FEED, feedDetail.getItemPosition());
            intent.putExtra(FeedFragment.PRIMARY_COLOR, str);
            intent.putExtra(FeedFragment.TITLE_TEXT_COLOR, str2);
            if (!CommonUtil.isEmpty(hashMap)) {
                intent.putExtra(BaseActivity.SOURCE_PROPERTIES, hashMap);
            }
        }
        feedFragment.startActivityForResult(intent, i2, (Bundle) null);
    }

    public static void navigateTo(FeedFragment feedFragment, CommunityPost communityPost, int i2, boolean z, HashMap<String, Object> hashMap) {
        Intent intent = new Intent(feedFragment.getActivity(), CommunityPostActivity.class);
        intent.putExtra(CommunityPost.COMMUNITY_POST_OBJ, g.a(communityPost));
        intent.putExtra(IS_FROM_BRANCH, z);
        if (!CommonUtil.isEmpty(hashMap)) {
            intent.putExtra(BaseActivity.SOURCE_PROPERTIES, hashMap);
        }
        feedFragment.startActivityForResult(intent, i2, (Bundle) null);
    }

    public static void navigateTo(Activity activity, CommunityPost communityPost, int i2, boolean z, HashMap<String, Object> hashMap) {
        Intent intent = new Intent(activity, CommunityPostActivity.class);
        intent.putExtra(CommunityPost.COMMUNITY_POST_OBJ, g.a(communityPost));
        intent.putExtra(IS_FROM_BRANCH, z);
        if (!CommonUtil.isEmpty(hashMap)) {
            intent.putExtra(BaseActivity.SOURCE_PROPERTIES, hashMap);
        }
        androidx.core.app.a.a(activity, intent, i2, (Bundle) null);
    }

    private void onBackPress() {
        if (isDirty()) {
            confirmationAlert();
        } else {
            navigateToParentActivity();
        }
    }

    private void confirmationAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Discard Post?");
        builder.setMessage("Are you sure you want to discard your changes?");
        builder.setNegativeButton(H5Param.DEFAULT_LONG_TRANSPARENT_TITLE_TEXTAUTO, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(H5Param.DEFAULT_LONG_PRESSO_LOGIN, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
                if (CommunityPostActivity.this.isSharedFromOtherApp) {
                    CommunityPostActivity.this.navigateToParentActivity();
                } else {
                    CommunityPostActivity.this.finish();
                }
            }
        });
        builder.create();
        builder.show();
    }

    /* access modifiers changed from: private */
    public void navigateToParentActivity() {
        Intent a2 = f.a(this);
        if (a2 != null) {
            if (f.a((Activity) this, a2)) {
                p.a((Context) this).b(a2).a();
            } else if (this.isSharedFromOtherApp) {
                p.a((Context) this).b(a2).a();
            }
        }
        finish();
    }

    private boolean isDirty() {
        if (this.mIsEditPost) {
            if (isPostModified()) {
                return true;
            }
            return false;
        } else if (CommonUtil.isNotEmpty(this.mEtDefaultText.getText().toString().trim()) || !CommonUtil.isEmpty(this.mImageList)) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void setImageCount() {
        this.mImageCount.setText(getString(R.string.sheroes_image_count, new Object[]{Integer.valueOf(this.mImageList.size()), 5}));
        if (this.mImageList.size() == 5) {
            this.mImageUploadView.setVisibility(8);
        } else {
            this.mImageUploadView.setVisibility(0);
        }
    }

    private void setupImageListView() {
        this.mPostPhotoAdapter = new PostPhotoAdapter(this, new View.OnClickListener() {
            public void onClick(View view) {
                int childAdapterPosition = CommunityPostActivity.this.mImageListView.getChildAdapterPosition((View) view.getParent());
                if (childAdapterPosition != -1) {
                    Photo photo = (Photo) CommunityPostActivity.this.mImageList.get(childAdapterPosition);
                    if (CommunityPostActivity.this.mIsEditPost && !photo.isNew) {
                        CommunityPostActivity.this.deletedImageIdList.add(Long.valueOf((long) photo.remote_id));
                    }
                    CommunityPostActivity.this.mImageList.remove(childAdapterPosition);
                    CommunityPostActivity.this.setImageCount();
                    CommunityPostActivity.this.mPostPhotoAdapter.removePhoto(childAdapterPosition);
                }
            }
        });
        this.mImageListView.setAdapter(this.mPostPhotoAdapter);
        if (this.mIsEditPost && !CommonUtil.isEmpty(this.mCommunityPost.photos)) {
            this.mImageList = this.mCommunityPost.photos;
            this.mPostPhotoAdapter.setData(new ArrayList(this.mImageList));
            setImageCount();
        }
    }

    /* access modifiers changed from: private */
    public void setupUserView() {
        if (this.mPostAsCommunitySelected) {
            this.mCommunityName.setVisibility(8);
            if (this.mCommunityPost.community != null) {
                this.mUserName.setText(CommonUtil.capitalizeString(this.mCommunityPost.community.name));
            }
        } else {
            if (this.mIsChallengePost) {
                this.mCommunityName.setVisibility(8);
            } else {
                this.mCommunityName.setVisibility(0);
            }
            if (this.mIsAnonymous) {
                this.mUserName.setText("Anonymous");
            } else {
                TextView textView = this.mUserName;
                textView.setText(CommonUtil.capitalizeString(this.mUserSummary.getFirstName() + " " + this.mUserSummary.getLastName()));
            }
        }
        setUserImage();
    }

    private void setUserImage() {
        if (this.mIsAnonymous || this.mPostAsCommunitySelected) {
            if (this.mPostAsCommunitySelected) {
                w.a().a(this.mCommunityPost.community.thumbImageUrl).a((ah) new CircleTransform(0.0f, 0)).a(this.mUserPicView, (e) null);
            } else {
                this.mUserPicView.setImageResource(R.drawable.vector_sheroes_anonymous);
            }
        } else if (this.mUserSummary.getPhotoUrl() != null && CommonUtil.isNotEmpty(this.mUserSummary.getPhotoUrl())) {
            String photoUrl = this.mUserSummary.getPhotoUrl();
            int i2 = this.mAuthorPicSize;
            w.a().a(CommonUtil.getThumborUri(photoUrl, i2, i2)).a((ah) new CircleTransform(0.0f, 0)).a(this.mUserPicView, (e) null);
        }
    }

    public void setMainCommunity(Community community, MyCommunities myCommunities) {
        CommunityPost communityPost = this.mCommunityPost;
        if (communityPost != null) {
            communityPost.community = new Community();
            this.mCommunityPost.community.id = community.id;
            this.mCommunityPost.community.name = community.name;
            this.mCommunityPost.community.isOwner = community.isOwner;
            this.mCommunityPost.community.thumbImageUrl = community.thumbImageUrl;
            this.mMyCommunities = myCommunities;
            setCommunityName();
            invalidateUserDropDownView();
        } else if (this.isSharedContent) {
            this.mCommunityPost = new CommunityPost();
            CommunityPost communityPost2 = this.mCommunityPost;
            communityPost2.community = community;
            communityPost2.createPostRequestFrom = -1;
            communityPost2.isChallengeType = false;
            communityPost2.community.id = community.id;
            this.mCommunityPost.community.name = community.name;
            this.mCommunityPost.community.isOwner = community.isOwner;
            this.mCommunityPost.community.thumbImageUrl = community.thumbImageUrl;
            this.mMyCommunities = myCommunities;
            setCommunityName();
            invalidateUserDropDownView();
        }
    }

    public void linkRenderResponse(LinkRenderResponse linkRenderResponse) {
        if (StringUtil.isNotNullOrEmptyString(linkRenderResponse.getStatus())) {
            String status = linkRenderResponse.getStatus();
            char c2 = 65535;
            int hashCode = status.hashCode();
            if (hashCode != -1149187101) {
                if (hashCode == 2066319421 && status.equals("FAILED")) {
                    c2 = 1;
                }
            } else if (status.equals("SUCCESS")) {
                c2 = 0;
            }
            if (c2 == 0) {
                this.isLinkRendered = true;
                this.cardViewLinkRender.setVisibility(0);
                this.mLinkRenderResponse = linkRenderResponse;
                if (StringUtil.isNotNullOrEmptyString(linkRenderResponse.getOgTitleS())) {
                    this.tvLinkTitle.setText(linkRenderResponse.getOgTitleS());
                }
                if (StringUtil.isNotNullOrEmptyString(linkRenderResponse.getOgDescriptionS())) {
                    this.tvLinkSubTitle.setText(linkRenderResponse.getOgDescriptionS());
                }
                if (StringUtil.isNotNullOrEmptyString(linkRenderResponse.getOgImageUrlS())) {
                    AnonymousClass12 r0 = new af() {
                        public void onBitmapFailed(Exception exc, Drawable drawable) {
                        }

                        public void onPrepareLoad(Drawable drawable) {
                        }

                        public void onBitmapLoaded(Bitmap bitmap, w.d dVar) {
                            CommunityPostActivity.this.ivLinkThumbnail.setImageBitmap(bitmap);
                            CommunityPostActivity.this.ivLinkThumbnail.setVisibility(0);
                            CommunityPostActivity.this.pbLink.setVisibility(8);
                        }
                    };
                    this.ivLinkThumbnail.setTag(r0);
                    w.a().a(linkRenderResponse.getOgImageUrlS()).a(R.drawable.background_image_placeholder).b(R.drawable.background_image_placeholder).a((af) r0);
                }
            }
        }
    }

    public void finishActivity() {
        setResult(-1, new Intent());
        navigateToParentActivity();
    }

    public void showMessage(int i2) {
        TextView textView = this.mCommunityName;
        if (textView != null) {
            Snackbar.a((View) textView, i2, -1).c();
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.sheroes_action) {
            onPostClicked();
        }
        if (id == R.id.sheroes_add_image) {
            onAddImageClick();
        }
        if (id == R.id.sheroes_camera) {
            onCameraClick();
        }
        if (id == R.id.sheroes_user_drop_down) {
            onUserDropDownClicked();
        }
    }

    /* access modifiers changed from: package-private */
    public void onAddImageClick() {
        this.rippleViewLinearAddImage.setOnRippleCompleteListener(new RippleViewLinear.OnRippleCompleteListener() {
            public void onComplete(RippleViewLinear rippleViewLinear) {
                CropImage.activity((Uri) null, 2).setCropShape(CropImageView.CropShape.RECTANGLE).setRequestedSize(ViewFinder.MAX_FRAME_WIDTH, ViewFinder.MAX_FRAME_WIDTH).start(CommunityPostActivity.this);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void onCameraClick() {
        this.rippleViewLinearCamera.setOnRippleCompleteListener(new RippleViewLinear.OnRippleCompleteListener() {
            public void onComplete(RippleViewLinear rippleViewLinear) {
                StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());
                CropImage.activity((Uri) null, 1).setCropShape(CropImageView.CropShape.RECTANGLE).setRequestedSize(ViewFinder.MAX_FRAME_WIDTH, ViewFinder.MAX_FRAME_WIDTH).start(CommunityPostActivity.this);
            }
        });
    }

    public void onUserDropDownClicked() {
        String str;
        t tVar = new t(this, this.mUserDropDownView);
        tVar.b().inflate(R.menu.menu_sheroes_user_spinner, tVar.f1796a);
        MenuItem findItem = tVar.f1796a.findItem(R.id.sheroes_user_menu);
        if (this.mPostAsCommunitySelected) {
            int i2 = R.string.sheroes_menu_post_as_user;
            str = getString(i2, new Object[]{this.mUserSummary.getFirstName() + " " + this.mUserSummary.getLastName()});
        } else {
            str = getString(R.string.sheroes_menu_post_as_community);
        }
        findItem.setTitle(str);
        tVar.f1798c = new t.b() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (!CommunityPostActivity.this.mPostAsCommunitySelected) {
                    CommunityPostActivity.this.mAnonymousSelect.setChecked(false);
                    boolean unused = CommunityPostActivity.this.mPostAsCommunitySelected = true;
                } else {
                    boolean unused2 = CommunityPostActivity.this.mPostAsCommunitySelected = false;
                }
                CommunityPostActivity.this.setupUserView();
                return true;
            }
        };
        tVar.f1797b.a();
    }

    private void setupToolbarItemsColor() {
        Drawable a2 = b.a((Context) this, R.drawable.vector_sheroes_back_arrow);
        if (a2 != null) {
            a2.setColorFilter(Color.parseColor(this.mTitleTextColor), PorterDuff.Mode.SRC_ATOP);
        }
        this.mTitleToolbar.setTextColor(Color.parseColor(this.mTitleTextColor));
        if (Build.VERSION.SDK_INT >= 21) {
            if (this.mStatusBarColorEmpty) {
                if (a2 != null) {
                    a2.setColorFilter(Color.parseColor(this.mTitleTextColor), PorterDuff.Mode.SRC_ATOP);
                }
                getWindow().setStatusBarColor(CommonUtil.colorBurn(Color.parseColor(this.mStatusBarColor)));
            } else {
                getWindow().setStatusBarColor(CommonUtil.colorBurn(Color.parseColor(this.mPrimaryColor)));
            }
        }
        getSupportActionBar().b(a2);
        this.mToolbar.setBackgroundColor(Color.parseColor(this.mPrimaryColor));
    }

    public void onPostClicked() {
        if (validateFields()) {
            CommunityPost communityPost = this.mCommunityPost;
            if (communityPost == null) {
                finish();
            } else if (!this.mIsProgressBarVisible) {
                if (this.mIsEditPost || this.mIsChallengePost || (!this.mIsCompanyAdmin && !communityPost.isMyPost)) {
                    sendPost();
                } else {
                    selectPostNowOrLater();
                }
            }
        }
    }
}
