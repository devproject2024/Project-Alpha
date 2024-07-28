package net.one97.paytm.paymentsBank.pdc.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import java.util.HashMap;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.PBCJRAccountSummary;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.activity.PBBaseToolbarActivity;
import net.one97.paytm.paymentsBank.pdc.a;
import net.one97.paytm.paymentsBank.pdc.response.PDCPriceResponse;
import net.one97.paytm.paymentsBank.utils.o;

public class PDCLowBalancelActivity extends PBBaseToolbarActivity implements View.OnClickListener, View.OnLongClickListener {

    /* renamed from: b  reason: collision with root package name */
    TextView f18664b;

    /* renamed from: c  reason: collision with root package name */
    TextView f18665c;

    /* renamed from: d  reason: collision with root package name */
    TextView f18666d;

    /* renamed from: f  reason: collision with root package name */
    TextView f18667f;

    /* renamed from: g  reason: collision with root package name */
    private String f18668g;

    /* renamed from: h  reason: collision with root package name */
    private String f18669h;

    /* renamed from: i  reason: collision with root package name */
    private String f18670i;
    private ViewGroup j;
    private TextView k;
    private TextView l;
    private TextView m;

    public final int e() {
        return R.layout.pdc_activity_low_balance;
    }

    public final int f() {
        return R.layout.pb_toolbar_center_title;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f18664b = (TextView) findViewById(R.id.atm_price);
        this.f18665c = (TextView) findViewById(R.id.insuff_bal_tv);
        this.f18666d = (TextView) findViewById(R.id.atm_card_charges_tv);
        this.f18667f = (TextView) findViewById(R.id.view_details_tv);
        this.j = (ViewGroup) findViewById(R.id.fragment_container);
        this.f18667f.setOnClickListener(this);
        this.f18666d.setOnClickListener(this);
        ((TextView) findViewById(R.id.toolbar_title)).setText(R.string.pb_pdc_low_bal_header);
        this.k = (TextView) findViewById(R.id.name);
        this.l = (TextView) findViewById(R.id.acc_number);
        this.m = (TextView) findViewById(R.id.ifsc_code);
        this.k.setOnLongClickListener(this);
        this.l.setOnLongClickListener(this);
        this.m.setOnLongClickListener(this);
        if (getIntent() != null) {
            this.f18669h = getIntent().getStringExtra("account_no_extra");
            this.f18670i = getIntent().getStringExtra("extra_ifsc");
            this.f18668g = getIntent().getStringExtra("pdc_product_id");
        }
        if (!TextUtils.isEmpty(this.f18668g) && b.c((Context) this)) {
            a(this, getString(R.string.pb_please_wait));
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            f b2 = a.b(this, this, this, this.f18668g, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap);
            b2.f16270b = getClass().getSimpleName();
            getApplicationContext();
            new c();
            c.a(b2);
        }
        if (!TextUtils.isEmpty(this.f18669h)) {
            this.l.setText(this.f18669h);
        }
        if (!TextUtils.isEmpty(this.f18670i)) {
            this.m.setText(this.f18670i);
        }
        o.a().getNameFromKyc(this, new d() {
            public final void onFragmentAction(int i2, Object obj) {
                PDCLowBalancelActivity.this.a(i2, obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2, Object obj) {
        this.k.setText((String) obj);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.view_details_tv) {
            if (this.j.getVisibility() == 8) {
                this.f18667f.setText(getString(R.string.pb_pdc_hide_details));
                this.j.setVisibility(0);
                return;
            }
            this.f18667f.setText(getString(R.string.pb_pdc_view_details));
            this.j.setVisibility(8);
        } else if (id == R.id.atm_card_charges_tv) {
            net.one97.paytm.bankCommon.utils.d.b();
            o.a().openWebViewActivity(this, net.one97.paytm.bankCommon.utils.d.a("ratesAndChargesForDebitCardUrl"), getString(R.string.pb_pdc_rate_and_charges));
        }
    }

    /* renamed from: a_ */
    public final void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        PBCJRAccountSummary pBCJRAccountSummary;
        String price;
        super.onResponse(iJRPaytmDataModel);
        ah_();
        if (iJRPaytmDataModel instanceof PDCPriceResponse) {
            PDCPriceResponse pDCPriceResponse = (PDCPriceResponse) iJRPaytmDataModel;
            if (!(pDCPriceResponse.getPayload() == null || pDCPriceResponse.getPayload().size() <= 0 || (price = pDCPriceResponse.getPayload().get(0).getPrice()) == null)) {
                this.f18664b.setText(String.format(getResources().getString(R.string.pb_simple_amount), new Object[]{price}));
            }
            String str = this.f18669h;
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", getClass().getSimpleName());
            f c2 = net.one97.paytm.paymentsBank.b.a.c((Context) this, str, (g.b<IJRPaytmDataModel>) this, (g.a) this, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap);
            if (b.c((Context) this)) {
                a(this, getString(R.string.pb_please_wait));
                c2.f16270b = "API_REQUEST_TAG_BANK_SUMMARY";
                getApplicationContext();
                new c();
                c.a(c2);
                return;
            }
            b(c2);
        } else if ((iJRPaytmDataModel instanceof PBCJRAccountSummary) && (pBCJRAccountSummary = (PBCJRAccountSummary) iJRPaytmDataModel) != null && pBCJRAccountSummary.getStatus() != null && pBCJRAccountSummary.getStatus().equalsIgnoreCase("success") && pBCJRAccountSummary.getAccounts() != null && pBCJRAccountSummary.getAccounts().size() > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(pBCJRAccountSummary.getEffectiveBalance());
            String sb2 = sb.toString();
            this.f18665c.setText(String.format(getString(R.string.pb_rupee), new Object[]{net.one97.paytm.bankCommon.mapping.a.ac(sb2)}));
        }
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        ah_();
        super.onErrorResponse(i2, iJRPaytmDataModel, networkCustomError);
    }

    public boolean onLongClick(View view) {
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService("clipboard");
        if (view.equals(this.k)) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText("account", this.k.getText().toString()));
            Toast.makeText(this, getString(R.string.uam_name_copied_clipboard), 0).show();
        } else if (view.equals(this.l)) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText("account", this.l.getText().toString()));
            Toast.makeText(this, getString(R.string.uam_acc_num_copied_clipboard), 0).show();
        } else if (view.equals(this.m)) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText("account", this.m.getText().toString()));
            Toast.makeText(this, getString(R.string.uam_ifsc_copied_clipboard), 0).show();
        }
        return false;
    }
}
