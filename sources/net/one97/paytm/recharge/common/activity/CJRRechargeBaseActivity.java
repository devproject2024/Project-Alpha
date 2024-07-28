package net.one97.paytm.recharge.common.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.paytm.utility.v;
import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.auth.LogoutModel;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.aa;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.e.y;
import net.one97.paytm.recharge.common.f.a;
import net.one97.paytm.recharge.common.utils.RechargeIconMenuView;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.utils.r;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.di.helper.c;
import net.one97.paytm.recharge.legacy.catalog.activity.AJRRechargeActivity;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;
import net.one97.paytm.widget.EditView;

public abstract class CJRRechargeBaseActivity extends PaytmActivity implements DialogInterface.OnCancelListener, ai, y, RechargeIconMenuView.a, EditView.a {

    /* renamed from: a  reason: collision with root package name */
    private final int f60857a = 45;

    /* renamed from: b  reason: collision with root package name */
    private TextView f60858b;

    /* renamed from: c  reason: collision with root package name */
    private MenuItem f60859c;

    /* renamed from: d  reason: collision with root package name */
    private MenuItem f60860d;

    /* renamed from: e  reason: collision with root package name */
    private Toolbar f60861e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f60862f = true;

    /* renamed from: g  reason: collision with root package name */
    private boolean f60863g = false;
    public ActionBar p;
    protected ProgressDialog q;
    protected CharSequence r;
    protected boolean s;
    protected final r t = new r();

    public abstract void a();

    public void az_() {
    }

    public Fragment b(int i2) {
        return null;
    }

    public void e() {
    }

    public void g() {
    }

    public void h() {
    }

    public void j() {
    }

    public void k() {
    }

    /* access modifiers changed from: protected */
    public int m() {
        return -1;
    }

    public void onEditViewClick(View view) {
    }

    public void onIconMenuClick(View view) {
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(CJRRechargeUtilities.INSTANCE.getRestringValue(context));
    }

    public void onCreate(Bundle bundle) {
        b.e((Activity) this);
        super.onCreate(bundle);
        this.f60863g = true;
        n();
        int m = m();
        if (m != -1) {
            setTheme(m);
        }
        CJRRechargeUtilities.INSTANCE.dropBreadCrumb(getClass().getSimpleName(), bundle == null ? "Activity Created" : "Activity Recreated");
    }

    public void onStart() {
        if (this.f60863g) {
            a();
            this.f60863g = false;
        }
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void n() {
        b.f((Context) this);
        this.p = getSupportActionBar();
        ActionBar actionBar = this.p;
        if (actionBar != null) {
            actionBar.b(true);
            this.p.c(false);
            this.p.a(true);
            this.p.b();
            this.p.a(R.layout.recharge_action_bar_title);
            this.p.a(2.0f);
            this.f60858b = (TextView) findViewById(R.id.text1);
            this.f60858b.setInputType(524288);
            this.f60858b.setEllipsize(TextUtils.TruncateAt.END);
            this.f60858b.setTextSize(19.0f);
            this.f60858b.setMaxLines(1);
            this.f60858b.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    CJRRechargeBaseActivity.a(CJRRechargeBaseActivity.this);
                }
            });
            b.d(this.f60858b);
            this.p.a((Drawable) new ColorDrawable(getResources().getColor(R.color.white)));
        }
    }

    public void onPause() {
        b.u();
        super.onPause();
        o();
    }

    public final void a(a aVar) {
        ba.a(aVar, (Context) this, (DialogInterface.OnCancelListener) this, (aa) null);
    }

    public void a(Context context, String str) {
        if (context != null || isFinishing()) {
            ProgressDialog progressDialog = this.q;
            if (progressDialog == null || !progressDialog.isShowing()) {
                this.q = new ProgressDialog(context);
                try {
                    this.q.setProgressStyle(0);
                    this.q.setMessage(str);
                    this.q.setCancelable(false);
                    this.q.setCanceledOnTouchOutside(false);
                    this.q.show();
                } catch (IllegalArgumentException e2) {
                    q.d(e2.getMessage());
                } catch (Exception unused) {
                }
            }
        }
    }

    public void o() {
        try {
            if (this.q != null && this.q.isShowing() && !isFinishing()) {
                this.q.dismiss();
                this.q = null;
            }
        } catch (Exception e2) {
            CJRRechargeUtilities.INSTANCE.debugLogExceptions(e2);
        }
    }

    /* access modifiers changed from: protected */
    public final void p() {
        this.s = true;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.recharge_action_bar_menu, menu);
        this.f60860d = menu.findItem(R.id.action_edit);
        EditView editView = (EditView) this.f60860d.getActionView();
        r rVar = this.t;
        rVar.f61725a = this;
        rVar.f61728d = editView;
        rVar.f61726b = b.f((Context) rVar.f61725a);
        rVar.f61727c = rVar.f61726b / 2;
        editView.setMainLayoutBackground(0);
        editView.setEditTextVisibility(0);
        new ActionBar.LayoutParams(-1, -2).height = rVar.f61726b * 1;
        editView.setMainLayoutParams(rVar.f61726b * 1, (rVar.f61725a == null || rVar.f61725a.getSupportActionBar() == null) ? 0 : rVar.f61725a.getSupportActionBar().d());
        editView.setEditTextMargin(0, rVar.f61726b / 8, rVar.f61726b / 8, 0);
        editView.setOnEditViewClickListener(rVar.f61725a);
        r rVar2 = this.t;
        if (rVar2.f61728d != null) {
            rVar2.f61728d.setEditTextVisibility(8);
        }
        this.f60859c = menu.findItem(R.id.action_bbps);
        r rVar3 = this.t;
        RechargeIconMenuView rechargeIconMenuView = (RechargeIconMenuView) this.f60859c.getActionView();
        rVar3.f61729e = rechargeIconMenuView;
        b.f((Context) rVar3.f61725a);
        rechargeIconMenuView.setLayoutParams(new ActionBar.LayoutParams(b.c(65), b.c(16)));
        if (rVar3.f61729e != null) {
            rVar3.f61729e.setIconMenuVisibility(8);
            rVar3.f61729e.setIconMenuViewClickListener(rVar3.f61725a);
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            q();
            try {
                onBackPressed();
            } catch (IllegalStateException unused) {
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.r = charSequence;
            int i2 = 45;
            if (this.f60862f) {
                i2 = 40;
            }
            String charSequence2 = charSequence.toString();
            if (charSequence2 != null && charSequence2.length() > 0) {
                charSequence2 = charSequence2.substring(0, 1).toUpperCase() + charSequence2.substring(1);
            }
            if (this instanceof AJRRechargeUtilityActivity) {
                this.f60858b.setText(charSequence2);
                this.f60858b.setTextSize(2, 17.0f);
            } else if (this instanceof AJRRechargeActivity) {
                this.f60858b.setTextSize(2, 17.0f);
            }
            if (charSequence2.length() > i2) {
                charSequence2 = charSequence2.substring(0, i2 - 3);
                if (charSequence2.trim().length() > 0) {
                    charSequence2 = charSequence2 + AppConstants.DOTS;
                }
            }
            TextView textView = this.f60858b;
            if (textView != null) {
                textView.setText(charSequence2);
            }
        }
    }

    public final void q() {
        try {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: protected */
    public final void b(boolean z) {
        MenuItem menuItem = this.f60859c;
        if (menuItem != null) {
            menuItem.setVisible(z);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean r() {
        MenuItem menuItem = this.f60859c;
        return menuItem != null && menuItem.isVisible();
    }

    public void onCancel(DialogInterface dialogInterface) {
        o();
    }

    public void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        LogoutModel logoutModel;
        if ((iJRPaytmDataModel instanceof LogoutModel) && (logoutModel = (LogoutModel) iJRPaytmDataModel) != null && !isFinishing()) {
            if (logoutModel.isLoggedOut()) {
                a((NetworkCustomError) null);
                return;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            String string = getResources().getString(R.string.retry);
            builder.setTitle(string).setMessage(getResources().getString(R.string.please_retry_now)).setCancelable(false);
            builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.cancel();
                }
            });
            builder.show();
        }
    }

    public void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        if (networkCustomError != null && !v.a(networkCustomError.getFullUrl())) {
            c cVar = c.f62654a;
            String aT = c.aT();
            if (!TextUtils.isEmpty(aT) && networkCustomError.getFullUrl().contains(aT) && !isFinishing()) {
                a(networkCustomError);
            }
        }
    }

    private void a(final NetworkCustomError networkCustomError) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String string = getResources().getString(R.string.title_401_410);
        builder.setTitle(string).setMessage(getResources().getString(R.string.message_401_410)).setCancelable(false);
        builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
                CJRRechargeBaseActivity.a(CJRRechargeBaseActivity.this, networkCustomError);
            }
        });
        builder.show();
    }

    public final void s() {
        if (!TextUtils.isEmpty(CJRRechargeUtilities.INSTANCE.getSSOToken(getApplicationContext()))) {
            c cVar = c.f62654a;
            String aT = c.aT();
            HashMap hashMap = new HashMap();
            hashMap.put("Authorization", b.m());
            hashMap.put(StringSet.token, CJRRechargeUtilities.INSTANCE.getSSOToken(getApplicationContext()));
            LogoutModel logoutModel = new LogoutModel();
            d dVar = d.f64967a;
            net.one97.paytm.recharge.common.f.c cVar2 = new net.one97.paytm.recharge.common.f.c("logout_api", aT, (ai) this, (IJRPaytmDataModel) logoutModel, (Map<String, String>) null, (Map<String, String>) hashMap, (String) null, (Object) d.a(ACTION_TYPE.LOGOUT, ERROR_TYPE.UNDEFINED));
            getApplicationContext();
            net.one97.paytm.recharge.common.f.d.a();
            net.one97.paytm.recharge.common.f.d.b(cVar2);
        } else if (!isFinishing()) {
            a((NetworkCustomError) null);
        }
    }

    public final void t() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.error_title_dont_keep_activities));
        builder.setMessage(getResources().getString(R.string.error_message_dont_keep_activities));
        builder.setPositiveButton(getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
                CJRRechargeBaseActivity.b(CJRRechargeBaseActivity.this);
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
            }
        });
        builder.show();
    }

    public void b(String str) {
        Toolbar toolbar = this.f60861e;
        if (toolbar != null) {
            toolbar.setVisibility(0);
            this.f60861e.setTitle((CharSequence) str);
        }
    }

    public void i() {
        Toolbar toolbar = this.f60861e;
        if (toolbar != null) {
            toolbar.setVisibility(0);
        }
    }

    static /* synthetic */ void a(CJRRechargeBaseActivity cJRRechargeBaseActivity) {
        if (cJRRechargeBaseActivity.s) {
            cJRRechargeBaseActivity.onBackPressed();
        }
    }

    static /* synthetic */ void a(CJRRechargeBaseActivity cJRRechargeBaseActivity, NetworkCustomError networkCustomError) {
        CJRRechargeUtilities.INSTANCE.signOut(cJRRechargeBaseActivity, true, networkCustomError);
        net.one97.paytm.recharge.di.helper.a aVar = net.one97.paytm.recharge.di.helper.a.f62650a;
        Intent intent = new Intent(cJRRechargeBaseActivity, net.one97.paytm.recharge.di.helper.a.b());
        intent.putExtra("authError", true);
        intent.putExtra("VERTICAL_NAME", "Recharge");
        cJRRechargeBaseActivity.startActivityForResult(intent, 3);
    }

    static /* synthetic */ void b(CJRRechargeBaseActivity cJRRechargeBaseActivity) {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS");
            intent.setFlags(1073741824);
            cJRRechargeBaseActivity.startActivity(intent);
        } catch (Exception unused) {
        }
    }
}
