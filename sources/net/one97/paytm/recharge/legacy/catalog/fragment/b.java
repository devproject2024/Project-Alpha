package net.one97.paytm.recharge.legacy.catalog.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.recharge.common.e.ai;

public abstract class b extends Fragment implements ai {

    /* renamed from: a  reason: collision with root package name */
    private ProgressDialog f62895a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f62896b;

    public void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        k.c(str, "tag");
    }

    public void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        k.c(str, "tag");
    }

    /* access modifiers changed from: protected */
    public void a(Context context, String str) {
        k.c(str, "message");
        if (getActivity() != null && isAdded()) {
            if (context == null) {
                FragmentActivity activity = getActivity();
                if (activity == null) {
                    k.a();
                }
                k.a((Object) activity, "activity!!");
                if (!activity.isFinishing()) {
                    return;
                }
            }
            ProgressDialog progressDialog = this.f62895a;
            if (progressDialog == null || !progressDialog.isShowing()) {
                this.f62895a = new ProgressDialog(context);
                try {
                    ProgressDialog progressDialog2 = this.f62895a;
                    if (progressDialog2 != null) {
                        progressDialog2.setProgressStyle(0);
                        progressDialog2.setMessage(str);
                        progressDialog2.setCancelable(true);
                        progressDialog2.setCanceledOnTouchOutside(true);
                        progressDialog2.show();
                    }
                } catch (IllegalArgumentException e2) {
                    q.d(e2.getMessage());
                } catch (Exception unused) {
                }
            } else {
                ProgressDialog progressDialog3 = this.f62895a;
                if (progressDialog3 != null) {
                    progressDialog3.setMessage(str);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void r() {
        try {
            if (getActivity() == null) {
                return;
            }
            if (!isDetached()) {
                ProgressDialog progressDialog = this.f62895a;
                if (progressDialog != null && progressDialog.isShowing()) {
                    FragmentActivity activity = getActivity();
                    if (activity == null) {
                        k.a();
                    }
                    k.a((Object) activity, "activity!!");
                    if (!activity.isFinishing()) {
                        ProgressDialog progressDialog2 = this.f62895a;
                        if (progressDialog2 != null) {
                            progressDialog2.dismiss();
                        }
                        this.f62895a = null;
                    }
                }
            }
        } catch (Exception e2) {
            q.d(e2.getMessage());
        }
    }

    public final void s() {
        if (getActivity() != null && !isDetached()) {
            try {
                FragmentActivity activity = getActivity();
                if (activity == null) {
                    k.a();
                }
                Object systemService = activity.getSystemService("input_method");
                if (systemService != null) {
                    InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                    if (inputMethodManager != null) {
                        FragmentActivity activity2 = getActivity();
                        if (activity2 == null) {
                            k.a();
                        }
                        k.a((Object) activity2, "activity!!");
                        View currentFocus = activity2.getCurrentFocus();
                        if (currentFocus == null) {
                            k.a();
                        }
                        k.a((Object) currentFocus, "activity!!.currentFocus!!");
                        inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                        return;
                    }
                    return;
                }
                throw new u("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            } catch (Exception e2) {
                q.d(e2.getMessage());
            }
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f62896b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
