package net.one97.paytm.o2o.amusementpark.c;

import android.text.TextUtils;
import android.widget.ProgressBar;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.i.h;
import net.one97.paytm.o2o.amusementpark.a;

public abstract class d extends h implements b {

    /* renamed from: b  reason: collision with root package name */
    protected ProgressBar f73548b;

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
    }

    public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel, String str2) {
        if (getActivity() != null && !isDetached()) {
            if (TextUtils.isEmpty(str) || !str.equalsIgnoreCase("nolink")) {
                if (this.f73548b != null) {
                    if (!(str != null && (str.equalsIgnoreCase("wallet-pay") || str.equalsIgnoreCase("wallet-lifafa") || str.equalsIgnoreCase("wallet-passbook") || str.equalsIgnoreCase("wallet-addmoney") || str.equalsIgnoreCase("wallet-acceptpayment") || str.equalsIgnoreCase("wallet-nearby") || str.equalsIgnoreCase("wallet-moneytransfer") || str.equalsIgnoreCase("wallet-upi") || str.equalsIgnoreCase("wallet-kyc")))) {
                        this.f73548b.setVisibility(0);
                    }
                }
                a.a().loadPage(getActivity(), str, (CJRItem) iJRPaytmDataModel, (String) null, 0, (ArrayList<? extends CJRItem>) null, false, str2);
            }
        }
    }
}
