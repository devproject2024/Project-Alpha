package net.one97.paytm.paymentsBank.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.g;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.bankCommon.activity.PBBaseActivity;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.CustProductList;
import net.one97.paytm.bankCommon.model.ValidatePasscode;
import net.one97.paytm.payments.activity.AJRSetPasscode;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.model.bankstatus.BankStatusModel;

public final class BankStatusCheckingActivity extends PBBaseActivity {

    /* renamed from: b  reason: collision with root package name */
    private CustProductList f17370b;

    /* renamed from: c  reason: collision with root package name */
    private BankStatusModel f17371c;

    /* renamed from: d  reason: collision with root package name */
    private final int f17372d = 100;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Fragment f17373e;

    /* renamed from: f  reason: collision with root package name */
    private int f17374f = this.f17372d;

    /* renamed from: g  reason: collision with root package name */
    private net.one97.paytm.paymentsBank.pdc.b.a f17375g;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pb_activity_forgot_passcode_challenges);
        this.f17373e = new net.one97.paytm.paymentsBank.forgotpasscode.a.a();
        Fragment fragment = this.f17373e;
        if (fragment != null) {
            this.f17375g = (net.one97.paytm.paymentsBank.pdc.b.a) fragment;
            q a2 = getSupportFragmentManager().a();
            int i2 = R.id.container;
            Fragment fragment2 = this.f17373e;
            if (fragment2 == null) {
                k.a();
            }
            a2.b(i2, fragment2).c();
            HashMap hashMap = new HashMap();
            String simpleName = getClass().getSimpleName();
            k.a((Object) simpleName, "javaClass.simpleName");
            hashMap.put("screen_name", simpleName);
            Context context = this;
            f b2 = net.one97.paytm.paymentsBank.b.a.b(context, this, this, a.c.PAYMENTSBANK, a.b.SILENT, hashMap);
            k.a((Object) b2, "PaymentBankAPIRequestFac…additionalParam\n        )");
            if (com.paytm.utility.b.c(context)) {
                getApplicationContext();
                net.one97.paytm.bankCommon.g.c.a();
                net.one97.paytm.bankCommon.g.c.a(b2);
                return;
            }
            a(b2);
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.paymentsBank.pdc.listener.ActivityActionListener");
    }

    /* JADX WARNING: Removed duplicated region for block: B:129:0x0284  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0299  */
    /* JADX WARNING: Removed duplicated region for block: B:143:? A[RETURN, SYNTHETIC] */
    /* renamed from: a_ */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onResponse(com.paytm.network.model.IJRPaytmDataModel r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            boolean r2 = r1 instanceof net.one97.paytm.paymentsBank.model.bankstatus.BankStatusModel
            java.lang.String r3 = "ISSUED"
            java.lang.String r4 = "PENDING"
            java.lang.String r5 = "INITIATED"
            java.lang.String r6 = "IN_PROGRESS"
            r7 = 6
            java.lang.String r8 = "FAILED"
            java.lang.String r9 = "LEAD"
            r10 = 3
            java.lang.String r11 = "NOT_APPLIED"
            r12 = 1
            java.lang.String r13 = "PaymentsBankHelper.getImplListener()"
            r14 = 0
            if (r2 == 0) goto L_0x0169
            r15 = 0
            if (r2 != 0) goto L_0x0020
            r1 = r15
        L_0x0020:
            net.one97.paytm.paymentsBank.model.bankstatus.BankStatusModel r1 = (net.one97.paytm.paymentsBank.model.bankstatus.BankStatusModel) r1
            r0.f17371c = r1
            net.one97.paytm.paymentsBank.model.bankstatus.BankStatusModel r1 = r0.f17371c
            if (r1 == 0) goto L_0x0165
            if (r1 == 0) goto L_0x002f
            java.lang.String r1 = r1.getErrorMessage()
            goto L_0x0030
        L_0x002f:
            r1 = r15
        L_0x0030:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x0165
            net.one97.paytm.paymentsBank.model.bankstatus.BankStatusModel r1 = r0.f17371c
            if (r1 == 0) goto L_0x0041
            java.lang.String r1 = r1.getErrorCode()
            goto L_0x0042
        L_0x0041:
            r1 = r15
        L_0x0042:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x004c
            goto L_0x0165
        L_0x004c:
            net.one97.paytm.paymentsBank.model.bankstatus.BankStatusModel r1 = r0.f17371c
            if (r1 == 0) goto L_0x0055
            java.lang.String r1 = r1.getAccountStatus()
            goto L_0x0056
        L_0x0055:
            r1 = r15
        L_0x0056:
            net.one97.paytm.paymentsBank.model.bankstatus.BankStatusModel r2 = r0.f17371c
            if (r2 == 0) goto L_0x005f
            java.lang.String r2 = r2.getPassCodeStatus()
            goto L_0x0060
        L_0x005f:
            r2 = r15
        L_0x0060:
            r16 = r1
            java.lang.CharSequence r16 = (java.lang.CharSequence) r16
            boolean r16 = android.text.TextUtils.isEmpty(r16)
            if (r16 == 0) goto L_0x006e
            r17.f()
            return
        L_0x006e:
            boolean r11 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r11, (boolean) r14)
            if (r11 != 0) goto L_0x014d
            boolean r9 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r9, (boolean) r14)
            if (r9 == 0) goto L_0x007c
            goto L_0x014d
        L_0x007c:
            boolean r8 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r8, (boolean) r14)
            if (r8 != 0) goto L_0x0135
            boolean r6 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r6, (boolean) r14)
            if (r6 != 0) goto L_0x0135
            boolean r5 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r5, (boolean) r14)
            if (r5 != 0) goto L_0x0135
            boolean r4 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r4, (boolean) r14)
            if (r4 == 0) goto L_0x0096
            goto L_0x0135
        L_0x0096:
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r3, (boolean) r14)
            if (r1 == 0) goto L_0x0134
            net.one97.paytm.paymentsBank.h.a r1 = net.one97.paytm.paymentsBank.utils.o.a()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r13)
            android.content.Context r1 = r1.getApplicationContext()
            net.one97.paytm.bankCommon.model.AccountStatus r3 = net.one97.paytm.bankCommon.model.AccountStatus.ISSUED
            int r3 = r3.getNumVal()
            net.one97.paytm.bankCommon.h.b.a((android.content.Context) r1, (int) r3)
            r1 = r2
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x00e1
            java.lang.String r1 = "EXIST"
            boolean r1 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r1, (boolean) r12)
            if (r1 == 0) goto L_0x00cb
            r1 = r0
            android.content.Context r1 = (android.content.Context) r1
            net.one97.paytm.bankCommon.h.b.a((android.content.Context) r1, (boolean) r12)
            r17.e()
            return
        L_0x00cb:
            java.lang.String r1 = "NOT_EXIST"
            boolean r1 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r1, (boolean) r12)
            if (r1 == 0) goto L_0x00e1
            android.content.Intent r1 = new android.content.Intent
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            java.lang.Class<net.one97.paytm.payments.activity.AJRSetPasscode> r3 = net.one97.paytm.payments.activity.AJRSetPasscode.class
            r1.<init>(r2, r3)
            r0.startActivityForResult(r1, r14)
            return
        L_0x00e1:
            androidx.fragment.app.Fragment r1 = r0.f17373e
            if (r1 == 0) goto L_0x00fb
            androidx.fragment.app.j r1 = r17.getSupportFragmentManager()
            androidx.fragment.app.q r1 = r1.a()
            androidx.fragment.app.Fragment r2 = r0.f17373e
            if (r2 != 0) goto L_0x00f4
            kotlin.g.b.k.a()
        L_0x00f4:
            androidx.fragment.app.q r1 = r1.a((androidx.fragment.app.Fragment) r2)
            r1.c()
        L_0x00fb:
            int r1 = net.one97.paytm.paymentsBank.R.string.some_went_wrong
            java.lang.String r1 = r0.getString(r1)
            net.one97.paytm.paymentsBank.model.bankstatus.BankStatusModel r2 = r0.f17371c
            if (r2 == 0) goto L_0x010a
            java.lang.String r2 = r2.getPassCodeExistErrorMessage()
            goto L_0x010b
        L_0x010a:
            r2 = r15
        L_0x010b:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0121
            net.one97.paytm.paymentsBank.model.bankstatus.BankStatusModel r1 = r0.f17371c
            if (r1 == 0) goto L_0x011b
            java.lang.String r15 = r1.getPassCodeExistErrorMessage()
        L_0x011b:
            r1 = r15
            if (r1 != 0) goto L_0x0121
            kotlin.g.b.k.a()
        L_0x0121:
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            int r3 = net.one97.paytm.paymentsBank.R.string.error
            java.lang.String r3 = r0.getString(r3)
            net.one97.paytm.paymentsBank.activity.BankStatusCheckingActivity$c r4 = new net.one97.paytm.paymentsBank.activity.BankStatusCheckingActivity$c
            r4.<init>(r0)
            com.paytm.utility.g$c r4 = (com.paytm.utility.g.c) r4
            com.paytm.utility.g.b(r2, r3, r1, r4)
        L_0x0134:
            return
        L_0x0135:
            net.one97.paytm.paymentsBank.h.a r1 = net.one97.paytm.paymentsBank.utils.o.a()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r13)
            android.content.Context r1 = r1.getApplicationContext()
            net.one97.paytm.bankCommon.model.AccountStatus r2 = net.one97.paytm.bankCommon.model.AccountStatus.PROCESSING
            int r2 = r2.getNumVal()
            net.one97.paytm.bankCommon.h.b.a((android.content.Context) r1, (int) r2)
            r0.a((int) r7)
            return
        L_0x014d:
            net.one97.paytm.paymentsBank.h.a r1 = net.one97.paytm.paymentsBank.utils.o.a()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r13)
            android.content.Context r1 = r1.getApplicationContext()
            net.one97.paytm.bankCommon.model.AccountStatus r2 = net.one97.paytm.bankCommon.model.AccountStatus.NOT_APPLIED
            int r2 = r2.getNumVal()
            net.one97.paytm.bankCommon.h.b.a((android.content.Context) r1, (int) r2)
            r0.a((int) r10)
            return
        L_0x0165:
            r17.f()
            return
        L_0x0169:
            boolean r2 = r1 instanceof net.one97.paytm.bankCommon.model.CustProductList
            if (r2 == 0) goto L_0x02a3
            net.one97.paytm.bankCommon.model.CustProductList r1 = (net.one97.paytm.bankCommon.model.CustProductList) r1
            r0.f17370b = r1
            net.one97.paytm.bankCommon.model.CustProductList r1 = r0.f17370b
            java.lang.String r2 = "custProductList"
            if (r1 != 0) goto L_0x017a
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x017a:
            java.lang.String r1 = r1.getIsaStatus()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x02a0
            net.one97.paytm.bankCommon.model.CustProductList r1 = r0.f17370b
            if (r1 != 0) goto L_0x018d
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x018d:
            java.lang.String r1 = r1.getIsaStatus()
            boolean r1 = r1.equals(r11)
            if (r1 != 0) goto L_0x0267
            net.one97.paytm.bankCommon.model.CustProductList r1 = r0.f17370b
            if (r1 != 0) goto L_0x019e
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x019e:
            java.lang.String r1 = r1.getIsaStatus()
            boolean r1 = r1.equals(r9)
            if (r1 == 0) goto L_0x01aa
            goto L_0x0267
        L_0x01aa:
            net.one97.paytm.bankCommon.model.CustProductList r1 = r0.f17370b
            if (r1 != 0) goto L_0x01b1
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x01b1:
            java.lang.String r1 = r1.getIsaStatus()
            boolean r1 = r1.equals(r8)
            if (r1 != 0) goto L_0x024f
            net.one97.paytm.bankCommon.model.CustProductList r1 = r0.f17370b
            if (r1 != 0) goto L_0x01c2
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x01c2:
            java.lang.String r1 = r1.getIsaStatus()
            boolean r1 = r1.equals(r6)
            if (r1 != 0) goto L_0x024f
            net.one97.paytm.bankCommon.model.CustProductList r1 = r0.f17370b
            if (r1 != 0) goto L_0x01d3
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x01d3:
            java.lang.String r1 = r1.getIsaStatus()
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x024f
            net.one97.paytm.bankCommon.model.CustProductList r1 = r0.f17370b
            if (r1 != 0) goto L_0x01e4
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x01e4:
            java.lang.String r1 = r1.getIsaStatus()
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x01ef
            goto L_0x024f
        L_0x01ef:
            net.one97.paytm.bankCommon.model.CustProductList r1 = r0.f17370b
            if (r1 != 0) goto L_0x01f6
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x01f6:
            java.lang.String r1 = r1.getIsaStatus()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x027e
            net.one97.paytm.paymentsBank.h.a r1 = net.one97.paytm.paymentsBank.utils.o.a()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r13)
            android.content.Context r1 = r1.getApplicationContext()
            net.one97.paytm.bankCommon.model.AccountStatus r3 = net.one97.paytm.bankCommon.model.AccountStatus.ISSUED
            int r3 = r3.getNumVal()
            net.one97.paytm.bankCommon.h.b.a((android.content.Context) r1, (int) r3)
            net.one97.paytm.paymentsBank.h.a r1 = net.one97.paytm.paymentsBank.utils.o.a()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r13)
            android.content.Context r1 = r1.getApplicationContext()
            boolean r1 = net.one97.paytm.bankCommon.h.b.a(r1)
            if (r1 != 0) goto L_0x024b
            net.one97.paytm.bankCommon.utils.g r1 = net.one97.paytm.bankCommon.utils.g.f16329a
            r3 = r0
            android.content.Context r3 = (android.content.Context) r3
            net.one97.paytm.paymentsBank.activity.BankStatusCheckingActivity$a r1 = new net.one97.paytm.paymentsBank.activity.BankStatusCheckingActivity$a
            r1.<init>(r0)
            r4 = r1
            net.one97.paytm.bankCommon.g.g$b r4 = (net.one97.paytm.bankCommon.g.g.b) r4
            net.one97.paytm.paymentsBank.activity.BankStatusCheckingActivity$b r1 = new net.one97.paytm.paymentsBank.activity.BankStatusCheckingActivity$b
            r1.<init>(r0)
            r5 = r1
            net.one97.paytm.bankCommon.g.g$a r5 = (net.one97.paytm.bankCommon.g.g.a) r5
            com.paytm.network.a$c r6 = com.paytm.network.a.c.PAYMENTSBANK
            com.paytm.network.a$b r7 = com.paytm.network.a.b.USER_FACING
            java.lang.String r8 = "BankStatusCheckingActivity"
            net.one97.paytm.bankCommon.g.f r1 = net.one97.paytm.bankCommon.utils.g.a(r3, r4, r5, r6, r7, r8)
            net.one97.paytm.bankCommon.g.c.a()
            net.one97.paytm.bankCommon.g.c.a(r1)
            goto L_0x027e
        L_0x024b:
            r17.e()
            goto L_0x027e
        L_0x024f:
            net.one97.paytm.paymentsBank.h.a r1 = net.one97.paytm.paymentsBank.utils.o.a()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r13)
            android.content.Context r1 = r1.getApplicationContext()
            net.one97.paytm.bankCommon.model.AccountStatus r3 = net.one97.paytm.bankCommon.model.AccountStatus.PROCESSING
            int r3 = r3.getNumVal()
            net.one97.paytm.bankCommon.h.b.a((android.content.Context) r1, (int) r3)
            r0.a((int) r7)
            goto L_0x027e
        L_0x0267:
            net.one97.paytm.paymentsBank.h.a r1 = net.one97.paytm.paymentsBank.utils.o.a()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r13)
            android.content.Context r1 = r1.getApplicationContext()
            net.one97.paytm.bankCommon.model.AccountStatus r3 = net.one97.paytm.bankCommon.model.AccountStatus.NOT_APPLIED
            int r3 = r3.getNumVal()
            net.one97.paytm.bankCommon.h.b.a((android.content.Context) r1, (int) r3)
            r0.a((int) r10)
        L_0x027e:
            net.one97.paytm.paymentsBank.utils.a r1 = net.one97.paytm.paymentsBank.utils.a.f19494a
            net.one97.paytm.bankCommon.model.CustProductList r1 = r0.f17370b
            if (r1 != 0) goto L_0x0287
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0287:
            java.lang.String r1 = net.one97.paytm.paymentsBank.utils.a.a(r1, true)
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x0296
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0297
        L_0x0296:
            r14 = 1
        L_0x0297:
            if (r14 != 0) goto L_0x02a3
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            net.one97.paytm.bankCommon.h.b.c((android.content.Context) r2, (java.lang.String) r1)
            return
        L_0x02a0:
            r17.f()
        L_0x02a3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.activity.BankStatusCheckingActivity.onResponse(com.paytm.network.model.IJRPaytmDataModel):void");
    }

    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        f();
    }

    public static final class c implements g.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BankStatusCheckingActivity f17379a;

        c(BankStatusCheckingActivity bankStatusCheckingActivity) {
            this.f17379a = bankStatusCheckingActivity;
        }

        public final void onDialogDismissed() {
            this.f17379a.finish();
        }
    }

    private final void a(int i2) {
        Intent intent = new Intent();
        intent.putExtra("result", "SUCCESS");
        intent.putExtra("pb_new_account_flow", true);
        intent.putExtra("pb_page", i2);
        setResult(-1, intent);
        finish();
    }

    public static final class a implements g.b<IJRPaytmDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BankStatusCheckingActivity f17376a;

        a(BankStatusCheckingActivity bankStatusCheckingActivity) {
            this.f17376a = bankStatusCheckingActivity;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
            k.c(iJRPaytmDataModel, Payload.RESPONSE);
            ValidatePasscode validatePasscode = (ValidatePasscode) iJRPaytmDataModel;
            if (validatePasscode.getResponseCode() == 1100) {
                net.one97.paytm.bankCommon.h.b.a((Context) this.f17376a, true);
                this.f17376a.e();
            } else if (validatePasscode.getResponseCode() == 1101) {
                this.f17376a.startActivityForResult(new Intent(this.f17376a, AJRSetPasscode.class), 0);
            } else {
                if (this.f17376a.f17373e != null) {
                    q a2 = this.f17376a.getSupportFragmentManager().a();
                    Fragment b2 = this.f17376a.f17373e;
                    if (b2 == null) {
                        k.a();
                    }
                    a2.a(b2).c();
                }
                String string = this.f17376a.getString(R.string.some_went_wrong);
                if (!TextUtils.isEmpty(validatePasscode.getMessage())) {
                    string = validatePasscode.getMessage();
                }
                BankStatusCheckingActivity bankStatusCheckingActivity = this.f17376a;
                com.paytm.utility.g.b(bankStatusCheckingActivity, bankStatusCheckingActivity.getString(R.string.error), string, new C0263a(this));
            }
        }

        /* renamed from: net.one97.paytm.paymentsBank.activity.BankStatusCheckingActivity$a$a  reason: collision with other inner class name */
        public static final class C0263a implements g.c {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f17377a;

            C0263a(a aVar) {
                this.f17377a = aVar;
            }

            public final void onDialogDismissed() {
                this.f17377a.f17376a.finish();
            }
        }
    }

    public static final class b implements g.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BankStatusCheckingActivity f17378a;

        b(BankStatusCheckingActivity bankStatusCheckingActivity) {
            this.f17378a = bankStatusCheckingActivity;
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f17378a.f();
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 0) {
            return;
        }
        if (i3 == -1) {
            e();
        } else {
            finish();
        }
    }

    /* access modifiers changed from: private */
    public final void e() {
        Intent intent = new Intent();
        intent.putExtra("result", "SUCCESS");
        setResult(-1, intent);
        finish();
    }

    /* access modifiers changed from: private */
    public final void f() {
        Intent intent = new Intent();
        intent.putExtra("result", "FAILURE");
        setResult(0, intent);
        finish();
    }
}
