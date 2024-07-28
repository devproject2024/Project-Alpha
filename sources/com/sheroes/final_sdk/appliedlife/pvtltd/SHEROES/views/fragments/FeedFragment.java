package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.t;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.y;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.play.core.splitcompat.a;
import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.AnalyticsManager;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.Event;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.EventProperty;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseActivity;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseFragment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.FeedItemCallback;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.SheroesPresenter;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.baseresponse.BaseResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.enums.FeedParticipationEnum;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.AppInstallationHelper;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.Configuration;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.comment.Comment;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.CarouselDataObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.CommunityFeedSolrObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.CommunityTab;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.FeedDetail;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.FeedResponsePojo;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.ImageSolrObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.UserPostSolrObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.login.LoginResponse;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.post.CommunityPost;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.preferences.Preference;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters.FeedPresenter;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppUtils;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.EndlessRecyclerViewScrollListener;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.stringutils.StringUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.AlbumActivity;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.BranchDeepLink;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CollectionActivity;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.PostDetailActivity;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.adapters.FeedAdapter;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.viewlisteners.IFeedView;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.parceler.g;

public class FeedFragment extends BaseFragment implements FeedItemCallback, IFeedView {
    public static final String DEEP_LINK_URL = "deep_link_url";
    private static final int HIDE_THRESHOLD = 20;
    public static final String IS_HOME_FEED = "Is Home Feed";
    public static final String PRIMARY_COLOR = "Primary Color";
    public static String SCREEN_LABEL = "/sheroes/feed";
    public static final String SCREEN_PROPERTIES = "Screen Properties";
    public static final String TITLE_TEXT_COLOR = "Title Text Color";
    ImageView emptyImage;
    TextView emptySubText;
    TextView emptyText;
    LinearLayout emptyView;
    ProgressBar gifLoader;
    /* access modifiers changed from: private */
    public boolean hasFeedEnded;
    private boolean isHomeFeed;
    private boolean isLoggedInUserMentor;
    /* access modifiers changed from: private */
    public FeedAdapter mAdapter;
    AppUtils mAppUtils;
    private CommunityTab mCommunityTab;
    Preference<Configuration> mConfiguration;
    private boolean mControlsVisible = true;
    private EndlessRecyclerViewScrollListener mEndlessRecyclerViewScrollListener;
    FloatingActionButton mFabButton;
    FeedPresenter mFeedPresenter;
    RecyclerView mFeedRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private long mLoggedInUser = -1;
    private String mPrimaryColor = "#6e2f95";
    HashMap<String, Object> mProperties;
    private String mScreenLabel;
    HashMap<String, Object> mScreenProperties;
    private int mScrolledDistance = 0;
    SwipeRefreshLayout mSwipeRefresh;
    private String mTitleTextColor = "#ffffff";
    Preference<LoginResponse> mUserPreference;
    CardView noInternet;
    TextView tvGoToSetting;

    public void dataOperationOnClick(BaseResponse baseResponse) {
    }

    public void handleOnClick(BaseResponse baseResponse, View view) {
    }

    public boolean trackScreenTime() {
        return true;
    }

    public void userCommentLikeRequest(BaseResponse baseResponse, int i2, int i3) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        SheroesSdk.getAppComponent(getActivity()).inject(this);
        View inflate = layoutInflater.inflate(R.layout.fragment_sheroes_feed, viewGroup, false);
        this.mSwipeRefresh = (SwipeRefreshLayout) inflate.findViewById(R.id.sheroes_swipeRefreshContainer);
        this.mFeedRecyclerView = (RecyclerView) inflate.findViewById(R.id.sheroes_feed);
        this.emptyView = (LinearLayout) inflate.findViewById(R.id.sheroes_empty_view);
        this.emptyImage = (ImageView) inflate.findViewById(R.id.sheroes_empty_image);
        this.emptyText = (TextView) inflate.findViewById(R.id.sheroes_empty_text);
        this.emptySubText = (TextView) inflate.findViewById(R.id.sheroes_empty_subtext);
        this.gifLoader = (ProgressBar) inflate.findViewById(R.id.sheroes_loader_gif);
        this.noInternet = (CardView) inflate.findViewById(R.id.sheroes_no_internet);
        ((TextView) inflate.findViewById(R.id.sheroes_tv_retry_for_internet)).setOnClickListener(this);
        this.tvGoToSetting = (TextView) inflate.findViewById(R.id.sheroes_tv_goto_setting);
        this.mFabButton = (FloatingActionButton) inflate.findViewById(R.id.sheroes_fab);
        this.mFabButton.setOnClickListener(this);
        this.mFeedPresenter.attachView(this);
        initialSetup();
        initializeRecyclerView();
        initializeSwipeRefreshView();
        setIsLoggedInUser();
        setupRecyclerScrollListener();
        showGifLoader();
        fetchRemoteConfig();
        new AppInstallationHelper(SheroesSdk.getApplicationContext()).setupAndSaveInstallation(true);
        checkForDeeplink();
        this.mFeedPresenter.fetchFeed(0);
        String string = getString(R.string.sheroes_setting);
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new UnderlineSpan(), 0, string.length(), 0);
        this.tvGoToSetting.setText(spannableString);
        this.mFeedPresenter.getAllCommunities(AppUtils.myCommunityRequestBuilder(AppConstants.FEED_COMMUNITY, 1));
        return inflate;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        Parcelable parcelableExtra;
        if (i2 != 1003) {
            if (i2 != 1902) {
                if (i2 == 5001 && i3 == -1) {
                    Snackbar.a((View) this.mFeedRecyclerView, R.string.sheroes_snackbar_submission_submited, -1).c();
                    refreshList();
                }
            } else if (intent != null) {
                UserPostSolrObj userPostSolrObj = null;
                Parcelable parcelableExtra2 = intent.getParcelableExtra(UserPostSolrObj.USER_POST_OBJ);
                boolean z = false;
                if (parcelableExtra2 != null) {
                    userPostSolrObj = (UserPostSolrObj) g.a(parcelableExtra2);
                    z = intent.getBooleanExtra(PostDetailActivity.IS_POST_DELETED, false);
                }
                if (userPostSolrObj == null) {
                    return;
                }
                if (z) {
                    removeItem(userPostSolrObj);
                } else {
                    invalidateItem(userPostSolrObj);
                }
            }
        } else if (intent != null && (parcelableExtra = intent.getParcelableExtra("community_detail")) != null) {
            for (FeedDetail feedDetail : (List) g.a(parcelableExtra)) {
                invalidateCommunityJoin((CommunityFeedSolrObj) feedDetail);
            }
        }
    }

    public void onResume() {
        super.onResume();
        a.a((Context) getActivity());
        a.b((Context) getActivity());
    }

    public void showFeedList(List<FeedDetail> list) {
        if (CommonUtil.isEmpty(list)) {
            this.mFeedRecyclerView.setVisibility(8);
            this.emptyView.setVisibility(0);
            loadEmptyView();
        } else {
            this.mFeedRecyclerView.setVisibility(0);
            this.emptyView.setVisibility(8);
        }
        this.mAdapter.feedFinishedLoading();
        this.mAdapter.setData(list);
        this.mAdapter.notifyDataSetChanged();
    }

    public Map<String, Object> getExtraProperties() {
        HashMap<String, Object> hashMap = this.mProperties;
        if (hashMap != null) {
            return hashMap;
        }
        return null;
    }

    private void loadEmptyView() {
        CommunityTab communityTab = this.mCommunityTab;
        if (communityTab != null) {
            if (CommonUtil.isNotEmpty(communityTab.emptyTitle)) {
                this.emptyText.setVisibility(0);
                this.emptyText.setText(this.mCommunityTab.emptyTitle);
            } else {
                this.emptyText.setVisibility(8);
            }
            if (CommonUtil.isNotEmpty(this.mCommunityTab.emptyDescription)) {
                this.emptySubText.setVisibility(0);
                this.emptySubText.setText(this.mCommunityTab.emptyDescription);
            } else {
                this.emptySubText.setVisibility(8);
            }
            if (CommonUtil.isNotEmpty(this.mCommunityTab.emptyImageUrl)) {
                this.emptyImage.setVisibility(0);
                if (getActivity() != null) {
                    w.a().a(this.mCommunityTab.emptyImageUrl).a(this.emptyImage, (e) null);
                    return;
                }
                return;
            }
            this.emptyImage.setVisibility(8);
        }
    }

    public void setData(int i2, FeedDetail feedDetail) {
        this.mAdapter.setData(i2, feedDetail);
    }

    public void invalidateItem(FeedDetail feedDetail) {
        updateItem(feedDetail);
    }

    public void notifyAllItemRemoved(FeedDetail feedDetail) {
        removeItem(feedDetail);
    }

    public void addAllFeed(List<FeedDetail> list) {
        this.mAdapter.addAll(list);
    }

    public void setFeedEnded(boolean z) {
        this.hasFeedEnded = z;
    }

    public String getScreenName() {
        if (CommonUtil.isNotEmpty(this.mScreenLabel)) {
            return this.mScreenLabel;
        }
        return SCREEN_LABEL;
    }

    public Event getEventScreenName() {
        return Event.FEED_SCREEN_LOADED;
    }

    public void showDeeplink(Uri uri) {
        if (uri != null) {
            Intent intent = new Intent(getActivity(), BranchDeepLink.class);
            intent.putExtra("branch_force_new_session", true);
            intent.putExtra("branch", uri);
            intent.setData(uri);
            startActivity(intent);
        }
    }

    private void initialSetup() {
        if (getArguments() != null) {
            Parcelable parcelable = getArguments().getParcelable(CommunityTab.COMMUNITY_TAB_OBJ);
            if (parcelable != null) {
                this.mCommunityTab = (CommunityTab) g.a(parcelable);
            }
            this.mPrimaryColor = getArguments().getString(PRIMARY_COLOR);
            this.mTitleTextColor = getArguments().getString(TITLE_TEXT_COLOR);
        }
        CommunityTab communityTab = this.mCommunityTab;
        if (communityTab == null) {
            if (getArguments() != null) {
                String string = getArguments().getString(AppConstants.END_POINT_URL);
                String string2 = getArguments().getString("screen_name");
                this.mProperties = (HashMap) getArguments().getSerializable(SCREEN_PROPERTIES);
                HashMap<String, Object> hashMap = this.mProperties;
                if (!(hashMap == null || hashMap.get(EventProperty.ID.getString()) == null)) {
                    this.mProperties.get(EventProperty.ID.getString());
                }
                if (CommonUtil.isNotEmpty(string2)) {
                    this.mScreenLabel = string2;
                }
                if (CommonUtil.isNotEmpty(string)) {
                    this.mFeedPresenter.setEndpointUrl(string);
                }
                this.isHomeFeed = getArguments().getBoolean(IS_HOME_FEED, true);
                this.mFeedPresenter.setIsHomeFeed(this.isHomeFeed);
                this.mScreenProperties = new EventProperty.Builder().build();
                if (this.isHomeFeed) {
                    this.mFabButton.setVisibility(0);
                }
            }
        } else if (CommonUtil.isNotEmpty(communityTab.dataUrl)) {
            this.mFeedPresenter.setEndpointUrl(this.mCommunityTab.dataUrl);
        }
    }

    private void fetchRemoteConfig() {
        this.mFeedPresenter.queryConfig();
    }

    private void setupRecyclerScrollListener() {
        this.mFeedRecyclerView.addOnScrollListener(new RecyclerView.l() {
            public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                super.onScrolled(recyclerView, i2, i3);
            }
        });
        this.mEndlessRecyclerViewScrollListener = new EndlessRecyclerViewScrollListener(this.mLinearLayoutManager) {
            public void onLoadMore(int i2, int i3, RecyclerView recyclerView) {
                if (!FeedFragment.this.mFeedPresenter.isFeedLoading() && !FeedFragment.this.hasFeedEnded) {
                    FeedFragment.this.mFeedRecyclerView.post(new Runnable() {
                        public void run() {
                            FeedFragment.this.mAdapter.feedStartedLoading();
                        }
                    });
                    FeedFragment.this.mFeedPresenter.fetchFeed(1);
                }
            }
        };
        this.mFeedRecyclerView.addOnScrollListener(this.mEndlessRecyclerViewScrollListener);
    }

    private void setIsLoggedInUser() {
        Preference<LoginResponse> preference = this.mUserPreference;
        if (preference != null && preference.isSet() && this.mUserPreference.get() != null && this.mUserPreference.get().getUserSummary() != null && this.mUserPreference.get().getUserSummary().getUserId() != null) {
            this.mLoggedInUser = this.mUserPreference.get().getUserSummary().getUserId().longValue();
            if (this.mUserPreference.get().getUserSummary().getUserBO().getUserTypeId() == 7) {
                this.isLoggedInUserMentor = true;
            }
        }
    }

    private void initializeSwipeRefreshView() {
        this.mSwipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.b() {
            public void onRefresh() {
                FeedFragment.this.mFeedPresenter.fetchFeed(0);
            }
        });
        this.mSwipeRefresh.setColorSchemeResources(R.color.sheroes_mentor_green, R.color.sheroes_link_color, R.color.sheroes_email);
    }

    private void initializeRecyclerView() {
        this.mLinearLayoutManager = new LinearLayoutManager(getActivity());
        this.mFeedRecyclerView.setLayoutManager(this.mLinearLayoutManager);
        ((y) this.mFeedRecyclerView.getItemAnimator()).m = false;
        this.mAdapter = new FeedAdapter(getContext(), this);
        this.mFeedRecyclerView.setAdapter(this.mAdapter);
    }

    /* access modifiers changed from: private */
    public void shareCardDetail(UserPostSolrObj userPostSolrObj) {
        String str;
        if (StringUtil.isNotNullOrEmptyString(userPostSolrObj.getPostShortBranchUrls())) {
            str = userPostSolrObj.getPostShortBranchUrls();
        } else {
            str = userPostSolrObj.getDeepLinkUrl();
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str);
        startActivity(Intent.createChooser(intent, AppConstants.SHARE));
        HashMap<String, Object> postProperties = AnalyticsManager.getPostProperties(userPostSolrObj, getScreenName());
        postProperties.put(EventProperty.SHARED_TO.getString(), AppConstants.SHARE_CHOOSER);
        AnalyticsManager.trackEvent(Event.POST_SHARED, getScreenName(), (Map<String, Object>) postProperties);
    }

    public void onPostShared(FeedDetail feedDetail) {
        String str;
        if (StringUtil.isNotNullOrEmptyString(feedDetail.getPostShortBranchUrls())) {
            str = feedDetail.getPostShortBranchUrls();
        } else {
            str = feedDetail.getDeepLinkUrl();
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        Preference<Configuration> preference = this.mConfiguration;
        if (preference == null || !preference.isSet() || this.mConfiguration.get() == null || this.mConfiguration.get().configData == null || !this.mConfiguration.get().configData.isWhatsAppShare) {
            intent.putExtra("android.intent.extra.TEXT", str);
            startActivity(Intent.createChooser(intent, AppConstants.SHARE));
        } else if (CommonUtil.isAppInstalled(getActivity(), AppConstants.WHATS_APP)) {
            intent.setPackage(AppConstants.WHATS_APP);
            intent.putExtra("android.intent.extra.TEXT", str);
            startActivity(intent);
        }
        Preference<Configuration> preference2 = this.mConfiguration;
        if (preference2 == null || !preference2.isSet() || this.mConfiguration.get() == null || this.mConfiguration.get().configData == null || !this.mConfiguration.get().configData.isWhatsAppShare) {
            HashMap<String, Object> postProperties = AnalyticsManager.getPostProperties(feedDetail, getScreenName());
            postProperties.put(EventProperty.SHARED_TO.getString(), AppConstants.SHARE_CHOOSER);
            AnalyticsManager.trackEvent(Event.POST_SHARED, getScreenName(), (Map<String, Object>) postProperties);
            return;
        }
        HashMap<String, Object> postProperties2 = AnalyticsManager.getPostProperties(feedDetail, getScreenName());
        postProperties2.put(EventProperty.SHARED_TO.getString(), AppConstants.WHATSAPP_ICON);
        AnalyticsManager.trackEvent(Event.POST_SHARED, getScreenName(), (Map<String, Object>) postProperties2);
    }

    public void onUserPostClicked(UserPostSolrObj userPostSolrObj) {
        navigateToPostDetailScreen(getScreenName(), userPostSolrObj, AppConstants.REQUEST_CODE_FOR_POST_DETAIL, (HashMap) this.mScreenProperties.clone(), false, this.mPrimaryColor, this.mTitleTextColor);
    }

    public void onUserPostCommentClicked(UserPostSolrObj userPostSolrObj) {
        navigateToPostDetailScreen(getScreenName(), userPostSolrObj, AppConstants.REQUEST_CODE_FOR_POST_DETAIL, (HashMap) this.mScreenProperties.clone(), true, this.mPrimaryColor, this.mTitleTextColor);
    }

    public void onUserPostImageClicked(UserPostSolrObj userPostSolrObj) {
        AlbumActivity.navigateTo(getActivity(), userPostSolrObj, getScreenName(), (HashMap) this.mScreenProperties.clone());
    }

    public void onPostMenuClicked(final UserPostSolrObj userPostSolrObj, View view) {
        t tVar = new t(getActivity(), view);
        Preference<LoginResponse> preference = this.mUserPreference;
        long longValue = (preference == null || !preference.isSet() || this.mUserPreference.get() == null || this.mUserPreference.get().getUserSummary() == null) ? -1 : this.mUserPreference.get().getUserSummary().getUserId().longValue();
        Preference<LoginResponse> preference2 = this.mUserPreference;
        if (!(preference2 == null || !preference2.isSet() || this.mUserPreference.get() == null || this.mUserPreference.get().getUserSummary() == null)) {
            int userTypeId = this.mUserPreference.get().getUserSummary().getUserBO() != null ? this.mUserPreference.get().getUserSummary().getUserBO().getUserTypeId() : 0;
            tVar.f1796a.add(0, R.id.sheroes_share, 1, menuIconWithText(getResources().getDrawable(R.drawable.vector_sheroes_share_black), getResources().getString(R.string.sheroes_ID_SHARE)));
            tVar.f1796a.add(0, R.id.sheroes_edit, 2, menuIconWithText(getResources().getDrawable(R.drawable.vector_sheroes_create), getResources().getString(R.string.sheroes_ID_EDIT)));
            tVar.f1796a.add(0, R.id.sheroes_delete, 3, menuIconWithText(getResources().getDrawable(R.drawable.vector_sheroes_delete), getResources().getString(R.string.sheroes_ID_DELETE)));
            tVar.f1796a.add(0, R.id.sheroes_top_post, 4, menuIconWithText(getResources().getDrawable(R.drawable.vector_sheroes_create), getResources().getString(R.string.sheroes_FEATURE_POST)));
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
            if (userPostSolrObj.communityId.longValue() == 0) {
                tVar.f1796a.findItem(R.id.sheroes_delete).setVisible(false);
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
            if (userPostSolrObj.isSpamPost()) {
                tVar.f1796a.findItem(R.id.sheroes_share).setVisible(false);
            }
            tVar.f1798c = new t.b() {
                public boolean onMenuItemClick(MenuItem menuItem) {
                    if (menuItem.getItemId() == R.id.sheroes_share) {
                        FeedFragment.this.shareCardDetail(userPostSolrObj);
                        return true;
                    } else if (menuItem.getItemId() == R.id.sheroes_edit) {
                        FeedFragment.this.navigateToCommunityPostActivity(userPostSolrObj);
                        return true;
                    } else if (menuItem.getItemId() == R.id.sheroes_delete) {
                        AnalyticsManager.trackPostAction(Event.POST_DELETED, userPostSolrObj, FeedFragment.this.getScreenName());
                        FeedFragment.this.mFeedPresenter.deleteCommunityPostFromPresenter(AppUtils.deleteCommunityPostRequest(userPostSolrObj.getIdOfEntityOrParticipant()), userPostSolrObj);
                        return true;
                    } else if (menuItem.getItemId() != R.id.sheroes_top_post) {
                        return false;
                    } else {
                        AnalyticsManager.trackPostAction(Event.POST_TOP_POST, userPostSolrObj, FeedFragment.this.getScreenName());
                        FeedFragment.this.mFeedPresenter.editTopPost(AppUtils.topCommunityPostRequestBuilder(userPostSolrObj.communityId, FeedFragment.this.getCreatorType(userPostSolrObj), userPostSolrObj.getListDescription(), userPostSolrObj.getIdOfEntityOrParticipant(), !userPostSolrObj.isTopPost()));
                        return true;
                    }
                }
            };
        }
        tVar.f1797b.a();
    }

    /* access modifiers changed from: private */
    public void navigateToCommunityPostActivity(UserPostSolrObj userPostSolrObj) {
        CommunityPostActivity.navigateTo(this, userPostSolrObj, 5001, this.mPrimaryColor, this.mTitleTextColor, this.mScreenProperties);
    }

    private CharSequence menuIconWithText(Drawable drawable, String str) {
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        SpannableString spannableString = new SpannableString("    ".concat(String.valueOf(str)));
        spannableString.setSpan(new ImageSpan(drawable, 0), 0, 1, 33);
        return spannableString;
    }

    public boolean shouldTrackScreen() {
        return this.mCommunityTab == null;
    }

    public SheroesPresenter getPresenter() {
        return this.mFeedPresenter;
    }

    /* access modifiers changed from: private */
    public String getCreatorType(UserPostSolrObj userPostSolrObj) {
        if (userPostSolrObj.isAnonymous()) {
            return AppConstants.ANONYMOUS;
        }
        return userPostSolrObj.getEntityOrParticipantTypeId().intValue() == 15 ? AppConstants.COMMUNITY_OWNER : AppConstants.USER;
    }

    public void onCommentMenuClicked(final UserPostSolrObj userPostSolrObj, TextView textView) {
        t tVar = new t(getActivity(), textView);
        Preference<LoginResponse> preference = this.mUserPreference;
        long longValue = (preference == null || !preference.isSet() || this.mUserPreference.get() == null || this.mUserPreference.get().getUserSummary() == null) ? -1 : this.mUserPreference.get().getUserSummary().getUserId().longValue();
        Preference<LoginResponse> preference2 = this.mUserPreference;
        if (!(preference2 == null || !preference2.isSet() || this.mUserPreference.get() == null || this.mUserPreference.get().getUserSummary() == null)) {
            int userTypeId = this.mUserPreference.get().getUserSummary().getUserBO() != null ? this.mUserPreference.get().getUserSummary().getUserBO().getUserTypeId() : 0;
            if (!CommonUtil.isEmpty(userPostSolrObj.getLastComments())) {
                tVar.f1796a.add(0, R.id.sheroes_edit, 1, menuIconWithText(getResources().getDrawable(R.drawable.ic_sheroes_create), getResources().getString(R.string.sheroes_ID_EDIT)));
                tVar.f1796a.add(0, R.id.sheroes_delete, 2, menuIconWithText(getResources().getDrawable(R.drawable.ic_sheroes_delete), getResources().getString(R.string.sheroes_ID_DELETE)));
                if (longValue == userPostSolrObj.getLastComments().get(0).getParticipantUserId().longValue() || userTypeId != 2) {
                    tVar.f1796a.findItem(R.id.sheroes_edit).setEnabled(true);
                } else {
                    tVar.f1796a.findItem(R.id.sheroes_edit).setEnabled(false);
                }
                tVar.f1798c = new t.b() {
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if (menuItem.getItemId() == R.id.sheroes_edit) {
                            FeedFragment.this.onEditMenuClicked(userPostSolrObj);
                            return true;
                        } else if (menuItem.getItemId() != R.id.sheroes_delete) {
                            return false;
                        } else {
                            FeedFragment.this.onDeleteMenuClicked(userPostSolrObj);
                            return true;
                        }
                    }
                };
            } else {
                return;
            }
        }
        tVar.f1797b.a();
    }

    public void onLikesCountClicked(UserPostSolrObj userPostSolrObj) {
        AnalyticsManager.getPostProperties(userPostSolrObj, getScreenName());
        AnalyticsManager.trackEvent(Event.POST_LIKES_VIEWED, getScreenName(), (Map<String, Object>) AnalyticsManager.getPostProperties(userPostSolrObj, getScreenName()));
        LikeListBottomSheetFragment.showDialog((AppCompatActivity) getActivity(), getScreenName(), userPostSolrObj.getEntityOrParticipantId(), userPostSolrObj);
    }

    public void onUserPostLiked(UserPostSolrObj userPostSolrObj) {
        this.mFeedPresenter.getPostLikesFromPresenter(this.mAppUtils.likeRequestBuilder(userPostSolrObj.getEntityOrParticipantId(), 10), userPostSolrObj);
    }

    public void onUserPostUnLiked(UserPostSolrObj userPostSolrObj) {
        this.mFeedPresenter.getPostUnLikesFromPresenter(this.mAppUtils.likeRequestBuilder(userPostSolrObj.getEntityOrParticipantId(), 0), userPostSolrObj);
    }

    public void onSpamPostApprove(UserPostSolrObj userPostSolrObj) {
        this.mFeedPresenter.getSpamPostApproveFromPresenter(this.mAppUtils.spamPostApprovedRequestBuilder(userPostSolrObj, true, false, true), userPostSolrObj);
    }

    public void onSpamPostDelete(UserPostSolrObj userPostSolrObj) {
        this.mFeedPresenter.getSpamPostApproveFromPresenter(this.mAppUtils.spamPostApprovedRequestBuilder(userPostSolrObj, true, true, false), userPostSolrObj);
    }

    public void onCommunityJoinOrLeave(CommunityFeedSolrObj communityFeedSolrObj) {
        if (communityFeedSolrObj.isMember()) {
            communityFeedSolrObj.setMember(false);
            communityFeedSolrObj.setNoOfMembers(communityFeedSolrObj.getNoOfMembers() - 1);
            AnalyticsManager.trackCommunityAction(Event.COMMUNITY_JOINED, communityFeedSolrObj, getScreenName());
            Preference<LoginResponse> preference = this.mUserPreference;
            if (preference != null && preference.isSet() && this.mUserPreference.get().getUserSummary() != null) {
                this.mFeedPresenter.leaveCommunity(AppUtils.removeMemberRequestBuilder(Long.valueOf(communityFeedSolrObj.getIdOfEntityOrParticipant()), this.mUserPreference.get().getUserSummary().getUserId()), communityFeedSolrObj);
                return;
            }
            return;
        }
        communityFeedSolrObj.setMember(true);
        communityFeedSolrObj.setNoOfMembers(communityFeedSolrObj.getNoOfMembers() + 1);
        AnalyticsManager.trackCommunityAction(Event.COMMUNITY_LEFT, communityFeedSolrObj, getScreenName());
        Preference<LoginResponse> preference2 = this.mUserPreference;
        if (preference2 != null && preference2.isSet() && this.mUserPreference.get().getUserSummary() != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.mUserPreference.get().getUserSummary().getUserId());
            this.mFeedPresenter.joinCommunity(AppUtils.communityRequestBuilder(arrayList, communityFeedSolrObj.getIdOfEntityOrParticipant(), AppConstants.OPEN_COMMUNITY), communityFeedSolrObj);
        }
    }

    public void onSeeMoreClicked(CarouselDataObj carouselDataObj) {
        if (carouselDataObj != null && carouselDataObj.getEndPointUrl() != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(EventProperty.COLLECTION_NAME.getString(), carouselDataObj.getScreenTitle());
            hashMap.put(EventProperty.URL.getString(), carouselDataObj.getEndPointUrl());
            navigateToCollectionActivity(getActivity(), carouselDataObj.getEndPointUrl(), carouselDataObj.getScreenTitle(), this.mScreenLabel, getString(R.string.sheroes_ID_COMMUNITIES_CATEGORY), new EventProperty.Builder().eventLabel(hashMap).build(), 1003);
        }
    }

    public void navigateToCollectionActivity(Activity activity, String str, String str2, String str3, String str4, HashMap<String, Object> hashMap, int i2) {
        Intent intent = new Intent(activity, CollectionActivity.class);
        intent.putExtra(BaseActivity.SOURCE_SCREEN, str3);
        intent.putExtra(AppConstants.END_POINT_URL, str);
        intent.putExtra(AppConstants.TOOLBAR_TITTE, str2);
        intent.putExtra("screen_name", str4);
        if (CommonUtil.isNotEmpty(str4)) {
            SCREEN_LABEL = str4;
        }
        if (!CommonUtil.isEmpty(hashMap)) {
            intent.putExtra(BaseActivity.SOURCE_PROPERTIES, hashMap);
        }
        startActivityForResult(intent, i2, (Bundle) null);
    }

    public void onImagePostClicked(ImageSolrObj imageSolrObj) {
        if (CommonUtil.isNotEmpty(imageSolrObj.getDeepLinkUrl())) {
            Uri parse = Uri.parse(imageSolrObj.getDeepLinkUrl());
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            startActivity(intent);
            AnalyticsManager.trackEvent(Event.PROMO_CARD, (String) null, (Map<String, Object>) new EventProperty.Builder().eventLabel(new EventProperty.Builder().id(String.valueOf(imageSolrObj.getIdOfEntityOrParticipant())).url(imageSolrObj.getDeepLinkUrl()).build()).build());
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        RecyclerView recyclerView = this.mFeedRecyclerView;
        if (recyclerView != null) {
            recyclerView.setAdapter((RecyclerView.a) null);
        }
    }

    public void onAskQuestionClicked() {
        CommunityPost communityPost = new CommunityPost();
        communityPost.isEdit = false;
        CommunityPostActivity.navigateTo(this, communityPost, 5001, false, this.mScreenProperties);
    }

    public void userCommentLikeRequest(UserPostSolrObj userPostSolrObj, boolean z, int i2) {
        if (!CommonUtil.isEmpty(userPostSolrObj.getLastComments())) {
            Comment comment = userPostSolrObj.getLastComments().get(0);
            if (z) {
                this.mFeedPresenter.getCommentLikesFromPresenter(this.mAppUtils.likeRequestBuilder(comment.getEntityId(), 10, comment.getCommentsId()), comment, userPostSolrObj);
            } else {
                this.mFeedPresenter.getCommentUnLikesFromPresenter(this.mAppUtils.unLikeRequestBuilder(comment.getEntityId(), comment.getCommentsId()), comment, userPostSolrObj);
            }
        }
    }

    public void startProgressBar() {
        SwipeRefreshLayout swipeRefreshLayout = this.mSwipeRefresh;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.post(new Runnable() {
                public void run() {
                    if (FeedFragment.this.mSwipeRefresh != null) {
                        FeedFragment.this.mSwipeRefresh.setRefreshing(true);
                        FeedFragment.this.mSwipeRefresh.setColorSchemeResources(R.color.sheroes_mentor_green, R.color.sheroes_link_color, R.color.sheroes_email);
                    }
                }
            });
        }
    }

    public void stopProgressBar() {
        this.mEndlessRecyclerViewScrollListener.finishLoading();
        SwipeRefreshLayout swipeRefreshLayout = this.mSwipeRefresh;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(false);
            this.mAdapter.feedFinishedLoading();
        }
    }

    public void navigateToPostDetailScreen(String str, UserPostSolrObj userPostSolrObj, int i2, HashMap<String, Object> hashMap, boolean z, String str2, String str3) {
        Intent intent = new Intent(getActivity(), PostDetailActivity.class);
        intent.putExtra(BaseActivity.SOURCE_SCREEN, str);
        intent.putExtra(UserPostSolrObj.USER_POST_OBJ, g.a(userPostSolrObj));
        intent.putExtra(PostDetailActivity.SHOW_KEYBOARD, z);
        if (!CommonUtil.isEmpty(hashMap)) {
            intent.putExtra(BaseActivity.SOURCE_PROPERTIES, hashMap);
        }
        intent.putExtra(PRIMARY_COLOR, str2);
        intent.putExtra(TITLE_TEXT_COLOR, str3);
        startActivityForResult(intent, i2, (Bundle) null);
    }

    /* access modifiers changed from: private */
    public void onDeleteMenuClicked(UserPostSolrObj userPostSolrObj) {
        userPostSolrObj.setIsEditOrDelete(2);
        navigateToPostDetailScreen(getScreenName(), userPostSolrObj, AppConstants.REQUEST_CODE_FOR_POST_DETAIL, (HashMap) this.mScreenProperties.clone(), false, this.mPrimaryColor, this.mTitleTextColor);
    }

    /* access modifiers changed from: private */
    public void onEditMenuClicked(UserPostSolrObj userPostSolrObj) {
        userPostSolrObj.setIsEditOrDelete(1);
        navigateToPostDetailScreen(getScreenName(), userPostSolrObj, AppConstants.REQUEST_CODE_FOR_POST_DETAIL, (HashMap) this.mScreenProperties.clone(), false, this.mPrimaryColor, this.mTitleTextColor);
    }

    public void updateItem(FeedDetail feedDetail) {
        findPositionAndUpdateItem(feedDetail, feedDetail.getIdOfEntityOrParticipant());
    }

    public void removeItem(FeedDetail feedDetail) {
        int findPositionById = findPositionById(feedDetail.getIdOfEntityOrParticipant());
        if (findPositionById != -1) {
            this.mAdapter.removeItem(findPositionById);
        }
    }

    public void invalidateCommunityJoin(CommunityFeedSolrObj communityFeedSolrObj) {
        findPositionAndUpdateItem(communityFeedSolrObj, communityFeedSolrObj.getIdOfEntityOrParticipant());
        if (getActivity() != null && (getActivity() instanceof CollectionActivity)) {
            ((CollectionActivity) getActivity()).setData(this.mAdapter.getDataList());
        }
    }

    public void invalidateCommunityLeft(CommunityFeedSolrObj communityFeedSolrObj) {
        findPositionAndUpdateItem(communityFeedSolrObj, communityFeedSolrObj.getIdOfEntityOrParticipant());
        if (getActivity() != null && (getActivity() instanceof CollectionActivity)) {
            ((CollectionActivity) getActivity()).setData(this.mAdapter.getDataList());
        }
    }

    public void showGifLoader() {
        this.gifLoader.setVisibility(0);
    }

    public void hideGifLoader() {
        this.gifLoader.setVisibility(8);
    }

    public void updateFeedConfigDataToMixpanel(FeedResponsePojo feedResponsePojo) {
        String setOrderKey = feedResponsePojo.getSetOrderKey();
        String num = feedResponsePojo.getServerFeedConfigVersion() != null ? Integer.toString(feedResponsePojo.getServerFeedConfigVersion().intValue()) : "";
        SharedPreferences.Editor edit = SheroesSdk.getAppSharedPrefs().edit();
        edit.putString(AppConstants.FEED_CONFIG_VERSION, num);
        edit.putString(AppConstants.SET_ORDER_KEY, setOrderKey);
        edit.apply();
    }

    public int findPositionById(long j) {
        FeedAdapter feedAdapter = this.mAdapter;
        if (feedAdapter == null) {
            return -1;
        }
        List<FeedDetail> dataList = feedAdapter.getDataList();
        if (CommonUtil.isEmpty(dataList)) {
            return -1;
        }
        for (int i2 = 0; i2 < dataList.size(); i2++) {
            FeedDetail feedDetail = dataList.get(i2);
            if (feedDetail != null && feedDetail.getIdOfEntityOrParticipant() == j) {
                return i2;
            }
        }
        return -1;
    }

    public void findPositionAndUpdateItem(FeedDetail feedDetail, long j) {
        FeedAdapter feedAdapter = this.mAdapter;
        if (feedAdapter != null) {
            List<FeedDetail> dataList = feedAdapter.getDataList();
            if (!CommonUtil.isEmpty(dataList)) {
                for (int i2 = 0; i2 < dataList.size(); i2++) {
                    FeedDetail feedDetail2 = dataList.get(i2);
                    if (feedDetail2 != null && feedDetail2.getIdOfEntityOrParticipant() == j) {
                        this.mAdapter.setData(i2, feedDetail);
                    }
                    if (feedDetail2 instanceof CarouselDataObj) {
                        int i3 = 0;
                        while (true) {
                            CarouselDataObj carouselDataObj = (CarouselDataObj) feedDetail2;
                            if (i3 >= carouselDataObj.getFeedDetails().size()) {
                                break;
                            }
                            FeedDetail feedDetail3 = carouselDataObj.getFeedDetails().get(i3);
                            if (feedDetail3 != null && feedDetail3.getIdOfEntityOrParticipant() == j) {
                                carouselDataObj.getFeedDetails().set(i3, feedDetail);
                                this.mAdapter.setData(i2, feedDetail2);
                            }
                            i3++;
                        }
                    }
                }
            }
        }
    }

    public void refreshList() {
        this.mFeedPresenter.fetchFeed(0);
    }

    public void showError(String str, FeedParticipationEnum feedParticipationEnum) {
        this.noInternet.setVisibility(0);
        this.mFeedRecyclerView.setVisibility(8);
        this.gifLoader.setVisibility(8);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.sheroes_tv_retry_for_internet) {
            this.noInternet.setVisibility(8);
            this.mFeedRecyclerView.setVisibility(0);
            this.gifLoader.setVisibility(8);
        } else if (view.getId() == R.id.sheroes_tv_goto_setting) {
            startActivity(new Intent("android.settings.WIFI_SETTINGS"));
        } else if (view.getId() == R.id.sheroes_fab) {
            onFabButtonClicked();
        }
    }

    public void onFabButtonClicked() {
        CommunityPost communityPost = new CommunityPost();
        communityPost.createPostRequestFrom = 101;
        communityPost.isEdit = false;
        Intent intent = new Intent(getActivity(), CommunityPostActivity.class);
        intent.putExtra(CommunityPost.COMMUNITY_POST_OBJ, g.a(communityPost));
        intent.putExtra(CommunityPostActivity.IS_FROM_COMMUNITY, false);
        startActivityForResult(intent, 5001);
    }

    private void checkForDeeplink() {
        String string = getArguments() != null ? getArguments().getString("deep_link_url") : "";
        if (CommonUtil.isNotEmpty(string)) {
            showDeeplink(Uri.parse(string));
        }
    }
}
