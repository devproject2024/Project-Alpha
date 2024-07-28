package net.one97.paytm.addmoney.toppb.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.addmoney.AddMoneyBaseToolbarActivity;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.common.model.PaymentDestinationType;
import net.one97.paytm.addmoney.toppb.a.a;
import net.one97.paytm.addmoney.utils.AddMoneyUtils;
import net.one97.paytm.addmoney.utils.c;
import net.one97.paytm.addmoney.utils.d;
import net.one97.paytm.addmoney.utils.g;
import net.one97.paytm.common.entity.paymentsbank.CustProductList;

public class AddMoneyToPPBActivity extends AddMoneyBaseToolbarActivity implements a {

    /* renamed from: c  reason: collision with root package name */
    private net.one97.paytm.addmoney.common.view.a f48827c;

    /* renamed from: d  reason: collision with root package name */
    private String f48828d;

    public final void a(NetworkCustomError networkCustomError) {
    }

    public final void a(boolean z) {
    }

    public final int a() {
        return R.layout.uam_activity_add_to_ppb;
    }

    public final int b() {
        return f48004a;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f48827c = net.one97.paytm.addmoney.common.view.a.c(PaymentDestinationType.TO_PAYTM_BANK.getNumVal());
        Bundle arguments = this.f48827c.getArguments();
        arguments.putBoolean("destroy_self", getIntent().getBooleanExtra("destroy_self", false));
        double doubleExtra = getIntent().getDoubleExtra("Amount", 0.0d);
        if (getIntent().hasExtra("amount")) {
            this.f48828d = getIntent().getStringExtra("amount");
            if (!TextUtils.isEmpty(this.f48828d)) {
                try {
                    doubleExtra = Double.parseDouble(this.f48828d);
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                }
            }
        }
        if (getIntent().hasExtra("hide_isa_fd")) {
            String stringExtra = getIntent().getStringExtra("hide_isa_fd");
            if (stringExtra != null) {
                try {
                    g.a().l = Boolean.valueOf(stringExtra).booleanValue();
                } catch (Exception e3) {
                    e3.printStackTrace();
                    g.a().l = false;
                }
            }
        } else {
            g.a().l = false;
        }
        if (doubleExtra > 0.0d) {
            arguments.putString("Amount", AddMoneyUtils.d(String.valueOf(doubleExtra)));
        }
        this.f48827c.setArguments(arguments);
        Intent intent = getIntent();
        if (intent.getSerializableExtra("cust_product_list") != null) {
            c.a().f48963f = (CustProductList) intent.getSerializableExtra("cust_product_list");
        }
        if (intent.getSerializableExtra("extra_saving_balance") != null) {
            c.a().f48965h = intent.getStringExtra("extra_saving_balance");
        }
        if (intent.getStringExtra("slfdIblCifStatus") != null) {
            c.a().f48966i = intent.getStringExtra("slfdIblCifStatus");
        }
        if (intent.hasExtra("slfdBalance")) {
            double doubleExtra2 = intent.getDoubleExtra("slfdBalance", -1.0d);
            c.a().j = Double.valueOf(doubleExtra2);
        }
        getSupportFragmentManager().a().b(R.id.containerLayout, this.f48827c, (String) null).c();
        d.a(this, "/add-money/ppb");
    }

    public void onBackPressed() {
        net.one97.paytm.addmoney.common.view.a aVar = this.f48827c;
        if (aVar == null || !aVar.isResumed()) {
            super.onBackPressed();
        } else {
            this.f48827c.r();
        }
    }

    public void finish() {
        c a2 = c.a();
        a2.f48962e = null;
        a2.f48958a = null;
        a2.f48960c = null;
        a2.f48959b = null;
        a2.f48961d = null;
        a2.f48963f = null;
        a2.f48964g = null;
        g a3 = g.a();
        a3.f48975b = null;
        a3.f48976c = null;
        a3.f48978e = null;
        a3.f48974a = "";
        a3.f48977d = null;
        super.finish();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (intent != null) {
            Intent intent2 = new Intent();
            intent2.putExtra("fd_clicked", intent.getBooleanExtra("fd_clicked", false));
            setResult(-1, intent2);
        }
    }
}
