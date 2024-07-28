package net.one97.paytm.upi.requestmoney.view;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.textfield.TextInputLayout;
import d.a.a.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.games.model.pfg.BaseResult;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.PaytmLogs;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.models.BeneficiaryEntity;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.CommonPayParams;
import net.one97.paytm.upi.common.upi.UpiDBTransactionModel;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.ValidateVpaResponse;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.k;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.requestmoney.a.d;
import net.one97.paytm.upi.requestmoney.model.ContactItemModel;
import net.one97.paytm.upi.requestmoney.view.b;
import net.one97.paytm.upi.requestmoney.view.d;
import net.one97.paytm.upi.requestmoney.view.f;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.CustomWalletAlertDialog;
import net.one97.paytm.upi.util.PaytmUpiPrefUtil;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public class RequestMoneyV2Activity extends PaytmActivity implements View.OnClickListener, d.b, b.a, d.b, f.a {

    /* renamed from: c  reason: collision with root package name */
    public static int f69217c = 1010;
    /* access modifiers changed from: private */
    public boolean A;
    private AdapterView.OnItemClickListener B = new AdapterView.OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            UpiBaseDataModel a2 = ((h) adapterView.getAdapter()).getItem(i2);
            if (a2 instanceof UpiDBTransactionModel) {
                RequestMoneyV2Activity.this.b((UpiDBTransactionModel) a2);
            } else if (a2 instanceof BeneficiaryEntity) {
                BeneficiaryEntity beneficiaryEntity = (BeneficiaryEntity) a2;
                if (beneficiaryEntity.instrumentPreferences.otherBank != null) {
                    BeneficiaryEntity.OtherBankAccountDetail otherBankAccountDetail = beneficiaryEntity.instrumentPreferences.otherBank.accounts.get(0).accountDetail;
                    RequestMoneyV2Activity.this.b(new UpiDBTransactionModel("", otherBankAccountDetail.accountNumber, otherBankAccountDetail.accountHolderName, otherBankAccountDetail.bankName, otherBankAccountDetail.ifscCode, "", ""));
                } else if (beneficiaryEntity.instrumentPreferences.upi != null) {
                    BeneficiaryEntity.UPIAccountDetail uPIAccountDetail = beneficiaryEntity.instrumentPreferences.upi.accounts.get(0).accountDetail;
                    RequestMoneyV2Activity.this.b(new UpiDBTransactionModel("", uPIAccountDetail.vpa, uPIAccountDetail.accountHolderName, "", "UPI", "", ""));
                }
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    protected ProgressDialog f69218a;

    /* renamed from: b  reason: collision with root package name */
    protected ValidateVpaResponse f69219b;

    /* renamed from: d  reason: collision with root package name */
    private AppBarLayout f69220d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f69221e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ImageView f69222f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ImageView f69223g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public TextView f69224h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public TextView f69225i;
    private View j;
    private Dialog k;
    /* access modifiers changed from: private */
    public EditText l;
    private TextView m;
    private TextInputLayout n;
    /* access modifiers changed from: private */
    public AutoCompleteTextView o;
    private FrameLayout p;
    private FrameLayout q;
    private FrameLayout r;
    /* access modifiers changed from: private */
    public d.a s;
    private RequestMoneyV2Activity t;
    private String u;
    private String v;
    private ArrayList<UpiBaseDataModel> w = new ArrayList<>();
    /* access modifiers changed from: private */
    public d x;
    private h y;
    private ArrayList<UpiDBTransactionModel> z;

    public enum a {
        SOMETHING_WENT_WRONG,
        PLEASE_ADD_BANK,
        CANNOT_TRANSFER_TO_SAME_ACC,
        NO_SIM
    }

    public enum b {
        VERIFY_VPA,
        PROCESS_PAYMENT
    }

    public final void a(String str, String str2) {
    }

    public final void a(String str, String str2, String str3) {
    }

    public final void a(List<UpiProfileDefaultBank> list) {
    }

    public final void a(AccountProviderBody.AccountProvider accountProvider, String str) {
    }

    public final void a(a aVar) {
    }

    public final void a(boolean z2) {
    }

    public final void b(List<UpiProfileDefaultBank> list) {
    }

    public final void b(boolean z2) {
    }

    public final void h() {
    }

    public final void i() {
    }

    public final /* bridge */ /* synthetic */ void a(Object obj) {
        this.s = (d.a) obj;
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
        setContentView(a());
        int color = getResources().getColor(R.color.white);
        Window window = getWindow();
        if (window != null) {
            window.setSoftInputMode(16);
            if (Build.VERSION.SDK_INT >= 21) {
                View decorView = window.getDecorView();
                window.addFlags(Integer.MIN_VALUE);
                if (decorView != null) {
                    decorView.setSystemUiVisibility(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
                }
                window.setStatusBarColor(color);
            }
        }
        this.t = this;
        d();
        this.s = new net.one97.paytm.upi.requestmoney.presenter.d(g.c(), g.a(), g.a(net.one97.paytm.upi.h.a.a(g.d(), (a.C1347a) null)), net.one97.paytm.upi.h.a.a(g.d(), (a.C1347a) null), this);
        this.s.e();
        this.l.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (RequestMoneyV2Activity.this.x != null) {
                    d a2 = RequestMoneyV2Activity.this.x;
                    String charSequence2 = charSequence.toString();
                    ArrayList arrayList = new ArrayList();
                    if (charSequence2.isEmpty()) {
                        arrayList.addAll(a2.f69406a);
                        if (a2.f69409d != null) {
                            a2.f69409d.a(arrayList);
                            a2.f69408c.scrollToPositionWithOffset(0, 0);
                            return;
                        }
                        return;
                    }
                    Iterator<ContactItemModel> it2 = a2.f69406a.iterator();
                    while (it2.hasNext()) {
                        ContactItemModel next = it2.next();
                        if (next.getName().toLowerCase().contains(charSequence2.toLowerCase())) {
                            arrayList.add(next);
                        }
                    }
                    if (a2.f69409d != null) {
                        a2.f69409d.a(arrayList);
                    }
                }
            }
        });
        this.o.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                RequestMoneyV2Activity.this.f69222f.setVisibility(8);
                if (charSequence.length() <= 0) {
                    if (RequestMoneyV2Activity.this.A) {
                        RequestMoneyV2Activity.this.f69223g.setVisibility(0);
                    }
                    RequestMoneyV2Activity.this.f69224h.setVisibility(8);
                    RequestMoneyV2Activity.this.f69225i.setVisibility(8);
                    return;
                }
                RequestMoneyV2Activity.this.f69223g.setVisibility(8);
                RequestMoneyV2Activity.this.f69224h.setVisibility(8);
                RequestMoneyV2Activity.this.f69225i.setVisibility(0);
            }
        });
        this.f69220d.a((AppBarLayout.b) new AppBarLayout.b() {
            public final void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
                PaytmLogs.d("tag_scroll", "recycler_view current offset: ".concat(String.valueOf(i2)));
                if (Math.abs(i2) >= appBarLayout.getTotalScrollRange() - 20) {
                    RequestMoneyV2Activity.this.d(true);
                } else {
                    RequestMoneyV2Activity.this.d(false);
                }
            }
        });
        this.f69223g.setOnClickListener(this);
        this.f69224h.setOnClickListener(this);
        if (!(getIntent() == null || getIntent().getStringExtra(UpiConstants.EXTRA_PAYER_VPA) == null)) {
            this.o.setText(getIntent().getStringExtra(UpiConstants.EXTRA_PAYER_VPA));
        }
        try {
            c.a().a((Object) this, false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public int a() {
        return R.layout.activity_request_money_v2;
    }

    /* access modifiers changed from: protected */
    public void d() {
        this.f69220d = (AppBarLayout) findViewById(R.id.appbar);
        this.j = findViewById(R.id.searchLayout);
        this.l = (EditText) this.j.findViewById(R.id.searchEdt);
        this.m = (TextView) this.j.findViewById(R.id.search_cancel_tv);
        this.p = (FrameLayout) findViewById(R.id.recent_fragment_container);
        this.r = (FrameLayout) findViewById(R.id.contacts_fragment_container);
        this.q = (FrameLayout) findViewById(R.id.recent_txn_fragment_container);
        this.n = (TextInputLayout) findViewById(R.id.account_til);
        this.o = (AutoCompleteTextView) findViewById(R.id.account_number_et);
        this.f69224h = (TextView) findViewById(R.id.txt_verify_vpa);
        this.f69222f = (ImageView) findViewById(R.id.vpa_verified_iv);
        this.f69223g = (ImageView) findViewById(R.id.phonebook_iv);
        this.f69225i = (TextView) findViewById(R.id.proceedbutton);
        this.f69221e = (ImageView) findViewById(R.id.iv_back_button);
        this.o.setThreshold(1);
        this.m.setOnClickListener(this);
        this.f69225i.setOnClickListener(this);
        this.f69221e.setOnClickListener(this);
    }

    /* access modifiers changed from: protected */
    public int b() {
        return R.string.request_money_contacts;
    }

    /* access modifiers changed from: protected */
    public String c() {
        return getString(R.string.request_money_saved_accounts);
    }

    public final void f() {
        f fVar = new f();
        this.q.setVisibility(0);
        if (getSupportFragmentManager().c("recenttxn_fragment") == null) {
            getSupportFragmentManager().a().a(0, 0).a(R.id.recent_txn_fragment_container, fVar, "recenttxn_fragment").c();
        } else {
            getSupportFragmentManager().a().a(0, 0).b(R.id.recent_txn_fragment_container, fVar, "recenttxn_fragment").c();
        }
    }

    public final void e() {
        if (Build.VERSION.SDK_INT < 23 || androidx.core.content.b.a((Context) this.t, "android.permission.READ_CONTACTS") == 0) {
            this.x = d.a(b());
            this.r.setVisibility(0);
            if (getSupportFragmentManager().c("contact_fragment") == null) {
                getSupportFragmentManager().a().a(0, 0).b(R.id.contacts_fragment_container, this.x, "contact_fragment").c();
                return;
            }
            return;
        }
        requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 102);
    }

    public final void a(UpiCustomVolleyError upiCustomVolleyError) {
        if (upiCustomVolleyError == null) {
            return;
        }
        if (UpiUtils.AUTHENTICATION_FAILURE_401.equalsIgnoreCase(upiCustomVolleyError.getMessage()) || "410".equalsIgnoreCase(upiCustomVolleyError.getMessage())) {
            k kVar = i.a().k;
            RequestMoneyV2Activity.class.getName();
            kVar.e(this);
            return;
        }
        CustomDialog.showAlert(this, "Error", upiCustomVolleyError.getAlertMessage());
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:19|20|(1:26)|27|28|(1:40)(2:32|34)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0055 */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0061 A[Catch:{ Exception -> 0x0066 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(boolean r1, net.one97.paytm.upi.requestmoney.view.RequestMoneyV2Activity.b r2) {
        /*
            r0 = this;
            if (r1 == 0) goto L_0x003b
            if (r2 == 0) goto L_0x001f
            net.one97.paytm.upi.requestmoney.view.RequestMoneyV2Activity$b r1 = net.one97.paytm.upi.requestmoney.view.RequestMoneyV2Activity.b.VERIFY_VPA     // Catch:{ Exception -> 0x0066 }
            if (r2 != r1) goto L_0x0011
            int r1 = net.one97.paytm.upi.R.string.verifying     // Catch:{ Exception -> 0x0066 }
            java.lang.String r1 = r0.getString(r1)     // Catch:{ Exception -> 0x0066 }
            r0.a((android.content.Context) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x0066 }
        L_0x0011:
            net.one97.paytm.upi.requestmoney.view.RequestMoneyV2Activity$b r1 = net.one97.paytm.upi.requestmoney.view.RequestMoneyV2Activity.b.PROCESS_PAYMENT     // Catch:{ Exception -> 0x0066 }
            if (r2 != r1) goto L_0x0066
            int r1 = net.one97.paytm.upi.R.string.processing_your_payment     // Catch:{ Exception -> 0x0066 }
            java.lang.String r1 = r0.getString(r1)     // Catch:{ Exception -> 0x0066 }
            r0.a((android.content.Context) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x0066 }
            return
        L_0x001f:
            android.app.Dialog r1 = r0.k     // Catch:{ Exception -> 0x0066 }
            if (r1 != 0) goto L_0x0029
            android.app.Dialog r1 = net.one97.paytm.upi.util.UpiAppUtils.getWalletStyleProgressDialog(r0)     // Catch:{ Exception -> 0x0066 }
            r0.k = r1     // Catch:{ Exception -> 0x0066 }
        L_0x0029:
            android.app.Dialog r1 = r0.k     // Catch:{ Exception -> 0x0066 }
            if (r1 == 0) goto L_0x0066
            android.app.Dialog r1 = r0.k     // Catch:{ Exception -> 0x0066 }
            boolean r1 = r1.isShowing()     // Catch:{ Exception -> 0x0066 }
            if (r1 != 0) goto L_0x0066
            android.app.Dialog r1 = r0.k     // Catch:{ Exception -> 0x0066 }
            r1.show()     // Catch:{ Exception -> 0x0066 }
            return
        L_0x003b:
            android.app.ProgressDialog r1 = r0.f69218a     // Catch:{ Exception -> 0x0055 }
            if (r1 == 0) goto L_0x0055
            android.app.ProgressDialog r1 = r0.f69218a     // Catch:{ Exception -> 0x0055 }
            boolean r1 = r1.isShowing()     // Catch:{ Exception -> 0x0055 }
            if (r1 == 0) goto L_0x0055
            boolean r1 = r0.isFinishing()     // Catch:{ Exception -> 0x0055 }
            if (r1 != 0) goto L_0x0055
            android.app.ProgressDialog r1 = r0.f69218a     // Catch:{ Exception -> 0x0055 }
            r1.dismiss()     // Catch:{ Exception -> 0x0055 }
            r1 = 0
            r0.f69218a = r1     // Catch:{ Exception -> 0x0055 }
        L_0x0055:
            android.app.Dialog r1 = r0.k     // Catch:{ Exception -> 0x0066 }
            if (r1 == 0) goto L_0x0066
            android.app.Dialog r1 = r0.k     // Catch:{ Exception -> 0x0066 }
            boolean r1 = r1.isShowing()     // Catch:{ Exception -> 0x0066 }
            if (r1 == 0) goto L_0x0066
            android.app.Dialog r1 = r0.k     // Catch:{ Exception -> 0x0066 }
            r1.dismiss()     // Catch:{ Exception -> 0x0066 }
        L_0x0066:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.requestmoney.view.RequestMoneyV2Activity.a(boolean, net.one97.paytm.upi.requestmoney.view.RequestMoneyV2Activity$b):void");
    }

    public void a(Bundle bundle) {
        Intent intent = new Intent(this, RequestMoneyV2SelectBankActivity.class);
        intent.putExtra("key", bundle);
        ValidateVpaResponse validateVpaResponse = this.f69219b;
        if (validateVpaResponse != null) {
            intent.putExtra("code", validateVpaResponse.getCode());
            intent.putExtra("ifsc", this.f69219b.getIfsc());
            intent.putExtra("type", this.f69219b.getType());
            intent.putExtra("accountType", this.f69219b.getAccountType());
        }
        startActivityForResult(intent, f69217c);
    }

    public final void a(boolean z2, String str, ValidateVpaResponse validateVpaResponse) {
        this.f69219b = validateVpaResponse;
        if (z2) {
            this.f69224h.setVisibility(8);
            this.f69222f.setVisibility(0);
            this.f69223g.setVisibility(8);
            this.n.setError((CharSequence) null);
            if (!TextUtils.isEmpty(this.v) && !TextUtils.isEmpty(this.u)) {
                Bundle bundle = new Bundle();
                bundle.putString("payee_vpa", this.v);
                bundle.putString("payee_name", this.u);
                bundle.putString(UpiConstants.EXTRA_ACCOUNT_TYPE, "UPI");
                this.s.a(bundle);
                return;
            }
            return;
        }
        String string = this.t.getString(R.string.upi_unable_to_verify_vpa);
        if ("XH".equalsIgnoreCase(str) || "J02".equalsIgnoreCase(str) || "U17".equalsIgnoreCase(str)) {
            string = this.t.getString(R.string.upi_address_incorrect);
        }
        this.n.setError(string);
        this.f69224h.setVisibility(0);
        this.f69222f.setVisibility(8);
        this.f69223g.setVisibility(8);
        if ("1006".equalsIgnoreCase(str)) {
            Intent intent = new Intent(this.t, UpiRegistrationActivity.class);
            intent.putExtra("redirect", BaseResult.RESP_SYS_EXCEPTION);
            startActivity(intent);
        }
    }

    public final void a(String str) {
        this.u = str;
    }

    public final void g() {
        Intent intent = new Intent(this, UpiRegistrationActivity.class);
        intent.putExtra("redirect", 64);
        startActivityForResult(intent, 64);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.phonebook_iv) {
            c(true);
        } else if (id == R.id.search_cancel_tv) {
            c(false);
        } else if (id == R.id.txt_verify_vpa) {
            q();
        } else if (id == R.id.proceedbutton) {
            q();
        } else if (id == R.id.iv_back_button) {
            finish();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            c.a().b(this);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.s.f();
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 102) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                o();
                this.r.setVisibility(8);
            } else {
                e();
            }
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 64) {
            a(false, (b) null);
            if (i3 == -1) {
                this.s.e();
            } else {
                finish();
            }
        } else if (i2 == f69217c && i3 == -1) {
            finish();
        }
        super.onActivityResult(i2, i3, intent);
    }

    private void o() {
        CoordinatorLayout.d dVar = (CoordinatorLayout.d) this.f69220d.getLayoutParams();
        ((AppBarLayout.LayoutParams) findViewById(R.id.parent_layout).getLayoutParams()).f35849a = 0;
        dVar.a((CoordinatorLayout.Behavior) null);
        this.f69220d.setLayoutParams(dVar);
    }

    private void a(Context context, String str) {
        ProgressDialog progressDialog = this.f69218a;
        if (progressDialog == null || !progressDialog.isShowing()) {
            this.f69218a = new ProgressDialog(context);
            try {
                this.f69218a.setProgressStyle(0);
                this.f69218a.setMessage(str);
                this.f69218a.setCancelable(false);
                this.f69218a.setCanceledOnTouchOutside(false);
                this.f69218a.show();
            } catch (Exception | IllegalArgumentException unused) {
            }
        }
    }

    private boolean p() {
        if (TextUtils.isEmpty(this.o.getText().toString())) {
            this.n.setError(getString(R.string.upi_empty_vpa_error));
            return false;
        } else if (this.o.getText().toString().length() > 255) {
            this.n.setError(getString(R.string.upi_vpa_length_breach));
            return false;
        } else if (this.o.getText().toString().matches("[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+")) {
            return true;
        } else {
            this.n.setError(getString(R.string.upi_invalid_upi));
            return false;
        }
    }

    private void q() {
        this.v = this.o.getText().toString().trim();
        if (p()) {
            this.n.setError((CharSequence) null);
            UpiAppUtils.hideKeyboard(this);
            if (!UpiAppUtils.isNetworkAvailable(this.t)) {
                CustomDialog.showAlert(this.t, getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
            } else if (this.o.getText().toString().toLowerCase().contains(".com")) {
                final String clearExtension = UpiAppUtils.clearExtension(this.o.getText().toString());
                final CustomWalletAlertDialog customWalletAlertDialog = new CustomWalletAlertDialog(this);
                customWalletAlertDialog.setMessage(String.format(getString(R.string.money_transfer_did_you_mean_to_enter), new Object[]{clearExtension}));
                customWalletAlertDialog.setButton(-1, CommonPayParams.Builder.YES, new View.OnClickListener() {
                    public final void onClick(View view) {
                        customWalletAlertDialog.dismiss();
                        RequestMoneyV2Activity.this.o.setText(clearExtension);
                        RequestMoneyV2Activity.this.s.a(clearExtension, "xyz", b.VERIFY_VPA);
                    }
                });
                customWalletAlertDialog.setButton(-2, CommonPayParams.Builder.NO, new View.OnClickListener() {

                    /* renamed from: b  reason: collision with root package name */
                    final /* synthetic */ boolean f69233b = false;

                    public final void onClick(View view) {
                        customWalletAlertDialog.dismiss();
                        RequestMoneyV2Activity.this.s.a(RequestMoneyV2Activity.this.o.getText().toString(), "xyz", b.VERIFY_VPA);
                    }
                });
                customWalletAlertDialog.show();
            } else {
                this.s.a(this.o.getText().toString(), "xyz", b.VERIFY_VPA);
            }
        }
    }

    /* access modifiers changed from: private */
    public void d(boolean z2) {
        d dVar = this.x;
        if (dVar != null) {
            if (dVar.f69407b != null) {
                if (z2) {
                    dVar.f69407b.setVisibility(8);
                } else {
                    dVar.f69407b.setVisibility(0);
                }
            }
            if (z2) {
                if (this.j.getVisibility() == 8) {
                    this.j.setVisibility(0);
                }
            } else if (this.j.getVisibility() == 0) {
                this.l.setText("");
                this.j.setVisibility(8);
                r();
            }
        }
    }

    private void r() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null && getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        } catch (Exception unused) {
        }
    }

    public final void b(Bundle bundle) {
        if (bundle.getString(UpiConstants.EXTRA_ACCOUNT_TYPE).equalsIgnoreCase("UPI")) {
            this.u = bundle.getString("payee_name");
            this.v = bundle.getString("payee_vpa");
            this.s.a(bundle);
        }
    }

    public final void c(boolean z2) {
        this.f69220d.setExpanded(!z2, true);
        d(z2);
        if (z2) {
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    RequestMoneyV2Activity.this.l.requestFocus();
                    RequestMoneyV2Activity requestMoneyV2Activity = RequestMoneyV2Activity.this;
                    requestMoneyV2Activity.l.postDelayed(new Runnable(requestMoneyV2Activity.l) {
                        public final void run() {
                            try {
                                InputMethodManager inputMethodManager = (InputMethodManager) RequestMoneyV2Activity.this.getSystemService("input_method");
                                if (inputMethodManager != null) {
                                    inputMethodManager.showSoftInput(r4, 1);
                                    RequestMoneyV2Activity.this.getWindow().setSoftInputMode(20);
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }, 100);
                }
            }, 500);
        } else {
            r();
        }
    }

    public final void a(ArrayList<BeneficiaryEntity> arrayList) {
        this.w.addAll(arrayList);
        ArrayList<UpiBaseDataModel> arrayList2 = this.w;
        h hVar = this.y;
        if (hVar == null) {
            this.y = new h(this.t, arrayList2);
            this.o.setAdapter(this.y);
            this.o.setOnItemClickListener(this.B);
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator<UpiBaseDataModel> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            UpiBaseDataModel next = it2.next();
            if (next instanceof BeneficiaryEntity) {
                BeneficiaryEntity beneficiaryEntity = (BeneficiaryEntity) next;
                if (beneficiaryEntity.instrumentPreferences.otherBank != null && !TextUtils.isEmpty(beneficiaryEntity.instrumentPreferences.otherBank.accounts.get(0).accountDetail.accountNumber) && !hVar.f69460c.contains(beneficiaryEntity.instrumentPreferences.otherBank.accounts.get(0).accountDetail.accountNumber)) {
                    hVar.f69460c.add(beneficiaryEntity.instrumentPreferences.otherBank.accounts.get(0).accountDetail.accountNumber);
                    arrayList3.add(next);
                }
            }
        }
        hVar.f69458a.addAll(arrayList3);
        hVar.f69459b.addAll(arrayList3);
        hVar.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    public void b(UpiDBTransactionModel upiDBTransactionModel) {
        this.v = upiDBTransactionModel.getTxn_mode();
        this.u = upiDBTransactionModel.getBeneficiary_name();
        if (!TextUtils.isEmpty(this.v) && !TextUtils.isEmpty(this.u)) {
            this.o.setText(this.v);
            q();
        }
    }

    public final void k() {
        o();
    }

    public final void j() {
        this.p.setVisibility(8);
    }

    public final void l() {
        if (this.x != null) {
            this.A = true;
            this.f69223g.setVisibility(0);
            return;
        }
        this.A = false;
    }

    public final void m() {
        this.r.setVisibility(8);
        this.f69223g.setVisibility(8);
    }

    public final void n() {
        this.q.setVisibility(8);
    }

    public final void a(UpiDBTransactionModel upiDBTransactionModel) {
        b(upiDBTransactionModel);
    }

    public final void b(ArrayList<UpiDBTransactionModel> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.z = arrayList;
        }
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putString("title", c());
        ArrayList<UpiDBTransactionModel> arrayList2 = this.z;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            bundle.putParcelableArrayList("recent_txn", this.z);
        }
        bVar.setArguments(bundle);
        this.p.setVisibility(0);
        if (getSupportFragmentManager().c("beneficiary_fragment") == null) {
            getSupportFragmentManager().a().a(0, 0).b(R.id.recent_fragment_container, bVar, "beneficiary_fragment").c();
        }
    }

    public void onEvent(net.one97.paytm.upi.requestmoney.model.a aVar) {
        try {
            if (!TextUtils.isEmpty(aVar.f69167a) && UpiAppUtils.checkIsVpa(aVar.f69168b) && PaytmUpiPrefUtil.getPref(getApplicationContext()).b("is_upi_user", false, true)) {
                Bundle bundle = new Bundle();
                bundle.putString("payee_vpa", aVar.f69168b);
                bundle.putString("payee_name", aVar.f69167a);
                bundle.putString(UpiConstants.EXTRA_ACCOUNT_TYPE, "UPI");
                this.s.a(bundle);
            }
        } catch (Exception unused) {
        }
    }
}
