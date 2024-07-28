package net.one97.paytm.paymentsBank.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.URLUtil;
import com.airbnb.lottie.LottieAnimationView;
import com.business.merchant_payments.common.utility.PaymentsGTMConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.bankCommon.activity.PBBaseActivity;
import net.one97.paytm.bankCommon.g.a;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.h.b;
import net.one97.paytm.bankCommon.mapping.e;
import net.one97.paytm.bankCommon.mapping.g;
import net.one97.paytm.bankCommon.model.AccountStatus;
import net.one97.paytm.bankCommon.model.auth.CJRUserInfoV2;
import net.one97.paytm.bankCommon.utils.d;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.utils.o;

public class SavingsAccountActivity extends PBBaseActivity {

    /* renamed from: b  reason: collision with root package name */
    private boolean f17416b = false;

    /* renamed from: c  reason: collision with root package name */
    private Context f17417c;

    /* renamed from: d  reason: collision with root package name */
    private LottieAnimationView f17418d;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_savings_account);
        this.f17417c = this;
        this.f17418d = (LottieAnimationView) findViewById(R.id.wallet_loader);
        findViewById(R.id.payments_bank_info_btn_close).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                SavingsAccountActivity.this.a(view);
            }
        });
        if (b.h(this) == AccountStatus.ISSUED || b.h(this) == AccountStatus.PROCESSING) {
            g();
        } else if (!b.e(this)) {
            g.a();
            if (!d.a("paytmPaymentBankEnabled", false)) {
                return;
            }
            if (b.h(this) == AccountStatus.ISSUED) {
                this.f17416b = false;
                e();
            } else if (b.d(this)) {
                e();
            } else {
                StringBuilder sb = new StringBuilder();
                this.f17417c.getApplicationContext();
                g.a();
                sb.append(d.a(PaymentsGTMConstants.USER_DETAILS));
                sb.append(e.v());
                String b2 = com.paytm.utility.b.b(this.f17417c, sb.toString());
                if (URLUtil.isValidUrl(b2)) {
                    Map<String, String> d2 = net.one97.paytm.bankCommon.mapping.d.d(this.f17417c);
                    if (com.paytm.utility.b.c(this.f17417c)) {
                        a(this.f17418d);
                        HashMap hashMap = new HashMap();
                        hashMap.put("screen_name", getClass().getSimpleName());
                        a aVar = new a(b2, this, this, new CJRUserInfoV2(), d2, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap);
                        this.f17417c.getApplicationContext();
                        new c();
                        c.a(aVar);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        finish();
    }

    private static void a(LottieAnimationView lottieAnimationView) {
        lottieAnimationView.setVisibility(0);
        lottieAnimationView.setAnimation("Payments-Loader.json");
        lottieAnimationView.loop(true);
        lottieAnimationView.playAnimation();
    }

    private static void b(LottieAnimationView lottieAnimationView) {
        lottieAnimationView.cancelAnimation();
        lottieAnimationView.setVisibility(8);
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        b(this.f17418d);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* renamed from: a_ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onResponse(com.paytm.network.model.IJRPaytmDataModel r7) {
        /*
            r6 = this;
            com.airbnb.lottie.LottieAnimationView r0 = r6.f17418d
            b(r0)
            boolean r0 = r7 instanceof net.one97.paytm.bankCommon.model.auth.CJRUserInfoV2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0120
            net.one97.paytm.bankCommon.model.auth.CJRUserInfoV2 r7 = (net.one97.paytm.bankCommon.model.auth.CJRUserInfoV2) r7
            java.lang.String r0 = r7.getUserId()
            if (r0 == 0) goto L_0x011f
            net.one97.paytm.bankCommon.h.a r0 = net.one97.paytm.bankCommon.h.a.a()
            android.content.Context r0 = r0.f16275a
            android.content.Context r0 = r0.getApplicationContext()
            com.paytm.b.a.a r0 = net.one97.paytm.bankOpen.d.c.a(r0)
            long r3 = java.lang.System.currentTimeMillis()
            java.lang.String r5 = "bankServiceCache"
            r0.a((java.lang.String) r5, (long) r3, (boolean) r2)
            net.one97.paytm.paymentsBank.h.a r0 = net.one97.paytm.paymentsBank.utils.o.a()
            r0.saveUserInfo(r7, r6)
            java.util.ArrayList r7 = r7.getUserTypes()
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.Class r3 = r6.getClass()
            java.lang.String r3 = r3.getSimpleName()
            java.lang.String r4 = "screen_name"
            r0.put(r4, r3)
            net.one97.paytm.bankCommon.mapping.g.a()
            java.lang.String r0 = "checkPaymentBankLead"
            boolean r0 = net.one97.paytm.bankCommon.utils.d.a(r0, r2)
            java.lang.String r3 = "BANK_CUSTOMER"
            if (r0 == 0) goto L_0x00f1
            if (r7 == 0) goto L_0x00ed
            int r0 = r7.size()
            if (r0 <= 0) goto L_0x00ed
            java.lang.String r0 = "BANK_LEAD"
            boolean r4 = r7.contains(r0)
            if (r4 == 0) goto L_0x008b
            boolean r4 = r7.contains(r3)
            if (r4 != 0) goto L_0x008b
            net.one97.paytm.bankCommon.h.a r7 = net.one97.paytm.bankCommon.h.a.a()
            r7.f16276b = r6
            net.one97.paytm.bankCommon.h.a.a()
            com.paytm.network.a$c r7 = com.paytm.network.a.c.PAYMENTSBANK
            com.paytm.network.a$b r7 = com.paytm.network.a.b.SILENT
            boolean r7 = net.one97.paytm.bankCommon.h.a.a(r6)
            r6.f17416b = r7
            net.one97.paytm.bankCommon.h.b.b((android.content.Context) r6, (boolean) r2)
            net.one97.paytm.bankCommon.h.b.c((android.content.Context) r6, (boolean) r1)
            boolean r7 = r6.f17416b
            if (r7 != 0) goto L_0x011f
            r6.e()
            return
        L_0x008b:
            boolean r1 = r7.contains(r0)
            if (r1 == 0) goto L_0x00b2
            boolean r1 = r7.contains(r3)
            if (r1 == 0) goto L_0x00b2
            net.one97.paytm.bankCommon.h.a r7 = net.one97.paytm.bankCommon.h.a.a()
            r7.f16276b = r6
            net.one97.paytm.bankCommon.h.a.a()
            com.paytm.network.a$c r7 = com.paytm.network.a.c.PAYMENTSBANK
            com.paytm.network.a$b r7 = com.paytm.network.a.b.SILENT
            boolean r7 = net.one97.paytm.bankCommon.h.a.a(r6)
            r6.f17416b = r7
            boolean r7 = r6.f17416b
            if (r7 != 0) goto L_0x011f
            r6.e()
            return
        L_0x00b2:
            boolean r1 = r7.contains(r0)
            if (r1 != 0) goto L_0x00c2
            boolean r1 = r7.contains(r3)
            if (r1 != 0) goto L_0x00c2
            r6.f()
            return
        L_0x00c2:
            boolean r0 = r7.contains(r0)
            if (r0 != 0) goto L_0x00e9
            boolean r7 = r7.contains(r3)
            if (r7 == 0) goto L_0x00e9
            net.one97.paytm.bankCommon.h.a r7 = net.one97.paytm.bankCommon.h.a.a()
            r7.f16276b = r6
            net.one97.paytm.bankCommon.h.a.a()
            com.paytm.network.a$c r7 = com.paytm.network.a.c.PAYMENTSBANK
            com.paytm.network.a$b r7 = com.paytm.network.a.b.USER_FACING
            boolean r7 = net.one97.paytm.bankCommon.h.a.a(r6)
            r6.f17416b = r7
            boolean r7 = r6.f17416b
            if (r7 != 0) goto L_0x011f
            r6.e()
            return
        L_0x00e9:
            r6.f()
            return
        L_0x00ed:
            r6.f()
            return
        L_0x00f1:
            if (r7 == 0) goto L_0x00ff
            int r0 = r7.size()
            if (r0 <= 0) goto L_0x00ff
            boolean r7 = r7.contains(r3)
            if (r7 != 0) goto L_0x0105
        L_0x00ff:
            net.one97.paytm.bankCommon.h.b.b((android.content.Context) r6, (boolean) r2)
            net.one97.paytm.bankCommon.h.b.c((android.content.Context) r6, (boolean) r1)
        L_0x0105:
            net.one97.paytm.bankCommon.h.a r7 = net.one97.paytm.bankCommon.h.a.a()
            r7.f16276b = r6
            net.one97.paytm.bankCommon.h.a.a()
            com.paytm.network.a$c r7 = com.paytm.network.a.c.PAYMENTSBANK
            com.paytm.network.a$b r7 = com.paytm.network.a.b.USER_FACING
            boolean r7 = net.one97.paytm.bankCommon.h.a.a(r6)
            r6.f17416b = r7
            boolean r7 = r6.f17416b
            if (r7 != 0) goto L_0x011f
            r6.e()
        L_0x011f:
            return
        L_0x0120:
            boolean r0 = r7 instanceof net.one97.paytm.bankCommon.model.CustProductList
            if (r0 == 0) goto L_0x01b5
            net.one97.paytm.bankCommon.model.CustProductList r7 = (net.one97.paytm.bankCommon.model.CustProductList) r7
            java.lang.String r0 = r7.getIsaStatus()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01b5
            java.lang.String r7 = r7.getIsaStatus()
            r0 = -1
            int r3 = r7.hashCode()
            r4 = 3
            switch(r3) {
                case -2125830485: goto L_0x017a;
                case -1757359925: goto L_0x0170;
                case -604548089: goto L_0x0166;
                case -287297839: goto L_0x015c;
                case 2332508: goto L_0x0152;
                case 35394935: goto L_0x0148;
                case 2066319421: goto L_0x013e;
                default: goto L_0x013d;
            }
        L_0x013d:
            goto L_0x0184
        L_0x013e:
            java.lang.String r2 = "FAILED"
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x0184
            r7 = 2
            goto L_0x0185
        L_0x0148:
            java.lang.String r2 = "PENDING"
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x0184
            r7 = 5
            goto L_0x0185
        L_0x0152:
            java.lang.String r3 = "LEAD"
            boolean r7 = r7.equals(r3)
            if (r7 == 0) goto L_0x0184
            r7 = 1
            goto L_0x0185
        L_0x015c:
            java.lang.String r2 = "NOT_APPLIED"
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x0184
            r7 = 0
            goto L_0x0185
        L_0x0166:
            java.lang.String r2 = "IN_PROGRESS"
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x0184
            r7 = 3
            goto L_0x0185
        L_0x0170:
            java.lang.String r2 = "INITIATED"
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x0184
            r7 = 4
            goto L_0x0185
        L_0x017a:
            java.lang.String r2 = "ISSUED"
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x0184
            r7 = 6
            goto L_0x0185
        L_0x0184:
            r7 = -1
        L_0x0185:
            switch(r7) {
                case 0: goto L_0x019b;
                case 1: goto L_0x019b;
                case 2: goto L_0x0192;
                case 3: goto L_0x0192;
                case 4: goto L_0x0192;
                case 5: goto L_0x0192;
                case 6: goto L_0x0189;
                default: goto L_0x0188;
            }
        L_0x0188:
            goto L_0x01b5
        L_0x0189:
            net.one97.paytm.bankCommon.model.AccountStatus r7 = net.one97.paytm.bankCommon.model.AccountStatus.ISSUED
            net.one97.paytm.bankCommon.h.b.a((android.content.Context) r6, (net.one97.paytm.bankCommon.model.AccountStatus) r7)
            r6.g()
            goto L_0x01b5
        L_0x0192:
            net.one97.paytm.bankCommon.model.AccountStatus r7 = net.one97.paytm.bankCommon.model.AccountStatus.PROCESSING
            net.one97.paytm.bankCommon.h.b.a((android.content.Context) r6, (net.one97.paytm.bankCommon.model.AccountStatus) r7)
            r6.g()
            return
        L_0x019b:
            net.one97.paytm.bankCommon.model.AccountStatus r7 = net.one97.paytm.bankCommon.model.AccountStatus.NOT_APPLIED
            net.one97.paytm.bankCommon.h.b.a((android.content.Context) r6, (net.one97.paytm.bankCommon.model.AccountStatus) r7)
            android.content.Intent r7 = new android.content.Intent
            java.lang.Class<net.one97.paytm.bankOpen.activity.PaymentsBankBaseActivity> r0 = net.one97.paytm.bankOpen.activity.PaymentsBankBaseActivity.class
            r7.<init>(r6, r0)
            java.lang.String r0 = "extraDefaultFrame"
            r7.putExtra(r0, r4)
            r6.startActivity(r7)
            r6.overridePendingTransition(r1, r1)
            r6.finish()
        L_0x01b5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.activity.SavingsAccountActivity.onResponse(com.paytm.network.model.IJRPaytmDataModel):void");
    }

    private void e() {
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", getClass().getSimpleName());
        f a2 = net.one97.paytm.paymentsBank.b.a.a(this.f17417c, (g.b<IJRPaytmDataModel>) this, (g.a) this, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap);
        if (com.paytm.utility.b.c(this.f17417c)) {
            a(this.f17418d);
            this.f17417c.getApplicationContext();
            new c();
            c.a(a2);
        }
    }

    private void f() {
        b.c((Context) this, true);
        finish();
    }

    private void g() {
        Intent intent = new Intent(this, o.a().getMainActivityClass());
        intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, CJRPGTransactionRequestUtils.PAYER_BANK_NAME);
        intent.setFlags(67108864);
        if (getIntent() != null) {
            if (getIntent().hasExtra("is_deep_linking_data")) {
                intent.putExtra("is_deep_linking_data", getIntent().getBooleanExtra("is_deep_linking_data", false));
            }
            if (getIntent().hasExtra("extra_home_data")) {
                intent.putExtra("extra_home_data", getIntent().getSerializableExtra("extra_home_data"));
            }
        }
        startActivity(intent);
        finish();
    }
}
