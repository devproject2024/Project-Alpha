package com.travel.train.activity;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.b;
import androidx.fragment.app.Fragment;
import com.paytm.utility.q;
import com.travel.train.CJRTrainBaseActivity;
import com.travel.train.R;
import com.travel.train.fragment.ak;
import com.travel.train.j.o;
import com.travel.train.model.CJRTrainSearchInput;
import com.travel.train.model.trainticket.CJRPNRStatusDetails;
import com.travel.train.model.trainticket.CJRTrainSearchResultsTrain;

public class AJRTrainViewRoute extends CJRTrainBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private CJRTrainSearchResultsTrain f26131a;

    /* renamed from: b  reason: collision with root package name */
    private CJRTrainSearchInput f26132b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ak f26133c;

    /* renamed from: d  reason: collision with root package name */
    private String f26134d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f26135e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f26136f;

    /* renamed from: g  reason: collision with root package name */
    private String f26137g;

    /* renamed from: h  reason: collision with root package name */
    private CJRPNRStatusDetails f26138h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f26139i;
    /* access modifiers changed from: private */
    public TextView j;
    private ImageView k;
    private String l;
    private String m = "AJRTrainViewRoute";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_t_activity_train_view_route);
        setSupportActionBar((Toolbar) findViewById(R.id.train_view_route_toolbar));
        getSupportActionBar().b(true);
        getSupportActionBar().c(false);
        try {
            Drawable a2 = b.a((Context) this, R.drawable.pr_t_abc_ic_ab_back_material);
            a2.mutate().setColorFilter(b.c(this, R.color.color_000000), PorterDuff.Mode.SRC_ATOP);
            getSupportActionBar().b(a2);
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
        this.f26139i = (TextView) findViewById(R.id.train_view_route_toolbar_title);
        this.j = (TextView) findViewById(R.id.edtSearch);
        this.k = (ImageView) findViewById(R.id.search_icon);
        this.k.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRTrainViewRoute.a(AJRTrainViewRoute.this);
            }
        });
        this.j.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                AJRTrainViewRoute.this.f26133c.a(AJRTrainViewRoute.this.j.getText().toString());
            }
        });
        if (getIntent().hasExtra("flag") && getIntent().getBooleanExtra("flag", true)) {
            this.f26138h = (CJRPNRStatusDetails) getIntent().getSerializableExtra("train_detail");
            this.f26135e = getIntent().getBooleanExtra("flag", true);
            this.f26137g = this.f26138h.getmTrainName();
            this.f26134d = this.f26138h.getmTrainNumber();
        } else if (getIntent().hasExtra("extra_home_data")) {
            this.f26131a = (CJRTrainSearchResultsTrain) getIntent().getSerializableExtra("extra_home_data");
            this.f26134d = this.f26131a.getTrainNumber();
            this.f26137g = this.f26131a.getTrainName();
        } else if (getIntent().hasExtra("order_summary_flag") && getIntent().getBooleanExtra("order_summary_flag", true)) {
            this.f26131a = (CJRTrainSearchResultsTrain) getIntent().getSerializableExtra("train_detail");
            this.f26136f = getIntent().getBooleanExtra("order_summary_flag", true);
            this.f26137g = this.f26131a.getTrainName();
            this.f26134d = this.f26131a.getTrainNumber();
            if (getIntent().hasExtra("order_summary_view_route_url")) {
                this.l = getIntent().getStringExtra("order_summary_view_route_url");
            }
        }
        if (getIntent().hasExtra("extra_selected_train_detail")) {
            if (getIntent().hasExtra("flag")) {
                this.f26137g = this.f26138h.getmTrainName();
            } else {
                this.f26132b = (CJRTrainSearchInput) getIntent().getSerializableExtra("extra_selected_train_detail");
            }
        }
        String str = this.f26137g;
        String a3 = str != null ? o.a(str) : "";
        if (this.f26134d != null) {
            a3 = getResources().getString(R.string.route_txt) + " - " + this.f26134d + " " + a3;
        }
        this.f26139i.setText(a3);
        this.f26133c = new ak();
        Bundle bundle2 = new Bundle();
        if (this.f26135e) {
            bundle2.putSerializable("train_detail", this.f26138h);
            bundle2.putBoolean("flag", this.f26135e);
        } else {
            boolean z = this.f26136f;
            if (z) {
                bundle2.putBoolean("order_summary_flag", z);
                bundle2.putString("order_summary_view_route_url", this.l);
                bundle2.putSerializable("train_detail", this.f26131a);
            } else {
                bundle2.putSerializable("extra_home_data", this.f26131a);
                bundle2.putSerializable("extra_selected_train_detail", this.f26132b);
            }
        }
        this.f26133c.setArguments(bundle2);
        getSupportFragmentManager().a().a(R.id.train_route_fragment_lyt, (Fragment) this.f26133c).b();
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        return true;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        super.onOptionsItemSelected(menuItem);
        if (menuItem.getItemId() != 16908332) {
            return true;
        }
        if (this.j.getVisibility() == 0) {
            this.j.setVisibility(8);
            this.j.clearFocus();
            this.f26139i.setVisibility(0);
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.j.getWindowToken(), 0);
            this.f26133c.a("");
            this.j.setHint(getString(R.string.train_view_route_search));
            return true;
        }
        finish();
        return true;
    }

    static /* synthetic */ void a(AJRTrainViewRoute aJRTrainViewRoute) {
        aJRTrainViewRoute.f26139i.setVisibility(8);
        aJRTrainViewRoute.j.setVisibility(0);
        aJRTrainViewRoute.j.setHint(aJRTrainViewRoute.getString(R.string.train_view_route_search));
        aJRTrainViewRoute.j.requestFocus();
        ((InputMethodManager) aJRTrainViewRoute.getSystemService("input_method")).showSoftInput(aJRTrainViewRoute.j, 1);
    }
}
