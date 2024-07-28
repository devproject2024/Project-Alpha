package net.one97.paytm.moneytransfer.view.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.utility.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.common.entity.wallet.CJRBankDetails;
import net.one97.paytm.games.model.pfg.BaseResult;
import net.one97.paytm.i.h;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.d.b;
import net.one97.paytm.moneytransfer.model.d;
import net.one97.paytm.moneytransfer.utils.f;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.moneytransfer.view.a.g;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity;
import net.one97.paytm.moneytransfer.viewmodel.b;
import net.one97.paytm.moneytransfer.viewmodel.c;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.UpiDBTransactionModel;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.util.AnimationFactory;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.Events;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public class e extends h implements View.OnClickListener, g.a {
    private String A = "";
    private String B = "";
    /* access modifiers changed from: private */
    public c C;
    private g D;
    private boolean E = false;
    private String F;
    /* access modifiers changed from: private */
    public boolean G;
    private String H;
    private AdapterView.OnItemClickListener I = new AdapterView.OnItemClickListener() {
        public final void onItemClick(AdapterView adapterView, View view, int i2, long j) {
            e.this.a(adapterView, view, i2, j);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public b f54453a;

    /* renamed from: b  reason: collision with root package name */
    TextWatcher f54454b = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            e.this.s.setError((CharSequence) null);
            e.this.q.setError((CharSequence) null);
            e.this.t.setError((CharSequence) null);
            e.this.r.setError((CharSequence) null);
            String charSequence2 = charSequence.toString();
            if (TextUtils.isEmpty(charSequence2)) {
                e.this.o.setVisibility(8);
                e.this.p.setVisibility(0);
            } else {
                e.this.o.setVisibility(0);
                e.this.p.setVisibility(8);
            }
            if (UpiAppUtils.checkIsVpa(charSequence2)) {
                e.g(e.this);
                e.this.C.a(charSequence2.trim());
                return;
            }
            e.i(e.this);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    TextWatcher f54455c = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (charSequence.length() == 0) {
                e.this.k.setTextColor(e.this.getResources().getColor(R.color.color_blue_ifsc));
                boolean unused = e.this.G = false;
                e.this.n.setVisibility(8);
                e.this.k.setText(e.this.getString(R.string.money_transfer_find_ifsc));
                e.this.k.setVisibility(0);
                e.this.r.setError((CharSequence) null);
            } else if (charSequence.length() != 11) {
                boolean unused2 = e.this.G = false;
                e.this.m.setVisibility(8);
                e.this.n.setVisibility(8);
                e.this.k.setTextColor(e.this.getResources().getColor(R.color.color_blue_ifsc));
                e.this.k.setVisibility(8);
                e.this.r.setError((CharSequence) null);
            } else if (!e.this.G) {
                e.this.C.c(e.this.x.getText().toString());
            } else {
                e.this.m.setVisibility(8);
            }
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final int f54456d = 0;

    /* renamed from: e  reason: collision with root package name */
    private final int f54457e = 50;

    /* renamed from: f  reason: collision with root package name */
    private View f54458f;

    /* renamed from: g  reason: collision with root package name */
    private View f54459g;

    /* renamed from: h  reason: collision with root package name */
    private View f54460h;

    /* renamed from: i  reason: collision with root package name */
    private View f54461i;
    private View j;
    /* access modifiers changed from: private */
    public TextView k;
    private TextView l;
    /* access modifiers changed from: private */
    public TextView m;
    /* access modifiers changed from: private */
    public ImageView n;
    /* access modifiers changed from: private */
    public ImageView o;
    /* access modifiers changed from: private */
    public ImageView p;
    /* access modifiers changed from: private */
    public TextInputLayout q;
    /* access modifiers changed from: private */
    public TextInputLayout r;
    /* access modifiers changed from: private */
    public TextInputLayout s;
    /* access modifiers changed from: private */
    public TextInputLayout t;
    private AutoCompleteTextView u;
    private LottieAnimationView v;
    private RecyclerView w;
    /* access modifiers changed from: private */
    public EditText x;
    private EditText y;
    private EditText z;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.H = arguments.getString(ContactColumn.PHONE_NUMBER);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_enter_bankaccount_upi, viewGroup, false);
        this.k = (TextView) inflate.findViewById(R.id.txt_p2b_ifsc_code_state);
        this.k.setOnClickListener(this);
        this.v = (LottieAnimationView) inflate.findViewById(R.id.money_transfer_loader);
        this.f54459g = inflate.findViewById(R.id.money_transfer_loader_container);
        this.l = (TextView) inflate.findViewById(R.id.phoneNumberTV);
        this.f54461i = inflate.findViewById(R.id.phoneNumberPrefilledLayout);
        this.j = inflate.findViewById(R.id.rl_mobile_no);
        this.z = (EditText) inflate.findViewById(R.id.mobile_no_et);
        this.t = (TextInputLayout) inflate.findViewById(R.id.mobile_til);
        this.q = (TextInputLayout) inflate.findViewById(R.id.account_til);
        this.u = (AutoCompleteTextView) inflate.findViewById(R.id.account_number_et);
        this.u.addTextChangedListener(this.f54454b);
        this.u.setThreshold(1);
        this.u.setOnItemClickListener(this.I);
        this.x = (EditText) inflate.findViewById(R.id.edit_p2b_ifsc_code);
        this.x.addTextChangedListener(this.f54455c);
        this.y = (EditText) inflate.findViewById(R.id.account_name_et);
        this.s = (TextInputLayout) inflate.findViewById(R.id.account_name_til);
        this.f54458f = inflate.findViewById(R.id.lyt_p2b_ifsc_code);
        this.f54460h = inflate.findViewById(R.id.proceedbutton);
        this.n = (ImageView) inflate.findViewById(R.id.ifsc_verified_image);
        this.m = (TextView) inflate.findViewById(R.id.bank_verified_value);
        this.f54460h.setOnClickListener(this);
        inflate.findViewById(R.id.iv_back_button).setOnClickListener(this);
        this.o = (ImageView) inflate.findViewById(R.id.cross_iv);
        this.o.setOnClickListener(this);
        this.p = (ImageView) inflate.findViewById(R.id.scan_iv);
        this.p.setOnClickListener(this);
        this.r = (TextInputLayout) inflate.findViewById(R.id.float_p2b_ifsc_code);
        this.w = (RecyclerView) inflate.findViewById(R.id.vpaRecyclerView);
        this.w.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
        this.D = new g();
        this.D.a((g.a) this);
        this.w.setAdapter(this.D);
        if (net.one97.paytm.moneytransfer.d.c.g().b()) {
            this.s.setHint(getString(R.string.mt_account_holders_name));
        }
        if (!m.b(getContext())) {
            this.u.setFilters(new InputFilter[]{new net.one97.paytm.moneytransfer.utils.b(), new InputFilter.LengthFilter(50)});
            this.q.setHint(getString(R.string.mt_enter_bank_account));
        } else {
            this.u.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
            this.q.setHint(getString(R.string.univ_money_trnsfr_upi_bank_acc_adhaar));
        }
        this.z.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                e.this.t.setError((CharSequence) null);
            }
        });
        if (!TextUtils.isEmpty(this.H)) {
            this.f54461i.setVisibility(0);
            this.l.setText(this.H);
        } else {
            this.f54461i.setVisibility(8);
        }
        this.C = (c) am.a((Fragment) this).a(c.class);
        this.C.f54710a.observe(this, new z() {
            public final void onChanged(Object obj) {
                e.this.a((ArrayList) obj);
            }
        });
        this.C.f54711b.observe(this, new z() {
            public final void onChanged(Object obj) {
                e.this.c((net.one97.paytm.moneytransfer.model.c) obj);
            }
        });
        this.C.f54712c.observe(this, new z() {
            public final void onChanged(Object obj) {
                e.this.b((net.one97.paytm.moneytransfer.model.c) obj);
            }
        });
        this.C.a();
        this.C.f54713d.observe(this, new z() {
            public final void onChanged(Object obj) {
                e.this.a((net.one97.paytm.moneytransfer.model.c) obj);
            }
        });
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(ArrayList arrayList) {
        this.D.a((List<String>) arrayList);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(net.one97.paytm.moneytransfer.model.c cVar) {
        int i2 = AnonymousClass4.f54465a[cVar.f54032a.ordinal()];
        if (i2 == 1) {
            this.f54459g.setVisibility(0);
            AnimationFactory.startWalletLoader(this.v);
            this.f54460h.setEnabled(false);
            this.f54460h.setVisibility(8);
        } else if (i2 == 2) {
            b();
            b.C0979b bVar = (b.C0979b) cVar.f54033b;
            this.F = bVar.f54690b;
            String str = bVar.f54691c;
            if (TextUtils.isEmpty(this.F)) {
                int i3 = bVar.f54689a;
                if (i3 == 1) {
                    this.q.setError(getString(R.string.upi_unable_to_verify_vpa));
                } else if (i3 == 2) {
                    if (UpiUtils.AUTHENTICATION_FAILURE_401.equalsIgnoreCase(str)) {
                        m.b((Activity) getActivity());
                    } else if ("XH".equalsIgnoreCase(str) || "J02".equalsIgnoreCase(str) || "U17".equalsIgnoreCase(str) || "37".equalsIgnoreCase(str) || "0037".equalsIgnoreCase(str)) {
                        this.q.setError(getString(R.string.upi_address_incorrect));
                    } else if ("INT-1470".equalsIgnoreCase(str)) {
                        this.q.setError(getString(R.string.mt_vpa_verify_no_bank_linked_err));
                    } else if ("1006".equalsIgnoreCase(str)) {
                        Intent intent = new Intent(getActivity(), UpiRegistrationActivity.class);
                        intent.putExtra("redirect", BaseResult.RESP_SYS_EXCEPTION);
                        startActivityForResult(intent, 80);
                    }
                }
            } else if (getActivity() != null) {
                UpiAppUtils.hideKeyboard(getActivity());
                a(this.u.getText().toString(), this.F);
            }
        } else if (i2 == 3) {
            b();
            UpiCustomVolleyError upiCustomVolleyError = cVar.f54034c;
            if (upiCustomVolleyError == null) {
                return;
            }
            if (UpiUtils.AUTHENTICATION_FAILURE_401.equalsIgnoreCase(upiCustomVolleyError.getmErrorCode()) || "410".equalsIgnoreCase(upiCustomVolleyError.getmErrorCode())) {
                m.b((Activity) getActivity());
            } else {
                com.paytm.utility.b.b((Context) getActivity(), upiCustomVolleyError.getAlertTitle() == null ? "Error" : upiCustomVolleyError.getAlertTitle(), upiCustomVolleyError.getAlertMessage());
            }
        }
    }

    /* renamed from: net.one97.paytm.moneytransfer.view.fragments.e$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f54465a = new int[d.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                net.one97.paytm.moneytransfer.model.d[] r0 = net.one97.paytm.moneytransfer.model.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f54465a = r0
                int[] r0 = f54465a     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.moneytransfer.model.d r1 = net.one97.paytm.moneytransfer.model.d.LOADING     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f54465a     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.moneytransfer.model.d r1 = net.one97.paytm.moneytransfer.model.d.SUCCESS     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f54465a     // Catch:{ NoSuchFieldError -> 0x002a }
                net.one97.paytm.moneytransfer.model.d r1 = net.one97.paytm.moneytransfer.model.d.ERROR     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.view.fragments.e.AnonymousClass4.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(net.one97.paytm.moneytransfer.model.c cVar) {
        int i2 = AnonymousClass4.f54465a[cVar.f54032a.ordinal()];
        if (i2 == 1) {
            return;
        }
        if (i2 != 2) {
            if (i2 == 3) {
                a(getString(R.string.bank_not_found_error));
            }
        } else if (cVar.f54033b != null) {
            CJRBankDetails cJRBankDetails = ((c.b) cVar.f54033b).f54718a;
            if (cJRBankDetails == null) {
                a(getString(R.string.bank_not_found_error));
            } else if (cJRBankDetails.getResponse() == null || TextUtils.isEmpty(cJRBankDetails.getResponse().getIfscCode()) || TextUtils.isEmpty(cJRBankDetails.getResponse().getBankName())) {
                a(cJRBankDetails.getStatusMessage());
            } else {
                this.A = cJRBankDetails.getResponse().getIfscCode();
                this.B = cJRBankDetails.getResponse().getBankName();
                a();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(AdapterView adapterView, View view, int i2, long j2) {
        IJRDataModel a2 = ((net.one97.paytm.moneytransfer.view.a.b) adapterView.getAdapter()).getItem(i2);
        if (a2 instanceof UpiDBTransactionModel) {
            a((UpiDBTransactionModel) a2);
        } else if (a2 instanceof BeneficiaryEntity) {
            BeneficiaryEntity beneficiaryEntity = (BeneficiaryEntity) a2;
            if (beneficiaryEntity.instrumentPreferences.otherBank != null) {
                BeneficiaryEntity.OtherBankAccountDetail otherBankAccountDetail = beneficiaryEntity.instrumentPreferences.otherBank.accounts.get(0).accountDetail;
                a(new UpiDBTransactionModel("", otherBankAccountDetail.accountNumber, otherBankAccountDetail.accountHolderName, otherBankAccountDetail.bankName, otherBankAccountDetail.ifscCode, "", ""));
            } else if (beneficiaryEntity.instrumentPreferences.upi != null) {
                BeneficiaryEntity.UPIAccountDetail uPIAccountDetail = beneficiaryEntity.instrumentPreferences.upi.accounts.get(0).accountDetail;
                a(new UpiDBTransactionModel("", uPIAccountDetail.vpa, uPIAccountDetail.accountHolderName, "", "UPI", "", ""));
            }
        }
    }

    private void a(UpiDBTransactionModel upiDBTransactionModel) {
        if (!TextUtils.isEmpty(upiDBTransactionModel.getTxn_mode())) {
            String txn_mode = upiDBTransactionModel.getTxn_mode();
            if (UpiAppUtils.checkIsVpa(upiDBTransactionModel.getTxn_mode())) {
                this.E = true;
                this.u.setText("");
                a(txn_mode, upiDBTransactionModel.getBeneficiary_name());
                return;
            }
            this.u.setText("");
            String beneficiary_name = upiDBTransactionModel.getBeneficiary_name();
            String ifsc = upiDBTransactionModel.getIfsc();
            String bank_name = upiDBTransactionModel.getBank_name();
            f.a(getActivity(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, Events.Action.PROCEED_CLICKED, CJRGTMConstants.MONEY_TRANSFER_HOME_SCREEN_NAME, "bank_account", "new_account_entered");
            Bundle bundle = new Bundle();
            bundle.putBoolean("isVPA", false);
            bundle.putString("vpa", txn_mode);
            bundle.putString("username", beneficiary_name);
            bundle.putString("ifsc", ifsc);
            bundle.putString("bankname", bank_name);
            bundle.putInt("source_of_initiation", MoneyTransferV3Activity.c.NEW_ACCOUNT.ordinal());
            m.a(bundle, getActivity().getSupportFragmentManager(), R.id.fragmentContainer);
        }
    }

    private void a() {
        this.G = true;
        this.m.setText(this.B);
        this.k.setVisibility(8);
        this.r.setErrorEnabled(false);
        this.r.setError((CharSequence) null);
        this.m.setVisibility(0);
        this.n.setVisibility(0);
    }

    private void a(String str) {
        this.G = false;
        this.m.setVisibility(8);
        this.n.setVisibility(8);
        this.k.setVisibility(0);
        this.r.setErrorEnabled(true);
        this.r.setError(str);
        this.k.setText(getString(R.string.money_transfer_verify));
        this.k.setVisibility(0);
    }

    private void b() {
        this.f54459g.setVisibility(8);
        AnimationFactory.stopWalletLoader(this.v);
        this.f54460h.setEnabled(true);
        this.f54460h.setVisibility(0);
    }

    public void onClick(View view) {
        Intent intent;
        String str;
        Intent intent2;
        int id = view.getId();
        boolean z2 = true;
        boolean z3 = false;
        if (id == R.id.txt_p2b_ifsc_code_state) {
            f.a(getContext(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, "ifsc_code_clicked", CJRGTMConstants.MONEY_TRANSFER_HOME_SCREEN_NAME, "", "");
            if (!this.k.getText().toString().equalsIgnoreCase("verify")) {
                try {
                    intent2 = new Intent(getActivity(), Class.forName(net.one97.paytm.moneytransfer.d.d.c().e()));
                } catch (ClassNotFoundException e2) {
                    e2.printStackTrace();
                    intent2 = null;
                }
                intent2.putExtra("show_ifsc_new_design", true);
                startActivityForResult(intent2, 0);
            } else if (!this.G) {
                this.C.c(this.x.getText().toString());
            }
        } else if (id == R.id.proceedbutton) {
            String obj = this.u.getText().toString();
            String obj2 = this.y.getText().toString();
            String obj3 = this.x.getText().toString();
            if (this.E) {
                if (a.m(getContext())) {
                    if (TextUtils.isEmpty(obj)) {
                        this.q.setError(getString(R.string.upi_empty_vpa_error));
                    } else if (obj.length() > 255) {
                        this.q.setError(getString(R.string.upi_vpa_length_breach));
                    } else if (!obj.matches("[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+")) {
                        this.q.setError(getString(R.string.upi_invalid_upi));
                    } else {
                        z3 = true;
                    }
                    if (z3) {
                        this.C.b(obj);
                        return;
                    }
                    return;
                }
                m.d((Activity) getActivity());
            } else if (!m.b(obj)) {
                if (m.b(getContext())) {
                    this.q.setError(getString(R.string.bank_account_upi_error_message));
                } else {
                    this.q.setError(getString(R.string.mt_bank_account_error_message));
                }
            } else if (("PYTM0123456".equalsIgnoreCase(this.A) || "PYTM0000001".equalsIgnoreCase(this.A)) && !TextUtils.isEmpty(obj) && obj.trim().length() < 12) {
                this.q.setError(getString(R.string.money_transfer_paytm_ifsc_check));
            } else {
                if (TextUtils.isEmpty(obj3) || !this.G) {
                    if (this.r.getError() != null) {
                        return;
                    }
                    if (obj3.length() == 0) {
                        this.r.setError(getString(R.string.ifsc_error_message));
                        this.r.requestFocus();
                        return;
                    } else if (obj3.length() == 11) {
                        this.A = obj3;
                        this.r.setError((CharSequence) null);
                    } else {
                        this.r.setError(getString(R.string.money_transfer_ifsc_code_error));
                        this.r.requestFocus();
                        return;
                    }
                }
                if (net.one97.paytm.moneytransfer.d.c.g().b() && (TextUtils.isEmpty(obj2) || obj2.trim().length() == 0)) {
                    this.s.setError(getString(R.string.mt_name_error));
                } else if (TextUtils.isEmpty(this.z.getText().toString()) || m.d(this.z.getText().toString())) {
                    this.q.setError((CharSequence) null);
                    if (getActivity() == null || getView() == null || !isAdded() || !isResumed()) {
                        z2 = false;
                    }
                    if (z2 && this.f54453a != null) {
                        j supportFragmentManager = getActivity().getSupportFragmentManager();
                        d dVar = new d();
                        String str2 = this.A;
                        String str3 = this.B;
                        if (!TextUtils.isEmpty(this.y.getText().toString()) || net.one97.paytm.moneytransfer.d.c.g().b()) {
                            str = this.y.getText().toString();
                        } else {
                            str = this.B;
                        }
                        String obj4 = this.z.getText().toString();
                        k.c(obj, CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER);
                        k.c(str2, "ifsc");
                        k.c(str3, "bankName");
                        k.c(str, "accountHolderName");
                        k.c(obj4, "mobileNumber");
                        dVar.f54443a = obj;
                        dVar.f54445c = str3;
                        dVar.f54444b = str2;
                        dVar.f54446d = str;
                        dVar.f54447e = obj4;
                        net.one97.paytm.moneytransfer.d.b bVar = this.f54453a;
                        k.c(bVar, "moneyTransferActivityCallback");
                        dVar.f54448f = bVar;
                        dVar.show(supportFragmentManager, "ConfirmBankAccountBottomSheetFragment");
                    }
                } else {
                    this.t.setError(getString(R.string.money_transfer_enter_valid_mobile));
                }
            }
        } else if (id == R.id.iv_back_button) {
            if (getActivity() != null) {
                com.paytm.utility.b.c((Activity) getActivity());
                if (getActivity().getIntent().getBooleanExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, false)) {
                    getActivity().finish();
                } else {
                    getActivity().getSupportFragmentManager().d();
                }
            }
        } else if (id == R.id.cross_iv) {
            this.u.setText("");
        } else if (id == R.id.scan_iv) {
            try {
                intent = new Intent(getActivity(), Class.forName(net.one97.paytm.moneytransfer.d.d.c().d()));
            } catch (ClassNotFoundException e3) {
                e3.printStackTrace();
                intent = null;
            }
            intent.putExtra(UpiConstants.KEY_IS_SCAN_ONLY, true);
            intent.putExtra("read_text", true);
            startActivityForResult(intent, 2010);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i3 != -1) {
            return;
        }
        if (i2 == 0) {
            if (intent != null) {
                this.A = intent.getStringExtra("intent_extra_ifsc_code");
                this.B = intent.getStringExtra("intent_extra_bank_name");
                this.x.setText(this.A);
                a();
            }
        } else if (i2 == 2010) {
            String stringExtra = intent.getStringExtra(CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER);
            String stringExtra2 = intent.getStringExtra("ifsc_code");
            intent.getBooleanExtra("is_from_scan_text", false);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.u.setText(stringExtra);
            }
            if (!TextUtils.isEmpty(stringExtra2)) {
                this.r.setVisibility(0);
                this.x.setText(stringExtra2);
            }
        } else if (i2 == 80) {
            this.C.b(this.u.getText().toString());
        }
    }

    public final void b(String str) {
        StringBuilder sb = new StringBuilder();
        String trim = this.u.getText().toString().trim();
        int indexOf = trim.indexOf("@");
        if (indexOf != -1) {
            trim = trim.substring(0, indexOf + 1);
        }
        sb.append(trim);
        sb.append(str);
        this.u.setText(sb.toString());
        this.u.setSelection(sb.length());
        this.C.b(this.u.getText().toString());
    }

    private void a(String str, String str2) {
        f.a(getActivity(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, Events.Action.PROCEED_CLICKED, CJRGTMConstants.MONEY_TRANSFER_HOME_SCREEN_NAME, "upi", "new_account_entered");
        Bundle bundle = new Bundle();
        bundle.putBoolean("isVPA", true);
        bundle.putString("vpa", str);
        bundle.putString("username", str2);
        bundle.putInt("source_of_initiation", MoneyTransferV3Activity.c.NEW_ACCOUNT.ordinal());
        m.a(bundle, getActivity().getSupportFragmentManager(), R.id.fragmentContainer);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(net.one97.paytm.moneytransfer.model.c cVar) {
        if (cVar.f54032a == d.SUCCESS) {
            this.u.setAdapter(new net.one97.paytm.moneytransfer.view.a.b(getContext(), (List) cVar.f54033b));
        }
    }

    static /* synthetic */ void g(e eVar) {
        eVar.E = true;
        eVar.r.setVisibility(8);
        eVar.y.setVisibility(8);
        eVar.f54458f.setVisibility(8);
        eVar.j.setVisibility(8);
        eVar.w.setVisibility(0);
    }

    static /* synthetic */ void i(e eVar) {
        eVar.E = false;
        eVar.r.setVisibility(0);
        eVar.y.setVisibility(0);
        eVar.f54458f.setVisibility(0);
        eVar.j.setVisibility(0);
        eVar.w.setVisibility(8);
    }
}
