package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.b;
import androidx.fragment.app.q;
import com.google.android.play.core.splitcompat.a;
import com.sheroes.final_sdk.R;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.SheroesSdk;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.Event;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.analytics.EventProperty;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.BaseActivity;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.basecomponents.SheroesPresenter;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.feed.FeedDetail;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.CommonUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.stringutils.StringUtil;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.fragments.FeedFragment;
import java.util.HashMap;
import java.util.List;
import org.parceler.g;

public class CollectionActivity extends BaseActivity {
    private static String SCREEN_LABEL = "Collection Activity";
    private static String SCREEN_LABEL_PAYTM = "/sheroes/feed/all";
    private String mEndPointUrl;
    private List<FeedDetail> mFeedDetailList = null;
    private String mTitle;
    Toolbar mToolbar;
    private HashMap<String, Object> properties = null;
    TextView titleName;

    public SheroesPresenter getPresenter() {
        return null;
    }

    public boolean shouldTrackScreen() {
        return true;
    }

    public boolean trackScreenTime() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SheroesSdk.getAppComponent(this).inject(this);
        setContentView(R.layout.activity_sheroes_communities_list);
        this.mToolbar = (Toolbar) findViewById(R.id.sheroes_toolbar);
        this.titleName = (TextView) findViewById(R.id.sheroes_title_toolbar);
        if (getIntent().getExtras() != null) {
            this.mEndPointUrl = getIntent().getExtras().getString(AppConstants.END_POINT_URL);
            this.mTitle = getIntent().getExtras().getString(AppConstants.TOOLBAR_TITTE);
            this.properties = new EventProperty.Builder().collectionName(this.mTitle).url(this.mEndPointUrl).build();
        }
        setupToolbar(this.mTitle);
        FeedFragment feedFragment = new FeedFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putString(AppConstants.END_POINT_URL, this.mEndPointUrl);
        bundle2.putSerializable(FeedFragment.SCREEN_PROPERTIES, this.properties);
        bundle2.putString("screen_name", this.mTitle);
        bundle2.putBoolean(FeedFragment.IS_HOME_FEED, false);
        q a2 = getSupportFragmentManager().a();
        feedFragment.setArguments(bundle2);
        a2.b(R.id.sheroes_container, feedFragment, (String) null);
        a2.b();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onBackPressed() {
        if (this.mFeedDetailList != null) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putParcelable("community_detail", g.a(this.mFeedDetailList));
            intent.putExtras(bundle);
            setResult(-1, intent);
        }
        finish();
    }

    public void onResume() {
        super.onResume();
        a.a((Context) this);
        a.b((Context) this);
    }

    public String getScreenName() {
        return SCREEN_LABEL_PAYTM;
    }

    public Event getEventScreenName() {
        return Event.FEED_COLLECTION_SCREEN_LOADED;
    }

    private void setupToolbar(String str) {
        setSupportActionBar(this.mToolbar);
        getSupportActionBar().b(true);
        getSupportActionBar().a((CharSequence) "");
        getSupportActionBar().b(b.a((Context) this, R.drawable.vector_sheroes_back_arrow));
        if (StringUtil.isNotNullOrEmptyString(str)) {
            this.titleName.setText(str);
        }
    }

    public void setData(List<FeedDetail> list) {
        if (StringUtil.isNotEmptyCollection(list)) {
            this.mFeedDetailList = list;
        }
    }

    public static void navigateTo(Activity activity, String str, String str2, String str3, String str4, HashMap<String, Object> hashMap, int i2) {
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
        androidx.core.app.a.a(activity, intent, i2, (Bundle) null);
    }
}
