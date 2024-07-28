package net.one97.paytm.paymentsBank.activity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.URLUtil;
import android.widget.TextView;
import androidx.core.content.b;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import net.one97.paytm.bankCommon.g.a;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.mapping.c;
import net.one97.paytm.bankCommon.mapping.g;
import net.one97.paytm.bankCommon.model.IsaDetailsModel;
import net.one97.paytm.bankCommon.model.NomineeModel;
import net.one97.paytm.bankCommon.model.nominee.NomineeEditStatusResponse;
import net.one97.paytm.bankCommon.utils.d;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.fragment.n;
import net.one97.paytm.paymentsBank.utils.j;
import net.one97.paytm.upi.util.UpiConstants;

public class AJRNomineeDetails extends PBBaseToolbarActivity {

    /* renamed from: b  reason: collision with root package name */
    private NomineeModel f17358b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f17359c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f17360d;

    /* renamed from: f  reason: collision with root package name */
    private String f17361f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f17362g;

    public final int e() {
        return 0;
    }

    public void onCreate(Bundle bundle) {
        a aVar;
        super.onCreate(bundle);
        c.a("/bank/savings-account/pb_nominee-detail", CJRPGTransactionRequestUtils.PAYER_BANK_NAME, (Context) this);
        ((TextView) findViewById(R.id.title)).setText(R.string.payment_nominee_details_title);
        findViewById(R.id.container_framelayout).setBackgroundColor(b.c(this, R.color.white));
        try {
            this.f17358b = (NomineeModel) getIntent().getSerializableExtra("NOMINEE_ITEM");
            this.f17360d = getIntent().getBooleanExtra("isEditable", false);
            this.f17361f = getIntent().getStringExtra("extra_account_number");
        } catch (ClassCastException e2) {
            e2.printStackTrace();
        }
        if (this.f17358b == null) {
            return;
        }
        if (TextUtils.isEmpty(this.f17361f) || !this.f17360d) {
            g();
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", getClass().getSimpleName());
        String nomineeId = this.f17358b.getNomineeId();
        a.c cVar = a.c.PAYMENTSBANK;
        a.b bVar = a.b.USER_FACING;
        g.a();
        String a2 = d.a("editNomineeStatus");
        if (URLUtil.isValidUrl(a2)) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("User-Token", com.paytm.utility.a.q(this));
            hashMap2.put("Client-Id", UpiConstants.B2C_ANDROID);
            aVar = new net.one97.paytm.bankCommon.g.a(a2 + "?nomineeId=" + nomineeId, this, this, new NomineeEditStatusResponse(), hashMap2, cVar, bVar, hashMap);
        } else {
            aVar = null;
        }
        if (aVar == null) {
            com.paytm.utility.b.b((Context) this, getString(R.string.error), getString(R.string.pb_something_wrong_try_again));
        } else if (com.paytm.utility.b.c((Context) this)) {
            a(this, getString(R.string.pb_please_wait));
            getApplicationContext();
            new net.one97.paytm.bankCommon.g.c();
            net.one97.paytm.bankCommon.g.c.a(aVar);
        } else {
            a(aVar);
        }
    }

    private void g() {
        invalidateOptionsMenu();
        n nVar = new n();
        Bundle bundle = new Bundle();
        bundle.putSerializable("NOMINEE_ITEM", this.f17358b);
        nVar.setArguments(bundle);
        getSupportFragmentManager().a().b(R.id.container_framelayout, nVar, (String) null).c();
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        if (j.a().equals("ICA")) {
            menu.findItem(R.id.edit_nominee).setVisible(false);
        } else if (this.f17359c || !this.f17362g) {
            menu.findItem(R.id.edit_nominee).setVisible(false);
        } else {
            menu.findItem(R.id.edit_nominee).setVisible(true);
        }
        super.onPrepareOptionsMenu(menu);
        return true;
    }

    public void onBackPressed() {
        if (this.f17359c) {
            this.f17359c = false;
            invalidateOptionsMenu();
        }
        super.onBackPressed();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.edit_nominee) {
            return super.onOptionsItemSelected(menuItem);
        }
        this.f17359c = true;
        net.one97.paytm.bankOpen.b.d dVar = new net.one97.paytm.bankOpen.b.d();
        Bundle bundle = new Bundle();
        bundle.putBoolean("DO_CREATE_ACCOUNT", false);
        bundle.putBoolean("add_nominee_for_slfd", false);
        bundle.putString("ACCOUNT_NUMBER", getIntent().getStringExtra("extra_account_number"));
        bundle.putSerializable("NOMINEE_ITEM", this.f17358b);
        dVar.setArguments(bundle);
        getSupportFragmentManager().a().b(R.id.container_framelayout, dVar, (String) null).a(dVar.getClass().getSimpleName()).c();
        invalidateOptionsMenu();
        return true;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nominee_detail_menu, menu);
        menu.findItem(R.id.edit_nominee).setVisible(false);
        return true;
    }

    public final int f() {
        return R.layout.item_toolbar_nominee_details;
    }

    /* renamed from: a_ */
    public final void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        ah_();
        if (iJRPaytmDataModel instanceof NomineeEditStatusResponse) {
            NomineeEditStatusResponse nomineeEditStatusResponse = (NomineeEditStatusResponse) iJRPaytmDataModel;
            if (!nomineeEditStatusResponse.getSuccess().booleanValue()) {
                return;
            }
            if (nomineeEditStatusResponse.getResponse() == null || nomineeEditStatusResponse.getResponse().getISA() == null) {
                this.f17362g = false;
                g();
            } else if ("DONE".equalsIgnoreCase(nomineeEditStatusResponse.getResponse().getISA().getStatus())) {
                if (com.paytm.utility.b.c((Context) this)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("screen_name", getClass().getSimpleName());
                    f a2 = net.one97.paytm.paymentsBank.b.a.a(this, com.paytm.utility.a.q(this), this.f17361f, this, this, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap);
                    if (com.paytm.utility.b.c((Context) this)) {
                        a(this, getString(R.string.pb_please_wait));
                        getApplicationContext();
                        new net.one97.paytm.bankCommon.g.c();
                        net.one97.paytm.bankCommon.g.c.a(a2);
                        return;
                    }
                    a(a2);
                }
            } else if ("NOT_REQUESTED".equalsIgnoreCase(nomineeEditStatusResponse.getResponse().getISA().getStatus()) || "FAILED".equalsIgnoreCase(nomineeEditStatusResponse.getResponse().getISA().getStatus())) {
                this.f17362g = true;
                g();
            } else {
                this.f17362g = false;
                g();
            }
        } else if (iJRPaytmDataModel instanceof IsaDetailsModel) {
            IsaDetailsModel isaDetailsModel = (IsaDetailsModel) iJRPaytmDataModel;
            if (isaDetailsModel == null || isaDetailsModel.getNomineeList() == null || isaDetailsModel.getNomineeList().size() <= 0) {
                com.paytm.utility.b.b((Context) this, getString(R.string.error), getString(R.string.pb_something_wrong_try_again));
                return;
            }
            this.f17358b = isaDetailsModel.getNomineeList().get(0);
            this.f17362g = true;
            g();
        }
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        ah_();
        net.one97.paytm.bankCommon.utils.f.a((Context) this, networkCustomError, i2);
    }
}
