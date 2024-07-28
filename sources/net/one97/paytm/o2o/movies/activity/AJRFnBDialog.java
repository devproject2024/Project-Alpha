package net.one97.paytm.o2o.movies.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.content.b;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.m;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.movies.foodbeverage.CJRFoodBeverageItemV2;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovies;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession;
import net.one97.paytm.o2o.movies.fragment.n;
import net.one97.paytm.o2o.movies.fragment.o;
import net.one97.paytm.o2o.movies.utils.g;

public class AJRFnBDialog extends AppBaseActivity implements View.OnClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public n f73978a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public n f73979b;

    /* renamed from: c  reason: collision with root package name */
    private TabLayout f73980c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f73981d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f73982e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f73983f = false;

    /* renamed from: g  reason: collision with root package name */
    private Context f73984g;

    /* renamed from: h  reason: collision with root package name */
    private RoboTextView f73985h;

    /* renamed from: i  reason: collision with root package name */
    private CJRMoviesSession f73986i;
    private CJRMovies j;
    private View k;
    private RoboTextView l;
    private RoboTextView m;
    private ViewPager n;
    private Boolean o = Boolean.FALSE;
    private String p;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f73982e = bundle.getBoolean("showSelected", false);
            this.f73981d = bundle.getBoolean("promoApplied", false);
            this.f73983f = bundle.getBoolean("showSkip", false);
        } else if (getIntent() != null) {
            this.f73982e = getIntent().getBooleanExtra("showSelected", false);
            this.f73981d = getIntent().getBooleanExtra("promoApplied", false);
            this.f73983f = getIntent().getBooleanExtra("showSkip", false);
        }
        this.f73986i = (CJRMoviesSession) getIntent().getParcelableExtra("moviesession");
        this.j = (CJRMovies) getIntent().getParcelableExtra("selectedmovie");
        this.p = getIntent().getStringExtra("from");
        setContentView(R.layout.fnb_list_activity);
        this.f73984g = this;
        this.n = (ViewPager) findViewById(R.id.id_view_pager);
        this.f73980c = (TabLayout) findViewById(R.id.id_tab_layout);
        this.f73980c.setSelectedTabIndicatorColor(b.c(this, R.color.color_00b9f5));
        this.f73980c.setSelectedTabIndicatorHeight((int) (getResources().getDisplayMetrics().density * 2.0f));
        this.k = findViewById(R.id.id_bottom_button);
        this.f73985h = (RoboTextView) findViewById(R.id.id_fnb_dialog_done);
        this.l = (RoboTextView) findViewById(R.id.id_price);
        this.m = (RoboTextView) findViewById(R.id.id_item_count);
        this.f73985h.setOnClickListener(this);
        findViewById(R.id.fnb_parent_container).setOnClickListener(this);
        findViewById(R.id.id_fnb_container).setOnClickListener(this);
        this.f73980c.setupWithViewPager(this.n);
        this.f73978a = n.a();
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("moviesession", this.f73986i);
        bundle2.putParcelable("selectedmovie", this.j);
        this.f73978a.setArguments(bundle2);
        this.f73979b = o.d();
        a aVar = new a(getSupportFragmentManager());
        this.n.setAdapter(aVar);
        this.n.addOnPageChangeListener(new ViewPager.e() {
            public final void onPageScrollStateChanged(int i2) {
            }

            public final void onPageScrolled(int i2, float f2, int i3) {
            }

            public final void onPageSelected(int i2) {
                AJRFnBDialog.a(AJRFnBDialog.this, i2);
            }
        });
        for (int i2 = 0; i2 < this.f73980c.getTabCount(); i2++) {
            TabLayout.f a2 = this.f73980c.a(i2);
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.fnb_tab_item, (ViewGroup) null, false);
            RoboTextView roboTextView = (RoboTextView) relativeLayout.findViewById(R.id.id_tab_item_title);
            roboTextView.setText(aVar.getPageTitle(i2));
            if (i2 == 0) {
                roboTextView.setTextColor(b.c(this, R.color.color_222222));
            }
            a2.a((View) relativeLayout);
        }
        b(false);
        if (this.f73982e) {
            this.f73980c.setScrollPosition(1, 0.0f, true);
            this.n.setCurrentItem(1);
        }
        a(-1);
    }

    private void a(int i2) {
        if (i2 == -1) {
            if ("order_summary".equals(this.p)) {
                if (g.a().f75925b.size() > 0) {
                    this.f73985h.setVisibility(0);
                } else {
                    this.f73985h.setVisibility(8);
                }
                this.f73985h.setText(getString(R.string.continue_label));
                return;
            } else if (!this.f73983f) {
                this.f73985h.setText(getString(R.string.continue_label));
                return;
            }
        } else if ("order_summary".equals(this.p)) {
            if (i2 > 0) {
                this.f73985h.setVisibility(0);
                return;
            } else {
                this.f73985h.setVisibility(8);
                return;
            }
        } else if (i2 > 0) {
            this.f73985h.setText(getString(R.string.continue_label));
            return;
        }
        this.f73985h.setText(getString(R.string.fnb_dialog_skip));
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.id_fnb_dialog_done) {
            if (this.o.booleanValue()) {
                a(false);
            } else if (!"order_summary".equals(this.p) || findViewById(R.id.id_tab_item_qty).getVisibility() == 8) {
                a(true);
            } else {
                a(false);
            }
        } else if (id == R.id.fnb_parent_container) {
            a(true);
        } else {
            int i2 = R.id.id_fnb_container;
        }
    }

    private void a(boolean z) {
        setResult(z ? 0 : -1, new Intent());
        finish();
    }

    public void onBackPressed() {
        a(true);
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("promoApplied", this.f73981d);
        bundle.putBoolean("showSelected", this.f73982e);
        bundle.putBoolean("showSkip", this.f73983f);
    }

    public final void a() {
        b(true);
        this.o = Boolean.TRUE;
        this.f73978a.c();
        this.f73979b.c();
        if (this.f73981d) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f73984g);
            builder.setTitle(getString(R.string.promo_code_alert));
            builder.setMessage(getString(R.string.promo_code_will_be_removed));
            builder.setCancelable(false);
            builder.setPositiveButton(getResources().getString(R.string.ok), $$Lambda$AJRFnBDialog$tWxSyVeN5W_GeUeQQcHxkmucs.INSTANCE);
            builder.show();
            this.f73981d = false;
        }
    }

    private void b(boolean z) {
        int i2;
        ArrayList<CJRFoodBeverageItemV2> arrayList = g.a().f75925b;
        double d2 = 0.0d;
        if (arrayList != null) {
            i2 = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                CJRFoodBeverageItemV2 cJRFoodBeverageItemV2 = arrayList.get(i3);
                int i4 = cJRFoodBeverageItemV2.getmFoodQauntitySelected();
                d2 += ((double) i4) * Double.parseDouble(cJRFoodBeverageItemV2.getmPrice());
                i2 += i4;
            }
        } else {
            i2 = 0;
        }
        if (this.k.getVisibility() == 0 || z) {
            this.k.setVisibility(0);
            if (i2 > 0) {
                this.l.setText(getString(R.string.rupee_symbol) + net.one97.paytm.o2o.movies.utils.n.a(d2));
                this.m.setText(String.valueOf(i2) + " " + getString(R.string.fnb_item_added));
                this.m.setVisibility(0);
            } else {
                this.l.setText(getString(R.string.rupee_symbol) + "0");
                this.m.setText(getString(R.string.fnb_dialog_no_items));
            }
            a(i2);
        } else {
            this.k.setVisibility(8);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.added_items_title));
        sb.append(i2 > 0 ? " ".concat(String.valueOf(i2)) : "");
        this.f73980c.a(1).a((CharSequence) sb.toString());
        b(i2);
    }

    private void b(int i2) {
        RoboTextView roboTextView = (RoboTextView) ((RelativeLayout) this.f73980c.a(1).f36766f).findViewById(R.id.id_tab_item_qty);
        if (i2 > 0) {
            roboTextView.setVisibility(0);
            roboTextView.setText(String.valueOf(i2));
            return;
        }
        roboTextView.setVisibility(8);
    }

    class a extends m {
        public final int getCount() {
            return 2;
        }

        public a(j jVar) {
            super(jVar);
        }

        public final Fragment getItem(int i2) {
            if (i2 == 0) {
                return AJRFnBDialog.this.f73978a;
            }
            return AJRFnBDialog.this.f73979b;
        }

        public final CharSequence getPageTitle(int i2) {
            if (i2 == 0) {
                return AJRFnBDialog.this.getString(R.string.item_list);
            }
            return AJRFnBDialog.this.getString(R.string.added_items_title);
        }
    }

    public void onStart() {
        super.onStart();
        try {
            getWindow().setLayout(-1, -2);
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void a(AJRFnBDialog aJRFnBDialog, int i2) {
        RoboTextView roboTextView = (RoboTextView) aJRFnBDialog.f73980c.a(0).f36766f.findViewById(R.id.id_tab_item_title);
        RoboTextView roboTextView2 = (RoboTextView) aJRFnBDialog.f73980c.a(1).f36766f.findViewById(R.id.id_tab_item_title);
        roboTextView.setTextColor(b.c(aJRFnBDialog, i2 == 0 ? R.color.color_222222 : net.one97.paytm.common.assets.R.color.color_999999));
        roboTextView2.setTextColor(b.c(aJRFnBDialog, i2 == 1 ? R.color.color_222222 : net.one97.paytm.common.assets.R.color.color_999999));
    }
}
