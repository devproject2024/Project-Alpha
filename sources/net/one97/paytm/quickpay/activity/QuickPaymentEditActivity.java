package net.one97.paytm.quickpay.activity;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.f;
import com.paytm.android.chat.utils.KeyList;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b.b;
import com.paytm.utility.b.b.c;
import com.paytm.utility.h;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.common.entity.beneficiaryModels.CJRKYCBeneficiaryBase;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.common.entity.quick_pay.Payload;
import net.one97.paytm.common.entity.quick_pay.QuickListResponse;
import net.one97.paytm.common.entity.quick_pay.QuickPayAddResponse;
import net.one97.paytm.common.entity.quick_pay.StandingInstructionList;
import net.one97.paytm.common.entity.quick_pay.SupportingData;
import net.one97.paytm.common.entity.wallet.CJRBankDetails;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.quickpay.a.e;
import net.one97.paytm.quickpay.activity.QuickPaymentActivity;
import net.one97.paytm.quickpay.widget.datetimepicker.b.b;
import net.one97.paytm.quickpay.widget.datetimepicker.view.DateTimeView;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.CommonPayParams;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.requestmoney.b.a.a;
import net.one97.paytm.utils.r;
import org.json.JSONException;
import org.json.JSONObject;

public class QuickPaymentEditActivity extends QuickPaymentActivity implements View.OnClickListener, b {
    /* access modifiers changed from: private */
    public TextView A;
    /* access modifiers changed from: private */
    public TextView B;
    /* access modifiers changed from: private */
    public TextView C;
    private String D = "";
    private ProgressBar E;
    /* access modifiers changed from: private */
    public String F;
    /* access modifiers changed from: private */
    public boolean G = true;
    /* access modifiers changed from: private */
    public boolean H;
    private boolean I;
    private RelativeLayout J;
    private SupportingData K;
    private final int L = 201;
    /* access modifiers changed from: private */
    public RelativeLayout M;
    /* access modifiers changed from: private */
    public RelativeLayout N;
    /* access modifiers changed from: private */
    public AutoCompleteTextView O;
    /* access modifiers changed from: private */
    public e P;
    /* access modifiers changed from: private */
    public ArrayList<IJRPaytmDataModel> Q = new ArrayList<>();
    /* access modifiers changed from: private */
    public LinearLayout R;
    private TextView S;
    private TextView T;
    private TextView U;
    /* access modifiers changed from: private */
    public a V;
    private LinearLayout W;
    private final int X = 202;
    private final char Y = ' ';
    private TextWatcher Z = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            QuickPaymentEditActivity.this.f60006d.setError((CharSequence) null);
            QuickPaymentEditActivity.this.f60007e.setError((CharSequence) null);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    boolean f60004a;
    private TextWatcher aa = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            QuickPaymentEditActivity.e(QuickPaymentEditActivity.this);
        }

        public final void afterTextChanged(Editable editable) {
            String obj = editable.toString();
            QuickPaymentEditActivity.this.y.setVisibility(8);
            if (QuickPaymentEditActivity.this.f60004a) {
                QuickPaymentEditActivity.this.f60004a = false;
            }
            if (TextUtils.isEmpty(obj)) {
                QuickPaymentEditActivity.this.A.setText(R.string.find_ifsc);
            } else if (TextUtils.isEmpty(obj) || obj.length() != 11) {
                QuickPaymentEditActivity.this.A.setText(QuickPaymentEditActivity.this.getString(R.string.verify));
            } else {
                QuickPaymentEditActivity.this.a(obj);
            }
        }
    };
    private RadioGroup.OnCheckedChangeListener ab = new RadioGroup.OnCheckedChangeListener() {
        public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
            QuickPaymentEditActivity.this.R.setVisibility(8);
            if (i2 == R.id.qp_paytm_rb) {
                if (QuickPaymentEditActivity.this.V == null || QuickPaymentEditActivity.this.V.getType() != a.WALLET.type) {
                    QuickPaymentEditActivity.a(QuickPaymentEditActivity.this, true, true);
                    QuickPaymentEditActivity.this.R.setVisibility(8);
                    return;
                }
                QuickPaymentEditActivity.this.R.setVisibility(0);
                QuickPaymentEditActivity.a(QuickPaymentEditActivity.this, true, false);
            } else if ((QuickPaymentEditActivity.this.V == null || QuickPaymentEditActivity.this.V.getType() != a.UPI.type) && ((QuickPaymentEditActivity.this.V == null || QuickPaymentEditActivity.this.V.getType() != a.BANK.type) && (QuickPaymentEditActivity.this.V == null || QuickPaymentEditActivity.this.V.getType() != a.BANKWITHIFSCVERIFIED.type))) {
                QuickPaymentEditActivity.a(QuickPaymentEditActivity.this, false, true);
                QuickPaymentEditActivity.this.R.setVisibility(8);
            } else {
                QuickPaymentEditActivity.this.R.setVisibility(0);
                QuickPaymentEditActivity.a(QuickPaymentEditActivity.this, false, false);
            }
        }
    };
    private TextWatcher ac = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            QuickPaymentEditActivity.e(QuickPaymentEditActivity.this);
            if (QuickPaymentEditActivity.this.f60005c) {
                QuickPaymentEditActivity quickPaymentEditActivity = QuickPaymentEditActivity.this;
                quickPaymentEditActivity.f60005c = false;
                quickPaymentEditActivity.x.setVisibility(8);
            }
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            if (com.paytm.utility.b.X(charSequence.toString())) {
                boolean unused = QuickPaymentEditActivity.this.H = true;
                QuickPaymentEditActivity.c(QuickPaymentEditActivity.this, true);
                return;
            }
            boolean unused2 = QuickPaymentEditActivity.this.H = false;
            QuickPaymentEditActivity.c(QuickPaymentEditActivity.this, false);
        }
    };
    private TextView.OnEditorActionListener ad = new TextView.OnEditorActionListener() {
        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            if (i2 != 6) {
                return true;
            }
            if (QuickPaymentEditActivity.this.H) {
                String obj = QuickPaymentEditActivity.this.O.getText().toString();
                if (TextUtils.isEmpty(obj)) {
                    return true;
                }
                QuickPaymentEditActivity.this.a(obj, false);
                return true;
            }
            com.paytm.utility.b.c((Activity) QuickPaymentEditActivity.this);
            return true;
        }
    };
    /* access modifiers changed from: private */
    public AdapterView.OnItemClickListener ae = new AdapterView.OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            IJRPaytmDataModel a2 = ((e) adapterView.getAdapter()).getItem(i2);
            if (a2 instanceof BeneficiaryEntity) {
                BeneficiaryEntity beneficiaryEntity = (BeneficiaryEntity) a2;
                if (beneficiaryEntity.instrumentPreferences.otherBank != null) {
                    BeneficiaryEntity.OtherBankAccountDetail otherBankAccountDetail = beneficiaryEntity.instrumentPreferences.otherBank.accounts.get(0).accountDetail;
                    String unused = QuickPaymentEditActivity.this.F = otherBankAccountDetail.bankName;
                    QuickPaymentEditActivity.this.f60010h.setVisibility(8);
                    QuickPaymentEditActivity.this.M.setVisibility(0);
                    boolean unused2 = QuickPaymentEditActivity.this.G = true;
                    QuickPaymentEditActivity.this.C.setText(QuickPaymentEditActivity.this.F);
                    QuickPaymentEditActivity.this.B.setText(otherBankAccountDetail.ifscCode);
                    QuickPaymentEditActivity.this.O.setText(otherBankAccountDetail.accountNumber);
                    QuickPaymentEditActivity.this.l.setText(otherBankAccountDetail.ifscCode);
                    QuickPaymentEditActivity.this.m.setText(otherBankAccountDetail.accountHolderName);
                    QuickPaymentEditActivity.this.b(true);
                    QuickPaymentEditActivity.this.O.setSelection(QuickPaymentEditActivity.this.O.getText().length());
                } else if (beneficiaryEntity.instrumentPreferences.upi != null) {
                    BeneficiaryEntity.UPIAccountDetail uPIAccountDetail = beneficiaryEntity.instrumentPreferences.upi.accounts.get(0).accountDetail;
                    QuickPaymentEditActivity.this.f60010h.setVisibility(8);
                    QuickPaymentEditActivity.this.O.setText(uPIAccountDetail.vpa);
                    QuickPaymentEditActivity.this.l.setText((CharSequence) null);
                    QuickPaymentEditActivity.this.m.setText(uPIAccountDetail.accountHolderName);
                    boolean unused3 = QuickPaymentEditActivity.this.H = true;
                    QuickPaymentEditActivity quickPaymentEditActivity = QuickPaymentEditActivity.this;
                    quickPaymentEditActivity.f60005c = true;
                    quickPaymentEditActivity.x.setVisibility(0);
                    QuickPaymentEditActivity.this.z.setVisibility(8);
                    QuickPaymentEditActivity.this.O.setSelection(QuickPaymentEditActivity.this.O.getText().length());
                }
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    boolean f60005c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public TextInputLayout f60006d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public TextInputLayout f60007e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public TextInputLayout f60008f;

    /* renamed from: g  reason: collision with root package name */
    private TextInputLayout f60009g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public TextInputLayout f60010h;

    /* renamed from: i  reason: collision with root package name */
    private AppCompatEditText f60011i;
    private AppCompatEditText j;
    private AppCompatEditText k;
    /* access modifiers changed from: private */
    public AppCompatEditText l;
    /* access modifiers changed from: private */
    public AppCompatEditText m;
    private AppCompatEditText n;
    private int o;
    private String p;
    /* access modifiers changed from: private */
    public StandingInstructionList q;
    private final int r = KeyList.IntentRequestKey.INTENT_REQUEST_CHOOSE_MEDIA;
    private RadioButton s;
    private RadioButton t;
    private RelativeLayout u;
    private LinearLayout v;
    private ImageView w;
    /* access modifiers changed from: private */
    public ImageView x;
    /* access modifiers changed from: private */
    public ImageView y;
    /* access modifiers changed from: private */
    public TextView z;

    public enum a {
        WALLET(0),
        BANK(1),
        BANKWITHIFSCVERIFIED(2),
        UPI(3);
        
        /* access modifiers changed from: private */
        public int type;

        private a(int i2) {
            this.type = i2;
        }

        public final int getType() {
            return this.type;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_edit_quick_payment);
        if (getSupportActionBar() != null) {
            getSupportActionBar().f();
        }
        b(getResources().getColor(R.color.white));
        Intent intent = getIntent();
        if (intent != null) {
            this.q = (StandingInstructionList) intent.getSerializableExtra("entity");
            this.K = this.q.getSupportingData();
        }
        this.f60006d = (TextInputLayout) findViewById(R.id.qpe_amount_til);
        this.f60011i = (AppCompatEditText) findViewById(R.id.qpe_amount_et);
        this.f60007e = (TextInputLayout) findViewById(R.id.qpe_name_til);
        this.j = (AppCompatEditText) findViewById(R.id.qpe_name_et);
        this.s = (RadioButton) findViewById(R.id.qp_paytm_rb);
        this.t = (RadioButton) findViewById(R.id.qp_account_rb);
        this.u = (RelativeLayout) findViewById(R.id.qp_wallet_ll);
        this.O = (AutoCompleteTextView) findViewById(R.id.qp_account_number_et);
        this.O.setThreshold(1);
        this.f60008f = (TextInputLayout) findViewById(R.id.qp_account_vpa_til);
        this.f60009g = (TextInputLayout) findViewById(R.id.qp_mobile_number_til);
        this.k = (AppCompatEditText) findViewById(R.id.qp_mobile_number_et);
        this.l = (AppCompatEditText) findViewById(R.id.qp_ifsc_et);
        this.f60010h = (TextInputLayout) findViewById(R.id.qp_ifsc_til);
        this.v = (LinearLayout) findViewById(R.id.qp_bank_ll);
        this.x = (ImageView) findViewById(R.id.qp_vpa_verified_iv);
        this.y = (ImageView) findViewById(R.id.qp_ifsc_verified_iv);
        this.E = (ProgressBar) findViewById(R.id.qp_ifsc_progress);
        this.J = (RelativeLayout) findViewById(R.id.qp_ifsc_layout);
        this.x = (ImageView) findViewById(R.id.qp_vpa_verified_iv);
        this.z = (TextView) findViewById(R.id.qp_verify_vpa_tv);
        this.M = (RelativeLayout) findViewById(R.id.ifsc_value_rl);
        this.B = (TextView) findViewById(R.id.ifsc_verified_value);
        this.C = (TextView) findViewById(R.id.bank_verified_value);
        this.y = (ImageView) findViewById(R.id.qp_ifsc_verified_iv);
        this.A = (TextView) findViewById(R.id.qp_ifsc_state_tv);
        this.N = (RelativeLayout) findViewById(R.id.rel_img_container);
        this.w = (ImageView) findViewById(R.id.qp_icon_iv);
        this.m = (AppCompatEditText) findViewById(R.id.qp_account_name_et);
        this.R = (LinearLayout) findViewById(R.id.ll_mode_selected);
        this.S = (TextView) findViewById(R.id.txt_change_mode);
        this.T = (TextView) findViewById(R.id.txt_bank_wallet);
        this.U = (TextView) findViewById(R.id.txt_bank_upi_heading);
        this.n = (AppCompatEditText) findViewById(R.id.qpe_tag_et);
        this.W = (LinearLayout) findViewById(R.id.ll_circle);
        String reminderFrequency = this.q.getReminderFrequency();
        if (TextUtils.isEmpty(reminderFrequency)) {
            ((LinearLayout) findViewById(R.id.qpe_date_tym_ll)).addView(new DateTimeView(this, getSupportFragmentManager(), this).getDateView());
        } else if ("monthly".equalsIgnoreCase(reminderFrequency)) {
            ((LinearLayout) findViewById(R.id.qpe_date_tym_ll)).addView(new DateTimeView(this, getSupportFragmentManager(), this, 2, this.q.getReminderDateIndex(), getResources().getDimension(R.dimen.dimen_15dp), getString(R.string.qp_when_to_pay)).getDateView());
        } else {
            ((LinearLayout) findViewById(R.id.qpe_date_tym_ll)).addView(new DateTimeView(this, getSupportFragmentManager(), this, 1, this.q.getReminderDayOfWeek(), getResources().getDimension(R.dimen.dimen_15dp), getString(R.string.qp_when_to_pay)).getDateView());
        }
        if (!TextUtils.isEmpty(this.q.getAmount())) {
            this.f60011i.setText(this.q.getAmount());
            AppCompatEditText appCompatEditText = this.f60011i;
            appCompatEditText.setSelection(appCompatEditText.getText().length());
        }
        this.j.setText(this.q.getReminderDisplayName());
        this.j.setKeyListener((KeyListener) null);
        this.j.setEnabled(false);
        SupportingData supportingData = this.q.getSupportingData();
        if (supportingData != null) {
            if (!TextUtils.isEmpty(supportingData.getTagName())) {
                this.n.setVisibility(0);
                this.n.setText(supportingData.getTagName());
                this.n.setKeyListener((KeyListener) null);
                this.n.setEnabled(false);
            } else {
                this.n.setVisibility(8);
            }
            if (TextUtils.isEmpty(supportingData.getTagUrl())) {
                this.w.setImageResource(R.drawable.ic_other);
            } else {
                this.N.setBackground(getResources().getDrawable(R.drawable.placeholder_quick_default));
                b.a.C0750a a2 = com.paytm.utility.b.b.a(this);
                a2.f43753a = supportingData.getTagUrl();
                a2.n = true;
                a2.a(this.w, (com.paytm.utility.b.b.b<?>) new com.paytm.utility.b.b.b<Drawable>() {
                    public final void onError(Exception exc) {
                        QuickPaymentEditActivity.this.N.setBackground(QuickPaymentEditActivity.this.getResources().getDrawable(R.drawable.placeholder_quick_default));
                    }

                    public final /* synthetic */ void onSuccess(Object obj, c cVar) {
                        QuickPaymentEditActivity.this.N.setBackground(QuickPaymentEditActivity.this.getResources().getDrawable(R.drawable.circle_grey));
                    }
                });
            }
            String beneficiaryAccountNumber = supportingData.getBeneficiaryAccountNumber();
            String beneficiaryMobileNumber = supportingData.getBeneficiaryMobileNumber();
            String beneficiaryUpiAddress = supportingData.getBeneficiaryUpiAddress();
            if (!TextUtils.isEmpty(beneficiaryAccountNumber)) {
                this.V = a.BANK;
                this.W.setVisibility(0);
                this.R.setVisibility(0);
                this.U.setText(getString(R.string.qp_bank_mode));
                TextView textView = this.T;
                if (beneficiaryAccountNumber.length() > 3) {
                    beneficiaryAccountNumber = beneficiaryAccountNumber.substring(0, 4);
                }
                textView.setText(beneficiaryAccountNumber);
                this.O.setText(supportingData.getBeneficiaryAccountNumber());
                this.t.setChecked(true);
                if (!TextUtils.isEmpty(supportingData.getBeneficiaryBankName())) {
                    this.f60010h.setVisibility(8);
                    this.M.setVisibility(0);
                    this.C.setText(supportingData.getBeneficiaryBankName());
                }
                if (!TextUtils.isEmpty(supportingData.getBeneficiaryIfscCode())) {
                    this.l.setText(supportingData.getBeneficiaryIfscCode());
                    this.B.setText(supportingData.getBeneficiaryIfscCode());
                    this.y.setVisibility(8);
                    this.f60004a = true;
                    b(true);
                    this.V = a.BANKWITHIFSCVERIFIED;
                }
            } else if (!TextUtils.isEmpty(beneficiaryMobileNumber)) {
                this.R.setVisibility(0);
                this.V = a.WALLET;
                this.U.setText(getString(R.string.qp_paytm_mode));
                this.T.setText(beneficiaryMobileNumber);
                this.k.setText(beneficiaryMobileNumber);
                this.s.setChecked(true);
                this.W.setVisibility(8);
                this.I = true;
            } else if (!TextUtils.isEmpty(beneficiaryUpiAddress)) {
                this.R.setVisibility(0);
                this.V = a.UPI;
                this.U.setText(getString(R.string.qp_upi_mode));
                this.T.setText(beneficiaryUpiAddress);
                this.O.setText(beneficiaryUpiAddress);
                this.t.setChecked(true);
                this.J.setVisibility(8);
                this.W.setVisibility(8);
                this.H = true;
                this.f60005c = true;
            }
        }
        findViewById(R.id.qpe_save_tv).setOnClickListener(this);
        findViewById(R.id.p2p_cp_contact_iv).setOnClickListener(this);
        this.f60011i.addTextChangedListener(this.Z);
        this.j.addTextChangedListener(this.Z);
        findViewById(R.id.qp_verify_vpa_tv).setOnClickListener(this);
        findViewById(R.id.qp_ifsc_state_tv).setOnClickListener(this);
        ((RadioGroup) findViewById(R.id.qp_select_rg)).setOnCheckedChangeListener(this.ab);
        this.l.addTextChangedListener(this.aa);
        this.O.addTextChangedListener(this.ac);
        this.O.setOnEditorActionListener(this.ad);
        this.M.setOnClickListener(this);
        findViewById(R.id.qp_back_iv).setOnClickListener(this);
        this.S.setOnClickListener(this);
        if (com.paytm.utility.a.m(this)) {
            d.a().a((Activity) this, (net.one97.paytm.landingpage.c.d) new net.one97.paytm.landingpage.c.d() {
                public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                    if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CJRKYCBeneficiaryBase)) {
                        ArrayList<BeneficiaryEntity> beneficiariesList = ((CJRKYCBeneficiaryBase) iJRPaytmDataModel).getBeneficiariesList();
                        if (beneficiariesList != null) {
                            Iterator<BeneficiaryEntity> it2 = beneficiariesList.iterator();
                            while (it2.hasNext()) {
                                BeneficiaryEntity next = it2.next();
                                if (next.instrumentPreferences.otherBank != null || next.instrumentPreferences.upi != null) {
                                    QuickPaymentEditActivity.this.Q.add(next);
                                }
                            }
                        }
                        if (QuickPaymentEditActivity.this.P == null) {
                            QuickPaymentEditActivity quickPaymentEditActivity = QuickPaymentEditActivity.this;
                            e unused = quickPaymentEditActivity.P = new e(quickPaymentEditActivity, quickPaymentEditActivity.Q);
                            QuickPaymentEditActivity.this.O.setAdapter(QuickPaymentEditActivity.this.P);
                            QuickPaymentEditActivity.this.O.setOnItemClickListener(QuickPaymentEditActivity.this.ae);
                            return;
                        }
                        QuickPaymentEditActivity.this.P.a((ArrayList<IJRPaytmDataModel>) QuickPaymentEditActivity.this.Q);
                    }
                }

                public final void a(NetworkCustomError networkCustomError) {
                    if (networkCustomError == null) {
                        return;
                    }
                    if (networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 403) {
                        r.a(QuickPaymentEditActivity.this, (String) null, (Bundle) null, false, false);
                    }
                }
            });
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 201) {
            if (intent == null || TextUtils.isEmpty(intent.getStringExtra("intent_extra_ifsc_code"))) {
                b(false);
            } else {
                this.f60010h.setVisibility(8);
                this.M.setVisibility(0);
                this.F = intent.getStringExtra("intent_extra_bank_name");
                this.B.setText(intent.getStringExtra("intent_extra_ifsc_code"));
                this.C.setText(this.F);
                b(true);
            }
        }
        if (i3 == -1 && i2 == 202) {
            Cursor cursor = null;
            try {
                cursor = getContentResolver().query(intent.getData(), (String[]) null, (String) null, (String[]) null, (String) null);
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex("data1");
                int columnIndex2 = cursor.getColumnIndex("display_name");
                String string = cursor.getString(columnIndex);
                cursor.getString(columnIndex2);
                String e2 = d.a().e(string);
                if (e2.length() > 10) {
                    e2 = d.a().a((Activity) this, e2);
                }
                if (!c(e2)) {
                    if (e2.length() > 5) {
                        e2 = e2.replace(" ", "");
                    }
                    this.k.setText(e2);
                    this.k.setSelection(this.k.getText().length());
                } else if (e2.length() > 5) {
                    String replace = e2.replace(" ", "");
                    this.k.setText(replace);
                    this.k.setSelection(replace.length());
                } else {
                    this.k.setText(e2.replace(" ", ""));
                    this.k.setSelection(e2.length());
                }
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
            } catch (Exception e3) {
                q.b(e3.getMessage());
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                throw th;
            }
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.qp_back_iv) {
            onBackPressed();
        } else if (id == R.id.qpe_change_tv) {
            Intent intent = new Intent(this, QuickPayEditAccountActivity.class);
            intent.putExtra("support_entity", this.q.getSupportingData());
            startActivityForResult(intent, KeyList.IntentRequestKey.INTENT_REQUEST_CHOOSE_MEDIA);
        } else if (id == R.id.qpe_save_tv) {
            String obj = this.f60011i.getText().toString();
            if (TextUtils.isEmpty(this.j.getText().toString())) {
                this.f60007e.setError("Please enter name");
                this.j.requestFocus();
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add("edit");
            StandingInstructionList standingInstructionList = this.q;
            if (!(standingInstructionList == null || standingInstructionList.getSupportingData() == null)) {
                arrayList.add(this.q.getSupportingData().getTagName());
            }
            int i2 = this.o;
            arrayList.add((i2 == 0 || i2 == 2) ? "Monthy" : "Weekly");
            try {
                d.a().a((Context) this, "set_reminder_button_clicked", (ArrayList<String>) arrayList);
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    q.b(e2.getMessage());
                }
            }
            this.q.setAmount(obj);
            c();
        } else if (id == R.id.qp_verify_vpa_tv) {
            String obj2 = this.O.getText().toString();
            if (!TextUtils.isEmpty(obj2)) {
                a(obj2, false);
            }
        } else if (id == R.id.qp_ifsc_state_tv) {
            this.f60010h.setError((CharSequence) null);
            com.paytm.utility.b.c((Activity) this);
            if (this.A.getText().toString().equalsIgnoreCase(getResources().getString(R.string.verify))) {
                if (com.paytm.utility.a.m(this)) {
                    a(this.l.getText().toString());
                } else {
                    com.paytm.utility.b.b((Context) this, getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
                }
            } else if (this.A.getText().toString().equalsIgnoreCase(getResources().getString(R.string.find_ifsc))) {
                Intent r2 = d.a().r(this);
                r2.putExtra("show_ifsc_new_design", true);
                startActivityForResult(r2, 201);
            }
        } else if (id == R.id.ifsc_value_rl) {
            this.M.setVisibility(8);
            this.f60010h.setVisibility(0);
        } else if (id == R.id.txt_change_mode) {
            this.R.setVisibility(8);
            a aVar = this.V;
            if (aVar != null) {
                int i3 = AnonymousClass7.f60031a[aVar.ordinal()];
                if (i3 == 1) {
                    this.u.setVisibility(0);
                    this.v.setVisibility(8);
                } else if (i3 == 2) {
                    this.u.setVisibility(8);
                    this.v.setVisibility(0);
                } else if (i3 == 3) {
                    this.u.setVisibility(8);
                    this.v.setVisibility(0);
                } else if (i3 == 4) {
                    this.u.setVisibility(8);
                    this.v.setVisibility(0);
                }
            }
        } else if (id == R.id.p2p_cp_contact_iv) {
            try {
                startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI), 202);
            } catch (Exception unused) {
            }
        }
    }

    public final void a(String str, int i2) {
        this.p = str;
        this.o = i2;
    }

    private void b() {
        String a2 = d.b().a("updateQuickPaymentUrl");
        if (URLUtil.isValidUrl(a2)) {
            String str = a2 + "?siId=" + this.q.getId() + "&type=QUICK_PAYMENTS";
            HashMap hashMap = new HashMap();
            hashMap.put("Authorization", d.a().b((Context) this));
            hashMap.put("Content-Type", "application/json");
            try {
                if (!TextUtils.isEmpty(this.p)) {
                    this.q.setEnablePaymentsReminder(true);
                    this.q.setReminderTimeRange("9-23");
                    if (this.o != 0) {
                        if (this.o != 2 || TextUtils.isEmpty(this.p)) {
                            if (this.o == 1 && !TextUtils.isEmpty(this.p)) {
                                this.q.setReminderDateIndex((String) null);
                                this.q.setReminderDayOfWeek(this.p);
                                this.q.setReminderFrequency("weekly");
                            }
                        }
                    }
                    this.q.setReminderDayOfWeek((String) null);
                    this.q.setReminderDateIndex(this.p);
                    this.q.setReminderFrequency("monthly");
                }
                this.q.getStartDate();
                this.q.getNextReminderDate();
                this.q.setStartDate((String) null);
                this.q.setNextReminderDate((String) null);
                JSONObject jSONObject = new JSONObject(new f().b(this.q));
                a((Context) this, getResources().getString(R.string.loading));
                d.a(this, str, new com.paytm.network.listener.b() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        if (iJRPaytmDataModel instanceof QuickPayAddResponse) {
                            QuickPayAddResponse quickPayAddResponse = (QuickPayAddResponse) iJRPaytmDataModel;
                            if (quickPayAddResponse.getResponseCode() == 200) {
                                QuickPaymentEditActivity quickPaymentEditActivity = QuickPaymentEditActivity.this;
                                QuickPaymentEditActivity.a(quickPaymentEditActivity, quickPaymentEditActivity.q.getId());
                                return;
                            }
                            QuickPaymentEditActivity.this.a();
                            String responseMessage = quickPayAddResponse.getResponseMessage();
                            if (TextUtils.isEmpty(responseMessage)) {
                                responseMessage = "Something went wrong";
                            }
                            QuickPaymentEditActivity.this.a("Error", responseMessage);
                            return;
                        }
                        QuickPaymentEditActivity.this.a();
                        QuickPaymentEditActivity.this.a("Error", "Something went wrong");
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        QuickPaymentEditActivity.this.a();
                        if (networkCustomError == null || !(networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 403)) {
                            QuickPaymentEditActivity.this.a("Error", "Something went wrong");
                        } else {
                            r.a(QuickPaymentEditActivity.this, (String) null, (Bundle) null, false, false);
                        }
                    }
                }, hashMap, (Map<String, String>) null, a.C0715a.PUT, jSONObject.toString(), new QuickPayAddResponse(), a.c.PAYMENTS, a.b.SILENT).a();
            } catch (JSONException e2) {
                q.b(e2.getMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, final boolean z2) {
        if (com.paytm.utility.a.m(this)) {
            this.f60008f.setError((CharSequence) null);
            com.paytm.utility.b.c((Activity) this);
            if (!b(str)) {
                return;
            }
            if (str.toLowerCase().contains(".com")) {
                final String c2 = d.a().c(str);
                final h hVar = new h(this);
                hVar.a(String.format(getString(R.string.did_you_mean_to_enter_quick), new Object[]{c2}));
                hVar.a(-1, CommonPayParams.Builder.YES, new View.OnClickListener() {
                    public final void onClick(View view) {
                        hVar.dismiss();
                        QuickPaymentEditActivity.this.O.setText(c2);
                        QuickPaymentEditActivity.this.a(c2, "xyz", z2);
                    }
                });
                hVar.a(-2, CommonPayParams.Builder.NO, new View.OnClickListener() {
                    public final void onClick(View view) {
                        hVar.dismiss();
                        QuickPaymentEditActivity quickPaymentEditActivity = QuickPaymentEditActivity.this;
                        quickPaymentEditActivity.a(quickPaymentEditActivity.O.getText().toString(), "xyz", z2);
                    }
                });
                hVar.show();
                return;
            }
            a(str, "xyz", z2);
            return;
        }
        com.paytm.utility.b.b((Context) this, getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, final boolean z2) {
        a((Context) this, getResources().getString(R.string.verifying));
        net.one97.paytm.upi.requestmoney.b.a.b c2 = g.c();
        AnonymousClass14 r2 = new a.C1402a() {
            public final void a(UpiBaseDataModel upiBaseDataModel) {
                QuickPaymentEditActivity.this.a();
                if (upiBaseDataModel instanceof BaseUpiResponse) {
                    BaseUpiResponse baseUpiResponse = (BaseUpiResponse) upiBaseDataModel;
                    if (!baseUpiResponse.isSuccess() || !"0".equalsIgnoreCase(baseUpiResponse.getResponse())) {
                        QuickPaymentEditActivity.this.f60008f.setError("You have entered an incorrect UPI ID");
                        return;
                    }
                    String str = (String) baseUpiResponse.getMobileAppData();
                    if (str.toLowerCase().contains("success")) {
                        String substring = str.substring(str.indexOf("=") + 1);
                        if (!TextUtils.isEmpty(substring)) {
                            QuickPaymentEditActivity quickPaymentEditActivity = QuickPaymentEditActivity.this;
                            quickPaymentEditActivity.f60005c = true;
                            quickPaymentEditActivity.x.setVisibility(0);
                            QuickPaymentEditActivity.this.z.setVisibility(8);
                            QuickPaymentEditActivity.this.m.setText(substring);
                            if (z2) {
                                QuickPaymentEditActivity.this.c();
                                return;
                            }
                            return;
                        }
                        QuickPaymentEditActivity.this.f60008f.setError("You have entered an incorrect UPI ID");
                    }
                }
            }

            public final void a(UpiCustomVolleyError upiCustomVolleyError) {
                QuickPaymentEditActivity.this.a();
                QuickPaymentEditActivity.this.f60008f.setError("You have entered an incorrect UPI ID");
            }
        };
        String str3 = this.D;
        c2.a(r2, str3, str, str2, str3);
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        if (!TextUtils.isEmpty(str) && com.paytm.utility.a.m(this)) {
            a(true);
            d.a().a((Activity) this, str, (net.one97.paytm.landingpage.c.d) new net.one97.paytm.landingpage.c.d() {
                public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                    QuickPaymentEditActivity.this.a(false);
                    QuickPaymentEditActivity.a(QuickPaymentEditActivity.this, (CJRBankDetails) iJRPaytmDataModel);
                }

                public final void a(NetworkCustomError networkCustomError) {
                    QuickPaymentEditActivity.this.a(false);
                    QuickPaymentEditActivity.this.b(false);
                    if (networkCustomError == null) {
                        return;
                    }
                    if (networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 403) {
                        r.a(QuickPaymentEditActivity.this, (String) null, (Bundle) null, false, false);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        new Intent();
        if (this.I) {
            String obj = this.k.getText().toString();
            if (!com.paytm.utility.b.b(obj)) {
                this.f60009g.setError(getString(R.string.enter_valid_mobile_number));
                this.k.requestFocus();
                return;
            }
            this.K.setBeneficiaryMobileNumber(obj);
            this.K.setBeneficiaryAccountNumber((String) null);
            this.K.setBeneficiaryIfscCode((String) null);
            this.K.setBeneficiaryName((String) null);
            this.K.setBeneficiaryUpiAddress((String) null);
            this.K.setBeneficiaryBankName((String) null);
            String obj2 = this.j.getText().toString();
            if (!TextUtils.isEmpty(obj2)) {
                this.q.setReminderDisplayName(obj2);
            } else {
                this.q.setReminderDisplayName(obj);
            }
            b();
            return;
        }
        if (!this.H) {
            String obj3 = this.O.getText().toString();
            String charSequence = this.M.getVisibility() == 0 ? this.B.getText().toString() : this.l.getText().toString();
            String obj4 = this.m.getText().toString();
            if (!d.a().d(obj3)) {
                this.f60008f.setError(getString(R.string.wallet_account_number_error));
                this.O.requestFocus();
                return;
            } else if (!this.f60004a) {
                this.f60010h.setError(getString(R.string.wallet_ifsc_code_error));
                this.l.requestFocus();
                return;
            } else {
                this.K.setBeneficiaryAccountNumber(obj3);
                this.K.setBeneficiaryIfscCode(charSequence);
                this.K.setBeneficiaryName(obj4);
                this.K.setBeneficiaryBankName(this.F);
                this.K.setBeneficiaryMobileNumber((String) null);
                this.K.setBeneficiaryUpiAddress((String) null);
                if (!TextUtils.isEmpty(obj4)) {
                    this.q.setReminderDisplayName(obj4);
                }
            }
        } else if (this.f60005c) {
            String obj5 = this.O.getText().toString();
            if (TextUtils.isEmpty(obj5)) {
                this.f60008f.setError(getString(R.string.wallet_account_name_error));
                return;
            }
            this.K.setBeneficiaryUpiAddress(this.O.getText().toString());
            this.K.setBeneficiaryName(obj5);
            this.K.setBeneficiaryMobileNumber((String) null);
            this.K.setBeneficiaryAccountNumber((String) null);
            this.K.setBeneficiaryIfscCode((String) null);
            this.K.setBeneficiaryBankName((String) null);
        } else {
            String obj6 = this.O.getText().toString();
            if (!TextUtils.isEmpty(obj6)) {
                a(obj6, true);
                return;
            }
            this.f60008f.setError("Please verify UPI ID");
            this.O.requestFocus();
            return;
        }
        b();
    }

    /* access modifiers changed from: private */
    public void a(boolean z2) {
        if (z2) {
            this.E.setVisibility(0);
            this.A.setVisibility(8);
            this.y.setVisibility(8);
            return;
        }
        this.E.setVisibility(8);
        this.A.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public void b(boolean z2) {
        if (z2) {
            this.A.setText(R.string.verified);
            this.y.setVisibility(0);
            this.f60004a = true;
            return;
        }
        this.A.setText(R.string.find_ifsc);
        this.y.setVisibility(8);
        this.f60004a = false;
        this.f60010h.setError(getString(R.string.enter_valid_ifsc));
    }

    private boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f60008f.setError(getString(R.string.upi_empty_vpa_error));
            return false;
        } else if (str.length() > 255) {
            this.f60008f.setError(getString(R.string.upi_vpa_length_breach));
            return false;
        } else if (str.matches("[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+")) {
            return true;
        } else {
            this.f60008f.setError(getString(R.string.upi_invalid_upi));
            return false;
        }
    }

    /* renamed from: net.one97.paytm.quickpay.activity.QuickPaymentEditActivity$7  reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f60031a = new int[a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                net.one97.paytm.quickpay.activity.QuickPaymentEditActivity$a[] r0 = net.one97.paytm.quickpay.activity.QuickPaymentEditActivity.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f60031a = r0
                int[] r0 = f60031a     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.quickpay.activity.QuickPaymentEditActivity$a r1 = net.one97.paytm.quickpay.activity.QuickPaymentEditActivity.a.WALLET     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f60031a     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.quickpay.activity.QuickPaymentEditActivity$a r1 = net.one97.paytm.quickpay.activity.QuickPaymentEditActivity.a.BANK     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f60031a     // Catch:{ NoSuchFieldError -> 0x002a }
                net.one97.paytm.quickpay.activity.QuickPaymentEditActivity$a r1 = net.one97.paytm.quickpay.activity.QuickPaymentEditActivity.a.BANKWITHIFSCVERIFIED     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f60031a     // Catch:{ NoSuchFieldError -> 0x0035 }
                net.one97.paytm.quickpay.activity.QuickPaymentEditActivity$a r1 = net.one97.paytm.quickpay.activity.QuickPaymentEditActivity.a.UPI     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.quickpay.activity.QuickPaymentEditActivity.AnonymousClass7.<clinit>():void");
        }
    }

    private static boolean c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (Integer.parseInt(String.valueOf(str.charAt(0))) <= 4 || str.length() != 10) {
                    return false;
                }
                return true;
            } catch (NumberFormatException unused) {
            }
        }
        return false;
    }

    public void onResume() {
        super.onResume();
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService("clipboard");
        if (clipboardManager.hasPrimaryClip() && clipboardManager.getPrimaryClip().getItemCount() > 0) {
            String replaceAll = clipboardManager.getPrimaryClip().getItemAt(0).getText().toString().replaceAll("\\s+", "");
            if (replaceAll.length() >= 10) {
                clipboardManager.setPrimaryClip(ClipData.newPlainText(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX, replaceAll.substring(replaceAll.length() - 10, replaceAll.length())));
            }
        }
    }

    static /* synthetic */ void a(QuickPaymentEditActivity quickPaymentEditActivity, String str) {
        String a2 = d.b().a("getQuickPaymentsUrl");
        if (!TextUtils.isEmpty(a2)) {
            HashMap hashMap = new HashMap();
            hashMap.put("Authorization", d.a().b((Context) quickPaymentEditActivity));
            com.paytm.network.a a3 = d.a(quickPaymentEditActivity, a2 + "&siId=" + str, new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    QuickPaymentEditActivity.this.a();
                    if (iJRPaytmDataModel != null) {
                        QuickListResponse quickListResponse = (QuickListResponse) iJRPaytmDataModel;
                        Payload payload = quickListResponse.getPayload();
                        if (payload == null || payload.getStandingInstructionList() == null || payload.getStandingInstructionList().size() <= 0) {
                            String responseMessage = quickListResponse.getResponseMessage();
                            if (TextUtils.isEmpty(responseMessage)) {
                                responseMessage = "Something went wrong";
                            }
                            QuickPaymentEditActivity.this.a("Error", responseMessage);
                            return;
                        }
                        StandingInstructionList standingInstructionList = payload.getStandingInstructionList().get(0);
                        if (standingInstructionList != null) {
                            net.one97.paytm.quickpay.b.a.a((Context) QuickPaymentEditActivity.this, standingInstructionList);
                            net.one97.paytm.quickpay.d.a.a().a(standingInstructionList);
                            QuickPaymentEditActivity quickPaymentEditActivity = QuickPaymentEditActivity.this;
                            quickPaymentEditActivity.a(quickPaymentEditActivity, quickPaymentEditActivity.getResources().getString(R.string.qp_edited_successfully), new QuickPaymentActivity.a() {
                                public final void a() {
                                    Intent intent = new Intent();
                                    intent.putExtra("instruction_entity", QuickPaymentEditActivity.this.q);
                                    QuickPaymentEditActivity.this.setResult(-1, intent);
                                    QuickPaymentEditActivity.this.finish();
                                }
                            });
                            return;
                        }
                        String responseMessage2 = quickListResponse.getResponseMessage();
                        if (TextUtils.isEmpty(responseMessage2)) {
                            responseMessage2 = "Something went wrong";
                        }
                        QuickPaymentEditActivity.this.a("Error", responseMessage2);
                        return;
                    }
                    QuickPaymentEditActivity.this.a("Error", "Something went wrong");
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    QuickPaymentEditActivity.this.a();
                    if (networkCustomError == null || !(networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 403)) {
                        QuickPaymentEditActivity.this.a("Error", "Something went wrong");
                    } else {
                        r.a(QuickPaymentEditActivity.this, (String) null, (Bundle) null, false, false);
                    }
                }
            }, hashMap, (Map<String, String>) null, a.C0715a.GET, (String) null, new QuickListResponse(), a.c.PAYMENTS, a.b.SILENT);
            if (com.paytm.utility.a.m(quickPaymentEditActivity)) {
                a3.a();
            }
        }
    }

    static /* synthetic */ void e(QuickPaymentEditActivity quickPaymentEditActivity) {
        quickPaymentEditActivity.f60009g.setError((CharSequence) null);
        quickPaymentEditActivity.f60010h.setError((CharSequence) null);
        quickPaymentEditActivity.f60008f.setError((CharSequence) null);
    }

    static /* synthetic */ void a(QuickPaymentEditActivity quickPaymentEditActivity, CJRBankDetails cJRBankDetails) {
        if (cJRBankDetails.getStatusCode() == null || !cJRBankDetails.getStatusCode().equalsIgnoreCase("SUCCESS") || cJRBankDetails.getResponse() == null) {
            quickPaymentEditActivity.b(false);
            return;
        }
        quickPaymentEditActivity.f60010h.setVisibility(8);
        quickPaymentEditActivity.M.setVisibility(0);
        quickPaymentEditActivity.b(true);
        quickPaymentEditActivity.F = cJRBankDetails.getResponse().getBankName();
        quickPaymentEditActivity.C.setText(quickPaymentEditActivity.F);
        quickPaymentEditActivity.B.setText(cJRBankDetails.getResponse().getIfscCode());
    }

    static /* synthetic */ void a(QuickPaymentEditActivity quickPaymentEditActivity, boolean z2, boolean z3) {
        if (z2) {
            quickPaymentEditActivity.I = true;
            quickPaymentEditActivity.G = false;
            if (z3) {
                AppCompatEditText appCompatEditText = quickPaymentEditActivity.k;
                appCompatEditText.setSelection(appCompatEditText.getText().length());
                quickPaymentEditActivity.k.requestFocus();
                quickPaymentEditActivity.s.setTypeface(Typeface.DEFAULT_BOLD);
                quickPaymentEditActivity.t.setTypeface(Typeface.DEFAULT);
                quickPaymentEditActivity.v.setVisibility(8);
                quickPaymentEditActivity.u.setVisibility(0);
                return;
            }
            quickPaymentEditActivity.t.setTypeface(Typeface.DEFAULT);
            quickPaymentEditActivity.v.setVisibility(8);
            return;
        }
        quickPaymentEditActivity.I = false;
        quickPaymentEditActivity.G = true;
        if (z3) {
            AutoCompleteTextView autoCompleteTextView = quickPaymentEditActivity.O;
            autoCompleteTextView.setSelection(autoCompleteTextView.getText().length());
            quickPaymentEditActivity.O.requestFocus();
            quickPaymentEditActivity.s.setTypeface(Typeface.DEFAULT);
            quickPaymentEditActivity.t.setTypeface(Typeface.DEFAULT_BOLD);
            quickPaymentEditActivity.u.setVisibility(8);
            quickPaymentEditActivity.v.setVisibility(0);
            return;
        }
        quickPaymentEditActivity.s.setTypeface(Typeface.DEFAULT);
        quickPaymentEditActivity.u.setVisibility(8);
    }

    static /* synthetic */ void c(QuickPaymentEditActivity quickPaymentEditActivity, boolean z2) {
        if (z2) {
            quickPaymentEditActivity.J.setVisibility(8);
            quickPaymentEditActivity.z.setVisibility(0);
            return;
        }
        quickPaymentEditActivity.J.setVisibility(0);
        quickPaymentEditActivity.z.setVisibility(8);
    }
}
