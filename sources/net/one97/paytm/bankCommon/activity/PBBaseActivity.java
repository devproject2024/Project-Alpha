package net.one97.paytm.bankCommon.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.google.android.play.core.splitcompat.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.h;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankOpen.f;
import net.one97.paytm.common.assets.R;

public class PBBaseActivity extends PaytmActivity implements g.a, g.b<IJRPaytmDataModel> {

    /* renamed from: a  reason: collision with root package name */
    protected ProgressDialog f16190a;

    /* renamed from: a_ */
    public void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
    }

    public void attachBaseContext(Context context) {
        if (f.d()) {
            super.attachBaseContext(context);
            return;
        }
        super.attachBaseContext(f.a().getBaseContext(context));
        a.a((Context) this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (f.d()) {
            finish();
        }
    }

    public void a(Context context, String str) {
        if (context != null || isFinishing()) {
            ProgressDialog progressDialog = this.f16190a;
            if (progressDialog == null || !progressDialog.isShowing()) {
                this.f16190a = new ProgressDialog(context);
                try {
                    this.f16190a.setProgressStyle(0);
                    this.f16190a.setMessage(str);
                    this.f16190a.setCancelable(false);
                    this.f16190a.setCanceledOnTouchOutside(false);
                    this.f16190a.show();
                } catch (IllegalArgumentException e2) {
                    if (b.v) {
                        e2.printStackTrace();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public void ah_() {
        try {
            if (this.f16190a != null && this.f16190a.isShowing() && !isFinishing()) {
                this.f16190a.dismiss();
                this.f16190a = null;
            }
        } catch (Exception unused) {
        }
    }

    public final void ag_() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().b(true);
            getSupportActionBar().e(R.drawable.back_arrow);
            getSupportActionBar().a(true);
            getSupportActionBar().a((Drawable) new ColorDrawable(getResources().getColor(net.one97.paytm.bankOpen.R.color.white)));
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        c();
        try {
            onBackPressed();
            return true;
        } catch (IllegalStateException unused) {
            return true;
        }
    }

    public final void c() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null && getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void d() {
        if (!isFinishing()) {
            net.one97.paytm.bankCommon.d.a.a().show(getSupportFragmentManager().a(), "dialog");
        }
    }

    public void a(final net.one97.paytm.bankCommon.g.f fVar) {
        if (!isFinishing()) {
            final h hVar = new h(this);
            hVar.setTitle(getResources().getString(net.one97.paytm.bankOpen.R.string.no_connection));
            hVar.a(getResources().getString(net.one97.paytm.bankOpen.R.string.no_internet));
            hVar.a(-3, getResources().getString(net.one97.paytm.bankOpen.R.string.network_retry_yes), new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.cancel();
                    if (b.c((Context) PBBaseActivity.this)) {
                        new c();
                        c.a(fVar);
                        return;
                    }
                    PBBaseActivity.this.a(fVar);
                }
            });
            hVar.show();
        }
    }
}
