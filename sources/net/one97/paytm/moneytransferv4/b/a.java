package net.one97.paytm.moneytransferv4.b;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.h;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;

public class a extends h {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f55180a;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f55181d = true;

    public void c() {
        HashMap hashMap = this.f55180a;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        c();
    }

    public final void a(UpiCustomVolleyError upiCustomVolleyError) {
        String str;
        if (upiCustomVolleyError == null || (str = upiCustomVolleyError.getmErrorCode()) == null) {
            str = "";
        }
        if (TextUtils.isEmpty(str) || !k.a((Object) UpiConstants.NETWORK_ERROR_CODE, (Object) str)) {
            Toast.makeText(getContext(), R.string.upi_some_went_wrong, 1).show();
        } else {
            CustomDialog.showAlert(getContext(), getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
        }
    }

    public void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (!UpiAppUtils.isNetworkAvailable(context) && this.f55181d) {
            CustomDialog.showAlert(context, getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
        }
    }
}
