package net.one97.paytm.paymentsBank.fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import com.google.android.play.core.splitcompat.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.utils.f;
import net.one97.paytm.i.h;

public class p extends h implements g.a, g.b<IJRPaytmDataModel> {

    /* renamed from: a  reason: collision with root package name */
    private ProgressDialog f18543a;

    /* renamed from: a */
    public void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
    }

    public final void a(Context context, String str) {
        if (getActivity() != null && isAdded()) {
            if (context != null || getActivity().isFinishing()) {
                ProgressDialog progressDialog = this.f18543a;
                if (progressDialog == null || !progressDialog.isShowing()) {
                    this.f18543a = new ProgressDialog(context);
                    try {
                        this.f18543a.setProgressStyle(0);
                        this.f18543a.setMessage(str);
                        this.f18543a.setCancelable(true);
                        this.f18543a.setCanceledOnTouchOutside(true);
                        this.f18543a.show();
                    } catch (IllegalArgumentException e2) {
                        e2.printStackTrace();
                    } catch (Exception unused) {
                    }
                } else {
                    this.f18543a.setMessage(str);
                }
            }
        }
    }

    public final void q() {
        try {
            if (getActivity() == null) {
                return;
            }
            if (!isDetached()) {
                if (this.f18543a != null && this.f18543a.isShowing() && !getActivity().isFinishing()) {
                    this.f18543a.dismiss();
                    this.f18543a = null;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void r() {
        if (getActivity() != null && !isDetached()) {
            k.a().show(getFragmentManager().a(), "dialog");
        }
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (networkCustomError != null) {
            f.a((Activity) getActivity(), (Exception) networkCustomError, (String) null);
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
