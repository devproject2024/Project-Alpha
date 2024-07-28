package net.one97.paytm.paymentsBank.slfd.passbook.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.j;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.sendbird.android.constant.StringSet;
import java.util.HashMap;
import kotlin.g;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.g.b.v;
import kotlin.g.b.w;
import kotlin.g.b.y;
import kotlin.h;
import kotlin.k.i;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.slfd.SlfdBaseActivity;
import net.one97.paytm.paymentsBank.utils.o;

public final class SlfdPassbookActivity extends SlfdBaseActivity {

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ i[] f19258b;

    /* renamed from: c  reason: collision with root package name */
    private final g f19259c = h.a(new a(this));

    /* renamed from: d  reason: collision with root package name */
    private final g f19260d = h.a(new d(this));

    /* renamed from: e  reason: collision with root package name */
    private final g f19261e = h.a(new e(this));

    /* renamed from: f  reason: collision with root package name */
    private HashMap f19262f;

    static {
        Class<SlfdPassbookActivity> cls = SlfdPassbookActivity.class;
        f19258b = new i[]{y.a((v) new w(y.b(cls), "ivBackBtn", "getIvBackBtn()Landroid/widget/ImageView;")), y.a((v) new w(y.b(cls), "tlSlfdTabs", "getTlSlfdTabs()Lcom/google/android/material/tabs/TabLayout;")), y.a((v) new w(y.b(cls), "vpSlfd", "getVpSlfd()Landroidx/viewpager/widget/ViewPager;"))};
    }

    private final ViewPager f() {
        return (ViewPager) this.f19261e.getValue();
    }

    public final View a(int i2) {
        if (this.f19262f == null) {
            this.f19262f = new HashMap();
        }
        View view = (View) this.f19262f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f19262f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class a extends l implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ SlfdPassbookActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(SlfdPassbookActivity slfdPassbookActivity) {
            super(0);
            this.this$0 = slfdPassbookActivity;
        }

        public final ImageView invoke() {
            return (ImageView) this.this$0.findViewById(R.id.iv_back);
        }
    }

    static final class d extends l implements kotlin.g.a.a<TabLayout> {
        final /* synthetic */ SlfdPassbookActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(SlfdPassbookActivity slfdPassbookActivity) {
            super(0);
            this.this$0 = slfdPassbookActivity;
        }

        public final TabLayout invoke() {
            return (TabLayout) this.this$0.findViewById(R.id.tl_slfd_tabs);
        }
    }

    static final class e extends l implements kotlin.g.a.a<ViewPager> {
        final /* synthetic */ SlfdPassbookActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(SlfdPassbookActivity slfdPassbookActivity) {
            super(0);
            this.this$0 = slfdPassbookActivity;
        }

        public final ViewPager invoke() {
            return (ViewPager) this.this$0.findViewById(R.id.vp_slfd);
        }
    }

    public final int e() {
        return R.layout.activity_fd_passbook;
    }

    public final void attachBaseContext(Context context) {
        k.c(context, "newBase");
        com.paytm.utility.b.e((Activity) this);
        super.attachBaseContext(o.a().getBaseContext(context));
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra("slfd_status", 0);
        ((ImageView) this.f19259c.getValue()).setOnClickListener(new b(this));
        j supportFragmentManager = getSupportFragmentManager();
        k.a((Object) supportFragmentManager, "supportFragmentManager");
        a aVar = new a(this, supportFragmentManager, intExtra);
        f().setAdapter(aVar);
        ((TabLayout) this.f19260d.getValue()).setupWithViewPager(f());
        aVar.notifyDataSetChanged();
        Context context = this;
        androidx.localbroadcastmanager.a.a.a(context).a(new Intent("intent.action.updateSlfdLanding"));
        f().addOnPageChangeListener(new c(this));
        net.one97.paytm.bankCommon.mapping.c.a("/fixed-deposit/your-investment", "fixed-deposit", context);
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SlfdPassbookActivity f19263a;

        b(SlfdPassbookActivity slfdPassbookActivity) {
            this.f19263a = slfdPassbookActivity;
        }

        public final void onClick(View view) {
            this.f19263a.finish();
        }
    }

    public static final class c implements ViewPager.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SlfdPassbookActivity f19264a;

        public final void onPageScrollStateChanged(int i2) {
        }

        public final void onPageScrolled(int i2, float f2, int i3) {
        }

        c(SlfdPassbookActivity slfdPassbookActivity) {
            this.f19264a = slfdPassbookActivity;
        }

        public final void onPageSelected(int i2) {
            net.one97.paytm.bankCommon.mapping.c.a(this.f19264a.getApplicationContext(), "fixed_deposit", "filter_transaction_radio_button_selected", i2 == 1 ? "invested" : i2 == 2 ? "redeemed" : StringSet.all, (String) null, (String) null, "/fixed-deposit/order-status-redeem", "fixed_deposit");
        }
    }
}
