package net.one97.paytm.wallet.splitbill.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.paytm.b.a.a;
import com.paytm.utility.b;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import java.util.ArrayList;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.utils.ShimmerFrameLayout;
import net.one97.paytm.utils.be;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.b.c;
import net.one97.paytm.wallet.splitbill.c.e;
import net.one97.paytm.wallet.splitbill.c.k;
import net.one97.paytm.wallet.splitbill.d.a;

public class SBLandingPageActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private ShimmerFrameLayout f71997a;

    /* renamed from: b  reason: collision with root package name */
    private ShimmerFrameLayout f71998b;

    /* renamed from: c  reason: collision with root package name */
    private String f71999c;

    /* renamed from: d  reason: collision with root package name */
    private String f72000d;

    /* renamed from: e  reason: collision with root package name */
    private String f72001e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f72002f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f72003g = false;

    /* renamed from: h  reason: collision with root package name */
    private a f72004h;

    /* renamed from: i  reason: collision with root package name */
    private String f72005i = null;
    private String j = null;
    private String k = null;
    private boolean l = false;
    private boolean m = true;
    /* access modifiers changed from: private */
    public RelativeLayout n;
    private Button o;
    private net.one97.paytm.wallet.splitbill.d.a p;

    public void onCreate(Bundle bundle) {
        Bundle extras;
        String string;
        super.onCreate(bundle);
        setTitle("SplitBill");
        setContentView(R.layout.sb_landing_page_activity);
        this.p = net.one97.paytm.wallet.splitbill.d.a.a((Context) this);
        this.f71997a = (ShimmerFrameLayout) findViewById(R.id.home_page_shimmer);
        this.n = (RelativeLayout) findViewById(R.id.sb_no_internet_layout);
        this.o = (Button) findViewById(R.id.no_internet_try_again);
        this.f71998b = (ShimmerFrameLayout) findViewById(R.id.first_time_shimmer);
        this.o.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SBLandingPageActivity.this.n.setVisibility(8);
                if (b.c((Context) SBLandingPageActivity.this)) {
                    SBLandingPageActivity.this.a();
                } else {
                    SBLandingPageActivity.this.n.setVisibility(0);
                }
            }
        });
        if (!(getIntent() == null || (extras = getIntent().getExtras()) == null || (string = extras.getString("feature_type")) == null)) {
            this.j = string;
            if (!this.j.equalsIgnoreCase(ViewHolderFactory.CLASS_HOME)) {
                if (this.j.equalsIgnoreCase("bill_detail")) {
                    this.f72003g = true;
                    this.f72005i = extras.getString("bill_id");
                } else if (this.j.equalsIgnoreCase("add_bill")) {
                    this.f72003g = true;
                    this.k = extras.getString("amount");
                }
            }
        }
        if (getIntent() != null && getIntent().hasExtra("from")) {
            this.f71999c = getIntent().getStringExtra("from");
            if ("mark_as_paid".equalsIgnoreCase(this.f71999c)) {
                this.f72002f = getIntent().getBooleanExtra("mark_as_paid_status", false);
                this.f72000d = getIntent().getStringExtra("mark_as_paid_message");
                this.f72001e = getIntent().getStringExtra("mark_as_paid_sub_message");
            }
        }
    }

    private void a(boolean z, boolean z2) {
        if (z && z2) {
            this.f71997a.setVisibility(0);
            this.f71998b.setVisibility(8);
            this.f71997a.a();
            findViewById(R.id.activity_sb_landing_frame).setVisibility(8);
        } else if (!z && z2) {
            this.f71998b.setVisibility(0);
            this.f71997a.setVisibility(8);
            this.f71998b.a();
            findViewById(R.id.activity_sb_landing_frame).setVisibility(8);
        } else if (!z || z2) {
            this.f71997a.setVisibility(8);
            this.f71998b.setVisibility(8);
            this.f71998b.b();
            findViewById(R.id.activity_sb_landing_frame).setVisibility(0);
        } else {
            this.f71997a.setVisibility(8);
            this.f71998b.setVisibility(8);
            this.f71997a.b();
            findViewById(R.id.activity_sb_landing_frame).setVisibility(0);
        }
    }

    public void onResume() {
        super.onResume();
        a();
    }

    /* access modifiers changed from: private */
    public void a() {
        if (!this.f72003g) {
            if (b.c((Context) this)) {
                b();
                this.f72004h = be.a(getApplicationContext());
                this.l = this.f72004h.b("needToShowFirstTimeShimmer", true, false);
                if (this.l) {
                    this.m = false;
                    this.f72004h = be.a(getApplicationContext());
                    this.f72004h.a("needToShowFirstTimeShimmer", false, false);
                } else {
                    this.m = true;
                }
                if (this.m) {
                    a(true, true);
                } else {
                    a(false, true);
                }
            } else {
                this.n.setVisibility(0);
            }
        } else if (b.c((Context) this)) {
            if (this.j.equalsIgnoreCase("bill_detail")) {
                Intent intent = new Intent(this, SBBillDetailActivity.class);
                intent.putExtra("bill_id", this.f72005i);
                startActivity(intent);
                ArrayList arrayList = new ArrayList();
                arrayList.add("viewBills");
                net.one97.paytm.wallet.splitbill.e.b.a(this, "split_bill", "splitbill_detail", arrayList, "", "/splitbill/selectbill", "split_bill");
            } else if (this.j.equalsIgnoreCase("add_bill")) {
                Intent intent2 = new Intent(this, SBSearchContactListActivity.class);
                intent2.putExtra("show_group_widget", false);
                intent2.putExtra("non_group_bill", true);
                intent2.putExtra("amount", this.k);
                startActivity(intent2);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add("P2M_post_payment");
                net.one97.paytm.wallet.splitbill.e.b.a(this, "split_bill", "new_splitbill", arrayList2, "", "/splitbill/new", "split_bill");
            }
            this.f72003g = false;
        } else {
            this.n.setVisibility(0);
        }
    }

    private void b() {
        this.n.setVisibility(8);
        this.p.a((c) new c() {
            public final void onInitSuccessful() {
                SBLandingPageActivity.this.c();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c() {
        boolean z = true;
        if (this.m) {
            a(true, false);
        } else {
            a(false, false);
        }
        if (this.p.f72230b == a.C1463a.FIRST_TIME) {
            z = false;
        }
        if (z) {
            getSupportFragmentManager().c(e.class.getSimpleName());
            e eVar = new e();
            Bundle bundle = new Bundle();
            bundle.putString("from", this.f71999c);
            bundle.putBoolean("mark_as_paid_status", this.f72002f);
            bundle.putString("mark_as_paid_message", this.f72000d);
            bundle.putString("mark_as_paid_sub_message", this.f72001e);
            eVar.setArguments(bundle);
            if (getSupportFragmentManager() != null) {
                getSupportFragmentManager().a().b(R.id.activity_sb_landing_frame, eVar, e.class.getSimpleName()).c();
            }
            this.f71999c = "";
            return;
        }
        getSupportFragmentManager().c(k.class.getSimpleName());
        k kVar = new k();
        if (getSupportFragmentManager() != null) {
            getSupportFragmentManager().a().b(R.id.activity_sb_landing_frame, kVar, k.class.getSimpleName()).c();
        }
    }
}
