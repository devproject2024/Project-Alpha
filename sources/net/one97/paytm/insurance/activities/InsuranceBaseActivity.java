package net.one97.paytm.insurance.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.google.android.play.core.splitcompat.a;
import com.paytm.utility.b;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.utility.l;
import net.one97.paytm.insurance.b.c;

public class InsuranceBaseActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private ProgressDialog f13986a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f13987b;

    public View a(int i2) {
        if (this.f13987b == null) {
            this.f13987b = new HashMap();
        }
        View view = (View) this.f13987b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f13987b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void attachBaseContext(Context context) {
        k.c(context, "newBase");
        super.attachBaseContext(c.a().getBaseContext(context));
        a.a((Context) this);
    }

    public final void a(Context context, String str) {
        k.c(str, "message");
        ProgressDialog progressDialog = this.f13986a;
        if (progressDialog != null) {
            if (progressDialog == null) {
                k.a();
            }
            if (progressDialog.isShowing()) {
                return;
            }
        }
        this.f13986a = new ProgressDialog(context);
        try {
            ProgressDialog progressDialog2 = this.f13986a;
            if (progressDialog2 == null) {
                k.a();
            }
            progressDialog2.setProgressStyle(0);
            ProgressDialog progressDialog3 = this.f13986a;
            if (progressDialog3 == null) {
                k.a();
            }
            progressDialog3.setMessage(str);
            ProgressDialog progressDialog4 = this.f13986a;
            if (progressDialog4 == null) {
                k.a();
            }
            progressDialog4.setCancelable(false);
            ProgressDialog progressDialog5 = this.f13986a;
            if (progressDialog5 == null) {
                k.a();
            }
            progressDialog5.setCanceledOnTouchOutside(false);
            ProgressDialog progressDialog6 = this.f13986a;
            if (progressDialog6 == null) {
                k.a();
            }
            progressDialog6.show();
        } catch (IllegalArgumentException e2) {
            if (b.v) {
                e2.printStackTrace();
            }
        } catch (Exception unused) {
        }
    }

    public final void d() {
        try {
            if (this.f13986a != null) {
                ProgressDialog progressDialog = this.f13986a;
                if (progressDialog == null) {
                    k.a();
                }
                if (progressDialog.isShowing() && !isFinishing()) {
                    ProgressDialog progressDialog2 = this.f13986a;
                    if (progressDialog2 == null) {
                        k.a();
                    }
                    progressDialog2.dismiss();
                    this.f13986a = null;
                }
            }
        } catch (Exception e2) {
            l.a((Throwable) e2);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        ProgressDialog progressDialog = this.f13986a;
        if (progressDialog != null) {
            if (progressDialog == null) {
                k.a();
            }
            if (progressDialog.isShowing()) {
                ProgressDialog progressDialog2 = this.f13986a;
                if (progressDialog2 == null) {
                    k.a();
                }
                progressDialog2.dismiss();
            }
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        k.c(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (!(inputMethodManager == null || getCurrentFocus() == null)) {
                View currentFocus = getCurrentFocus();
                if (currentFocus == null) {
                    k.a();
                }
                inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            onBackPressed();
            return true;
        } catch (IllegalStateException unused) {
            return true;
        }
    }
}
