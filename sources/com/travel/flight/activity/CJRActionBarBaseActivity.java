package com.travel.flight.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.paytm.utility.b;
import com.travel.flight.R;
import com.travel.flight.flightorder.widget.EditView;
import com.travel.flight.flightorder.widget.NotificationView;
import com.travel.flight.utils.i;
import com.travel.utils.q;
import java.util.HashMap;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderList;
import net.one97.paytm.common.entity.shopping.CJRShoppingCart;

public abstract class CJRActionBarBaseActivity extends PaytmActivity implements DialogInterface.OnCancelListener, Response.ErrorListener, Response.Listener<IJRDataModel>, EditView.a, NotificationView.a {

    /* renamed from: e  reason: collision with root package name */
    public static HashMap<String, String> f23511e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    public static HashMap<String, String> f23512f = new HashMap<>();
    private boolean A = true;
    private boolean B = false;
    private boolean C = false;
    private boolean D = false;
    private boolean E = false;
    private String F = "9367";
    private boolean G = false;

    /* renamed from: a  reason: collision with root package name */
    private final int f23513a = 45;

    /* renamed from: b  reason: collision with root package name */
    private TextView f23514b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f23515c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f23516d = false;

    /* renamed from: g  reason: collision with root package name */
    public ActionBar f23517g;

    /* renamed from: h  reason: collision with root package name */
    protected FrameLayout f23518h;

    /* renamed from: i  reason: collision with root package name */
    protected ProgressDialog f23519i;
    protected CJRFrequentOrderList j;
    protected boolean k;
    protected CharSequence l;
    androidx.appcompat.app.a m;
    boolean n;
    private String o = CJRActionBarBaseActivity.class.getName();
    private MenuItem p;
    private MenuItem q;
    private boolean r = false;
    private boolean s = true;
    private boolean t = true;
    private boolean u = true;
    private boolean v = false;
    private boolean w = true;
    private a x;
    private boolean y = true;
    private boolean z = false;

    public interface a {
    }

    public void onEditViewClick(View view) {
    }

    public void onErrorResponse(VolleyError volleyError) {
    }

    public void setNotificationViewClick(View view) {
    }

    public /* synthetic */ void onResponse(Object obj) {
        IJRDataModel iJRDataModel = (IJRDataModel) obj;
        if (iJRDataModel instanceof CJRFrequentOrderList) {
            this.k = false;
            this.j = (CJRFrequentOrderList) iJRDataModel;
            if (this.x == null) {
            }
        } else if (iJRDataModel instanceof CJRShoppingCart) {
            CJRShoppingCart cJRShoppingCart = (CJRShoppingCart) iJRDataModel;
            if (cJRShoppingCart == null || cJRShoppingCart.getCart() == null || cJRShoppingCart.getCart().getCartItems() == null) {
                com.travel.flight.flightorder.i.a.b(this, "0");
                com.travel.flight.flightorder.i.a.a((Context) this, 0);
                return;
            }
            com.travel.flight.flightorder.i.a.b(this, cJRShoppingCart.getCart().getFinalPrice());
            com.travel.flight.flightorder.i.a.a((Context) this, cJRShoppingCart.getCart().getCartItems().size());
            com.travel.flight.flightorder.i.a.a((Context) this, cJRShoppingCart.getCart().getmCartId());
            new StringBuilder("cart id ").append(cJRShoppingCart.getCart().getmCartId());
            b.j();
        }
    }

    public void attachBaseContext(Context context) {
        com.travel.flight.b.a();
        super.attachBaseContext(com.travel.flight.b.b().d(context));
        q.a(context);
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        try {
            super.onStop();
        } catch (Exception unused) {
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_f_action_bar_layout);
        b.f((Context) this);
        this.f23517g = getSupportActionBar();
        ActionBar actionBar = this.f23517g;
        if (actionBar != null) {
            actionBar.b(true);
            this.f23517g.c(false);
            this.f23517g.a(true);
            this.f23517g.b();
            this.f23517g.a(R.layout.pre_f_action_bar_title);
            this.f23517g.a(2.0f);
            this.f23514b = (TextView) findViewById(R.id.text1);
            this.f23514b.setInputType(524288);
            this.f23514b.setEllipsize(TextUtils.TruncateAt.END);
            this.f23514b.setTextSize(19.0f);
            this.f23514b.setMaxLines(1);
            this.f23515c = (TextView) findViewById(R.id.text2);
            this.f23514b.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    CJRActionBarBaseActivity.a(CJRActionBarBaseActivity.this);
                }
            });
            b.d(this.f23514b);
            this.f23517g.a((Drawable) new ColorDrawable(getResources().getColor(R.color.white)));
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onPause() {
        b.u();
        super.onPause();
        c();
    }

    /* access modifiers changed from: protected */
    public final void a() {
        try {
            if (this.p != null) {
                this.y = false;
                if (14 <= b.d() && this.p.isActionViewExpanded()) {
                    this.p.collapseActionView();
                }
                this.p.setVisible(false);
                this.s = false;
                setTitle(this.l);
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public final void b() {
        MenuItem menuItem = this.q;
        if (menuItem != null) {
            menuItem.setVisible(false);
            this.w = false;
            setTitle(this.l);
            this.C = false;
        }
    }

    public final void c() {
        try {
            if (this.f23519i != null && this.f23519i.isShowing() && !isFinishing()) {
                this.f23519i.dismiss();
                this.f23519i = null;
            }
        } catch (Exception unused) {
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onCancel(DialogInterface dialogInterface) {
        c();
    }

    public void onResume() {
        i.a(getApplicationContext()).b("cart_item_qty", 0, true);
        super.onResume();
        q.a(this);
    }

    static /* synthetic */ void a(CJRActionBarBaseActivity cJRActionBarBaseActivity) {
        if (cJRActionBarBaseActivity.n) {
            cJRActionBarBaseActivity.onBackPressed();
        }
    }
}
