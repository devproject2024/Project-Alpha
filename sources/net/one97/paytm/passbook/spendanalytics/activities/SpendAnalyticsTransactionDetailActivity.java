package net.one97.paytm.passbook.spendanalytics.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.squareup.picasso.ah;
import com.squareup.picasso.w;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.base.BaseActivity;
import net.one97.paytm.passbook.beans.CJRLedger;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.spendanalytics.a.e;
import net.one97.paytm.passbook.spendanalytics.model.a;
import net.one97.paytm.passbook.utility.c;
import net.one97.paytm.passbook.utility.j;

public class SpendAnalyticsTransactionDetailActivity extends BaseActivity implements g, i.a<IJRDataModel> {

    /* renamed from: a  reason: collision with root package name */
    CJRLedger f58552a;

    /* renamed from: b  reason: collision with root package name */
    private Dialog f58553b;

    public /* synthetic */ void onResponse(Object obj) {
        IJRDataModel iJRDataModel = (IJRDataModel) obj;
        if (!isFinishing() && (iJRDataModel instanceof CJRLedger)) {
            this.f58552a = (CJRLedger) iJRDataModel;
            if ("SUCCESS".equalsIgnoreCase(this.f58552a.getStatusMessage())) {
                CJRLedger cJRLedger = this.f58552a;
                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.historyRecyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(new e(this, cJRLedger.getTransactionList()));
            } else {
                b.b((Context) this, getString(R.string.pass_alert), this.f58552a.getStatusMessage());
            }
            b();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_spend_by_one_category_history);
        a aVar = (a) getIntent().getSerializableExtra("request_store_history");
        a(aVar.payeeID, aVar.selectedMonth);
        ((ImageButton) findViewById(R.id.backArrow)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SpendAnalyticsTransactionDetailActivity.this.a(view);
            }
        });
        TextView textView = (TextView) findViewById(R.id.categoryItemName);
        if (!TextUtils.isEmpty(aVar.storeName)) {
            textView.setText(aVar.storeName);
        } else if (aVar.payeeID.equalsIgnoreCase("others")) {
            textView.setText("Others");
        }
        ((TextView) findViewById(R.id.amount)).setText(getString(R.string.pass_rs_symbol) + c.c(aVar.sum).replace(".00", ""));
        TextView textView2 = (TextView) findViewById(R.id.noOfPayments);
        if (aVar == null || aVar.storeName == null || !aVar.storeName.equals("Transfers")) {
            if (aVar.cnt.equals("1")) {
                textView2.setText(aVar.cnt + " Payment");
            } else {
                textView2.setText(aVar.cnt + " Payments");
            }
        } else if (aVar.cnt.equals("1")) {
            textView2.setText(aVar.cnt + " Transfer");
        } else {
            textView2.setText(aVar.cnt + " Transfers");
        }
        w.a().a(aVar.storeLogo).a((ah) new net.one97.paytm.passbook.customview.b()).a((ImageView) findViewById(R.id.favStoreIcon), (com.squareup.picasso.e) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        finish();
    }

    private void a(String str, String str2) {
        if (str != null) {
            net.one97.paytm.passbook.spendanalytics.a aVar = net.one97.paytm.passbook.spendanalytics.a.f58478a;
            String a2 = net.one97.paytm.passbook.spendanalytics.a.a(str2);
            net.one97.paytm.passbook.spendanalytics.a aVar2 = net.one97.paytm.passbook.spendanalytics.a.f58478a;
            net.one97.paytm.passbook.mapping.a.b a3 = net.one97.paytm.passbook.spendanalytics.d.a.a(this, a2, "0", net.one97.paytm.passbook.spendanalytics.a.b(str2), str, "100", this, this);
            if (b.c((Context) this)) {
                a();
                net.one97.paytm.passbook.mapping.a.c.a();
                net.one97.paytm.passbook.mapping.a.c.b(a3);
                return;
            }
            a((DialogInterface.OnClickListener) new DialogInterface.OnClickListener(str, str2) {
                private final /* synthetic */ String f$1;
                private final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    SpendAnalyticsTransactionDetailActivity.this.a(this.f$1, this.f$2, dialogInterface, i2);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2, DialogInterface dialogInterface, int i2) {
        a(str, str2);
    }

    private void a() {
        try {
            if (this.f58553b == null) {
                this.f58553b = net.one97.paytm.passbook.mapping.c.f(this);
            }
            if (this.f58553b != null && !this.f58553b.isShowing()) {
                this.f58553b.show();
            }
        } catch (Exception unused) {
        }
    }

    private void b() {
        try {
            if (this.f58553b != null && this.f58553b.isShowing()) {
                this.f58553b.dismiss();
            }
        } catch (Exception unused) {
        }
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        b();
        if (isFinishing() || j.a((Context) this, networkCustomError)) {
            return;
        }
        if ((networkCustomError.getStatusCode() != -1 && networkCustomError.getStatusCode() == 410) || networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 403) {
            getClass().getName();
            j.a(this, networkCustomError, true, false);
            return;
        }
        getClass().getName();
        j.a((Activity) this, (Throwable) networkCustomError);
    }

    public final void a(DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.no_connection));
        builder.setMessage(getResources().getString(R.string.no_internet));
        builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), onClickListener);
        builder.show();
    }
}
