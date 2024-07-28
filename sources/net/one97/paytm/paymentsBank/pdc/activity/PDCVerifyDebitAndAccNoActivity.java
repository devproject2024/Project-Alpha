package net.one97.paytm.paymentsBank.pdc.activity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import java.util.HashMap;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.CustProductList;
import net.one97.paytm.bankCommon.model.PBCardDetailModel;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.activity.PBBaseToolbarActivity;
import net.one97.paytm.paymentsBank.b.a;

public class PDCVerifyDebitAndAccNoActivity extends PBBaseToolbarActivity {

    /* renamed from: b  reason: collision with root package name */
    private String f18698b;

    /* renamed from: c  reason: collision with root package name */
    private String f18699c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f18700d;

    /* renamed from: f  reason: collision with root package name */
    private TextView f18701f;

    /* renamed from: g  reason: collision with root package name */
    private View f18702g;

    /* renamed from: h  reason: collision with root package name */
    private CustProductList f18703h;

    public final int e() {
        return R.layout.activity_pdc_verify_debit_and_account;
    }

    public final int f() {
        return R.layout.item_toolbar_normal_layout;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getIntent().getStringExtra("accessToken");
        this.f18700d = (TextView) findViewById(R.id.card_number);
        this.f18701f = (TextView) findViewById(R.id.account_number);
        this.f18702g = findViewById(R.id.confirm_btn);
        this.f18702g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PDCVerifyDebitAndAccNoActivity.this.a(view);
            }
        });
        if (b.c((Context) this)) {
            a(this, getString(R.string.pb_please_wait));
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            f a2 = a.a((Context) this, (g.b<IJRPaytmDataModel>) this, (g.a) this, a.c.PAYMENTSBANK, a.b.SILENT, (HashMap<String, String>) hashMap);
            getApplicationContext();
            new c();
            c.a(a2);
        }
        this.f18701f.setText(this.f18699c);
        this.f18700d.setText(this.f18698b);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        if (!b.c((Context) this)) {
            b.a((Context) this, getString(R.string.pb_check_your_network));
            return;
        }
        setResult(-1);
        finish();
    }

    /* renamed from: a_ */
    public final void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        ah_();
        if (iJRPaytmDataModel instanceof CustProductList) {
            this.f18703h = (CustProductList) iJRPaytmDataModel;
            if (!TextUtils.isEmpty(this.f18703h.getErrorMessage())) {
                b.b((Context) this, getString(R.string.error), this.f18703h.getErrorMessage());
            } else {
                this.f18699c = this.f18703h.getIsaAccNum();
                this.f18698b = this.f18703h.getVdcMaskedCardNum();
                this.f18701f.setText(this.f18699c);
                this.f18700d.setText(this.f18698b);
                this.f18702g.setVisibility(0);
            }
        }
        if (iJRPaytmDataModel instanceof PBCardDetailModel) {
            PBCardDetailModel pBCardDetailModel = (PBCardDetailModel) iJRPaytmDataModel;
            if (!TextUtils.isEmpty(pBCardDetailModel.getErrorMessage())) {
                b.b((Context) this, getString(R.string.error), pBCardDetailModel.getErrorMessage());
                return;
            }
            this.f18699c = this.f18703h.getIsaAccNum();
            this.f18698b = pBCardDetailModel.getPan();
            this.f18701f.setText(this.f18699c);
            this.f18700d.setText(this.f18698b);
            this.f18702g.setVisibility(0);
        }
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        ah_();
    }
}
