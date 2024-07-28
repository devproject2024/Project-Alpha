package net.one97.paytm;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.SearchView;
import androidx.drawerlayout.widget.DrawerLayout;
import com.paytm.network.a;
import com.paytm.network.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.d;
import com.paytm.utility.q;
import com.paytm.utility.v;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.app.CJRJarvisApplication;
import net.one97.paytm.auth.activity.AJRAuthActivity;
import net.one97.paytm.common.entity.CJRFlyoutCatalog;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.auth.LogoutModel;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderList;
import net.one97.paytm.common.entity.shopping.CJRCatalog;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRShoppingCart;
import net.one97.paytm.j.c;
import net.one97.paytm.landingpage.widgets.IconMenuView;
import net.one97.paytm.landingpage.widgets.SignInMenuView;
import net.one97.paytm.locale.b.e;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.utils.ag;
import net.one97.paytm.utils.j;
import net.one97.paytm.utils.l;
import net.one97.paytm.utils.t;
import net.one97.paytm.widget.EditView;
import net.one97.paytm.widget.NotificationView;

public abstract class CJRActionBarBaseActivity extends PaytmActivity implements DialogInterface.OnCancelListener, com.paytm.network.listener.b, IconMenuView.a, SignInMenuView.a, t, EditView.a, NotificationView.a {
    public static HashMap<String, String> m = new HashMap<>();
    public static HashMap<String, String> n = new HashMap<>();
    protected CharSequence A;
    boolean B;
    private MenuItem C;
    private MenuItem D;
    private MenuItem E;
    private MenuItem F;
    private MenuItem G;
    private boolean H = false;
    private boolean I;
    private boolean J = true;
    private boolean K = true;
    private boolean L = true;
    private boolean M = false;
    private boolean N = true;
    /* access modifiers changed from: private */
    public a O;
    private boolean P = true;
    private boolean Q = false;
    private boolean R = true;
    private boolean S = false;
    private boolean T = false;
    private boolean U = false;
    private boolean V = false;
    private String W = "9367";
    private boolean X = false;

    /* renamed from: a  reason: collision with root package name */
    private final int f51798a = 45;

    /* renamed from: b  reason: collision with root package name */
    private TextView f51799b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f51800c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f51801d = false;

    /* renamed from: e  reason: collision with root package name */
    private String f51802e = CJRActionBarBaseActivity.class.getName();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public androidx.appcompat.app.a f51803f;

    /* renamed from: g  reason: collision with root package name */
    private MenuItem f51804g;

    /* renamed from: h  reason: collision with root package name */
    private MenuItem f51805h;

    /* renamed from: i  reason: collision with root package name */
    private MenuItem f51806i;
    private MenuItem j;
    private MenuItem k;
    private MenuItem l;
    protected final a o = new a();
    public ActionBar p;
    public SearchView q;
    public CJRCatalog r;
    protected FrameLayout s;
    protected c t;
    protected ProgressDialog u;
    protected CJRFrequentOrderList v;
    protected String w;
    protected boolean x;
    protected ProgressBar y;
    protected DrawerLayout z;

    public interface a {
    }

    public abstract void a();

    public void onFileWriteComplete(String str) {
    }

    public void attachBaseContext(Context context) {
        if ((this instanceof AJRRechargePaymentActivity) || (this instanceof AJREmbedWebView)) {
            super.attachBaseContext(context);
        } else {
            super.attachBaseContext(e.a(context));
        }
        com.google.android.play.core.splitcompat.a.a((Context) this);
        com.google.android.play.core.splitcompat.a.b((Context) this);
    }

    public final void g() {
        if (d.c(this)) {
            c.a();
            this.w = c.a("frequentOrdersAndroid", (String) null);
            String str = this.w;
            if (str != null) {
                this.w = str + com.paytm.utility.c.a((Context) this, false);
                if (!this.x) {
                    com.paytm.utility.a.a((HashMap<String, String>) new HashMap(), (Context) this);
                    this.x = true;
                    com.paytm.network.b bVar = new com.paytm.network.b();
                    bVar.f42877a = this;
                    bVar.n = a.b.USER_FACING;
                    bVar.f42880d = this.w;
                    bVar.k = false;
                    bVar.f42882f = com.paytm.utility.b.ah(this);
                    bVar.o = "CJRActionBarBaseActivity";
                    bVar.f42878b = a.c.HOME;
                    bVar.f42885i = new CJRFrequentOrderList();
                    bVar.j = new com.paytm.network.listener.b() {
                        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                            if (iJRPaytmDataModel instanceof CJRFrequentOrderList) {
                                CJRActionBarBaseActivity cJRActionBarBaseActivity = CJRActionBarBaseActivity.this;
                                cJRActionBarBaseActivity.x = false;
                                cJRActionBarBaseActivity.v = (CJRFrequentOrderList) iJRPaytmDataModel;
                                if (cJRActionBarBaseActivity.v != null) {
                                    CJRActionBarBaseActivity cJRActionBarBaseActivity2 = CJRActionBarBaseActivity.this;
                                    cJRActionBarBaseActivity2.a(cJRActionBarBaseActivity2.v);
                                    ((CJRJarvisApplication) CJRActionBarBaseActivity.this.getApplication()).f49005a = CJRActionBarBaseActivity.this.v;
                                }
                                if (CJRActionBarBaseActivity.this.O != null) {
                                    a unused = CJRActionBarBaseActivity.this.O;
                                }
                            }
                        }

                        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                            CJRActionBarBaseActivity.this.x = false;
                        }
                    };
                    bVar.l = true;
                    bVar.f42879c = a.C0715a.GET;
                    bVar.l().a();
                    return;
                }
                com.paytm.utility.a.c();
            }
        }
    }

    public final void h() {
        if (this.r != null) {
            CJRCatalog cJRCatalog = new CJRCatalog();
            cJRCatalog.setSearchQueryUrl(this.r.getSearchQueryUrl());
            cJRCatalog.setAllCatalogList(this.r.getAllCatalogList());
            this.t = new c(this, cJRCatalog, this.z);
        }
    }

    public void onFileReadComplete(IJRPaytmDataModel iJRPaytmDataModel, String str) {
        if (iJRPaytmDataModel != null && "flyout_catalog_list".equals(str)) {
            this.t = new c(this, (CJRCatalog) iJRPaytmDataModel, this.z);
        }
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        try {
            super.onStop();
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.action_bar_layout);
        this.z = (DrawerLayout) findViewById(R.id.drawer_layout);
        this.f51803f = new androidx.appcompat.app.a(this.z, this) {
            public final void onDrawerClosed(View view) {
                net.one97.paytm.common.utility.d.f49594a = false;
                CJRActionBarBaseActivity.this.supportInvalidateOptionsMenu();
                try {
                    if (view instanceof LinearLayout) {
                        CJRActionBarBaseActivity.this.z.setDrawerLockMode(0, 8388611);
                    }
                } catch (Exception unused) {
                }
            }

            public final void onDrawerOpened(View view) {
                InputMethodManager inputMethodManager = (InputMethodManager) this.getSystemService("input_method");
                View currentFocus = this.getCurrentFocus();
                if (currentFocus != null) {
                    inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                }
                CJRActionBarBaseActivity.this.supportInvalidateOptionsMenu();
                if (CJRActionBarBaseActivity.this.t != null) {
                    c cVar = CJRActionBarBaseActivity.this.t;
                    if (cVar.f52348e != null) {
                        cVar.f52348e.b();
                        l.f(cVar.f52347c);
                    }
                }
                if (!net.one97.paytm.common.utility.b.bs && CJRActionBarBaseActivity.this.z.e(8388611)) {
                    CJRActionBarBaseActivity.c(CJRActionBarBaseActivity.this);
                }
            }
        };
        DrawerLayout drawerLayout = this.z;
        if (drawerLayout != null) {
            drawerLayout.setDrawerListener(this.f51803f);
        }
        com.paytm.utility.a.t(this);
        this.p = getSupportActionBar();
        ActionBar actionBar = this.p;
        if (actionBar != null) {
            actionBar.b(true);
            this.p.c(false);
            this.p.a(true);
            a(true);
            this.p.b();
            this.p.a((int) R.layout.action_bar_title);
            this.p.a(2.0f);
            this.f51799b = (TextView) findViewById(R.id.text1);
            this.f51799b.setInputType(524288);
            this.f51799b.setEllipsize(TextUtils.TruncateAt.END);
            this.f51799b.setTextSize(19.0f);
            this.f51799b.setMaxLines(1);
            this.f51800c = (TextView) findViewById(R.id.text2);
            this.f51799b.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    CJRActionBarBaseActivity.b(CJRActionBarBaseActivity.this);
                }
            });
            com.paytm.utility.b.d(this.f51799b);
            this.p.a((Drawable) new ColorDrawable(getResources().getColor(R.color.white)));
        }
        l.a(getClass().getSimpleName(), "Activity Created");
    }

    public final void a(String str, IJRDataModel iJRDataModel, int i2, ArrayList<? extends CJRItem> arrayList, String str2) {
        if (TextUtils.isEmpty(str) || !str.equalsIgnoreCase("nolink")) {
            ProgressBar progressBar = this.y;
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
            j.a((Context) this, str, iJRDataModel, (String) null, i2, arrayList, false, str2, this.t);
        }
    }

    public void onBackPressed() {
        SearchView searchView = this.q;
        if (searchView != null) {
            searchView.setIconified(true);
        }
        super.onBackPressed();
    }

    public void onPause() {
        super.onPause();
        com.paytm.utility.a.k();
        m();
    }

    public void onResume() {
        c cVar = this.t;
        if (cVar != null) {
            c.f52345b = 500;
            if (cVar.f52348e != null && (net.one97.paytm.common.utility.b.br || cVar.f52348e.f52836c != com.paytm.utility.a.p(cVar.f52347c))) {
                net.one97.paytm.common.utility.b.br = false;
                cVar.f52348e = new net.one97.paytm.landingpage.leftNavigation.d();
                androidx.fragment.app.q a2 = cVar.f52347c.getSupportFragmentManager().a();
                a2.b(R.id.flyout_frame, cVar.f52348e, "fragment_flyout");
                a2.c();
                cVar.f52347c.getSupportFragmentManager().b();
            }
        }
        n();
        net.one97.paytm.wallet.f.d.a().a(this);
        super.onResume();
        com.google.android.play.core.splitcompat.a.a((Context) this);
        com.google.android.play.core.splitcompat.a.b((Context) this);
    }

    /* access modifiers changed from: protected */
    public final void i() {
        try {
            if (this.f51804g != null) {
                this.P = false;
                if (14 <= com.paytm.utility.b.d() && this.f51804g.isActionViewExpanded()) {
                    this.f51804g.collapseActionView();
                }
                this.f51804g.setVisible(false);
                this.J = false;
                setTitle(this.A);
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void a(int i2) {
        a aVar = this.o;
        if (aVar.f51947a != null && !aVar.f51947a.isFinishing()) {
            aVar.f51952f.setMainLayoutParams(i2, aVar.f51947a.getSupportActionBar().d());
        }
    }

    /* access modifiers changed from: protected */
    public final void c(String str) {
        a aVar = this.o;
        if (aVar.f51952f == null) {
            return;
        }
        if (str == null || str.trim().length() <= 0) {
            aVar.f51952f.setEditText(" ");
            aVar.f51952f.setClickable(false);
            return;
        }
        aVar.f51952f.setEditText(str);
        aVar.f51952f.setClickable(true);
        aVar.f51952f.setEditTextVisibility(0);
    }

    /* access modifiers changed from: protected */
    public final void d(String str) {
        a aVar = this.o;
        if (aVar.f51953g == null) {
            return;
        }
        if (str == null || str.trim().length() <= 0) {
            aVar.f51953g.setEditText(" ");
            aVar.f51953g.setClickable(false);
            return;
        }
        aVar.f51953g.setEditText(str);
        aVar.f51953g.setClickable(true);
        aVar.f51953g.setSignInTextVisibility(0);
        if (aVar.f51947a != null && !aVar.f51947a.isFinishing()) {
            aVar.f51953g.setMainLayoutParams(aVar.f51953g.getTextWidth(), aVar.f51947a.getSupportActionBar().d());
        }
    }

    /* access modifiers changed from: protected */
    public final void j() {
        MenuItem menuItem = this.f51805h;
        if (menuItem != null) {
            this.R = false;
            menuItem.setVisible(false);
            this.K = false;
            setTitle(this.A);
            this.o.a(8);
        }
    }

    /* access modifiers changed from: protected */
    public final void k() {
        MenuItem menuItem = this.j;
        if (menuItem != null) {
            menuItem.setVisible(false);
            this.N = false;
            setTitle(this.A);
            this.T = false;
        }
    }

    public final void a(Context context, String str) {
        if (context != null || isFinishing()) {
            ProgressDialog progressDialog = this.u;
            if (progressDialog == null || !progressDialog.isShowing()) {
                this.u = new ProgressDialog(context);
                try {
                    this.u.setProgressStyle(0);
                    this.u.setMessage(str);
                    this.u.setCancelable(false);
                    this.u.setCanceledOnTouchOutside(false);
                    this.u.show();
                } catch (IllegalArgumentException e2) {
                    if (com.paytm.utility.b.v) {
                        q.b(e2.getMessage());
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public final void m() {
        try {
            if (this.u != null && this.u.isShowing() && !isFinishing()) {
                this.u.dismiss();
                this.u = null;
            }
        } catch (Exception e2) {
            com.google.firebase.crashlytics.c.a().a((Throwable) e2);
        }
    }

    public void n() {
        int b2 = ag.a(getApplicationContext()).b("cart_item_qty", 0, true);
        if (b2 > 0) {
            String valueOf = String.valueOf(b2);
            a aVar = this.o;
            if (aVar.f51950d != null) {
                aVar.f51950d.setNotificationText(valueOf, aVar.f51948b);
                aVar.f51950d.setNotificationTextVisibility(0);
                return;
            }
            return;
        }
        this.o.a(8);
    }

    /* access modifiers changed from: protected */
    public final void o() {
        a(false);
    }

    private void a(boolean z2) {
        this.f51801d = z2;
        if (z2) {
            this.p.c((int) R.drawable.action_bar_logo_with_bg_cjr);
            this.p.b((int) R.drawable.action_bar_logo_with_bg_cjr);
            return;
        }
        ActionBar actionBar = this.p;
        if (actionBar != null) {
            actionBar.c((int) R.drawable.no_home_icon);
            this.p.b((int) R.drawable.no_home_icon);
        }
        this.z.setDrawerLockMode(1);
    }

    /* access modifiers changed from: protected */
    public final void p() {
        androidx.appcompat.app.a aVar = this.f51803f;
        if (aVar != null) {
            this.I = true;
            aVar.c();
            DrawerLayout drawerLayout = this.z;
            if (drawerLayout != null) {
                drawerLayout.setDrawerLockMode(1);
            }
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_menu, menu);
        this.f51805h = menu.findItem(R.id.action_notifivation);
        NotificationView notificationView = (NotificationView) this.f51805h.getActionView();
        a aVar = this.o;
        if (com.paytm.utility.b.d() > 11) {
            new ActionBar.LayoutParams(-1, -2).height = aVar.f51948b * 1;
        } else {
            new ActionBar.LayoutParams(-1, -2).height = aVar.f51948b * 1;
        }
        aVar.f51947a = this;
        aVar.f51948b = com.paytm.utility.a.t(aVar.f51947a);
        aVar.f51949c = aVar.f51948b / 2;
        if (notificationView != null) {
            aVar.f51950d = notificationView;
            notificationView.setImageBackground(R.drawable.ic_cart_dark_smiley);
            notificationView.setNotificationTextVisibility(8);
            if (aVar.f51947a.getSupportActionBar() != null) {
                notificationView.setMainLayoutParams(aVar.f51948b * 1, aVar.f51947a.getSupportActionBar().d());
            }
            notificationView.setNotificationTextMargin(0, aVar.f51948b / 5, aVar.f51948b / 4, 0);
            notificationView.setOnNotificationViewClickListener(aVar.f51947a);
        }
        this.f51806i = menu.findItem(R.id.action_updates_notification);
        NotificationView notificationView2 = (NotificationView) this.f51806i.getActionView();
        a aVar2 = this.o;
        if (com.paytm.utility.b.d() > 11) {
            new ActionBar.LayoutParams(-1, -2).height = aVar2.f51948b * 1;
        } else {
            new ActionBar.LayoutParams(-1, -2).height = aVar2.f51948b * 1;
        }
        aVar2.f51947a = this;
        aVar2.f51948b = com.paytm.utility.a.t(aVar2.f51947a);
        aVar2.f51949c = aVar2.f51948b / 2;
        if (notificationView2 != null) {
            aVar2.f51951e = notificationView2;
            notificationView2.setMainLayoutTag("updates_count");
            notificationView2.setImageBackground(R.drawable.icon_notifications);
            notificationView2.setNotificationTextVisibility(8);
            if (aVar2.f51947a.getSupportActionBar() != null) {
                notificationView2.setMainLayoutParams(aVar2.f51948b * 1, aVar2.f51947a.getSupportActionBar().d());
            }
            notificationView2.setNotificationTextMargin(0, aVar2.f51948b / 5, aVar2.f51948b / 4, 0);
            notificationView2.setOnNotificationViewClickListener(aVar2.f51947a);
        }
        boolean z2 = this.M;
        MenuItem menuItem = this.f51806i;
        if (menuItem != null) {
            menuItem.setVisible(z2);
            this.M = z2;
        }
        this.C = menu.findItem(R.id.action_share);
        this.j = menu.findItem(R.id.action_edit);
        EditView editView = (EditView) this.j.getActionView();
        a aVar3 = this.o;
        aVar3.f51947a = this;
        aVar3.f51952f = editView;
        aVar3.f51948b = com.paytm.utility.a.t(aVar3.f51947a);
        aVar3.f51949c = aVar3.f51948b / 2;
        editView.setMainLayoutBackground(0);
        editView.setEditTextVisibility(0);
        new ActionBar.LayoutParams(-1, -2).height = aVar3.f51948b * 1;
        editView.setMainLayoutParams(aVar3.f51948b * 1, (aVar3.f51947a == null || aVar3.f51947a.getSupportActionBar() == null) ? 0 : aVar3.f51947a.getSupportActionBar().d());
        editView.setEditTextMargin(0, aVar3.f51948b / 8, aVar3.f51948b / 8, 0);
        editView.setOnEditViewClickListener(aVar3.f51947a);
        this.f51804g = menu.findItem(R.id.action_search);
        this.q = (SearchView) this.f51804g.getActionView();
        this.q.setQueryHint(getResources().getString(R.string.search));
        this.k = menu.findItem(R.id.action_sign_in);
        SignInMenuView signInMenuView = (SignInMenuView) this.k.getActionView();
        a aVar4 = this.o;
        aVar4.f51947a = this;
        aVar4.f51953g = signInMenuView;
        int t2 = com.paytm.utility.a.t(aVar4.f51947a);
        signInMenuView.setSignInTextVisibility(8);
        new ActionBar.LayoutParams(-1, -2).height = t2 * 1;
        if (!(aVar4.f51947a == null || aVar4.f51947a.getSupportActionBar() == null)) {
            signInMenuView.setMainLayoutParams(signInMenuView.getTextWidth(), aVar4.f51947a.getSupportActionBar().d());
        }
        signInMenuView.setOnSignInMenuViewClickListener(aVar4.f51947a);
        l();
        this.l = menu.findItem(R.id.action_menu_icon);
        a aVar5 = this.o;
        aVar5.f51954h = (IconMenuView) this.l.getActionView();
        new ActionBar.LayoutParams(-1, -2).height = com.paytm.utility.a.t(aVar5.f51947a) * 1;
        if (aVar5.f51954h != null) {
            aVar5.f51954h.setIconMenuVisibility(8);
            aVar5.f51954h.setIconMenuViewClickListener(aVar5.f51947a);
        }
        this.D = menu.findItem(R.id.qr_img);
        this.E = menu.findItem(R.id.profile);
        this.F = menu.findItem(R.id.inbox_share);
        this.G = menu.findItem(R.id.action_bbps);
        a aVar6 = this.o;
        aVar6.f51955i = (IconMenuView) this.G.getActionView();
        if (aVar6.f51955i != null) {
            aVar6.f51955i.setLayoutParams(new ActionBar.LayoutParams(com.paytm.utility.a.a(65), com.paytm.utility.a.a(16)));
            aVar6.f51955i.setIconMenuVisibility(8);
            aVar6.f51955i.setIconMenuViewClickListener(aVar6.f51947a);
        }
        n();
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean e2 = this.z.e(8388611);
        if (this.P) {
            boolean z2 = !e2;
            MenuItem menuItem = this.f51804g;
            if (menuItem != null) {
                menuItem.setVisible(z2);
                this.J = z2;
            }
        } else {
            i();
        }
        if (this.Q) {
            boolean z3 = !e2;
            MenuItem menuItem2 = this.E;
            if (menuItem2 != null) {
                menuItem2.setVisible(z3);
                this.L = z3;
            }
        } else {
            try {
                if (this.E != null) {
                    this.Q = false;
                    this.E.setVisible(false);
                    this.L = false;
                    setTitle(this.A);
                }
            } catch (Exception e3) {
                if (com.paytm.utility.b.v) {
                    q.b(e3.getMessage());
                }
            }
        }
        int i2 = 8;
        if (this.R) {
            boolean z4 = !e2;
            MenuItem menuItem3 = this.f51805h;
            if (menuItem3 != null) {
                menuItem3.setVisible(z4);
                this.K = z4;
                this.o.a(z4 ? 0 : 8);
                n();
            }
        } else {
            j();
        }
        if (this.B) {
            MenuItem menuItem4 = this.C;
            if (menuItem4 != null) {
                menuItem4.setVisible(true);
            }
        } else {
            MenuItem menuItem5 = this.C;
            if (menuItem5 != null) {
                menuItem5.setVisible(false);
            }
        }
        if (this.U) {
            boolean z5 = !e2;
            MenuItem menuItem6 = this.l;
            if (menuItem6 != null) {
                menuItem6.setVisible(z5);
                a aVar = this.o;
                if (z5) {
                    i2 = 0;
                }
                aVar.b(i2);
            }
        } else {
            MenuItem menuItem7 = this.l;
            if (menuItem7 != null) {
                menuItem7.setVisible(false);
                this.U = false;
                this.o.b(8);
            }
        }
        if (this.H) {
            boolean z6 = !e2;
            MenuItem menuItem8 = this.F;
            if (menuItem8 != null) {
                menuItem8.setVisible(z6);
            }
        } else {
            MenuItem menuItem9 = this.F;
            if (menuItem9 != null) {
                this.H = false;
                menuItem9.setVisible(this.H);
            }
        }
        if (!this.S || !com.paytm.utility.a.p(this)) {
            MenuItem menuItem10 = this.D;
            if (menuItem10 != null) {
                this.S = false;
                menuItem10.setVisible(this.S);
            }
        } else {
            boolean z7 = !e2;
            MenuItem menuItem11 = this.D;
            if (menuItem11 != null) {
                menuItem11.setVisible(z7);
            }
        }
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        boolean z2;
        boolean z3;
        androidx.appcompat.app.a aVar = this.f51803f;
        if (menuItem == null || menuItem.getItemId() != 16908332 || !aVar.f1081c) {
            z2 = false;
        } else {
            int a2 = aVar.f1079a.a(8388611);
            View b2 = aVar.f1079a.b(8388611);
            if (b2 != null) {
                z3 = DrawerLayout.f(b2);
            } else {
                z3 = false;
            }
            if (z3 && a2 != 2) {
                aVar.f1079a.d(8388611);
            } else if (a2 != 1) {
                aVar.f1079a.c(8388611);
            }
            z2 = true;
        }
        if (z2) {
            net.one97.paytm.j.a.a((Context) this, "left_nav", "top_nav_clicked", (String) null, (String) null, "/top-left-nav", "homescreen");
            return true;
        }
        switch (menuItem.getItemId()) {
            case 16908332:
                q();
                try {
                    onBackPressed();
                    break;
                } catch (IllegalStateException unused) {
                    break;
                }
            case R.id.action_search:
                SearchView searchView = this.q;
                if (searchView != null) {
                    searchView.setIconified(true);
                }
                this.f51804g.setActionView((View) null);
                Intent intent = new Intent(this, net.one97.paytm.marketplace.a.g());
                a("search");
                startActivity(intent);
                return true;
            case R.id.inbox_share:
                try {
                    Intent intent2 = new Intent("android.intent.action.SEND");
                    intent2.setType("text/plain");
                    intent2.putExtra("android.intent.extra.SUBJECT", getString(R.string.share_inbox_sbjct));
                    intent2.putExtra("android.intent.extra.TEXT", getString(R.string.share_inbox) + " http://m.p-y.tm/updt");
                    Intent createChooser = Intent.createChooser(intent2, getString(R.string.inbox_share_title));
                    if (createChooser.resolveActivity(getPackageManager()) == null) {
                        Toast.makeText(this, getString(R.string.no_app_found), 1).show();
                        break;
                    } else {
                        startActivity(createChooser);
                        break;
                    }
                } catch (Exception e2) {
                    if (com.paytm.utility.b.v) {
                        q.b(e2.getMessage());
                        break;
                    }
                }
                break;
            case R.id.profile:
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("ITEM_NAME", "profile");
                    hashMap.put("current_screen_type", "/");
                    net.one97.paytm.j.a.b("top_nav_clicked", (Map<String, Object>) hashMap, (Context) this);
                } catch (Exception e3) {
                    if (com.paytm.utility.b.v) {
                        q.b(e3.getMessage());
                    }
                }
                net.one97.paytm.payments.d.a.a((Activity) this, "paytmmp://mini-app?aId=109200364bd9adad098ce67c643bade349cd01d5&data=eyJwYXJhbXMiOiIvaDUtc2V0dGluZ3MiLCJzcGFyYW1zIjp7ImNhblB1bGxEb3duIjpmYWxzZSwicHVsbFJlZnJlc2giOmZhbHNlLCJzaG93VGl0bGVCYXIiOmZhbHNlfX0=&url=https://paytm.com");
                break;
            case R.id.qr_img:
                if (com.paytm.utility.a.b((Context) this) == null) {
                    Toast.makeText(this, getResources().getString(R.string.profile_qr_code_msg), 0).show();
                    break;
                } else {
                    try {
                        net.one97.paytm.j.a.b("wallet_account_qr_clicked", (Map<String, Object>) new HashMap(), getApplicationContext());
                        break;
                    } catch (Exception e4) {
                        if (com.paytm.utility.b.v) {
                            q.b(e4.getMessage());
                            break;
                        }
                    }
                }
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private void a(String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("current_screen_type", getResources().getString(R.string.hamburger_click_screen_name));
            hashMap.put("ITEM_NAME", str);
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "TOP NAV");
            net.one97.paytm.j.a.b("top_nav_clicked", (Map<String, Object>) hashMap, (Context) this);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.A = charSequence;
            String charSequence2 = charSequence.toString();
            if (charSequence2 != null && charSequence2.length() > 0) {
                charSequence2 = charSequence2.substring(0, 1).toUpperCase() + charSequence2.substring(1);
            }
            if (this.f51799b != null) {
                int i2 = 45;
                if (this.N) {
                    i2 = 40;
                }
                if (this.J) {
                    i2 -= 5;
                }
                if (this.K) {
                    i2 -= 5;
                }
                boolean z2 = this instanceof AJRAuthActivity;
                if (z2) {
                    this.f51799b.setTypeface(Typeface.create("sans-serif-medium", 0));
                }
                if (!(this instanceof AJREmbedWebView)) {
                    if (z2 && this.V) {
                        i2 -= 5;
                    }
                    if (charSequence2.length() > i2) {
                        charSequence2 = charSequence2.substring(0, i2 - 3);
                        if (charSequence2.trim().length() > 0) {
                            charSequence2 = charSequence2 + AppConstants.DOTS;
                        }
                    }
                    this.f51799b.setText(charSequence2);
                } else if (!TextUtils.isEmpty(charSequence2)) {
                    if (charSequence2.length() < i2) {
                        this.f51799b.setTextSize(2, 17.0f);
                    } else {
                        charSequence2 = charSequence2.substring(0, (i2 - 5) - 3);
                        if (charSequence2.trim().length() > 0) {
                            charSequence2 = charSequence2 + AppConstants.DOTS;
                        }
                    }
                    this.f51799b.setText(charSequence2);
                }
            }
        }
    }

    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        androidx.appcompat.app.a aVar = this.f51803f;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        androidx.appcompat.app.a aVar = this.f51803f;
        if (!aVar.f1082d) {
            aVar.f1080b = aVar.d();
        }
        aVar.a();
    }

    public void setNotificationViewClick(View view) {
        if (this.z.e(8388611)) {
            this.z.d(8388611);
        }
        try {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            this.f51804g.collapseActionView();
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
        net.one97.paytm.j.a.a("cart_button_clicked", "Product Screen", (Context) this);
        a("cart");
        net.one97.paytm.marketplace.a.i();
    }

    public void onEditViewClick(View view) {
        if (this.z.e(8388611)) {
            this.z.d(8388611);
        }
    }

    public void onSignInMenuClick(View view) {
        if (this.z.e(8388611)) {
            this.z.d(8388611);
        }
    }

    public void onIconMenuClick(View view) {
        if (this.z.e(8388611)) {
            this.z.d(8388611);
        }
    }

    public final void a(NetworkCustomError networkCustomError) {
        if (!TextUtils.isEmpty(t.b(getApplicationContext()))) {
            b();
        } else if (!isFinishing()) {
            b(networkCustomError);
        }
    }

    private void b(final NetworkCustomError networkCustomError) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String string = getResources().getString(R.string.title_401_410);
        builder.setTitle(string).setMessage(getResources().getString(R.string.message_401_410)).setCancelable(false);
        builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
                CJRActionBarBaseActivity.d(CJRActionBarBaseActivity.this);
            }
        });
        builder.show();
    }

    private void b() {
        c.a();
        String a2 = c.a("logoutIfRequired", (String) null);
        HashMap hashMap = new HashMap();
        hashMap.put("Authorization", com.paytm.utility.b.m());
        hashMap.put(StringSet.token, t.b(getApplicationContext()));
        net.one97.paytm.common.b.d.a(this, a2, this, hashMap, (Map<String, String>) null, a.C0715a.POST, (String) null, new LogoutModel(), a.c.HOME, a.b.USER_FACING).a();
    }

    public final void q() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null && getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        } catch (Exception unused) {
            boolean z2 = com.paytm.utility.b.v;
        }
    }

    public final void a(CJRFrequentOrderList cJRFrequentOrderList) {
        new net.one97.paytm.landingpage.utils.c(this, new t() {
            public final void onFileReadComplete(IJRPaytmDataModel iJRPaytmDataModel, String str) {
            }

            public final void onFileWriteComplete(String str) {
            }
        }, cJRFrequentOrderList, "frequent_order_list").execute(new Void[0]);
        this.x = true;
    }

    public final void r() {
        if (!isFinishing()) {
            try {
                if (getApplication() != null && (getApplication() instanceof CJRJarvisApplication)) {
                    getApplication();
                    this.r = CJRJarvisApplication.k();
                }
                if (this.r == null) {
                    new b().execute(new Void[0]);
                } else if (!isFinishing()) {
                    if (this.f51803f != null && this.f51803f.f1081c) {
                        h();
                    }
                    a();
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.b(e2.getMessage());
                }
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        net.one97.paytm.wallet.f.d.a().f70361a = null;
    }

    public final void s() {
        androidx.appcompat.app.a aVar = this.f51803f;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        m();
    }

    /* access modifiers changed from: protected */
    public final void t() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().f();
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        LogoutModel logoutModel;
        if (iJRPaytmDataModel instanceof CJRShoppingCart) {
            CJRShoppingCart cJRShoppingCart = (CJRShoppingCart) iJRPaytmDataModel;
            if (cJRShoppingCart == null || cJRShoppingCart.getCart() == null || cJRShoppingCart.getCart().getCartItems() == null) {
                t.b(this, "0");
                t.a((Context) this, 0);
                return;
            }
            t.b(this, cJRShoppingCart.getCart().getFinalPrice());
            t.a((Context) this, cJRShoppingCart.getCart().getCartItems().size());
            t.a((Context) this, cJRShoppingCart.getCart().getmCartId());
            new StringBuilder("cart id ").append(cJRShoppingCart.getCart().getmCartId());
            com.paytm.utility.a.c();
        } else if ((iJRPaytmDataModel instanceof LogoutModel) && (logoutModel = (LogoutModel) iJRPaytmDataModel) != null && !isFinishing()) {
            if (logoutModel.isLoggedOut()) {
                b((NetworkCustomError) null);
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            String string = getResources().getString(R.string.retry);
            builder.setTitle(string).setMessage(getResources().getString(R.string.please_retry_now)).setCancelable(false);
            builder.setPositiveButton(getResources().getString(R.string.ok), $$Lambda$CJRActionBarBaseActivity$HGtNQNIRcoJDPzOdF23ccKpa_c.INSTANCE);
            builder.show();
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (!v.a(networkCustomError.getUrl())) {
            c.a();
            String a2 = c.a("logoutIfRequired", (String) null);
            if (!TextUtils.isEmpty(a2) && networkCustomError.getUrl().contains(a2) && !isFinishing()) {
                b(networkCustomError);
            }
        }
    }

    public class b extends AsyncTask<Void, Void, CJRCatalog> {
        public b() {
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            if (!CJRActionBarBaseActivity.this.isFinishing()) {
                if (CJRActionBarBaseActivity.this.f51803f.f1081c) {
                    CJRActionBarBaseActivity.this.h();
                }
                CJRActionBarBaseActivity.this.a();
            }
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            StringBuilder sb = new StringBuilder();
            c.a();
            sb.append(c.t());
            sb.append(com.paytm.utility.c.a(CJRActionBarBaseActivity.this.getApplicationContext(), true));
            CJRFlyoutCatalog cJRFlyoutCatalog = (CJRFlyoutCatalog) f.a(sb.toString(), CJRActionBarBaseActivity.this.getApplicationContext(), new CJRFlyoutCatalog());
            if (!(cJRFlyoutCatalog == null || cJRFlyoutCatalog.getFlyoutCatalog() == null)) {
                CJRActionBarBaseActivity.this.r = cJRFlyoutCatalog.getFlyoutCatalog();
                CJRActionBarBaseActivity.this.r.setParentNameItems(new ArrayList());
                CJRActionBarBaseActivity.this.getApplication();
                CJRJarvisApplication.a(CJRActionBarBaseActivity.this.r);
            }
            return CJRActionBarBaseActivity.this.r;
        }
    }

    /* access modifiers changed from: protected */
    public final void l() {
        this.V = false;
        MenuItem menuItem = this.k;
        if (menuItem != null) {
            menuItem.setVisible(false);
            a aVar = this.o;
            if (aVar.f51953g != null) {
                aVar.f51953g.setSignInTextVisibility(8);
            }
        }
    }

    static /* synthetic */ void b(CJRActionBarBaseActivity cJRActionBarBaseActivity) {
        if (cJRActionBarBaseActivity.I) {
            cJRActionBarBaseActivity.onBackPressed();
        } else if (!cJRActionBarBaseActivity.z.e(8388611)) {
            cJRActionBarBaseActivity.z.c(8388611);
        } else {
            cJRActionBarBaseActivity.z.d(8388611);
        }
    }

    static /* synthetic */ void c(CJRActionBarBaseActivity cJRActionBarBaseActivity) {
        ArrayList arrayList;
        net.one97.paytm.common.utility.b.bs = true;
        try {
            String b2 = ag.a(cJRActionBarBaseActivity.getApplicationContext()).b("banner_data", "", true);
            if (!TextUtils.isEmpty(b2) && (arrayList = (ArrayList) new com.google.gson.f().a(b2, new com.google.gson.b.a<List<CJRHomePageItem>>() {
            }.getType())) != null && !arrayList.isEmpty()) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    net.one97.paytm.j.a.b((CJRHomePageItem) arrayList.get(i2), (Context) cJRActionBarBaseActivity, i2, "flyout");
                }
            }
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void d(CJRActionBarBaseActivity cJRActionBarBaseActivity) {
        net.one97.paytm.auth.b.b.a((Activity) cJRActionBarBaseActivity);
        Intent intent = new Intent(cJRActionBarBaseActivity, AJRAuthActivity.class);
        intent.putExtra("authError", true);
        intent.putExtra("VERTICAL_NAME", GAUtil.MARKET_PLACE);
        cJRActionBarBaseActivity.startActivityForResult(intent, 3);
    }
}
