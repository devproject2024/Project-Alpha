package net.one97.paytm.moneytransferv4.accounts;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.c;
import androidx.lifecycle.z;
import com.appsflyer.internal.referrer.Payload;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.utility.n;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferBaseActivity;
import net.one97.paytm.moneytransferv4.d.a.q;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.profile.view.SetMPINActivity;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.CustomWalletLoaderDialog;
import net.one97.paytm.upi.util.IncorrectUpiPinBottomSheet;
import net.one97.paytm.upi.util.UPICheckBalanceHelper;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public final class AccountSettingsActivity extends MoneyTransferBaseActivity implements n.c {

    /* renamed from: b  reason: collision with root package name */
    public static final a f54861b = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public q f54862a;

    /* renamed from: c  reason: collision with root package name */
    private net.one97.paytm.moneytransfer.c.b f54863c;

    /* renamed from: d  reason: collision with root package name */
    private BankAccountDetails.BankAccount f54864d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f54865e = "";

    /* renamed from: f  reason: collision with root package name */
    private UPICheckBalanceHelper f54866f;

    /* renamed from: g  reason: collision with root package name */
    private i f54867g;

    /* renamed from: h  reason: collision with root package name */
    private HashMap f54868h;

    public final View a(int i2) {
        if (this.f54868h == null) {
            this.f54868h = new HashMap();
        }
        View view = (View) this.f54868h.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f54868h.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class g<T> implements z<net.one97.paytm.moneytransfer.model.c<d>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AccountSettingsActivity f54874a;

        g(AccountSettingsActivity accountSettingsActivity) {
            this.f54874a = accountSettingsActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.moneytransfer.model.c cVar = (net.one97.paytm.moneytransfer.model.c) obj;
            AccountSettingsActivity accountSettingsActivity = this.f54874a;
            k.a((Object) cVar, Payload.RESPONSE);
            AccountSettingsActivity.a(accountSettingsActivity, cVar);
        }
    }

    public static final /* synthetic */ i d(AccountSettingsActivity accountSettingsActivity) {
        i iVar = accountSettingsActivity.f54867g;
        if (iVar == null) {
            k.a("viewModel");
        }
        return iVar;
    }

    public static final /* synthetic */ BankAccountDetails.BankAccount f(AccountSettingsActivity accountSettingsActivity) {
        BankAccountDetails.BankAccount bankAccount = accountSettingsActivity.f54864d;
        if (bankAccount == null) {
            k.a("bankAccount");
        }
        return bankAccount;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01c3  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0283  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r9) {
        /*
            r8 = this;
            net.one97.paytm.moneytransferv4.d.a.a r0 = net.one97.paytm.moneytransfer.utils.o.a()
            r0.a((net.one97.paytm.moneytransferv4.accounts.AccountSettingsActivity) r8)
            super.onCreate(r9)
            android.view.LayoutInflater r9 = r8.getLayoutInflater()
            net.one97.paytm.moneytransfer.c.b r9 = net.one97.paytm.moneytransfer.c.b.a(r9)
            java.lang.String r0 = "ActivityAccountSettingsB…g.inflate(layoutInflater)"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
            r8.f54863c = r9
            r9 = r8
            android.app.Activity r9 = (android.app.Activity) r9
            r0 = 17170443(0x106000b, float:2.4611944E-38)
            net.one97.paytm.upi.util.UpiUtils.setStatusBarColor(r0, r9)
            boolean r9 = net.one97.paytm.upi.util.UpiUtils.isAtleastLollipop()
            if (r9 == 0) goto L_0x008a
            android.transition.TransitionSet r9 = new android.transition.TransitionSet
            r9.<init>()
            r0 = r8
            android.content.Context r0 = (android.content.Context) r0
            android.transition.TransitionInflater r0 = android.transition.TransitionInflater.from(r0)
            int r1 = net.one97.paytm.moneytransfer.R.transition.arc
            android.transition.Transition r0 = r0.inflateTransition(r1)
            r9.addTransition(r0)
            r1 = 380(0x17c, double:1.877E-321)
            r9.setDuration(r1)
            android.view.animation.AccelerateDecelerateInterpolator r3 = new android.view.animation.AccelerateDecelerateInterpolator
            r3.<init>()
            android.animation.TimeInterpolator r3 = (android.animation.TimeInterpolator) r3
            r9.setInterpolator(r3)
            android.transition.TransitionSet r3 = new android.transition.TransitionSet
            r3.<init>()
            r3.addTransition(r0)
            r3.setDuration(r1)
            android.view.animation.AccelerateDecelerateInterpolator r0 = new android.view.animation.AccelerateDecelerateInterpolator
            r0.<init>()
            android.animation.TimeInterpolator r0 = (android.animation.TimeInterpolator) r0
            r3.setInterpolator(r0)
            r0 = 200(0xc8, double:9.9E-322)
            r3.setStartDelay(r0)
            android.view.Window r0 = r8.getWindow()
            java.lang.String r1 = "window"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            android.transition.Transition r9 = (android.transition.Transition) r9
            r0.setSharedElementEnterTransition(r9)
            android.view.Window r9 = r8.getWindow()
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r1)
            android.transition.Transition r3 = (android.transition.Transition) r3
            r9.setSharedElementExitTransition(r3)
            android.view.Window r9 = r8.getWindow()
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r1)
            r9.setSharedElementReturnTransition(r3)
        L_0x008a:
            net.one97.paytm.moneytransfer.c.b r9 = r8.f54863c
            java.lang.String r0 = "binding"
            if (r9 != 0) goto L_0x0093
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0093:
            androidx.constraintlayout.widget.ConstraintLayout r9 = r9.a()
            android.view.View r9 = (android.view.View) r9
            r8.setContentView((android.view.View) r9)
            android.content.Intent r9 = r8.getIntent()
            java.lang.String r1 = "bank_account"
            java.io.Serializable r9 = r9.getSerializableExtra(r1)
            if (r9 == 0) goto L_0x028b
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r9 = (net.one97.paytm.upi.common.upi.BankAccountDetails.BankAccount) r9
            r8.f54864d = r9
            android.content.Intent r9 = r8.getIntent()
            java.lang.String r1 = "primary_vpa"
            java.lang.String r9 = r9.getStringExtra(r1)
            java.lang.String r1 = "intent.getStringExtra(PRIMARY_VPA)"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r1)
            r8.f54865e = r9
            androidx.lifecycle.al r9 = new androidx.lifecycle.al
            r1 = r8
            androidx.lifecycle.ao r1 = (androidx.lifecycle.ao) r1
            net.one97.paytm.moneytransferv4.d.a.q r2 = r8.f54862a
            if (r2 != 0) goto L_0x00cb
            java.lang.String r3 = "viewModelFactory"
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x00cb:
            androidx.lifecycle.al$b r2 = (androidx.lifecycle.al.b) r2
            r9.<init>((androidx.lifecycle.ao) r1, (androidx.lifecycle.al.b) r2)
            java.lang.Class<net.one97.paytm.moneytransferv4.accounts.i> r1 = net.one97.paytm.moneytransferv4.accounts.i.class
            androidx.lifecycle.ai r9 = r9.a(r1)
            java.lang.String r1 = "ViewModelProvider(this, …ntsViewModel::class.java]"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r1)
            net.one97.paytm.moneytransferv4.accounts.i r9 = (net.one97.paytm.moneytransferv4.accounts.i) r9
            r8.f54867g = r9
            net.one97.paytm.moneytransferv4.accounts.i r9 = r8.f54867g
            if (r9 != 0) goto L_0x00e8
            java.lang.String r1 = "viewModel"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x00e8:
            androidx.lifecycle.LiveData<net.one97.paytm.moneytransfer.model.c<net.one97.paytm.moneytransferv4.accounts.d>> r9 = r9.f54968e
            r1 = r8
            androidx.lifecycle.q r1 = (androidx.lifecycle.q) r1
            net.one97.paytm.moneytransferv4.accounts.AccountSettingsActivity$g r2 = new net.one97.paytm.moneytransferv4.accounts.AccountSettingsActivity$g
            r2.<init>(r8)
            androidx.lifecycle.z r2 = (androidx.lifecycle.z) r2
            r9.observe(r1, r2)
            net.one97.paytm.moneytransfer.c.b r9 = r8.f54863c
            if (r9 != 0) goto L_0x00fe
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x00fe:
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r1 = r8.f54864d
            java.lang.String r2 = "bankAccount"
            if (r1 != 0) goto L_0x0107
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0107:
            java.lang.String r1 = r1.getBankLogoUrl()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x011a
            boolean r1 = kotlin.m.p.a(r1)
            if (r1 == 0) goto L_0x0118
            goto L_0x011a
        L_0x0118:
            r1 = 0
            goto L_0x011b
        L_0x011a:
            r1 = 1
        L_0x011b:
            if (r1 != 0) goto L_0x0156
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r1 = r8.f54864d
            if (r1 != 0) goto L_0x0124
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0124:
            java.lang.String r1 = r1.getBankLogoUrl()
            boolean r1 = android.webkit.URLUtil.isValidUrl(r1)
            if (r1 != 0) goto L_0x012f
            goto L_0x0156
        L_0x012f:
            com.squareup.picasso.w r1 = com.squareup.picasso.w.a()
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r5 = r8.f54864d
            if (r5 != 0) goto L_0x013a
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x013a:
            java.lang.String r5 = r5.getBankLogoUrl()
            com.squareup.picasso.aa r1 = r1.a((java.lang.String) r5)
            int r5 = net.one97.paytm.moneytransfer.R.drawable.ic_default_bank
            com.squareup.picasso.aa r1 = r1.a((int) r5)
            int r5 = net.one97.paytm.moneytransfer.R.drawable.ic_default_bank
            com.squareup.picasso.aa r1 = r1.b((int) r5)
            net.one97.paytm.upi.util.CircularImageView r5 = r9.f53711d
            android.widget.ImageView r5 = (android.widget.ImageView) r5
            r1.a((android.widget.ImageView) r5)
            goto L_0x0175
        L_0x0156:
            net.one97.paytm.upi.util.CircularImageView r1 = r9.f53711d
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r5 = r8.f54864d
            if (r5 != 0) goto L_0x0161
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0161:
            java.lang.String r5 = r5.getIfsc()
            androidx.constraintlayout.widget.ConstraintLayout r6 = r9.a()
            java.lang.String r7 = "root"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            android.content.Context r6 = r6.getContext()
            net.one97.paytm.moneytransfer.utils.m.a((android.widget.ImageView) r1, (java.lang.String) r5, (android.content.Context) r6)
        L_0x0175:
            android.widget.TextView r1 = r9.f53712e
            java.lang.String r5 = "bankName"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r5 = r8.f54864d
            if (r5 != 0) goto L_0x0183
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0183:
            java.lang.String r5 = r5.getBankName()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r5)
            java.lang.String r5 = " XX "
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r5)
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r5 = r8.f54864d
            if (r5 != 0) goto L_0x01a7
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x01a7:
            java.lang.String r5 = r5.getMaskedAccountNumber()
            java.lang.String r7 = "bankAccount.maskedAccountNumber"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r7)
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r7 = r8.f54864d
            if (r7 != 0) goto L_0x01b7
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x01b7:
            java.lang.String r7 = r7.getMaskedAccountNumber()
            int r7 = r7.length()
            int r7 = r7 + -4
            if (r5 == 0) goto L_0x0283
            java.lang.String r5 = r5.substring(r7)
            java.lang.String r7 = "(this as java.lang.String).substring(startIndex)"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r7)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r1.setText(r5)
            android.widget.TextView r1 = r9.f53710c
            java.lang.String r5 = "bankIfsc"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            int r5 = net.one97.paytm.moneytransfer.R.string.money_transfer_ifsc_with_placeholder_without_bold
            java.lang.Object[] r4 = new java.lang.Object[r4]
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r6 = r8.f54864d
            if (r6 != 0) goto L_0x01ea
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x01ea:
            java.lang.String r6 = r6.getIfsc()
            r4[r3] = r6
            java.lang.String r3 = r8.getString(r5, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            java.lang.String r3 = ", "
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r3 = r8.f54864d
            if (r3 != 0) goto L_0x0214
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0214:
            java.lang.String r3 = r3.getBranchAddress()
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r1.setText(r3)
            android.widget.TextView r9 = r9.m
            java.lang.String r1 = "userFullName"
            kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r1)
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r1 = r8.f54864d
            if (r1 != 0) goto L_0x0232
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x0232:
            java.lang.String r1 = r1.getCustomerName()
            java.lang.String r1 = net.one97.paytm.upi.f.a((java.lang.String) r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r9.setText(r1)
            net.one97.paytm.moneytransfer.c.b r9 = r8.f54863c
            if (r9 != 0) goto L_0x0246
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x0246:
            android.widget.TextView r0 = r9.f53714g
            net.one97.paytm.moneytransferv4.accounts.AccountSettingsActivity$b r1 = new net.one97.paytm.moneytransferv4.accounts.AccountSettingsActivity$b
            r1.<init>(r8)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            android.widget.TextView r0 = r9.k
            net.one97.paytm.moneytransferv4.accounts.AccountSettingsActivity$c r1 = new net.one97.paytm.moneytransferv4.accounts.AccountSettingsActivity$c
            r1.<init>(r8)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            android.widget.TextView r0 = r9.l
            net.one97.paytm.moneytransferv4.accounts.AccountSettingsActivity$d r1 = new net.one97.paytm.moneytransferv4.accounts.AccountSettingsActivity$d
            r1.<init>(r8)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            android.widget.TextView r0 = r9.f53713f
            net.one97.paytm.moneytransferv4.accounts.AccountSettingsActivity$e r1 = new net.one97.paytm.moneytransferv4.accounts.AccountSettingsActivity$e
            r1.<init>(r8)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
            android.widget.ImageView r9 = r9.f53708a
            net.one97.paytm.moneytransferv4.accounts.AccountSettingsActivity$f r0 = new net.one97.paytm.moneytransferv4.accounts.AccountSettingsActivity$f
            r0.<init>(r8)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r9.setOnClickListener(r0)
            return
        L_0x0283:
            kotlin.u r9 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
            r9.<init>(r0)
            throw r9
        L_0x028b:
            kotlin.u r9 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.upi.common.upi.BankAccountDetails.BankAccount"
            r9.<init>(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.accounts.AccountSettingsActivity.onCreate(android.os.Bundle):void");
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AccountSettingsActivity f54869a;

        b(AccountSettingsActivity accountSettingsActivity) {
            this.f54869a = accountSettingsActivity;
        }

        public final void onClick(View view) {
            AccountSettingsActivity.a(this.f54869a);
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AccountSettingsActivity f54870a;

        c(AccountSettingsActivity accountSettingsActivity) {
            this.f54870a = accountSettingsActivity;
        }

        public final void onClick(View view) {
            m.e((Activity) this.f54870a);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AccountSettingsActivity f54871a;

        d(AccountSettingsActivity accountSettingsActivity) {
            this.f54871a = accountSettingsActivity;
        }

        public final void onClick(View view) {
            AccountSettingsActivity.b(this.f54871a);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AccountSettingsActivity f54872a;

        e(AccountSettingsActivity accountSettingsActivity) {
            this.f54872a = accountSettingsActivity;
        }

        public final void onClick(View view) {
            AccountSettingsActivity.c(this.f54872a);
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AccountSettingsActivity f54873a;

        f(AccountSettingsActivity accountSettingsActivity) {
            this.f54873a = accountSettingsActivity;
        }

        public final void onClick(View view) {
            this.f54873a.onBackPressed();
        }
    }

    static final class h implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AccountSettingsActivity f54875a;

        h(AccountSettingsActivity accountSettingsActivity) {
            this.f54875a = accountSettingsActivity;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AccountSettingsActivity.d(this.f54875a).a(this.f54875a.f54865e, AccountSettingsActivity.f(this.f54875a));
            dialogInterface.dismiss();
        }
    }

    static final class i implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final i f54876a = new i();

        i() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 10 && i3 == -1) {
            Toast.makeText(this, R.string.upi_reset_mpin_success, 0).show();
        }
    }

    public final void a(n.b bVar) {
        k.c(bVar, "errorUPI");
        if (bVar == n.b.INCORRECT_MPIN) {
            a(false);
        } else if (bVar == n.b.INCORRECT_MPIN_TOO_MANY_TIMES) {
            a(true);
        } else {
            UpiUtils.handleCheckBalanceError(this, bVar);
        }
        net.one97.paytm.moneytransfer.c.b bVar2 = this.f54863c;
        if (bVar2 == null) {
            k.a("binding");
        }
        TextView textView = bVar2.f53713f;
        k.a((Object) textView, "binding.checkBalanceButton");
        net.one97.paytm.upi.f.b((View) textView);
    }

    private final void a(boolean z) {
        if (!isFinishing()) {
            androidx.fragment.app.j supportFragmentManager = getSupportFragmentManager();
            k.a((Object) supportFragmentManager, "supportFragmentManager");
            IncorrectUpiPinBottomSheet.Companion.show(new j(this), supportFragmentManager, z);
        }
    }

    public static final class j implements IncorrectUpiPinBottomSheet.OnItemClick {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AccountSettingsActivity f54877a;

        j(AccountSettingsActivity accountSettingsActivity) {
            this.f54877a = accountSettingsActivity;
        }

        public final void onReEnterClicked() {
            AccountSettingsActivity.c(this.f54877a);
        }

        public final void onCreateNewPinClicked() {
            AccountSettingsActivity.a(this.f54877a);
        }
    }

    public final void a(String str, String str2, String str3) {
        String str4;
        k.c(str3, "accountType");
        net.one97.paytm.moneytransfer.c.b bVar = this.f54863c;
        if (bVar == null) {
            k.a("binding");
        }
        TextView textView = bVar.f53713f;
        k.a((Object) textView, "binding.checkBalanceButton");
        net.one97.paytm.upi.f.c((View) textView);
        net.one97.paytm.moneytransfer.c.b bVar2 = this.f54863c;
        if (bVar2 == null) {
            k.a("binding");
        }
        TextView textView2 = bVar2.f53709b;
        k.a((Object) textView2, "binding.balanceTextView");
        net.one97.paytm.upi.f.b((View) textView2);
        if (UpiConstants.BANK_ACCOUNT_TYPE.valueOf(str3) == UpiConstants.BANK_ACCOUNT_TYPE.UOD || UpiConstants.BANK_ACCOUNT_TYPE.valueOf(str3) == UpiConstants.BANK_ACCOUNT_TYPE.SOD) {
            str4 = getString(R.string.mt_balance_credit_limit_bold, new Object[]{UpiAppUtils.priceToString(str), UpiAppUtils.priceToString(str2)});
        } else {
            str4 = getString(R.string.mt_available_balance_bold, new Object[]{UpiAppUtils.priceToString(str2)});
        }
        k.a((Object) str4, "if (UpiConstants.BANK_AC…ilableBalance))\n        }");
        net.one97.paytm.moneytransfer.c.b bVar3 = this.f54863c;
        if (bVar3 == null) {
            k.a("binding");
        }
        TextView textView3 = bVar3.f53709b;
        k.a((Object) textView3, "binding.balanceTextView");
        textView3.setText(str4);
    }

    public final void b() {
        net.one97.paytm.moneytransfer.c.b bVar = this.f54863c;
        if (bVar == null) {
            k.a("binding");
        }
        TextView textView = bVar.f53713f;
        k.a((Object) textView, "binding.checkBalanceButton");
        net.one97.paytm.upi.f.b((View) textView);
        net.one97.paytm.moneytransfer.c.b bVar2 = this.f54863c;
        if (bVar2 == null) {
            k.a("binding");
        }
        UpiUtils.stopWalletLoader(bVar2.j);
    }

    public final void Z_() {
        net.one97.paytm.moneytransfer.c.b bVar = this.f54863c;
        if (bVar == null) {
            k.a("binding");
        }
        TextView textView = bVar.f53713f;
        k.a((Object) textView, "binding.checkBalanceButton");
        net.one97.paytm.upi.f.c((View) textView);
        net.one97.paytm.moneytransfer.c.b bVar2 = this.f54863c;
        if (bVar2 == null) {
            k.a("binding");
        }
        UpiUtils.startWalletLoader(bVar2.j);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void a(AccountSettingsActivity accountSettingsActivity, net.one97.paytm.moneytransfer.model.c cVar) {
        int i2 = e.f54923a[cVar.f54032a.ordinal()];
        if (i2 == 1) {
            Context context = accountSettingsActivity;
            CustomWalletLoaderDialog.getInstance(context).dismissLoader();
            ResultType resulttype = cVar.f54033b;
            if (resulttype == null) {
                k.a();
            }
            d dVar = (d) resulttype;
            if (dVar.f54920a) {
                Intent intent = new Intent();
                BankAccountDetails.BankAccount bankAccount = accountSettingsActivity.f54864d;
                if (bankAccount == null) {
                    k.a("bankAccount");
                }
                intent.putExtra("bank_account", bankAccount);
                accountSettingsActivity.setResult(-1, intent);
                accountSettingsActivity.finish();
                return;
            }
            String str = dVar.f54921b;
            if (k.a((Object) "88", (Object) str) || k.a((Object) "80", (Object) str)) {
                Toast.makeText(context, R.string.upi_delete_default_bank, 1).show();
            } else if (k.a((Object) "102", (Object) str)) {
                Toast.makeText(context, R.string.upi_delete_default_bank_vpa, 1).show();
            } else if (k.a((Object) "INT-1199", (Object) str)) {
                Toast.makeText(context, R.string.upi_delete_default_bank_vpa, 1).show();
            } else if (!TextUtils.isEmpty(dVar.f54922c)) {
                Toast.makeText(context, dVar.f54922c, 1).show();
            } else {
                Toast.makeText(context, R.string.something_went_wrong, 1).show();
            }
        } else if (i2 == 2) {
            Context context2 = accountSettingsActivity;
            CustomWalletLoaderDialog.getInstance(context2).dismissLoader();
            UpiCustomVolleyError upiCustomVolleyError = cVar.f54034c;
            if (upiCustomVolleyError == null) {
                k.a();
            }
            String str2 = upiCustomVolleyError.getmErrorCode();
            k.a((Object) str2, "error.getmErrorCode()");
            if (TextUtils.isEmpty(str2) || !k.a((Object) UpiConstants.NETWORK_ERROR_CODE, (Object) str2)) {
                Toast.makeText(context2, R.string.upi_some_went_wrong, 1).show();
            } else {
                CustomDialog.showAlert(context2, accountSettingsActivity.getResources().getString(R.string.no_connection), accountSettingsActivity.getResources().getString(R.string.no_internet));
            }
        } else if (i2 == 3) {
            CustomWalletLoaderDialog.getInstance(accountSettingsActivity).showLoader();
        }
    }

    public static final /* synthetic */ void a(AccountSettingsActivity accountSettingsActivity) {
        Intent intent = new Intent(accountSettingsActivity, SetMPINActivity.class);
        ArrayList arrayList = new ArrayList();
        BankAccountDetails.BankAccount bankAccount = accountSettingsActivity.f54864d;
        if (bankAccount == null) {
            k.a("bankAccount");
        }
        arrayList.add(bankAccount);
        intent.putExtra("user_upi_details", new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, accountSettingsActivity.f54865e).setBankAccountList(arrayList).build());
        accountSettingsActivity.startActivityForResult(intent, 10);
    }

    public static final /* synthetic */ void b(AccountSettingsActivity accountSettingsActivity) {
        c.a aVar = new c.a(accountSettingsActivity);
        aVar.a(true);
        aVar.a(R.string.upi_delete_bank);
        aVar.b(R.string.upi_delete_bank_confirmation);
        aVar.a(R.string.ok, (DialogInterface.OnClickListener) new h(accountSettingsActivity));
        aVar.b(R.string.cancel, (DialogInterface.OnClickListener) i.f54876a);
        aVar.b();
    }

    public static final /* synthetic */ void c(AccountSettingsActivity accountSettingsActivity) {
        if (accountSettingsActivity.f54866f == null) {
            accountSettingsActivity.f54866f = new UPICheckBalanceHelper.UPICheckBalanceBuilder(accountSettingsActivity, accountSettingsActivity).setDeviceBindingRequestCode(1000).setOnActivityResultRecieverAfterDeviceBinding((Activity) accountSettingsActivity).setScreenName(accountSettingsActivity.getClass().getName()).setTag(accountSettingsActivity.getClass().getName()).build();
        }
        UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
        BankAccountDetails.BankAccount bankAccount = accountSettingsActivity.f54864d;
        if (bankAccount == null) {
            k.a("bankAccount");
        }
        upiProfileDefaultBank.setDebitBank(bankAccount);
        upiProfileDefaultBank.setVirtualAddress(accountSettingsActivity.f54865e);
        UPICheckBalanceHelper uPICheckBalanceHelper = accountSettingsActivity.f54866f;
        if (uPICheckBalanceHelper == null) {
            k.a();
        }
        uPICheckBalanceHelper.getUpiAccountBalance(upiProfileDefaultBank);
    }
}
