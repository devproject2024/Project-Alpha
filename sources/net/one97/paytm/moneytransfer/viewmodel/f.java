package net.one97.paytm.moneytransfer.viewmodel;

import android.app.Application;
import androidx.lifecycle.y;
import com.appsflyer.internal.referrer.Payload;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.moneytransfer.b.a.b;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountBalanceModel;
import net.one97.paytm.upi.common.upi.CJRAccountSummary;
import net.one97.paytm.upi.profile.b.a;

public final class f extends androidx.lifecycle.a {

    /* renamed from: a  reason: collision with root package name */
    public b f54753a;

    /* renamed from: b  reason: collision with root package name */
    public y<String> f54754b = new y<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(Application application) {
        super(application);
        k.c(application, "application");
        this.f54753a = net.one97.paytm.moneytransfer.b.a(application);
    }

    public static final class a implements a.C1382a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f54755a;

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            k.c(upiCustomVolleyError, "upiCustomVolleyError");
        }

        public a(f fVar) {
            this.f54755a = fVar;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof CJRAccountSummary) {
                CJRAccountSummary cJRAccountSummary = (CJRAccountSummary) upiBaseDataModel;
                if (cJRAccountSummary.getStatus() != null) {
                    String status = cJRAccountSummary.getStatus();
                    Boolean valueOf = status != null ? Boolean.valueOf(p.a(status, "success", true)) : null;
                    if (valueOf == null) {
                        k.a();
                    }
                    if (valueOf.booleanValue()) {
                        AccountBalanceModel accountBalanceModel = cJRAccountSummary.getAccounts().get(0);
                        y a2 = this.f54755a.f54754b;
                        if (a2 != null) {
                            k.a((Object) accountBalanceModel, "account");
                            a2.setValue(String.valueOf(accountBalanceModel.getEffectiveBalance()));
                        }
                    }
                }
            }
        }
    }
}
