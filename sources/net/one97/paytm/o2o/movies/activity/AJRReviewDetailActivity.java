package net.one97.paytm.o2o.movies.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.m;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.adapter.CriticRatingReviewItem;
import net.one97.paytm.o2o.movies.adapter.CriticReviewAndRating;
import net.one97.paytm.o2o.movies.adapter.DwhSource;
import net.one97.paytm.o2o.movies.common.customui.CustomTabLayout;
import net.one97.paytm.o2o.movies.fragment.m;
import net.one97.paytm.o2o.movies.utils.n;

public final class AJRReviewDetailActivity extends AppBaseActivity implements CustomTabLayout.b {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f74085a;

    private View a(int i2) {
        if (this.f74085a == null) {
            this.f74085a = new HashMap();
        }
        View view = (View) this.f74085a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f74085a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onCreate(Bundle bundle) {
        List<CriticRatingReviewItem> list;
        ArrayList<CriticRatingReviewItem> reviews;
        super.onCreate(bundle);
        setContentView(R.layout.activity_review_detail);
        Intent intent = getIntent();
        Integer num = null;
        CriticReviewAndRating criticReviewAndRating = intent != null ? (CriticReviewAndRating) intent.getParcelableExtra("ratingAndReview") : null;
        Intent intent2 = getIntent();
        String stringExtra = intent2 != null ? intent2.getStringExtra("movieName") : null;
        TextView textView = (TextView) a(R.id.movieName);
        k.a((Object) textView, "movieName");
        textView.setText(stringExtra);
        CustomTabLayout customTabLayout = (CustomTabLayout) a(R.id.review_details_tabs);
        k.a((Object) customTabLayout, "review_details_tabs");
        customTabLayout.setTabGravity(0);
        Context context = this;
        ((CustomTabLayout) a(R.id.review_details_tabs)).setSelectedTabIndicatorWidth(n.a(100, context));
        ((CustomTabLayout) a(R.id.review_details_tabs)).setSelectedTabIndicatorColor(androidx.core.content.b.c(context, R.color.color_00b9f5));
        Resources resources = getResources();
        k.a((Object) resources, "resources");
        ((CustomTabLayout) a(R.id.review_details_tabs)).setSelectedTabIndicatorHeight((int) (resources.getDisplayMetrics().density * 2.0f));
        j supportFragmentManager = getSupportFragmentManager();
        k.a((Object) supportFragmentManager, "supportFragmentManager");
        a aVar = new a(supportFragmentManager, criticReviewAndRating != null ? criticReviewAndRating.getReviews() : null, context);
        ViewPager viewPager = (ViewPager) a(R.id.reviewDetailViewpager);
        k.a((Object) viewPager, "reviewDetailViewpager");
        viewPager.setOffscreenPageLimit(3);
        ViewPager viewPager2 = (ViewPager) a(R.id.reviewDetailViewpager);
        k.a((Object) viewPager2, "reviewDetailViewpager");
        viewPager2.setAdapter(aVar);
        ((CustomTabLayout) a(R.id.review_details_tabs)).setupWithViewPager((ViewPager) a(R.id.reviewDetailViewpager), true);
        CustomTabLayout customTabLayout2 = (CustomTabLayout) a(R.id.review_details_tabs);
        k.a((Object) customTabLayout2, "review_details_tabs");
        customTabLayout2.setTabMode(0);
        Integer valueOf = (criticReviewAndRating == null || (reviews = criticReviewAndRating.getReviews()) == null) ? null : Integer.valueOf(reviews.size());
        if (valueOf == null) {
            k.a();
        }
        if (valueOf.intValue() <= 0) {
            CustomTabLayout customTabLayout3 = (CustomTabLayout) a(R.id.review_details_tabs);
            k.a((Object) customTabLayout3, "review_details_tabs");
            customTabLayout3.setVisibility(8);
        }
        CustomTabLayout customTabLayout4 = (CustomTabLayout) a(R.id.review_details_tabs);
        k.a((Object) customTabLayout4, "review_details_tabs");
        int tabCount = customTabLayout4.getTabCount();
        for (int i2 = 0; i2 < tabCount; i2++) {
            CustomTabLayout.e a2 = ((CustomTabLayout) a(R.id.review_details_tabs)).a(i2);
            CharSequence pageTitle = aVar.getPageTitle(i2);
            if (!(pageTitle == null || p.a(pageTitle)) && a2 != null) {
                View inflate = LayoutInflater.from(aVar.f74087b).inflate(R.layout.critic_custom_tab, (ViewGroup) null, false);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                if (i2 == 0 && (list = aVar.f74086a) != null && list.size() == 1) {
                    layoutParams.addRule(9);
                } else {
                    layoutParams.addRule(13);
                }
                if (i2 == 0) {
                    k.a((Object) inflate, "view");
                    ((TextView) inflate.findViewById(R.id.textView)).setPadding(0, 0, n.a(5, inflate.getContext()), 0);
                } else {
                    k.a((Object) inflate, "view");
                    ((TextView) inflate.findViewById(R.id.textView)).setPadding(n.a(5, inflate.getContext()), 0, n.a(5, inflate.getContext()), 0);
                }
                TextView textView2 = (TextView) inflate.findViewById(R.id.textView);
                k.a((Object) textView2, "view.textView");
                textView2.setLayoutParams(layoutParams);
                TextView textView3 = (TextView) inflate.findViewById(R.id.textView);
                k.a((Object) textView3, "view.textView");
                textView3.setText(aVar.getPageTitle(i2));
                a2.a(inflate);
            }
        }
        ((CustomTabLayout) a(R.id.review_details_tabs)).a((CustomTabLayout.b) this);
        if (criticReviewAndRating != null) {
            CriticRatingReviewItem criticRatingReviewItem = new CriticRatingReviewItem(0, 0, criticReviewAndRating.getSelectedSourceId(), (DwhSource) null, (String) null, (String) null, (String) null, (String) null, (String) null);
            ViewPager viewPager3 = (ViewPager) a(R.id.reviewDetailViewpager);
            k.a((Object) viewPager3, "reviewDetailViewpager");
            ArrayList<CriticRatingReviewItem> reviews2 = criticReviewAndRating.getReviews();
            if (reviews2 != null) {
                num = Integer.valueOf(reviews2.indexOf(criticRatingReviewItem));
            }
            if (num == null) {
                k.a();
            }
            viewPager3.setCurrentItem(num.intValue());
            ViewPager viewPager4 = (ViewPager) a(R.id.reviewDetailViewpager);
            k.a((Object) viewPager4, "reviewDetailViewpager");
            a(((CustomTabLayout) a(R.id.review_details_tabs)).a(viewPager4.getCurrentItem()));
        }
        ((ImageView) a(R.id.crossIcon)).setOnClickListener(new b(this));
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRReviewDetailActivity f74088a;

        b(AJRReviewDetailActivity aJRReviewDetailActivity) {
            this.f74088a = aJRReviewDetailActivity;
        }

        public final void onClick(View view) {
            this.f74088a.onBackPressed();
        }
    }

    public static final class a extends m {

        /* renamed from: a  reason: collision with root package name */
        final List<CriticRatingReviewItem> f74086a;

        /* renamed from: b  reason: collision with root package name */
        Context f74087b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(j jVar, List<CriticRatingReviewItem> list, Context context) {
            super(jVar);
            k.c(jVar, "fm");
            k.c(context, "context");
            this.f74086a = list;
            this.f74087b = context;
        }

        public final Fragment getItem(int i2) {
            m.a aVar = net.one97.paytm.o2o.movies.fragment.m.f75399a;
            List<CriticRatingReviewItem> list = this.f74086a;
            CriticRatingReviewItem criticRatingReviewItem = list != null ? list.get(i2) : null;
            net.one97.paytm.o2o.movies.fragment.m mVar = new net.one97.paytm.o2o.movies.fragment.m();
            Bundle bundle = new Bundle();
            bundle.putParcelable("reviewItem", criticRatingReviewItem);
            mVar.setArguments(bundle);
            return mVar;
        }

        public final CharSequence getPageTitle(int i2) {
            String str;
            CriticRatingReviewItem criticRatingReviewItem;
            DwhSource dwhSource;
            List<CriticRatingReviewItem> list = this.f74086a;
            if (list == null || (criticRatingReviewItem = list.get(i2)) == null || (dwhSource = criticRatingReviewItem.f74228b) == null) {
                str = null;
            } else {
                str = dwhSource.f74236a;
            }
            return str;
        }

        public final int getCount() {
            List<CriticRatingReviewItem> list = this.f74086a;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
    }

    public final void a(CustomTabLayout.e eVar) {
        View view;
        if (eVar != null && (view = eVar.f75078e) != null) {
            ((TextView) view.findViewById(R.id.textView)).setTextColor(getResources().getColor(net.one97.paytm.common.assets.R.color.color_000000));
        }
    }

    public final void b(CustomTabLayout.e eVar) {
        View view;
        if (eVar != null && (view = eVar.f75078e) != null) {
            ((TextView) view.findViewById(R.id.textView)).setTextColor(getResources().getColor(net.one97.paytm.common.assets.R.color.color_999999));
        }
    }
}
