package net.one97.paytm.feed.ui.feed.story;

import android.app.ActionBar;
import android.os.Build;
import android.os.Parcelable;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.j;
import androidx.viewpager.widget.ViewPager;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.b.ci;
import net.one97.paytm.feed.repository.models.stories.Stories;
import net.one97.paytm.feed.ui.base.FeedBaseActivity;

public final class StoryViewActivity extends FeedBaseActivity<ci, Object> {

    /* renamed from: f  reason: collision with root package name */
    public static final a f35179f = new a((byte) 0);

    /* renamed from: i  reason: collision with root package name */
    private static int f35180i = -1;
    private static int j = -1;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<Stories> f35181c;

    /* renamed from: d  reason: collision with root package name */
    public Stories f35182d;

    /* renamed from: e  reason: collision with root package name */
    int f35183e;

    /* renamed from: g  reason: collision with root package name */
    private final String f35184g = "StoryViewActivity::";

    /* renamed from: h  reason: collision with root package name */
    private g f35185h;

    public static final /* synthetic */ ci a(StoryViewActivity storyViewActivity) {
        return (ci) storyViewActivity.a();
    }

    public final int c() {
        return R.layout.feed_storyview;
    }

    public final HashMap<Integer, Object> d() {
        return new HashMap<>();
    }

    public final void e() {
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.a((TreeSet<Integer>) new TreeSet());
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(TarConstants.EOF_BLOCK, TarConstants.EOF_BLOCK);
        } else {
            Window window = getWindow();
            k.a((Object) window, "window");
            View decorView = window.getDecorView();
            k.a((Object) decorView, "window.decorView");
            decorView.setSystemUiVisibility(4);
            ActionBar actionBar = getActionBar();
            if (actionBar != null) {
                actionBar.hide();
            }
        }
        ArrayList<Stories> parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("stories");
        k.a((Object) parcelableArrayListExtra, "intent.getParcelableArra…Extra<Stories>(\"stories\")");
        this.f35181c = parcelableArrayListExtra;
        Parcelable parcelableExtra = getIntent().getParcelableExtra("data");
        k.a((Object) parcelableExtra, "intent.getParcelableExtra(\"data\")");
        this.f35182d = (Stories) parcelableExtra;
        f35180i = getIntent().getIntExtra(CLPConstants.ARGUMENT_KEY_POSITION, -1);
        j = getIntent().getIntExtra("storyCardPosition", -1);
        ArrayList<Stories> arrayList = this.f35181c;
        if (arrayList == null) {
            k.a("stories");
        }
        j supportFragmentManager = getSupportFragmentManager();
        k.a((Object) supportFragmentManager, "supportFragmentManager");
        this.f35185h = new g(arrayList, supportFragmentManager);
        ViewPager viewPager = ((ci) a()).f34052a;
        k.a((Object) viewPager, "dataBinding.feedStoryViewpager");
        viewPager.setAdapter(this.f35185h);
        ((ci) a()).f34052a.setPageTransformer(true, new a());
        ((ci) a()).f34052a.setCurrentItem(f35180i, false);
        ViewPager viewPager2 = ((ci) a()).f34052a;
        k.a((Object) viewPager2, "dataBinding.feedStoryViewpager");
        viewPager2.setOffscreenPageLimit(1);
    }

    public final void onPause() {
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.d(j);
        net.one97.paytm.feed.e.b bVar2 = net.one97.paytm.feed.e.b.f34268c;
        net.one97.paytm.feed.e.b.k();
        super.onPause();
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ StoryViewActivity f35188a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f35189b;

        c(StoryViewActivity storyViewActivity, int i2) {
            this.f35188a = storyViewActivity;
            this.f35189b = i2;
        }

        public final void run() {
            StoryViewActivity.a(this.f35188a).f34052a.setCurrentItem(this.f35189b + 1, true);
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ StoryViewActivity f35186a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f35187b;

        b(StoryViewActivity storyViewActivity, int i2) {
            this.f35186a = storyViewActivity;
            this.f35187b = i2;
        }

        public final void run() {
            StoryViewActivity.a(this.f35186a).f34052a.setCurrentItem(this.f35187b - 1, true);
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
