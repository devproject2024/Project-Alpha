package net.one97.paytm.insurance.fourWheeler.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.j;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.insurance.common.a.a;

public final class a implements b, net.one97.paytm.insurance.H5.b {

    /* renamed from: a  reason: collision with root package name */
    public ProgressDialog f14032a;

    /* renamed from: b  reason: collision with root package name */
    public Activity f14033b;

    /* renamed from: c  reason: collision with root package name */
    private net.one97.paytm.insurance.common.a.a f14034c;

    /* renamed from: d  reason: collision with root package name */
    private j f14035d;

    public a(Activity activity, j jVar) {
        k.c(activity, "activity");
        k.c(jVar, "supportFragmentManager");
        this.f14033b = activity;
        this.f14035d = jVar;
    }

    public final void a() {
        Activity activity = this.f14033b;
        if (activity != null) {
            activity.finish();
        }
    }

    private final void b() {
        Activity activity;
        ProgressDialog progressDialog = this.f14032a;
        if (progressDialog != null && progressDialog != null && progressDialog.isShowing() && (activity = this.f14033b) != null && !activity.isFinishing()) {
            ProgressDialog progressDialog2 = this.f14032a;
            if (progressDialog2 != null) {
                progressDialog2.dismiss();
            }
            this.f14032a = null;
        }
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        b();
        if (iJRPaytmDataModel instanceof CJROrderSummary) {
            a.C0191a aVar = net.one97.paytm.insurance.common.a.a.f13991c;
            this.f14034c = a.C0191a.a((CJROrderSummary) iJRPaytmDataModel);
            net.one97.paytm.insurance.common.a.a aVar2 = this.f14034c;
            if (aVar2 != null) {
                net.one97.paytm.insurance.H5.b bVar = this;
                k.c(bVar, "needHelpTransparentActivityListener");
                aVar2.f13993b = bVar;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("isFromH5", true);
            net.one97.paytm.insurance.common.a.a aVar3 = this.f14034c;
            if (aVar3 != null) {
                aVar3.setArguments(bundle);
            }
            net.one97.paytm.insurance.common.a.a aVar4 = this.f14034c;
            if (aVar4 != null) {
                aVar4.a((Context) this.f14033b, this.f14035d);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001a, code lost:
        r8 = r9.getMessage();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleErrorCode(int r7, com.paytm.network.model.IJRPaytmDataModel r8, com.paytm.network.model.NetworkCustomError r9) {
        /*
            r6 = this;
            r6.b()
            r7 = 1
            if (r9 == 0) goto L_0x0018
            java.lang.String r8 = r9.getMessage()
            if (r8 == 0) goto L_0x0018
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            java.lang.String r0 = "401"
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r8 = kotlin.m.p.a((java.lang.CharSequence) r8, (java.lang.CharSequence) r0, (boolean) r7)
            if (r8 == r7) goto L_0x0038
        L_0x0018:
            if (r9 == 0) goto L_0x002f
            java.lang.String r8 = r9.getMessage()
            if (r8 == 0) goto L_0x002f
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            java.lang.String r0 = "410"
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r7 = kotlin.m.p.a((java.lang.CharSequence) r8, (java.lang.CharSequence) r0, (boolean) r7)
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            goto L_0x0030
        L_0x002f:
            r7 = 0
        L_0x0030:
            java.lang.Boolean r8 = java.lang.Boolean.TRUE
            boolean r7 = kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 == 0) goto L_0x0053
        L_0x0038:
            net.one97.paytm.insurance.a.a r7 = net.one97.paytm.insurance.b.c.a()
            java.lang.String r8 = "InsuranceHelper.getInsuranceListener()"
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)
            java.lang.String r3 = r7.getLandingActivityClassName()
            net.one97.paytm.insurance.a.a r0 = net.one97.paytm.insurance.b.c.a()
            android.app.Activity r1 = r6.f14033b
            r4 = 0
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
            r2 = r9
            r0.handleError(r1, r2, r3, r4, r5)
            goto L_0x0063
        L_0x0053:
            android.app.Activity r7 = r6.f14033b
            r8 = r7
            android.content.Context r8 = (android.content.Context) r8
            int r9 = net.one97.paytm.insurance.R.string.oops_something_went_wrong
            java.lang.String r7 = r7.getString(r9)
            java.lang.String r9 = "Error"
            com.paytm.utility.b.b((android.content.Context) r8, (java.lang.String) r9, (java.lang.String) r7)
        L_0x0063:
            android.app.Activity r7 = r6.f14033b
            r7.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.insurance.fourWheeler.utils.a.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void");
    }
}
