package com.travel;

import android.app.AlertDialog;
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
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.travel.common.TravelBaseActivity;
import com.travel.utils.b;
import com.travel.utils.q;
import com.travel.utils.r;
import com.travel.widget.EditView;
import com.travel.widget.NotificationView;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.recharge.CJRFrequentOrderList;
import net.one97.paytm.common.entity.shopping.CJRShoppingCart;

public abstract class CJRActionBarBaseActivity extends TravelBaseActivity implements DialogInterface.OnCancelListener, Response.ErrorListener, Response.Listener<IJRDataModel>, EditView.a, NotificationView.a {

    /* renamed from: a  reason: collision with root package name */
    private static String f21396a = "CJRActionBarBaseActivity";

    /* renamed from: c  reason: collision with root package name */
    private static String f21397c = CJRActionBarBaseActivity.class.getName();

    /* renamed from: b  reason: collision with root package name */
    private TextView f21398b;

    /* renamed from: d  reason: collision with root package name */
    private androidx.appcompat.app.a f21399d;

    /* renamed from: e  reason: collision with root package name */
    private MenuItem f21400e;

    /* renamed from: f  reason: collision with root package name */
    private MenuItem f21401f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f21402g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f21403h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f21404i = true;
    private boolean j = true;
    private a k;
    private boolean l = true;
    private boolean m = false;
    public ActionBar s;
    protected ProgressDialog t;
    protected CJRFrequentOrderList u;
    protected boolean v;
    protected CharSequence w;

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
            this.v = false;
            this.u = (CJRFrequentOrderList) iJRDataModel;
            if (this.k == null) {
            }
        } else if (iJRDataModel instanceof CJRShoppingCart) {
            CJRShoppingCart cJRShoppingCart = (CJRShoppingCart) iJRDataModel;
            if (cJRShoppingCart == null || cJRShoppingCart.getCart() == null || cJRShoppingCart.getCart().getCartItems() == null) {
                b.a((Context) this, "0");
                b.a((Context) this, 0);
                return;
            }
            b.a((Context) this, cJRShoppingCart.getCart().getFinalPrice());
            b.a((Context) this, cJRShoppingCart.getCart().getCartItems().size());
            r.a(getApplicationContext()).a("cart_id", cJRShoppingCart.getCart().getmCartId(), true);
            new StringBuilder("cart id ").append(cJRShoppingCart.getCart().getmCartId());
            com.paytm.utility.b.j();
        }
    }

    public void attachBaseContext(Context context) {
        q.a(context);
        d.a();
        super.attachBaseContext(d.b().c(context));
        com.google.android.play.core.splitcompat.a.b((Context) this);
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        try {
            super.onStop();
        } catch (Exception e2) {
            com.paytm.utility.q.c(e2.getMessage());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_td_action_bar_layout);
        com.paytm.utility.b.f((Context) this);
        this.s = getSupportActionBar();
        ActionBar actionBar = this.s;
        if (actionBar != null) {
            actionBar.b(true);
            this.s.c(false);
            this.s.a(true);
            this.s.b();
            this.s.a(R.layout.pre_td_action_bar_title);
            this.s.a(2.0f);
            this.f21398b = (TextView) findViewById(R.id.text1);
            this.f21398b.setInputType(524288);
            this.f21398b.setEllipsize(TextUtils.TruncateAt.END);
            this.f21398b.setTextSize(19.0f);
            this.f21398b.setMaxLines(1);
            this.f21398b.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    CJRActionBarBaseActivity.a(CJRActionBarBaseActivity.this);
                }
            });
            com.paytm.utility.b.d(this.f21398b);
            this.s.a((Drawable) new ColorDrawable(getResources().getColor(R.color.white)));
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onPause() {
        com.paytm.utility.b.u();
        super.onPause();
        a();
    }

    /* access modifiers changed from: protected */
    public final void c() {
        try {
            if (this.f21400e != null) {
                this.l = false;
                if (14 <= com.paytm.utility.b.d() && this.f21400e.isActionViewExpanded()) {
                    this.f21400e.collapseActionView();
                }
                this.f21400e.setVisible(false);
                this.f21404i = false;
                setTitle(this.w);
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                com.paytm.utility.q.c(e2.getMessage());
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void d() {
        MenuItem menuItem = this.f21401f;
        if (menuItem != null) {
            menuItem.setVisible(false);
            this.j = false;
            setTitle(this.w);
            this.m = false;
        }
    }

    public final void a(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getResources().getString(R.string.no_connection));
        builder.setMessage(context.getResources().getString(R.string.no_internet));
        builder.setPositiveButton(context.getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
            }
        });
        builder.show();
    }

    public final void a(Context context, String str) {
        if (context != null || isFinishing()) {
            ProgressDialog progressDialog = this.t;
            if (progressDialog == null || !progressDialog.isShowing()) {
                this.t = new ProgressDialog(context);
                try {
                    this.t.setProgressStyle(0);
                    this.t.setMessage(str);
                    this.t.setCancelable(false);
                    this.t.setCanceledOnTouchOutside(false);
                    this.t.show();
                } catch (IllegalArgumentException e2) {
                    if (com.paytm.utility.b.v) {
                        com.paytm.utility.q.c(e2.getMessage());
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public void a() {
        try {
            if (this.t != null && this.t.isShowing() && !isFinishing()) {
                this.t.dismiss();
                this.t = null;
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public final void e() {
        androidx.appcompat.app.a aVar = this.f21399d;
        if (aVar != null) {
            this.f21403h = true;
            aVar.c();
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.w = charSequence;
            String charSequence2 = charSequence.toString();
            if (charSequence2 != null && charSequence2.length() > 0) {
                charSequence2 = charSequence2.substring(0, 1).toUpperCase() + charSequence2.substring(1);
            }
            TextView textView = this.f21398b;
            if (textView != null) {
                textView.setText(charSequence2);
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onCancel(DialogInterface dialogInterface) {
        a();
    }

    public void onResume() {
        r.a(getApplicationContext()).b("cart_item_qty", 0, true);
        q.a(this);
        super.onResume();
    }

    static /* synthetic */ void a(CJRActionBarBaseActivity cJRActionBarBaseActivity) {
        if (cJRActionBarBaseActivity.f21403h) {
            cJRActionBarBaseActivity.onBackPressed();
        }
    }
}
