package net.one97.paytm.feed.ui.profile;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.o;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.repository.models.Category;
import net.one97.paytm.feed.repository.models.profile.FeedProfile;
import net.one97.paytm.feed.repository.models.profile.Following;
import net.one97.paytm.feed.repository.models.profile.UserData;
import net.one97.paytm.feed.settings.FeedLanguageSettings;
import net.one97.paytm.feed.ui.base.FeedNoBindingBaseActivity;
import net.one97.paytm.feed.ui.feed.FeedFragment;
import net.one97.paytm.feed.ui.profile.c;

public final class ProfileActivity extends FeedNoBindingBaseActivity implements AppBarLayout.b, c.b {

    /* renamed from: b  reason: collision with root package name */
    public static final a f35247b = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    ArrayList<String> f35248a = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final float f35249c = 0.9f;

    /* renamed from: d  reason: collision with root package name */
    private final float f35250d = 0.3f;

    /* renamed from: e  reason: collision with root package name */
    private final int f35251e = 200;

    /* renamed from: f  reason: collision with root package name */
    private ViewGroup f35252f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f35253g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f35254h = true;

    /* renamed from: i  reason: collision with root package name */
    private int f35255i = -1;
    private AppBarLayout j;
    /* access modifiers changed from: private */
    public ViewPager k;
    private Toolbar l;
    private String m = "";
    private TextView n;
    private ImageView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private b s;

    static final class c extends l implements kotlin.g.a.b<FeedProfile, x> {
        final /* synthetic */ ProfileActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(ProfileActivity profileActivity) {
            super(1);
            this.this$0 = profileActivity;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((FeedProfile) obj);
            return x.f47997a;
        }

        public final void invoke(FeedProfile feedProfile) {
            androidx.viewpager.widget.a adapter;
            Object obj;
            b bVar;
            List<Following> list;
            androidx.viewpager.widget.a adapter2;
            Object obj2 = null;
            if (feedProfile != null) {
                ProfileActivity.a(this.this$0, feedProfile.getResult().getUserData());
                ViewPager a2 = this.this$0.k;
                if (a2 == null || (adapter2 = a2.getAdapter()) == null) {
                    obj = null;
                } else {
                    ViewPager a3 = this.this$0.k;
                    if (a3 == null) {
                        k.a();
                    }
                    obj = adapter2.instantiateItem((ViewGroup) a3, 0);
                }
                if (obj != null) {
                    c cVar = (c) obj;
                    if (cVar != null) {
                        List<Following> following = feedProfile.getResult().getFollowing();
                        k.c(following, "following");
                        b bVar2 = cVar.f35295a;
                        if (bVar2 != null) {
                            k.c(following, "following");
                            if (!following.isEmpty()) {
                                ArrayList arrayList = new ArrayList(bVar2.f35284a);
                                arrayList.addAll(following);
                                bVar2.f35284a = arrayList;
                                bVar2.notifyDataSetChanged();
                            }
                        }
                        b bVar3 = cVar.f35295a;
                        if (bVar3 != null) {
                            obj2 = bVar3.f35284a;
                        }
                        if (!(obj2 == null || (bVar = cVar.f35295a) == null || (list = bVar.f35284a) == null || list.size() != 0)) {
                            if (following.size() == 0) {
                                LinearLayout linearLayout = cVar.f35297c;
                                if (linearLayout != null) {
                                    linearLayout.setVisibility(0);
                                }
                                RecyclerView recyclerView = cVar.f35296b;
                                if (recyclerView != null) {
                                    recyclerView.setVisibility(8);
                                }
                            } else {
                                LinearLayout linearLayout2 = cVar.f35297c;
                                if (linearLayout2 != null) {
                                    linearLayout2.setVisibility(8);
                                }
                                RecyclerView recyclerView2 = cVar.f35296b;
                                if (recyclerView2 != null) {
                                    recyclerView2.setVisibility(0);
                                }
                            }
                        }
                    }
                    if (cVar != null) {
                        cVar.f35298d = false;
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.feed.ui.profile.FollowingFragment");
            }
            ViewPager a4 = this.this$0.k;
            if (!(a4 == null || (adapter = a4.getAdapter()) == null)) {
                ViewPager a5 = this.this$0.k;
                if (a5 == null) {
                    k.a();
                }
                obj2 = adapter.instantiateItem((ViewGroup) a5, 0);
            }
            if (obj2 != null) {
                c cVar2 = (c) obj2;
                if (cVar2 != null) {
                    cVar2.f35298d = false;
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.feed.ui.profile.FollowingFragment");
        }
    }

    static final class e extends l implements kotlin.g.a.b<String, x> {
        final /* synthetic */ Following $item;
        final /* synthetic */ ProfileActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(ProfileActivity profileActivity, Following following) {
            super(1);
            this.this$0 = profileActivity;
            this.$item = following;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return x.f47997a;
        }

        public final void invoke(String str) {
            Object obj;
            androidx.viewpager.widget.a adapter;
            if (str != null) {
                net.one97.paytm.feed.repository.db.a aVar = net.one97.paytm.feed.repository.db.a.f34614a;
                Context context = this.this$0;
                Following following = this.$item;
                if (following == null) {
                    k.a();
                }
                net.one97.paytm.feed.repository.db.a.a(context, following.getUserId(), true);
                this.$item.setFollowing(true);
                ViewPager a2 = this.this$0.k;
                if (a2 == null || (adapter = a2.getAdapter()) == null) {
                    obj = null;
                } else {
                    ViewPager a3 = this.this$0.k;
                    if (a3 == null) {
                        k.a();
                    }
                    obj = adapter.instantiateItem((ViewGroup) a3, 0);
                }
                if (obj != null) {
                    b bVar = ((c) obj).f35295a;
                    if (bVar != null) {
                        bVar.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.feed.ui.profile.FollowingFragment");
            }
        }
    }

    static final class f extends l implements kotlin.g.a.b<String, x> {
        final /* synthetic */ Following $item;
        final /* synthetic */ ProfileActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(ProfileActivity profileActivity, Following following) {
            super(1);
            this.this$0 = profileActivity;
            this.$item = following;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return x.f47997a;
        }

        public final void invoke(String str) {
            Object obj;
            androidx.viewpager.widget.a adapter;
            if (str != null) {
                net.one97.paytm.feed.repository.db.a aVar = net.one97.paytm.feed.repository.db.a.f34614a;
                Context context = this.this$0;
                Following following = this.$item;
                if (following == null) {
                    k.a();
                }
                net.one97.paytm.feed.repository.db.a.a(context, following.getUserId(), false);
                this.$item.setFollowing(false);
                ViewPager a2 = this.this$0.k;
                if (a2 == null || (adapter = a2.getAdapter()) == null) {
                    obj = null;
                } else {
                    ViewPager a3 = this.this$0.k;
                    if (a3 == null) {
                        k.a();
                    }
                    obj = adapter.instantiateItem((ViewGroup) a3, 0);
                }
                if (obj != null) {
                    b bVar = ((c) obj).f35295a;
                    if (bVar != null) {
                        bVar.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.feed.ui.profile.FollowingFragment");
            }
        }
    }

    public final void a(Following following) {
        if (following == null) {
            k.a();
        }
        if (!following.getFollowing()) {
            net.one97.paytm.feed.c.a aVar = net.one97.paytm.feed.c.a.f34255a;
            net.one97.paytm.feed.c.a.a().b((Context) this, "/content-social-graph/v1/follow", following.getUserId(), (kotlin.g.a.b<? super String, x>) new e(this, following));
            return;
        }
        net.one97.paytm.feed.c.a aVar2 = net.one97.paytm.feed.c.a.f34255a;
        net.one97.paytm.feed.c.a.a().b((Context) this, "/content-social-graph/v1/unfollow", following.getUserId(), (kotlin.g.a.b<? super String, x>) new f(this, following));
    }

    public final void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
        Float f2 = null;
        Integer valueOf = appBarLayout != null ? Integer.valueOf(appBarLayout.getTotalScrollRange()) : null;
        float abs = (float) Math.abs(i2);
        if (valueOf != null) {
            f2 = Float.valueOf((float) valueOf.intValue());
        }
        if (f2 == null) {
            k.a();
        }
        float floatValue = abs / f2.floatValue();
        if (floatValue >= this.f35250d) {
            if (this.f35254h) {
                ViewGroup viewGroup = this.f35252f;
                if (viewGroup == null) {
                    k.a();
                }
                a(viewGroup, (long) this.f35251e, 4);
                this.f35254h = false;
            }
        } else if (!this.f35254h) {
            ViewGroup viewGroup2 = this.f35252f;
            if (viewGroup2 == null) {
                k.a();
            }
            a(viewGroup2, (long) this.f35251e, 0);
            this.f35254h = true;
        }
        if (floatValue >= this.f35249c) {
            if (!this.f35253g) {
                TextView textView = this.r;
                if (textView == null) {
                    k.a("mTitle");
                }
                a(textView, (long) this.f35251e, 0);
                this.f35253g = true;
            }
        } else if (this.f35253g) {
            TextView textView2 = this.r;
            if (textView2 == null) {
                k.a("mTitle");
            }
            a(textView2, (long) this.f35251e, 4);
            this.f35253g = false;
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.feed_profile_detail);
        this.j = (AppBarLayout) findViewById(R.id.appbar);
        this.l = (Toolbar) findViewById(R.id.profile__toolbar);
        this.f35252f = (ViewGroup) findViewById(R.id.profile_header);
        View findViewById = findViewById(R.id.title);
        if (findViewById != null) {
            this.r = (TextView) findViewById;
            AppBarLayout appBarLayout = this.j;
            if (appBarLayout != null) {
                appBarLayout.a((AppBarLayout.b) this);
            }
            this.n = (TextView) findViewById(R.id.username);
            this.p = (TextView) findViewById(R.id.followingCount);
            this.q = (TextView) findViewById(R.id.bookmarkCount);
            this.o = (ImageView) findViewById(R.id.userAvatar);
            Toolbar toolbar = this.l;
            if (toolbar != null) {
                setSupportActionBar(toolbar);
            }
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.b(true);
            }
            Toolbar toolbar2 = this.l;
            if (toolbar2 != null) {
                toolbar2.setNavigationOnClickListener(new h(this));
            }
            if (getSupportActionBar() != null) {
                ActionBar supportActionBar2 = getSupportActionBar();
                if (supportActionBar2 == null) {
                    k.a();
                }
                k.a((Object) supportActionBar2, "supportActionBar!!");
                supportActionBar2.a((CharSequence) "");
            }
            androidx.appcompat.app.e.m();
            this.f35248a.add(getString(R.string.feed_following));
            this.f35248a.add(getString(R.string.bookmarks));
            View findViewById2 = findViewById(R.id.profile_viewpager);
            if (findViewById2 != null) {
                this.k = (ViewPager) findViewById2;
                Context context = this;
                j supportFragmentManager = getSupportFragmentManager();
                k.a((Object) supportFragmentManager, "supportFragmentManager");
                this.s = new b(context, supportFragmentManager);
                ViewPager viewPager = this.k;
                if (viewPager != null) {
                    b bVar = this.s;
                    if (bVar == null) {
                        k.a("adapter");
                    }
                    viewPager.setAdapter(bVar);
                    ViewPager viewPager2 = this.k;
                    if (viewPager2 != null) {
                        viewPager2.setOffscreenPageLimit(1);
                        View findViewById3 = findViewById(R.id.profile_tabs);
                        if (findViewById3 != null) {
                            TabLayout tabLayout = (TabLayout) findViewById3;
                            tabLayout.setupWithViewPager(this.k);
                            int size = this.f35248a.size();
                            for (int i2 = 0; i2 < size; i2++) {
                                TabLayout.f a2 = tabLayout.a(i2);
                                if (a2 != null) {
                                    View inflate = LayoutInflater.from(context).inflate(R.layout.feed_profile_tab, (ViewGroup) null);
                                    TextView textView = (TextView) inflate.findViewById(R.id.updates_title_text);
                                    k.a((Object) textView, "tabTextView");
                                    textView.setText(this.f35248a.get(i2));
                                    if (i2 == 0) {
                                        textView.setTextColor(androidx.core.content.b.c(context, R.color.feed_white));
                                        textView.setTypeface(Typeface.create("sans-serif", 0));
                                        textView.setBackground(androidx.core.content.b.a(context, R.drawable.feed_profile_tab_left));
                                        Drawable background = textView.getBackground();
                                        if (background == null) {
                                            k.a();
                                        }
                                        a(background, R.color.feed_paytm_blue);
                                    } else if (i2 == 1) {
                                        textView.setTypeface(Typeface.create("sans-serif", 0));
                                        textView.setTextColor(androidx.core.content.b.c(context, R.color.feed_paytm_blue));
                                        textView.setBackground(androidx.core.content.b.a(context, R.drawable.feed_profile_tab_right));
                                        Drawable background2 = textView.getBackground();
                                        if (background2 == null) {
                                            k.a();
                                        }
                                        a(background2, R.color.feed_white);
                                    }
                                    k.a((Object) inflate, "view");
                                    a2.a(inflate);
                                }
                            }
                            tabLayout.a((TabLayout.b) new g(this, tabLayout));
                            TextView textView2 = this.r;
                            if (textView2 == null) {
                                k.a("mTitle");
                            }
                            a(textView2, 0, 4);
                            a(context);
                            ImageView imageView = this.o;
                            if (imageView != null) {
                                imageView.setOnClickListener(new d(this));
                                return;
                            }
                            return;
                        }
                        throw new u("null cannot be cast to non-null type com.google.android.material.tabs.TabLayout");
                    }
                    throw new u("null cannot be cast to non-null type androidx.viewpager.widget.ViewPager");
                }
                throw new u("null cannot be cast to non-null type androidx.viewpager.widget.ViewPager");
            }
            throw new u("null cannot be cast to non-null type androidx.viewpager.widget.ViewPager");
        }
        throw new u("null cannot be cast to non-null type android.widget.TextView");
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ProfileActivity f35258a;

        d(ProfileActivity profileActivity) {
            this.f35258a = profileActivity;
        }

        public final void onClick(View view) {
            net.one97.paytm.feed.utility.j jVar = net.one97.paytm.feed.utility.j.f35397a;
            if (net.one97.paytm.feed.utility.j.e(this.f35258a)) {
                net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
                net.one97.paytm.feed.e.b.c((Context) this.f35258a);
                return;
            }
            Toast.makeText(this.f35258a, R.string.feed_no_internet, 0).show();
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final class g implements TabLayout.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ProfileActivity f35259a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TabLayout f35260b;

        public final void onTabReselected(TabLayout.f fVar) {
        }

        g(ProfileActivity profileActivity, TabLayout tabLayout) {
            this.f35259a = profileActivity;
            this.f35260b = tabLayout;
        }

        public final void onTabUnselected(TabLayout.f fVar) {
            View view;
            Iterator it2 = this.f35259a.f35248a.iterator();
            int i2 = 0;
            while (it2.hasNext()) {
                it2.next();
                int i3 = i2 + 1;
                if (i2 < 0) {
                    kotlin.a.k.a();
                }
                TabLayout.f a2 = this.f35260b.a(i2);
                Drawable drawable = null;
                if (a2 != null) {
                    view = a2.f36766f;
                } else {
                    view = null;
                }
                TextView textView = view != null ? (TextView) view.findViewById(R.id.updates_title_text) : null;
                if (textView != null) {
                    textView.setTypeface(Typeface.create("sans-serif", 0));
                }
                if (textView != null) {
                    textView.setTextColor(androidx.core.content.b.c(this.f35259a, R.color.feed_paytm_blue));
                }
                ProfileActivity profileActivity = this.f35259a;
                if (textView != null) {
                    drawable = textView.getBackground();
                }
                if (drawable == null) {
                    k.a();
                }
                profileActivity.a(drawable, R.color.feed_white);
                i2 = i3;
            }
        }

        public final void onTabSelected(TabLayout.f fVar) {
            View view;
            if (fVar != null) {
                TabLayout.f a2 = this.f35260b.a(fVar.f36765e);
                Drawable drawable = null;
                if (a2 != null) {
                    view = a2.f36766f;
                } else {
                    view = null;
                }
                TextView textView = view != null ? (TextView) view.findViewById(R.id.updates_title_text) : null;
                if (textView != null) {
                    textView.setTextColor(androidx.core.content.b.c(this.f35259a, R.color.feed_white));
                }
                if (textView != null) {
                    textView.setTypeface(Typeface.create("sans-serif", 0));
                }
                ProfileActivity profileActivity = this.f35259a;
                if (textView != null) {
                    drawable = textView.getBackground();
                }
                if (drawable == null) {
                    k.a();
                }
                profileActivity.a(drawable, R.color.feed_paytm_blue);
            }
        }
    }

    public final void a(Drawable drawable, int i2) {
        k.c(drawable, "background");
        if (drawable instanceof ShapeDrawable) {
            Paint paint = ((ShapeDrawable) drawable).getPaint();
            k.a((Object) paint, "shapeDrawable.paint");
            paint.setColor(androidx.core.content.b.c(this, i2));
        } else if (drawable instanceof GradientDrawable) {
            ((GradientDrawable) drawable).setColor(androidx.core.content.b.c(this, i2));
        } else if (drawable instanceof ColorDrawable) {
            ((ColorDrawable) drawable).setColor(androidx.core.content.b.c(this, i2));
        }
    }

    public static final class b extends o {

        /* renamed from: a  reason: collision with root package name */
        private final Context f35256a;

        /* renamed from: b  reason: collision with root package name */
        private j f35257b;

        public final int getCount() {
            return 2;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Context context, j jVar) {
            super(jVar);
            k.c(context, "mContext");
            k.c(jVar, "fm");
            this.f35256a = context;
            this.f35257b = jVar;
        }

        public final Fragment getItem(int i2) {
            c cVar;
            if (i2 == 0) {
                c.a aVar = c.f35294e;
                c cVar2 = new c();
                Bundle bundle = new Bundle();
                bundle.putInt("column-count", 3);
                cVar2.setArguments(bundle);
                cVar = cVar2;
            } else if (i2 == 1) {
                Bundle bundle2 = new Bundle();
                FeedFragment.a aVar2 = FeedFragment.f34877i;
                String n = FeedFragment.B;
                FeedFragment.a aVar3 = FeedFragment.f34877i;
                Category category = new Category(n, FeedFragment.B, "", "");
                bundle2.putInt("providerId", -1);
                FeedFragment.a aVar4 = FeedFragment.f34877i;
                bundle2.putParcelable(FeedFragment.y, category);
                FeedFragment.a aVar5 = FeedFragment.f34877i;
                cVar = FeedFragment.a.a(bundle2);
            } else {
                cVar = new FeedFragment();
            }
            return cVar;
        }
    }

    public final boolean onCreateOptionsMenu(Menu menu) {
        k.c(menu, "menu");
        MenuInflater menuInflater = getMenuInflater();
        k.a((Object) menuInflater, "menuInflater");
        menuInflater.inflate(R.menu.feed_profile_menu, menu);
        return true;
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ProfileActivity f35261a;

        h(ProfileActivity profileActivity) {
            this.f35261a = profileActivity;
        }

        public final void onClick(View view) {
            this.f35261a.onBackPressed();
        }
    }

    private static void a(View view, long j2, int i2) {
        AlphaAnimation alphaAnimation;
        k.c(view, "v");
        if (i2 == 0) {
            alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        } else {
            alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        }
        alphaAnimation.setDuration(j2);
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
    }

    public final void a(Context context) {
        k.c(context, "context");
        net.one97.paytm.feed.c.a aVar = net.one97.paytm.feed.c.a.f34255a;
        net.one97.paytm.feed.c.a.a().a(context, (kotlin.g.a.b<? super FeedProfile, x>) new c(this));
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem != null && menuItem.getItemId() == R.id.language) {
            net.one97.paytm.feed.utility.u uVar = net.one97.paytm.feed.utility.u.f35438a;
            if (!net.one97.paytm.feed.utility.u.a() && !isFinishing()) {
                net.one97.paytm.feed.utility.j jVar = net.one97.paytm.feed.utility.j.f35397a;
                Context context = this;
                if (net.one97.paytm.feed.utility.j.e(context)) {
                    FeedLanguageSettings.a aVar = FeedLanguageSettings.f34806a;
                    k.c(context, "context");
                    context.startActivity(new Intent(context, FeedLanguageSettings.class));
                }
            }
        }
        return true;
    }

    public final void onBackPressed() {
        net.one97.paytm.feed.repository.db.a aVar = net.one97.paytm.feed.repository.db.a.f34614a;
        Context applicationContext = getApplicationContext();
        k.a((Object) applicationContext, "this.applicationContext");
        net.one97.paytm.feed.repository.db.a.c(applicationContext);
        net.one97.paytm.feed.b bVar = net.one97.paytm.feed.b.f33792d;
        net.one97.paytm.feed.b.a(0);
        net.one97.paytm.feed.b bVar2 = net.one97.paytm.feed.b.f33792d;
        net.one97.paytm.feed.b.b(0);
        net.one97.paytm.feed.b bVar3 = net.one97.paytm.feed.b.f33792d;
        FeedFragment.a aVar2 = FeedFragment.f34877i;
        net.one97.paytm.feed.b.a(FeedFragment.z);
        super.onBackPressed();
    }

    public final void onDestroy() {
        super.onDestroy();
        net.one97.paytm.feed.repository.db.a aVar = net.one97.paytm.feed.repository.db.a.f34614a;
        Context applicationContext = getApplicationContext();
        k.a((Object) applicationContext, "this.applicationContext");
        net.one97.paytm.feed.repository.db.a.c(applicationContext);
        net.one97.paytm.feed.b bVar = net.one97.paytm.feed.b.f33792d;
        net.one97.paytm.feed.b.a(0);
        net.one97.paytm.feed.b bVar2 = net.one97.paytm.feed.b.f33792d;
        net.one97.paytm.feed.b.b(0);
        net.one97.paytm.feed.b bVar3 = net.one97.paytm.feed.b.f33792d;
        FeedFragment.a aVar2 = FeedFragment.f34877i;
        net.one97.paytm.feed.b.a(FeedFragment.z);
    }

    public static final /* synthetic */ void a(ProfileActivity profileActivity, UserData userData) {
        if (userData != null) {
            try {
                profileActivity.f35255i = Integer.parseInt(userData.getFollowingCountDisplay());
            } catch (Exception unused) {
                profileActivity.f35255i = -1;
            }
            TextView textView = profileActivity.n;
            if (textView != null) {
                textView.setText(userData.getName());
            }
            TextView textView2 = profileActivity.p;
            if (textView2 != null) {
                textView2.setText(userData.getFollowingCountDisplay() + "  " + profileActivity.getString(R.string.feed_following));
            }
            if (userData.getBookmarkCount() > 1) {
                TextView textView3 = profileActivity.q;
                if (textView3 != null) {
                    textView3.setText(userData.getBookmarkCountDisplay() + "  " + profileActivity.getString(R.string.bookmarks));
                }
            } else {
                TextView textView4 = profileActivity.q;
                if (textView4 != null) {
                    textView4.setText(userData.getBookmarkCountDisplay() + "  " + profileActivity.getString(R.string.bookmark));
                }
            }
            ImageView imageView = profileActivity.o;
            if (imageView == null) {
                k.a();
            }
            net.one97.paytm.feed.utility.a.b(imageView, userData.getImageUrl(), "64", "64");
            TextView textView5 = profileActivity.r;
            if (textView5 == null) {
                k.a("mTitle");
            }
            textView5.setText(userData.getName());
        }
    }
}
