package net.one97.paytm.moneytransferv4;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.Fade;
import androidx.transition.Transition;
import androidx.transition.u;
import androidx.transition.v;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.contactsSdk.database.ContactColumn;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.common.entity.wallet.CJRBankDetails;
import net.one97.paytm.contacts.entities.beans.ContactDetail;
import net.one97.paytm.contacts.utils.e;
import net.one97.paytm.games.model.pfg.BaseResult;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.utils.f;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.moneytransfer.view.a.g;
import net.one97.paytm.moneytransfer.viewmodel.b;
import net.one97.paytm.moneytransfer.viewmodel.c;
import net.one97.paytm.moneytransferv4.b.a;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.UpiDBTransactionModel;
import net.one97.paytm.upi.q;
import net.one97.paytm.upi.registration.view.UPISettingsActivity;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.registration.view.UpiSelectBankActivity;
import net.one97.paytm.upi.util.AnimationFactory;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.Events;
import net.one97.paytm.upi.util.GAConstants;
import net.one97.paytm.upi.util.PermissionUtil;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.wallet.utility.d;

public class b extends a implements View.OnClickListener, g.a {
    private EditText A;
    private EditText B;
    private String C = "";
    private String D = "";
    /* access modifiers changed from: private */
    public c E;
    private g F;
    private boolean G = false;
    private String H;
    /* access modifiers changed from: private */
    public boolean I;
    private String J;
    private ImageView K;
    private TextView L;
    private AdapterView.OnItemClickListener M = new AdapterView.OnItemClickListener() {
        public final void onItemClick(AdapterView adapterView, View view, int i2, long j) {
            b.this.a(adapterView, view, i2, j);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    TextWatcher f55166a = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            b.this.u.setError((CharSequence) null);
            b.this.s.setError((CharSequence) null);
            b.this.v.setError((CharSequence) null);
            b.this.t.setError((CharSequence) null);
            String charSequence2 = charSequence.toString();
            if (TextUtils.isEmpty(charSequence2)) {
                b.this.q.setVisibility(8);
                b.this.r.setVisibility(0);
            } else {
                b.this.q.setVisibility(0);
                b.this.r.setVisibility(8);
            }
            if (UpiAppUtils.checkIsVpa(charSequence2)) {
                b.g(b.this);
                b.this.E.a(charSequence2.trim());
                return;
            }
            b.i(b.this);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    TextWatcher f55167b = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (charSequence.length() == 0) {
                b.this.m.setTextColor(b.this.getResources().getColor(R.color.color_blue_ifsc));
                boolean unused = b.this.I = false;
                b.this.p.setVisibility(8);
                b.this.m.setText(b.this.getString(R.string.money_transfer_find_ifsc));
                b.this.m.setVisibility(0);
                b.this.t.setError((CharSequence) null);
            } else if (charSequence.length() != 11) {
                boolean unused2 = b.this.I = false;
                b.this.o.setVisibility(8);
                b.this.p.setVisibility(8);
                b.this.m.setTextColor(b.this.getResources().getColor(R.color.color_blue_ifsc));
                b.this.m.setVisibility(8);
                b.this.t.setError((CharSequence) null);
            } else if (!b.this.I) {
                b.this.E.c(b.this.z.getText().toString());
            } else {
                b.this.o.setVisibility(8);
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final int f55168c = 0;

    /* renamed from: e  reason: collision with root package name */
    private final int f55169e = 50;

    /* renamed from: f  reason: collision with root package name */
    private final int f55170f = 1234;

    /* renamed from: g  reason: collision with root package name */
    private final int f55171g = 1223;

    /* renamed from: h  reason: collision with root package name */
    private View f55172h;

    /* renamed from: i  reason: collision with root package name */
    private View f55173i;
    private View j;
    private View k;
    private View l;
    /* access modifiers changed from: private */
    public TextView m;
    private TextView n;
    /* access modifiers changed from: private */
    public TextView o;
    /* access modifiers changed from: private */
    public ImageView p;
    /* access modifiers changed from: private */
    public ImageView q;
    /* access modifiers changed from: private */
    public ImageView r;
    /* access modifiers changed from: private */
    public TextInputLayout s;
    /* access modifiers changed from: private */
    public TextInputLayout t;
    /* access modifiers changed from: private */
    public TextInputLayout u;
    /* access modifiers changed from: private */
    public TextInputLayout v;
    private AutoCompleteTextView w;
    private LottieAnimationView x;
    private RecyclerView y;
    /* access modifiers changed from: private */
    public EditText z;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.J = arguments.getString(ContactColumn.PHONE_NUMBER);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_money_transfer_enter_bankaccount_upi, viewGroup, false);
        this.L = (TextView) inflate.findViewById(R.id.mobilePlaceHolder);
        this.K = (ImageView) inflate.findViewById(R.id.selectContact);
        this.m = (TextView) inflate.findViewById(R.id.txt_p2b_ifsc_code_state);
        this.m.setOnClickListener(this);
        this.x = (LottieAnimationView) inflate.findViewById(R.id.money_transfer_loader);
        this.f55173i = inflate.findViewById(R.id.money_transfer_loader_container);
        this.n = (TextView) inflate.findViewById(R.id.phoneNumberTV);
        this.k = inflate.findViewById(R.id.phoneNumberPrefilledLayout);
        this.l = inflate.findViewById(R.id.rl_mobile_no);
        this.B = (EditText) inflate.findViewById(R.id.mobile_no_et);
        this.v = (TextInputLayout) inflate.findViewById(R.id.mobile_til);
        this.s = (TextInputLayout) inflate.findViewById(R.id.account_til);
        this.w = (AutoCompleteTextView) inflate.findViewById(R.id.account_number_et);
        this.w.addTextChangedListener(this.f55166a);
        this.w.setThreshold(1);
        this.w.setOnItemClickListener(this.M);
        this.z = (EditText) inflate.findViewById(R.id.edit_p2b_ifsc_code);
        this.z.addTextChangedListener(this.f55167b);
        this.A = (EditText) inflate.findViewById(R.id.account_name_et);
        this.u = (TextInputLayout) inflate.findViewById(R.id.account_name_til);
        this.f55172h = inflate.findViewById(R.id.lyt_p2b_ifsc_code);
        this.j = inflate.findViewById(R.id.proceedbutton);
        this.p = (ImageView) inflate.findViewById(R.id.ifsc_verified_image);
        this.o = (TextView) inflate.findViewById(R.id.bank_verified_value);
        this.j.setOnClickListener(this);
        inflate.findViewById(R.id.iv_back_button).setOnClickListener(this);
        this.q = (ImageView) inflate.findViewById(R.id.cross_iv);
        this.q.setOnClickListener(this);
        this.r = (ImageView) inflate.findViewById(R.id.scan_iv);
        this.r.setOnClickListener(this);
        this.t = (TextInputLayout) inflate.findViewById(R.id.float_p2b_ifsc_code);
        this.y = (RecyclerView) inflate.findViewById(R.id.vpaRecyclerView);
        this.y.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
        this.F = new g();
        this.F.a((g.a) this);
        this.y.setAdapter(this.F);
        if (net.one97.paytm.moneytransfer.d.c.g().b()) {
            this.u.setHint(getString(R.string.mt_account_holders_name));
        }
        if (!m.b(getContext())) {
            this.w.setFilters(new InputFilter[]{new net.one97.paytm.moneytransfer.utils.b(), new InputFilter.LengthFilter(50)});
            this.s.setHint(getString(R.string.mt_enter_bank_account));
        } else {
            this.w.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
            this.s.setHint(getString(R.string.univ_money_trnsfr_upi_bank_acc_adhaar));
        }
        this.B.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                b.this.v.setError((CharSequence) null);
            }
        });
        f.a(getContext(), CJRGTMConstants.MT_V4_TO_BANK_AACCOUNT_SCREEN_NAME);
        this.K.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.b(view);
            }
        });
        if (getArguments() != null && getArguments().getBoolean("came_from_self_acc", false)) {
            m.a((EditText) this.w, (Activity) getActivity());
            a(getArguments().getString(CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER), getArguments().getString("ifsc_code"));
        }
        inflate.findViewById(R.id.settingsIcon).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.a(view);
            }
        });
        if (!TextUtils.isEmpty(this.J)) {
            this.k.setVisibility(0);
            this.n.setText(this.J);
        } else {
            this.k.setVisibility(8);
        }
        this.E = (c) am.a((Fragment) this).a(c.class);
        this.E.f54710a.observe(this, new z() {
            public final void onChanged(Object obj) {
                b.this.a((ArrayList) obj);
            }
        });
        this.E.f54711b.observe(this, new z() {
            public final void onChanged(Object obj) {
                b.this.c((net.one97.paytm.moneytransfer.model.c) obj);
            }
        });
        this.E.f54712c.observe(this, new z() {
            public final void onChanged(Object obj) {
                b.this.b((net.one97.paytm.moneytransfer.model.c) obj);
            }
        });
        this.E.a();
        this.E.f54713d.observe(this, new z() {
            public final void onChanged(Object obj) {
                b.this.a((net.one97.paytm.moneytransfer.model.c) obj);
            }
        });
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        new Handler().post(new Runnable(view) {
            private final /* synthetic */ View f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                b.this.c(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(final View view) {
        Fade fade = new Fade(1);
        fade.a((Transition.d) new u() {
            public final void a(Transition transition) {
                super.a(transition);
                view.findViewById(R.id.bottomContainer).setVisibility(0);
            }
        });
        View findViewById = view.findViewById(R.id.fieldsContainer);
        v.a((ViewGroup) view.findViewById(R.id.bankDetailsContainer), (Transition) fade);
        findViewById.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        if (PermissionUtil.checkReadContactsPermission(requireActivity())) {
            a();
        } else {
            requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 1234);
        }
    }

    private void a() {
        try {
            d dVar = d.f72319a;
            Intent a2 = d.a(requireActivity());
            e eVar = e.f50261a;
            a2.putExtra(e.h(), e.C0905e.CONTACT_ONLY_WITH_RESULT.getType());
            startActivityForResult(a2, 1223);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(ArrayList arrayList) {
        this.F.a((List<String>) arrayList);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(net.one97.paytm.moneytransfer.model.c cVar) {
        int i2 = AnonymousClass5.f55179a[cVar.f54032a.ordinal()];
        if (i2 == 1) {
            this.f55173i.setVisibility(0);
            AnimationFactory.startWalletLoader(this.x);
            this.j.setEnabled(false);
            this.j.setVisibility(8);
        } else if (i2 == 2) {
            d();
            b.C0979b bVar = (b.C0979b) cVar.f54033b;
            this.H = bVar.f54690b;
            String str = bVar.f54691c;
            if (TextUtils.isEmpty(this.H)) {
                int i3 = bVar.f54689a;
                if (i3 == 1) {
                    this.s.setError(getString(R.string.upi_unable_to_verify_vpa));
                } else if (i3 == 2) {
                    if (UpiUtils.AUTHENTICATION_FAILURE_401.equalsIgnoreCase(str)) {
                        m.b((Activity) getActivity());
                    } else if ("XH".equalsIgnoreCase(str) || "J02".equalsIgnoreCase(str) || "U17".equalsIgnoreCase(str) || "37".equalsIgnoreCase(str) || "0037".equalsIgnoreCase(str)) {
                        this.s.setError(getString(R.string.upi_address_incorrect));
                    } else if ("INT-1470".equalsIgnoreCase(str)) {
                        this.s.setError(getString(R.string.mt_vpa_verify_no_bank_linked_err));
                    } else if ("1006".equalsIgnoreCase(str)) {
                        Intent intent = new Intent(getActivity(), UpiRegistrationActivity.class);
                        intent.putExtra("redirect", BaseResult.RESP_SYS_EXCEPTION);
                        startActivityForResult(intent, 80);
                    }
                }
            } else if (getActivity() != null) {
                UpiAppUtils.hideKeyboard(getActivity());
                b(this.w.getText().toString(), this.H);
            }
        } else if (i2 == 3) {
            d();
            UpiCustomVolleyError upiCustomVolleyError = cVar.f54034c;
            if (upiCustomVolleyError == null) {
                return;
            }
            if (UpiUtils.AUTHENTICATION_FAILURE_401.equalsIgnoreCase(upiCustomVolleyError.getmErrorCode()) || "410".equalsIgnoreCase(upiCustomVolleyError.getmErrorCode())) {
                m.b((Activity) getActivity());
            } else if (UpiConstants.NETWORK_ERROR_CODE.equals(upiCustomVolleyError.getmErrorCode())) {
                a(upiCustomVolleyError);
            } else {
                com.paytm.utility.b.b((Context) getActivity(), upiCustomVolleyError.getAlertTitle() == null ? "Error" : upiCustomVolleyError.getAlertTitle(), upiCustomVolleyError.getAlertMessage());
            }
        }
    }

    /* renamed from: net.one97.paytm.moneytransferv4.b$5  reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f55179a = new int[net.one97.paytm.moneytransfer.model.d.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                net.one97.paytm.moneytransfer.model.d[] r0 = net.one97.paytm.moneytransfer.model.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f55179a = r0
                int[] r0 = f55179a     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.moneytransfer.model.d r1 = net.one97.paytm.moneytransfer.model.d.LOADING     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f55179a     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.moneytransfer.model.d r1 = net.one97.paytm.moneytransfer.model.d.SUCCESS     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f55179a     // Catch:{ NoSuchFieldError -> 0x002a }
                net.one97.paytm.moneytransfer.model.d r1 = net.one97.paytm.moneytransfer.model.d.ERROR     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransferv4.b.AnonymousClass5.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(net.one97.paytm.moneytransfer.model.c cVar) {
        int i2 = AnonymousClass5.f55179a[cVar.f54032a.ordinal()];
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
                this.C = cJRBankDetails.getResponse().getIfscCode();
                this.D = cJRBankDetails.getResponse().getBankName();
                b();
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
                this.G = true;
                this.w.setText("");
                b(txn_mode, upiDBTransactionModel.getBeneficiary_name());
                return;
            }
            this.w.setText("");
            String beneficiary_name = upiDBTransactionModel.getBeneficiary_name();
            String ifsc = upiDBTransactionModel.getIfsc();
            String bank_name = upiDBTransactionModel.getBank_name();
            f.a(getActivity(), "mt_p2p_new_v1", Events.Action.PROCEED_CLICKED, CJRGTMConstants.MT_V4_TO_BANK_AACCOUNT_SCREEN_NAME, "bank_account", "new_account_entered");
            PaymentManager paymentManager = PaymentManager.f54783a;
            m.a(R.id.container, (Fragment) net.one97.paytm.moneytransferv4.a.a.a.a(PaymentManager.a(txn_mode, beneficiary_name, bank_name, ifsc, (String) null, (String) null, (String) null, 240), (Activity) getActivity()), "BeneficiaryHistoryFragment", getFragmentManager());
        }
    }

    private void b() {
        this.I = true;
        this.o.setText(this.D);
        this.m.setVisibility(8);
        this.t.setErrorEnabled(false);
        this.t.setError((CharSequence) null);
        this.o.setVisibility(0);
        this.p.setVisibility(0);
    }

    private void a(String str) {
        this.I = false;
        this.o.setVisibility(8);
        this.p.setVisibility(8);
        this.m.setVisibility(0);
        this.t.setErrorEnabled(true);
        this.t.setError(str);
        this.m.setText(getString(R.string.money_transfer_verify));
        this.m.setVisibility(0);
    }

    private void d() {
        this.f55173i.setVisibility(8);
        AnimationFactory.stopWalletLoader(this.x);
        this.j.setEnabled(true);
        this.j.setVisibility(0);
    }

    public void onClick(View view) {
        Intent intent;
        String str;
        Intent intent2;
        int id = view.getId();
        boolean z2 = true;
        boolean z3 = false;
        if (id == R.id.txt_p2b_ifsc_code_state) {
            f.a(getContext(), "mt_p2p_new_v1", "find_ifsc_clicked", CJRGTMConstants.MT_V4_TO_BANK_AACCOUNT_SCREEN_NAME, "", "");
            if (!this.m.getText().toString().equalsIgnoreCase("verify")) {
                try {
                    intent2 = new Intent(getActivity(), Class.forName(net.one97.paytm.moneytransfer.d.d.c().e()));
                } catch (ClassNotFoundException e2) {
                    e2.printStackTrace();
                    intent2 = null;
                }
                intent2.putExtra("show_ifsc_new_design", true);
                startActivityForResult(intent2, 0);
            } else if (!this.I) {
                this.E.c(this.z.getText().toString());
            }
        } else if (id == R.id.proceedbutton) {
            net.one97.paytm.moneytransfer.utils.e.a((Fragment) this, "mt_p2p_new_v1", Events.Action.PROCEED_CLICKED, GAConstants.SCREEN_NAME.UPI_TRANSFER_TO_BANK_ACC, "", "", "");
            String obj = this.w.getText().toString();
            String obj2 = this.A.getText().toString();
            String obj3 = this.z.getText().toString();
            if (this.G) {
                if (com.paytm.utility.a.m(getContext())) {
                    if (TextUtils.isEmpty(obj)) {
                        this.s.setError(getString(R.string.upi_empty_vpa_error));
                    } else if (obj.length() > 255) {
                        this.s.setError(getString(R.string.upi_vpa_length_breach));
                    } else if (!obj.matches("[a-zA-Z0-9.-]+@[a-zA-Z0-9.-]+")) {
                        this.s.setError(getString(R.string.upi_invalid_upi));
                    } else {
                        z3 = true;
                    }
                    if (z3) {
                        this.E.b(obj);
                        return;
                    }
                    return;
                }
                m.d((Activity) getActivity());
            } else if (!m.b(obj)) {
                if (m.b(getContext())) {
                    this.s.setError(getString(R.string.bank_account_upi_error_message));
                } else {
                    this.s.setError(getString(R.string.mt_bank_account_error_message));
                }
            } else if (("PYTM0123456".equalsIgnoreCase(this.C) || "PYTM0000001".equalsIgnoreCase(this.C)) && !TextUtils.isEmpty(obj) && obj.trim().length() < 12) {
                this.s.setError(getString(R.string.money_transfer_paytm_ifsc_check));
            } else {
                if (TextUtils.isEmpty(obj3) || !this.I) {
                    if (this.t.getError() != null) {
                        return;
                    }
                    if (obj3.length() == 0) {
                        this.t.setError(getString(R.string.ifsc_error_message));
                        this.t.requestFocus();
                        return;
                    } else if (obj3.length() == 11) {
                        this.C = obj3;
                        this.t.setError((CharSequence) null);
                    } else {
                        this.t.setError(getString(R.string.money_transfer_ifsc_code_error));
                        this.t.requestFocus();
                        return;
                    }
                }
                if (net.one97.paytm.moneytransfer.d.c.g().b() && (TextUtils.isEmpty(obj2) || obj2.trim().length() == 0)) {
                    this.u.setError(getString(R.string.mt_name_error));
                } else if (TextUtils.isEmpty(this.B.getText().toString()) || m.d(this.B.getText().toString())) {
                    this.s.setError((CharSequence) null);
                    if (!TextUtils.isEmpty(this.B.getText().toString()) && m.d(this.B.getText().toString())) {
                        f.a(getContext(), "mt_p2p_new_v1", CJRGTMConstants.MT_V4_MOBILE_ENTERED, CJRGTMConstants.MT_V4_TO_BANK_AACCOUNT_SCREEN_NAME, "", "");
                    }
                    if (getActivity() == null || getView() == null || !isAdded() || !isResumed()) {
                        z2 = false;
                    }
                    if (z2) {
                        net.one97.paytm.moneytransferv4.home.presentation.a.a aVar = new net.one97.paytm.moneytransferv4.home.presentation.a.a();
                        String str2 = this.C;
                        String str3 = this.D;
                        if (!TextUtils.isEmpty(this.A.getText().toString()) || net.one97.paytm.moneytransfer.d.c.g().b()) {
                            str = this.A.getText().toString();
                        } else {
                            str = this.D;
                        }
                        String obj4 = this.B.getText().toString();
                        k.c(obj, CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER);
                        k.c(str2, "ifsc");
                        k.c(str3, "bankName");
                        k.c(str, "accountHolderName");
                        k.c(obj4, "mobileNumber");
                        aVar.f55428a = obj;
                        aVar.f55430c = str3;
                        aVar.f55429b = str2;
                        aVar.f55431d = str;
                        aVar.f55432e = obj4;
                        aVar.show(getChildFragmentManager(), "ConfirmBankAccountBottomSheetFragment");
                    }
                } else {
                    this.v.setError(getString(R.string.money_transfer_enter_valid_mobile));
                }
            }
        } else if (id == R.id.iv_back_button) {
            if (getActivity() != null) {
                com.paytm.utility.b.c((Activity) getActivity());
                requireActivity().onBackPressed();
            }
            f.a(getContext(), "mt_p2p_new_v1", "back_button_clicked", CJRGTMConstants.MT_V4_TO_BANK_AACCOUNT_SCREEN_NAME, "", "");
        } else if (id == R.id.cross_iv) {
            this.w.setText("");
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
                this.C = intent.getStringExtra("intent_extra_ifsc_code");
                this.D = intent.getStringExtra("intent_extra_bank_name");
                this.z.setText(this.C);
                b();
            }
        } else if (i2 == 2010) {
            a(intent.getStringExtra(CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER), intent.getStringExtra("ifsc_code"));
        } else if (i2 == 80) {
            this.E.b(this.w.getText().toString());
        } else if (i2 == 1223) {
            ContactDetail contactDetail = (ContactDetail) intent.getSerializableExtra("contact");
            if (!(contactDetail == null || contactDetail.getPrimaryPhoneNumber() == null)) {
                this.B.setText(contactDetail.getPrimaryPhoneNumber().substring(contactDetail.getPrimaryPhoneNumber().length() - 10));
            }
            if (contactDetail != null && contactDetail.getContactName() != null) {
                this.A.setText(contactDetail.getContactName());
            }
        }
    }

    private void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.w.setText(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.t.setVisibility(0);
            this.z.setText(str2);
        }
    }

    public final void b(String str) {
        StringBuilder sb = new StringBuilder();
        String trim = this.w.getText().toString().trim();
        int indexOf = trim.indexOf("@");
        if (indexOf != -1) {
            trim = trim.substring(0, indexOf + 1);
        }
        sb.append(trim);
        sb.append(str);
        this.w.setText(sb.toString());
        this.w.setSelection(sb.length());
        this.E.b(this.w.getText().toString());
    }

    private void b(String str, String str2) {
        f.a(getActivity(), "mt_p2p_new_v1", Events.Action.PROCEED_CLICKED, CJRGTMConstants.MT_V4_TO_BANK_AACCOUNT_SCREEN_NAME, "upi", "new_account_entered");
        PaymentManager paymentManager = PaymentManager.f54783a;
        m.a(R.id.container, (Fragment) net.one97.paytm.moneytransferv4.a.a.a.a(PaymentManager.a(str, str2), (Activity) getActivity()), "BeneficiaryHistoryFragment", getFragmentManager());
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 == 1234 && PermissionUtil.areAllPermissionsGranted(iArr)) {
            a();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(net.one97.paytm.moneytransfer.model.c cVar) {
        if (cVar.f54032a == net.one97.paytm.moneytransfer.model.d.SUCCESS) {
            this.w.setAdapter(new net.one97.paytm.moneytransfer.view.a.b(getContext(), (List) cVar.f54033b));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        net.one97.paytm.upi.registration.b.a.b bVar = this.E.f54714e;
        k.a((Object) bVar, "registrationRepository");
        if (bVar.e()) {
            net.one97.paytm.upi.registration.b.a.b bVar2 = this.E.f54714e;
            k.a((Object) bVar2, "registrationRepository");
            if (!bVar2.h()) {
                q.a aVar = q.f68356a;
                q.a.a(getActivity());
                return;
            }
            Intent intent = new Intent(getContext(), UPISettingsActivity.class);
            intent.setFlags(67108864);
            startActivityForResult(intent, UpiConstants.REQUEST_CODE_UPI_LANDING_PAGE);
        } else if (UpiUtils.isInActiveProfileExist(getContext())) {
            startActivityForResult(UpiUtils.getUpiLandingPageActivityIntent(getContext()), UpiConstants.REQUEST_CODE_UPI_LANDING_PAGE);
        } else {
            startActivity(new Intent(getContext(), UpiSelectBankActivity.class));
        }
    }

    static /* synthetic */ void g(b bVar) {
        bVar.G = true;
        bVar.t.setVisibility(8);
        bVar.u.setVisibility(8);
        bVar.f55172h.setVisibility(8);
        bVar.l.setVisibility(8);
        bVar.y.setVisibility(0);
        bVar.L.setVisibility(8);
    }

    static /* synthetic */ void i(b bVar) {
        bVar.G = false;
        bVar.t.setVisibility(0);
        bVar.u.setVisibility(0);
        bVar.f55172h.setVisibility(0);
        bVar.l.setVisibility(0);
        bVar.y.setVisibility(8);
        bVar.L.setVisibility(0);
    }
}
