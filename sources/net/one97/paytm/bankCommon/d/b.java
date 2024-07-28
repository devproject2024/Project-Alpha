package net.one97.paytm.bankCommon.d;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.google.android.play.core.splitcompat.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankOpen.R;
import net.one97.paytm.i.h;

public abstract class b extends h implements g.a, g.b<IJRPaytmDataModel> {

    /* renamed from: a  reason: collision with root package name */
    protected ProgressDialog f16232a;

    /* renamed from: a */
    public void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
    }

    public final void a(final f fVar) {
        if (getActivity() != null && !isDetached()) {
            final com.paytm.utility.h hVar = new com.paytm.utility.h(getActivity());
            hVar.setTitle(getResources().getString(R.string.no_connection));
            hVar.a(getResources().getString(R.string.no_internet));
            hVar.a(-3, getResources().getString(R.string.network_retry_yes), new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.cancel();
                    if (com.paytm.utility.b.c((Context) b.this.getActivity())) {
                        b.this.getActivity();
                        new c();
                        c.a(fVar);
                        return;
                    }
                    b.this.a(fVar);
                }
            });
            hVar.show();
        }
    }

    public final void a() {
        if (getActivity() != null && !isDetached()) {
            a.a().show(getFragmentManager().a(), "dialog");
        }
    }

    public final void a(Context context, String str) {
        if (getActivity() != null && isAdded()) {
            if (context != null || getActivity().isFinishing()) {
                ProgressDialog progressDialog = this.f16232a;
                if (progressDialog == null || !progressDialog.isShowing()) {
                    this.f16232a = new ProgressDialog(context);
                    try {
                        this.f16232a.setProgressStyle(0);
                        this.f16232a.setMessage(str);
                        this.f16232a.setCancelable(true);
                        this.f16232a.setCanceledOnTouchOutside(true);
                        this.f16232a.show();
                    } catch (IllegalArgumentException e2) {
                        e2.printStackTrace();
                    } catch (Exception unused) {
                    }
                } else {
                    this.f16232a.setMessage(str);
                }
            }
        }
    }

    public void W_() {
        try {
            if (getActivity() == null) {
                return;
            }
            if (!isDetached()) {
                if (this.f16232a != null && this.f16232a.isShowing() && !getActivity().isFinishing()) {
                    this.f16232a.dismiss();
                    this.f16232a = null;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void c() {
        if (getActivity() != null && !isDetached()) {
            try {
                InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
                if (inputMethodManager != null) {
                    inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        a.a((Context) getActivity());
        a.b((Context) getActivity());
    }

    public void onResume() {
        super.onResume();
        a.a((Context) getActivity());
        a.b((Context) getActivity());
    }
}
