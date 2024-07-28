package com.travel.flight.d;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.paytm.network.a;
import com.travel.flight.R;
import com.travel.flight.f.c;
import com.travel.flight.flightorder.widget.EditView;
import com.travel.utils.q;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.shopping.CJRCatalog;
import net.one97.paytm.i.h;

public abstract class b extends h implements Response.ErrorListener, Response.Listener<IJRDataModel>, EditView.a {
    protected CJRCatalog mCatalog;
    protected ProgressDialog mProgressDialog;
    private c mUserChangeListener;

    public void onErrorResponse(VolleyError volleyError) {
    }

    public void onResponse(IJRDataModel iJRDataModel) {
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof c) {
            this.mUserChangeListener = (c) activity;
        }
        if (getArguments() != null && getArguments().getSerializable("CACHED_CATALOG_DATA") != null) {
            this.mCatalog = (CJRCatalog) getArguments().getSerializable("CACHED_CATALOG_DATA");
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        q.a(context);
    }

    public void showNetworkDialogNew(final a aVar) {
        if (getActivity() != null && !isDetached()) {
            final com.paytm.utility.h hVar = new com.paytm.utility.h(getActivity());
            hVar.setTitle(getResources().getString(R.string.no_connection));
            hVar.a(getResources().getString(R.string.no_internet));
            hVar.a(-3, getResources().getString(R.string.network_retry_yes), new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.cancel();
                    if (com.paytm.utility.b.c((Context) b.this.getActivity())) {
                        aVar.a();
                    } else {
                        b.this.showNetworkDialogNew(aVar);
                    }
                }
            });
            hVar.show();
        }
    }

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
                        this.mProgressDialog.setCanceledOnTouchOutside(true);
                        this.mProgressDialog.show();
                    } catch (Exception | IllegalArgumentException unused) {
                    }
                } else {
                    this.mProgressDialog.setMessage(str);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void removeProgressDialog() {
        try {
            if (getActivity() == null) {
                return;
            }
            if (!isDetached()) {
                if (this.mProgressDialog != null && this.mProgressDialog.isShowing() && !getActivity().isFinishing()) {
                    this.mProgressDialog.dismiss();
                    this.mProgressDialog = null;
                }
            }
        } catch (Exception unused) {
        }
    }

    public void onResume() {
        super.onResume();
        q.a(getActivity());
    }

    public void onActivityResult(int i2, Intent intent) {
        q.a(getActivity());
    }

    public void onDestroy() {
        super.onDestroy();
        this.mUserChangeListener = null;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.mUserChangeListener = null;
    }
}
