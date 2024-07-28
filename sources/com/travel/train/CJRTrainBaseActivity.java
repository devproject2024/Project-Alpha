package com.travel.train;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Html;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.google.android.play.core.splitcompat.a;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.h;
import com.travel.utils.q;
import net.one97.paytm.activity.PaytmActivity;

public abstract class CJRTrainBaseActivity extends PaytmActivity implements DialogInterface.OnCancelListener {
    private String LOG_TAG = "CJRTrainBaseActivity";
    protected ProgressDialog mProgressDialog;

    public void attachBaseContext(Context context) {
        q.a(context);
        b.a();
        super.attachBaseContext(b.b().c(context));
        a.b((Context) this);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        q.a(this);
    }

    public void onResume() {
        super.onResume();
        q.a(this);
    }

    public void showProgressDialog(Context context, String str) {
        if (context != null || isFinishing()) {
            ProgressDialog progressDialog = this.mProgressDialog;
            if (progressDialog == null || !progressDialog.isShowing()) {
                this.mProgressDialog = new ProgressDialog(context);
                try {
                    this.mProgressDialog.setProgressStyle(0);
                    this.mProgressDialog.setMessage(str);
                    this.mProgressDialog.setCancelable(false);
                    this.mProgressDialog.setCanceledOnTouchOutside(false);
                    this.mProgressDialog.show();
                } catch (IllegalArgumentException e2) {
                    if (b.v) {
                        com.paytm.utility.q.c(e2.getMessage());
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public void removeProgressDialog() {
        try {
            if (this.mProgressDialog != null && this.mProgressDialog.isShowing() && !isFinishing()) {
                this.mProgressDialog.dismiss();
                this.mProgressDialog = null;
            }
        } catch (Exception unused) {
        }
    }

    public void showNetworkDialog(final com.paytm.network.a aVar, final String str, final String str2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(Html.fromHtml("<b>" + getResources().getString(R.string.network_retry_yes) + "</b>"), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
                if (b.c((Context) CJRTrainBaseActivity.this)) {
                    CJRTrainBaseActivity cJRTrainBaseActivity = CJRTrainBaseActivity.this;
                    cJRTrainBaseActivity.showProgressDialog(cJRTrainBaseActivity, cJRTrainBaseActivity.getString(R.string.please_wait_progress_msg));
                    aVar.a();
                    return;
                }
                CJRTrainBaseActivity.this.showNetworkDialog(aVar, str, str2);
            }
        });
        builder.setNegativeButton(Html.fromHtml("<b>Back</b>"), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                if (!CJRTrainBaseActivity.this.isFinishing()) {
                    CJRTrainBaseActivity.this.finish();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    public void showErrorDialog(String str, String str2) {
        if (!isFinishing()) {
            final h hVar = new h(this);
            hVar.setTitle(str);
            hVar.setCancelable(false);
            hVar.a(str2);
            hVar.a(-3, getString(R.string.ok), new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.cancel();
                }
            });
            hVar.setOnKeyListener(new DialogInterface.OnKeyListener() {
                public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                    if (i2 != 4) {
                        return true;
                    }
                    dialogInterface.cancel();
                    return true;
                }
            });
            hVar.show();
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            Window window = hVar.getWindow();
            layoutParams.copyFrom(window.getAttributes());
            layoutParams.width = -1;
            layoutParams.height = -2;
            window.setAttributes(layoutParams);
        }
    }

    public void showSessionTimeoutAlert(NetworkCustomError networkCustomError) {
        if (!isFinishing()) {
            b.a();
            b.a((Activity) this, (Exception) networkCustomError);
        }
    }

    public void hideKeyboard() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null && getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        } catch (Exception e2) {
            if (b.v) {
                com.paytm.utility.q.c(e2.getMessage());
            }
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        removeProgressDialog();
    }
}
