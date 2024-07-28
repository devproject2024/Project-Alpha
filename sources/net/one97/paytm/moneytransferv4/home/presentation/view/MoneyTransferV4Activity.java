package net.one97.paytm.moneytransferv4.home.presentation.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import androidx.lifecycle.am;
import androidx.lifecycle.y;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.NetworkCustomError;
import easypay.manager.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.PPBCurrentAccountModel;
import net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse;
import net.one97.paytm.contacts.entities.beans.ContactDetail;
import net.one97.paytm.contacts.entities.beans.VPADetails;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.a.d;
import net.one97.paytm.moneytransfer.d.d;
import net.one97.paytm.moneytransfer.utils.f;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferBaseActivity;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity;
import net.one97.paytm.moneytransferv4.PaymentFlow;
import net.one97.paytm.moneytransferv4.PaymentManager;
import net.one97.paytm.moneytransferv4.a.a.a;
import net.one97.paytm.moneytransferv4.accounts.b;
import net.one97.paytm.moneytransferv4.accounts.k;
import net.one97.paytm.moneytransferv4.home.presentation.view.a;
import net.one97.paytm.moneytransferv4.invite.d;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.upi.common.CustomAmountTextInputEditText;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CustomWalletAlertDialog;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public final class MoneyTransferV4Activity extends MoneyTransferBaseActivity implements d.b, PaymentManager.a {

    /* renamed from: b  reason: collision with root package name */
    public static final a f55513b = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public IJRDataModel f55514a;

    /* renamed from: c  reason: collision with root package name */
    private boolean f55515c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f55516d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f55517e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f55518f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f55519g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f55520h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f55521i;
    /* access modifiers changed from: private */
    public boolean j;
    private boolean k;
    private String l = "";
    private d.a m;
    private UpiConstants.MoneyTransferPaymentOption n = UpiConstants.MoneyTransferPaymentOption.ALL;
    private net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a o;
    private HashMap p;

    public final View a(int i2) {
        if (this.p == null) {
            this.p = new HashMap();
        }
        View view = (View) this.p.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.p.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
    }

    public final /* bridge */ /* synthetic */ void a(Object obj) {
    }

    public final void a(PPBCurrentAccountModel pPBCurrentAccountModel) {
    }

    public final void a(BaseUpiResponse baseUpiResponse, String str, boolean z) {
        k.c(baseUpiResponse, "baseUpiResponse");
        k.c(str, "txId");
    }

    public final void a(boolean z) {
    }

    public final void c(String str) {
    }

    public final boolean c() {
        return false;
    }

    public final void j() {
    }

    public final void l() {
    }

    public final void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        setContentView(R.layout.mt_v4_activity_home_layout);
        UpiUtils.setStatusBarColor(17170443, this);
        if (getIntent().getSerializableExtra(UpiConstants.EXTRA_MONEY_TRANSFER_PAYMENT_OPTION) != null) {
            Serializable serializableExtra = getIntent().getSerializableExtra(UpiConstants.EXTRA_MONEY_TRANSFER_PAYMENT_OPTION);
            if (serializableExtra != null) {
                this.n = (UpiConstants.MoneyTransferPaymentOption) serializableExtra;
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.upi.util.UpiConstants.MoneyTransferPaymentOption");
            }
        }
        boolean z2 = false;
        this.f55517e = getIntent().getBooleanExtra(UpiConstants.EXTRA_IS_COLLECT_REQUEST, false);
        this.f55518f = getIntent().getBooleanExtra(UpiConstants.EXTRA_IS_FROM_UNIV_P2P, false);
        this.f55519g = getIntent().getBooleanExtra(UpiConstants.EXTRA_IS_FOR_IMPS_FROM_UNIV_P2P, false);
        this.f55520h = getIntent().getBooleanExtra("add_money_to_ppb", false);
        this.f55521i = getIntent().getBooleanExtra("intent_extra_is_offline_pg", false);
        this.j = getIntent().getBooleanExtra("upi_push", false);
        if (getIntent() != null && getIntent().getBooleanExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, false)) {
            this.f55516d = true;
        }
        Serializable serializableExtra2 = getIntent().getSerializableExtra("search_screen_response");
        if (!(serializableExtra2 instanceof IJRDataModel)) {
            serializableExtra2 = null;
        }
        this.f55514a = (IJRDataModel) serializableExtra2;
        if (getIntent() != null) {
            Intent intent = getIntent();
            k.a((Object) intent, "intent");
            if (intent.getData() != null) {
                this.k = true;
                this.n = UpiConstants.MoneyTransferPaymentOption.UPI;
            }
        }
        this.o = (net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a) am.a((FragmentActivity) this).a(net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a.class);
        UpiConstants.MoneyTransferPaymentOption moneyTransferPaymentOption = this.n;
        net.one97.paytm.moneytransfer.b.a.b a2 = net.one97.paytm.moneytransfer.b.a(getApplicationContext());
        getApplicationContext();
        getApplicationContext();
        this.m = new net.one97.paytm.moneytransferv4.home.presentation.a.d(moneyTransferPaymentOption, a2, g.a(g.a((a.C1347a) null)), this);
        d.a aVar = this.m;
        if (aVar != null) {
            aVar.e();
        }
        if (this.f55516d) {
            DeepLinkData deepLinkData = (DeepLinkData) getIntent().getParcelableExtra("EXTRA_DEEP_LINK_DATA");
            if (deepLinkData != null) {
                try {
                    if (p.a(UpiConstants.WALLET_TYPE_MONEY_TRANSFER, deepLinkData.f50288f, true) && a(deepLinkData)) {
                        Uri build = Uri.parse(deepLinkData.f50283a).buildUpon().build();
                        String queryParameter = build.getQueryParameter("pn");
                        String queryParameter2 = build.getQueryParameter("pa");
                        String queryParameter3 = build.getQueryParameter("account");
                        String queryParameter4 = build.getQueryParameter("ifsc");
                        String queryParameter5 = build.getQueryParameter(PayUtility.BANK_NAME);
                        if (!TextUtils.isEmpty(queryParameter3)) {
                            int i2 = net.one97.paytm.upi.R.id.container;
                            a.C0982a aVar2 = net.one97.paytm.moneytransferv4.a.a.a.f54784c;
                            PaymentManager paymentManager = PaymentManager.f54783a;
                            m.a(i2, (Fragment) a.C0982a.a(PaymentManager.a(queryParameter3, queryParameter, queryParameter5, queryParameter4, "", (String) null, (String) null, Constants.EASY_PAY_INVISIBLE_ASSIST), this, 12), "BeneficiaryHistoryFragment", getSupportFragmentManager());
                        } else if (!TextUtils.isEmpty(queryParameter2)) {
                            int i3 = net.one97.paytm.upi.R.id.container;
                            a.C0982a aVar3 = net.one97.paytm.moneytransferv4.a.a.a.f54784c;
                            PaymentManager paymentManager2 = PaymentManager.f54783a;
                            m.a(i3, (Fragment) a.C0982a.a(PaymentManager.a(queryParameter2, queryParameter, (String) null, (String) null, (String) null, (String) null, (String) null, 252), this, 12), "BeneficiaryHistoryFragment", getSupportFragmentManager());
                        }
                    } else if (p.a("money_transfer_bankaccount", deepLinkData.f50288f, true)) {
                        m.a(net.one97.paytm.upi.R.id.container, (Fragment) new net.one97.paytm.m.d(), "TransferToBankAccountFragment", getSupportFragmentManager());
                    } else if (p.a("money_transfer_contact", deepLinkData.f50288f, true)) {
                        j supportFragmentManager = getSupportFragmentManager();
                        if (supportFragmentManager != null) {
                            supportFragmentManager.a().a(net.one97.paytm.upi.R.id.container, (Fragment) new net.one97.paytm.moneytransferv4.search.b()).a(net.one97.paytm.moneytransferv4.search.b.class.getName()).b();
                        }
                    } else if (p.a("money_transfer_self", deepLinkData.f50288f, true)) {
                        int i4 = net.one97.paytm.upi.R.id.container;
                        k.a aVar4 = net.one97.paytm.moneytransferv4.accounts.k.f54987b;
                        m.a(i4, (Fragment) new net.one97.paytm.moneytransferv4.accounts.k(), "SelfAccountFragment", getSupportFragmentManager());
                    } else if (p.a("money_transfer_check_balance", deepLinkData.f50288f, true)) {
                        int i5 = R.id.container;
                        b.a aVar5 = net.one97.paytm.moneytransferv4.accounts.b.f54902b;
                        m.a(i5, (Fragment) new net.one97.paytm.moneytransferv4.accounts.b(), "AccBalanceAndHistoryFragment", getSupportFragmentManager());
                    } else {
                        Uri build2 = Uri.parse(deepLinkData.f50283a).buildUpon().build();
                        CharSequence queryParameter6 = build2.getQueryParameter("source");
                        if (queryParameter6 != null) {
                            if (!p.a(queryParameter6)) {
                                z = false;
                                if (!z && p.a("from_notification", build2.getQueryParameter("source"), true)) {
                                    f.a(getApplicationContext(), CJRGTMConstants.PUSH_NOTIFICATION, CJRGTMConstants.MT_V4_HOMEPAGE_DEEPLINK_CLICKED, CJRGTMConstants.MT_V4_DEEPLINK_SCREEN_NAME, "", "");
                                }
                                n();
                            }
                        }
                        z = true;
                        f.a(getApplicationContext(), CJRGTMConstants.PUSH_NOTIFICATION, CJRGTMConstants.MT_V4_HOMEPAGE_DEEPLINK_CLICKED, CJRGTMConstants.MT_V4_DEEPLINK_SCREEN_NAME, "", "");
                        n();
                    }
                } catch (Exception e2) {
                    if (com.paytm.utility.b.v) {
                        e2.printStackTrace();
                    }
                }
            }
        } else {
            IJRDataModel iJRDataModel = this.f55514a;
            if (iJRDataModel != null) {
                if (iJRDataModel instanceof PaymentCombinationAPIResponse) {
                    PaymentManager paymentManager3 = PaymentManager.f54783a;
                    PaymentManager.a((PaymentCombinationAPIResponse) iJRDataModel, (PaymentManager.a) this);
                } else if (iJRDataModel instanceof ContactDetail) {
                    int i6 = R.id.container;
                    a.C0982a aVar6 = net.one97.paytm.moneytransferv4.a.a.a.f54784c;
                    PaymentManager paymentManager4 = PaymentManager.f54783a;
                    m.a(i6, (Fragment) a.C0982a.a(PaymentManager.a((ContactDetail) iJRDataModel), (Activity) null, 14), "BeneficiaryHistoryFragment", getSupportFragmentManager());
                } else if (iJRDataModel instanceof VPADetails) {
                    int i7 = R.id.container;
                    a.C0982a aVar7 = net.one97.paytm.moneytransferv4.a.a.a.f54784c;
                    PaymentManager paymentManager5 = PaymentManager.f54783a;
                    m.a(i7, (Fragment) a.C0982a.a(PaymentManager.a((VPADetails) iJRDataModel), (Activity) null, 14), "BeneficiaryHistoryFragment", getSupportFragmentManager());
                }
            } else if (this.k) {
                q a3 = getSupportFragmentManager().a();
                int i8 = net.one97.paytm.upi.R.id.container;
                a.C0982a aVar8 = net.one97.paytm.moneytransferv4.a.a.a.f54784c;
                Intent intent2 = getIntent();
                kotlin.g.b.k.a((Object) intent2, "intent");
                Uri data = intent2.getData();
                if (data == null) {
                    kotlin.g.b.k.a();
                }
                kotlin.g.b.k.a((Object) data, "intent.data!!");
                kotlin.g.b.k.c(data, "uri");
                net.one97.paytm.moneytransferv4.a.a.a aVar9 = new net.one97.paytm.moneytransferv4.a.a.a();
                Bundle bundle2 = new Bundle();
                bundle2.putString("uri", data.toString());
                aVar9.setArguments(bundle2);
                a3.a(i8, aVar9, a.f55526c.getClass().getName()).b();
            } else if (this.f55517e) {
                PaymentManager paymentManager6 = PaymentManager.f54783a;
                Intent intent3 = getIntent();
                kotlin.g.b.k.a((Object) intent3, "intent");
                PaymentManager.PaymentUICollectRequestModel a4 = PaymentManager.a(intent3);
                a.C0982a aVar10 = net.one97.paytm.moneytransferv4.a.a.a.f54784c;
                kotlin.g.b.k.c(a4, "collectModel");
                net.one97.paytm.moneytransferv4.a.a.a aVar11 = new net.one97.paytm.moneytransferv4.a.a.a();
                Bundle bundle3 = new Bundle();
                bundle3.putSerializable("collect_flow", a4);
                aVar11.setArguments(bundle3);
                getSupportFragmentManager().a().a(net.one97.paytm.upi.R.id.container, aVar11, a.f55526c.getClass().getName()).b();
            } else {
                n();
            }
        }
        getSupportFragmentManager().a((j.c) new b(this));
        if (m()) {
            i a5 = i.a();
            kotlin.g.b.k.a((Object) a5, "PaytmUpiSdk.getInstance()");
            net.one97.paytm.upi.f.a g2 = a5.g();
            kotlin.g.b.k.a((Object) g2, "PaytmUpiSdk.getInstance().themeProvider");
            if (g2 != null) {
                Context applicationContext = getApplicationContext();
                kotlin.g.b.k.a((Object) applicationContext, "applicationContext");
                g2.a(applicationContext);
            }
        }
        if (!this.j && !this.f55516d && !this.f55521i && !this.f55515c && !this.f55517e && !this.f55520h && !this.k) {
            z2 = true;
        }
        if (z2) {
            f.a(getApplicationContext(), CJRGTMConstants.MONEY_TRANSFER_UPI, CJRGTMConstants.MT_V4_HOMEPAGE_ICON_CLICKED, CJRGTMConstants.MT_V4_SCREEN_NAME, String.valueOf(m.b(getApplicationContext())), "");
        }
    }

    static final class b implements j.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoneyTransferV4Activity f55522a;

        b(MoneyTransferV4Activity moneyTransferV4Activity) {
            this.f55522a = moneyTransferV4Activity;
        }

        public final void a() {
            com.paytm.utility.b.c((Activity) this.f55522a);
        }
    }

    private final void n() {
        q a2 = getSupportFragmentManager().a();
        int i2 = net.one97.paytm.upi.R.id.container;
        a.C1027a aVar = a.f55526c;
        a2.a(i2, a.C1027a.a(), a.f55526c.getClass().getName()).b();
    }

    public final void e(String str) {
        if (!isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(str);
            builder.setNegativeButton(17039370, new d(this));
            builder.show();
        }
    }

    static final class d implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoneyTransferV4Activity f55525a;

        d(MoneyTransferV4Activity moneyTransferV4Activity) {
            this.f55525a = moneyTransferV4Activity;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.cancel();
            if (this.f55525a.f55518f || this.f55525a.f55517e || this.f55525a.f55520h || this.f55525a.f55521i || this.f55525a.j) {
                this.f55525a.finish();
            }
        }
    }

    public final void a(String str, String str2, String str3) {
        CustomWalletAlertDialog customWalletAlertDialog = new CustomWalletAlertDialog(this);
        customWalletAlertDialog.setTitle(str);
        customWalletAlertDialog.setCanceledOnTouchOutside(false);
        customWalletAlertDialog.setCancelable(false);
        customWalletAlertDialog.setMessage(str2);
        customWalletAlertDialog.setButton(-1, str3, new c(this, customWalletAlertDialog));
        customWalletAlertDialog.show();
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoneyTransferV4Activity f55523a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CustomWalletAlertDialog f55524b;

        c(MoneyTransferV4Activity moneyTransferV4Activity, CustomWalletAlertDialog customWalletAlertDialog) {
            this.f55523a = moneyTransferV4Activity;
            this.f55524b = customWalletAlertDialog;
        }

        public final void onClick(View view) {
            this.f55524b.dismiss();
            if (this.f55523a.j || this.f55523a.f55518f || this.f55523a.f55521i || this.f55523a.f55520h) {
                this.f55523a.finish();
            }
        }
    }

    public final boolean m() {
        return !this.j && !this.f55521i && !this.f55515c && !this.f55517e && !this.f55520h && !this.k;
    }

    public final void a(List<? extends UpiProfileDefaultBank> list) {
        y<ArrayList<UpiProfileDefaultBank>> yVar;
        ArrayList value;
        net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a aVar = this.o;
        if (aVar != null && (yVar = aVar.f55568h) != null && (value = yVar.getValue()) != null) {
            value.clear();
        }
    }

    public final boolean b() {
        return this.f55520h;
    }

    public final boolean h() {
        return this.f55515c;
    }

    public final boolean f() {
        return this.f55517e;
    }

    public final boolean g() {
        return this.f55516d;
    }

    public final void d(String str) {
        net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a aVar;
        if (str != null && (aVar = this.o) != null) {
            kotlin.g.b.k.c(str, "vpa");
            y<String> yVar = aVar.f55564d;
            if (yVar != null) {
                yVar.setValue(str);
            }
        }
    }

    public final boolean d() {
        return this.f55521i;
    }

    public final boolean k() {
        return UpiAppUtils.isNetworkAvailable(getApplicationContext());
    }

    public final void b(String str) {
        net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a aVar;
        if (str != null && (aVar = this.o) != null) {
            kotlin.g.b.k.c(str, "balance");
            y<String> yVar = aVar.f55566f;
            if (yVar != null) {
                yVar.setValue(str);
            }
        }
    }

    public final void a(ArrayList<UpiProfileDefaultBank> arrayList, ArrayList<UpiProfileDefaultBank> arrayList2) {
        net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a aVar;
        net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a aVar2;
        net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a aVar3 = this.o;
        if (aVar3 != null) {
            aVar3.f55563c = Boolean.TRUE;
        }
        if (!(arrayList == null || (aVar2 = this.o) == null)) {
            kotlin.g.b.k.c(arrayList, "list");
            y<ArrayList<UpiProfileDefaultBank>> yVar = aVar2.f55568h;
            if (yVar != null) {
                yVar.setValue(arrayList);
            }
        }
        if (arrayList2 != null && (aVar = this.o) != null) {
            kotlin.g.b.k.c(arrayList2, "list");
            y<ArrayList<UpiProfileDefaultBank>> yVar2 = aVar.f55569i;
            if (yVar2 != null) {
                yVar2.setValue(arrayList2);
            }
        }
    }

    public final void a(String str) {
        net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a aVar;
        if (!(str == null || (aVar = this.o) == null)) {
            kotlin.g.b.k.c(str, "accNo");
            y<String> yVar = aVar.f55565e;
            if (yVar != null) {
                yVar.setValue(str);
            }
        }
        if (str != null) {
            this.l = str;
        }
        d.a aVar2 = this.m;
        if (aVar2 != null) {
            aVar2.a(this.l);
        }
    }

    public final boolean e() {
        return this.j;
    }

    public final void a(UpiCustomVolleyError upiCustomVolleyError) {
        if (this.f55518f || this.f55517e || this.f55520h) {
            MoneyTransferV3Activity.b bVar = MoneyTransferV3Activity.b.SOMETHING_WENT_WRONG;
        } else if (upiCustomVolleyError == null) {
        } else {
            if (p.a(UpiUtils.AUTHENTICATION_FAILURE_401, upiCustomVolleyError.getmErrorCode(), true) || p.a("410", upiCustomVolleyError.getmErrorCode(), true)) {
                d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
                new NetworkCustomError();
                net.one97.paytm.moneytransfer.d.d.b(d.a.a()).a((Activity) this, (String) null, false);
            } else if (upiCustomVolleyError.getAlertMessage() != null) {
                String alertMessage = upiCustomVolleyError.getAlertMessage();
                kotlin.g.b.k.a((Object) alertMessage, "error.alertMessage");
                CharSequence charSequence = alertMessage;
                int length = charSequence.length() - 1;
                int i2 = 0;
                boolean z = false;
                while (i2 <= length) {
                    boolean z2 = charSequence.charAt(!z ? i2 : length) <= ' ';
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length--;
                    } else if (!z2) {
                        z = true;
                    } else {
                        i2++;
                    }
                }
                String obj = charSequence.subSequence(i2, length + 1).toString();
                if (TextUtils.isEmpty(obj)) {
                    obj = getString(net.one97.paytm.upi.R.string.upi_oops_something_went_wrong);
                }
                com.paytm.utility.b.b((Context) this, "Error", obj);
            } else {
                com.paytm.utility.b.b((Context) this, "Error", getString(net.one97.paytm.upi.R.string.upi_oops_something_went_wrong));
            }
        }
    }

    public final boolean i() {
        return this.f55518f;
    }

    public final void a(Double d2, Double d3, Double d4) {
        if (d2 != null) {
            double doubleValue = d2.doubleValue();
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a aVar = this.o;
            if (aVar != null) {
                aVar.j = doubleValue;
            }
        }
        if (d3 != null) {
            double doubleValue2 = d3.doubleValue();
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a aVar2 = this.o;
            if (aVar2 != null) {
                aVar2.k = doubleValue2;
            }
        }
        if (d4 != null) {
            double doubleValue3 = d4.doubleValue();
            net.one97.paytm.moneytransferv4.home.presentation.viewmodel.a aVar3 = this.o;
            if (aVar3 != null) {
                aVar3.l = doubleValue3;
            }
        }
    }

    public final void onBackPressed() {
        Fragment c2 = getSupportFragmentManager().c(net.one97.paytm.upi.R.id.container);
        if (c2 instanceof net.one97.paytm.moneytransferv4.search.b) {
            net.one97.paytm.moneytransferv4.search.b bVar = (net.one97.paytm.moneytransferv4.search.b) c2;
            if (bVar.getChildFragmentManager().c(R.id.inviteContainer) == null) {
                j fragmentManager = bVar.getFragmentManager();
                if (fragmentManager != null) {
                    fragmentManager.d();
                    return;
                }
                return;
            }
            bVar.getChildFragmentManager().d();
            return;
        }
        if (getIntent().getBooleanExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, false)) {
            j supportFragmentManager = getSupportFragmentManager();
            kotlin.g.b.k.a((Object) supportFragmentManager, "supportFragmentManager");
            if (supportFragmentManager.f() <= 1) {
                finish();
                return;
            }
        }
        j supportFragmentManager2 = getSupportFragmentManager();
        kotlin.g.b.k.a((Object) supportFragmentManager2, "supportFragmentManager");
        int size = supportFragmentManager2.g().size();
        if (size > 0) {
            Fragment fragment = supportFragmentManager2.g().get(size - 1);
            if (fragment instanceof net.one97.paytm.moneytransferv4.a.a.a) {
                net.one97.paytm.moneytransferv4.home.presentation.a.b bVar2 = ((net.one97.paytm.moneytransferv4.a.a.a) fragment).f54785a;
                if (bVar2 == null) {
                    kotlin.g.b.k.a("paymentFragment");
                }
                if (bVar2 != null) {
                    bVar2.d();
                }
            } else if ((fragment instanceof a) || (fragment instanceof net.one97.paytm.moneytransferv4.b.a.a.a.g.a) || (fragment instanceof net.one97.paytm.moneytransferv4.invite.d)) {
                finish();
            } else {
                supportFragmentManager2.d();
            }
        } else {
            finish();
        }
        com.paytm.utility.b.c((Activity) this);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 104) {
            j supportFragmentManager = getSupportFragmentManager();
            kotlin.g.b.k.a((Object) supportFragmentManager, "supportFragmentManager");
            List<Fragment> g2 = supportFragmentManager.g();
            kotlin.g.b.k.a((Object) g2, "supportFragmentManager.fragments");
            for (Fragment next : g2) {
                if (next instanceof net.one97.paytm.moneytransferv4.a.a.a) {
                    net.one97.paytm.moneytransferv4.home.presentation.a.b bVar = ((net.one97.paytm.moneytransferv4.a.a.a) next).f54785a;
                    if (bVar == null) {
                        kotlin.g.b.k.a("paymentFragment");
                    }
                    if (bVar != null && bVar.isAdded()) {
                        if (i3 == -1) {
                            bVar.m = true;
                            net.one97.paytm.wallet.utility.d dVar = net.one97.paytm.wallet.utility.d.f72319a;
                            if (intent == null) {
                                kotlin.g.b.k.a();
                            }
                            net.one97.paytm.wallet.utility.d.a(intent, bVar.l(), bVar.n);
                            return;
                        }
                        net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.d dVar2 = bVar.k;
                        if (dVar2 != null) {
                            dVar2.b();
                        }
                        net.one97.paytm.moneytransferv4.accountsbottomsheet.paymentcombination.d dVar3 = bVar.k;
                        if (dVar3 != null) {
                            CustomAmountTextInputEditText customAmountTextInputEditText = bVar.f55438a;
                            if (customAmountTextInputEditText == null) {
                                kotlin.g.b.k.a("amountET");
                            }
                            dVar3.a(String.valueOf(customAmountTextInputEditText != null ? customAmountTextInputEditText.getText() : null), bVar.l);
                        }
                        bVar.m = false;
                        return;
                    }
                    return;
                }
            }
        }
    }

    public final void a(PaymentFlow paymentFlow) {
        kotlin.g.b.k.c(paymentFlow, PayUtility.PAYMENT_FLOW);
        a.C0982a aVar = net.one97.paytm.moneytransferv4.a.a.a.f54784c;
        m.a(net.one97.paytm.upi.R.id.container, (Fragment) a.C0982a.a(paymentFlow), getSupportFragmentManager());
    }

    public final void b(PaymentFlow paymentFlow) {
        kotlin.g.b.k.c(paymentFlow, PayUtility.PAYMENT_FLOW);
        d.a aVar = net.one97.paytm.moneytransferv4.invite.d.f55674a;
        m.a(net.one97.paytm.upi.R.id.container, (Fragment) d.a.a(paymentFlow), "BeneficiaryHistoryFragment", getSupportFragmentManager());
    }

    public final void a(String str, String str2) {
        m.a(getApplicationContext(), str, str2);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static boolean a(DeepLinkData deepLinkData) {
        kotlin.g.b.k.c(deepLinkData, "deepLinkData");
        String str = deepLinkData.f50283a;
        if (TextUtils.isEmpty(deepLinkData.f50283a)) {
            return false;
        }
        Uri build = Uri.parse(str).buildUpon().build();
        kotlin.g.b.k.a((Object) build, "Uri.parse(deepLinkUrl).buildUpon().build()");
        if (!TextUtils.isEmpty(build.getQueryParameter("account")) || !TextUtils.isEmpty(build.getQueryParameter("pa"))) {
            return true;
        }
        return false;
    }

    public static final Intent a(Context context, int i2, IJRDataModel iJRDataModel) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(iJRDataModel, Payload.RESPONSE);
        Intent intent = new Intent(context, MoneyTransferV4Activity.class);
        intent.putExtra("search_screen_response", iJRDataModel);
        intent.putExtra("source_flag", i2);
        intent.putExtra("isPayFlow", true);
        return intent;
    }

    public static final Intent b(Context context, int i2, IJRDataModel iJRDataModel) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(iJRDataModel, Payload.RESPONSE);
        Intent intent = new Intent(context, MoneyTransferV4Activity.class);
        intent.putExtra("search_screen_response", iJRDataModel);
        intent.putExtra("source_flag", i2);
        intent.putExtra("entry_point", "PAY");
        intent.putExtra("isPayFlow", true);
        return intent;
    }

    public static final Intent c(Context context, int i2, IJRDataModel iJRDataModel) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(iJRDataModel, Payload.RESPONSE);
        Intent intent = new Intent(context, MoneyTransferV4Activity.class);
        intent.putExtra("search_screen_response", iJRDataModel);
        intent.putExtra("source_flag", i2);
        intent.putExtra("entry_point", "DEEPLINK");
        intent.putExtra("isPayFlow", true);
        return intent;
    }

    public static final Intent d(Context context, int i2, IJRDataModel iJRDataModel) {
        kotlin.g.b.k.c(context, "context");
        kotlin.g.b.k.c(iJRDataModel, Payload.RESPONSE);
        Intent intent = new Intent(context, MoneyTransferV4Activity.class);
        intent.putExtra("search_screen_response", iJRDataModel);
        intent.putExtra("source_flag", i2);
        intent.putExtra("entry_point", "PAY");
        intent.putExtra("isPayFlow", true);
        return intent;
    }

    public static final Intent a(Activity activity, int i2, IJRDataModel iJRDataModel) {
        kotlin.g.b.k.c(activity, "activity");
        kotlin.g.b.k.c(iJRDataModel, Payload.RESPONSE);
        Intent intent = new Intent(activity, MoneyTransferV4Activity.class);
        if (i2 == 2001) {
            intent.putExtra("from_app_evoke", true);
        }
        if (i2 == 2002) {
            intent.putExtra("is_from_chat_flow", true);
        }
        intent.putExtra("search_screen_response", iJRDataModel);
        return intent;
    }
}
