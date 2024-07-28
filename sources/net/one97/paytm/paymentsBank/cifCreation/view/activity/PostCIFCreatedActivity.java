package net.one97.paytm.paymentsBank.cifCreation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.h.u;
import com.appsflyer.internal.referrer.Payload;
import com.google.android.material.snackbar.Snackbar;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.CustProductList;
import net.one97.paytm.bankCommon.model.PBTncData;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.cifCreation.CIFBaseActivity;
import net.one97.paytm.paymentsBank.cifCreation.a.a;
import net.one97.paytm.paymentsBank.cifCreation.model.CIFCreationResponse;
import net.one97.paytm.paymentsBank.cifCreation.model.CIFStatusResponse;
import net.one97.paytm.paymentsBank.cifCreation.view.a.b;
import net.one97.paytm.paymentsBank.createfd.activity.CreateFdActivity;
import net.one97.paytm.paymentsBank.model.slfd.SlfdMetaApiResponseModel;
import net.one97.paytm.paymentsBank.slfd.c;
import net.one97.paytm.paymentsBank.slfd.common.view.d;
import net.one97.paytm.paymentsBank.utils.j;
import net.one97.paytm.paymentsBank.utils.o;

public final class PostCIFCreatedActivity extends CIFBaseActivity implements View.OnClickListener, a.b, b.a {

    /* renamed from: b  reason: collision with root package name */
    public a.C0295a f18050b;

    /* renamed from: c  reason: collision with root package name */
    private final String f18051c = "custProductListApi";

    /* renamed from: d  reason: collision with root package name */
    private View f18052d;

    /* renamed from: e  reason: collision with root package name */
    private ProgressBar f18053e;

    /* renamed from: f  reason: collision with root package name */
    private int f18054f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f18055g;

    public final View a(int i2) {
        if (this.f18055g == null) {
            this.f18055g = new HashMap();
        }
        View view = (View) this.f18055g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f18055g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a(ArrayList<PBTncData> arrayList) {
        k.c(arrayList, "mTncDataList");
    }

    public final void a(CIFCreationResponse cIFCreationResponse) {
        k.c(cIFCreationResponse, "cifCreationResponse");
    }

    public final void a(CIFStatusResponse cIFStatusResponse) {
        k.c(cIFStatusResponse, "cifBottomSheetResponse");
    }

    public final void a(SlfdMetaApiResponseModel slfdMetaApiResponseModel) {
        k.c(slfdMetaApiResponseModel, "slfdMetaApiResponse");
    }

    public final void b(boolean z) {
    }

    public final void f() {
    }

    public final void h() {
    }

    private a.C0295a g() {
        a.C0295a aVar = this.f18050b;
        if (aVar == null) {
            k.a("presenter");
        }
        return aVar;
    }

    public final int e() {
        return R.layout.activity_post_cif_created;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c cVar = c.f18958a;
        Context applicationContext = getApplicationContext();
        k.a((Object) applicationContext, "applicationContext");
        a.C0295a aVar = new net.one97.paytm.paymentsBank.cifCreation.b.a(c.a(applicationContext), this);
        k.c(aVar, "<set-?>");
        this.f18050b = aVar;
        View.OnClickListener onClickListener = this;
        ((ImageView) a(R.id.iv_back_arrow)).setOnClickListener(onClickListener);
        View findViewById = findViewById(R.id.pb_progress);
        k.a((Object) findViewById, "findViewById<ProgressBar>(R.id.pb_progress)");
        this.f18053e = (ProgressBar) findViewById;
        ProgressBar progressBar = this.f18053e;
        if (progressBar == null) {
            k.a("pbProgress");
        }
        u.g((View) progressBar, 10.0f);
        View findViewById2 = findViewById(R.id.parent);
        k.a((Object) findViewById2, "findViewById(R.id.parent)");
        this.f18052d = findViewById2;
        ((TextView) a(R.id.tv_interest_table_link)).setOnClickListener(onClickListener);
        ((Button) a(R.id.btn_create_fd)).setOnClickListener(onClickListener);
        a(true);
        String str = "ISA";
        if (!k.a((Object) j.a(), (Object) str)) {
            str = "ICA";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", getClass().getSimpleName());
        f a2 = net.one97.paytm.paymentsBank.b.a.a((Context) this, (g.b<IJRPaytmDataModel>) this, (g.a) this, a.c.PAYMENTSBANK, a.b.SILENT, (HashMap<String, String>) hashMap, str);
        a2.a(this.f18051c);
        net.one97.paytm.paymentsBank.h.a a3 = o.a();
        k.a((Object) a3, "PaymentsBankHelper.getImplListener()");
        a3.getApplicationContext();
        net.one97.paytm.bankCommon.g.c.a();
        net.one97.paytm.bankCommon.g.c.a(a2);
        getSupportFragmentManager().a().b(R.id.fragment_container_benefits, b.a(false, true), b.class.getName()).c();
    }

    public final void onClick(View view) {
        k.c(view, "view");
        if (view.getId() == R.id.iv_back_arrow) {
            onBackPressed();
        } else if (view.getId() == R.id.tv_interest_table_link) {
            new d().show(getSupportFragmentManager(), "itTableBottomSheet");
        } else if (view.getId() == R.id.btn_create_fd) {
            startActivity(new Intent(this, CreateFdActivity.class));
        }
    }

    public final void a(String str, String str2) {
        k.c(str, "errorTitle");
        k.c(str2, ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE);
        View view = this.f18052d;
        if (view == null) {
            k.a("parentContainer");
        }
        Snackbar a2 = Snackbar.a(view, (CharSequence) str2, 0);
        k.a((Object) a2, "Snackbar.make(this, message, length)");
        a2.c();
    }

    public final void a(boolean z) {
        if (z) {
            this.f18054f++;
            ProgressBar progressBar = this.f18053e;
            if (progressBar == null) {
                k.a("pbProgress");
            }
            net.one97.paytm.paymentsBank.slfd.b.a.b.a(progressBar);
            return;
        }
        this.f18054f--;
        if (this.f18054f == 0) {
            ProgressBar progressBar2 = this.f18053e;
            if (progressBar2 == null) {
                k.a("pbProgress");
            }
            net.one97.paytm.paymentsBank.slfd.b.a.b.b(progressBar2);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        g().b();
    }

    /* renamed from: a_ */
    public final void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        k.c(iJRPaytmDataModel, Payload.RESPONSE);
        if (iJRPaytmDataModel instanceof CustProductList) {
            a(false);
            CustProductList custProductList = (CustProductList) iJRPaytmDataModel;
            if (TextUtils.isEmpty(custProductList.getErrorMessage())) {
                net.one97.paytm.paymentsBank.utils.a aVar = net.one97.paytm.paymentsBank.utils.a.f19494a;
                if (net.one97.paytm.paymentsBank.utils.a.a(custProductList)) {
                    net.one97.paytm.paymentsBank.utils.a aVar2 = net.one97.paytm.paymentsBank.utils.a.f19494a;
                    String f2 = net.one97.paytm.paymentsBank.utils.a.a(custProductList, true);
                    if (f2 != null) {
                        g().a(f2);
                    }
                }
            }
        }
    }

    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        k.c(iJRPaytmDataModel, "model");
        k.c(networkCustomError, "error");
        a(false);
    }

    public final void a(double d2) {
        TextView textView = (TextView) a(R.id.tv_available_deposit);
        k.a((Object) textView, "tv_available_deposit");
        textView.setText(getString(R.string.rs_str, new Object[]{net.one97.paytm.bankCommon.mapping.a.ad(String.valueOf(d2))}));
    }
}
