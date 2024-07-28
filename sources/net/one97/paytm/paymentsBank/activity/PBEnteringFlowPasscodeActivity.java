package net.one97.paytm.paymentsBank.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.g;
import com.paytm.utility.v;
import net.one97.paytm.bankCommon.activity.PBBaseActivity;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.ValidatePasscode;
import net.one97.paytm.bankCommon.utils.g;
import net.one97.paytm.payments.activity.AJRForgotPasscode;
import net.one97.paytm.payments.activity.AJRSetPasscode;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.activity.PBEnteringFlowPasscodeActivity;
import net.one97.paytm.paymentsBank.forgotpasscode.a.a;
import net.one97.paytm.paymentsBank.fragment.BankTabPasscodeFragment;
import net.one97.paytm.paymentsBank.utils.h;

public class PBEnteringFlowPasscodeActivity extends PBBaseActivity {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Fragment f17396b;

    public void onCreate(Bundle bundle) {
        b.e((Activity) this);
        super.onCreate(bundle);
        setContentView(R.layout.activity_pb_entering_flow_passcode);
        if (net.one97.paytm.bankCommon.h.b.a(this)) {
            e();
            return;
        }
        this.f17396b = new a();
        getSupportFragmentManager().a().b(R.id.container, this.f17396b, (String) null).c();
        g gVar = g.f16329a;
        f a2 = g.a(this, new g.b<IJRPaytmDataModel>() {
            public final /* synthetic */ void onResponse(Object obj) {
                ValidatePasscode validatePasscode = (ValidatePasscode) ((IJRPaytmDataModel) obj);
                if (validatePasscode != null && validatePasscode.getResponseCode() == 1100) {
                    net.one97.paytm.bankCommon.h.b.a((Context) PBEnteringFlowPasscodeActivity.this, true);
                    PBEnteringFlowPasscodeActivity.this.e();
                } else if (validatePasscode == null || validatePasscode.getResponseCode() != 1101) {
                    if (PBEnteringFlowPasscodeActivity.this.f17396b != null) {
                        PBEnteringFlowPasscodeActivity.this.getSupportFragmentManager().a().a(PBEnteringFlowPasscodeActivity.this.f17396b).c();
                    }
                    PBEnteringFlowPasscodeActivity pBEnteringFlowPasscodeActivity = PBEnteringFlowPasscodeActivity.this;
                    com.paytm.utility.g.b(pBEnteringFlowPasscodeActivity, pBEnteringFlowPasscodeActivity.getString(R.string.error), TextUtils.isEmpty(validatePasscode.getMessage()) ? PBEnteringFlowPasscodeActivity.this.getString(R.string.some_went_wrong) : validatePasscode.getMessage(), new g.c() {
                        public final void onDialogDismissed() {
                            PBEnteringFlowPasscodeActivity.AnonymousClass1.this.a();
                        }
                    });
                } else {
                    PBEnteringFlowPasscodeActivity.this.f();
                }
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void a() {
                PBEnteringFlowPasscodeActivity.this.finish();
            }
        }, new g.a() {
            public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                if (PBEnteringFlowPasscodeActivity.this.f17396b != null) {
                    PBEnteringFlowPasscodeActivity.this.getSupportFragmentManager().a().a(PBEnteringFlowPasscodeActivity.this.f17396b).c();
                }
                net.one97.paytm.bankCommon.utils.f.a((Context) PBEnteringFlowPasscodeActivity.this, networkCustomError, i2);
            }
        }, a.c.PAYMENTSBANK, a.b.USER_FACING, getClass().getSimpleName());
        if (b.c((Context) this)) {
            getApplicationContext();
            new c();
            c.a(a2);
            return;
        }
        h hVar = h.f19510a;
        h.a(a2, this);
    }

    public final void e() {
        BankTabPasscodeFragment bankTabPasscodeFragment = new BankTabPasscodeFragment();
        Bundle extras = getIntent().getExtras();
        if (!v.a(getIntent().getAction())) {
            if (extras == null) {
                extras = new Bundle();
            }
            extras.putString("action", getIntent().getAction());
        }
        bankTabPasscodeFragment.setArguments(extras);
        getSupportFragmentManager().a().b(R.id.container, bankTabPasscodeFragment, (String) null).c();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        a(i2, i3, intent);
    }

    /* access modifiers changed from: protected */
    public void a(int i2, int i3, Intent intent) {
        if (i2 == 7 && i3 == -1) {
            startActivity(new Intent(this, AJRForgotPasscode.class));
        } else if (i2 != 102) {
        } else {
            if (i3 == -1) {
                e();
            } else {
                finish();
            }
        }
    }

    public void f() {
        Intent intent = new Intent(this, AJRSetPasscode.class);
        intent.putExtras(getIntent());
        startActivityForResult(intent, 102);
    }
}
