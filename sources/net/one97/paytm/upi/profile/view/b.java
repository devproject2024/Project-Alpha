package net.one97.paytm.upi.profile.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.q;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.google.android.material.textfield.TextInputLayout;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.ArrayList;
import net.one97.paytm.i.h;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.UpiCheckAndAddVpaModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.k;
import net.one97.paytm.upi.profile.a.a;
import net.one97.paytm.upi.profile.view.e;
import net.one97.paytm.upi.profile.view.p;
import net.one97.paytm.upi.registration.view.UPISettingsActivity;
import net.one97.paytm.upi.registration.view.UpiLandingPageActivity;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.registration.view.h;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.GAConstants;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public class b extends h implements a.b, p.a {

    /* renamed from: a  reason: collision with root package name */
    private TextView f68192a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f68193b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f68194c;

    /* renamed from: d  reason: collision with root package name */
    private FrameLayout f68195d;

    /* renamed from: e  reason: collision with root package name */
    private FrameLayout f68196e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f68197f;

    /* renamed from: g  reason: collision with root package name */
    private RecyclerView f68198g;

    /* renamed from: h  reason: collision with root package name */
    private RecyclerView.LayoutManager f68199h;

    /* renamed from: i  reason: collision with root package name */
    private ProgressBar f68200i;
    private ImageView j;
    private ImageView k;
    private TextView l;
    private TextView m;
    private RelativeLayout n;
    private TextInputLayout o;
    /* access modifiers changed from: private */
    public AppCompatEditText p;
    /* access modifiers changed from: private */
    public p q;
    /* access modifiers changed from: private */
    public a.C1380a r;
    private String s;
    private UpiConstants.PROFILE_STATE t;
    private AccountProviderBody.AccountProvider u;
    private View v;
    private View w;
    private TextWatcher x = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            b.this.o.setError((CharSequence) null);
        }

        public final void afterTextChanged(Editable editable) {
            if (b.this.f68197f.getVisibility() == 0) {
                b.this.q.f68349a = -1;
                b.this.q.notifyDataSetChanged();
            }
        }
    };

    public final /* bridge */ /* synthetic */ void a(Object obj) {
    }

    public static b a(AccountProviderBody.AccountProvider accountProvider, String str, UpiConstants.PROFILE_STATE profile_state) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putSerializable(UpiConstants.EXTRA_SELECTED_BANK, accountProvider);
        bundle.putString("vpa", str);
        bundle.putSerializable(UpiConstants.EXTRA_PROFILE_STATE, profile_state);
        bVar.setArguments(bundle);
        return bVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.u = (AccountProviderBody.AccountProvider) getArguments().getSerializable(UpiConstants.EXTRA_SELECTED_BANK);
            this.s = getArguments().getString("vpa");
            this.t = (UpiConstants.PROFILE_STATE) getArguments().getSerializable(UpiConstants.EXTRA_PROFILE_STATE);
            getActivity();
            net.one97.paytm.upi.profile.b.b a2 = g.a();
            getActivity();
            getActivity();
            this.r = new net.one97.paytm.upi.profile.presenter.a(a2, g.a(net.one97.paytm.upi.h.a.a(g.d(), (a.C1347a) null)), this, this.u, this.s, UpiAppUtils.getMobile(getActivity()), this.t);
        }
        if (bundle != null) {
            this.u = (AccountProviderBody.AccountProvider) bundle.getSerializable(UpiConstants.EXTRA_SELECTED_BANK);
            this.s = bundle.getString("vpa");
            this.t = (UpiConstants.PROFILE_STATE) bundle.getSerializable(UpiConstants.EXTRA_PROFILE_STATE);
            getActivity();
            net.one97.paytm.upi.profile.b.b a3 = g.a();
            getActivity();
            getActivity();
            this.r = new net.one97.paytm.upi.profile.presenter.a(a3, g.a(net.one97.paytm.upi.h.a.a(g.d(), (a.C1347a) null)), this, this.u, this.s, UpiAppUtils.getMobile(getActivity()), this.t);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_bank_vpa_creation, viewGroup, false);
        CJRSendGTMTag.sendOpenScreenWithDeviceInfo(UpiConstants.GTM_SCREEN_VIEW_CREATE_VPA, "wallet", getActivity());
        this.f68192a = (TextView) inflate.findViewById(R.id.tv_bank_name);
        this.f68193b = (TextView) inflate.findViewById(R.id.tv_registration_status);
        this.f68195d = (FrameLayout) inflate.findViewById(R.id.pb_progress);
        this.f68197f = (LinearLayout) inflate.findViewById(R.id.vaSuggestionContainer);
        this.f68198g = (RecyclerView) inflate.findViewById(R.id.suggestion_recycler_view);
        this.j = (ImageView) this.f68195d.findViewById(R.id.iv_bank_icon);
        this.f68200i = (ProgressBar) this.f68195d.findViewById(R.id.progress);
        this.l = (TextView) inflate.findViewById(R.id.tv_proceed);
        this.f68194c = (TextView) inflate.findViewById(R.id.tv_add_bank_later);
        this.o = (TextInputLayout) inflate.findViewById(R.id.edt_enter_vpa_parent);
        this.p = (AppCompatEditText) inflate.findViewById(R.id.edt_enter_vpa);
        this.n = (RelativeLayout) inflate.findViewById(R.id.ll_add_vpa_container);
        this.m = (TextView) inflate.findViewById(R.id.suggestion_message_text);
        this.p.addTextChangedListener(this.x);
        this.f68196e = (FrameLayout) inflate.findViewById(R.id.fragmentContainer);
        this.v = inflate.findViewById(R.id.accountSwitch);
        this.w = inflate.findViewById(R.id.error_layout);
        this.k = (ImageView) inflate.findViewById(R.id.iv_error_icon);
        inflate.findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.b(view);
            }
        });
        this.f68199h = new LinearLayoutManager(getActivity());
        this.f68198g.setLayoutManager(this.f68199h);
        this.f68198g.setNestedScrollingEnabled(false);
        if (Build.VERSION.SDK_INT < 21) {
            Drawable f2 = androidx.core.graphics.drawable.a.f(this.f68200i.getIndeterminateDrawable());
            androidx.core.graphics.drawable.a.a(f2, androidx.core.content.b.c(getContext(), R.color.upi_pin_green));
            this.f68200i.setIndeterminateDrawable(androidx.core.graphics.drawable.a.g(f2));
        } else {
            this.f68200i.getIndeterminateDrawable().setColorFilter(androidx.core.content.b.c(getContext(), R.color.upi_pin_green), PorterDuff.Mode.SRC_IN);
        }
        this.f68194c.setVisibility(8);
        this.l.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue == 0) {
                    b bVar = b.this;
                    try {
                        ((InputMethodManager) bVar.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(bVar.p.getWindowToken(), 0);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    CJRSendGTMTag.sendNewCustomGTMEvents(b.this.getActivity(), CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "create_upi_proceed_clicked", "", "", "", UpiConstants.GTM_SCREEN_VIEW_CREATE_VPA, "wallet");
                    b.this.r.a(b.this.p.getText().toString(), true);
                } else if (intValue == 1) {
                    b.this.r.a();
                } else if (intValue == 3) {
                    b.this.r.b();
                } else if (intValue == 4) {
                    if (com.paytm.utility.a.m(b.this.getContext())) {
                        b.this.r.a();
                    } else {
                        UpiUtils.showNoNetworkErrorDialog(b.this.getActivity());
                    }
                }
                b.this.d(GAConstants.ACTION.RETRY);
                b.this.e();
            }
        });
        this.v.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.a(view);
            }
        });
        if (UpiConstants.PROFILE_STATE.CHECK_VPA.equals(this.t)) {
            f();
        } else if (UpiConstants.PROFILE_STATE.ADD_BANK.equals(this.t)) {
            if (getActivity() instanceof BankVpaCreationActivity) {
                ((Toolbar) ((BankVpaCreationActivity) getActivity()).findViewById(R.id.toolbar)).setVisibility(8);
            }
            if (getActivity() instanceof UpiRegistrationActivity) {
                UpiRegistrationActivity upiRegistrationActivity = (UpiRegistrationActivity) getActivity();
                if (upiRegistrationActivity.f68769a != null) {
                    upiRegistrationActivity.f68769a.setVisibility(8);
                }
            }
        }
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        getActivity().finish();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.r.e();
    }

    public final void a(UpiCheckAndAddVpaModel upiCheckAndAddVpaModel) {
        d();
        this.l.setTag(0);
        this.n.setVisibility(0);
        f();
        c(getString(R.string.upi_create_vpa_new), getString(R.string.upi_tip_create_vpa));
        this.f68197f.setVisibility(0);
        this.o.setError(upiCheckAndAddVpaModel.getRespMessage());
        this.m.setText(getString(R.string.upi_or_choose_from_suggestions));
        this.q = new p(upiCheckAndAddVpaModel.getSuggestedVpas(), this);
        this.f68198g.setAdapter(this.q);
    }

    public final void a(UpiConstants.UpiVpaValidationError upiVpaValidationError) {
        d();
        this.n.setVisibility(0);
        f();
        if (UpiConstants.UpiVpaValidationError.MAX_LENGTH_BREACH.equals(upiVpaValidationError)) {
            this.o.setError(getString(R.string.upi_vpa_length_breach));
        } else if (UpiConstants.UpiVpaValidationError.INVALID_CHARS.equals(upiVpaValidationError)) {
            this.o.setError(getString(R.string.upi_invalid_vpa));
        } else if (UpiConstants.UpiVpaValidationError.EMPTY_VPA.equals(upiVpaValidationError)) {
            this.o.setError(getString(R.string.upi_empty_vpa_error));
        } else if (UpiConstants.UpiVpaValidationError.ALPHANUMERIC_ERROR.equals(upiVpaValidationError)) {
            this.o.setError(getString(R.string.upi_vpa_unavailable));
        }
        this.l.setTag(0);
        this.l.setText(getString(R.string.submit));
        c(getString(R.string.upi_create_vpa_new), getString(R.string.upi_tip_create_vpa));
    }

    public final void a(String str) {
        this.f68197f.setVisibility(8);
        this.n.setVisibility(8);
        c();
        this.j.setImageResource(R.drawable.ic_upi);
        c(getString(R.string.upi_progress_create_vpa_title), String.format(getString(R.string.upi_progress_create_vpa_desc), new Object[]{str}));
    }

    public final void a() {
        d();
        this.r.a();
        CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), GAConstants.CATEGORY.UPI_ONB_V1, "add_va_response_success", "", "", "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
    }

    public final void a(String str, String str2) {
        d();
        this.n.setVisibility(0);
        f();
        CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), GAConstants.CATEGORY.UPI_ONB_V1, "add_va_response_failure", str, "", "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
        if ("100".equals(str)) {
            this.o.setError(getString(R.string.upi_lifetime_max_vpa));
        } else {
            this.o.setError(getString(R.string.upi_some_went_wrong));
        }
        this.l.setText(getString(R.string.retry));
        this.l.setTag(0);
        c(getString(R.string.upi_vpa_save_error), getString(R.string.upi_press_retry_to_create_profile));
        if (!TextUtils.isEmpty(str2) && UpiUtils.isAuthenticationFailure(str2)) {
            k kVar = i.a().k;
            FragmentActivity activity = getActivity();
            new UpiCustomVolleyError();
            UpiLandingPageActivity.class.getName();
            kVar.e(activity);
        }
    }

    public final void a(String str, String str2, String str3) {
        c();
        w.a().a(str3).a(R.drawable.ic_paytm_payments_bank).b(R.drawable.ic_paytm_payments_bank).a(this.j, (e) null);
        c(getString(R.string.upi_progress_confirming_account_bank_new, str, str2), getString(R.string.upi_fetching_account_details));
    }

    public final void a(UserUpiDetails userUpiDetails) {
        this.r.b();
        e(userUpiDetails);
    }

    public final void a(UserUpiDetails userUpiDetails, boolean z) {
        if (getActivity() != null) {
            e(userUpiDetails);
            String str = null;
            int i2 = 0;
            if (getActivity() instanceof UpiRegistrationActivity) {
                str = ((UpiRegistrationActivity) getActivity()).f68772d;
                i2 = ((UpiRegistrationActivity) getActivity()).b();
            }
            ChooseBankAccountActivity.a(getActivity(), userUpiDetails, z, str, i2);
            getActivity().finish();
        }
    }

    private void e(UserUpiDetails userUpiDetails) {
        int i2;
        String str = "";
        String substring = (userUpiDetails == null || userUpiDetails.getAccountProvider() == null || TextUtils.isEmpty(userUpiDetails.getAccountProvider().getIfsc()) || userUpiDetails.getAccountProvider().getIfsc().length() <= 4) ? str : userUpiDetails.getAccountProvider().getIfsc().substring(0, 4);
        if (userUpiDetails == null || userUpiDetails.getBankAccountList() == null) {
            i2 = 0;
        } else {
            i2 = userUpiDetails.getBankAccountList().size();
            if (i2 > 0) {
                str = userUpiDetails.getBankAccountList().get(0).isMpinSet() ? H5AppHandler.CHECK_VALUE : "no";
            }
        }
        Context context = getContext();
        CJRSendGTMTag.sendNewCustomGTMEvents(context, GAConstants.CATEGORY.UPI_ONB_V1, "list_account_response_success", "ifsc_" + substring + ";accounts_" + i2, "mbeba_".concat(str), "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
    }

    public final void b(String str) {
        d();
        CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), GAConstants.CATEGORY.UPI_ONB_V1, "list_account_response_failure", str, "", "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
        this.l.setTag(4);
        this.l.setText(getString(R.string.retry));
        if (TextUtils.isEmpty(str)) {
            str = getString(R.string.upi_unable_to_get_bank_accounts);
        }
        c(getString(R.string.upi_unable_to_get_bank_accounts), getString(R.string.upi_press_retry_to_create_profile));
        if (UpiUtils.AUTHENTICATION_FAILURE_401.equalsIgnoreCase(str) || "410".equalsIgnoreCase(str)) {
            k kVar = i.a().k;
            FragmentActivity activity = getActivity();
            new UpiCustomVolleyError();
            UpiLandingPageActivity.class.getName();
            kVar.e(activity);
            return;
        }
        e(str);
    }

    public final void b(String str, String str2) {
        c();
        c(getString(R.string.upi_progress_confirming_account_bank_new, str, str2), getString(R.string.upi_storing_your_details));
    }

    public final void a(String str, String str2, UserUpiDetails userUpiDetails, String str3) {
        CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), GAConstants.CATEGORY.UPI_ONB_V1, "add_account_response_failure", str, "", "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
        CJRSendGTMTag.sendCustomGTMEvents(getActivity(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, "add_new_clicked", "false", "", "", "");
        CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), GAConstants.CATEGORY.MT_ONB_V1, GAConstants.ACTION.BANK_ACC_LINKED_FAILURE, "", str, "", GAConstants.SCREEN_NAME.UPI_ADD_NEW_BANK, "");
        int i2 = 8;
        if (getActivity() instanceof UpiRegistrationActivity) {
            UpiRegistrationActivity upiRegistrationActivity = (UpiRegistrationActivity) getActivity();
            AccountProviderBody.AccountProvider accountProvider = this.u;
            String str4 = this.s;
            int ordinal = UpiConstants.RegistrationErrorOrigin.ADD_ACCOUNT_TECHNICAL_ERROR.ordinal();
            upiRegistrationActivity.c();
            RelativeLayout relativeLayout = upiRegistrationActivity.f68770b;
            if (!UpiUtils.isPaytmFirstApp()) {
                i2 = 0;
            }
            relativeLayout.setVisibility(i2);
            net.one97.paytm.upi.registration.view.i iVar = (net.one97.paytm.upi.registration.view.i) upiRegistrationActivity.getSupportFragmentManager().c(net.one97.paytm.upi.registration.view.i.class.getSimpleName());
            if (iVar == null) {
                iVar = net.one97.paytm.upi.registration.view.i.a(accountProvider, str4, ordinal);
            }
            UpiUtils.replaceFragmentToActivity(upiRegistrationActivity.getSupportFragmentManager(), iVar, R.id.fl_container);
            return;
        }
        d();
        this.l.setTag(3);
        this.l.setText(getString(R.string.retry));
        String string = TextUtils.isEmpty(str2) ? getString(R.string.upi_press_retry_to_create_profile) : str2;
        if ("96".equals(str)) {
            BankAccountDetails.BankAccount selectedBankAccount = userUpiDetails.getSelectedBankAccount();
            if (selectedBankAccount != null) {
                this.l.setVisibility(8);
                c(getString(R.string.upi_unable_to_add_bank), String.format(getString(R.string.upi_bank_account_already_linked), new Object[]{str3, UpiUtils.maskNumber(selectedBankAccount.getMaskedAccountNumber())}));
            } else {
                c(getString(R.string.upi_unable_to_add_bank), string);
            }
        } else {
            c(getString(R.string.upi_unable_to_add_bank), string);
        }
        e(str);
    }

    public final void b(UserUpiDetails userUpiDetails) {
        if (getActivity() != null) {
            CJRSendGTMTag.sendCustomGTMEvents(getActivity(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, "add_new_clicked", "true", "", "", "");
            f(userUpiDetails);
            if (getActivity() instanceof UpiRegistrationActivity) {
                String str = ((UpiRegistrationActivity) getActivity()).f68772d;
                if (!TextUtils.isEmpty(str)) {
                    if (str.equals(UpiConstants.UPI_ONBOARDING_SELF_DESTROY)) {
                        getActivity().setResult(-1, getActivity().getIntent());
                        getActivity().finish();
                        return;
                    }
                    i.a().m.a((Activity) getActivity(), str);
                }
            }
            String string = getString(R.string.upi_bank_link_success);
            if (getActivity() != null) {
                Toast.makeText(getActivity(), string, 1).show();
            }
            Intent intent = new Intent();
            if (userUpiDetails.getBankAccountList() != null && !userUpiDetails.getBankAccountList().isEmpty()) {
                intent.putExtra(UpiConstants.EXTRA_SELECTED_BANK, userUpiDetails.getSelectedBankAccount());
                intent.putExtra(UpiConstants.EXTRA_BANK_ACCOUNT_LIST, (ArrayList) userUpiDetails.getBankAccountList());
            }
            getActivity().setResult(-1, intent);
            getActivity().finish();
        }
    }

    public final void c(UserUpiDetails userUpiDetails) {
        if (getActivity() != null) {
            f(userUpiDetails);
            if (getActivity() instanceof UpiRegistrationActivity) {
                String str = ((UpiRegistrationActivity) getActivity()).f68772d;
                int b2 = ((UpiRegistrationActivity) getActivity()).b();
                if (TextUtils.isEmpty(str)) {
                    Intent intent = new Intent(getContext(), UPISettingsActivity.class);
                    intent.putExtra("user_upi_details", userUpiDetails);
                    intent.putExtra(UpiConstants.EXTRA_KEY_IS_FROM_ON_BOARDING, true);
                    intent.putExtra(UpiConstants.EXTRA_ON_BOARDING_SOURCE, b2);
                    intent.putExtra(UpiConstants.EXTRA_IS_MPIN_SET, true);
                    startActivity(intent);
                } else if (str.equals(UpiConstants.UPI_ONBOARDING_SELF_DESTROY)) {
                    getActivity().setResult(-1, getActivity().getIntent());
                    getActivity().finish();
                    return;
                } else {
                    i.a().m.a((Activity) getActivity(), str);
                }
            }
            getActivity().finish();
        }
    }

    public final void d(UserUpiDetails userUpiDetails) {
        if (getActivity() != null) {
            f(userUpiDetails);
            if (getActivity() instanceof UpiRegistrationActivity) {
                String str = ((UpiRegistrationActivity) getActivity()).f68772d;
                int b2 = ((UpiRegistrationActivity) getActivity()).b();
                if (TextUtils.isEmpty(str)) {
                    if (userUpiDetails.getBankAccountList() != null) {
                        net.one97.paytm.upi.h hVar = i.a().m;
                        hVar.a("BankVpaCreationFragment", userUpiDetails.getBankAccountList().size() + "_" + userUpiDetails.getSelectedBankIdx());
                    } else {
                        net.one97.paytm.upi.h hVar2 = i.a().m;
                        hVar2.a("BankVpaCreationFragment", "null_" + userUpiDetails.getSelectedBankIdx());
                    }
                    Intent intent = new Intent(getContext(), SetMPINActivity.class);
                    intent.putExtra("user_upi_details", userUpiDetails);
                    intent.putExtra(UpiConstants.EXTRA_KEY_IS_FROM_ON_BOARDING, true);
                    intent.putExtra(UpiConstants.EXTRA_ON_BOARDING_SOURCE, b2);
                    startActivity(intent);
                } else if (str.equals(UpiConstants.UPI_ONBOARDING_SELF_DESTROY)) {
                    getActivity().setResult(-1, getActivity().getIntent());
                    getActivity().finish();
                    return;
                } else {
                    i.a().m.a((Activity) getActivity(), str);
                }
            }
            getActivity().finish();
        }
    }

    private void f(UserUpiDetails userUpiDetails) {
        int i2;
        String str = "";
        String substring = (userUpiDetails == null || userUpiDetails.getAccountProvider() == null || TextUtils.isEmpty(userUpiDetails.getAccountProvider().getIfsc()) || userUpiDetails.getAccountProvider().getIfsc().length() <= 4) ? str : userUpiDetails.getAccountProvider().getIfsc().substring(0, 4);
        if (userUpiDetails == null || userUpiDetails.getBankAccountList() == null) {
            i2 = 0;
        } else {
            i2 = userUpiDetails.getBankAccountList().size();
            if (i2 > 0) {
                str = userUpiDetails.getBankAccountList().get(0).isMpinSet() ? H5AppHandler.CHECK_VALUE : "no";
            }
        }
        Context context = getContext();
        CJRSendGTMTag.sendNewCustomGTMEvents(context, GAConstants.CATEGORY.UPI_ONB_V1, "add_account_response_success", "ifsc_" + substring + ";accounts_" + i2, "mbeba_".concat(str), "", GAConstants.SCREEN_NAME.UPI_ONB_DEVICE_BINDING_PROCESS, "wallet");
        CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), GAConstants.CATEGORY.MT_ONB_V1, GAConstants.ACTION.BANK_ACC_LINKED_SUCCESS, "", "", "", GAConstants.SCREEN_NAME.UPI_ADD_NEW_BANK, "");
    }

    private void c() {
        this.l.setVisibility(8);
        this.f68195d.setVisibility(0);
    }

    private void d() {
        this.l.setVisibility(0);
        this.f68195d.setVisibility(8);
    }

    private void c(String str, String str2) {
        this.f68192a.setText(str);
        this.f68193b.setText(str2);
        this.f68193b.setVisibility(0);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("vpa", this.s);
        bundle.putSerializable(UpiConstants.EXTRA_SELECTED_BANK, this.u);
        bundle.putSerializable(UpiConstants.EXTRA_PROFILE_STATE, this.t);
    }

    public void onDetach() {
        super.onDetach();
        a.C1380a aVar = this.r;
        if (aVar != null) {
            aVar.f();
        }
    }

    public final void a(AccountProviderBody.AccountProvider accountProvider) {
        if (accountProvider != null) {
            e();
            this.u = accountProvider;
            this.r.a(accountProvider);
            this.r.a();
        } else if (getActivity() != null) {
            Toast.makeText(getActivity(), R.string.upi_some_went_wrong, 1).show();
        }
    }

    public final void c(String str) {
        this.p.removeTextChangedListener(this.x);
        this.p.setText(str.substring(0, str.length() - 6));
        this.p.addTextChangedListener(this.x);
        this.o.setError((CharSequence) null);
    }

    public final void b(String str, String str2, String str3) {
        if (isAdded()) {
            d();
            this.l.setTag(1);
            this.l.setText(getString(R.string.retry));
            c(String.format(getString(R.string.upi_no_bank_ac_dynamic_text), new Object[]{str, str2}), "");
            e(str3);
        }
    }

    private void e(String str) {
        if (g()) {
            this.f68193b.setVisibility(8);
            this.v.setVisibility(0);
            this.f68196e.setVisibility(0);
            this.w.setVisibility(0);
            if (!TextUtils.isEmpty(this.u.getBankLogoUrl())) {
                w.a().a(this.u.getBankLogoUrl()).a(R.drawable.ic_paytm_payments_bank).b(R.drawable.ic_paytm_payments_bank).a(this.k, (e) null);
            } else {
                UpiUtils.setBankIcon(this.k, this.u.getIfsc(), getContext());
            }
            ((TextView) this.v.findViewById(R.id.accountChange)).setText(getString(R.string.upi_account_change_bottom_bar_text, com.paytm.utility.a.b(getContext())));
            q a2 = getChildFragmentManager().a();
            e.a aVar = e.f68228a;
            a2.b(R.id.fragmentContainer, e.a.a(this.u), e.class.getName()).b();
            CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), GAConstants.CATEGORY.MT_ONB_V1, GAConstants.ACTION.BANK_ACC_LINKED_FAILURE, "", str, "", GAConstants.SCREEN_NAME.UPI_ADD_NEW_BANK, "");
        }
    }

    /* access modifiers changed from: private */
    public void e() {
        this.w.setVisibility(8);
        this.v.setVisibility(8);
        this.f68196e.setVisibility(8);
    }

    private void f() {
        if (isAdded() && getView() != null) {
            getView().findViewById(R.id.back).setVisibility(8);
            getView().findViewById(R.id.motif).setVisibility(8);
        }
    }

    private boolean g() {
        return getActivity() != null && isAdded() && isResumed();
    }

    /* access modifiers changed from: package-private */
    public final void d(String str) {
        CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), GAConstants.CATEGORY.MT_ONB_V1, GAConstants.ACTION.BANK_ACC_NOT_FOUND_CTA_CLICK, str, "", "", GAConstants.SCREEN_NAME.UPI_NO_BANK_ACC_FOUND, "");
    }

    public final void b() {
        Intent intent = new Intent(getActivity(), UpiRegistrationActivity.class);
        intent.putExtra("redirect", 200);
        startActivityForResult(intent, 200);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        if (isAdded()) {
            d(GAConstants.ACTION.ACCOUNT_SWITCH_LOGIN);
            h.a aVar = net.one97.paytm.upi.registration.view.h.f68882a;
            net.one97.paytm.upi.registration.view.h hVar = new net.one97.paytm.upi.registration.view.h();
            hVar.showNow(getChildFragmentManager(), hVar.getClass().getName());
        }
    }
}
