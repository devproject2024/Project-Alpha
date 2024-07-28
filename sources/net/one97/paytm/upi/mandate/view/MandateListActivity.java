package net.one97.paytm.upi.mandate.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.f;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.mandate.utils.h;
import net.one97.paytm.upi.mandate.view.PendingMandateFragment;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public final class MandateListActivity extends PaytmActivity implements h {

    /* renamed from: a  reason: collision with root package name */
    public static final a f67433a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private ViewPager f67434b;

    /* renamed from: c  reason: collision with root package name */
    private TabLayout f67435c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f67436d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f67437e;

    /* renamed from: f  reason: collision with root package name */
    private View f67438f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f67439g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f67440h;

    public final void attachBaseContext(Context context) {
        i a2 = i.a();
        k.a((Object) a2, "PaytmUpiSdk.getInstance()");
        if (a2.c() == null) {
            super.attachBaseContext(context);
            return;
        }
        i a3 = i.a();
        k.a((Object) a3, "PaytmUpiSdk.getInstance()");
        ContextWrapper d2 = a3.c().d(context);
        if (d2 != null) {
            super.attachBaseContext(d2);
        } else {
            super.attachBaseContext(context);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_mandate_list);
        UpiUtils.setStatusBarColor(androidx.core.content.b.c(this, R.color.color_f3f7f8), this);
        View findViewById = findViewById(R.id.vpMandateList);
        k.a((Object) findViewById, "findViewById(R.id.vpMandateList)");
        this.f67434b = (ViewPager) findViewById;
        View findViewById2 = findViewById(R.id.mandate_type_tabs);
        k.a((Object) findViewById2, "findViewById(R.id.mandate_type_tabs)");
        this.f67435c = (TabLayout) findViewById2;
        View findViewById3 = findViewById(R.id.iv_back);
        k.a((Object) findViewById3, "findViewById(R.id.iv_back)");
        this.f67436d = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.tvCreateMandate);
        k.a((Object) findViewById4, "findViewById(R.id.tvCreateMandate)");
        this.f67437e = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.parent_container);
        k.a((Object) findViewById5, "findViewById(R.id.parent_container)");
        this.f67438f = findViewById5;
        View findViewById6 = findViewById(R.id.ivRefresh);
        k.a((Object) findViewById6, "findViewById(R.id.ivRefresh)");
        this.f67439g = (ImageView) findViewById6;
        View findViewById7 = findViewById(R.id.tvScheduleMandate);
        k.a((Object) findViewById7, "findViewById(R.id.tvScheduleMandate)");
        this.f67440h = (TextView) findViewById7;
        ViewPager viewPager = this.f67434b;
        if (viewPager == null) {
            k.a("vpMandatePager");
        }
        j supportFragmentManager = getSupportFragmentManager();
        k.a((Object) supportFragmentManager, "supportFragmentManager");
        viewPager.setAdapter(new f(supportFragmentManager));
        TabLayout tabLayout = this.f67435c;
        if (tabLayout == null) {
            k.a("vpMandateTabs");
        }
        ViewPager viewPager2 = this.f67434b;
        if (viewPager2 == null) {
            k.a("vpMandatePager");
        }
        tabLayout.setupWithViewPager(viewPager2);
        int intExtra = getIntent().getIntExtra("move_to_position", 0);
        ViewPager viewPager3 = this.f67434b;
        if (viewPager3 == null) {
            k.a("vpMandatePager");
        }
        viewPager3.setCurrentItem(intExtra);
        ImageView imageView = this.f67436d;
        if (imageView == null) {
            k.a("ivBack");
        }
        imageView.setOnClickListener(new b(this));
        ((TextView) findViewById(R.id.tv_know_more)).setOnClickListener(new c(this));
        TextView textView = this.f67437e;
        if (textView == null) {
            k.a("tvCreateMandate");
        }
        textView.setOnClickListener(new d(this));
        ImageView imageView2 = this.f67439g;
        if (imageView2 == null) {
            k.a("ivRefresh");
        }
        imageView2.setOnClickListener(new e(this));
        if (getSupportFragmentManager().c("PendingMandateFragment") == null) {
            q a2 = getSupportFragmentManager().a();
            int i2 = R.id.fl_pending_container;
            PendingMandateFragment.a aVar = PendingMandateFragment.f67465a;
            a2.a(i2, new PendingMandateFragment(), "PendingMandateFragment").c();
        }
        if (getIntent().getBooleanExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, false)) {
            Uri parse = Uri.parse(getIntent().getStringExtra("EXTRA_DEEP_LINK_DATA"));
            if (TextUtils.isEmpty(parse.getQueryParameter("featuretype"))) {
                return;
            }
            if (p.a(parse.getQueryParameter("featuretype"), "scheduledmandates", true)) {
                ViewPager viewPager4 = this.f67434b;
                if (viewPager4 == null) {
                    k.a("vpMandatePager");
                }
                viewPager4.setCurrentItem(0);
                return;
            }
            ViewPager viewPager5 = this.f67434b;
            if (viewPager5 == null) {
                k.a("vpMandatePager");
            }
            viewPager5.setCurrentItem(1);
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MandateListActivity f67441a;

        b(MandateListActivity mandateListActivity) {
            this.f67441a = mandateListActivity;
        }

        public final void onClick(View view) {
            this.f67441a.finish();
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MandateListActivity f67442a;

        c(MandateListActivity mandateListActivity) {
            this.f67442a = mandateListActivity;
        }

        public final void onClick(View view) {
            new c().show(this.f67442a.getSupportFragmentManager(), "KnowMoreBS");
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MandateListActivity f67443a;

        d(MandateListActivity mandateListActivity) {
            this.f67443a = mandateListActivity;
        }

        public final void onClick(View view) {
            this.f67443a.startActivity(new Intent(this.f67443a, MandateSelectVpaActivity.class));
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MandateListActivity f67444a;

        e(MandateListActivity mandateListActivity) {
            this.f67444a = mandateListActivity;
        }

        public final void onClick(View view) {
            MandateListActivity.b(this.f67444a);
        }
    }

    public final void a(boolean z) {
        TextView textView = this.f67440h;
        if (textView == null) {
            k.a("scheduledTextView");
        }
        f.a((View) textView, z);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void b(MandateListActivity mandateListActivity) {
        androidx.localbroadcastmanager.a.a a2 = androidx.localbroadcastmanager.a.a.a((Context) mandateListActivity);
        k.a((Object) a2, "LocalBroadcastManager.getInstance(this)");
        a2.a(new Intent("action_refresh_received_mandates"));
        a2.a(new Intent("action_refresh_pending_mandates"));
        a2.a(new Intent("action_refresh_scheduled_mandates"));
    }
}
