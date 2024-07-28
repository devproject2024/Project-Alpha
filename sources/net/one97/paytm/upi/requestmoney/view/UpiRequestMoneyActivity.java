package net.one97.paytm.upi.requestmoney.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.b;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.a;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.games.model.pfg.BaseResult;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.CustomAmountTextInputEditText;
import net.one97.paytm.upi.common.MoneyTransferRecentListAdapter;
import net.one97.paytm.upi.common.RoboTextView;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.CommonPayParams;
import net.one97.paytm.upi.common.upi.MoneyTransferContract;
import net.one97.paytm.upi.common.upi.UpiDBTransactionModel;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.k;
import net.one97.paytm.upi.profile.view.UpiQrCodeActivity;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.requestmoney.a.e;
import net.one97.paytm.upi.requestmoney.view.a.c;
import net.one97.paytm.upi.util.CustomWalletAlertDialog;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public class UpiRequestMoneyActivity extends PaytmActivity implements ExpandableListView.OnChildClickListener, ExpandableListView.OnGroupClickListener, e.b {
    /* access modifiers changed from: private */
    public TextInputLayout A;
    private ProgressBar B;
    private RelativeLayout C;
    private RelativeLayout D;
    private RelativeLayout E;
    /* access modifiers changed from: private */
    public ExpandableListView F;
    /* access modifiers changed from: private */
    public e.a G;
    private i H;
    private h I;
    private MoneyTransferRecentListAdapter J;
    /* access modifiers changed from: private */
    public List<UpiProfileDefaultBank> K;
    /* access modifiers changed from: private */
    public UpiProfileDefaultBank L;
    private View M;
    private int N;
    /* access modifiers changed from: private */
    public long O;
    /* access modifiers changed from: private */
    public Date P;
    private RecyclerView Q;
    /* access modifiers changed from: private */
    public a R;
    /* access modifiers changed from: private */
    public boolean S;
    private boolean T;
    /* access modifiers changed from: private */
    public boolean U;
    private c V = new c() {
        public final void a(Date date, String str) {
            UpiRequestMoneyActivity.this.s.setText(str);
            Date unused = UpiRequestMoneyActivity.this.P = date;
            long unused2 = UpiRequestMoneyActivity.this.O = UpiUtils.getMinutesfromDate(date);
            UpiRequestMoneyActivity.this.z.setHint(UpiRequestMoneyActivity.this.getString(R.string.upi_expire_on));
        }
    };
    private AdapterView.OnItemClickListener W = new AdapterView.OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            UpiDBTransactionModel upiDBTransactionModel = (UpiDBTransactionModel) ((h) adapterView.getAdapter()).getItem(i2);
            if (!TextUtils.isEmpty(upiDBTransactionModel.getTxn_mode())) {
                UpiRequestMoneyActivity.this.u.setText(upiDBTransactionModel.getTxn_mode());
            }
            if (!TextUtils.isEmpty(upiDBTransactionModel.getBeneficiary_name())) {
                UpiRequestMoneyActivity.this.x.setVisibility(0);
                UpiRequestMoneyActivity.this.r.setText(upiDBTransactionModel.getBeneficiary_name());
            }
            boolean unused = UpiRequestMoneyActivity.this.S = true;
            UpiRequestMoneyActivity.this.w.setError((CharSequence) null);
            UpiRequestMoneyActivity.this.m.setText("");
            UpiRequestMoneyActivity.this.m.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ifsc_verified_image, 0);
            new Handler().post(new Runnable() {
                public final void run() {
                    UpiRequestMoneyActivity.this.u.dismissDropDown();
                }
            });
            UpiRequestMoneyActivity.this.v.requestFocus();
            UpiRequestMoneyActivity upiRequestMoneyActivity = UpiRequestMoneyActivity.this;
            upiRequestMoneyActivity.a((EditText) upiRequestMoneyActivity.v);
        }
    };
    private View.OnClickListener X = new View.OnClickListener() {
        public final void onClick(View view) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) view;
            if (autoCompleteTextView.hasFocus() && TextUtils.isEmpty(autoCompleteTextView.getText().toString()) && autoCompleteTextView.getAdapter() != null && autoCompleteTextView.getAdapter().getCount() > 0) {
                autoCompleteTextView.showDropDown();
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    Date f69276a = new Date();

    /* renamed from: b  reason: collision with root package name */
    Calendar f69277b = Calendar.getInstance();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Context f69278c;

    /* renamed from: d  reason: collision with root package name */
    private Toolbar f69279d;

    /* renamed from: e  reason: collision with root package name */
    private NestedScrollView f69280e;

    /* renamed from: f  reason: collision with root package name */
    private String f69281f = "";

    /* renamed from: g  reason: collision with root package name */
    private ImageView f69282g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f69283h;

    /* renamed from: i  reason: collision with root package name */
    private RoboTextView f69284i;
    private RoboTextView j;
    private RoboTextView k;
    private TextView l;
    /* access modifiers changed from: private */
    public TextView m;
    /* access modifiers changed from: private */
    public TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    /* access modifiers changed from: private */
    public AppCompatEditText r;
    /* access modifiers changed from: private */
    public AppCompatEditText s;
    /* access modifiers changed from: private */
    public AppCompatEditText t;
    /* access modifiers changed from: private */
    public AutoCompleteTextView u;
    /* access modifiers changed from: private */
    public CustomAmountTextInputEditText v;
    /* access modifiers changed from: private */
    public TextInputLayout w;
    /* access modifiers changed from: private */
    public TextInputLayout x;
    /* access modifiers changed from: private */
    public TextInputLayout y;
    /* access modifiers changed from: private */
    public TextInputLayout z;

    public final /* bridge */ /* synthetic */ void a(Object obj) {
        this.G = (e.a) obj;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_upi_request_money);
        UpiUtils.setStatusBarColor(R.color.app_theme_color, this);
        this.f69278c = this;
        this.f69279d = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.f69279d);
        this.T = getIntent().getBooleanExtra(UpiConstants.EXTRA_SOURCE_DYNAMIC_QR, false);
        this.B = (ProgressBar) findViewById(R.id.pb_request_money);
        this.f69280e = (NestedScrollView) findViewById(R.id.main_scroll_view);
        this.f69282g = (ImageView) findViewById(R.id.iv_back_button);
        this.M = findViewById(R.id.lv_headerLayout);
        this.j = (RoboTextView) this.M.findViewById(R.id.tv_vpa_name);
        this.f69284i = (RoboTextView) this.M.findViewById(R.id.tv_bank_acc_no);
        this.k = (RoboTextView) findViewById(R.id.recent_title);
        this.Q = (RecyclerView) findViewById(R.id.vpa_beneficiary_list);
        this.Q.setLayoutManager(new LinearLayoutManager(this));
        this.Q.setNestedScrollingEnabled(false);
        this.f69283h = (ImageView) this.M.findViewById(R.id.drop_icon_iv);
        this.M.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (UpiRequestMoneyActivity.this.K != null && UpiRequestMoneyActivity.this.K.size() > 1) {
                    UpiRequestMoneyActivity upiRequestMoneyActivity = UpiRequestMoneyActivity.this;
                    upiRequestMoneyActivity.onGroupClick(upiRequestMoneyActivity.F, (View) null, 0, 0);
                }
            }
        });
        this.f69282g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                UpiRequestMoneyActivity.this.finish();
            }
        });
        this.C = (RelativeLayout) findViewById(R.id.rl_spinner);
        this.D = (RelativeLayout) findViewById(R.id.rlyExpireTime);
        this.E = (RelativeLayout) findViewById(R.id.rlyUpiVpa);
        this.F = (ExpandableListView) findViewById(R.id.lv_vpa_list);
        this.p = (TextView) findViewById(R.id.tv_toolbar_title);
        this.q = (TextView) findViewById(R.id.tv_header_text);
        this.m = (TextView) findViewById(R.id.tv_verify_vpa);
        this.n = (TextView) findViewById(R.id.tv_add_description);
        this.o = (TextView) findViewById(R.id.tv_change_expiry);
        this.m.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                UpiRequestMoneyActivity.this.c(false);
            }
        });
        this.n.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (UpiRequestMoneyActivity.this.A.getVisibility() == 8) {
                    UpiRequestMoneyActivity.this.A.setVisibility(0);
                    UpiRequestMoneyActivity.this.n.setVisibility(8);
                    UpiRequestMoneyActivity.this.t.requestFocus();
                }
            }
        });
        this.l = (TextView) findViewById(R.id.tv_proceed);
        this.l.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                UpiRequestMoneyActivity.g(UpiRequestMoneyActivity.this);
            }
        });
        this.u = (AutoCompleteTextView) findViewById(R.id.tiet_vpa);
        this.u.setThreshold(0);
        this.u.setOnClickListener(this.X);
        this.u.setOnFocusChangeListener((View.OnFocusChangeListener) null);
        this.r = (AppCompatEditText) findViewById(R.id.tiet_registered_name);
        this.v = (CustomAmountTextInputEditText) findViewById(R.id.tiet_amount);
        this.s = (AppCompatEditText) findViewById(R.id.tiet_expire_after);
        this.t = (AppCompatEditText) findViewById(R.id.tiet_optional_description);
        this.w = (TextInputLayout) findViewById(R.id.til_vpa);
        this.x = (TextInputLayout) findViewById(R.id.til_registered_name);
        this.y = (TextInputLayout) findViewById(R.id.til_amount);
        this.z = (TextInputLayout) findViewById(R.id.til_expire_after);
        this.A = (TextInputLayout) findViewById(R.id.til_optional_desc);
        int collectRequestExpiryTime = UpiGTMLoader.getInstance().getCollectRequestExpiryTime();
        this.O = (long) collectRequestExpiryTime;
        AppCompatEditText appCompatEditText = this.s;
        appCompatEditText.setText(collectRequestExpiryTime + " " + getString(R.string.upi_minutes_label));
        this.o.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                UpiRequestMoneyActivity.h(UpiRequestMoneyActivity.this);
            }
        });
        this.u.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                UpiRequestMoneyActivity.this.w.setError((CharSequence) null);
                UpiRequestMoneyActivity.this.m.setText(UpiRequestMoneyActivity.this.getString(R.string.verify_vpa));
                UpiRequestMoneyActivity.this.m.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                UpiRequestMoneyActivity.this.m.setTextColor(b.c(UpiRequestMoneyActivity.this.f69278c, R.color.color_00b9f5));
                boolean unused = UpiRequestMoneyActivity.this.S = false;
            }
        });
        this.v.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                UpiRequestMoneyActivity.this.y.setError((CharSequence) null);
            }
        });
        this.s.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                UpiRequestMoneyActivity.this.z.setError((CharSequence) null);
            }
        });
        if (this.T) {
            this.k.setVisibility(8);
            this.Q.setVisibility(8);
            this.q.setVisibility(8);
            this.D.setVisibility(8);
            this.E.setVisibility(8);
            this.p.setText(getString(R.string.upi_request_money_qr_code));
            this.l.setText(R.string.upi_generate_qr_code);
        }
        setTitle("");
        this.G = new net.one97.paytm.upi.requestmoney.presenter.e(g.c(), this);
        this.G.e();
    }

    /* access modifiers changed from: private */
    public void c(final boolean z2) {
        if (UpiAppUtils.isNetworkAvailable(this.f69278c)) {
            this.w.setError((CharSequence) null);
            UpiAppUtils.hideKeyboard(this);
            if (!c()) {
                return;
            }
            if (this.u.getText().toString().toLowerCase().contains(".com")) {
                final String clearExtension = UpiAppUtils.clearExtension(this.u.getText().toString());
                final CustomWalletAlertDialog customWalletAlertDialog = new CustomWalletAlertDialog(this);
                customWalletAlertDialog.setMessage(String.format(getString(R.string.money_transfer_did_you_mean_to_enter), new Object[]{clearExtension}));
                customWalletAlertDialog.setButton(-1, CommonPayParams.Builder.YES, new View.OnClickListener() {
                    public final void onClick(View view) {
                        customWalletAlertDialog.dismiss();
                        UpiRequestMoneyActivity.this.u.setText(clearExtension);
                        UpiRequestMoneyActivity.this.G.a(clearExtension, "xyz", z2);
                    }
                });
                customWalletAlertDialog.setButton(-2, CommonPayParams.Builder.NO, new View.OnClickListener() {
                    public final void onClick(View view) {
                        customWalletAlertDialog.dismiss();
                        UpiRequestMoneyActivity.this.G.a(UpiRequestMoneyActivity.this.u.getText().toString(), "xyz", z2);
                    }
                });
                customWalletAlertDialog.show();
                return;
            }
            this.G.a(this.u.getText().toString(), "xyz", z2);
        }
    }

    private boolean c() {
        String obj = this.u.getText().toString();
        if (!this.U && !TextUtils.isEmpty(obj) && !obj.contains("@")) {
            if (obj.toLowerCase().endsWith("paytm")) {
                c("paytm");
                return false;
            } else if (obj.toLowerCase().endsWith("ybl")) {
                c("ybl");
                return false;
            } else if (obj.toLowerCase().endsWith("okaxis")) {
                c("okaxis");
                return false;
            } else if (obj.toLowerCase().endsWith("upi")) {
                c("upi");
                return false;
            }
        }
        if (TextUtils.isEmpty(this.u.getText().toString())) {
            this.w.setError(getString(R.string.upi_empty_vpa_error));
            return false;
        } else if (this.u.getText().toString().length() > 255) {
            this.w.setError(getString(R.string.upi_vpa_length_breach));
            return false;
        } else if (this.u.getText().toString().matches("[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+")) {
            return true;
        } else {
            this.w.setError(getString(R.string.upi_invalid_upi));
            return false;
        }
    }

    private boolean d() {
        if (!this.T && !c()) {
            return false;
        }
        if (TextUtils.isEmpty(UpiAppUtils.getCleanString(this.v.getText().toString()))) {
            this.y.setError(getString(R.string.wallet_p2b_amount_error_part_1, new Object[]{UpiAppUtils.formatNumber(UpiUtils.getMinAmountAllowed(this)) + getString(R.string.wallet_p2b_amount_error_part_2) + UpiAppUtils.formatNumber(UpiUtils.getMaxAmountAllowed(this))}));
            return false;
        } else if (!UpiUtils.isAmountValid(UpiAppUtils.getCleanString(this.v.getText().toString()))) {
            this.y.setError(getString(R.string.upi_err_msg_valid_upi_amount));
            return false;
        } else {
            try {
                double parseDouble = Double.parseDouble(UpiAppUtils.getCleanString(this.v.getText().toString()));
                if (Double.compare(parseDouble, UpiUtils.getMaxAmountAllowed(this)) > 0) {
                    this.y.setError(getString(R.string.wallet_p2b_amount_error_part_1, new Object[]{UpiAppUtils.formatNumber(UpiUtils.getMinAmountAllowed(this)) + getString(R.string.wallet_p2b_amount_error_part_2) + UpiAppUtils.formatNumber(UpiUtils.getMaxAmountAllowed(this))}));
                    return false;
                } else if (Double.compare(parseDouble, UpiUtils.getMinAmountAllowed(this)) < 0) {
                    this.y.setError(getString(R.string.wallet_p2b_amount_error_part_1, new Object[]{UpiAppUtils.formatNumber(UpiUtils.getMinAmountAllowed(this)) + getString(R.string.wallet_p2b_amount_error_part_2) + UpiAppUtils.formatNumber(UpiUtils.getMaxAmountAllowed(this))}));
                    return false;
                } else if (this.L == null) {
                    b(getString(R.string.please_add_a_bank_account));
                    return false;
                } else if (TextUtils.isEmpty(this.u.getText().toString()) || !e()) {
                    return true;
                } else {
                    b(String.format(getString(R.string.upi_same_vpa_request_money_error), new Object[]{this.L.getCreditBank().getAccount(), this.u.getText().toString()}));
                    return false;
                }
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                this.y.setError(getString(R.string.upi_err_msg_valid_upi_amount));
                return false;
            }
        }
    }

    private boolean e() {
        if (this.K == null) {
            return false;
        }
        String obj = this.u.getText().toString();
        for (UpiProfileDefaultBank next : this.K) {
            if (next.getVirtualAddress().equalsIgnoreCase(obj) && next.getDebitBank() != null && next.getDebitBank().getAccount().equalsIgnoreCase(this.L.getCreditBank().getAccount())) {
                return true;
            }
        }
        return false;
    }

    private void b(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(str);
        builder.setNegativeButton(17039370, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.cancel();
            }
        });
        builder.show();
    }

    private void c(String str) {
        String obj = this.u.getText().toString();
        final String str2 = obj.substring(0, obj.toString().indexOf(str)) + "@" + str;
        final CustomWalletAlertDialog customWalletAlertDialog = new CustomWalletAlertDialog(this);
        customWalletAlertDialog.setTitle(getString(R.string.did_you_mean_to_enter_quick, new Object[]{""}).replace("\"", ""));
        customWalletAlertDialog.setMessage(str2);
        customWalletAlertDialog.setMessageFontStyle(1);
        customWalletAlertDialog.setMessageFontSize(21);
        customWalletAlertDialog.setTitleFontSize(15);
        customWalletAlertDialog.setButton(-1, CommonPayParams.Builder.YES, new View.OnClickListener() {
            public final void onClick(View view) {
                customWalletAlertDialog.dismiss();
                UpiRequestMoneyActivity.this.u.setText(str2);
                UpiRequestMoneyActivity.this.G.a(str2, "xyz", false);
            }
        });
        customWalletAlertDialog.setButton(-2, CommonPayParams.Builder.NO, new View.OnClickListener() {
            public final void onClick(View view) {
                customWalletAlertDialog.dismiss();
                boolean unused = UpiRequestMoneyActivity.this.U = true;
            }
        });
        customWalletAlertDialog.show();
    }

    public final void a(boolean z2) {
        if (z2) {
            this.B.setVisibility(0);
        } else {
            this.B.setVisibility(8);
        }
    }

    public final void a(boolean z2, String str) {
        this.S = z2;
        if (this.S) {
            this.w.setError((CharSequence) null);
            this.m.setText("");
            this.m.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ifsc_verified_image, 0);
            this.f69280e.a(33);
            this.v.requestFocus();
            a((EditText) this.v);
            return;
        }
        String string = this.f69278c.getString(R.string.upi_unable_to_verify_vpa);
        if ("XH".equalsIgnoreCase(str) || "J02".equalsIgnoreCase(str) || "U17".equalsIgnoreCase(str)) {
            string = this.f69278c.getString(R.string.upi_address_incorrect);
        }
        this.w.setError(string);
        this.m.setText(getString(R.string.verify_vpa));
        this.m.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        this.m.setTextColor(b.c(this.f69278c, R.color.color_00b9f5));
        if ("1006".equalsIgnoreCase(str)) {
            Intent intent = new Intent(this.f69278c, UpiRegistrationActivity.class);
            intent.putExtra("redirect", BaseResult.RESP_SYS_EXCEPTION);
            startActivity(intent);
        }
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.x.setVisibility(8);
            return;
        }
        this.x.setVisibility(0);
        this.r.setText(str);
    }

    public final void b(boolean z2) {
        a aVar = this.R;
        if (aVar != null) {
            aVar.dismiss();
        }
        if (!z2) {
            Toast.makeText(this.f69278c, getString(R.string.upi_some_went_wrong), 0).show();
        }
        finish();
    }

    public final void b() {
        Intent intent = new Intent(this, UpiRegistrationActivity.class);
        intent.putExtra("redirect", 64);
        startActivityForResult(intent, 64);
        finish();
    }

    public final void a(boolean z2, String str, String str2, String str3, String str4, String str5) {
        if ("1006".equalsIgnoreCase(str)) {
            Intent intent = new Intent(this, UpiRegistrationActivity.class);
            intent.putExtra("redirect", BaseResult.RESP_SYS_EXCEPTION);
            startActivity(intent);
        } else {
            Intent intent2 = new Intent(this.f69278c, UpiRequestMoneyStatusActivity.class);
            intent2.putExtra(UpiConstants.EXTRA_IS_SUCCESS, z2);
            intent2.putExtra(UpiConstants.EXTRA_RESPONSE_CODE, str);
            intent2.putExtra("message", str2);
            intent2.putExtra(UpiConstants.EXTRA_RRN, str3);
            intent2.putExtra(UpiConstants.EXTRA_UPI_TRAN_LOG_ID, str4);
            intent2.putExtra("seq_no", str5);
            intent2.putExtra(UpiConstants.EXTRA_PAYER_VPA, this.u.getText().toString());
            intent2.putExtra(UpiConstants.EXTRA_PAYER_NAME, this.r.getText().toString());
            intent2.putExtra("amount", UpiAppUtils.getCleanString(this.v.getText().toString()));
            intent2.putExtra(UpiConstants.EXTRA_OPTIONAL_DESC, this.t.getText().toString());
            intent2.putExtra(UpiConstants.EXTRA_EXPIRY_TIME, this.s.getText().toString());
            intent2.putExtra(UpiConstants.EXTRA_EXPIRY_TIME_HINT, this.z.getHint().toString());
            startActivity(intent2);
        }
        finish();
    }

    public final void a(List<UpiProfileDefaultBank> list) {
        this.K = list;
        if (this.K.size() > 0) {
            this.F.setVisibility(0);
            i iVar = this.H;
            if (iVar != null) {
                iVar.f69468a = this.K;
                this.F.collapseGroup(0);
                this.H.notifyDataSetChanged();
                this.F.invalidateViews();
            } else {
                this.H = new i(this.f69278c, this.K);
                this.F.setAdapter(this.H);
            }
            this.F.setOnChildClickListener(this);
            a(this.F);
            this.F.setOnGroupClickListener(this);
            this.L = this.K.get(0);
            this.M.setVisibility(0);
            a(this.L);
        } else {
            this.F.setVisibility(8);
            this.M.setVisibility(8);
        }
        if (this.K.size() > 1) {
            this.f69283h.setVisibility(0);
        } else {
            this.f69283h.setVisibility(8);
        }
    }

    public final void b(List<UpiProfileDefaultBank> list) {
        this.K = list;
        this.K.clear();
        i iVar = this.H;
        if (iVar != null) {
            iVar.f69468a = this.K;
            iVar.notifyDataSetChanged();
        }
    }

    public final void a(UpiCustomVolleyError upiCustomVolleyError) {
        if (upiCustomVolleyError != null && UpiUtils.AUTHENTICATION_FAILURE_401.equalsIgnoreCase(upiCustomVolleyError.getMessage())) {
            k kVar = i.a().k;
            UpiRequestMoneyActivity.class.getName();
            kVar.e(this);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i3 == -1 && i2 == 64) {
            this.G.e();
        }
        if (i3 == -1 && i2 == 96) {
            this.G.e();
        }
        super.onActivityResult(i2, i3, intent);
    }

    public boolean onChildClick(ExpandableListView expandableListView, View view, int i2, int i3, long j2) {
        this.L = this.K.get(i3);
        this.H.f69469b = i3;
        this.F.collapseGroup(0);
        this.H.notifyDataSetChanged();
        this.F.invalidateViews();
        a(this.F);
        this.M.setVisibility(0);
        a(this.L);
        return false;
    }

    private void a(UpiProfileDefaultBank upiProfileDefaultBank) {
        if (upiProfileDefaultBank != null) {
            BankAccountDetails.BankAccount creditBank = upiProfileDefaultBank.getCreditBank();
            this.f69284i.setTextColor(b.c(this.f69278c, R.color.color_222222));
            this.j.setTextColor(b.c(this.f69278c, R.color.color_222222));
            if (!TextUtils.isEmpty(creditBank.getAccount()) && !TextUtils.isEmpty(creditBank.getBankName())) {
                RoboTextView roboTextView = this.f69284i;
                roboTextView.setText(creditBank.getBankName() + " " + getString(R.string.upi_acc_no_prefix) + " " + UpiUtils.maskNumber(creditBank.getAccount()));
            }
            if (!TextUtils.isEmpty(upiProfileDefaultBank.getVirtualAddress())) {
                this.j.setText(upiProfileDefaultBank.getVirtualAddress());
                this.j.setFontType(4);
            }
        }
    }

    private static void a(ExpandableListView expandableListView) {
        ExpandableListAdapter expandableListAdapter = expandableListView.getExpandableListAdapter();
        int i2 = 0;
        for (int i3 = 0; i3 < expandableListAdapter.getGroupCount(); i3++) {
            View groupView = expandableListAdapter.getGroupView(i3, true, (View) null, expandableListView);
            groupView.measure(0, 0);
            i2 += groupView.getMeasuredHeight();
            if (expandableListView.isGroupExpanded(i3)) {
                int i4 = i2;
                for (int i5 = 0; i5 < expandableListAdapter.getChildrenCount(i3); i5++) {
                    View childView = expandableListAdapter.getChildView(i3, i5, false, (View) null, expandableListView);
                    childView.measure(0, 0);
                    i4 += childView.getMeasuredHeight();
                }
                i2 = i4;
            }
        }
        ViewGroup.LayoutParams layoutParams = expandableListView.getLayoutParams();
        layoutParams.height = i2 + (expandableListView.getDividerHeight() * (expandableListAdapter.getGroupCount() - 1));
        expandableListView.setLayoutParams(layoutParams);
        expandableListView.requestLayout();
    }

    public void onDestroy() {
        super.onDestroy();
        this.G.f();
    }

    public final void a(ArrayList<UpiBaseDataModel> arrayList) {
        if (!this.T && arrayList.size() > 0) {
            this.k.setVisibility(0);
            this.J = new MoneyTransferRecentListAdapter(this, MoneyTransferRecentListAdapter.REQUEST_MONEY_PRESENTER, (MoneyTransferContract.Presenter) null, this.G);
            this.Q.setAdapter(this.J);
            this.I = new h(this.f69278c, arrayList);
            this.u.setAdapter(this.I);
            this.u.setOnItemClickListener(this.W);
        }
    }

    /* access modifiers changed from: private */
    public void a(final EditText editText) {
        editText.postDelayed(new Runnable() {
            public final void run() {
                try {
                    ((InputMethodManager) UpiRequestMoneyActivity.this.getSystemService("input_method")).showSoftInput(editText, 1);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }, 100);
    }

    public final void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.u.setText(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.x.setVisibility(0);
            this.r.setText(str2);
        }
        this.S = true;
        this.w.setError((CharSequence) null);
        this.m.setText("");
        this.m.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ifsc_verified_image, 0);
        this.f69280e.a(33);
        this.v.requestFocus();
        a((EditText) this.v);
    }

    public final void a() {
        View inflate = LayoutInflater.from(this.f69278c).inflate(R.layout.dialog_upi_request_money, (ViewGroup) null);
        UpiAppUtils.updateAmount(String.format(this.f69278c.getString(R.string.rs_str), new Object[]{UpiAppUtils.priceToString(UpiAppUtils.getCleanString(this.v.getText().toString()))}), (TextView) inflate.findViewById(R.id.tv_amount));
        ((TextView) inflate.findViewById(R.id.tv_payer_name)).setText(this.r.getText().toString());
        ((TextView) inflate.findViewById(R.id.tv_payer_vpa)).setText(String.format(getResources().getString(R.string.upi_collect_request_vpa), new Object[]{this.u.getText().toString()}));
        this.R = new a(this.f69278c);
        this.R.setContentView(inflate);
        final BottomSheetBehavior from = BottomSheetBehavior.from((View) inflate.getParent());
        from.setState(3);
        this.R.show();
        this.R.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                from.setState(4);
            }
        });
        TextView textView = (TextView) inflate.findViewById(R.id.tv_pay);
        textView.setText(getString(R.string.confirm));
        textView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                UpiRequestMoneyActivity.this.R.dismiss();
                String obj = UpiRequestMoneyActivity.this.t.getText().toString();
                if (TextUtils.isEmpty(obj)) {
                    obj = "NA";
                }
                UpiRequestMoneyActivity.this.G.a(UpiRequestMoneyActivity.this.L, UpiRequestMoneyActivity.this.u.getText().toString(), UpiUtils.convertToTwoPlaces(UpiAppUtils.getCleanString(UpiRequestMoneyActivity.this.v.getText().toString())), String.valueOf(UpiRequestMoneyActivity.this.O), obj, UpiRequestMoneyActivity.this.r.getText().toString());
            }
        });
        ((ImageView) inflate.findViewById(R.id.iv_cancel)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                UpiRequestMoneyActivity.this.R.dismiss();
            }
        });
    }

    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i2, long j2) {
        ExpandableListAdapter expandableListAdapter = expandableListView.getExpandableListAdapter();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(expandableListView.getWidth(), 1073741824);
        int i3 = 0;
        for (int i4 = 0; i4 < expandableListAdapter.getGroupCount(); i4++) {
            View groupView = expandableListAdapter.getGroupView(i4, false, (View) null, expandableListView);
            groupView.measure(makeMeasureSpec, 0);
            i3 += groupView.getMeasuredHeight();
            if ((expandableListView.isGroupExpanded(i4) && i4 != i2) || (!expandableListView.isGroupExpanded(i4) && i4 == i2)) {
                int i5 = i3;
                for (int i6 = 0; i6 < expandableListAdapter.getChildrenCount(i4); i6++) {
                    View childView = expandableListAdapter.getChildView(i4, i6, false, (View) null, expandableListView);
                    childView.measure(makeMeasureSpec, 0);
                    i5 += childView.getMeasuredHeight();
                }
                i3 = i5;
            }
        }
        ViewGroup.LayoutParams layoutParams = expandableListView.getLayoutParams();
        int dividerHeight = i3 + (expandableListView.getDividerHeight() * (expandableListAdapter.getGroupCount() - 1));
        if (dividerHeight < 10) {
            dividerHeight = 200;
        }
        layoutParams.height = dividerHeight;
        expandableListView.setLayoutParams(layoutParams);
        expandableListView.requestLayout();
        this.M.setVisibility(8);
        expandableListView.expandGroup(0);
        return false;
    }

    static /* synthetic */ void g(UpiRequestMoneyActivity upiRequestMoneyActivity) {
        if (!upiRequestMoneyActivity.d()) {
            return;
        }
        if (!upiRequestMoneyActivity.T && !upiRequestMoneyActivity.S) {
            upiRequestMoneyActivity.c(true);
        } else if (upiRequestMoneyActivity.T) {
            UpiQrCodeActivity.a((Context) upiRequestMoneyActivity, UpiAppUtils.getCleanString(upiRequestMoneyActivity.v.getText().toString()), upiRequestMoneyActivity.L.getVirtualAddress(), upiRequestMoneyActivity.t.getText().toString());
            upiRequestMoneyActivity.finish();
        } else {
            upiRequestMoneyActivity.G.a();
        }
    }

    static /* synthetic */ void h(UpiRequestMoneyActivity upiRequestMoneyActivity) {
        if (upiRequestMoneyActivity.V != null) {
            if (upiRequestMoneyActivity.P == null) {
                upiRequestMoneyActivity.f69277b.setTime(upiRequestMoneyActivity.f69276a);
                upiRequestMoneyActivity.f69277b.add(12, UpiGTMLoader.getInstance().getCollectRequestExpiryTime());
                upiRequestMoneyActivity.P = upiRequestMoneyActivity.f69277b.getTime();
            }
            c cVar = upiRequestMoneyActivity.V;
            Date date = upiRequestMoneyActivity.P;
            Date date2 = new Date();
            upiRequestMoneyActivity.f69277b.setTime(upiRequestMoneyActivity.f69276a);
            upiRequestMoneyActivity.f69277b.add(5, 45);
            net.one97.paytm.upi.requestmoney.view.a.b.a(cVar, date, date2, upiRequestMoneyActivity.f69277b.getTime(), upiRequestMoneyActivity.N).show(upiRequestMoneyActivity.getSupportFragmentManager(), "tagSlideDateTimeDialogFragment");
            return;
        }
        throw new NullPointerException("Attempting to bind null listener to SlideDateTimePicker");
    }
}
