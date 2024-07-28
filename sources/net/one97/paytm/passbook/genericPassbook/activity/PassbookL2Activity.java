package net.one97.paytm.passbook.genericPassbook.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.base.BaseActivity;
import net.one97.paytm.passbook.genericPassbook.a;
import net.one97.paytm.passbook.genericPassbook.b.b;
import net.one97.paytm.passbook.genericPassbook.d.a.c;
import net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment;
import net.one97.paytm.passbook.utility.n;

public final class PassbookL2Activity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    public b f57326a;

    /* renamed from: b  reason: collision with root package name */
    private PassbookL2Fragment f57327b;

    /* renamed from: c  reason: collision with root package name */
    private int f57328c = Integer.MIN_VALUE;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f57329d;

    public final View a(int i2) {
        if (this.f57329d == null) {
            this.f57329d = new HashMap();
        }
        View view = (View) this.f57329d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f57329d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final b a() {
        b bVar = this.f57326a;
        if (bVar == null) {
            k.a("mDataModel");
        }
        return bVar;
    }

    public final void onCreate(Bundle bundle) {
        b bVar;
        a aVar;
        super.onCreate(bundle);
        setContentView(R.layout.pass_activity_l2);
        this.f57328c = getIntent().getIntExtra("passbook_type", Integer.MIN_VALUE);
        int i2 = this.f57328c;
        if (i2 == Integer.MIN_VALUE) {
            finish();
            return;
        }
        Context context = this;
        AppCompatActivity appCompatActivity = this;
        k.c(context, "context");
        k.c(appCompatActivity, "activity");
        if (i2 == n.ICA_CURRENT_ACCOUNT.getValue()) {
            bVar = new net.one97.paytm.passbook.genericPassbook.a.a(context);
        } else if (i2 == n.SAVINGS_ACCOUNT.getValue()) {
            bVar = new net.one97.paytm.passbook.genericPassbook.c.a(context, appCompatActivity);
        } else if (i2 == n.PAYTM_WALLET.getValue()) {
            bVar = new c(context, appCompatActivity);
        } else if (i2 == n.LOYALTY_WALLET_TYPE_7.getValue() || i2 == n.LOYALTY_WALLET.getValue() || i2 == n.ALLOWALANCE_WALLET.getValue() || i2 == n.FOOD_WALLET.getValue() || i2 == n.GIFT_VOUCHER.getValue() || i2 == n.TOLL.getValue()) {
            bVar = new net.one97.paytm.passbook.genericPassbook.d.b.c(context, appCompatActivity, i2);
        } else {
            bVar = new net.one97.paytm.passbook.genericPassbook.d.b.c(context, appCompatActivity, i2);
        }
        this.f57326a = bVar;
        Fragment c2 = getSupportFragmentManager().c(R.id.l2Fragment);
        if (c2 != null) {
            this.f57327b = (PassbookL2Fragment) c2;
            PassbookL2Fragment passbookL2Fragment = this.f57327b;
            if (passbookL2Fragment == null) {
                k.a("mL2Fragment");
            }
            b bVar2 = this.f57326a;
            if (bVar2 == null) {
                k.a("mDataModel");
            }
            k.c(bVar2, "dataModel");
            passbookL2Fragment.f57494a = bVar2;
            Context context2 = passbookL2Fragment.getContext();
            if (context2 != null) {
                k.a((Object) context2, "it");
                aVar = new a(context2);
            } else {
                aVar = null;
            }
            if (aVar == null) {
                k.a();
            }
            passbookL2Fragment.f57495b = aVar;
            b bVar3 = passbookL2Fragment.f57494a;
            if (bVar3 == null) {
                k.a("mDataModel");
            }
            Fragment c3 = bVar3.c();
            if (!(c3 == null || c3 == null)) {
                passbookL2Fragment.getChildFragmentManager().a().b(R.id.ctaContainerLayout, c3).c();
            }
            RecyclerView recyclerView = (RecyclerView) passbookL2Fragment.a(R.id.rvPassbookEntries);
            k.a((Object) recyclerView, "rvPassbookEntries");
            recyclerView.setLayoutManager(new LinearLayoutManager(passbookL2Fragment.getContext()));
            b bVar4 = passbookL2Fragment.f57494a;
            if (bVar4 == null) {
                k.a("mDataModel");
            }
            RecyclerView recyclerView2 = (RecyclerView) passbookL2Fragment.a(R.id.rvPassbookEntries);
            k.a((Object) recyclerView2, "rvPassbookEntries");
            RecyclerView.a<RecyclerView.v> a2 = bVar4.a((net.one97.paytm.passbook.genericPassbook.b.c) passbookL2Fragment, recyclerView2);
            RecyclerView recyclerView3 = (RecyclerView) passbookL2Fragment.a(R.id.rvPassbookEntries);
            k.a((Object) recyclerView3, "rvPassbookEntries");
            recyclerView3.setAdapter(a2);
            b bVar5 = passbookL2Fragment.f57494a;
            if (bVar5 == null) {
                k.a("mDataModel");
            }
            if (bVar5.b() != null) {
                LinearLayout linearLayout = (LinearLayout) passbookL2Fragment.a(R.id.filterLayout);
                k.a((Object) linearLayout, "filterLayout");
                linearLayout.setVisibility(0);
            }
            RoboTextView roboTextView = passbookL2Fragment.f57498e;
            if (roboTextView == null) {
                k.a("mFilterView");
            }
            roboTextView.setOnClickListener(new PassbookL2Fragment.c(passbookL2Fragment));
            passbookL2Fragment.b();
            passbookL2Fragment.a();
            TextView textView = passbookL2Fragment.f57496c;
            if (textView == null) {
                k.a("toolbarTitle");
            }
            b bVar6 = passbookL2Fragment.f57494a;
            if (bVar6 == null) {
                k.a("mDataModel");
            }
            textView.setText(bVar6.h());
            ImageView imageView = passbookL2Fragment.f57497d;
            if (imageView == null) {
                k.a("toolbarIcon");
            }
            b bVar7 = passbookL2Fragment.f57494a;
            if (bVar7 == null) {
                k.a("mDataModel");
            }
            imageView.setImageDrawable(bVar7.i());
            b bVar8 = passbookL2Fragment.f57494a;
            if (bVar8 == null) {
                k.a("mDataModel");
            }
            TextView textView2 = passbookL2Fragment.f57499f;
            if (textView2 == null) {
                k.a("mBalanceTitleText");
            }
            bVar8.a(textView2);
            b bVar9 = passbookL2Fragment.f57494a;
            if (bVar9 == null) {
                k.a("mDataModel");
            }
            bVar9.k();
            b bVar10 = passbookL2Fragment.f57494a;
            if (bVar10 == null) {
                k.a("mDataModel");
            }
            bVar10.l();
            b bVar11 = passbookL2Fragment.f57494a;
            if (bVar11 == null) {
                k.a("mDataModel");
            }
            bVar11.m();
            b bVar12 = passbookL2Fragment.f57494a;
            if (bVar12 == null) {
                k.a("mDataModel");
            }
            FrameLayout frameLayout = (FrameLayout) passbookL2Fragment.a(R.id.pbBannerContainer);
            k.a((Object) frameLayout, "pbBannerContainer");
            bVar12.a(frameLayout);
            PassbookL2Fragment passbookL2Fragment2 = this.f57327b;
            if (passbookL2Fragment2 == null) {
                k.a("mL2Fragment");
            }
            View view = passbookL2Fragment2.getView();
            if (view != null) {
                b bVar13 = this.f57326a;
                if (bVar13 == null) {
                    k.a("mDataModel");
                }
                k.a((Object) view, "it");
                bVar13.a(view);
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment");
    }

    public final boolean onCreateOptionsMenu(Menu menu) {
        if (this.f57326a != null) {
            b bVar = this.f57326a;
            if (bVar == null) {
                k.a("mDataModel");
            }
            bVar.a(menu, getMenuInflater());
        }
        return super.onCreateOptionsMenu(menu);
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (this.f57326a != null) {
            b bVar = this.f57326a;
            if (bVar == null) {
                k.a("mDataModel");
            }
            bVar.a(menuItem);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        b bVar = this.f57326a;
        if (bVar == null) {
            k.a("mDataModel");
        }
        bVar.a(i2, i3, intent);
    }
}
