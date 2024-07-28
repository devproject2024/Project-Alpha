package com.travel.train.fragment;

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
import com.paytm.network.a;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.travel.train.R;
import com.travel.utils.q;
import net.one97.paytm.i.h;

public class am extends h implements DialogInterface.OnCancelListener {
    private String LOG_TAG = "FJRTravelExtendFragment";
    public ProgressDialog mProgressDialog;

    public boolean onBackPressed() {
        return false;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        q.a(context);
    }

    public void onResume() {
        super.onResume();
        q.a(getActivity());
    }

    /* access modifiers changed from: protected */
    public void showProgressDialog(Context context, String str) {
        if (getActivity() != null && isAdded()) {
            if (context != null || getActivity().isFinishing()) {
                ProgressDialog progressDialog = this.mProgressDialog;
                if (progressDialog == null || !progressDialog.isShowing()) {
                    this.mProgressDialog = new ProgressDialog(context);
                    try {
                        this.mProgressDialog.setProgressStyle(0);
                        this.mProgressDialog.setMessage(str);
                        this.mProgressDialog.setCancelable(true);
                        this.mProgressDialog.setCanceledOnTouchOutside(false);
                        this.mProgressDialog.show();
                    } catch (IllegalArgumentException e2) {
                        com.paytm.utility.q.c(e2.getMessage());
                    } catch (Exception unused) {
                    }
                } else {
                    this.mProgressDialog.setMessage(str);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void removeProgressDialog() {
        ProgressDialog progressDialog;
        if (getActivity() != null && !isDetached() && (progressDialog = this.mProgressDialog) != null && progressDialog.isShowing() && !getActivity().isFinishing()) {
            this.mProgressDialog.dismiss();
            this.mProgressDialog = null;
        }
    }

    public void showNetworkDialog(final a aVar, final String str, final String str2) {
        if (getActivity() != null && !isDetached()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle(str);
            builder.setMessage(str2);
            builder.setPositiveButton(Html.fromHtml("<b>" + getResources().getString(R.string.network_retry_yes) + "</b>"), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.cancel();
                    if (b.c((Context) am.this.getActivity())) {
                        am amVar = am.this;
                        amVar.showProgressDialog(amVar.getActivity(), am.this.getString(R.string.please_wait_progress_msg));
                        aVar.a();
                        return;
                    }
                    am.this.showNetworkDialog(aVar, str, str2);
                }
            });
            builder.setNegativeButton(Html.fromHtml("<b>Back</b>"), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    if (am.this.getActivity() != null && !am.this.getActivity().isFinishing()) {
                        am.this.getActivity().finish();
                    }
                }
            });
            builder.setCancelable(false);
            builder.show();
        }
    }

    public void showNoNetworkDialog() {
        if (getActivity() != null && !isDetached()) {
            com.travel.train.widget.b.a().show(getFragmentManager().a(), "dialog");
        }
    }

    public void showErrorDialog(String str, String str2) {
        if (getActivity() != null && !getActivity().isFinishing()) {
            final com.paytm.utility.h hVar = new com.paytm.utility.h(getActivity());
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

    public void onCancel(DialogInterface dialogInterface) {
        removeProgressDialog();
    }

    public void showSessionTimeoutAlert(NetworkCustomError networkCustomError) {
        if (getActivity() != null && !isDetached() && !getActivity().isFinishing()) {
            com.travel.train.b.a();
            com.travel.train.b.a((Activity) getActivity(), (Exception) networkCustomError);
        }
    }

    public void hideKeyboard() {
        if (getActivity() != null && !isDetached()) {
            try {
                InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
                }
            } catch (Exception e2) {
                com.paytm.utility.q.c(e2.getMessage());
            }
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        q.a(getActivity());
    }
}
