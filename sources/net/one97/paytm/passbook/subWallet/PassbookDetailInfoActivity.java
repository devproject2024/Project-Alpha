package net.one97.paytm.passbook.subWallet;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.a;
import com.paytm.utility.b;
import com.paytm.utility.v;
import java.util.HashMap;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.CJRLedger;
import net.one97.paytm.passbook.beans.CJRTransaction;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.mapping.c;
import net.one97.paytm.passbook.mapping.e;
import net.one97.paytm.passbook.transactionDetail.PassbookDetailActivity;
import net.one97.paytm.passbook.transactionDetail.PassbookTransactionDetailsActivity;
import net.one97.paytm.passbook.utility.j;
import org.json.JSONException;
import org.json.JSONObject;

public class PassbookDetailInfoActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private LottieAnimationView f58758a;

    /* renamed from: b  reason: collision with root package name */
    private String f58759b;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pass_activity_passbook_detail_info);
        this.f58758a = (LottieAnimationView) findViewById(R.id.wallet_loader);
        this.f58759b = getIntent().getStringExtra("id");
        if (v.a(this.f58759b)) {
            c.a(this, getString(R.string.error), getString(R.string.transcation_not_available), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    PassbookDetailInfoActivity.this.a(dialogInterface, i2);
                }
            });
        } else {
            a();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        if (!isFinishing()) {
            finish();
        }
    }

    private void a() {
        if (!b.r((Context) this)) {
            b();
        } else {
            a(this.f58759b);
        }
    }

    private void b() {
        startActivityForResult(new Intent(this, d.b().f()), 0);
    }

    private void a(String str) {
        e.a();
        String o = e.o();
        HashMap hashMap = new HashMap();
        hashMap.put("ssotoken", a.q(this));
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("lastLimit", 1);
            jSONObject2.put("startLimit", 0);
            jSONObject2.put("id", str);
            jSONObject.put("request", jSONObject2);
        } catch (JSONException unused) {
        }
        net.one97.paytm.passbook.mapping.a.b bVar = new net.one97.paytm.passbook.mapping.a.b(o, new i.a() {
            public final void onResponse(Object obj) {
                PassbookDetailInfoActivity.this.a((IJRDataModel) obj);
            }
        }, new g() {
            public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                PassbookDetailInfoActivity.a(PassbookDetailInfoActivity.this, (Throwable) networkCustomError);
            }
        }, new CJRLedger(), hashMap, jSONObject.toString(), a.C0715a.POST, a.c.PASSBOOK, a.b.SILENT, PassbookDetailInfoActivity.class.getName());
        if (b.c((Context) this)) {
            c();
            net.one97.paytm.passbook.mapping.a.c.a(bVar);
            return;
        }
        a(bVar, this, new DialogInterface.OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                PassbookDetailInfoActivity.this.a(dialogInterface);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface) {
        d();
        if (!isFinishing()) {
            finish();
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 0) {
            return;
        }
        if (b.r((Context) this)) {
            a();
        } else if (!isFinishing()) {
            finish();
        }
    }

    private void a(net.one97.paytm.passbook.mapping.a.e eVar, Context context, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getResources().getString(R.string.no_connection));
        builder.setMessage(context.getResources().getString(R.string.no_internet));
        builder.setPositiveButton(context.getResources().getString(R.string.network_retry_yes), new DialogInterface.OnClickListener(context, eVar, onCancelListener) {
            private final /* synthetic */ Context f$1;
            private final /* synthetic */ net.one97.paytm.passbook.mapping.a.e f$2;
            private final /* synthetic */ DialogInterface.OnCancelListener f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                PassbookDetailInfoActivity.this.a(this.f$1, this.f$2, this.f$3, dialogInterface, i2);
            }
        });
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        builder.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Context context, net.one97.paytm.passbook.mapping.a.e eVar, DialogInterface.OnCancelListener onCancelListener, DialogInterface dialogInterface, int i2) {
        dialogInterface.cancel();
        d();
        c();
        if (b.c(context)) {
            context.getApplicationContext();
            net.one97.paytm.passbook.mapping.a.c.a();
            net.one97.paytm.passbook.mapping.a.c.b(eVar);
            return;
        }
        a(eVar, context, onCancelListener);
    }

    private void c() {
        this.f58758a.setVisibility(0);
        net.one97.paytm.passbook.utility.a.a(this.f58758a);
    }

    private void d() {
        this.f58758a.setVisibility(8);
        net.one97.paytm.passbook.utility.a.b(this.f58758a);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(IJRDataModel iJRDataModel) {
        if (iJRDataModel instanceof CJRLedger) {
            CJRLedger cJRLedger = (CJRLedger) iJRDataModel;
            if (!cJRLedger.getStatusCode().equalsIgnoreCase("SUCCESS")) {
                String string = getString(R.string.failed_to_load_transaction_detail);
                if (!v.a(cJRLedger.getStatusMessage())) {
                    string = cJRLedger.getStatusMessage();
                }
                Toast.makeText(this, string, 0).show();
            } else if (cJRLedger.mTransactionList == null || cJRLedger.mTransactionList.size() == 0) {
                Toast.makeText(this, R.string.no_transaction_found, 0).show();
                if (!isFinishing()) {
                    finish();
                    return;
                }
                return;
            } else {
                CJRTransaction cJRTransaction = cJRLedger.mTransactionList.get(0);
                if (PassbookTransactionDetailsActivity.a(cJRTransaction)) {
                    new Intent(this, PassbookTransactionDetailsActivity.class);
                } else {
                    new Intent(this, PassbookDetailActivity.class);
                }
                Intent intent = new Intent(this, PassbookTransactionDetailsActivity.class);
                intent.putExtra("passbook_detail_data", cJRTransaction);
                intent.putExtra("EXTENDED_TXN_INFO", "getTabName()");
                startActivity(intent);
            }
            if (!isFinishing()) {
                finish();
            }
        }
    }

    static /* synthetic */ void a(PassbookDetailInfoActivity passbookDetailInfoActivity, Throwable th) {
        PassbookDetailInfoActivity.class.getSimpleName();
        j.a((Activity) passbookDetailInfoActivity, th);
    }
}
