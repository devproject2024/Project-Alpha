package net.one97.paytm.dynamic.module.feed;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.google.android.play.core.splitcompat.a;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.paytm_finance.R;

public final class FeedActivity extends AppCompatActivity {
    private HashMap _$_findViewCache;
    private boolean init;

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_feed_activity);
        init();
    }

    private final void initToolbar() {
        if (((Toolbar) _$_findCachedViewById(R.id.toolbar)) != null) {
            setSupportActionBar((Toolbar) _$_findCachedViewById(R.id.toolbar));
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.b(true);
            }
            ActionBar supportActionBar2 = getSupportActionBar();
            if (supportActionBar2 != null) {
                supportActionBar2.a(true);
            }
            ActionBar supportActionBar3 = getSupportActionBar();
            if (supportActionBar3 != null) {
                supportActionBar3.a((CharSequence) getResources().getString(R.string.feed_title));
            }
        }
    }

    private final void init() {
        initToolbar();
        if (this.init) {
            j supportFragmentManager = getSupportFragmentManager();
            if (supportFragmentManager != null) {
                q a2 = supportFragmentManager.a();
                FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(R.id.feedMainContainer);
                k.a((Object) frameLayout, "feedMainContainer");
                a2.b(frameLayout.getId(), getFeedFragment(), (String) null).c();
                return;
            }
            return;
        }
        finish();
    }

    private final void initFeedModule(Application application) {
        this.init = InboxFeedDataProvider.INSTANCE.initFeedModule(application);
        new FeedModuleManager().init(application);
    }

    private final Fragment getFeedFragment() {
        return InboxFeedDataProvider.INSTANCE.getFeedFragment();
    }

    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        Context context2 = this;
        a.a(context2);
        a.b(context2);
        Context applicationContext = context != null ? context.getApplicationContext() : null;
        if (!(applicationContext instanceof Application)) {
            applicationContext = null;
        }
        Application application = (Application) applicationContext;
        if (application != null) {
            initFeedModule(application);
        }
    }

    public final boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public final void onResume() {
        super.onResume();
        Context context = this;
        a.a(context);
        a.b(context);
    }
}
