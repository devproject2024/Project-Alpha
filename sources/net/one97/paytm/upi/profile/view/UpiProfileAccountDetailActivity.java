package net.one97.paytm.upi.profile.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.c;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.b;
import androidx.fragment.app.Fragment;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.PaytmLogs;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.h;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.k;
import net.one97.paytm.upi.profile.a.g;
import net.one97.paytm.upi.profile.presenter.f;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.CustomWalletLoaderDialog;
import net.one97.paytm.upi.util.GAConstants;
import net.one97.paytm.upi.util.IncorrectUpiPinBottomSheet;
import net.one97.paytm.upi.util.PaytmUpiPrefUtil;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public class UpiProfileAccountDetailActivity extends PaytmActivity implements View.OnClickListener, a.C1347a, g.b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f68160a = UpiProfileAccountDetailActivity.class.getSimpleName();
    private View A;
    private View B;
    private BankAccountDetails.BankAccount C;
    private String D;
    /* access modifiers changed from: private */
    public UserUpiDetails E;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public g.a f68161b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f68162c;

    /* renamed from: d  reason: collision with root package name */
    private RelativeLayout f68163d;

    /* renamed from: e  reason: collision with root package name */
    private RelativeLayout f68164e;

    /* renamed from: f  reason: collision with root package name */
    private RelativeLayout f68165f;

    /* renamed from: g  reason: collision with root package name */
    private RelativeLayout f68166g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f68167h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f68168i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private ProgressDialog p;
    private TextView q;
    private TextView r;
    private TextView s;
    private ImageView t;
    private ImageView u;
    private TextView v;
    private TextView w;
    private CustomWalletLoaderDialog x;
    private View y;
    private View z;

    public final /* bridge */ /* synthetic */ void a(Object obj) {
    }

    public static void a(Fragment fragment, BankAccountDetails.BankAccount bankAccount, String str, int i2) {
        Intent intent = new Intent(fragment.getContext(), UpiProfileAccountDetailActivity.class);
        intent.putExtra("vpa", str);
        intent.putExtra(UpiConstants.EXTRA_SELECTED_BANK, bankAccount);
        fragment.startActivityForResult(intent, i2);
    }

    public static void a(Activity activity, BankAccountDetails.BankAccount bankAccount, String str) {
        Intent intent = new Intent(activity, UpiProfileAccountDetailActivity.class);
        intent.putExtra("vpa", str);
        intent.putExtra(UpiConstants.EXTRA_SELECTED_BANK, bankAccount);
        activity.startActivityForResult(intent, 35);
    }

    public void attachBaseContext(Context context) {
        if (i.a().m == null) {
            super.attachBaseContext(context);
        }
        ContextWrapper d2 = i.a().m.d(context);
        if (d2 != null) {
            super.attachBaseContext(d2);
        } else {
            super.attachBaseContext(context);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_upi_account_detail);
        this.f68162c = (RelativeLayout) findViewById(R.id.rl_make_default);
        this.y = findViewById(R.id.default_divider);
        this.f68163d = (RelativeLayout) findViewById(R.id.rl_check_balance);
        this.f68164e = (RelativeLayout) findViewById(R.id.rl_change_mpin);
        this.f68165f = (RelativeLayout) findViewById(R.id.rl_reset_mpin);
        this.o = (TextView) findViewById(R.id.tv_balance_value);
        this.u = (ImageView) findViewById(R.id.info_icon);
        this.f68166g = (RelativeLayout) findViewById(R.id.rl_delete_bank);
        this.m = (TextView) findViewById(R.id.tv_branch_address);
        this.t = (ImageView) findViewById(R.id.iv_bank_icon);
        this.n = (TextView) findViewById(R.id.tv_check_balance);
        this.v = (TextView) findViewById(R.id.tv_uod_warning);
        this.w = (TextView) findViewById(R.id.tv_acc_label);
        this.z = findViewById(R.id.change_mpin_divider);
        this.A = findViewById(R.id.check_balance_divider);
        this.B = findViewById(R.id.reset_mpin_divider);
        this.s = (TextView) findViewById(R.id.tv_set_mpin);
        this.f68167h = (TextView) findViewById(R.id.tv_customer_name);
        this.f68168i = (TextView) findViewById(R.id.tv_bank_name);
        this.j = (TextView) findViewById(R.id.tv_acc_no);
        this.k = (TextView) findViewById(R.id.tv_acc_type);
        this.l = (TextView) findViewById(R.id.tv_ifsc_code);
        this.r = (TextView) findViewById(R.id.tv_upi_pin_msg);
        findViewById(R.id.rb_bank_select).setVisibility(8);
        this.f68162c.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.f68164e.setOnClickListener(this);
        this.f68165f.setOnClickListener(this);
        this.f68166g.setOnClickListener(this);
        this.s.setOnClickListener(this);
        this.f68163d.setVisibility(8);
        this.A.setVisibility(8);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.q = (TextView) toolbar.findViewById(R.id.tv_toolbar_title);
        this.q.setText("");
        toolbar.setNavigationIcon(R.drawable.back_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                UpiProfileAccountDetailActivity.this.finish();
            }
        });
        if (bundle == null) {
            this.D = getIntent().getStringExtra("vpa");
            this.C = (BankAccountDetails.BankAccount) getIntent().getSerializableExtra(UpiConstants.EXTRA_SELECTED_BANK);
        } else {
            this.D = bundle.getString("vpa");
            this.C = (BankAccountDetails.BankAccount) bundle.getSerializable(UpiConstants.EXTRA_SELECTED_BANK);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.C);
        this.E = new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, this.D).setBankAccountList(arrayList).setSelectedBankIdx(0).build();
        this.f68161b = new f(net.one97.paytm.upi.g.a(), net.one97.paytm.upi.g.a(a.a(net.one97.paytm.upi.g.d(), (a.C1347a) null)), a.a(net.one97.paytm.upi.g.d(), this), this, this.E);
        this.f68161b.e();
        CJRSendGTMTag.sendNewCustomGTMEvents(this, GAConstants.CATEGORY.UPI_ONB_V1, "screen_open", this.C.getBankName(), "", "", GAConstants.SCREEN_NAME.BANK_DETAIL_PAGE, "wallet");
    }

    public final void j() {
        this.f68162c.setVisibility(0);
        this.y.setVisibility(0);
    }

    public final void a() {
        a(getString(R.string.please_wait));
    }

    public final void a(UpiCustomVolleyError upiCustomVolleyError, String str) {
        l();
        if (!TextUtils.isEmpty(str)) {
            if ("ZM".equals(str)) {
                b(false);
            } else if ("1006".equals(str)) {
                a(11);
            } else if ("Z6".equals(str)) {
                b(true);
            } else {
                Toast.makeText(this, R.string.upi_check_balance_error, 1).show();
            }
        } else if (upiCustomVolleyError != null) {
            String str2 = upiCustomVolleyError.getmErrorCode();
            if (TextUtils.isEmpty(str2) || !UpiConstants.NETWORK_ERROR_CODE.equals(str2)) {
                Toast.makeText(this, R.string.upi_some_went_wrong, 1).show();
            } else {
                CustomDialog.showAlert(this, getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
            }
        } else {
            Toast.makeText(this, R.string.upi_some_went_wrong, 1).show();
        }
    }

    private void b(boolean z2) {
        IncorrectUpiPinBottomSheet.show(new IncorrectUpiPinBottomSheet.OnItemClick() {
            public final void onReEnterClicked() {
                if (!UpiAppUtils.isNetworkAvailable(UpiProfileAccountDetailActivity.this)) {
                    UpiProfileAccountDetailActivity upiProfileAccountDetailActivity = UpiProfileAccountDetailActivity.this;
                    CustomDialog.showAlert(upiProfileAccountDetailActivity, upiProfileAccountDetailActivity.getResources().getString(R.string.no_connection), UpiProfileAccountDetailActivity.this.getResources().getString(R.string.no_internet));
                } else if (UpiProfileAccountDetailActivity.this.k()) {
                    UpiProfileAccountDetailActivity.this.f68161b.a();
                } else {
                    UpiProfileAccountDetailActivity.this.a(11);
                }
            }

            public final void onCreateNewPinClicked() {
                UpiProfileAccountDetailActivity upiProfileAccountDetailActivity = UpiProfileAccountDetailActivity.this;
                UserUpiDetails c2 = upiProfileAccountDetailActivity.E;
                if (UpiAppUtils.isNetworkAvailable(upiProfileAccountDetailActivity)) {
                    if (c2.getBankAccountList() != null) {
                        h hVar = i.a().m;
                        hVar.a("UpiProfileAccountDetailActivity", c2.getBankAccountList().size() + "_" + c2.getSelectedBankIdx());
                    } else {
                        h hVar2 = i.a().m;
                        hVar2.a("UpiProfileAccountDetailActivity", "null_" + c2.getSelectedBankIdx());
                    }
                    SetMPINActivity.a(upiProfileAccountDetailActivity, c2, 10, true);
                    return;
                }
                CustomDialog.showAlert(upiProfileAccountDetailActivity, upiProfileAccountDetailActivity.getString(R.string.no_connection), upiProfileAccountDetailActivity.getString(R.string.no_internet_new_message));
            }
        }, getSupportFragmentManager(), z2);
    }

    public final void a(final String str, final String str2) {
        l();
        this.o.setVisibility(0);
        this.u.setVisibility(0);
        this.n.setVisibility(4);
        this.o.setText(getString(R.string.upi_new_balance, new Object[]{UpiAppUtils.priceToString(str2)}));
        this.u.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                UpiUtils.addBalanceSheet(str, str2, UpiProfileAccountDetailActivity.this.getSupportFragmentManager());
            }
        });
    }

    public final void b() {
        a(getString(R.string.please_wait));
    }

    public final void c() {
        l();
    }

    public final void b(UpiCustomVolleyError upiCustomVolleyError, String str) {
        l();
        if (TextUtils.isEmpty(str)) {
            String str2 = upiCustomVolleyError.getmErrorCode();
            if (TextUtils.isEmpty(str2) || !UpiConstants.NETWORK_ERROR_CODE.equals(str2)) {
                Toast.makeText(this, R.string.upi_some_went_wrong, 1).show();
            } else {
                CustomDialog.showAlert(this, getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
            }
        } else if ("ZM".equals(str) || "RM".equals(str)) {
            Toast.makeText(this, R.string.upi_incorrect_mpin, 1).show();
        } else if ("1006".equals(str)) {
            a(12);
        } else {
            Toast.makeText(this, R.string.upi_reset_mpin_error, 1).show();
        }
    }

    public final void d() {
        l();
        Toast.makeText(this, R.string.upi_reset_mpin_success, 1).show();
    }

    public final void e() {
        a(getString(R.string.please_wait));
    }

    public final void f() {
        Toast.makeText(this, R.string.upi_bank_delete_success, 1).show();
        l();
        setResult(-1);
        finish();
    }

    public final void c(UpiCustomVolleyError upiCustomVolleyError, String str) {
        l();
        if ("88".equals(str) || "80".equals(str)) {
            Toast.makeText(this, R.string.upi_delete_default_bank, 1).show();
        } else if ("102".equals(str)) {
            Toast.makeText(this, R.string.upi_delete_default_bank_vpa, 1).show();
        } else if ("INT-1199".equals(str)) {
            Toast.makeText(this, R.string.upi_delete_default_bank_vpa, 1).show();
        } else {
            String str2 = upiCustomVolleyError.getmErrorCode();
            if (TextUtils.isEmpty(str2) || !UpiConstants.NETWORK_ERROR_CODE.equals(str2)) {
                Toast.makeText(this, R.string.upi_some_went_wrong, 1).show();
            } else {
                CustomDialog.showAlert(this, getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
            }
        }
    }

    public final void g() {
        k kVar = i.a().k;
        new UpiCustomVolleyError();
        kVar.e(this);
    }

    public final void h() {
        l();
        Toast.makeText(this, R.string.upi_some_went_wrong, 1).show();
    }

    public final void i() {
        Toast.makeText(this, R.string.upi_some_went_wrong, 1).show();
    }

    public final void c(UserUpiDetails userUpiDetails) {
        this.f68162c.setVisibility(8);
        this.y.setVisibility(8);
        BankAccountDetails.BankAccount selectedBankAccount = userUpiDetails.getSelectedBankAccount();
        setResult(-1);
        if (selectedBankAccount != null) {
            Toast.makeText(this, getString(R.string.upi_default_account_success, new Object[]{selectedBankAccount.getBankName()}), 1).show();
            return;
        }
        Toast.makeText(this, getString(R.string.upi_default_bank_changed), 1).show();
    }

    public final void d(UpiCustomVolleyError upiCustomVolleyError, String str) {
        if (upiCustomVolleyError != null) {
            if (UpiConstants.NETWORK_ERROR_CODE.equalsIgnoreCase(upiCustomVolleyError.getmErrorCode())) {
                CustomDialog.showAlert(this, getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
            }
        } else if (!TextUtils.isEmpty(str)) {
            Toast.makeText(this, str, 1).show();
        } else {
            Toast.makeText(this, getString(R.string.upi_default_bank_account_change_failed), 1).show();
        }
    }

    public final void a(boolean z2) {
        try {
            if (this.x == null) {
                this.x = new CustomWalletLoaderDialog(this);
            }
            if (z2) {
                this.x.setTitle(getString(R.string.upi_changing_default_account_text));
                this.x.showLoader();
                return;
            }
            this.x.dismissLoader();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(UserUpiDetails userUpiDetails) {
        String str;
        BankAccountDetails.BankAccount selectedBankAccount = userUpiDetails.getSelectedBankAccount();
        if (selectedBankAccount != null && selectedBankAccount.getCredsAllowed() != null) {
            this.f68167h.setText(selectedBankAccount.getCustomerName());
            this.m.setText(selectedBankAccount.getBranchAddress());
            this.f68168i.setText(selectedBankAccount.getBankName());
            UpiConstants.BANK_ACCOUNT_TYPE valueOf = UpiConstants.BANK_ACCOUNT_TYPE.valueOf(this.C.getAccountType());
            this.j.setText(getString(valueOf.getAccDisplayStringId(), new Object[]{UpiUtils.maskNumber(selectedBankAccount.getAccount())}));
            if (valueOf == UpiConstants.BANK_ACCOUNT_TYPE.UOD) {
                this.v.setText(Html.fromHtml(getString(R.string.upi_uod_bank_link_message)));
                this.v.setVisibility(0);
            }
            this.l.setText(selectedBankAccount.getIfsc());
            if (!TextUtils.isEmpty(selectedBankAccount.getAccountType())) {
                this.k.setText(selectedBankAccount.getAccountType());
            }
            w.a().a(selectedBankAccount.getBankLogoUrl()).a(R.drawable.ic_paytm_payments_bank).b(R.drawable.ic_paytm_payments_bank).a(this.t, (e) null);
            Iterator<BankAccountDetails.BankAccountCredentials> it2 = selectedBankAccount.getCredsAllowed().getChild().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    str = "0";
                    break;
                }
                BankAccountDetails.BankAccountCredentials next = it2.next();
                if ("MPIN".equals(next.getCredsAllowedSubType())) {
                    str = next.getCredsAllowedDLength();
                    break;
                }
            }
            if (selectedBankAccount.isMpinSet()) {
                this.r.setVisibility(8);
                this.r.setText(String.format(getString(R.string.upi_pin_exists), new Object[]{str}));
                this.r.setTextColor(b.c(this, R.color.upi_pin_green));
                return;
            }
            this.r.setText(String.format(getString(R.string.upi_pin_set), new Object[]{str}));
            this.r.setTextColor(b.c(this, R.color.upi_pin_red));
            this.s.setVisibility(0);
            this.f68164e.setVisibility(8);
            this.z.setVisibility(8);
            if (selectedBankAccount.getIfsc().contains("PYTM")) {
                this.n.setVisibility(0);
            } else {
                this.n.setVisibility(8);
            }
            this.f68165f.setVisibility(8);
            this.B.setVisibility(8);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("vpa", this.D);
        bundle.putSerializable(UpiConstants.EXTRA_SELECTED_BANK, this.C);
    }

    public final void b(UserUpiDetails userUpiDetails) {
        if (UpiAppUtils.isNetworkAvailable(this)) {
            if (userUpiDetails.getBankAccountList() != null) {
                h hVar = i.a().m;
                hVar.a("UpiProfileAccountDetailActivity", userUpiDetails.getBankAccountList().size() + "_" + userUpiDetails.getSelectedBankIdx());
            } else {
                h hVar2 = i.a().m;
                hVar2.a("UpiProfileAccountDetailActivity", "null_" + userUpiDetails.getSelectedBankIdx());
            }
            SetMPINActivity.a(this, userUpiDetails, 10, false);
            return;
        }
        CustomDialog.showAlert(this, getString(R.string.no_connection), getString(R.string.no_internet_new_message));
    }

    public void onServiceConnected() {
        PaytmLogs.d(f68160a, "onServiceConnected");
    }

    public void onServiceDisconnected() {
        PaytmLogs.d(f68160a, "onServiceDisconnected");
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 10) {
            if (i3 == -1) {
                Intent intent2 = new Intent();
                intent2.putExtra("launch_account_detail", true);
                intent2.putExtra(UpiConstants.EXTRA_SELECTED_BANK, this.C);
                setResult(-1, intent2);
                finish();
            }
        } else if (i2 == 11) {
            if (i3 == -1) {
                this.f68161b.a();
            }
        } else if (i2 == 13) {
            if (i3 == -1) {
                this.f68161b.b();
            }
        } else if (i2 == 14 && i3 == -1) {
            this.f68161b.c();
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_check_balance) {
            if (!UpiAppUtils.isNetworkAvailable(this)) {
                CustomDialog.showAlert(this, getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
            } else if (k()) {
                this.f68161b.a();
            } else {
                a(11);
            }
        } else if (id == R.id.rl_change_mpin) {
            CJRSendGTMTag.sendNewCustomGTMEvents(this, CJRGTMConstants.UPI_EVENT_CATEGORY, "change_upi_pin", "", "", "", "/bhim-upi/bank-details", "wallet");
            if (k()) {
                this.f68161b.b();
            } else {
                a(12);
            }
        } else if (id == R.id.tv_set_mpin || id == R.id.rl_reset_mpin) {
            CJRSendGTMTag.sendNewCustomGTMEvents(this, CJRGTMConstants.UPI_EVENT_CATEGORY, "set_upi_pin", "", "", "", "/bhim-upi/bank-details", "wallet");
            CJRSendGTMTag.sendNewCustomGTMEvents(this, GAConstants.CATEGORY.UPI_ONB_V1, "set_mpin_clicked", this.C.getBankName(), "", "", GAConstants.SCREEN_NAME.BANK_DETAIL_PAGE, "wallet");
            if (k()) {
                this.f68161b.b();
            } else {
                a(13);
            }
        } else if (id == R.id.rl_delete_bank) {
            CJRSendGTMTag.sendNewCustomGTMEvents(this, CJRGTMConstants.UPI_EVENT_CATEGORY, "delete_bank", "", "", "", "/bhim-upi/bank-details", "wallet");
            c.a aVar = new c.a(this);
            aVar.a(true);
            aVar.a(R.string.upi_delete_bank);
            aVar.b(R.string.upi_delete_bank_confirmation);
            aVar.a(R.string.ok, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    UpiProfileAccountDetailActivity.this.f68161b.c();
                    dialogInterface.dismiss();
                }
            });
            aVar.b(R.string.cancel, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            });
            aVar.b();
        } else if (id == R.id.rl_make_default) {
            this.f68161b.d();
        }
    }

    public final boolean k() {
        return PaytmUpiPrefUtil.getPref(getApplicationContext()).b(UpiConstants.PREF_KEY_IS_SAME_DEVICE, false, true);
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        Intent intent = new Intent(this, UpiRegistrationActivity.class);
        intent.putExtra("redirect", i2);
        startActivityForResult(intent, i2);
    }

    private void a(String str) {
        this.p = new ProgressDialog(this);
        this.p.setMessage(str);
        this.p.setCancelable(false);
        this.p.show();
    }

    private void l() {
        ProgressDialog progressDialog = this.p;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.p.dismiss();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f68161b.f();
    }
}
