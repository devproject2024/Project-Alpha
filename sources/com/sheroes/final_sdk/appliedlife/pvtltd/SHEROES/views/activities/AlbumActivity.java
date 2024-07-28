package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.a;
import androidx.core.content.b;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.y;
import androidx.viewpager.widget.ViewPager;
import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.AnalyticsManager;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.Event;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.EventProperty;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseActivity;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.SheroesPresenter;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.FeedDetail;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.UserPostSolrObj;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.post.Album;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.post.Config;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.post.Photo;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.presenters.AlbumPresenter;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.stringutils.StringUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.adapters.AlbumCarouselAdapter;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.adapters.AlbumGalleryAdapter;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.viewlisteners.IAlbumView;
import java.util.HashMap;
import java.util.Map;
import org.parceler.g;

public class AlbumActivity extends BaseActivity implements IAlbumView {
    private static final String MAIN_ITEM_POSITION = "Main Item Position";
    private static final String SCREEN_LABEL = "Album Activity";
    private static final String SCREEN_LABEL_PAYTM = "/sheroes/album";
    private static final String TAG = "AlbumActivity";
    /* access modifiers changed from: private */
    public Album mAlbum;
    /* access modifiers changed from: private */
    public AlbumCarouselAdapter mAlbumCarouselAdapter;
    private String mAlbumId;
    AlbumPresenter mAlbumPresenter;
    RecyclerView mImageListView;
    /* access modifiers changed from: private */
    public String mMainImageUrl;
    private int mMainItemPosition;
    ProgressBar mProgressBar;
    private String mStatusBarColor = "#aaaaaa";
    Toolbar mToolbar;
    private UserPostSolrObj mUserPostSolrObj;
    ViewPager mViewPager;

    public SheroesPresenter getPresenter() {
        return null;
    }

    public String getScreenName() {
        return SCREEN_LABEL_PAYTM;
    }

    public boolean shouldTrackScreen() {
        return true;
    }

    public void trackSaveImageEvent(String str) {
    }

    public boolean trackScreenTime() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SheroesSdk.getAppComponent(this).inject(this);
        setContentView(R.layout.activity_sheroes_album);
        this.mToolbar = (Toolbar) findViewById(R.id.sheroes_toolbar);
        this.mViewPager = (ViewPager) findViewById(R.id.sheroes_image_slides);
        this.mImageListView = (RecyclerView) findViewById(R.id.sheroes_image_list);
        this.mProgressBar = (ProgressBar) findViewById(R.id.sheroes_progress_bar);
        Parcelable parcelableExtra = getIntent().getParcelableExtra(UserPostSolrObj.USER_POST_OBJ);
        Parcelable parcelableExtra2 = getIntent().getParcelableExtra(Album.ALBUM_OBJ);
        if (parcelableExtra2 != null) {
            this.mAlbum = (Album) g.a(parcelableExtra2);
            if (this.mAlbum != null) {
                if (getIntent().getExtras() != null) {
                    this.mMainItemPosition = getIntent().getExtras().getInt(MAIN_ITEM_POSITION, 1);
                }
            } else {
                return;
            }
        } else if (getIntent().getExtras() != null) {
            this.mAlbumId = getIntent().getExtras().getString(FeedDetail.FEED_DETAIL_OBJ);
        }
        if (parcelableExtra != null) {
            this.mUserPostSolrObj = (UserPostSolrObj) g.a(parcelableExtra);
        }
        this.mAlbumPresenter.setView(this);
        setSupportActionBar(this.mToolbar);
        getSupportActionBar().b(true);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(CommonUtil.colorBurn(Color.parseColor(this.mStatusBarColor)));
        }
        this.mToolbar.setBackgroundColor(b.c(this, R.color.sheroes_transparent_dark));
        this.mToolbar.setPadding(0, CommonUtil.getStatusBarHeight(this), 0, 0);
        getWindow().getDecorView().setSystemUiVisibility(1280);
        this.mImageListView.setLayoutManager(new LinearLayoutManager(this, 0, false));
        ((y) this.mImageListView.getItemAnimator()).m = false;
        Album album = this.mAlbum;
        if (album != null && !CommonUtil.isEmpty(album.photos)) {
            showAlbum(this.mAlbum);
        }
    }

    private void initViewPager() {
        this.mViewPager.setAdapter(new AlbumGalleryAdapter(this, this.mAlbum.photos, new CommonUtil.Callback() {
            public void callBack(boolean z) {
                if (z) {
                    AlbumActivity.this.mImageListView.animate().translationY((float) AlbumActivity.this.mImageListView.getHeight()).setInterpolator(new AccelerateInterpolator()).start();
                } else {
                    AlbumActivity.this.mImageListView.animate().translationY(0.0f).setInterpolator(new DecelerateInterpolator()).start();
                }
            }
        }));
        this.mViewPager.setOffscreenPageLimit(2);
        int i2 = this.mMainItemPosition;
        if (i2 > 0 && i2 < this.mAlbum.photos.size()) {
            this.mViewPager.setCurrentItem(this.mMainItemPosition);
            this.mMainImageUrl = this.mAlbum.photos.get(this.mMainItemPosition).url;
            this.mAlbumCarouselAdapter.setSelectedPosition(this.mMainItemPosition);
        }
        this.mViewPager.addOnPageChangeListener(new ViewPager.e() {
            public void onPageScrollStateChanged(int i2) {
            }

            public void onPageScrolled(int i2, float f2, int i3) {
            }

            public void onPageSelected(int i2) {
                AlbumActivity albumActivity = AlbumActivity.this;
                String unused = albumActivity.mMainImageUrl = albumActivity.mAlbum.photos.get(i2).url;
                if (AlbumActivity.this.mImageListView != null) {
                    AlbumActivity.this.mImageListView.smoothScrollToPosition(i2);
                    AlbumActivity.this.mAlbumCarouselAdapter.setSelectedPosition(i2);
                }
                AlbumActivity.this.getSupportActionBar().a((CharSequence) AlbumActivity.this.getString(R.string.sheroes_album_title, new Object[]{Integer.valueOf(i2 + 1), Integer.valueOf(AlbumActivity.this.mAlbum.photos.size())}));
            }
        });
    }

    public Event getEventScreenName() {
        return Event.ALBUM_SCREEN_LOADED;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        menu.clear();
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            return true;
        } else if (itemId != R.id.sheroes_share || !CommonUtil.isNotEmpty(this.mAlbum.deepLinkUrl)) {
            return true;
        } else {
            HashMap<String, Object> build = new EventProperty.Builder().url(Config.COMMUNITY_POST_IMAGE_SHARE + System.getProperty("line.separator") + this.mAlbum.deepLinkUrl).build();
            UserPostSolrObj userPostSolrObj = this.mUserPostSolrObj;
            if (userPostSolrObj == null) {
                return true;
            }
            build.putAll(AnalyticsManager.getPostProperties(userPostSolrObj, ""));
            return true;
        }
    }

    private void initAlbumCarouselAdapter() {
        this.mAlbumCarouselAdapter = new AlbumCarouselAdapter(this, this.mAlbum.photos, new View.OnClickListener() {
            public void onClick(View view) {
                int childAdapterPosition = AlbumActivity.this.mImageListView.getChildAdapterPosition(view);
                AlbumActivity.this.mViewPager.setCurrentItem(childAdapterPosition);
                AlbumActivity.this.mAlbumCarouselAdapter.setSelectedPosition(childAdapterPosition);
            }
        });
        this.mImageListView.setAdapter(this.mAlbumCarouselAdapter);
    }

    private void setUpOptionMenuStates(Menu menu) {
        menu.findItem(R.id.sheroes_share).setVisible(true);
    }

    public static void navigateTo(Activity activity, FeedDetail feedDetail, String str, HashMap<String, Object> hashMap) {
        UserPostSolrObj userPostSolrObj = (UserPostSolrObj) feedDetail;
        if (feedDetail != null && !CommonUtil.isEmpty(userPostSolrObj.getImageUrls())) {
            Album album = new Album();
            for (String str2 : userPostSolrObj.getImageUrls()) {
                Photo photo = new Photo();
                photo.url = str2;
                album.photos.add(photo);
            }
            if (StringUtil.isNotNullOrEmptyString(feedDetail.getPostShortBranchUrls())) {
                album.deepLinkUrl = feedDetail.getPostShortBranchUrls();
            } else {
                album.deepLinkUrl = feedDetail.getDeepLinkUrl();
            }
            Intent intent = new Intent(activity, AlbumActivity.class);
            intent.putExtra(Album.ALBUM_OBJ, g.a(album));
            if (feedDetail instanceof UserPostSolrObj) {
                intent.putExtra(UserPostSolrObj.USER_POST_OBJ, g.a(userPostSolrObj));
            }
            intent.putExtra(BaseActivity.SOURCE_SCREEN, str);
            intent.putExtra(MAIN_ITEM_POSITION, feedDetail.getItemPosition());
            if (!CommonUtil.isEmpty(hashMap)) {
                intent.putExtra(BaseActivity.SOURCE_PROPERTIES, hashMap);
            }
            a.a(activity, intent, (Bundle) null);
        }
    }

    public void showAlbum(Album album) {
        if (!CommonUtil.isEmpty(album.photos)) {
            this.mMainImageUrl = this.mAlbum.photos.get(0).url;
            this.mAlbum = album;
            if (this.mAlbum.photos.size() < 2) {
                getSupportActionBar().a((CharSequence) "");
                this.mImageListView.setVisibility(8);
            } else {
                this.mImageListView.setVisibility(0);
                getSupportActionBar().a((CharSequence) getString(R.string.sheroes_album_title, new Object[]{Integer.valueOf(this.mMainItemPosition + 1), Integer.valueOf(this.mAlbum.photos.size())}));
            }
            initAlbumCarouselAdapter();
            initViewPager();
        }
    }

    public void showProgressBar() {
        this.mProgressBar.setVisibility(0);
    }

    public void hideProgressBar() {
        this.mProgressBar.setVisibility(8);
    }

    public void showSuccessMessage() {
        Toast.makeText(this, R.string.sheroes_img_saved_info, 1).show();
    }

    public Map<String, Object> getExtraPropertiesToTrack() {
        return AnalyticsManager.getPostProperties(this.mUserPostSolrObj, getScreenName());
    }

    public void onResume() {
        super.onResume();
        com.google.android.play.core.splitcompat.a.a((Context) this);
        com.google.android.play.core.splitcompat.a.b((Context) this);
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
