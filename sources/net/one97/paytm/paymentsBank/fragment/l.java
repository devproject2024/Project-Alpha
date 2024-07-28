package net.one97.paytm.paymentsBank.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.i.h;
import net.one97.paytm.paymentsBank.R;

public abstract class l extends h implements g.a, g.b<IJRPaytmDataModel> {

    /* renamed from: b  reason: collision with root package name */
    protected ProgressDialog f18527b;

    /* renamed from: a */
    public void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
    }

    public final void a(f fVar) {
        if (getActivity() != null && !isDetached()) {
            com.paytm.utility.h hVar = new com.paytm.utility.h(getActivity());
            hVar.setTitle(getResources().getString(R.string.no_connection));
            hVar.a(getResources().getString(R.string.no_internet));
            hVar.a(-3, getResources().getString(R.string.network_retry_yes), new View.OnClickListener(hVar, fVar) {
                private final /* synthetic */ com.paytm.utility.h f$1;
                private final /* synthetic */ f f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    l.this.a(this.f$1, this.f$2, view);
                }
            });
            hVar.show();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(com.paytm.utility.h hVar, f fVar, View view) {
        hVar.cancel();
        if (b.c((Context) getActivity())) {
            getActivity();
            new c();
            c.a(fVar);
            return;
        }
        a(fVar);
    }

    /* access modifiers changed from: protected */
    public final void a(Context context, String str) {
        if (getActivity() != null && isAdded()) {
            if (context != null || getActivity().isFinishing()) {
                ProgressDialog progressDialog = this.f18527b;
                if (progressDialog == null || !progressDialog.isShowing()) {
                    this.f18527b = new ProgressDialog(context);
                    try {
                        this.f18527b.setProgressStyle(0);
                        this.f18527b.setMessage(str);
                        this.f18527b.setCancelable(true);
                        this.f18527b.setCanceledOnTouchOutside(true);
                        this.f18527b.show();
                    } catch (IllegalArgumentException e2) {
                        e2.printStackTrace();
                    } catch (Exception unused) {
                    }
                } else {
                    this.f18527b.setMessage(str);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void c() {
        try {
            if (getActivity() == null) {
                return;
            }
            if (!isDetached()) {
                if (this.f18527b != null && this.f18527b.isShowing() && !getActivity().isFinishing()) {
                    this.f18527b.dismiss();
                    this.f18527b = null;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void d() {
        if (getActivity() != null && !isDetached()) {
            try {
                InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
