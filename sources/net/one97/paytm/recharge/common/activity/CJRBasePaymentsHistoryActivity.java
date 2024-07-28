package net.one97.paytm.recharge.common.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.databinding.f;
import com.google.android.material.appbar.AppBarLayout;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.automatic.b.a.j;
import net.one97.paytm.recharge.b.a;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;

public class CJRBasePaymentsHistoryActivity extends PaytmActivity implements DialogInterface.OnCancelListener, AppBarLayout.b, ai {

    /* renamed from: a  reason: collision with root package name */
    private ProgressDialog f60851a;

    /* renamed from: b  reason: collision with root package name */
    protected IJRPaytmDataModel f60852b;

    /* renamed from: c  reason: collision with root package name */
    protected int f60853c;

    /* renamed from: d  reason: collision with root package name */
    protected a f60854d;

    /* renamed from: e  reason: collision with root package name */
    private j f60855e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f60856f = false;

    public void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
    }

    public void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
    }

    /* access modifiers changed from: protected */
    public void b() {
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(CJRRechargeUtilities.INSTANCE.getRestringValue(context));
    }

    public void onCreate(Bundle bundle) {
        b.e((Activity) this);
        super.onCreate(bundle);
        this.f60854d = (a) f.a(this, R.layout.activity_recharge_my_payments_history);
        this.f60852b = (IJRPaytmDataModel) getIntent().getSerializableExtra("selected_payment");
        this.f60853c = getIntent().getIntExtra("extra_intent_item_position", -1);
        b();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.f60852b == null) {
            return true;
        }
        getMenuInflater().inflate(R.menu.my_profile_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public final void c() {
        try {
            if (this.f60851a != null && this.f60851a.isShowing()) {
                this.f60851a.dismiss();
            }
        } catch (IllegalStateException e2) {
            CJRRechargeUtilities.INSTANCE.debugLogExceptions(e2);
        }
    }

    public final void a(String str) {
        ProgressDialog progressDialog = this.f60851a;
        if (progressDialog == null) {
            this.f60851a = ProgressDialog.show(this, "", str, true);
        } else if (!progressDialog.isShowing()) {
            this.f60851a.setMessage(str);
            this.f60851a.show();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
        float abs = ((float) Math.abs(i2)) / ((float) appBarLayout.getTotalScrollRange());
        if (abs >= 0.7f && this.f60856f) {
            this.f60854d.f60313h.setVisibility(0);
            this.f60856f = !this.f60856f;
        } else if (abs < 0.7f && !this.f60856f) {
            this.f60854d.f60313h.setVisibility(8);
            this.f60856f = !this.f60856f;
        }
    }

    public void onBackPressed() {
        setResult(0, new Intent().putExtra("statusCode", this.f60855e).putExtra("extra_intent_item_position", this.f60853c).putExtra("selected_subscription", this.f60852b));
        super.onBackPressed();
    }
}
