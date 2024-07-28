package net.one97.paytm.paymentsBank.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.paytm.c.b;
import com.paytm.utility.q;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import kotlin.g.b.k;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.bankOpen.f;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.utils.n;

public final class BankFlowActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private DeepLinkData f17368a;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_bank_flow);
        if (n.V()) {
            b.a(getApplicationContext(), n.W(), new a(this));
        } else {
            a();
        }
    }

    public static final class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BankFlowActivity f17369a;

        a(BankFlowActivity bankFlowActivity) {
            this.f17369a = bankFlowActivity;
        }

        public final void a(boolean z) {
            if (z) {
                this.f17369a.startActivity(new Intent(this.f17369a, RootedDeviceActivity.class));
                this.f17369a.finish();
                return;
            }
            this.f17369a.a();
        }

        public final void a() {
            q.b("playServicesNotUpdated");
            this.f17369a.a();
        }

        public final void a(Exception exc) {
            k.c(exc, "e");
            q.b(exc.getMessage());
            this.f17369a.a();
        }
    }

    /* access modifiers changed from: private */
    public final void a() {
        if (getIntent() != null && getIntent().hasExtra("EXTRA_DEEP_LINK_DATA")) {
            this.f17368a = (DeepLinkData) getIntent().getParcelableExtra("EXTRA_DEEP_LINK_DATA");
        }
        if (getIntent() != null) {
            Intent intent = getIntent();
            k.a((Object) intent, "intent");
            if (!TextUtils.isEmpty(intent.getAction())) {
                Intent intent2 = getIntent();
                k.a((Object) intent2, "intent");
                if (intent2.getAction().equals("open_passcode_screen")) {
                    b();
                    return;
                }
            }
        }
        if (getIntent() != null) {
            Intent intent3 = getIntent();
            k.a((Object) intent3, "intent");
            if (!TextUtils.isEmpty(intent3.getAction())) {
                Intent intent4 = getIntent();
                k.a((Object) intent4, "intent");
                if (intent4.getAction().equals("open_passcode_screen_consent_ppb")) {
                    b();
                    return;
                }
            }
        }
        c();
    }

    private final void b() {
        Intent intent = new Intent();
        intent.setClass(this, PBWalletPassBookBridgeActivity.class);
        intent.setFlags(33554432);
        Intent intent2 = getIntent();
        k.a((Object) intent2, "intent");
        Bundle extras = intent2.getExtras();
        if (extras != null) {
            intent.putExtras(extras);
        }
        startActivity(intent);
        finish();
    }

    private final void c() {
        startActivityForResult(new Intent(this, BankStatusCheckingActivity.class), 1);
    }

    private final void d() {
        Intent intent = new Intent(this, BankTabActivity.class);
        intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, CJRPGTransactionRequestUtils.PAYER_BANK_NAME);
        startActivity(intent);
        finish();
    }

    /* JADX WARNING: Removed duplicated region for block: B:282:0x0515  */
    /* JADX WARNING: Removed duplicated region for block: B:286:0x0537  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityResult(int r24, int r25, android.content.Intent r26) {
        /*
            r23 = this;
            r1 = r23
            r2 = r24
            r3 = r25
            r4 = r26
            super.onActivityResult(r24, r25, r26)
            r5 = -1
            r6 = 1
            if (r2 != r6) goto L_0x0755
            if (r3 != r5) goto L_0x0752
            java.lang.String r0 = "open_acc_base"
            r7 = 0
            java.lang.String r8 = "extraDefaultFrame"
            if (r4 == 0) goto L_0x009c
            r9 = 0
            java.lang.String r10 = "pb_new_account_flow"
            boolean r10 = r4.getBooleanExtra(r10, r9)
            if (r10 == 0) goto L_0x009c
            java.lang.String r10 = "pb_page"
            int r9 = r4.getIntExtra(r10, r9)
            android.content.Intent r10 = new android.content.Intent
            r11 = r1
            android.content.Context r11 = (android.content.Context) r11
            java.lang.Class<net.one97.paytm.bankOpen.activity.PaymentsBankBaseActivity> r12 = net.one97.paytm.bankOpen.activity.PaymentsBankBaseActivity.class
            r10.<init>(r11, r12)
            net.one97.paytm.deeplink.DeepLinkData r11 = r1.f17368a
            if (r11 == 0) goto L_0x0091
            if (r11 == 0) goto L_0x003a
            java.lang.String r11 = r11.f50288f
            goto L_0x003b
        L_0x003a:
            r11 = r7
        L_0x003b:
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = android.text.TextUtils.isEmpty(r11)
            if (r11 != 0) goto L_0x0091
            net.one97.paytm.deeplink.DeepLinkData r11 = r1.f17368a
            if (r11 == 0) goto L_0x0049
            java.lang.String r7 = r11.f50288f
        L_0x0049:
            boolean r0 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x0091
            net.one97.paytm.deeplink.DeepLinkData r0 = r1.f17368a
            if (r0 != 0) goto L_0x0056
            kotlin.g.b.k.a()
        L_0x0056:
            android.net.Uri r0 = r0.f50289g
            if (r0 == 0) goto L_0x008d
            net.one97.paytm.deeplink.DeepLinkData r0 = r1.f17368a
            if (r0 != 0) goto L_0x0061
            kotlin.g.b.k.a()
        L_0x0061:
            android.net.Uri r0 = r0.f50289g
            if (r0 != 0) goto L_0x0068
            kotlin.g.b.k.a()
        L_0x0068:
            java.lang.String r0 = r0.getQueryParameter(r8)
            if (r0 == 0) goto L_0x008d
            net.one97.paytm.deeplink.DeepLinkData r0 = r1.f17368a
            if (r0 != 0) goto L_0x0075
            kotlin.g.b.k.a()
        L_0x0075:
            android.net.Uri r0 = r0.f50289g
            if (r0 != 0) goto L_0x007c
            kotlin.g.b.k.a()
        L_0x007c:
            java.lang.String r0 = r0.getQueryParameter(r8)
            if (r0 != 0) goto L_0x0085
            kotlin.g.b.k.a()
        L_0x0085:
            int r0 = java.lang.Integer.parseInt(r0)
            r10.putExtra(r8, r0)
            goto L_0x0094
        L_0x008d:
            r10.putExtra(r8, r9)
            goto L_0x0094
        L_0x0091:
            r10.putExtra(r8, r9)
        L_0x0094:
            r1.startActivity(r10)
            r23.finish()
            goto L_0x0755
        L_0x009c:
            net.one97.paytm.deeplink.DeepLinkData r9 = r1.f17368a
            java.lang.String r10 = "activate_pdc"
            r11 = 33554432(0x2000000, float:9.403955E-38)
            r12 = 0
            if (r9 == 0) goto L_0x0553
            if (r9 != 0) goto L_0x00ab
            kotlin.g.b.k.a()
        L_0x00ab:
            java.lang.String r9 = r9.f50288f
            if (r9 == 0) goto L_0x0553
            net.one97.paytm.deeplink.DeepLinkData r9 = r1.f17368a
            if (r9 != 0) goto L_0x00b6
            kotlin.g.b.k.a()
        L_0x00b6:
            java.lang.String r9 = r9.f50288f
            boolean r9 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r9 == 0) goto L_0x0112
            android.content.Intent r0 = new android.content.Intent
            r6 = r1
            android.content.Context r6 = (android.content.Context) r6
            java.lang.Class<net.one97.paytm.bankOpen.activity.PaymentsBankBaseActivity> r7 = net.one97.paytm.bankOpen.activity.PaymentsBankBaseActivity.class
            r0.<init>(r6, r7)
            net.one97.paytm.deeplink.DeepLinkData r6 = r1.f17368a
            if (r6 != 0) goto L_0x00cf
            kotlin.g.b.k.a()
        L_0x00cf:
            android.net.Uri r6 = r6.f50289g
            if (r6 == 0) goto L_0x0106
            net.one97.paytm.deeplink.DeepLinkData r6 = r1.f17368a
            if (r6 != 0) goto L_0x00da
            kotlin.g.b.k.a()
        L_0x00da:
            android.net.Uri r6 = r6.f50289g
            if (r6 != 0) goto L_0x00e1
            kotlin.g.b.k.a()
        L_0x00e1:
            java.lang.String r6 = r6.getQueryParameter(r8)
            if (r6 == 0) goto L_0x0106
            net.one97.paytm.deeplink.DeepLinkData r6 = r1.f17368a
            if (r6 != 0) goto L_0x00ee
            kotlin.g.b.k.a()
        L_0x00ee:
            android.net.Uri r6 = r6.f50289g
            if (r6 != 0) goto L_0x00f5
            kotlin.g.b.k.a()
        L_0x00f5:
            java.lang.String r6 = r6.getQueryParameter(r8)
            if (r6 != 0) goto L_0x00fe
            kotlin.g.b.k.a()
        L_0x00fe:
            int r6 = java.lang.Integer.parseInt(r6)
            r0.putExtra(r8, r6)
            goto L_0x010a
        L_0x0106:
            r6 = 3
            r0.putExtra(r8, r6)
        L_0x010a:
            r1.startActivity(r0)
            r23.finish()
            goto L_0x0755
        L_0x0112:
            net.one97.paytm.deeplink.DeepLinkData r9 = r1.f17368a
            if (r9 != 0) goto L_0x0119
            kotlin.g.b.k.a()
        L_0x0119:
            java.lang.String r9 = r9.f50288f
            java.lang.String r14 = "bank_acc_requeseted"
            boolean r9 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r14, (boolean) r6)
            if (r9 == 0) goto L_0x0167
            net.one97.paytm.deeplink.DeepLinkData r0 = r1.f17368a
            if (r0 != 0) goto L_0x012a
            kotlin.g.b.k.a()
        L_0x012a:
            android.content.Intent r6 = new android.content.Intent
            r7 = r1
            android.content.Context r7 = (android.content.Context) r7
            java.lang.Class<net.one97.paytm.bankOpen.activity.BankAccountOpenReqSubmittedActivity> r9 = net.one97.paytm.bankOpen.activity.BankAccountOpenReqSubmittedActivity.class
            r6.<init>(r7, r9)
            if (r0 != 0) goto L_0x0139
            kotlin.g.b.k.a()
        L_0x0139:
            android.net.Uri r7 = r0.f50289g
            java.lang.String r9 = "middle_text"
            if (r7 == 0) goto L_0x0156
            android.net.Uri r0 = r0.f50289g
            if (r0 != 0) goto L_0x0146
            kotlin.g.b.k.a()
        L_0x0146:
            java.lang.String r0 = r0.getQueryParameter(r9)
            if (r0 != 0) goto L_0x014f
            kotlin.g.b.k.a()
        L_0x014f:
            int r0 = java.lang.Integer.parseInt(r0)
            r6.putExtra(r9, r0)
        L_0x0156:
            int r0 = net.one97.paytm.paymentsBank.R.string.bank_acc_open_after_verified
            java.lang.String r0 = r1.getString(r0)
            r6.putExtra(r9, r0)
            r1.startActivity(r6)
            r23.finish()
            goto L_0x0553
        L_0x0167:
            net.one97.paytm.deeplink.DeepLinkData r9 = r1.f17368a
            if (r9 != 0) goto L_0x016e
            kotlin.g.b.k.a()
        L_0x016e:
            java.lang.String r9 = r9.f50288f
            java.lang.String r14 = "redeem_fd"
            boolean r9 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r14, (boolean) r6)
            if (r9 != 0) goto L_0x04dd
            net.one97.paytm.deeplink.DeepLinkData r9 = r1.f17368a
            if (r9 != 0) goto L_0x017f
            kotlin.g.b.k.a()
        L_0x017f:
            java.lang.String r9 = r9.f50288f
            java.lang.String r14 = "fd_break"
            boolean r9 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r14, (boolean) r6)
            if (r9 == 0) goto L_0x018b
            goto L_0x04dd
        L_0x018b:
            net.one97.paytm.deeplink.DeepLinkData r9 = r1.f17368a
            if (r9 != 0) goto L_0x0192
            kotlin.g.b.k.a()
        L_0x0192:
            java.lang.String r9 = r9.f50288f
            java.lang.String r14 = "activate_dormant_acc"
            boolean r9 = kotlin.m.p.a((java.lang.String) r14, (java.lang.String) r9, (boolean) r6)
            if (r9 == 0) goto L_0x01b5
            android.content.Intent r0 = new android.content.Intent
            r6 = r1
            android.content.Context r6 = (android.content.Context) r6
            java.lang.Class<net.one97.paytm.paymentsBank.forgotpasscode.ForgotPasscodeChallengesActivity> r7 = net.one97.paytm.paymentsBank.forgotpasscode.ForgotPasscodeChallengesActivity.class
            r0.<init>(r6, r7)
            java.lang.String r6 = "activity_flow"
            java.lang.String r7 = "ACTIVATE_ACCOUNT"
            r0.putExtra(r6, r7)
            r1.startActivity(r0)
            r23.finish()
            goto L_0x0553
        L_0x01b5:
            net.one97.paytm.deeplink.DeepLinkData r9 = r1.f17368a
            if (r9 != 0) goto L_0x01bc
            kotlin.g.b.k.a()
        L_0x01bc:
            java.lang.String r9 = r9.f50288f
            if (r9 == 0) goto L_0x04d5
            java.lang.String r14 = "manage_debit"
            boolean r14 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r14, (boolean) r6)
            if (r14 == 0) goto L_0x01f0
            net.one97.paytm.payments.c.c.b r0 = net.one97.paytm.payments.c.c.b.f17264a
            boolean r0 = net.one97.paytm.payments.c.c.b.d()
            if (r0 == 0) goto L_0x01de
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            net.one97.paytm.payments.c.c.b r7 = net.one97.paytm.payments.c.c.b.f17264a
            r7 = r1
            android.content.Context r7 = (android.content.Context) r7
            net.one97.paytm.payments.c.c.b.a(r7, r0)
            goto L_0x01eb
        L_0x01de:
            android.content.Intent r0 = new android.content.Intent
            r7 = r1
            android.content.Context r7 = (android.content.Context) r7
            java.lang.Class<net.one97.paytm.paymentsBank.activity.ManageDebitCardActivity> r14 = net.one97.paytm.paymentsBank.activity.ManageDebitCardActivity.class
            r0.<init>(r7, r14)
            r1.startActivity(r0)
        L_0x01eb:
            r23.finish()
            goto L_0x0491
        L_0x01f0:
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x0208
            android.content.Intent r0 = new android.content.Intent
            r7 = r1
            android.content.Context r7 = (android.content.Context) r7
            java.lang.Class<net.one97.paytm.bankOpen.activity.PaymentsBankBaseActivity> r14 = net.one97.paytm.bankOpen.activity.PaymentsBankBaseActivity.class
            r0.<init>(r7, r14)
            r1.startActivity(r0)
            r23.finish()
            goto L_0x0491
        L_0x0208:
            java.lang.String r0 = "savings_acc"
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x0222
            android.content.Intent r0 = new android.content.Intent
            r7 = r1
            android.content.Context r7 = (android.content.Context) r7
            java.lang.Class<net.one97.paytm.paymentsBank.activity.SavingsAccountActivity> r14 = net.one97.paytm.paymentsBank.activity.SavingsAccountActivity.class
            r0.<init>(r7, r14)
            r1.startActivity(r0)
            r23.finish()
            goto L_0x0491
        L_0x0222:
            java.lang.String r0 = "savings_acc_info"
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x023c
            android.content.Intent r0 = new android.content.Intent
            r7 = r1
            android.content.Context r7 = (android.content.Context) r7
            java.lang.Class<net.one97.paytm.paymentsBank.activity.SavingsAccountInfoActivity> r14 = net.one97.paytm.paymentsBank.activity.SavingsAccountInfoActivity.class
            r0.<init>(r7, r14)
            r1.startActivity(r0)
            r23.finish()
            goto L_0x0491
        L_0x023c:
            java.lang.String r0 = "set_passcode"
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x0256
            android.content.Intent r0 = new android.content.Intent
            r7 = r1
            android.content.Context r7 = (android.content.Context) r7
            java.lang.Class<net.one97.paytm.payments.activity.AJRSetPasscode> r14 = net.one97.paytm.payments.activity.AJRSetPasscode.class
            r0.<init>(r7, r14)
            r1.startActivity(r0)
            r23.finish()
            goto L_0x0491
        L_0x0256:
            java.lang.String r0 = "enter_passcode"
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x0273
            android.content.Intent r0 = new android.content.Intent
            r7 = r1
            android.content.Context r7 = (android.content.Context) r7
            java.lang.Class<net.one97.paytm.payments.activity.AJREnterPasscode> r14 = net.one97.paytm.payments.activity.AJREnterPasscode.class
            r0.<init>(r7, r14)
            r0.setFlags(r11)
            r1.startActivity(r0)
            r23.finish()
            goto L_0x0491
        L_0x0273:
            java.lang.String r0 = "fgt_passcode"
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x0286
            r0 = r1
            android.content.Context r0 = (android.content.Context) r0
            net.one97.paytm.paymentsBank.forgotpasscode.ForgotPasscodeChallengesActivity.b((android.content.Context) r0)
            r23.finish()
            goto L_0x0491
        L_0x0286:
            java.lang.String r0 = "change_passcode"
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x02a0
            android.content.Intent r0 = new android.content.Intent
            r7 = r1
            android.content.Context r7 = (android.content.Context) r7
            java.lang.Class<net.one97.paytm.payments.activity.AJRChangePasscode> r14 = net.one97.paytm.payments.activity.AJRChangePasscode.class
            r0.<init>(r7, r14)
            r1.startActivity(r0)
            r23.finish()
            goto L_0x0491
        L_0x02a0:
            java.lang.String r0 = "bank_landing"
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x02ad
            r23.d()
            goto L_0x0491
        L_0x02ad:
            java.lang.String r0 = "bank_acc_opened"
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x02c7
            android.content.Intent r0 = new android.content.Intent
            r7 = r1
            android.content.Context r7 = (android.content.Context) r7
            java.lang.Class<net.one97.paytm.bankOpen.activity.BankAccountOpenedActivity> r14 = net.one97.paytm.bankOpen.activity.BankAccountOpenedActivity.class
            r0.<init>(r7, r14)
            r1.startActivity(r0)
            r23.finish()
            goto L_0x0491
        L_0x02c7:
            java.lang.String r0 = "add_pan_card"
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            java.lang.String r14 = "bank"
            if (r0 == 0) goto L_0x02eb
            net.one97.paytm.paymentsBank.h.a r0 = net.one97.paytm.paymentsBank.utils.o.a()     // Catch:{ UnsupportedEncodingException -> 0x02e5 }
            r7 = r1
            android.content.Context r7 = (android.content.Context) r7     // Catch:{ UnsupportedEncodingException -> 0x02e5 }
            java.lang.String r15 = net.one97.paytm.paymentsBank.utils.e.b()     // Catch:{ UnsupportedEncodingException -> 0x02e5 }
            java.lang.String r14 = net.one97.paytm.paymentsBank.utils.e.a(r15, r14)     // Catch:{ UnsupportedEncodingException -> 0x02e5 }
            r0.checkDeepLinking(r7, r14)     // Catch:{ UnsupportedEncodingException -> 0x02e5 }
            goto L_0x0491
        L_0x02e5:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0491
        L_0x02eb:
            java.lang.String r0 = "add_aadhar_card"
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x030d
            net.one97.paytm.paymentsBank.h.a r0 = net.one97.paytm.paymentsBank.utils.o.a()     // Catch:{ UnsupportedEncodingException -> 0x0307 }
            r7 = r1
            android.content.Context r7 = (android.content.Context) r7     // Catch:{ UnsupportedEncodingException -> 0x0307 }
            java.lang.String r15 = net.one97.paytm.paymentsBank.utils.e.b()     // Catch:{ UnsupportedEncodingException -> 0x0307 }
            java.lang.String r14 = net.one97.paytm.paymentsBank.utils.e.b(r15, r14)     // Catch:{ UnsupportedEncodingException -> 0x0307 }
            r0.checkDeepLinking(r7, r14)     // Catch:{ UnsupportedEncodingException -> 0x0307 }
            goto L_0x0491
        L_0x0307:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x0491
        L_0x030d:
            java.lang.String r0 = "upgrade_kyc"
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x0346
            net.one97.paytm.paymentsBank.h.a r0 = net.one97.paytm.paymentsBank.utils.o.a()     // Catch:{ UnsupportedEncodingException -> 0x033d }
            r7 = r1
            android.content.Context r7 = (android.content.Context) r7     // Catch:{ UnsupportedEncodingException -> 0x033d }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ UnsupportedEncodingException -> 0x033d }
            r15.<init>()     // Catch:{ UnsupportedEncodingException -> 0x033d }
            java.lang.String r16 = net.one97.paytm.paymentsBank.utils.e.a()     // Catch:{ UnsupportedEncodingException -> 0x033d }
            java.lang.String r5 = r16.toString()     // Catch:{ UnsupportedEncodingException -> 0x033d }
            r15.append(r5)     // Catch:{ UnsupportedEncodingException -> 0x033d }
            java.lang.String r5 = "payment_bank?open_screen=bank_kyc_status_screen"
            r15.append(r5)     // Catch:{ UnsupportedEncodingException -> 0x033d }
            java.lang.String r5 = r15.toString()     // Catch:{ UnsupportedEncodingException -> 0x033d }
            java.lang.String r5 = net.one97.paytm.paymentsBank.utils.e.c(r5, r14)     // Catch:{ UnsupportedEncodingException -> 0x033d }
            r0.checkDeepLinking(r7, r5)     // Catch:{ UnsupportedEncodingException -> 0x033d }
            goto L_0x0341
        L_0x033d:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0341:
            r23.finish()
            goto L_0x0491
        L_0x0346:
            java.lang.String r0 = "alter_nominee"
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x0353
            r23.d()
            goto L_0x0491
        L_0x0353:
            java.lang.String r0 = "nach_mandate"
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x0360
            r23.d()
            goto L_0x0491
        L_0x0360:
            java.lang.String r0 = "savings_account_passbook_tab"
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x036d
            r23.d()
            goto L_0x0491
        L_0x036d:
            java.lang.String r0 = "manage_debit"
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x037a
            r23.d()
            goto L_0x0491
        L_0x037a:
            java.lang.String r0 = "forgot_atm_pin"
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x0387
            r23.d()
            goto L_0x0491
        L_0x0387:
            java.lang.String r0 = "request_atm"
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x0394
            r23.d()
            goto L_0x0491
        L_0x0394:
            java.lang.String r0 = "track_atm_order"
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x03a1
            r23.d()
            goto L_0x0491
        L_0x03a1:
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r10, (boolean) r6)
            if (r0 == 0) goto L_0x03f2
            net.one97.paytm.payments.c.c.b r0 = net.one97.paytm.payments.c.c.b.f17264a
            boolean r0 = net.one97.paytm.payments.c.c.b.d()
            if (r0 == 0) goto L_0x03ed
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            net.one97.paytm.paymentsBank.utils.l r5 = net.one97.paytm.paymentsBank.utils.l.a()
            java.lang.String r14 = "PDCSingletonHolder.getInstance()"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r14)
            java.lang.String r5 = r5.c()
            net.one97.paytm.paymentsBank.utils.l r15 = net.one97.paytm.paymentsBank.utils.l.a()
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r14)
            java.lang.String r15 = r15.b()
            java.lang.String r11 = "goToScreen"
            r0.putString(r11, r15)
            java.lang.String r11 = "pdc_qrcode_id"
            r0.putString(r11, r5)
            net.one97.paytm.payments.c.c.b r5 = net.one97.paytm.payments.c.c.b.f17264a
            r5 = r1
            android.content.Context r5 = (android.content.Context) r5
            net.one97.paytm.payments.c.c.b.a(r5, r0)
            net.one97.paytm.paymentsBank.utils.l r0 = net.one97.paytm.paymentsBank.utils.l.a()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r14)
            r0.a((java.lang.String) r7)
            r23.finish()
            goto L_0x0491
        L_0x03ed:
            r23.d()
            goto L_0x0491
        L_0x03f2:
            java.lang.String r0 = "block_card"
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x03ff
            r23.d()
            goto L_0x0491
        L_0x03ff:
            java.lang.String r0 = "fd_projection"
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x040c
            r23.d()
            goto L_0x0491
        L_0x040c:
            java.lang.String r0 = "fd_interest_certificate"
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x0419
            r23.d()
            goto L_0x0491
        L_0x0419:
            java.lang.String r0 = "fd_tds_certificate"
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x0426
            r23.d()
            goto L_0x0491
        L_0x0426:
            java.lang.String r0 = "fd_form_15"
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x0432
            r23.d()
            goto L_0x0491
        L_0x0432:
            java.lang.String r0 = "fd_break"
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x043e
            r23.d()
            goto L_0x0491
        L_0x043e:
            java.lang.String r0 = "fd_interest_table"
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x044a
            r23.d()
            goto L_0x0491
        L_0x044a:
            java.lang.String r0 = "fd_benefits"
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x0456
            r23.d()
            goto L_0x0491
        L_0x0456:
            java.lang.String r0 = "fd_passbook"
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x0462
            r23.d()
            goto L_0x0491
        L_0x0462:
            java.lang.String r0 = "fixed_deposit"
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x046e
            r23.d()
            goto L_0x0491
        L_0x046e:
            java.lang.String r0 = "create_fd"
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x047a
            r23.d()
            goto L_0x0491
        L_0x047a:
            java.lang.String r0 = "withdraw_cash_nearby"
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x0486
            r23.d()
            goto L_0x0491
        L_0x0486:
            java.lang.String r0 = "dc_payment_settings"
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x0491
            r23.d()
        L_0x0491:
            java.lang.String r0 = "dbt"
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x049c
            r23.d()
        L_0x049c:
            java.lang.String r0 = "change_atm_pin"
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x04a7
            r23.d()
        L_0x04a7:
            java.lang.String r0 = "retry_request_atm"
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x04b2
            r23.d()
        L_0x04b2:
            java.lang.String r0 = "cheque_book"
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x04bd
            r23.d()
        L_0x04bd:
            java.lang.String r0 = "automatic_payments"
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x04c8
            r23.d()
        L_0x04c8:
            java.lang.String r0 = "create_cif"
            boolean r0 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r0, (boolean) r6)
            if (r0 == 0) goto L_0x0553
            r23.d()
            goto L_0x0553
        L_0x04d5:
            kotlin.u r0 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.String"
            r0.<init>(r2)
            throw r0
        L_0x04dd:
            net.one97.paytm.deeplink.DeepLinkData r0 = r1.f17368a
            if (r0 != 0) goto L_0x04e4
            kotlin.g.b.k.a()
        L_0x04e4:
            android.net.Uri r5 = r0.f50289g
            java.lang.String r7 = "amount_to_redeem"
            if (r5 == 0) goto L_0x050c
            android.net.Uri r5 = r0.f50289g
            if (r5 != 0) goto L_0x04f1
            kotlin.g.b.k.a()
        L_0x04f1:
            java.lang.String r5 = r5.getQueryParameter(r7)
            if (r5 == 0) goto L_0x050c
            android.net.Uri r5 = r0.f50289g
            if (r5 != 0) goto L_0x04fe
            kotlin.g.b.k.a()
        L_0x04fe:
            java.lang.String r5 = r5.getQueryParameter(r7)
            if (r5 != 0) goto L_0x0507
            kotlin.g.b.k.a()
        L_0x0507:
            double r14 = java.lang.Double.parseDouble(r5)
            goto L_0x050d
        L_0x050c:
            r14 = r12
        L_0x050d:
            net.one97.paytm.payments.c.c.b r5 = net.one97.paytm.payments.c.c.b.f17264a
            boolean r5 = net.one97.paytm.payments.c.c.b.a()
            if (r5 == 0) goto L_0x0537
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
            java.lang.String r0 = r0.f50288f
            java.lang.String r6 = "goToScreen"
            r5.putString(r6, r0)
            int r0 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r0 == 0) goto L_0x052c
            java.lang.String r0 = java.lang.String.valueOf(r14)
            r5.putString(r7, r0)
        L_0x052c:
            net.one97.paytm.payments.c.c.b r0 = net.one97.paytm.payments.c.c.b.f17264a
            r0 = r1
            android.content.Context r0 = (android.content.Context) r0
            java.lang.String r6 = "home"
            net.one97.paytm.payments.c.c.b.a(r0, r5, r6)
            goto L_0x0550
        L_0x0537:
            android.content.Intent r0 = new android.content.Intent
            r5 = r1
            android.content.Context r5 = (android.content.Context) r5
            java.lang.Class<net.one97.paytm.paymentsBank.slfd.redeemFd.RedeemFdActivity> r9 = net.one97.paytm.paymentsBank.slfd.redeemFd.RedeemFdActivity.class
            r0.<init>(r5, r9)
            java.lang.String r5 = "from_deeplink"
            r0.putExtra(r5, r6)
            int r5 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r5 == 0) goto L_0x054d
            r0.putExtra(r7, r14)
        L_0x054d:
            r1.startActivity(r0)
        L_0x0550:
            r23.finish()
        L_0x0553:
            android.content.Intent r0 = r23.getIntent()
            java.lang.String r5 = "intent"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            java.lang.String r0 = r0.getAction()
            android.content.Intent r6 = r23.getIntent()
            if (r6 == 0) goto L_0x0755
            r7 = r0
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0755
            if (r0 != 0) goto L_0x0573
            goto L_0x0755
        L_0x0573:
            int r7 = r0.hashCode()
            switch(r7) {
                case -1715484902: goto L_0x073b;
                case -1194392669: goto L_0x0726;
                case -959322835: goto L_0x070f;
                case 28784611: goto L_0x06ef;
                case 275753525: goto L_0x06b9;
                case 307452710: goto L_0x0631;
                case 842327227: goto L_0x0614;
                case 1048800749: goto L_0x05fc;
                case 1450922160: goto L_0x05df;
                case 1546312108: goto L_0x05c7;
                case 1979203079: goto L_0x057c;
                default: goto L_0x057a;
            }
        L_0x057a:
            goto L_0x0755
        L_0x057c:
            java.lang.String r5 = "slfd_from_passbook"
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L_0x0755
            net.one97.paytm.payments.c.c.b r5 = net.one97.paytm.payments.c.c.b.f17264a
            boolean r5 = net.one97.paytm.payments.c.c.b.a()
            if (r5 == 0) goto L_0x05a1
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
            java.lang.String r6 = "action"
            r5.putString(r6, r0)
            net.one97.paytm.payments.c.c.b r0 = net.one97.paytm.payments.c.c.b.f17264a
            r0 = r1
            android.content.Context r0 = (android.content.Context) r0
            java.lang.String r6 = "home"
            net.one97.paytm.payments.c.c.b.a(r0, r5, r6)
            goto L_0x05c2
        L_0x05a1:
            r0 = r1
            android.content.Context r0 = (android.content.Context) r0
            java.lang.String r5 = "ISA"
            net.one97.paytm.bankCommon.h.b.a((android.content.Context) r0, (java.lang.String) r5)
            r17 = r1
            android.app.Activity r17 = (android.app.Activity) r17
            java.lang.String r0 = "fdBal"
            double r18 = r6.getDoubleExtra(r0, r12)
            java.lang.String r0 = "accNo"
            java.lang.String r20 = r6.getStringExtra(r0)
            java.lang.String r0 = "saBal"
            double r21 = r6.getDoubleExtra(r0, r12)
            net.one97.paytm.paymentsBank.slfd.d.a((android.app.Activity) r17, (double) r18, (java.lang.String) r20, (double) r21)
        L_0x05c2:
            r23.finish()
            goto L_0x0755
        L_0x05c7:
            java.lang.String r5 = "open_slfd"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x0755
            r0 = r1
            android.content.Context r0 = (android.content.Context) r0
            java.lang.Class<net.one97.paytm.paymentsBank.slfd.SlfdBaseActivity> r5 = net.one97.paytm.paymentsBank.slfd.SlfdBaseActivity.class
            r6.setClass(r0, r5)
            r1.startActivity(r6)
            r23.finish()
            goto L_0x0755
        L_0x05df:
            java.lang.String r5 = "passcode_activity"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x0755
            r0 = r1
            android.content.Context r0 = (android.content.Context) r0
            java.lang.Class<net.one97.paytm.paymentsBank.activity.PBEnteringFlowPasscodeActivity> r5 = net.one97.paytm.paymentsBank.activity.PBEnteringFlowPasscodeActivity.class
            r6.setClass(r0, r5)
            r5 = 33554432(0x2000000, float:9.403955E-38)
            r6.setFlags(r5)
            r1.startActivity(r6)
            r23.finish()
            goto L_0x0755
        L_0x05fc:
            java.lang.String r5 = "open_ica_acc_opening"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x0755
            r0 = r1
            android.content.Context r0 = (android.content.Context) r0
            java.lang.Class<net.one97.paytm.bankOpen.ica.activity.ICAAccountOpeningActivity> r5 = net.one97.paytm.bankOpen.ica.activity.ICAAccountOpeningActivity.class
            r6.setClass(r0, r5)
            r1.startActivity(r6)
            r23.finish()
            goto L_0x0755
        L_0x0614:
            java.lang.String r5 = "set_passcode"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x0755
            r0 = r1
            android.content.Context r0 = (android.content.Context) r0
            java.lang.Class<net.one97.paytm.payments.activity.AJRSetPasscode> r5 = net.one97.paytm.payments.activity.AJRSetPasscode.class
            r6.setClass(r0, r5)
            r5 = 33554432(0x2000000, float:9.403955E-38)
            r6.setFlags(r5)
            r1.startActivity(r6)
            r23.finish()
            goto L_0x0755
        L_0x0631:
            java.lang.String r6 = "fd_create_new_task"
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x0755
            net.one97.paytm.paymentsBank.utils.l r0 = net.one97.paytm.paymentsBank.utils.l.a()
            net.one97.paytm.payments.c.c.a r0 = r0.d()
            boolean r0 = r0 instanceof net.one97.paytm.payments.c.a.b
            java.lang.String r6 = "status"
            if (r0 == 0) goto L_0x067f
            net.one97.paytm.paymentsBank.createfd.utils.b$a r0 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a
            int r0 = net.one97.paytm.paymentsBank.createfd.utils.b.f18188c
            android.content.Intent r7 = r23.getIntent()
            boolean r7 = r7.hasExtra(r6)
            if (r7 == 0) goto L_0x066b
            android.content.Intent r0 = r23.getIntent()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            android.os.Bundle r0 = r0.getExtras()
            if (r0 != 0) goto L_0x0667
            kotlin.g.b.k.a()
        L_0x0667:
            int r0 = r0.getInt(r6)
        L_0x066b:
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
            r5.putInt(r6, r0)
            net.one97.paytm.paymentsBank.utils.l r0 = net.one97.paytm.paymentsBank.utils.l.a()
            net.one97.paytm.payments.c.c.a r0 = r0.d()
            r0.a(r5)
            goto L_0x06b4
        L_0x067f:
            android.content.Intent r0 = new android.content.Intent
            r5 = r1
            android.content.Context r5 = (android.content.Context) r5
            java.lang.Class<net.one97.paytm.paymentsBank.createfd.activity.CreateFdActivity> r7 = net.one97.paytm.paymentsBank.createfd.activity.CreateFdActivity.class
            r0.<init>(r5, r7)
            android.content.Intent r5 = r23.getIntent()
            boolean r5 = r5.hasExtra(r6)
            if (r5 == 0) goto L_0x06ac
            android.content.Intent r5 = r23.getIntent()
            java.lang.String r7 = "getIntent()"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r7)
            android.os.Bundle r5 = r5.getExtras()
            if (r5 != 0) goto L_0x06a5
            kotlin.g.b.k.a()
        L_0x06a5:
            int r5 = r5.getInt(r6)
            r0.putExtra(r6, r5)
        L_0x06ac:
            r5 = 603979776(0x24000000, float:2.7755576E-17)
            r0.setFlags(r5)
            r1.startActivity(r0)
        L_0x06b4:
            r23.finish()
            goto L_0x0755
        L_0x06b9:
            java.lang.String r5 = "icafd_from_passbook"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x0755
            r0 = r1
            android.content.Context r0 = (android.content.Context) r0
            java.lang.String r5 = "ICA"
            net.one97.paytm.bankCommon.h.b.a((android.content.Context) r0, (java.lang.String) r5)
            java.lang.String r5 = "caId"
            java.lang.String r5 = r6.getStringExtra(r5)
            net.one97.paytm.bankCommon.h.c.a(r5, r0)
            r17 = r1
            android.app.Activity r17 = (android.app.Activity) r17
            java.lang.String r0 = "fdBal"
            double r18 = r6.getDoubleExtra(r0, r12)
            java.lang.String r0 = "accNo"
            java.lang.String r20 = r6.getStringExtra(r0)
            java.lang.String r0 = "saBal"
            double r21 = r6.getDoubleExtra(r0, r12)
            net.one97.paytm.paymentsBank.slfd.d.a((android.app.Activity) r17, (double) r18, (java.lang.String) r20, (double) r21)
            r23.finish()
            goto L_0x0755
        L_0x06ef:
            java.lang.String r5 = "open_ica_isa_opening"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x0755
            r0 = r1
            android.content.Context r0 = (android.content.Context) r0
            java.lang.Class<net.one97.paytm.bankOpen.activity.PaymentsBankBaseActivity> r5 = net.one97.paytm.bankOpen.activity.PaymentsBankBaseActivity.class
            r6.setClass(r0, r5)
            r0 = 67108864(0x4000000, float:1.5046328E-36)
            r6.setFlags(r0)
            r0 = 7
            r6.putExtra(r8, r0)
            r1.startActivity(r6)
            r23.finish()
            goto L_0x0755
        L_0x070f:
            java.lang.String r5 = "change_passcode"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x0755
            r0 = r1
            android.content.Context r0 = (android.content.Context) r0
            java.lang.Class<net.one97.paytm.payments.activity.AJRChangePasscode> r5 = net.one97.paytm.payments.activity.AJRChangePasscode.class
            r6.setClass(r0, r5)
            r1.startActivity(r6)
            r23.finish()
            goto L_0x0755
        L_0x0726:
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x0755
            r0 = r1
            android.content.Context r0 = (android.content.Context) r0
            java.lang.Class<net.one97.paytm.paymentsBank.pdc.activity.PDCPasscodePinActivity> r5 = net.one97.paytm.paymentsBank.pdc.activity.PDCPasscodePinActivity.class
            r6.setClass(r0, r5)
            r1.startActivity(r6)
            r23.finish()
            goto L_0x0755
        L_0x073b:
            java.lang.String r5 = "forgot_passcode"
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L_0x0755
            r0 = r1
            android.content.Context r0 = (android.content.Context) r0
            java.lang.Class<net.one97.paytm.payments.activity.AJRForgotPasscode> r5 = net.one97.paytm.payments.activity.AJRForgotPasscode.class
            r6.setClass(r0, r5)
            r1.startActivity(r6)
            r23.finish()
            goto L_0x0755
        L_0x0752:
            r23.finish()
        L_0x0755:
            r0 = 9856(0x2680, float:1.3811E-41)
            if (r2 != r0) goto L_0x0763
            r5 = -1
            if (r3 != r5) goto L_0x075f
            r1.setResult(r5, r4)
        L_0x075f:
            r23.finish()
            return
        L_0x0763:
            r5 = -1
            r0 = 1234(0x4d2, float:1.729E-42)
            if (r2 != r0) goto L_0x0770
            if (r3 != r5) goto L_0x076d
            r1.setResult(r5, r4)
        L_0x076d:
            r23.finish()
        L_0x0770:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.activity.BankFlowActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    public final void attachBaseContext(Context context) {
        if (f.d()) {
            super.attachBaseContext(context);
        } else {
            super.attachBaseContext(f.a().getBaseContext(context));
        }
        Context context2 = this;
        com.google.android.play.core.splitcompat.a.a(context2);
        com.google.android.play.core.splitcompat.a.b(context2);
    }
}
