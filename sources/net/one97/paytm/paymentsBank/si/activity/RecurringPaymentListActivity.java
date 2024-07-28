package net.one97.paytm.paymentsBank.si.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.passcode.BankPasscodeActivity;
import net.one97.paytm.paymentsBank.si.a.b;
import net.one97.paytm.paymentsBank.si.d.a;
import net.one97.paytm.paymentsBank.si.response.AllSIResponse;
import net.one97.paytm.paymentsBank.si.response.SIActivateResponse;
import net.one97.paytm.paymentsBank.si.response.SIDeActivateResponse;
import net.one97.paytm.paymentsBank.si.response.SIDeleteResponse;
import net.one97.paytm.upi.util.UpiConstants;

public class RecurringPaymentListActivity extends SIBaseActivity implements View.OnClickListener, d, g.a, g.b<IJRPaytmDataModel>, b.a {

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f18812b;

    /* renamed from: c  reason: collision with root package name */
    private b f18813c;

    /* renamed from: d  reason: collision with root package name */
    private LottieAnimationView f18814d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<IJRPaytmDataModel> f18815e;

    /* renamed from: f  reason: collision with root package name */
    private AllSIResponse.StandingInstructions f18816f;

    /* renamed from: g  reason: collision with root package name */
    private String f18817g;

    /* renamed from: h  reason: collision with root package name */
    private int f18818h = 0;

    /* renamed from: i  reason: collision with root package name */
    private int f18819i = -1;

    public void onFragmentAction(int i2, Object obj) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.si_activity_recur_list);
        findViewById(R.id.back_arrow).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                RecurringPaymentListActivity.this.a(view);
            }
        });
        ((ViewGroup) findViewById(R.id.addNewLyt)).setOnClickListener(this);
        this.f18812b = (RecyclerView) findViewById(R.id.recurr_rv);
        this.f18814d = (LottieAnimationView) findViewById(R.id.loader_view);
        this.f18812b.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f18815e = new ArrayList<>();
        if (getIntent().hasExtra("extra_list")) {
            this.f18815e = (ArrayList) getIntent().getSerializableExtra("extra_list");
        } else {
            e();
        }
        this.f18813c = new b(this, this.f18815e, this);
        this.f18812b.setNestedScrollingEnabled(false);
        this.f18812b.setAdapter(this.f18813c);
        ArrayList<IJRPaytmDataModel> arrayList = this.f18815e;
        if (arrayList != null && arrayList.size() > 0 && !g()) {
            this.f18813c.a();
            h();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        onBackPressed();
    }

    private void e() {
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", getClass().getSimpleName());
        f a2 = a.a(this, this, this, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap);
        if (com.paytm.utility.b.c((Context) this)) {
            a(this.f18814d);
            this.f18812b.setVisibility(8);
            new c();
            c.a(a2);
            return;
        }
        com.paytm.utility.b.b((Context) this, getResources().getString(R.string.network_error_heading), getString(R.string.network_error_message));
    }

    public final void a(AllSIResponse.StandingInstructions standingInstructions) {
        this.f18816f = standingInstructions;
        this.f18818h = 3;
        Intent intent = new Intent(this, BankPasscodeActivity.class);
        intent.putExtra("title", getString(R.string.pb_passcode_header_delete_recurring_payment));
        intent.putExtra("ppb_header_position", "center");
        intent.putExtra("r_token", true);
        startActivityForResult(intent, 110);
    }

    public final void b(AllSIResponse.StandingInstructions standingInstructions) {
        String str;
        this.f18816f = standingInstructions;
        if ("ACTIVE".equalsIgnoreCase(standingInstructions.getStatus())) {
            this.f18818h = 2;
            str = getString(R.string.pb_passcode_header_pause_recurring_payment);
        } else {
            this.f18818h = 1;
            str = getString(R.string.pb_passcode_header_resume_recurring_payment);
        }
        Intent intent = new Intent(this, BankPasscodeActivity.class);
        intent.putExtra("title", str);
        intent.putExtra("ppb_header_position", "center");
        intent.putExtra("r_token", true);
        startActivityForResult(intent, 110);
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (!isFinishing()) {
            ah_();
            net.one97.paytm.bankCommon.utils.f.a((Context) this, networkCustomError, i2);
        }
    }

    /* renamed from: a_ */
    public final void onResponse(IJRPaytmDataModel iJRPaytmDataModel) {
        ah_();
        if (iJRPaytmDataModel instanceof AllSIResponse) {
            LottieAnimationView lottieAnimationView = this.f18814d;
            lottieAnimationView.cancelAnimation();
            lottieAnimationView.setVisibility(8);
            AllSIResponse allSIResponse = (AllSIResponse) iJRPaytmDataModel;
            this.f18815e = new ArrayList<>();
            if (allSIResponse.getPayload() == null) {
                return;
            }
            if (!TextUtils.isEmpty(allSIResponse.getPayload().getErrorMessage())) {
                com.paytm.utility.b.b((Context) this, getString(R.string.error), allSIResponse.getPayload().getErrorMessage());
            } else if (allSIResponse.getPayload().getStandingInstructionList() == null || allSIResponse.getPayload().getStandingInstructionList().size() <= 0) {
                f();
                finish();
            } else {
                this.f18815e.addAll(allSIResponse.getPayload().getStandingInstructionList());
                b bVar = this.f18813c;
                ArrayList<IJRPaytmDataModel> arrayList = this.f18815e;
                if (arrayList != null && arrayList.size() > 0) {
                    if (bVar.f18782b != null) {
                        bVar.f18782b.clear();
                    } else {
                        bVar.f18782b = new ArrayList<>();
                    }
                    bVar.f18782b.addAll(arrayList);
                }
                bVar.notifyDataSetChanged();
                this.f18812b.setVisibility(0);
                if (this.f18815e.size() == 0) {
                    f();
                    finish();
                } else if (!g()) {
                    this.f18813c.a();
                    h();
                }
            }
        } else if (iJRPaytmDataModel instanceof SIDeActivateResponse) {
            SIDeActivateResponse sIDeActivateResponse = (SIDeActivateResponse) iJRPaytmDataModel;
            if (sIDeActivateResponse.getResponseCode().intValue() == 200) {
                e();
            } else {
                com.paytm.utility.b.b((Context) this, getString(R.string.error), TextUtils.isEmpty(sIDeActivateResponse.getResponseMessage()) ? getString(R.string.pb_something_wrong_try_again) : sIDeActivateResponse.getResponseMessage());
            }
        } else if (iJRPaytmDataModel instanceof SIActivateResponse) {
            SIActivateResponse sIActivateResponse = (SIActivateResponse) iJRPaytmDataModel;
            if (sIActivateResponse.getResponseCode().intValue() == 200) {
                e();
            } else {
                com.paytm.utility.b.b((Context) this, getString(R.string.error), TextUtils.isEmpty(sIActivateResponse.getResponseMessage()) ? getString(R.string.pb_something_wrong_try_again) : sIActivateResponse.getResponseMessage());
            }
        } else if (iJRPaytmDataModel instanceof SIDeleteResponse) {
            SIDeleteResponse sIDeleteResponse = (SIDeleteResponse) iJRPaytmDataModel;
            if (sIDeleteResponse.getResponseCode().intValue() == 200) {
                e();
            } else {
                com.paytm.utility.b.b((Context) this, getString(R.string.error), TextUtils.isEmpty(sIDeleteResponse.getResponseMessage()) ? getString(R.string.pb_something_wrong_try_again) : sIDeleteResponse.getResponseMessage());
            }
        }
    }

    private void f() {
        Intent intent = new Intent(this, RecurringPaymentAddActivity.class);
        intent.putExtra("acc_no", getIntent().getStringExtra("acc_no"));
        startActivity(intent);
    }

    public void onClick(View view) {
        if (view.getId() != R.id.addNewLyt) {
            return;
        }
        if (com.paytm.utility.b.c((Context) this)) {
            f();
        } else {
            com.paytm.utility.b.b((Context) this, getString(R.string.network_error_heading), getString(R.string.pb_check_your_network));
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        int i4 = i2;
        int i5 = i3;
        if (i4 == 110 && i5 == -1) {
            this.f18817g = intent.getStringExtra("passcode");
            int i6 = this.f18818h;
            f fVar = null;
            if (i6 == 2 || i6 == 1) {
                HashMap hashMap = new HashMap();
                hashMap.put("screen_name", getClass().getSimpleName());
                if (this.f18818h == 2) {
                    String str = this.f18817g;
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.f18816f.getId());
                    String sb2 = sb.toString();
                    a.c cVar = a.c.PAYMENTSBANK;
                    a.b bVar = a.b.USER_FACING;
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("Authorization", str);
                    hashMap2.put("channel", UpiConstants.B2C_ANDROID);
                    hashMap2.put("Content-Type", "application/json");
                    net.one97.paytm.bankCommon.utils.d.b();
                    String a2 = net.one97.paytm.bankCommon.utils.d.a("siPause");
                    if (URLUtil.isValidUrl(a2)) {
                        String e2 = com.paytm.utility.b.e((Context) this, a2 + "&siId=" + sb2);
                        net.one97.paytm.bankCommon.b.b bVar2 = new net.one97.paytm.bankCommon.b.b();
                        bVar2.a(e2, this, this, new SIDeActivateResponse(), hashMap2, (String) null, a.C0715a.PUT, cVar, bVar, hashMap);
                        fVar = bVar2.a();
                    }
                } else {
                    String str2 = this.f18817g;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(this.f18816f.getId());
                    fVar = net.one97.paytm.paymentsBank.si.d.a.a((Context) this, str2, sb3.toString(), (g.b<IJRPaytmDataModel>) this, (g.a) this, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap);
                }
                if (com.paytm.utility.b.c((Context) this)) {
                    a(this, getString(R.string.pb_please_wait));
                    new c();
                    c.a(fVar);
                    return;
                }
                com.paytm.utility.b.b((Context) this, getResources().getString(R.string.network_error_heading), getString(R.string.network_error_message));
            } else if (i6 == 3) {
                HashMap hashMap3 = new HashMap();
                hashMap3.put("screen_name", getClass().getSimpleName());
                String str3 = this.f18817g;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(this.f18816f.getId());
                String sb5 = sb4.toString();
                a.c cVar2 = a.c.PAYMENTSBANK;
                a.b bVar3 = a.b.USER_FACING;
                HashMap hashMap4 = new HashMap();
                hashMap4.put("Authorization", str3);
                hashMap4.put("channel", UpiConstants.B2C_ANDROID);
                net.one97.paytm.bankCommon.utils.d.b();
                String a3 = net.one97.paytm.bankCommon.utils.d.a("siDelete");
                if (URLUtil.isValidUrl(a3)) {
                    String e3 = com.paytm.utility.b.e((Context) this, a3 + "&siId=" + sb5);
                    net.one97.paytm.bankCommon.b.b bVar4 = new net.one97.paytm.bankCommon.b.b();
                    bVar4.a(e3, this, this, new SIDeleteResponse(), hashMap4, (String) null, a.C0715a.PUT, cVar2, bVar3, hashMap3);
                    fVar = bVar4.a();
                }
                if (com.paytm.utility.b.c((Context) this)) {
                    a(this, getString(R.string.pb_please_wait));
                    new c();
                    c.a(fVar);
                    return;
                }
                com.paytm.utility.b.b((Context) this, getResources().getString(R.string.network_error_heading), getString(R.string.network_error_message));
            }
        } else if (i4 == 120 && i5 == -1) {
            e();
        }
    }

    private boolean g() {
        return net.one97.paytm.payments.d.b.a(getApplicationContext()).b("si_swipe_list", false, false);
    }

    private void h() {
        net.one97.paytm.payments.d.b.a(getApplicationContext()).a("si_swipe_list", true, false);
    }
}
