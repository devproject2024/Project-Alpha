package net.one97.paytm.insurance.H5;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import androidx.core.content.b;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.insurance.R;
import net.one97.paytm.insurance.b.c;
import net.one97.paytm.insurance.fourWheeler.utils.a;

public final class InsuranceTransparentActivity extends FragmentActivity {
    public final void onCreate(Bundle bundle) {
        ProgressDialog progressDialog;
        super.onCreate(bundle);
        if (getIntent().getBundleExtra("data") != null && getIntent().getBundleExtra("data").getString("target") != null && getIntent().getBundleExtra("data").getString("target").equals("insOpenCSTScreen")) {
            j supportFragmentManager = getSupportFragmentManager();
            k.a((Object) supportFragmentManager, "supportFragmentManager");
            a aVar = new a(this, supportFragmentManager);
            String obj = getIntent().getBundleExtra("data").get("orderId").toString();
            k.c(obj, "orderId");
            if (aVar.f14033b != null && !aVar.f14033b.isFinishing() && (aVar.f14032a == null || (progressDialog = aVar.f14032a) == null || !progressDialog.isShowing())) {
                aVar.f14032a = new ProgressDialog(aVar.f14033b, R.style.SampleTheme);
                try {
                    ProgressDialog progressDialog2 = aVar.f14032a;
                    if (progressDialog2 != null) {
                        progressDialog2.setIndeterminateDrawable(b.a((Context) aVar.f14033b, R.drawable.ins_custom_progress_bar));
                    }
                    ProgressDialog progressDialog3 = aVar.f14032a;
                    if (progressDialog3 != null) {
                        progressDialog3.setMessage(aVar.f14033b.getString(R.string.ins_please_wait_progress_msg));
                    }
                    ProgressDialog progressDialog4 = aVar.f14032a;
                    if (progressDialog4 != null) {
                        progressDialog4.setCancelable(false);
                    }
                    ProgressDialog progressDialog5 = aVar.f14032a;
                    if (progressDialog5 != null) {
                        progressDialog5.setCanceledOnTouchOutside(false);
                    }
                    ProgressDialog progressDialog6 = aVar.f14032a;
                    if (progressDialog6 != null) {
                        progressDialog6.show();
                    }
                } catch (IllegalArgumentException e2) {
                    if (com.paytm.utility.b.v) {
                        e2.printStackTrace();
                    }
                } catch (Exception unused) {
                }
            }
            StringBuilder sb = new StringBuilder();
            net.one97.paytm.insurance.a.a a2 = c.a();
            k.a((Object) a2, "InsuranceHelper.getInsuranceListener()");
            sb.append(a2.getOrderDetailUrl());
            sb.append(obj);
            String sb2 = sb.toString();
            new com.paytm.network.b().a((Context) aVar.f14033b).a(a.C0715a.GET).a(a.c.INSURANCE).a(com.paytm.utility.b.b((Context) aVar.f14033b, sb2) + "&actions=1").b((String) null).a((Map<String, String>) null).a((IJRPaytmDataModel) new CJROrderSummary()).c("InsurancePostPaymentFragment").a((com.paytm.network.listener.b) aVar).a(a.b.SILENT).l().a();
        }
    }
}
