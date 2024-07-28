package net.one97.paytm.landingpage.activity;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.SearchView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.q;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.home.LeftNavigationModel;
import net.one97.paytm.common.entity.shopping.CJRCatalog;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.landingpage.R;
import net.one97.paytm.landingpage.e.a;
import net.one97.paytm.landingpage.leftNavigation.h;
import net.one97.paytm.landingpage.utils.b;
import net.one97.paytm.landingpage.utils.g;
import net.one97.paytm.landingpage.widgets.CartMenuView;
import net.one97.paytm.locale.b.e;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.t;
import net.one97.paytm.utils.ag;
import net.one97.paytm.utils.r;

public class HomeBaseActivity extends PaytmActivity implements DialogInterface.OnCancelListener, DrawerLayout.c, CartMenuView.a, t {
    public static HashMap<String, String> q = new HashMap<>();
    public static HashMap<String, String> r = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    private boolean f52705a = false;

    /* renamed from: b  reason: collision with root package name */
    private boolean f52706b = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f52707c = false;

    /* renamed from: d  reason: collision with root package name */
    public DrawerLayout f52708d;

    /* renamed from: e  reason: collision with root package name */
    ProgressBar f52709e;

    /* renamed from: f  reason: collision with root package name */
    SearchView f52710f;

    /* renamed from: g  reason: collision with root package name */
    protected CJRCatalog f52711g;

    /* renamed from: h  reason: collision with root package name */
    MenuItem f52712h;

    /* renamed from: i  reason: collision with root package name */
    CharSequence f52713i;
    boolean j = false;
    boolean k = false;
    b l;
    final a m = new a();
    protected FrameLayout n;
    protected ActionBar o;
    protected ProgressDialog p;
    private MenuItem s;
    private MenuItem t;
    private View u;

    public final void a(float f2) {
    }

    public void onFileWriteComplete(String str) {
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(e.a(context));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.u = d.b().n();
        setContentView(this.u);
        d.b().o();
        this.f52708d = (DrawerLayout) findViewById(R.id.drawer_layout);
        this.n = (FrameLayout) findViewById(R.id.content_frame);
        DrawerLayout drawerLayout = this.f52708d;
        if (drawerLayout != null) {
            drawerLayout.a((DrawerLayout.c) this);
        }
    }

    public void onResume() {
        b bVar = this.l;
        if (bVar != null) {
            b.f52896e = 500;
            if (bVar.d() == null) {
                bVar.b();
            } else if (net.one97.paytm.common.utility.b.br || bVar.f52898a.f52836c != com.paytm.utility.a.p(bVar.f52899b.getApplicationContext())) {
                net.one97.paytm.common.utility.b.br = false;
                bVar.f52898a = new net.one97.paytm.landingpage.leftNavigation.d();
                q a2 = bVar.f52899b.getSupportFragmentManager().a();
                a2.b(R.id.flyout_frame, bVar.f52898a, "fragment_flyout");
                a2.c();
                bVar.f52899b.getSupportFragmentManager().b();
            }
        }
        a();
        d.b().a((Context) this);
        super.onResume();
        com.google.android.play.core.splitcompat.a.a((Context) this);
        com.google.android.play.core.splitcompat.a.b((Context) this);
    }

    public void onPause() {
        com.paytm.utility.a.k();
        super.onPause();
        h();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_action_bar_menu, menu);
        setTitle(this.f52713i);
        this.f52712h = menu.findItem(R.id.action_search);
        this.f52710f = (SearchView) this.f52712h.getActionView();
        this.f52710f.setQueryHint(getResources().getString(R.string.search));
        this.s = menu.findItem(R.id.action_cart);
        CartMenuView cartMenuView = (CartMenuView) this.s.getActionView();
        a aVar = this.m;
        if (com.paytm.utility.b.d() > 11) {
            new ActionBar.LayoutParams(-1, -2).height = aVar.f52752a * 1;
        } else {
            new ActionBar.LayoutParams(-1, -2).height = aVar.f52752a * 1;
        }
        aVar.f52752a = com.paytm.utility.a.t(this);
        if (cartMenuView != null) {
            aVar.f52753b = cartMenuView;
            cartMenuView.setImageBackground(R.drawable.ic_cart_dark_smiley);
            cartMenuView.setCartMenuTextVisibility(8);
            cartMenuView.setMainLayoutParams();
            cartMenuView.setCartMenuTextMargin(0, aVar.f52752a / 5, aVar.f52752a / 4, 0);
            cartMenuView.setOnCartMenuClickListener(this);
        }
        a();
        this.t = menu.findItem(R.id.action_profile);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        b(this.f52705a);
        boolean z = this.f52707c;
        try {
            if (this.t != null) {
                this.f52707c = z;
                this.t.setVisible(z);
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                com.paytm.utility.q.b(e2.getMessage());
            }
        }
        c(this.f52706b);
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            com.paytm.utility.b.d((Activity) this);
            onBackPressed();
        } else if (itemId == R.id.action_search) {
            d.a();
            SearchView searchView = this.f52710f;
            if (searchView != null) {
                searchView.setIconified(true);
            }
            this.f52712h.setActionView((View) null);
            a("search");
            Intent i2 = d.a().i((Activity) this);
            i2.putExtra("SHOW_SMART_WIDGET_SEARCH", false);
            i2.putExtra("isMall", true);
            startActivity(i2);
            b bVar = this.l;
            if (bVar != null && (this instanceof AJRMainActivity)) {
                bVar.e();
            }
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void setCartMenuViewClick(View view) {
        i();
        com.paytm.utility.b.d((Activity) this);
        this.f52712h.collapseActionView();
        d.a().c();
        d.a().b("cart_button_clicked", "Product Screen", (Activity) this);
        a("cart");
    }

    public void onCancel(DialogInterface dialogInterface) {
        h();
    }

    public void onFileReadComplete(IJRPaytmDataModel iJRPaytmDataModel, String str) {
        if (iJRPaytmDataModel != null && "flyout_catalog_list".equals(str)) {
            this.l = new b(this, (CJRCatalog) iJRPaytmDataModel);
        }
    }

    public final void a(String str, IJRDataModel iJRDataModel, String str2, int i2, ArrayList<? extends CJRItem> arrayList, boolean z, String str3) {
        IJRDataModel iJRDataModel2 = iJRDataModel;
        if (!TextUtils.isEmpty(str)) {
            String str4 = str;
            if (str.equalsIgnoreCase("nolink")) {
                return;
            }
        } else {
            String str5 = str;
        }
        ProgressBar progressBar = this.f52709e;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        d.a().a(this, str, iJRDataModel, str2, i2, arrayList, z, str3, iJRDataModel2 instanceof CJRHomePageItem ? ((CJRHomePageItem) iJRDataModel2).getCategoryId() : null);
    }

    public final void a(com.paytm.network.a aVar) {
        if (!isFinishing() && !isDestroyed()) {
            r.a(aVar, (Context) this, (DialogInterface.OnCancelListener) this);
        }
    }

    public final void b(Context context, String str) {
        if (context != null || isFinishing()) {
            ProgressDialog progressDialog = this.p;
            if (progressDialog == null || !progressDialog.isShowing()) {
                this.p = new ProgressDialog(context);
                try {
                    this.p.setProgressStyle(0);
                    this.p.setMessage(str);
                    this.p.setCancelable(false);
                    this.p.setCanceledOnTouchOutside(false);
                    this.p.show();
                } catch (IllegalArgumentException e2) {
                    if (com.paytm.utility.b.v) {
                        com.paytm.utility.q.b(e2.getMessage());
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public final void h() {
        ProgressDialog progressDialog = this.p;
        if (progressDialog != null && progressDialog.isShowing() && !isFinishing()) {
            this.p.dismiss();
            this.p = null;
        }
    }

    /* access modifiers changed from: protected */
    public final void a(boolean z) {
        a(z, R.drawable.action_bar_logo_with_bg);
    }

    /* access modifiers changed from: protected */
    public final void b(boolean z) {
        try {
            if (this.f52712h != null) {
                this.f52705a = z;
                if (14 <= com.paytm.utility.b.d() && !z && this.f52712h.isActionViewExpanded()) {
                    this.f52712h.collapseActionView();
                }
                this.f52712h.setVisible(z);
                this.j = z;
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                com.paytm.utility.q.b(e2.getMessage());
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void c(boolean z) {
        MenuItem menuItem = this.s;
        if (menuItem != null) {
            this.f52706b = z;
            menuItem.setVisible(z);
            this.k = z;
            this.m.a(z ? 0 : 8);
            a();
        }
    }

    /* access modifiers changed from: package-private */
    public final void i() {
        DrawerLayout drawerLayout = this.f52708d;
        if (drawerLayout != null && drawerLayout.e(8388611)) {
            this.f52708d.d(8388611);
        }
    }

    private void a(boolean z, int i2) {
        if (z) {
            if (this.o == null) {
                this.o = getSupportActionBar();
            }
            androidx.appcompat.app.ActionBar actionBar = this.o;
            if (actionBar != null) {
                actionBar.c(i2);
                this.o.b(i2);
                return;
            }
            return;
        }
        androidx.appcompat.app.ActionBar actionBar2 = this.o;
        if (actionBar2 != null) {
            actionBar2.c(R.drawable.no_home_icon);
            this.o.b(R.drawable.no_home_icon);
        }
        this.f52708d.setDrawerLockMode(1);
    }

    public void onDrawerOpened(View view) {
        com.paytm.utility.b.d((Activity) this);
        supportInvalidateOptionsMenu();
        b bVar = this.l;
        if (bVar != null) {
            bVar.b();
            bVar.f();
            h hVar = h.f52857a;
            h.a(true);
        }
    }

    public void onDrawerClosed(View view) {
        net.one97.paytm.common.utility.d.f49594a = false;
        b bVar = this.l;
        if (bVar != null) {
            if (b.f52896e == 501) {
                if (!(bVar.f52899b instanceof AJRMainActivity)) {
                    bVar.f52899b.finish();
                }
                bVar.e();
                b.c();
                bVar.f52899b.a(b.f52895d.getURLType(), b.f52895d, (String) null, 0, (ArrayList<? extends CJRItem>) null, true, "catalog");
            }
            if (bVar.f52898a != null && com.paytm.utility.b.r((Context) bVar.f52899b)) {
                net.one97.paytm.landingpage.leftNavigation.d dVar = bVar.f52898a;
                LeftNavigationModel.HeaderModel header = ((LeftNavigationModel) dVar.f52834a.get(1)).getHeader();
                header.setAccountBalance("");
                header.setAccountNumber(net.one97.paytm.landingpage.utils.d.a(dVar.f52837d));
                dVar.f52835b.notifyItemChanged(1);
            }
            h hVar = h.f52857a;
            h.a(false);
        }
        supportInvalidateOptionsMenu();
        if (view instanceof LinearLayout) {
            this.f52708d.setDrawerLockMode(0, 8388611);
        }
    }

    private void a() {
        int b2 = ag.a(getApplicationContext()).b("cart_item_qty", 0, true);
        if (b2 > 0) {
            this.m.a(String.valueOf(b2));
        } else {
            this.m.a(8);
        }
    }

    private void a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("current_screen_type", getResources().getString(R.string.hamburger_click_screen_name));
        hashMap.put("ITEM_NAME", str);
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "TOP NAV");
        g.a(this, hashMap);
    }
}
